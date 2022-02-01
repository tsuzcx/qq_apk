package com.tencent.mm.plugin.gamelife.g;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.loader.cache.memory.DefaultBitmapMemoryCache;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarLoader;", "", "()V", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarData;", "Landroid/graphics/Bitmap;", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e JbE;
  private static final com.tencent.mm.loader.b.e mgi;
  private static final com.tencent.mm.loader.b.d<a, Bitmap> mgj;
  private static final com.tencent.mm.loader.d<a> mgk;
  
  static
  {
    AppMethodBeat.i(268157);
    JbE = new e();
    Object localObject = new e.a();
    ((e.a)localObject).nqd = true;
    ((e.a)localObject).nqc = true;
    ((e.a)localObject).nqh = 132;
    ((e.a)localObject).nqg = 132;
    mgi = ((e.a)localObject).blI();
    mgj = new com.tencent.mm.loader.b.a().a((com.tencent.mm.loader.cache.a.d)new b()).a((com.tencent.mm.loader.cache.memory.d)new DefaultBitmapMemoryCache()).a((com.tencent.mm.loader.c.b)new c()).b(mgi).b(new com.tencent.mm.loader.d.c.c(0.1F).blN()).blt();
    localObject = com.tencent.mm.loader.e.noo;
    mgk = com.tencent.mm.loader.e.a(mgj);
    AppMethodBeat.o(268157);
  }
  
  public static com.tencent.mm.loader.d<a> getLoader()
  {
    return mgk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.e
 * JD-Core Version:    0.7.0.1
 */