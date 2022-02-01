package com.tencent.mm.plugin.appbrand.luggage.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.canvas.e.a;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;

public final class c
  implements e
{
  public final Bitmap a(d paramd, String paramString)
  {
    AppMethodBeat.i(47473);
    paramd = a(paramd, paramString, null);
    AppMethodBeat.o(47473);
    return paramd;
  }
  
  public final Bitmap a(d paramd, String paramString, Rect paramRect, e.a parama)
  {
    AppMethodBeat.i(47475);
    f localf = paramd.eqB;
    String str = ((b)localf.T(b.class)).b(localf, paramString);
    paramd = ((a)localf.T(a.class)).a(str, paramRect, new c.1(this, parama, paramd, paramString));
    AppMethodBeat.o(47475);
    return paramd;
  }
  
  public final Bitmap a(d paramd, String paramString, e.a parama)
  {
    AppMethodBeat.i(47474);
    paramd = a(paramd, paramString, null, parama);
    AppMethodBeat.o(47474);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.a.c
 * JD-Core Version:    0.7.0.1
 */