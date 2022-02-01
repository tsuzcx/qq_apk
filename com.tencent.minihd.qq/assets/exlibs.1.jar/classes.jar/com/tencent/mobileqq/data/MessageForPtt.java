package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Media;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.qphone.base.util.QLog;
import localpb.richMsg.RichMsg.PttRec;

public class MessageForPtt
  extends ChatMessage
  implements MediaPlayerManager.Media
{
  public static final int PTT_SIZE_ANIM_START = -2;
  public static final int PTT_SIZE_RECV_ERROR = -4;
  public static final int PTT_SIZE_SATUTS_ERROR = -1;
  public static final int PTT_SIZE_UI_SEND = -3;
  public static final int STT_ABLE = 1;
  public static final int STT_DONE = 2;
  public static final int STT_EMPTY = 0;
  public static final int VIPFLAG_NONE = 0;
  public static final int VIPFLAG_SVIP = 2;
  public static final int VIPFLAG_VIP = 1;
  public boolean c2cViaOffline;
  public boolean expandStt = true;
  public long fileSize;
  public long groupFileID;
  public String groupFileKeyStr = null;
  public boolean isReadPtt;
  public int isReport = 0;
  public int itemType;
  public int longPttVipFlag;
  public String md5;
  public long msgRecTime = 0L;
  public long msgTime = 0L;
  public String storageSource;
  public int sttAbility = 0;
  public String sttText;
  public int subVersion = 5;
  public int timeLength;
  public String timeStr;
  public String url;
  public String urlAtServer;
  
  public void doParse()
  {
    boolean bool = true;
    Object localObject = new RichMsg.PttRec();
    int i;
    try
    {
      RichMsg.PttRec localPttRec = (RichMsg.PttRec)((RichMsg.PttRec)localObject).mergeFrom(this.msgData);
      localObject = localPttRec;
      i = 1;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localException2.printStackTrace();
        i = 0;
        continue;
        bool = true;
        continue;
        long l = 0L;
        continue;
        l = 0L;
      }
      if (this.msg != null) {
        break label348;
      }
    }
    if (i != 0)
    {
      this.url = ((RichMsg.PttRec)localObject).localPath.get();
      this.fileSize = ((RichMsg.PttRec)localObject).size.get();
      this.itemType = ((RichMsg.PttRec)localObject).type.get();
      this.isReadPtt = ((RichMsg.PttRec)localObject).isRead.get();
      this.urlAtServer = ((RichMsg.PttRec)localObject).uuid.get();
      this.sttAbility = ((RichMsg.PttRec)localObject).pttFlag.get();
      this.md5 = ((RichMsg.PttRec)localObject).md5.get();
      this.storageSource = ((RichMsg.PttRec)localObject).serverStorageSource.get();
      this.subVersion = ((RichMsg.PttRec)localObject).version.get();
      this.isReport = ((RichMsg.PttRec)localObject).isReport.get();
      this.groupFileID = ((RichMsg.PttRec)localObject).groupFileID.get();
      this.sttText = ((RichMsg.PttRec)localObject).sttText.get();
      this.longPttVipFlag = ((RichMsg.PttRec)localObject).longPttVipFlag.get();
      if (((RichMsg.PttRec)localObject).expandStt.has())
      {
        bool = ((RichMsg.PttRec)localObject).expandStt.get();
        this.expandStt = bool;
        if (((RichMsg.PttRec)localObject).group_file_key.has()) {
          this.groupFileKeyStr = ((RichMsg.PttRec)localObject).group_file_key.get();
        }
        if (!((RichMsg.PttRec)localObject).msgTime.has()) {
          break label307;
        }
        l = ((RichMsg.PttRec)localObject).msgTime.get();
        this.msgTime = l;
        if (!((RichMsg.PttRec)localObject).msgRecTime.has()) {
          break label312;
        }
        l = ((RichMsg.PttRec)localObject).msgRecTime.get();
        this.msgRecTime = l;
      }
    }
    for (;;)
    {
      try
      {
        label307:
        label312:
        if (this.versionCode > 0) {
          this.msg = new String(this.msgData, "UTF-8");
        }
        label348:
        this.subVersion = 0;
        if ((this.msg == null) || (this.msgtype != -1031)) {
          break label730;
        }
        this.msg = ActionMsgUtil.a(this.msg).msg;
        i = 1;
        if ((this.msg != null) && (this.msg.length() > 0) && (this.msg.charAt(0) == '\026'))
        {
          localObject = this.msg.split("\\|");
          if (localObject != null) {
            if (localObject.length > 0)
            {
              this.url = localObject[0].trim();
              if (i != 0) {
                this.urlAtServer = this.url;
              }
              if (localObject.length <= 1) {}
            }
          }
        }
      }
      catch (Exception localException3)
      {
        try
        {
          this.fileSize = Long.valueOf(localObject[1]).longValue();
          if (localObject.length <= 2) {}
        }
        catch (Exception localException3)
        {
          try
          {
            this.itemType = Integer.parseInt(localObject[2]);
            if (localObject.length > 3) {
              if (Integer.valueOf(localObject[3].trim()).intValue() != 0)
              {
                this.isReadPtt = bool;
                if (localObject.length <= 4) {
                  break;
                }
                this.urlAtServer = localObject[4];
                return;
                localException1 = localException1;
                localException1.printStackTrace();
                continue;
                this.url = "";
                if (i == 0) {
                  continue;
                }
                this.urlAtServer = this.url;
                continue;
                localException3 = localException3;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d(getClass().getName(), 2, "java.lang.NumberFormatException: Invalid long: " + localException1[1] + " msg byte " + Utils.a(this.msg));
              }
            }
          }
          catch (Exception localException4)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(getClass().getName(), 2, "java.lang.NumberFormatException: Invalid int: " + localException1[2] + " msg byte " + Utils.a(this.msg));
            continue;
            bool = false;
            continue;
            this.isReadPtt = true;
            continue;
          }
        }
      }
      if (this.msg != null) {
        break;
      }
      this.url = "";
      this.urlAtServer = "";
      return;
      label730:
      i = 0;
    }
  }
  
  public boolean isReady()
  {
    return (this.fileSize > 0L) || (this.fileSize == -3L) || (this.fileSize == -1L);
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
    if (this.versionCode < 3) {
      this.subVersion = 0;
    }
    RichMsg.PttRec localPttRec = new RichMsg.PttRec();
    PBStringField localPBStringField = localPttRec.localPath;
    if (this.url != null)
    {
      str = this.url;
      localPBStringField.set(str);
      localPttRec.size.set(this.fileSize);
      localPttRec.type.set(this.itemType);
      localPttRec.isRead.set(this.isReadPtt);
      localPBStringField = localPttRec.uuid;
      if (this.urlAtServer == null) {
        break label285;
      }
      str = this.urlAtServer;
      label93:
      localPBStringField.set(str);
      localPBStringField = localPttRec.md5;
      if (this.md5 == null) {
        break label291;
      }
      str = this.md5;
      label115:
      localPBStringField.set(str);
      localPBStringField = localPttRec.serverStorageSource;
      if (this.storageSource == null) {
        break label297;
      }
      str = this.storageSource;
      label137:
      localPBStringField.set(str);
      localPttRec.version.set(this.subVersion);
      localPttRec.isReport.set(this.isReport);
      localPttRec.pttFlag.set(this.sttAbility);
      localPttRec.groupFileID.set(this.groupFileID);
      localPBStringField = localPttRec.sttText;
      if (this.sttText == null) {
        break label303;
      }
    }
    label285:
    label291:
    label297:
    label303:
    for (String str = this.sttText;; str = "")
    {
      localPBStringField.set(str);
      localPttRec.longPttVipFlag.set(this.longPttVipFlag);
      localPttRec.expandStt.set(this.expandStt);
      if (this.groupFileKeyStr != null) {
        localPttRec.group_file_key.set(this.groupFileKeyStr);
      }
      localPttRec.msgTime.set(this.msgTime);
      localPttRec.msgRecTime.set(this.msgRecTime);
      try
      {
        this.msgData = localPttRec.toByteArray();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      str = "";
      break;
      str = "";
      break label93;
      str = "";
      break label115;
      str = "";
      break label137;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPtt
 * JD-Core Version:    0.7.0.1
 */