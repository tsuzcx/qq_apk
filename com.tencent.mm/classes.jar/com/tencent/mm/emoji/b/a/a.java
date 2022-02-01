package com.tencent.mm.emoji.b.a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/cache/AnimateCache;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/Drawable;", "get", "key", "put", "", "drawable", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  private static final LruCache<String, WeakReference<Drawable>> cache;
  public static final a mgq;
  
  static
  {
    AppMethodBeat.i(105412);
    mgq = new a();
    TAG = "MicroMsg.EmojiLoader.AnimateCache";
    cache = new LruCache(10);
    AppMethodBeat.o(105412);
  }
  
  public static Drawable En(String paramString)
  {
    AppMethodBeat.i(105410);
    Log.i(TAG, s.X("get ", paramString));
    if (paramString == null)
    {
      AppMethodBeat.o(105410);
      return null;
    }
    paramString = (WeakReference)cache.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(105410);
      return null;
    }
    paramString = (Drawable)paramString.get();
    AppMethodBeat.o(105410);
    return paramString;
  }
  
  public static void put(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(105411);
    Log.i(TAG, s.X("put ", paramString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.a.a
 * JD-Core Version:    0.7.0.1
 */