package com.tencent.kinda.framework.animate;

import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMKAnimator$3
  implements Runnable
{
  MMKAnimator$3(MMKAnimator paramMMKAnimator, VoidCallback paramVoidCallback) {}
  
  public void run()
  {
    AppMethodBeat.i(144304);
    if (this.val$completion != null) {
      this.val$completion.call();
    }
    AppMethodBeat.o(144304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.MMKAnimator.3
 * JD-Core Version:    0.7.0.1
 */