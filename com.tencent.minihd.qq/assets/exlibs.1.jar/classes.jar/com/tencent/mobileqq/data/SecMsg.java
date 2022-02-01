package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import hzf;

public class SecMsg
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new hzf();
  public static final int EMPTY_SEQ = -2;
  public static final long MSG_TYPE_EMPTY = 1L;
  public static final long MSG_TYPE_TXT = 2L;
  public static final int SEND_STATUS_FAILED = 2;
  public static final int SEND_STATUS_SENDING = 1;
  public static final int SEND_STATUS_SUCCESS = 0;
  private static final int SEND_TIMEOUT = 60000;
  public String content;
  public boolean isLocal;
  public boolean isRead;
  public long localSeq;
  public int sendStatus;
  public long senderSuid;
  public long seq = -1L;
  public String ssid;
  public long timestamp;
  public long type;
  
  public SecMsg() {}
  
  private SecMsg(Parcel paramParcel)
  {
    this.seq = paramParcel.readLong();
    this.type = paramParcel.readLong();
    this.ssid = paramParcel.readString();
    this.senderSuid = paramParcel.readLong();
    this.timestamp = paramParcel.readLong();
    this.content = paramParcel.readString();
    this.isLocal = ((Boolean)paramParcel.readValue(null)).booleanValue();
    this.isRead = ((Boolean)paramParcel.readValue(null)).booleanValue();
    this.localSeq = paramParcel.readLong();
    this.sendStatus = paramParcel.readInt();
  }
  
  public static String getTabPrefix()
  {
    return SecMsg.class.getSimpleName() + "_";
  }
  
  public static String getTableName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return getTabPrefix() + paramString;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getSendStatus()
  {
    int i = 1;
    if (this.isLocal)
    {
      if (this.sendStatus == 1)
      {
        if (NetConnInfoCenter.getServerTimeMillis() - this.timestamp > 60000L) {
          i = 2;
        }
        return i;
      }
      return this.sendStatus;
    }
    return 0;
  }
  
  public String getTableName()
  {
    return getTableName(this.ssid);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.seq);
    paramParcel.writeLong(this.type);
    paramParcel.writeString(this.ssid);
    paramParcel.writeLong(this.senderSuid);
    paramParcel.writeLong(this.timestamp);
    paramParcel.writeString(this.content);
    paramParcel.writeValue(Boolean.valueOf(this.isLocal));
    paramParcel.writeValue(Boolean.valueOf(this.isRead));
    paramParcel.writeLong(this.localSeq);
    paramParcel.writeInt(this.sendStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.SecMsg
 * JD-Core Version:    0.7.0.1
 */