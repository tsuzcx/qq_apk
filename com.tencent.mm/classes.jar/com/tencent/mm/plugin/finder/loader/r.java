package com.tencent.mm.plugin.finder.loader;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.an.e.a;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoView;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "", "preloadCoreCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "getPreloadCoreCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "createVideoProxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "runOnUI", "", "run", "Lkotlin/Function0;", "CdnCallback", "Companion", "VideoProxy", "plugin-finder_release"})
public final class r
{
  public static final b uJq;
  final MediaPreloadCore uJp;
  
  static
  {
    AppMethodBeat.i(166363);
    uJq = new b((byte)0);
    AppMethodBeat.o(166363);
  }
  
  public r(MediaPreloadCore paramMediaPreloadCore)
  {
    this.uJp = paramMediaPreloadCore;
  }
  
  public static void S(a<kotlin.x> parama)
  {
    AppMethodBeat.i(166362);
    p.h(parama, "run");
    com.tencent.mm.ac.d.h((a)new d(parama));
    AppMethodBeat.o(166362);
  }
  
  public final b a(s params, com.tencent.mm.plugin.finder.video.x paramx)
  {
    AppMethodBeat.i(248239);
    p.h(params, "video");
    p.h(paramx, "callback");
    params = (b)new c(params, paramx);
    AppMethodBeat.o(248239);
    return params;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isStopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/lang/Object;)V", "onDataAvailable", "", "mediaId", "", "offset", "", "total", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onProgress", "plugin-finder_release"})
  final class a
    implements h.a
  {
    private final Object lock;
    final b.a qWn;
    final s tHN;
    final com.tencent.mm.plugin.finder.video.x uJr;
    final AtomicBoolean uJs;
    
    public a(b.a parama, s params, AtomicBoolean paramAtomicBoolean, Object paramObject)
    {
      AppMethodBeat.i(248237);
      this.uJr = parama;
      this.qWn = params;
      this.tHN = paramAtomicBoolean;
      this.uJs = paramObject;
      this.lock = localObject;
      AppMethodBeat.o(248237);
    }
    
    public final void Ds(String paramString)
    {
      AppMethodBeat.i(248235);
      p.h(paramString, "mediaId");
      AppMethodBeat.o(248235);
    }
    
    public final void a(final String paramString, final int paramInt, final com.tencent.mm.i.d paramd)
    {
      int i = 1;
      AppMethodBeat.i(166348);
      p.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        if (!this.uJs.get())
        {
          if (paramd == null) {
            break label314;
          }
          Log.i("Finder.VideoDownloader", "[onFinish] mediaId=" + paramString + " ret=" + paramInt + " fileLength=" + paramd.field_fileLength + ' ' + "sceneResult=" + paramd.field_retCode + " videoFormat:" + paramd.field_videoFormat + " videoFlag=" + paramd.field_videoFlag);
          localObject2 = r.uJq;
          p.h(paramString, "mediaId");
          localObject2 = new long[3];
          CdnLogic.queryDownloadedSize(paramString, (long[])localObject2);
          if ((localObject2[0] != localObject2[1]) || (localObject2[1] != localObject2[2])) {
            break label251;
          }
        }
        for (;;)
        {
          if ((i == 0) && ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))) {
            com.tencent.mm.ac.d.h((a)r.a.d.uJB);
          }
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
          com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, paramd.field_fileLength, paramd.field_fileLength, 3);
          localObject2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
          com.tencent.mm.plugin.finder.storage.logic.d.avG(paramString);
          r.S((a)new b(this, paramd, paramString, paramInt));
          paramString = kotlin.x.SXb;
          AppMethodBeat.o(166348);
          return;
          label251:
          Log.e("Finder.VideoDownloader", "[checkFinishValid] mediaId=" + paramString + ' ' + localObject2[0] + ':' + localObject2[1] + ':' + localObject2[2]);
          i = 0;
        }
        label314:
        Object localObject2 = (a)this;
        Log.e("Finder.VideoDownloader", "sceneResult is null! mediaId=" + paramString + " ret=" + paramInt);
        r.S((a)new c((a)localObject2, this, paramd, paramString, paramInt));
      }
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(248236);
      p.h(paramString1, "mediaId");
      for (;;)
      {
        synchronized (this.lock)
        {
          Log.i("Finder.VideoDownloader", "[onMoovReady] mediaId=" + paramString1 + " offset=" + paramLong1 + " total=" + paramLong2 + " fileFormat=[" + this.tHN.uIx + "=>" + paramString2 + "]} isHasStop=" + this.uJs.get());
          if (!this.uJs.get())
          {
            z.a locala = new z.a();
            locala.SYB = false;
            if ((this.qWn instanceof FinderVideoView)) {
              locala.SYB = ((FinderVideoView)this.qWn).Gs(paramLong1);
            }
            localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
            if (!com.tencent.mm.plugin.finder.storage.logic.d.avH(paramString1).field_moovReady)
            {
              bool = true;
              localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
              if (paramString2 != null) {
                break label256;
              }
              localObject1 = "";
              com.tencent.mm.plugin.finder.storage.logic.d.gU(paramString1, (String)localObject1);
              localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
              com.tencent.mm.plugin.finder.storage.logic.d.avG(paramString1);
              r.S((a)new e(locala, bool, this, paramString1, paramLong1, paramLong2, paramString2));
            }
          }
          else
          {
            paramString1 = kotlin.x.SXb;
            AppMethodBeat.o(248236);
            return;
          }
          final boolean bool = false;
        }
        label256:
        Object localObject1 = paramString2;
      }
    }
    
    public final void i(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(166347);
      p.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        if (!this.uJs.get())
        {
          Log.i("Finder.VideoDownloader", "[onProgress] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2);
          com.tencent.mm.plugin.finder.storage.logic.d locald = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
          com.tencent.mm.plugin.finder.storage.logic.d.a(paramString, paramLong1, paramLong2, 1);
          locald = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
          com.tencent.mm.plugin.finder.storage.logic.d.avG(paramString);
          r.S((a)new f(this, paramString, paramLong1, paramLong2));
        }
        paramString = kotlin.x.SXb;
        AppMethodBeat.o(166347);
        return;
      }
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(166346);
      p.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        if (!this.uJs.get()) {
          r.S((a)new a(this, paramString, paramLong1, paramLong2));
        }
        kotlin.x localx = kotlin.x.SXb;
        Log.i("Finder.VideoDownloader", "[onDataAvailable] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2);
        AppMethodBeat.o(166346);
        return;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onDataAvailable$1$1"})
    static final class a
      extends q
      implements a<kotlin.x>
    {
      a(r.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onFinish$1$1$2", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$$special$$inlined$let$lambda$1"})
    static final class b
      extends q
      implements a<kotlin.x>
    {
      b(r.a parama, com.tencent.mm.i.d paramd, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onFinish$1$2$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$$special$$inlined$run$lambda$1"})
    static final class c
      extends q
      implements a<kotlin.x>
    {
      c(r.a parama1, r.a parama2, com.tencent.mm.i.d paramd, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onMoovReady$1$1"})
    static final class e
      extends q
      implements a<kotlin.x>
    {
      e(z.a parama, boolean paramBoolean, r.a parama1, String paramString1, long paramLong1, long paramLong2, String paramString2)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onProgress$1$1"})
    static final class f
      extends q
      implements a<kotlin.x>
    {
      f(r.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$Companion;", "", "()V", "TAG", "", "checkFinishValid", "", "mediaId", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "getEngineCallback", "()Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "setEngineCallback", "(Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;)V", "isHasStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isVideoDataAvailable", "", "mediaId", "", "offset", "", "length", "requestVideoData", "", "setIEngineCallback", "startHttpStream", "filePath", "url", "stop", "plugin-finder_release"})
  final class c
    implements b
  {
    private final Object lock;
    private b.a qWn;
    final s tHN;
    private final AtomicBoolean uJF;
    private at uJG;
    final com.tencent.mm.plugin.finder.video.x uJr;
    
    public c(com.tencent.mm.plugin.finder.video.x paramx)
    {
      AppMethodBeat.i(248238);
      this.tHN = paramx;
      Object localObject;
      this.uJr = localObject;
      this.uJF = new AtomicBoolean(false);
      this.lock = new Object();
      AppMethodBeat.o(248238);
    }
    
    public final void a(b.a parama)
    {
      AppMethodBeat.i(166359);
      p.h(parama, "callback");
      this.qWn = parama;
      AppMethodBeat.o(166359);
    }
    
    public final void he(final String paramString)
    {
      AppMethodBeat.i(166356);
      synchronized (this.lock)
      {
        this.uJF.compareAndSet(false, true);
        Log.i("Finder.VideoDownloader", "[stop] mediaId=".concat(String.valueOf(paramString)));
        if (paramString != null)
        {
          o.bhk().a(paramString, (e.a)new b(this, paramString));
          MediaPreloadCore localMediaPreloadCore = r.this.uJp;
          if (localMediaPreloadCore != null)
          {
            localMediaPreloadCore.bl(paramString, false);
            paramString = kotlin.x.SXb;
          }
        }
        AppMethodBeat.o(166356);
        return;
      }
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(166358);
      p.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        StringBuilder localStringBuilder = new StringBuilder("[isVideoDataAvailable] mediaId=").append(paramString).append(" offset=").append(paramInt1).append(" length=").append(paramInt2).append(" cacheSize=");
        Object localObject1 = this.uJG;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((at)localObject1).field_cacheSize);
          Log.i("Finder.VideoDownloader", localObject1);
          localObject1 = this.uJr;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.video.x)localObject1).ac(paramString, paramInt1, paramInt2);
          }
          boolean bool = o.bhk().isVideoDataAvailable(paramString, paramInt1, paramInt2);
          AppMethodBeat.o(166358);
          return bool;
        }
        localObject1 = null;
      }
    }
    
    public final void p(final String paramString1, final String paramString2, final String paramString3)
    {
      AppMethodBeat.i(166355);
      p.h(paramString1, "mediaId");
      p.h(paramString2, "filePath");
      p.h(paramString3, "url");
      for (;;)
      {
        synchronized (this.lock)
        {
          this.uJF.set(false);
          Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
          at localat = com.tencent.mm.plugin.finder.storage.logic.d.avH(paramString1);
          localat.field_reqFormat = this.tHN.uJN;
          if (localat.field_fileFormat == null)
          {
            localObject1 = this.tHN.uIx.detail;
            localat.field_fileFormat = ((String)localObject1);
            localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
            Object localObject2 = this.tHN.uIw.mediaId;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            int i = this.tHN.uJN;
            localObject2 = localat.field_fileFormat;
            p.g(localObject2, "this.field_fileFormat");
            com.tencent.mm.plugin.finder.storage.logic.d.a(paramString1, (String)localObject1, paramString3, i, (String)localObject2, localat.field_cacheSize, localat.field_totalSize, 1, this.tHN.uIw.videoDuration, this.tHN.djW(), this.tHN.djV());
            localObject1 = y.vXH;
            i = localat.field_reqFormat;
            localObject1 = localat.field_fileFormat;
            p.g(localObject1, "videoCache.field_fileFormat");
            localObject2 = this.tHN.djW();
            String str = this.tHN.djV();
            if (this.tHN.uIw.hot_flag != 1) {
              break label633;
            }
            bool = true;
            localObject1 = y.a(paramString1, paramString3, paramString2, i, (String)localObject1, (String)localObject2, str, bool, (h.a)new r.a(r.this, this.uJr, this.qWn, this.tHN, this.uJF, this.lock), "Finder.VideoDownloader");
            this.uJG = localat;
            localObject2 = r.this.uJp;
            if (localObject2 != null) {
              ((MediaPreloadCore)localObject2).bl(paramString1, true);
            }
            Log.i("Finder.VideoDownloader", "[startHttpStream] fallback cancel mediaId=" + paramString1 + " isPreLoadCompleted=" + localat.dkO() + ' ' + "isAllCompleted=" + localat.dkN() + " file=" + paramString2 + ", " + paramString3 + " isMoovReady=" + localat.field_moovReady);
            if (localat.dkN())
            {
              Log.i("Finder.VideoDownloader", "[finish] mediaId=" + paramString1 + " cacheSize=" + localat.field_cacheSize + " totalSize=" + localat.field_totalSize + '}');
              ((h)localObject1).gre.a(paramString1, localat.field_cacheSize, localat.field_totalSize, localat.field_fileFormat);
              ((h)localObject1).gre.i(paramString1, localat.field_cacheSize, localat.field_totalSize);
              ((h)localObject1).gre.a(paramString1, 0, null);
              paramString2 = r.this.uJp;
              if (paramString2 != null) {
                paramString2.bl(paramString1, false);
              }
              AppMethodBeat.o(166355);
            }
          }
          else
          {
            localObject1 = localat.field_fileFormat;
            continue;
          }
          o.bhk().e((h)localObject1);
          r.S((a)new a(this, paramString1, paramString3, paramString2));
          paramString1 = kotlin.x.SXb;
          AppMethodBeat.o(166355);
          return;
        }
        label633:
        boolean bool = false;
      }
    }
    
    public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(166357);
      p.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        StringBuilder localStringBuilder = new StringBuilder("[requestVideoData] mediaId=").append(paramString).append(" offset=").append(paramInt1).append(" length=").append(paramInt2).append(" cacheSize=");
        Object localObject1 = this.uJG;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((at)localObject1).field_cacheSize);
          Log.i("Finder.VideoDownloader", localObject1);
          o.bhk();
          e.r(paramString, paramInt1, paramInt2);
          AppMethodBeat.o(166357);
          return;
        }
        localObject1 = null;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$startHttpStream$1$1"})
    static final class a
      extends q
      implements a<kotlin.x>
    {
      a(r.c paramc, String paramString1, String paramString2, String paramString3)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "kotlin.jvm.PlatformType", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "isFinish", "", "onStop", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$stop$1$1$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$$special$$inlined$let$lambda$1"})
    static final class b
      implements e.a
    {
      b(r.c paramc, String paramString) {}
      
      public final void a(final h paramh, final com.tencent.mm.i.d paramd)
      {
        AppMethodBeat.i(166354);
        r.S((a)new q(paramh) {});
        AppMethodBeat.o(166354);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<kotlin.x>
  {
    d(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.r
 * JD-Core Version:    0.7.0.1
 */