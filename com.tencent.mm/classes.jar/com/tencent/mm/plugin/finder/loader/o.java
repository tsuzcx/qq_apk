package com.tencent.mm.plugin.finder.loader;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.e;
import com.tencent.mm.ao.e.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.video.FinderVideoView;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import d.g.a.a;
import d.g.b.q;
import d.g.b.y.a;
import d.l;
import d.z;
import java.util.concurrent.atomic.AtomicBoolean;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "", "preloadCoreCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "getPreloadCoreCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "createVideoProxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "runOnUI", "", "run", "Lkotlin/Function0;", "CdnCallback", "Companion", "VideoProxy", "plugin-finder_release"})
public final class o
{
  public static final b sjp;
  final MediaPreloadCore sjo;
  
  static
  {
    AppMethodBeat.i(166363);
    sjp = new b((byte)0);
    AppMethodBeat.o(166363);
  }
  
  public o(MediaPreloadCore paramMediaPreloadCore)
  {
    this.sjo = paramMediaPreloadCore;
  }
  
  public static void A(a<z> parama)
  {
    AppMethodBeat.i(166362);
    d.g.b.p.h(parama, "run");
    com.tencent.mm.ad.c.g((a)new d(parama));
    AppMethodBeat.o(166362);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isStopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/lang/Object;)V", "onDataAvailable", "", "mediaId", "", "offset", "", "total", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReady", "svrflag", "onProgress", "plugin-finder_release"})
  final class a
    implements h.a
  {
    private final Object lock;
    final b.a pzN;
    final m rQu;
    final t sjq;
    final AtomicBoolean sjr;
    
    public a(b.a parama, m paramm, AtomicBoolean paramAtomicBoolean, Object paramObject)
    {
      AppMethodBeat.i(202928);
      this.sjq = parama;
      this.pzN = paramm;
      this.rQu = paramAtomicBoolean;
      this.sjr = paramObject;
      this.lock = localObject;
      AppMethodBeat.o(202928);
    }
    
    public final void a(final String paramString, final int paramInt, final d paramd)
    {
      int i = 1;
      AppMethodBeat.i(166348);
      d.g.b.p.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        if (!this.sjr.get())
        {
          if (paramd == null) {
            break label314;
          }
          ad.i("Finder.VideoDownloader", "[onFinish] mediaId=" + paramString + " ret=" + paramInt + " fileLength=" + paramd.field_fileLength + ' ' + "sceneResult=" + paramd.field_retCode + " videoFormat:" + paramd.field_videoFormat + " videoFlag=" + paramd.field_videoFlag);
          localObject2 = o.sjp;
          d.g.b.p.h(paramString, "mediaId");
          localObject2 = new long[3];
          CdnLogic.queryDownloadedSize(paramString, (long[])localObject2);
          if ((localObject2[0] != localObject2[1]) || (localObject2[1] != localObject2[2])) {
            break label251;
          }
        }
        for (;;)
        {
          if ((i == 0) && ((i.IS_FLAVOR_PURPLE) || (i.DEBUG))) {
            com.tencent.mm.ad.c.g((a)d.sjA);
          }
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
          com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, paramd.field_fileLength, paramd.field_fileLength, 3);
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
          com.tencent.mm.plugin.finder.storage.logic.c.aiC(paramString);
          o.A((a)new b(this, paramd, paramString, paramInt));
          paramString = z.MKo;
          AppMethodBeat.o(166348);
          return;
          label251:
          ad.e("Finder.VideoDownloader", "[checkFinishValid] mediaId=" + paramString + ' ' + localObject2[0] + ':' + localObject2[1] + ':' + localObject2[2]);
          i = 0;
        }
        label314:
        Object localObject2 = (a)this;
        ad.e("Finder.VideoDownloader", "sceneResult is null! mediaId=" + paramString + " ret=" + paramInt);
        o.A((a)new c((a)localObject2, this, paramd, paramString, paramInt));
      }
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(202927);
      d.g.b.p.h(paramString1, "mediaId");
      for (;;)
      {
        synchronized (this.lock)
        {
          ad.i("Finder.VideoDownloader", "[onMoovReady] mediaId=" + paramString1 + " offset=" + paramLong1 + " total=" + paramLong2 + " fileFormat=[" + this.rQu.siD + "=>" + paramString2 + "]} isHasStop=" + this.sjr.get());
          if (!this.sjr.get())
          {
            y.a locala = new y.a();
            locala.MLQ = false;
            if ((this.pzN instanceof FinderVideoView)) {
              locala.MLQ = ((FinderVideoView)this.pzN).xr(paramLong1);
            }
            localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
            if (paramString2 == null)
            {
              localObject1 = "";
              com.tencent.mm.plugin.finder.storage.logic.c.gp(paramString1, (String)localObject1);
              localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
              com.tencent.mm.plugin.finder.storage.logic.c.aiC(paramString1);
              o.A((a)new e(locala, this, paramString1, paramLong1, paramLong2, paramString2));
            }
          }
          else
          {
            paramString1 = z.MKo;
            AppMethodBeat.o(202927);
            return;
          }
        }
        Object localObject1 = paramString2;
      }
    }
    
    public final void i(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(166347);
      d.g.b.p.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        if (!this.sjr.get())
        {
          ad.i("Finder.VideoDownloader", "[onProgress] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2);
          com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
          com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, paramLong1, paramLong2, 1);
          localc = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
          com.tencent.mm.plugin.finder.storage.logic.c.aiC(paramString);
          o.A((a)new f(this, paramString, paramLong1, paramLong2));
        }
        paramString = z.MKo;
        AppMethodBeat.o(166347);
        return;
      }
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(166346);
      d.g.b.p.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        if (!this.sjr.get()) {
          o.A((a)new a(this, paramString, paramLong1, paramLong2));
        }
        z localz = z.MKo;
        ad.i("Finder.VideoDownloader", "[onDataAvailable] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2);
        AppMethodBeat.o(166346);
        return;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onDataAvailable$1$1"})
    static final class a
      extends q
      implements a<z>
    {
      a(o.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onFinish$1$1$2", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$$special$$inlined$let$lambda$1"})
    static final class b
      extends q
      implements a<z>
    {
      b(o.a parama, d paramd, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onFinish$1$2$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$$special$$inlined$run$lambda$1"})
    static final class c
      extends q
      implements a<z>
    {
      c(o.a parama1, o.a parama2, d paramd, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements a<z>
    {
      public static final d sjA;
      
      static
      {
        AppMethodBeat.i(202926);
        sjA = new d();
        AppMethodBeat.o(202926);
      }
      
      d()
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onMoovReady$1$1"})
    static final class e
      extends q
      implements a<z>
    {
      e(y.a parama, o.a parama1, String paramString1, long paramLong1, long paramLong2, String paramString2)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onProgress$1$1"})
    static final class f
      extends q
      implements a<z>
    {
      f(o.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$Companion;", "", "()V", "TAG", "", "checkFinishValid", "", "mediaId", "plugin-finder_release"})
  public static final class b {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "getEngineCallback", "()Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "setEngineCallback", "(Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;)V", "isHasStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isVideoDataAvailable", "", "mediaId", "", "offset", "", "length", "requestVideoData", "", "setIEngineCallback", "startHttpStream", "filePath", "url", "stop", "plugin-finder_release"})
  public final class c
    implements b
  {
    private final Object lock;
    private b.a pzN;
    final m rQu;
    private final AtomicBoolean sjD;
    private y sjE;
    final t sjq;
    
    public c(t paramt)
    {
      AppMethodBeat.i(202929);
      this.rQu = paramt;
      Object localObject;
      this.sjq = localObject;
      this.sjD = new AtomicBoolean(false);
      this.lock = new Object();
      AppMethodBeat.o(202929);
    }
    
    public final void a(b.a parama)
    {
      AppMethodBeat.i(166359);
      d.g.b.p.h(parama, "callback");
      this.pzN = parama;
      AppMethodBeat.o(166359);
    }
    
    public final void gj(final String paramString)
    {
      AppMethodBeat.i(166356);
      synchronized (this.lock)
      {
        this.sjD.compareAndSet(false, true);
        ad.i("Finder.VideoDownloader", "[stop] mediaId=".concat(String.valueOf(paramString)));
        if (paramString != null)
        {
          com.tencent.mm.modelvideo.o.aMK().a(paramString, (e.a)new b(this, paramString));
          MediaPreloadCore localMediaPreloadCore = o.this.sjo;
          if (localMediaPreloadCore != null)
          {
            localMediaPreloadCore.ba(paramString, false);
            paramString = z.MKo;
          }
        }
        AppMethodBeat.o(166356);
        return;
      }
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(166358);
      d.g.b.p.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        StringBuilder localStringBuilder = new StringBuilder("[isVideoDataAvailable] mediaId=").append(paramString).append(" offset=").append(paramInt1).append(" length=").append(paramInt2).append(" cacheSize=");
        Object localObject1 = this.sjE;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((y)localObject1).field_cacheSize);
          ad.i("Finder.VideoDownloader", localObject1);
          localObject1 = this.sjq;
          if (localObject1 != null) {
            ((t)localObject1).ae(paramString, paramInt1, paramInt2);
          }
          boolean bool = com.tencent.mm.modelvideo.o.aMK().isVideoDataAvailable(paramString, paramInt1, paramInt2);
          AppMethodBeat.o(166358);
          return bool;
        }
        localObject1 = null;
      }
    }
    
    public final void p(final String paramString1, final String paramString2, final String paramString3)
    {
      AppMethodBeat.i(166355);
      d.g.b.p.h(paramString1, "mediaId");
      d.g.b.p.h(paramString2, "filePath");
      d.g.b.p.h(paramString3, "url");
      synchronized (this.lock)
      {
        this.sjD.set(false);
        Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
        y localy = com.tencent.mm.plugin.finder.storage.logic.c.aiD(paramString1);
        localy.field_reqFormat = this.rQu.sjm;
        if (localy.field_fileFormat == null) {}
        for (localObject1 = this.rQu.siD.detail;; localObject1 = localy.field_fileFormat)
        {
          localy.field_fileFormat = ((String)localObject1);
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
          localObject1 = this.rQu.siC.mediaId;
          d.g.b.p.g(localObject1, "video.mediaObj.mediaId");
          int i = this.rQu.sjm;
          Object localObject3 = localy.field_fileFormat;
          d.g.b.p.g(localObject3, "this.field_fileFormat");
          com.tencent.mm.plugin.finder.storage.logic.c.a(paramString1, (String)localObject1, paramString3, paramString2, i, (String)localObject3, localy.field_cacheSize, localy.field_totalSize, 1, this.rQu.siC.videoDuration, this.rQu.cCz(), this.rQu.cCy());
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
          i = localy.field_reqFormat;
          localObject1 = localy.field_fileFormat;
          d.g.b.p.g(localObject1, "videoCache.field_fileFormat");
          localObject1 = com.tencent.mm.plugin.finder.utils.p.a(paramString1, paramString3, paramString2, i, (String)localObject1, this.rQu.cCz(), this.rQu.cCy(), (h.a)new o.a(o.this, this.sjq, this.pzN, this.rQu, this.sjD, this.lock), "Finder.VideoDownloader");
          this.sjE = localy;
          localObject3 = o.this.sjo;
          if (localObject3 != null) {
            ((MediaPreloadCore)localObject3).ba(paramString1, true);
          }
          ad.i("Finder.VideoDownloader", "[startHttpStream] fallback cancel mediaId=" + paramString1 + " isPreLoadCompleted=" + localy.cCX() + ' ' + "isAllCompleted=" + localy.cCW() + " file=" + paramString2 + ", " + paramString3 + " isMoovReady=" + localy.field_moovReady);
          if (!localy.cCW()) {
            break;
          }
          ad.i("Finder.VideoDownloader", "[finish] mediaId=" + paramString1 + " cacheSize=" + localy.field_cacheSize + " totalSize=" + localy.field_totalSize + '}');
          ((h)localObject1).fJN.a(paramString1, localy.field_cacheSize, localy.field_totalSize, localy.field_fileFormat);
          ((h)localObject1).fJN.i(paramString1, localy.field_cacheSize, localy.field_totalSize);
          ((h)localObject1).fJN.a(paramString1, 0, null);
          paramString2 = o.this.sjo;
          if (paramString2 != null) {
            paramString2.ba(paramString1, false);
          }
          AppMethodBeat.o(166355);
          return;
        }
        com.tencent.mm.modelvideo.o.aMK().a((h)localObject1);
        o.A((a)new a(this, paramString1, paramString3, paramString2));
        paramString1 = z.MKo;
        AppMethodBeat.o(166355);
        return;
      }
    }
    
    public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(166357);
      d.g.b.p.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        StringBuilder localStringBuilder = new StringBuilder("[requestVideoData] mediaId=").append(paramString).append(" offset=").append(paramInt1).append(" length=").append(paramInt2).append(" cacheSize=");
        Object localObject1 = this.sjE;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((y)localObject1).field_cacheSize);
          ad.i("Finder.VideoDownloader", localObject1);
          com.tencent.mm.modelvideo.o.aMK();
          e.r(paramString, paramInt1, paramInt2);
          AppMethodBeat.o(166357);
          return;
        }
        localObject1 = null;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$startHttpStream$1$1"})
    static final class a
      extends q
      implements a<z>
    {
      a(o.c paramc, String paramString1, String paramString2, String paramString3)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "kotlin.jvm.PlatformType", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "isFinish", "", "onStop", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$stop$1$1$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$$special$$inlined$let$lambda$1"})
    static final class b
      implements e.a
    {
      b(o.c paramc, String paramString) {}
      
      public final void a(final h paramh, final d paramd)
      {
        AppMethodBeat.i(166354);
        o.A((a)new q(paramh) {});
        AppMethodBeat.o(166354);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<z>
  {
    d(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.o
 * JD-Core Version:    0.7.0.1
 */