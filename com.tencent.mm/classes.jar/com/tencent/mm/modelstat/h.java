package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h
{
  long bSb;
  long beginTime;
  boolean cMU;
  long endTime;
  long fTq;
  long fTr;
  int rtType;
  
  public h() {}
  
  public h(int paramInt, boolean paramBoolean, long paramLong)
  {
    this.rtType = paramInt;
    this.cMU = paramBoolean;
    this.fTq = paramLong;
    this.fTr = 0L;
  }
  
  public final void akD()
  {
    AppMethodBeat.i(78735);
    if (this.fTr == 0L)
    {
      this.beginTime = bo.aoy();
      this.bSb = bo.yB();
    }
    this.fTr += 1L;
    AppMethodBeat.o(78735);
  }
  
  public final void hc(long paramLong)
  {
    AppMethodBeat.i(78736);
    if (this.fTq == 0L) {
      this.fTq = paramLong;
    }
    this.bSb = (bo.yB() - this.bSb);
    this.endTime = bo.aoy();
    ab.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.fTq + " Count:" + this.fTr + " type:" + this.rtType);
    WatchDogPushReceiver.a(this);
    AppMethodBeat.o(78736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelstat.h
 * JD-Core Version:    0.7.0.1
 */