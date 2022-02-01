package com.tencent.mm.plugin.finder.loader;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.an.e.a;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.video.FinderVideoView;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.j;
import d.g.a.a;
import d.g.b.q;
import d.g.b.y.a;
import d.l;
import java.util.concurrent.atomic.AtomicBoolean;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "", "preloadCoreCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "getPreloadCoreCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "createVideoProxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "runOnUI", "", "run", "Lkotlin/Function0;", "CdnCallback", "Companion", "VideoProxy", "plugin-finder_release"})
public final class o
{
  public static final b ssm;
  final MediaPreloadCore ssl;
  
  static
  {
    AppMethodBeat.i(166363);
    ssm = new b((byte)0);
    AppMethodBeat.o(166363);
  }
  
  public o(MediaPreloadCore paramMediaPreloadCore)
  {
    this.ssl = paramMediaPreloadCore;
  }
  
  public static void z(a<d.z> parama)
  {
    AppMethodBeat.i(166362);
    d.g.b.p.h(parama, "run");
    com.tencent.mm.ac.c.h((a)new d(parama));
    AppMethodBeat.o(166362);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isStopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/lang/Object;)V", "onDataAvailable", "", "mediaId", "", "offset", "", "total", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReady", "svrflag", "onProgress", "plugin-finder_release"})
  final class a
    implements h.a
  {
    private final Object lock;
    final b.a pGr;
    final m rYW;
    final t ssn;
    final AtomicBoolean sso;
    
    public a(b.a parama, m paramm, AtomicBoolean paramAtomicBoolean, Object paramObject)
    {
      AppMethodBeat.i(203408);
      this.ssn = parama;
      this.pGr = paramm;
      this.rYW = paramAtomicBoolean;
      this.sso = paramObject;
      this.lock = localObject;
      AppMethodBeat.o(203408);
    }
    
    public final void a(final String paramString, final int paramInt, final d paramd)
    {
      int i = 1;
      AppMethodBeat.i(166348);
      d.g.b.p.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        if (!this.sso.get())
        {
          if (paramd == null) {
            break label314;
          }
          ae.i("Finder.VideoDownloader", "[onFinish] mediaId=" + paramString + " ret=" + paramInt + " fileLength=" + paramd.field_fileLength + ' ' + "sceneResult=" + paramd.field_retCode + " videoFormat:" + paramd.field_videoFormat + " videoFlag=" + paramd.field_videoFlag);
          localObject2 = o.ssm;
          d.g.b.p.h(paramString, "mediaId");
          localObject2 = new long[3];
          CdnLogic.queryDownloadedSize(paramString, (long[])localObject2);
          if ((localObject2[0] != localObject2[1]) || (localObject2[1] != localObject2[2])) {
            break label251;
          }
        }
        for (;;)
        {
          if ((i == 0) && ((j.IS_FLAVOR_PURPLE) || (j.DEBUG))) {
            com.tencent.mm.ac.c.h((a)d.ssx);
          }
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
          com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, paramd.field_fileLength, paramd.field_fileLength, 3);
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
          com.tencent.mm.plugin.finder.storage.logic.c.ajz(paramString);
          o.z((a)new b(this, paramd, paramString, paramInt));
          paramString = d.z.Nhr;
          AppMethodBeat.o(166348);
          return;
          label251:
          ae.e("Finder.VideoDownloader", "[checkFinishValid] mediaId=" + paramString + ' ' + localObject2[0] + ':' + localObject2[1] + ':' + localObject2[2]);
          i = 0;
        }
        label314:
        Object localObject2 = (a)this;
        ae.e("Finder.VideoDownloader", "sceneResult is null! mediaId=" + paramString + " ret=" + paramInt);
        o.z((a)new c((a)localObject2, this, paramd, paramString, paramInt));
      }
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(203407);
      d.g.b.p.h(paramString1, "mediaId");
      for (;;)
      {
        synchronized (this.lock)
        {
          ae.i("Finder.VideoDownloader", "[onMoovReady] mediaId=" + paramString1 + " offset=" + paramLong1 + " total=" + paramLong2 + " fileFormat=[" + this.rYW.sry + "=>" + paramString2 + "]} isHasStop=" + this.sso.get());
          if (!this.sso.get())
          {
            y.a locala = new y.a();
            locala.NiT = false;
            if ((this.pGr instanceof FinderVideoView)) {
              locala.NiT = ((FinderVideoView)this.pGr).xL(paramLong1);
            }
            localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
            if (paramString2 == null)
            {
              localObject1 = "";
              com.tencent.mm.plugin.finder.storage.logic.c.gu(paramString1, (String)localObject1);
              localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
              com.tencent.mm.plugin.finder.storage.logic.c.ajz(paramString1);
              o.z((a)new e(locala, this, paramString1, paramLong1, paramLong2, paramString2));
            }
          }
          else
          {
            paramString1 = d.z.Nhr;
            AppMethodBeat.o(203407);
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
        if (!this.sso.get())
        {
          ae.i("Finder.VideoDownloader", "[onProgress] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2);
          com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
          com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, paramLong1, paramLong2, 1);
          localc = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
          com.tencent.mm.plugin.finder.storage.logic.c.ajz(paramString);
          o.z((a)new f(this, paramString, paramLong1, paramLong2));
        }
        paramString = d.z.Nhr;
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
        if (!this.sso.get()) {
          o.z((a)new a(this, paramString, paramLong1, paramLong2));
        }
        d.z localz = d.z.Nhr;
        ae.i("Finder.VideoDownloader", "[onDataAvailable] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2);
        AppMethodBeat.o(166346);
        return;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onDataAvailable$1$1"})
    static final class a
      extends q
      implements a<d.z>
    {
      a(o.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onFinish$1$1$2", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$$special$$inlined$let$lambda$1"})
    static final class b
      extends q
      implements a<d.z>
    {
      b(o.a parama, d paramd, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onFinish$1$2$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$$special$$inlined$run$lambda$1"})
    static final class c
      extends q
      implements a<d.z>
    {
      c(o.a parama1, o.a parama2, d paramd, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements a<d.z>
    {
      public static final d ssx;
      
      static
      {
        AppMethodBeat.i(203406);
        ssx = new d();
        AppMethodBeat.o(203406);
      }
      
      d()
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onMoovReady$1$1"})
    static final class e
      extends q
      implements a<d.z>
    {
      e(y.a parama, o.a parama1, String paramString1, long paramLong1, long paramLong2, String paramString2)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onProgress$1$1"})
    static final class f
      extends q
      implements a<d.z>
    {
      f(o.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$Companion;", "", "()V", "TAG", "", "checkFinishValid", "", "mediaId", "plugin-finder_release"})
  public static final class b {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "getEngineCallback", "()Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "setEngineCallback", "(Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;)V", "isHasStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isVideoDataAvailable", "", "mediaId", "", "offset", "", "length", "requestVideoData", "", "setIEngineCallback", "startHttpStream", "filePath", "url", "stop", "plugin-finder_release"})
  public final class c
    implements b
  {
    private final Object lock;
    private b.a pGr;
    final m rYW;
    private final AtomicBoolean ssA;
    private com.tencent.mm.plugin.finder.model.z ssB;
    final t ssn;
    
    public c(t paramt)
    {
      AppMethodBeat.i(203409);
      this.rYW = paramt;
      Object localObject;
      this.ssn = localObject;
      this.ssA = new AtomicBoolean(false);
      this.lock = new Object();
      AppMethodBeat.o(203409);
    }
    
    public final void a(b.a parama)
    {
      AppMethodBeat.i(166359);
      d.g.b.p.h(parama, "callback");
      this.pGr = parama;
      AppMethodBeat.o(166359);
    }
    
    public final void gp(final String paramString)
    {
      AppMethodBeat.i(166356);
      synchronized (this.lock)
      {
        this.ssA.compareAndSet(false, true);
        ae.i("Finder.VideoDownloader", "[stop] mediaId=".concat(String.valueOf(paramString)));
        if (paramString != null)
        {
          com.tencent.mm.modelvideo.o.aNi().a(paramString, (e.a)new b(this, paramString));
          MediaPreloadCore localMediaPreloadCore = o.this.ssl;
          if (localMediaPreloadCore != null)
          {
            localMediaPreloadCore.bc(paramString, false);
            paramString = d.z.Nhr;
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
        Object localObject1 = this.ssB;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.model.z)localObject1).field_cacheSize);
          ae.i("Finder.VideoDownloader", localObject1);
          localObject1 = this.ssn;
          if (localObject1 != null) {
            ((t)localObject1).ae(paramString, paramInt1, paramInt2);
          }
          boolean bool = com.tencent.mm.modelvideo.o.aNi().isVideoDataAvailable(paramString, paramInt1, paramInt2);
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
        this.ssA.set(false);
        Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
        com.tencent.mm.plugin.finder.model.z localz = com.tencent.mm.plugin.finder.storage.logic.c.ajA(paramString1);
        localz.field_reqFormat = this.rYW.ssj;
        if (localz.field_fileFormat == null) {}
        for (localObject1 = this.rYW.sry.detail;; localObject1 = localz.field_fileFormat)
        {
          localz.field_fileFormat = ((String)localObject1);
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
          Object localObject2 = this.rYW.srx.mediaId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          int i = this.rYW.ssj;
          localObject2 = localz.field_fileFormat;
          d.g.b.p.g(localObject2, "this.field_fileFormat");
          com.tencent.mm.plugin.finder.storage.logic.c.a(paramString1, (String)localObject1, paramString3, i, (String)localObject2, localz.field_cacheSize, localz.field_totalSize, 1, this.rYW.srx.videoDuration, this.rYW.cEl(), this.rYW.cEk());
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
          i = localz.field_reqFormat;
          localObject1 = localz.field_fileFormat;
          d.g.b.p.g(localObject1, "videoCache.field_fileFormat");
          localObject1 = com.tencent.mm.plugin.finder.utils.p.a(paramString1, paramString3, paramString2, i, (String)localObject1, this.rYW.cEl(), this.rYW.cEk(), (h.a)new o.a(o.this, this.ssn, this.pGr, this.rYW, this.ssA, this.lock), "Finder.VideoDownloader");
          this.ssB = localz;
          localObject2 = o.this.ssl;
          if (localObject2 != null) {
            ((MediaPreloadCore)localObject2).bc(paramString1, true);
          }
          ae.i("Finder.VideoDownloader", "[startHttpStream] fallback cancel mediaId=" + paramString1 + " isPreLoadCompleted=" + localz.cEK() + ' ' + "isAllCompleted=" + localz.cEJ() + " file=" + paramString2 + ", " + paramString3 + " isMoovReady=" + localz.field_moovReady);
          if (!localz.cEJ()) {
            break;
          }
          ae.i("Finder.VideoDownloader", "[finish] mediaId=" + paramString1 + " cacheSize=" + localz.field_cacheSize + " totalSize=" + localz.field_totalSize + '}');
          ((h)localObject1).fLQ.a(paramString1, localz.field_cacheSize, localz.field_totalSize, localz.field_fileFormat);
          ((h)localObject1).fLQ.i(paramString1, localz.field_cacheSize, localz.field_totalSize);
          ((h)localObject1).fLQ.a(paramString1, 0, null);
          paramString2 = o.this.ssl;
          if (paramString2 != null) {
            paramString2.bc(paramString1, false);
          }
          AppMethodBeat.o(166355);
          return;
        }
        com.tencent.mm.modelvideo.o.aNi().a((h)localObject1);
        o.z((a)new a(this, paramString1, paramString3, paramString2));
        paramString1 = d.z.Nhr;
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
        Object localObject1 = this.ssB;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((com.tencent.mm.plugin.finder.model.z)localObject1).field_cacheSize);
          ae.i("Finder.VideoDownloader", localObject1);
          com.tencent.mm.modelvideo.o.aNi();
          e.r(paramString, paramInt1, paramInt2);
          AppMethodBeat.o(166357);
          return;
        }
        localObject1 = null;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$startHttpStream$1$1"})
    static final class a
      extends q
      implements a<d.z>
    {
      a(o.c paramc, String paramString1, String paramString2, String paramString3)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "kotlin.jvm.PlatformType", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "isFinish", "", "onStop", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$stop$1$1$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$$special$$inlined$let$lambda$1"})
    static final class b
      implements e.a
    {
      b(o.c paramc, String paramString) {}
      
      public final void a(final h paramh, final d paramd)
      {
        AppMethodBeat.i(166354);
        o.z((a)new q(paramh) {});
        AppMethodBeat.o(166354);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<d.z>
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