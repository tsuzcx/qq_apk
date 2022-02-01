package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;II)V", "actionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getViewActionCallback", "onViewCallPreFinishLoadMore", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onViewCallPreFinishRefresh", "onViewPrepared", "plugin-finder_release"})
public abstract class aa$b
  extends b.b
{
  private j xzw = (j)new a(this);
  
  public aa$b(MMActivity paramMMActivity, aa.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (b.a)parama, paramInt1, paramInt2);
  }
  
  public void dsm()
  {
    d.a(d.aJa(), (b)new b(this));
  }
  
  public j dtb()
  {
    return this.xzw;
  }
  
  public void h(RefreshLoadMoreLayout.c<Object> paramc)
  {
    p.k(paramc, "reason");
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback$actionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class a
    implements j
  {
    a()
    {
      this.xxU = localObject.xvJ;
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(273236);
      this.xxU.onChanged();
      AppMethodBeat.o(273236);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(273230);
      this.xzx.xvJ.onItemRangeChanged(this.xzx.wnI + paramInt1, paramInt2);
      AppMethodBeat.o(273230);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(273231);
      this.xzx.xvJ.onItemRangeChanged(this.xzx.wnI + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(273231);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(273232);
      this.xzx.xvJ.onItemRangeInserted(this.xzx.wnI + paramInt1, paramInt2);
      AppMethodBeat.o(273232);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(273233);
      this.xzx.xvJ.onItemRangeRemoved(this.xzx.wnI + paramInt1, paramInt2);
      AppMethodBeat.o(273233);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(273234);
      p.k(paramc, "reason");
      p.k(paramc, "reason");
      AppMethodBeat.o(273234);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(273237);
      p.k(paramc, "reason");
      this.xxU.onPreFinishLoadMoreSmooth(paramc);
      AppMethodBeat.o(273237);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(273235);
      p.k(paramc, "reason");
      this.xzx.h(paramc);
      AppMethodBeat.o(273235);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  static final class b
    extends q
    implements b<Void, x>
  {
    b(aa.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aa.b
 * JD-Core Version:    0.7.0.1
 */