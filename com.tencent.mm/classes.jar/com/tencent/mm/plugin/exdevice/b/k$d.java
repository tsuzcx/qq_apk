package com.tencent.mm.plugin.exdevice.b;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

final class k$d
  implements Runnable
{
  private long jth = -1L;
  
  public k$d(k paramk, long paramLong)
  {
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.jth = paramLong;
      return;
    }
  }
  
  public final void run()
  {
    y.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Time Out Sequnence(%d)", new Object[] { Long.valueOf(this.jth) });
    k.a(this.jte).obtainMessage(0, Long.valueOf(this.jth)).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.k.d
 * JD-Core Version:    0.7.0.1
 */