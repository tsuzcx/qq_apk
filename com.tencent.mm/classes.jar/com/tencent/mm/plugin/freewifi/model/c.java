package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ao;

public final class c
{
  private ao sqf;
  
  public final ao cIW()
  {
    AppMethodBeat.i(24773);
    if (this.sqf == null) {
      this.sqf = new ao("FreeWifiHandlerThread_handlerThread");
    }
    ao localao = this.sqf;
    AppMethodBeat.o(24773);
    return localao;
  }
  
  public final void release()
  {
    AppMethodBeat.i(24774);
    if (this.sqf != null) {
      this.sqf.quit();
    }
    this.sqf = null;
    AppMethodBeat.o(24774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.c
 * JD-Core Version:    0.7.0.1
 */