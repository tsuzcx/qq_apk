package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f;
import a.f.b.t;
import a.f.b.v;
import a.j.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.TimeUnit;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativePredownloadPeriodCheckLogic;", "", "()V", "INTERVAL", "", "getINTERVAL", "()J", "KEY_LAST_CHECK_TIMESTAMP", "", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV$delegate", "Lkotlin/Lazy;", "SP", "hitFrequencyLimit", "", "triggerCheck", "", "plugin-appbrand-integration_release"})
public final class d
{
  private static final f iWm;
  public static final d iWn;
  
  static
  {
    AppMethodBeat.i(154357);
    eOJ = new k[] { (k)v.a(new t(v.aG(d.class), "MMKV", "getMMKV()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;")) };
    iWn = new d();
    iWm = a.g.j((a.f.a.a)d.a.iWo);
    AppMethodBeat.o(154357);
  }
  
  private static as aND()
  {
    AppMethodBeat.i(154358);
    as localas = (as)iWm.getValue();
    AppMethodBeat.o(154358);
    return localas;
  }
  
  public static void aNE()
  {
    AppMethodBeat.i(154359);
    if (!c.aNC())
    {
      AppMethodBeat.o(154359);
      return;
    }
    long l = aND().getLong("KEY_LAST_CHECK_TIMESTAMP", 0L);
    if (bo.aoy() - l <= TimeUnit.MINUTES.toMillis(((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVv, 60L))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(154359);
      return;
    }
    aND().putLong("KEY_LAST_CHECK_TIMESTAMP", bo.aoy());
    ((m)com.tencent.mm.kernel.g.E(m.class)).yN("gh_b489f391e008@app");
    AppMethodBeat.o(154359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.d
 * JD-Core Version:    0.7.0.1
 */