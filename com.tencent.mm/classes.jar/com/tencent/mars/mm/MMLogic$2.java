package com.tencent.mars.mm;

import com.tencent.mm.network.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class MMLogic$2
  implements Runnable
{
  MMLogic$2(b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void run()
  {
    try
    {
      this.val$monitor.u(this.val$wr, this.val$ws, this.val$mr, this.val$ms);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.e("C2Java", "reportFlowData :%s", new Object[] { bo.l(localThrowable) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mars.mm.MMLogic.2
 * JD-Core Version:    0.7.0.1
 */