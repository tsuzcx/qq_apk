package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.finder.convert.i;
import com.tencent.mm.plugin.finder.convert.o;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.g.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.b.a;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.a.m;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class q
{
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "(ILcom/tencent/mm/ui/MMActivity;ZZ)V", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "()Z", "objectId", "", "getObjectId", "()J", "setObjectId", "(J)V", "objectNonceId", "", "getObjectNonceId", "()Ljava/lang/String;", "setObjectNonceId", "(Ljava/lang/String;)V", "getSafeMode", "getScene", "()I", "showErrUi", "Lkotlin/Function2;", "", "getShowErrUi", "()Lkotlin/jvm/functions/Function2;", "setShowErrUi", "(Lkotlin/jvm/functions/Function2;)V", "successNext", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getSuccessNext", "()Lkotlin/jvm/functions/Function1;", "setSuccessNext", "(Lkotlin/jvm/functions/Function1;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getFeedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getInitRequest", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "isFinderSelfScene", "loadFirstFeed", "next", "Lkotlin/Function0;", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "index", "requestRefresh", "plugin-finder_release"})
  public static class a
    extends e.a
  {
    public m<? super Integer, ? super String, y> KNg;
    public d.g.a.b<? super FinderObject, y> KNh;
    private final boolean diE;
    public long objectId;
    public String objectNonceId;
    public BaseFinderFeed qHv;
    public final boolean qqF;
    private final int scene;
    
    private a(int paramInt, MMActivity paramMMActivity, boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(197691);
      this.scene = paramInt;
      this.qqF = paramBoolean;
      this.diE = false;
      this.objectNonceId = "";
      AppMethodBeat.o(197691);
    }
    
    public final void a(a.b paramb)
    {
      AppMethodBeat.i(197688);
      k.h(paramb, "callback");
      super.a(paramb);
      AppMethodBeat.o(197688);
    }
    
    public final void aJq()
    {
      AppMethodBeat.i(197686);
      BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
      if (localBaseFinderFeedLoader != null)
      {
        localBaseFinderFeedLoader.requestLoadMore();
        AppMethodBeat.o(197686);
        return;
      }
      AppMethodBeat.o(197686);
    }
    
    public final boolean clH()
    {
      return this.diE;
    }
    
    public com.tencent.mm.view.recyclerview.c clL()
    {
      AppMethodBeat.i(197684);
      com.tencent.mm.view.recyclerview.c localc = (com.tencent.mm.view.recyclerview.c)new a(this);
      AppMethodBeat.o(197684);
      return localc;
    }
    
    public final ArrayList<BaseFinderFeed> clY()
    {
      AppMethodBeat.i(197687);
      Object localObject = this.qvo;
      if (localObject != null) {}
      for (localObject = ((BaseFinderFeedLoader)localObject).getDataListJustForAdapter();; localObject = null)
      {
        localObject = (ArrayList)localObject;
        AppMethodBeat.o(197687);
        return localObject;
      }
    }
    
    public final com.tencent.mm.plugin.finder.feed.model.internal.h clZ()
    {
      AppMethodBeat.i(197683);
      Object localObject = this.qvo;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFeedShareRelativeListLoader");
        AppMethodBeat.o(197683);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.plugin.finder.feed.model.internal.h)new g.b(((com.tencent.mm.plugin.finder.feed.model.g)localObject).feedId, (com.tencent.mm.plugin.finder.feed.model.internal.g)new b());
      AppMethodBeat.o(197683);
      return localObject;
    }
    
    public void onDetach()
    {
      AppMethodBeat.i(197690);
      super.onDetach();
      AppMethodBeat.o(197690);
    }
    
    public final void requestRefresh()
    {
      AppMethodBeat.i(197685);
      final d.g.a.a locala = (d.g.a.a)new d(this);
      k.h(locala, "next");
      long l = this.objectId;
      String str = this.objectNonceId;
      int i = this.qqE;
      int j = this.scene;
      Object localObject = FinderReporterUIC.Ljl;
      localObject = FinderReporterUIC.a.lB((Context)this.imP);
      if (localObject != null) {}
      for (localObject = ((FinderReporterUIC)localObject).fXs();; localObject = null)
      {
        new com.tencent.mm.plugin.finder.cgi.h(l, str, i, j, "", true, null, null, 0L, null, false, false, null, (dzp)localObject, 8128).auK().b((com.tencent.mm.vending.c.a)new c(this, locala));
        AppMethodBeat.o(197685);
        return;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.view.recyclerview.c
    {
      public final com.tencent.mm.view.recyclerview.b<?> zm(int paramInt)
      {
        AppMethodBeat.i(197680);
        switch (paramInt)
        {
        case 3: 
        case 5: 
        case 6: 
        default: 
          localb = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.g((c)this.KNi, this.KNi.qqF, 0, 4);
          AppMethodBeat.o(197680);
          return localb;
        case 4: 
          localb = (com.tencent.mm.view.recyclerview.b)new r(this.KNi.qrq, (c)this.KNi, this.KNi.qqF, 0, 8);
          AppMethodBeat.o(197680);
          return localb;
        case 2: 
          localb = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.g((c)this.KNi, this.KNi.qqF, 0, 4);
          AppMethodBeat.o(197680);
          return localb;
        case 7: 
          localb = (com.tencent.mm.view.recyclerview.b)new o((c)this.KNi, this.KNi.qqF, 0, 4);
          AppMethodBeat.o(197680);
          return localb;
        case 8: 
          localb = (com.tencent.mm.view.recyclerview.b)new i(this.KNi.qrq, (c)this.KNi, this.KNi.qqF, 0, 8);
          AppMethodBeat.o(197680);
          return localb;
        }
        com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.l((c)this.KNi, this.KNi.qqF, 0, 4);
        AppMethodBeat.o(197680);
        return localb;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter$getInitRequest$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class b
      implements com.tencent.mm.plugin.finder.feed.model.internal.g
    {
      public final void call(int paramInt) {}
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
    static final class c<_Ret, _Var>
      implements com.tencent.mm.vending.c.a<_Ret, _Var>
    {
      c(q.a parama, d.g.a.a parama1) {}
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      d(q.a parama)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;II)V", "myActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getMyActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setMyActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getViewActionCallback", "onItemChange", "", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "Companion", "plugin-finder_release"})
  public static final class b
    extends e.b
  {
    public static final a KNl;
    private static final String TAG = "Finder.FinderFeedDetailRelUIContract.ViewCallback";
    private d KNk;
    
    static
    {
      AppMethodBeat.i(197701);
      KNl = new a((byte)0);
      TAG = "Finder.FinderFeedDetailRelUIContract.ViewCallback";
      AppMethodBeat.o(197701);
    }
    
    public b(MMActivity paramMMActivity, q.a parama, int paramInt)
    {
      super((e.a)parama, paramInt, 25);
      AppMethodBeat.i(197700);
      this.KNk = ((d)new b(this));
      AppMethodBeat.o(197700);
    }
    
    public final void CC(int paramInt)
    {
      AppMethodBeat.i(197699);
      super.CC(paramInt);
      MMActivity localMMActivity = this.imP;
      if ((localMMActivity instanceof FinderShareFeedRelUI)) {
        ((FinderShareFeedRelUI)localMMActivity).fVH();
      }
      AppMethodBeat.o(197699);
    }
    
    public final void clP()
    {
      AppMethodBeat.i(197697);
      Object localObject = this.quj.getRecyclerView();
      ((RecyclerView)localObject).setItemAnimator((RecyclerView.f)new com.tencent.mm.plugin.finder.view.animation.c());
      ((RecyclerView)localObject).setHasFixedSize(true);
      ((RecyclerView)localObject).setItemViewCacheSize(4);
      ((RecyclerView)localObject).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(((RecyclerView)localObject).getResources().getColor(2131099679)), (int)((RecyclerView)localObject).getResources().getDimension(2131166294)));
      localObject = this.qun;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderFeedDetailRelUIContract.Presenter");
        AppMethodBeat.o(197697);
        throw ((Throwable)localObject);
      }
      localObject = (q.a)localObject;
      if (((q.a)localObject).qHv != null)
      {
        ad.i(TAG, "cache exit!,show cache first");
        ArrayList localArrayList = ((q.a)localObject).clY();
        if (localArrayList != null) {
          localArrayList.clear();
        }
        localArrayList = ((q.a)localObject).clY();
        if (localArrayList != null)
        {
          localObject = ((q.a)localObject).qHv;
          if (localObject == null) {
            k.fvU();
          }
          localArrayList.add(localObject);
        }
        getAdapter().notifyDataSetChanged();
      }
      super.clP();
      AppMethodBeat.o(197697);
    }
    
    public final d cma()
    {
      return this.KNk;
    }
    
    public final RecyclerView.h getItemDecoration()
    {
      AppMethodBeat.i(197698);
      RecyclerView.h localh = (RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(b.a.a(this).getColor(2131099648)), 0);
      AppMethodBeat.o(197698);
      return localh;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {}
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback$myActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
    public static final class b
      implements d
    {
      b()
      {
        this.qvq = localObject.quj;
      }
      
      public final void at(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(197693);
        this.KNm.quj.at(this.KNm.qui + paramInt1, paramInt2);
        AppMethodBeat.o(197693);
      }
      
      public final void au(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(197694);
        this.KNm.quj.au(this.KNm.qui + paramInt1, paramInt2);
        AppMethodBeat.o(197694);
      }
      
      public final void c(RefreshLoadMoreLayout.c<Object> paramc)
      {
        AppMethodBeat.i(197695);
        k.h(paramc, "reason");
        this.qvq.c(paramc);
        AppMethodBeat.o(197695);
      }
      
      public final void d(RefreshLoadMoreLayout.c<Object> paramc)
      {
        AppMethodBeat.i(197696);
        k.h(paramc, "reason");
        this.qvq.d(paramc);
        AppMethodBeat.o(197696);
      }
      
      public final void f(int paramInt1, int paramInt2, Object paramObject)
      {
        AppMethodBeat.i(197692);
        this.KNm.quj.f(this.KNm.qui + paramInt1, paramInt2, paramObject);
        AppMethodBeat.o(197692);
      }
      
      public final void onChanged() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.q
 * JD-Core Version:    0.7.0.1
 */