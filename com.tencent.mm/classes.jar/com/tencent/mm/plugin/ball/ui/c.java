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
import com.tencent.mm.plugin.ball.f.e;
import com.tencent.mm.plugin.ball.view.d;
import com.tencent.mm.plugin.ball.view.d.1;
import com.tencent.mm.plugin.ball.view.d.2;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;

public final class c
{
  public static void a(final f paramf, final Point paramPoint, final float paramFloat, a parama)
  {
    AppMethodBeat.i(106302);
    bd.az(aj.getContext(), 2131766133);
    if (paramf.aWk())
    {
      paramf.a(new f.b()
      {
        public final void ib(boolean paramAnonymousBoolean)
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
                if (c.1.this.mFa != null) {
                  c.1.this.mFa.aWf();
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
              if (c.1.this.mFb != null)
              {
                Object localObject2 = c.1.this.mFc;
                Object localObject3 = c.1.this.mFb;
                float f = c.1.this.mFd;
                a locala = c.1.this.mFa;
                ad.i("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, ballPos(x:%d, y:%d), lastSwipePosX:%f", new Object[] { Integer.valueOf(((Point)localObject3).x), Integer.valueOf(((Point)localObject3).y), Float.valueOf(f) });
                if (((f)localObject2).getMaskView() == null)
                {
                  ad.w("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, page mask view is null");
                  locala.aWf();
                  AppMethodBeat.o(106295);
                  return;
                }
                if (((f)localObject2).getContentView() == null)
                {
                  ad.w("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, page content view is null");
                  locala.aWf();
                  AppMethodBeat.o(106295);
                  return;
                }
                if (((f)localObject2).byJ() == null)
                {
                  ad.w("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, page root view is null");
                  locala.aWf();
                  AppMethodBeat.o(106295);
                  return;
                }
                Object localObject1 = ((f)localObject2).getBitmap();
                if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled()) || (((Bitmap)localObject1).getWidth() == 0) || (((Bitmap)localObject1).getHeight() == 0))
                {
                  ad.w("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, page get bitmap is null");
                  locala.aWf();
                  AppMethodBeat.o(106295);
                  return;
                }
                localObject1 = new d(((f)localObject2).getActivity(), (Bitmap)localObject1);
                ((d)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                int i = ((Point)localObject3).x;
                int j = ((Point)localObject3).y;
                int k = e.mFL / 2;
                ((d)localObject1).mJL = i;
                ((d)localObject1).mJM = j;
                ((d)localObject1).mJK = k;
                ((d)localObject1).setContentStartPosX((int)f);
                ((d)localObject1).setListener(new c.3((d)localObject1, locala, (f)localObject2));
                localObject3 = ((f)localObject2).byJ();
                ((ViewGroup)localObject3).addView((View)localObject1, ((ViewGroup)localObject3).getChildCount());
                ((f)localObject2).getContentView().setVisibility(8);
                localObject2 = new LinearInterpolator();
                boolean bool;
                if (((d)localObject1).mJN > 0)
                {
                  bool = true;
                  ((d)localObject1).mJO = bool;
                  if (((d)localObject1).mJN >= ((d)localObject1).mJL) {
                    break label678;
                  }
                  i = ((d)localObject1).mJN;
                  label412:
                  localObject3 = PropertyValuesHolder.ofInt("canvasTranslationX", new int[] { ((d)localObject1).mJN, i });
                  i = ((d)localObject1).mJL;
                  if (((d)localObject1).mJO) {
                    if (((d)localObject1).mJN >= ((d)localObject1).mJL) {
                      break label687;
                    }
                  }
                }
                label678:
                label687:
                for (i = ((d)localObject1).mJL - ((d)localObject1).mJN;; i = 0)
                {
                  localObject3 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("translationX", new int[] { 0, i }), PropertyValuesHolder.ofInt("translationY", new int[] { 0, ((d)localObject1).mJM }), PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 2.0F * ((d)localObject1).mJK / ((d)localObject1).mWidth }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 2.0F * ((d)localObject1).mJK / ((d)localObject1).mHeight }), localObject3, PropertyValuesHolder.ofInt("bgAlpha", new int[] { 255, 0 }) });
                  ((ValueAnimator)localObject3).setDuration(300L);
                  ((ValueAnimator)localObject3).setInterpolator((TimeInterpolator)localObject2);
                  ((ValueAnimator)localObject3).addUpdateListener(new d.1((d)localObject1));
                  ((ValueAnimator)localObject3).addListener(new d.2((d)localObject1));
                  ((ValueAnimator)localObject3).start();
                  AppMethodBeat.o(106295);
                  return;
                  bool = false;
                  break;
                  i = ((d)localObject1).mJL;
                  break label412;
                }
              }
              if (c.1.this.mFa != null) {
                c.1.this.mFa.aWf();
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
        if (this.mFa != null) {
          this.mFa.aWf();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.c
 * JD-Core Version:    0.7.0.1
 */