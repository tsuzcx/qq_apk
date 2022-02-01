package com.tencent.mm.plugin.appbrand.appusage;

public final class AppBrandRecentTaskInfo
  extends LocalUsageInfo
{
  public final String appName;
  public final long crj;
  public final int cyo;
  public final String dCl;
  public final int eix;
  public final String gLc;
  public final String kVo;
  public final boolean kVp;
  public final boolean kVq;
  public final boolean kVr;
  
  public AppBrandRecentTaskInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, String paramString7, boolean paramBoolean4)
  {
    super(paramString2, paramString3, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramBoolean1, paramLong1, paramLong2, paramBoolean3, paramString7);
    this.gLc = paramString1;
    this.dCl = paramString2;
    this.appName = paramString4;
    this.kVo = paramString6;
    this.cyo = paramInt1;
    this.eix = paramInt2;
    this.kVp = paramBoolean1;
    this.crj = paramLong3;
    this.kVq = paramBoolean2;
    this.kVr = paramBoolean4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo
 * JD-Core Version:    0.7.0.1
 */