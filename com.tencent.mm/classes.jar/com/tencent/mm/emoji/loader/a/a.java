package com.tencent.mm.emoji.loader.a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/cache/AnimateCache;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/Drawable;", "get", "key", "put", "", "drawable", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.EmojiLoader.AnimateCache";
  private static final LruCache<String, WeakReference<Drawable>> cache;
  public static final a gVS;
  
  static
  {
    AppMethodBeat.i(105412);
    gVS = new a();
    TAG = "MicroMsg.EmojiLoader.AnimateCache";
    cache = new LruCache(20);
    AppMethodBeat.o(105412);
  }
  
  public static Drawable EO(String paramString)
  {
    AppMethodBeat.i(105410);
    Log.i(TAG, "get ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(105410);
      return null;
    }
    paramString = (WeakReference)cache.get(paramString);
    if (paramString != null)
    {
      paramString = (Drawable)paramString.get();
      AppMethodBeat.o(105410);
      return paramString;
    }
    AppMethodBeat.o(105410);
    return null;
  }
  
  public static void put(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(105411);
    Log.i(TAG, "put ".concat(String.valueOf(paramString)));
    if (paramString != null)
    {
      if (paramDrawable != null)
      {
        cache.put(paramString, new WeakReference(paramDrawable));
        AppMethodBeat.o(105411);
        return;
      }
      cache.remove(paramString);
    }
    AppMethodBeat.o(105411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.a.a
 * JD-Core Version:    0.7.0.1
 */