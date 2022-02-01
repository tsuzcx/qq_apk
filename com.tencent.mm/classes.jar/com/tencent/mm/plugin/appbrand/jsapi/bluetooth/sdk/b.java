package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a;

public final class b
{
  private Context context;
  public c kjC;
  public a kjD;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(144531);
    this.context = paramContext;
    this.kjC = new c(paramContext);
    this.kjD = new a(paramContext);
    AppMethodBeat.o(144531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b
 * JD-Core Version:    0.7.0.1
 */