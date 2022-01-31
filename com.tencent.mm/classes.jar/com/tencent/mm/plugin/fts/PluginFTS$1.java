package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class PluginFTS$1
  implements Runnable
{
  PluginFTS$1(PluginFTS paramPluginFTS) {}
  
  public final void run()
  {
    AppMethodBeat.i(136579);
    if (PluginFTS.access$100(this.mQm) != null) {
      PluginFTS.access$100(this.mQm).rollback();
    }
    AppMethodBeat.o(136579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.1
 * JD-Core Version:    0.7.0.1
 */