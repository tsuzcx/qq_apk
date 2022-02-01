package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

public final class c
{
  private ap rhn;
  
  public final ap cvK()
  {
    AppMethodBeat.i(24773);
    if (this.rhn == null) {
      this.rhn = new ap("FreeWifiHandlerThread_handlerThread");
    }
    ap localap = this.rhn;
    AppMethodBeat.o(24773);
    return localap;
  }
  
  public final void release()
  {
    AppMethodBeat.i(24774);
    if (this.rhn != null) {
      this.rhn.quit();
    }
    this.rhn = null;
    AppMethodBeat.o(24774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.c
 * JD-Core Version:    0.7.0.1
 */