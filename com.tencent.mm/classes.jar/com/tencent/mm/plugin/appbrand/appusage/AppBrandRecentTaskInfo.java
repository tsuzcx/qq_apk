package com.tencent.mm.plugin.appbrand.appusage;

public final class AppBrandRecentTaskInfo
  extends LocalUsageInfo
{
  public final String appName;
  public final int appServiceType;
  public final long egK;
  public final int eul;
  public final String hzi;
  public final String lYI;
  public final int nOX;
  public final String qPt;
  public final boolean qPu;
  public final boolean qPv;
  
  public AppBrandRecentTaskInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, boolean paramBoolean1, long paramLong3, int paramInt4, boolean paramBoolean2, String paramString7, boolean paramBoolean3)
  {
    super(paramString2, paramString3, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramBoolean1, paramLong1, paramLong2, paramBoolean2, paramString7);
    this.lYI = paramString1;
    this.hzi = paramString2;
    this.appName = paramString4;
    this.qPt = paramString6;
    this.appServiceType = paramInt1;
    this.eul = paramInt2;
    this.qPu = paramBoolean1;
    this.egK = paramLong3;
    this.nOX = paramInt4;
    this.qPv = paramBoolean3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo
 * JD-Core Version:    0.7.0.1
 */