package com.tencent.mm.emoji.b.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/cache/CoverMemoryCache;", "", "()V", "cacheMap", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "clear", "", "get", "key", "", "put", "bitmap", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b mgs;
  private static final com.tencent.mm.memory.a.b<Bitmap> mgt;
  
  static
  {
    AppMethodBeat.i(105416);
    mgs = new b();
    mgt = new com.tencent.mm.memory.a.b(500, b.class);
    AppMethodBeat.o(105416);
  }
  
  public static Bitmap Eo(String paramString)
  {
    AppMethodBeat.i(105413);
    Log.d(c.aUw(), s.X("get: ", paramString));
    if (paramString == null)
    {
      AppMethodBeat.o(105413);
      return null;
    }
    paramString = (Bitmap)mgt.get(paramString);
    if ((paramString == null) || (paramString.isRecycled()))
    {
      AppMethodBeat.o(105413);
      return null;
    }
    AppMethodBeat.o(105413);
    return paramString;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(105415);
    mgt.clear();
    AppMethodBeat.o(105415);
  }
  
  public static void put(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(105414);
    Log.d(c.aUw(), "put: " + paramString + ", " + paramBitmap);
    if (paramString != null)
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        mgt.put(paramString, paramBitmap);
        AppMethodBeat.o(105414);
        return;
      }
      mgt.remove(paramString);
    }
    AppMethodBeat.o(105414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.a.b
 * JD-Core Version:    0.7.0.1
 */