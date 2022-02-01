package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.f;
import d.g.a.a;
import d.l;
import java.util.concurrent.TimeUnit;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativePredownloadPeriodCheckLogic;", "", "()V", "INTERVAL", "", "getINTERVAL", "()J", "KEY_LAST_CHECK_TIMESTAMP", "", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV$delegate", "Lkotlin/Lazy;", "SP", "hitFrequencyLimit", "", "triggerCheck", "", "plugin-appbrand-integration_release"})
public final class d
{
  private static final f mMX;
  public static final d mMY;
  
  static
  {
    AppMethodBeat.i(51351);
    mMY = new d();
    mMX = d.g.O((a)d.a.mMZ);
    AppMethodBeat.o(51351);
  }
  
  private static ax Lv()
  {
    AppMethodBeat.i(51352);
    ax localax = (ax)mMX.getValue();
    AppMethodBeat.o(51352);
    return localax;
  }
  
  public static void bAZ()
  {
    AppMethodBeat.i(51353);
    if (!c.bAW())
    {
      AppMethodBeat.o(51353);
      return;
    }
    if (!c.bAY())
    {
      AppMethodBeat.o(51353);
      return;
    }
    long l = Lv().getLong("KEY_LAST_CHECK_TIMESTAMP", 0L);
    if (bt.flT() - l <= TimeUnit.MINUTES.toMillis(((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qxF, 60L))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(51353);
      return;
    }
    Lv().putLong("KEY_LAST_CHECK_TIMESTAMP", bt.flT());
    ((r)com.tencent.mm.kernel.g.ab(r.class)).LO("gh_b489f391e008@app");
    AppMethodBeat.o(51353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.d
 * JD-Core Version:    0.7.0.1
 */