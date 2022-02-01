package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.f;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import d.l;
import d.l.k;
import java.util.concurrent.TimeUnit;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativePredownloadPeriodCheckLogic;", "", "()V", "INTERVAL", "", "getINTERVAL", "()J", "KEY_LAST_CHECK_TIMESTAMP", "", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV$delegate", "Lkotlin/Lazy;", "SP", "hitFrequencyLimit", "", "triggerCheck", "", "plugin-appbrand-integration_release"})
public final class d
{
  private static final f lKy;
  public static final d lKz;
  
  static
  {
    AppMethodBeat.i(51351);
    $$delegatedProperties = new k[] { (k)w.a(new u(w.bk(d.class), "MMKV", "getMMKV()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;")) };
    lKz = new d();
    lKy = d.g.E((a)d.a.lKA);
    AppMethodBeat.o(51351);
  }
  
  private static ax Km()
  {
    AppMethodBeat.i(51352);
    ax localax = (ax)lKy.getValue();
    AppMethodBeat.o(51352);
    return localax;
  }
  
  public static void bpW()
  {
    AppMethodBeat.i(51353);
    if (!c.bpT())
    {
      AppMethodBeat.o(51353);
      return;
    }
    if (!c.bpV())
    {
      AppMethodBeat.o(51353);
      return;
    }
    long l = Km().getLong("KEY_LAST_CHECK_TIMESTAMP", 0L);
    if (bt.eGO() - l <= TimeUnit.MINUTES.toMillis(((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.ppp, 60L))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(51353);
      return;
    }
    Km().putLong("KEY_LAST_CHECK_TIMESTAMP", bt.eGO());
    ((q)com.tencent.mm.kernel.g.ab(q.class)).Eu("gh_b489f391e008@app");
    AppMethodBeat.o(51353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.d
 * JD-Core Version:    0.7.0.1
 */