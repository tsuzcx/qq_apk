package com.tencent.mm.modelstat;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class h
{
  long beginTime;
  long brE;
  boolean ceg;
  long eDA;
  long eDz;
  long endTime;
  int rtType;
  
  public h() {}
  
  public h(int paramInt, boolean paramBoolean, long paramLong)
  {
    this.rtType = paramInt;
    this.ceg = paramBoolean;
    this.eDz = paramLong;
    this.eDA = 0L;
  }
  
  public final void Ru()
  {
    if (this.eDA == 0L)
    {
      this.beginTime = bk.UY();
      this.brE = bk.UZ();
    }
    this.eDA += 1L;
  }
  
  public final void cg(long paramLong)
  {
    if (this.eDz == 0L) {
      this.eDz = paramLong;
    }
    this.brE = (bk.UZ() - this.brE);
    this.endTime = bk.UY();
    y.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.eDz + " Count:" + this.eDA + " type:" + this.rtType);
    WatchDogPushReceiver.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.h
 * JD-Core Version:    0.7.0.1
 */