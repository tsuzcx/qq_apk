package com.tencent.mm.plugin.finder.feed;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.view.decoration.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;II)V", "myActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getMyActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setMyActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getViewActionCallback", "onItemChange", "", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "Companion", "plugin-finder_release"})
public final class i$b
  extends u.b
{
  private static final String TAG = "Finder.FinderFeedDetailRelUIContract.ViewCallback";
  public static final i.b.a sem;
  private com.tencent.mm.view.d sel;
  
  static
  {
    AppMethodBeat.i(202254);
    sem = new i.b.a((byte)0);
    TAG = "Finder.FinderFeedDetailRelUIContract.ViewCallback";
    AppMethodBeat.o(202254);
  }
  
  public i$b(MMActivity paramMMActivity, i.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (u.a)parama, paramInt1, paramInt2);
    AppMethodBeat.i(202253);
    this.sel = ((com.tencent.mm.view.d)new b(this));
    AppMethodBeat.o(202253);
  }
  
  public final void EK(int paramInt)
  {
    AppMethodBeat.i(202252);
    super.EK(paramInt);
    MMActivity localMMActivity = this.fNT;
    if ((localMMActivity instanceof FinderShareFeedRelUI)) {
      ((FinderShareFeedRelUI)localMMActivity).cMY();
    }
    AppMethodBeat.o(202252);
  }
  
  public final com.tencent.mm.view.d cCT()
  {
    return this.sel;
  }
  
  public final void cCw()
  {
    AppMethodBeat.i(202250);
    Object localObject = this.scj.getRecyclerView();
    ((RecyclerView)localObject).setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.d());
    ((RecyclerView)localObject).setHasFixedSize(true);
    ((RecyclerView)localObject).setItemViewCacheSize(4);
    ((RecyclerView)localObject).b((RecyclerView.h)new b((Drawable)new ColorDrawable(((RecyclerView)localObject).getResources().getColor(2131099679)), (int)((RecyclerView)localObject).getResources().getDimension(2131166294)));
    localObject = this.sco;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderFeedDetailRelUIContract.Presenter");
      AppMethodBeat.o(202250);
      throw ((Throwable)localObject);
    }
    localObject = (i.a)localObject;
    if (((i.a)localObject).rZB != null)
    {
      ae.i(TAG, "cache exit!,show cache first");
      ArrayList localArrayList = ((i.a)localObject).cCS();
      if (localArrayList != null) {
        localArrayList.clear();
      }
      localArrayList = ((i.a)localObject).cCS();
      if (localArrayList != null)
      {
        localObject = ((i.a)localObject).rZB;
        if (localObject == null) {
          p.gkB();
        }
        localArrayList.add(localObject);
      }
      getAdapter().notifyDataSetChanged();
    }
    super.cCw();
    AppMethodBeat.o(202250);
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(202251);
    RecyclerView.h localh = (RecyclerView.h)new b((Drawable)new ColorDrawable(c.a.a(this).getColor(2131099648)), 0);
    AppMethodBeat.o(202251);
    return localh;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback$myActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.view.d
  {
    b()
    {
      this.sen = localObject.scj;
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202246);
      this.seo.scj.au(this.seo.rgr + paramInt1, paramInt2);
      AppMethodBeat.o(202246);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202247);
      this.seo.scj.av(this.seo.rgr + paramInt1, paramInt2);
      AppMethodBeat.o(202247);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202249);
      p.h(paramc, "reason");
      this.sen.c(paramc);
      AppMethodBeat.o(202249);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(202248);
      p.h(paramc, "reason");
      this.sen.d(paramc);
      AppMethodBeat.o(202248);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(202245);
      this.seo.scj.f(this.seo.rgr + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(202245);
    }
    
    public final void onChanged() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.i.b
 * JD-Core Version:    0.7.0.1
 */