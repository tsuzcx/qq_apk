package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import a.l;
import android.animation.Animator.AnimatorListener;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class DynamicBackgroundGLSurfaceView$b$b
  implements Runnable
{
  DynamicBackgroundGLSurfaceView$b$b(DynamicBackgroundGLSurfaceView.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(135226);
    Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.jgM);
    if (localObject != null)
    {
      if ((((GradientColorBackgroundView)localObject).getVisibility() == 0) && (!this.jgM.jgF))
      {
        localObject = DynamicBackgroundGLSurfaceView.b.b(this.jgM);
        if (localObject != null) {
          ((GameGLSurfaceView)localObject).setVisibility(0);
        }
        this.jgM.jgF = true;
        localObject = DynamicBackgroundGLSurfaceView.b.a(this.jgM);
        if (localObject != null) {
          ((GradientColorBackgroundView)localObject).setAlpha(1.0F);
        }
        ab.d("MicroMsg.DynamicBgSurfaceView", "alvinluo GradientColorBackgroundView do alpha animation");
        localObject = DynamicBackgroundGLSurfaceView.b.a(this.jgM);
        if (localObject != null)
        {
          localObject = ((GradientColorBackgroundView)localObject).animate();
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setDuration(DynamicBackgroundGLSurfaceView.b.aPN());
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new DynamicBackgroundGLSurfaceView.b.b.1(this));
                if (localObject != null)
                {
                  ((ViewPropertyAnimator)localObject).start();
                  AppMethodBeat.o(135226);
                }
              }
            }
          }
        }
      }
    }
    else
    {
      AppMethodBeat.o(135226);
      return;
    }
    AppMethodBeat.o(135226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView.b.b
 * JD-Core Version:    0.7.0.1
 */