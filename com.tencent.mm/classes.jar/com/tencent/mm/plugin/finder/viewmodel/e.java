package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.i;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStateCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cachedTabIndex", "", "cachedTimeStamp", "", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "getCachedIndex", "type", "getEnterTabIndex", "getRedDotCount", "Lkotlin/Pair;", "redDotFlags", "", "", "([Ljava/lang/Boolean;)Lkotlin/Pair;", "isExistRedDot", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "setRedDotFlags", "", "([Ljava/lang/Boolean;)V", "store", "tabIndex", "Companion", "plugin-finder_release"})
public final class e
  extends i<PluginFinder>
{
  public static final a Bhi;
  public final ConcurrentHashMap<Integer, Integer> Bgm;
  public int Bhh;
  
  static
  {
    AppMethodBeat.i(287865);
    Bhi = new a((byte)0);
    AppMethodBeat.o(287865);
  }
  
  public e()
  {
    AppMethodBeat.i(287864);
    this.Bgm = new ConcurrentHashMap();
    this.Bhh = -1;
    AppMethodBeat.o(287864);
  }
  
  private static boolean b(bkn parambkn)
  {
    return (parambkn != null) && (parambkn.count > 0);
  }
  
  public final int eke()
  {
    int i3 = 0;
    AppMethodBeat.i(287863);
    if (this.Bhh != -1)
    {
      i = this.Bhh;
      AppMethodBeat.o(287863);
      return i;
    }
    Object localObject1 = (Integer)this.Bgm.get(Integer.valueOf(1));
    if (localObject1 != null) {}
    Boolean[] arrayOfBoolean;
    int n;
    int i1;
    for (int j = ((Integer)localObject1).intValue();; j = 0)
    {
      arrayOfBoolean = new Boolean[3];
      arrayOfBoolean[0] = Boolean.FALSE;
      arrayOfBoolean[1] = Boolean.FALSE;
      arrayOfBoolean[2] = Boolean.FALSE;
      localObject1 = h.ag(PluginFinder.class);
      p.j(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager().aBe("NotificationCenterLike");
      localObject2 = h.ag(PluginFinder.class);
      p.j(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
      localObject2 = ((PluginFinder)localObject2).getRedDotManager().aBe("NotificationCenterComment");
      Object localObject3 = h.ag(PluginFinder.class);
      p.j(localObject3, "MMKernel.plugin(PluginFinder::class.java)");
      localObject3 = ((PluginFinder)localObject3).getRedDotManager().aBe("NotificationCenterFollow");
      arrayOfBoolean[0] = Boolean.valueOf(b((bkn)localObject1));
      arrayOfBoolean[1] = Boolean.valueOf(b((bkn)localObject2));
      arrayOfBoolean[2] = Boolean.valueOf(b((bkn)localObject3));
      int k = 0;
      n = -1;
      i1 = 0;
      i = 0;
      while (k < 3)
      {
        int i2 = n;
        int m = i1;
        if (arrayOfBoolean[k].booleanValue())
        {
          i1 += 1;
          i2 = n;
          m = i1;
          if (n == -1)
          {
            i2 = i;
            m = i1;
          }
        }
        k += 1;
        i += 1;
        n = i2;
        i1 = m;
      }
    }
    Object localObject2 = new o(Integer.valueOf(i1), Integer.valueOf(n));
    this.Bhh = j;
    if (((Number)((o)localObject2).Mx).intValue() == 0)
    {
      AppMethodBeat.o(287863);
      return j;
    }
    int i = i3;
    if (j >= 0)
    {
      i = i3;
      if (j < 3) {
        i = 1;
      }
    }
    if (i != 0) {}
    for (localObject1 = arrayOfBoolean; (localObject1 != null) && (arrayOfBoolean[j].booleanValue()); localObject1 = null)
    {
      Log.i("Finder.FinderTabStateCacheVM", "red dot index == cachedIndex");
      AppMethodBeat.o(287863);
      return j;
    }
    if ((((Number)((o)localObject2).Mx).intValue() == 2) || (((Number)((o)localObject2).Mx).intValue() == 1))
    {
      this.Bhh = ((Number)((o)localObject2).My).intValue();
      i = ((Number)((o)localObject2).My).intValue();
      AppMethodBeat.o(287863);
      return i;
    }
    AppMethodBeat.o(287863);
    return j;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStateCacheVM$Companion;", "", "()V", "TAG", "", "TYPE_NOTIFY_TAB", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.e
 * JD-Core Version:    0.7.0.1
 */