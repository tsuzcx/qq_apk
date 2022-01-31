package com.tencent.luggage.bridge.impl.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.a.c;

public class c
  extends a
{
  public Bitmap b(String paramString, Rect paramRect, a.c paramc)
  {
    return null;
  }
  
  public boolean match(String paramString)
  {
    AppMethodBeat.i(90767);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(90767);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      AppMethodBeat.o(90767);
      return true;
    }
    AppMethodBeat.o(90767);
    return false;
  }
  
  public final String tX()
  {
    return "NetworkImageReader";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.a.c
 * JD-Core Version:    0.7.0.1
 */