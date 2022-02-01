package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.TimeUnit;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativePredownloadPeriodCheckLogic;", "", "()V", "INTERVAL", "", "getINTERVAL", "()J", "KEY_LAST_CHECK_TIMESTAMP", "", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV$delegate", "Lkotlin/Lazy;", "SP", "hitFrequencyLimit", "", "triggerCheck", "", "plugin-appbrand-integration_release"})
public final class d
{
  private static final f ofd;
  public static final d ofe;
  
  static
  {
    AppMethodBeat.i(51351);
    ofe = new d();
    ofd = kotlin.g.ah((a)d.a.ofg);
    AppMethodBeat.o(51351);
  }
  
  private static MultiProcessMMKV VQ()
  {
    AppMethodBeat.i(51352);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)ofd.getValue();
    AppMethodBeat.o(51352);
    return localMultiProcessMMKV;
  }
  
  private static long bYU()
  {
    AppMethodBeat.i(229568);
    long l = TimeUnit.MINUTES.toMillis(((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rXU, 60L));
    AppMethodBeat.o(229568);
    return l;
  }
  
  private static boolean bYW()
  {
    AppMethodBeat.i(229569);
    long l = VQ().getLong("KEY_LAST_CHECK_TIMESTAMP", 0L);
    if (Util.nowMilliSecond() - l <= bYU())
    {
      AppMethodBeat.o(229569);
      return true;
    }
    AppMethodBeat.o(229569);
    return false;
  }
  
  public final void bYV()
  {
    AppMethodBeat.i(51353);
    if (!c.bYQ())
    {
      AppMethodBeat.o(51353);
      return;
    }
    if (!c.bYS())
    {
      AppMethodBeat.o(51353);
      return;
    }
    if (bYW())
    {
      AppMethodBeat.o(51353);
      return;
    }
    VQ().putLong("KEY_LAST_CHECK_TIMESTAMP", Util.nowMilliSecond());
    ((w)com.tencent.mm.kernel.g.af(w.class)).bb("gh_b489f391e008@app", 0);
    AppMethodBeat.o(51353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.d
 * JD-Core Version:    0.7.0.1
 */