package com.tencent.mm.emoji.loader.a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import d.l;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/cache/AnimateCache;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/Drawable;", "get", "key", "put", "", "drawable", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.EmojiLoader.AnimateCache";
  private static final ag<String, WeakReference<Drawable>> fLt;
  public static final a fLu;
  
  static
  {
    AppMethodBeat.i(105412);
    fLu = new a();
    TAG = "MicroMsg.EmojiLoader.AnimateCache";
    fLt = new ag(20);
    AppMethodBeat.o(105412);
  }
  
  public static void b(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(105411);
    ad.i(TAG, "put ".concat(String.valueOf(paramString)));
    if (paramString != null)
    {
      if (paramDrawable != null)
      {
        fLt.put(paramString, new WeakReference(paramDrawable));
        AppMethodBeat.o(105411);
        return;
      }
      fLt.remove(paramString);
    }
    AppMethodBeat.o(105411);
  }
  
  public static Drawable pS(String paramString)
  {
    AppMethodBeat.i(105410);
    ad.i(TAG, "get ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(105410);
      return null;
    }
    paramString = (WeakReference)fLt.get(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.a.a
 * JD-Core Version:    0.7.0.1
 */