package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.d;
import d.g.a.b;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;II)V", "actionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getViewActionCallback", "onViewPrepared", "", "plugin-finder_release"})
public abstract class e$b
  extends a.b
{
  private d KNP = (d)new a(this);
  
  public e$b(MMActivity paramMMActivity, e.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (a.a)parama, paramInt1, paramInt2);
  }
  
  public void clP()
  {
    c.a(c.agM(), (b)new b(this));
  }
  
  public d cma()
  {
    return this.KNP;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback$actionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class a
    implements d
  {
    a()
    {
      this.qvq = localObject.quj;
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197849);
      this.qvr.quj.at(this.qvr.qui + paramInt1, paramInt2);
      AppMethodBeat.o(197849);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197850);
      this.qvr.quj.au(this.qvr.qui + paramInt1, paramInt2);
      AppMethodBeat.o(197850);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197852);
      k.h(paramc, "reason");
      this.qvq.c(paramc);
      AppMethodBeat.o(197852);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197853);
      k.h(paramc, "reason");
      this.qvq.d(paramc);
      AppMethodBeat.o(197853);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(197848);
      this.qvr.quj.f(this.qvr.qui + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(197848);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(197851);
      this.qvq.onChanged();
      AppMethodBeat.o(197851);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<Void, y>
  {
    b(e.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.e.b
 * JD-Core Version:    0.7.0.1
 */