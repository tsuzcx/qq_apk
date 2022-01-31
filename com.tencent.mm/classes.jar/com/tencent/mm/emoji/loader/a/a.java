package com.tencent.mm.emoji.loader.a;

import a.l;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/cache/AnimateCache;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/Drawable;", "get", "key", "put", "", "drawable", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.EmojiLoader.AnimateCache";
  private static final ae<String, WeakReference<Drawable>> evq;
  public static final a evr;
  
  static
  {
    AppMethodBeat.i(63167);
    evr = new a();
    TAG = "MicroMsg.EmojiLoader.AnimateCache";
    evq = new ae(20);
    AppMethodBeat.o(63167);
  }
  
  public static void b(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(63166);
    ab.i(TAG, "put ".concat(String.valueOf(paramString)));
    if (paramString != null)
    {
      if (paramDrawable != null)
      {
        evq.put(paramString, new WeakReference(paramDrawable));
        AppMethodBeat.o(63166);
        return;
      }
      evq.remove(paramString);
    }
    AppMethodBeat.o(63166);
  }
  
  public static Drawable lJ(String paramString)
  {
    AppMethodBeat.i(63165);
    ab.i(TAG, "get ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(63165);
      return null;
    }
    paramString = (WeakReference)evq.get(paramString);
    if (paramString != null)
    {
      paramString = (Drawable)paramString.get();
      AppMethodBeat.o(63165);
      return paramString;
    }
    AppMethodBeat.o(63165);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.a.a
 * JD-Core Version:    0.7.0.1
 */