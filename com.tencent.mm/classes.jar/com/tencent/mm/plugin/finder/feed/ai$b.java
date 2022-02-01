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
import com.tencent.mm.plugin.finder.convert.af;
import com.tencent.mm.plugin.finder.convert.af.a;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.d.c;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallBackTagWrapper;", "context", "Lcom/tencent/mm/ui/MMActivity;", "type", "", "topic", "", "activity", "presenter", "(Lcom/tencent/mm/ui/MMActivity;ILjava/lang/String;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedPresenter;)V", "TAG", "VIEW_TYPE_FOOTER", "VIEW_TYPE_HEADER", "VIEW_TYPR_LOADING_HEADER", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "footerView", "Landroid/view/View;", "gridSpanCount", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "loadingHeader", "progressBar", "recyclerBg", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "refreshTip", "Landroid/widget/TextView;", "getTopic", "()Ljava/lang/String;", "topicHeader", "getType", "()I", "addLoadingHeader", "", "addTagsHeader", "tagsData", "Lcom/tencent/mm/protocal/protobuf/RelatedTopic;", "dimissLoadingHeader", "finishLoadMore", "startPos", "increment", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "hasMore", "", "finishRefresh", "subTitle", "totalCount", "", "getActivity", "getPresenter", "getRootView", "hideLoadFooter", "initView", "onDetach", "refreshSubTile", "showLoadError", "errMsg", "showLoadFooter", "text", "showProgress", "show", "showProgressHeader", "ifShow", "showRefreshTip", "tip", "textColor", "clickable", "plugin-finder_release"})
public final class ai$b
  implements com.tencent.mm.plugin.finder.presenter.base.b, com.tencent.mm.plugin.finder.presenter.base.c<ai.a>
{
  final String TAG;
  MMActivity activity;
  final String dol;
  final MMActivity iMV;
  View nzT;
  View progressBar;
  WxRecyclerAdapter<?> rfX;
  final int rgk;
  final int rgl;
  r rgm;
  private int rjc;
  h rkw;
  ai.a rlS;
  View rlT;
  public WxRecyclerView rlU;
  View rlV;
  TextView rlW;
  private View rlX;
  final int rlY;
  final int type;
  
  public ai$b(MMActivity paramMMActivity1, int paramInt, String paramString, MMActivity paramMMActivity2, ai.a parama)
  {
    AppMethodBeat.i(202023);
    this.iMV = paramMMActivity1;
    this.type = paramInt;
    this.dol = paramString;
    this.TAG = "Finder.FinderTopicFeedUIContract.TopicFeedViewCallback";
    this.activity = paramMMActivity2;
    this.rlS = parama;
    this.rgl = -1;
    this.rlY = -2;
    this.rjc = 3;
    this.rkw = new h(new cnx());
    paramMMActivity1 = com.tencent.mm.plugin.finder.utils.d.rOJ;
    this.rgm = com.tencent.mm.plugin.finder.utils.d.cCM();
    AppMethodBeat.o(202023);
  }
  
  private void cvx()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(202021);
        if (this.rlX == null) {
          this.rlX = z.jD((Context)this.activity).inflate(2131496225, null);
        }
        Object localObject3 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("ken loading header:");
        Object localObject1 = this.rlX;
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).getParent();
          ac.d((String)localObject3, localObject1);
          localObject1 = this.rlX;
          if (localObject1 != null)
          {
            localObject1 = ((View)localObject1).getParent();
            if (localObject1 == null) {
              continue;
            }
            AppMethodBeat.o(202021);
          }
        }
        else
        {
          localObject1 = null;
          continue;
        }
        localObject1 = null;
        continue;
        if (this.rlX != null)
        {
          localObject1 = this.rfX;
          if (localObject1 != null)
          {
            localObject3 = this.rlX;
            if (localObject3 == null) {
              k.fOy();
            }
            ((WxRecyclerAdapter)localObject1).f((View)localObject3, this.rlY, true);
            AppMethodBeat.o(202021);
            continue;
          }
        }
        AppMethodBeat.o(202021);
      }
      finally {}
    }
  }
  
  public final void adB(String paramString)
  {
    AppMethodBeat.i(165972);
    k.h(paramString, "text");
    if (this.nzT == null) {
      this.nzT = View.inflate((Context)this.activity, 2131494060, null);
    }
    Object localObject = this.rlU;
    if (localObject == null) {
      k.aVY("recyclerView");
    }
    localObject = ((WxRecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
      AppMethodBeat.o(165972);
      throw paramString;
    }
    localObject = (com.tencent.mm.view.recyclerview.d)localObject;
    View localView = this.nzT;
    if (localView == null) {
      k.fOy();
    }
    ((com.tencent.mm.view.recyclerview.d)localObject).g(localView, this.rgl, true);
    localObject = this.nzT;
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
    AppMethodBeat.i(202019);
    WxRecyclerView localWxRecyclerView = this.rlU;
    if (localWxRecyclerView == null) {
      k.aVY("recyclerView");
    }
    AppMethodBeat.o(202019);
    return localWxRecyclerView;
  }
  
  public final View getRootView()
  {
    AppMethodBeat.i(202022);
    View localView = this.activity.findViewById(2131308039);
    k.g(localView, "activity.findViewById(R.id.topic_root_layout)");
    AppMethodBeat.o(202022);
    return localView;
  }
  
  public final void lA(final boolean paramBoolean)
  {
    AppMethodBeat.i(165973);
    com.tencent.mm.ac.c.g((d.g.a.a)new h(this, paramBoolean));
    AppMethodBeat.o(165973);
  }
  
  public final void lz(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(202020);
        ac.d(this.TAG, "showProgressHeader = ".concat(String.valueOf(paramBoolean)));
        if (paramBoolean)
        {
          cvx();
          AppMethodBeat.o(202020);
          return;
        }
        if (this.rlX != null)
        {
          WxRecyclerAdapter localWxRecyclerAdapter = this.rfX;
          if (localWxRecyclerAdapter != null)
          {
            View localView = this.rlX;
            if (localView == null) {
              k.fOy();
            }
            localWxRecyclerAdapter.L(localView.hashCode(), true);
            AppMethodBeat.o(202020);
            continue;
          }
        }
        AppMethodBeat.o(202020);
      }
      finally {}
    }
  }
  
  public final void n(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(165974);
    com.tencent.mm.ac.c.g((d.g.a.a)new i(this, paramString, paramBoolean, paramInt));
    AppMethodBeat.o(165974);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onViewAttachedToWindow", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class a
    extends WxRecyclerAdapter<BaseFinderFeed>
  {
    a(com.tencent.mm.view.recyclerview.c paramc, ArrayList paramArrayList)
    {
      super(localArrayList);
    }
    
    public final void e(e parame)
    {
      AppMethodBeat.i(202009);
      k.h(parame, "holder");
      super.e(parame);
      Object localObject = parame.asD;
      k.g(localObject, "holder.itemView");
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
      {
        if ((parame.ly() == this.rlZ.rgk) || (parame.ly() == this.rlZ.rgl) || (parame.ly() == this.rlZ.rlY))
        {
          ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(true);
          AppMethodBeat.o(202009);
          return;
        }
        if (parame.getTag() != null)
        {
          parame = parame.getTag();
          af.a locala = af.rcj;
          if (k.g(parame, Integer.valueOf(af.cta()))) {
            ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(true);
          }
        }
      }
      AppMethodBeat.o(202009);
    }
    
    public final void t(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(202011);
      k.h(paramRecyclerView, "recyclerView");
      Object localObject = FinderReporterUIC.seQ;
      localObject = FinderReporterUIC.a.eV((Context)this.rlZ.iMV);
      if (localObject != null)
      {
        localObject = FinderReporterUIC.d((FinderReporterUIC)localObject);
        if (localObject != null)
        {
          ((f)localObject).ctt().b(paramRecyclerView, 5);
          AppMethodBeat.o(202011);
          return;
        }
      }
      AppMethodBeat.o(202011);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "it", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Integer, com.tencent.mm.view.recyclerview.b<?>>
  {
    b(ai.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ai.b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202013);
      this.rlZ.rlS.requestRefresh();
      AppMethodBeat.o(202013);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$4", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
  public static final class d
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(202014);
      ai.b.b(this.rlZ).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      Object localObject = ai.b.b(this.rlZ).getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(202014);
        throw ((Throwable)localObject);
      }
      localObject = (FrameLayout.LayoutParams)localObject;
      ((FrameLayout.LayoutParams)localObject).topMargin = ai.b.c(this.rlZ).getHeight();
      ac.i(this.rlZ.TAG, "header height " + ai.b.c(this.rlZ).getHeight());
      ai.b.b(this.rlZ).setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(202014);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$5", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202016);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt1);
      localb.lS(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      paramInt1 = paramRecyclerView.computeVerticalScrollOffset();
      ai.b.b(this.rlZ).setTranslationY(-paramInt1);
      ac.d(this.rlZ.TAG, "scroll dy %d, translationY %f", new Object[] { Integer.valueOf(paramInt2), Float.valueOf(ai.b.b(this.rlZ).getTranslationY()) });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(202016);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(202015);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
      k.h(paramRecyclerView, "recyclerView");
      if ((paramInt == 0) || (paramInt == 1))
      {
        if (((Collection)this.rlZ.rlS.dataList).isEmpty()) {
          break label186;
        }
        paramInt = 1;
        if ((paramInt != 0) && (this.rlZ.rgm.x(paramRecyclerView)))
        {
          ac.i(this.rlZ.TAG, "scroll to the end, load more data");
          paramRecyclerView = this.rlZ.rlS;
          if (!ai.a.b(paramRecyclerView.rkv)) {
            break label191;
          }
          paramRecyclerView.rlI.a(paramRecyclerView.rlK, null);
        }
      }
      for (;;)
      {
        paramRecyclerView = this.rlZ;
        localObject = this.rlZ.activity.getString(2131755804);
        k.g(localObject, "activity.getString(R.string.app_loading)");
        paramRecyclerView.adB((String)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(202015);
        return;
        label186:
        paramInt = 0;
        break;
        label191:
        localObject = new cnx();
        ((cnx)localObject).FBb = new LinkedList();
        ((cnx)localObject).FBb.add(paramRecyclerView.rkv);
        paramRecyclerView.rlI.a(paramRecyclerView.rlK, (cnx)localObject);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$6", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "plugin-finder_release"})
  public static final class f
    implements d.c
  {
    public final void b(RecyclerView.a<?> parama, View paramView, int paramInt)
    {
      AppMethodBeat.i(202017);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(parama);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bb(paramView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$6", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", "onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
      k.h(parama, "adapter");
      k.h(paramView, "view");
      paramInt -= ((com.tencent.mm.view.recyclerview.d)parama).JCb.size();
      Intent localIntent;
      long l;
      if ((paramInt >= 0) && (paramInt < this.rlZ.rlS.dataList.size()))
      {
        localObject = ((BaseFinderFeed)this.rlZ.rlS.dataList.get(paramInt)).feedObject;
        ac.i(this.rlZ.TAG, "onClick " + paramInt + " id:" + ((FinderItem)localObject).getId() + ", pos:" + paramInt);
        localIntent = new Intent();
        localIntent.putExtra("key_topic_type", this.rlZ.type);
        localIntent.putExtra("key_topic_title", this.rlZ.dol);
        localIntent.putExtra("KEY_CLICK_FEED_ID", ((FinderItem)localObject).getId());
        localIntent.putExtra("KEY_CLICK_FEED_POSITION", paramInt);
        l = System.currentTimeMillis();
        com.tencent.mm.bw.b localb = this.rlZ.rlS.rlI.adC(this.rlZ.rlS.rkv.dol);
        if (!ai.a.b(this.rlZ.rlS.rkv)) {
          break label593;
        }
        parama = null;
        aj.a locala = aj.rmg;
        aj.a.a(l, (List)this.rlZ.rlS.dataList, localb, parama);
        localIntent.putExtra("KEY_CACHE_ID", l);
        localIntent.putExtra("key_ref_object_id", this.rlZ.activity.getIntent().getLongExtra("key_ref_object_id", 0L));
        parama = this.rlZ.rlS.rlI.rnp;
        if (parama == null) {
          break label633;
        }
        parama = parama.toByteArray();
        label360:
        localIntent.putExtra("KEY_FINDER_LOCATION", parama);
        if (this.rlZ.rlS.rlI.qYj != null)
        {
          parama = this.rlZ.rlS.rlI.qYj;
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
        ac.i(this.rlZ.TAG, "enterTopicTimelineUI, cacheId:" + l + ", fixPos:" + paramInt);
        parama = FinderReporterUIC.seQ;
        parama = paramView.getContext();
        k.g(parama, "view.context");
        FinderReporterUIC.a.a(parama, localIntent, 0L, 0, false, 124);
        parama = com.tencent.mm.plugin.finder.utils.a.rOv;
        parama = paramView.getContext();
        k.g(parama, "view.context");
        com.tencent.mm.plugin.finder.utils.a.J(parama, localIntent);
        parama = com.tencent.mm.plugin.finder.report.d.rxr;
        com.tencent.mm.plugin.finder.report.d.I(((FinderItem)localObject).getId(), 2);
        parama = FinderReporterUIC.seQ;
        parama = paramView.getContext();
        k.g(parama, "view.context");
        parama = FinderReporterUIC.a.eV(parama);
        if (parama != null)
        {
          parama = parama.cGb();
          if (parama != null)
          {
            paramView = com.tencent.mm.plugin.finder.report.d.rxr;
            com.tencent.mm.plugin.finder.report.d.a(parama, ((FinderItem)localObject).getId(), (RecyclerView)this.rlZ.getRecyclerView());
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$6", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$initView$com/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener", "onItemClick", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/view/View;I)V");
        AppMethodBeat.o(202017);
        return;
        parama = new cnx();
        parama.FBb = new LinkedList();
        parama.FBb.add(this.rlZ.rlS.rkv);
        break;
        parama = null;
        break label360;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$refreshSubTile$1$1$1", "com/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$TopicFeedViewCallback$$special$$inlined$let$lambda$1"})
  static final class g
    implements View.OnClickListener
  {
    g(alt paramalt, byte[] paramArrayOfByte, ai.b paramb, String paramString) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202018);
      paramView = com.tencent.mm.plugin.finder.utils.n.rPN;
      com.tencent.mm.plugin.finder.utils.n.a((Context)this.rlZ.activity, this.rma);
      AppMethodBeat.o(202018);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(ai.b paramb, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(ai.b paramb, String paramString, boolean paramBoolean, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ai.b
 * JD-Core Version:    0.7.0.1
 */