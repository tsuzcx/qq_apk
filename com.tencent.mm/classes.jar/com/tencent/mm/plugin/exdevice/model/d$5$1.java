package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.e;

final class d$5$1
  extends c.a
{
  d$5$1(d.5 param5)
  {
    super(0);
  }
  
  public final void onServiceConnected()
  {
    d.a(this.jtK.jtE).jyW = null;
    e.aMd().av(this.jtK.jtI, this.jtK.jtJ);
    synchronized (d.b(this.jtK.jtE))
    {
      d.b(this.jtK.jtE).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.d.5.1
 * JD-Core Version:    0.7.0.1
 */