package com.tencent.maas.model;

public class MJTemplateInfo
{
  private String adaptedCategoryID;
  private MJChannelEventConfig channelEventConfig;
  private String displayName;
  private boolean isUnrecommended;
  private long minimumAndroidSDKVersion;
  private long minimumiOSSDKVersion;
  private String templateDescURL;
  private long templateDescVersion;
  private String templateID;
  private String thumbnailURL;
  
  public MJTemplateInfo(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, MJChannelEventConfig paramMJChannelEventConfig, String paramString5, long paramLong1, long paramLong2, long paramLong3)
  {
    this.templateID = paramString1;
    this.thumbnailURL = paramString2;
    this.displayName = paramString3;
    this.adaptedCategoryID = paramString4;
    this.isUnrecommended = paramBoolean;
    this.channelEventConfig = paramMJChannelEventConfig;
    this.templateDescURL = paramString5;
    this.templateDescVersion = paramLong1;
    this.minimumiOSSDKVersion = paramLong2;
    this.minimumAndroidSDKVersion = paramLong3;
  }
  
  public String getAdaptedCategoryID()
  {
    return this.adaptedCategoryID;
  }
  
  public MJChannelEventConfig getChannelEventConfig()
  {
    return this.channelEventConfig;
  }
  
  public String getDisplayName()
  {
    return this.displayName;
  }
  
  public long getMinimumAndroidSDKVersion()
  {
    return this.minimumAndroidSDKVersion;
  }
  
  public long getMinimumiOSSDKVersion()
  {
    return this.minimumiOSSDKVersion;
  }
  
  public String getTemplateDescURL()
  {
    return this.templateDescURL;
  }
  
  public long getTemplateDescVersion()
  {
    return this.templateDescVersion;
  }
  
  public String getTemplateID()
  {
    return this.templateID;
  }
  
  public String getThumbnailURL()
  {
    return this.thumbnailURL;
  }
  
  public boolean isUnrecommended()
  {
    return this.isUnrecommended;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.model.MJTemplateInfo
 * JD-Core Version:    0.7.0.1
 */