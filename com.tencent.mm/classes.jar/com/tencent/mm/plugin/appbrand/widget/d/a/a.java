package com.tencent.mm.plugin.appbrand.widget.d.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/HalfScreenBackgroundCommonRenderer;", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "backgroundColor", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;I)V", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "backgroundColorAlpha", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "animator", "Landroid/animation/ValueAnimator;", "fromAlpha", "toAlpha", "duration", "", "currentAlpha", "defaultAlpha", "onAnimationUpdate", "", "animation", "onBackground", "onDrawBackground", "canvas", "Landroid/graphics/Canvas;", "drawBgUnderMe", "Landroid/view/View;", "reset", "transparent", "type", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer$RendererType;", "viewToDrawBackgroundBehind", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  implements c
{
  public static final a.a uEi;
  private int backgroundColor;
  private final w qxC;
  private int uEj;
  
  static
  {
    AppMethodBeat.i(324381);
    uEi = new a.a((byte)0);
    AppMethodBeat.o(324381);
  }
  
  public a(w paramw, int paramInt)
  {
    AppMethodBeat.i(324367);
    this.qxC = paramw;
    this.backgroundColor = paramInt;
    AppMethodBeat.o(324367);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(324434);
    s.u(paramValueAnimator, "animation");
    AppMethodBeat.o(324434);
  }
  
  public void a(Canvas paramCanvas, View paramView)
  {
    AppMethodBeat.i(324393);
    if (paramCanvas != null)
    {
      paramView = new ColorDrawable(Color.argb(this.uEj, Color.red(this.backgroundColor), Color.green(this.backgroundColor), Color.blue(this.backgroundColor)));
      paramView.setBounds(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight());
      paramView.draw(paramCanvas);
    }
    AppMethodBeat.o(324393);
  }
  
  public final int cQq()
  {
    return this.uEj;
  }
  
  public final int cQr()
  {
    AppMethodBeat.i(324411);
    int i = Color.alpha(this.backgroundColor);
    AppMethodBeat.o(324411);
    return i;
  }
  
  public final void cQs()
  {
    this.backgroundColor = 0;
    this.uEj = 0;
  }
  
  public View cQt()
  {
    return (View)this.qxC.qsk;
  }
  
  public c.b cQu()
  {
    return c.b.uEA;
  }
  
  protected final w getRuntime()
  {
    return this.qxC;
  }
  
  public final ValueAnimator h(final int paramInt1, final int paramInt2, final long paramLong)
  {
    AppMethodBeat.i(324402);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.setDuration(paramLong);
    Object localObject = cQt();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((View)localObject).getParent())
    {
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(this, paramInt1, paramInt2, paramLong, (View)localObject));
      localValueAnimator.start();
      Log.i("MicroMsg.HalfScreenBackgroundCommonRenderer", s.X("[animator]:", localValueAnimator));
      s.s(localValueAnimator, "animator");
      AppMethodBeat.o(324402);
      return localValueAnimator;
    }
  }
  
  public void onBackground() {}
  
  public final void reset()
  {
    this.uEj = 0;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/halfscreen/bg/HalfScreenBackgroundCommonRenderer$animator$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(a parama, int paramInt1, int paramInt2, long paramLong, View paramView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(324379);
      if (paramValueAnimator == null)
      {
        AppMethodBeat.o(324379);
        return;
      }
      this.uEk.a(paramInt1, paramInt2, paramLong, paramValueAnimator);
      a locala = this.uEk;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(324379);
        throw paramValueAnimator;
      }
      a.a(locala, ((Integer)paramValueAnimator).intValue());
      paramValueAnimator = this.uEo;
      if (paramValueAnimator != null) {
        paramValueAnimator.invalidate();
      }
      AppMethodBeat.o(324379);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.a.a
 * JD-Core Version:    0.7.0.1
 */