package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.richstatus.RichStatus;

public class ExtensionInfo
  extends Entity
{
  public static final int CHAT_C2C_SHOW_AUDIO_PANEL = 1;
  public static final int CHAT_C2C_SHOW_NONE_PANEL = 0;
  public static final long CHAT_FONT_ID_UNAVAILABLE = 0L;
  public static final int CHAT_INPUT_TYPE_ADUIO = 2;
  public static final int CHAT_INPUT_TYPE_KEYBOARD = 1;
  public static final int CHAT_INPUT_TYPE_NONE = 0;
  public static final long EXTENSION_INFO_EXPIRATION = 86400000L;
  public static final long PENDANT_ID_UNAVAILABLE = 0L;
  public int chatInputType = 0;
  public long colorRingId = 0L;
  public long commingRingId = 0L;
  public String feedContent;
  public boolean feedHasPhoto = false;
  public long feedTime;
  public boolean isAdded2C2C;
  public long pendantId;
  public byte[] richBuffer;
  @notColumn
  public RichStatus richStatus;
  public long richTime;
  public int showC2CPanel = 1;
  public long timestamp = 0L;
  public long uVipFont;
  @unique
  public String uin;
  
  public RichStatus getRichStatus()
  {
    return getRichStatus(false);
  }
  
  public RichStatus getRichStatus(boolean paramBoolean)
  {
    if (this.richStatus == null)
    {
      if ((this.richTime > 0L) && (paramBoolean)) {
        return RichStatus.a();
      }
      if (this.richTime <= 0L) {
        break label60;
      }
      this.richStatus = RichStatus.a(this.richBuffer);
      this.richStatus.a = this.richTime;
    }
    for (;;)
    {
      return this.richStatus;
      label60:
      this.richStatus = new RichStatus(null);
    }
  }
  
  public boolean isPendantExpired()
  {
    return System.currentTimeMillis() - this.timestamp >= 86400000L;
  }
  
  public boolean isPendantValid()
  {
    return this.pendantId != 0L;
  }
  
  public void setRichBuffer(byte[] paramArrayOfByte, long paramLong)
  {
    this.richBuffer = paramArrayOfByte;
    this.richTime = paramLong;
    this.richStatus = null;
    this.isAdded2C2C = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.ExtensionInfo
 * JD-Core Version:    0.7.0.1
 */