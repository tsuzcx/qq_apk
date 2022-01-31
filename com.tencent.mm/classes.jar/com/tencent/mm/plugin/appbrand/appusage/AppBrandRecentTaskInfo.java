package com.tencent.mm.plugin.appbrand.appusage;

public final class AppBrandRecentTaskInfo
  extends LocalUsageInfo
{
  public final String appName;
  public final int bCV;
  public final String cmx;
  public final String ese;
  public final int gXd;
  public final String hcc;
  public final boolean hcd;
  public final long updateTime;
  
  public AppBrandRecentTaskInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3)
  {
    super(paramString2, paramString3, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramBoolean, paramLong1, paramLong2);
    this.ese = paramString1;
    this.cmx = paramString2;
    this.appName = paramString4;
    this.hcc = paramString6;
    this.bCV = paramInt1;
    this.gXd = paramInt2;
    this.hcd = paramBoolean;
    this.updateTime = paramLong3;
  }
  
  public final boolean vY()
  {
    return this.bCV == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo
 * JD-Core Version:    0.7.0.1
 */