package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponentPlugin;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStateCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cachedTabIndex", "", "cachedTimeStamp", "", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "getCachedIndex", "type", "getEnterTabIndex", "getRedDotCount", "Lkotlin/Pair;", "redDotFlags", "", "", "([Ljava/lang/Boolean;)Lkotlin/Pair;", "isExistRedDot", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "setRedDotFlags", "", "([Ljava/lang/Boolean;)V", "store", "tabIndex", "Companion", "plugin-finder_release"})
public final class FinderTabStateCacheVM
  extends UIComponentPlugin<PluginFinder>
{
  public static final a wuJ;
  public final ConcurrentHashMap<Integer, Integer> wtV;
  public int wuI;
  
  static
  {
    AppMethodBeat.i(255373);
    wuJ = new a((byte)0);
    AppMethodBeat.o(255373);
  }
  
  public FinderTabStateCacheVM()
  {
    AppMethodBeat.i(255372);
    this.wtV = new ConcurrentHashMap();
    this.wuI = -1;
    AppMethodBeat.o(255372);
  }
  
  private static void a(Boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(255370);
    Object localObject1 = g.ah(PluginFinder.class);
    p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    localObject1 = ((PluginFinder)localObject1).getRedDotManager().asW("NotificationCenterLike");
    Object localObject2 = g.ah(PluginFinder.class);
    p.g(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
    localObject2 = ((PluginFinder)localObject2).getRedDotManager().asW("NotificationCenterComment");
    Object localObject3 = g.ah(PluginFinder.class);
    p.g(localObject3, "MMKernel.plugin(PluginFinder::class.java)");
    localObject3 = ((PluginFinder)localObject3).getRedDotManager().asW("NotificationCenterFollow");
    paramArrayOfBoolean[0] = Boolean.valueOf(a((bdo)localObject1));
    paramArrayOfBoolean[1] = Boolean.valueOf(a((bdo)localObject2));
    paramArrayOfBoolean[2] = Boolean.valueOf(a((bdo)localObject3));
    AppMethodBeat.o(255370);
  }
  
  private static boolean a(bdo parambdo)
  {
    return (parambdo != null) && (parambdo.count > 0);
  }
  
  private static o<Integer, Integer> b(Boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(255371);
    int j = 0;
    int i = 0;
    int m = -1;
    int k;
    for (int n = 0; j < 3; n = k)
    {
      int i1 = m;
      k = n;
      if (paramArrayOfBoolean[j].booleanValue())
      {
        n += 1;
        i1 = m;
        k = n;
        if (m == -1)
        {
          i1 = i;
          k = n;
        }
      }
      j += 1;
      i += 1;
      m = i1;
    }
    paramArrayOfBoolean = new o(Integer.valueOf(n), Integer.valueOf(m));
    AppMethodBeat.o(255371);
    return paramArrayOfBoolean;
  }
  
  private final int dHV()
  {
    AppMethodBeat.i(255369);
    Integer localInteger = (Integer)this.wtV.get(Integer.valueOf(1));
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(255369);
      return i;
    }
    AppMethodBeat.o(255369);
    return 0;
  }
  
  public final int dHU()
  {
    AppMethodBeat.i(255368);
    int i;
    if (this.wuI != -1)
    {
      i = this.wuI;
      AppMethodBeat.o(255368);
      return i;
    }
    int j = dHV();
    Boolean[] arrayOfBoolean2 = new Boolean[3];
    arrayOfBoolean2[0] = Boolean.FALSE;
    arrayOfBoolean2[1] = Boolean.FALSE;
    arrayOfBoolean2[2] = Boolean.FALSE;
    a(arrayOfBoolean2);
    o localo = b(arrayOfBoolean2);
    this.wuI = j;
    if (((Number)localo.first).intValue() == 0)
    {
      AppMethodBeat.o(255368);
      return j;
    }
    if ((j >= 0) && (j < 3))
    {
      i = 1;
      if (i == 0) {
        break label146;
      }
    }
    label146:
    for (Boolean[] arrayOfBoolean1 = arrayOfBoolean2;; arrayOfBoolean1 = null)
    {
      if ((arrayOfBoolean1 == null) || (!arrayOfBoolean2[j].booleanValue())) {
        break label151;
      }
      Log.i("Finder.FinderTabStateCacheVM", "red dot index == cachedIndex");
      AppMethodBeat.o(255368);
      return j;
      i = 0;
      break;
    }
    label151:
    if ((((Number)localo.first).intValue() == 2) || (((Number)localo.first).intValue() == 1))
    {
      this.wuI = ((Number)localo.second).intValue();
      i = ((Number)localo.second).intValue();
      AppMethodBeat.o(255368);
      return i;
    }
    AppMethodBeat.o(255368);
    return j;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStateCacheVM$Companion;", "", "()V", "TAG", "", "TYPE_NOTIFY_TAB", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTabStateCacheVM
 * JD-Core Version:    0.7.0.1
 */