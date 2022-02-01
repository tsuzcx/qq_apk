package com.tencent.mm.emoji.loader.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/cache/CoverMemoryCache;", "", "()V", "cacheMap", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "clear", "", "get", "key", "", "put", "bitmap", "plugin-emojisdk_release"})
public final class b
{
  private static final com.tencent.mm.memory.a.b<Bitmap> fPh;
  public static final b fPi;
  
  static
  {
    AppMethodBeat.i(105416);
    fPi = new b();
    fPh = new com.tencent.mm.memory.a.b(300, b.class);
    AppMethodBeat.o(105416);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(105415);
    fPh.clear();
    AppMethodBeat.o(105415);
  }
  
  public static void put(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(105414);
    ac.d(c.abZ(), "put: " + paramString + ", " + paramBitmap);
    if (paramString != null)
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        fPh.put(paramString, paramBitmap);
        AppMethodBeat.o(105414);
        return;
      }
      fPh.remove(paramString);
    }
    AppMethodBeat.o(105414);
  }
  
  public static Bitmap te(String paramString)
  {
    AppMethodBeat.i(105413);
    ac.d(c.abZ(), "get: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(105413);
      return null;
    }
    paramString = (Bitmap)fPh.get(paramString);
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