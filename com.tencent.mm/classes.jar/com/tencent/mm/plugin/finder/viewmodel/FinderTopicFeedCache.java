package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache;", "Landroid/arch/lifecycle/ViewModel;", "()V", "caches", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "get", "onCleared", "", "resetCache", "store", "lastDataList", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTopicFeedCache
  extends ViewModel
{
  public static final a tls;
  public ArrayList<BaseFinderFeed> tlr;
  
  static
  {
    AppMethodBeat.i(206092);
    tls = new a((byte)0);
    AppMethodBeat.o(206092);
  }
  
  public final void af()
  {
    AppMethodBeat.i(206091);
    super.af();
    ArrayList localArrayList = this.tlr;
    if (localArrayList != null)
    {
      localArrayList.clear();
      AppMethodBeat.o(206091);
      return;
    }
    AppMethodBeat.o(206091);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTopicFeedCache
 * JD-Core Version:    0.7.0.1
 */