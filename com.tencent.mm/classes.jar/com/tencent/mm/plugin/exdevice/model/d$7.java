package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.c.a;

final class d$7
  extends c.a
{
  d$7(d paramd, int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    super(paramInt);
  }
  
  public final void onServiceConnected()
  {
    AppMethodBeat.i(19105);
    d.a(this.lDd).lIv = null;
    this.lDd.c(this.lDj, this.lDk, this.crZ, this.lDl);
    AppMethodBeat.o(19105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.7
 * JD-Core Version:    0.7.0.1
 */