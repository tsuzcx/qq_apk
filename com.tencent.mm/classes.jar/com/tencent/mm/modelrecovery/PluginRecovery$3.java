package com.tencent.mm.modelrecovery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class PluginRecovery$3
  implements Runnable
{
  PluginRecovery$3(PluginRecovery paramPluginRecovery) {}
  
  public final void run()
  {
    AppMethodBeat.i(16527);
    ab.i("MicroMsg.Recovery.PluginRecovery", "postLog");
    a.aiR();
    AppMethodBeat.o(16527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery.3
 * JD-Core Version:    0.7.0.1
 */