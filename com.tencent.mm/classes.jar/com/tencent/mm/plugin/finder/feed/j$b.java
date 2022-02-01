package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.view.animation.e;
import com.tencent.mm.plugin.finder.view.decoration.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;II)V", "myActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getMyActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setMyActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getViewActionCallback", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onItemChange", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "Companion", "plugin-finder_release"})
public final class j$b
  extends aa.b
{
  private static final String TAG = "Finder.FinderFeedDetailRelUIContract.ViewCallback";
  public static final a xxT;
  private j xxS;
  
  static
  {
    AppMethodBeat.i(286755);
    xxT = new a((byte)0);
    TAG = "Finder.FinderFeedDetailRelUIContract.ViewCallback";
    AppMethodBeat.o(286755);
  }
  
  public j$b(MMActivity paramMMActivity, j.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (aa.a)parama, paramInt1, paramInt2);
    AppMethodBeat.i(286754);
    this.xxS = ((j)new b(this));
    AppMethodBeat.o(286754);
  }
  
  public final void Mw(int paramInt)
  {
    AppMethodBeat.i(286753);
    super.Mw(paramInt);
    MMActivity localMMActivity = this.iXq;
    if ((localMMActivity instanceof FinderShareFeedRelUI)) {
      ((FinderShareFeedRelUI)localMMActivity).ebh();
    }
    AppMethodBeat.o(286753);
  }
  
  public final void aa(ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(286750);
    p.k(paramArrayList, "data");
    super.aa(paramArrayList);
    if (dsA())
    {
      paramArrayList = this.xvJ;
      View localView = ad.kS((Context)this.iXq).inflate(b.g.hot_tab_load_more_footer, null);
      p.j(localView, "MMLayoutInflater.getInfl…b_load_more_footer, null)");
      paramArrayList.setLoadMoreFooter(localView);
    }
    AppMethodBeat.o(286750);
  }
  
  public final void dsm()
  {
    AppMethodBeat.i(286751);
    Object localObject = this.xvJ.getRecyclerView();
    ((RecyclerView)localObject).setItemAnimator((RecyclerView.f)new e());
    ((RecyclerView)localObject).setHasFixedSize(true);
    if (!dsA())
    {
      ((RecyclerView)localObject).b((RecyclerView.h)new b((Drawable)new ColorDrawable(((RecyclerView)localObject).getResources().getColor(b.c.BW_93)), (int)((RecyclerView)localObject).getResources().getDimension(b.d.feed_divider)));
      ((RecyclerView)localObject).setItemViewCacheSize(4);
    }
    for (;;)
    {
      localObject = this.xvP;
      if (localObject != null) {
        break;
      }
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderFeedDetailRelUIContract.Presenter");
      AppMethodBeat.o(286751);
      throw ((Throwable)localObject);
      ((RecyclerView)localObject).setItemViewCacheSize(1);
    }
    localObject = (j.a)localObject;
    if (((j.a)localObject).xxO != null)
    {
      Log.i(TAG, "cache exit!,show cache first");
      ArrayList localArrayList = ((j.a)localObject).dta();
      if (localArrayList != null) {
        localArrayList.clear();
      }
      localArrayList = ((j.a)localObject).dta();
      if (localArrayList != null)
      {
        localObject = ((j.a)localObject).xxO;
        if (localObject == null) {
          p.iCn();
        }
        localArrayList.add(localObject);
      }
      getAdapter().notifyDataSetChanged();
    }
    super.dsm();
    AppMethodBeat.o(286751);
  }
  
  public final j dtb()
  {
    return this.xxS;
  }
  
  public final View getEmptyView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(286752);
    RecyclerView.h localh = (RecyclerView.h)new b((Drawable)new ColorDrawable(c.a.a(this).getColor(b.c.BG_0)), 0);
    AppMethodBeat.o(286752);
    return localh;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback$myActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class b
    implements j
  {
    b()
    {
      this.xxU = localObject.xvJ;
    }
    
    public final void onChanged() {}
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(286541);
      this.xxV.xvJ.onItemRangeChanged(this.xxV.wnI + paramInt1, paramInt2);
      AppMethodBeat.o(286541);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(286542);
      this.xxV.xvJ.onItemRangeChanged(this.xxV.wnI + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(286542);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(286543);
      this.xxV.xvJ.onItemRangeInserted(this.xxV.wnI + paramInt1, paramInt2);
      AppMethodBeat.o(286543);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(286544);
      this.xxV.xvJ.onItemRangeRemoved(this.xxV.wnI + paramInt1, paramInt2);
      AppMethodBeat.o(286544);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(286545);
      p.k(paramc, "reason");
      this.xxU.onPreFinishLoadMore(paramc);
      AppMethodBeat.o(286545);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(286546);
      p.k(paramc, "reason");
      this.xxU.onPreFinishLoadMoreSmooth(paramc);
      AppMethodBeat.o(286546);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(286547);
      p.k(paramc, "reason");
      this.xxU.onPreFinishRefresh(paramc);
      AppMethodBeat.o(286547);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.j.b
 * JD-Core Version:    0.7.0.1
 */