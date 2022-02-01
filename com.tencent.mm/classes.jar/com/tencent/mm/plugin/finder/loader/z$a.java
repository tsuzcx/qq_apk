package com.tencent.mm.plugin.finder.loader;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.video.FinderVideoView;
import com.tencent.mm.plugin.finder.video.y;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.a;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isStopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/lang/Object;)V", "onDataAvailable", "", "mediaId", "", "offset", "", "total", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onProgress", "plugin-finder_release"})
final class z$a
  implements h.a
{
  private final Object lock;
  private final f.a uyX;
  private final y zuX;
  private final aa zuY;
  private final AtomicBoolean zuZ;
  
  public z$a(y paramy, f.a parama, aa paramaa, AtomicBoolean paramAtomicBoolean, Object paramObject)
  {
    AppMethodBeat.i(291671);
    this.zuX = parama;
    this.uyX = paramaa;
    this.zuY = paramAtomicBoolean;
    this.zuZ = paramObject;
    this.lock = localObject;
    AppMethodBeat.o(291671);
  }
  
  public final void Kj(String paramString)
  {
    AppMethodBeat.i(291669);
    p.k(paramString, "mediaId");
    AppMethodBeat.o(291669);
  }
  
  public final void a(final String paramString, final int paramInt, final com.tencent.mm.i.d paramd)
  {
    int i = 1;
    AppMethodBeat.i(166348);
    p.k(paramString, "mediaId");
    synchronized (this.lock)
    {
      if (!this.zuZ.get())
      {
        if (paramd == null) {
          break label314;
        }
        Log.i("Finder.VideoDownloader", "[onFinish] mediaId=" + paramString + " ret=" + paramInt + " fileLength=" + paramd.field_fileLength + ' ' + "sceneResult=" + paramd.field_retCode + " videoFormat:" + paramd.field_videoFormat + " videoFlag=" + paramd.field_videoFlag);
        localObject2 = z.zuW;
        p.k(paramString, "mediaId");
        localObject2 = new long[3];
        CdnLogic.queryDownloadedSize(paramString, (long[])localObject2);
        if ((localObject2[0] != localObject2[1]) || (localObject2[1] != localObject2[2])) {
          break label251;
        }
      }
      for (;;)
      {
        if ((i == 0) && ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))) {
          com.tencent.mm.ae.d.uiThread((a)z.a.d.zvi);
        }
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, paramd.field_fileLength, paramd.field_fileLength, 3);
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        com.tencent.mm.plugin.finder.storage.logic.d.aET(paramString);
        z.U((a)new b(this, paramd, paramString, paramInt));
        paramString = x.aazN;
        AppMethodBeat.o(166348);
        return;
        label251:
        Log.e("Finder.VideoDownloader", "[checkFinishValid] mediaId=" + paramString + ' ' + localObject2[0] + ':' + localObject2[1] + ':' + localObject2[2]);
        i = 0;
      }
      label314:
      Object localObject2 = (a)this;
      Log.e("Finder.VideoDownloader", "sceneResult is null! mediaId=" + paramString + " ret=" + paramInt);
      z.U((a)new c((a)localObject2, this, paramd, paramString, paramInt));
    }
  }
  
  public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
  {
    AppMethodBeat.i(291670);
    p.k(paramString1, "mediaId");
    for (;;)
    {
      synchronized (this.lock)
      {
        Log.i("Finder.VideoDownloader", "[onMoovReady] mediaId=" + paramString1 + " offset=" + paramLong1 + " total=" + paramLong2 + " fileFormat=[" + this.zuY.ztP + "=>" + paramString2 + "]} isHasStop=" + this.zuZ.get());
        if (!this.zuZ.get())
        {
          aa.a locala = new aa.a();
          locala.aaBx = false;
          if ((this.uyX instanceof FinderVideoView)) {
            locala.aaBx = ((FinderVideoView)this.uyX).Nq(paramLong1);
          }
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
          if (!com.tencent.mm.plugin.finder.storage.logic.d.aEU(paramString1).field_moovReady)
          {
            bool = true;
            localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
            if (paramString2 != null) {
              break label256;
            }
            localObject1 = "";
            com.tencent.mm.plugin.finder.storage.logic.d.hl(paramString1, (String)localObject1);
            localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
            com.tencent.mm.plugin.finder.storage.logic.d.aET(paramString1);
            z.U((a)new e(locala, bool, this, paramString1, paramLong1, paramLong2, paramString2));
          }
        }
        else
        {
          paramString1 = x.aazN;
          AppMethodBeat.o(291670);
          return;
        }
        final boolean bool = false;
      }
      label256:
      Object localObject1 = paramString2;
    }
  }
  
  public final void h(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(166347);
    p.k(paramString, "mediaId");
    synchronized (this.lock)
    {
      if (!this.zuZ.get())
      {
        Log.i("Finder.VideoDownloader", "[onProgress] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2);
        com.tencent.mm.plugin.finder.storage.logic.d locald = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, paramLong1, paramLong2, 1);
        locald = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        com.tencent.mm.plugin.finder.storage.logic.d.aET(paramString);
        z.U((a)new f(this, paramString, paramLong1, paramLong2));
      }
      paramString = x.aazN;
      AppMethodBeat.o(166347);
      return;
    }
  }
  
  public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(166346);
    p.k(paramString, "mediaId");
    synchronized (this.lock)
    {
      if (!this.zuZ.get()) {
        z.U((a)new a(this, paramString, paramLong1, paramLong2));
      }
      x localx = x.aazN;
      Log.i("Finder.VideoDownloader", "[onDataAvailable] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2);
      AppMethodBeat.o(166346);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onDataAvailable$1$1"})
  static final class a
    extends q
    implements a<x>
  {
    a(z.a parama, String paramString, long paramLong1, long paramLong2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onFinish$1$1$2", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$$special$$inlined$let$lambda$1"})
  static final class b
    extends q
    implements a<x>
  {
    b(z.a parama, com.tencent.mm.i.d paramd, String paramString, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onFinish$1$2$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$$special$$inlined$run$lambda$1"})
  static final class c
    extends q
    implements a<x>
  {
    c(z.a parama1, z.a parama2, com.tencent.mm.i.d paramd, String paramString, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onMoovReady$1$1"})
  static final class e
    extends q
    implements a<x>
  {
    e(aa.a parama, boolean paramBoolean, z.a parama1, String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onProgress$1$1"})
  static final class f
    extends q
    implements a<x>
  {
    f(z.a parama, String paramString, long paramLong1, long paramLong2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.z.a
 * JD-Core Version:    0.7.0.1
 */