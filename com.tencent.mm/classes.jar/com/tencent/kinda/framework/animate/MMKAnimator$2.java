package com.tencent.kinda.framework.animate;

import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMKAnimator$2
  implements Runnable
{
  MMKAnimator$2(MMKAnimator paramMMKAnimator, VoidCallback paramVoidCallback) {}
  
  public void run()
  {
    AppMethodBeat.i(144303);
    if (this.val$animation != null) {
      this.val$animation.call();
    }
    AppMethodBeat.o(144303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.MMKAnimator.2
 * JD-Core Version:    0.7.0.1
 */