package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.si;
import com.tencent.mm.autogen.a.si.a;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.preload.model.b;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.logic.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.pluginsdk.ui.tools.i.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "firstCacheTimeStep", "", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isViewFocused", "setViewFocused", "lastDownloadStatus", "lastSeconds", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "limitSeconds", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "preloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "preloadModel$delegate", "Lkotlin/Lazy;", "textureView", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "totalSeconds", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "videoMatrix", "Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "getVideoMatrix", "()Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "setVideoMatrix", "(Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;)V", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkCompleted", "createMp4Parser", "Lcom/tencent/mm/plugin/Atom/IMp4Parser;", "createVideoFilePath", "", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrPosSec", "getDefaultLog", "", "getMediaId", "getVideoDurationSec", "getVideoMediaId", "isPlaying", "layoutId", "logTips", "onCompletion", "onM3U8Ready", "mediaId", "m3u8", "onMediaInfoAndMatrixPrepared", "onMoovReady", "moovPos", "", "length", "isPreparedMoovReadyResult", "onPrepareMoovReady", "onProgress", "offset", "total", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "pauseWithCancel", "play", "requestAudioFocus", "reset", "seekTo", "seconds", "", "afterPlay", "time", "afterSeekPlay", "setIMMVideoViewCallback", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setInterceptDetach", "isInterceptDetach", "setLocalVideoMedia", "path", "matrix", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setLoop", "loop", "setMute", "mute", "setVideoCore", "setVideoMedia", "isLocal", "downloadUrl", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setVideoTotalTime", "startOrPlay", "stop", "updateTime", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderVideoView
  extends MMVideoView
{
  public static final FinderVideoView.a Gro;
  private l AJn;
  private v BtQ;
  private final kotlin.j EUE;
  private boolean Flr;
  private boolean Fls;
  private ab Flu;
  private volatile boolean GnV;
  private boolean GpI;
  private w GpJ;
  private byz Grp;
  private SynchronizedVideoPlayTextureView Grq;
  private int Grr;
  private final int Grs;
  private int Grt;
  private int Gru;
  private int Grv;
  private final com.tencent.mm.model.d nmW;
  
  static
  {
    AppMethodBeat.i(168206);
    Gro = new FinderVideoView.a((byte)0);
    AppMethodBeat.o(168206);
  }
  
  public FinderVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168204);
    setReporter((i.c)new i.c()
    {
      public final void Du(String paramAnonymousString) {}
      
      public final void hp(long paramAnonymousLong)
      {
        int j = 1;
        AppMethodBeat.i(168171);
        Object localObject = this.Grw.getMediaInfo();
        int i;
        label140:
        label176:
        label320:
        if (localObject == null)
        {
          localObject = null;
          label68:
          label212:
          label356:
          if (localObject != null)
          {
            if (paramAnonymousLong < 200L) {
              h.OAn.idkeyStat(1302L, paramAnonymousLong, 1L, false);
            }
            if (120L > paramAnonymousLong) {
              break label432;
            }
            if (paramAnonymousLong > 139L) {
              break label427;
            }
            i = 1;
            if (i != 0)
            {
              h.OAn.idkeyStat(1302L, 200L, 1L, false);
              if (120L > paramAnonymousLong) {
                break label442;
              }
              if (paramAnonymousLong > 124L) {
                break label437;
              }
              i = 1;
              label104:
              if (i != 0) {
                h.OAn.idkeyStat(1302L, 201L, 1L, false);
              }
              if (125L > paramAnonymousLong) {
                break label452;
              }
              if (paramAnonymousLong > 129L) {
                break label447;
              }
              i = 1;
              if (i != 0) {
                h.OAn.idkeyStat(1302L, 202L, 1L, false);
              }
              if (130L > paramAnonymousLong) {
                break label462;
              }
              if (paramAnonymousLong > 134L) {
                break label457;
              }
              i = 1;
              if (i != 0) {
                h.OAn.idkeyStat(1302L, 203L, 1L, false);
              }
              if (135L > paramAnonymousLong) {
                break label472;
              }
              if (paramAnonymousLong > 139L) {
                break label467;
              }
              i = 1;
              if (i != 0) {
                h.OAn.idkeyStat(1302L, 204L, 1L, false);
              }
            }
            if (141L > paramAnonymousLong) {
              break label482;
            }
            if (paramAnonymousLong > 160L) {
              break label477;
            }
            i = 1;
            label248:
            if (i != 0)
            {
              h.OAn.idkeyStat(1302L, 210L, 1L, false);
              if (141L > paramAnonymousLong) {
                break label492;
              }
              if (paramAnonymousLong > 145L) {
                break label487;
              }
              i = 1;
              if (i != 0) {
                h.OAn.idkeyStat(1302L, 211L, 1L, false);
              }
              if (146L > paramAnonymousLong) {
                break label502;
              }
              if (paramAnonymousLong > 150L) {
                break label497;
              }
              i = 1;
              if (i != 0) {
                h.OAn.idkeyStat(1302L, 212L, 1L, false);
              }
              if (151L > paramAnonymousLong) {
                break label512;
              }
              if (paramAnonymousLong > 155L) {
                break label507;
              }
              i = 1;
              if (i != 0) {
                h.OAn.idkeyStat(1302L, 213L, 1L, false);
              }
              if (156L > paramAnonymousLong) {
                break label522;
              }
              if (paramAnonymousLong > 160L) {
                break label517;
              }
              i = j;
            }
          }
        }
        for (;;)
        {
          label284:
          if (i != 0) {
            h.OAn.idkeyStat(1302L, 214L, 1L, false);
          }
          AppMethodBeat.o(168171);
          return;
          localObject = ((v)localObject).Grz;
          break;
          label427:
          i = 0;
          break label68;
          label432:
          i = 0;
          break label68;
          label437:
          i = 0;
          break label104;
          label442:
          i = 0;
          break label104;
          label447:
          i = 0;
          break label140;
          label452:
          i = 0;
          break label140;
          label457:
          i = 0;
          break label176;
          label462:
          i = 0;
          break label176;
          label467:
          i = 0;
          break label212;
          label472:
          i = 0;
          break label212;
          label477:
          i = 0;
          break label248;
          label482:
          i = 0;
          break label248;
          label487:
          i = 0;
          break label284;
          label492:
          i = 0;
          break label284;
          label497:
          i = 0;
          break label320;
          label502:
          i = 0;
          break label320;
          label507:
          i = 0;
          break label356;
          label512:
          i = 0;
          break label356;
          label517:
          i = 0;
          continue;
          label522:
          i = 0;
        }
      }
    });
    this.EUE = kotlin.k.cm((kotlin.g.a.a)FinderVideoView.c.Gry);
    this.Flr = true;
    this.GnV = true;
    this.nmW = new com.tencent.mm.model.d();
    paramContext = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.Grs = com.tencent.mm.plugin.finder.storage.d.eRl();
    this.Grt = -1;
    this.Grv = 3;
    AppMethodBeat.o(168204);
  }
  
  public FinderVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168205);
    setReporter((i.c)new i.c()
    {
      public final void Du(String paramAnonymousString) {}
      
      public final void hp(long paramAnonymousLong)
      {
        int j = 1;
        AppMethodBeat.i(168171);
        Object localObject = this.Grw.getMediaInfo();
        int i;
        label140:
        label176:
        label320:
        if (localObject == null)
        {
          localObject = null;
          label68:
          label212:
          label356:
          if (localObject != null)
          {
            if (paramAnonymousLong < 200L) {
              h.OAn.idkeyStat(1302L, paramAnonymousLong, 1L, false);
            }
            if (120L > paramAnonymousLong) {
              break label432;
            }
            if (paramAnonymousLong > 139L) {
              break label427;
            }
            i = 1;
            if (i != 0)
            {
              h.OAn.idkeyStat(1302L, 200L, 1L, false);
              if (120L > paramAnonymousLong) {
                break label442;
              }
              if (paramAnonymousLong > 124L) {
                break label437;
              }
              i = 1;
              label104:
              if (i != 0) {
                h.OAn.idkeyStat(1302L, 201L, 1L, false);
              }
              if (125L > paramAnonymousLong) {
                break label452;
              }
              if (paramAnonymousLong > 129L) {
                break label447;
              }
              i = 1;
              if (i != 0) {
                h.OAn.idkeyStat(1302L, 202L, 1L, false);
              }
              if (130L > paramAnonymousLong) {
                break label462;
              }
              if (paramAnonymousLong > 134L) {
                break label457;
              }
              i = 1;
              if (i != 0) {
                h.OAn.idkeyStat(1302L, 203L, 1L, false);
              }
              if (135L > paramAnonymousLong) {
                break label472;
              }
              if (paramAnonymousLong > 139L) {
                break label467;
              }
              i = 1;
              if (i != 0) {
                h.OAn.idkeyStat(1302L, 204L, 1L, false);
              }
            }
            if (141L > paramAnonymousLong) {
              break label482;
            }
            if (paramAnonymousLong > 160L) {
              break label477;
            }
            i = 1;
            label248:
            if (i != 0)
            {
              h.OAn.idkeyStat(1302L, 210L, 1L, false);
              if (141L > paramAnonymousLong) {
                break label492;
              }
              if (paramAnonymousLong > 145L) {
                break label487;
              }
              i = 1;
              if (i != 0) {
                h.OAn.idkeyStat(1302L, 211L, 1L, false);
              }
              if (146L > paramAnonymousLong) {
                break label502;
              }
              if (paramAnonymousLong > 150L) {
                break label497;
              }
              i = 1;
              if (i != 0) {
                h.OAn.idkeyStat(1302L, 212L, 1L, false);
              }
              if (151L > paramAnonymousLong) {
                break label512;
              }
              if (paramAnonymousLong > 155L) {
                break label507;
              }
              i = 1;
              if (i != 0) {
                h.OAn.idkeyStat(1302L, 213L, 1L, false);
              }
              if (156L > paramAnonymousLong) {
                break label522;
              }
              if (paramAnonymousLong > 160L) {
                break label517;
              }
              i = j;
            }
          }
        }
        for (;;)
        {
          label284:
          if (i != 0) {
            h.OAn.idkeyStat(1302L, 214L, 1L, false);
          }
          AppMethodBeat.o(168171);
          return;
          localObject = ((v)localObject).Grz;
          break;
          label427:
          i = 0;
          break label68;
          label432:
          i = 0;
          break label68;
          label437:
          i = 0;
          break label104;
          label442:
          i = 0;
          break label104;
          label447:
          i = 0;
          break label140;
          label452:
          i = 0;
          break label140;
          label457:
          i = 0;
          break label176;
          label462:
          i = 0;
          break label176;
          label467:
          i = 0;
          break label212;
          label472:
          i = 0;
          break label212;
          label477:
          i = 0;
          break label248;
          label482:
          i = 0;
          break label248;
          label487:
          i = 0;
          break label284;
          label492:
          i = 0;
          break label284;
          label497:
          i = 0;
          break label320;
          label502:
          i = 0;
          break label320;
          label507:
          i = 0;
          break label356;
          label512:
          i = 0;
          break label356;
          label517:
          i = 0;
          continue;
          label522:
          i = 0;
        }
      }
    });
    this.EUE = kotlin.k.cm((kotlin.g.a.a)FinderVideoView.c.Gry);
    this.Flr = true;
    this.GnV = true;
    this.nmW = new com.tencent.mm.model.d();
    paramContext = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.Grs = com.tencent.mm.plugin.finder.storage.d.eRl();
    this.Grt = -1;
    this.Grv = 3;
    AppMethodBeat.o(168205);
  }
  
  private final void a(String paramString1, String paramString2, byz parambyz, x paramx, FeedData paramFeedData)
  {
    AppMethodBeat.i(335087);
    this.Grp = parambyz;
    a("", paramString1, paramString2, null, paramx, paramFeedData);
    AppMethodBeat.o(335087);
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, dji paramdji, x paramx, FeedData paramFeedData)
  {
    AppMethodBeat.i(335093);
    this.BtQ = new v(paramString1, paramString2, paramString3, paramdji, paramx, paramFeedData);
    paramString3 = this.BtQ;
    int i;
    if (paramString3 != null)
    {
      if ((paramdji == null) || (paramdji.aaPf != true)) {
        break label140;
      }
      i = 1;
      if (i != 0)
      {
        paramString2 = paramdji.EDC;
        if (paramString2 != null) {
          break label146;
        }
      }
    }
    label140:
    label146:
    for (paramString2 = null;; paramString2 = paramString2.aaPK)
    {
      setVideoMatrix(paramString2);
      Log.i("Finder.VideoView", s.X("[setVideoMedia] needCrop, ", getVideoMatrix()));
      fiw();
      super.b(false, paramString1, 0);
      this.oYr = paramString3.path;
      this.oYq = paramString3.mediaId;
      Log.i("Finder.VideoView", s.X("[setVideoMedia] ", getDefaultLog()));
      AppMethodBeat.o(335093);
      return;
      i = 0;
      break;
    }
  }
  
  private final void bUf()
  {
    AppMethodBeat.i(168202);
    this.nmW.a((d.a)new FinderVideoView.d());
    AppMethodBeat.o(168202);
  }
  
  private final boolean c(v paramv)
  {
    AppMethodBeat.i(335082);
    if (paramv == null)
    {
      Log.w("Finder.VideoView", "[checkCompleted] mediaInfo is null");
      AppMethodBeat.o(335082);
      return false;
    }
    if (paramv.Grz == null)
    {
      Log.w("Finder.VideoView", "[checkCompleted] localFinderMedia is null");
      AppMethodBeat.o(335082);
      return true;
    }
    Object localObject = e.FNF;
    az localaz = e.bS(paramv.mediaId, true);
    int j = localaz.ayR(paramv.path);
    Log.i("Finder.VideoView", "[checkCompleted] isDownloadFinishAndCheckFile=" + j + " cache=" + localaz + " path=" + paramv.path + ' ' + getDefaultLog());
    localObject = com.tencent.mm.plugin.finder.preload.f.EUC;
    si localsi;
    if (com.tencent.mm.plugin.finder.preload.f.eHI())
    {
      localsi = new si();
      si.a locala = localsi.hVv;
      paramv = paramv.Grz;
      if (paramv != null) {
        break label259;
      }
      paramv = "";
      locala.mediaId = paramv;
      localsi.hVv.hVy = localaz.field_fileFormat;
      localsi.hVv.hVx = localaz.field_hasPlayed;
      paramv = localsi.hVv;
      if (j != 0) {
        break label280;
      }
    }
    label259:
    label280:
    for (int i = (int)(100.0F * (float)localaz.field_cacheSize / (float)localaz.field_totalSize);; i = 0)
    {
      paramv.hVw = i;
      localsi.publish();
      if (j != 0) {
        break label285;
      }
      AppMethodBeat.o(335082);
      return true;
      localObject = paramv.mediaId;
      paramv = (v)localObject;
      if (localObject != null) {
        break;
      }
      paramv = "";
      break;
    }
    label285:
    AppMethodBeat.o(335082);
    return false;
  }
  
  private final String getDefaultLog()
  {
    AppMethodBeat.i(168195);
    StringBuilder localStringBuilder = new StringBuilder("videoView=").append(hashCode()).append("->textureView=").append(this.wCd.hashCode()).append(" mediaId=");
    Object localObject = this.BtQ;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((v)localObject).mediaId)
    {
      localObject = localObject;
      AppMethodBeat.o(168195);
      return localObject;
    }
  }
  
  private final b getPreloadModel()
  {
    AppMethodBeat.i(335073);
    b localb = (b)this.EUE.getValue();
    AppMethodBeat.o(335073);
    return localb;
  }
  
  public final void Bh(int paramInt)
  {
    AppMethodBeat.i(168190);
    super.Bh(paramInt);
    ab localab;
    if (this.Grt != paramInt)
    {
      localab = this.Flu;
      if (localab != null)
      {
        localObject = this.BtQ;
        if (localObject != null) {
          break label63;
        }
      }
    }
    label63:
    for (Object localObject = null;; localObject = ((v)localObject).Grz)
    {
      localab.a((dji)localObject, paramInt, this.Gru);
      this.Grt = paramInt;
      AppMethodBeat.o(168190);
      return;
    }
  }
  
  public final boolean G(double paramDouble)
  {
    AppMethodBeat.i(335432);
    boolean bool = super.G(paramDouble);
    AppMethodBeat.o(335432);
    return bool;
  }
  
  public final void J(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(168200);
    Log.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s isPreparedMoovReadyResult:%s", new Object[] { bNL(), Long.valueOf(paramLong), Integer.valueOf(this.oYv), this.oYq, Boolean.valueOf(paramBoolean) });
    if (this.oYv != 0)
    {
      Log.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(168200);
      return;
    }
    iJV();
    try
    {
      if (this.oYu == null)
      {
        Log.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bNL() });
        AppMethodBeat.o(168200);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "%s deal moov ready error [%s]", new Object[] { bNL(), this.oYq });
      AppMethodBeat.o(168200);
      return;
    }
    if ((paramBoolean) || (this.oYu.O(this.oYr, paramLong)))
    {
      this.oYv = this.oYu.bTU();
      Log.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { bNL(), Integer.valueOf(this.oYv), this.oYq });
      if (xa(0)) {
        bNS();
      }
      if (this.oYw != -1) {
        break label321;
      }
    }
    label321:
    for (int i = 1;; i = 2)
    {
      this.oYt = i;
      AppMethodBeat.o(168200);
      return;
      Log.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { bNL(), this.oYq });
      this.oYp.requestVideoData(this.oYq, 0, -1);
      AppMethodBeat.o(168200);
      return;
    }
  }
  
  public final boolean X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168189);
    Log.i("Finder.VideoView", "[seekTo] time=" + paramInt + " afterSeekPlay=" + paramBoolean + ' ' + getDefaultLog());
    bUf();
    paramBoolean = super.X(paramInt, paramBoolean);
    AppMethodBeat.o(168189);
    return paramBoolean;
  }
  
  public boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    int i = 0;
    AppMethodBeat.i(168199);
    s.u(paramPInt1, "start");
    s.u(paramPInt2, "end");
    paramPInt1.value = Math.max(paramInt, this.oYz);
    if (this.oYt == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt2.value = (paramPInt1.value + this.Grv + 1);
    }
    this.Grv += this.oYE.oYJ;
    if (this.oYt == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.oYA + 8);
    }
    int j;
    if ((this.oYt == 3) || (this.oYt == 4))
    {
      paramPInt1.value = this.oYz;
      paramPInt2.value = (this.oYA + paramInt + 1 + this.oYE.oYK);
      j = Math.min(kotlin.h.a.eH(getPreloadModel().EVl / 100.0F * this.oYv), getPreloadModel().EVr);
      if (j > 0) {
        break label435;
      }
      i = j;
      if (paramPInt2.value < this.oYv / 2.0F)
      {
        paramPInt2.value = ((int)(this.oYv / 2.0F + 1.0F));
        i = j;
      }
    }
    for (;;)
    {
      if (paramPInt2.value >= this.oYv + 1) {
        paramPInt2.value = (this.oYv + 1);
      }
      if (paramPInt2.value >= paramPInt1.value) {
        break;
      }
      paramPInt1.value += this.oYE.oYK;
      Log.i("Finder.VideoView", bNL() + " [start:end]=[" + paramPInt1.value + ':' + paramPInt2.value + "],playStatus=" + this.oYt + ",playTime=" + paramInt + ",cachePlayTime=" + this.oYz + ",cacheTimeStep=" + this.oYA + ",timeDuration=" + this.oYv + ",targetSecond=" + i + ",cdnMediaId=" + this.oYq);
      AppMethodBeat.o(168199);
      return true;
      label435:
      i = j;
      if (paramPInt2.value < j)
      {
        paramPInt2.value = (j + 1);
        i = j;
      }
    }
    Log.i("Finder.VideoView", bNL() + " [start:end]=[" + paramPInt1.value + ':' + paramPInt2.value + "],playStatus=" + this.oYt + ",playTime=" + paramInt + ",cachePlayTime=" + this.oYz + ",cacheTimeStep=" + this.oYA + ",timeDuration=" + this.oYv + ",targetSecond=" + i + ",cdnMediaId=" + this.oYq);
    AppMethodBeat.o(168199);
    return true;
  }
  
  public final void b(x paramx, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(335307);
    s.u(paramx, "video");
    s.u(paramFeedData, "feedData");
    if (paramBoolean)
    {
      Object localObject2 = paramx.eCF().url;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str = paramx.aUt();
      localObject2 = paramx.eCF().EDC;
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((dju)localObject2).aaPK)
      {
        a((String)localObject1, str, (byz)localObject2, paramx, paramFeedData);
        AppMethodBeat.o(335307);
        return;
      }
    }
    a(paramx.getUrl(), paramx.getPath(), paramx.aUt(), paramx.eCF(), paramx, paramFeedData);
    AppMethodBeat.o(335307);
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(335437);
    paramBoolean = super.b(paramDouble, paramBoolean);
    AppMethodBeat.o(335437);
    return paramBoolean;
  }
  
  public final String bNL()
  {
    AppMethodBeat.i(335454);
    String str = "mediaId:" + getMediaId() + hashCode();
    AppMethodBeat.o(335454);
    return str;
  }
  
  public final void bNO() {}
  
  public final com.tencent.mm.plugin.a.f bNQ()
  {
    AppMethodBeat.i(335446);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (com.tencent.mm.plugin.finder.storage.d.eRM() == 1)
    {
      localObject = (com.tencent.mm.plugin.a.f)new com.tencent.mm.plugin.a.j();
      AppMethodBeat.o(335446);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (com.tencent.mm.plugin.finder.storage.d.eRM() == 2)
    {
      localObject = (com.tencent.mm.plugin.a.f)new com.tencent.mm.plugin.a.k();
      AppMethodBeat.o(335446);
      return localObject;
    }
    localObject = (com.tencent.mm.plugin.a.f)new com.tencent.mm.plugin.finder.video.parser.a();
    AppMethodBeat.o(335446);
    return localObject;
  }
  
  public final boolean bNU()
  {
    AppMethodBeat.i(168185);
    Object localObject;
    if (!this.Flr)
    {
      StringBuilder localStringBuilder = new StringBuilder("[play] unFocused. ").append(getDefaultLog()).append(" mediaId=");
      localObject = this.BtQ;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((v)localObject).mediaId)
      {
        Log.i("Finder.VideoView", localObject);
        AppMethodBeat.o(168185);
        return false;
      }
    }
    if (this.Grr == 1)
    {
      this.oYs = 1;
      this.Grr = 0;
      localObject = this.oYp;
      if (localObject != null) {
        ((com.tencent.mm.modelvideo.f)localObject).w(getVideoMediaId(), this.oYr, this.url);
      }
      int i = this.wCd.getCurrentPosition() / 1000;
      xa(i);
      Log.i("Finder.VideoView", "continue to download... mediaId=" + getVideoMediaId() + " playSec=" + i);
    }
    if ((this.Flr) && (super.bNU()))
    {
      bUf();
      localObject = this.Grq;
      if (localObject != null) {
        ((SynchronizedVideoPlayTextureView)localObject).setOneTimeVideoTextureUpdateCallback((i.e)this);
      }
      localObject = this.Flu;
      if (localObject != null) {
        ((ab)localObject).egu();
      }
      AppMethodBeat.o(168185);
      return true;
    }
    AppMethodBeat.o(168185);
    return false;
  }
  
  public final i dY(final Context paramContext)
  {
    AppMethodBeat.i(168180);
    this.sJh = 1;
    paramContext = new b(this, paramContext);
    paramContext.setIsOnlineVideoType(true);
    paramContext.setNeedResetExtractor(true);
    ah localah = ah.aiuX;
    this.Grq = ((SynchronizedVideoPlayTextureView)paramContext);
    paramContext = this.Grq;
    s.checkNotNull(paramContext);
    paramContext = (i)paramContext;
    AppMethodBeat.o(168180);
    return paramContext;
  }
  
  public final int eLK()
  {
    AppMethodBeat.i(335238);
    Log.i("Finder.VideoView", "[pauseWithCancel] " + getDefaultLog() + " downloadStatus=" + this.oYs + ", isPrepared=" + this.hS);
    this.Grr = this.oYs;
    com.tencent.mm.modelvideo.f localf = this.oYp;
    if (localf != null) {
      localf.js(getVideoMediaId());
    }
    pause();
    AppMethodBeat.o(335238);
    return 0;
  }
  
  public int edi()
  {
    return e.f.fake_finder_video_view;
  }
  
  public void fiw() {}
  
  public final boolean fjD()
  {
    return this.Flr;
  }
  
  public final boolean fjE()
  {
    return this.Fls;
  }
  
  public final boolean fjF()
  {
    return this.GnV;
  }
  
  public final boolean fjG()
  {
    AppMethodBeat.i(335261);
    boolean bool = this.GnV;
    start();
    AppMethodBeat.o(335261);
    return bool;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(335206);
    Object localObject = this.Grq;
    if (localObject == null)
    {
      AppMethodBeat.o(335206);
      return null;
    }
    localObject = ((SynchronizedVideoPlayTextureView)localObject).getBitmap();
    AppMethodBeat.o(335206);
    return localObject;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(335398);
    int i = super.getCurrPosSec();
    AppMethodBeat.o(335398);
    return i;
  }
  
  public final ab getLifecycle()
  {
    return this.Flu;
  }
  
  public String getMediaId()
  {
    Object localObject1 = this.BtQ;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((v)localObject1).mediaId)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      return localObject2;
    }
  }
  
  public final v getMediaInfo()
  {
    return this.BtQ;
  }
  
  public final w getMuteListener()
  {
    return this.GpJ;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(335402);
    int i = super.getVideoDurationSec();
    AppMethodBeat.o(335402);
    return i;
  }
  
  public final byz getVideoMatrix()
  {
    return this.Grp;
  }
  
  public final String getVideoMediaId()
  {
    v localv = this.BtQ;
    if (localv == null) {
      return null;
    }
    return localv.mediaId;
  }
  
  public final boolean get_isPreviewing()
  {
    return this.GpI;
  }
  
  public final void h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(168196);
    if (!Util.isEqual(this.oYq, paramString))
    {
      AppMethodBeat.o(168196);
      return;
    }
    Log.i("Finder.VideoView", "%s download  onPlayProgress [%d, %d] pauseByLoadData=%s playStatus=%s", new Object[] { bNL(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(this.oYy), Integer.valueOf(this.oYt) });
    if ((this.oYy) && (this.oYt == 3)) {
      xa(getCurrPosSec());
    }
    AppMethodBeat.o(168196);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(335425);
    boolean bool = super.isPlaying();
    AppMethodBeat.o(335425);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(335291);
    Object localObject = this.BtQ;
    if (localObject != null)
    {
      ab localab = getLifecycle();
      if (localab != null) {
        localab.a(((v)localObject).Grz, getVideoDurationSec(), getVideoDurationSec());
      }
      if (this.oYG)
      {
        localObject = getLifecycle();
        if (localObject != null) {
          ((ab)localObject).eCP();
        }
      }
    }
    super.onCompletion();
    AppMethodBeat.o(335291);
  }
  
  public void onTextureUpdate()
  {
    AppMethodBeat.i(168203);
    super.onTextureUpdate();
    ab localab = this.Flu;
    if (localab != null) {
      localab.ph(0L);
    }
    AppMethodBeat.o(168203);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(178468);
    super.onUIDestroy();
    this.Flr = false;
    this.BtQ = null;
    this.Grp = null;
    Log.i("Finder.VideoView", "[onUIDestroy] " + getDefaultLog() + "  " + "");
    AppMethodBeat.o(178468);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(168186);
    super.onUIPause();
    AppMethodBeat.o(168186);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(168187);
    super.onUIResume();
    AppMethodBeat.o(168187);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(168183);
    this.nmW.gR(false);
    Log.i("Finder.VideoView", "[pause] " + getDefaultLog() + "  " + "");
    ab localab = this.Flu;
    if (localab != null) {
      localab.a(null);
    }
    boolean bool = super.pause();
    AppMethodBeat.o(168183);
    return bool;
  }
  
  public final boolean qW(long paramLong)
  {
    AppMethodBeat.i(335389);
    if (this.oYu == null)
    {
      Log.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bNL() });
      AppMethodBeat.o(335389);
      return false;
    }
    boolean bool = this.oYu.O(this.oYr, paramLong);
    AppMethodBeat.o(335389);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(168198);
    super.reset();
    this.Grv = 3;
    AppMethodBeat.o(168198);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(335412);
    s.u(paramb, "_callback");
    super.setIMMVideoViewCallback(paramb);
    AppMethodBeat.o(335412);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    AppMethodBeat.i(168181);
    SynchronizedVideoPlayTextureView localSynchronizedVideoPlayTextureView = this.Grq;
    if (localSynchronizedVideoPlayTextureView != null) {
      localSynchronizedVideoPlayTextureView.setInterceptDetach(paramBoolean);
    }
    AppMethodBeat.o(168181);
  }
  
  public final void setLifecycle(ab paramab)
  {
    this.Flu = paramab;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(335419);
    super.setLoop(paramBoolean);
    AppMethodBeat.o(335419);
  }
  
  public final void setMediaInfo(v paramv)
  {
    this.BtQ = paramv;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(168194);
    super.setMute(paramBoolean);
    AppMethodBeat.o(168194);
  }
  
  public final void setMuteListener(w paramw)
  {
    this.GpJ = paramw;
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.GnV = paramBoolean;
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.Fls = paramBoolean;
  }
  
  public final void setVideoCore(l paraml)
  {
    this.AJn = paraml;
  }
  
  public final void setVideoMatrix(byz parambyz)
  {
    this.Grp = parambyz;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(168191);
    super.setVideoTotalTime(paramInt);
    this.Gru = paramInt;
    AppMethodBeat.o(168191);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.Flr = paramBoolean;
  }
  
  public final void set_isPreviewing(boolean paramBoolean)
  {
    this.GpI = paramBoolean;
  }
  
  public final void start()
  {
    AppMethodBeat.i(168188);
    if (!this.Flr)
    {
      Log.w("Finder.VideoView", s.X("isViewFocused=", Boolean.valueOf(this.Flr)));
      AppMethodBeat.o(168188);
      return;
    }
    if (this.BtQ == null)
    {
      Log.w("Finder.VideoView", "mediaInfo is null!");
      AppMethodBeat.o(168188);
      return;
    }
    if (this.wCd == null)
    {
      Log.w("Finder.VideoView", "videoView is null!");
      AppMethodBeat.o(168188);
      return;
    }
    if (this.oYt == 3) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(168188);
      return;
    }
    Log.i("Finder.VideoView", "[start#1] isNeverStart=" + this.GnV + " isViewFocused=" + this.Flr + " isPlaying=false " + getDefaultLog());
    if (!this.GnV)
    {
      bNU();
      AppMethodBeat.o(168188);
      return;
    }
    Object localObject = this.Flu;
    if (localObject != null) {
      ((ab)localObject).a(this.BtQ, 0);
    }
    if (c(this.BtQ))
    {
      localObject = this.wCd.getVideoPath();
      v localv = this.BtQ;
      s.checkNotNull(localv);
      if (!s.p(localObject, localv.path))
      {
        localObject = this.wCd;
        localv = this.BtQ;
        s.checkNotNull(localv);
        ((i)localObject).setVideoPath(localv.path);
      }
      this.oYp = null;
      this.oYs = 3;
      this.Grr = 0;
      localObject = this.Grq;
      if (localObject != null) {
        ((SynchronizedVideoPlayTextureView)localObject).setIsOnlineVideoType(false);
      }
      boolean bool = bNU();
      if (!bool)
      {
        localObject = (CharSequence)this.wCd.getVideoPath();
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label465;
        }
        i = 1;
        if (i != 0)
        {
          localObject = new StringBuilder("[start] ERROR! videoPath=").append(this.wCd.getVideoPath()).append(" completedPath=");
          localv = this.BtQ;
          s.checkNotNull(localv);
          Log.e("Finder.VideoView", localv.path);
        }
      }
      Log.i("Finder.VideoView", "[start] ret=" + bool + " has download! local path:" + this.wCd.getVideoPath());
    }
    for (;;)
    {
      hp(1L + getReportIdkey());
      this.GnV = false;
      AppMethodBeat.o(168188);
      return;
      label465:
      i = 0;
      break;
      localObject = this.Grq;
      if (localObject != null) {
        ((SynchronizedVideoPlayTextureView)localObject).setIsOnlineVideoType(true);
      }
      if ((this.oYp != null) && (this.oYs != 1))
      {
        Log.i("Finder.VideoView", s.X("[start] need to download...", getDefaultLog()));
        showLoading();
        setDownloadStatus(1);
        this.oYp.a((f.a)this);
        this.oYp.w(this.oYq, this.oYr, this.url);
        hmY();
      }
      else
      {
        showLoading();
        if (this.oYp == null) {
          Log.e("Finder.VideoView", s.X("why proxy is null! ", getDefaultLog()));
        }
        Log.i("Finder.VideoView", s.X("[start] wait for download...", getDefaultLog()));
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(168182);
    super.stop();
    ab localab = this.Flu;
    if (localab != null) {
      ab.a.a(localab, this.BtQ);
    }
    this.GnV = true;
    this.BtQ = null;
    this.Grp = null;
    this.Flr = false;
    this.Grr = 0;
    Log.i("Finder.VideoView", "[stop] " + getDefaultLog() + "  " + "");
    AppMethodBeat.o(168182);
  }
  
  public final boolean xb(int paramInt)
  {
    AppMethodBeat.i(168197);
    if (this.oYs == 3)
    {
      AppMethodBeat.o(168197);
      return true;
    }
    Object localObject1 = new PInt();
    Object localObject2 = new PInt();
    try
    {
      localPInt1 = new PInt();
      localPInt2 = new PInt();
      if ((paramInt != 0) || (this.oYu == null)) {
        break label566;
      }
      localPInt2.value = 0;
      localPInt1.value = localPInt2.value;
      bool = this.oYu.b(paramInt + 1, localPInt1, localPInt2);
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        PInt localPInt1;
        PInt localPInt2;
        boolean bool = false;
        continue;
        bool = false;
        continue;
        int i = paramInt + 1;
        continue;
        bool = false;
      }
    }
    if (bool)
    {
      i = localPInt2.value + 1;
      if ((this.oYp != null) && (this.oYu != null) && (this.oYu.a(paramInt, i, (PInt)localObject1, (PInt)localObject2)))
      {
        bool = this.oYp.isVideoDataAvailable(this.oYq, ((PInt)localObject1).value, ((PInt)localObject2).value);
        if (bool) {}
        for (;;)
        {
          try
          {
            this.oYz = Math.max(i, this.oYz);
            localObject1 = this.AJn;
            if (localObject1 != null)
            {
              localObject1 = ((l)localObject1).Gqb;
              if (localObject1 != null)
              {
                localObject2 = getMediaId();
                i = this.oYz;
                int j = this.oYv;
                s.u(localObject2, "mediaId");
                if (((com.tencent.mm.plugin.finder.preload.f)localObject1).eHH())
                {
                  Object localObject3 = e.FNF;
                  localObject3 = e.bS((String)localObject2, false);
                  if (((((com.tencent.mm.plugin.finder.preload.f)localObject1).getPreloadModel().EVr <= i) || (((com.tencent.mm.plugin.finder.preload.f)localObject1).getPreloadModel().EVq <= ((az)localObject3).eDy())) && (((com.tencent.mm.plugin.finder.preload.f)localObject1).EUH))
                  {
                    ((com.tencent.mm.plugin.finder.preload.f)localObject1).azg("startPreloadSecs=" + ((com.tencent.mm.plugin.finder.preload.f)localObject1).getPreloadModel().EVr + ", startPreloadPercent=" + ((com.tencent.mm.plugin.finder.preload.f)localObject1).getPreloadModel().EVq + " cachePercent=" + ((az)localObject3).eDy() + " cacheTime=" + i + ", timeDuration=" + j + ", [onOnlineCachePlaying#" + (String)localObject2 + ']');
                    ((com.tencent.mm.plugin.finder.preload.f)localObject1).EUH = false;
                  }
                }
              }
            }
            Log.i("Finder.VideoView", "ret=%s %s checkCanPlay range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { Boolean.valueOf(bool), bNL(), Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.oYt), Integer.valueOf(this.oYz), Integer.valueOf(this.oYA), this.oYq });
            AppMethodBeat.o(168197);
            return bool;
          }
          catch (Exception localException1) {}
          this.oYz = paramInt;
          continue;
          Log.e(this.TAG, "%s check video data error %s ", new Object[] { bNL(), localException1.toString() });
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderVideoView$createVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "getBusinessType", "", "setVideoPath", "", "fullFile", "", "stop", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends SynchronizedVideoPlayTextureView
  {
    b(FinderVideoView paramFinderVideoView, Context paramContext)
    {
      super();
    }
    
    public final int getBusinessType()
    {
      return 1;
    }
    
    public final void setVideoPath(String paramString)
    {
      AppMethodBeat.i(168175);
      Log.i("Finder.VideoView", s.X("[setVideoPath] ", FinderVideoView.a(this.Grw)));
      super.setVideoPath(paramString);
      AppMethodBeat.o(168175);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(168174);
      Log.i("Finder.VideoView", s.X("[stop] ", FinderVideoView.a(this.Grw)));
      super.stop();
      AppMethodBeat.o(168174);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoView
 * JD-Core Version:    0.7.0.1
 */