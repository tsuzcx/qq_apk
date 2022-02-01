package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardContract$ViewCallback;", "root", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardContract$Presenter;)V", "btnClose", "Landroid/widget/ImageView;", "value", "", "isVisitorGuideShowed", "()Z", "setVisitorGuideShowed", "(Z)V", "onCardCloseClick", "Lkotlin/Function0;", "", "getOnCardCloseClick", "()Lkotlin/jvm/functions/Function0;", "setOnCardCloseClick", "(Lkotlin/jvm/functions/Function0;)V", "viewAnchorGuide", "viewFailed", "viewVisitorGuide", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "hideCardView", "onMount", "onUnmount", "reset", "showAnchorGuideCardView", "showFailedCardView", "showVisitorGuideCardView", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements d.b
{
  public static final f.a Cwo;
  private final d.a Cwp;
  private View Cwq;
  private View Cwr;
  private View Cws;
  private ImageView Cwt;
  public kotlin.g.a.a<ah> Cwu;
  private final MMActivity activity;
  public final View lBX;
  
  static
  {
    AppMethodBeat.i(352526);
    Cwo = new f.a((byte)0);
    AppMethodBeat.o(352526);
  }
  
  public f(View paramView, MMActivity paramMMActivity, d.a parama)
  {
    AppMethodBeat.i(352505);
    this.lBX = paramView;
    this.activity = paramMMActivity;
    this.Cwp = parama;
    this.Cwq = this.lBX.findViewById(p.e.BVR);
    this.Cwr = this.lBX.findViewById(p.e.BVQ);
    this.Cws = this.lBX.findViewById(p.e.BVU);
    this.Cwt = ((ImageView)this.lBX.findViewById(p.e.close));
    paramView = this.Cwt;
    if (paramView != null) {
      paramView.setOnClickListener(new f..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(352505);
  }
  
  private static final void a(f paramf, View paramView)
  {
    AppMethodBeat.i(352518);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    paramf = paramf.Cwu;
    if (paramf != null) {
      paramf.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveAllowanceGiftCardViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(352518);
  }
  
  public final MMFragmentActivity dUP()
  {
    return (MMFragmentActivity)this.activity;
  }
  
  public final void ehA()
  {
    Object localObject2 = null;
    AppMethodBeat.i(352568);
    View localView = this.Cws;
    Object localObject1;
    if (localView != null)
    {
      localObject1 = this.Cws;
      if (localObject1 != null) {
        break label38;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      localView.setBackground((Drawable)localObject1);
      AppMethodBeat.o(352568);
      return;
      label38:
      Object localObject3 = ((View)localObject1).getContext();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((Context)localObject3).getResources();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Resources)localObject3).getDrawable(p.d.BzK);
        }
      }
    }
  }
  
  public final void ehB()
  {
    AppMethodBeat.i(352577);
    View localView = this.Cws;
    if (localView != null) {
      localView.setBackground(null);
    }
    AppMethodBeat.o(352577);
  }
  
  public final void ehx()
  {
    AppMethodBeat.i(352545);
    View localView = this.Cwq;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.Cwr;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.Cws;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.lBX.setVisibility(0);
    AppMethodBeat.o(352545);
  }
  
  public final void ehy()
  {
    AppMethodBeat.i(352555);
    View localView = this.Cwq;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.Cwr;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.Cws;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.lBX.setVisibility(0);
    AppMethodBeat.o(352555);
  }
  
  public final void ehz()
  {
    AppMethodBeat.i(352562);
    if (MultiProcessMMKV.getDefault().getBoolean("MMKVFinderLiveAllowanceGiftCardViewCallbackAnchor", false))
    {
      AppMethodBeat.o(352562);
      return;
    }
    MultiProcessMMKV.getDefault().putBoolean("MMKVFinderLiveAllowanceGiftCardViewCallbackAnchor", true);
    View localView = this.Cwq;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.Cwr;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.Cws;
    if (localView != null) {
      localView.setVisibility(0);
    }
    this.lBX.setVisibility(0);
    AppMethodBeat.o(352562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.f
 * JD-Core Version:    0.7.0.1
 */