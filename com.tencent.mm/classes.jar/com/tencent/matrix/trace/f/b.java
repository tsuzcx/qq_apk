package com.tencent.matrix.trace.f;

import android.os.Handler;
import com.tencent.c.a.a.a;
import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.AppMethodBeat.a;

public final class b
  extends f
{
  private final com.tencent.matrix.trace.a.b cBH;
  private AppMethodBeat.a cCS;
  private long[] cCT = new long[3];
  public long cCU;
  private boolean cCV;
  
  public b(com.tencent.matrix.trace.a.b paramb)
  {
    this.cBH = paramb;
    if (paramb.cwi == null) {}
    for (;;)
    {
      this.cCU = i;
      this.cCV = paramb.cBA;
      return;
      i = paramb.cwi.get(a.a.Iha.name(), 700);
    }
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramBoolean);
    if (this.cBH.cBD) {}
    for (l = System.currentTimeMillis();; l = 0L)
    {
      paramLong1 = (paramLong3 - paramLong1) / 1000000L;
      try
      {
        if (paramLong1 >= this.cCU)
        {
          long[] arrayOfLong1 = AppMethodBeat.getInstance().copyData(this.cCS);
          long[] arrayOfLong2 = new long[3];
          System.arraycopy(this.cCT, 0, arrayOfLong2, 0, 3);
          String str = AppMethodBeat.getVisibleScene();
          com.tencent.matrix.g.b.Iq().post(new b.a(this, com.tencent.matrix.a.csS.csU, str, arrayOfLong1, arrayOfLong2, paramLong4 - paramLong2, paramLong1, paramLong3 / 1000000L));
        }
        return;
      }
      finally
      {
        this.cCS.release();
        if (!this.cBH.cBD) {
          break;
        }
        c.v("Matrix.EvilMethodTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s innerCost:%s", new Object[] { Long.valueOf(paramLong5), Long.valueOf(paramLong1), Long.valueOf(paramLong4 - paramLong2), com.tencent.matrix.trace.g.b.t(paramLong4 - paramLong2, paramLong1), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    this.cCT[0] = paramLong4;
    this.cCT[1] = paramLong5;
    this.cCT[2] = paramLong6;
  }
  
  public final void d(long paramLong1, long paramLong2, long paramLong3)
  {
    super.d(paramLong1, paramLong2, paramLong3);
    this.cCS = AppMethodBeat.getInstance().maskIndex("EvilMethodTracer#dispatchBegin");
  }
  
  public final void onAlive()
  {
    super.onAlive();
    if (this.cCV) {
      com.tencent.matrix.trace.core.b.HU().a(this);
    }
  }
  
  public final void onDead()
  {
    super.onDead();
    if (this.cCV) {
      com.tencent.matrix.trace.core.b.HU().b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.f.b
 * JD-Core Version:    0.7.0.1
 */