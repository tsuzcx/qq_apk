package com.tencent.mm.plugin.finder.profile.uihandler;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uihandler/FinderUiStyleManager;", "K", "T", "Landroid/view/View;", "", "()V", "groups", "", "", "Lcom/tencent/mm/plugin/finder/profile/uihandler/IUiStyleActionHandler;", "getHandler", "groupName", "handlerName", "", "(Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/profile/uihandler/IUiStyleActionHandler;", "register", "", "handler", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/finder/profile/uihandler/IUiStyleActionHandler;)V", "handlers", "", "(Ljava/lang/Object;Ljava/util/Set;)V", "unRegister", "update", "(Ljava/lang/Object;)V", "Builder", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a<K, T extends View>
{
  public static final a FfW;
  public final Map<K, Set<b<T>>> FfX;
  
  static
  {
    AppMethodBeat.i(348431);
    FfW = new a((byte)0);
    AppMethodBeat.o(348431);
  }
  
  public a()
  {
    AppMethodBeat.i(348417);
    this.FfX = ((Map)new LinkedHashMap());
    AppMethodBeat.o(348417);
  }
  
  private void a(K paramK, b<T> paramb)
  {
    AppMethodBeat.i(348426);
    s.u(paramb, "handler");
    Log.i("Finder.ProfileUiStyleConfig", "groupName:" + paramK + " handler:" + paramb);
    if (this.FfX.containsKey(paramK))
    {
      paramK = (Set)this.FfX.get(paramK);
      if (paramK != null)
      {
        paramK.add(paramb);
        AppMethodBeat.o(348426);
      }
    }
    else
    {
      Map localMap = this.FfX;
      HashSet localHashSet = new HashSet();
      localHashSet.add(paramb);
      localMap.put(paramK, localHashSet);
    }
    AppMethodBeat.o(348426);
  }
  
  public final void a(K paramK, Set<? extends b<T>> paramSet)
  {
    AppMethodBeat.i(348442);
    s.u(paramSet, "handlers");
    paramSet = ((Iterable)paramSet).iterator();
    while (paramSet.hasNext()) {
      a(paramK, (b)paramSet.next());
    }
    AppMethodBeat.o(348442);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uihandler/FinderUiStyleManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uihandler.a
 * JD-Core Version:    0.7.0.1
 */