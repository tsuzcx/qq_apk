package com.tencent.mm.plugin.gamelife.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarLoader;", "", "()V", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarData;", "Landroid/graphics/Bitmap;", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "plugin-gamelife_release"})
public final class e
{
  private static final com.tencent.mm.loader.c.e gir;
  private static final com.tencent.mm.loader.c.d<a, Bitmap> gis;
  private static final com.tencent.mm.loader.d<a> git;
  public static final e uym;
  
  static
  {
    AppMethodBeat.i(211375);
    uym = new e();
    Object localObject = new e.a();
    ((e.a)localObject).heb = true;
    ((e.a)localObject).hea = true;
    ((e.a)localObject).hef = 132;
    ((e.a)localObject).hee = 132;
    gir = ((e.a)localObject).arf();
    gis = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new b()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.d.b)new c()).b(gir).b(new com.tencent.mm.loader.e.c.c(0.1F).ark()).aqQ();
    localObject = com.tencent.mm.loader.e.hcm;
    git = com.tencent.mm.loader.e.a(gis);
    AppMethodBeat.o(211375);
  }
  
  public static com.tencent.mm.loader.d<a> getLoader()
  {
    return git;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.e
 * JD-Core Version:    0.7.0.1
 */