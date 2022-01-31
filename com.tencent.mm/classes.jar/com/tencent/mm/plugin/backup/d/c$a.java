package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$a
{
  byte[] buf;
  int fQD;
  boolean idE;
  int type;
  
  c$a(c paramc, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(17259);
    this.idE = false;
    this.fQD = paramInt1;
    this.type = paramInt2;
    this.buf = ((byte[])paramArrayOfByte.clone());
    AppMethodBeat.o(17259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.a
 * JD-Core Version:    0.7.0.1
 */