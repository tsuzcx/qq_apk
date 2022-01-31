package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.mm.ck.f;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.y;

public enum i
{
  public volatile boolean fFu = false;
  public volatile f<Void> fFv;
  
  private i() {}
  
  public final void acu()
  {
    for (;;)
    {
      try
      {
        if (this.fFu)
        {
          y.d("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, queueRunning, skip");
          return;
        }
        if (!com.tencent.mm.kernel.g.DN().dJH)
        {
          y.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, account not ready");
          continue;
        }
        y.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, set flag queue running");
      }
      finally {}
      this.fFu = true;
      this.fFv = com.tencent.mm.ck.g.cNB();
      this.fFv.j(new i.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.i
 * JD-Core Version:    0.7.0.1
 */