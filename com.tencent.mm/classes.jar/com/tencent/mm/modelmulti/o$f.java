package com.tencent.mm.modelmulti;

import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Queue;

final class o$f
  implements o.c
{
  int esl;
  azg etR;
  long eud;
  
  public o$f(o paramo, s.b paramb, int paramInt, long paramLong)
  {
    if (paramb == null) {}
    for (paramo = null;; paramo = paramb.sqj)
    {
      this.etR = paramo;
      this.eud = paramLong;
      this.esl = paramInt;
      return;
    }
  }
  
  public final boolean c(Queue<o.c> paramQueue)
  {
    if (this.etR == null)
    {
      f.nEG.a(99L, 40L, 1L, false);
      y.e("MicroMsg.SyncService", "%s run resp == null", new Object[] { this });
      return false;
    }
    if (10018 == ae.eSP)
    {
      y.e("MicroMsg.SyncService", "%s Give up for test", new Object[] { this });
      return false;
    }
    new o.a(this.etN, this, true, this.etR, new o.f.1(this), (byte)0);
    f.nEG.a(99L, 21L, 1L, false);
    return true;
  }
  
  public final String toString()
  {
    return "NotifyData[" + hashCode() + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.f
 * JD-Core Version:    0.7.0.1
 */