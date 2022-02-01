package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.i.b;
import kotlin.i.c;
import kotlin.l;
import kotlin.l.k;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCircleProgressView;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "angle", "", "animDuration", "", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator$delegate", "Lkotlin/Lazy;", "<set-?>", "", "circleColor", "getCircleColor", "()I", "setCircleColor", "(I)V", "circleColor$delegate", "Lkotlin/properties/ReadWriteProperty;", "circlePaint", "Landroid/graphics/Paint;", "getCirclePaint", "()Landroid/graphics/Paint;", "circlePaint$delegate", "circleStrokeWidth", "getCircleStrokeWidth", "()F", "setCircleStrokeWidth", "(F)V", "circleStrokeWidth$delegate", "currentPlayTime", "dotColor", "getDotColor", "setDotColor", "dotColor$delegate", "dotPaint", "getDotPaint", "dotPaint$delegate", "dotWidth", "getDotWidth", "setDotWidth", "dotWidth$delegate", "pointX", "pointY", "processToDraw", "value", "progress", "getProgress", "setProgress", "progressColor", "getProgressColor", "setProgressColor", "progressColor$delegate", "progressPaint", "getProgressPaint", "progressPaint$delegate", "progressWidth", "getProgressWidth", "setProgressWidth", "progressWidth$delegate", "radius", "getRadius", "step", "transitionTimingMs", "getTransitionTimingMs", "setTransitionTimingMs", "onDetachedFromWindow", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "promote", "startAnim", "stopAnim", "Companion", "luggage-wechat-full-sdk_release"})
public final class AppBrandCircleProgressView
  extends View
{
  public static final AppBrandCircleProgressView.g nSL;
  private float angle;
  private int lCq;
  private final c nSA;
  private final c nSB;
  private final c nSC;
  private final f nSD;
  private final f nSE;
  private final f nSF;
  private final f nSG;
  private long nSH;
  private float nSI;
  private float nSJ;
  private float nSK;
  private int nSv;
  private long nSw;
  private final c nSx;
  private final c nSy;
  private final c nSz;
  private int progress;
  
  static
  {
    AppMethodBeat.i(230202);
    cLI = new k[] { (k)aa.a(new v(aa.bp(AppBrandCircleProgressView.class), "circleColor", "getCircleColor()I")), (k)aa.a(new v(aa.bp(AppBrandCircleProgressView.class), "dotColor", "getDotColor()I")), (k)aa.a(new v(aa.bp(AppBrandCircleProgressView.class), "progressColor", "getProgressColor()I")), (k)aa.a(new v(aa.bp(AppBrandCircleProgressView.class), "circleStrokeWidth", "getCircleStrokeWidth()F")), (k)aa.a(new v(aa.bp(AppBrandCircleProgressView.class), "dotWidth", "getDotWidth()F")), (k)aa.a(new v(aa.bp(AppBrandCircleProgressView.class), "progressWidth", "getProgressWidth()F")) };
    nSL = new AppBrandCircleProgressView.g((byte)0);
    AppMethodBeat.o(230202);
  }
  
  public AppBrandCircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(230225);
    this.nSv = 2000;
    this.nSw = 1500L;
    paramContext = kotlin.i.a.SYL;
    paramContext = Integer.valueOf(-7829368);
    this.nSx = ((c)new a(paramContext, paramContext, this));
    paramContext = kotlin.i.a.SYL;
    paramContext = Integer.valueOf(-7829368);
    this.nSy = ((c)new b(paramContext, paramContext, this));
    paramContext = kotlin.i.a.SYL;
    paramContext = Integer.valueOf(-16711936);
    this.nSz = ((c)new c(paramContext, paramContext, this));
    paramContext = kotlin.i.a.SYL;
    paramContext = Float.valueOf(1.0F);
    this.nSA = ((c)new d(paramContext, paramContext, this));
    paramContext = kotlin.i.a.SYL;
    paramContext = Float.valueOf(1.0F);
    this.nSB = ((c)new e(paramContext, paramContext, this));
    paramContext = kotlin.i.a.SYL;
    paramContext = Float.valueOf(3.0F);
    this.nSC = ((c)new f(paramContext, paramContext, this));
    this.nSD = g.ah((kotlin.g.a.a)new h(this));
    this.nSE = g.ah((kotlin.g.a.a)new i(this));
    this.nSF = g.ah((kotlin.g.a.a)new j(this));
    this.nSG = g.ah((kotlin.g.a.a)new k(this));
    this.lCq = 1;
    this.nSK = this.progress;
    AppMethodBeat.o(230225);
  }
  
  private final ValueAnimator getAnimator()
  {
    AppMethodBeat.i(230216);
    ValueAnimator localValueAnimator = (ValueAnimator)this.nSD.getValue();
    AppMethodBeat.o(230216);
    return localValueAnimator;
  }
  
  private final Paint getCirclePaint()
  {
    AppMethodBeat.i(230217);
    Paint localPaint = (Paint)this.nSE.getValue();
    AppMethodBeat.o(230217);
    return localPaint;
  }
  
  private final Paint getDotPaint()
  {
    AppMethodBeat.i(230218);
    Paint localPaint = (Paint)this.nSF.getValue();
    AppMethodBeat.o(230218);
    return localPaint;
  }
  
  private final Paint getProgressPaint()
  {
    AppMethodBeat.i(230219);
    Paint localPaint = (Paint)this.nSG.getValue();
    AppMethodBeat.o(230219);
    return localPaint;
  }
  
  private final float getRadius()
  {
    AppMethodBeat.i(230220);
    float f = 0.0F;
    if (isLaidOut()) {
      f = Math.min(getMeasuredHeight() - Math.max(getProgressWidth(), getDotWidth()) * 2.0F, getMeasuredWidth() - Math.max(getProgressWidth(), getDotWidth()) * 2.0F) / 2.0F;
    }
    AppMethodBeat.o(230220);
    return f;
  }
  
  public final void bWT()
  {
    AppMethodBeat.i(230221);
    this.nSH = 0L;
    getAnimator().addUpdateListener((ValueAnimator.AnimatorUpdateListener)new l(this));
    getAnimator().start();
    AppMethodBeat.o(230221);
  }
  
  public final void bWU()
  {
    AppMethodBeat.i(230222);
    this.nSv = 0;
    getAnimator().setDuration(1000L);
    this.lCq = 5;
    AppMethodBeat.o(230222);
  }
  
  public final long getAnimDuration()
  {
    return this.nSw;
  }
  
  public final int getCircleColor()
  {
    AppMethodBeat.i(230204);
    int i = ((Number)this.nSx.a(cLI[0])).intValue();
    AppMethodBeat.o(230204);
    return i;
  }
  
  public final float getCircleStrokeWidth()
  {
    AppMethodBeat.i(230210);
    float f = ((Number)this.nSA.a(cLI[3])).floatValue();
    AppMethodBeat.o(230210);
    return f;
  }
  
  public final int getDotColor()
  {
    AppMethodBeat.i(230206);
    int i = ((Number)this.nSy.a(cLI[1])).intValue();
    AppMethodBeat.o(230206);
    return i;
  }
  
  public final float getDotWidth()
  {
    AppMethodBeat.i(230212);
    float f = ((Number)this.nSB.a(cLI[4])).floatValue();
    AppMethodBeat.o(230212);
    return f;
  }
  
  public final int getProgress()
  {
    return this.progress;
  }
  
  public final int getProgressColor()
  {
    AppMethodBeat.i(230208);
    int i = ((Number)this.nSz.a(cLI[2])).intValue();
    AppMethodBeat.o(230208);
    return i;
  }
  
  public final float getProgressWidth()
  {
    AppMethodBeat.i(230214);
    float f = ((Number)this.nSC.a(cLI[5])).floatValue();
    AppMethodBeat.o(230214);
    return f;
  }
  
  public final int getTransitionTimingMs()
  {
    return this.nSv;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(230224);
    super.onDetachedFromWindow();
    getAnimator().cancel();
    AppMethodBeat.o(230224);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(230223);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if ((this.nSI == 0.0F) || (this.nSJ == 0.0F))
    {
      AppMethodBeat.o(230223);
      return;
    }
    float f8 = getMeasuredWidth();
    float f1 = getMeasuredHeight();
    paramCanvas.drawCircle(f8 / 2.0F, f1 / 2.0F, getRadius(), getCirclePaint());
    if (this.nSH <= this.nSv)
    {
      paramCanvas.drawCircle(this.nSI + getRadius() + Math.max(getProgressWidth(), getDotWidth()), this.nSJ + getRadius() + Math.max(getProgressWidth(), getDotWidth()), getDotWidth(), getDotPaint());
      AppMethodBeat.o(230223);
      return;
    }
    if (this.nSK < this.progress) {
      this.nSK += this.lCq;
    }
    for (;;)
    {
      float f2 = this.nSK * 360.0F / 100.0F;
      float f3 = f8 / 2.0F;
      float f4 = getRadius();
      float f5 = f1 / 2.0F;
      float f6 = getRadius();
      float f7 = getRadius();
      f8 /= 2.0F;
      float f9 = getRadius();
      paramCanvas.drawArc(f3 - f4, f5 - f6, f7 + f8, f1 / 2.0F + f9, this.angle, f2, false, getProgressPaint());
      if (this.nSK >= 100.0F) {
        getAnimator().cancel();
      }
      AppMethodBeat.o(230223);
      return;
      if (this.nSK <= 80.0F) {
        this.nSK += 0.5F;
      }
    }
  }
  
  public final void setAnimDuration(long paramLong)
  {
    this.nSw = paramLong;
  }
  
  public final void setCircleColor(int paramInt)
  {
    AppMethodBeat.i(230205);
    this.nSx.a(cLI[0], Integer.valueOf(paramInt));
    AppMethodBeat.o(230205);
  }
  
  public final void setCircleStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(230211);
    this.nSA.a(cLI[3], Float.valueOf(paramFloat));
    AppMethodBeat.o(230211);
  }
  
  public final void setDotColor(int paramInt)
  {
    AppMethodBeat.i(230207);
    this.nSy.a(cLI[1], Integer.valueOf(paramInt));
    AppMethodBeat.o(230207);
  }
  
  public final void setDotWidth(float paramFloat)
  {
    AppMethodBeat.i(230213);
    this.nSB.a(cLI[4], Float.valueOf(paramFloat));
    AppMethodBeat.o(230213);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(230203);
    Log.d("AppBrandCircleProgressView", "hash = " + hashCode() + " progress = " + paramInt);
    this.progress = paramInt;
    AppMethodBeat.o(230203);
  }
  
  public final void setProgressColor(int paramInt)
  {
    AppMethodBeat.i(230209);
    this.nSz.a(cLI[2], Integer.valueOf(paramInt));
    AppMethodBeat.o(230209);
  }
  
  public final void setProgressWidth(float paramFloat)
  {
    AppMethodBeat.i(230215);
    this.nSC.a(cLI[5], Float.valueOf(paramFloat));
    AppMethodBeat.o(230215);
  }
  
  public final void setTransitionTimingMs(int paramInt)
  {
    this.nSv = paramInt;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class a
    extends b<Integer>
  {
    public a(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(230191);
      p.h(paramk, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.b(jdField_this).setColor(i);
      AppMethodBeat.o(230191);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class b
    extends b<Integer>
  {
    public b(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(230192);
      p.h(paramk, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.c(jdField_this).setColor(i);
      AppMethodBeat.o(230192);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class c
    extends b<Integer>
  {
    public c(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(230193);
      p.h(paramk, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.d(jdField_this).setColor(i);
      AppMethodBeat.o(230193);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class d
    extends b<Float>
  {
    public d(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(230194);
      p.h(paramk, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.b(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(230194);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class e
    extends b<Float>
  {
    public e(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(230195);
      p.h(paramk, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.b(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(230195);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class f
    extends b<Float>
  {
    public f(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(230196);
      p.h(paramk, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.d(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(230196);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<ValueAnimator>
  {
    h(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<Paint>
  {
    i(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<Paint>
  {
    j(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<Paint>
  {
    k(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class l
    implements ValueAnimator.AnimatorUpdateListener
  {
    l(AppBrandCircleProgressView paramAppBrandCircleProgressView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(230201);
      AppBrandCircleProgressView localAppBrandCircleProgressView = this.nSM;
      p.g(paramValueAnimator, "animation");
      AppBrandCircleProgressView.a(localAppBrandCircleProgressView, paramValueAnimator.getCurrentPlayTime());
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(230201);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      AppBrandCircleProgressView.a(this.nSM, AppBrandCircleProgressView.a(this.nSM) * (float)Math.cos(f));
      AppBrandCircleProgressView.b(this.nSM, AppBrandCircleProgressView.a(this.nSM) * (float)Math.sin(f));
      AppBrandCircleProgressView.c(this.nSM, (float)(f * 360.0F / 6.283185307179586D));
      this.nSM.invalidate();
      AppMethodBeat.o(230201);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView
 * JD-Core Version:    0.7.0.1
 */