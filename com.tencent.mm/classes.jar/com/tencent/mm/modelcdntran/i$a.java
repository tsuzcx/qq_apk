package com.tencent.mm.modelcdntran;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$a
{
  boolean oAZ = false;
  long oBa = 0L;
  long oBb = 0L;
  long oBc = 0L;
  
  public final String toString()
  {
    AppMethodBeat.i(150423);
    String str = String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.oAZ), Long.valueOf(this.oBa), Long.valueOf(this.oBb), Long.valueOf(this.oBc) });
    AppMethodBeat.o(150423);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelcdntran.i.a
 * JD-Core Version:    0.7.0.1
 */