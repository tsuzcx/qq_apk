package com.tencent.mm.plugin.finder.feed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.event.c.a;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedScrollBaseHandler;", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "eventObserver", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "getEventObserver", "()Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isVideoPlayFinish", "", "()Z", "setVideoPlayFinish", "(Z)V", "lastFeedId", "", "getLastFeedId", "()J", "setLastFeedId", "(J)V", "lastFeedPos", "", "getLastFeedPos", "()I", "setLastFeedPos", "(I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "replayCount", "getReplayCount", "setReplayCount", "onAttach", "", "recycler", "onCenterFeedChange", "ev", "Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "onDetach", "onEvent", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onVideoPlayOneMinute", "feedId", "onVideoReplay", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class n
{
  FeedData AOy;
  long AVm;
  int AVn;
  int AVo;
  boolean AVp;
  public final d AVq;
  private final MMActivity activity;
  RecyclerView mkw;
  
  public n(MMActivity paramMMActivity)
  {
    this.activity = paramMMActivity;
    this.AVq = ((d)new a(this));
  }
  
  public abstract void a(h paramh);
  
  public final MMActivity getActivity()
  {
    return this.activity;
  }
  
  public void nr(long paramLong)
  {
    this.AVo += 1;
    this.AVp = true;
  }
  
  public void ns(long paramLong) {}
  
  public void onDetach()
  {
    Object localObject = k.aeZF;
    localObject = ((bn)k.d((AppCompatActivity)this.activity).cq(bn.class)).Vm(-1);
    if (localObject != null) {
      ((c)localObject).b(this.AVq);
    }
  }
  
  public void q(RecyclerView paramRecyclerView)
  {
    this.mkw = paramRecyclerView;
    paramRecyclerView = k.aeZF;
    paramRecyclerView = ((bn)k.d((AppCompatActivity)this.activity).cq(bn.class)).Vm(-1);
    if (paramRecyclerView != null) {
      paramRecyclerView.a(this.AVq);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderFeedScrollBaseHandler$eventObserver$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends d
  {
    a(n paramn) {}
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(363011);
      s.u(paramb, "ev");
      s.u(paramb, "ev");
      if (((paramb instanceof h)) && ((((h)paramb).type == 0) || (((h)paramb).type == 5) || (((h)paramb).type == 4) || (((h)paramb).type == 7) || (((h)paramb).type == 10)))
      {
        if (this.AVr.AVm != ((h)paramb).AOv)
        {
          this.AVr.AVo = 0;
          this.AVr.AVp = false;
          this.AVr.a((h)paramb);
          this.AVr.AVm = ((h)paramb).AOv;
          this.AVr.AVn = ((h)paramb).AOw;
          this.AVr.AOy = ((h)paramb).AOy;
          AppMethodBeat.o(363011);
        }
      }
      else if ((paramb instanceof c.a))
      {
        if (((c.a)paramb).type == 2)
        {
          this.AVr.nr(((c.a)paramb).feedId);
          AppMethodBeat.o(363011);
          return;
        }
        if ((((c.a)paramb).type == 3) && (((c.a)paramb).offset == 60)) {
          this.AVr.ns(((c.a)paramb).feedId);
        }
      }
      AppMethodBeat.o(363011);
    }
    
    public final boolean a(c paramc, b paramb)
    {
      AppMethodBeat.i(363022);
      s.u(paramc, "dispatcher");
      s.u(paramb, "event");
      if ((((paramb instanceof h)) && ((((h)paramb).type == 0) || (((h)paramb).type == 5) || (((h)paramb).type == 4) || (((h)paramb).type == 7) || (((h)paramb).type == 10))) || (((paramb instanceof c.a)) && ((((c.a)paramb).type == 2) || (((c.a)paramb).type == 3))))
      {
        AppMethodBeat.o(363022);
        return true;
      }
      AppMethodBeat.o(363022);
      return false;
    }
    
    public final boolean dXA()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.n
 * JD-Core Version:    0.7.0.1
 */