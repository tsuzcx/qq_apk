package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.d;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class ah
  extends i
{
  public final void Wa()
  {
    AppMethodBeat.i(160135);
    Log.i("MicroMsg.ToolsProcessBootStep", "installPlugins()");
    if (MMApplicationContext.isToolsProcess()) {
      x.gmG();
    }
    d.a(null);
    super.Wa();
    AppMethodBeat.o(160135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.ah
 * JD-Core Version:    0.7.0.1
 */