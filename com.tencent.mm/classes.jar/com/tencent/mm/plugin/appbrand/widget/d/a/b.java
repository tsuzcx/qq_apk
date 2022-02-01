package com.tencent.mm.plugin.appbrand.widget.d.a;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.k.a.a.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.videocomposition.effect.d;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/HalfScreenBackgroundEmbedRenderer;", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/HalfScreenBackgroundCommonRenderer;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "backgroundColor", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;I)V", "blurHostCaptureSnapshot", "Landroid/graphics/Bitmap;", "progressToTargetAlpha", "", "requestingEffect", "", "onAnimationUpdate", "", "fromAlpha", "toAlpha", "duration", "", "animation", "Landroid/animation/ValueAnimator;", "onBackground", "onDrawBackground", "canvas", "Landroid/graphics/Canvas;", "drawBgUnderMe", "Landroid/view/View;", "tryRenderBg", "type", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer$RendererType;", "viewToDrawBackgroundBehind", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public static final b.a uEp;
  private float uEq;
  private Bitmap uEr;
  private boolean uEs;
  
  static
  {
    AppMethodBeat.i(324375);
    uEp = new b.a((byte)0);
    AppMethodBeat.o(324375);
  }
  
  public b(w paramw, int paramInt)
  {
    super(paramw, paramInt);
    AppMethodBeat.i(324358);
    AppMethodBeat.o(324358);
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(324409);
    s.u(paramValueAnimator, "animation");
    super.a(paramInt1, paramInt2, paramLong, paramValueAnimator);
    if (paramInt1 - paramInt2 == 0) {}
    for (float f = 1.0F;; f = (((Integer)paramValueAnimator).intValue() - paramInt1) / (paramInt2 - paramInt1))
    {
      this.uEq = f;
      AppMethodBeat.o(324409);
      return;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(324409);
        throw paramValueAnimator;
      }
    }
  }
  
  public final void a(Canvas paramCanvas, View paramView)
  {
    AppMethodBeat.i(324396);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramCanvas != null)
    {
      if (this.uEr == null) {
        break label131;
      }
      localObject1 = new Paint();
      ((Paint)localObject1).setAlpha((int)(this.uEq * 255.0F));
      localObject2 = this.uEr;
      s.checkNotNull(localObject2);
      localObject3 = this.uEr;
      s.checkNotNull(localObject3);
      int i = ((Bitmap)localObject3).getWidth();
      localObject3 = this.uEr;
      s.checkNotNull(localObject3);
      paramCanvas.drawBitmap((Bitmap)localObject2, new Rect(0, 0, i, ((Bitmap)localObject3).getHeight()), new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight()), (Paint)localObject1);
    }
    for (;;)
    {
      super.a(paramCanvas, paramView);
      AppMethodBeat.o(324396);
      return;
      label131:
      if (!this.uEs)
      {
        localObject1 = com.tencent.mm.plugin.appbrand.k.a.a.ruh;
        localObject1 = a.a.H(getRuntime());
        if (localObject1 != null)
        {
          this.uEs = true;
          localObject1 = ((w)localObject1).ccY();
          localObject2 = new com.tencent.mm.videocomposition.effect.a();
          localObject3 = new Matrix();
          ((Matrix)localObject3).postScale(0.6F, 0.6F);
          localObject3 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject3, true);
          s.s(localObject3, "resizeBmp");
          ((com.tencent.mm.videocomposition.effect.a)localObject2).setInputBitmap((Bitmap)localObject3);
          ((com.tencent.mm.videocomposition.effect.a)localObject2).setOutputSize(paramCanvas.getWidth(), paramCanvas.getHeight());
          ((com.tencent.mm.videocomposition.effect.a)localObject2).HkF.GpO.jQj().setRadius(2.0F);
          ((com.tencent.mm.videocomposition.effect.a)localObject2).aW((kotlin.g.a.b)new b.b(System.currentTimeMillis(), this, paramView, (Bitmap)localObject1, (Bitmap)localObject3));
        }
      }
    }
  }
  
  public final View cQt()
  {
    AppMethodBeat.i(324386);
    for (;;)
    {
      try
      {
        localObject1 = getRuntime().qsc;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = null;
      }
      finally
      {
        Object localObject1;
        Object localObject3 = null;
        continue;
        localObject3 = ((AppBrandRuntime)localObject3).qsp;
        if (localObject3 != null) {
          continue;
        }
        localObject3 = null;
        continue;
        localObject3 = ((e)localObject3).cGi();
        continue;
      }
      if (localObject1 != null) {
        continue;
      }
      localObject1 = null;
      localObject1 = (View)localObject1;
      AppMethodBeat.o(324386);
      return localObject1;
      localObject1 = ((ap)localObject1).y((AppBrandRuntime)getRuntime());
    }
  }
  
  public final c.b cQu()
  {
    return c.b.uEB;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(324403);
    super.onBackground();
    Object localObject = k.Uo(getRuntime().mAppId);
    if ((localObject != k.d.qrK) && (localObject != k.d.qrL) && (localObject != k.d.qrM) && (localObject != k.d.qrN))
    {
      localObject = this.uEr;
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      this.uEr = null;
    }
    AppMethodBeat.o(324403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.a.b
 * JD-Core Version:    0.7.0.1
 */