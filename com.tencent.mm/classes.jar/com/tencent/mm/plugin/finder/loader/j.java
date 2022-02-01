package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.b.e;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "clear", "", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends com.tencent.mm.loader.cache.a.a<r>
{
  public final boolean a(com.tencent.mm.loader.g.a.a<r> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(166312);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    AppMethodBeat.o(166312);
    return true;
  }
  
  public final boolean a(com.tencent.mm.loader.g.a.a<r> parama, com.tencent.mm.loader.g.f<?> paramf, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(166311);
    s.u(parama, "url");
    s.u(paramf, "httpResponse");
    s.u(parame, "opts");
    s.u(paramf1, "reaper");
    AppMethodBeat.o(166311);
    return true;
  }
  
  public final com.tencent.mm.loader.g.b.a b(com.tencent.mm.loader.g.a.a<r> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(166314);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    parame = c(parama, parame, paramf);
    Log.v("Finder.Loader", "url " + parama + " and path " + parame + " fileret " + y.ZC(parame) + " type " + ((r)parama.bmg()).eCd());
    if (y.ZC(parame))
    {
      parama = com.tencent.mm.loader.g.b.a.GJ(parame);
      AppMethodBeat.o(166314);
      return parama;
    }
    parame = parama.bmg();
    if (((r)parame instanceof b)) {}
    for (;;)
    {
      parame = (r)parame;
      if ((parame == null) || (!((b)parame).eCj())) {
        break;
      }
      paramf = (b)parame;
      bm localbm = bm.GlZ;
      paramf = s.X(bm.fij(), paramf.eCh());
      if (!y.ZC(paramf)) {
        break;
      }
      Log.v("Finder.Loader", "exist origin url disk cache, rawUrl " + ((b)parame).idu + " and originUrlPath " + paramf);
      parama = com.tencent.mm.loader.g.b.a.GJ(paramf);
      AppMethodBeat.o(166314);
      return parama;
      parame = null;
    }
    if (((r)parama.bmg()).eCd() == v.FKZ)
    {
      if (y.ZC(((r)parama.bmg()).eCi()))
      {
        parama = com.tencent.mm.loader.g.b.a.GJ(((r)parama.bmg()).eCi());
        AppMethodBeat.o(166314);
        return parama;
      }
    }
    else if (y.ZC(((r)parama.bmg()).getUrl()))
    {
      parama = com.tencent.mm.loader.g.b.a.GJ(((r)parama.bmg()).getUrl());
      AppMethodBeat.o(166314);
      return parama;
    }
    AppMethodBeat.o(166314);
    return null;
  }
  
  public final String c(com.tencent.mm.loader.g.a.a<r> parama, e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(166313);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    parama = ((r)parama.bmg()).getPath();
    AppMethodBeat.o(166313);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.j
 * JD-Core Version:    0.7.0.1
 */