package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.Handler;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    if (!this.gnp.gnk.get()) {
      return;
    }
    if ((this.gnp.gno != null) && (this.gnp.gnm.size() > 0))
    {
      this.gnp.gno.ay(this.gnp.gnm);
      this.gnp.gnm.clear();
    }
    this.gnp.mHandler.postDelayed(this.gnp.gnn, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.glN.dDr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a.1
 * JD-Core Version:    0.7.0.1
 */