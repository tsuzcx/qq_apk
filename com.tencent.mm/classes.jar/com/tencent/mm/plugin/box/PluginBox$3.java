package com.tencent.mm.plugin.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class PluginBox$3
  implements Runnable
{
  PluginBox$3(PluginBox paramPluginBox, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(250474);
    try
    {
      if (c.aoZ(this.val$path) == 0)
      {
        c.ls(true);
        c.aoU(c.lt(false));
      }
      AppMethodBeat.o(250474);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Box.PluginBox", localException, "[updateWordBankRes]", new Object[0]);
      AppMethodBeat.o(250474);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.box.PluginBox.3
 * JD-Core Version:    0.7.0.1
 */