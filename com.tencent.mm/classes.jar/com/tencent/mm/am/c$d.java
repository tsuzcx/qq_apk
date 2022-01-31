package com.tencent.mm.am;

import com.tencent.mm.model.bz;
import java.io.Serializable;

public final class c$d
  implements Serializable
{
  long ekA = 0L;
  int ekf = 0;
  boolean ekg = true;
  boolean ekh = false;
  long endTime = 0L;
  int pid = 0;
  long startTime = 0L;
  
  static d b(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    d locald = new d();
    locald.pid = paramInt1;
    locald.startTime = paramLong1;
    locald.endTime = paramLong2;
    locald.ekf = paramInt2;
    return locald;
  }
  
  final void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    this.pid = paramInt1;
    if (this.startTime <= 0L)
    {
      this.startTime = paramLong1;
      this.ekA = bz.Is();
    }
    this.endTime = paramLong2;
    this.ekf = paramInt2;
  }
  
  public final String toString()
  {
    return String.format("pid:%s,startServerTime:%s,startTime:%s,endTime:%s,normalExecute:%s,changedNetworkStatus:%s,networkStatus:%s", new Object[] { Integer.valueOf(this.pid), a.bU(this.ekA), a.bU(this.startTime), a.bU(this.endTime), Boolean.valueOf(this.ekg), Boolean.valueOf(this.ekh), Integer.valueOf(this.ekf) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.am.c.d
 * JD-Core Version:    0.7.0.1
 */