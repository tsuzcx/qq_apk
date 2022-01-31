package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import java.io.Serializable;

public final class c$d
  implements Serializable
{
  long endTime = 0L;
  long fAQ = 0L;
  int fAv = 0;
  boolean fAw = true;
  boolean fAx = false;
  int pid = 0;
  long startTime = 0L;
  
  static d c(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(58342);
    d locald = new d();
    locald.pid = paramInt1;
    locald.startTime = paramLong1;
    locald.endTime = paramLong2;
    locald.fAv = paramInt2;
    AppMethodBeat.o(58342);
    return locald;
  }
  
  final void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(58341);
    this.pid = paramInt1;
    if (this.startTime <= 0L)
    {
      this.startTime = paramLong1;
      this.fAQ = cb.abp();
    }
    this.endTime = paramLong2;
    this.fAv = paramInt2;
    AppMethodBeat.o(58341);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58343);
    String str = String.format("pid:%s,startServerTime:%s,startTime:%s,endTime:%s,normalExecute:%s,changedNetworkStatus:%s,networkStatus:%s", new Object[] { Integer.valueOf(this.pid), a.gP(this.fAQ), a.gP(this.startTime), a.gP(this.endTime), Boolean.valueOf(this.fAw), Boolean.valueOf(this.fAx), Integer.valueOf(this.fAv) });
    AppMethodBeat.o(58343);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.c.d
 * JD-Core Version:    0.7.0.1
 */