package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.protocal.protobuf.eqs;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.protocal.protobuf.qd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/model/BizStrategyManager;", "", "()V", "KEY_BIZ_STRATEGY_FETCH_INTERVAL", "", "KEY_BIZ_STRATEGY_FETCH_LAST_TIME", "TAG", "lastTriggerPreDownloadTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "requestType", "", "fetchBizStrategy", "", "init", "onEnterBizTimeLineUI", "onUpdateBizStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "preloadForPluginApp", "release", "updateBizStrategyControlInfo", "RequestType", "plugin-brandservice_release"})
public final class b
{
  private static final kotlin.f iBW;
  private static long pmU;
  public static final b pmV;
  private static int requestType;
  
  static
  {
    AppMethodBeat.i(175458);
    pmV = new b();
    r localr = r.NPl;
    if (r.gzN()) {}
    for (int i = 16;; i = 0)
    {
      requestType = i | 0x2A;
      iBW = kotlin.g.ah((kotlin.g.a.a)b.b.pmX);
      AppMethodBeat.o(175458);
      return;
    }
  }
  
  private static MultiProcessMMKV aTI()
  {
    AppMethodBeat.i(175459);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)iBW.getValue();
    AppMethodBeat.o(175459);
    return localMultiProcessMMKV;
  }
  
  public static final void clr()
  {
    AppMethodBeat.i(175462);
    long l = aTI().getLong("biz_time_line_strategy_last_time", 0L);
    l = Math.abs(System.currentTimeMillis() - l);
    if (l < aTI().getLong("biz_time_line_fetch_interval", 1800000L)) {
      Log.i("MicroMsg.BizStrategyManager", "fetchBizStrategy delta < interval, return");
    }
    while (c.clu())
    {
      Object localObject = c.pne;
      c.cly();
      ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.f.class)).a(z.nMQ);
      localObject = c.clw();
      if (localObject != null)
      {
        localObject = ((eqs)localObject).MVS;
        if (localObject != null) {
          if (System.currentTimeMillis() - pmU < 3600000L)
          {
            AppMethodBeat.o(175462);
            return;
            Log.i("MicroMsg.BizStrategyManager", "alvinluo fetchBizStrategy %d, requestType: %d", new Object[] { Long.valueOf(l), Integer.valueOf(requestType) });
            localObject = new d.a();
            ((d.a)localObject).c((com.tencent.mm.bw.a)new qc());
            ((d.a)localObject).d((com.tencent.mm.bw.a)new qd());
            ((d.a)localObject).MB("/cgi-bin/mmbiz-bin/timeline/bizstrategy");
            ((d.a)localObject).sG(1806);
            localObject = ((d.a)localObject).aXF();
            p.g(localObject, "rr");
            com.tencent.mm.bw.a locala = ((d)localObject).aYJ();
            if (locala == null)
            {
              localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyReq");
              AppMethodBeat.o(175462);
              throw ((Throwable)localObject);
            }
            ((qc)locala).ReqType = requestType;
            aa.a((d)localObject, (aa.a)a.pmW);
          }
          else
          {
            pmU = System.currentTimeMillis();
            ((w)com.tencent.mm.kernel.g.af(w.class)).bb((String)localObject, 0);
            AppMethodBeat.o(175462);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(175462);
  }
  
  public static final void init()
  {
    AppMethodBeat.i(175460);
    Log.i("MicroMsg.BizStrategyManager", "alvinluo BizStrategyManager init requestType: %d", new Object[] { Integer.valueOf(requestType) });
    c.init();
    AppMethodBeat.o(175460);
  }
  
  public static final void release()
  {
    AppMethodBeat.i(175461);
    c.release();
    AppMethodBeat.o(175461);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements aa.a
  {
    public static final a pmW;
    
    static
    {
      AppMethodBeat.i(175455);
      pmW = new a();
      AppMethodBeat.o(175455);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
    {
      AppMethodBeat.i(175454);
      Log.i("MicroMsg.BizStrategyManager", "doBizStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = b.pmV;
      b.cls().putLong("biz_time_line_strategy_last_time", System.currentTimeMillis());
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(175454);
        return 0;
      }
      paramString = b.pmV;
      paramInt1 = b.clt();
      p.g(paramd, "comReqResp");
      paramString = paramd.aYK();
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyResp");
        AppMethodBeat.o(175454);
        throw paramString;
      }
      b.a(paramInt1, (qd)paramString);
      AppMethodBeat.o(175454);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.b
 * JD-Core Version:    0.7.0.1
 */