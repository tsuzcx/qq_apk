package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;II)V", "actionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getViewActionCallback", "onViewCallPreFinishLoadMore", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onViewCallPreFinishRefresh", "onViewPrepared", "plugin-finder_release"})
public abstract class v$b
  extends b.b
{
  private j tOK = (j)new a(this);
  
  public v$b(MMActivity paramMMActivity, v.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (b.a)parama, paramInt1, paramInt2);
  }
  
  public void d(RefreshLoadMoreLayout.c<Object> paramc)
  {
    p.h(paramc, "reason");
  }
  
  public void dbY()
  {
    d.a(d.aBx(), (b)new b(this));
  }
  
  public j dcI()
  {
    return this.tOK;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback$actionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class a
    implements j
  {
    a()
    {
      this.tNU = localObject.tLS;
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(243990);
      this.tNU.onChanged();
      AppMethodBeat.o(243990);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243984);
      this.tOL.tLS.onItemRangeChanged(this.tOL.sHN + paramInt1, paramInt2);
      AppMethodBeat.o(243984);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(243985);
      this.tOL.tLS.onItemRangeChanged(this.tOL.sHN + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(243985);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243986);
      this.tOL.tLS.onItemRangeInserted(this.tOL.sHN + paramInt1, paramInt2);
      AppMethodBeat.o(243986);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243987);
      this.tOL.tLS.onItemRangeRemoved(this.tOL.sHN + paramInt1, paramInt2);
      AppMethodBeat.o(243987);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(243988);
      p.h(paramc, "reason");
      p.h(paramc, "reason");
      AppMethodBeat.o(243988);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(243991);
      p.h(paramc, "reason");
      this.tNU.onPreFinishLoadMoreSmooth(paramc);
      AppMethodBeat.o(243991);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(243989);
      p.h(paramc, "reason");
      this.tOL.d(paramc);
      AppMethodBeat.o(243989);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  static final class b
    extends q
    implements b<Void, x>
  {
    b(v.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.v.b
 * JD-Core Version:    0.7.0.1
 */