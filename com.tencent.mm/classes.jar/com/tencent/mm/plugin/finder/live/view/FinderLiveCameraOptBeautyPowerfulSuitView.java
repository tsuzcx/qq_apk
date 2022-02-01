package com.tencent.mm.plugin.finder.live.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/Animator;", "onModeSwitch", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuitMode", "", "getOnModeSwitch", "()Lkotlin/jvm/functions/Function1;", "setOnModeSwitch", "(Lkotlin/jvm/functions/Function1;)V", "onSuitSwitch", "suit", "getOnSuitSwitch", "setOnSuitSwitch", "value", "getSuit", "()I", "setSuit", "(I)V", "suitMode", "getSuitMode", "()Z", "setSuitMode", "(Z)V", "executeMakeSureNumberColor", "onDetachedFromWindow", "setFixedTextSize", "textView", "Landroid/widget/TextView;", "size", "", "switchModeByUser", "mode", "switchSuitByUser", "suitSelect", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveCameraOptBeautyPowerfulSuitView
  extends RelativeLayout
{
  public static final FinderLiveCameraOptBeautyPowerfulSuitView.a DLP;
  private kotlin.g.a.b<? super Boolean, ah> DLQ;
  private kotlin.g.a.b<? super Integer, ah> DLR;
  private int DLS;
  private boolean DLT;
  private Animator bCA;
  
  static
  {
    AppMethodBeat.i(358464);
    DLP = new FinderLiveCameraOptBeautyPowerfulSuitView.a((byte)0);
    AppMethodBeat.o(358464);
  }
  
  public FinderLiveCameraOptBeautyPowerfulSuitView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(358294);
    AppMethodBeat.o(358294);
  }
  
  public FinderLiveCameraOptBeautyPowerfulSuitView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(358253);
    this.DLS = -1000;
    this.DLT = true;
    View.inflate(paramContext, p.f.Cdi, (ViewGroup)this);
    paramContext = findViewById(p.e.BIo);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitView..ExternalSyntheticLambda5(this));
    }
    paramContext = findViewById(p.e.BIq);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitView..ExternalSyntheticLambda9(this));
    }
    paramContext = findViewById(p.e.BIs);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitView..ExternalSyntheticLambda7(this));
    }
    paramContext = findViewById(p.e.BIw);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitView..ExternalSyntheticLambda11(this));
    }
    paramContext = findViewById(p.e.BIx);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitView..ExternalSyntheticLambda4(this));
    }
    paramContext = findViewById(p.e.BIy);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitView..ExternalSyntheticLambda8(this));
    }
    paramContext = findViewById(p.e.BIi);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitView..ExternalSyntheticLambda6(this));
    }
    paramContext = findViewById(p.e.BIk);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitView..ExternalSyntheticLambda12(this));
    }
    paramContext = findViewById(p.e.BIm);
    if (paramContext != null) {
      paramContext.setOnClickListener(new FinderLiveCameraOptBeautyPowerfulSuitView..ExternalSyntheticLambda10(this));
    }
    paramContext = findViewById(p.e.BIp);
    s.s(paramContext, "findViewById(R.id.finder…erful_go_to_details_1_tv)");
    a((TextView)paramContext, 14.0F);
    paramContext = findViewById(p.e.BIr);
    s.s(paramContext, "findViewById(R.id.finder…erful_go_to_details_2_tv)");
    a((TextView)paramContext, 14.0F);
    paramContext = findViewById(p.e.BIt);
    s.s(paramContext, "findViewById(R.id.finder…erful_go_to_details_3_tv)");
    a((TextView)paramContext, 14.0F);
    paramContext = findViewById(p.e.BIA);
    s.s(paramContext, "findViewById(R.id.finder…beauty_powerful_number_1)");
    a((TextView)paramContext, 24.0F);
    paramContext = findViewById(p.e.BIB);
    s.s(paramContext, "findViewById(R.id.finder…beauty_powerful_number_2)");
    a((TextView)paramContext, 24.0F);
    paramContext = findViewById(p.e.BIC);
    s.s(paramContext, "findViewById(R.id.finder…beauty_powerful_number_3)");
    a((TextView)paramContext, 24.0F);
    AppMethodBeat.o(358253);
  }
  
  private final void Pw(int paramInt)
  {
    AppMethodBeat.i(358279);
    Log.i("Finder.FinderLiveCameraOptBeautyPowerfulSuitView", s.X("#switchSuitByUser suitSelect=", Integer.valueOf(paramInt)));
    int i = paramInt;
    if (this.DLS == paramInt)
    {
      i = paramInt;
      if (this.DLT) {
        i = -1;
      }
    }
    setSuit(i);
    kotlin.g.a.b localb = this.DLR;
    if (localb != null) {
      localb.invoke(Integer.valueOf(this.DLS));
    }
    AppMethodBeat.o(358279);
  }
  
  private static final void a(int paramInt1, int paramInt2, FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(358333);
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramFinderLiveCameraOptBeautyPowerfulSuitView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(358333);
      throw paramFinderLiveCameraOptBeautyPowerfulSuitView;
    }
    a(paramFinderLiveCameraOptBeautyPowerfulSuitView, paramInt1, paramInt2, ((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(358333);
  }
  
  private final void a(TextView paramTextView, float paramFloat)
  {
    AppMethodBeat.i(358286);
    Object localObject = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    localObject = getContext();
    s.s(localObject, "context");
    paramTextView.setTextSize(1, com.tencent.mm.plugin.finder.accessibility.a.g((Context)localObject, paramFloat));
    AppMethodBeat.o(358286);
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, float paramFloat)
  {
    AppMethodBeat.i(358316);
    paramFinderLiveCameraOptBeautyPowerfulSuitView.findViewById(p.e.BIu).setAlpha(paramFloat);
    AppMethodBeat.o(358316);
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(358327);
    float f = paramInt2 - paramInt1;
    paramFloat = paramInt1 + f * paramFloat;
    ((TextView)paramFinderLiveCameraOptBeautyPowerfulSuitView.findViewById(p.e.BIA)).setTextSize(0, paramFloat);
    ((TextView)paramFinderLiveCameraOptBeautyPowerfulSuitView.findViewById(p.e.BIB)).setTextSize(0, paramFloat);
    ((TextView)paramFinderLiveCameraOptBeautyPowerfulSuitView.findViewById(p.e.BIC)).setTextSize(0, paramFloat);
    AppMethodBeat.o(358327);
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    AppMethodBeat.i(358302);
    if (paramFinderLiveCameraOptBeautyPowerfulSuitView.DLT) {
      paramInt1 = kotlin.h.a.eH(paramInt1 * paramFloat);
    }
    for (paramInt2 = kotlin.h.a.eH(paramInt2 * paramFloat);; paramInt2 = kotlin.h.a.eH(paramInt2 * (1.0F - paramFloat)))
    {
      paramInt2 += paramInt3;
      localObject = paramFinderLiveCameraOptBeautyPowerfulSuitView.findViewById(p.e.BIA).getLayoutParams();
      if (localObject != null) {
        break;
      }
      paramFinderLiveCameraOptBeautyPowerfulSuitView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(358302);
      throw paramFinderLiveCameraOptBeautyPowerfulSuitView;
      paramInt1 = kotlin.h.a.eH(paramInt1 * (1.0F - paramFloat));
    }
    Object localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt2;
    paramFinderLiveCameraOptBeautyPowerfulSuitView.findViewById(p.e.BIA).setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = paramFinderLiveCameraOptBeautyPowerfulSuitView.findViewById(p.e.BIB).getLayoutParams();
    if (localObject == null)
    {
      paramFinderLiveCameraOptBeautyPowerfulSuitView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(358302);
      throw paramFinderLiveCameraOptBeautyPowerfulSuitView;
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;
    paramFinderLiveCameraOptBeautyPowerfulSuitView.findViewById(p.e.BIB).setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = paramFinderLiveCameraOptBeautyPowerfulSuitView.findViewById(p.e.BIC).getLayoutParams();
    if (localObject == null)
    {
      paramFinderLiveCameraOptBeautyPowerfulSuitView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(358302);
      throw paramFinderLiveCameraOptBeautyPowerfulSuitView;
    }
    localObject = (RelativeLayout.LayoutParams)localObject;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt2;
    paramFinderLiveCameraOptBeautyPowerfulSuitView.findViewById(p.e.BIC).setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(358302);
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, int paramInt1, int paramInt2, int paramInt3, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(358309);
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramFinderLiveCameraOptBeautyPowerfulSuitView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(358309);
      throw paramFinderLiveCameraOptBeautyPowerfulSuitView;
    }
    a(paramFinderLiveCameraOptBeautyPowerfulSuitView, paramInt1, paramInt2, paramInt3, ((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(358309);
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(358323);
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramFinderLiveCameraOptBeautyPowerfulSuitView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(358323);
      throw paramFinderLiveCameraOptBeautyPowerfulSuitView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    if (paramFinderLiveCameraOptBeautyPowerfulSuitView.DLT) {}
    for (;;)
    {
      a(paramFinderLiveCameraOptBeautyPowerfulSuitView, f);
      AppMethodBeat.o(358323);
      return;
      f = 1.0F - f;
    }
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, View paramView)
  {
    AppMethodBeat.i(358360);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitView, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulSuitView.evg();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358360);
  }
  
  private static final void b(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, float paramFloat)
  {
    AppMethodBeat.i(358339);
    paramFinderLiveCameraOptBeautyPowerfulSuitView.findViewById(p.e.BID).setAlpha(paramFloat);
    paramFinderLiveCameraOptBeautyPowerfulSuitView.findViewById(p.e.BIi).setAlpha(1.0F - paramFloat);
    paramFinderLiveCameraOptBeautyPowerfulSuitView.findViewById(p.e.BIk).setAlpha(1.0F - paramFloat);
    paramFinderLiveCameraOptBeautyPowerfulSuitView.findViewById(p.e.BIm).setAlpha(1.0F - paramFloat);
    AppMethodBeat.o(358339);
  }
  
  private static final void b(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(358350);
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramFinderLiveCameraOptBeautyPowerfulSuitView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(358350);
      throw paramFinderLiveCameraOptBeautyPowerfulSuitView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    if (paramFinderLiveCameraOptBeautyPowerfulSuitView.DLT) {}
    for (;;)
    {
      b(paramFinderLiveCameraOptBeautyPowerfulSuitView, f);
      AppMethodBeat.o(358350);
      return;
      f = 1.0F - f;
    }
  }
  
  private static final void b(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, View paramView)
  {
    AppMethodBeat.i(358369);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitView, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulSuitView.evg();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358369);
  }
  
  private static final void c(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, View paramView)
  {
    AppMethodBeat.i(358377);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitView, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulSuitView.evg();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358377);
  }
  
  private static final void d(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, View paramView)
  {
    AppMethodBeat.i(358387);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitView, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulSuitView.Pw(0);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358387);
  }
  
  private static final void e(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, View paramView)
  {
    AppMethodBeat.i(358394);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitView, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulSuitView.Pw(1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358394);
  }
  
  private final void evf()
  {
    int m = 1;
    AppMethodBeat.i(358268);
    Object localObject = getContext().getResources();
    int i;
    int j;
    label56:
    int k;
    if (this.DLT)
    {
      i = p.b.hot_tab_BW_100_Alpha_0_8;
      i = ((Resources)localObject).getColor(i);
      localObject = getContext().getResources();
      if (!this.DLT) {
        break label316;
      }
      j = p.b.ByS;
      j = ((Resources)localObject).getColor(j);
      localObject = (TextView)findViewById(p.e.BIA);
      if (this.DLS != 0) {
        break label323;
      }
      k = j;
      label84:
      ((TextView)localObject).setTextColor(k);
      localObject = (TextView)findViewById(p.e.BIB);
      if (this.DLS != 1) {
        break label328;
      }
      k = j;
      label112:
      ((TextView)localObject).setTextColor(k);
      localObject = (TextView)findViewById(p.e.BIC);
      if (this.DLS != 2) {
        break label333;
      }
      label138:
      ((TextView)localObject).setTextColor(j);
      if (this.DLT) {
        break label353;
      }
      localObject = (TextView)findViewById(p.e.BIA);
      Typeface localTypeface;
      if (localObject != null)
      {
        localTypeface = ((TextView)localObject).getTypeface();
        if (getSuit() != 0) {
          break label338;
        }
        i = 1;
        label184:
        ((TextView)localObject).setTypeface(localTypeface, i);
      }
      localObject = (TextView)findViewById(p.e.BIB);
      if (localObject != null)
      {
        localTypeface = ((TextView)localObject).getTypeface();
        if (getSuit() != 1) {
          break label343;
        }
        i = 1;
        label226:
        ((TextView)localObject).setTypeface(localTypeface, i);
      }
      localObject = (TextView)findViewById(p.e.BIC);
      if (localObject != null)
      {
        localTypeface = ((TextView)localObject).getTypeface();
        if (getSuit() != 2) {
          break label348;
        }
        i = m;
        label269:
        ((TextView)localObject).setTypeface(localTypeface, i);
      }
    }
    for (;;)
    {
      localObject = findViewById(p.e.BIA);
      s.s(localObject, "findViewById<TextView>(R…beauty_powerful_number_1)");
      i.setTextBold((TextView)localObject);
      AppMethodBeat.o(358268);
      return;
      i = p.b.hot_tab_BW_100_Alpha_0_3;
      break;
      label316:
      j = p.b.Bzh;
      break label56;
      label323:
      k = i;
      break label84;
      label328:
      k = i;
      break label112;
      label333:
      j = i;
      break label138;
      label338:
      i = 0;
      break label184;
      label343:
      i = 0;
      break label226;
      label348:
      i = 0;
      break label269;
      label353:
      localObject = findViewById(p.e.BIA);
      s.s(localObject, "findViewById<TextView>(R…beauty_powerful_number_1)");
      i.w((TextView)localObject);
      localObject = findViewById(p.e.BIB);
      s.s(localObject, "findViewById<TextView>(R…beauty_powerful_number_2)");
      i.w((TextView)localObject);
      localObject = findViewById(p.e.BIC);
      s.s(localObject, "findViewById<TextView>(R…beauty_powerful_number_3)");
      i.w((TextView)localObject);
    }
  }
  
  private final void evg()
  {
    AppMethodBeat.i(358276);
    if (!this.DLT) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Finder.FinderLiveCameraOptBeautyPowerfulSuitView", s.X("#switchModeByUser mode=", Boolean.valueOf(bool)));
      setSuitMode(bool);
      kotlin.g.a.b localb = this.DLQ;
      if (localb != null) {
        localb.invoke(Boolean.valueOf(this.DLT));
      }
      AppMethodBeat.o(358276);
      return;
    }
  }
  
  private static final void f(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, View paramView)
  {
    AppMethodBeat.i(358401);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitView, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulSuitView.Pw(2);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358401);
  }
  
  private static final void g(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, View paramView)
  {
    AppMethodBeat.i(358409);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitView, "this$0");
    if (!paramFinderLiveCameraOptBeautyPowerfulSuitView.getSuitMode()) {
      paramFinderLiveCameraOptBeautyPowerfulSuitView.Pw(0);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358409);
  }
  
  private static final void h(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, View paramView)
  {
    AppMethodBeat.i(358417);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitView, "this$0");
    if (!paramFinderLiveCameraOptBeautyPowerfulSuitView.getSuitMode()) {
      paramFinderLiveCameraOptBeautyPowerfulSuitView.Pw(1);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358417);
  }
  
  private static final void i(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, View paramView)
  {
    AppMethodBeat.i(358425);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulSuitView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulSuitView, "this$0");
    if (!paramFinderLiveCameraOptBeautyPowerfulSuitView.getSuitMode()) {
      paramFinderLiveCameraOptBeautyPowerfulSuitView.Pw(2);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358425);
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
    AppMethodBeat.i(358645);
    super.onDetachedFromWindow();
    Animator localAnimator = this.bCA;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    AppMethodBeat.o(358645);
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
    AppMethodBeat.i(358617);
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
          break label116;
        }
      }
    }
    label116:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label121;
      }
      AppMethodBeat.o(358617);
      return;
      localObject1 = Boolean.valueOf(((Animator)localObject1).isRunning());
      break;
    }
    label121:
    this.DLS = paramInt;
    paramInt = p.d.BBj;
    i = p.d.BBk;
    findViewById(p.e.BIz).setVisibility(4);
    findViewById(p.e.BIj).setVisibility(4);
    findViewById(p.e.BIl).setVisibility(4);
    findViewById(p.e.BIn).setVisibility(4);
    findViewById(p.e.BIw).setBackgroundResource(paramInt);
    findViewById(p.e.BIx).setBackgroundResource(paramInt);
    findViewById(p.e.BIy).setBackgroundResource(paramInt);
    findViewById(p.e.BIo).setVisibility(4);
    findViewById(p.e.BIq).setVisibility(4);
    findViewById(p.e.BIs).setVisibility(4);
    View localView;
    switch (this.DLS)
    {
    default: 
      localObject1 = null;
      localObject2 = null;
      localView = null;
      if (this.DLS == -1) {
        findViewById(p.e.BIz).setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      evf();
      AppMethodBeat.o(358617);
      return;
      localView = findViewById(p.e.BIj);
      localObject2 = findViewById(p.e.BIw);
      localObject1 = findViewById(p.e.BIo);
      break;
      localView = findViewById(p.e.BIl);
      localObject2 = findViewById(p.e.BIx);
      localObject1 = findViewById(p.e.BIq);
      break;
      localView = findViewById(p.e.BIn);
      localObject2 = findViewById(p.e.BIy);
      localObject1 = findViewById(p.e.BIs);
      break;
      if (localView != null) {
        localView.setVisibility(0);
      }
      if (localObject2 != null) {
        ((View)localObject2).setBackgroundResource(i);
      }
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    }
  }
  
  public final void setSuitMode(boolean paramBoolean)
  {
    AppMethodBeat.i(358639);
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
          break label127;
        }
      }
    }
    label127:
    for (final int i = 1;; i = 0)
    {
      if (i == 0) {
        break label133;
      }
      AppMethodBeat.o(358639);
      return;
      localObject1 = Boolean.valueOf(((Animator)localObject1).isRunning());
      break;
    }
    label133:
    this.DLT = paramBoolean;
    localObject1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 11);
    final int j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 95);
    final int k = com.tencent.mm.cd.a.fromDPToPix(getContext(), 67);
    ((ValueAnimator)localObject1).addUpdateListener(new FinderLiveCameraOptBeautyPowerfulSuitView..ExternalSyntheticLambda3(this, j, k, i));
    ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new c(this, j, k, i));
    ((ValueAnimator)localObject1).setDuration(200L);
    localObject2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject2).addUpdateListener(new FinderLiveCameraOptBeautyPowerfulSuitView..ExternalSyntheticLambda1(this));
    ((ValueAnimator)localObject2).addListener((Animator.AnimatorListener)new e(this));
    ((ValueAnimator)localObject2).setDuration(200L);
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    Object localObject3 = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    localObject3 = getContext();
    s.s(localObject3, "context");
    float f1 = com.tencent.mm.plugin.finder.accessibility.a.g((Context)localObject3, 17.0F);
    localObject3 = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    localObject3 = getContext();
    s.s(localObject3, "context");
    float f2 = com.tencent.mm.plugin.finder.accessibility.a.g((Context)localObject3, 24.0F);
    localObject3 = getContext();
    float f3;
    if (getSuitMode())
    {
      f3 = f1;
      i = com.tencent.mm.cd.a.fromDPToPix((Context)localObject3, f3);
      localObject3 = getContext();
      if (!getSuitMode()) {
        break label587;
      }
    }
    for (;;)
    {
      j = com.tencent.mm.cd.a.fromDPToPix((Context)localObject3, f2);
      localValueAnimator1.addUpdateListener(new FinderLiveCameraOptBeautyPowerfulSuitView..ExternalSyntheticLambda0(i, j, this));
      localValueAnimator1.addListener((Animator.AnimatorListener)new d(i, j, this));
      localValueAnimator1.setDuration(200L);
      ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator2.addUpdateListener(new FinderLiveCameraOptBeautyPowerfulSuitView..ExternalSyntheticLambda2(this));
      localValueAnimator2.addListener((Animator.AnimatorListener)new b(this));
      localValueAnimator2.setDuration(200L);
      localObject3 = new AnimatorSet();
      ((AnimatorSet)localObject3).play((Animator)localObject1).with((Animator)localObject2).with((Animator)localValueAnimator1).with((Animator)localValueAnimator2);
      ((AnimatorSet)localObject3).start();
      localObject1 = ah.aiuX;
      this.bCA = ((Animator)localObject3);
      evf();
      AppMethodBeat.o(358639);
      return;
      f3 = f2;
      break;
      label587:
      f2 = f1;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepFour$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(358164);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = this.DLU;
      if (FinderLiveCameraOptBeautyPowerfulSuitView.a(this.DLU)) {}
      for (float f = 1.0F;; f = 0.0F)
      {
        FinderLiveCameraOptBeautyPowerfulSuitView.d(paramAnimator, f);
        AppMethodBeat.o(358164);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepOne$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(358161);
      super.onAnimationEnd(paramAnimator);
      FinderLiveCameraOptBeautyPowerfulSuitView.a(this.DLU, j, k, i);
      AppMethodBeat.o(358161);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepThree$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends AnimatorListenerAdapter
  {
    d(int paramInt1, int paramInt2, FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(358165);
      super.onAnimationEnd(paramAnimator);
      FinderLiveCameraOptBeautyPowerfulSuitView.a(jdField_this, this.DLY, j);
      AppMethodBeat.o(358165);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulSuitView$suitMode$animatorStepTwo$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends AnimatorListenerAdapter
  {
    e(FinderLiveCameraOptBeautyPowerfulSuitView paramFinderLiveCameraOptBeautyPowerfulSuitView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(358162);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = this.DLU;
      float f;
      if (FinderLiveCameraOptBeautyPowerfulSuitView.a(this.DLU))
      {
        f = 1.0F;
        FinderLiveCameraOptBeautyPowerfulSuitView.c(paramAnimator, f);
        paramAnimator = this.DLU.findViewById(p.e.BIu);
        if (!FinderLiveCameraOptBeautyPowerfulSuitView.a(this.DLU)) {
          break label71;
        }
      }
      label71:
      for (int i = 0;; i = 8)
      {
        paramAnimator.setVisibility(i);
        AppMethodBeat.o(358162);
        return;
        f = 0.0F;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveCameraOptBeautyPowerfulSuitView
 * JD-Core Version:    0.7.0.1
 */