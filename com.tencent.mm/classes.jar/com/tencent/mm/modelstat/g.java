package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
{
  long beginTime;
  long cost;
  long endTime;
  boolean ihD;
  long oWl;
  long oWm;
  int rtType;
  
  public g() {}
  
  public g(int paramInt, boolean paramBoolean, long paramLong)
  {
    this.rtType = paramInt;
    this.ihD = paramBoolean;
    this.oWl = paramLong;
    this.oWm = 0L;
  }
  
  public final void bNd()
  {
    AppMethodBeat.i(151079);
    if (this.oWm == 0L)
    {
      this.beginTime = Util.nowMilliSecond();
      this.cost = Util.currentTicks();
    }
    this.oWm += 1L;
    AppMethodBeat.o(151079);
  }
  
  public final void ja(long paramLong)
  {
    AppMethodBeat.i(151080);
    if (this.oWl == 0L) {
      this.oWl = paramLong;
    }
    this.cost = (Util.currentTicks() - this.cost);
    this.endTime = Util.nowMilliSecond();
    Log.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.oWl + " Count:" + this.oWm + " type:" + this.rtType);
    WatchDogPushReceiver.a(this);
    AppMethodBeat.o(151080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.g
 * JD-Core Version:    0.7.0.1
 */