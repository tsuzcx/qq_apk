package com.tencent.mm.plugin.finder.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache;", "Landroid/arch/lifecycle/ViewModel;", "()V", "caches", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "get", "onCleared", "", "resetCache", "store", "lastDataList", "Cache", "Companion", "plugin-finder_release"})
public final class FinderTopicFeedCache
  extends ViewModel
{
  public static final a LhA;
  public ArrayList<BaseFinderFeed> Lhz;
  
  static
  {
    AppMethodBeat.i(200339);
    LhA = new a((byte)0);
    AppMethodBeat.o(200339);
  }
  
  public final void ae()
  {
    AppMethodBeat.i(200338);
    super.ae();
    ArrayList localArrayList = this.Lhz;
    if (localArrayList != null)
    {
      localArrayList.clear();
      AppMethodBeat.o(200338);
      return;
    }
    AppMethodBeat.o(200338);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/FinderTopicFeedCache$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderTopicFeedCache
 * JD-Core Version:    0.7.0.1
 */