package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.k;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;II)V", "actionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getViewActionCallback", "onViewCallPreFinishLoadMore", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onViewCallPreFinishRefresh", "onViewPrepared", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ae$b
  extends b.b
{
  private k AWW = (k)new a(this);
  
  public ae$b(MMActivity paramMMActivity, ae.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (b.a)parama, paramInt1, paramInt2);
  }
  
  public void ebi()
  {
    d.a(d.bbX(), (b)new b(this));
  }
  
  public k ecd()
  {
    return this.AWW;
  }
  
  public void j(RefreshLoadMoreLayout.d<Object> paramd)
  {
    s.u(paramd, "reason");
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback$actionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements k
  {
    a(ae.b paramb)
    {
      AppMethodBeat.i(363494);
      this.AVe = this.AWX.ATx;
      AppMethodBeat.o(363494);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(363499);
      this.AVe.onChanged();
      AppMethodBeat.o(363499);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363513);
      this.AWX.ATx.onItemRangeChanged(this.AWX.zJM + paramInt1, paramInt2);
      AppMethodBeat.o(363513);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(363518);
      this.AWX.ATx.onItemRangeChanged(this.AWX.zJM + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(363518);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363522);
      this.AWX.ATx.onItemRangeInserted(this.AWX.zJM + paramInt1, paramInt2);
      AppMethodBeat.o(363522);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363527);
      this.AWX.ATx.onItemRangeRemoved(this.AWX.zJM + paramInt1, paramInt2);
      AppMethodBeat.o(363527);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363535);
      s.u(paramd, "reason");
      s.u(paramd, "reason");
      AppMethodBeat.o(363535);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363503);
      s.u(paramd, "reason");
      this.AVe.onPreFinishLoadMoreSmooth(paramd);
      AppMethodBeat.o(363503);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363540);
      s.u(paramd, "reason");
      this.AWX.j(paramd);
      AppMethodBeat.o(363540);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Void;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Void, ah>
  {
    b(ae.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ae.b
 * JD-Core Version:    0.7.0.1
 */