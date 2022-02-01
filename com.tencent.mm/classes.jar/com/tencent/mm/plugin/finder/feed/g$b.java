package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "FILTER_VIEW_TYPE", "getFILTER_VIEW_TYPE", "()I", "TAG", "", "filterContract", "Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "tagContainer", "Landroid/view/ViewGroup;", "tagContainerHeight", "dismissEmptyView", "", "fixStatusHeight", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "handleLoadMoreEnd", "handleRefreshEnd", "initTopicFilter", "topics", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "Lkotlin/collections/ArrayList;", "initView", "data", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isHandleRefreshEndBySelf", "onGridItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshFooter", "refreshTopic", "reportTagClick", "item", "reportTagsExpose", "resetLoadMore", "selectTagWithCache", "selectTagWithNoCache", "showEmptyView", "showLoading", "plugin-finder_release"})
public class g$b
  extends c.b
{
  private final String TAG;
  private final int xxC;
  private int xxD;
  ViewGroup xxE;
  com.tencent.mm.plugin.finder.profile.b xxF;
  
  private g$b(MMActivity paramMMActivity, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, paramInt1, paramInt2, false);
    AppMethodBeat.i(268193);
    this.TAG = "Finder.FinderFavFeedUIContract.FavFeedViewCallback";
    this.xxC = 10000001;
    this.xxD = -1;
    AppMethodBeat.o(268193);
  }
  
  private final void dsW()
  {
    AppMethodBeat.i(268178);
    View localView = getEmptyView();
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(b.f.empty_tip);
    if (localView != null) {
      localView.setVisibility(4);
    }
    localView = findViewById(b.f.retry_tip);
    if (localView != null) {
      localView.setVisibility(4);
    }
    localView = findViewById(b.f.progress);
    if (localView != null) {
      localView.setVisibility(4);
    }
    this.xvJ.setVisibility(0);
    AppMethodBeat.o(268178);
  }
  
  private final void dsX()
  {
    AppMethodBeat.i(268179);
    Object localObject = this.xvJ.getLoadMoreFooter();
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
      if (localObject != null)
      {
        Context localContext = ((TextView)localObject).getContext();
        p.j(localContext, "context");
        ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(b.j.finder_load_more_footer_tip));
        ((TextView)localObject).setVisibility(0);
      }
    }
    localObject = this.xvJ.getLoadMoreFooter();
    if (localObject != null)
    {
      localObject = ((View)localObject).findViewById(b.f.load_more_footer_end_layout);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        AppMethodBeat.o(268179);
        return;
      }
    }
    AppMethodBeat.o(268179);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(268190);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    p.k(parama, "adapter");
    p.k(paramView, "view");
    paramInt -= ((com.tencent.mm.view.recyclerview.h)parama).YSk.size();
    if ((paramInt >= 0) && (paramInt < dsG().xnX.getSize()))
    {
      parama = (bu)dsG().xnX.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
        AppMethodBeat.o(268190);
        return;
      }
      Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      localObject = new Intent();
      BaseFeedLoader.saveCache$default(dsG().xnX, (Intent)localObject, paramInt, null, 4, null);
      paramView = dsG().xnX;
      parama = paramView;
      if (!(paramView instanceof FinderFavFeedLoader)) {
        parama = null;
      }
      parama = (FinderFavFeedLoader)parama;
      if (parama == null) {
        break label309;
      }
    }
    label309:
    for (long l = parama.xGt;; l = 0L)
    {
      ((Intent)localObject).putExtra("key_active_topic_id", l);
      parama = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.b((Activity)this.iXq, (Intent)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
      AppMethodBeat.o(268190);
      return;
    }
  }
  
  public final void ab(ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(268177);
    p.k(paramArrayList, "data");
    super.ab(paramArrayList);
    AppMethodBeat.o(268177);
  }
  
  public final void bTY()
  {
    AppMethodBeat.i(268184);
    View localView = getEmptyView();
    if (localView != null)
    {
      localView.setVisibility(0);
      Object localObject = (TextView)localView.findViewById(b.f.empty_tip);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = localView.findViewById(b.f.progress);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localView = localView.findViewById(b.f.retry_tip);
      if (localView != null)
      {
        localView.setVisibility(8);
        AppMethodBeat.o(268184);
        return;
      }
      AppMethodBeat.o(268184);
      return;
    }
    AppMethodBeat.o(268184);
  }
  
  public final boolean c(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(268181);
    p.k(paramc, "reason");
    AppMethodBeat.o(268181);
    return true;
  }
  
  public final void d(final RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(268182);
    p.k(paramc, "reason");
    View localView = getEmptyView();
    if (localView != null)
    {
      RecyclerView.a locala = this.xvJ.getRecyclerView().getAdapter();
      Object localObject = locala;
      if (!(locala instanceof WxRecyclerAdapter)) {
        localObject = null;
      }
      localObject = (WxRecyclerAdapter)localObject;
      if (paramc.YND != -1)
      {
        if (localObject != null) {
          i = ((com.tencent.mm.view.recyclerview.h)localObject).ihV();
        }
        while (i <= 0)
        {
          bTY();
          paramc = this.xvJ;
          if (paramc != null)
          {
            paramc.setVisibility(0);
            AppMethodBeat.o(268182);
            return;
            i = 0;
          }
          else
          {
            AppMethodBeat.o(268182);
            return;
          }
        }
        localView.setVisibility(8);
        localObject = this.xvJ;
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).setVisibility(0);
        }
        if (!paramc.YNF)
        {
          dsY();
          paramc = this.xvJ.getLoadMoreFooter();
          if (paramc != null)
          {
            paramc.setVisibility(0);
            AppMethodBeat.o(268182);
            return;
          }
        }
        AppMethodBeat.o(268182);
        return;
      }
      localView.setVisibility(0);
      localObject = (TextView)localView.findViewById(b.f.empty_tip);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = (TextView)localView.findViewById(b.f.retry_tip);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = localView.findViewById(b.f.progress);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = localView.findViewById(b.f.retry_tip);
      if (localObject != null) {
        ((View)localObject).setOnClickListener((View.OnClickListener)new a(localView, this, paramc));
      }
      paramc = dsH().xnX;
      if (paramc == null)
      {
        paramc = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
        AppMethodBeat.o(268182);
        throw paramc;
      }
      paramc = ((FinderFavFeedLoader)paramc).getDataList();
      if (!((Collection)paramc).isEmpty()) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramc.clear();
          dsH().xnX.onDataChanged();
        }
        AppMethodBeat.o(268182);
        return;
      }
    }
    AppMethodBeat.o(268182);
  }
  
  public final void dsL()
  {
    AppMethodBeat.i(268187);
    if (dsH().xnX.getSize() <= ku() * 3)
    {
      localObject = dsH().xnX;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
        AppMethodBeat.o(268187);
        throw ((Throwable)localObject);
      }
      if (((FinderFavFeedLoader)localObject).hasMore) {
        RefreshLoadMoreLayout.c(this.xvJ);
      }
    }
    Object localObject = dsH().xnX;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
      AppMethodBeat.o(268187);
      throw ((Throwable)localObject);
    }
    localObject = (FinderFavFeedLoader)localObject;
    ((FinderFavFeedLoader)localObject).jlf -= 1;
    int i = ((FinderFavFeedLoader)localObject).jlf;
    localObject = this.xwc;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(b.f.desc);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)this.iXq.getResources().getString(b.j.finder_fav_list_desc, new Object[] { Integer.valueOf(i) }));
        AppMethodBeat.o(268187);
        return;
      }
    }
    AppMethodBeat.o(268187);
  }
  
  public final void dsY()
  {
    int j = 0;
    AppMethodBeat.i(268180);
    Object localObject1 = dsH().xnX;
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
      AppMethodBeat.o(268180);
      throw ((Throwable)localObject1);
    }
    if (((FinderFavFeedLoader)localObject1).xGt == 0L) {}
    for (int i = 1;; i = 0)
    {
      localObject1 = this.xvJ.getLoadMoreFooter();
      if (localObject1 == null) {
        break label191;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.load_more_footer_tip_tv);
      if (localObject1 == null) {
        break label191;
      }
      if (i == 0) {
        break label240;
      }
      localObject2 = dsH().xnX;
      if (localObject2 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
      AppMethodBeat.o(268180);
      throw ((Throwable)localObject1);
    }
    int k = ((FinderFavFeedLoader)localObject2).jlf;
    Object localObject2 = ((TextView)localObject1).getContext();
    p.j(localObject2, "context");
    ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(b.j.finder_fav_feed_footer_hint, new Object[] { Integer.valueOf(k) }));
    ((TextView)localObject1).setVisibility(0);
    label191:
    localObject1 = this.xvJ.getLoadMoreFooter();
    if (localObject1 != null) {}
    for (localObject1 = ((View)localObject1).findViewById(b.f.load_more_footer_end_layout);; localObject1 = null)
    {
      if (localObject1 == null) {
        break label256;
      }
      if (i != 0) {
        j = 8;
      }
      ((View)localObject1).setVisibility(j);
      AppMethodBeat.o(268180);
      return;
      label240:
      ((TextView)localObject1).setVisibility(8);
      break;
    }
    label256:
    AppMethodBeat.o(268180);
  }
  
  public final void e(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(268183);
    p.k(paramc, "reason");
    super.e(paramc);
    if (!paramc.YNF) {
      dsY();
    }
    AppMethodBeat.o(268183);
  }
  
  public final RecyclerView.LayoutManager eW(Context paramContext)
  {
    AppMethodBeat.i(268189);
    p.k(paramContext, "context");
    paramContext = dsI().eW(paramContext);
    AppMethodBeat.o(268189);
    return paramContext;
  }
  
  public final String f(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(268191);
    p.k(paramc, "reason");
    paramc = this.iXq.getResources().getString(b.j.finder_fav_list_title);
    AppMethodBeat.o(268191);
    return paramc;
  }
  
  public final String g(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(268192);
    p.k(paramc, "reason");
    if (paramc.lCh == null)
    {
      AppMethodBeat.o(268192);
      return null;
    }
    if ((paramc.lCh instanceof Integer))
    {
      Resources localResources = this.iXq.getResources();
      int i = b.j.finder_fav_list_desc;
      paramc = paramc.lCh;
      if (paramc == null)
      {
        paramc = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(268192);
        throw paramc;
      }
      paramc = localResources.getString(i, new Object[] { (Integer)paramc });
      AppMethodBeat.o(268192);
      return paramc;
    }
    AppMethodBeat.o(268192);
    return null;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(268188);
    View localView2 = findViewById(b.f.empty_view);
    View localView1 = localView2;
    if (!(localView2 instanceof View)) {
      localView1 = null;
    }
    AppMethodBeat.o(268188);
    return localView1;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(268185);
    RecyclerView.h localh = dsI().getItemDecoration();
    AppMethodBeat.o(268185);
    return localh;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback$handleRefreshEnd$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(View paramView, g.b paramb, RefreshLoadMoreLayout.c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(265295);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback$handleRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      p.j(paramView, "it");
      paramView.setVisibility(8);
      paramView = this.xkv.findViewById(b.f.progress);
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      com.tencent.e.h.ZvG.be((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(290063);
          this.xxH.xxG.dsH().requestRefresh();
          AppMethodBeat.o(290063);
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback$handleRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265295);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "selected", "", "invoke"})
  static final class b
    extends q
    implements m<bkr, Boolean, x>
  {
    b(g.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.g.b
 * JD-Core Version:    0.7.0.1
 */