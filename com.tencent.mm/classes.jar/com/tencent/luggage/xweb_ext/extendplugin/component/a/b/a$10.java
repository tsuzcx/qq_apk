package com.tencent.luggage.xweb_ext.extendplugin.component.a.b;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.TXLivePusher;

final class a$10
  implements ScaleGestureDetector.OnScaleGestureListener
{
  a$10(a parama) {}
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f2 = 0.9F;
    AppMethodBeat.i(154404);
    b localb = this.bGK.bGz;
    int j;
    float f3;
    float f1;
    label86:
    int k;
    int i;
    if (localb.bGQ != null)
    {
      j = localb.bGQ.getMaxZoom();
      if (j > 0)
      {
        f3 = paramScaleGestureDetector.getScaleFactor();
        if (f3 <= 1.0F) {
          break label288;
        }
        f2 = 0.2F / j * (j - this.bGK.mCurrentScale) + 1.0F;
        f1 = f2;
        if (f2 <= 1.1F) {
          f1 = 1.1F;
        }
        k = Math.round(this.bGK.mCurrentScale * f1);
        i = k;
        if (k == this.bGK.mCurrentScale)
        {
          if (f1 <= 1.0F) {
            break label333;
          }
          i = k + 1;
        }
        label129:
        k = i;
        if (i >= j) {
          k = j;
        }
        i = k;
        if (k <= 1) {
          i = 1;
        }
        if (f1 <= 1.0F) {
          break label352;
        }
        if (i >= this.bGK.mCurrentScale) {
          break label382;
        }
        i = this.bGK.mCurrentScale;
      }
    }
    label288:
    label333:
    label352:
    label382:
    for (;;)
    {
      this.bGK.mCurrentScale = i;
      if (this.bGK.bGz != null)
      {
        ab.i(this.bGK.xo(), "onScale, maxZoom:%s, current scale:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(this.bGK.mCurrentScale) });
        paramScaleGestureDetector = this.bGK.bGz;
        i = this.bGK.mCurrentScale;
        paramScaleGestureDetector.bGQ.setZoom(i);
        new com.tencent.luggage.xweb_ext.extendplugin.component.a.a();
      }
      AppMethodBeat.o(154404);
      return false;
      j = 0;
      break;
      f1 = f3;
      if (f3 < 1.0F)
      {
        f3 = 1.0F - 0.2F / j * this.bGK.mCurrentScale;
        f1 = f2;
        if (f3 >= 0.9F) {
          break label86;
        }
        f1 = f3;
      }
      break label86;
      i = k;
      if (f1 >= 1.0F) {
        break label129;
      }
      i = k - 1;
      break label129;
      if ((f1 < 1.0F) && (i > this.bGK.mCurrentScale)) {
        i = this.bGK.mCurrentScale;
      }
    }
  }
  
  public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.10
 * JD-Core Version:    0.7.0.1
 */