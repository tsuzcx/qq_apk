package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.c.a;

final class d$6
  extends c.a
{
  d$6(d paramd, int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    super(paramInt);
  }
  
  public final void onServiceConnected()
  {
    AppMethodBeat.i(19104);
    d.a(this.lDd).lIv = null;
    this.lDd.c(this.lDj, this.lDk, this.crZ, this.lDl);
    AppMethodBeat.o(19104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.6
 * JD-Core Version:    0.7.0.1
 */