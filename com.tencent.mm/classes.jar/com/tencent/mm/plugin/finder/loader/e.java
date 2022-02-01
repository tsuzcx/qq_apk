package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-finder_release"})
public final class e
  extends com.tencent.mm.loader.b.a.a<j>
{
  public final boolean a(com.tencent.mm.loader.h.a.a<j> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(166312);
    k.h(parama, "url");
    k.h(parame, "opts");
    k.h(paramf, "reaper");
    AppMethodBeat.o(166312);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<j> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(166311);
    k.h(parama, "url");
    k.h(paramf, "httpResponse");
    k.h(parame, "opts");
    k.h(paramf1, "reaper");
    AppMethodBeat.o(166311);
    return true;
  }
  
  public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<j> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(166314);
    k.h(parama, "url");
    k.h(parame, "opts");
    k.h(paramf, "reaper");
    parame = c(parama, parame, paramf);
    ad.v("Finder.Loader", "url " + parama + " and path " + parame + " fileret " + i.eK(parame) + " type " + ((j)parama.value()).cmR());
    if (i.eK(parame))
    {
      parama = com.tencent.mm.loader.h.b.a.ri(parame);
      AppMethodBeat.o(166314);
      return parama;
    }
    if (((j)parama.value()).cmR() == h.qJZ)
    {
      if (i.eK(((j)parama.value()).cmT()))
      {
        parama = com.tencent.mm.loader.h.b.a.ri(((j)parama.value()).cmT());
        AppMethodBeat.o(166314);
        return parama;
      }
    }
    else if (i.eK(((j)parama.value()).getUrl()))
    {
      parama = com.tencent.mm.loader.h.b.a.ri(((j)parama.value()).getUrl());
      AppMethodBeat.o(166314);
      return parama;
    }
    AppMethodBeat.o(166314);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.h.a.a<j> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(166313);
    k.h(parama, "url");
    k.h(parame, "opts");
    k.h(paramf, "reaper");
    parama = ((j)parama.value()).getPath();
    AppMethodBeat.o(166313);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.e
 * JD-Core Version:    0.7.0.1
 */