package com.tencent.mm.dynamicbackground.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 11}, fNZ={""}, fOa={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mRenderer", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer;", "needPause", "", "showGradientView", "onAttachedToWindow", "", "onDetachedFromWindow", "onResume", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "release", "setColor", "particleColor1", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "surfaceCreated", "holder", "Landroid/view/SurfaceHolder;", "surfaceDestroyed", "Companion", "GLRenderer", "dynamicbg_release"})
public final class DynamicBackgroundGLSurfaceView
  extends GameGLSurfaceView
{
  public static final DynamicBackgroundGLSurfaceView.a fMp;
  public DynamicBackgroundGLSurfaceView.b fMm;
  private boolean fMn;
  private boolean fMo;
  
  static
  {
    AppMethodBeat.i(103118);
    fMp = new DynamicBackgroundGLSurfaceView.a((byte)0);
    AppMethodBeat.o(103118);
  }
  
  public DynamicBackgroundGLSurfaceView(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  public DynamicBackgroundGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103117);
    setEGLContextClientVersion(2);
    abz();
    setPreserveEGLContextOnPause(true);
    this.fMm = new DynamicBackgroundGLSurfaceView.b(paramContext);
    setRenderer((GameGLSurfaceView.n)this.fMm);
    getHolder().setFormat(-3);
    paramContext = this.fMm;
    if (paramContext != null)
    {
      paramAttributeSet = (GameGLSurfaceView)this;
      k.h(paramAttributeSet, "surfaceView");
      paramContext.fMy = paramAttributeSet;
      AppMethodBeat.o(103117);
      return;
    }
    AppMethodBeat.o(103117);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(103113);
    super.onAttachedToWindow();
    c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onAttachedToWindow", new Object[0]);
    AppMethodBeat.o(103113);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(103110);
    super.onDetachedFromWindow();
    c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onDetachedFromWindow", new Object[0]);
    AppMethodBeat.o(103110);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(103115);
    super.onResume();
    this.fMn = false;
    AppMethodBeat.o(103115);
  }
  
  protected final void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(103114);
    k.h(paramView, "changedView");
    super.onVisibilityChanged(paramView, paramInt);
    c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onVisibilityChanged: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 0) && (this.fMn))
    {
      c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo needPause", new Object[0]);
      this.fMn = false;
    }
    AppMethodBeat.o(103114);
  }
  
  public final void setGradientBackgroundView(View paramView)
  {
    AppMethodBeat.i(103116);
    k.h(paramView, "gradientColorBackgroundView");
    DynamicBackgroundGLSurfaceView.b localb = this.fMm;
    if (localb != null)
    {
      k.h(paramView, "gradientColorBackgroundView");
      localb.fMv = paramView;
      AppMethodBeat.o(103116);
      return;
    }
    AppMethodBeat.o(103116);
  }
  
  public final void setShowGradientView(boolean paramBoolean)
  {
    this.fMo = paramBoolean;
    DynamicBackgroundGLSurfaceView.b localb = this.fMm;
    if (localb != null)
    {
      localb.fMo = paramBoolean;
      if (!localb.fMo) {
        localb.fMx = false;
      }
    }
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(103112);
    super.surfaceCreated(paramSurfaceHolder);
    c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo surfaceCreated", new Object[0]);
    AppMethodBeat.o(103112);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(103111);
    super.surfaceDestroyed(paramSurfaceHolder);
    c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo surfaceDestroyed", new Object[0]);
    paramSurfaceHolder = this.fMm;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.fMw = false;
      AppMethodBeat.o(103111);
      return;
    }
    AppMethodBeat.o(103111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */