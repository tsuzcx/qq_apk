package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "root", "Landroid/view/View;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;", "(Landroid/view/View;Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;)V", "SMALL_ANIMATION_FILE", "", "getSMALL_ANIMATION_FILE", "()Ljava/lang/String;", "countDownTxt", "Landroid/widget/TextView;", "getCountDownTxt", "()Landroid/widget/TextView;", "setCountDownTxt", "(Landroid/widget/TextView;)V", "currentTextSizeDp", "", "getCurrentTextSizeDp", "()F", "setCurrentTextSizeDp", "(F)V", "isPagEnable", "", "kotlin.jvm.PlatformType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "value", "needResize", "getNeedResize", "()Z", "setNeedResize", "(Z)V", "smallAnim", "Lorg/libpag/PAGView;", "getSmallAnim", "()Lorg/libpag/PAGView;", "setSmallAnim", "(Lorg/libpag/PAGView;)V", "smallAnimContainer", "Landroid/widget/FrameLayout;", "getSmallAnimContainer", "()Landroid/widget/FrameLayout;", "setSmallAnimContainer", "(Landroid/widget/FrameLayout;)V", "smallAnimListener", "Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;", "getSmallAnimListener", "()Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;", "setSmallAnimListener", "(Lcom/tencent/mm/plugin/finder/live/component/SmallAnimListener;)V", "getActivity", "getPresenter", "initSmallAnim", "", "initView", "notifyLinkMicStatus", "reset", "resumeLotteryBubble", "callback", "Lkotlin/Function0;", "showLotteryComputing", "showLotteryFinish", "showPrepareLottery", "updateCountDown", "remainTime", "updateCountDownTxtSize", "updateRootViewSize", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  implements z.b
{
  public static final ab.a CyP;
  private static final float CyX;
  private static final String TAG;
  private FrameLayout Cwi;
  private PAGView Cwj;
  private final z.a CyQ;
  private final String CyR;
  TextView CyS;
  private aw CyT;
  private final Boolean CyU;
  private float CyV;
  private boolean CyW;
  private final MMActivity activity;
  private final View lBX;
  
  static
  {
    AppMethodBeat.i(353172);
    CyP = new ab.a((byte)0);
    TAG = "FinderLiveLotteryBubbleViewCallback";
    CyX = MMApplicationContext.getContext().getResources().getDimension(p.c.Edge_13A);
    AppMethodBeat.o(353172);
  }
  
  public ab(View paramView, MMActivity paramMMActivity, z.a parama)
  {
    AppMethodBeat.i(353056);
    this.lBX = paramView;
    this.activity = paramMMActivity;
    this.CyQ = parama;
    this.CyR = "small_lottery_amin.pag";
    this.CyU = ((cn)h.az(cn.class)).isPagEnable();
    this.CyV = 14.0F;
    paramView = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    com.tencent.mm.plugin.finder.utils.aw.aBW("FinderLiveLotteryBubbleViewCallback");
    this.lBX.setTag(Float.valueOf(1.0F));
    AppMethodBeat.o(353056);
  }
  
  private static final void a(ab paramab)
  {
    AppMethodBeat.i(353124);
    s.u(paramab, "this$0");
    FrameLayout localFrameLayout = paramab.Cwi;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(0);
    }
    paramab = paramab.Cwj;
    if (paramab != null) {
      paramab.setProgress(1.0D);
    }
    AppMethodBeat.o(353124);
  }
  
  private static final void a(ab paramab, float paramFloat)
  {
    AppMethodBeat.i(353157);
    s.u(paramab, "this$0");
    paramab.lBX.setScaleX(paramFloat);
    paramab.lBX.setScaleY(paramFloat);
    paramab.lBX.setPivotX(0.0F);
    PAGView localPAGView = paramab.Cwj;
    if (localPAGView != null) {
      localPAGView.setScaleX(paramFloat);
    }
    paramab = paramab.Cwj;
    if (paramab != null) {
      paramab.setScaleY(paramFloat);
    }
    AppMethodBeat.o(353157);
  }
  
  private static final void a(ab paramab, View paramView)
  {
    AppMethodBeat.i(353104);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramab);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramab, "this$0");
    paramab = paramab.CyQ;
    if (paramab != null) {
      paramab.eij();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353104);
  }
  
  private static final void b(ab paramab)
  {
    AppMethodBeat.i(353132);
    s.u(paramab, "this$0");
    FrameLayout localFrameLayout = paramab.Cwi;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(0);
    }
    paramab = paramab.Cwj;
    if (paramab != null) {
      paramab.setProgress(1.0D);
    }
    AppMethodBeat.o(353132);
  }
  
  private static final void b(ab paramab, View paramView)
  {
    AppMethodBeat.i(353115);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramab);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramab, "this$0");
    paramab = paramab.CyQ;
    if (paramab != null) {
      paramab.eij();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleViewCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(353115);
  }
  
  private static final void c(ab paramab)
  {
    AppMethodBeat.i(353143);
    s.u(paramab, "this$0");
    FrameLayout localFrameLayout = paramab.Cwi;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(0);
    }
    paramab = paramab.Cwj;
    if (paramab != null) {
      paramab.setProgress(1.0D);
    }
    AppMethodBeat.o(353143);
  }
  
  private final void eio()
  {
    AppMethodBeat.i(353065);
    if (!this.CyU.booleanValue())
    {
      AppMethodBeat.o(353065);
      return;
    }
    if (this.Cwj == null)
    {
      Log.i(TAG, "initSmallAnim create smallAnim!");
      this.Cwj = new PAGView(this.lBX.getContext());
      this.CyT = new aw(this);
      localObject = this.Cwj;
      if (localObject != null) {
        ((PAGView)localObject).addListener((PAGView.PAGViewListener)this.CyT);
      }
    }
    Object localObject = this.Cwi;
    if ((localObject != null) && (((FrameLayout)localObject).indexOfChild((View)this.Cwj) == -1)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i(TAG, "initSmallAnim add smallAnim!");
        localObject = new FrameLayout.LayoutParams(-1, -1);
        PAGView localPAGView = this.Cwj;
        if (localPAGView != null) {
          localPAGView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        localObject = this.Cwj;
        if (localObject != null) {
          ((PAGView)localObject).setFile(PAGFile.Load(this.activity.getAssets(), this.CyR));
        }
        localObject = this.Cwi;
        if (localObject != null) {
          ((FrameLayout)localObject).addView((View)this.Cwj);
        }
      }
      AppMethodBeat.o(353065);
      return;
    }
  }
  
  private final void eip()
  {
    AppMethodBeat.i(353077);
    if (this.CyW) {}
    for (float f = 0.8F; s.p(this.lBX.getTag(), Float.valueOf(f)); f = 1.0F)
    {
      Log.i(TAG, "updateRootViewSize fail, scale:" + f + ",width:" + this.lBX.getLayoutParams().width);
      AppMethodBeat.o(353077);
      return;
    }
    this.lBX.setTag(Float.valueOf(f));
    Log.i(TAG, s.X("updateRootViewSize scale:", Float.valueOf(f)));
    this.lBX.post(new ab..ExternalSyntheticLambda5(this, f));
    AppMethodBeat.o(353077);
  }
  
  private final void eiq()
  {
    AppMethodBeat.i(353090);
    TextView localTextView = this.CyS;
    if (localTextView != null) {
      if (!this.CyW) {
        break label39;
      }
    }
    label39:
    for (float f = 12.0F;; f = this.CyV)
    {
      localTextView.setTextSize(1, f);
      AppMethodBeat.o(353090);
      return;
    }
  }
  
  public final void aV(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(353273);
    s.u(parama, "callback");
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder("showPrepareLottery smallAnim is null:");
    if (this.Cwj == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject, bool + ",isPagEnable:" + this.CyU);
      if (this.CyU.booleanValue()) {
        break;
      }
      parama.invoke();
      AppMethodBeat.o(353273);
      return;
    }
    reset();
    eio();
    eip();
    localObject = this.Cwi;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.CyS;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.CyT;
    if (localObject != null)
    {
      s.u(parama, "callback");
      ((aw)localObject).CBk = parama;
    }
    parama = this.Cwj;
    if (parama != null) {
      parama.setProgress(0.0D);
    }
    parama = this.Cwj;
    if (parama != null) {
      parama.play();
    }
    AppMethodBeat.o(353273);
  }
  
  public final void aW(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(353291);
    s.u(parama, "callback");
    Object localObject = TAG;
    if (this.Cwj == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject, s.X("resumeLotteryBubble smallAnim is null:", Boolean.valueOf(bool)));
      eio();
      localObject = this.Cwi;
      if (localObject != null) {
        ((FrameLayout)localObject).setVisibility(0);
      }
      localObject = this.Cwj;
      if (localObject != null) {
        ((PAGView)localObject).setProgress(1.0D);
      }
      localObject = this.CyS;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      parama.invoke();
      AppMethodBeat.o(353291);
      return;
    }
  }
  
  public final void awn(String paramString)
  {
    AppMethodBeat.i(353318);
    s.u(paramString, "remainTime");
    Log.i(TAG, s.X("updateCountDown remainTime:", paramString));
    Object localObject = this.Cwi;
    if (localObject != null) {
      ((FrameLayout)localObject).post(new ab..ExternalSyntheticLambda2(this));
    }
    localObject = this.CyS;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.CyS;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)paramString);
    }
    this.CyV = 17.0F;
    eiq();
    AppMethodBeat.o(353318);
  }
  
  public final void eik()
  {
    AppMethodBeat.i(353303);
    Log.i(TAG, "showLotteryComputing");
    eio();
    Object localObject = this.Cwi;
    if (localObject != null) {
      ((FrameLayout)localObject).post(new ab..ExternalSyntheticLambda4(this));
    }
    localObject = this.CyS;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.CyS;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)this.lBX.getContext().getResources().getString(p.h.Cmi));
    }
    this.CyV = 14.0F;
    eiq();
    AppMethodBeat.o(353303);
  }
  
  public final void eil()
  {
    AppMethodBeat.i(353310);
    Log.i(TAG, "showLotteryFinish");
    eio();
    Object localObject = this.Cwi;
    if (localObject != null) {
      ((FrameLayout)localObject).post(new ab..ExternalSyntheticLambda3(this));
    }
    localObject = this.CyS;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.CyS;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)this.lBX.getContext().getResources().getString(p.h.Cmj));
    }
    this.CyV = 14.0F;
    eiq();
    AppMethodBeat.o(353310);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(353250);
    Log.i(TAG, "initView!");
    this.CyS = ((TextView)this.lBX.findViewById(p.e.lvD));
    this.Cwi = ((FrameLayout)this.lBX.findViewById(p.e.BBA));
    Object localObject = this.lBX.findViewById(p.e.BNr);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new ab..ExternalSyntheticLambda0(this));
    }
    localObject = this.CyS;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new ab..ExternalSyntheticLambda1(this));
    }
    eip();
    AppMethodBeat.o(353250);
  }
  
  public final void qq(boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(353326);
    if (paramBoolean != this.CyW) {
      Log.i(TAG, s.X("needResize :", Boolean.valueOf(paramBoolean)));
    }
    this.CyW = paramBoolean;
    Object localObject = this.Cwi;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
    {
      i = 1;
      if (i != 0) {
        eip();
      }
      localObject = this.CyS;
      if ((localObject == null) || (((TextView)localObject).getVisibility() != 0)) {
        break label107;
      }
    }
    label107:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        eiq();
      }
      AppMethodBeat.o(353326);
      return;
      i = 0;
      break;
    }
  }
  
  public final void reset()
  {
    int i = 1;
    AppMethodBeat.i(353261);
    Log.i(TAG, "reset");
    PAGView localPAGView = this.Cwj;
    if ((localPAGView != null) && (localPAGView.isPlaying() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localPAGView = this.Cwj;
        if (localPAGView != null) {
          localPAGView.stop();
        }
      }
      AppMethodBeat.o(353261);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ab
 * JD-Core Version:    0.7.0.1
 */