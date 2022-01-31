package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

final class c$c
  implements Serializable
{
  long fAA = 0L;
  long fAB = 0L;
  long fAP = 0L;
  long fAu = 0L;
  long fAz = 0L;
  int pid = 0;
  
  c$c(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.pid = paramInt;
    this.fAu = paramLong1;
    this.fAP = paramLong2;
    this.fAz = paramLong3;
    this.fAA = paramLong4;
    this.fAB = paramLong5;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58340);
    String str = String.format("pid:%s, server time:%s, client time:%s, msg server time:%s, intervalTime:%s, msg server id:%s", new Object[] { Integer.valueOf(this.pid), a.gP(this.fAu), a.gP(this.fAP), a.gP(this.fAz), Long.valueOf(this.fAA), Long.valueOf(this.fAB) });
    AppMethodBeat.o(58340);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.c.c
 * JD-Core Version:    0.7.0.1
 */