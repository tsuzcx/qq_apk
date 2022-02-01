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
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.i.b;
import kotlin.i.c;
import kotlin.l;
import kotlin.l.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCircleProgressView;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "angle", "", "animDuration", "", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator$delegate", "Lkotlin/Lazy;", "<set-?>", "", "circleColor", "getCircleColor", "()I", "setCircleColor", "(I)V", "circleColor$delegate", "Lkotlin/properties/ReadWriteProperty;", "circlePaint", "Landroid/graphics/Paint;", "getCirclePaint", "()Landroid/graphics/Paint;", "circlePaint$delegate", "circleStrokeWidth", "getCircleStrokeWidth", "()F", "setCircleStrokeWidth", "(F)V", "circleStrokeWidth$delegate", "currentPlayTime", "dotColor", "getDotColor", "setDotColor", "dotColor$delegate", "dotPaint", "getDotPaint", "dotPaint$delegate", "dotWidth", "getDotWidth", "setDotWidth", "dotWidth$delegate", "pointX", "pointY", "processToDraw", "value", "progress", "getProgress", "setProgress", "progressColor", "getProgressColor", "setProgressColor", "progressColor$delegate", "progressPaint", "getProgressPaint", "progressPaint$delegate", "progressWidth", "getProgressWidth", "setProgressWidth", "progressWidth$delegate", "radius", "getRadius", "step", "transitionTimingMs", "getTransitionTimingMs", "setTransitionTimingMs", "onDetachedFromWindow", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "promote", "startAnim", "stopAnim", "Companion", "luggage-wechat-full-sdk_release"})
public final class AppBrandCircleProgressView
  extends View
{
  public static final AppBrandCircleProgressView.g qUn;
  private float angle;
  private long currentPlayTime;
  private int oxQ;
  private int progress;
  private int qTY;
  private long qTZ;
  private final c qUa;
  private final c qUb;
  private final c qUc;
  private final c qUd;
  private final c qUe;
  private final c qUf;
  private final f qUg;
  private final f qUh;
  private final f qUi;
  private final f qUj;
  private float qUk;
  private float qUl;
  private float qUm;
  
  static
  {
    AppMethodBeat.i(240343);
    cMt = new n[] { (n)ab.a(new v(ab.bO(AppBrandCircleProgressView.class), "circleColor", "getCircleColor()I")), (n)ab.a(new v(ab.bO(AppBrandCircleProgressView.class), "dotColor", "getDotColor()I")), (n)ab.a(new v(ab.bO(AppBrandCircleProgressView.class), "progressColor", "getProgressColor()I")), (n)ab.a(new v(ab.bO(AppBrandCircleProgressView.class), "circleStrokeWidth", "getCircleStrokeWidth()F")), (n)ab.a(new v(ab.bO(AppBrandCircleProgressView.class), "dotWidth", "getDotWidth()F")), (n)ab.a(new v(ab.bO(AppBrandCircleProgressView.class), "progressWidth", "getProgressWidth()F")) };
    qUn = new AppBrandCircleProgressView.g((byte)0);
    AppMethodBeat.o(240343);
  }
  
  public AppBrandCircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(240396);
    this.qTY = 2000;
    this.qTZ = 1500L;
    paramContext = kotlin.i.a.aaBH;
    paramContext = Integer.valueOf(-7829368);
    this.qUa = ((c)new a(paramContext, paramContext, this));
    paramContext = kotlin.i.a.aaBH;
    paramContext = Integer.valueOf(-7829368);
    this.qUb = ((c)new b(paramContext, paramContext, this));
    paramContext = kotlin.i.a.aaBH;
    paramContext = Integer.valueOf(-16711936);
    this.qUc = ((c)new c(paramContext, paramContext, this));
    paramContext = kotlin.i.a.aaBH;
    paramContext = Float.valueOf(1.0F);
    this.qUd = ((c)new d(paramContext, paramContext, this));
    paramContext = kotlin.i.a.aaBH;
    paramContext = Float.valueOf(1.0F);
    this.qUe = ((c)new e(paramContext, paramContext, this));
    paramContext = kotlin.i.a.aaBH;
    paramContext = Float.valueOf(3.0F);
    this.qUf = ((c)new f(paramContext, paramContext, this));
    this.qUg = g.ar((kotlin.g.a.a)new h(this));
    this.qUh = g.ar((kotlin.g.a.a)new i(this));
    this.qUi = g.ar((kotlin.g.a.a)new j(this));
    this.qUj = g.ar((kotlin.g.a.a)new k(this));
    this.oxQ = 1;
    this.qUm = this.progress;
    AppMethodBeat.o(240396);
  }
  
  private final ValueAnimator getAnimator()
  {
    AppMethodBeat.i(240378);
    ValueAnimator localValueAnimator = (ValueAnimator)this.qUg.getValue();
    AppMethodBeat.o(240378);
    return localValueAnimator;
  }
  
  private final Paint getCirclePaint()
  {
    AppMethodBeat.i(240380);
    Paint localPaint = (Paint)this.qUh.getValue();
    AppMethodBeat.o(240380);
    return localPaint;
  }
  
  private final Paint getDotPaint()
  {
    AppMethodBeat.i(240382);
    Paint localPaint = (Paint)this.qUi.getValue();
    AppMethodBeat.o(240382);
    return localPaint;
  }
  
  private final Paint getProgressPaint()
  {
    AppMethodBeat.i(240383);
    Paint localPaint = (Paint)this.qUj.getValue();
    AppMethodBeat.o(240383);
    return localPaint;
  }
  
  private final float getRadius()
  {
    AppMethodBeat.i(240385);
    float f = 0.0F;
    if (isLaidOut()) {
      f = Math.min(getMeasuredHeight() - Math.max(getProgressWidth(), getDotWidth()) * 2.0F, getMeasuredWidth() - Math.max(getProgressWidth(), getDotWidth()) * 2.0F) / 2.0F;
    }
    AppMethodBeat.o(240385);
    return f;
  }
  
  public final void cjx()
  {
    AppMethodBeat.i(240388);
    this.currentPlayTime = 0L;
    getAnimator().addUpdateListener((ValueAnimator.AnimatorUpdateListener)new l(this));
    getAnimator().start();
    AppMethodBeat.o(240388);
  }
  
  public final void cjy()
  {
    AppMethodBeat.i(240390);
    this.qTY = 0;
    getAnimator().setDuration(1000L);
    this.oxQ = 5;
    AppMethodBeat.o(240390);
  }
  
  public final long getAnimDuration()
  {
    return this.qTZ;
  }
  
  public final int getCircleColor()
  {
    AppMethodBeat.i(240352);
    int i = ((Number)this.qUa.a(cMt[0])).intValue();
    AppMethodBeat.o(240352);
    return i;
  }
  
  public final float getCircleStrokeWidth()
  {
    AppMethodBeat.i(240368);
    float f = ((Number)this.qUd.a(cMt[3])).floatValue();
    AppMethodBeat.o(240368);
    return f;
  }
  
  public final int getDotColor()
  {
    AppMethodBeat.i(240355);
    int i = ((Number)this.qUb.a(cMt[1])).intValue();
    AppMethodBeat.o(240355);
    return i;
  }
  
  public final float getDotWidth()
  {
    AppMethodBeat.i(240371);
    float f = ((Number)this.qUe.a(cMt[4])).floatValue();
    AppMethodBeat.o(240371);
    return f;
  }
  
  public final int getProgress()
  {
    return this.progress;
  }
  
  public final int getProgressColor()
  {
    AppMethodBeat.i(240362);
    int i = ((Number)this.qUc.a(cMt[2])).intValue();
    AppMethodBeat.o(240362);
    return i;
  }
  
  public final float getProgressWidth()
  {
    AppMethodBeat.i(240375);
    float f = ((Number)this.qUf.a(cMt[5])).floatValue();
    AppMethodBeat.o(240375);
    return f;
  }
  
  public final int getTransitionTimingMs()
  {
    return this.qTY;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(240393);
    super.onDetachedFromWindow();
    getAnimator().cancel();
    AppMethodBeat.o(240393);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(240392);
    p.k(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if ((this.qUk == 0.0F) || (this.qUl == 0.0F))
    {
      AppMethodBeat.o(240392);
      return;
    }
    float f8 = getMeasuredWidth();
    float f1 = getMeasuredHeight();
    paramCanvas.drawCircle(f8 / 2.0F, f1 / 2.0F, getRadius(), getCirclePaint());
    if (this.currentPlayTime <= this.qTY)
    {
      paramCanvas.drawCircle(this.qUk + getRadius() + Math.max(getProgressWidth(), getDotWidth()), this.qUl + getRadius() + Math.max(getProgressWidth(), getDotWidth()), getDotWidth(), getDotPaint());
      AppMethodBeat.o(240392);
      return;
    }
    if (this.qUm < this.progress) {
      this.qUm += this.oxQ;
    }
    for (;;)
    {
      float f2 = this.qUm * 360.0F / 100.0F;
      float f3 = f8 / 2.0F;
      float f4 = getRadius();
      float f5 = f1 / 2.0F;
      float f6 = getRadius();
      float f7 = getRadius();
      f8 /= 2.0F;
      float f9 = getRadius();
      paramCanvas.drawArc(f3 - f4, f5 - f6, f7 + f8, f1 / 2.0F + f9, this.angle, f2, false, getProgressPaint());
      if (this.qUm >= 100.0F) {
        getAnimator().cancel();
      }
      AppMethodBeat.o(240392);
      return;
      if (this.qUm <= 80.0F) {
        this.qUm += 0.5F;
      }
    }
  }
  
  public final void setAnimDuration(long paramLong)
  {
    this.qTZ = paramLong;
  }
  
  public final void setCircleColor(int paramInt)
  {
    AppMethodBeat.i(240354);
    this.qUa.a(cMt[0], Integer.valueOf(paramInt));
    AppMethodBeat.o(240354);
  }
  
  public final void setCircleStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(240369);
    this.qUd.a(cMt[3], Float.valueOf(paramFloat));
    AppMethodBeat.o(240369);
  }
  
  public final void setDotColor(int paramInt)
  {
    AppMethodBeat.i(240359);
    this.qUb.a(cMt[1], Integer.valueOf(paramInt));
    AppMethodBeat.o(240359);
  }
  
  public final void setDotWidth(float paramFloat)
  {
    AppMethodBeat.i(240373);
    this.qUe.a(cMt[4], Float.valueOf(paramFloat));
    AppMethodBeat.o(240373);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(240349);
    Log.d("AppBrandCircleProgressView", "hash = " + hashCode() + " progress = " + paramInt);
    this.progress = paramInt;
    AppMethodBeat.o(240349);
  }
  
  public final void setProgressColor(int paramInt)
  {
    AppMethodBeat.i(240365);
    this.qUc.a(cMt[2], Integer.valueOf(paramInt));
    AppMethodBeat.o(240365);
  }
  
  public final void setProgressWidth(float paramFloat)
  {
    AppMethodBeat.i(240376);
    this.qUf.a(cMt[5], Float.valueOf(paramFloat));
    AppMethodBeat.o(240376);
  }
  
  public final void setTransitionTimingMs(int paramInt)
  {
    this.qTY = paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class a
    extends b<Integer>
  {
    public a(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(n<?> paramn, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(237673);
      p.k(paramn, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.b(jdField_this).setColor(i);
      AppMethodBeat.o(237673);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class b
    extends b<Integer>
  {
    public b(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(n<?> paramn, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(235785);
      p.k(paramn, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.c(jdField_this).setColor(i);
      AppMethodBeat.o(235785);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class c
    extends b<Integer>
  {
    public c(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(n<?> paramn, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(246110);
      p.k(paramn, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.d(jdField_this).setColor(i);
      AppMethodBeat.o(246110);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class d
    extends b<Float>
  {
    public d(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(n<?> paramn, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(244146);
      p.k(paramn, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.b(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(244146);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class e
    extends b<Float>
  {
    public e(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(n<?> paramn, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(247217);
      p.k(paramn, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.b(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(247217);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class f
    extends b<Float>
  {
    public f(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(n<?> paramn, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(234547);
      p.k(paramn, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.d(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(234547);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<ValueAnimator>
  {
    h(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<Paint>
  {
    i(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<Paint>
  {
    j(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/graphics/Paint;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<Paint>
  {
    k(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class l
    implements ValueAnimator.AnimatorUpdateListener
  {
    l(AppBrandCircleProgressView paramAppBrandCircleProgressView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(234315);
      AppBrandCircleProgressView localAppBrandCircleProgressView = this.qUo;
      p.j(paramValueAnimator, "animation");
      AppBrandCircleProgressView.a(localAppBrandCircleProgressView, paramValueAnimator.getCurrentPlayTime());
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(234315);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      AppBrandCircleProgressView.a(this.qUo, AppBrandCircleProgressView.a(this.qUo) * (float)Math.cos(f));
      AppBrandCircleProgressView.b(this.qUo, AppBrandCircleProgressView.a(this.qUo) * (float)Math.sin(f));
      AppBrandCircleProgressView.c(this.qUo, (float)(f * 360.0F / 6.283185307179586D));
      this.qUo.invalidate();
      AppMethodBeat.o(234315);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView
 * JD-Core Version:    0.7.0.1
 */