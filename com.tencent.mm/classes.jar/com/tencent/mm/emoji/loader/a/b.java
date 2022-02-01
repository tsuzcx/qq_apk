package com.tencent.mm.emoji.loader.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/cache/CoverMemoryCache;", "", "()V", "cacheMap", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "clear", "", "get", "key", "", "put", "bitmap", "plugin-emojisdk_release"})
public final class b
{
  private static final com.tencent.mm.memory.a.b<Bitmap> gkZ;
  public static final b gla;
  
  static
  {
    AppMethodBeat.i(105416);
    gla = new b();
    gkZ = new com.tencent.mm.memory.a.b(300, b.class);
    AppMethodBeat.o(105416);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(105415);
    gkZ.clear();
    AppMethodBeat.o(105415);
  }
  
  public static void put(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(105414);
    ae.d(c.aeP(), "put: " + paramString + ", " + paramBitmap);
    if (paramString != null)
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        gkZ.put(paramString, paramBitmap);
        AppMethodBeat.o(105414);
        return;
      }
      gkZ.remove(paramString);
    }
    AppMethodBeat.o(105414);
  }
  
  public static Bitmap wA(String paramString)
  {
    AppMethodBeat.i(105413);
    ae.d(c.aeP(), "get: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(105413);
      return null;
    }
    paramString = (Bitmap)gkZ.get(paramString);
    if ((paramString == null) || (paramString.isRecycled()))
    {
      AppMethodBeat.o(105413);
      return null;
    }
    AppMethodBeat.o(105413);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.a.b
 * JD-Core Version:    0.7.0.1
 */