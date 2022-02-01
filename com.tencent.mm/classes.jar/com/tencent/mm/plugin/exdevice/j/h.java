package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.f;
import com.tencent.mm.plugin.exdevice.model.ai;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends ai
{
  private f ypd;
  private a ywq;
  
  public h(f paramf)
  {
    this.ypd = paramf;
  }
  
  public final boolean a(m paramm, d paramd)
  {
    AppMethodBeat.i(23806);
    this.ywq = new a(this.ypd, paramd);
    boolean bool = this.ywq.b(paramm);
    Log.i("MicroMsg.exdevice.MMSendDataToDeviceExcuter", "send data to devide : %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(23806);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.h
 * JD-Core Version:    0.7.0.1
 */