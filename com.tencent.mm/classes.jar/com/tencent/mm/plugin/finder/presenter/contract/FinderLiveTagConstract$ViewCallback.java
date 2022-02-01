package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;)V", "actionBtn", "Landroid/widget/TextView;", "getActionBtn", "()Landroid/widget/TextView;", "setActionBtn", "(Landroid/widget/TextView;)V", "cancelBtn", "getCancelBtn", "setCancelBtn", "header", "Landroid/widget/RelativeLayout;", "getHeader", "()Landroid/widget/RelativeLayout;", "setHeader", "(Landroid/widget/RelativeLayout;)V", "tagRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getTagRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setTagRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "titleTv", "getTitleTv", "setTitleTv", "finishWithResult", "", "getActivity", "getPresenter", "initView", "Companion", "plugin-finder_release"})
public final class FinderLiveTagConstract$ViewCallback
  implements c<FinderLiveTagConstract.Presenter>
{
  public static final Companion uXJ;
  final MMActivity activity;
  public TextView kaq;
  public TextView titleTv;
  public TextView uXA;
  public RecyclerView uXB;
  final FinderLiveTagConstract.Presenter uXI;
  public RelativeLayout uXy;
  
  static
  {
    AppMethodBeat.i(249829);
    uXJ = new Companion((byte)0);
    AppMethodBeat.o(249829);
  }
  
  public FinderLiveTagConstract$ViewCallback(MMActivity paramMMActivity, FinderLiveTagConstract.Presenter paramPresenter)
  {
    AppMethodBeat.i(249828);
    this.activity = paramMMActivity;
    this.uXI = paramPresenter;
    AppMethodBeat.o(249828);
  }
  
  public final void amT()
  {
    AppMethodBeat.i(249827);
    Log.i("FinderLiveTagConstract.ViewCallback", "finishWithResult hasNextAction:" + this.uXI.uXv);
    if (this.uXI.uXv)
    {
      new Intent();
      Intent localIntent = new Intent();
      localIntent.putExtra("KEY_START_LIVE", true);
      this.activity.setResult(-1, localIntent);
      this.activity.finish();
      AppMethodBeat.o(249827);
      return;
    }
    this.activity.setResult(-1);
    this.activity.finish();
    AppMethodBeat.o(249827);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.ViewCallback
 * JD-Core Version:    0.7.0.1
 */