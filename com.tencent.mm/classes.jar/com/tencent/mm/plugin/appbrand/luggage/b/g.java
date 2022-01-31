package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.bridge.impl.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.3;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.e.a.a;
import com.tencent.mm.plugin.appbrand.e.a.c;
import com.tencent.mm.plugin.appbrand.luggage.a.a;

public final class g
  extends c
{
  public final void a(String paramString, a.a parama)
  {
    AppMethodBeat.i(86987);
    if (!match(paramString))
    {
      AppMethodBeat.o(86987);
      return;
    }
    b localb = b.acD();
    parama = new g.2(this, parama);
    byte[] arrayOfByte = localb.qy(paramString);
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
      parama.P(arrayOfByte);
      AppMethodBeat.o(86987);
      return;
    }
    localb.a(new b.3(localb, paramString, parama), paramString, null);
    AppMethodBeat.o(86987);
  }
  
  public final Bitmap b(String paramString, Rect paramRect, a.c paramc)
  {
    AppMethodBeat.i(86986);
    if (!match(paramString))
    {
      AppMethodBeat.o(86986);
      return null;
    }
    if (paramRect != null) {}
    for (paramRect = new a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());; paramRect = null)
    {
      Bitmap localBitmap = b.acD().a(paramString, paramRect);
      if (localBitmap == null) {
        b.acD().a(new g.1(this, paramc), paramString, null, paramRect);
      }
      AppMethodBeat.o(86986);
      return localBitmap;
    }
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(86985);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(86985);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      AppMethodBeat.o(86985);
      return true;
    }
    AppMethodBeat.o(86985);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.g
 * JD-Core Version:    0.7.0.1
 */