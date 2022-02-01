package com.tencent.mm.plugin.gamelife.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarLoader;", "", "()V", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarData;", "Landroid/graphics/Bitmap;", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "plugin-gamelife_release"})
public final class e
{
  public static final e DhM;
  private static final com.tencent.mm.loader.c.e jGA;
  private static final com.tencent.mm.loader.c.d<a, Bitmap> jGB;
  private static final com.tencent.mm.loader.d<a> jGC;
  
  static
  {
    AppMethodBeat.i(202692);
    DhM = new e();
    Object localObject = new e.a();
    ((e.a)localObject).kOp = true;
    ((e.a)localObject).kOo = true;
    ((e.a)localObject).kOt = 132;
    ((e.a)localObject).kOs = 132;
    jGA = ((e.a)localObject).aRT();
    jGB = new com.tencent.mm.loader.c.a().a((com.tencent.mm.loader.b.a.d)new b()).a((com.tencent.mm.loader.b.b.e)new com.tencent.mm.loader.b.b.a()).a((com.tencent.mm.loader.d.b)new c()).b(jGA).b(new com.tencent.mm.loader.e.c.c(0.1F).aRY()).aRE();
    localObject = com.tencent.mm.loader.e.kMy;
    jGC = com.tencent.mm.loader.e.a(jGB);
    AppMethodBeat.o(202692);
  }
  
  public static com.tencent.mm.loader.d<a> getLoader()
  {
    return jGC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.e
 * JD-Core Version:    0.7.0.1
 */