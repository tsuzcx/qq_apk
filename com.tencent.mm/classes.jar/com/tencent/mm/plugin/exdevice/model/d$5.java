package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class d$5
  implements Runnable
{
  d$5(d paramd, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    if (d.a(this.jtE) == null)
    {
      d.a(this.jtE, new c());
      d.a(this.jtE).jyW = new d.5.1(this);
      d.a(this.jtE).da(ae.getContext());
      synchronized (d.b(this.jtE))
      {
        try
        {
          d.b(this.jtE).wait();
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            y.e("MicroMsg.exdevice.ExdeviceConnectManager", "mSyncLock.wait failed!!!, %s", new Object[] { localInterruptedException.getMessage() });
            y.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectManager", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }
    e.aMd().av(this.jtI, this.jtJ);
  }
  
  public final String toString()
  {
    return super.toString() + "|ranging";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.5
 * JD-Core Version:    0.7.0.1
 */