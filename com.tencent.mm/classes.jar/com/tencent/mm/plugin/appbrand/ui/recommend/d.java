package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.TimeUnit;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendFakeNativePredownloadPeriodCheckLogic;", "", "()V", "INTERVAL", "", "getINTERVAL", "()J", "KEY_LAST_CHECK_TIMESTAMP", "", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV$delegate", "Lkotlin/Lazy;", "SP", "hitFrequencyLimit", "", "triggerCheck", "", "plugin-appbrand-integration_release"})
public final class d
{
  private static final f rgP;
  public static final d rgQ;
  
  static
  {
    AppMethodBeat.i(51351);
    rgQ = new d();
    rgP = g.ar((a)a.rgR);
    AppMethodBeat.o(51351);
  }
  
  private static MultiProcessMMKV aal()
  {
    AppMethodBeat.i(51352);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)rgP.getValue();
    AppMethodBeat.o(51352);
    return localMultiProcessMMKV;
  }
  
  private static long clD()
  {
    AppMethodBeat.i(264375);
    long l = TimeUnit.MINUTES.toMillis(((b)h.ae(b.class)).a(b.a.vEK, 60L));
    AppMethodBeat.o(264375);
    return l;
  }
  
  private static boolean clF()
  {
    AppMethodBeat.i(264376);
    long l = aal().getLong("KEY_LAST_CHECK_TIMESTAMP", 0L);
    if (Util.nowMilliSecond() - l <= clD())
    {
      AppMethodBeat.o(264376);
      return true;
    }
    AppMethodBeat.o(264376);
    return false;
  }
  
  public final void clE()
  {
    AppMethodBeat.i(51353);
    if (!c.clA())
    {
      AppMethodBeat.o(51353);
      return;
    }
    if (!c.clB())
    {
      AppMethodBeat.o(51353);
      return;
    }
    if (clF())
    {
      AppMethodBeat.o(51353);
      return;
    }
    aal().putLong("KEY_LAST_CHECK_TIMESTAMP", Util.nowMilliSecond());
    ((w)h.ae(w.class)).bu("gh_b489f391e008@app", 0);
    AppMethodBeat.o(51353);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements a<MultiProcessMMKV>
  {
    public static final a rgR;
    
    static
    {
      AppMethodBeat.i(51350);
      rgR = new a();
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