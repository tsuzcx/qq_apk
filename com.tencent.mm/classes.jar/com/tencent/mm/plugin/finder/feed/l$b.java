package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.am;
import com.tencent.mm.plugin.finder.convert.am.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.ebq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.d;
import com.tencent.mm.view.recyclerview.d.c;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "context", "Lcom/tencent/mm/ui/MMActivity;", "type", "", "topic", "", "activity", "presenter", "(Lcom/tencent/mm/ui/MMActivity;ILjava/lang/String;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;)V", "TAG", "VIEW_TYPE_FOOTER", "VIEW_TYPE_HEADER", "VIEW_TYPR_LOADING_HEADER", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "footerView", "Landroid/view/View;", "gridSpanCount", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "loadingHeader", "progressBar", "recyclerBg", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "refreshTip", "Landroid/widget/TextView;", "getTopic", "()Ljava/lang/String;", "topicHeader", "getType", "()I", "addLoadingHeader", "", "addTagsHeader", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "dimissLoadingHeader", "finishLoadMore", "startPos", "increment", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "hasMore", "", "finishRefresh", "subTitle", "totalCount", "", "getActivity", "getPresenter", "getRootView", "hideLoadFooter", "initView", "onDetach", "refreshSubTile", "showLoadError", "errMsg", "showLoadFooter", "text", "showProgress", "show", "showProgressHeader", "ifShow", "showRefreshTip", "tip", "textColor", "clickable", "plugin-finder_release"})
public final class l$b
  implements com.tencent.mm.plugin.finder.presenter.base.b<l.a>, com.tencent.mm.plugin.finder.presenter.base.c
{
  com.tencent.mm.plugin.finder.storage.v KMT;
  private int KNS;
  x KOL;
  public WxRecyclerView KPx;
  private View KPy;
  final int KPz;
  final String TAG;
  MMActivity activity;
  final String dqA;
  final MMActivity imP;
  View mXu;
  View progressBar;
  WxRecyclerAdapter<?> qul;
  l.a qxF;
  View qxG;
  View qxH;
  TextView qxI;
  final int qxJ;
  final int qxK;
  final int type;
  
  public l$b(MMActivity paramMMActivity1, int paramInt, String paramString, MMActivity paramMMActivity2, l.a parama)
  {
    AppMethodBeat.i(198115);
    this.imP = paramMMActivity1;
    this.type = paramInt;
    this.dqA = paramString;
    this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedViewCallback";
    this.activity = paramMMActivity2;
    this.qxF = parama;
    this.qxK = -1;
    this.KPz = -2;
    this.KNS = 3;
    this.KOL = new x(new ebq());
    paramMMActivity1 = o.LaG;
    this.KMT = o.fVP();
    AppMethodBeat.o(198115);
  }
  
  private void fTu()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(198113);
        if (this.KPy == null) {
          this.KPy = com.tencent.mm.ui.y.js((Context)this.activity).inflate(2131496224, null);
        }
        Object localObject3 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("ken loading header:");
        Object localObject1 = this.KPy;
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).getParent();
          ad.d((String)localObject3, localObject1);
          localObject1 = this.KPy;
          if (localObject1 != null)
          {
            localObject1 = ((View)localObject1).getParent();
            if (localObject1 == null) {
              continue;
            }
            AppMethodBeat.o(198113);
          }
        }
        else
        {
          localObject1 = null;
          continue;
        }
        localObject1 = null;
        continue;
        if (this.KPy != null)
        {
          localObject1 = this.qul;
          if (localObject1 != null)
          {
            localObject3 = this.KPy;
            if (localObject3 == null) {
              k.fvU();
            }
            ((WxRecyclerAdapter)localObject1).f((View)localObject3, this.KPz, true);
            AppMethodBeat.o(198113);
            continue;
          }
        }
        AppMethodBeat.o(198113);
      }
      finally {}
    }
  }
  
  public final void YZ(String paramString)
  {
    AppMethodBeat.i(165972);
    k.h(paramString, "text");
    if (this.mXu == null) {
      this.mXu = View.inflate((Context)this.activity, 2131494060, null);
    }
    Object localObject = this.KPx;
    if (localObject == null) {
      k.aPZ("recyclerView");
    }
    localObject = ((WxRecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(165972);
      throw paramString;
    }
    localObject = (d)localObject;
    View localView = this.mXu;
    if (localView == null) {
      k.fvU();
    }
    ((d)localObject).g(localView, this.qxK, true);
    localObject = this.mXu;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131302534);
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)paramString);
        AppMethodBeat.o(165972);
        return;
      }
    }
    AppMethodBeat.o(165972);
  }
  
  public final MMActivity getActivity()
  {
    return this.activity;
  }
  
  public final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(198111);
    WxRecyclerView localWxRecyclerView = this.KPx;
    if (localWxRecyclerView == null) {
      k.aPZ("recyclerView");
    }
    AppMethodBeat.o(198111);
    return localWxRecyclerView;
  }
  
  public final View getRootView()
  {
    AppMethodBeat.i(198114);
    View localView = this.activity.findViewById(2131307899);
    k.g(localView, "activity.findViewById(R.id.topic_root_layout)");
    AppMethodBeat.o(198114);
    return localView;
  }
  
  public final void kV(final boolean paramBoolean)
  {
    AppMethodBeat.i(165973);
    com.tencent.mm.ad.c.g((d.g.a.a)new i(this, paramBoolean));
    AppMethodBeat.o(165973);
  }
  
  public final void n(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(165974);
    com.tencent.mm.ad.c.g((d.g.a.a)new j(this, paramString, paramBoolean, paramInt));
    AppMethodBeat.o(165974);
  }
  
  public final void yC(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(198112);
        ad.d(this.TAG, "showProgressHeader = ".concat(String.valueOf(paramBoolean)));
        if (paramBoolean)
        {
          fTu();
          AppMethodBeat.o(198112);
          return;
        }
        if (this.KPy != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = this.qul;
          if (localWxRecyclerAdapter != null)
          {
            View localView = this.KPy;
            if (localView == null) {
              k.fvU();
            }
            localWxRecyclerAdapter.i(localView.hashCode(), true);
            AppMethodBeat.o(198112);
            continue;
          }
        }
        AppMethodBeat.o(198112);
      }
      finally {}
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Integer, com.tencent.mm.view.recyclerview.b<?>>
  {
    a(l.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$6", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "plugin-finder_release"})
  public static final class b
    implements d.c
  {
    public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
    {
      AppMethodBeat.i(198109);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).be(parama);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$6", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", "onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
      k.h(parama, "adapter");
      k.h(paramView, "view");
      paramInt -= ((d)parama).Ibl.size();
      Intent localIntent;
      long l;
      if ((paramInt >= 0) && (paramInt < this.qxL.qxF.dataList.size()))
      {
        localObject = ((BaseFinderFeed)this.qxL.qxF.dataList.get(paramInt)).feedObject;
        ad.i(this.qxL.TAG, "onClick " + paramInt + " id:" + ((FinderItem)localObject).getId() + ", pos:" + paramInt);
        localIntent = new Intent();
        localIntent.putExtra("key_topic_type", this.qxL.type);
        localIntent.putExtra("key_topic_title", this.qxL.dqA);
        localIntent.putExtra("KEY_CLICK_FEED_ID", ((FinderItem)localObject).getId());
        localIntent.putExtra("KEY_CLICK_FEED_POSITION", paramInt);
        l = System.currentTimeMillis();
        com.tencent.mm.bx.b localb = this.qxL.qxF.qxz.aVl(this.qxL.qxF.KOK.dqA);
        if (!l.a.b(this.qxL.qxF.KOK)) {
          break label593;
        }
        parama = null;
        m.a locala = m.qxS;
        m.a.a(l, (List)this.qxL.qxF.dataList, localb, parama);
        localIntent.putExtra("KEY_CACHE_ID", l);
        localIntent.putExtra("key_ref_object_id", this.qxL.activity.getIntent().getLongExtra("key_ref_object_id", 0L));
        parama = this.qxL.qxF.qxz.qyK;
        if (parama == null) {
          break label633;
        }
        parama = parama.toByteArray();
        label360:
        localIntent.putExtra("KEY_FINDER_LOCATION", parama);
        if (this.qxL.qxF.qxz.KJJ != null)
        {
          parama = this.qxL.qxF.qxz.KJJ;
          if (parama == null) {
            break label638;
          }
        }
      }
      label593:
      label633:
      label638:
      for (parama = parama.toByteArray();; parama = null)
      {
        localIntent.putExtra("KEY_SECTION_INFO", parama);
        ad.i(this.qxL.TAG, "enterTopicTimelineUI, cacheId:" + l + ", fixPos:" + paramInt);
        parama = FinderReporterUIC.Ljl;
        parama = paramView.getContext();
        k.g(parama, "view.context");
        FinderReporterUIC.a.a(parama, localIntent, 0L, 0, false, 124);
        parama = com.tencent.mm.plugin.finder.utils.a.qSb;
        parama = paramView.getContext();
        k.g(parama, "view.context");
        com.tencent.mm.plugin.finder.utils.a.G(parama, localIntent);
        parama = com.tencent.mm.plugin.finder.report.b.qFq;
        com.tencent.mm.plugin.finder.report.b.F(((FinderItem)localObject).getId(), 2);
        parama = FinderReporterUIC.Ljl;
        parama = paramView.getContext();
        k.g(parama, "view.context");
        parama = FinderReporterUIC.a.lB(parama);
        if (parama != null)
        {
          parama = parama.fXs();
          if (parama != null)
          {
            paramView = com.tencent.mm.plugin.finder.report.b.qFq;
            com.tencent.mm.plugin.finder.report.b.a(parama, ((FinderItem)localObject).getId(), (RecyclerView)this.qxL.getRecyclerView());
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$6", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", "onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
        AppMethodBeat.o(198109);
        return;
        parama = new ebq();
        parama.LAk = new LinkedList();
        parama.LAk.add(this.qxL.qxF.KOK);
        break;
        parama = null;
        break label360;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onViewAttachedToWindow", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class c
    extends WxRecyclerAdapter<BaseFinderFeed>
  {
    c(com.tencent.mm.view.recyclerview.c paramc, ArrayList paramArrayList)
    {
      super(localArrayList);
    }
    
    public final void e(com.tencent.mm.view.recyclerview.e parame)
    {
      AppMethodBeat.i(198101);
      k.h(parame, "holder");
      super.e(parame);
      Object localObject = parame.arI;
      k.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        if ((parame.lp() == this.qxL.qxJ) || (parame.lp() == this.qxL.qxK) || (parame.lp() == this.qxL.KPz))
        {
          ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(true);
          AppMethodBeat.o(198101);
          return;
        }
        if (parame.getTag() != null)
        {
          parame = parame.getTag();
          am.a locala = am.KLu;
          if (k.g(parame, Integer.valueOf(am.fSk()))) {
            ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(true);
          }
        }
      }
      AppMethodBeat.o(198101);
    }
    
    public final void w(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(198103);
      k.h(paramRecyclerView, "recyclerView");
      Object localObject = FinderReporterUIC.Ljl;
      localObject = FinderReporterUIC.a.lB((Context)this.qxL.imP);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.d((FinderReporterUIC)localObject);
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.finder.event.base.e)localObject).fSD().b(paramRecyclerView, 5);
          AppMethodBeat.o(198103);
          return;
        }
      }
      AppMethodBeat.o(198103);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(l.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198105);
      this.qxL.qxF.requestRefresh();
      AppMethodBeat.o(198105);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$4", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
  public static final class e
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(198106);
      l.b.b(this.qxL).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      Object localObject = l.b.b(this.qxL).getLayoutParams();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(198106);
        throw ((Throwable)localObject);
      }
      localObject = (FrameLayout.LayoutParams)localObject;
      ((FrameLayout.LayoutParams)localObject).topMargin = l.b.c(this.qxL).getHeight();
      ad.i(this.qxL.TAG, "header height " + l.b.c(this.qxL).getHeight());
      l.b.b(this.qxL).setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(198106);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$5", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(198108);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      paramInt1 = paramRecyclerView.computeVerticalScrollOffset();
      l.b.b(this.qxL).setTranslationY(-paramInt1);
      ad.d(this.qxL.TAG, "scroll dy %d, translationY %f", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(l.b.b(this.qxL).getTranslationY()) });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(198108);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(198107);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).be(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
      k.h(paramRecyclerView, "recyclerView");
      if ((paramInt == 0) || (paramInt == 1))
      {
        if (((Collection)this.qxL.qxF.dataList).isEmpty()) {
          break label186;
        }
        paramInt = 1;
        if ((paramInt != 0) && (this.qxL.KMT.A(paramRecyclerView)))
        {
          ad.i(this.qxL.TAG, "scroll to the end, load more data");
          paramRecyclerView = this.qxL.qxF;
          if (!l.a.b(paramRecyclerView.KOK)) {
            break label191;
          }
          paramRecyclerView.qxz.a(paramRecyclerView.KPs, null);
        }
      }
      for (;;)
      {
        paramRecyclerView = this.qxL;
        localObject = this.qxL.activity.getString(2131755804);
        k.g(localObject, "activity.getString(R.string.app_loading)");
        paramRecyclerView.YZ((String)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(198107);
        return;
        label186:
        paramInt = 0;
        break;
        label191:
        localObject = new ebq();
        ((ebq)localObject).LAk = new LinkedList();
        ((ebq)localObject).LAk.add(paramRecyclerView.KOK);
        paramRecyclerView.qxz.a(paramRecyclerView.KPs, (ebq)localObject);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshSubTile$1$1$1", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$$special$$inlined$let$lambda$1"})
  static final class g
    implements View.OnClickListener
  {
    g(ajq paramajq, byte[] paramArrayOfByte, l.b paramb, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198110);
      paramView = com.tencent.mm.plugin.finder.utils.i.qTa;
      com.tencent.mm.plugin.finder.utils.i.a((Context)this.qxL.activity, this.KPA);
      AppMethodBeat.o(198110);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    i(l.b paramb, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    j(l.b paramb, String paramString, boolean paramBoolean, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.l.b
 * JD-Core Version:    0.7.0.1
 */