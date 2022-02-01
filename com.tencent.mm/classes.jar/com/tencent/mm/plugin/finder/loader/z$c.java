package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.e.a;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.preload.c;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.video.y;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "getEngineCallback", "()Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "setEngineCallback", "(Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;)V", "isHasStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isVideoDataAvailable", "", "mediaId", "", "offset", "", "length", "requestVideoData", "", "setIEngineCallback", "startHttpStream", "filePath", "url", "stop", "plugin-finder_release"})
final class z$c
  implements f
{
  private final Object lock;
  private f.a uyX;
  final y zuX;
  final aa zuY;
  private final AtomicBoolean zvm;
  private av zvn;
  
  public z$c(aa paramaa, y paramy)
  {
    AppMethodBeat.i(282502);
    this.zuY = paramy;
    Object localObject;
    this.zuX = localObject;
    this.zvm = new AtomicBoolean(false);
    this.lock = new Object();
    AppMethodBeat.o(282502);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(166359);
    p.k(parama, "callback");
    this.uyX = parama;
    AppMethodBeat.o(166359);
  }
  
  public final void hR(final String paramString)
  {
    AppMethodBeat.i(166356);
    synchronized (this.lock)
    {
      this.zvm.compareAndSet(false, true);
      Log.i("Finder.VideoDownloader", "[stop] mediaId=".concat(String.valueOf(paramString)));
      if (paramString != null)
      {
        s.bqC().a(paramString, (e.a)new b(this, paramString));
        c localc = this.zva.zuV;
        if (localc != null)
        {
          localc.bq(paramString, false);
          paramString = x.aazN;
        }
      }
      AppMethodBeat.o(166356);
      return;
    }
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166358);
    p.k(paramString, "mediaId");
    synchronized (this.lock)
    {
      StringBuilder localStringBuilder = new StringBuilder("[isVideoDataAvailable] mediaId=").append(paramString).append(" offset=").append(paramInt1).append(" length=").append(paramInt2).append(" cacheSize=");
      Object localObject1 = this.zvn;
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((av)localObject1).field_cacheSize);
        Log.i("Finder.VideoDownloader", localObject1);
        localObject1 = this.zuX;
        if (localObject1 != null) {
          ((y)localObject1).ae(paramString, paramInt1, paramInt2);
        }
        boolean bool = s.bqC().isVideoDataAvailable(paramString, paramInt1, paramInt2);
        AppMethodBeat.o(166358);
        return bool;
      }
      localObject1 = null;
    }
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166357);
    p.k(paramString, "mediaId");
    synchronized (this.lock)
    {
      StringBuilder localStringBuilder = new StringBuilder("[requestVideoData] mediaId=").append(paramString).append(" offset=").append(paramInt1).append(" length=").append(paramInt2).append(" cacheSize=");
      Object localObject1 = this.zvn;
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((av)localObject1).field_cacheSize);
        Log.i("Finder.VideoDownloader", localObject1);
        s.bqC();
        e.s(paramString, paramInt1, paramInt2);
        AppMethodBeat.o(166357);
        return;
      }
      localObject1 = null;
    }
  }
  
  public final void s(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(166355);
    p.k(paramString1, "mediaId");
    p.k(paramString2, "filePath");
    p.k(paramString3, "url");
    for (;;)
    {
      synchronized (this.lock)
      {
        this.zvm.set(false);
        Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        av localav = com.tencent.mm.plugin.finder.storage.logic.d.aEU(paramString1);
        localav.field_reqFormat = this.zuY.zvu;
        if (localav.field_fileFormat == null)
        {
          localObject1 = this.zuY.ztP.detail;
          localav.field_fileFormat = ((String)localObject1);
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
          Object localObject2 = this.zuY.ztO.mediaId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          int i = this.zuY.zvu;
          localObject2 = localav.field_fileFormat;
          p.j(localObject2, "this.field_fileFormat");
          com.tencent.mm.plugin.finder.storage.logic.d.a(paramString1, (String)localObject1, paramString3, i, (String)localObject2, localav.field_cacheSize, localav.field_totalSize, 1, this.zuY.ztO.videoDuration, this.zuY.dIZ(), this.zuY.dIY());
          localObject1 = aj.AGc;
          i = localav.field_reqFormat;
          localObject1 = localav.field_fileFormat;
          p.j(localObject1, "videoCache.field_fileFormat");
          localObject2 = this.zuY.dIZ();
          String str = this.zuY.dIY();
          if (this.zuY.ztO.hot_flag != 1) {
            break label633;
          }
          bool = true;
          localObject1 = aj.a(paramString1, paramString3, paramString2, i, (String)localObject1, (String)localObject2, str, bool, (h.a)new z.a(this.zva, this.zuX, this.uyX, this.zuY, this.zvm, this.lock), "Finder.VideoDownloader");
          this.zvn = localav;
          localObject2 = this.zva.zuV;
          if (localObject2 != null) {
            ((c)localObject2).bq(paramString1, true);
          }
          Log.i("Finder.VideoDownloader", "[startHttpStream] fallback cancel mediaId=" + paramString1 + " isPreLoadCompleted=" + localav.dKO() + ' ' + "isAllCompleted=" + localav.dKN() + " file=" + paramString2 + ", " + paramString3 + " isMoovReady=" + localav.field_moovReady);
          if (localav.dKN())
          {
            Log.i("Finder.VideoDownloader", "[finish] mediaId=" + paramString1 + " cacheSize=" + localav.field_cacheSize + " totalSize=" + localav.field_totalSize + '}');
            ((h)localObject1).iVn.a(paramString1, localav.field_cacheSize, localav.field_totalSize, localav.field_fileFormat);
            ((h)localObject1).iVn.h(paramString1, localav.field_cacheSize, localav.field_totalSize);
            ((h)localObject1).iVn.a(paramString1, 0, null);
            paramString2 = this.zva.zuV;
            if (paramString2 != null) {
              paramString2.bq(paramString1, false);
            }
            AppMethodBeat.o(166355);
          }
        }
        else
        {
          localObject1 = localav.field_fileFormat;
          continue;
        }
        s.bqC().e((h)localObject1);
        z.U((a)new a(this, paramString1, paramString3, paramString2));
        paramString1 = x.aazN;
        AppMethodBeat.o(166355);
        return;
      }
      label633:
      boolean bool = false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$startHttpStream$1$1"})
  static final class a
    extends q
    implements a<x>
  {
    a(z.c paramc, String paramString1, String paramString2, String paramString3)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "kotlin.jvm.PlatformType", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "isFinish", "", "onStop", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$stop$1$1$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$$special$$inlined$let$lambda$1"})
  static final class b
    implements e.a
  {
    b(z.c paramc, String paramString) {}
    
    public final void a(final h paramh, final com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(166354);
      z.U((a)new q(paramh) {});
      AppMethodBeat.o(166354);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.z.c
 * JD-Core Version:    0.7.0.1
 */