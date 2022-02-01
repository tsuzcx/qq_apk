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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;II)V", "myActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getMyActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setMyActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getViewActionCallback", "onItemChange", "", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "Companion", "plugin-finder_release"})
public final class i$b
  extends u.b
{
  private static final String TAG = "Finder.FinderFeedDetailRelUIContract.ViewCallback";
  public static final a rVG;
  private com.tencent.mm.view.d rVF;
  
  static
  {
    AppMethodBeat.i(201795);
    rVG = new a((byte)0);
    TAG = "Finder.FinderFeedDetailRelUIContract.ViewCallback";
    AppMethodBeat.o(201795);
  }
  
  public i$b(MMActivity paramMMActivity, i.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (u.a)parama, paramInt1, paramInt2);
    AppMethodBeat.i(201794);
    this.rVF = ((com.tencent.mm.view.d)new b(this));
    AppMethodBeat.o(201794);
  }
  
  public final void Ex(int paramInt)
  {
    AppMethodBeat.i(201793);
    super.Ex(paramInt);
    MMActivity localMMActivity = this.fLP;
    if ((localMMActivity instanceof FinderShareFeedRelUI)) {
      ((FinderShareFeedRelUI)localMMActivity).cKu();
    }
    AppMethodBeat.o(201793);
  }
  
  public final void cAK()
  {
    AppMethodBeat.i(201791);
    Object localObject = this.rTF.getRecyclerView();
    ((RecyclerView)localObject).setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.d());
    ((RecyclerView)localObject).setHasFixedSize(true);
    ((RecyclerView)localObject).setItemViewCacheSize(4);
    ((RecyclerView)localObject).b((RecyclerView.h)new b((Drawable)new ColorDrawable(((RecyclerView)localObject).getResources().getColor(2131099679)), (int)((RecyclerView)localObject).getResources().getDimension(2131166294)));
    localObject = this.rTK;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderFeedDetailRelUIContract.Presenter");
      AppMethodBeat.o(201791);
      throw ((Throwable)localObject);
    }
    localObject = (i.a)localObject;
    if (((i.a)localObject).rQZ != null)
    {
      ad.i(TAG, "cache exit!,show cache first");
      ArrayList localArrayList = ((i.a)localObject).cBg();
      if (localArrayList != null) {
        localArrayList.clear();
      }
      localArrayList = ((i.a)localObject).cBg();
      if (localArrayList != null)
      {
        localObject = ((i.a)localObject).rQZ;
        if (localObject == null) {
          p.gfZ();
        }
        localArrayList.add(localObject);
      }
      getAdapter().notifyDataSetChanged();
    }
    super.cAK();
    AppMethodBeat.o(201791);
  }
  
  public final com.tencent.mm.view.d cBh()
  {
    return this.rVF;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(201792);
    RecyclerView.h localh = (RecyclerView.h)new b((Drawable)new ColorDrawable(c.a.a(this).getColor(2131099648)), 0);
    AppMethodBeat.o(201792);
    return localh;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback$myActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.view.d
  {
    b()
    {
      this.rVH = localObject.rTF;
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201787);
      this.rVI.rTF.au(this.rVI.qYl + paramInt1, paramInt2);
      AppMethodBeat.o(201787);
    }
    
    public final void av(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(201788);
      this.rVI.rTF.av(this.rVI.qYl + paramInt1, paramInt2);
      AppMethodBeat.o(201788);
    }
    
    public final void c(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201790);
      p.h(paramc, "reason");
      this.rVH.c(paramc);
      AppMethodBeat.o(201790);
    }
    
    public final void d(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201789);
      p.h(paramc, "reason");
      this.rVH.d(paramc);
      AppMethodBeat.o(201789);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(201786);
      this.rVI.rTF.f(this.rVI.qYl + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(201786);
    }
    
    public final void onChanged() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.i.b
 * JD-Core Version:    0.7.0.1
 */