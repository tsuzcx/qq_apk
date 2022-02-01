package com.tencent.mm.plugin.appbrand.appusage;

public final class AppBrandRecentTaskInfo
  extends LocalUsageInfo
{
  public final String appName;
  public final int cmt;
  public final int dQv;
  public final String dkZ;
  public final long fOl;
  public final String gfv;
  public final String jSE;
  public final boolean jSF;
  public final boolean jSG;
  public final boolean jSH;
  
  public AppBrandRecentTaskInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, String paramString7, boolean paramBoolean4)
  {
    super(paramString2, paramString3, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramBoolean1, paramLong1, paramLong2, paramBoolean3, paramString7);
    this.gfv = paramString1;
    this.dkZ = paramString2;
    this.appName = paramString4;
    this.jSE = paramString6;
    this.cmt = paramInt1;
    this.dQv = paramInt2;
    this.jSF = paramBoolean1;
    this.fOl = paramLong3;
    this.jSG = paramBoolean2;
    this.jSH = paramBoolean4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo
 * JD-Core Version:    0.7.0.1
 */