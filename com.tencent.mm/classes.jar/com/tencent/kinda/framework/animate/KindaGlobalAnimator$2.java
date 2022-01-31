package com.tencent.kinda.framework.animate;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class KindaGlobalAnimator$2
  implements Runnable
{
  KindaGlobalAnimator$2(long paramLong, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(144293);
    if ((this.val$duration > 0L) && (this.val$run != null))
    {
      KindaGlobalAnimator.access$000(this.val$duration, null);
      this.val$run.run();
      KindaGlobalAnimator.access$100();
    }
    AppMethodBeat.o(144293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaGlobalAnimator.2
 * JD-Core Version:    0.7.0.1
 */