package com.tencent.mm.modelrecovery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class PluginRecovery$4
  implements Runnable
{
  PluginRecovery$4(PluginRecovery paramPluginRecovery) {}
  
  public final void run()
  {
    AppMethodBeat.i(16528);
    ab.i("MicroMsg.Recovery.PluginRecovery", "postReport");
    b.aiS();
    AppMethodBeat.o(16528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.PluginRecovery.4
 * JD-Core Version:    0.7.0.1
 */