package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class c
{
  private MMHandler wOE;
  
  public final MMHandler dMZ()
  {
    AppMethodBeat.i(24773);
    if (this.wOE == null) {
      this.wOE = new MMHandler("FreeWifiHandlerThread_handlerThread");
    }
    MMHandler localMMHandler = this.wOE;
    AppMethodBeat.o(24773);
    return localMMHandler;
  }
  
  public final void release()
  {
    AppMethodBeat.i(24774);
    if (this.wOE != null) {
      this.wOE.quit();
    }
    this.wOE = null;
    AppMethodBeat.o(24774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.c
 * JD-Core Version:    0.7.0.1
 */