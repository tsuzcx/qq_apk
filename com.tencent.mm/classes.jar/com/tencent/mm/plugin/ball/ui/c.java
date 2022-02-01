package com.tencent.mm.plugin.ball.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.a.f.b;
import com.tencent.mm.plugin.ball.d.a;
import com.tencent.mm.plugin.ball.view.e.1;
import com.tencent.mm.plugin.ball.view.e.2;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;

public final class c
{
  public static void a(final f paramf, final Point paramPoint, final float paramFloat, a parama)
  {
    AppMethodBeat.i(106302);
    bd.aI(aj.getContext(), 2131766133);
    if (paramf.bgM())
    {
      paramf.a(new f.b()
      {
        public final void iK(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(106296);
          if (!paramAnonymousBoolean)
          {
            ad.i("MicroMsg.FloatBallSwipeTransformationHelper", "doTransform, convertToTranslucent not complete");
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(106294);
                if (c.1.this.nHB != null) {
                  c.1.this.nHB.bgH();
                }
                AppMethodBeat.o(106294);
              }
            });
            AppMethodBeat.o(106296);
            return;
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(106295);
              if (c.1.this.nHC != null)
              {
                Object localObject2 = c.1.this.nHD;
                Object localObject3 = c.1.this.nHC;
                float f = c.1.this.nHE;
                a locala = c.1.this.nHB;
                ad.i("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, ballPos(x:%d, y:%d), lastSwipePosX:%f", new Object[] { Integer.valueOf(((Point)localObject3).x), Integer.valueOf(((Point)localObject3).y), Float.valueOf(f) });
                if (((f)localObject2).getMaskView() == null)
                {
                  ad.w("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, page mask view is null");
                  locala.bgH();
                  AppMethodBeat.o(106295);
                  return;
                }
                if (((f)localObject2).getContentView() == null)
                {
                  ad.w("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, page content view is null");
                  locala.bgH();
                  AppMethodBeat.o(106295);
                  return;
                }
                if (((f)localObject2).bJP() == null)
                {
                  ad.w("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, page root view is null");
                  locala.bgH();
                  AppMethodBeat.o(106295);
                  return;
                }
                Object localObject1 = ((f)localObject2).getBitmap();
                if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled()) || (((Bitmap)localObject1).getWidth() == 0) || (((Bitmap)localObject1).getHeight() == 0))
                {
                  ad.w("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, page get bitmap is null");
                  locala.bgH();
                  AppMethodBeat.o(106295);
                  return;
                }
                localObject1 = new com.tencent.mm.plugin.ball.view.e(((f)localObject2).getActivity(), (Bitmap)localObject1);
                ((com.tencent.mm.plugin.ball.view.e)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                int i = ((Point)localObject3).x;
                int j = ((Point)localObject3).y;
                int k = com.tencent.mm.plugin.ball.f.e.nIm / 2;
                ((com.tencent.mm.plugin.ball.view.e)localObject1).nMB = i;
                ((com.tencent.mm.plugin.ball.view.e)localObject1).nMC = j;
                ((com.tencent.mm.plugin.ball.view.e)localObject1).nMA = k;
                ((com.tencent.mm.plugin.ball.view.e)localObject1).setContentStartPosX((int)f);
                ((com.tencent.mm.plugin.ball.view.e)localObject1).setListener(new c.3((com.tencent.mm.plugin.ball.view.e)localObject1, locala, (f)localObject2));
                localObject3 = ((f)localObject2).bJP();
                ((ViewGroup)localObject3).addView((View)localObject1, ((ViewGroup)localObject3).getChildCount());
                ((f)localObject2).getContentView().setVisibility(8);
                localObject2 = new LinearInterpolator();
                boolean bool;
                if (((com.tencent.mm.plugin.ball.view.e)localObject1).nMD > 0)
                {
                  bool = true;
                  ((com.tencent.mm.plugin.ball.view.e)localObject1).nME = bool;
                  if (((com.tencent.mm.plugin.ball.view.e)localObject1).nMD >= ((com.tencent.mm.plugin.ball.view.e)localObject1).nMB) {
                    break label678;
                  }
                  i = ((com.tencent.mm.plugin.ball.view.e)localObject1).nMD;
                  label412:
                  localObject3 = PropertyValuesHolder.ofInt("canvasTranslationX", new int[] { ((com.tencent.mm.plugin.ball.view.e)localObject1).nMD, i });
                  i = ((com.tencent.mm.plugin.ball.view.e)localObject1).nMB;
                  if (((com.tencent.mm.plugin.ball.view.e)localObject1).nME) {
                    if (((com.tencent.mm.plugin.ball.view.e)localObject1).nMD >= ((com.tencent.mm.plugin.ball.view.e)localObject1).nMB) {
                      break label687;
                    }
                  }
                }
                label678:
                label687:
                for (i = ((com.tencent.mm.plugin.ball.view.e)localObject1).nMB - ((com.tencent.mm.plugin.ball.view.e)localObject1).nMD;; i = 0)
                {
                  localObject3 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("translationX", new int[] { 0, i }), PropertyValuesHolder.ofInt("translationY", new int[] { 0, ((com.tencent.mm.plugin.ball.view.e)localObject1).nMC }), PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 2.0F * ((com.tencent.mm.plugin.ball.view.e)localObject1).nMA / ((com.tencent.mm.plugin.ball.view.e)localObject1).mWidth }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 2.0F * ((com.tencent.mm.plugin.ball.view.e)localObject1).nMA / ((com.tencent.mm.plugin.ball.view.e)localObject1).mHeight }), localObject3, PropertyValuesHolder.ofInt("bgAlpha", new int[] { 255, 0 }) });
                  ((ValueAnimator)localObject3).setDuration(300L);
                  ((ValueAnimator)localObject3).setInterpolator((TimeInterpolator)localObject2);
                  ((ValueAnimator)localObject3).addUpdateListener(new e.1((com.tencent.mm.plugin.ball.view.e)localObject1));
                  ((ValueAnimator)localObject3).addListener(new e.2((com.tencent.mm.plugin.ball.view.e)localObject1));
                  ((ValueAnimator)localObject3).start();
                  AppMethodBeat.o(106295);
                  return;
                  bool = false;
                  break;
                  i = ((com.tencent.mm.plugin.ball.view.e)localObject1).nMB;
                  break label412;
                }
              }
              if (c.1.this.nHB != null) {
                c.1.this.nHB.bgH();
              }
              AppMethodBeat.o(106295);
            }
          });
          AppMethodBeat.o(106296);
        }
      });
      AppMethodBeat.o(106302);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(106297);
        if (this.nHB != null) {
          this.nHB.bgH();
        }
        AppMethodBeat.o(106297);
      }
    });
    AppMethodBeat.o(106302);
  }
  
  public static void a(f paramf, Point paramPoint, a parama)
  {
    AppMethodBeat.i(106301);
    a(paramf, paramPoint, -1.0F, parama);
    AppMethodBeat.o(106301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.c
 * JD-Core Version:    0.7.0.1
 */