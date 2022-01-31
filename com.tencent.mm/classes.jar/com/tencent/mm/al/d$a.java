package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a
{
  boolean fzm = false;
  long fzn = 0L;
  long fzo = 0L;
  long fzp = 0L;
  
  public final String toString()
  {
    AppMethodBeat.i(78065);
    String str = String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.fzm), Long.valueOf(this.fzn), Long.valueOf(this.fzo), Long.valueOf(this.fzp) });
    AppMethodBeat.o(78065);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.d.a
 * JD-Core Version:    0.7.0.1
 */