package com.tencent.mm.plugin.appbrand.appusage;

public final class AppBrandRecentTaskInfo
  extends LocalUsageInfo
{
  public final String appName;
  public final int cmr;
  public final int dPf;
  public final String djX;
  public final long fMf;
  public final String gdn;
  public final String jPm;
  public final boolean jPn;
  public final boolean jPo;
  public final boolean jPp;
  
  public AppBrandRecentTaskInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, String paramString7, boolean paramBoolean4)
  {
    super(paramString2, paramString3, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramBoolean1, paramLong1, paramLong2, paramBoolean3, paramString7);
    this.gdn = paramString1;
    this.djX = paramString2;
    this.appName = paramString4;
    this.jPm = paramString6;
    this.cmr = paramInt1;
    this.dPf = paramInt2;
    this.jPn = paramBoolean1;
    this.fMf = paramLong3;
    this.jPo = paramBoolean2;
    this.jPp = paramBoolean4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo
 * JD-Core Version:    0.7.0.1
 */