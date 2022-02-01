package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveWecoinHotLoader;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.widget.am;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveChargeIncomeContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveChargeIncomeContract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveChargeIncomeContract$Presenter;)V", "chargeCustomerRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getChargeCustomerRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setChargeCustomerRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "hotAmount", "Landroid/widget/TextView;", "getHotAmount", "()Landroid/widget/TextView;", "setHotAmount", "(Landroid/widget/TextView;)V", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "profileWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;", "getProfileWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;", "setProfileWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;)V", "topActionTv", "getTopActionTv", "setTopActionTv", "topBackBtn", "getTopBackBtn", "setTopBackBtn", "topGroup", "Landroid/widget/RelativeLayout;", "getTopGroup", "()Landroid/widget/RelativeLayout;", "setTopGroup", "(Landroid/widget/RelativeLayout;)V", "userAmount", "getUserAmount", "setUserAmount", "getActivity", "getPresenter", "initView", "", "showContentView", "wecoinHotResp", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$LiveWecoinHotResponse;", "showEmptyView", "showProgress", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveChargeIncomeContract$ViewCallback
  implements c<FinderLiveChargeIncomeContract.Presenter>
{
  private final FinderLiveChargeIncomeContract.Presenter Cyk;
  am Dhc;
  public RecyclerView EYn;
  public RelativeLayout EYo;
  public View EYp;
  public TextView EYq;
  public TextView EYr;
  public TextView EYs;
  final MMActivity activity;
  public View njN;
  
  public FinderLiveChargeIncomeContract$ViewCallback(MMActivity paramMMActivity, FinderLiveChargeIncomeContract.Presenter paramPresenter)
  {
    AppMethodBeat.i(343674);
    this.activity = paramMMActivity;
    this.Cyk = paramPresenter;
    AppMethodBeat.o(343674);
  }
  
  private static final void a(ViewCallback paramViewCallback, View paramView)
  {
    AppMethodBeat.i(343680);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramViewCallback);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveChargeIncomeContract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramViewCallback, "this$0");
    paramViewCallback.activity.finish();
    a.a(new Object(), "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveChargeIncomeContract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(343680);
  }
  
  private static final void b(ViewCallback paramViewCallback, View paramView)
  {
    AppMethodBeat.i(343687);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramViewCallback);
    ((b)localObject2).cH(paramView);
    a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveChargeIncomeContract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    s.u(paramViewCallback, "this$0");
    localObject1 = (com.tencent.mm.plugin.wallet.wecoin.a.d)h.ax(com.tencent.mm.plugin.wallet.wecoin.a.d.class);
    localObject2 = (Context)paramViewCallback.activity;
    paramView = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHQ();
    paramViewCallback = paramView;
    if (paramView == null) {
      paramViewCallback = "";
    }
    ((com.tencent.mm.plugin.wallet.wecoin.a.d)localObject1).cj((Context)localObject2, paramViewCallback);
    a.a(new Object(), "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveChargeIncomeContract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(343687);
  }
  
  public final RecyclerView eIc()
  {
    AppMethodBeat.i(343694);
    RecyclerView localRecyclerView = this.EYn;
    if (localRecyclerView != null)
    {
      AppMethodBeat.o(343694);
      return localRecyclerView;
    }
    s.bIx("chargeCustomerRecyclerView");
    AppMethodBeat.o(343694);
    return null;
  }
  
  public final View getLoadingView()
  {
    AppMethodBeat.i(343700);
    View localView = this.njN;
    if (localView != null)
    {
      AppMethodBeat.o(343700);
      return localView;
    }
    s.bIx("loadingView");
    AppMethodBeat.o(343700);
    return null;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(343711);
    Object localObject1 = this.activity.findViewById(p.e.BJO);
    s.s(localObject1, "activity.findViewById(R.…_charge_income_top_group)");
    localObject1 = (RelativeLayout)localObject1;
    s.u(localObject1, "<set-?>");
    this.EYo = ((RelativeLayout)localObject1);
    localObject1 = this.activity.findViewById(p.e.BJN);
    s.s(localObject1, "activity.findViewById(R.…rge_income_top_back_icon)");
    s.u(localObject1, "<set-?>");
    this.EYp = ((View)localObject1);
    localObject1 = this.activity.findViewById(p.e.BJM);
    s.s(localObject1, "activity.findViewById(R.…rge_income_top_action_tv)");
    localObject1 = (TextView)localObject1;
    s.u(localObject1, "<set-?>");
    this.EYq = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(p.e.BJQ);
    s.s(localObject1, "activity.findViewById(R.…ve_charge_user_amount_tv)");
    localObject1 = (TextView)localObject1;
    s.u(localObject1, "<set-?>");
    this.EYr = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(p.e.BBZ);
    s.s(localObject1, "activity.findViewById(R.…harge_income_heat_amount)");
    localObject1 = (TextView)localObject1;
    s.u(localObject1, "<set-?>");
    this.EYs = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(p.e.BJL);
    s.s(localObject1, "activity.findViewById(R.…ve_charge_income_loading)");
    s.u(localObject1, "<set-?>");
    this.njN = ((View)localObject1);
    localObject1 = this.activity.findViewById(p.e.BJK);
    s.s(localObject1, "activity.findViewById(R.…_live_charge_income_list)");
    localObject1 = (RecyclerView)localObject1;
    s.u(localObject1, "<set-?>");
    this.EYn = ((RecyclerView)localObject1);
    eIc().setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    eIc().setAdapter((RecyclerView.a)this.Cyk.getAdapter());
    localObject1 = this.EYo;
    if (localObject1 != null) {}
    for (;;)
    {
      localObject1 = ((RelativeLayout)localObject1).getLayoutParams();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(343711);
      throw ((Throwable)localObject1);
      s.bIx("topGroup");
      localObject1 = null;
    }
    localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
    int i = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
    ((ViewGroup.MarginLayoutParams)localObject1).topMargin = (bf.getStatusBarHeight((Context)this.activity) + i);
    localObject1 = this.EYp;
    if (localObject1 != null)
    {
      ((View)localObject1).setOnClickListener(new FinderLiveChargeIncomeContract.ViewCallback..ExternalSyntheticLambda1(this));
      localObject1 = this.EYq;
      if (localObject1 == null) {
        break label424;
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setOnClickListener(new FinderLiveChargeIncomeContract.ViewCallback..ExternalSyntheticLambda0(this));
      localObject1 = this.Cyk;
      ((FinderLiveChargeIncomeContract.Presenter)localObject1).EYk.requestRefresh();
      localObject1 = ((FinderLiveChargeIncomeContract.Presenter)localObject1).EYl;
      if (localObject1 != null) {
        ((ViewCallback)localObject1).getLoadingView().setVisibility(0);
      }
      AppMethodBeat.o(343711);
      return;
      s.bIx("topBackBtn");
      localObject1 = null;
      break;
      label424:
      s.bIx("topActionTv");
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveChargeIncomeContract.ViewCallback
 * JD-Core Version:    0.7.0.1
 */