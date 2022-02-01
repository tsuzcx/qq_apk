package com.tencent.mm.emoji.loader.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/cache/CoverMemoryCache;", "", "()V", "cacheMap", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Landroid/graphics/Bitmap;", "clear", "", "get", "key", "put", "bitmap", "plugin-emojisdk_release"})
public final class b
{
  private static final h<String, Bitmap> fLv;
  public static final b fLw;
  
  static
  {
    AppMethodBeat.i(105416);
    fLw = new b();
    fLv = new h(300);
    AppMethodBeat.o(105416);
  }
  
  public static void c(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(105414);
    ad.i(c.abb(), "put: " + paramString + ", " + paramBitmap);
    if (paramString != null)
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        fLv.put(paramString, paramBitmap);
        AppMethodBeat.o(105414);
        return;
      }
      fLv.remove(paramString);
    }
    AppMethodBeat.o(105414);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(105415);
    fLv.clear();
    AppMethodBeat.o(105415);
  }
  
  public static Bitmap pT(String paramString)
  {
    AppMethodBeat.i(105413);
    ad.i(c.abb(), "get: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(105413);
      return null;
    }
    paramString = (Bitmap)fLv.get(paramString);
    if ((paramString == null) || (paramString.isRecycled()))
    {
      AppMethodBeat.o(105413);
      return null;
    }
    AppMethodBeat.o(105413);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.a.b
 * JD-Core Version:    0.7.0.1
 */