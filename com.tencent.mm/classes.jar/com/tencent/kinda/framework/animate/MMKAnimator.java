package com.tencent.kinda.framework.animate;

import com.tencent.kinda.gen.KindaAnimator;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMKAnimator
  implements KindaAnimator
{
  public void startAnimationImpl(float paramFloat, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(144305);
    KindaGlobalAnimator.startAnimate((1000.0F * paramFloat), new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(144302);
        if (paramVoidCallback != null) {
          paramVoidCallback.call();
        }
        AppMethodBeat.o(144302);
      }
    });
    AppMethodBeat.o(144305);
  }
  
  public void startAnimationImpl(float paramFloat, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(144306);
    KindaGlobalAnimator.startAnimate((1000.0F * paramFloat), new MMKAnimator.2(this, paramVoidCallback1), new MMKAnimator.3(this, paramVoidCallback2));
    AppMethodBeat.o(144306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.MMKAnimator
 * JD-Core Version:    0.7.0.1
 */