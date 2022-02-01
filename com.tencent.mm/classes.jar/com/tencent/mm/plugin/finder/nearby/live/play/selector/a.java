package com.tencent.mm.plugin.finder.nearby.live.play.selector;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.nearby.live.play.e.b;
import java.util.HashSet;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/selector/ILiveAutoPlaySelector;", "", "findAutoPlayItem", "", "layoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "firstVisibleItemPos", "lastVisibleItemPos", "findAutoStopItem", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager$LivePreviewData;", "Lkotlin/collections/HashSet;", "curLivePreviewDataSet", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract HashSet<e.b> a(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, HashSet<e.b> paramHashSet);
  
  public abstract int[] a(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.selector.a
 * JD-Core Version:    0.7.0.1
 */