package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.protobuf.ast;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class r
  implements n
{
  final String appId;
  final int cxS;
  final int hcr;
  final String hiw;
  final String hkj;
  final int iln;
  final int ilo;
  private final AtomicInteger ilp;
  private volatile boolean ilq;
  final List<WxaAttributes.WxaVersionModuleInfo> moduleList;
  
  r(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, String paramString3, List<WxaAttributes.WxaVersionModuleInfo> paramList)
  {
    AppMethodBeat.i(131836);
    this.ilp = new AtomicInteger(0);
    this.ilq = false;
    this.appId = paramString1;
    this.hcr = paramInt1;
    this.hiw = paramString2;
    this.cxS = paramInt2;
    this.iln = paramInt3;
    this.ilo = paramInt4;
    this.hkj = paramString3;
    this.moduleList = paramList;
    AppMethodBeat.o(131836);
  }
  
  public void aGL() {}
  
  public void aGQ() {}
  
  public void onDownloadProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.r
 * JD-Core Version:    0.7.0.1
 */