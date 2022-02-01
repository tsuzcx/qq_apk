package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class h
{
  long beginTime;
  long cfj;
  boolean dBE;
  long endTime;
  long hWA;
  long hWB;
  int rtType;
  
  public h() {}
  
  public h(int paramInt, boolean paramBoolean, long paramLong)
  {
    this.rtType = paramInt;
    this.dBE = paramBoolean;
    this.hWA = paramLong;
    this.hWB = 0L;
  }
  
  public final void aIy()
  {
    AppMethodBeat.i(151079);
    if (this.hWB == 0L)
    {
      this.beginTime = bs.eWj();
      this.cfj = bs.Gn();
    }
    this.hWB += 1L;
    AppMethodBeat.o(151079);
  }
  
  public final void qp(long paramLong)
  {
    AppMethodBeat.i(151080);
    if (this.hWA == 0L) {
      this.hWA = paramLong;
    }
    this.cfj = (bs.Gn() - this.cfj);
    this.endTime = bs.eWj();
    ac.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.hWA + " Count:" + this.hWB + " type:" + this.rtType);
    WatchDogPushReceiver.a(this);
    AppMethodBeat.o(151080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.h
 * JD-Core Version:    0.7.0.1
 */