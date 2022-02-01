package com.tencent.mm.emoji.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/EmojiGroupThumbLoader;", "", "()V", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "Landroid/graphics/Bitmap;", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "plugin-emojisdk_release"})
public final class d
{
  private static final com.tencent.mm.loader.c.e gir;
  private static final com.tencent.mm.loader.c.d<a, Bitmap> gis;
  private static final com.tencent.mm.loader.d<a> git;
  public static final d giu;
  
  static
  {
    AppMethodBeat.i(105386);
    giu = new d();
    Object localObject = new e.a();
    ((e.a)localObject).heb = true;
    ((e.a)localObject).hea = true;
    gir = ((e.a)localObject).arf();
    gis = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new b()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.d.b)new c()).b(gir).aqQ();
    localObject = com.tencent.mm.loader.e.hcm;
    git = com.tencent.mm.loader.e.a(gis);
    AppMethodBeat.o(105386);
  }
  
  public static com.tencent.mm.loader.d<a> getLoader()
  {
    return git;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d
 * JD-Core Version:    0.7.0.1
 */