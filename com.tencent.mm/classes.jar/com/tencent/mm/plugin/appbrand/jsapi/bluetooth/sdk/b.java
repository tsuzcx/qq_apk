package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a;

public final class b
{
  private Context context;
  public c hGa;
  public a hGb;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(94219);
    this.context = paramContext;
    this.hGa = new c(paramContext);
    this.hGb = new a(paramContext);
    AppMethodBeat.o(94219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b
 * JD-Core Version:    0.7.0.1
 */