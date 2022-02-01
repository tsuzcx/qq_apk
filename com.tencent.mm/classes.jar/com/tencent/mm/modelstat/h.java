package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class h
{
  long beginTime;
  long cpz;
  boolean dNR;
  long endTime;
  long ipV;
  long ipW;
  int rtType;
  
  public h() {}
  
  public h(int paramInt, boolean paramBoolean, long paramLong)
  {
    this.rtType = paramInt;
    this.dNR = paramBoolean;
    this.ipV = paramLong;
    this.ipW = 0L;
  }
  
  public final void aLI()
  {
    AppMethodBeat.i(151079);
    if (this.ipW == 0L)
    {
      this.beginTime = bt.flT();
      this.cpz = bt.HI();
    }
    this.ipW += 1L;
    AppMethodBeat.o(151079);
  }
  
  public final void so(long paramLong)
  {
    AppMethodBeat.i(151080);
    if (this.ipV == 0L) {
      this.ipV = paramLong;
    }
    this.cpz = (bt.HI() - this.cpz);
    this.endTime = bt.flT();
    ad.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.ipV + " Count:" + this.ipW + " type:" + this.rtType);
    WatchDogPushReceiver.a(this);
    AppMethodBeat.o(151080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.h
 * JD-Core Version:    0.7.0.1
 */