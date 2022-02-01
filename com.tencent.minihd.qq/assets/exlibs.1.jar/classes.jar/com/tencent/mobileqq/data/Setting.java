package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class Setting
  extends Entity
{
  public byte bFaceFlags;
  public byte bHeadType;
  public byte bSourceType;
  public byte bUsrType;
  public long headImgTimestamp = 0L;
  public short systemHeadID = 0;
  @unique
  public String uin;
  public long updateTimestamp;
  public String url;
  
  public Setting clone()
  {
    Setting localSetting = new Setting();
    localSetting.uin = this.uin;
    localSetting.headImgTimestamp = this.headImgTimestamp;
    localSetting.systemHeadID = this.systemHeadID;
    localSetting.bFaceFlags = this.bFaceFlags;
    localSetting.bUsrType = this.bUsrType;
    localSetting.bHeadType = this.bHeadType;
    localSetting.url = this.url;
    localSetting.bSourceType = this.bSourceType;
    localSetting.updateTimestamp = this.updateTimestamp;
    return localSetting;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.Setting
 * JD-Core Version:    0.7.0.1
 */