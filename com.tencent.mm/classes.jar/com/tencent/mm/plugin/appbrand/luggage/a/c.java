package com.tencent.mm.plugin.appbrand.luggage.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.canvas.e.a;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.g.a.b;
import com.tencent.mm.plugin.appbrand.g.b;

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
  
  public final Bitmap a(final d paramd, final String paramString, Rect paramRect, final e.a parama)
  {
    AppMethodBeat.i(47475);
    com.tencent.mm.plugin.appbrand.jsapi.c localc = paramd.ccU;
    String str = ((b)localc.K(b.class)).b(localc, paramString);
    paramd = ((a)localc.K(a.class)).a(str, paramRect, new a.b()
    {
      public final void M(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(47472);
        if ((parama == null) || (paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
        {
          AppMethodBeat.o(47472);
          return;
        }
        parama.a(paramd);
        AppMethodBeat.o(47472);
      }
    });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.a.c
 * JD-Core Version:    0.7.0.1
 */