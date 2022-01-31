package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.sdk.platformtools.ab;

final class d$11
  extends c.a
{
  d$11(d paramd)
  {
    super(0);
  }
  
  public final void onServiceConnected()
  {
    AppMethodBeat.i(19109);
    ab.d("MicroMsg.exdevice.ExdeviceConnectManager", "onServiceConnected");
    AppMethodBeat.o(19109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.11
 * JD-Core Version:    0.7.0.1
 */