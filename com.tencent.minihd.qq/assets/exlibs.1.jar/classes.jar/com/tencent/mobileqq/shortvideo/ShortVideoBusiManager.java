package com.tencent.mobileqq.shortvideo;

import android.content.Intent;
import com.tencent.device.file.DevShortVideoOperator;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import java.io.File;

public class ShortVideoBusiManager
{
  public static final int a = 0;
  private static final String a;
  public static final int b = 1;
  
  static
  {
    jdField_a_of_type_JavaLangString = ShortVideoBusiManager.class.getSimpleName();
  }
  
  static BaseShortVideoOprerator a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new AioShortVideoOperator(paramQQAppInterface);
    }
    return new DevShortVideoOperator(paramQQAppInterface);
  }
  
  static InfoBuilder a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new AioShortVideoOperator();
    }
    return new DevShortVideoOperator();
  }
  
  public static ShortVideoDownloadInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  public static ShortVideoReq a(int paramInt1, int paramInt2)
  {
    ShortVideoReq localShortVideoReq = new ShortVideoReq();
    localShortVideoReq.d = paramInt1;
    localShortVideoReq.jdField_e_of_type_Int = paramInt2;
    return localShortVideoReq;
  }
  
  public static ShortVideoUploadInfo a(int paramInt, Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramObject, paramShortVideoReq);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileMsg paramFileMsg, TransferRequest paramTransferRequest)
  {
    if ((paramFileMsg == null) || (paramTransferRequest == null)) {
      Logger.b(jdField_a_of_type_JavaLangString, "updataMessageDataBaseContent", "fileMsg or req is null");
    }
    MessageRecord localMessageRecord;
    MessageForShortVideo localMessageForShortVideo;
    int i;
    int j;
    do
    {
      do
      {
        return;
        if (paramTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
          localMessageRecord = paramTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        }
        while (localMessageRecord == null)
        {
          Logger.b(jdField_a_of_type_JavaLangString, "updataMessageDataBaseContent", "msg null");
          return;
          localMessageRecord = paramQQAppInterface.a().a(paramTransferRequest.b, paramTransferRequest.jdField_a_of_type_Int, paramTransferRequest.jdField_a_of_type_Long);
          Logger.a(jdField_a_of_type_JavaLangString, "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
        }
      } while (!(localMessageRecord instanceof MessageForShortVideo));
      localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
      if (paramFileMsg.jdField_a_of_type_Long != 0L) {
        break;
      }
      i = 0;
      if (localMessageForShortVideo.videoFileProgress < 0) {
        localMessageForShortVideo.videoFileProgress = 0;
      }
      j = localMessageForShortVideo.videoFileProgress;
    } while (((localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 2002)) && (((localMessageForShortVideo.videoFileStatus == paramFileMsg.D) && (i - j < 10)) || (((localMessageForShortVideo.videoFileStatus == 2004) || (localMessageForShortVideo.videoFileStatus == 1004)) && ((paramFileMsg.D == 1002) || (paramFileMsg.D == 2002)))));
    localMessageForShortVideo.videoFileStatus = paramFileMsg.D;
    localMessageForShortVideo.fileType = paramFileMsg.jdField_e_of_type_Int;
    localMessageForShortVideo.videoFileProgress = i;
    if (paramFileMsg.D == 1003)
    {
      localMessageForShortVideo.videoFileSize = ((int)paramFileMsg.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramFileMsg.c;
      localMessageForShortVideo.md5 = paramFileMsg.h;
    }
    for (;;)
    {
      localMessageForShortVideo.serial();
      paramQQAppInterface.a().a(paramTransferRequest.b, paramTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
      if ((paramFileMsg.D == 1003) || (paramFileMsg.D == 2003))
      {
        paramQQAppInterface.a().a(999, true, paramTransferRequest.b);
        Logger.a(jdField_a_of_type_JavaLangString, "updataMessageDataBaseContent", "app.getMsgHandler().notifyUI");
      }
      Logger.a(jdField_a_of_type_JavaLangString, "updataMessageDataBaseContent", "MessageForShortVideo: " + localMessageForShortVideo.toString() + "\n" + localMessageForShortVideo.toLogString());
      return;
      i = (int)(100L * paramFileMsg.jdField_e_of_type_Long / paramFileMsg.jdField_a_of_type_Long);
      break;
      if (paramFileMsg.D == 2003) {
        localMessageForShortVideo.lastModified = new File(paramTransferRequest.g).lastModified();
      }
    }
  }
  
  public static void a(ShortVideoReq paramShortVideoReq, QQAppInterface paramQQAppInterface)
  {
    if (paramShortVideoReq == null)
    {
      Logger.b(jdField_a_of_type_JavaLangString, "launch", "error,req == null");
      return;
    }
    BaseShortVideoOprerator localBaseShortVideoOprerator = a(paramShortVideoReq.jdField_e_of_type_Int, paramQQAppInterface);
    if (localBaseShortVideoOprerator == null)
    {
      Logger.b(jdField_a_of_type_JavaLangString, "launch", "error,busiInterface == null,req.busiType:" + paramShortVideoReq.jdField_e_of_type_Int);
      return;
    }
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localBaseShortVideoOprerator.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = paramShortVideoReq;
    localBaseShortVideoOprerator.f = paramShortVideoReq.jdField_a_of_type_JavaLangString;
    localBaseShortVideoOprerator.g = paramShortVideoReq.b;
    localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack);
    Logger.a(jdField_a_of_type_JavaLangString, "launch", "cmd:" + paramShortVideoReq.d + ",busiType" + paramShortVideoReq.jdField_e_of_type_Int + "uuid:" + paramShortVideoReq.jdField_a_of_type_JavaLangString);
    switch (paramShortVideoReq.d)
    {
    default: 
      return;
    case 0: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo);
      return;
    case 2: 
      localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
      return;
    }
    localBaseShortVideoOprerator.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoBusiManager
 * JD-Core Version:    0.7.0.1
 */