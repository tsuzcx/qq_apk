package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.protocal.protobuf.dvq;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/model/BizStrategyManager;", "", "()V", "KEY_BIZ_STRATEGY_FETCH_INTERVAL", "", "KEY_BIZ_STRATEGY_FETCH_LAST_TIME", "TAG", "lastTriggerPreDownloadTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "requestType", "", "fetchBizStrategy", "", "init", "onEnterBizTimeLineUI", "onUpdateBizStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "preloadForPluginApp", "release", "updateBizStrategyControlInfo", "RequestType", "plugin-brandservice_release"})
public final class b
{
  private static final d.f nOP;
  private static long nWo;
  public static final b nWp;
  private static int requestType;
  
  static
  {
    AppMethodBeat.i(175458);
    nWp = new b();
    requestType = 10;
    nOP = d.g.O((d.g.a.a)b.b.nWr);
    AppMethodBeat.o(175458);
  }
  
  private static ax bNe()
  {
    AppMethodBeat.i(175459);
    ax localax = (ax)nOP.getValue();
    AppMethodBeat.o(175459);
    return localax;
  }
  
  public static final void bNt()
  {
    AppMethodBeat.i(175462);
    long l = bNe().getLong("biz_time_line_strategy_last_time", 0L);
    l = Math.abs(System.currentTimeMillis() - l);
    if (l < bNe().getLong("biz_time_line_fetch_interval", 1800000L)) {
      ad.i("MicroMsg.BizStrategyManager", "fetchBizStrategy delta < interval, return");
    }
    while (c.bNv())
    {
      Object localObject = c.nWy;
      c.bNz();
      ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).aYx();
      localObject = c.bNx();
      if (localObject != null)
      {
        localObject = ((dvq)localObject).HqF;
        if (localObject != null) {
          if (System.currentTimeMillis() - nWo < 3600000L)
          {
            AppMethodBeat.o(175462);
            return;
            ad.i("MicroMsg.BizStrategyManager", "alvinluo fetchBizStrategy %d, requestType: %d", new Object[] { Long.valueOf(l), Integer.valueOf(requestType) });
            localObject = new com.tencent.mm.al.b.a();
            ((com.tencent.mm.al.b.a)localObject).c((com.tencent.mm.bx.a)new pd());
            ((com.tencent.mm.al.b.a)localObject).d((com.tencent.mm.bx.a)new pe());
            ((com.tencent.mm.al.b.a)localObject).Dl("/cgi-bin/mmbiz-bin/timeline/bizstrategy");
            ((com.tencent.mm.al.b.a)localObject).oP(1806);
            localObject = ((com.tencent.mm.al.b.a)localObject).aDC();
            p.g(localObject, "rr");
            com.tencent.mm.bx.a locala = ((com.tencent.mm.al.b)localObject).aEE();
            if (locala == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyReq");
              AppMethodBeat.o(175462);
              throw ((Throwable)localObject);
            }
            ((pd)locala).ReqType = requestType;
            x.a((com.tencent.mm.al.b)localObject, (x.a)a.nWq);
          }
          else
          {
            nWo = System.currentTimeMillis();
            ((r)com.tencent.mm.kernel.g.ab(r.class)).LO((String)localObject);
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
    ad.i("MicroMsg.BizStrategyManager", "alvinluo BizStrategyManager init requestType: %d", new Object[] { Integer.valueOf(requestType) });
    c.init();
    AppMethodBeat.o(175460);
  }
  
  public static final void release()
  {
    AppMethodBeat.i(175461);
    c.release();
    AppMethodBeat.o(175461);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements x.a
  {
    public static final a nWq;
    
    static
    {
      AppMethodBeat.i(175455);
      nWq = new a();
      AppMethodBeat.o(175455);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb, n paramn)
    {
      AppMethodBeat.i(175454);
      ad.i("MicroMsg.BizStrategyManager", "doBizStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(175454);
        return 0;
      }
      paramString = b.nWp;
      paramInt1 = b.bNu();
      p.g(paramb, "comReqResp");
      paramString = paramb.aEF();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyResp");
        AppMethodBeat.o(175454);
        throw paramString;
      }
      b.a(paramInt1, (pe)paramString);
      AppMethodBeat.o(175454);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.b
 * JD-Core Version:    0.7.0.1
 */