package com.tencent.mm.plugin.finder.loader;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.video.FinderVideoView;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.h;
import d.g.a.a;
import d.g.b.k;
import d.g.b.v.a;
import d.y;
import java.util.concurrent.atomic.AtomicBoolean;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "isStopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/lang/Object;)V", "onDataAvailable", "", "mediaId", "", "offset", "", "total", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReady", "svrflag", "onProgress", "plugin-finder_release"})
final class n$a
  implements h.a
{
  private final Object lock;
  final b.a oWd;
  final l rcZ;
  final t rua;
  final AtomicBoolean rub;
  
  public n$a(t paramt, b.a parama, l paraml, AtomicBoolean paramAtomicBoolean, Object paramObject)
  {
    AppMethodBeat.i(202542);
    this.rua = parama;
    this.oWd = paraml;
    this.rcZ = paramAtomicBoolean;
    this.rub = paramObject;
    this.lock = localObject;
    AppMethodBeat.o(202542);
  }
  
  public final void a(final String paramString, final int paramInt, final d paramd)
  {
    int i = 1;
    AppMethodBeat.i(166348);
    k.h(paramString, "mediaId");
    synchronized (this.lock)
    {
      if (!this.rub.get())
      {
        if (paramd == null) {
          break label319;
        }
        ac.i("Finder.VideoDownloader", "[onFinish] mediaId=" + paramString + " ret=" + paramInt + " fileLength=" + paramd.field_fileLength + ' ' + "sceneResult=" + paramd.field_retCode + " videoFormat:" + paramd.field_videoFormat + " videoFlag=" + paramd.field_videoFlag);
        localObject2 = n.rtZ;
        k.h(paramString, "mediaId");
        localObject2 = new long[3];
        CdnLogic.queryDownloadedSize(paramString, (long[])localObject2);
        if ((localObject2[0] != localObject2[1]) || (localObject2[1] != localObject2[2])) {
          break label256;
        }
      }
      for (;;)
      {
        if ((i == 0) && ((h.IS_FLAVOR_PURPLE) || (h.DEBUG))) {
          com.tencent.mm.ac.c.g((a)n.a.d.ruk);
        }
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
        com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, paramd.field_fileLength, paramd.field_fileLength, 3);
        if (n.a(this.ruc) != null) {
          MediaPreloadCore.adH(paramString);
        }
        n.w((a)new b(this, paramd, paramString, paramInt));
        paramString = y.KTp;
        AppMethodBeat.o(166348);
        return;
        label256:
        ac.e("Finder.VideoDownloader", "[checkFinishValid] mediaId=" + paramString + ' ' + localObject2[0] + ':' + localObject2[1] + ':' + localObject2[2]);
        i = 0;
      }
      label319:
      Object localObject2 = (a)this;
      ac.e("Finder.VideoDownloader", "sceneResult is null! mediaId=" + paramString + " ret=" + paramInt);
      n.w((a)new n.a.c((a)localObject2, this, paramd, paramString, paramInt));
    }
  }
  
  public final void a(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(202541);
    k.h(paramString1, "mediaId");
    for (;;)
    {
      synchronized (this.lock)
      {
        ac.i("Finder.VideoDownloader", "[onMoovReady] mediaId=" + paramString1 + " offset=" + paramLong1 + " total=" + paramLong2 + " fileFormat=[" + this.rcZ.rtm + "=>" + paramString2 + "]} isHasStop=" + this.rub.get());
        if (!this.rub.get())
        {
          v.a locala = new v.a();
          locala.KUL = false;
          if ((this.oWd instanceof FinderVideoView)) {
            locala.KUL = ((FinderVideoView)this.oWd).vn(paramLong1);
          }
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
          if (paramString2 == null)
          {
            localObject1 = "";
            com.tencent.mm.plugin.finder.storage.logic.c.gf(paramString1, (String)localObject1);
            localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
            com.tencent.mm.plugin.finder.storage.logic.c.aeh(paramString1);
            n.w((a)new n.a.e(locala, this, paramString1, paramLong1, paramLong2, paramString2));
          }
        }
        else
        {
          paramString1 = y.KTp;
          AppMethodBeat.o(202541);
          return;
        }
      }
      Object localObject1 = paramString2;
    }
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(166347);
    k.h(paramString, "mediaId");
    synchronized (this.lock)
    {
      if (!this.rub.get())
      {
        ac.i("Finder.VideoDownloader", "[onProgress] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2);
        com.tencent.mm.plugin.finder.storage.logic.c localc = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
        com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, paramLong1, paramLong2, 1);
        if (n.a(this.ruc) != null) {
          MediaPreloadCore.adH(paramString);
        }
        n.w((a)new n.a.f(this, paramString, paramLong1, paramLong2));
      }
      paramString = y.KTp;
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
      if (!this.rub.get()) {
        n.w((a)new a(this, paramString, paramLong1, paramLong2));
      }
      y localy = y.KTp;
      ac.i("Finder.VideoDownloader", "[onDataAvailable] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2);
      AppMethodBeat.o(166346);
      return;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onDataAvailable$1$1"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    a(n.a parama, String paramString, long paramLong1, long paramLong2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onFinish$1$1$2", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$$special$$inlined$let$lambda$1"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(n.a parama, d paramd, String paramString, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.n.a
 * JD-Core Version:    0.7.0.1
 */