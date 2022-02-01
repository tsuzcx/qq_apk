package com.tencent.mobileqq.data;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForDeviceSingleStruct
  extends ChatMessage
{
  public static final int DATATYPE_SINGLESTRUCT_PIC = 1;
  public static final int DATATYPE_SINGLESTRUCT_VIDEO = 2;
  private static final String TAG = MessageForDeviceSingleStruct.class.getSimpleName();
  public byte[] coverKey = null;
  public long entityID;
  public byte[] mediaKey = null;
  public long nAppearTime = MessageCache.a();
  public long nCoverSessionID = 0L;
  public int nDataType = 1;
  public long nMediaFileSize = 0L;
  public int nMediaFileStatus = 1;
  public float nMediaProgress = 0.0F;
  public long nMediaSessionID = 0L;
  public String strCoverMD5 = "";
  public String strCoverPath = "";
  public String strDigest = "";
  public String strGuideWords = "";
  public String strMediaFileName = "";
  public String strMediaPath = "";
  public String strTitle = "";
  
  protected void doParse()
  {
    try
    {
      MessageForDeviceSingleStruct.SingleStructMsgSerial localSingleStructMsgSerial = (MessageForDeviceSingleStruct.SingleStructMsgSerial)MessagePkgUtils.a(this.msgData);
      if (localSingleStructMsgSerial != null)
      {
        this.nDataType = localSingleStructMsgSerial.nDataType;
        this.strTitle = localSingleStructMsgSerial.strTitle;
        this.nAppearTime = localSingleStructMsgSerial.nAppearTime;
        this.strDigest = localSingleStructMsgSerial.strDigest;
        this.strGuideWords = localSingleStructMsgSerial.strGuideWords;
        this.nCoverSessionID = localSingleStructMsgSerial.nCoverSessionID;
        this.coverKey = localSingleStructMsgSerial.coverKey;
        this.strCoverPath = localSingleStructMsgSerial.strCoverPath;
        this.nMediaSessionID = localSingleStructMsgSerial.nMediaSessionID;
        this.mediaKey = localSingleStructMsgSerial.mediaKey;
        this.strMediaPath = localSingleStructMsgSerial.strMediaPath;
        this.nMediaFileStatus = localSingleStructMsgSerial.nMediaFileStatus;
        this.nMediaProgress = localSingleStructMsgSerial.nMediaProgress;
        this.strMediaFileName = localSingleStructMsgSerial.strMediaFileName;
        this.nMediaFileSize = localSingleStructMsgSerial.nMediaFileSize;
        this.strCoverMD5 = localSingleStructMsgSerial.strCoverMD5;
        this.msg = localSingleStructMsgSerial.strRecentMsg;
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
  
  public boolean parseFromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.time = paramString.optLong("msg_time", MessageCache.a());
      this.strTitle = paramString.optString("title", "点击查看");
      String str = paramString.optString("data_type", "");
      this.nDataType = 1;
      if (str.compareToIgnoreCase("PICTURE") == 0) {
        this.nDataType = 1;
      }
      for (;;)
      {
        this.nAppearTime = paramString.optLong("appear_time", MessageCache.a());
        this.strDigest = paramString.optString("digest", "");
        this.strGuideWords = paramString.optString("guidewords", "");
        str = paramString.optString("cover_key", "");
        if (!TextUtils.isEmpty(str)) {
          this.coverKey = Base64.decode(str, 2);
        }
        paramString = paramString.optString("media_key", "");
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        this.mediaKey = Base64.decode(paramString, 2);
        return true;
        if (str.compareToIgnoreCase("VIDEO") == 0) {
          this.nDataType = 2;
        }
      }
      return true;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getString from json JSONException error:" + paramString.getMessage());
      }
      return false;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getString from json Exception error:" + paramString.getMessage());
        }
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
    MessageForDeviceSingleStruct.SingleStructMsgSerial localSingleStructMsgSerial = new MessageForDeviceSingleStruct.SingleStructMsgSerial(null);
    localSingleStructMsgSerial.nDataType = this.nDataType;
    localSingleStructMsgSerial.strTitle = this.strTitle;
    localSingleStructMsgSerial.nAppearTime = this.nAppearTime;
    localSingleStructMsgSerial.strDigest = this.strDigest;
    localSingleStructMsgSerial.strGuideWords = this.strGuideWords;
    localSingleStructMsgSerial.nCoverSessionID = this.nCoverSessionID;
    localSingleStructMsgSerial.coverKey = this.coverKey;
    localSingleStructMsgSerial.strCoverPath = this.strCoverPath;
    localSingleStructMsgSerial.nMediaSessionID = this.nMediaSessionID;
    localSingleStructMsgSerial.mediaKey = this.mediaKey;
    localSingleStructMsgSerial.strMediaPath = this.strMediaPath;
    localSingleStructMsgSerial.nMediaFileStatus = this.nMediaFileStatus;
    localSingleStructMsgSerial.nMediaProgress = this.nMediaProgress;
    localSingleStructMsgSerial.strMediaFileName = this.strMediaFileName;
    localSingleStructMsgSerial.nMediaFileSize = this.nMediaFileSize;
    localSingleStructMsgSerial.strCoverMD5 = this.strCoverMD5;
    localSingleStructMsgSerial.strRecentMsg = this.msg;
    try
    {
      this.msgData = MessagePkgUtils.a(localSingleStructMsgSerial);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForDeviceSingleStruct
 * JD-Core Version:    0.7.0.1
 */