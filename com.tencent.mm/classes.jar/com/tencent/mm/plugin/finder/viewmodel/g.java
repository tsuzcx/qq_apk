package com.tencent.mm.plugin.finder.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.n;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStateCacheVM;", "Lcom/tencent/mm/ui/component/UIComponentPlugin;", "Lcom/tencent/mm/plugin/finder/PluginFinder;", "()V", "cachedTabIndex", "", "cachedTimeStamp", "", "caches", "Ljava/util/concurrent/ConcurrentHashMap;", "getCachedIndex", "type", "getEnterTabIndex", "getRedDotCount", "Lkotlin/Pair;", "redDotFlags", "", "", "([Ljava/lang/Boolean;)Lkotlin/Pair;", "isExistRedDot", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "setRedDotFlags", "", "([Ljava/lang/Boolean;)V", "store", "tabIndex", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class g
  extends n<PluginFinder>
{
  public static final a GLh;
  private final ConcurrentHashMap<Integer, Integer> GKl;
  private int GLi;
  
  static
  {
    AppMethodBeat.i(337197);
    GLh = new a((byte)0);
    AppMethodBeat.o(337197);
  }
  
  public g()
  {
    AppMethodBeat.i(337178);
    this.GKl = new ConcurrentHashMap();
    this.GLi = -1;
    AppMethodBeat.o(337178);
  }
  
  protected static boolean c(bxq parambxq)
  {
    return (parambxq != null) && (parambxq.count > 0);
  }
  
  public final void UZ(int paramInt)
  {
    AppMethodBeat.i(337207);
    Log.i("Finder.FinderTagCacheVm", "type=1 tabIndex=" + paramInt + ' ');
    ((Map)this.GKl).put(Integer.valueOf(1), Integer.valueOf(paramInt));
    this.GLi = -1;
    AppMethodBeat.o(337207);
  }
  
  public int Va(int paramInt)
  {
    int i2 = 0;
    AppMethodBeat.i(337223);
    if (this.GLi != -1)
    {
      paramInt = this.GLi;
      AppMethodBeat.o(337223);
      return paramInt;
    }
    Object localObject = (Integer)this.GKl.get(Integer.valueOf(paramInt));
    if (localObject == null) {}
    Boolean[] arrayOfBoolean;
    int m;
    int n;
    for (int i = 0;; i = ((Integer)localObject).intValue())
    {
      arrayOfBoolean = new Boolean[3];
      arrayOfBoolean[0] = Boolean.FALSE;
      arrayOfBoolean[1] = Boolean.FALSE;
      arrayOfBoolean[2] = Boolean.FALSE;
      a(arrayOfBoolean);
      int j = 0;
      paramInt = 0;
      m = -1;
      int k;
      for (n = 0; j < 3; n = k)
      {
        int i1 = m;
        k = n;
        if (arrayOfBoolean[j].booleanValue())
        {
          n += 1;
          i1 = m;
          k = n;
          if (m == -1)
          {
            i1 = paramInt;
            k = n;
          }
        }
        j += 1;
        paramInt += 1;
        m = i1;
      }
    }
    r localr = new r(Integer.valueOf(n), Integer.valueOf(m));
    this.GLi = i;
    if (((Number)localr.bsC).intValue() == 0)
    {
      AppMethodBeat.o(337223);
      return i;
    }
    paramInt = i2;
    if (i >= 0)
    {
      paramInt = i2;
      if (i < 3) {
        paramInt = 1;
      }
    }
    if (paramInt != 0) {}
    for (localObject = arrayOfBoolean; (localObject != null) && (arrayOfBoolean[i].booleanValue()); localObject = null)
    {
      Log.i("Finder.FinderTabStateCacheVM", "red dot index == cachedIndex");
      AppMethodBeat.o(337223);
      return i;
    }
    if ((((Number)localr.bsC).intValue() == 2) || (((Number)localr.bsC).intValue() == 1))
    {
      this.GLi = ((Number)localr.bsD).intValue();
      paramInt = ((Number)localr.bsD).intValue();
      AppMethodBeat.o(337223);
      return paramInt;
    }
    AppMethodBeat.o(337223);
    return i;
  }
  
  protected void a(Boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(337234);
    s.u(paramArrayOfBoolean, "redDotFlags");
    bxq localbxq1 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("NotificationCenterLike");
    bxq localbxq2 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("NotificationCenterComment");
    bxq localbxq3 = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp("NotificationCenterFollow");
    paramArrayOfBoolean[0] = Boolean.valueOf(c(localbxq1));
    paramArrayOfBoolean[1] = Boolean.valueOf(c(localbxq2));
    paramArrayOfBoolean[2] = Boolean.valueOf(c(localbxq3));
    AppMethodBeat.o(337234);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStateCacheVM$Companion;", "", "()V", "TAG", "", "TYPE_NOTIFY_TAB", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.g
 * JD-Core Version:    0.7.0.1
 */