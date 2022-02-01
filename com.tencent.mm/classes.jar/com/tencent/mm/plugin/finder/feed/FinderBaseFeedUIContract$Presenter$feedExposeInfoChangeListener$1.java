package com.tencent.mm.plugin.finder.feed;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderExposeChangedEventListener;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1
  extends FinderExposeChangedEventListener
{
  private String tag;
  
  FinderBaseFeedUIContract$Presenter$feedExposeInfoChangeListener$1(b.a parama)
  {
    AppMethodBeat.i(165612);
    this.tag = this.ATt.getTAG();
    AppMethodBeat.o(165612);
  }
  
  public final void a(long paramLong, brh parambrh)
  {
    AppMethodBeat.i(165611);
    Object localObject1 = this.ATt.ATo;
    if (localObject1 != null)
    {
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView();
      Object localObject2 = ((RecyclerView)localObject1).getAdapter();
      if (localObject2 == null)
      {
        parambrh = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<@[FlexibleNullability] androidx.recyclerview.widget.RecyclerView.ViewHolder?>");
        AppMethodBeat.o(165611);
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
    AppMethodBeat.o(165611);
  }
  
  public final String getTag()
  {
    return this.tag;
  }
  
  public final FinderItem np(long paramLong)
  {
    AppMethodBeat.i(165610);
    Object localObject1 = this.ATt.ATo;
    if (localObject1 != null)
    {
      Object localObject2 = ((b.b)localObject1).ATx.getRecyclerView();
      localObject1 = this.ATt;
      localObject2 = ((RecyclerView)localObject2).getAdapter();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<@[FlexibleNullability] androidx.recyclerview.widget.RecyclerView.ViewHolder?>");
        AppMethodBeat.o(165610);
        throw ((Throwable)localObject1);
      }
      localObject2 = i.c((i)localObject2, paramLong);
      if (localObject2 != null)
      {
        int i = ((RecyclerView.v)localObject2).KJ();
        localObject2 = ((b.a)localObject1).ATo;
        s.checkNotNull(localObject2);
        localObject1 = ((b.a)localObject1).NC(i - ((b.b)localObject2).zJM);
        if ((localObject1 instanceof BaseFinderFeed))
        {
          localObject1 = ((BaseFinderFeed)localObject1).feedObject;
          AppMethodBeat.o(165610);
          return localObject1;
        }
      }
    }
    AppMethodBeat.o(165610);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderBaseFeedUIContract.Presenter.feedExposeInfoChangeListener.1
 * JD-Core Version:    0.7.0.1
 */