package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.cache.memory.DefaultBitmapMemoryCache;
import com.tencent.mm.loader.g.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderBitmapMemoryCache;", "Lcom/tencent/mm/loader/cache/memory/DefaultBitmapMemoryCache;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "get", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends DefaultBitmapMemoryCache<r>
{
  public static final d.a Exk;
  
  static
  {
    AppMethodBeat.i(331718);
    Exk = new d.a((byte)0);
    AppMethodBeat.o(331718);
  }
  
  public final e<Bitmap> a(com.tencent.mm.loader.g.a.a<r> parama, com.tencent.mm.loader.d.c.a<Bitmap> parama1)
  {
    AppMethodBeat.i(331726);
    s.u(parama, "url");
    Object localObject = super.a(parama, parama1);
    if (localObject != null)
    {
      AppMethodBeat.o(331726);
      return localObject;
    }
    parama = parama.bmg();
    if (((r)parama instanceof b))
    {
      localObject = (r)parama;
      if ((localObject == null) || (!((b)localObject).eCj())) {
        break label172;
      }
      if (parama1 != null) {
        break label154;
      }
      parama = null;
      label69:
      if (parama != null) {
        break label169;
      }
      parama = ((b)localObject).eCh();
    }
    label154:
    label169:
    for (;;)
    {
      parama1 = (Bitmap)this.npe.get(parama);
      if (parama1 == null) {
        break label172;
      }
      Log.v("FinderBitmapMemoryCache", "exist origin url memory cache, rawUrl " + ((b)localObject).idu + " and originUrlKey " + parama);
      parama = new e(parama1);
      AppMethodBeat.o(331726);
      return parama;
      parama = null;
      break;
      parama = parama1.GH(((b)localObject).eCh());
      break label69;
    }
    label172:
    AppMethodBeat.o(331726);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.d
 * JD-Core Version:    0.7.0.1
 */