package com.tencent.mm.appbrand.v8;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
  extends y
{
  private b(IJSRuntime.Config paramConfig)
  {
    super(paramConfig);
  }
  
  static y a(IJSRuntime.Config paramConfig)
  {
    AppMethodBeat.i(143992);
    paramConfig = new b(paramConfig);
    AppMethodBeat.o(143992);
    return paramConfig;
  }
  
  final c Nm()
  {
    AppMethodBeat.i(143993);
    Looper.prepare();
    g localg = new g(Looper.myLooper());
    AppMethodBeat.o(143993);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.b
 * JD-Core Version:    0.7.0.1
 */