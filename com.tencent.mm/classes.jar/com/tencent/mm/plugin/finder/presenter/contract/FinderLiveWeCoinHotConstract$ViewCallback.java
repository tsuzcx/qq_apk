package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveWecoinHotLoader;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.g;
import com.tencent.mm.plugin.finder.live.report.q.m;
import com.tencent.mm.plugin.finder.live.widget.am;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;)V", "emptyTv", "Landroid/widget/TextView;", "getEmptyTv", "()Landroid/widget/TextView;", "setEmptyTv", "(Landroid/widget/TextView;)V", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "profileWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;", "getProfileWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;", "setProfileWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;)V", "titleAmountTv", "getTitleAmountTv", "setTitleAmountTv", "titleGroup", "Landroid/widget/RelativeLayout;", "getTitleGroup", "()Landroid/widget/RelativeLayout;", "setTitleGroup", "(Landroid/widget/RelativeLayout;)V", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "topActionTv", "getTopActionTv", "setTopActionTv", "topBackBtn", "getTopBackBtn", "setTopBackBtn", "topGroup", "getTopGroup", "setTopGroup", "wecoinRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getWecoinRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setWecoinRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getActivity", "getPresenter", "initView", "", "showContentView", "wecoinHotResp", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$LiveWecoinHotResponse;", "showEmptyView", "showProgress", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveWeCoinHotConstract$ViewCallback
  implements com.tencent.mm.plugin.finder.presenter.base.c<FinderLiveWeCoinHotConstract.Presenter>
{
  final FinderLiveWeCoinHotConstract.Presenter CAW;
  am Dhc;
  public WeImageView EFn;
  public RecyclerView EYS;
  public RelativeLayout EYT;
  public TextView EYU;
  public RelativeLayout EYo;
  public View EYp;
  public TextView EYq;
  final MMActivity activity;
  public TextView lNm;
  public View njN;
  public TextView titleTv;
  
  public FinderLiveWeCoinHotConstract$ViewCallback(MMActivity paramMMActivity, FinderLiveWeCoinHotConstract.Presenter paramPresenter)
  {
    AppMethodBeat.i(343807);
    this.activity = paramMMActivity;
    this.CAW = paramPresenter;
    AppMethodBeat.o(343807);
  }
  
  private static final void a(ViewCallback paramViewCallback, View paramView)
  {
    AppMethodBeat.i(343815);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramViewCallback);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramViewCallback, "this$0");
    localObject = new Intent();
    if (s.p(paramViewCallback.CAW.EYk.BhB, Boolean.TRUE)) {}
    for (paramView = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=support/we-coin/protocol/index#/base-protocol/v2";; paramView = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=support/we-coin/protocol/index")
    {
      ((Intent)localObject).putExtra("rawUrl", paramView);
      com.tencent.mm.br.c.b((Context)paramViewCallback.activity, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(343815);
      return;
    }
  }
  
  private static final void b(ViewCallback paramViewCallback, View paramView)
  {
    AppMethodBeat.i(343825);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramViewCallback);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramViewCallback, "this$0");
    paramViewCallback.activity.finish();
    paramViewCallback = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      paramViewCallback = j.Dob;
      j.a(q.g.Dsn, String.valueOf(q.m.Dtm.action));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(343825);
  }
  
  private static final void c(ViewCallback paramViewCallback, View paramView)
  {
    AppMethodBeat.i(343834);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramViewCallback);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramViewCallback, "this$0");
    paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      paramView = j.Dob;
      j.a(q.g.Dsn, String.valueOf(q.m.Dtl.action));
    }
    localObject1 = (com.tencent.mm.plugin.wallet.wecoin.a.d)h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class);
    localObject2 = (Context)paramViewCallback.activity;
    paramView = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHQ();
    paramViewCallback = paramView;
    if (paramView == null) {
      paramViewCallback = "";
    }
    ((com.tencent.mm.plugin.wallet.wecoin.a.d)localObject1).cj((Context)localObject2, paramViewCallback);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(343834);
  }
  
  public final RecyclerView eIh()
  {
    AppMethodBeat.i(343856);
    RecyclerView localRecyclerView = this.EYS;
    if (localRecyclerView != null)
    {
      AppMethodBeat.o(343856);
      return localRecyclerView;
    }
    s.bIx("wecoinRecyclerView");
    AppMethodBeat.o(343856);
    return null;
  }
  
  public final RelativeLayout eIi()
  {
    AppMethodBeat.i(343863);
    RelativeLayout localRelativeLayout = this.EYT;
    if (localRelativeLayout != null)
    {
      AppMethodBeat.o(343863);
      return localRelativeLayout;
    }
    s.bIx("titleGroup");
    AppMethodBeat.o(343863);
    return null;
  }
  
  public final TextView eIj()
  {
    AppMethodBeat.i(343866);
    TextView localTextView = this.EYU;
    if (localTextView != null)
    {
      AppMethodBeat.o(343866);
      return localTextView;
    }
    s.bIx("titleAmountTv");
    AppMethodBeat.o(343866);
    return null;
  }
  
  public final TextView eIk()
  {
    AppMethodBeat.i(343872);
    TextView localTextView = this.lNm;
    if (localTextView != null)
    {
      AppMethodBeat.o(343872);
      return localTextView;
    }
    s.bIx("emptyTv");
    AppMethodBeat.o(343872);
    return null;
  }
  
  public final View getLoadingView()
  {
    AppMethodBeat.i(343879);
    View localView = this.njN;
    if (localView != null)
    {
      AppMethodBeat.o(343879);
      return localView;
    }
    s.bIx("loadingView");
    AppMethodBeat.o(343879);
    return null;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(343889);
    Object localObject1 = this.activity.findViewById(p.e.BUo);
    s.s(localObject1, "activity.findViewById(R.…ive_wecoin_hot_top_group)");
    localObject1 = (RelativeLayout)localObject1;
    s.u(localObject1, "<set-?>");
    this.EYo = ((RelativeLayout)localObject1);
    localObject1 = this.activity.findViewById(p.e.BUn);
    s.s(localObject1, "activity.findViewById(R.…wecoin_hot_top_back_icon)");
    s.u(localObject1, "<set-?>");
    this.EYp = ((View)localObject1);
    localObject1 = this.activity.findViewById(p.e.BUm);
    s.s(localObject1, "activity.findViewById(R.…wecoin_hot_top_action_tv)");
    localObject1 = (TextView)localObject1;
    s.u(localObject1, "<set-?>");
    this.EYq = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(p.e.BUj);
    s.s(localObject1, "activity.findViewById(R.…e_wecoin_hot_title_group)");
    localObject1 = (RelativeLayout)localObject1;
    s.u(localObject1, "<set-?>");
    this.EYT = ((RelativeLayout)localObject1);
    localObject1 = this.activity.findViewById(p.e.BUl);
    s.s(localObject1, "activity.findViewById(R.…live_wecoin_hot_title_tv)");
    localObject1 = (TextView)localObject1;
    s.u(localObject1, "<set-?>");
    this.titleTv = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(p.e.BUk);
    s.s(localObject1, "activity.findViewById(R.…ve_wecoin_hot_title_icon)");
    localObject1 = (WeImageView)localObject1;
    s.u(localObject1, "<set-?>");
    this.EFn = ((WeImageView)localObject1);
    localObject1 = this.activity.findViewById(p.e.BUi);
    s.s(localObject1, "activity.findViewById(R.…coin_hot_title_amount_tv)");
    localObject1 = (TextView)localObject1;
    s.u(localObject1, "<set-?>");
    this.EYU = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(p.e.BTZ);
    s.s(localObject1, "activity.findViewById(R.…ive_wecoin_hot_empty_tip)");
    localObject1 = (TextView)localObject1;
    s.u(localObject1, "<set-?>");
    this.lNm = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(p.e.BUg);
    s.s(localObject1, "activity.findViewById(R.…_live_wecoin_hot_loading)");
    s.u(localObject1, "<set-?>");
    this.njN = ((View)localObject1);
    localObject1 = this.activity.findViewById(p.e.BUf);
    s.s(localObject1, "activity.findViewById(R.…der_live_wecoin_hot_list)");
    localObject1 = (RecyclerView)localObject1;
    s.u(localObject1, "<set-?>");
    this.EYS = ((RecyclerView)localObject1);
    eIh().setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    eIh().setAdapter((RecyclerView.a)this.CAW.getAdapter());
    eIi().setVisibility(8);
    eIh().setVisibility(8);
    eIk().setVisibility(8);
    getLoadingView().setVisibility(8);
    localObject1 = this.EFn;
    if (localObject1 != null)
    {
      ((WeImageView)localObject1).setOnClickListener(new FinderLiveWeCoinHotConstract.ViewCallback..ExternalSyntheticLambda2(this));
      localObject1 = this.EYo;
      if (localObject1 == null) {
        break label487;
      }
    }
    for (;;)
    {
      localObject1 = ((RelativeLayout)localObject1).getLayoutParams();
      if (localObject1 != null) {
        break label498;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(343889);
      throw ((Throwable)localObject1);
      s.bIx("titleIv");
      localObject1 = null;
      break;
      label487:
      s.bIx("topGroup");
      localObject1 = null;
    }
    label498:
    localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
    int i = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
    ((ViewGroup.MarginLayoutParams)localObject1).topMargin = (bf.getStatusBarHeight((Context)this.activity) + i);
    localObject1 = this.EYp;
    if (localObject1 != null)
    {
      ((View)localObject1).setOnClickListener(new FinderLiveWeCoinHotConstract.ViewCallback..ExternalSyntheticLambda0(this));
      localObject1 = this.EYq;
      if (localObject1 == null) {
        break label611;
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setOnClickListener(new FinderLiveWeCoinHotConstract.ViewCallback..ExternalSyntheticLambda1(this));
      localObject1 = this.activity.findViewById(p.e.BOp);
      if (localObject1 != null) {
        break label622;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(343889);
      throw ((Throwable)localObject1);
      s.bIx("topBackBtn");
      localObject1 = null;
      break;
      label611:
      s.bIx("topActionTv");
      localObject1 = localObject2;
    }
    label622:
    this.Dhc = new am((ViewGroup)localObject1);
    localObject1 = this.Dhc;
    if (localObject1 != null)
    {
      ((am)localObject1).eBc();
      ((am)localObject1).ErB = ((kotlin.g.a.a)new u((am)localObject1) {});
      ((am)localObject1).ErC = ((kotlin.g.a.b)new u((am)localObject1) {});
    }
    this.CAW.EYk.requestRefresh();
    AppMethodBeat.o(343889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveWeCoinHotConstract.ViewCallback
 * JD-Core Version:    0.7.0.1
 */