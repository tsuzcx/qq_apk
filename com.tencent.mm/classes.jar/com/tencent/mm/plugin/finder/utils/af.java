package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.cgi.r;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.a.ad;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.plugin.findersdk.a.ag.a<Ljava.lang.Boolean;>;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.c.a;
import java.util.HashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderSwitchApi;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSwitchApi;", "()V", "TAG", "", "getFinderActivityShareBusinessType", "", "getUserInfoFinderSetting", "", "hasFinderSetting", "", "type", "setUserInfoFinderSetting", "", "finderSetting", "showFinderAtWxProfile", "showFinderEntryAtWxMe", "showFinderEntrySetting", "showFinderRecentLike", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failedCallback", "showFriendFinderEntry", "plugin-finder_release"})
public final class af
  implements ad
{
  public static final af AFF;
  private static final String TAG = "Finder.FinderSwitchApi";
  
  static
  {
    AppMethodBeat.i(272988);
    AFF = new af();
    TAG = "Finder.FinderSwitchApi";
    AppMethodBeat.o(272988);
  }
  
  public static boolean edP()
  {
    AppMethodBeat.i(272983);
    Object localObject = aj.AGc;
    boolean bool2 = aj.edY();
    localObject = d.AjH;
    if (((Number)d.dUd().aSr()).intValue() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i(TAG, "showFinderEntrySetting hasFinderAccount" + bool2 + ", switch:" + bool1);
      if ((!bool2) || (!bool1)) {
        break;
      }
      AppMethodBeat.o(272983);
      return true;
    }
    AppMethodBeat.o(272983);
    return false;
  }
  
  public final void Nd(long paramLong)
  {
    AppMethodBeat.i(272979);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBV, Long.valueOf(paramLong));
    AppMethodBeat.o(272979);
  }
  
  public final boolean b(ag.a<Boolean> parama)
  {
    AppMethodBeat.i(272987);
    Object localObject = ae.AFC;
    ag.a locala = (ag.a)new a(parama);
    localObject = (Integer)ae.AFB.get(Integer.valueOf(1));
    parama = (ag.a<Boolean>)localObject;
    if (localObject == null) {
      parama = Integer.valueOf(0);
    }
    p.j(parama, "requestTimeMap[exptId] ?: 0");
    int i = parama.intValue();
    if (cm.bfF() - i > ae.xUB) {
      new r(j.listOf(Integer.valueOf(1))).bhW().g((a)new ae.a(locala));
    }
    parama = h.aHG();
    p.j(parama, "MMKernel.storage()");
    if (parama.aHp().getInt(ar.a.VBU, 0) == 1)
    {
      AppMethodBeat.o(272987);
      return true;
    }
    AppMethodBeat.o(272987);
    return false;
  }
  
  public final long edM()
  {
    AppMethodBeat.i(272980);
    com.tencent.mm.kernel.f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    long l = localf.aHp().a(ar.a.VBV, 0L);
    AppMethodBeat.o(272980);
    return l;
  }
  
  public final boolean edN()
  {
    AppMethodBeat.i(272981);
    if ((edM() & 1L) != 0L)
    {
      AppMethodBeat.o(272981);
      return true;
    }
    AppMethodBeat.o(272981);
    return false;
  }
  
  public final boolean edO()
  {
    AppMethodBeat.i(272982);
    Object localObject = aj.AGc;
    int i = aj.eei();
    localObject = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(localObject, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool1 = ((com.tencent.mm.plugin.teenmode.a.b)localObject).ZM();
    localObject = d.AjH;
    switch (((Number)d.dUa().aSr()).intValue())
    {
    }
    for (;;)
    {
      Log.i(TAG, "showFinderEntryAtWxMe teenMode:" + bool1 + ", state:" + i);
      if (!bool1) {
        break;
      }
      AppMethodBeat.o(272982);
      return false;
      bool1 = true;
      continue;
      i = 1;
      continue;
      i = 4;
    }
    boolean bool2;
    switch (i)
    {
    case 2: 
    case 3: 
    default: 
      localObject = d.AjH;
      if (((Number)d.dUb().aSr()).intValue() == 1)
      {
        bool1 = true;
        localObject = d.AjH;
        if (((Number)d.dUc().aSr()).intValue() != 1) {
          break label338;
        }
        bool2 = true;
        label226:
        localObject = d.AjH;
        if (((Number)d.dUd().aSr()).intValue() != 1) {
          break label343;
        }
      }
      break;
    }
    boolean bool4;
    label338:
    label343:
    for (boolean bool3 = true;; bool3 = false)
    {
      localObject = aj.AGc;
      bool4 = aj.eed();
      Log.i(TAG, "showFinderEntryAtWxMe switchA:" + bool1 + ", switchB:" + bool2 + ", switchC:" + bool3 + ", showFinderAtWxProfile:" + bool4);
      if (!bool1) {
        break label349;
      }
      AppMethodBeat.o(272982);
      return true;
      AppMethodBeat.o(272982);
      return false;
      bool1 = false;
      break;
      bool2 = false;
      break label226;
    }
    label349:
    if (!bool2)
    {
      AppMethodBeat.o(272982);
      return false;
    }
    if (!bool3)
    {
      AppMethodBeat.o(272982);
      return false;
    }
    if (bool4)
    {
      AppMethodBeat.o(272982);
      return true;
    }
    AppMethodBeat.o(272982);
    return false;
  }
  
  public final boolean edQ()
  {
    AppMethodBeat.i(272984);
    d locald = d.AjH;
    if (((Number)d.dUd().aSr()).intValue() == 1)
    {
      AppMethodBeat.o(272984);
      return true;
    }
    AppMethodBeat.o(272984);
    return false;
  }
  
  public final boolean edR()
  {
    AppMethodBeat.i(293283);
    aj localaj = aj.AGc;
    boolean bool = aj.eed();
    AppMethodBeat.o(293283);
    return bool;
  }
  
  public final int edS()
  {
    AppMethodBeat.i(272986);
    d locald = d.AjH;
    int i = ((Number)d.dWQ().aSr()).intValue();
    AppMethodBeat.o(272986);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/FinderSwitchApi$showFinderRecentLike$1", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "onCallback", "", "ret", "(Ljava/lang/Integer;)V", "plugin-finder_release"})
  public static final class a
    implements ag.a<Integer>
  {
    a(ag.a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.af
 * JD-Core Version:    0.7.0.1
 */