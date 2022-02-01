package com.tencent.mm.plugin.finder.megavideo.loader;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.cgi.ct;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "context", "Landroid/content/Context;", "hasMore", "", "isLoading", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "listener", "Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader$BulletLoadListener;", "maxBulletTime", "", "megaVideoFeed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "getMegaVideoFeed", "()Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "setMegaVideoFeed", "(Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;)V", "minBulletTime", "checkLoadMore", "", "time", "onAttach", "feed", "onDetach", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestEnter", "requestLoadMore", "BulletLoadListener", "Companion", "plugin-finder_release"})
public final class a
  implements i
{
  public static final b uLm;
  public Context context;
  private boolean hasMore;
  private boolean isLoading;
  b lastBuffer;
  public bm uJO;
  public a uLj;
  private long uLk;
  long uLl;
  
  static
  {
    AppMethodBeat.i(248432);
    uLm = new b((byte)0);
    AppMethodBeat.o(248432);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(248431);
    p.h(paramq, "scene");
    boolean bool;
    if ((paramq instanceof ct))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label416;
      }
      long l = ((ct)paramq).twG;
      paramString = this.uJO;
      if (paramString == null) {
        p.btv("megaVideoFeed");
      }
      if (l != paramString.lT())
      {
        AppMethodBeat.o(248431);
        return;
      }
      if ((this.uLk == ((ct)paramq).cZp()) && (this.uLl == ((ct)paramq).cZq()))
      {
        paramString = new StringBuilder("onSceneEnd: hasMore = false, id=");
        localObject = this.uJO;
        if (localObject == null) {
          p.btv("megaVideoFeed");
        }
        Log.i("Finder.MegaVideoBulletLoader", ((bm)localObject).lT() + ", pullType=" + ((ct)paramq).pullType + ',' + " minBulletTime = " + this.uLk + ", maxBulletTime = " + this.uLl);
        this.hasMore = false;
        AppMethodBeat.o(248431);
        return;
      }
      this.uLk = ((ct)paramq).cZp();
      this.uLl = ((ct)paramq).cZq();
      this.lastBuffer = ((ct)paramq).cYz();
      paramString = ((ct)paramq).cZo();
      if (((Collection)paramString).isEmpty()) {
        break label405;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label410;
      }
      Object localObject = new StringBuilder("onSceneEnd: size = ").append(paramString.size()).append(", id=");
      bm localbm = this.uJO;
      if (localbm == null) {
        p.btv("megaVideoFeed");
      }
      Log.i("Finder.MegaVideoBulletLoader", localbm.lT() + ", pullType=" + ((ct)paramq).pullType + ',' + " minBulletTime = " + this.uLk + ", maxBulletTime = " + this.uLl);
      paramq = this.uLj;
      if (paramq != null) {
        paramq.eh(paramString);
      }
      bool = true;
      label388:
      this.hasMore = bool;
    }
    for (;;)
    {
      this.isLoading = false;
      AppMethodBeat.o(248431);
      return;
      label405:
      paramInt1 = 0;
      break;
      label410:
      bool = false;
      break label388;
      label416:
      Log.e("Finder.MegaVideoBulletLoader", "NetSceneMegaVideoGetBullet: errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader$BulletLoadListener;", "", "onBulletIncrease", "", "increaseList", "", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void eh(List<? extends cni> paramList);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/loader/MegaVideoBulletLoader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public c(a parama, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.loader.a
 * JD-Core Version:    0.7.0.1
 */