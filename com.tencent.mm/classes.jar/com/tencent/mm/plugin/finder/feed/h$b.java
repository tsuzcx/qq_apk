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
import com.tencent.mm.plugin.finder.view.animation.c;
import com.tencent.mm.plugin.finder.view.decoration.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;II)V", "myActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getMyActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setMyActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getViewActionCallback", "onItemChange", "", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "Companion", "plugin-finder_release"})
public final class h$b
  extends r.b
{
  private static final String TAG = "Finder.FinderFeedDetailRelUIContract.ViewCallback";
  public static final h.b.a rhA;
  private d rhz;
  
  static
  {
    AppMethodBeat.i(201598);
    rhA = new h.b.a((byte)0);
    TAG = "Finder.FinderFeedDetailRelUIContract.ViewCallback";
    AppMethodBeat.o(201598);
  }
  
  public h$b(MMActivity paramMMActivity, h.a parama, int paramInt)
  {
    super(paramMMActivity, (r.a)parama, paramInt, 25);
    AppMethodBeat.i(201597);
    this.rhz = ((d)new b(this));
    AppMethodBeat.o(201597);
  }
  
  public final void DE(int paramInt)
  {
    AppMethodBeat.i(201596);
    super.DE(paramInt);
    MMActivity localMMActivity = this.iMV;
    if ((localMMActivity instanceof FinderShareFeedRelUI)) {
      ((FinderShareFeedRelUI)localMMActivity).cCo();
    }
    AppMethodBeat.o(201596);
  }
  
  public final d cuQ()
  {
    return this.rhz;
  }
  
  public final void cuy()
  {
    AppMethodBeat.i(201594);
    Object localObject = this.rfT.getRecyclerView();
    ((RecyclerView)localObject).setItemAnimator((RecyclerView.f)new c());
    ((RecyclerView)localObject).setHasFixedSize(true);
    ((RecyclerView)localObject).setItemViewCacheSize(4);
    ((RecyclerView)localObject).b((RecyclerView.h)new b((Drawable)new ColorDrawable(((RecyclerView)localObject).getResources().getColor(2131099679)), (int)((RecyclerView)localObject).getResources().getDimension(2131166294)));
    localObject = this.rfZ;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderFeedDetailRelUIContract.Presenter");
      AppMethodBeat.o(201594);
      throw ((Throwable)localObject);
    }
    localObject = (h.a)localObject;
    if (((h.a)localObject).rdD != null)
    {
      ac.i(TAG, "cache exit!,show cache first");
      ArrayList localArrayList = ((h.a)localObject).cuP();
      if (localArrayList != null) {
        localArrayList.clear();
      }
      localArrayList = ((h.a)localObject).cuP();
      if (localArrayList != null)
      {
        localObject = ((h.a)localObject).rdD;
        if (localObject == null) {
          k.fOy();
        }
        localArrayList.add(localObject);
      }
      getAdapter().notifyDataSetChanged();
    }
    super.cuy();
    AppMethodBeat.o(201594);
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(201595);
    RecyclerView.h localh = (RecyclerView.h)new b((Drawable)new ColorDrawable(c.a.a(this).getColor(2131099648)), 0);
    AppMethodBeat.o(201595);
    return localh;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback$myActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class b
    implements d
  {
    b()
    {
      this.rhB = localObject.rfT;
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201590);
      this.rhC.rfT.at(this.rhC.qpm + paramInt1, paramInt2);
      AppMethodBeat.o(201590);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201591);
      this.rhC.rfT.au(this.rhC.qpm + paramInt1, paramInt2);
      AppMethodBeat.o(201591);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201593);
      k.h(paramc, "reason");
      this.rhB.c(paramc);
      AppMethodBeat.o(201593);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201592);
      k.h(paramc, "reason");
      this.rhB.d(paramc);
      AppMethodBeat.o(201592);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(201589);
      this.rhC.rfT.f(this.rhC.qpm + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(201589);
    }
    
    public final void onChanged() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.h.b
 * JD-Core Version:    0.7.0.1
 */