package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveWecoinHotLoader;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.e;
import com.tencent.mm.plugin.finder.live.report.s.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;)V", "emptyTv", "Landroid/widget/TextView;", "getEmptyTv", "()Landroid/widget/TextView;", "setEmptyTv", "(Landroid/widget/TextView;)V", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "profileWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;", "getProfileWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;", "setProfileWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;)V", "titleAmountTv", "getTitleAmountTv", "setTitleAmountTv", "titleGroup", "Landroid/widget/RelativeLayout;", "getTitleGroup", "()Landroid/widget/RelativeLayout;", "setTitleGroup", "(Landroid/widget/RelativeLayout;)V", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "topActionTv", "getTopActionTv", "setTopActionTv", "topBackBtn", "getTopBackBtn", "setTopBackBtn", "topGroup", "getTopGroup", "setTopGroup", "topTitleTv", "getTopTitleTv", "setTopTitleTv", "wecoinRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getWecoinRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setWecoinRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getActivity", "getPresenter", "initView", "", "showContentView", "wecoinHotResp", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$LiveWecoinHotResponse;", "showEmptyView", "showProgress", "plugin-finder_release"})
public final class FinderLiveWeCoinHotConstract$ViewCallback
  implements com.tencent.mm.plugin.finder.presenter.base.c<FinderLiveWeCoinHotConstract.Presenter>
{
  final MMActivity activity;
  public TextView jkI;
  public View kGT;
  public TextView titleTv;
  final FinderLiveWeCoinHotConstract.Presenter ycJ;
  com.tencent.mm.plugin.finder.live.widget.x ywo;
  public WeImageView zCw;
  public RecyclerView zOe;
  public RelativeLayout zOf;
  public TextView zOg;
  public View zOh;
  public TextView zOi;
  public RelativeLayout zOj;
  public TextView zOk;
  
  public FinderLiveWeCoinHotConstract$ViewCallback(MMActivity paramMMActivity, FinderLiveWeCoinHotConstract.Presenter paramPresenter)
  {
    AppMethodBeat.i(225776);
    this.activity = paramMMActivity;
    this.ycJ = paramPresenter;
    AppMethodBeat.o(225776);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(225774);
    Object localObject = this.activity.findViewById(b.f.finder_live_wecoin_hot_top_group);
    p.j(localObject, "activity.findViewById(R.…ive_wecoin_hot_top_group)");
    this.zOf = ((RelativeLayout)localObject);
    localObject = this.activity.findViewById(b.f.finder_live_wecoin_hot_top_title_tv);
    p.j(localObject, "activity.findViewById(R.…_wecoin_hot_top_title_tv)");
    this.zOg = ((TextView)localObject);
    localObject = this.activity.findViewById(b.f.finder_live_wecoin_hot_top_back_icon);
    p.j(localObject, "activity.findViewById(R.…wecoin_hot_top_back_icon)");
    this.zOh = ((View)localObject);
    localObject = this.activity.findViewById(b.f.finder_live_wecoin_hot_top_action_tv);
    p.j(localObject, "activity.findViewById(R.…wecoin_hot_top_action_tv)");
    this.zOi = ((TextView)localObject);
    localObject = this.activity.findViewById(b.f.finder_live_wecoin_hot_title_group);
    p.j(localObject, "activity.findViewById(R.…e_wecoin_hot_title_group)");
    this.zOj = ((RelativeLayout)localObject);
    localObject = this.activity.findViewById(b.f.finder_live_wecoin_hot_title_tv);
    p.j(localObject, "activity.findViewById(R.…live_wecoin_hot_title_tv)");
    this.titleTv = ((TextView)localObject);
    localObject = this.activity.findViewById(b.f.finder_live_wecoin_hot_title_icon);
    p.j(localObject, "activity.findViewById(R.…ve_wecoin_hot_title_icon)");
    this.zCw = ((WeImageView)localObject);
    localObject = this.activity.findViewById(b.f.finder_live_wecoin_hot_title_amount_tv);
    p.j(localObject, "activity.findViewById(R.…coin_hot_title_amount_tv)");
    this.zOk = ((TextView)localObject);
    localObject = this.activity.findViewById(b.f.finder_live_wecoin_hot_empty_tip);
    p.j(localObject, "activity.findViewById(R.…ive_wecoin_hot_empty_tip)");
    this.jkI = ((TextView)localObject);
    localObject = this.activity.findViewById(b.f.finder_live_wecoin_hot_loading);
    p.j(localObject, "activity.findViewById(R.…_live_wecoin_hot_loading)");
    this.kGT = ((View)localObject);
    localObject = this.activity.findViewById(b.f.finder_live_wecoin_hot_list);
    p.j(localObject, "activity.findViewById(R.…der_live_wecoin_hot_list)");
    this.zOe = ((RecyclerView)localObject);
    localObject = this.zOe;
    if (localObject == null) {
      p.bGy("wecoinRecyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    localObject = this.zOe;
    if (localObject == null) {
      p.bGy("wecoinRecyclerView");
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.ycJ.getAdapter());
    localObject = this.zOg;
    if (localObject == null) {
      p.bGy("topTitleTv");
    }
    ar.a((Paint)((TextView)localObject).getPaint(), 0.8F);
    localObject = this.zOj;
    if (localObject == null) {
      p.bGy("titleGroup");
    }
    ((RelativeLayout)localObject).setVisibility(8);
    localObject = this.zOe;
    if (localObject == null) {
      p.bGy("wecoinRecyclerView");
    }
    ((RecyclerView)localObject).setVisibility(8);
    localObject = this.jkI;
    if (localObject == null) {
      p.bGy("emptyTv");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.kGT;
    if (localObject == null) {
      p.bGy("loadingView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.zCw;
    if (localObject == null) {
      p.bGy("titleIv");
    }
    ((WeImageView)localObject).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(230465);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=support/we-coin/protocol/index");
        com.tencent.mm.by.c.b((Context)this.zOm.activity, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(230465);
      }
    });
    localObject = this.zOf;
    if (localObject == null) {
      p.bGy("topGroup");
    }
    localObject = ((RelativeLayout)localObject).getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(225774);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    int i = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = (ax.getStatusBarHeight((Context)this.activity) + i);
    localObject = this.zOh;
    if (localObject == null) {
      p.bGy("topBackBtn");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(273050);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        FinderLiveWeCoinHotConstract.ViewCallback.b(this.zOm).finish();
        paramAnonymousView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
        {
          paramAnonymousView = k.yBj;
          k.a(s.e.yEP, String.valueOf(s.k.yFI.action));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(273050);
      }
    });
    localObject = this.zOi;
    if (localObject == null) {
      p.bGy("topActionTv");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(287272);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
        {
          paramAnonymousView = k.yBj;
          k.a(s.e.yEP, String.valueOf(s.k.yFH.action));
        }
        com.tencent.mm.plugin.wallet.wecoin.a.c localc = (com.tencent.mm.plugin.wallet.wecoin.a.c)h.ae(com.tencent.mm.plugin.wallet.wecoin.a.c.class);
        Context localContext = (Context)FinderLiveWeCoinHotConstract.ViewCallback.b(this.zOm);
        paramAnonymousView = h.ae(com.tencent.mm.plugin.expt.b.c.class);
        p.j(paramAnonymousView, "MMKernel.service(IHellBizService::class.java)");
        localObject = ((com.tencent.mm.plugin.expt.b.c)paramAnonymousView).dbu();
        paramAnonymousView = (View)localObject;
        if (localObject == null) {
          paramAnonymousView = "";
        }
        localc.bY(localContext, paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(287272);
      }
    });
    localObject = this.activity.findViewById(b.f.finder_live_members_profile_ui_root);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(225774);
      throw ((Throwable)localObject);
    }
    this.ywo = new com.tencent.mm.plugin.finder.live.widget.x((ViewGroup)localObject);
    localObject = this.ywo;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.live.widget.x)localObject).dIu();
      ((com.tencent.mm.plugin.finder.live.widget.x)localObject).zoV = ((kotlin.g.a.a)new q((com.tencent.mm.plugin.finder.live.widget.x)localObject) {});
      ((com.tencent.mm.plugin.finder.live.widget.x)localObject).zoW = ((kotlin.g.a.b)new q((com.tencent.mm.plugin.finder.live.widget.x)localObject) {});
    }
    this.ycJ.zOb.requestRefresh();
    AppMethodBeat.o(225774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveWeCoinHotConstract.ViewCallback
 * JD-Core Version:    0.7.0.1
 */