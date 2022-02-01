package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a
{
  boolean hBL = false;
  long hBM = 0L;
  long hBN = 0L;
  long hBO = 0L;
  
  public final String toString()
  {
    AppMethodBeat.i(150423);
    String str = String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.hBL), Long.valueOf(this.hBM), Long.valueOf(this.hBN), Long.valueOf(this.hBO) });
    AppMethodBeat.o(150423);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.d.a
 * JD-Core Version:    0.7.0.1
 */