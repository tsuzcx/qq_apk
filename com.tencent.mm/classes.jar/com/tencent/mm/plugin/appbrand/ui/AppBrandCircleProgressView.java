package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.aa;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.g.b.z;
import kotlin.i.b;
import kotlin.i.c;
import kotlin.j;
import kotlin.k;
import kotlin.l.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandCircleProgressView;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "angle", "", "animDuration", "", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator$delegate", "Lkotlin/Lazy;", "<set-?>", "", "circleColor", "getCircleColor", "()I", "setCircleColor", "(I)V", "circleColor$delegate", "Lkotlin/properties/ReadWriteProperty;", "circlePaint", "Landroid/graphics/Paint;", "getCirclePaint", "()Landroid/graphics/Paint;", "circlePaint$delegate", "circleStrokeWidth", "getCircleStrokeWidth", "()F", "setCircleStrokeWidth", "(F)V", "circleStrokeWidth$delegate", "currentPlayTime", "dotColor", "getDotColor", "setDotColor", "dotColor$delegate", "dotPaint", "getDotPaint", "dotPaint$delegate", "dotWidth", "getDotWidth", "setDotWidth", "dotWidth$delegate", "pointX", "pointY", "processToDraw", "value", "progress", "getProgress", "setProgress", "progressColor", "getProgressColor", "setProgressColor", "progressColor$delegate", "progressPaint", "getProgressPaint", "progressPaint$delegate", "progressWidth", "getProgressWidth", "setProgressWidth", "progressWidth$delegate", "radius", "getRadius", "step", "transitionTimingMs", "getTransitionTimingMs", "setTransitionTimingMs", "onDetachedFromWindow", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "promote", "startAnim", "stopAnim", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandCircleProgressView
  extends View
{
  public static final AppBrandCircleProgressView.a tYY;
  private float angle;
  private long currentPlayTime;
  private int progress;
  private int rBp;
  private int tYZ;
  private long tZa;
  private final c tZb;
  private final c tZc;
  private final c tZd;
  private final c tZe;
  private final c tZf;
  private final c tZg;
  private final j tZh;
  private final j tZi;
  private final j tZj;
  private final j tZk;
  private float tZl;
  private float tZm;
  private float tZn;
  
  static
  {
    AppMethodBeat.i(322767);
    aYe = new o[] { (o)ai.a((z)new aa(AppBrandCircleProgressView.class, "circleColor", "getCircleColor()I", 0)), (o)ai.a((z)new aa(AppBrandCircleProgressView.class, "dotColor", "getDotColor()I", 0)), (o)ai.a((z)new aa(AppBrandCircleProgressView.class, "progressColor", "getProgressColor()I", 0)), (o)ai.a((z)new aa(AppBrandCircleProgressView.class, "circleStrokeWidth", "getCircleStrokeWidth()F", 0)), (o)ai.a((z)new aa(AppBrandCircleProgressView.class, "dotWidth", "getDotWidth()F", 0)), (o)ai.a((z)new aa(AppBrandCircleProgressView.class, "progressWidth", "getProgressWidth()F", 0)) };
    tYY = new AppBrandCircleProgressView.a((byte)0);
    AppMethodBeat.o(322767);
  }
  
  public AppBrandCircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(322705);
    this.tYZ = 2000;
    this.tZa = 1500L;
    paramContext = kotlin.i.a.aixi;
    paramContext = Integer.valueOf(-7829368);
    this.tZb = ((c)new f(paramContext, paramContext, this));
    paramContext = kotlin.i.a.aixi;
    paramContext = Integer.valueOf(-7829368);
    this.tZc = ((c)new g(paramContext, paramContext, this));
    paramContext = kotlin.i.a.aixi;
    paramContext = Integer.valueOf(-16711936);
    this.tZd = ((c)new h(paramContext, paramContext, this));
    paramContext = kotlin.i.a.aixi;
    paramContext = Float.valueOf(1.0F);
    this.tZe = ((c)new i(paramContext, paramContext, this));
    paramContext = kotlin.i.a.aixi;
    paramContext = Float.valueOf(1.0F);
    this.tZf = ((c)new j(paramContext, paramContext, this));
    paramContext = kotlin.i.a.aixi;
    paramContext = Float.valueOf(3.0F);
    this.tZg = ((c)new k(paramContext, paramContext, this));
    this.tZh = k.cm((kotlin.g.a.a)new b(this));
    this.tZi = k.cm((kotlin.g.a.a)new c(this));
    this.tZj = k.cm((kotlin.g.a.a)new d(this));
    this.tZk = k.cm((kotlin.g.a.a)new e(this));
    this.rBp = 1;
    this.tZn = this.progress;
    AppMethodBeat.o(322705);
  }
  
  private static final void a(AppBrandCircleProgressView paramAppBrandCircleProgressView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(322728);
    s.u(paramAppBrandCircleProgressView, "this$0");
    paramAppBrandCircleProgressView.currentPlayTime = paramValueAnimator.getCurrentPlayTime();
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramAppBrandCircleProgressView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(322728);
      throw paramAppBrandCircleProgressView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramAppBrandCircleProgressView.tZl = (paramAppBrandCircleProgressView.getRadius() * (float)Math.cos(f));
    paramAppBrandCircleProgressView.tZm = (paramAppBrandCircleProgressView.getRadius() * (float)Math.sin(f));
    paramAppBrandCircleProgressView.angle = ((float)(f * 360.0F / 6.283185307179586D));
    paramAppBrandCircleProgressView.invalidate();
    AppMethodBeat.o(322728);
  }
  
  private final ValueAnimator getAnimator()
  {
    AppMethodBeat.i(322708);
    Object localObject = this.tZh.getValue();
    s.s(localObject, "<get-animator>(...)");
    localObject = (ValueAnimator)localObject;
    AppMethodBeat.o(322708);
    return localObject;
  }
  
  private final Paint getCirclePaint()
  {
    AppMethodBeat.i(322713);
    Paint localPaint = (Paint)this.tZi.getValue();
    AppMethodBeat.o(322713);
    return localPaint;
  }
  
  private final Paint getDotPaint()
  {
    AppMethodBeat.i(322716);
    Paint localPaint = (Paint)this.tZj.getValue();
    AppMethodBeat.o(322716);
    return localPaint;
  }
  
  private final Paint getProgressPaint()
  {
    AppMethodBeat.i(322719);
    Paint localPaint = (Paint)this.tZk.getValue();
    AppMethodBeat.o(322719);
    return localPaint;
  }
  
  private final float getRadius()
  {
    AppMethodBeat.i(322723);
    float f = 0.0F;
    if (isLaidOut()) {
      f = Math.min(getMeasuredHeight() - Math.max(getProgressWidth(), getDotWidth()) * 2.0F, getMeasuredWidth() - Math.max(getProgressWidth(), getDotWidth()) * 2.0F) / 2.0F;
    }
    AppMethodBeat.o(322723);
    return f;
  }
  
  public final void cKI()
  {
    AppMethodBeat.i(322920);
    this.currentPlayTime = 0L;
    getAnimator().addUpdateListener(new AppBrandCircleProgressView..ExternalSyntheticLambda0(this));
    getAnimator().start();
    AppMethodBeat.o(322920);
  }
  
  public final void cKJ()
  {
    AppMethodBeat.i(322926);
    this.tYZ = 0;
    getAnimator().setDuration(1000L);
    this.rBp = 5;
    AppMethodBeat.o(322926);
  }
  
  public final long getAnimDuration()
  {
    return this.tZa;
  }
  
  public final int getCircleColor()
  {
    AppMethodBeat.i(322840);
    int i = ((Number)this.tZb.a(aYe[0])).intValue();
    AppMethodBeat.o(322840);
    return i;
  }
  
  public final float getCircleStrokeWidth()
  {
    AppMethodBeat.i(322885);
    float f = ((Number)this.tZe.a(aYe[3])).floatValue();
    AppMethodBeat.o(322885);
    return f;
  }
  
  public final int getDotColor()
  {
    AppMethodBeat.i(322858);
    int i = ((Number)this.tZc.a(aYe[1])).intValue();
    AppMethodBeat.o(322858);
    return i;
  }
  
  public final float getDotWidth()
  {
    AppMethodBeat.i(322896);
    float f = ((Number)this.tZf.a(aYe[4])).floatValue();
    AppMethodBeat.o(322896);
    return f;
  }
  
  public final int getProgress()
  {
    return this.progress;
  }
  
  public final int getProgressColor()
  {
    AppMethodBeat.i(322871);
    int i = ((Number)this.tZd.a(aYe[2])).intValue();
    AppMethodBeat.o(322871);
    return i;
  }
  
  public final float getProgressWidth()
  {
    AppMethodBeat.i(322909);
    float f = ((Number)this.tZg.a(aYe[5])).floatValue();
    AppMethodBeat.o(322909);
    return f;
  }
  
  public final int getTransitionTimingMs()
  {
    return this.tYZ;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(322938);
    super.onDetachedFromWindow();
    getAnimator().cancel();
    AppMethodBeat.o(322938);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(322933);
    s.u(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    if (this.tZl == 0.0F)
    {
      i = 1;
      if (i == 0) {
        if (this.tZm != 0.0F) {
          break label65;
        }
      }
    }
    label65:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label71;
      }
      AppMethodBeat.o(322933);
      return;
      i = 0;
      break;
    }
    label71:
    float f8 = getMeasuredWidth();
    float f1 = getMeasuredHeight();
    paramCanvas.drawCircle(f8 / 2.0F, f1 / 2.0F, getRadius(), getCirclePaint());
    if (this.currentPlayTime <= this.tYZ)
    {
      paramCanvas.drawCircle(this.tZl + getRadius() + Math.max(getProgressWidth(), getDotWidth()), this.tZm + getRadius() + Math.max(getProgressWidth(), getDotWidth()), getDotWidth(), getDotPaint());
      AppMethodBeat.o(322933);
      return;
    }
    if (this.tZn < this.progress) {
      this.tZn += this.rBp;
    }
    for (;;)
    {
      float f2 = this.tZn * 360.0F / 100.0F;
      float f3 = f8 / 2.0F;
      float f4 = getRadius();
      float f5 = f1 / 2.0F;
      float f6 = getRadius();
      float f7 = getRadius();
      f8 /= 2.0F;
      float f9 = getRadius();
      paramCanvas.drawArc(f3 - f4, f5 - f6, f7 + f8, f1 / 2.0F + f9, this.angle, f2, false, getProgressPaint());
      if (this.tZn >= 100.0F) {
        getAnimator().cancel();
      }
      AppMethodBeat.o(322933);
      return;
      if (this.tZn <= 80.0F) {
        this.tZn += 0.5F;
      }
    }
  }
  
  public final void setAnimDuration(long paramLong)
  {
    this.tZa = paramLong;
  }
  
  public final void setCircleColor(int paramInt)
  {
    AppMethodBeat.i(322853);
    this.tZb.a(aYe[0], Integer.valueOf(paramInt));
    AppMethodBeat.o(322853);
  }
  
  public final void setCircleStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(322889);
    this.tZe.a(aYe[3], Float.valueOf(paramFloat));
    AppMethodBeat.o(322889);
  }
  
  public final void setDotColor(int paramInt)
  {
    AppMethodBeat.i(322863);
    this.tZc.a(aYe[1], Integer.valueOf(paramInt));
    AppMethodBeat.o(322863);
  }
  
  public final void setDotWidth(float paramFloat)
  {
    AppMethodBeat.i(322902);
    this.tZf.a(aYe[4], Float.valueOf(paramFloat));
    AppMethodBeat.o(322902);
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(322829);
    Log.d("AppBrandCircleProgressView", "hash = " + hashCode() + " progress = " + paramInt);
    this.progress = paramInt;
    AppMethodBeat.o(322829);
  }
  
  public final void setProgressColor(int paramInt)
  {
    AppMethodBeat.i(322877);
    this.tZd.a(aYe[2], Integer.valueOf(paramInt));
    AppMethodBeat.o(322877);
  }
  
  public final void setProgressWidth(float paramFloat)
  {
    AppMethodBeat.i(322915);
    this.tZg.a(aYe[5], Float.valueOf(paramFloat));
    AppMethodBeat.o(322915);
  }
  
  public final void setTransitionTimingMs(int paramInt)
  {
    this.tYZ = paramInt;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ValueAnimator>
  {
    b(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Paint;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Paint>
  {
    c(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Paint;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Paint>
  {
    d(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Paint;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Paint>
  {
    e(AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class f
    extends b<Integer>
  {
    public f(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(o<?> paramo, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(323036);
      s.u(paramo, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.a(jdField_this).setColor(i);
      AppMethodBeat.o(323036);
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class g
    extends b<Integer>
  {
    public g(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(o<?> paramo, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(322726);
      s.u(paramo, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.b(jdField_this).setColor(i);
      AppMethodBeat.o(322726);
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class h
    extends b<Integer>
  {
    public h(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(o<?> paramo, Integer paramInteger1, Integer paramInteger2)
    {
      AppMethodBeat.i(322698);
      s.u(paramo, "property");
      int i = ((Number)paramInteger2).intValue();
      ((Number)paramInteger1).intValue();
      AppBrandCircleProgressView.c(jdField_this).setColor(i);
      AppMethodBeat.o(322698);
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class i
    extends b<Float>
  {
    public i(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(o<?> paramo, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(322701);
      s.u(paramo, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.a(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(322701);
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class j
    extends b<Float>
  {
    public j(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(o<?> paramo, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(322458);
      s.u(paramo, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.b(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(322458);
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class k
    extends b<Float>
  {
    public k(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
    {
      super();
    }
    
    public final void a(o<?> paramo, Float paramFloat1, Float paramFloat2)
    {
      AppMethodBeat.i(322449);
      s.u(paramo, "property");
      float f = ((Number)paramFloat2).floatValue();
      ((Number)paramFloat1).floatValue();
      AppBrandCircleProgressView.c(jdField_this).setStrokeWidth(f);
      AppMethodBeat.o(322449);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView
 * JD-Core Version:    0.7.0.1
 */