package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.protocal.protobuf.fbe;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.r;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/model/BizStrategyManager;", "", "()V", "KEY_BIZ_STRATEGY_FETCH_INTERVAL", "", "KEY_BIZ_STRATEGY_FETCH_LAST_TIME", "TAG", "lastTriggerPreDownloadTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "requestType", "", "fetchBizStrategy", "", "init", "onEnterBizTimeLineUI", "onUpdateBizStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "preloadForPluginApp", "release", "updateBizStrategyControlInfo", "RequestType", "plugin-brandservice_release"})
public final class c
{
  private static final kotlin.f lrB;
  private static int requestType;
  private static long svS;
  public static final c svT;
  
  static
  {
    AppMethodBeat.i(175458);
    svT = new c();
    r localr = r.VcW;
    if (r.hvQ()) {}
    for (int i = 16;; i = 0)
    {
      requestType = i | 0xAA;
      lrB = g.ar((kotlin.g.a.a)b.svV);
      AppMethodBeat.o(175458);
      return;
    }
  }
  
  private static MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(175459);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)lrB.getValue();
    AppMethodBeat.o(175459);
    return localMultiProcessMMKV;
  }
  
  public static final void cyV()
  {
    AppMethodBeat.i(175462);
    long l = bcJ().getLong("biz_time_line_strategy_last_time", 0L);
    l = Math.abs(System.currentTimeMillis() - l);
    if (l < bcJ().getLong("biz_time_line_fetch_interval", 1800000L)) {
      Log.i("MicroMsg.BizStrategyManager", "fetchBizStrategy delta < interval, return");
    }
    while (d.cyY())
    {
      Object localObject = d.swc;
      d.czc();
      ((com.tencent.mm.plugin.appbrand.service.f)h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).a(z.qPi);
      localObject = d.cza();
      if (localObject != null)
      {
        localObject = ((fbe)localObject).Uin;
        if (localObject != null) {
          if (System.currentTimeMillis() - svS < 3600000L)
          {
            AppMethodBeat.o(175462);
            return;
            Log.i("MicroMsg.BizStrategyManager", "alvinluo fetchBizStrategy %d, requestType: %d", new Object[] { Long.valueOf(l), Integer.valueOf(requestType) });
            localObject = new d.a();
            ((d.a)localObject).c((com.tencent.mm.cd.a)new py());
            ((d.a)localObject).d((com.tencent.mm.cd.a)new pz());
            ((d.a)localObject).TW("/cgi-bin/mmbiz-bin/timeline/bizstrategy");
            ((d.a)localObject).vD(1806);
            localObject = ((d.a)localObject).bgN();
            p.j(localObject, "rr");
            com.tencent.mm.cd.a locala = ((com.tencent.mm.an.d)localObject).bhX();
            if (locala == null)
            {
              localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyReq");
              AppMethodBeat.o(175462);
              throw ((Throwable)localObject);
            }
            ((py)locala).lpw = requestType;
            aa.a((com.tencent.mm.an.d)localObject, (aa.a)a.svU);
          }
          else
          {
            svS = System.currentTimeMillis();
            ((w)h.ae(w.class)).bu((String)localObject, 0);
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
    d.init();
    AppMethodBeat.o(175460);
  }
  
  public static final void release()
  {
    AppMethodBeat.i(175461);
    d.release();
    AppMethodBeat.o(175461);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements aa.a
  {
    public static final a svU;
    
    static
    {
      AppMethodBeat.i(175455);
      svU = new a();
      AppMethodBeat.o(175455);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(175454);
      Log.i("MicroMsg.BizStrategyManager", "doBizStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = c.svT;
      c.cyW().putLong("biz_time_line_strategy_last_time", System.currentTimeMillis());
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(175454);
        return 0;
      }
      paramString = c.svT;
      paramInt1 = c.cyX();
      p.j(paramd, "comReqResp");
      paramString = paramd.bhY();
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyResp");
        AppMethodBeat.o(175454);
        throw paramString;
      }
      c.a(paramInt1, (pz)paramString);
      AppMethodBeat.o(175454);
      return 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MultiProcessMMKV>
  {
    public static final b svV;
    
    static
    {
      AppMethodBeat.i(175457);
      svV = new b();
      AppMethodBeat.o(175457);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.c
 * JD-Core Version:    0.7.0.1
 */