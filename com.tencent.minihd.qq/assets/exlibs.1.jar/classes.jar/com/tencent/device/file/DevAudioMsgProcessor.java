package com.tencent.device.file;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class DevAudioMsgProcessor
  implements DeviceAVFileMsgObserver.DevMsgProcessor
{
  private static final String a = "DeviceAudioMsg";
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    byte[] arrayOfByte = new byte[3];
    PkgTools.a(paramString1.length(), arrayOfByte, 0, 3, "utf-8");
    paramString2 = (MessageForDevPtt)MessageRecordFactory.b(paramQQAppInterface, paramString2, paramString3, paramInt);
    paramString2.url = paramString1;
    paramString2.fileSize = -3L;
    paramString2.itemType = 2;
    if ((SttManager.a(paramInt)) && (SttManager.a(paramQQAppInterface))) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramString2.sttAbility = paramInt;
      paramString2.longPttVipFlag = 0;
      paramString2.c2cViaOffline = true;
      paramString2.msg = paramString2.getSummary();
      paramString2.issend = 1;
      paramString2.isread = false;
      paramString2.serial();
      paramQQAppInterface.a().a(paramString2, paramQQAppInterface.a());
      return paramString2;
    }
  }
  
  public long a(String paramString, long paramLong)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      paramString = ((DeviceFileHandler)((QQAppInterface)localAppRuntime).a(52)).a(paramString, DeviceMsgHandle.d, null, paramLong);
      if (paramString != null) {
        return paramString.uSessionID;
      }
    }
    return 0L;
  }
  
  public void a(Session paramSession)
  {
    Object localObject = BaseApplicationImpl.a().a();
    MessageForDevPtt localMessageForDevPtt;
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localMessageForDevPtt = (MessageForDevPtt)MessageRecordFactory.a(-4501);
      byte[] arrayOfByte = new byte[3];
      PkgTools.a(paramSession.strFilePathSrc.length(), arrayOfByte, 0, 3, "utf-8");
      localMessageForDevPtt.url = paramSession.strFilePathSrc;
      localMessageForDevPtt.itemType = 2;
      if ((!SttManager.a(0)) || (!SttManager.a((QQAppInterface)localObject))) {
        break label222;
      }
    }
    label222:
    for (int i = 1;; i = 0)
    {
      localMessageForDevPtt.sttAbility = i;
      localMessageForDevPtt.longPttVipFlag = 0;
      localMessageForDevPtt.c2cViaOffline = true;
      localMessageForDevPtt.msgtype = -4501;
      localMessageForDevPtt.istroop = 9501;
      localMessageForDevPtt.issend = 0;
      localMessageForDevPtt.isread = false;
      localMessageForDevPtt.selfuin = ((QQAppInterface)localObject).a();
      localMessageForDevPtt.senderuin = Long.toString(paramSession.msgHeader.uint64_src_uin);
      localMessageForDevPtt.frienduin = Long.toString(paramSession.msgHeader.uint64_src_uin);
      localMessageForDevPtt.time = MessageCache.a();
      localMessageForDevPtt.fileSize = paramSession.uFileSizeSrc;
      localMessageForDevPtt.fileSessionId = paramSession.uSessionID;
      localMessageForDevPtt.msg = localMessageForDevPtt.getSummary();
      localMessageForDevPtt.serial();
      ((QQAppInterface)localObject).a().a(localMessageForDevPtt, ((QQAppInterface)localObject).a());
      return;
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
    MessageForDevPtt localMessageForDevPtt;
    do
    {
      do
      {
        return;
      } while (!(localMessageRecord instanceof MessageForDevPtt));
      localMessageForDevPtt = (MessageForDevPtt)localMessageRecord;
      localMessageForDevPtt.fileSessionId = paramSession.uSessionID;
      localMessageForDevPtt.serial();
      ((QQAppInterface)localObject).a().a(paramString, paramInt, localMessageRecord.uniseq, localMessageForDevPtt.msgData);
    } while (!QLog.isColorLevel());
    QLog.d("DeviceAudioMsg", 2, "updatemsg msg.uniseq:" + localMessageRecord.uniseq + " ===> filesize:" + localMessageForDevPtt.fileSize);
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
    while (!(localMessageRecord instanceof MessageForDevPtt)) {
      return;
    }
    MessageForDevPtt localMessageForDevPtt = (MessageForDevPtt)localMessageRecord;
    localMessageForDevPtt.url = paramSession.strFilePathSrc;
    localMessageForDevPtt.itemType = 2;
    localMessageForDevPtt.issend = 1;
    if (paramBoolean) {
      localMessageForDevPtt.fileSize = paramSession.uFileSizeSrc;
    }
    for (localMessageRecord.extraflag = 32770;; localMessageRecord.extraflag = 32768)
    {
      localMessageForDevPtt.msg = localMessageForDevPtt.getSummary();
      localMessageForDevPtt.serial();
      ((QQAppInterface)localObject).a().a(paramString, paramInt, localMessageRecord.uniseq, localMessageForDevPtt.msgData);
      return;
      localMessageForDevPtt.fileSize = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.file.DevAudioMsgProcessor
 * JD-Core Version:    0.7.0.1
 */