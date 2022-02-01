package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class h
{
  long beginTime;
  long cin;
  boolean dDS;
  long endTime;
  long hvZ;
  long hwa;
  int rtType;
  
  public h() {}
  
  public h(int paramInt, boolean paramBoolean, long paramLong)
  {
    this.rtType = paramInt;
    this.dDS = paramBoolean;
    this.hvZ = paramLong;
    this.hwa = 0L;
  }
  
  public final void aBI()
  {
    AppMethodBeat.i(151079);
    if (this.hwa == 0L)
    {
      this.beginTime = bt.eGO();
      this.cin = bt.GC();
    }
    this.hwa += 1L;
    AppMethodBeat.o(151079);
  }
  
  public final void mB(long paramLong)
  {
    AppMethodBeat.i(151080);
    if (this.hvZ == 0L) {
      this.hvZ = paramLong;
    }
    this.cin = (bt.GC() - this.cin);
    this.endTime = bt.eGO();
    ad.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.hvZ + " Count:" + this.hwa + " type:" + this.rtType);
    WatchDogPushReceiver.a(this);
    AppMethodBeat.o(151080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.h
 * JD-Core Version:    0.7.0.1
 */