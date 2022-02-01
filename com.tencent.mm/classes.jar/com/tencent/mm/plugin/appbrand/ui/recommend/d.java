package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.y;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativePredownloadPeriodCheckLogic;", "", "()V", "INTERVAL", "", "getINTERVAL", "()J", "KEY_LAST_CHECK_TIMESTAMP", "", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV$delegate", "Lkotlin/Lazy;", "SP", "hitFrequencyLimit", "", "triggerCheck", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d uoL;
  private static final j uoM;
  
  static
  {
    AppMethodBeat.i(51351);
    uoL = new d();
    uoM = k.cm((a)a.uoN);
    AppMethodBeat.o(51351);
  }
  
  private static MultiProcessMMKV aBP()
  {
    AppMethodBeat.i(51352);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)uoM.getValue();
    AppMethodBeat.o(51352);
    return localMultiProcessMMKV;
  }
  
  public static void cNa()
  {
    AppMethodBeat.i(51353);
    if (!c.cMX())
    {
      AppMethodBeat.o(51353);
      return;
    }
    if (!c.cMY())
    {
      AppMethodBeat.o(51353);
      return;
    }
    long l = aBP().getLong("KEY_LAST_CHECK_TIMESTAMP", 0L);
    if (Util.nowMilliSecond() - l <= TimeUnit.MINUTES.toMillis(((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUf, 60L))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(51353);
      return;
    }
    aBP().putLong("KEY_LAST_CHECK_TIMESTAMP", Util.nowMilliSecond());
    ((y)h.ax(y.class)).bL("gh_b489f391e008@app", 0);
    AppMethodBeat.o(51353);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<MultiProcessMMKV>
  {
    public static final a uoN;
    
    static
    {
      AppMethodBeat.i(51350);
      uoN = new a();
      AppMethodBeat.o(51350);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.d
 * JD-Core Version:    0.7.0.1
 */