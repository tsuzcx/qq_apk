package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.protocal.protobuf.nr;
import com.tencent.mm.protocal.protobuf.ns;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.f;
import d.g.b.u;
import d.g.b.w;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/model/BizStrategyManager;", "", "()V", "KEY_BIZ_STRATEGY_FETCH_INTERVAL", "", "KEY_BIZ_STRATEGY_FETCH_LAST_TIME", "TAG", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "requestType", "", "fetchBizStrategy", "", "init", "onEnterBizTimeLineUI", "onUpdateBizStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "preloadForPluginApp", "release", "updateBizStrategyControlInfo", "RequestType", "plugin-brandservice_release"})
public final class c
{
  private static final f mSD;
  public static final c mSE;
  private static int requestType;
  
  static
  {
    AppMethodBeat.i(175458);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(c.class), "mmkv", "getMmkv()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;")) };
    mSE = new c();
    requestType = 10;
    mSD = d.g.E((d.g.a.a)c.b.mSG);
    AppMethodBeat.o(175458);
  }
  
  private static ax bCc()
  {
    AppMethodBeat.i(175459);
    ax localax = (ax)mSD.getValue();
    AppMethodBeat.o(175459);
    return localax;
  }
  
  public static final void bCd()
  {
    AppMethodBeat.i(175462);
    long l = bCc().getLong("biz_time_line_strategy_last_time", 0L);
    l = System.currentTimeMillis() - l;
    if (l < bCc().getLong("biz_time_line_fetch_interval", 1800000L)) {
      ad.i("MicroMsg.BizStrategyManager", "fetchBizStrategy delta < interval, return");
    }
    for (;;)
    {
      if (d.bCf())
      {
        localObject = d.mSM;
        d.bCj();
        ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class)).aOn();
      }
      AppMethodBeat.o(175462);
      return;
      ad.i("MicroMsg.BizStrategyManager", "alvinluo fetchBizStrategy %d, requestType: %d", new Object[] { Long.valueOf(l), Integer.valueOf(requestType) });
      Object localObject = new b.a();
      ((b.a)localObject).c((com.tencent.mm.bx.a)new nr());
      ((b.a)localObject).d((com.tencent.mm.bx.a)new ns());
      ((b.a)localObject).wg("/cgi-bin/mmbiz-bin/timeline/bizstrategy");
      ((b.a)localObject).nB(1806);
      localObject = ((b.a)localObject).atI();
      d.g.b.k.g(localObject, "rr");
      com.tencent.mm.bx.a locala = ((b)localObject).auL();
      if (locala == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyReq");
        AppMethodBeat.o(175462);
        throw ((Throwable)localObject);
      }
      ((nr)locala).ReqType = requestType;
      x.a((b)localObject, (x.a)a.mSF);
    }
  }
  
  public static final void init()
  {
    AppMethodBeat.i(175460);
    ad.i("MicroMsg.BizStrategyManager", "alvinluo BizStrategyManager init requestType: %d", new Object[] { Integer.valueOf(requestType) });
    d.init();
    AppMethodBeat.o(175460);
  }
  
  public static final void release()
  {
    AppMethodBeat.i(175461);
    d.release();
    AppMethodBeat.o(175461);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "comReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements x.a
  {
    public static final a mSF;
    
    static
    {
      AppMethodBeat.i(175455);
      mSF = new a();
      AppMethodBeat.o(175455);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
    {
      AppMethodBeat.i(175454);
      ad.i("MicroMsg.BizStrategyManager", "doBizStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(175454);
        return 0;
      }
      paramString = c.mSE;
      paramInt1 = c.bCe();
      d.g.b.k.g(paramb, "comReqResp");
      paramString = paramb.auM();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyResp");
        AppMethodBeat.o(175454);
        throw paramString;
      }
      c.a(paramInt1, (ns)paramString);
      AppMethodBeat.o(175454);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.c
 * JD-Core Version:    0.7.0.1
 */