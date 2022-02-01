package com.tencent.mm.plugin.finder.feed;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderExposeChangedEventListener;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.view.recyclerview.i;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1
  extends FinderExposeChangedEventListener
{
  private String tag;
  
  FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1(an.b paramb)
  {
    AppMethodBeat.i(165733);
    this.tag = an.b.d(this.AYj);
    AppMethodBeat.o(165733);
  }
  
  public final void a(long paramLong, brh parambrh)
  {
    AppMethodBeat.i(165732);
    Object localObject1 = an.b.b(this.AYj);
    if (localObject1 != null)
    {
      localObject1 = ((an.c)localObject1).getRecyclerView();
      Object localObject2 = ((RecyclerView)localObject1).getAdapter();
      if (localObject2 == null)
      {
        parambrh = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<@[FlexibleNullability] androidx.recyclerview.widget.RecyclerView.ViewHolder?>");
        AppMethodBeat.o(165732);
        throw parambrh;
      }
      localObject2 = i.c((i)localObject2, paramLong);
      if (localObject2 != null)
      {
        int i = ((RecyclerView.v)localObject2).KJ();
        localObject1 = ((RecyclerView)localObject1).getAdapter();
        if (localObject1 != null) {
          ((RecyclerView.a)localObject1).t(i, new r(Integer.valueOf(1), parambrh));
        }
      }
    }
    AppMethodBeat.o(165732);
  }
  
  public final String getTag()
  {
    return this.tag;
  }
  
  public final FinderItem np(long paramLong)
  {
    AppMethodBeat.i(165731);
    Object localObject1 = an.b.b(this.AYj);
    if (localObject1 != null)
    {
      Object localObject2 = ((an.c)localObject1).getRecyclerView();
      localObject1 = this.AYj;
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<@[FlexibleNullability] androidx.recyclerview.widget.RecyclerView.ViewHolder?>");
        AppMethodBeat.o(165731);
        throw ((Throwable)localObject1);
      }
      localObject2 = i.c((i)localObject2, paramLong);
      if (localObject2 != null)
      {
        int i = ((RecyclerView.v)localObject2).KJ();
        localObject1 = (cc)((an.b)localObject1).getFeedLoader().safeGet(i);
        if ((localObject1 instanceof BaseFinderFeed))
        {
          localObject1 = ((BaseFinderFeed)localObject1).feedObject;
          AppMethodBeat.o(165731);
          return localObject1;
        }
      }
    }
    AppMethodBeat.o(165731);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderProfileTimelineContract.ProfileTimelinePresenter.feedExposeInfoChangeListener.1
 * JD-Core Version:    0.7.0.1
 */