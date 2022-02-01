package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;)V", "actionBtn", "Landroid/widget/TextView;", "getActionBtn", "()Landroid/widget/TextView;", "setActionBtn", "(Landroid/widget/TextView;)V", "cancelBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCancelBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCancelBtn", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "header", "Landroid/widget/RelativeLayout;", "getHeader", "()Landroid/widget/RelativeLayout;", "setHeader", "(Landroid/widget/RelativeLayout;)V", "tagRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getTagRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setTagRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "titleTv", "getTitleTv", "setTitleTv", "getActivity", "getPresenter", "initView", "", "refreshActionBtn", "Companion", "plugin-finder_release"})
public final class FinderLiveSubTagConstract$ViewCallback
  implements c<FinderLiveSubTagConstract.Presenter>
{
  public static final Companion uXD;
  final MMActivity activity;
  public TextView titleTv;
  public TextView uXA;
  public RecyclerView uXB;
  final FinderLiveSubTagConstract.Presenter uXC;
  public RelativeLayout uXy;
  public WeImageView uXz;
  
  static
  {
    AppMethodBeat.i(249815);
    uXD = new Companion((byte)0);
    AppMethodBeat.o(249815);
  }
  
  public FinderLiveSubTagConstract$ViewCallback(MMActivity paramMMActivity, FinderLiveSubTagConstract.Presenter paramPresenter)
  {
    AppMethodBeat.i(249814);
    this.activity = paramMMActivity;
    this.uXC = paramPresenter;
    AppMethodBeat.o(249814);
  }
  
  public final void dlV()
  {
    boolean bool = true;
    AppMethodBeat.i(249813);
    TextView localTextView = this.uXA;
    if (localTextView == null) {
      p.btv("actionBtn");
    }
    Object localObject;
    int i;
    if (this.uXC.uXq != null)
    {
      localObject = this.uXC.uXq;
      if (localObject != null)
      {
        localObject = ((axk)localObject).qHk;
        localObject = (CharSequence)localObject;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label97;
        }
        i = 1;
        label76:
        if (i != 0) {
          break label102;
        }
      }
    }
    for (;;)
    {
      localTextView.setEnabled(bool);
      AppMethodBeat.o(249813);
      return;
      localObject = null;
      break;
      label97:
      i = 0;
      break label76;
      label102:
      bool = false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract.ViewCallback
 * JD-Core Version:    0.7.0.1
 */