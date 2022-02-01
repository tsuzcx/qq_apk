package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.e;
import com.tencent.mm.plugin.finder.report.live.s.i;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;)V", "emptyTv", "Landroid/widget/TextView;", "getEmptyTv", "()Landroid/widget/TextView;", "setEmptyTv", "(Landroid/widget/TextView;)V", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "titleAmountTv", "getTitleAmountTv", "setTitleAmountTv", "titleGroup", "Landroid/widget/RelativeLayout;", "getTitleGroup", "()Landroid/widget/RelativeLayout;", "setTitleGroup", "(Landroid/widget/RelativeLayout;)V", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "topActionTv", "getTopActionTv", "setTopActionTv", "topBackBtn", "getTopBackBtn", "setTopBackBtn", "topGroup", "getTopGroup", "setTopGroup", "topTitleTv", "getTopTitleTv", "setTopTitleTv", "wecoinRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getWecoinRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setWecoinRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getActivity", "getPresenter", "initView", "", "showContentView", "wecoinHotResp", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$LiveWecoinHotResponse;", "showEmptyView", "showProgress", "plugin-finder_release"})
public final class FinderLiveWeCoinHotConstract$ViewCallback
  implements com.tencent.mm.plugin.finder.presenter.base.c<FinderLiveWeCoinHotConstract.Presenter>
{
  final MMActivity activity;
  public View hSw;
  public TextView qqJ;
  public TextView titleTv;
  public WeImageView uPW;
  public RecyclerView uXQ;
  public RelativeLayout uXR;
  public TextView uXS;
  public View uXT;
  public TextView uXU;
  public RelativeLayout uXV;
  public TextView uXW;
  final FinderLiveWeCoinHotConstract.Presenter uXX;
  
  public FinderLiveWeCoinHotConstract$ViewCallback(MMActivity paramMMActivity, FinderLiveWeCoinHotConstract.Presenter paramPresenter)
  {
    AppMethodBeat.i(249845);
    this.activity = paramMMActivity;
    this.uXX = paramPresenter;
    AppMethodBeat.o(249845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveWeCoinHotConstract.ViewCallback
 * JD-Core Version:    0.7.0.1
 */