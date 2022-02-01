package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.o;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.i.a.ac;
import com.tencent.mm.plugin.i.a.af.a;
import com.tencent.mm.plugin.i.a.af.a<Ljava.lang.Boolean;>;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.c.a;
import java.util.HashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderSwitchApi;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSwitchApi;", "()V", "TAG", "", "getFinderActivityShareBusinessType", "", "getUserInfoFinderSetting", "", "hasFinderSetting", "", "type", "setUserInfoFinderSetting", "", "finderSetting", "showFinderAtWxProfile", "showFinderEntryAtWxMe", "showFinderEntrySetting", "showFinderRecentLike", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failedCallback", "showFriendFinderEntry", "plugin-finder_release"})
public final class v
  implements ac
{
  private static final String TAG = "Finder.FinderSwitchApi";
  public static final v vXn;
  
  static
  {
    AppMethodBeat.i(253547);
    vXn = new v();
    TAG = "Finder.FinderSwitchApi";
    AppMethodBeat.o(253547);
  }
  
  public static boolean dCt()
  {
    AppMethodBeat.i(253542);
    Object localObject = y.vXH;
    boolean bool2 = y.dCB();
    localObject = c.vCb;
    if (((Number)c.dsL().value()).intValue() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i(TAG, "showFinderEntrySetting hasFinderAccount" + bool2 + ", switch:" + bool1);
      if ((!bool2) || (!bool1)) {
        break;
      }
      AppMethodBeat.o(253542);
      return true;
    }
    AppMethodBeat.o(253542);
    return false;
  }
  
  public final void Gf(long paramLong)
  {
    AppMethodBeat.i(253538);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OmU, Long.valueOf(paramLong));
    AppMethodBeat.o(253538);
  }
  
  public final boolean a(af.a<Boolean> parama)
  {
    AppMethodBeat.i(253546);
    Object localObject = u.vXk;
    af.a locala = (af.a)new a(parama);
    localObject = (Integer)u.vXj.get(Integer.valueOf(1));
    parama = (af.a<Boolean>)localObject;
    if (localObject == null) {
      parama = Integer.valueOf(0);
    }
    p.g(parama, "requestTimeMap[exptId] ?: 0");
    int i = parama.intValue();
    if (cl.aWB() - i > u.ufh) {
      new o(j.listOf(Integer.valueOf(1))).aYI().g((a)new u.a(locala));
    }
    parama = g.aAh();
    p.g(parama, "MMKernel.storage()");
    if (parama.azQ().getInt(ar.a.OmT, 0) == 1)
    {
      AppMethodBeat.o(253546);
      return true;
    }
    AppMethodBeat.o(253546);
    return false;
  }
  
  public final long dCq()
  {
    AppMethodBeat.i(253539);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    long l = locale.azQ().a(ar.a.OmU, 0L);
    AppMethodBeat.o(253539);
    return l;
  }
  
  public final boolean dCr()
  {
    AppMethodBeat.i(253540);
    if ((dCq() & 1L) != 0L)
    {
      AppMethodBeat.o(253540);
      return true;
    }
    AppMethodBeat.o(253540);
    return false;
  }
  
  public final boolean dCs()
  {
    AppMethodBeat.i(253541);
    Object localObject = y.vXH;
    int i = y.dCL();
    localObject = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
    p.g(localObject, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool1 = ((com.tencent.mm.plugin.teenmode.a.b)localObject).Vt();
    localObject = c.vCb;
    switch (((Number)c.dsI().value()).intValue())
    {
    }
    for (;;)
    {
      Log.i(TAG, "showFinderEntryAtWxMe teenMode:" + bool1 + ", state:" + i);
      if (!bool1) {
        break;
      }
      AppMethodBeat.o(253541);
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
      localObject = c.vCb;
      if (((Number)c.dsJ().value()).intValue() == 1)
      {
        bool1 = true;
        localObject = c.vCb;
        if (((Number)c.dsK().value()).intValue() != 1) {
          break label338;
        }
        bool2 = true;
        label226:
        localObject = c.vCb;
        if (((Number)c.dsL().value()).intValue() != 1) {
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
      localObject = y.vXH;
      bool4 = y.dCG();
      Log.i(TAG, "showFinderEntryAtWxMe switchA:" + bool1 + ", switchB:" + bool2 + ", switchC:" + bool3 + ", showFinderAtWxProfile:" + bool4);
      if (!bool1) {
        break label349;
      }
      AppMethodBeat.o(253541);
      return true;
      AppMethodBeat.o(253541);
      return false;
      bool1 = false;
      break;
      bool2 = false;
      break label226;
    }
    label349:
    if (!bool2)
    {
      AppMethodBeat.o(253541);
      return false;
    }
    if (!bool3)
    {
      AppMethodBeat.o(253541);
      return false;
    }
    if (bool4)
    {
      AppMethodBeat.o(253541);
      return true;
    }
    AppMethodBeat.o(253541);
    return false;
  }
  
  public final boolean dCu()
  {
    AppMethodBeat.i(253543);
    c localc = c.vCb;
    if (((Number)c.dsL().value()).intValue() == 1)
    {
      AppMethodBeat.o(253543);
      return true;
    }
    AppMethodBeat.o(253543);
    return false;
  }
  
  public final boolean dCv()
  {
    AppMethodBeat.i(258554);
    y localy = y.vXH;
    boolean bool = y.dCG();
    AppMethodBeat.o(258554);
    return bool;
  }
  
  public final int dCw()
  {
    AppMethodBeat.i(253545);
    c localc = c.vCb;
    int i = ((Number)c.dwH().value()).intValue();
    AppMethodBeat.o(253545);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/utils/FinderSwitchApi$showFinderRecentLike$1", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "onCallback", "", "ret", "(Ljava/lang/Integer;)V", "plugin-finder_release"})
  public static final class a
    implements af.a<Integer>
  {
    a(af.a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.v
 * JD-Core Version:    0.7.0.1
 */