package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.f;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
  extends ae
{
  private f lCH;
  private a lJv;
  
  public h(f paramf)
  {
    this.lCH = paramf;
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(19738);
    this.lJv = new a(this.lCH, paramd);
    boolean bool = this.lJv.b(paramm);
    ab.i("MicroMsg.exdevice.MMSendDataToDeviceExcuter", "send data to devide : %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(19738);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.h
 * JD-Core Version:    0.7.0.1
 */