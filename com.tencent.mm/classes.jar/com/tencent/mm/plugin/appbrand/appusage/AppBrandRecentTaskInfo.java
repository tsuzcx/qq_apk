package com.tencent.mm.plugin.appbrand.appusage;

public final class AppBrandRecentTaskInfo
  extends LocalUsageInfo
{
  public final String appName;
  public final int bFB;
  public final String bFn;
  public final String dzp;
  public final int fEL;
  public final String fJk;
  public final boolean fJl;
  public final long updateTime;
  
  public AppBrandRecentTaskInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    super(paramString2, paramString3, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramBoolean, paramLong1);
    this.dzp = paramString1;
    this.bFn = paramString2;
    this.appName = paramString4;
    this.fJk = paramString6;
    this.bFB = paramInt1;
    this.fEL = paramInt2;
    this.fJl = paramBoolean;
    this.updateTime = paramLong2;
  }
  
  public final boolean ZH()
  {
    return this.bFB == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo
 * JD-Core Version:    0.7.0.1
 */