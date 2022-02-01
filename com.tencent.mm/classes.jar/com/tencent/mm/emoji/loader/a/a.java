package com.tencent.mm.emoji.loader.a;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/cache/AnimateCache;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/drawable/Drawable;", "get", "key", "put", "", "drawable", "plugin-emojisdk_release"})
public final class a
{
  private static final String TAG = "MicroMsg.EmojiLoader.AnimateCache";
  private static final ah<String, WeakReference<Drawable>> gkX;
  public static final a gkY;
  
  static
  {
    AppMethodBeat.i(105412);
    gkY = new a();
    TAG = "MicroMsg.EmojiLoader.AnimateCache";
    gkX = new ah(20);
    AppMethodBeat.o(105412);
  }
  
  public static void put(String paramString, Drawable paramDrawable)
  {
    AppMethodBeat.i(105411);
    ae.i(TAG, "put ".concat(String.valueOf(paramString)));
    if (paramString != null)
    {
      if (paramDrawable != null)
      {
        gkX.put(paramString, new WeakReference(paramDrawable));
        AppMethodBeat.o(105411);
        return;
      }
      gkX.remove(paramString);
    }
    AppMethodBeat.o(105411);
  }
  
  public static Drawable wz(String paramString)
  {
    AppMethodBeat.i(105410);
    ae.i(TAG, "get ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(105410);
      return null;
    }
    paramString = (WeakReference)gkX.get(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.a.a
 * JD-Core Version:    0.7.0.1
 */