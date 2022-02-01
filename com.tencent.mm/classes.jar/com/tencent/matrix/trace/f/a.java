package com.tencent.matrix.trace.f;

import android.os.Handler;
import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.AppMethodBeat.a;

public final class a
  extends f
{
  private final com.tencent.matrix.trace.a.b cBr;
  private Handler cCM;
  private volatile a.a cCN;
  private boolean cCO;
  
  public a(com.tencent.matrix.trace.a.b paramb)
  {
    this.cBr = paramb;
    this.cCO = paramb.cBC;
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramBoolean);
    if (this.cBr.cBD)
    {
      paramLong1 = (paramLong3 - paramLong1) / 1000000L;
      c.v("Matrix.AnrTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s", new Object[] { Long.valueOf(paramLong5), Long.valueOf(paramLong1), Long.valueOf(paramLong4 - paramLong2), com.tencent.matrix.trace.g.b.t(paramLong4 - paramLong2, paramLong1) });
    }
    if (this.cCN != null)
    {
      this.cCN.cCP.release();
      this.cCM.removeCallbacks(this.cCN);
    }
  }
  
  public final void d(long paramLong1, long paramLong2, long paramLong3)
  {
    super.d(paramLong1, paramLong2, paramLong3);
    this.cCN = new a.a(this, AppMethodBeat.getInstance().maskIndex("AnrTracer#dispatchBegin"), paramLong3);
    if (this.cBr.cBD) {
      c.v("Matrix.AnrTracer", "* [dispatchBegin] token:%s index:%s", new Object[] { Long.valueOf(paramLong3), Integer.valueOf(this.cCN.cCP.index) });
    }
    this.cCM.postDelayed(this.cCN, 5000L - (System.nanoTime() - paramLong3) / 1000000L);
  }
  
  public final void onAlive()
  {
    super.onAlive();
    if (this.cCO)
    {
      com.tencent.matrix.trace.core.b.HU().a(this);
      this.cCM = new Handler(com.tencent.matrix.g.b.Iq().getLooper());
    }
  }
  
  public final void onDead()
  {
    super.onDead();
    if (this.cCO)
    {
      com.tencent.matrix.trace.core.b.HU().b(this);
      if (this.cCN != null) {
        this.cCN.cCP.release();
      }
      this.cCM.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.f.a
 * JD-Core Version:    0.7.0.1
 */