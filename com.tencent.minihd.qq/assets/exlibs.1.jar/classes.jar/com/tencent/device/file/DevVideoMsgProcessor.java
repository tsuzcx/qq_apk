package com.tencent.device.file;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Handler;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import czu;
import java.io.File;
import mqq.app.AppRuntime;

public class DevVideoMsgProcessor
  implements DeviceAVFileMsgObserver.DevMsgProcessor
{
  public static final String a = "device_video_path";
  private static final String b = "DeviceShortVideo";
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    if (!Utils.e())
    {
      ToastUtil.a().a(2131367289);
      return;
    }
    Object localObject1 = MessageForDevShortVideo.getLocalPath();
    Object localObject2 = new File((String)localObject1);
    ((File)localObject2).getParentFile().mkdirs();
    localObject2 = Uri.fromFile((File)localObject2);
    PreferenceManager.getDefaultSharedPreferences(paramActivity.getApplicationContext()).edit().putString("device_video_path", (String)localObject1).commit();
    localObject1 = new Intent("android.media.action.VIDEO_CAPTURE");
    ((Intent)localObject1).putExtra("output", (Parcelable)localObject2);
    ((Intent)localObject1).putExtra("android.intent.extra.videoQuality", 1);
    ((Intent)localObject1).putExtra("android.intent.extra.durationLimit", 60);
    ((Intent)localObject1).putExtra("android.intent.extra.sizeLimit", 1073741824);
    FileProvider7Helper.intentCompatForN(paramActivity, (Intent)localObject1);
    paramActivity.startActivityForResult((Intent)localObject1, 83);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    ThreadManager.a().post(new czu(paramString1, paramString2, paramQQAppInterface));
  }
  
  public long a(String paramString, long paramLong)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      paramString = ((DeviceFileHandler)((QQAppInterface)localAppRuntime).a(52)).a(paramString, DeviceMsgHandle.jdField_c_of_type_JavaLangString, null, paramLong);
      if (paramString != null) {
        return paramString.uSessionID;
      }
    }
    return 0L;
  }
  
  public void a(Session paramSession)
  {
    Object localObject = BaseApplicationImpl.a().a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      DevShortVideoOperator localDevShortVideoOperator = new DevShortVideoOperator();
      localDevShortVideoOperator.a = paramSession.strFilePathSrc;
      localDevShortVideoOperator.a();
      MessageForDevShortVideo localMessageForDevShortVideo = (MessageForDevShortVideo)MessageRecordFactory.a(-4503);
      localMessageForDevShortVideo.videoFileName = paramSession.strFilePathSrc;
      localMessageForDevShortVideo.msgtype = -4503;
      localMessageForDevShortVideo.istroop = 9501;
      localMessageForDevShortVideo.issend = 0;
      localMessageForDevShortVideo.isread = false;
      localMessageForDevShortVideo.selfuin = ((QQAppInterface)localObject).a();
      localMessageForDevShortVideo.senderuin = Long.toString(paramSession.msgHeader.uint64_src_uin);
      localMessageForDevShortVideo.frienduin = Long.toString(paramSession.msgHeader.uint64_src_uin);
      localMessageForDevShortVideo.uuid = "";
      localMessageForDevShortVideo.md5 = localDevShortVideoOperator.jdField_c_of_type_JavaLangString;
      localMessageForDevShortVideo.videoFileFormat = 2;
      localMessageForDevShortVideo.videoFileSize = ((int)paramSession.uFileSizeSrc);
      localMessageForDevShortVideo.videoFileTime = ((int)(localDevShortVideoOperator.jdField_b_of_type_Long / 1000L));
      localMessageForDevShortVideo.thumbWidth = localDevShortVideoOperator.jdField_b_of_type_Int;
      localMessageForDevShortVideo.thumbHeight = localDevShortVideoOperator.jdField_c_of_type_Int;
      localMessageForDevShortVideo.videoFileStatus = 2003;
      localMessageForDevShortVideo.videoFileProgress = 0;
      localMessageForDevShortVideo.fileType = 19;
      localMessageForDevShortVideo.thumbMD5 = localDevShortVideoOperator.e;
      localMessageForDevShortVideo.lastModified = 0L;
      localMessageForDevShortVideo.fileSessionId = paramSession.uSessionID;
      localMessageForDevShortVideo.msg = localMessageForDevShortVideo.getSummary();
      localMessageForDevShortVideo.serial();
      ((QQAppInterface)localObject).a().a(localMessageForDevShortVideo, ((QQAppInterface)localObject).a());
      if (QLog.isColorLevel()) {
        QLog.d("DeviceShortVideo", 2, "recievemsg msg.uniseq:" + localMessageForDevShortVideo.uniseq + " ===> filesize:" + localMessageForDevShortVideo.videoFileSize + " fileStatus:" + ShortVideoUtils.b(localMessageForDevShortVideo.videoFileStatus));
      }
      localObject = ShortVideoUtils.a(localMessageForDevShortVideo, "mp4");
      FileUtils.a(paramSession.strFilePathSrc, (String)localObject);
    }
  }
  
  public void a(Session paramSession, String paramString, long paramLong, int paramInt, float paramFloat)
  {
    Object localObject = BaseApplicationImpl.a().a();
    MessageRecord localMessageRecord;
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localMessageRecord = ((QQAppInterface)localObject).a().a(paramString, paramInt, paramLong);
      if (localMessageRecord != null) {
        break label43;
      }
    }
    label43:
    MessageForDevShortVideo localMessageForDevShortVideo;
    do
    {
      do
      {
        return;
      } while (!(localMessageRecord instanceof MessageForDevShortVideo));
      localMessageForDevShortVideo = (MessageForDevShortVideo)localMessageRecord;
      localMessageForDevShortVideo.videoFileSize = ((int)paramSession.uFileSizeSrc);
      localMessageForDevShortVideo.fileSessionId = paramSession.uSessionID;
      localMessageForDevShortVideo.videoFileProgress = ((int)(100.0F * paramFloat));
      localMessageForDevShortVideo.serial();
      ((QQAppInterface)localObject).a().a(paramString, paramInt, localMessageRecord.uniseq, localMessageForDevShortVideo.msgData);
    } while (!QLog.isColorLevel());
    QLog.d("DeviceShortVideo", 2, "updatemsg msg.uniseq:" + localMessageRecord.uniseq + " ===> filesize:" + localMessageForDevShortVideo.videoFileSize);
  }
  
  public void a(Session paramSession, String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = BaseApplicationImpl.a().a();
    MessageRecord localMessageRecord;
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localMessageRecord = ((QQAppInterface)localObject).a().a(paramString, paramInt, paramLong);
      if (localMessageRecord != null) {
        break label43;
      }
    }
    label43:
    while (!(localMessageRecord instanceof MessageForDevShortVideo)) {
      return;
    }
    MessageForDevShortVideo localMessageForDevShortVideo = (MessageForDevShortVideo)localMessageRecord;
    localMessageForDevShortVideo.videoFileSize = ((int)paramSession.uFileSizeSrc);
    localMessageRecord.issend = 1;
    if (paramBoolean) {}
    for (localMessageForDevShortVideo.videoFileStatus = 1003;; localMessageForDevShortVideo.videoFileStatus = 1005)
    {
      localMessageForDevShortVideo.msg = localMessageForDevShortVideo.getSummary();
      localMessageForDevShortVideo.serial();
      ((QQAppInterface)localObject).a().a(paramString, paramInt, localMessageRecord.uniseq, localMessageForDevShortVideo.msgData);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DeviceShortVideo", 2, "updatemsg msg.uniseq:" + localMessageRecord.uniseq + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForDevShortVideo.videoFileStatus));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.file.DevVideoMsgProcessor
 * JD-Core Version:    0.7.0.1
 */