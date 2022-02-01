package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a
{
  boolean iSh = false;
  long iSi = 0L;
  long iSj = 0L;
  long iSk = 0L;
  
  public final String toString()
  {
    AppMethodBeat.i(150423);
    String str = String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.iSh), Long.valueOf(this.iSi), Long.valueOf(this.iSj), Long.valueOf(this.iSk) });
    AppMethodBeat.o(150423);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.d.a
 * JD-Core Version:    0.7.0.1
 */