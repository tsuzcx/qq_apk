package com.tencent.mm.plugin.appbrand.report;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.protocal.protobuf.asw;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.protocal.protobuf.dan;
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.sdk.platformtools.ab;

public final class b$1
  implements Runnable
{
  public b$1(b paramb, i parami, b.a parama) {}
  
  public final void run()
  {
    Object localObject2 = null;
    AppMethodBeat.i(143516);
    if ((this.gWQ == null) || (this.gWQ.ws() == null))
    {
      ab.w("MicroMsg.AppBrandGameSamplingReportMgr", "hy: runtime is null!");
      if (this.iFi != null) {
        this.iFi.dd(-1, -1);
      }
      AppMethodBeat.o(143516);
      return;
    }
    ab.d("MicroMsg.AppBrandGameSamplingReportMgr", "hy: trigger update");
    this.iFj.iFf = null;
    this.iFj.iFg = null;
    i locali = this.gWQ;
    Object localObject3 = new com.tencent.mm.ai.b.a();
    ((com.tencent.mm.ai.b.a)localObject3).fsX = new asw();
    ((com.tencent.mm.ai.b.a)localObject3).fsY = new asx();
    ((com.tencent.mm.ai.b.a)localObject3).funcId = 2955;
    ((com.tencent.mm.ai.b.a)localObject3).uri = "/cgi-bin/mmgame-bin/getwxagameconfig";
    ((com.tencent.mm.ai.b.a)localObject3).reqCmdId = 0;
    ((com.tencent.mm.ai.b.a)localObject3).respCmdId = 0;
    Object localObject1;
    dao localdao;
    if ((locali.ws().asY() != null) && (locali.ws().asY().ave() != null))
    {
      localObject1 = locali.ws().asY().ave();
      localdao = new dao();
      localdao.xqO = ((WxaPkgWrappingInfo)localObject1).gXf;
      localdao.ygU = ((WxaPkgWrappingInfo)localObject1).gXg;
      localdao.ygN = 0;
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (locali.wY() != null)
      {
        localObject1 = localObject2;
        if (locali.wY().hiX != null)
        {
          localObject1 = locali.wY().hiX;
          localObject2 = new dan();
          ((dan)localObject2).xmQ = ((WxaPkgWrappingInfo)localObject1).gXe;
          ((dan)localObject2).wwX = ((WxaPkgWrappingInfo)localObject1).gXf;
          AppBrandStatObject localAppBrandStatObject = ((o)locali).wS().bDh;
          localObject1 = localObject2;
          if (localAppBrandStatObject != null)
          {
            ((dan)localObject2).Scene = localAppBrandStatObject.scene;
            ((dan)localObject2).xqL = localAppBrandStatObject.cJb;
            ((dan)localObject2).xqM = 0;
            localObject1 = localObject2;
          }
        }
      }
      localObject2 = ((com.tencent.mm.ai.b.a)localObject3).ado();
      localObject3 = (asw)((com.tencent.mm.ai.b)localObject2).fsV.fta;
      ((asw)localObject3).fKw = locali.mAppId;
      ((asw)localObject3).xid = localdao;
      ((asw)localObject3).xic = ((dan)localObject1);
      com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ai.b)localObject2, new b.1.1(this));
      AppMethodBeat.o(143516);
      return;
      localdao = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.b.1
 * JD-Core Version:    0.7.0.1
 */