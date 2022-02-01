package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.z;
import com.tencent.mm.plugin.finder.feed.model.z.a;
import com.tencent.mm.plugin.finder.feed.model.z.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.q;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class aa
{
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "initLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "initDataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;Lcom/tencent/mm/protobuf/ByteString;Ljava/util/List;)V", "getInitDataList", "()Ljava/util/List;", "getInitLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onDetach", "requestRefresh", "plugin-finder_release"})
  public static final class a
    extends n.a
  {
    final b KNT;
    private final List<BaseFinderFeed> KNU;
    
    public a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader, b paramb, List<? extends BaseFinderFeed> paramList)
    {
      super(paramBaseFinderFeedLoader);
      AppMethodBeat.i(197885);
      this.KNT = paramb;
      this.KNU = paramList;
      AppMethodBeat.o(197885);
    }
    
    public final void aJq()
    {
      AppMethodBeat.i(197881);
      this.qvo.requestLoadMore();
      AppMethodBeat.o(197881);
    }
    
    public final void clJ()
    {
      AppMethodBeat.i(197880);
      n.b localb = this.KMQ;
      if (localb != null)
      {
        localb.N((ArrayList)this.qvo.getDataListJustForAdapter());
        AppMethodBeat.o(197880);
        return;
      }
      AppMethodBeat.o(197880);
    }
    
    public final c clL()
    {
      AppMethodBeat.i(197883);
      Object localObject = this.KMQ;
      if (localObject != null) {}
      for (localObject = ((n.b)localObject).fTe();; localObject = null)
      {
        if (localObject == null) {
          k.fvU();
        }
        localObject = ((com.tencent.mm.plugin.finder.storage.v)localObject).fTj();
        AppMethodBeat.o(197883);
        return localObject;
      }
    }
    
    public final void fTa()
    {
      AppMethodBeat.i(197882);
      com.tencent.mm.plugin.finder.feed.model.internal.a.initData$default(this.qvo, (h)new z.b(this.KNU, 0L, (g)new a(this)), false, 2, null);
      AppMethodBeat.o(197882);
    }
    
    public final void onDetach()
    {
      AppMethodBeat.i(197884);
      super.onDetach();
      z.a locala = z.KQl;
      z.a.clearCache();
      AppMethodBeat.o(197884);
    }
    
    public final void requestRefresh() {}
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter$loadInitData$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a
      implements g
    {
      public final void call(int paramInt)
      {
        AppMethodBeat.i(197879);
        Object localObject = this.KNV.qvo;
        if (localObject == null)
        {
          localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader");
          AppMethodBeat.o(197879);
          throw ((Throwable)localObject);
        }
        ((z)localObject).lastBuffer = this.KNV.KNT;
        AppMethodBeat.o(197879);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;Ljava/lang/String;)V", "TAG", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"})
  public static final class b
    extends n.b
  {
    private com.tencent.mm.plugin.finder.storage.v KMT;
    private final dyz KNW;
    private final String TAG;
    private final String title;
    
    public b(MMActivity paramMMActivity, int paramInt, dyz paramdyz, String paramString)
    {
      super(paramInt, 28);
      AppMethodBeat.i(197892);
      this.KNW = paramdyz;
      this.title = paramString;
      this.TAG = "Finder.FinderRelatedFeedUIContract.FavFeedViewCallback";
      this.KMT = ((com.tencent.mm.plugin.finder.storage.v)new q());
      AppMethodBeat.o(197892);
    }
    
    public final void c(RecyclerView.a<?> parama, View paramView, int paramInt)
    {
      AppMethodBeat.i(197889);
      k.h(parama, "adapter");
      k.h(paramView, "view");
      paramInt -= ((d)parama).Ibl.size();
      if ((paramInt >= 0) && (paramInt < fTb().qvo.getSize()))
      {
        parama = ((BaseFinderFeed)fTb().qvo.getDataListJustForAdapter().get(paramInt)).feedObject;
        ad.i(this.TAG, "onClick " + paramInt + " id:" + parama.getId() + ", pos:" + paramInt);
        parama = new Intent();
        parama.putExtra("KEY_CLICK_FEED_POSITION", paramInt);
        long l = System.currentTimeMillis();
        Object localObject = z.KQl;
        localObject = (List)fTb().qvo.getDataListJustForAdapter();
        BaseFinderFeedLoader localBaseFinderFeedLoader = fTb().qvo;
        if (localBaseFinderFeedLoader == null)
        {
          parama = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader");
          AppMethodBeat.o(197889);
          throw parama;
        }
        z.a.a(l, (List)localObject, ((z)localBaseFinderFeedLoader).lastBuffer);
        parama.putExtra("KEY_CACHE_ID", l);
        parama.putExtra("KEY_TITLE", this.title);
        parama.putExtra("KEY_REQUEST_PB", this.KNW.toByteArray());
        localObject = FinderReporterUIC.Ljl;
        localObject = paramView.getContext();
        k.g(localObject, "view.context");
        FinderReporterUIC.a.a((Context)localObject, parama, 0L, 0, false, 124);
        localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
        paramView = paramView.getContext();
        k.g(paramView, "view.context");
        com.tencent.mm.plugin.finder.utils.a.af(paramView, parama);
      }
      AppMethodBeat.o(197889);
    }
    
    public final com.tencent.mm.plugin.finder.storage.v fTe()
    {
      return this.KMT;
    }
    
    public final boolean fTf()
    {
      return false;
    }
    
    public final void fTg() {}
    
    public final MMActivity getActivity()
    {
      return this.imP;
    }
    
    public final View getEmptyView()
    {
      AppMethodBeat.i(197887);
      View localView = this.imP.findViewById(2131299478);
      AppMethodBeat.o(197887);
      return localView;
    }
    
    public final RecyclerView.h getItemDecoration()
    {
      AppMethodBeat.i(197886);
      RecyclerView.h localh = this.KMT.getItemDecoration();
      AppMethodBeat.o(197886);
      return localh;
    }
    
    public final String h(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197890);
      k.h(paramc, "reason");
      AppMethodBeat.o(197890);
      return "";
    }
    
    public final String i(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(197891);
      k.h(paramc, "reason");
      AppMethodBeat.o(197891);
      return "";
    }
    
    public final RecyclerView.i lw(Context paramContext)
    {
      AppMethodBeat.i(197888);
      k.h(paramContext, "context");
      paramContext = this.KMT.lw(paramContext);
      AppMethodBeat.o(197888);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aa
 * JD-Core Version:    0.7.0.1
 */