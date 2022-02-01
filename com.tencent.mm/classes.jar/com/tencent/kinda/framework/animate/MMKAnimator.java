package com.tencent.kinda.framework.animate;

import com.tencent.kinda.gen.KindaAnimator;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMKAnimator
  implements KindaAnimator
{
  public void startAnimationImpl(float paramFloat, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(18340);
    KindaGlobalAnimator.startAnimate((1000.0F * paramFloat), new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18337);
        if (paramVoidCallback != null) {
          paramVoidCallback.call();
        }
        AppMethodBeat.o(18337);
      }
    });
    AppMethodBeat.o(18340);
  }
  
  public void startAnimationImpl(float paramFloat, final VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(18341);
    KindaGlobalAnimator.startAnimate((1000.0F * paramFloat), new Runnable()new Runnable
    {
      public void run()
      {
        AppMethodBeat.i(18338);
        if (paramVoidCallback1 != null) {
          paramVoidCallback1.call();
        }
        AppMethodBeat.o(18338);
      }
    }, new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18339);
        if (paramVoidCallback2 != null) {
          paramVoidCallback2.call();
        }
        AppMethodBeat.o(18339);
      }
    });
    AppMethodBeat.o(18341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.MMKAnimator
 * JD-Core Version:    0.7.0.1
 */