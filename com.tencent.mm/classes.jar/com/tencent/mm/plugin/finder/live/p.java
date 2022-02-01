package com.tencent.mm.plugin.finder.live;

import android.view.ViewGroup;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/IFinderLivePlayViewSelector;", "", "check", "", "setBaseData", "view", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "dataSet", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "selectCallback", "Lcom/tencent/mm/plugin/finder/live/SelectorResult;", "", "Landroid/view/ViewGroup;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "plugin-finder_release"})
public abstract interface p
{
  public abstract void a(WxRecyclerView paramWxRecyclerView, bu parambu, x<Integer, ViewGroup, y> paramx);
  
  public abstract void dwn();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.p
 * JD-Core Version:    0.7.0.1
 */