package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCircleProgressView;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "angle", "", "animDuration", "", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator$delegate", "Lkotlin/Lazy;", "<set-?>", "", "circleColor", "getCircleColor", "()I", "setCircleColor", "(I)V", "circleColor$delegate", "Lkotlin/properties/ReadWriteProperty;", "circlePaint", "Landroid/graphics/Paint;", "getCirclePaint", "()Landroid/graphics/Paint;", "circlePaint$delegate", "circleStrokeWidth", "getCircleStrokeWidth", "()F", "setCircleStrokeWidth", "(F)V", "circleStrokeWidth$delegate", "currentPlayTime", "dotColor", "getDotColor", "setDotColor", "dotColor$delegate", "dotPaint", "getDotPaint", "dotPaint$delegate", "dotWidth", "getDotWidth", "setDotWidth", "dotWidth$delegate", "pointX", "pointY", "processToDraw", "value", "progress", "getProgress", "setProgress", "progressColor", "getProgressColor", "setProgressColor", "progressColor$delegate", "progressPaint", "getProgressPaint", "progressPaint$delegate", "progressWidth", "getProgressWidth", "setProgressWidth", "progressWidth$delegate", "radius", "getRadius", "step", "transitionTimingMs", "getTransitionTimingMs", "setTransitionTimingMs", "onDetachedFromWindow", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "promote", "startAnim", "stopAnim", "Companion", "luggage-wechat-full-sdk_release"})
public final class AppBrandCircleProgressView
  extends View
{
  public static final AppBrandCircleProgressView.g mFS;
  private float angle;
  private int kyd;
  private int mFC;
  private long mFD;
  private final c mFE;
  private final c mFF;
  private final c mFG;
  private final c mFH;
  private final c mFI;
  private final c mFJ;
  private final f mFK;
  private final f mFL;
  private final f mFM;
  private final f mFN;
  private long mFO;
  private float mFP;
  private float mFQ;
  private float mFR;
  private int progress;
  
  static
  {
    AppMethodBeat.i(221031);
    cxA = new k[] { (k)z.a(new u(z.bp(AppBrandCircleProgressView.class), "circleColor", "getCircleColor()I")), (k)z.a(new u(z.bp(AppBrandCircleProgressView.class), "dotColor", "getDotColor()I")), (k)z.a(new u(z.bp(AppBrandCircleProgressView.class), "progressColor", "getProgressColor()I")), (k)z.a(new u(z.bp(AppBrandCircleProgressView.class), "circleStrokeWidth", "getCircleStrokeWidth()F")), (k)z.a(new u(z.bp(AppBrandCircleProgressView.class), "dotWidth", "getDotWidth()F")), (k)z.a(new u(z.bp(AppBrandCircleProgressView.class), "progressWidth", "getProgressWidth()F")) };
    mFS = new AppBrandCircleProgressView.g((byte)0);
    AppMethodBeat.o(221031);
  }
  
  public AppBrandCircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(221054);
    this.mFC = 2000;
    this.mFD = 1500L;
    paramContext = d.i.a.Njd;
    paramContext = Integer.valueOf(-7829368);
    this.mFE = ((c)new a(paramContext, paramContext, this));
    paramContext = d.i.a.Njd;
    paramContext = Integer.valueOf(-7829368);
    this.mFF = ((c)new b(paramContext, paramContext, this));
    paramContext = d.i.a.Njd;
    paramContext = Integer.valueOf(-16711936);
    this.mFG = ((c)new c(paramContext, paramContext, this));
    paramContext = d.i.a.Njd;
    paramContext = Float.valueOf(1.0F);
    this.mFH = ((c)new d(paramContext, paramContext, this));
    paramContext = d.i.a.Njd;
    paramContext = Float.valueOf(1.0F);
    this.mFI = ((c)new e(paramContext, paramContext, this));
    paramContext = d.i.a.Njd;
    paramContext = Float.valueOf(3.0F);
    this.mFJ = ((c)new f(paramContext, paramContext, this));
    this.mFK = g.O((d.g.a.a)new h(this));
    this.mFL = g.O((d.g.a.a)new i(this));
    this.mFM = g.O((d.g.a.a)new j(this));
    this.mFN = g.O((d.g.a.a)new k(this));
    this.kyd = 1;
    this.mFR = this.progress;
    AppMethodBeat.o(221054);
  }
  
  private final ValueAnimator getAnimator()
  {
    AppMethodBeat.i(221045);
    ValueAnimator localValueAnimator = (ValueAnimator)this.mFK.getValue();
    AppMethodBeat.o(221045);
    return localValueAnimator;
  }
  
  private final Paint getCirclePaint()
  {
    AppMethodBeat.i(221046);
    Paint localPaint = (Paint)this.mFL.getValue();
    AppMethodBeat.o(221046);
    return localPaint;
  }
  
  private final Paint getDotPaint()
  {
    AppMethodBeat.i(221047);
    Paint localPaint = (Paint)this.mFM.getValue();
    AppMethodBeat.o(221047);
    return localPaint;
  }
  
  private final Paint getProgressPaint()
  {
    AppMethodBeat.i(221048);
    Paint localPaint = (Paint)this.mFN.getValue();
    AppMethodBeat.o(221048);
    return localPaint;
  }
  
  private final float getRadius()
  {
    AppMethodBeat.i(221049);
    float f = 0.0F;
    if (isLaidOut()) {
      f = Math.min(getMeasuredHeight() - Math.max(getProgressWidth(), getDotWidth()) * 2.0F, getMeasuredWidth() - Math.max(getProgressWidth(), getDotWidth()) * 2.0F) / 2.0F;
    }
    AppMethodBeat.o(221049);
    return f;
  }
  
  public final void bzX()
  {
    AppMethodBeat.i(221050);
    this.mFO = 0L;
    getAnimator().addUpdateListener((ValueAnimator.AnimatorUpdateListener)new l(this));
    getAnimator().start();
    AppMethodBeat.o(221050);
  }
  
  public final void bzY()
  {
    AppMethodBeat.i(221051);
    this.mFC = 0;
    getAnimator().setDuration(1000L);
    this.kyd = 5;
    AppMethodBeat.o(221051);
  }
  
  public final long getAnimDuration()
  {
    return this.mFD;
  }
  
  public final int getCircleColor()
  {
    AppMethodBeat.i(221033);
    int i = ((Number)this.mFE.a(cxA[0])).intValue();
    AppMethodBeat.o(221033);
    return i;
  }
  
  public final float getCircleStrokeWidth()
  {
    AppMethodBeat.i(221039);
    float f = ((Number)this.mFH.a(cxA[3])).floatValue();
    AppMethodBeat.o(221039);
    return f;
  }
  
  public final int getDotColor()
  {
    AppMethodBeat.i(221035);
    int i = ((Number)this.mFF.a(cxA[1])).intValue();
    AppMethodBeat.o(221035);
    return i;
  }
  
  public final float getDotWidth()
  {
    AppMethodBeat.i(221041);
    float f = ((Number)this.mFI.a(cxA[4])).floatValue();
    AppMethodBeat.o(221041);
    return f;
  }
  
  public final int getProgress()
  {
    return this.progress;
  }
  
  public final int getProgressColor()
  {
    AppMethodBeat.i(221037);
    int i = ((Number)this.mFG.a(cxA[2])).intValue();
    AppMethodBeat.o(221037);
    return i;
  }
  
  public final float getProgressWidth()
  {
    AppMethodBeat.i(221043);
    float f = ((Number)this.mFJ.a(cxA[5])).floatValue();
    AppMethodBeat.o(221043);
    return f;
  }
  
  public final int getTransitionTimingMs()
  {
    return this.mFC;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(221053);
    super.onDetachedFromWindow();
    getAnimator().cancel();
    AppMethodBeat.o(221053);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(221052);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if ((this.mFP == 0.0F) || (this.mFQ == 0.0F))
    {
      AppMethodBeat.o(221052);
      return;
    }
    float f8 = getMeasuredWidth();
    float f1 = getMeasuredHeight();
    paramCanvas.drawCircle(f8 / 2.0F, f1 / 2.0F, getRadius(), getCirclePaint());
    if (this.mFO <= this.mFC)
    {
      paramCanvas.drawCircle(this.mFP + getRadius() + Math.max(getProgressWidth(), getDotWidth()), this.mFQ + getRadius() + Math.max(getProgressWidth(), getDotWidth()), getDotWidth(), getDotPaint());
      AppMethodBeat.o(221052);
      return;
    }
    if (this.mFR < this.progress) {
      this.mFR += this.kyd;
    }
    for (;;)
    {
      float f2 = this.mFR * 360.0F / 100.0F;
      float f3 = f8 / 2.0F;
      float f4 = getRadius();
      float f5 = f1 / 2.0F;
      float f6 = getRadius();
      float f7 = getRadius();
      f8 /= 2.0F;
      float f9 = getRadius();
      paramCanvas.drawArc(f3 - f4, f5 - f6, f7 + f8, f1 / 2.0F + f9, this.angle, f2, false, getProgressPaint());
      if (this.mFR >= 100.0F) {
        getAnimator().cancel();
      }
      AppMethodBeat.o(221052);
      return;
      if (this.mFR <= 80.0F) {
        this.mFR += 0.5F;
      }
    }
  }
  
  public final void setAnimDuration(long paramLong)
  {
    this.mFD = paramLong;
  }
  
  public final void setCircleColor(int paramInt)
  {
    AppMethodBeat.i(221034);
    this.mFE.a(cxA[0], Integer.valueOf(paramInt));
    AppMethodBeat.o(221034);
  }
  
  public final void setCircleStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(221040);
    this.mFH.a(cxA[3], Float.valueOf(paramFloat));
    AppMethodBeat.o(221040);
  }
  
  public final void setDotColor(int paramInt)
  {
    AppMethodBeat.i(221036);
    this.mFF.a(cxA[1], Integer.valueOf(paramInt));
    AppMethodBeat.o(221036);
  }
  
  public final void setDotWidth(float paramFloat)
  {
    AppMethodBeat.i(221042);
    this.mFI.a(cxA[4], Float.valueOf(paramFloat));
    AppMethodBeat.o(221042);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(221032);
    ae.i("AppBrandCircleProgressView", "progress = [%d]".concat(String.valueOf(paramInt)));
    this.progress = paramInt;
    AppMethodBeat.o(221032);
  }
  
  public final void setProgressColor(int paramInt)
  {
    AppMethodBeat.i(221038);
    this.mFG.a(cxA[2], Integer.valueOf(paramInt));
    AppMethodBeat.o(221038);
  }
  
  public final void setProgressWidth(float paramFloat)
  {
    AppMethodBeat.i(221044);
    this.mFJ.a(cxA[5], Float.valueOf(paramFloat));
    AppMethodBeat.o(221044);
  }
  
  public final void setTransitionTimingMs(int paramInt)
  {
    this.mFC = paramInt;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class a
    extends b<Integer>
  {
    public a(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(221020);
      p.h(paramk, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.b(jdField_this).setColor(i);
      AppMethodBeat.o(221020);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class b
    extends b<Integer>
  {
    public b(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(221021);
      p.h(paramk, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.c(jdField_this).setColor(i);
      AppMethodBeat.o(221021);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class c
    extends b<Integer>
  {
    public c(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(221022);
      p.h(paramk, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.d(jdField_this).setColor(i);
      AppMethodBeat.o(221022);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class d
    extends b<Float>
  {
    public d(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(221023);
      p.h(paramk, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.b(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(221023);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class e
    extends b<Float>
  {
    public e(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(221024);
      p.h(paramk, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.b(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(221024);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class f
    extends b<Float>
  {
    public f(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(k<?> paramk, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(221025);
      p.h(paramk, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.d(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(221025);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<ValueAnimator>
  {
    h(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<Paint>
  {
    i(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<Paint>
  {
    j(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<Paint>
  {
    k(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class l
    implements ValueAnimator.AnimatorUpdateListener
  {
    l(AppBrandCircleProgressView paramAppBrandCircleProgressView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(221030);
      AppBrandCircleProgressView localAppBrandCircleProgressView = this.mFT;
      p.g(paramValueAnimator, "animation");
      AppBrandCircleProgressView.a(localAppBrandCircleProgressView, paramValueAnimator.getCurrentPlayTime());
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(221030);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      AppBrandCircleProgressView.a(this.mFT, AppBrandCircleProgressView.a(this.mFT) * (float)Math.cos(f));
      AppBrandCircleProgressView.b(this.mFT, AppBrandCircleProgressView.a(this.mFT) * (float)Math.sin(f));
      AppBrandCircleProgressView.c(this.mFT, (float)(f * 360.0F / 6.283185307179586D));
      this.mFT.invalidate();
      AppMethodBeat.o(221030);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView
 * JD-Core Version:    0.7.0.1
 */