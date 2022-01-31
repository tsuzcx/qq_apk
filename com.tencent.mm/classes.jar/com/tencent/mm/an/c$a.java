package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

final class c$a
  implements Serializable
{
  long fAu = 0L;
  long time = 0L;
  int type = 0;
  
  c$a(long paramLong1, long paramLong2, int paramInt)
  {
    this.fAu = paramLong1;
    this.time = paramLong2;
    this.type = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58338);
    String str = String.format("serverTime:%s,time:%s,type:%s", new Object[] { a.gP(this.fAu), a.gP(this.time), Integer.valueOf(this.type) });
    AppMethodBeat.o(58338);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.an.c.a
 * JD-Core Version:    0.7.0.1
 */