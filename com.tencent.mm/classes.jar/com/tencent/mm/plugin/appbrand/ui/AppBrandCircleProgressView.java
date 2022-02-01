package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.g.b.u;
import d.g.b.z;
import d.i.b;
import d.i.c;
import d.l;
import d.l.k;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCircleProgressView;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "angle", "", "animDuration", "", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator$delegate", "Lkotlin/Lazy;", "<set-?>", "", "circleColor", "getCircleColor", "()I", "setCircleColor", "(I)V", "circleColor$delegate", "Lkotlin/properties/ReadWriteProperty;", "circlePaint", "Landroid/graphics/Paint;", "getCirclePaint", "()Landroid/graphics/Paint;", "circlePaint$delegate", "circleStrokeWidth", "getCircleStrokeWidth", "()F", "setCircleStrokeWidth", "(F)V", "circleStrokeWidth$delegate", "currentPlayTime", "dotColor", "getDotColor", "setDotColor", "dotColor$delegate", "dotPaint", "getDotPaint", "dotPaint$delegate", "dotWidth", "getDotWidth", "setDotWidth", "dotWidth$delegate", "pointX", "pointY", "processToDraw", "value", "progress", "getProgress", "setProgress", "progressColor", "getProgressColor", "setProgressColor", "progressColor$delegate", "progressPaint", "getProgressPaint", "progressPaint$delegate", "progressWidth", "getProgressWidth", "setProgressWidth", "progressWidth$delegate", "radius", "getRadius", "step", "transitionTimingMs", "getTransitionTimingMs", "setTransitionTimingMs", "onDetachedFromWindow", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "promote", "startAnim", "stopAnim", "Companion", "luggage-wechat-full-sdk_release"})
public final class AppBrandCircleProgressView
  extends View
{
  public static final AppBrandCircleProgressView.g mAP;
  private float angle;
  private int kuN;
  private long mAA;
  private final c mAB;
  private final c mAC;
  private final c mAD;
  private final c mAE;
  private final c mAF;
  private final c mAG;
  private final f mAH;
  private final f mAI;
  private final f mAJ;
  private final f mAK;
  private long mAL;
  private float mAM;
  private float mAN;
  private float mAO;
  private int mAz;
  private int progress;
  
  static
  {
    AppMethodBeat.i(192418);
    cwV = new k[] { (k)z.a(new u(z.bp(AppBrandCircleProgressView.class), "circleColor", "getCircleColor()I")), (k)z.a(new u(z.bp(AppBrandCircleProgressView.class), "dotColor", "getDotColor()I")), (k)z.a(new u(z.bp(AppBrandCircleProgressView.class), "progressColor", "getProgressColor()I")), (k)z.a(new u(z.bp(AppBrandCircleProgressView.class), "circleStrokeWidth", "getCircleStrokeWidth()F")), (k)z.a(new u(z.bp(AppBrandCircleProgressView.class), "dotWidth", "getDotWidth()F")), (k)z.a(new u(z.bp(AppBrandCircleProgressView.class), "progressWidth", "getProgressWidth()F")) };
    mAP = new AppBrandCircleProgressView.g((byte)0);
    AppMethodBeat.o(192418);
  }
  
  public AppBrandCircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192441);
    this.mAz = 2000;
    this.mAA = 1500L;
    paramContext = d.i.a.MMa;
    paramContext = Integer.valueOf(-7829368);
    this.mAB = ((c)new a(paramContext, paramContext, this));
    paramContext = d.i.a.MMa;
    paramContext = Integer.valueOf(-7829368);
    this.mAC = ((c)new b(paramContext, paramContext, this));
    paramContext = d.i.a.MMa;
    paramContext = Integer.valueOf(-16711936);
    this.mAD = ((c)new c(paramContext, paramContext, this));
    paramContext = d.i.a.MMa;
    paramContext = Float.valueOf(1.0F);
    this.mAE = ((c)new d(paramContext, paramContext, this));
    paramContext = d.i.a.MMa;
    paramContext = Float.valueOf(1.0F);
    this.mAF = ((c)new e(paramContext, paramContext, this));
    paramContext = d.i.a.MMa;
    paramContext = Float.valueOf(3.0F);
    this.mAG = ((c)new f(paramContext, paramContext, this));
    this.mAH = g.O((d.g.a.a)new h(this));
    this.mAI = g.O((d.g.a.a)new i(this));
    this.mAJ = g.O((d.g.a.a)new j(this));
    this.mAK = g.O((d.g.a.a)new k(this));
    this.kuN = 1;
    this.mAO = this.progress;
    AppMethodBeat.o(192441);
  }
  
  private final ValueAnimator getAnimator()
  {
    AppMethodBeat.i(192432);
    ValueAnimator localValueAnimator = (ValueAnimator)this.mAH.getValue();
    AppMethodBeat.o(192432);
    return localValueAnimator;
  }
  
  private final Paint getCirclePaint()
  {
    AppMethodBeat.i(192433);
    Paint localPaint = (Paint)this.mAI.getValue();
    AppMethodBeat.o(192433);
    return localPaint;
  }
  
  private final Paint getDotPaint()
  {
    AppMethodBeat.i(192434);
    Paint localPaint = (Paint)this.mAJ.getValue();
    AppMethodBeat.o(192434);
    return localPaint;
  }
  
  private final Paint getProgressPaint()
  {
    AppMethodBeat.i(192435);
    Paint localPaint = (Paint)this.mAK.getValue();
    AppMethodBeat.o(192435);
    return localPaint;
  }
  
  private final float getRadius()
  {
    AppMethodBeat.i(192436);
    float f = 0.0F;
    if (isLaidOut()) {
      f = Math.min(getMeasuredHeight() - Math.max(getProgressWidth(), getDotWidth()) * 2.0F, getMeasuredWidth() - Math.max(getProgressWidth(), getDotWidth()) * 2.0F) / 2.0F;
    }
    AppMethodBeat.o(192436);
    return f;
  }
  
  public final void bzc()
  {
    AppMethodBeat.i(192437);
    this.mAL = 0L;
    getAnimator().addUpdateListener((ValueAnimator.AnimatorUpdateListener)new l(this));
    getAnimator().start();
    AppMethodBeat.o(192437);
  }
  
  public final void bzd()
  {
    AppMethodBeat.i(192438);
    this.mAz = 0;
    getAnimator().setDuration(1000L);
    this.kuN = 5;
    AppMethodBeat.o(192438);
  }
  
  public final long getAnimDuration()
  {
    return this.mAA;
  }
  
  public final int getCircleColor()
  {
    AppMethodBeat.i(192420);
    int i = ((Number)this.mAB.a(cwV[0])).intValue();
    AppMethodBeat.o(192420);
    return i;
  }
  
  public final float getCircleStrokeWidth()
  {
    AppMethodBeat.i(192426);
    float f = ((Number)this.mAE.a(cwV[3])).floatValue();
    AppMethodBeat.o(192426);
    return f;
  }
  
  public final int getDotColor()
  {
    AppMethodBeat.i(192422);
    int i = ((Number)this.mAC.a(cwV[1])).intValue();
    AppMethodBeat.o(192422);
    return i;
  }
  
  public final float getDotWidth()
  {
    AppMethodBeat.i(192428);
    float f = ((Number)this.mAF.a(cwV[4])).floatValue();
    AppMethodBeat.o(192428);
    return f;
  }
  
  public final int getProgress()
  {
    return this.progress;
  }
  
  public final int getProgressColor()
  {
    AppMethodBeat.i(192424);
    int i = ((Number)this.mAD.a(cwV[2])).intValue();
    AppMethodBeat.o(192424);
    return i;
  }
  
  public final float getProgressWidth()
  {
    AppMethodBeat.i(192430);
    float f = ((Number)this.mAG.a(cwV[5])).floatValue();
    AppMethodBeat.o(192430);
    return f;
  }
  
  public final int getTransitionTimingMs()
  {
    return this.mAz;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(192440);
    super.onDetachedFromWindow();
    getAnimator().cancel();
    AppMethodBeat.o(192440);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192439);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if ((this.mAM == 0.0F) || (this.mAN == 0.0F))
    {
      AppMethodBeat.o(192439);
      return;
    }
    float f8 = getMeasuredWidth();
    float f1 = getMeasuredHeight();
    paramCanvas.drawCircle(f8 / 2.0F, f1 / 2.0F, getRadius(), getCirclePaint());
    if (this.mAL <= this.mAz)
    {
      paramCanvas.drawCircle(this.mAM + getRadius() + Math.max(getProgressWidth(), getDotWidth()), this.mAN + getRadius() + Math.max(getProgressWidth(), getDotWidth()), getDotWidth(), getDotPaint());
      AppMethodBeat.o(192439);
      return;
    }
    if (this.mAO < this.progress) {
      this.mAO += this.kuN;
    }
    for (;;)
    {
      float f2 = this.mAO * 360.0F / 100.0F;
      float f3 = f8 / 2.0F;
      float f4 = getRadius();
      float f5 = f1 / 2.0F;
      float f6 = getRadius();
      float f7 = getRadius();
      f8 /= 2.0F;
      float f9 = getRadius();
      paramCanvas.drawArc(f3 - f4, f5 - f6, f7 + f8, f1 / 2.0F + f9, this.angle, f2, false, getProgressPaint());
      if (this.mAO >= 100.0F) {
        getAnimator().cancel();
      }
      AppMethodBeat.o(192439);
      return;
      if (this.mAO <= 80.0F) {
        this.mAO += 0.5F;
      }
    }
  }
  
  public final void setAnimDuration(long paramLong)
  {
    this.mAA = paramLong;
  }
  
  public final void setCircleColor(int paramInt)
  {
    AppMethodBeat.i(192421);
    this.mAB.a(cwV[0], Integer.valueOf(paramInt));
    AppMethodBeat.o(192421);
  }
  
  public final void setCircleStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(192427);
    this.mAE.a(cwV[3], Float.valueOf(paramFloat));
    AppMethodBeat.o(192427);
  }
  
  public final void setDotColor(int paramInt)
  {
    AppMethodBeat.i(192423);
    this.mAC.a(cwV[1], Integer.valueOf(paramInt));
    AppMethodBeat.o(192423);
  }
  
  public final void setDotWidth(float paramFloat)
  {
    AppMethodBeat.i(192429);
    this.mAF.a(cwV[4], Float.valueOf(paramFloat));
    AppMethodBeat.o(192429);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(192419);
    ad.i("AppBrandCircleProgressView", "progress = [%d]".concat(String.valueOf(paramInt)));
    this.progress = paramInt;
    AppMethodBeat.o(192419);
  }
  
  public final void setProgressColor(int paramInt)
  {
    AppMethodBeat.i(192425);
    this.mAD.a(cwV[2], Integer.valueOf(paramInt));
    AppMethodBeat.o(192425);
  }
  
  public final void setProgressWidth(float paramFloat)
  {
    AppMethodBeat.i(192431);
    this.mAG.a(cwV[5], Float.valueOf(paramFloat));
    AppMethodBeat.o(192431);
  }
  
  public final void setTransitionTimingMs(int paramInt)
  {
    this.mAz = paramInt;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class a
    extends b<Integer>
  {
    public a(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(192407);
      p.h(paramk, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.b(jdField_this).setColor(i);
      AppMethodBeat.o(192407);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class b
    extends b<Integer>
  {
    public b(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(192408);
      p.h(paramk, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.c(jdField_this).setColor(i);
      AppMethodBeat.o(192408);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class c
    extends b<Integer>
  {
    public c(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(192409);
      p.h(paramk, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.d(jdField_this).setColor(i);
      AppMethodBeat.o(192409);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class d
    extends b<Float>
  {
    public d(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(192410);
      p.h(paramk, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.b(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(192410);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class e
    extends b<Float>
  {
    public e(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(192411);
      p.h(paramk, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.b(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(192411);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class f
    extends b<Float>
  {
    public f(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(192412);
      p.h(paramk, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.d(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(192412);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<ValueAnimator>
  {
    h(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<Paint>
  {
    i(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<Paint>
  {
    j(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<Paint>
  {
    k(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class l
    implements ValueAnimator.AnimatorUpdateListener
  {
    l(AppBrandCircleProgressView paramAppBrandCircleProgressView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(192417);
      AppBrandCircleProgressView localAppBrandCircleProgressView = this.mAQ;
      p.g(paramValueAnimator, "animation");
      AppBrandCircleProgressView.a(localAppBrandCircleProgressView, paramValueAnimator.getCurrentPlayTime());
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(192417);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      AppBrandCircleProgressView.a(this.mAQ, AppBrandCircleProgressView.a(this.mAQ) * (float)Math.cos(f));
      AppBrandCircleProgressView.b(this.mAQ, AppBrandCircleProgressView.a(this.mAQ) * (float)Math.sin(f));
      AppBrandCircleProgressView.c(this.mAQ, (float)(f * 360.0F / 6.283185307179586D));
      this.mAQ.invalidate();
      AppMethodBeat.o(192417);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView
 * JD-Core Version:    0.7.0.1
 */