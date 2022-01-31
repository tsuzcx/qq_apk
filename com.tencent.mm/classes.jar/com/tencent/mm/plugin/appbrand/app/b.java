package com.tencent.mm.plugin.appbrand.app;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.vending.c.a;

public final class b
  implements com.tencent.mm.plugin.appbrand.service.d
{
  public static com.tencent.mm.vending.g.e<Pair<String, String>> A(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143058);
    paramString = g.j(paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)).b(new a() {});
    AppMethodBeat.o(143058);
    return paramString;
  }
  
  public final void aut()
  {
    AppMethodBeat.i(143056);
    h.aLT();
    AppMethodBeat.o(143056);
  }
  
  public final void auu()
  {
    AppMethodBeat.i(154322);
    com.tencent.mm.sdk.g.d.ysm.execute(new b.1(this));
    AppMethodBeat.o(154322);
  }
  
  public final com.tencent.mm.vending.g.e<Pair<String, String>> z(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143057);
    paramString = A(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(143057);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.b
 * JD-Core Version:    0.7.0.1
 */