package com.tencent.mm.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.d;
import com.tencent.mm.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ListIterator;

public final class c$1
  implements ValueAnimator.AnimatorUpdateListener
{
  public c$1(c paramc) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(116141);
    float f1 = ((Float)paramValueAnimator.getAnimatedValue("deltaY")).floatValue();
    float f2 = ((Float)paramValueAnimator.getAnimatedValue("deltaX")).floatValue();
    ab.d("MicroMsg.StickBackAnim", "animatorValueY:%s  %s", new Object[] { Float.valueOf(f1), Float.valueOf(f1 - this.bVJ.bVH) });
    paramValueAnimator = this.bVJ.bVE;
    float f3 = this.bVJ.bVI;
    float f4 = this.bVJ.bVH;
    String str = this.bVJ.bVG;
    Object localObject = (d)paramValueAnimator.CB();
    if (localObject == null) {
      ab.w("MicroMsg.EmojiAndTextArtist", "cache is null!");
    }
    for (;;)
    {
      this.bVJ.bVH = f1;
      this.bVJ.bVI = f2;
      AppMethodBeat.o(116141);
      return;
      localObject = ((d)localObject).Jk();
      if (((ListIterator)localObject).hasPrevious())
      {
        com.tencent.mm.y.c localc = (com.tencent.mm.y.c)((ListIterator)localObject).previous();
        if (!localc.eFp.equals(str)) {
          break;
        }
        localc.eFs.offset(f2 - f3, f1 - f4);
        paramValueAnimator.CI();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.b.c.1
 * JD-Core Version:    0.7.0.1
 */