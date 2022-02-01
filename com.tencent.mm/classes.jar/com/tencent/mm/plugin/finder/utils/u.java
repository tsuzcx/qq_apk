package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.af.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.c.a;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderSvrExptManager;", "", "()V", "TAG", "", "requestInterval", "", "requestTimeMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getHitCache", "exptId", "getSvrExptHitValue", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failedCallback", "setHitCache", "", "value", "plugin-finder_release"})
public final class u
{
  private static final String TAG = "Finder.FinderSvrExptManager";
  static int ufh;
  static final HashMap<Integer, Integer> vXj;
  public static final u vXk;
  
  static
  {
    AppMethodBeat.i(253536);
    vXk = new u();
    TAG = "Finder.FinderSvrExptManager";
    vXj = new HashMap();
    ufh = 300;
    AppMethodBeat.o(253536);
  }
  
  public static void gn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253535);
    Log.i(TAG, "setHitCache, exptId:" + paramInt1 + ", value:" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(253535);
      return;
      e locale = g.aAh();
      p.g(locale, "MMKernel.storage()");
      locale.azQ().set(ar.a.OmT, Integer.valueOf(paramInt2));
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetSvrExptConfigResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(af.a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.u
 * JD-Core Version:    0.7.0.1
 */