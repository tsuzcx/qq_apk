package com.tencent.mm.emoji.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/EmojiGroupThumbLoader;", "", "()V", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "Landroid/graphics/Bitmap;", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "plugin-emojisdk_release"})
public final class d
{
  private static final com.tencent.mm.loader.c.e fOR;
  private static final com.tencent.mm.loader.c.d<a, Bitmap> fOS;
  private static final com.tencent.mm.loader.d<a> fOT;
  public static final d fOU;
  
  static
  {
    AppMethodBeat.i(105386);
    fOU = new d();
    Object localObject = new e.a();
    ((e.a)localObject).gKq = true;
    ((e.a)localObject).gKp = true;
    fOR = ((e.a)localObject).aot();
    fOS = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new b()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.d.b)new c()).b(fOR).aod();
    localObject = com.tencent.mm.loader.e.gIC;
    fOT = com.tencent.mm.loader.e.a(fOS);
    AppMethodBeat.o(105386);
  }
  
  public static com.tencent.mm.loader.d<a> getLoader()
  {
    return fOT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d
 * JD-Core Version:    0.7.0.1
 */