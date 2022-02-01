package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.d;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;II)V", "actionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getViewActionCallback", "onViewPrepared", "", "plugin-finder_release"})
public abstract class u$b
  extends a.b
{
  private d rWs = (d)new a(this);
  
  public u$b(MMActivity paramMMActivity, u.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (a.a)parama, paramInt1, paramInt2);
  }
  
  public void cAK()
  {
    c.a(c.akP(), (b)new b(this));
  }
  
  public d cBh()
  {
    return this.rWs;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback$actionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class a
    implements d
  {
    a()
    {
      this.rVH = localObject.rTF;
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201964);
      this.rWt.rTF.au(this.rWt.qYl + paramInt1, paramInt2);
      AppMethodBeat.o(201964);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201965);
      this.rWt.rTF.av(this.rWt.qYl + paramInt1, paramInt2);
      AppMethodBeat.o(201965);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201968);
      p.h(paramc, "reason");
      this.rVH.c(paramc);
      AppMethodBeat.o(201968);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201967);
      p.h(paramc, "reason");
      this.rVH.d(paramc);
      AppMethodBeat.o(201967);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(201963);
      this.rWt.rTF.f(this.rWt.qYl + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(201963);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(201966);
      this.rVH.onChanged();
      AppMethodBeat.o(201966);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke"})
  static final class b
    extends q
    implements b<Void, z>
  {
    b(u.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.u.b
 * JD-Core Version:    0.7.0.1
 */