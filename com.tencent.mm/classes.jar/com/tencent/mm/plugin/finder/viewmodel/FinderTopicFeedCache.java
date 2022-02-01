package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache;", "Landroid/arch/lifecycle/ViewModel;", "()V", "caches", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "get", "onCleared", "", "resetCache", "store", "lastDataList", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTopicFeedCache
  extends ViewModel
{
  public static final a wuY;
  public ArrayList<BaseFinderFeed> wuX;
  
  static
  {
    AppMethodBeat.i(255397);
    wuY = new a((byte)0);
    AppMethodBeat.o(255397);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(255396);
    super.onCleared();
    ArrayList localArrayList = this.wuX;
    if (localArrayList != null)
    {
      localArrayList.clear();
      AppMethodBeat.o(255396);
      return;
    }
    AppMethodBeat.o(255396);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTopicFeedCache
 * JD-Core Version:    0.7.0.1
 */