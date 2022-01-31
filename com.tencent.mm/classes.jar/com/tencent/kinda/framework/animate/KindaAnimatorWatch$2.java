package com.tencent.kinda.framework.animate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class KindaAnimatorWatch$2
  implements Runnable
{
  KindaAnimatorWatch$2(int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(144286);
    if (KindaAnimatorWatch.access$000().containsKey(Integer.valueOf(this.val$hash_code))) {
      KindaAnimatorWatch.access$000().remove(Integer.valueOf(this.val$hash_code));
    }
    AppMethodBeat.o(144286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.animate.KindaAnimatorWatch.2
 * JD-Core Version:    0.7.0.1
 */