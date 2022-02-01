package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache;", "Landroid/arch/lifecycle/ViewModel;", "()V", "caches", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "get", "onCleared", "", "resetCache", "store", "lastDataList", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTopicFeedCache
  extends ViewModel
{
  public static final FinderTopicFeedCache.a sdd;
  public ArrayList<BaseFinderFeed> sdc;
  
  static
  {
    AppMethodBeat.i(204464);
    sdd = new FinderTopicFeedCache.a((byte)0);
    AppMethodBeat.o(204464);
  }
  
  public final void ae()
  {
    AppMethodBeat.i(204463);
    super.ae();
    ArrayList localArrayList = this.sdc;
    if (localArrayList != null)
    {
      localArrayList.clear();
      AppMethodBeat.o(204463);
      return;
    }
    AppMethodBeat.o(204463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTopicFeedCache
 * JD-Core Version:    0.7.0.1
 */