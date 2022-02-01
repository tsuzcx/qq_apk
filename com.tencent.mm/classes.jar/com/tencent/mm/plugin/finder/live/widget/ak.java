package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.model.r;
import com.tencent.mm.live.model.r.a;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.util.g;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveLoadingTipWidget;", "", "root", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "TAG", "", "actionTv", "Landroid/widget/TextView;", "bgHideAnim", "Landroid/animation/ValueAnimator;", "blurBgView", "Landroid/widget/ImageView;", "container", "countDownTv", "descTv", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "pauseTime", "", "getPauseTime", "()I", "setPauseTime", "(I)V", "progressTips", "progressView", "Landroid/view/View;", "showProgressTask", "Ljava/lang/Runnable;", "timeCountThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getTimeCountThread", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setTimeCountThread", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "timeCountTv", "getTimeCountTv", "()Landroid/widget/TextView;", "setTimeCountTv", "(Landroid/widget/TextView;)V", "titleTv", "bindData", "", "checkIfNeedAddToDecorView", "fillBlurBg", "", "username", "withoutBlur", "forcestopTimer", "getBlurBgElevation", "", "hideLoadingLayer", "withAnimation", "hideProgress", "hideTimeCount", "report", "isBlurBgVisible", "isLoadingTipWidgetVisible", "postShowProgressView", "delay", "", "showBlurBg", "showBlurBgWithTimeCount", "tip", "showProgress", "showProgressWithBlurBg", "showProgressWithTips", "tips", "showTipWithBlurBg", "showTipWithBlurBgAction", "actionTxt", "action", "Lkotlin/Function0;", "showVerificationLayerInfo", "title", "desc", "interceptTouchEvent", "showBg", "callback", "Lkotlin/Function1;", "startPauseTime", "tryReportPause", "tryReportPauseRecovery", "unMount", "updateVerificationButtonState", "buttonWording", "", "enable", "updateVerificationCountDownTip", "countDownTip", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
{
  public final TextView AkE;
  public final ViewGroup CAj;
  public int CWv;
  public com.tencent.mm.plugin.finder.live.model.context.a CvU;
  public ValueAnimator Ern;
  public final ImageView Ero;
  public final View Erp;
  public TextView Erq;
  public final Runnable Err;
  public MTimerHandler Ers;
  private final String TAG;
  public final TextView descTv;
  public final ViewGroup mJe;
  public final TextView njJ;
  public TextView nmm;
  public final TextView titleTv;
  
  public ak(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(361572);
    this.mJe = paramViewGroup;
    this.TAG = "FinderLiveLoadingTipWidget";
    paramViewGroup = this.mJe.findViewById(p.e.live_loading_blur);
    s.s(paramViewGroup, "root.findViewById(R.id.live_loading_blur)");
    this.Ero = ((ImageView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.live_loading_bar);
    s.s(paramViewGroup, "root.findViewById(R.id.live_loading_bar)");
    this.Erp = paramViewGroup;
    paramViewGroup = this.mJe.findViewById(p.e.BWT);
    s.s(paramViewGroup, "root.findViewById(R.id.live_loading_tips)");
    this.AkE = ((TextView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BMz);
    s.s(paramViewGroup, "root.findViewById(R.id.f…er_live_layer_show_title)");
    this.titleTv = ((TextView)paramViewGroup);
    this.Erq = ((TextView)this.mJe.findViewById(p.e.CbC));
    paramViewGroup = this.mJe.findViewById(p.e.BMy);
    s.s(paramViewGroup, "root.findViewById(R.id.f…der_live_layer_show_desc)");
    this.descTv = ((TextView)paramViewGroup);
    paramViewGroup = this.mJe.findViewById(p.e.BMx);
    s.s(paramViewGroup, "root.findViewById(R.id.f…ayer_show_btn_count_down)");
    this.njJ = ((TextView)paramViewGroup);
    this.nmm = ((TextView)this.mJe.findViewById(p.e.BMw));
    paramViewGroup = this.mJe.findViewById(p.e.BNp);
    s.s(paramViewGroup, "root.findViewById(R.id.f…live_loading_tip_ui_root)");
    this.CAj = ((ViewGroup)paramViewGroup);
    aw.a((Paint)this.titleTv.getPaint(), 0.8F);
    paramViewGroup = this.Erq;
    if (paramViewGroup == null)
    {
      paramViewGroup = null;
      aw.a((Paint)paramViewGroup, 0.8F);
      this.Err = new ak..ExternalSyntheticLambda5(this);
      this.CAj.setClickable(false);
      paramViewGroup = this.CAj;
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
        break label341;
      }
    }
    label341:
    for (float f = this.mJe.getContext().getResources().getDimensionPixelSize(p.c.live_ui_layer_4);; f = this.mJe.getContext().getResources().getDimensionPixelSize(p.c.live_ui_layer_1))
    {
      paramViewGroup.setElevation(f);
      AppMethodBeat.o(361572);
      return;
      paramViewGroup = paramViewGroup.getPaint();
      break;
    }
  }
  
  private static final void a(ak paramak, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(361642);
    s.u(paramak, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramak = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(361642);
      throw paramak;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramak.Erp.setAlpha(f);
    paramak.titleTv.setAlpha(f);
    AppMethodBeat.o(361642);
  }
  
  private static final boolean a(ak paramak, final com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(361632);
    s.u(paramak, "this$0");
    s.u(parama, "$it");
    d.uiThread((kotlin.g.a.a)new c(paramak, parama));
    AppMethodBeat.o(361632);
    return true;
  }
  
  private static final void b(ak paramak)
  {
    AppMethodBeat.i(361591);
    s.u(paramak, "this$0");
    paramak.Erp.setVisibility(0);
    AppMethodBeat.o(361591);
  }
  
  private void eAZ()
  {
    AppMethodBeat.i(361578);
    Log.i(this.TAG, "hideTimeCount");
    Object localObject = this.Erq;
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = this.Erq;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        localObject = this.Ers;
        if (localObject != null) {
          ((MTimerHandler)localObject).stopTimer();
        }
      }
      AppMethodBeat.o(361578);
      return;
    }
  }
  
  private static final void gq(View paramView)
  {
    AppMethodBeat.i(361622);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveLoadingTipWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveLoadingTipWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361622);
  }
  
  private static final void j(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(361602);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveLoadingTipWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    if (parama != null) {
      parama.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveLoadingTipWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361602);
  }
  
  private static final void j(kotlin.g.a.b paramb, View paramView)
  {
    AppMethodBeat.i(361613);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveLoadingTipWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$_callback");
    paramb.invoke(Boolean.TRUE);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveLoadingTipWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361613);
  }
  
  public final void eBa()
  {
    ViewGroup localViewGroup = null;
    AppMethodBeat.i(361823);
    if ((this.CAj.getWidth() == 0) && (this.CAj.getHeight() == 0))
    {
      Log.i(this.TAG, "checkIfNeedAddToDecorView: width and height = 0");
      Object localObject = this.mJe.getContext();
      if ((localObject instanceof Activity))
      {
        localObject = (Activity)localObject;
        if (localObject != null) {
          break label92;
        }
        localObject = null;
        label64:
        if (!(localObject instanceof FrameLayout)) {
          break label114;
        }
      }
      label92:
      label114:
      for (localObject = (FrameLayout)localObject;; localObject = null)
      {
        if (localObject != null) {
          break label119;
        }
        AppMethodBeat.o(361823);
        return;
        localObject = null;
        break;
        localObject = ((Activity)localObject).getWindow();
        if (localObject == null)
        {
          localObject = null;
          break label64;
        }
        localObject = ((Window)localObject).getDecorView();
        break label64;
      }
      label119:
      ViewParent localViewParent = this.CAj.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        localViewGroup = (ViewGroup)localViewParent;
      }
      if (localViewGroup == null)
      {
        AppMethodBeat.o(361823);
        return;
      }
      if (!s.p(localViewGroup, localObject))
      {
        Log.i(this.TAG, "checkIfNeedAddToDecorView: add to decor view");
        localViewGroup.removeView((View)this.CAj);
        ((FrameLayout)localObject).addView((View)this.CAj);
      }
    }
    AppMethodBeat.o(361823);
  }
  
  public final boolean fillBlurBg(final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(361759);
    Object localObject1 = this.CvU;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = this.CvU;
      if (localObject2 == null) {
        break label236;
      }
      localObject2 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(e.class);
      if (localObject2 == null) {
        break label236;
      }
      localObject2 = ((e)localObject2).Eco;
      if (localObject2 == null) {
        break label236;
      }
      localObject2 = ((FinderObject)localObject2).liveInfo;
      if ((localObject2 == null) || (((bip)localObject2).ZRU != 1)) {
        break label236;
      }
      i = 1;
      label86:
      if ((i == 0) && (!paramBoolean)) {
        break label246;
      }
      if (((CharSequence)localObject1).length() != 0) {
        break label241;
      }
    }
    label236:
    label241:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label246;
      }
      ((cn)h.az(cn.class)).loadImage((String)localObject1, this.Ero);
      Log.i(this.TAG, "showThumbUrlBg withoutBlur:" + paramBoolean + " username:" + paramString + ", url:" + (String)localObject1);
      AppMethodBeat.o(361759);
      return true;
      localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      localObject2 = ((e)localObject1).eyo();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      i = 0;
      break label86;
    }
    label246:
    Object localObject2 = g.DIp;
    paramBoolean = g.a(paramString, (String)localObject1, (View)this.Ero, (kotlin.g.a.b)new a(this, paramString, (String)localObject1));
    AppMethodBeat.o(361759);
    return paramBoolean;
  }
  
  public final void hideLoadingLayer(boolean paramBoolean)
  {
    AppMethodBeat.i(361813);
    this.Erp.removeCallbacks(this.Err);
    Object localObject;
    if (this.Ern == null)
    {
      this.Ern = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localObject = this.Ern;
      if (localObject != null)
      {
        ((ValueAnimator)localObject).addUpdateListener(new ak..ExternalSyntheticLambda0(this));
        ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new b(this));
      }
    }
    if (paramBoolean)
    {
      localObject = this.Ern;
      if (localObject != null)
      {
        ((ValueAnimator)localObject).start();
        AppMethodBeat.o(361813);
      }
    }
    else
    {
      hideProgress();
      eAZ();
      this.Ero.setElevation(this.mJe.getContext().getResources().getDimensionPixelSize(p.c.live_ui_layer_0));
      this.titleTv.setVisibility(8);
      this.descTv.setVisibility(8);
      this.njJ.setVisibility(8);
      localObject = this.nmm;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      this.CAj.setVisibility(8);
      this.CAj.setClickable(false);
    }
    AppMethodBeat.o(361813);
  }
  
  public final void hideProgress()
  {
    AppMethodBeat.i(361803);
    this.Erp.setVisibility(8);
    this.AkE.setVisibility(8);
    AppMethodBeat.o(361803);
  }
  
  public final void showTipWithBlurBgAction(String paramString1, String paramString2, String paramString3, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(361768);
    s.u(paramString1, "username");
    s.u(paramString2, "tip");
    s.u(paramString3, "actionTxt");
    ValueAnimator localValueAnimator = this.Ern;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localValueAnimator = this.Ern;
        if (localValueAnimator != null) {
          localValueAnimator.end();
        }
      }
      this.CAj.setVisibility(0);
      fillBlurBg(paramString1, true);
      this.Ero.setElevation(this.mJe.getContext().getResources().getDimensionPixelSize(p.c.live_ui_layer_1));
      this.Erp.setVisibility(8);
      this.AkE.setVisibility(8);
      this.titleTv.setVisibility(0);
      this.titleTv.setText((CharSequence)paramString2);
      this.njJ.setVisibility(8);
      paramString1 = this.nmm;
      if (paramString1 != null) {
        paramString1.setOnClickListener(new ak..ExternalSyntheticLambda1(parama));
      }
      paramString1 = this.nmm;
      if (paramString1 != null) {
        paramString1.setVisibility(0);
      }
      paramString1 = this.nmm;
      if (paramString1 != null) {
        paramString1.setText((CharSequence)paramString3);
      }
      startPauseTime();
      this.descTv.setVisibility(8);
      this.CAj.setClickable(false);
      this.mJe.requestLayout();
      AppMethodBeat.o(361768);
      return;
    }
  }
  
  public final void showVerificationLayerInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(361785);
    s.u(paramString1, "title");
    ValueAnimator localValueAnimator = this.Ern;
    int i;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning() == true))
    {
      i = 1;
      if (i != 0)
      {
        localValueAnimator = this.Ern;
        if (localValueAnimator != null) {
          localValueAnimator.end();
        }
      }
      this.CAj.setVisibility(0);
      hideProgress();
      if (!paramBoolean2) {
        break label280;
      }
      fillBlurBg(null, true);
      this.Ero.setElevation(this.mJe.getContext().getResources().getDimensionPixelSize(p.c.live_ui_layer_1));
      label105:
      this.titleTv.setVisibility(0);
      this.titleTv.setText((CharSequence)paramString1);
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label307;
      }
      i = 1;
      label145:
      if (i == 0) {
        break label313;
      }
      this.descTv.setVisibility(8);
      label159:
      eAZ();
      paramString1 = (CharSequence)paramString3;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label335;
      }
      i = 1;
      label184:
      if (i == 0) {
        break label341;
      }
      paramString1 = this.nmm;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      label204:
      if (paramb != null)
      {
        paramString1 = this.nmm;
        if (paramString1 != null) {
          paramString1.setOnClickListener(new ak..ExternalSyntheticLambda2(paramb));
        }
      }
      if (!paramBoolean1) {
        break label375;
      }
      this.CAj.setOnClickListener(ak..ExternalSyntheticLambda3.INSTANCE);
    }
    for (;;)
    {
      this.mJe.requestLayout();
      paramString1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
        eBa();
      }
      AppMethodBeat.o(361785);
      return;
      i = 0;
      break;
      label280:
      this.Ero.setElevation(this.mJe.getContext().getResources().getDimensionPixelSize(p.c.live_ui_layer_0));
      break label105;
      label307:
      i = 0;
      break label145;
      label313:
      this.descTv.setVisibility(0);
      this.descTv.setText((CharSequence)paramString2);
      break label159;
      label335:
      i = 0;
      break label184;
      label341:
      paramString1 = this.nmm;
      if (paramString1 != null) {
        paramString1.setVisibility(0);
      }
      paramString1 = this.nmm;
      if (paramString1 == null) {
        break label204;
      }
      paramString1.setText((CharSequence)paramString3);
      break label204;
      label375:
      this.CAj.setClickable(false);
    }
  }
  
  public final void startPauseTime()
  {
    AppMethodBeat.i(361795);
    Object localObject = this.CvU;
    if (localObject != null)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = ((e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(e.class)).Een;
      if (1L <= l2) {
        if (l2 < l1)
        {
          i = 1;
          if (i == 0) {
            break label195;
          }
        }
      }
      label195:
      for (i = (int)((l1 - ((e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(e.class)).Een) / 1000L);; i = ((e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(e.class)).Eeo)
      {
        this.CWv = i;
        Log.i(this.TAG, "startPauseTime: curTime:" + l1 + ", anchorPauseStartTime:" + ((e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(e.class)).Een + ", anchorPauseTimeCount:" + ((e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(e.class)).Eeo + ", pauseTime:" + this.CWv);
        if (this.CWv >= 0) {
          break label213;
        }
        eAZ();
        AppMethodBeat.o(361795);
        return;
        i = 0;
        break;
        i = 0;
        break;
      }
      label213:
      TextView localTextView = this.Erq;
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      localTextView = this.Erq;
      if (localTextView != null)
      {
        r.a locala = r.mZi;
        localTextView.setText((CharSequence)r.a.I(this.CWv, ":"));
      }
      if (this.Ers == null) {
        this.Ers = new MTimerHandler("LiveVisitorPause::Timer", new ak..ExternalSyntheticLambda4(this, (com.tencent.mm.plugin.finder.live.model.context.a)localObject), true);
      }
      localObject = this.Ers;
      if ((localObject == null) || (((MTimerHandler)localObject).stopped() != true)) {
        break label348;
      }
    }
    label348:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = this.Ers;
        if (localObject != null) {
          ((MTimerHandler)localObject).startTimer(1000L);
        }
      }
      AppMethodBeat.o(361795);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    a(ak paramak, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveLoadingTipWidget$hideLoadingLayer$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(ak paramak) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(361634);
      ak.f(this.Ert).setAlpha(1.0F);
      ak.e(this.Ert).setAlpha(1.0F);
      ak.d(this.Ert).setElevation(ak.g(this.Ert).getContext().getResources().getDimensionPixelSize(p.c.live_ui_layer_0));
      ak.f(this.Ert).setVisibility(8);
      ak.h(this.Ert).setVisibility(8);
      ak.e(this.Ert).setVisibility(8);
      ak.i(this.Ert).setVisibility(8);
      ak.j(this.Ert).setVisibility(8);
      paramAnimator = ak.k(this.Ert);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      ak.a(this.Ert);
      ak.l(this.Ert).setVisibility(8);
      ak.l(this.Ert).setClickable(false);
      AppMethodBeat.o(361634);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(361619);
      ak.f(this.Ert).setAlpha(1.0F);
      ak.e(this.Ert).setAlpha(1.0F);
      ak.d(this.Ert).setElevation(ak.g(this.Ert).getContext().getResources().getDimensionPixelSize(p.c.live_ui_layer_0));
      ak.f(this.Ert).setVisibility(8);
      ak.h(this.Ert).setVisibility(8);
      ak.e(this.Ert).setVisibility(8);
      ak.i(this.Ert).setVisibility(8);
      ak.j(this.Ert).setVisibility(8);
      paramAnimator = ak.k(this.Ert);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      ak.a(this.Ert);
      ak.l(this.Ert).setVisibility(8);
      ak.l(this.Ert).setClickable(false);
      AppMethodBeat.o(361619);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(ak paramak, com.tencent.mm.plugin.finder.live.model.context.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ak
 * JD-Core Version:    0.7.0.1
 */