package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;

public final class c
{
  private aq txA;
  
  public final aq cTQ()
  {
    AppMethodBeat.i(24773);
    if (this.txA == null) {
      this.txA = new aq("FreeWifiHandlerThread_handlerThread");
    }
    aq localaq = this.txA;
    AppMethodBeat.o(24773);
    return localaq;
  }
  
  public final void release()
  {
    AppMethodBeat.i(24774);
    if (this.txA != null) {
      this.txA.quit();
    }
    this.txA = null;
    AppMethodBeat.o(24774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.c
 * JD-Core Version:    0.7.0.1
 */