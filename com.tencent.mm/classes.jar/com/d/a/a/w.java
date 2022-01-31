package com.d.a.a;

import android.content.Context;
import android.os.Handler;

final class w
  extends n
{
  private static w bbr;
  private boolean bbs;
  private int bbt;
  private long bbu;
  private long bbv;
  
  static w pE()
  {
    if (bbr == null) {
      bbr = new w();
    }
    return bbr;
  }
  
  final void a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    if (this.bbs) {
      stop();
    }
    super.a(paramInt, paramString, paramLong1, paramLong2);
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    if (this.bbs) {
      if (k.pe().aVJ) {
        k.pe().pa();
      }
    }
    for (;;)
    {
      super.a(paramContext, paramHandler, parama);
      return;
      if (!k.pe().aVJ) {
        try
        {
          k.pe().a(paramContext, new m[] { this });
        }
        catch (Exception localException) {}
      }
    }
  }
  
  final void a(Handler paramHandler, d.a parama)
  {
    try
    {
      this.bbs = false;
      super.a(paramHandler, parama);
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  public final void a(p paramp)
  {
    long l = paramp.aYA;
    if ((this.bbs) && (l - this.bbv > this.bbu)) {
      stop();
    }
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    super.a(paramp);
  }
  
  final void a(x paramx, long paramLong1, long paramLong2)
  {
    if (paramx.bbA == null) {
      paramx.bbA = new x.a();
    }
    float f = paramx.bbA.bbD;
    if ((this.bbs) && (f >= this.bbt)) {
      stop();
    }
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    super.a(paramx, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.d.a.a.w
 * JD-Core Version:    0.7.0.1
 */