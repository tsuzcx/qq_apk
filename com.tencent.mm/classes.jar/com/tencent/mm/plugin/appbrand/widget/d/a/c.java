package com.tencent.mm.plugin.appbrand.widget.d.a;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer;", "", "animator", "Landroid/animation/ValueAnimator;", "fromAlpha", "", "toAlpha", "duration", "", "currentAlpha", "defaultAlpha", "onBackground", "", "onDrawBackground", "canvas", "Landroid/graphics/Canvas;", "drawBgUnderMe", "Landroid/view/View;", "reset", "transparent", "type", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer$RendererType;", "viewToDrawBackgroundBehind", "Companion", "RendererType", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
{
  public static final a uEw = a.uEx;
  
  public abstract void a(Canvas paramCanvas, View paramView);
  
  public abstract int cQq();
  
  public abstract int cQr();
  
  public abstract void cQs();
  
  public abstract View cQt();
  
  public abstract b cQu();
  
  public abstract ValueAnimator h(int paramInt1, int paramInt2, long paramLong);
  
  public abstract void onBackground();
  
  public abstract void reset();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer$Companion;", "", "()V", "DUMMY", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer;", "getDUMMY", "()Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final c uEy;
    
    static
    {
      AppMethodBeat.i(324391);
      uEx = new a();
      uEy = (c)new a();
      AppMethodBeat.o(324391);
    }
    
    public static c cQv()
    {
      return uEy;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer$Companion$DUMMY$1", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer;", "animator", "Landroid/animation/ValueAnimator;", "fromAlpha", "", "toAlpha", "duration", "", "currentAlpha", "defaultAlpha", "onBackground", "", "onDrawBackground", "canvas", "Landroid/graphics/Canvas;", "drawBgUnderMe", "Landroid/view/View;", "reset", "transparent", "type", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer$RendererType;", "viewToDrawBackgroundBehind", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements c
    {
      public final void a(Canvas paramCanvas, View paramView) {}
      
      public final int cQq()
      {
        return 0;
      }
      
      public final int cQr()
      {
        return 0;
      }
      
      public final void cQs() {}
      
      public final View cQt()
      {
        return null;
      }
      
      public final c.b cQu()
      {
        return c.b.uEz;
      }
      
      public final ValueAnimator h(int paramInt1, int paramInt2, long paramLong)
      {
        AppMethodBeat.i(324384);
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 0.0F });
        s.s(localValueAnimator, "ofFloat(0F,0F)");
        AppMethodBeat.o(324384);
        return localValueAnimator;
      }
      
      public final void onBackground() {}
      
      public final void reset() {}
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer$RendererType;", "", "(Ljava/lang/String;I)V", "TYPE_NONE", "TYPE_NORMAL", "TYPE_EMBED", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(324392);
      uEz = new b("TYPE_NONE", 0);
      uEA = new b("TYPE_NORMAL", 1);
      uEB = new b("TYPE_EMBED", 2);
      uEC = new b[] { uEz, uEA, uEB };
      AppMethodBeat.o(324392);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.a.c
 * JD-Core Version:    0.7.0.1
 */