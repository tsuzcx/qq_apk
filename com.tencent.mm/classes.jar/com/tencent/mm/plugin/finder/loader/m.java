package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.e;
import com.tencent.mm.ao.e.a;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.a;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore.b;
import com.tencent.mm.plugin.finder.video.FinderVideoView;
import com.tencent.mm.plugin.finder.video.s;
import com.tencent.mm.plugin.i.a.l.a;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.a;
import d.g.b.k;
import d.g.b.v.a;
import d.y;
import java.util.concurrent.atomic.AtomicBoolean;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "", "preloadCoreCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "createVideoProxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "runOnUI", "", "run", "Lkotlin/Function0;", "CdnCallback", "Companion", "VideoProxy", "plugin-finder_release"})
public final class m
{
  public static final b qCS;
  private final MediaPreloadCore KTh;
  
  static
  {
    AppMethodBeat.i(166363);
    qCS = new b((byte)0);
    AppMethodBeat.o(166363);
  }
  
  public m(MediaPreloadCore paramMediaPreloadCore)
  {
    this.KTh = paramMediaPreloadCore;
  }
  
  public static void r(a<y> parama)
  {
    AppMethodBeat.i(166362);
    k.h(parama, "run");
    com.tencent.mm.ad.c.g((a)new e(parama));
    AppMethodBeat.o(166362);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isStopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/lang/Object;)V", "onDataAvailable", "", "mediaId", "", "offset", "", "total", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReady", "svrflag", "onProgress", "plugin-finder_release"})
  final class a
    implements h.a
  {
    final s KTi;
    private final Object lock;
    final b.a osD;
    final l qCU;
    final AtomicBoolean qCV;
    
    public a(b.a parama, l paraml, AtomicBoolean paramAtomicBoolean, Object paramObject)
    {
      AppMethodBeat.i(198615);
      this.KTi = parama;
      this.osD = paraml;
      this.qCU = paramAtomicBoolean;
      this.qCV = paramObject;
      this.lock = localObject;
      AppMethodBeat.o(198615);
    }
    
    public final void a(final String paramString, final int paramInt, final com.tencent.mm.i.d paramd)
    {
      AppMethodBeat.i(166348);
      k.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        if (!this.qCV.get())
        {
          if (paramd != null)
          {
            ad.i("Finder.VideoDownloader", "[onFinish] mediaId=" + paramString + " ret=" + paramInt + " recvedBytes=" + paramd.field_recvedBytes + " fileLength=" + paramd.field_fileLength + "  finderformat:" + paramd.field_videoFormat);
            if (paramd.field_recvedBytes >= paramd.field_fileLength)
            {
              localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
              com.tencent.mm.plugin.finder.storage.logic.c.f(paramString, paramd.field_fileLength, paramd.field_fileLength, 3);
            }
            if (m.a(m.this) != null) {
              MediaPreloadCore.aVo(paramString);
            }
            m.r((a)new b(this, paramd, paramString, paramInt));
          }
        }
        else
        {
          paramString = y.JfV;
          AppMethodBeat.o(166348);
          return;
        }
        Object localObject2 = (a)this;
        ad.e("Finder.VideoDownloader", "sceneResult is null! mediaId=" + paramString + " ret=" + paramInt);
        m.r((a)new c((a)localObject2, this, paramd, paramString, paramInt));
      }
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(198614);
      k.h(paramString1, "mediaId");
      for (;;)
      {
        synchronized (this.lock)
        {
          ad.i("Finder.VideoDownloader", "[onMoovReady] mediaId=" + paramString1 + " offset=" + paramLong1 + " total=" + paramLong2 + " fileFormat=[" + this.qCU.qCk + "=>" + paramString2 + "]} isHasStop=" + this.qCV.get());
          if (!this.qCV.get())
          {
            v.a locala = new v.a();
            locala.Jhs = false;
            if ((this.osD instanceof FinderVideoView)) {
              locala.Jhs = ((FinderVideoView)this.osD).Cb(paramLong1);
            }
            localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
            if (paramString2 == null)
            {
              localObject1 = "";
              com.tencent.mm.plugin.finder.storage.logic.c.ki(paramString1, (String)localObject1);
              m.r((a)new d(locala, this, paramString1, paramLong1, paramLong2, paramString2));
            }
          }
          else
          {
            paramString1 = y.JfV;
            AppMethodBeat.o(198614);
            return;
          }
        }
        Object localObject1 = paramString2;
      }
    }
    
    public final void k(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(166347);
      k.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        if (!this.qCV.get())
        {
          ad.i("Finder.VideoDownloader", "[onProgress] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2);
          com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
          com.tencent.mm.plugin.finder.storage.logic.c.f(paramString, paramLong1, paramLong2, 1);
          if (m.a(m.this) != null) {
            MediaPreloadCore.aVo(paramString);
          }
          m.r((a)new e(this, paramString, paramLong1, paramLong2));
        }
        paramString = y.JfV;
        AppMethodBeat.o(166347);
        return;
      }
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(166346);
      k.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        if (!this.qCV.get()) {
          m.r((a)new a(this, paramString, paramLong1, paramLong2));
        }
        y localy = y.JfV;
        ad.i("Finder.VideoDownloader", "[onDataAvailable] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2);
        AppMethodBeat.o(166346);
        return;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onDataAvailable$1$1"})
    static final class a
      extends d.g.b.l
      implements a<y>
    {
      a(m.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onFinish$1$1$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$$special$$inlined$let$lambda$1"})
    static final class b
      extends d.g.b.l
      implements a<y>
    {
      b(m.a parama, com.tencent.mm.i.d paramd, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onFinish$1$2$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$$special$$inlined$run$lambda$1"})
    static final class c
      extends d.g.b.l
      implements a<y>
    {
      c(m.a parama1, m.a parama2, com.tencent.mm.i.d paramd, String paramString, int paramInt)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onMoovReady$1$1"})
    static final class d
      extends d.g.b.l
      implements a<y>
    {
      d(v.a parama, m.a parama1, String paramString1, long paramLong1, long paramLong2, String paramString2)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onProgress$1$1"})
    static final class e
      extends d.g.b.l
      implements a<y>
    {
      e(m.a parama, String paramString, long paramLong1, long paramLong2)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$Companion;", "", "()V", "TAG", "", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "reqFormat", "", "fileFormat", "urlToken", "decodeKey", "videoCallback", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "plugin-finder_release"})
  public static final class b {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "getEngineCallback", "()Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "setEngineCallback", "(Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;)V", "isHasStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isVideoDataAvailable", "", "mediaId", "", "offset", "", "length", "requestVideoData", "", "setIEngineCallback", "startHttpStream", "filePath", "url", "stop", "plugin-finder_release"})
  public final class d
    implements com.tencent.mm.modelvideo.b
  {
    final s KTi;
    private final Object lock;
    private b.a osD;
    final l qCU;
    private final AtomicBoolean qDf;
    private r qDg;
    
    public d(s params)
    {
      AppMethodBeat.i(198616);
      this.qCU = params;
      Object localObject;
      this.KTi = localObject;
      this.qDf = new AtomicBoolean(false);
      this.lock = new Object();
      AppMethodBeat.o(198616);
    }
    
    public final void a(b.a parama)
    {
      AppMethodBeat.i(166359);
      k.h(parama, "callback");
      this.osD = parama;
      AppMethodBeat.o(166359);
    }
    
    public final void fy(final String paramString)
    {
      AppMethodBeat.i(166356);
      synchronized (this.lock)
      {
        this.qDf.compareAndSet(false, true);
        ad.i("Finder.VideoDownloader", "[stop] mediaId=".concat(String.valueOf(paramString)));
        if (paramString != null)
        {
          o.aCJ().a(paramString, (e.a)new c(this, paramString));
          MediaPreloadCore localMediaPreloadCore = m.a(m.this);
          if (localMediaPreloadCore != null)
          {
            localMediaPreloadCore.cW(paramString, false);
            paramString = y.JfV;
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
        Object localObject1 = this.qDg;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((r)localObject1).field_cacheSize);
          ad.i("Finder.VideoDownloader", localObject1);
          localObject1 = this.KTi;
          if (localObject1 != null) {
            ((s)localObject1).aa(paramString, paramInt1, paramInt2);
          }
          boolean bool = o.aCJ().isVideoDataAvailable(paramString, paramInt1, paramInt2);
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
      for (;;)
      {
        Object localObject1;
        r localr;
        int j;
        synchronized (this.lock)
        {
          this.qDf.set(false);
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
          localr = com.tencent.mm.plugin.finder.storage.logic.c.aVA(paramString1);
          localr.field_reqFormat = this.qCU.KTf;
          if (localr.field_fileFormat == null)
          {
            localObject1 = this.qCU.qCk.detail;
            localr.field_fileFormat = ((String)localObject1);
            localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
            localObject1 = this.qCU.qCj.mediaId;
            k.g(localObject1, "video.mediaObj.mediaId");
            i = this.qCU.KTf;
            localObject3 = localr.field_fileFormat;
            k.g(localObject3, "this.field_fileFormat");
            com.tencent.mm.plugin.finder.storage.logic.c.a(paramString1, (String)localObject1, paramString3, paramString2, i, (String)localObject3, localr.field_cacheSize, localr.field_totalSize, 1);
            localObject1 = m.qCS;
            j = localr.field_reqFormat;
            localObject3 = localr.field_fileFormat;
            k.g(localObject3, "videoCache.field_fileFormat");
            String str1 = this.qCU.fTN();
            String str2 = this.qCU.cmS();
            h.a locala = (h.a)new m.a(m.this, this.KTi, this.osD, this.qCU, this.qDf, this.lock);
            k.h(paramString1, "mediaId");
            k.h(paramString3, "url");
            k.h(paramString2, "path");
            k.h(localObject3, "fileFormat");
            k.h(str1, "urlToken");
            k.h(locala, "videoCallback");
            localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
            boolean bool = com.tencent.mm.plugin.finder.storage.b.fUN();
            localObject1 = new com.tencent.mm.i.h();
            ((com.tencent.mm.i.h)localObject1).field_mediaId = paramString1;
            ((com.tencent.mm.i.h)localObject1).url = (paramString3 + str1);
            ((com.tencent.mm.i.h)localObject1).fnL = 60;
            ((com.tencent.mm.i.h)localObject1).fnM = 60;
            ((com.tencent.mm.i.h)localObject1).foc = 1;
            ((com.tencent.mm.i.h)localObject1).fnX = 8;
            ((com.tencent.mm.i.h)localObject1).qpa = 0;
            if (!bool)
            {
              if (j > 0) {
                break label947;
              }
              i = com.tencent.mm.modelcontrol.d.H(1, paramString2);
              ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat = i;
              ((com.tencent.mm.i.h)localObject1).field_fullpath = paramString2;
              ((com.tencent.mm.i.h)localObject1).concurrentCount = l.a.tDs;
              ((com.tencent.mm.i.h)localObject1).connectionCount = 1;
              ((com.tencent.mm.i.h)localObject1).snsCipherKey = str2;
              ((com.tencent.mm.i.h)localObject1).foj = locala;
              ad.i("Finder.VideoDownloader", "[loadByCdn] finder video, reqFormat=" + j + " fileFormat=" + (String)localObject3 + ",isOpenMultiBitRateDownload=" + bool + ", decodeKey=" + str2 + ' ' + str1 + " mediaId=" + paramString1 + " url=" + ((com.tencent.mm.i.h)localObject1).url + ' ');
              this.qDg = localr;
              localObject3 = m.a(m.this);
              if (localObject3 != null) {
                ((MediaPreloadCore)localObject3).cW(paramString1, true);
              }
              ad.i("Finder.VideoDownloader", "[startHttpStream] fallback cancel mediaId=" + paramString1 + " isPreLoadCompleted=" + localr.cnn() + ' ' + "isAllCompleted=" + localr.cnm() + " file=" + paramString2 + ", " + paramString3);
              if (!localr.cnm()) {
                break label792;
              }
              ad.i("Finder.VideoDownloader", "[finish] mediaId=" + paramString1 + " cacheSize=" + localr.field_cacheSize + " totalSize=" + localr.field_totalSize + '}');
              ((com.tencent.mm.i.h)localObject1).foj.a(paramString1, localr.field_cacheSize, localr.field_totalSize, localr.field_fileFormat);
              ((com.tencent.mm.i.h)localObject1).foj.k(paramString1, localr.field_cacheSize, localr.field_totalSize);
              ((com.tencent.mm.i.h)localObject1).foj.a(paramString1, 0, null);
              AppMethodBeat.o(166355);
            }
          }
          else
          {
            localObject1 = localr.field_fileFormat;
            continue;
          }
          ((com.tencent.mm.i.h)localObject1).field_requestVideoFormat = 0;
          ((com.tencent.mm.i.h)localObject1).videoFlag = ((String)localObject3);
        }
        label792:
        Object localObject3 = MediaPreloadCore.KTA;
        localObject3 = MediaPreloadCore.a.a(localr);
        if ((!((MediaPreloadCore.b)localObject3).qEp) && (localr.cnn()) && (!localr.cnm())) {
          ad.e("Finder.VideoDownloader", "why has preload, but moov is not ready??? offset=" + ((MediaPreloadCore.b)localObject3).offset + " length=" + ((MediaPreloadCore.b)localObject3).length + ' ' + localr.field_mediaId + " cache=" + localr.field_cacheSize);
        }
        if (m.a(m.this) != null) {
          MediaPreloadCore.aVo(paramString1);
        }
        o.aCJ().a((com.tencent.mm.i.h)localObject1);
        m.r((a)new b(this, paramString1, paramString3, paramString2));
        paramString1 = y.JfV;
        AppMethodBeat.o(166355);
        return;
        label947:
        int i = j;
      }
    }
    
    public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(166357);
      k.h(paramString, "mediaId");
      synchronized (this.lock)
      {
        StringBuilder localStringBuilder = new StringBuilder("[requestVideoData] mediaId=").append(paramString).append(" offset=").append(paramInt1).append(" length=").append(paramInt2).append(" cacheSize=");
        Object localObject1 = this.qDg;
        if (localObject1 != null)
        {
          localObject1 = Long.valueOf(((r)localObject1).field_cacheSize);
          ad.i("Finder.VideoDownloader", localObject1);
          o.aCJ();
          e.q(paramString, paramInt1, paramInt2);
          AppMethodBeat.o(166357);
          return;
        }
        localObject1 = null;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$startHttpStream$1$1"})
    static final class b
      extends d.g.b.l
      implements a<y>
    {
      b(m.d paramd, String paramString1, String paramString2, String paramString3)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "kotlin.jvm.PlatformType", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "isFinish", "", "onStop", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$stop$1$1$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$$special$$inlined$let$lambda$1"})
    static final class c
      implements e.a
    {
      c(m.d paramd, String paramString) {}
      
      public final void a(final com.tencent.mm.i.h paramh, final com.tencent.mm.i.d paramd)
      {
        AppMethodBeat.i(166354);
        m.r((a)new d.g.b.l(paramh) {});
        AppMethodBeat.o(166354);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<y>
  {
    e(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.m
 * JD-Core Version:    0.7.0.1
 */