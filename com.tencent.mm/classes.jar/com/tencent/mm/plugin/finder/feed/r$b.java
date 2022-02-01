package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.d;
import d.g.a.b;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;II)V", "actionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getViewActionCallback", "onViewPrepared", "", "plugin-finder_release"})
public abstract class r$b
  extends b.b
{
  private d rim = (d)new a(this);
  
  public r$b(MMActivity paramMMActivity, r.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (b.a)parama, paramInt1, paramInt2);
  }
  
  public d cuQ()
  {
    return this.rim;
  }
  
  public void cuy()
  {
    c.a(c.aid(), (b)new b(this));
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback$actionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class a
    implements d
  {
    a()
    {
      this.rhB = localObject.rfT;
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201746);
      this.rin.rfT.at(this.rin.qpm + paramInt1, paramInt2);
      AppMethodBeat.o(201746);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201747);
      this.rin.rfT.au(this.rin.qpm + paramInt1, paramInt2);
      AppMethodBeat.o(201747);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201750);
      k.h(paramc, "reason");
      this.rhB.c(paramc);
      AppMethodBeat.o(201750);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201749);
      k.h(paramc, "reason");
      this.rhB.d(paramc);
      AppMethodBeat.o(201749);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(201745);
      this.rin.rfT.f(this.rin.qpm + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(201745);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(201748);
      this.rhB.onChanged();
      AppMethodBeat.o(201748);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<Void, y>
  {
    b(r.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.r.b
 * JD-Core Version:    0.7.0.1
 */