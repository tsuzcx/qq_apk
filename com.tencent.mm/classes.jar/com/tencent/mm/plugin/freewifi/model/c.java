package com.tencent.mm.plugin.freewifi.model;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak;

public final class c
{
  private HandlerThread mKh;
  private ak mKi;
  
  public final ak bAw()
  {
    AppMethodBeat.i(20696);
    if (this.mKh == null)
    {
      this.mKh = d.aqu("FreeWifiHandlerThread_handlerThread");
      this.mKh.start();
    }
    if (this.mKi == null) {
      this.mKi = new ak(this.mKh.getLooper());
    }
    ak localak = this.mKi;
    AppMethodBeat.o(20696);
    return localak;
  }
  
  public final void release()
  {
    AppMethodBeat.i(20697);
    if (this.mKh != null)
    {
      this.mKh.quit();
      this.mKh = null;
    }
    this.mKi = null;
    AppMethodBeat.o(20697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.c
 * JD-Core Version:    0.7.0.1
 */