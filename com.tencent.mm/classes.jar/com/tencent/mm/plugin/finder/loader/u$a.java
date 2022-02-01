package com.tencent.mm.plugin.finder.loader;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.h.a;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.storage.logic.e;
import com.tencent.mm.plugin.finder.video.FinderVideoView;
import com.tencent.mm.plugin.finder.video.aa;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isStopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/lang/Object;)V", "onDataAvailable", "", "mediaId", "", "offset", "", "total", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onProgress", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
final class u$a
  implements h.a
{
  private final aa EyW;
  private final v EyX;
  private final AtomicBoolean EyY;
  private final Object lock;
  private final f.a xFC;
  
  public u$a(aa paramaa, f.a parama, v paramv, AtomicBoolean paramAtomicBoolean, Object paramObject)
  {
    AppMethodBeat.i(331830);
    this.EyW = parama;
    this.xFC = paramv;
    this.EyX = paramAtomicBoolean;
    this.EyY = paramObject;
    this.lock = localObject;
    AppMethodBeat.o(331830);
  }
  
  public final void a(final String paramString, final int paramInt, final com.tencent.mm.g.d paramd)
  {
    int i = 1;
    AppMethodBeat.i(166348);
    s.u(paramString, "mediaId");
    synchronized (this.lock)
    {
      if (!this.EyY.get()) {
        if (paramd != null) {
          break label112;
        }
      }
      for (Object localObject1 = null;; localObject1 = ah.aiuX)
      {
        if (localObject1 == null)
        {
          localObject1 = (a)this;
          Log.e("Finder.VideoDownloader", "sceneResult is null! mediaId=" + paramString + " ret=" + paramInt);
          u.bt((a)new d((a)localObject1, paramString, paramInt, paramd));
        }
        paramString = ah.aiuX;
        AppMethodBeat.o(166348);
        return;
        label112:
        Log.i("Finder.VideoDownloader", "[onFinish] mediaId=" + paramString + " ret=" + paramInt + " fileLength=" + paramd.field_fileLength + " sceneResult=" + paramd.field_retCode + " videoFormat:" + paramd.field_videoFormat + " videoFlag=" + paramd.field_videoFlag);
        localObject1 = u.EyU;
        s.u(paramString, "mediaId");
        localObject1 = new long[3];
        CdnLogic.queryDownloadedSize(paramString, (long[])localObject1);
        if ((localObject1[0] != localObject1[1]) || (localObject1[1] != localObject1[2])) {
          break;
        }
        if ((i == 0) && ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))) {
          com.tencent.mm.ae.d.uiThread((a)u.a.b.Ezc);
        }
        localObject1 = e.FNF;
        e.a(paramString, paramd.field_fileLength, paramd.field_fileLength, 3);
        localObject1 = e.FNF;
        e.aAM(paramString);
        u.bt((a)new c(this, paramString, paramInt, paramd));
      }
      Log.e("Finder.VideoDownloader", "[checkFinishValid] mediaId=" + paramString + ' ' + localObject1[0] + ':' + localObject1[1] + ':' + localObject1[2]);
      i = 0;
    }
  }
  
  public final void a(final String paramString1, final long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(331869);
    s.u(paramString1, "mediaId");
    synchronized (this.lock)
    {
      Log.i("Finder.VideoDownloader", "[onMoovReady] mediaId=" + paramString1 + " offset=" + paramLong1 + " total=" + paramLong2 + " fileFormat=[" + this.EyX.ExF + "=>" + paramString2 + "]} isHasStop=" + this.EyY.get());
      if (!this.EyY.get())
      {
        final ah.a locala = new ah.a();
        if ((this.xFC instanceof FinderVideoView)) {
          locala.aiwY = ((FinderVideoView)this.xFC).qW(paramLong1);
        }
        Object localObject1 = e.FNF;
        if (!e.aAN(paramString1).field_moovReady)
        {
          bool = true;
          localObject1 = e.FNF;
          localObject1 = paramString2;
          if (paramString2 == null) {
            localObject1 = "";
          }
          e.ig(paramString1, (String)localObject1);
          paramString2 = e.FNF;
          e.aAM(paramString1);
          u.bt((a)new e(this, paramString1, paramLong1, paramLong2, locala, bool));
        }
      }
      else
      {
        paramString1 = ah.aiuX;
        AppMethodBeat.o(331869);
        return;
      }
      boolean bool = false;
    }
  }
  
  public final void h(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(166347);
    s.u(paramString, "mediaId");
    synchronized (this.lock)
    {
      if (!this.EyY.get())
      {
        Log.i("Finder.VideoDownloader", "[onProgress] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2);
        e locale = e.FNF;
        e.a(paramString, paramLong1, paramLong2, 1);
        locale = e.FNF;
        e.aAM(paramString);
        u.bt((a)new f(this, paramString, paramLong1, paramLong2));
      }
      paramString = ah.aiuX;
      AppMethodBeat.o(166347);
      return;
    }
  }
  
  public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(166346);
    s.u(paramString, "mediaId");
    synchronized (this.lock)
    {
      if (!this.EyY.get()) {
        u.bt((a)new a(this, paramString, paramLong1, paramLong2));
      }
      ah localah = ah.aiuX;
      Log.i("Finder.VideoDownloader", "[onDataAvailable] mediaId=" + paramString + " offset=" + paramLong1 + " total=" + paramLong2);
      AppMethodBeat.o(166346);
      return;
    }
  }
  
  public final void onM3U8Ready(String paramString1, String paramString2)
  {
    AppMethodBeat.i(331857);
    s.u(paramString1, "mediaId");
    AppMethodBeat.o(331857);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements a<ah>
  {
    a(u.a parama, String paramString, long paramLong1, long paramLong2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements a<ah>
  {
    c(u.a parama, String paramString, int paramInt, com.tencent.mm.g.d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements a<ah>
  {
    d(u.a parama, String paramString, int paramInt, com.tencent.mm.g.d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements a<ah>
  {
    e(u.a parama, String paramString, long paramLong1, long paramLong2, ah.a parama1, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements a<ah>
  {
    f(u.a parama, String paramString, long paramLong1, long paramLong2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.u.a
 * JD-Core Version:    0.7.0.1
 */