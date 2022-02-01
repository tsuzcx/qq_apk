package com.tencent.mm.emoji.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/EmojiGroupThumbLoader;", "", "()V", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "Landroid/graphics/Bitmap;", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "plugin-emojisdk_release"})
public final class d
{
  private static final com.tencent.mm.loader.c.e gVE;
  private static final com.tencent.mm.loader.c.d<a, Bitmap> gVF;
  private static final com.tencent.mm.loader.d<a> gVG;
  public static final d gVH;
  
  static
  {
    AppMethodBeat.i(105386);
    gVH = new d();
    Object localObject = new e.a();
    ((e.a)localObject).hZJ = true;
    ((e.a)localObject).hZI = true;
    gVE = ((e.a)localObject).aJT();
    gVF = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new b()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.d.b)new c()).b(gVE).aJE();
    localObject = com.tencent.mm.loader.e.hXU;
    gVG = com.tencent.mm.loader.e.a(gVF);
    AppMethodBeat.o(105386);
  }
  
  public static com.tencent.mm.loader.d<a> getLoader()
  {
    return gVG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d
 * JD-Core Version:    0.7.0.1
 */