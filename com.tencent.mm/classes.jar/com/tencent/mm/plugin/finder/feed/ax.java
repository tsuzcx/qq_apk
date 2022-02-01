package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.preload.tabPreload.c;
import com.tencent.mm.plugin.finder.preload.tabPreload.g;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.a;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineHotCacheControl;", "", "()V", "clearCache", "", "tabType", "", "isRecycle", "", "hasPreload", "notShowCacheOnInit", "notShowCacheOnVisible", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "notShowCacheWhenLoading", "notShowCacheWhenPreloadExist", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
{
  public static final ax AZe;
  
  static
  {
    AppMethodBeat.i(363005);
    AZe = new ax();
    AppMethodBeat.o(363005);
  }
  
  public static boolean NG(int paramInt)
  {
    AppMethodBeat.i(362976);
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(362976);
      return false;
    case 3: 
      locald = d.FAy;
      if (((Number)d.eXb().bmg()).intValue() == 1)
      {
        AppMethodBeat.o(362976);
        return true;
      }
      AppMethodBeat.o(362976);
      return false;
    case 1: 
      locald = d.FAy;
      if (((Number)d.eXd().bmg()).intValue() == 1)
      {
        AppMethodBeat.o(362976);
        return true;
      }
      AppMethodBeat.o(362976);
      return false;
    }
    d locald = d.FAy;
    if (((Number)d.eWZ().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(362976);
      return true;
    }
    AppMethodBeat.o(362976);
    return false;
  }
  
  public static boolean NH(int paramInt)
  {
    AppMethodBeat.i(362983);
    switch (paramInt)
    {
    case 2: 
    default: 
      AppMethodBeat.o(362983);
      return false;
    case 3: 
      locald = d.FAy;
      if (((Number)d.eXc().bmg()).intValue() == 1)
      {
        AppMethodBeat.o(362983);
        return true;
      }
      AppMethodBeat.o(362983);
      return false;
    case 1: 
      locald = d.FAy;
      if (((Number)d.eXe().bmg()).intValue() == 1)
      {
        AppMethodBeat.o(362983);
        return true;
      }
      AppMethodBeat.o(362983);
      return false;
    }
    d locald = d.FAy;
    if (((Number)d.eXa().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(362983);
      return true;
    }
    AppMethodBeat.o(362983);
    return false;
  }
  
  public static boolean NI(int paramInt)
  {
    AppMethodBeat.i(362993);
    Object localObject = k.aeZF;
    localObject = ((c)k.cn(PluginFinder.class).q(c.class)).Rn(paramInt);
    if (localObject == null) {
      localObject = null;
    }
    while (localObject != null)
    {
      AppMethodBeat.o(362993);
      return true;
      localObject = ((g)localObject).EWk;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((g.a)localObject).BeG;
      }
    }
    AppMethodBeat.o(362993);
    return false;
  }
  
  public static void ecC()
  {
    AppMethodBeat.i(362998);
    Object localObject = k.aeZF;
    localObject = ((c)k.cn(PluginFinder.class).q(c.class)).Rn(4);
    if (localObject != null) {
      ((g)localObject).ta(false);
    }
    AppMethodBeat.o(362998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ax
 * JD-Core Version:    0.7.0.1
 */