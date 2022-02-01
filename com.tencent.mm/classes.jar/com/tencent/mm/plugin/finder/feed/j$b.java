package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.view.animation.e;
import com.tencent.mm.plugin.finder.view.decoration.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;II)V", "myActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getMyActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setMyActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getViewActionCallback", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onItemChange", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "Companion", "plugin-finder_release"})
public final class j$b
  extends v.b
{
  private static final String TAG = "Finder.FinderFeedDetailRelUIContract.ViewCallback";
  public static final a tNT;
  private j tNS;
  
  static
  {
    AppMethodBeat.i(243803);
    tNT = new a((byte)0);
    TAG = "Finder.FinderFeedDetailRelUIContract.ViewCallback";
    AppMethodBeat.o(243803);
  }
  
  public j$b(MMActivity paramMMActivity, j.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (v.a)parama, paramInt1, paramInt2);
    AppMethodBeat.i(243802);
    this.tNS = ((j)new b(this));
    AppMethodBeat.o(243802);
  }
  
  public final void IF(int paramInt)
  {
    AppMethodBeat.i(243801);
    super.IF(paramInt);
    MMActivity localMMActivity = this.gte;
    if ((localMMActivity instanceof FinderShareFeedRelUI)) {
      ((FinderShareFeedRelUI)localMMActivity).dAl();
    }
    AppMethodBeat.o(243801);
  }
  
  public final void aa(ArrayList<bo> paramArrayList)
  {
    AppMethodBeat.i(243798);
    p.h(paramArrayList, "data");
    super.aa(paramArrayList);
    if (dck())
    {
      paramArrayList = this.tLS;
      View localView = aa.jQ((Context)this.gte).inflate(2131495035, null);
      p.g(localView, "MMLayoutInflater.getInfl…b_load_more_footer, null)");
      paramArrayList.setLoadMoreFooter(localView);
    }
    AppMethodBeat.o(243798);
  }
  
  public final void dbY()
  {
    AppMethodBeat.i(243799);
    Object localObject = this.tLS.getRecyclerView();
    ((RecyclerView)localObject).setItemAnimator((RecyclerView.f)new e());
    ((RecyclerView)localObject).setHasFixedSize(true);
    if (!dck())
    {
      ((RecyclerView)localObject).b((RecyclerView.h)new b((Drawable)new ColorDrawable(((RecyclerView)localObject).getResources().getColor(2131099689)), (int)((RecyclerView)localObject).getResources().getDimension(2131166341)));
      ((RecyclerView)localObject).setItemViewCacheSize(4);
    }
    for (;;)
    {
      localObject = this.tLY;
      if (localObject != null) {
        break;
      }
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderFeedDetailRelUIContract.Presenter");
      AppMethodBeat.o(243799);
      throw ((Throwable)localObject);
      ((RecyclerView)localObject).setItemViewCacheSize(1);
    }
    localObject = (j.a)localObject;
    if (((j.a)localObject).tNO != null)
    {
      Log.i(TAG, "cache exit!,show cache first");
      ArrayList localArrayList = ((j.a)localObject).dcH();
      if (localArrayList != null) {
        localArrayList.clear();
      }
      localArrayList = ((j.a)localObject).dcH();
      if (localArrayList != null)
      {
        localObject = ((j.a)localObject).tNO;
        if (localObject == null) {
          p.hyc();
        }
        localArrayList.add(localObject);
      }
      getAdapter().notifyDataSetChanged();
    }
    super.dbY();
    AppMethodBeat.o(243799);
  }
  
  public final j dcI()
  {
    return this.tNS;
  }
  
  public final View getEmptyView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(243800);
    RecyclerView.h localh = (RecyclerView.h)new b((Drawable)new ColorDrawable(c.a.a(this).getColor(2131099648)), 0);
    AppMethodBeat.o(243800);
    return localh;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback$myActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
  public static final class b
    implements j
  {
    b()
    {
      this.tNU = localObject.tLS;
    }
    
    public final void onChanged() {}
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243791);
      this.tNV.tLS.onItemRangeChanged(this.tNV.sHN + paramInt1, paramInt2);
      AppMethodBeat.o(243791);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(243792);
      this.tNV.tLS.onItemRangeChanged(this.tNV.sHN + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(243792);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243793);
      this.tNV.tLS.onItemRangeInserted(this.tNV.sHN + paramInt1, paramInt2);
      AppMethodBeat.o(243793);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243794);
      this.tNV.tLS.onItemRangeRemoved(this.tNV.sHN + paramInt1, paramInt2);
      AppMethodBeat.o(243794);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(243795);
      p.h(paramc, "reason");
      this.tNU.onPreFinishLoadMore(paramc);
      AppMethodBeat.o(243795);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(243796);
      p.h(paramc, "reason");
      this.tNU.onPreFinishLoadMoreSmooth(paramc);
      AppMethodBeat.o(243796);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(243797);
      p.h(paramc, "reason");
      this.tNU.onPreFinishRefresh(paramc);
      AppMethodBeat.o(243797);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.j.b
 * JD-Core Version:    0.7.0.1
 */