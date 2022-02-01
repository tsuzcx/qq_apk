package com.tencent.mm.emoji.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.loader.cache.memory.DefaultBitmapMemoryCache;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/EmojiGroupThumbLoader;", "", "()V", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "Landroid/graphics/Bitmap;", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d mgh;
  private static final com.tencent.mm.loader.b.e mgi;
  private static final com.tencent.mm.loader.b.d<a, Bitmap> mgj;
  private static final com.tencent.mm.loader.d<a> mgk;
  
  static
  {
    AppMethodBeat.i(105386);
    mgh = new d();
    Object localObject = new e.a();
    ((e.a)localObject).nqd = true;
    ((e.a)localObject).nqc = true;
    mgi = ((e.a)localObject).blI();
    mgj = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new b()).a((com.tencent.mm.loader.cache.memory.d)new DefaultBitmapMemoryCache()).a((com.tencent.mm.loader.c.b)new c()).b(mgi).blt();
    localObject = com.tencent.mm.loader.e.noo;
    mgk = com.tencent.mm.loader.e.a(mgj);
    AppMethodBeat.o(105386);
  }
  
  public static com.tencent.mm.loader.d<a> getLoader()
  {
    return mgk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.d
 * JD-Core Version:    0.7.0.1
 */