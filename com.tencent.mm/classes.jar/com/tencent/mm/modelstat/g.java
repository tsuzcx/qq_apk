package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
{
  long beginTime;
  long cCY;
  long endTime;
  boolean gbt;
  long mds;
  long mdt;
  int rtType;
  
  public g() {}
  
  public g(int paramInt, boolean paramBoolean, long paramLong)
  {
    this.rtType = paramInt;
    this.gbt = paramBoolean;
    this.mds = paramLong;
    this.mdt = 0L;
  }
  
  public final void GP(long paramLong)
  {
    AppMethodBeat.i(151080);
    if (this.mds == 0L) {
      this.mds = paramLong;
    }
    this.cCY = (Util.currentTicks() - this.cCY);
    this.endTime = Util.nowMilliSecond();
    Log.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.mds + " Count:" + this.mdt + " type:" + this.rtType);
    WatchDogPushReceiver.a(this);
    AppMethodBeat.o(151080);
  }
  
  public final void bpw()
  {
    AppMethodBeat.i(151079);
    if (this.mdt == 0L)
    {
      this.beginTime = Util.nowMilliSecond();
      this.cCY = Util.currentTicks();
    }
    this.mdt += 1L;
    AppMethodBeat.o(151079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.g
 * JD-Core Version:    0.7.0.1
 */