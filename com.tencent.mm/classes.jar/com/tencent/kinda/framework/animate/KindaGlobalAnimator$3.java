package com.tencent.kinda.framework.animate;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class KindaGlobalAnimator$3
  implements Runnable
{
  KindaGlobalAnimator$3(long paramLong, Runnable paramRunnable1, Runnable paramRunnable2) {}
  
  public final void run()
  {
    AppMethodBeat.i(144294);
    if ((this.val$duration > 0L) && (this.val$run != null))
    {
      KindaGlobalAnimator.access$000(this.val$duration, this.val$complete);
      this.val$run.run();
      KindaGlobalAnimator.access$100();
      if (KindaGlobalAnimator.access$200() != null)
      {
        KindaGlobalAnimator.access$200().run();
        KindaGlobalAnimator.access$202(null);
      }
    }
    AppMethodBeat.o(144294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaGlobalAnimator.3
 * JD-Core Version:    0.7.0.1
 */