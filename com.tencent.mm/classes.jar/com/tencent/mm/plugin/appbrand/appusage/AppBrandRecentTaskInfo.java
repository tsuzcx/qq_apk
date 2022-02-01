package com.tencent.mm.plugin.appbrand.appusage;

public final class AppBrandRecentTaskInfo
  extends LocalUsageInfo
{
  public final String appName;
  public final String cYF;
  public final int cca;
  public final String fJM;
  public final long fto;
  public final int joY;
  public final String jvt;
  public final boolean jvu;
  public final boolean jvv;
  
  public AppBrandRecentTaskInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2)
  {
    super(paramString2, paramString3, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramBoolean1, paramLong1, paramLong2);
    this.fJM = paramString1;
    this.cYF = paramString2;
    this.appName = paramString4;
    this.jvt = paramString6;
    this.cca = paramInt1;
    this.joY = paramInt2;
    this.jvu = paramBoolean1;
    this.fto = paramLong3;
    this.jvv = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo
 * JD-Core Version:    0.7.0.1
 */