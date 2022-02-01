package com.tencent.mm.plugin.brandservice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.p.a;
import com.tencent.mm.model.p.e;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.appbrand.service.y;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.enk;
import com.tencent.mm.protocal.protobuf.fxl;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.ri;
import com.tencent.mm.protocal.protobuf.rj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.r;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/model/BizStrategyManager;", "", "()V", "KEY_BIZ_STRATEGY_FETCH_INTERVAL", "", "KEY_BIZ_STRATEGY_FETCH_LAST_TIME", "TAG", "lastTriggerPreDownloadTime", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "requestType", "", "fetchBizStrategy", "", "init", "onEnterBizTimeLineUI", "onUpdateBizStrategy", "resp", "Lcom/tencent/mm/protocal/protobuf/BizStrategyResp;", "preloadForPluginApp", "release", "updateBizStrategyControlInfo", "RequestType", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final j exj;
  private static int requestType;
  public static final c vBF;
  private static long vBG;
  
  static
  {
    AppMethodBeat.i(175458);
    vBF = new c();
    r localr = r.acDM;
    if (r.iXp()) {}
    for (int i = 16;; i = 0)
    {
      requestType = i | 0xAA;
      exj = k.cm((kotlin.g.a.a)c.a.vBH);
      AppMethodBeat.o(175458);
      return;
    }
  }
  
  private static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(175459);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(175459);
    return localMultiProcessMMKV;
  }
  
  private static final int b(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(303489);
    Log.i("MicroMsg.BizStrategyManager", "doBizStrategy callback %d/%d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    atj().putLong("biz_time_line_strategy_last_time", System.currentTimeMillis());
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(303489);
      return 0;
    }
    paramInt1 = requestType;
    paramString = c.c.b(paramc.otC);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyResp");
      AppMethodBeat.o(303489);
      throw paramString;
    }
    paramString = (rj)paramString;
    if (paramString != null)
    {
      paramc = paramString.YWk;
      if (paramc != null)
      {
        Log.i("MicroMsg.BizStrategyManager", "alvinluo updateBizStrategyControlInfo RefreshInterval = %d", new Object[] { Integer.valueOf(paramc.YWg) });
        if (paramc.YWg > 0) {
          atj().putLong("biz_time_line_fetch_interval", paramc.YWg);
        }
      }
      if ((paramInt1 & 0x2) != 0)
      {
        paramc = com.tencent.mm.pluginsdk.c.XNm;
        com.tencent.mm.pluginsdk.c.b(paramString);
      }
      if ((paramInt1 & 0x8) != 0) {
        d.a(paramString);
      }
      if ((paramInt1 & 0x10) != 0)
      {
        paramc = r.acDM;
        paramc = paramString.YWn;
        if (paramc != null)
        {
          r.acDP = paramc.YGr;
          r.Yjq = paramc.YGs;
          r.iXz();
          Log.i("MicroMsg.BizCardLogic", "handleExtInfo extInfo " + r.acDP + ' ' + r.Yjq);
        }
      }
      if ((paramInt1 & 0x20) != 0)
      {
        paramc = com.tencent.mm.model.p.ojc;
        paramc = paramString.YWo;
        if (paramc != null)
        {
          Log.i("Micromsg.BizTLRecFeedsDataUtil", s.X("updateSvrSwitch = ", Integer.valueOf(paramc.abrV)));
          if (paramc.abrV != p.e.ojq.value) {
            break label382;
          }
          p.a.atj().encode("BizTLRecommendFeedsSvrOpen", false);
          p.a.atj().encode("BizTLRecommendFeedsRefreshFreq", paramc.abrW);
        }
      }
      if ((paramInt1 & 0x80) != 0)
      {
        paramc = com.tencent.mm.pluginsdk.model.c.XPt;
        paramString = paramString.YWq;
        if (paramString != null) {
          break label409;
        }
      }
    }
    label409:
    for (paramInt1 = 0;; paramInt1 = paramString.YSL)
    {
      com.tencent.mm.pluginsdk.model.c.atj().encode("SvrOpenFlag", paramInt1);
      Log.d("MicroMsg.BizFinderLiveLogic", s.X("svrOpenFlag = ", Integer.valueOf(paramInt1)));
      AppMethodBeat.o(303489);
      return 0;
      label382:
      if (paramc.abrV != p.e.ojr.value) {
        break;
      }
      p.a.atj().encode("BizTLRecommendFeedsSvrOpen", true);
      break;
    }
  }
  
  public static final void dbS()
  {
    AppMethodBeat.i(175462);
    long l = atj().getLong("biz_time_line_strategy_last_time", 0L);
    l = Math.abs(System.currentTimeMillis() - l);
    if (l < atj().getLong("biz_time_line_fetch_interval", 1800000L)) {
      Log.i("MicroMsg.BizStrategyManager", "fetchBizStrategy delta < interval, return");
    }
    while (d.dbT())
    {
      Object localObject = d.vBI;
      d.dbW();
      ((g)h.ax(g.class)).a(ab.tTZ);
      localObject = d.dbU();
      if (localObject != null)
      {
        localObject = ((fxl)localObject).abzC;
        if (localObject != null) {
          if (System.currentTimeMillis() - vBG < 3600000L)
          {
            AppMethodBeat.o(175462);
            return;
            Log.i("MicroMsg.BizStrategyManager", "alvinluo fetchBizStrategy %d, requestType: %d", new Object[] { Long.valueOf(l), Integer.valueOf(requestType) });
            localObject = new com.tencent.mm.am.c.a();
            ((com.tencent.mm.am.c.a)localObject).otE = ((com.tencent.mm.bx.a)new ri());
            ((com.tencent.mm.am.c.a)localObject).otF = ((com.tencent.mm.bx.a)new rj());
            ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/mmbiz-bin/timeline/bizstrategy";
            ((com.tencent.mm.am.c.a)localObject).funcId = 1806;
            localObject = ((com.tencent.mm.am.c.a)localObject).bEF();
            com.tencent.mm.bx.a locala = c.b.b(((com.tencent.mm.am.c)localObject).otB);
            if (locala == null)
            {
              localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizStrategyReq");
              AppMethodBeat.o(175462);
              throw ((Throwable)localObject);
            }
            ((ri)locala).nUz = requestType;
            z.a((com.tencent.mm.am.c)localObject, c..ExternalSyntheticLambda0.INSTANCE);
          }
          else
          {
            vBG = System.currentTimeMillis();
            ((y)h.ax(y.class)).bL((String)localObject, 0);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.c
 * JD-Core Version:    0.7.0.1
 */