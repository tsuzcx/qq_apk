package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderBitmapMemoryCache;", "Lcom/tencent/mm/loader/cache/memory/DefaultBitmapMemoryCache;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "get", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "Companion", "plugin-finder_release"})
public final class h
  extends com.tencent.mm.loader.b.b.a<w>
{
  public static final a ztr;
  
  static
  {
    AppMethodBeat.i(284914);
    ztr = new a((byte)0);
    AppMethodBeat.o(284914);
  }
  
  public final com.tencent.mm.loader.h.e<Bitmap> a(com.tencent.mm.loader.h.a.a<w> parama, com.tencent.mm.loader.e.c.a<Bitmap> parama1)
  {
    AppMethodBeat.i(284913);
    p.k(parama, "url");
    Object localObject = super.a(parama, parama1);
    if (localObject != null)
    {
      AppMethodBeat.o(284913);
      return localObject;
    }
    parama = parama.aSr();
    if (((w)parama instanceof e)) {}
    for (;;)
    {
      localObject = (w)parama;
      if (localObject == null) {
        break label185;
      }
      if (localObject != null) {
        break;
      }
      parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.loader.FinderAvatar");
      AppMethodBeat.o(284913);
      throw parama;
      parama = null;
    }
    if (((e)localObject).dJc())
    {
      if (parama1 != null)
      {
        parama = parama1.Ot(((e)localObject).dJb());
        if (parama != null) {
          break label192;
        }
      }
      parama = ((e)localObject).dJb();
    }
    label185:
    label192:
    for (;;)
    {
      parama1 = (Bitmap)this.kNp.get(parama);
      if (parama1 != null)
      {
        Log.v("FinderBitmapMemoryCache", "exist origin url memory cache, rawUrl " + ((e)localObject).fXu + " and originUrlKey " + parama);
        parama = new com.tencent.mm.loader.h.e(parama1);
        AppMethodBeat.o(284913);
        return parama;
      }
      AppMethodBeat.o(284913);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderBitmapMemoryCache$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.h
 * JD-Core Version:    0.7.0.1
 */