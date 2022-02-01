package com.tencent.mm.plugin.gamelife.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/gamelife/loader/GameLifeAvatarData;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-gamelife_release"})
public final class b
  extends com.tencent.mm.loader.b.a.a<a>
{
  public final boolean a(com.tencent.mm.loader.h.a.a<a> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(212141);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    AppMethodBeat.o(212141);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<a> parama, com.tencent.mm.loader.h.f<?> paramf, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(212140);
    p.h(parama, "url");
    p.h(paramf, "httpResponse");
    p.h(parame, "opts");
    p.h(paramf1, "reaper");
    AppMethodBeat.o(212140);
    return true;
  }
  
  public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<a> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(212143);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    parama = ((a)parama.value()).getPath();
    if (o.fB(parama))
    {
      parama = com.tencent.mm.loader.h.b.a.yL(parama);
      AppMethodBeat.o(212143);
      return parama;
    }
    AppMethodBeat.o(212143);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.h.a.a<a> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(212142);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    parama = ((a)parama.value()).getPath();
    AppMethodBeat.o(212142);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.f.b
 * JD-Core Version:    0.7.0.1
 */