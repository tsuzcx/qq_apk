package com.tencent.mm.plugin.finder.feed;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderExposeChangedEventListener;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTimelinePresenter$feedExposeInfoChangeListener$1
  extends FinderExposeChangedEventListener
{
  private String tag;
  
  FinderTimelinePresenter$feedExposeInfoChangeListener$1(bg parambg)
  {
    AppMethodBeat.i(362684);
    this.tag = bg.f(this.BaB);
    AppMethodBeat.o(362684);
  }
  
  public final void a(long paramLong, brh parambrh)
  {
    AppMethodBeat.i(165868);
    Object localObject1 = bg.g(this.BaB);
    if (localObject1 != null)
    {
      localObject1 = ((aw.b)localObject1).getRecyclerView();
      if (localObject1 != null)
      {
        Object localObject2 = ((RecyclerView)localObject1).getAdapter();
        if (localObject2 == null)
        {
          parambrh = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<@[FlexibleNullability] androidx.recyclerview.widget.RecyclerView.ViewHolder?>");
          AppMethodBeat.o(165868);
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
    }
    AppMethodBeat.o(165868);
  }
  
  public final String getTag()
  {
    return this.tag;
  }
  
  public final FinderItem np(long paramLong)
  {
    AppMethodBeat.i(165867);
    Object localObject1 = bg.g(this.BaB);
    if (localObject1 != null)
    {
      Object localObject2 = ((aw.b)localObject1).getRecyclerView();
      if (localObject2 != null)
      {
        localObject1 = this.BaB;
        Object localObject3 = ((RecyclerView)localObject2).getAdapter();
        if (localObject3 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<@[FlexibleNullability] androidx.recyclerview.widget.RecyclerView.ViewHolder?>");
          AppMethodBeat.o(165867);
          throw ((Throwable)localObject1);
        }
        localObject3 = i.c((i)localObject3, paramLong);
        if (localObject3 != null)
        {
          int i = ((RecyclerView.v)localObject3).KJ();
          localObject2 = ((RecyclerView)localObject2).getAdapter();
          if (localObject2 == null)
          {
            localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<@[FlexibleNullability] androidx.recyclerview.widget.RecyclerView.ViewHolder?>");
            AppMethodBeat.o(165867);
            throw ((Throwable)localObject1);
          }
          int j = ((i)localObject2).agOb.size();
          localObject1 = (cc)((bg)localObject1).AZs.safeGet(i - j);
          if ((localObject1 instanceof BaseFinderFeed))
          {
            localObject1 = ((BaseFinderFeed)localObject1).feedObject;
            AppMethodBeat.o(165867);
            return localObject1;
          }
        }
      }
    }
    AppMethodBeat.o(165867);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderTimelinePresenter.feedExposeInfoChangeListener.1
 * JD-Core Version:    0.7.0.1
 */