package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.f;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends ae
{
  private a rEI;
  private f rxK;
  
  public h(f paramf)
  {
    this.rxK = paramf;
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23806);
    this.rEI = new a(this.rxK, paramd);
    boolean bool = this.rEI.b(paramm);
    Log.i("MicroMsg.exdevice.MMSendDataToDeviceExcuter", "send data to devide : %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(23806);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.h
 * JD-Core Version:    0.7.0.1
 */