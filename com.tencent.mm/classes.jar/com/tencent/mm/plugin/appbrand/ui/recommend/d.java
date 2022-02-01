package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import d.f;
import d.g.a.a;
import d.l;
import java.util.concurrent.TimeUnit;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativePredownloadPeriodCheckLogic;", "", "()V", "INTERVAL", "", "getINTERVAL", "()J", "KEY_LAST_CHECK_TIMESTAMP", "", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV$delegate", "Lkotlin/Lazy;", "SP", "hitFrequencyLimit", "", "triggerCheck", "", "plugin-appbrand-integration_release"})
public final class d
{
  private static final f mSa;
  public static final d mSb;
  
  static
  {
    AppMethodBeat.i(51351);
    mSb = new d();
    mSa = d.g.O((a)d.a.mSc);
    AppMethodBeat.o(51351);
  }
  
  private static ay LD()
  {
    AppMethodBeat.i(51352);
    ay localay = (ay)mSa.getValue();
    AppMethodBeat.o(51352);
    return localay;
  }
  
  public static void bBT()
  {
    AppMethodBeat.i(51353);
    if (!c.bBQ())
    {
      AppMethodBeat.o(51353);
      return;
    }
    if (!c.bBS())
    {
      AppMethodBeat.o(51353);
      return;
    }
    long l = LD().getLong("KEY_LAST_CHECK_TIMESTAMP", 0L);
    if (bu.fpO() - l <= TimeUnit.MINUTES.toMillis(((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qEL, 60L))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(51353);
      return;
    }
    LD().putLong("KEY_LAST_CHECK_TIMESTAMP", bu.fpO());
    ((s)com.tencent.mm.kernel.g.ab(s.class)).Mr("gh_b489f391e008@app");
    AppMethodBeat.o(51353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.d
 * JD-Core Version:    0.7.0.1
 */