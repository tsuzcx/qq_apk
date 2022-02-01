package com.tencent.mm.plugin.finder.nearby;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/NearbyConfig;", "", "()V", "TAG", "", "get3TabTargetTabCommentScene", "", "get3TabTargetTabType", "saveExitTabType", "", "tabType", "plugin-finder_release"})
public final class a
{
  public static final a uQd;
  
  static
  {
    AppMethodBeat.i(248996);
    uQd = new a();
    AppMethodBeat.o(248996);
  }
  
  public static void Jy(int paramInt)
  {
    AppMethodBeat.i(248995);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Okp, Integer.valueOf(paramInt));
    AppMethodBeat.o(248995);
  }
  
  public static int dlh()
  {
    AppMethodBeat.i(248993);
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    int j = ((e)localObject).azQ().getInt(ar.a.Okp, -1);
    localObject = g.ah(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    localObject = ((PluginFinder)localObject).getRedDotManager().asX("NearbyEntrance");
    int i;
    if (localObject != null) {
      if (((k)localObject).field_ctrInfo.type == 1014)
      {
        Log.i("Finder.RedDotManager", "[getNearbyAliveTabType] entrance red dot is foot print, jump to default tab");
        i = -1;
      }
    }
    for (;;)
    {
      Log.i("NearbyConfig", "get3TabTargetTabType defaultType=1001, lastExitType:" + j + " aliveType=" + i);
      if (i == -1) {
        break;
      }
      AppMethodBeat.o(248993);
      return i;
      i = f.a((k)localObject);
      continue;
      i = -1;
    }
    if ((j != -1) && (j != 1003))
    {
      AppMethodBeat.o(248993);
      return j;
    }
    AppMethodBeat.o(248993);
    return 1001;
  }
  
  public static int dli()
  {
    AppMethodBeat.i(248994);
    switch (dlh())
    {
    default: 
      AppMethodBeat.o(248994);
      return 94;
    case 1002: 
      AppMethodBeat.o(248994);
      return 15;
    case 1001: 
      AppMethodBeat.o(248994);
      return 94;
    }
    AppMethodBeat.o(248994);
    return 77;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.a
 * JD-Core Version:    0.7.0.1
 */