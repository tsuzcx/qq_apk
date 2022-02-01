package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.an.e.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.b;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.a;
import d.g.b.k;
import d.g.b.v.a;
import d.y;
import java.util.concurrent.atomic.AtomicBoolean;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "", "preloadCoreCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "createVideoProxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "runOnUI", "", "run", "Lkotlin/Function0;", "CdnCallback", "Companion", "VideoProxy", "plugin-finder_release"})
public final class n
{
  public static final b rtZ;
  private final MediaPreloadCore rtY;
  
  static
  {
    AppMethodBeat.i(166363);
    rtZ = new b((byte)0);
    AppMethodBeat.o(166363);
  }
  
  public n(MediaPreloadCore paramMediaPreloadCore)
  {
    this.rtY = paramMediaPreloadCore;
  }
  
  public static void w(a<y> parama)
  {
    AppMethodBeat.i(166362);
    k.h(parama, "run");
    com.tencent.mm.ac.c.g((a)new d(parama));
    AppMethodBeat.o(166362);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onFinish$1$2$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$$special$$inlined$run$lambda$1"})
  static final class a$c
    extends d.g.b.l
    implements a<y>
  {
    a$c(n.a parama1, n.a parama2, d paramd, String paramString, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a$d
    extends d.g.b.l
    implements a<y>
  {
    public static final d ruk;
    
    static
    {
      AppMethodBeat.i(202540);
      ruk = new d();
      AppMethodBeat.o(202540);
    }
    
    a$d()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onMoovReady$1$1"})
  static final class a$e
    extends d.g.b.l
    implements a<y>
  {
    a$e(v.a parama, n.a parama1, String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onProgress$1$1"})
  static final class a$f
    extends d.g.b.l
    implements a<y>
  {
    a$f(n.a parama, String paramString, long paramLong1, long paramLong2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$Companion;", "", "()V", "TAG", "", "checkFinishValid", "", "mediaId", "plugin-finder_release"})
  public static final class b {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "getEngineCallback", "()Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "setEngineCallback", "(Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;)V", "isHasStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isVideoDataAvailable", "", "mediaId", "", "offset", "", "length", "requestVideoData", "", "setIEngineCallback", "startHttpStream", "filePath", "url", "stop", "plugin-finder_release"})
  public final class c
    implements b
  {
    private final Object lock;
    private b.a oWd;
    final l rcZ;
    final t rua;
    private final AtomicBoolean run;
    private w ruo;
    
    public c(t paramt)
    {
      AppMethodBeat.i(202543);
      this.rcZ = paramt;
      Object localObject;
      this.rua = localObject;
      this.run = new AtomicBoolean(false);
      this.lock = new Object();
      AppMethodBeat.o(202543);
    }
    
    public final void a(b.a parama)
    {
      AppMethodBeat.i(166359);
      k.h(parama, "callback");
      this.oWd = parama;
      AppMethodBeat.o(166359);
    }
    
    public final void fo(final String paramString)
    {
      AppMethodBeat.i(166356);
      synchronized (this.lock)
      {
        this.run.compareAndSet(false, true);
        ac.i("Finder.VideoDownloader", "[stop] mediaId=".concat(String.valueOf(paramString)));
        if (paramString != null)
        {
          o.aJz().a(paramString, (e.a)new b(this, paramString));
          MediaPreloadCore localMediaPreloadCore = n.a(n.this);
          if (localMediaPreloadCore != null)
          {
            localMediaPreloadCore.aY(paramString, false);
            paramString = y.KTp;
          }
        }
        AppMethodBeat.o(166356);
        return;
      }
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(166358);
      k.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        StringBuilder localStringBuilder = new StringBuilder("[isVideoDataAvailable] mediaId=").append(paramString).append(" offset=").append(paramInt1).append(" length=").append(paramInt2).append(" cacheSize=");
        Object localObject1 = this.ruo;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((w)localObject1).field_cacheSize);
          ac.i("Finder.VideoDownloader", localObject1);
          localObject1 = this.rua;
          if (localObject1 != null) {
            ((t)localObject1).aa(paramString, paramInt1, paramInt2);
          }
          boolean bool = o.aJz().isVideoDataAvailable(paramString, paramInt1, paramInt2);
          AppMethodBeat.o(166358);
          return bool;
        }
        localObject1 = null;
      }
    }
    
    public final void q(final String paramString1, final String paramString2, final String paramString3)
    {
      AppMethodBeat.i(166355);
      k.h(paramString1, "mediaId");
      k.h(paramString2, "filePath");
      k.h(paramString3, "url");
      synchronized (this.lock)
      {
        this.run.set(false);
        Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
        w localw = com.tencent.mm.plugin.finder.storage.logic.c.aei(paramString1);
        localw.field_reqFormat = this.rcZ.rtW;
        if (localw.field_fileFormat == null) {}
        for (localObject1 = this.rcZ.rtm.detail;; localObject1 = localw.field_fileFormat)
        {
          localw.field_fileFormat = ((String)localObject1);
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
          localObject1 = this.rcZ.rtl.mediaId;
          k.g(localObject1, "video.mediaObj.mediaId");
          int i = this.rcZ.rtW;
          localObject3 = localw.field_fileFormat;
          k.g(localObject3, "this.field_fileFormat");
          com.tencent.mm.plugin.finder.storage.logic.c.a(paramString1, (String)localObject1, paramString3, paramString2, i, (String)localObject3, localw.field_cacheSize, localw.field_totalSize, 1);
          localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
          i = localw.field_reqFormat;
          localObject1 = localw.field_fileFormat;
          k.g(localObject1, "videoCache.field_fileFormat");
          localObject1 = com.tencent.mm.plugin.finder.utils.n.a(paramString1, paramString3, paramString2, i, (String)localObject1, this.rcZ.cwl(), this.rcZ.cwk(), (h.a)new n.a(n.this, this.rua, this.oWd, this.rcZ, this.run, this.lock), "Finder.VideoDownloader");
          this.ruo = localw;
          localObject3 = n.a(n.this);
          if (localObject3 != null) {
            ((MediaPreloadCore)localObject3).aY(paramString1, true);
          }
          ac.i("Finder.VideoDownloader", "[startHttpStream] fallback cancel mediaId=" + paramString1 + " isPreLoadCompleted=" + localw.cwH() + ' ' + "isAllCompleted=" + localw.cwG() + " file=" + paramString2 + ", " + paramString3);
          if (!localw.cwG()) {
            break;
          }
          ac.i("Finder.VideoDownloader", "[finish] mediaId=" + paramString1 + " cacheSize=" + localw.field_cacheSize + " totalSize=" + localw.field_totalSize + '}');
          ((h)localObject1).frE.a(paramString1, localw.field_cacheSize, localw.field_totalSize, localw.field_fileFormat);
          ((h)localObject1).frE.i(paramString1, localw.field_cacheSize, localw.field_totalSize);
          ((h)localObject1).frE.a(paramString1, 0, null);
          AppMethodBeat.o(166355);
          return;
        }
        Object localObject3 = MediaPreloadCore.rvo;
        localObject3 = MediaPreloadCore.a.a(localw);
        if ((!((MediaPreloadCore.b)localObject3).rvp) && (localw.cwH()) && (!localw.cwG())) {
          ac.e("Finder.VideoDownloader", "why has preload, but moov is not ready??? offset=" + ((MediaPreloadCore.b)localObject3).offset + " length=" + ((MediaPreloadCore.b)localObject3).length + ' ' + localw.field_mediaId + " cache=" + localw.field_cacheSize);
        }
        if (n.a(n.this) != null) {
          MediaPreloadCore.adH(paramString1);
        }
        o.aJz().a((h)localObject1);
        n.w((a)new a(this, paramString1, paramString3, paramString2));
        paramString1 = y.KTp;
        AppMethodBeat.o(166355);
        return;
      }
    }
    
    public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(166357);
      k.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        StringBuilder localStringBuilder = new StringBuilder("[requestVideoData] mediaId=").append(paramString).append(" offset=").append(paramInt1).append(" length=").append(paramInt2).append(" cacheSize=");
        Object localObject1 = this.ruo;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((w)localObject1).field_cacheSize);
          ac.i("Finder.VideoDownloader", localObject1);
          o.aJz();
          e.p(paramString, paramInt1, paramInt2);
          AppMethodBeat.o(166357);
          return;
        }
        localObject1 = null;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$startHttpStream$1$1"})
    static final class a
      extends d.g.b.l
      implements a<y>
    {
      a(n.c paramc, String paramString1, String paramString2, String paramString3)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "kotlin.jvm.PlatformType", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "isFinish", "", "onStop", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$stop$1$1$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$$special$$inlined$let$lambda$1"})
    static final class b
      implements e.a
    {
      b(n.c paramc, String paramString) {}
      
      public final void a(final h paramh, final d paramd)
      {
        AppMethodBeat.i(166354);
        n.w((a)new d.g.b.l(paramh) {});
        AppMethodBeat.o(166354);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<y>
  {
    d(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.n
 * JD-Core Version:    0.7.0.1
 */