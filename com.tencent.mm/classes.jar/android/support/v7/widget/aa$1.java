package android.support.v7.widget;

import android.animation.ValueAnimator;

final class aa$1
  implements Runnable
{
  aa$1(aa paramaa) {}
  
  public final void run()
  {
    aa localaa = this.acR;
    switch (localaa.acO)
    {
    default: 
      return;
    case 1: 
      localaa.acN.cancel();
    }
    localaa.acO = 3;
    localaa.acN.setFloatValues(new float[] { ((Float)localaa.acN.getAnimatedValue()).floatValue(), 0.0F });
    localaa.acN.setDuration(500L);
    localaa.acN.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.aa.1
 * JD-Core Version:    0.7.0.1
 */