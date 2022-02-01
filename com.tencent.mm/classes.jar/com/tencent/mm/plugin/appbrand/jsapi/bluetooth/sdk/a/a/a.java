package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.k;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a
{
  public final void crh()
  {
    AppMethodBeat.i(144570);
    if (this.rNd.rMH == null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e("MicroMsg.Ble.Action", "connection is not open.", new Object[0]);
      onResult(k.rNG);
      done();
      AppMethodBeat.o(144570);
      return;
    }
    this.rNd.jh(true);
    onResult(k.rNz);
    done();
    AppMethodBeat.o(144570);
  }
  
  public final String getName()
  {
    return "CloseAction";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a.a
 * JD-Core Version:    0.7.0.1
 */