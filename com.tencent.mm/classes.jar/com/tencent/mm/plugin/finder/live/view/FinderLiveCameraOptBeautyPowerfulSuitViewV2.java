package com.tencent.mm.plugin.finder.live.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/Animator;", "onCloseClick", "Lkotlin/Function0;", "", "getOnCloseClick", "()Lkotlin/jvm/functions/Function0;", "setOnCloseClick", "(Lkotlin/jvm/functions/Function0;)V", "onModeSwitch", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuitMode", "getOnModeSwitch", "()Lkotlin/jvm/functions/Function1;", "setOnModeSwitch", "(Lkotlin/jvm/functions/Function1;)V", "onSuitSwitch", "suit", "getOnSuitSwitch", "setOnSuitSwitch", "value", "getSuit", "()I", "setSuit", "(I)V", "suitMode", "getSuitMode", "()Z", "setSuitMode", "(Z)V", "executeMakeSureNumberColor", "onDetachedFromWindow", "setFixedTextSize", "textView", "Landroid/widget/TextView;", "size", "", "switchModeByUser", "mode", "switchSuitByUser", "suitSelect", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveCameraOptBeautyPowerfulSuitViewV2
  extends RelativeLayout
{
  public static final FinderLiveCameraOptBeautyPowerfulSuitViewV2.a DMa;
  private kotlin.g.a.b<? super Boolean, ah> DLQ;
  private kotlin.g.a.b<? super Integer, ah> DLR;
  private int DLS;
  private boolean DLT;
  private kotlin.g.a.a<ah> DMb;
  private Animator bCA;
  
  static
  {
    AppMethodBeat.i(357708);
    DMa = new FinderLiveCameraOptBeautyPowerfulSuitViewV2.a((byte)0);
    AppMethodBeat.o(357708);
  }
  
  public FinderLiveCameraOptBeautyPowerfulSuitViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(357632);
    AppMethodBeat.o(357632);
  }
  
  public FinderLiveCameraOptBeautyPowerfulSuitViewV2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(357605);
    this.DLS = -1000;
    this.DLT = true;
    View.inflate(paramContext, p.f.Cdj, (ViewGroup)this);
    paramContext = findViewById(p.e.BHO);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitViewV2..ExternalSyntheticLambda5(this));
    }
    paramContext = findViewById(p.e.BIo);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitViewV2..ExternalSyntheticLambda8(this));
    }
    paramContext = findViewById(p.e.BIq);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitViewV2..ExternalSyntheticLambda7(this));
    }
    paramContext = findViewById(p.e.BIs);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitViewV2..ExternalSyntheticLambda2(this));
    }
    paramContext = findViewById(p.e.BIv);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitViewV2..ExternalSyntheticLambda6(this));
    }
    paramContext = findViewById(p.e.BIw);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitViewV2..ExternalSyntheticLambda1(this));
    }
    paramContext = findViewById(p.e.BIx);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitViewV2..ExternalSyntheticLambda3(this));
    }
    paramContext = findViewById(p.e.BIy);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitViewV2..ExternalSyntheticLambda4(this));
    }
    paramContext = findViewById(p.e.BIp);
    s.s(paramContext, "findViewById(R.id.finder…erful_go_to_details_1_tv)");
    a((TextView)paramContext, 15.0F);
    paramContext = findViewById(p.e.BIr);
    s.s(paramContext, "findViewById(R.id.finder…erful_go_to_details_2_tv)");
    a((TextView)paramContext, 15.0F);
    paramContext = findViewById(p.e.BIt);
    s.s(paramContext, "findViewById(R.id.finder…erful_go_to_details_3_tv)");
    a((TextView)paramContext, 15.0F);
    paramContext = findViewById(p.e.BIv);
    s.s(paramContext, "findViewById(R.id.finder…auty_powerful_group_bg_0)");
    a((TextView)paramContext, 16.0F);
    paramContext = findViewById(p.e.BIw);
    s.s(paramContext, "findViewById(R.id.finder…auty_powerful_group_bg_1)");
    a((TextView)paramContext, 16.0F);
    paramContext = findViewById(p.e.BIx);
    s.s(paramContext, "findViewById(R.id.finder…auty_powerful_group_bg_2)");
    a((TextView)paramContext, 16.0F);
    paramContext = findViewById(p.e.BIy);
    s.s(paramContext, "findViewById(R.id.finder…auty_powerful_group_bg_3)");
    a((TextView)paramContext, 16.0F);
    AppMethodBeat.o(357605);
  }
  
  private final void Pw(int paramInt)
  {
    AppMethodBeat.i(357621);
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulSuitView", s.X("#switchSuitByUser suitSelect=", Integer.valueOf(paramInt)));
    if (this.DLS != paramInt)
    {
      setSuit(paramInt);
      kotlin.g.a.b localb = this.DLR;
      if (localb != null) {
        localb.invoke(Integer.valueOf(this.DLS));
      }
    }
    AppMethodBeat.o(357621);
  }
  
  private final void a(TextView paramTextView, float paramFloat)
  {
    AppMethodBeat.i(357625);
    Object localObject = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    localObject = getContext();
    s.s(localObject, "context");
    paramTextView.setTextSize(1, com.tencent.mm.plugin.finder.accessibility.a.g((Context)localObject, paramFloat));
    AppMethodBeat.o(357625);
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulSuitViewV2 paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(357637);
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramFinderLiveCameraOptBeautyPowerfulSuitViewV2 = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(357637);
      throw paramFinderLiveCameraOptBeautyPowerfulSuitViewV2;
    }
    paramFinderLiveCameraOptBeautyPowerfulSuitViewV2.setAlpha(((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(357637);
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulSuitViewV2 paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, View paramView)
  {
    AppMethodBeat.i(357642);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulSuitViewV2 = paramFinderLiveCameraOptBeautyPowerfulSuitViewV2.getOnCloseClick();
    if (paramFinderLiveCameraOptBeautyPowerfulSuitViewV2 != null) {
      paramFinderLiveCameraOptBeautyPowerfulSuitViewV2.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357642);
  }
  
  private static final void b(FinderLiveCameraOptBeautyPowerfulSuitViewV2 paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, View paramView)
  {
    AppMethodBeat.i(357649);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulSuitViewV2.evg();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357649);
  }
  
  private static final void c(FinderLiveCameraOptBeautyPowerfulSuitViewV2 paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, View paramView)
  {
    AppMethodBeat.i(357655);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulSuitViewV2.evg();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357655);
  }
  
  private static final void d(FinderLiveCameraOptBeautyPowerfulSuitViewV2 paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, View paramView)
  {
    AppMethodBeat.i(357666);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulSuitViewV2.evg();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357666);
  }
  
  private static final void e(FinderLiveCameraOptBeautyPowerfulSuitViewV2 paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, View paramView)
  {
    AppMethodBeat.i(357674);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulSuitViewV2.Pw(-1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357674);
  }
  
  private void evg()
  {
    AppMethodBeat.i(357615);
    if (!this.DLT) {}
    for (boolean bool = true;; bool = false)
    {
      rY(bool);
      AppMethodBeat.o(357615);
      return;
    }
  }
  
  private static final void f(FinderLiveCameraOptBeautyPowerfulSuitViewV2 paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, View paramView)
  {
    AppMethodBeat.i(357681);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulSuitViewV2.Pw(0);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357681);
  }
  
  private static final void g(FinderLiveCameraOptBeautyPowerfulSuitViewV2 paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, View paramView)
  {
    AppMethodBeat.i(357692);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulSuitViewV2.Pw(1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357692);
  }
  
  private static final void h(FinderLiveCameraOptBeautyPowerfulSuitViewV2 paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, View paramView)
  {
    AppMethodBeat.i(357695);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitViewV2, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulSuitViewV2.Pw(2);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357695);
  }
  
  public final kotlin.g.a.a<ah> getOnCloseClick()
  {
    return this.DMb;
  }
  
  public final kotlin.g.a.b<Boolean, ah> getOnModeSwitch()
  {
    return this.DLQ;
  }
  
  public final kotlin.g.a.b<Integer, ah> getOnSuitSwitch()
  {
    return this.DLR;
  }
  
  public final int getSuit()
  {
    return this.DLS;
  }
  
  public final boolean getSuitMode()
  {
    return this.DLT;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(357850);
    super.onDetachedFromWindow();
    Animator localAnimator = this.bCA;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    AppMethodBeat.o(357850);
  }
  
  public final void rY(boolean paramBoolean)
  {
    AppMethodBeat.i(357842);
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulSuitView", s.X("#switchModeByUser mode=", Boolean.valueOf(paramBoolean)));
    setSuitMode(paramBoolean);
    kotlin.g.a.b localb = this.DLQ;
    if (localb != null) {
      localb.invoke(Boolean.valueOf(this.DLT));
    }
    AppMethodBeat.o(357842);
  }
  
  public final void setOnCloseClick(kotlin.g.a.a<ah> parama)
  {
    this.DMb = parama;
  }
  
  public final void setOnModeSwitch(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    this.DLQ = paramb;
  }
  
  public final void setOnSuitSwitch(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    this.DLR = paramb;
  }
  
  public final void setSuit(int paramInt)
  {
    AppMethodBeat.i(357819);
    Object localObject2 = new StringBuilder("#suit set value=").append(paramInt).append(" field=").append(this.DLS).append(" isAnimatorRunning=");
    Object localObject1 = this.bCA;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("Finder.FinderLiveCameraOptBeautyPowerfulSuitView", localObject1);
      if (paramInt != this.DLS)
      {
        localObject1 = this.bCA;
        if ((localObject1 == null) || (((Animator)localObject1).isRunning() != true)) {
          break label125;
        }
      }
    }
    label125:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label130;
      }
      AppMethodBeat.o(357819);
      return;
      localObject1 = Boolean.valueOf(((Animator)localObject1).isRunning());
      break;
    }
    label130:
    this.DLS = paramInt;
    paramInt = p.d.BBj;
    i = p.d.BBk;
    findViewById(p.e.BIv).setBackgroundResource(paramInt);
    findViewById(p.e.BIw).setBackgroundResource(paramInt);
    findViewById(p.e.BIx).setBackgroundResource(paramInt);
    findViewById(p.e.BIy).setBackgroundResource(paramInt);
    findViewById(p.e.BIo).setVisibility(4);
    findViewById(p.e.BIq).setVisibility(4);
    findViewById(p.e.BIs).setVisibility(4);
    label304:
    label331:
    int j;
    switch (this.DLS)
    {
    default: 
      localObject1 = null;
      localObject2 = null;
      if (localObject2 != null) {
        ((View)localObject2).setBackgroundResource(i);
      }
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = getContext().getResources();
      if (this.DLT)
      {
        paramInt = p.b.force_notify_text_white_50;
        paramInt = ((Resources)localObject1).getColor(paramInt);
        localObject1 = getContext().getResources();
        if (!this.DLT) {
          break label539;
        }
        i = p.b.ByS;
        i = ((Resources)localObject1).getColor(i);
        localObject1 = (TextView)findViewById(p.e.BIv);
        if (this.DLS != -1) {
          break label546;
        }
        j = i;
        label360:
        ((TextView)localObject1).setTextColor(j);
        localObject1 = (TextView)findViewById(p.e.BIw);
        if (this.DLS != 0) {
          break label551;
        }
        j = i;
        label387:
        ((TextView)localObject1).setTextColor(j);
        localObject1 = (TextView)findViewById(p.e.BIx);
        if (this.DLS != 1) {
          break label556;
        }
        j = i;
        label415:
        ((TextView)localObject1).setTextColor(j);
        localObject1 = (TextView)findViewById(p.e.BIy);
        if (this.DLS != 2) {
          break label561;
        }
      }
      break;
    }
    for (;;)
    {
      ((TextView)localObject1).setTextColor(i);
      AppMethodBeat.o(357819);
      return;
      localObject2 = findViewById(p.e.BIv);
      localObject1 = null;
      break;
      localObject2 = findViewById(p.e.BIw);
      localObject1 = findViewById(p.e.BIo);
      break;
      localObject2 = findViewById(p.e.BIx);
      localObject1 = findViewById(p.e.BIq);
      break;
      localObject2 = findViewById(p.e.BIy);
      localObject1 = findViewById(p.e.BIs);
      break;
      paramInt = p.b.hot_tab_BW_100_Alpha_0_3;
      break label304;
      label539:
      i = p.b.Bzh;
      break label331;
      label546:
      j = paramInt;
      break label360;
      label551:
      j = paramInt;
      break label387;
      label556:
      j = paramInt;
      break label415;
      label561:
      i = paramInt;
    }
  }
  
  public final void setSuitMode(boolean paramBoolean)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(357835);
    Object localObject2 = new StringBuilder("#mode set value=").append(paramBoolean).append(" field=").append(this.DLT).append(" isAnimatorRunning=");
    Object localObject1 = this.bCA;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i("Finder.FinderLiveCameraOptBeautyPowerfulSuitView", localObject1);
      if (paramBoolean != this.DLT)
      {
        localObject1 = this.bCA;
        if ((localObject1 == null) || (((Animator)localObject1).isRunning() != true)) {
          break label129;
        }
      }
    }
    label129:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label135;
      }
      AppMethodBeat.o(357835);
      return;
      localObject1 = Boolean.valueOf(((Animator)localObject1).isRunning());
      break;
    }
    label135:
    this.DLT = paramBoolean;
    float f1;
    if (this.DLT)
    {
      f1 = 0.0F;
      if (!this.DLT) {
        break label257;
      }
    }
    for (;;)
    {
      localObject1 = this.bCA;
      if (localObject1 != null) {
        ((Animator)localObject1).cancel();
      }
      localObject1 = ValueAnimator.ofFloat(new float[] { f1, f2 });
      ((ValueAnimator)localObject1).addUpdateListener(new FinderLiveCameraOptBeautyPowerfulSuitViewV2..ExternalSyntheticLambda0(this));
      ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new b(this));
      ((ValueAnimator)localObject1).setDuration(360L);
      ((ValueAnimator)localObject1).start();
      localObject2 = ah.aiuX;
      this.bCA = ((Animator)localObject1);
      AppMethodBeat.o(357835);
      return;
      f1 = 1.0F;
      break;
      label257:
      f2 = 0.0F;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitViewV2$suitMode$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(FinderLiveCameraOptBeautyPowerfulSuitViewV2 paramFinderLiveCameraOptBeautyPowerfulSuitViewV2) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(358175);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = this.DMc;
      float f;
      if (FinderLiveCameraOptBeautyPowerfulSuitViewV2.a(this.DMc))
      {
        f = 1.0F;
        FinderLiveCameraOptBeautyPowerfulSuitViewV2.a(paramAnimator, f);
        paramAnimator = this.DMc;
        if (!FinderLiveCameraOptBeautyPowerfulSuitViewV2.a(this.DMc)) {
          break label65;
        }
      }
      label65:
      for (int i = 0;; i = 4)
      {
        paramAnimator.setVisibility(i);
        AppMethodBeat.o(358175);
        return;
        f = 0.0F;
        break;
      }
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(358170);
      super.onAnimationStart(paramAnimator);
      this.DMc.setVisibility(0);
      AppMethodBeat.o(358170);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveCameraOptBeautyPowerfulSuitViewV2
 * JD-Core Version:    0.7.0.1
 */