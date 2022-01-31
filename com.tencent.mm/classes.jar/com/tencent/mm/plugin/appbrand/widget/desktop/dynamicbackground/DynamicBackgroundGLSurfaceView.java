package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDelayPauseRunnable", "Ljava/lang/Runnable;", "mRenderer", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView$GLRenderer;", "needPause", "", "showGradientView", "onAttachedToWindow", "", "onDetachedFromWindow", "onResume", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "release", "setGradientBackgroundView", "gradientColorBackgroundView", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GradientColorBackgroundView;", "setShowGradientView", "show", "surfaceCreated", "holder", "Landroid/view/SurfaceHolder;", "surfaceDestroyed", "Companion", "GLRenderer", "plugin-appbrand-integration_release"})
public final class DynamicBackgroundGLSurfaceView
  extends GameGLSurfaceView
{
  public static final DynamicBackgroundGLSurfaceView.a jgA;
  private DynamicBackgroundGLSurfaceView.b jgx;
  private boolean jgy;
  private boolean jgz;
  
  static
  {
    AppMethodBeat.i(135248);
    jgA = new DynamicBackgroundGLSurfaceView.a((byte)0);
    AppMethodBeat.o(135248);
  }
  
  public DynamicBackgroundGLSurfaceView(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  public DynamicBackgroundGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(135247);
    setEGLContextClientVersion(2);
    aQc();
    setPreserveEGLContextOnPause(true);
    this.jgx = new DynamicBackgroundGLSurfaceView.b(paramContext);
    setRenderer((GameGLSurfaceView.n)this.jgx);
    getHolder().setFormat(-3);
    paramContext = this.jgx;
    if (paramContext != null)
    {
      paramAttributeSet = (GameGLSurfaceView)this;
      j.q(paramAttributeSet, "surfaceView");
      paramContext.jgH = paramAttributeSet;
      AppMethodBeat.o(135247);
      return;
    }
    AppMethodBeat.o(135247);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(135243);
    super.onAttachedToWindow();
    ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onAttachedToWindow");
    AppMethodBeat.o(135243);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(135240);
    super.onDetachedFromWindow();
    ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onDetachedFromWindow");
    AppMethodBeat.o(135240);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(135245);
    super.onResume();
    this.jgy = false;
    AppMethodBeat.o(135245);
  }
  
  protected final void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(135244);
    j.q(paramView, "changedView");
    super.onVisibilityChanged(paramView, paramInt);
    ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onVisibilityChanged: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 0) && (this.jgy))
    {
      ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo needPause");
      this.jgy = false;
    }
    AppMethodBeat.o(135244);
  }
  
  public final void setGradientBackgroundView(GradientColorBackgroundView paramGradientColorBackgroundView)
  {
    AppMethodBeat.i(135246);
    j.q(paramGradientColorBackgroundView, "gradientColorBackgroundView");
    DynamicBackgroundGLSurfaceView.b localb = this.jgx;
    if (localb != null)
    {
      j.q(paramGradientColorBackgroundView, "gradientColorBackgroundView");
      localb.jdq = paramGradientColorBackgroundView;
      AppMethodBeat.o(135246);
      return;
    }
    AppMethodBeat.o(135246);
  }
  
  public final void setShowGradientView(boolean paramBoolean)
  {
    this.jgz = paramBoolean;
    DynamicBackgroundGLSurfaceView.b localb = this.jgx;
    if (localb != null)
    {
      localb.jgz = paramBoolean;
      if (!localb.jgz) {
        localb.jgG = false;
      }
    }
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(135242);
    super.surfaceCreated(paramSurfaceHolder);
    ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo surfaceCreated");
    AppMethodBeat.o(135242);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(135241);
    super.surfaceDestroyed(paramSurfaceHolder);
    ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo surfaceDestroyed");
    paramSurfaceHolder = this.jgx;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.jgF = false;
      AppMethodBeat.o(135241);
      return;
    }
    AppMethodBeat.o(135241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */