package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.profile.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.as;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.threadpool.h;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "FILTER_VIEW_TYPE", "getFILTER_VIEW_TYPE", "()I", "TAG", "", "filterContract", "Lcom/tencent/mm/plugin/finder/profile/FinderTopicFilterContract;", "tagContainer", "Landroid/view/ViewGroup;", "tagContainerHeight", "dismissEmptyView", "", "fixStatusHeight", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "handleLoadMoreEnd", "handleRefreshEnd", "initTopicFilter", "topics", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "Lkotlin/collections/ArrayList;", "initView", "data", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isHandleRefreshEndBySelf", "onGridItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshFooter", "refreshTopic", "reportTagClick", "item", "reportTagsExpose", "resetLoadMore", "selectTagWithCache", "selectTagWithNoCache", "showEmptyView", "showLoading", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class g$b
  extends c.b
{
  private final int AUO;
  private int AUP;
  ViewGroup AUQ;
  e AUR;
  private final String TAG;
  
  private g$b(MMActivity paramMMActivity, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, paramInt1, paramInt2, false);
    AppMethodBeat.i(363932);
    this.TAG = "Finder.FinderFavFeedUIContract.FavFeedViewCallback";
    this.AUO = 10000001;
    this.AUP = -1;
    AppMethodBeat.o(363932);
  }
  
  private static final void a(View paramView1, b paramb, View paramView2)
  {
    AppMethodBeat.i(363963);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView1);
    localb.cH(paramb);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramView1, "$this_apply");
    s.u(paramb, "this$0");
    paramView2.setVisibility(8);
    paramView1 = paramView1.findViewById(e.e.progress);
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    h.ahAA.bm(new g.b..ExternalSyntheticLambda1(paramb));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(363963);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(363953);
    s.u(paramb, "this$0");
    paramb.ebL().requestRefresh();
    AppMethodBeat.o(363953);
  }
  
  private final void ebY()
  {
    AppMethodBeat.i(363940);
    View localView = getEmptyView();
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(e.e.empty_tip);
    if (localView != null) {
      localView.setVisibility(4);
    }
    localView = findViewById(e.e.retry_tip);
    if (localView != null) {
      localView.setVisibility(4);
    }
    localView = findViewById(e.e.progress);
    if (localView != null) {
      localView.setVisibility(4);
    }
    this.ATx.setVisibility(0);
    AppMethodBeat.o(363940);
  }
  
  private final void ebZ()
  {
    AppMethodBeat.i(363947);
    Object localObject = this.ATx.getLoadMoreFooter();
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)((TextView)localObject).getContext().getResources().getString(e.h.finder_load_more_footer_tip));
        ((TextView)localObject).setVisibility(0);
      }
    }
    localObject = this.ATx.getLoadMoreFooter();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((View)localObject).findViewById(e.e.load_more_footer_end_layout))
    {
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      AppMethodBeat.o(363947);
      return;
    }
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(364078);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    localb.sc(paramInt);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, localb.aYj());
    s.u(parama, "adapter");
    s.u(paramView, "view");
    paramView = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
    com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999706);
    paramInt -= ((com.tencent.mm.view.recyclerview.i)parama).agOb.size();
    if ((paramInt >= 0) && (paramInt < ebL().ALH.getSize()))
    {
      parama = (cc)ebL().ALH.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
        AppMethodBeat.o(364078);
        return;
      }
      Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      paramView = new Intent();
      BaseFeedLoader.saveCache$default((BaseFeedLoader)ebL().ALH, paramView, paramInt, null, 4, null);
      parama = ebL().ALH;
      if (!(parama instanceof FinderFavFeedLoader)) {
        break label308;
      }
      parama = (FinderFavFeedLoader)parama;
      if (parama != null) {
        break label313;
      }
    }
    label308:
    label313:
    for (long l = 0L;; l = parama.BfA)
    {
      paramView.putExtra("key_active_topic_id", l);
      parama = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.p((Activity)this.lzt, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback", "com/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallbackcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback", "onGridItemClick", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
      AppMethodBeat.o(364078);
      return;
      parama = null;
      break;
    }
  }
  
  public final void ae(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(363999);
    s.u(paramArrayList, "data");
    super.ae(paramArrayList);
    TextView localTextView = (TextView)findViewById(e.e.empty_tip);
    if (localTextView != null)
    {
      paramArrayList = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() != 0) {
        break label78;
      }
    }
    label78:
    for (paramArrayList = (CharSequence)this.lzt.getString(e.h.finder_fav_empty_tips);; paramArrayList = (CharSequence)this.lzt.getString(e.h.finder_fav_empty_tips2))
    {
      localTextView.setText(paramArrayList);
      AppMethodBeat.o(363999);
      return;
    }
  }
  
  public final String b(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(364089);
    s.u(paramd, "reason");
    paramd = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0)
    {
      paramd = this.lzt.getResources().getString(e.h.finder_fav_list_title);
      AppMethodBeat.o(364089);
      return paramd;
    }
    paramd = this.lzt.getResources().getString(e.h.finder_fav_list_title2);
    AppMethodBeat.o(364089);
    return paramd;
  }
  
  public final String c(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(364093);
    s.u(paramd, "reason");
    if (paramd.extra == null)
    {
      AppMethodBeat.o(364093);
      return null;
    }
    if ((paramd.extra instanceof Integer))
    {
      Resources localResources = this.lzt.getResources();
      int i = e.h.finder_fav_list_desc;
      paramd = paramd.extra;
      if (paramd == null)
      {
        paramd = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(364093);
        throw paramd;
      }
      paramd = localResources.getString(i, new Object[] { Integer.valueOf(((Integer)paramd).intValue()) });
      AppMethodBeat.o(364093);
      return paramd;
    }
    AppMethodBeat.o(364093);
    return null;
  }
  
  public final void cul()
  {
    AppMethodBeat.i(364038);
    View localView = getEmptyView();
    if (localView != null)
    {
      localView.setVisibility(0);
      Object localObject = (TextView)localView.findViewById(e.e.empty_tip);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = localView.findViewById(e.e.progress);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localView = localView.findViewById(e.e.retry_tip);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(364038);
  }
  
  public final void dUO()
  {
    AppMethodBeat.i(364047);
    if ((ebL().ALH.getSize() <= ebK() * 3) && (((FinderFavFeedLoader)ebL().ALH).hasMore)) {
      ebO();
    }
    Object localObject = (FinderFavFeedLoader)ebL().ALH;
    ((FinderFavFeedLoader)localObject).lNX -= 1;
    int i = ((FinderFavFeedLoader)localObject).lNX;
    localObject = this.ATL;
    if (localObject == null) {}
    for (localObject = null;; localObject = (TextView)((View)localObject).findViewById(e.e.desc))
    {
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)this.lzt.getResources().getString(e.h.finder_fav_list_desc, new Object[] { Integer.valueOf(i) }));
      }
      AppMethodBeat.o(364047);
      return;
    }
  }
  
  public final void eca()
  {
    int j = 0;
    AppMethodBeat.i(364010);
    int i;
    int k;
    if (((FinderFavFeedLoader)ebL().ALH).BfA == 0L)
    {
      i = 1;
      localObject = this.ATx.getLoadMoreFooter();
      if (localObject != null)
      {
        localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
        if (localObject != null)
        {
          if (i == 0) {
            break label220;
          }
          k = ((FinderFavFeedLoader)ebL().ALH).lNX;
          com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() != 0) {
            break label184;
          }
          ((TextView)localObject).setText((CharSequence)((TextView)localObject).getContext().getResources().getString(e.h.finder_fav_feed_footer_hint, new Object[] { Integer.valueOf(k) }));
          label131:
          ((TextView)localObject).setVisibility(0);
        }
      }
      label137:
      localObject = this.ATx.getLoadMoreFooter();
      if (localObject != null) {
        break label230;
      }
    }
    label184:
    label220:
    label230:
    for (Object localObject = null;; localObject = ((View)localObject).findViewById(e.e.load_more_footer_end_layout))
    {
      if (localObject != null)
      {
        if (i != 0) {
          j = 8;
        }
        ((View)localObject).setVisibility(j);
      }
      AppMethodBeat.o(364010);
      return;
      i = 0;
      break;
      ((TextView)localObject).setText((CharSequence)((TextView)localObject).getContext().getResources().getString(e.h.finder_fav_feed_footer_hint2, new Object[] { Integer.valueOf(k) }));
      break label131;
      ((TextView)localObject).setVisibility(8);
      break label137;
    }
  }
  
  public final boolean f(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(364014);
    s.u(paramd, "reason");
    AppMethodBeat.o(364014);
    return true;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(364061);
    s.u(paramContext, "context");
    paramContext = dUN().fT(paramContext);
    AppMethodBeat.o(364061);
    return paramContext;
  }
  
  public final void g(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(364025);
    s.u(paramd, "reason");
    View localView = getEmptyView();
    if (localView != null)
    {
      Object localObject = this.ATx.getRecyclerView().getAdapter();
      if ((localObject instanceof WxRecyclerAdapter))
      {
        localObject = (WxRecyclerAdapter)localObject;
        if (paramd.agJs == -1) {
          break label159;
        }
        if (localObject != null) {
          break label95;
        }
      }
      label95:
      for (i = 0;; i = ((com.tencent.mm.view.recyclerview.i)localObject).jNl())
      {
        if (i > 0) {
          break label103;
        }
        cul();
        paramd = this.ATx;
        if (paramd == null) {
          break label300;
        }
        paramd.setVisibility(0);
        AppMethodBeat.o(364025);
        return;
        localObject = null;
        break;
      }
      label103:
      localView.setVisibility(8);
      localObject = this.ATx;
      if (localObject != null) {
        ((RefreshLoadMoreLayout)localObject).setVisibility(0);
      }
      if (!paramd.agJu)
      {
        eca();
        paramd = this.ATx.getLoadMoreFooter();
        if (paramd != null)
        {
          paramd.setVisibility(0);
          AppMethodBeat.o(364025);
          return;
          label159:
          localView.setVisibility(0);
          paramd = (TextView)localView.findViewById(e.e.empty_tip);
          if (paramd != null) {
            paramd.setVisibility(8);
          }
          paramd = (TextView)localView.findViewById(e.e.retry_tip);
          if (paramd != null) {
            paramd.setVisibility(0);
          }
          paramd = localView.findViewById(e.e.progress);
          if (paramd != null) {
            paramd.setVisibility(8);
          }
          paramd = localView.findViewById(e.e.retry_tip);
          if (paramd != null) {
            paramd.setOnClickListener(new g.b..ExternalSyntheticLambda0(localView, this));
          }
          paramd = ((FinderFavFeedLoader)ebL().ALH).getDataList();
          if (((Collection)paramd).isEmpty()) {
            break label307;
          }
        }
      }
    }
    label300:
    label307:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramd.clear();
        ebL().ALH.onDataChanged();
      }
      AppMethodBeat.o(364025);
      return;
    }
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(364056);
    View localView = findViewById(e.e.empty_view);
    if ((localView instanceof View))
    {
      AppMethodBeat.o(364056);
      return localView;
    }
    AppMethodBeat.o(364056);
    return null;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(364042);
    RecyclerView.h localh = dUN().getItemDecoration();
    AppMethodBeat.o(364042);
    return localh;
  }
  
  public final void h(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(364031);
    s.u(paramd, "reason");
    super.h(paramd);
    if (!paramd.agJu) {
      eca();
    }
    AppMethodBeat.o(364031);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "selected", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<bxv, Boolean, ah>
  {
    a(g.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.g.b
 * JD-Core Version:    0.7.0.1
 */