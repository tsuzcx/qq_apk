package com.tencent.mm.plugin.finder.viewmodel;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache;", "Landroidx/lifecycle/ViewModel;", "()V", "caches", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "get", "onCleared", "", "resetCache", "store", "lastDataList", "Cache", "Companion", "plugin-finder_release"})
public final class i
  extends x
{
  public static final a Bhw;
  public ArrayList<BaseFinderFeed> Bhv;
  
  static
  {
    AppMethodBeat.i(290135);
    Bhw = new a((byte)0);
    AppMethodBeat.o(290135);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(290133);
    super.onCleared();
    ArrayList localArrayList = this.Bhv;
    if (localArrayList != null)
    {
      localArrayList.clear();
      AppMethodBeat.o(290133);
      return;
    }
    AppMethodBeat.o(290133);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.i
 * JD-Core Version:    0.7.0.1
 */