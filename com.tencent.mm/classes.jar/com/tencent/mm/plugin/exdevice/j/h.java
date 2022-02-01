package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.f;
import com.tencent.mm.plugin.exdevice.service.m;

public final class h
  extends com.tencent.mm.plugin.exdevice.model.ae
{
  private f qgO;
  private a qnB;
  
  public h(f paramf)
  {
    this.qgO = paramf;
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23806);
    this.qnB = new a(this.qgO, paramd);
    boolean bool = this.qnB.b(paramm);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.MMSendDataToDeviceExcuter", "send data to devide : %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(23806);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.h
 * JD-Core Version:    0.7.0.1
 */