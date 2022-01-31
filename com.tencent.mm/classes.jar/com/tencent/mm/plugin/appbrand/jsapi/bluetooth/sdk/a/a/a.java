package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;

@TargetApi(18)
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  public final void aiu()
  {
    if (this.gmv.gmp == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "connection is not open.", new Object[0]);
      a(j.gmW);
      done();
      return;
    }
    this.gmv.da(true);
    a(j.gmO);
    done();
  }
  
  public final String getName()
  {
    return "CloseAction";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.a
 * JD-Core Version:    0.7.0.1
 */