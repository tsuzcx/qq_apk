package com.tencent.mm.plugin.finder.megavideo.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.plugin.finder.cgi.cz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "context", "Landroid/content/Context;", "hasMore", "", "isLoading", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "listener", "Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader$BulletLoadListener;", "maxBulletTime", "", "megaVideoFeed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "getMegaVideoFeed", "()Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "setMegaVideoFeed", "(Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;)V", "minBulletTime", "checkLoadMore", "", "time", "onAttach", "feed", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestEnter", "requestLoadMore", "BulletLoadListener", "Companion", "plugin-finder_release"})
public final class a
  implements i
{
  public static final a zwN;
  
  static
  {
    AppMethodBeat.i(275310);
    zwN = new a((byte)0);
    AppMethodBeat.o(275310);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(275308);
    p.k(paramq, "scene");
    if ((paramq instanceof cz))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        AppMethodBeat.o(275308);
        throw null;
      }
      Log.e("Finder.MegaVideoBulletLoader", "NetSceneMegaVideoGetBullet: errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
    }
    AppMethodBeat.o(275308);
    throw null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public b(a parama, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.loader.a
 * JD-Core Version:    0.7.0.1
 */