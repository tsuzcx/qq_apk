package com.tencent.mm.plugin.appbrand.appusage;

public final class AppBrandRecentTaskInfo
  extends LocalUsageInfo
{
  public final String appName;
  public final int cfd;
  public final String dbj;
  public final String fGf;
  public final long fpL;
  public final int iOP;
  public final String iVd;
  public final boolean iVe;
  public final boolean iVf;
  
  public AppBrandRecentTaskInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2)
  {
    super(paramString2, paramString3, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramBoolean1, paramLong1, paramLong2);
    this.fGf = paramString1;
    this.dbj = paramString2;
    this.appName = paramString4;
    this.iVd = paramString6;
    this.cfd = paramInt1;
    this.iOP = paramInt2;
    this.iVe = paramBoolean1;
    this.fpL = paramLong3;
    this.iVf = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo
 * JD-Core Version:    0.7.0.1
 */