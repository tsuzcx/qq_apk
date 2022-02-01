package com.tencent.mm.plugin.appbrand.appusage;

public final class AppBrandRecentTaskInfo
  extends LocalUsageInfo
{
  public final String appName;
  public final int cBI;
  public final long coZ;
  public final int cwR;
  public final String fuO;
  public final String jvr;
  public final String nPB;
  public final boolean nPC;
  public final boolean nPD;
  public final boolean nPE;
  
  public AppBrandRecentTaskInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, String paramString7, boolean paramBoolean4)
  {
    super(paramString2, paramString3, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramBoolean1, paramLong1, paramLong2, paramBoolean3, paramString7);
    this.jvr = paramString1;
    this.fuO = paramString2;
    this.appName = paramString4;
    this.nPB = paramString6;
    this.cwR = paramInt1;
    this.cBI = paramInt2;
    this.nPC = paramBoolean1;
    this.coZ = paramLong3;
    this.nPD = paramBoolean2;
    this.nPE = paramBoolean4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo
 * JD-Core Version:    0.7.0.1
 */