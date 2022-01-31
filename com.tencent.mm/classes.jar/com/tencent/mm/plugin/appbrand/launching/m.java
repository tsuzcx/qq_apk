package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import java.util.List;

class m
  implements i
{
  final String appId;
  final int fJy;
  final String fPq;
  final List<WxaAttributes.WxaVersionModuleInfo> fRu;
  final String fRw;
  final int gJU;
  final int gKx;
  final int gKy;
  private volatile boolean gKz = false;
  
  m(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, String paramString3, List<WxaAttributes.WxaVersionModuleInfo> paramList)
  {
    this.appId = paramString1;
    this.fJy = paramInt1;
    this.fPq = paramString2;
    this.gJU = paramInt2;
    this.gKx = paramInt3;
    this.gKy = paramInt4;
    this.fRw = paramString3;
    this.fRu = paramList;
  }
  
  public void alE() {}
  
  public void alG() {}
  
  public final void onDownloadProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.m
 * JD-Core Version:    0.7.0.1
 */