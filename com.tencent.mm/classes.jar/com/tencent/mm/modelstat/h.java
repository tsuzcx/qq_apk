package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class h
{
  long beginTime;
  long cqc;
  boolean dPh;
  long endTime;
  long isQ;
  long isR;
  int rtType;
  
  public h() {}
  
  public h(int paramInt, boolean paramBoolean, long paramLong)
  {
    this.rtType = paramInt;
    this.dPh = paramBoolean;
    this.isQ = paramLong;
    this.isR = 0L;
  }
  
  public final void aMf()
  {
    AppMethodBeat.i(151079);
    if (this.isR == 0L)
    {
      this.beginTime = bu.fpO();
      this.cqc = bu.HQ();
    }
    this.isR += 1L;
    AppMethodBeat.o(151079);
  }
  
  public final void sB(long paramLong)
  {
    AppMethodBeat.i(151080);
    if (this.isQ == 0L) {
      this.isQ = paramLong;
    }
    this.cqc = (bu.HQ() - this.cqc);
    this.endTime = bu.fpO();
    ae.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.isQ + " Count:" + this.isR + " type:" + this.rtType);
    WatchDogPushReceiver.a(this);
    AppMethodBeat.o(151080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.h
 * JD-Core Version:    0.7.0.1
 */