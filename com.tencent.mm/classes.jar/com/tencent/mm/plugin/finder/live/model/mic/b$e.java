package com.tencent.mm.plugin.finder.live.model.mic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/mic/LinkMicTimeoutTimer$applyPkMicTimeoutTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$e
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(359689);
    Object localObject = b.enl();
    if (localObject != null)
    {
      localObject = (a)((WeakReference)localObject).get();
      if (localObject != null) {
        ((a)localObject).onApplyMicPkTimeout();
      }
    }
    AppMethodBeat.o(359689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.mic.b.e
 * JD-Core Version:    0.7.0.1
 */