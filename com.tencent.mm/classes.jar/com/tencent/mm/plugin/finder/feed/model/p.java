package com.tencent.mm.plugin.finder.feed.model;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.model.cc;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/IFinderBatchSyncLoader;", "Id", "", "batchLoad", "", "ids", "", "Lkotlin/Pair;", "", "clearCache", "id", "type", "", "(Ljava/lang/Object;I)V", "getSyncData", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderCache;", "(Ljava/lang/Object;I)Lcom/tencent/mm/plugin/finder/feed/model/IFinderCache;", "onAttach", "generator", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "firstItemPos", "lastItemPos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestType", "onDetach", "onEventHappen", "ev", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onScrollEvent", "feeds", "requestLoad", "nonceId", "(Ljava/lang/Object;Ljava/lang/String;I)V", "setUxInfo", "uxInfo", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface p<Id>
{
  public abstract void a(b paramb);
  
  public abstract void a(b paramb, LinkedList<cc> paramLinkedList);
  
  public abstract void a(m<? super Integer, ? super Integer, ? extends LinkedList<cc>> paramm, RecyclerView paramRecyclerView, int paramInt);
  
  public abstract void fi(Id paramId);
  
  public abstract q fj(Id paramId);
  
  public abstract void onDetach();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.p
 * JD-Core Version:    0.7.0.1
 */