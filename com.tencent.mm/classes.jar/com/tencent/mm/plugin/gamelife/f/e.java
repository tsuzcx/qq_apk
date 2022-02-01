package com.tencent.mm.plugin.gamelife.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarLoader;", "", "()V", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarData;", "Landroid/graphics/Bitmap;", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "plugin-gamelife_release"})
public final class e
{
  private static final com.tencent.mm.loader.c.e gVE;
  private static final com.tencent.mm.loader.c.d<a, Bitmap> gVF;
  private static final com.tencent.mm.loader.d<a> gVG;
  public static final e ycg;
  
  static
  {
    AppMethodBeat.i(241389);
    ycg = new e();
    Object localObject = new e.a();
    ((e.a)localObject).hZJ = true;
    ((e.a)localObject).hZI = true;
    ((e.a)localObject).hZN = 132;
    ((e.a)localObject).hZM = 132;
    gVE = ((e.a)localObject).aJT();
    gVF = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new b()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.d.b)new c()).b(gVE).b(new com.tencent.mm.loader.e.c.c(0.1F).aJY()).aJE();
    localObject = com.tencent.mm.loader.e.hXU;
    gVG = com.tencent.mm.loader.e.a(gVF);
    AppMethodBeat.o(241389);
  }
  
  public static com.tencent.mm.loader.d<a> getLoader()
  {
    return gVG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.e
 * JD-Core Version:    0.7.0.1
 */