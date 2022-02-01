package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.utils.MessagePkgUtils;

public class MessageForDeviceFile
  extends ChatMessage
{
  public static final int DATATYPE_FILE_IMAGE = 2;
  public static final int MSG_STATUS_FAILED = 1;
  public static final int MSG_STATUS_RECVING = 3;
  public static final int MSG_STATUS_SENDING = 2;
  public static final int MSG_STATUS_SUCC = 0;
  private static final String TAG = MessageForDeviceFile.class.getSimpleName();
  public long entityID;
  public String filePath;
  public long fileSize;
  public int msgStatus;
  public int nFileMsgType;
  public int nFileStatus;
  public float progress;
  public String srcFileName;
  public String strServiceName;
  public long uSessionID;
  
  protected void doParse()
  {
    try
    {
      MessageForDeviceFile.DeviceFileMsgSerial localDeviceFileMsgSerial = (MessageForDeviceFile.DeviceFileMsgSerial)MessagePkgUtils.a(this.msgData);
      if (localDeviceFileMsgSerial != null)
      {
        this.strServiceName = localDeviceFileMsgSerial.strServiceName;
        this.nFileMsgType = localDeviceFileMsgSerial.nFileMsgType;
        this.filePath = localDeviceFileMsgSerial.filePath;
        this.srcFileName = localDeviceFileMsgSerial.srcFileName;
        this.fileSize = localDeviceFileMsgSerial.fileSize;
        this.nFileStatus = localDeviceFileMsgSerial.nFileStatus;
        this.progress = localDeviceFileMsgSerial.progress;
        this.uSessionID = localDeviceFileMsgSerial.uSessionID;
        this.msgStatus = localDeviceFileMsgSerial.msgStatus;
        this.msg = localDeviceFileMsgSerial.strRecentMsg;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    MessageForDeviceFile.DeviceFileMsgSerial localDeviceFileMsgSerial = new MessageForDeviceFile.DeviceFileMsgSerial(null);
    localDeviceFileMsgSerial.strServiceName = this.strServiceName;
    localDeviceFileMsgSerial.nFileMsgType = this.nFileMsgType;
    localDeviceFileMsgSerial.filePath = this.filePath;
    localDeviceFileMsgSerial.srcFileName = this.srcFileName;
    localDeviceFileMsgSerial.fileSize = this.fileSize;
    localDeviceFileMsgSerial.nFileStatus = this.nFileStatus;
    localDeviceFileMsgSerial.progress = this.progress;
    localDeviceFileMsgSerial.uSessionID = this.uSessionID;
    localDeviceFileMsgSerial.msgStatus = this.msgStatus;
    localDeviceFileMsgSerial.strRecentMsg = this.msg;
    try
    {
      this.msgData = MessagePkgUtils.a(localDeviceFileMsgSerial);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForDeviceFile
 * JD-Core Version:    0.7.0.1
 */