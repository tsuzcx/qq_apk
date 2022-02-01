package com.tencent.mm.plugin.appbrand.ui.wxa_container;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.d.d;
import com.tencent.mm.plugin.appbrand.widget.d.d.b;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.statusbar.c.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandActivityContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "externalHeaderAnchor", "Landroid/view/View;", "externalHeaderContainer", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarContainerLayout;", "runtimeContainer", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "getRuntimeContainer", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "setRuntimeContainer", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;)V", "animateExternalHeader", "", "animation", "Landroid/view/animation/Animation;", "clearExternalHeader", "drawChild", "", "canvas", "Landroid/graphics/Canvas;", "child", "drawingTime", "", "getRuntime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "isInteractsExternalHeader", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onLayout", "changed", "left", "", "top", "right", "bottom", "onTouchEvent", "event", "setAnimationMatrix", "view", "matrix", "Landroid/graphics/Matrix;", "setExternalHeader", "header", "setExternalHeaderAnchor", "anchor", "setExternalHeaderContainer", "container", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends FrameLayout
{
  public AppBrandRuntimeContainerWC upP;
  public com.tencent.mm.plugin.appbrand.page.capsulebar.c upQ;
  public View upR;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(322520);
    AppMethodBeat.o(322520);
  }
  
  private static final void a(a parama, Animation paramAnimation, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(322528);
    s.u(parama, "this$0");
    s.u(paramAnimation, "$animation");
    float f1;
    float f2;
    if (parama.upQ != null)
    {
      paramValueAnimator = new Transformation();
      if (paramAnimation.getTransformation(SystemClock.uptimeMillis(), paramValueAnimator))
      {
        parama = parama.upQ;
        s.checkNotNull(parama);
        parama = (View)parama;
        paramAnimation = paramValueAnimator.getMatrix();
        if ((paramAnimation == null) || (paramAnimation.isIdentity()))
        {
          parama.setPivotX(parama.getWidth() / 2);
          parama.setPivotY(parama.getHeight() / 2);
          parama.setTranslationX(0.0F);
          parama.setTranslationY(0.0F);
          parama.setScaleX(1.0F);
          parama.setScaleY(1.0F);
          parama.setRotation(0.0F);
          AppMethodBeat.o(322528);
          return;
        }
        paramValueAnimator = new float[9];
        paramAnimation.getValues(paramValueAnimator);
        f1 = paramValueAnimator[3];
        f2 = (float)Math.sqrt(1.0F - f1 * f1);
        if (paramValueAnimator[0] >= 0.0F) {
          break label255;
        }
      }
    }
    label255:
    for (int i = -1;; i = 1)
    {
      float f3 = i * f2;
      f1 = (float)Math.toDegrees(Math.atan2(f1, f3));
      f2 = paramValueAnimator[0] / f3;
      f3 = paramValueAnimator[4] / f3;
      float f4 = paramValueAnimator[2];
      float f5 = paramValueAnimator[5];
      parama.setPivotX(0.0F);
      parama.setPivotY(0.0F);
      parama.setTranslationX(f4);
      parama.setTranslationY(f5);
      parama.setRotation(f1);
      parama.setScaleX(f2);
      parama.setScaleY(f3);
      AppMethodBeat.o(322528);
      return;
    }
  }
  
  private final w getRuntime()
  {
    AppMethodBeat.i(322523);
    Object localObject = getRuntimeContainer().getActiveRuntime();
    if ((localObject instanceof w))
    {
      localObject = (w)localObject;
      AppMethodBeat.o(322523);
      return localObject;
    }
    AppMethodBeat.o(322523);
    return null;
  }
  
  private static final void setExternalHeaderContainer$lambda-1(View paramView)
  {
    AppMethodBeat.i(322524);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandActivityContainerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/wxa_container/AppBrandActivityContainerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322524);
  }
  
  public final boolean E(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(322554);
    s.u(paramMotionEvent, "ev");
    if (this.upQ == null)
    {
      AppMethodBeat.o(322554);
      return false;
    }
    Rect localRect = new Rect();
    com.tencent.mm.plugin.appbrand.page.capsulebar.c localc = this.upQ;
    s.checkNotNull(localc);
    localc.getHitRect(localRect);
    boolean bool = localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    AppMethodBeat.o(322554);
    return bool;
  }
  
  public final void c(Animation paramAnimation)
  {
    AppMethodBeat.i(322556);
    s.u(paramAnimation, "animation");
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, (int)paramAnimation.getDuration() });
    localValueAnimator.setDuration(paramAnimation.getDuration());
    localValueAnimator.addUpdateListener(new a..ExternalSyntheticLambda0(this, paramAnimation));
    localValueAnimator.start();
    AppMethodBeat.o(322556);
  }
  
  protected final boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(322545);
    if (paramView != null)
    {
      Object localObject = getRuntime();
      if (localObject != null)
      {
        localObject = ((w)localObject).qvN;
        if (localObject != null) {
          ((d)localObject).a(paramCanvas, paramView, d.b.uDH);
        }
      }
    }
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    AppMethodBeat.o(322545);
    return bool;
  }
  
  public final AppBrandRuntimeContainerWC getRuntimeContainer()
  {
    AppMethodBeat.i(322536);
    AppBrandRuntimeContainerWC localAppBrandRuntimeContainerWC = this.upP;
    if (localAppBrandRuntimeContainerWC != null)
    {
      AppMethodBeat.o(322536);
      return localAppBrandRuntimeContainerWC;
    }
    s.bIx("runtimeContainer");
    AppMethodBeat.o(322536);
    return null;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(322542);
    s.u(paramMotionEvent, "ev");
    if (this.upP != null)
    {
      Object localObject = getRuntime();
      if (localObject != null)
      {
        localObject = ((w)localObject).qvN;
        if (localObject != null)
        {
          localObject = ((d)localObject).uDE;
          if ((localObject == null) || (((l)localObject).L(paramMotionEvent) != true)) {}
        }
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(322542);
        return true;
      }
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(322542);
    return bool;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(322558);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.upR;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((View)localObject).getParent())
    {
      if ((s.p(localObject, this)) && (this.upQ != null))
      {
        localObject = this.upR;
        s.checkNotNull(localObject);
        paramInt1 = ((View)localObject).getLeft();
        localObject = this.upR;
        s.checkNotNull(localObject);
        paramInt2 = ((View)localObject).getTop();
        localObject = this.upR;
        s.checkNotNull(localObject);
        paramInt3 = ((View)localObject).getRight();
        localObject = this.upQ;
        s.checkNotNull(localObject);
        com.tencent.mm.plugin.appbrand.page.capsulebar.c localc = this.upQ;
        s.checkNotNull(localc);
        ((com.tencent.mm.plugin.appbrand.page.capsulebar.c)localObject).layout(paramInt1, paramInt2 - localc.getMeasuredHeight(), paramInt3, paramInt2);
      }
      AppMethodBeat.o(322558);
      return;
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(322541);
    s.u(paramMotionEvent, "event");
    if (this.upP != null)
    {
      Object localObject = getRuntime();
      if (localObject != null)
      {
        localObject = ((w)localObject).qvN;
        if (localObject != null)
        {
          localObject = ((d)localObject).uDE;
          if ((localObject == null) || (((l)localObject).K(paramMotionEvent) != true)) {}
        }
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(322541);
        return true;
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(322541);
    return bool;
  }
  
  public final void setExternalHeader(View paramView)
  {
    AppMethodBeat.i(322548);
    com.tencent.mm.plugin.appbrand.page.capsulebar.c localc = this.upQ;
    if (localc != null) {
      localc.removeAllViews();
    }
    localc = this.upQ;
    if (localc != null) {
      localc.addView(paramView);
    }
    AppMethodBeat.o(322548);
  }
  
  public final void setExternalHeaderAnchor(View paramView)
  {
    this.upR = paramView;
  }
  
  public final void setExternalHeaderContainer(com.tencent.mm.plugin.appbrand.page.capsulebar.c paramc)
  {
    AppMethodBeat.i(322552);
    s.u(paramc, "container");
    if (this.upQ != null) {
      removeView((View)this.upQ);
    }
    this.upQ = paramc;
    paramc = this.upQ;
    if (paramc != null) {
      paramc.setOnClickListener(a..ExternalSyntheticLambda1.INSTANCE);
    }
    paramc = getRuntime();
    if (paramc != null)
    {
      paramc = AndroidContextUtil.castActivityOrNull(paramc.mContext);
      if (paramc != null) {
        com.tencent.mm.ui.statusbar.c.ch(paramc).a((c.a)this.upQ);
      }
    }
    addView((View)this.upQ, new ViewGroup.LayoutParams(-1, -2));
    AppMethodBeat.o(322552);
  }
  
  public final void setRuntimeContainer(AppBrandRuntimeContainerWC paramAppBrandRuntimeContainerWC)
  {
    AppMethodBeat.i(322538);
    s.u(paramAppBrandRuntimeContainerWC, "<set-?>");
    this.upP = paramAppBrandRuntimeContainerWC;
    AppMethodBeat.o(322538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.wxa_container.a
 * JD-Core Version:    0.7.0.1
 */