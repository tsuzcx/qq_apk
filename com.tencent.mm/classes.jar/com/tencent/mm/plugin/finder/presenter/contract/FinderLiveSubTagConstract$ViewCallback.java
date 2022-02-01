package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
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
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;)V", "actionBtn", "Landroid/widget/TextView;", "getActionBtn", "()Landroid/widget/TextView;", "setActionBtn", "(Landroid/widget/TextView;)V", "cancelBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCancelBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCancelBtn", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "header", "Landroid/widget/RelativeLayout;", "getHeader", "()Landroid/widget/RelativeLayout;", "setHeader", "(Landroid/widget/RelativeLayout;)V", "tagRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getTagRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setTagRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "titleTv", "getTitleTv", "setTitleTv", "getActivity", "getPresenter", "initView", "", "refreshActionBtn", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveSubTagConstract$ViewCallback
  implements c<FinderLiveSubTagConstract.Presenter>
{
  public static final FinderLiveSubTagConstract.ViewCallback.Companion EYH;
  private final FinderLiveSubTagConstract.Presenter CAS;
  public RelativeLayout EYI;
  public RecyclerView EYJ;
  public WeImageView EpW;
  public TextView EtY;
  private final MMActivity activity;
  public TextView titleTv;
  
  static
  {
    AppMethodBeat.i(343949);
    EYH = new FinderLiveSubTagConstract.ViewCallback.Companion((byte)0);
    AppMethodBeat.o(343949);
  }
  
  public FinderLiveSubTagConstract$ViewCallback(MMActivity paramMMActivity, FinderLiveSubTagConstract.Presenter paramPresenter)
  {
    AppMethodBeat.i(343912);
    this.activity = paramMMActivity;
    this.CAS = paramPresenter;
    AppMethodBeat.o(343912);
  }
  
  private static final void a(ViewCallback paramViewCallback, View paramView)
  {
    AppMethodBeat.i(343931);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramViewCallback);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramViewCallback, "this$0");
    paramViewCallback.activity.setResult(0);
    paramViewCallback.activity.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(343931);
  }
  
  private static final void b(ViewCallback paramViewCallback, View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(343942);
    Object localObject2 = new Object();
    Object localObject3 = new b();
    ((b)localObject3).cH(paramViewCallback);
    ((b)localObject3).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject2, ((b)localObject3).aYj());
    s.u(paramViewCallback, "this$0");
    localObject2 = new StringBuilder("select live tag finish. lastTag:[");
    paramView = ((e)paramViewCallback.CAS.getLiveData().business(e.class)).CFe;
    if (paramView == null)
    {
      paramView = null;
      localObject2 = ((StringBuilder)localObject2).append(paramView).append('-');
      paramView = ((e)paramViewCallback.CAS.getLiveData().business(e.class)).CFe;
      if (paramView != null) {
        break label270;
      }
      paramView = null;
      label130:
      localObject2 = ((StringBuilder)localObject2).append(paramView).append("] selectedTag:[");
      paramView = paramViewCallback.CAS.EYD;
      if (paramView != null) {
        break label292;
      }
      paramView = null;
      label155:
      localObject2 = ((StringBuilder)localObject2).append(paramView).append('-');
      paramView = paramViewCallback.CAS.EYD;
      if (paramView != null) {
        break label300;
      }
      paramView = localObject1;
    }
    for (;;)
    {
      Log.i("FinderLiveSubTagConstract.ViewCallback", paramView + ']');
      ((e)paramViewCallback.CAS.getLiveData().business(e.class)).CFe = paramViewCallback.CAS.EYD;
      paramViewCallback.activity.setResult(-1);
      paramViewCallback.activity.finish();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(343942);
      return;
      paramView = paramView.xms;
      break;
      label270:
      paramView = paramView.ZWk;
      if (paramView == null)
      {
        paramView = null;
        break label130;
      }
      paramView = paramView.xms;
      break label130;
      label292:
      paramView = paramView.xms;
      break label155;
      label300:
      localObject3 = paramView.ZWk;
      paramView = localObject1;
      if (localObject3 != null) {
        paramView = ((bno)localObject3).xms;
      }
    }
  }
  
  private TextView eIe()
  {
    AppMethodBeat.i(343919);
    TextView localTextView = this.EtY;
    if (localTextView != null)
    {
      AppMethodBeat.o(343919);
      return localTextView;
    }
    s.bIx("actionBtn");
    AppMethodBeat.o(343919);
    return null;
  }
  
  private RecyclerView eIf()
  {
    AppMethodBeat.i(343923);
    RecyclerView localRecyclerView = this.EYJ;
    if (localRecyclerView != null)
    {
      AppMethodBeat.o(343923);
      return localRecyclerView;
    }
    s.bIx("tagRecyclerView");
    AppMethodBeat.o(343923);
    return null;
  }
  
  public final void eIg()
  {
    AppMethodBeat.i(343970);
    TextView localTextView = eIe();
    Object localObject;
    int i;
    if (this.CAS.EYD != null)
    {
      localObject = this.CAS.EYD;
      if (localObject == null)
      {
        localObject = null;
        localObject = (CharSequence)localObject;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label81;
        }
        i = 1;
        label55:
        if (i != 0) {
          break label86;
        }
      }
    }
    label81:
    label86:
    for (boolean bool = true;; bool = false)
    {
      localTextView.setEnabled(bool);
      AppMethodBeat.o(343970);
      return;
      localObject = ((bno)localObject).xms;
      break;
      i = 0;
      break label55;
    }
  }
  
  public final void initView()
  {
    Object localObject3 = null;
    AppMethodBeat.i(343981);
    Object localObject1 = this.activity.findViewById(p.e.BSM);
    s.s(localObject1, "activity.findViewById(R.…r_live_sub_tag_ui_header)");
    localObject1 = (RelativeLayout)localObject1;
    s.u(localObject1, "<set-?>");
    this.EYI = ((RelativeLayout)localObject1);
    localObject1 = this.activity.findViewById(p.e.BSO);
    s.s(localObject1, "activity.findViewById(R.…sub_tag_ui_header_cancel)");
    localObject1 = (WeImageView)localObject1;
    s.u(localObject1, "<set-?>");
    this.EpW = ((WeImageView)localObject1);
    localObject1 = this.activity.findViewById(p.e.BSP);
    s.s(localObject1, "activity.findViewById(R.…_sub_tag_ui_header_title)");
    localObject1 = (TextView)localObject1;
    s.u(localObject1, "<set-?>");
    this.titleTv = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(p.e.BSN);
    s.s(localObject1, "activity.findViewById(R.…tag_ui_header_action_btn)");
    localObject1 = (TextView)localObject1;
    s.u(localObject1, "<set-?>");
    this.EtY = ((TextView)localObject1);
    localObject1 = this.activity.findViewById(p.e.BSL);
    s.s(localObject1, "activity.findViewById(R.…_live_sub_tag_ui_content)");
    localObject1 = (RecyclerView)localObject1;
    s.u(localObject1, "<set-?>");
    this.EYJ = ((RecyclerView)localObject1);
    eIf().setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    Object localObject2 = eIf();
    localObject1 = this.CAS.ALE;
    if (localObject1 != null)
    {
      ((RecyclerView)localObject2).setAdapter((RecyclerView.a)localObject1);
      localObject1 = eIf().getLayoutParams();
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        break label445;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      label245:
      int i;
      if (localObject1 != null)
      {
        i = ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (bf.bk((Context)this.activity) + i);
      }
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        break label450;
      }
      label279:
      localObject2 = this.CAS.EYA;
      if (localObject2 != null) {
        break label461;
      }
      localObject2 = null;
      label293:
      ((TextView)localObject1).setText((CharSequence)localObject2);
      localObject1 = this.EYI;
      if (localObject1 == null) {
        break label469;
      }
      label310:
      localObject1 = ((RelativeLayout)localObject1).getLayoutParams();
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        break label480;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      label327:
      if (localObject1 != null)
      {
        i = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = (bf.getStatusBarHeight((Context)this.activity) + i);
      }
      localObject1 = this.EpW;
      if (localObject1 == null) {
        break label485;
      }
      label361:
      ((WeImageView)localObject1).setOnClickListener(new FinderLiveSubTagConstract.ViewCallback..ExternalSyntheticLambda1(this));
      eIg();
      if (!this.CAS.EYC) {
        break label497;
      }
      eIe().setText((CharSequence)this.activity.getContext().getResources().getString(p.h.Cuf));
    }
    for (;;)
    {
      eIe().setOnClickListener(new FinderLiveSubTagConstract.ViewCallback..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(343981);
      return;
      s.bIx("adapter");
      localObject1 = null;
      break;
      label445:
      localObject1 = null;
      break label245;
      label450:
      s.bIx("titleTv");
      localObject1 = null;
      break label279;
      label461:
      localObject2 = ((bno)localObject2).xms;
      break label293;
      label469:
      s.bIx("header");
      localObject1 = null;
      break label310;
      label480:
      localObject1 = null;
      break label327;
      label485:
      s.bIx("cancelBtn");
      localObject1 = localObject3;
      break label361;
      label497:
      eIe().setText((CharSequence)this.activity.getContext().getResources().getString(p.h.app_finish));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract.ViewCallback
 * JD-Core Version:    0.7.0.1
 */