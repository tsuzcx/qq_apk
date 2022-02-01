package com.tencent.mm.plugin.findersdk.a;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.model.q;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bkk;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "", "clearCache", "", "id", "", "type", "", "getCacheInfo", "Lcom/tencent/mm/plugin/finder/feed/model/IFinderCache;", "getEventObserver", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "getOrRequestNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "userName", "", "notifyWithCache", "onAttach", "getData", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "firstItemPos", "lastItemPos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetach", "requestLoad", "feedId", "nonceId", "(Ljava/lang/Long;Ljava/lang/String;I)V", "requestSignNoticeInfo", "(Ljava/lang/Long;Ljava/lang/String;)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface as
{
  public abstract void a(Long paramLong, String paramString);
  
  public abstract void a(m<? super Integer, ? super Integer, ? extends LinkedList<cc>> paramm, RecyclerView paramRecyclerView);
  
  public abstract bkk avW(String paramString);
  
  public abstract void avX(String paramString);
  
  public abstract d edV();
  
  public abstract q nE(long paramLong);
  
  public abstract void nF(long paramLong);
  
  public abstract void onDetach();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.as
 * JD-Core Version:    0.7.0.1
 */