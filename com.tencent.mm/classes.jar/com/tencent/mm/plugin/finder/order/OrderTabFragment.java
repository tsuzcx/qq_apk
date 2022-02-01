package com.tencent.mm.plugin.finder.order;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.order.data.b.b;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.protocal.protobuf.alq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/OrderTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "type", "", "(I)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/order/data/OrderFeedLoader;", "hasMore", "", "loadingView", "Landroid/view/View;", "mergeDataAndRefresh", "Lkotlin/Function5;", "Lcom/tencent/mm/protocal/protobuf/EcCustomerGetOrderListResp;", "", "noResultView", "Landroid/widget/TextView;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "refreshed", "retryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getType", "()I", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onUserVisibleFocused", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "refresh", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OrderTabFragment
  extends MMFinderFragment
{
  private RefreshLoadMoreLayout ATx;
  private WxRecyclerView AZd;
  private TextView BnA;
  private View BsS;
  private final kotlin.g.a.s<Integer, Integer, alq, Integer, Integer, ah> BsV;
  private com.tencent.mm.plugin.finder.order.data.b ESe;
  private boolean ESf;
  private boolean hasMore;
  private View njN;
  private final int type;
  
  public OrderTabFragment(int paramInt)
  {
    AppMethodBeat.i(332260);
    this.type = paramInt;
    this.hasMore = true;
    this.BsV = ((kotlin.g.a.s)new a(this));
    AppMethodBeat.o(332260);
  }
  
  private static final void a(OrderTabFragment paramOrderTabFragment, View paramView)
  {
    AppMethodBeat.i(332289);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramOrderTabFragment);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/order/OrderTabFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramOrderTabFragment, "this$0");
    paramOrderTabFragment.bDL();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/order/OrderTabFragment", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(332289);
  }
  
  private final void bDL()
  {
    Object localObject2 = null;
    AppMethodBeat.i(332274);
    Object localObject3 = this.ESe;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("feedLoader");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.finder.order.data.b)localObject1).bDL();
    localObject3 = this.njN;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("loadingView");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(0);
    localObject3 = this.BnA;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("noResultView");
      localObject1 = null;
    }
    ((TextView)localObject1).setVisibility(8);
    localObject3 = this.BsS;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("retryView");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    localObject1 = this.ATx;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((RefreshLoadMoreLayout)localObject1).setVisibility(8);
      AppMethodBeat.o(332274);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return p.f.Cfb;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    return null;
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(332438);
    super.onUserVisibleFocused();
    if (!this.ESf)
    {
      this.ESf = true;
      bDL();
    }
    AppMethodBeat.o(332438);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(332430);
    kotlin.g.b.s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramBundle = paramView.getContext();
    if (paramBundle == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(332430);
      throw paramView;
    }
    this.ESe = new com.tencent.mm.plugin.finder.order.data.b((MMActivity)paramBundle, this.type, "", this.BsV);
    this.hasMore = true;
    paramBundle = paramView.findViewById(p.e.rl_layout);
    kotlin.g.b.s.s(paramBundle, "view.findViewById(R.id.rl_layout)");
    this.ATx = ((RefreshLoadMoreLayout)paramBundle);
    Object localObject2 = this.ATx;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
    }
    this.AZd = ((WxRecyclerView)paramBundle.getRecyclerView());
    paramBundle = paramView.findViewById(p.e.no_result_tv);
    kotlin.g.b.s.s(paramBundle, "view.findViewById(R.id.no_result_tv)");
    this.BnA = ((TextView)paramBundle);
    paramBundle = paramView.findViewById(p.e.loading_layout);
    kotlin.g.b.s.s(paramBundle, "view.findViewById(R.id.loading_layout)");
    this.njN = paramBundle;
    paramBundle = paramView.findViewById(p.e.retry_layout);
    kotlin.g.b.s.s(paramBundle, "view.findViewById(R.id.retry_layout)");
    this.BsS = paramBundle;
    localObject2 = this.BsS;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("retryView");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(new OrderTabFragment..ExternalSyntheticLambda0(this));
    paramBundle = com.tencent.mm.plugin.finder.order.ui.d.ESR;
    Context localContext = paramView.getContext();
    kotlin.g.b.s.s(localContext, "view.context");
    paramBundle = this.AZd;
    paramView = paramBundle;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      paramView = null;
    }
    localObject2 = this.ESe;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("feedLoader");
      paramBundle = null;
    }
    com.tencent.mm.plugin.finder.order.ui.d.a(localContext, paramView, paramBundle.pUj);
    paramBundle = this.ATx;
    paramView = paramBundle;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramView = null;
    }
    paramView.setEnablePullDownHeader(false);
    paramBundle = this.ATx;
    paramView = paramBundle;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramView = null;
    }
    paramBundle = af.mU(getContext()).inflate(p.f.load_more_footer, null);
    kotlin.g.b.s.s(paramBundle, "getInflater(context).inf…t.load_more_footer, null)");
    paramView.setLoadMoreFooter(paramBundle);
    paramView = this.ATx;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramView = localObject1;
    }
    for (;;)
    {
      paramView.setActionCallback((RefreshLoadMoreLayout.b)new b(this));
      AppMethodBeat.o(332430);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "resp", "Lcom/tencent/mm/protocal/protobuf/EcCustomerGetOrderListResp;", "originSize", "currentSize"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.s<Integer, Integer, alq, Integer, Integer, ah>
  {
    a(OrderTabFragment paramOrderTabFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/order/OrderTabFragment$onViewCreated$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RefreshLoadMoreLayout.b
  {
    b(OrderTabFragment paramOrderTabFragment) {}
    
    public final void qI(int paramInt)
    {
      RefreshLoadMoreLayout localRefreshLoadMoreLayout2 = null;
      RefreshLoadMoreLayout localRefreshLoadMoreLayout1 = null;
      AppMethodBeat.i(332298);
      Log.i("MicroMsg.UIComponentFragment", "onLoadMoreBegin");
      if (OrderTabFragment.a(this.ESg))
      {
        localObject = OrderTabFragment.b(this.ESg);
        if (localObject == null)
        {
          kotlin.g.b.s.bIx("feedLoader");
          localObject = null;
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.b((com.tencent.mm.plugin.finder.order.data.b)localObject));
          localRefreshLoadMoreLayout2 = OrderTabFragment.c(this.ESg);
          localObject = localRefreshLoadMoreLayout2;
          if (localRefreshLoadMoreLayout2 == null)
          {
            kotlin.g.b.s.bIx("rlLayout");
            localObject = null;
          }
          localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(p.e.load_more_footer_tip_tv);
            if (localObject != null) {
              ((TextView)localObject).setText(p.h.finder_load_more_footer_tip);
            }
          }
          localRefreshLoadMoreLayout2 = OrderTabFragment.c(this.ESg);
          localObject = localRefreshLoadMoreLayout2;
          if (localRefreshLoadMoreLayout2 == null)
          {
            kotlin.g.b.s.bIx("rlLayout");
            localObject = null;
          }
          localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
          if (localObject != null) {
            break label213;
          }
          localObject = null;
          label150:
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
          localRefreshLoadMoreLayout2 = OrderTabFragment.c(this.ESg);
          localObject = localRefreshLoadMoreLayout2;
          if (localRefreshLoadMoreLayout2 == null)
          {
            kotlin.g.b.s.bIx("rlLayout");
            localObject = null;
          }
          localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
          if (localObject != null) {
            break label227;
          }
        }
        label213:
        label227:
        for (localObject = localRefreshLoadMoreLayout1;; localObject = ((View)localObject).findViewById(p.e.load_more_footer_end_layout))
        {
          if (localObject == null) {
            break label374;
          }
          ((View)localObject).setVisibility(8);
          AppMethodBeat.o(332298);
          return;
          break;
          localObject = (TextView)((View)localObject).findViewById(p.e.load_more_footer_tip_tv);
          break label150;
        }
      }
      localRefreshLoadMoreLayout1 = OrderTabFragment.c(this.ESg);
      Object localObject = localRefreshLoadMoreLayout1;
      if (localRefreshLoadMoreLayout1 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject = null;
      }
      localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
      if (localObject != null)
      {
        localObject = (TextView)((View)localObject).findViewById(p.e.load_more_footer_tip_tv);
        if (localObject != null) {
          ((TextView)localObject).setText(p.h.finder_load_more_no_result_tip);
        }
      }
      localRefreshLoadMoreLayout1 = OrderTabFragment.c(this.ESg);
      localObject = localRefreshLoadMoreLayout1;
      if (localRefreshLoadMoreLayout1 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject = null;
      }
      localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        localRefreshLoadMoreLayout1 = OrderTabFragment.c(this.ESg);
        localObject = localRefreshLoadMoreLayout1;
        if (localRefreshLoadMoreLayout1 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          localObject = null;
        }
        localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
        if (localObject != null) {
          break label394;
        }
      }
      label394:
      for (localObject = localRefreshLoadMoreLayout2;; localObject = ((View)localObject).findViewById(p.e.load_more_footer_end_layout))
      {
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        label374:
        AppMethodBeat.o(332298);
        return;
        localObject = (TextView)((View)localObject).findViewById(p.e.load_more_footer_tip_tv);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.OrderTabFragment
 * JD-Core Version:    0.7.0.1
 */