package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedScrollBaseHandler;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "eventObserver", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "getEventObserver", "()Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isVideoPlayFinish", "", "()Z", "setVideoPlayFinish", "(Z)V", "lastFeedId", "", "getLastFeedId", "()J", "setLastFeedId", "(J)V", "lastFeedPos", "", "getLastFeedPos", "()I", "setLastFeedPos", "(I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "replayCount", "getReplayCount", "setReplayCount", "onAttach", "", "recycler", "onCenterFeedChange", "ev", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "onDetach", "onEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onVideoReplay", "feedId", "plugin-finder_release"})
public abstract class o
{
  private final MMActivity activity;
  RecyclerView jLl;
  FeedData xro;
  long xym;
  int xyn;
  int xyo;
  boolean xyp;
  public final d xyq;
  
  public o(MMActivity paramMMActivity)
  {
    this.activity = paramMMActivity;
    this.xyq = ((d)new a(this));
  }
  
  public void KS(long paramLong)
  {
    this.xyo += 1;
    this.xyp = true;
  }
  
  public abstract void a(h paramh);
  
  public final MMActivity getActivity()
  {
    return this.activity;
  }
  
  public void m(RecyclerView paramRecyclerView)
  {
    this.jLl = paramRecyclerView;
    paramRecyclerView = aj.Bnu;
    paramRecyclerView = aj.a.fZ((Context)this.activity);
    if (paramRecyclerView != null)
    {
      paramRecyclerView = aj.a(paramRecyclerView);
      if (paramRecyclerView != null) {
        paramRecyclerView.a(this.xyq);
      }
    }
  }
  
  public void onDetach()
  {
    Object localObject = aj.Bnu;
    localObject = aj.a.fZ((Context)this.activity);
    if (localObject != null)
    {
      localObject = aj.a((aj)localObject);
      if (localObject != null) {
        ((c)localObject).b(this.xyq);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderFeedScrollBaseHandler$eventObserver$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class a
    extends d
  {
    public final void a(b paramb)
    {
      AppMethodBeat.i(285787);
      p.k(paramb, "ev");
      p.k(paramb, "ev");
      if (((paramb instanceof h)) && ((((h)paramb).type == 0) || (((h)paramb).type == 5) || (((h)paramb).type == 4) || (((h)paramb).type == 7) || (((h)paramb).type == 10)))
      {
        if (this.xyr.xym != ((h)paramb).xrl)
        {
          this.xyr.xyo = 0;
          this.xyr.xyp = false;
          this.xyr.a((h)paramb);
          this.xyr.xym = ((h)paramb).xrl;
          this.xyr.xyn = ((h)paramb).xrm;
          this.xyr.xro = ((h)paramb).xro;
          AppMethodBeat.o(285787);
        }
      }
      else if (((paramb instanceof c.a)) && (((c.a)paramb).type == 2) && (((c.a)paramb).type == 2)) {
        this.xyr.KS(((c.a)paramb).feedId);
      }
      AppMethodBeat.o(285787);
    }
    
    public final boolean a(c paramc, b paramb)
    {
      AppMethodBeat.i(285788);
      p.k(paramc, "dispatcher");
      p.k(paramb, "event");
      if ((((paramb instanceof h)) && ((((h)paramb).type == 0) || (((h)paramb).type == 5) || (((h)paramb).type == 4) || (((h)paramb).type == 7) || (((h)paramb).type == 10))) || (((paramb instanceof c.a)) && (((c.a)paramb).type == 2)))
      {
        AppMethodBeat.o(285788);
        return true;
      }
      AppMethodBeat.o(285788);
      return false;
    }
    
    public final boolean dpw()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.o
 * JD-Core Version:    0.7.0.1
 */