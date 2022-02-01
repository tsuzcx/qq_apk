package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
{
  long beginTime;
  long cCv;
  boolean ehd;
  long endTime;
  long jod;
  long joe;
  int rtType;
  
  public h() {}
  
  public h(int paramInt, boolean paramBoolean, long paramLong)
  {
    this.rtType = paramInt;
    this.ehd = paramBoolean;
    this.jod = paramLong;
    this.joe = 0L;
  }
  
  public final void AH(long paramLong)
  {
    AppMethodBeat.i(151080);
    if (this.jod == 0L) {
      this.jod = paramLong;
    }
    this.cCv = (Util.currentTicks() - this.cCv);
    this.endTime = Util.nowMilliSecond();
    Log.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.jod + " Count:" + this.joe + " type:" + this.rtType);
    WatchDogPushReceiver.a(this);
    AppMethodBeat.o(151080);
  }
  
  public final void bgi()
  {
    AppMethodBeat.i(151079);
    if (this.joe == 0L)
    {
      this.beginTime = Util.nowMilliSecond();
      this.cCv = Util.currentTicks();
    }
    this.joe += 1L;
    AppMethodBeat.o(151079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.h
 * JD-Core Version:    0.7.0.1
 */