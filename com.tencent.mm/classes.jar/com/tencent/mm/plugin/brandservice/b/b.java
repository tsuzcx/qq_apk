package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.protocal.protobuf.dpz;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.b.u;
import d.g.b.w;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/model/BizStrategyManager;", "", "()V", "KEY_BIZ_STRATEGY_FETCH_INTERVAL", "", "KEY_BIZ_STRATEGY_FETCH_LAST_TIME", "TAG", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "requestType", "", "fetchBizStrategy", "", "init", "onEnterBizTimeLineUI", "onUpdateBizStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "preloadForPluginApp", "release", "updateBizStrategyControlInfo", "RequestType", "plugin-brandservice_release"})
public final class b
{
  private static final d.f nuQ;
  public static final b nuR;
  private static int requestType;
  
  static
  {
    AppMethodBeat.i(175458);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(b.class), "mmkv", "getMmkv()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;")) };
    nuR = new b();
    requestType = 10;
    nuQ = d.g.K((d.g.a.a)b.b.nuT);
    AppMethodBeat.o(175458);
  }
  
  private static aw bJa()
  {
    AppMethodBeat.i(175459);
    aw localaw = (aw)nuQ.getValue();
    AppMethodBeat.o(175459);
    return localaw;
  }
  
  public static final void bJb()
  {
    AppMethodBeat.i(175462);
    long l = bJa().getLong("biz_time_line_strategy_last_time", 0L);
    l = Math.abs(System.currentTimeMillis() - l);
    if (l < bJa().getLong("biz_time_line_fetch_interval", 1800000L)) {
      ac.i("MicroMsg.BizStrategyManager", "fetchBizStrategy delta < interval, return");
    }
    while (c.bJd())
    {
      Object localObject = c.nva;
      c.bJh();
      ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).aVd();
      localObject = c.bJf();
      if (localObject == null) {
        break;
      }
      localObject = ((dpz)localObject).FXn;
      if (localObject == null) {
        break;
      }
      ((q)com.tencent.mm.kernel.g.ab(q.class)).Ix((String)localObject);
      AppMethodBeat.o(175462);
      return;
      ac.i("MicroMsg.BizStrategyManager", "alvinluo fetchBizStrategy %d, requestType: %d", new Object[] { Long.valueOf(l), Integer.valueOf(requestType) });
      localObject = new com.tencent.mm.ak.b.a();
      ((com.tencent.mm.ak.b.a)localObject).c((com.tencent.mm.bw.a)new ny());
      ((com.tencent.mm.ak.b.a)localObject).d((com.tencent.mm.bw.a)new nz());
      ((com.tencent.mm.ak.b.a)localObject).Am("/cgi-bin/mmbiz-bin/timeline/bizstrategy");
      ((com.tencent.mm.ak.b.a)localObject).op(1806);
      localObject = ((com.tencent.mm.ak.b.a)localObject).aAz();
      d.g.b.k.g(localObject, "rr");
      com.tencent.mm.bw.a locala = ((com.tencent.mm.ak.b)localObject).aBC();
      if (locala == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyReq");
        AppMethodBeat.o(175462);
        throw ((Throwable)localObject);
      }
      ((ny)locala).ReqType = requestType;
      x.a((com.tencent.mm.ak.b)localObject, (x.a)a.nuS);
    }
    AppMethodBeat.o(175462);
  }
  
  public static final void init()
  {
    AppMethodBeat.i(175460);
    ac.i("MicroMsg.BizStrategyManager", "alvinluo BizStrategyManager init requestType: %d", new Object[] { Integer.valueOf(requestType) });
    c.init();
    AppMethodBeat.o(175460);
  }
  
  public static final void release()
  {
    AppMethodBeat.i(175461);
    c.release();
    AppMethodBeat.o(175461);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements x.a
  {
    public static final a nuS;
    
    static
    {
      AppMethodBeat.i(175455);
      nuS = new a();
      AppMethodBeat.o(175455);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb, n paramn)
    {
      AppMethodBeat.i(175454);
      ac.i("MicroMsg.BizStrategyManager", "doBizStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(175454);
        return 0;
      }
      paramString = b.nuR;
      paramInt1 = b.bJc();
      d.g.b.k.g(paramb, "comReqResp");
      paramString = paramb.aBD();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyResp");
        AppMethodBeat.o(175454);
        throw paramString;
      }
      b.a(paramInt1, (nz)paramString);
      AppMethodBeat.o(175454);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.b
 * JD-Core Version:    0.7.0.1
 */