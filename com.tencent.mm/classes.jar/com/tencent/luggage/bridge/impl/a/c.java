package com.tencent.luggage.bridge.impl.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;

public class c
  extends a
{
  public final void a(String paramString, a.c paramc) {}
  
  public Bitmap b(String paramString, Rect paramRect, a.b paramb)
  {
    return null;
  }
  
  public final String key()
  {
    return "NetworkImageReader";
  }
  
  public boolean match(String paramString)
  {
    AppMethodBeat.i(140368);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(140368);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      AppMethodBeat.o(140368);
      return true;
    }
    AppMethodBeat.o(140368);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.a.c
 * JD-Core Version:    0.7.0.1
 */