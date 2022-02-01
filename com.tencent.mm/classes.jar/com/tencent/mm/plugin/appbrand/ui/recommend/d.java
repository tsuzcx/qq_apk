package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import d.f;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import d.l;
import d.l.k;
import java.util.concurrent.TimeUnit;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativePredownloadPeriodCheckLogic;", "", "()V", "INTERVAL", "", "getINTERVAL", "()J", "KEY_LAST_CHECK_TIMESTAMP", "", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV$delegate", "Lkotlin/Lazy;", "SP", "hitFrequencyLimit", "", "triggerCheck", "", "plugin-appbrand-integration_release"})
public final class d
{
  private static final f mmv;
  public static final d mmw;
  
  static
  {
    AppMethodBeat.i(51351);
    $$delegatedProperties = new k[] { (k)w.a(new u(w.bn(d.class), "MMKV", "getMMKV()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;")) };
    mmw = new d();
    mmv = d.g.K((a)d.a.mmx);
    AppMethodBeat.o(51351);
  }
  
  private static aw JW()
  {
    AppMethodBeat.i(51352);
    aw localaw = (aw)mmv.getValue();
    AppMethodBeat.o(51352);
    return localaw;
  }
  
  public static void bwT()
  {
    AppMethodBeat.i(51353);
    if (!c.bwQ())
    {
      AppMethodBeat.o(51353);
      return;
    }
    if (!c.bwS())
    {
      AppMethodBeat.o(51353);
      return;
    }
    long l = JW().getLong("KEY_LAST_CHECK_TIMESTAMP", 0L);
    if (bs.eWj() - l <= TimeUnit.MINUTES.toMillis(((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pTa, 60L))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(51353);
      return;
    }
    JW().putLong("KEY_LAST_CHECK_TIMESTAMP", bs.eWj());
    ((q)com.tencent.mm.kernel.g.ab(q.class)).Ix("gh_b489f391e008@app");
    AppMethodBeat.o(51353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.d
 * JD-Core Version:    0.7.0.1
 */