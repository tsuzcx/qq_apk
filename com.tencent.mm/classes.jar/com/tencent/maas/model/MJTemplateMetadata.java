package com.tencent.maas.model;

public class MJTemplateMetadata
{
  private String descDownloadURL;
  private long descVersion;
  private long minimumAndroidSDKVersion;
  private long minimumiOSSDKVersion;
  private String templateID;
  
  public MJTemplateMetadata(String paramString1, long paramLong1, String paramString2, long paramLong2, long paramLong3)
  {
    this.templateID = paramString1;
    this.descVersion = paramLong1;
    this.descDownloadURL = paramString2;
    this.minimumiOSSDKVersion = paramLong2;
    this.minimumAndroidSDKVersion = paramLong3;
  }
  
  public String getDescDownloadURL()
  {
    return this.descDownloadURL;
  }
  
  public long getDescVersion()
  {
    return this.descVersion;
  }
  
  public long getMinimumAndroidSDKVersion()
  {
    return this.minimumAndroidSDKVersion;
  }
  
  public long getMinimumiOSSDKVersion()
  {
    return this.minimumiOSSDKVersion;
  }
  
  public String getTemplateID()
  {
    return this.templateID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.model.MJTemplateMetadata
 * JD-Core Version:    0.7.0.1
 */