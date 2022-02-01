package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.f;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends ae
{
  private f oTt;
  private a pag;
  
  public h(f paramf)
  {
    this.oTt = paramf;
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23806);
    this.pag = new a(this.oTt, paramd);
    boolean bool = this.pag.b(paramm);
    ad.i("MicroMsg.exdevice.MMSendDataToDeviceExcuter", "send data to devide : %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(23806);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.h
 * JD-Core Version:    0.7.0.1
 */