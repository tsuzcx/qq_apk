package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.bv;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderSwitchApi;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSwitchApi;", "()V", "TAG", "", "getFinderActivityShareBusinessType", "", "getUserInfoFinderSetting", "", "hasFinderSetting", "", "type", "setUserInfoFinderSetting", "", "finderSetting", "showFinderAtWxProfile", "showFinderEntryAtWxMe", "showFinderEntrySetting", "showFinderRecentLike", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failedCallback", "showFriendFinderEntry", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aq
  implements bv
{
  public static final aq Giv;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(332982);
    Giv = new aq();
    TAG = "Finder.FinderSwitchApi";
    AppMethodBeat.o(332982);
  }
  
  public static boolean ffG()
  {
    AppMethodBeat.i(332976);
    Object localObject = av.GiL;
    boolean bool2 = av.ffR();
    localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eSw().bmg()).intValue() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i(TAG, "showFinderEntrySetting hasFinderAccount" + bool2 + ", switch:" + bool1);
      if ((!bool2) || (!bool1)) {
        break;
      }
      AppMethodBeat.o(332976);
      return true;
    }
    AppMethodBeat.o(332976);
    return false;
  }
  
  public final boolean c(ca.a<Boolean> parama)
  {
    AppMethodBeat.i(333024);
    ap localap = ap.Git;
    if (ap.b((ca.a)new a(parama)) == 1)
    {
      AppMethodBeat.o(333024);
      return true;
    }
    AppMethodBeat.o(333024);
    return false;
  }
  
  public final long ffD()
  {
    AppMethodBeat.i(332990);
    long l = h.baE().ban().a(at.a.adet, 0L);
    AppMethodBeat.o(332990);
    return l;
  }
  
  public final boolean ffE()
  {
    AppMethodBeat.i(332996);
    if ((ffD() & 1L) != 0L)
    {
      AppMethodBeat.o(332996);
      return true;
    }
    AppMethodBeat.o(332996);
    return false;
  }
  
  public final boolean ffF()
  {
    AppMethodBeat.i(333003);
    Object localObject = av.GiL;
    int i = av.fgg();
    boolean bool1 = ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
    localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    switch (((Number)com.tencent.mm.plugin.finder.storage.d.eSt().bmg()).intValue())
    {
    }
    for (;;)
    {
      Log.i(TAG, "showFinderEntryAtWxMe teenMode:" + bool1 + ", state:" + i);
      if (!bool1) {
        break;
      }
      AppMethodBeat.o(333003);
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
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eSu().bmg()).intValue() == 1)
      {
        bool1 = true;
        localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eSv().bmg()).intValue() != 1) {
          break label318;
        }
        bool2 = true;
        label210:
        localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eSw().bmg()).intValue() != 1) {
          break label323;
        }
      }
      break;
    }
    boolean bool4;
    label318:
    label323:
    for (boolean bool3 = true;; bool3 = false)
    {
      localObject = av.GiL;
      bool4 = av.ffW();
      Log.i(TAG, "showFinderEntryAtWxMe switchA:" + bool1 + ", switchB:" + bool2 + ", switchC:" + bool3 + ", showFinderAtWxProfile:" + bool4);
      if (!bool1) {
        break label329;
      }
      AppMethodBeat.o(333003);
      return true;
      AppMethodBeat.o(333003);
      return false;
      bool1 = false;
      break;
      bool2 = false;
      break label210;
    }
    label329:
    if (!bool2)
    {
      AppMethodBeat.o(333003);
      return false;
    }
    if (!bool3)
    {
      AppMethodBeat.o(333003);
      return false;
    }
    if (bool4)
    {
      AppMethodBeat.o(333003);
      return true;
    }
    AppMethodBeat.o(333003);
    return false;
  }
  
  public final boolean ffH()
  {
    AppMethodBeat.i(333006);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eSw().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(333006);
      return true;
    }
    AppMethodBeat.o(333006);
    return false;
  }
  
  public final boolean ffI()
  {
    AppMethodBeat.i(370206);
    av localav = av.GiL;
    boolean bool = av.ffW();
    AppMethodBeat.o(370206);
    return bool;
  }
  
  public final int ffJ()
  {
    AppMethodBeat.i(333017);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.d.eVB().bmg()).intValue();
    AppMethodBeat.o(333017);
    return i;
  }
  
  public final void qG(long paramLong)
  {
    AppMethodBeat.i(332988);
    h.baE().ban().set(at.a.adet, Long.valueOf(paramLong));
    AppMethodBeat.o(332988);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderSwitchApi$showFinderRecentLike$1", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "", "onCallback", "", "ret", "(Ljava/lang/Integer;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ca.a<Integer>
  {
    a(ca.a<Boolean> parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.aq
 * JD-Core Version:    0.7.0.1
 */