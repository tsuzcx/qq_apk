package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-finder_release"})
public final class n
  extends com.tencent.mm.loader.b.a.a<w>
{
  public final boolean a(com.tencent.mm.loader.h.a.a<w> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(166312);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    AppMethodBeat.o(166312);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<w> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(166311);
    p.k(parama, "url");
    p.k(paramf, "httpResponse");
    p.k(parame, "opts");
    p.k(paramf1, "reaper");
    AppMethodBeat.o(166311);
    return true;
  }
  
  public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<w> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(166314);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    parame = c(parama, parame, paramf);
    Log.v("Finder.Loader", "url " + parama + " and path " + parame + " fileret " + com.tencent.mm.vfs.u.agG(parame) + " type " + ((w)parama.aSr()).dIX());
    if (com.tencent.mm.vfs.u.agG(parame))
    {
      parama = com.tencent.mm.loader.h.b.a.Ov(parame);
      AppMethodBeat.o(166314);
      return parama;
    }
    parame = parama.aSr();
    if (((w)parame instanceof e)) {}
    for (;;)
    {
      parame = (w)parame;
      if (parame == null) {
        break label265;
      }
      if (parame != null) {
        break;
      }
      parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.loader.FinderAvatar");
      AppMethodBeat.o(166314);
      throw parama;
      parame = null;
    }
    if (((e)parame).dJc())
    {
      paramf = (e)parame;
      StringBuilder localStringBuilder = new StringBuilder();
      av localav = av.AJz;
      paramf = av.egl() + paramf.dJb();
      if (com.tencent.mm.vfs.u.agG(paramf))
      {
        Log.v("Finder.Loader", "exist origin url disk cache, rawUrl " + ((e)parame).fXu + " and originUrlPath " + paramf);
        parama = com.tencent.mm.loader.h.b.a.Ov(paramf);
        AppMethodBeat.o(166314);
        return parama;
      }
    }
    label265:
    if (((w)parama.aSr()).dIX() == com.tencent.mm.plugin.finder.storage.u.Alz)
    {
      if (com.tencent.mm.vfs.u.agG(((w)parama.aSr()).aJi()))
      {
        parama = com.tencent.mm.loader.h.b.a.Ov(((w)parama.aSr()).aJi());
        AppMethodBeat.o(166314);
        return parama;
      }
    }
    else if (com.tencent.mm.vfs.u.agG(((w)parama.aSr()).getUrl()))
    {
      parama = com.tencent.mm.loader.h.b.a.Ov(((w)parama.aSr()).getUrl());
      AppMethodBeat.o(166314);
      return parama;
    }
    AppMethodBeat.o(166314);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.h.a.a<w> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(166313);
    p.k(parama, "url");
    p.k(parame, "opts");
    p.k(paramf, "reaper");
    parama = ((w)parama.aSr()).getPath();
    AppMethodBeat.o(166313);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.n
 * JD-Core Version:    0.7.0.1
 */