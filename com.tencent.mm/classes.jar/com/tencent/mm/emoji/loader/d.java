package com.tencent.mm.emoji.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/EmojiGroupThumbLoader;", "", "()V", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "Landroid/graphics/Bitmap;", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "plugin-emojisdk_release"})
public final class d
{
  private static final com.tencent.mm.loader.c.e fLf;
  private static final com.tencent.mm.loader.c.d<a, Bitmap> fLg;
  private static final com.tencent.mm.loader.d<a> fLh;
  public static final d fLi;
  
  static
  {
    AppMethodBeat.i(105386);
    fLi = new d();
    Object localObject = new e.a();
    ((e.a)localObject).gjE = true;
    ((e.a)localObject).gjD = true;
    fLf = ((e.a)localObject).ahr();
    fLg = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new b()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.d.b)new c()).b(fLf).ahb();
    localObject = com.tencent.mm.loader.e.ghT;
    fLh = com.tencent.mm.loader.e.a(fLg);
    AppMethodBeat.o(105386);
  }
  
  public static com.tencent.mm.loader.d<a> getLoader()
  {
    return fLh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d
 * JD-Core Version:    0.7.0.1
 */