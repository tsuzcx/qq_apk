package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;)V", "actionBtn", "Landroid/widget/TextView;", "getActionBtn", "()Landroid/widget/TextView;", "setActionBtn", "(Landroid/widget/TextView;)V", "cancelBtn", "getCancelBtn", "setCancelBtn", "header", "Landroid/widget/RelativeLayout;", "getHeader", "()Landroid/widget/RelativeLayout;", "setHeader", "(Landroid/widget/RelativeLayout;)V", "tagRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getTagRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setTagRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "titleTv", "getTitleTv", "setTitleTv", "finishWithResult", "", "getActivity", "getPresenter", "initView", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveTagConstract$ViewCallback
  implements c<FinderLiveTagConstract.Presenter>
{
  public static final FinderLiveTagConstract.ViewCallback.Companion EYN;
  private final FinderLiveTagConstract.Presenter CAU;
  public RelativeLayout EYI;
  public RecyclerView EYJ;
  public TextView EtY;
  final MMActivity activity;
  public TextView pOq;
  public TextView titleTv;
  
  static
  {
    AppMethodBeat.i(343643);
    EYN = new FinderLiveTagConstract.ViewCallback.Companion((byte)0);
    AppMethodBeat.o(343643);
  }
  
  public FinderLiveTagConstract$ViewCallback(MMActivity paramMMActivity, FinderLiveTagConstract.Presenter paramPresenter)
  {
    AppMethodBeat.i(343604);
    this.activity = paramMMActivity;
    this.CAU = paramPresenter;
    AppMethodBeat.o(343604);
  }
  
  private static final void a(ViewCallback paramViewCallback, View paramView)
  {
    AppMethodBeat.i(343623);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramViewCallback);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramViewCallback, "this$0");
    paramViewCallback.activity.setResult(0);
    paramViewCallback.activity.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(343623);
  }
  
  private static final void b(ViewCallback paramViewCallback, View paramView)
  {
    AppMethodBeat.i(343632);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramViewCallback);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramViewCallback, "this$0");
    paramViewCallback.aMV();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(343632);
  }
  
  private static final void c(ViewCallback paramViewCallback, View paramView)
  {
    AppMethodBeat.i(343638);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramViewCallback);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramViewCallback, "this$0");
    paramViewCallback.aMV();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(343638);
  }
  
  private TextView eIe()
  {
    AppMethodBeat.i(343609);
    TextView localTextView = this.EtY;
    if (localTextView != null)
    {
      AppMethodBeat.o(343609);
      return localTextView;
    }
    s.bIx("actionBtn");
    AppMethodBeat.o(343609);
    return null;
  }
  
  private RecyclerView eIf()
  {
    AppMethodBeat.i(343616);
    RecyclerView localRecyclerView = this.EYJ;
    if (localRecyclerView != null)
    {
      AppMethodBeat.o(343616);
      return localRecyclerView;
    }
    s.bIx("tagRecyclerView");
    AppMethodBeat.o(343616);
    return null;
  }
  
  public final void aMV()
  {
    AppMethodBeat.i(343673);
    Log.i("FinderLiveTagConstract.ViewCallback", s.X("finishWithResult hasNextAction:", Boolean.valueOf(this.CAU.EYC)));
    if (this.CAU.EYC)
    {
      new Intent();
      Intent localIntent = new Intent();
      localIntent.putExtra("KEY_START_LIVE", true);
      this.activity.setResult(-1, localIntent);
      this.activity.finish();
      AppMethodBeat.o(343673);
      return;
    }
    this.activity.setResult(-1);
    this.activity.finish();
    AppMethodBeat.o(343673);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(343668);
    Object localObject1 = this.activity.findViewById(p.e.BTa);
    s.s(localObject1, "activity.findViewById(R.…inder_live_tag_ui_header)");
    localObject1 = (RelativeLayout)localObject1;
    s.u(localObject1, "<set-?>");
    this.EYI = ((RelativeLayout)localObject1);
    localObject1 = this.activity.findViewById(p.e.BTc);
    s.s(localObject1, "activity.findViewById(R.…ive_tag_ui_header_cancel)");
    localObject1 = (TextView)localObject1;
    s.u(localObject1, "<set-?>");
    this.pOq = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(p.e.BTd);
    s.s(localObject1, "activity.findViewById(R.…live_tag_ui_header_title)");
    localObject1 = (TextView)localObject1;
    s.u(localObject1, "<set-?>");
    this.titleTv = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(p.e.BTb);
    s.s(localObject1, "activity.findViewById(R.…tag_ui_header_action_btn)");
    localObject1 = (TextView)localObject1;
    s.u(localObject1, "<set-?>");
    this.EtY = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(p.e.BSZ);
    s.s(localObject1, "activity.findViewById(R.…nder_live_tag_ui_content)");
    localObject1 = (RecyclerView)localObject1;
    s.u(localObject1, "<set-?>");
    this.EYJ = ((RecyclerView)localObject1);
    eIf().setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    Object localObject2 = eIf();
    localObject1 = this.CAU.ALE;
    label236:
    int i;
    if (localObject1 != null)
    {
      ((RecyclerView)localObject2).setAdapter((RecyclerView.a)localObject1);
      localObject1 = eIf().getLayoutParams();
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        break label487;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      if (localObject1 != null)
      {
        i = ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (bf.bk((Context)this.activity) + i);
      }
      localObject1 = this.pOq;
      if (localObject1 == null) {
        break label492;
      }
      label270:
      ((TextView)localObject1).setOnClickListener(new FinderLiveTagConstract.ViewCallback..ExternalSyntheticLambda0(this));
      localObject1 = this.EYI;
      if (localObject1 == null) {
        break label503;
      }
      label291:
      localObject1 = ((RelativeLayout)localObject1).getLayoutParams();
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        break label514;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      label308:
      if (localObject1 != null)
      {
        i = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = (bf.getStatusBarHeight((Context)this.activity) + i);
      }
      localObject2 = eIe();
      if (((e)this.CAU.getLiveData().business(e.class)).CFe == null) {
        break label532;
      }
      localObject1 = ((e)this.CAU.getLiveData().business(e.class)).CFe;
      if (localObject1 != null) {
        break label519;
      }
      localObject1 = null;
      label387:
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label527;
      }
      i = 1;
      label407:
      if (i != 0) {
        break label532;
      }
    }
    label514:
    label519:
    label527:
    label532:
    for (boolean bool = true;; bool = false)
    {
      ((TextView)localObject2).setEnabled(bool);
      if (!this.CAU.EYC) {
        break label537;
      }
      eIe().setText((CharSequence)this.activity.getContext().getResources().getString(p.h.Cuf));
      eIe().setOnClickListener(new FinderLiveTagConstract.ViewCallback..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(343668);
      return;
      s.bIx("adapter");
      localObject1 = null;
      break;
      label487:
      localObject1 = null;
      break label236;
      label492:
      s.bIx("cancelBtn");
      localObject1 = null;
      break label270;
      label503:
      s.bIx("header");
      localObject1 = null;
      break label291;
      localObject1 = null;
      break label308;
      localObject1 = ((bno)localObject1).xms;
      break label387;
      i = 0;
      break label407;
    }
    label537:
    eIe().setText((CharSequence)this.activity.getContext().getResources().getString(p.h.app_finish));
    eIe().setOnClickListener(new FinderLiveTagConstract.ViewCallback..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(343668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.ViewCallback
 * JD-Core Version:    0.7.0.1
 */