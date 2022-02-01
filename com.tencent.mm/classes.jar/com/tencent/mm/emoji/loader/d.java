package com.tencent.mm.emoji.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/EmojiGroupThumbLoader;", "", "()V", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "Landroid/graphics/Bitmap;", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "plugin-emojisdk_release"})
public final class d
{
  private static final com.tencent.mm.loader.c.e gkJ;
  private static final com.tencent.mm.loader.c.d<a, Bitmap> gkK;
  private static final com.tencent.mm.loader.d<a> gkL;
  public static final d gkM;
  
  static
  {
    AppMethodBeat.i(105386);
    gkM = new d();
    Object localObject = new e.a();
    ((e.a)localObject).hgP = true;
    ((e.a)localObject).hgO = true;
    gkJ = ((e.a)localObject).aru();
    gkK = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new b()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.d.b)new c()).b(gkJ).arf();
    localObject = com.tencent.mm.loader.e.hfa;
    gkL = com.tencent.mm.loader.e.a(gkK);
    AppMethodBeat.o(105386);
  }
  
  public static com.tencent.mm.loader.d<a> getLoader()
  {
    return gkL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d
 * JD-Core Version:    0.7.0.1
 */