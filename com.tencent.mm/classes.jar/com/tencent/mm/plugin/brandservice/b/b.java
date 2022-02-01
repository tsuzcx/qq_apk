package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.protocal.protobuf.dwn;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/model/BizStrategyManager;", "", "()V", "KEY_BIZ_STRATEGY_FETCH_INTERVAL", "", "KEY_BIZ_STRATEGY_FETCH_LAST_TIME", "TAG", "lastTriggerPreDownloadTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "requestType", "", "fetchBizStrategy", "", "init", "onEnterBizTimeLineUI", "onUpdateBizStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "preloadForPluginApp", "release", "updateBizStrategyControlInfo", "RequestType", "plugin-brandservice_release"})
public final class b
{
  private static final d.f nUv;
  private static long obX;
  public static final b obY;
  private static int requestType;
  
  static
  {
    AppMethodBeat.i(175458);
    obY = new b();
    requestType = 10;
    nUv = d.g.O((d.g.a.a)b.b.oca);
    AppMethodBeat.o(175458);
  }
  
  private static ay bOc()
  {
    AppMethodBeat.i(175459);
    ay localay = (ay)nUv.getValue();
    AppMethodBeat.o(175459);
    return localay;
  }
  
  public static final void bOr()
  {
    AppMethodBeat.i(175462);
    long l = bOc().getLong("biz_time_line_strategy_last_time", 0L);
    l = Math.abs(System.currentTimeMillis() - l);
    if (l < bOc().getLong("biz_time_line_fetch_interval", 1800000L)) {
      ae.i("MicroMsg.BizStrategyManager", "fetchBizStrategy delta < interval, return");
    }
    while (c.bOt())
    {
      Object localObject = c.och;
      c.bOx();
      ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).aYS();
      localObject = c.bOv();
      if (localObject != null)
      {
        localObject = ((dwn)localObject).HKh;
        if (localObject != null) {
          if (System.currentTimeMillis() - obX < 3600000L)
          {
            AppMethodBeat.o(175462);
            return;
            ae.i("MicroMsg.BizStrategyManager", "alvinluo fetchBizStrategy %d, requestType: %d", new Object[] { Long.valueOf(l), Integer.valueOf(requestType) });
            localObject = new com.tencent.mm.ak.b.a();
            ((com.tencent.mm.ak.b.a)localObject).c((com.tencent.mm.bw.a)new pf());
            ((com.tencent.mm.ak.b.a)localObject).d((com.tencent.mm.bw.a)new pg());
            ((com.tencent.mm.ak.b.a)localObject).DN("/cgi-bin/mmbiz-bin/timeline/bizstrategy");
            ((com.tencent.mm.ak.b.a)localObject).oS(1806);
            localObject = ((com.tencent.mm.ak.b.a)localObject).aDS();
            p.g(localObject, "rr");
            com.tencent.mm.bw.a locala = ((com.tencent.mm.ak.b)localObject).aEU();
            if (locala == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyReq");
              AppMethodBeat.o(175462);
              throw ((Throwable)localObject);
            }
            ((pf)locala).ReqType = requestType;
            x.a((com.tencent.mm.ak.b)localObject, (x.a)a.obZ);
          }
          else
          {
            obX = System.currentTimeMillis();
            ((s)com.tencent.mm.kernel.g.ab(s.class)).Mr((String)localObject);
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
    ae.i("MicroMsg.BizStrategyManager", "alvinluo BizStrategyManager init requestType: %d", new Object[] { Integer.valueOf(requestType) });
    c.init();
    AppMethodBeat.o(175460);
  }
  
  public static final void release()
  {
    AppMethodBeat.i(175461);
    c.release();
    AppMethodBeat.o(175461);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements x.a
  {
    public static final a obZ;
    
    static
    {
      AppMethodBeat.i(175455);
      obZ = new a();
      AppMethodBeat.o(175455);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb, n paramn)
    {
      AppMethodBeat.i(175454);
      ae.i("MicroMsg.BizStrategyManager", "doBizStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(175454);
        return 0;
      }
      paramString = b.obY;
      paramInt1 = b.bOs();
      p.g(paramb, "comReqResp");
      paramString = paramb.aEV();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyResp");
        AppMethodBeat.o(175454);
        throw paramString;
      }
      b.a(paramInt1, (pg)paramString);
      AppMethodBeat.o(175454);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.b
 * JD-Core Version:    0.7.0.1
 */