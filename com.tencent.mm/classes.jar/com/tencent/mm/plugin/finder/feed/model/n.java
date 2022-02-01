package com.tencent.mm.plugin.finder.feed.model;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.model.bu;
import java.util.LinkedList;
import kotlin.g.a.m;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/IFinderBatchSyncLoader;", "Id", "", "batchLoad", "", "ids", "", "Lkotlin/Pair;", "", "clearCache", "id", "type", "", "(Ljava/lang/Object;I)V", "getSyncData", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderCache;", "(Ljava/lang/Object;I)Lcom/tencent/mm/plugin/finder/feed/model/IFinderCache;", "onAttach", "generator", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "firstItemPos", "lastItemPos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestType", "onDetach", "onEventHappen", "ev", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onScrollEvent", "feeds", "requestLoad", "nonceId", "(Ljava/lang/Object;Ljava/lang/String;I)V", "setUxInfo", "uxInfo", "plugin-finder-base_release"})
public abstract interface n<Id>
{
  public abstract void a(b paramb);
  
  public abstract void a(b paramb, LinkedList<bu> paramLinkedList);
  
  public abstract void a(m<? super Integer, ? super Integer, ? extends LinkedList<bu>> paramm, RecyclerView paramRecyclerView, int paramInt);
  
  public abstract void e(Id paramId, String paramString);
  
  public abstract void onDetach();
  
  public abstract void s(Id paramId, int paramInt);
  
  public abstract o t(Id paramId, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.n
 * JD-Core Version:    0.7.0.1
 */