package android.support.v7.widget;

import android.animation.ValueAnimator;

final class z$1
  implements Runnable
{
  z$1(z paramz) {}
  
  public final void run()
  {
    z localz = this.adB;
    switch (localz.adz)
    {
    default: 
      return;
    case 1: 
      localz.ady.cancel();
    }
    localz.adz = 3;
    localz.ady.setFloatValues(new float[] { ((Float)localz.ady.getAnimatedValue()).floatValue(), 0.0F });
    localz.ady.setDuration(500L);
    localz.ady.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.z.1
 * JD-Core Version:    0.7.0.1
 */