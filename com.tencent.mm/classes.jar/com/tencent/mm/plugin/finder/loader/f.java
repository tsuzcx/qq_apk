package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-finder_release"})
public final class f
  extends com.tencent.mm.loader.b.a.a<k>
{
  public final boolean a(com.tencent.mm.loader.h.a.a<k> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(166312);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    AppMethodBeat.o(166312);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<k> parama, com.tencent.mm.loader.h.f<?> paramf, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(166311);
    p.h(parama, "url");
    p.h(paramf, "httpResponse");
    p.h(parame, "opts");
    p.h(paramf1, "reaper");
    AppMethodBeat.o(166311);
    return true;
  }
  
  public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<k> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(166314);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    parame = c(parama, parame, paramf);
    ae.v("Finder.Loader", "url " + parama + " and path " + parame + " fileret " + o.fB(parame) + " type " + ((k)parama.value()).cEj());
    if (o.fB(parame))
    {
      parama = com.tencent.mm.loader.h.b.a.yL(parame);
      AppMethodBeat.o(166314);
      return parama;
    }
    if (((k)parama.value()).cEj() == r.sJv)
    {
      if (o.fB(((k)parama.value()).all()))
      {
        parama = com.tencent.mm.loader.h.b.a.yL(((k)parama.value()).all());
        AppMethodBeat.o(166314);
        return parama;
      }
    }
    else if (o.fB(((k)parama.value()).getUrl()))
    {
      parama = com.tencent.mm.loader.h.b.a.yL(((k)parama.value()).getUrl());
      AppMethodBeat.o(166314);
      return parama;
    }
    AppMethodBeat.o(166314);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.h.a.a<k> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(166313);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    parama = ((k)parama.value()).getPath();
    AppMethodBeat.o(166313);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.f
 * JD-Core Version:    0.7.0.1
 */