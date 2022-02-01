package com.tencent.mm.emoji.loader.a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import d.l;
import java.lang.ref.WeakReference;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/cache/AnimateCache;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/Drawable;", "get", "key", "put", "", "drawable", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.EmojiLoader.AnimateCache";
  private static final af<String, WeakReference<Drawable>> fPf;
  public static final a fPg;
  
  static
  {
    AppMethodBeat.i(105412);
    fPg = new a();
    TAG = "MicroMsg.EmojiLoader.AnimateCache";
    fPf = new af(20);
    AppMethodBeat.o(105412);
  }
  
  public static void put(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(105411);
    ac.i(TAG, "put ".concat(String.valueOf(paramString)));
    if (paramString != null)
    {
      if (paramDrawable != null)
      {
        fPf.put(paramString, new WeakReference(paramDrawable));
        AppMethodBeat.o(105411);
        return;
      }
      fPf.remove(paramString);
    }
    AppMethodBeat.o(105411);
  }
  
  public static Drawable td(String paramString)
  {
    AppMethodBeat.i(105410);
    ac.i(TAG, "get ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(105410);
      return null;
    }
    paramString = (WeakReference)fPf.get(paramString);
    if (paramString != null)
    {
      paramString = (Drawable)paramString.get();
      AppMethodBeat.o(105410);
      return paramString;
    }
    AppMethodBeat.o(105410);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.a.a
 * JD-Core Version:    0.7.0.1
 */