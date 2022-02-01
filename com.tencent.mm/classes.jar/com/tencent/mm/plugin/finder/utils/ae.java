package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.c.a;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderSvrExptManager;", "", "()V", "TAG", "", "requestInterval", "", "requestTimeMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getHitCache", "exptId", "getSvrExptHitValue", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failedCallback", "setHitCache", "", "value", "plugin-finder_release"})
public final class ae
{
  static final HashMap<Integer, Integer> AFB;
  public static final ae AFC;
  private static final String TAG = "Finder.FinderSvrExptManager";
  static int xUB;
  
  static
  {
    AppMethodBeat.i(271306);
    AFC = new ae();
    TAG = "Finder.FinderSvrExptManager";
    AFB = new HashMap();
    xUB = 300;
    AppMethodBeat.o(271306);
  }
  
  public static void gZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(271305);
    Log.i(TAG, "setHitCache, exptId:" + paramInt1 + ", value:" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(271305);
      return;
      f localf = h.aHG();
      p.j(localf, "MMKernel.storage()");
      localf.aHp().set(ar.a.VBU, Integer.valueOf(paramInt2));
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetSvrExptConfigResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements a<_Ret, _Var>
  {
    a(ag.a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ae
 * JD-Core Version:    0.7.0.1
 */