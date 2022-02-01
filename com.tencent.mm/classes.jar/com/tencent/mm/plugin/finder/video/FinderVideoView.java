package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.qu;
import com.tencent.mm.f.a.qu.a;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.preload.c;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "firstCacheTimeStep", "", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isViewFocused", "setViewFocused", "lastDownloadStatus", "lastSeconds", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "limitSeconds", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "preloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "preloadModel$delegate", "Lkotlin/Lazy;", "textureView", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "totalSeconds", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "videoMatrix", "Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "getVideoMatrix", "()Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "setVideoMatrix", "(Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;)V", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkCompleted", "createMp4Parser", "Lcom/tencent/mm/plugin/Atom/IMp4Parser;", "createVideoFilePath", "", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrPosSec", "getDefaultLog", "", "getMediaId", "getVideoDurationSec", "getVideoMediaId", "isPlaying", "layoutId", "logTips", "onCompletion", "onM3U8Ready", "mediaId", "m3u8", "onMediaInfoAndMatrixPrepared", "onMoovReady", "moovPos", "", "length", "isPreparedMoovReadyResult", "onPrepareMoovReady", "onProgress", "offset", "total", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "pauseWithCancel", "play", "requestAudioFocus", "reset", "seekTo", "seconds", "", "afterPlay", "time", "afterSeekPlay", "setIMMVideoViewCallback", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setInterceptDetach", "isInterceptDetach", "setLocalVideoMedia", "path", "matrix", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setLoop", "loop", "setMute", "mute", "setVideoCore", "setVideoMedia", "isLocal", "downloadUrl", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setVideoTotalTime", "startOrPlay", "stop", "updateTime", "Companion", "plugin-finder_release"})
public class FinderVideoView
  extends MMVideoView
{
  public static final a APc;
  private z ALf;
  private t ALh;
  private boolean ALj;
  private boolean ALk;
  private volatile boolean ALl;
  private boolean ANj;
  private u ANk;
  private blk AOV;
  private SynchronizedVideoPlayTextureView AOW;
  private int AOX;
  private final int AOY;
  private int AOZ;
  private int APa;
  private int APb;
  private final com.tencent.mm.model.d kKI;
  private l xkW;
  private final kotlin.f zKf;
  
  static
  {
    AppMethodBeat.i(168206);
    APc = new a((byte)0);
    AppMethodBeat.o(168206);
  }
  
  public FinderVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168204);
    setReporter((i.c)new i.c()
    {
      public final void EW(long paramAnonymousLong)
      {
        AppMethodBeat.i(168171);
        Object localObject = this.APd.getMediaInfo();
        if (localObject != null)
        {
          localObject = ((t)localObject).APg;
          if (localObject == null) {
            break label384;
          }
          if (paramAnonymousLong < 200L) {
            h.IzE.idkeyStat(1302L, paramAnonymousLong, 1L, false);
          }
          if (120L <= paramAnonymousLong) {
            break label73;
          }
        }
        label73:
        label202:
        label225:
        for (;;)
        {
          if (141L <= paramAnonymousLong) {
            break label227;
          }
          AppMethodBeat.o(168171);
          return;
          localObject = null;
          break;
          if (139L >= paramAnonymousLong)
          {
            h.IzE.idkeyStat(1302L, 200L, 1L, false);
            if (120L > paramAnonymousLong)
            {
              label103:
              if (125L <= paramAnonymousLong) {
                break label177;
              }
              label111:
              if (130L <= paramAnonymousLong) {
                break label202;
              }
            }
            for (;;)
            {
              if ((135L > paramAnonymousLong) || (139L < paramAnonymousLong)) {
                break label225;
              }
              h.IzE.idkeyStat(1302L, 204L, 1L, false);
              break;
              if (124L < paramAnonymousLong) {
                break label103;
              }
              h.IzE.idkeyStat(1302L, 201L, 1L, false);
              break label103;
              if (129L < paramAnonymousLong) {
                break label111;
              }
              h.IzE.idkeyStat(1302L, 202L, 1L, false);
              break label111;
              if (134L >= paramAnonymousLong) {
                h.IzE.idkeyStat(1302L, 203L, 1L, false);
              }
            }
          }
        }
        label177:
        label227:
        if (160L >= paramAnonymousLong)
        {
          h.IzE.idkeyStat(1302L, 210L, 1L, false);
          if (141L > paramAnonymousLong)
          {
            if (146L <= paramAnonymousLong) {
              break label312;
            }
            if (151L <= paramAnonymousLong) {
              break label337;
            }
          }
          for (;;)
          {
            if (156L <= paramAnonymousLong) {
              break label362;
            }
            AppMethodBeat.o(168171);
            return;
            if (145L < paramAnonymousLong) {
              break;
            }
            h.IzE.idkeyStat(1302L, 211L, 1L, false);
            break;
            if (150L < paramAnonymousLong) {
              break label265;
            }
            h.IzE.idkeyStat(1302L, 212L, 1L, false);
            break label265;
            if (155L >= paramAnonymousLong) {
              h.IzE.idkeyStat(1302L, 213L, 1L, false);
            }
          }
          label362:
          if (160L >= paramAnonymousLong) {
            h.IzE.idkeyStat(1302L, 214L, 1L, false);
          }
        }
        label265:
        label312:
        label337:
        AppMethodBeat.o(168171);
        label384:
      }
      
      public final void KP(String paramAnonymousString) {}
    });
    this.zKf = g.ar((kotlin.g.a.a)c.APf);
    this.ALj = true;
    this.ALl = true;
    this.kKI = com.tencent.mm.model.d.bcs();
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.AOY = com.tencent.mm.plugin.finder.storage.d.dSX();
    this.AOZ = -1;
    this.APb = 3;
    AppMethodBeat.o(168204);
  }
  
  public FinderVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168205);
    setReporter((i.c)new i.c()
    {
      public final void EW(long paramAnonymousLong)
      {
        AppMethodBeat.i(168171);
        Object localObject = this.APd.getMediaInfo();
        if (localObject != null)
        {
          localObject = ((t)localObject).APg;
          if (localObject == null) {
            break label384;
          }
          if (paramAnonymousLong < 200L) {
            h.IzE.idkeyStat(1302L, paramAnonymousLong, 1L, false);
          }
          if (120L <= paramAnonymousLong) {
            break label73;
          }
        }
        label73:
        label202:
        label225:
        for (;;)
        {
          if (141L <= paramAnonymousLong) {
            break label227;
          }
          AppMethodBeat.o(168171);
          return;
          localObject = null;
          break;
          if (139L >= paramAnonymousLong)
          {
            h.IzE.idkeyStat(1302L, 200L, 1L, false);
            if (120L > paramAnonymousLong)
            {
              label103:
              if (125L <= paramAnonymousLong) {
                break label177;
              }
              label111:
              if (130L <= paramAnonymousLong) {
                break label202;
              }
            }
            for (;;)
            {
              if ((135L > paramAnonymousLong) || (139L < paramAnonymousLong)) {
                break label225;
              }
              h.IzE.idkeyStat(1302L, 204L, 1L, false);
              break;
              if (124L < paramAnonymousLong) {
                break label103;
              }
              h.IzE.idkeyStat(1302L, 201L, 1L, false);
              break label103;
              if (129L < paramAnonymousLong) {
                break label111;
              }
              h.IzE.idkeyStat(1302L, 202L, 1L, false);
              break label111;
              if (134L >= paramAnonymousLong) {
                h.IzE.idkeyStat(1302L, 203L, 1L, false);
              }
            }
          }
        }
        label177:
        label227:
        if (160L >= paramAnonymousLong)
        {
          h.IzE.idkeyStat(1302L, 210L, 1L, false);
          if (141L > paramAnonymousLong)
          {
            if (146L <= paramAnonymousLong) {
              break label312;
            }
            if (151L <= paramAnonymousLong) {
              break label337;
            }
          }
          for (;;)
          {
            if (156L <= paramAnonymousLong) {
              break label362;
            }
            AppMethodBeat.o(168171);
            return;
            if (145L < paramAnonymousLong) {
              break;
            }
            h.IzE.idkeyStat(1302L, 211L, 1L, false);
            break;
            if (150L < paramAnonymousLong) {
              break label265;
            }
            h.IzE.idkeyStat(1302L, 212L, 1L, false);
            break label265;
            if (155L >= paramAnonymousLong) {
              h.IzE.idkeyStat(1302L, 213L, 1L, false);
            }
          }
          label362:
          if (160L >= paramAnonymousLong) {
            h.IzE.idkeyStat(1302L, 214L, 1L, false);
          }
        }
        label265:
        label312:
        label337:
        AppMethodBeat.o(168171);
        label384:
      }
      
      public final void KP(String paramAnonymousString) {}
    });
    this.zKf = g.ar((kotlin.g.a.a)c.APf);
    this.ALj = true;
    this.ALl = true;
    this.kKI = com.tencent.mm.model.d.bcs();
    paramContext = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.AOY = com.tencent.mm.plugin.finder.storage.d.dSX();
    this.AOZ = -1;
    this.APb = 3;
    AppMethodBeat.o(168205);
  }
  
  private final void a(String paramString1, String paramString2, blk paramblk, ac paramac, FeedData paramFeedData)
  {
    AppMethodBeat.i(241814);
    this.AOV = paramblk;
    a("", paramString1, paramString2, null, paramac, paramFeedData);
    AppMethodBeat.o(241814);
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, csg paramcsg, ac paramac, FeedData paramFeedData)
  {
    AppMethodBeat.i(241816);
    this.ALh = new t(paramString1, paramString2, paramString3, paramcsg, paramac, paramFeedData);
    paramString3 = this.ALh;
    if (paramString3 != null)
    {
      if ((paramcsg != null) && (paramcsg.TzU == true))
      {
        paramString2 = paramcsg.zBo;
        if (paramString2 == null) {
          break label155;
        }
      }
      label155:
      for (paramString2 = paramString2.TAw;; paramString2 = null)
      {
        this.AOV = paramString2;
        Log.i("Finder.VideoView", "[setVideoMedia] needCrop, " + this.AOV);
        egz();
        super.c(false, paramString1, 0);
        this.mfv = paramString3.path;
        this.mfu = paramString3.mediaId;
        Log.i("Finder.VideoView", "[setVideoMedia] " + getDefaultLog());
        AppMethodBeat.o(241816);
        return;
      }
    }
    AppMethodBeat.o(241816);
  }
  
  private final boolean c(t paramt)
  {
    AppMethodBeat.i(241804);
    if (paramt == null)
    {
      Log.w("Finder.VideoView", "[checkCompleted] mediaInfo is null");
      AppMethodBeat.o(241804);
      return false;
    }
    if (paramt.APg == null)
    {
      Log.w("Finder.VideoView", "[checkCompleted] localFinderMedia is null");
      AppMethodBeat.o(241804);
      return true;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
    av localav = com.tencent.mm.plugin.finder.storage.logic.d.bC(paramt.mediaId, true);
    int j = localav.aDv(paramt.path);
    Log.i("Finder.VideoView", "[checkCompleted] isDownloadFinishAndCheckFile=" + j + " cache=" + localav + " path=" + paramt.path + ' ' + getDefaultLog());
    localObject = c.zKl;
    qu localqu;
    if (c.dMG())
    {
      localqu = new qu();
      qu.a locala = localqu.fPA;
      paramt = paramt.APg;
      if (paramt != null)
      {
        localObject = paramt.mediaId;
        paramt = (t)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramt = "";
      }
      locala.mediaId = paramt;
      localqu.fPA.fPD = localav.field_fileFormat;
      localqu.fPA.fPC = localav.field_hasPlayed;
      paramt = localqu.fPA;
      if (j != 0) {
        break label279;
      }
    }
    label279:
    for (int i = (int)(100.0F * (float)localav.field_cacheSize / (float)localav.field_totalSize);; i = 0)
    {
      paramt.fPB = i;
      EventCenter.instance.publish((IEvent)localqu);
      if (j != 0) {
        break;
      }
      AppMethodBeat.o(241804);
      return true;
    }
    AppMethodBeat.o(241804);
    return false;
  }
  
  private final String getDefaultLog()
  {
    AppMethodBeat.i(168195);
    StringBuilder localStringBuilder = new StringBuilder("videoView=").append(hashCode()).append("->textureView=").append(this.txH.hashCode()).append(" mediaId=");
    Object localObject = this.ALh;
    if (localObject != null) {}
    for (localObject = ((t)localObject).mediaId;; localObject = null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(168195);
      return localObject;
    }
  }
  
  private final com.tencent.mm.plugin.finder.preload.model.a getPreloadModel()
  {
    AppMethodBeat.i(241782);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)this.zKf.getValue();
    AppMethodBeat.o(241782);
    return locala;
  }
  
  private final void requestAudioFocus()
  {
    AppMethodBeat.i(168202);
    this.kKI.a((d.a)new FinderVideoView.d());
    AppMethodBeat.o(168202);
  }
  
  public final void AS(int paramInt)
  {
    AppMethodBeat.i(168190);
    super.AS(paramInt);
    z localz;
    if (this.AOZ != paramInt)
    {
      localz = this.ALf;
      if (localz != null)
      {
        localObject = this.ALh;
        if (localObject == null) {
          break label66;
        }
      }
    }
    label66:
    for (Object localObject = ((t)localObject).APg;; localObject = null)
    {
      localz.a((csg)localObject, paramInt, this.APa);
      this.AOZ = paramInt;
      AppMethodBeat.o(168190);
      return;
    }
  }
  
  public final void B(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(168200);
    Log.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s isPreparedMoovReadyResult:%s", new Object[] { bqf(), Long.valueOf(paramLong), Integer.valueOf(this.mfz), this.mfu, Boolean.valueOf(paramBoolean) });
    if (this.mfz != 0)
    {
      Log.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(168200);
      return;
    }
    hja();
    try
    {
      if (this.mfy == null)
      {
        Log.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bqf() });
        AppMethodBeat.o(168200);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "%s deal moov ready error [%s]", new Object[] { bqf(), this.mfu });
      AppMethodBeat.o(168200);
      return;
    }
    if ((paramBoolean) || (this.mfy.K(this.mfv, paramLong)))
    {
      com.tencent.mm.plugin.a.f localf = this.mfy;
      p.j(localf, "parser");
      this.mfz = localf.bvI();
      Log.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { bqf(), Integer.valueOf(this.mfz), this.mfu });
      if (xa(0)) {
        bqm();
      }
      if (this.mfA != -1) {
        break label333;
      }
    }
    label333:
    for (int i = 1;; i = 2)
    {
      this.mfx = i;
      AppMethodBeat.o(168200);
      return;
      Log.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { bqf(), this.mfu });
      this.mft.requestVideoData(this.mfu, 0, -1);
      AppMethodBeat.o(168200);
      return;
    }
  }
  
  public final boolean I(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168189);
    Log.i("Finder.VideoView", "[seekTo] time=" + paramInt + " afterSeekPlay=" + paramBoolean + ' ' + getDefaultLog());
    requestAudioFocus();
    paramBoolean = super.I(paramInt, paramBoolean);
    AppMethodBeat.o(168189);
    return paramBoolean;
  }
  
  public final boolean Nq(long paramLong)
  {
    AppMethodBeat.i(241831);
    if (this.mfy == null)
    {
      Log.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bqf() });
      AppMethodBeat.o(241831);
      return false;
    }
    boolean bool = this.mfy.K(this.mfv, paramLong);
    AppMethodBeat.o(241831);
    return bool;
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(241848);
    paramBoolean = super.a(paramDouble, paramBoolean);
    AppMethodBeat.o(241848);
    return paramBoolean;
  }
  
  public boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    int i = 0;
    AppMethodBeat.i(168199);
    p.k(paramPInt1, "start");
    p.k(paramPInt2, "end");
    paramPInt1.value = Math.max(paramInt, this.mfD);
    if (this.mfx == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt2.value = (paramPInt1.value + this.APb + 1);
    }
    this.APb += this.mfI.mfN;
    if (this.mfx == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.mfE + 8);
    }
    int j;
    if ((this.mfx == 3) || (this.mfx == 4))
    {
      paramPInt1.value = this.mfD;
      paramPInt2.value = (this.mfE + paramInt + 1 + this.mfI.mfO);
      j = Math.min(kotlin.h.a.dm(getPreloadModel().zKE / 100.0F * this.mfz), getPreloadModel().zKK);
      if (j > 0) {
        break label435;
      }
      i = j;
      if (paramPInt2.value < this.mfz / 2.0F)
      {
        paramPInt2.value = ((int)(this.mfz / 2.0F + 1.0F));
        i = j;
      }
    }
    for (;;)
    {
      if (paramPInt2.value >= this.mfz + 1) {
        paramPInt2.value = (this.mfz + 1);
      }
      if (paramPInt2.value >= paramPInt1.value) {
        break;
      }
      paramPInt1.value += this.mfI.mfO;
      Log.i("Finder.VideoView", bqf() + " [start:end]=[" + paramPInt1.value + ':' + paramPInt2.value + "],playStatus=" + this.mfx + ",playTime=" + paramInt + ",cachePlayTime=" + this.mfD + ",cacheTimeStep=" + this.mfE + ",timeDuration=" + this.mfz + ",targetSecond=" + i + ",cdnMediaId=" + this.mfu);
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
    Log.i("Finder.VideoView", bqf() + " [start:end]=[" + paramPInt1.value + ':' + paramPInt2.value + "],playStatus=" + this.mfx + ",playTime=" + paramInt + ",cachePlayTime=" + this.mfD + ",cacheTimeStep=" + this.mfE + ",timeDuration=" + this.mfz + ",targetSecond=" + i + ",cdnMediaId=" + this.mfu);
    AppMethodBeat.o(168199);
    return true;
  }
  
  public final void b(ac paramac, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(241811);
    p.k(paramac, "video");
    p.k(paramFeedData, "feedData");
    if (paramBoolean)
    {
      Object localObject2 = paramac.dJw().url;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str = paramac.aBv();
      localObject2 = paramac.dJw().zBo;
      if (localObject2 != null) {}
      for (localObject2 = ((css)localObject2).TAw;; localObject2 = null)
      {
        a((String)localObject1, str, (blk)localObject2, paramac, paramFeedData);
        AppMethodBeat.o(241811);
        return;
      }
    }
    a(paramac.getUrl(), paramac.getPath(), paramac.aBv(), paramac.dJw(), paramac, paramFeedData);
    AppMethodBeat.o(241811);
  }
  
  public final void bXh()
  {
    AppMethodBeat.i(168203);
    super.bXh();
    z localz = this.ALf;
    if (localz != null)
    {
      localz.Ma(0L);
      AppMethodBeat.o(168203);
      return;
    }
    AppMethodBeat.o(168203);
  }
  
  public final String bqf()
  {
    AppMethodBeat.i(241852);
    String str = "mediaId:" + getMediaId() + hashCode();
    AppMethodBeat.o(241852);
    return str;
  }
  
  public final void bqi() {}
  
  public final com.tencent.mm.plugin.a.f bqk()
  {
    AppMethodBeat.i(241850);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (com.tencent.mm.plugin.finder.storage.d.dTx() == 1)
    {
      localObject = (com.tencent.mm.plugin.a.f)new j();
      AppMethodBeat.o(241850);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (com.tencent.mm.plugin.finder.storage.d.dTx() == 2)
    {
      localObject = (com.tencent.mm.plugin.a.f)new com.tencent.mm.plugin.a.k();
      AppMethodBeat.o(241850);
      return localObject;
    }
    localObject = (com.tencent.mm.plugin.a.f)new com.tencent.mm.plugin.finder.video.parser.a();
    AppMethodBeat.o(241850);
    return localObject;
  }
  
  public final boolean bqo()
  {
    AppMethodBeat.i(168185);
    Object localObject;
    if (!this.ALj)
    {
      StringBuilder localStringBuilder = new StringBuilder("[play] unFocused. ").append(getDefaultLog()).append(" mediaId=");
      localObject = this.ALh;
      if (localObject != null) {}
      for (localObject = ((t)localObject).mediaId;; localObject = null)
      {
        Log.i("Finder.VideoView", (String)localObject);
        AppMethodBeat.o(168185);
        return false;
      }
    }
    if (this.AOX == 1)
    {
      this.mfw = 1;
      this.AOX = 0;
      localObject = this.mft;
      if (localObject != null) {
        ((com.tencent.mm.modelvideo.f)localObject).s(getVideoMediaId(), this.mfv, this.url);
      }
      localObject = this.txH;
      p.j(localObject, "videoView");
      int i = ((com.tencent.mm.pluginsdk.ui.tools.k)localObject).getCurrentPosition() / 1000;
      xa(i);
      Log.i("Finder.VideoView", "continue to download... mediaId=" + getVideoMediaId() + " playSec=" + i);
    }
    if ((this.ALj) && (super.bqo()))
    {
      requestAudioFocus();
      localObject = this.AOW;
      if (localObject != null) {
        ((SynchronizedVideoPlayTextureView)localObject).setOneTimeVideoTextureUpdateCallback((k.e)this);
      }
      localObject = this.ALf;
      if (localObject != null) {
        ((z)localObject).dJV();
      }
      AppMethodBeat.o(168185);
      return true;
    }
    AppMethodBeat.o(168185);
    return false;
  }
  
  public final com.tencent.mm.pluginsdk.ui.tools.k df(final Context paramContext)
  {
    AppMethodBeat.i(168180);
    this.pDV = 1;
    paramContext = new b(this, paramContext, paramContext);
    paramContext.setIsOnlineVideoType(true);
    paramContext.setNeedResetExtractor(true);
    this.AOW = ((SynchronizedVideoPlayTextureView)paramContext);
    paramContext = this.AOW;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext = (com.tencent.mm.pluginsdk.ui.tools.k)paramContext;
    AppMethodBeat.o(168180);
    return paramContext;
  }
  
  public final boolean egV()
  {
    AppMethodBeat.i(241800);
    boolean bool = this.ALl;
    start();
    AppMethodBeat.o(241800);
    return bool;
  }
  
  public final int egW()
  {
    AppMethodBeat.i(241794);
    Log.i("Finder.VideoView", "[pauseWithCancel] " + getDefaultLog() + " downloadStatus=" + this.mfw + ", isPrepared=" + this.gX);
    this.AOX = this.mfw;
    com.tencent.mm.modelvideo.f localf = this.mft;
    if (localf != null) {
      localf.hR(getVideoMediaId());
    }
    pause();
    AppMethodBeat.o(241794);
    return 0;
  }
  
  public int egy()
  {
    return b.g.fake_finder_video_view;
  }
  
  public void egz() {}
  
  public final boolean ehA()
  {
    return this.ALk;
  }
  
  public final boolean ehB()
  {
    return this.ALl;
  }
  
  public final boolean ehz()
  {
    return this.ALj;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(241786);
    Object localObject = this.AOW;
    if (localObject != null)
    {
      localObject = ((SynchronizedVideoPlayTextureView)localObject).getBitmap();
      AppMethodBeat.o(241786);
      return localObject;
    }
    AppMethodBeat.o(241786);
    return null;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(241834);
    int i = super.getCurrPosSec();
    AppMethodBeat.o(241834);
    return i;
  }
  
  public final z getLifecycle()
  {
    return this.ALf;
  }
  
  public String getMediaId()
  {
    Object localObject = this.ALh;
    if (localObject != null)
    {
      String str = ((t)localObject).mediaId;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final t getMediaInfo()
  {
    return this.ALh;
  }
  
  public final u getMuteListener()
  {
    return this.ANk;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(241836);
    int i = super.getVideoDurationSec();
    AppMethodBeat.o(241836);
    return i;
  }
  
  public final blk getVideoMatrix()
  {
    return this.AOV;
  }
  
  public final String getVideoMediaId()
  {
    t localt = this.ALh;
    if (localt != null) {
      return localt.mediaId;
    }
    return null;
  }
  
  public final boolean get_isPreviewing()
  {
    return this.ANj;
  }
  
  public final void h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(168196);
    if (!Util.isEqual(this.mfu, paramString))
    {
      AppMethodBeat.o(168196);
      return;
    }
    Log.i("Finder.VideoView", "%s download  onPlayProgress [%d, %d] pauseByLoadData=%s playStatus=%s", new Object[] { bqf(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(this.mfC), Integer.valueOf(this.mfx) });
    if ((this.mfC) && (this.mfx == 3)) {
      xa(getCurrPosSec());
    }
    AppMethodBeat.o(168196);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(241842);
    boolean bool = super.isPlaying();
    AppMethodBeat.o(241842);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(241807);
    Object localObject = this.ALh;
    if (localObject != null)
    {
      z localz = this.ALf;
      if (localz != null) {
        localz.a(((t)localObject).APg, getVideoDurationSec(), getVideoDurationSec());
      }
      if (this.mfK)
      {
        localObject = this.ALf;
        if (localObject != null) {
          ((z)localObject).dJU();
        }
      }
    }
    super.onCompletion();
    AppMethodBeat.o(241807);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(178468);
    super.onUIDestroy();
    this.ALj = false;
    this.ALh = null;
    this.AOV = null;
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
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(241845);
    boolean bool = super.p(paramDouble);
    AppMethodBeat.o(241845);
    return bool;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(168183);
    this.kKI.avz();
    Log.i("Finder.VideoView", "[pause] " + getDefaultLog() + "  " + "");
    z localz = this.ALf;
    if (localz != null) {
      localz.a(null);
    }
    boolean bool = super.pause();
    AppMethodBeat.o(168183);
    return bool;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(168198);
    super.reset();
    this.APb = 3;
    AppMethodBeat.o(168198);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(241838);
    p.k(paramb, "_callback");
    super.setIMMVideoViewCallback(paramb);
    AppMethodBeat.o(241838);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    AppMethodBeat.i(168181);
    SynchronizedVideoPlayTextureView localSynchronizedVideoPlayTextureView = this.AOW;
    if (localSynchronizedVideoPlayTextureView != null)
    {
      localSynchronizedVideoPlayTextureView.setInterceptDetach(paramBoolean);
      AppMethodBeat.o(168181);
      return;
    }
    AppMethodBeat.o(168181);
  }
  
  public final void setLifecycle(z paramz)
  {
    this.ALf = paramz;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(241840);
    super.setLoop(paramBoolean);
    AppMethodBeat.o(241840);
  }
  
  public final void setMediaInfo(t paramt)
  {
    this.ALh = paramt;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(168194);
    super.setMute(paramBoolean);
    AppMethodBeat.o(168194);
  }
  
  public final void setMuteListener(u paramu)
  {
    this.ANk = paramu;
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.ALl = paramBoolean;
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.ALk = paramBoolean;
  }
  
  public final void setVideoCore(l paraml)
  {
    this.xkW = paraml;
  }
  
  public final void setVideoMatrix(blk paramblk)
  {
    this.AOV = paramblk;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(168191);
    super.setVideoTotalTime(paramInt);
    this.APa = paramInt;
    AppMethodBeat.o(168191);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.ALj = paramBoolean;
  }
  
  public final void set_isPreviewing(boolean paramBoolean)
  {
    this.ANj = paramBoolean;
  }
  
  public final void start()
  {
    AppMethodBeat.i(168188);
    if (!this.ALj)
    {
      Log.w("Finder.VideoView", "isViewFocused=" + this.ALj);
      AppMethodBeat.o(168188);
      return;
    }
    if (this.ALh == null)
    {
      Log.w("Finder.VideoView", "mediaInfo is null!");
      AppMethodBeat.o(168188);
      return;
    }
    if (this.txH == null)
    {
      Log.w("Finder.VideoView", "videoView is null!");
      AppMethodBeat.o(168188);
      return;
    }
    if (this.mfx == 3) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(168188);
      return;
    }
    Log.i("Finder.VideoView", "[start#1] isNeverStart=" + this.ALl + " isViewFocused=" + this.ALj + " isPlaying=false " + getDefaultLog());
    if (!this.ALl)
    {
      bqo();
      AppMethodBeat.o(168188);
      return;
    }
    Object localObject1 = this.ALf;
    if (localObject1 != null) {
      ((z)localObject1).a(this.ALh, 0);
    }
    if (c(this.ALh))
    {
      localObject1 = this.txH;
      p.j(localObject1, "videoView");
      localObject1 = ((com.tencent.mm.pluginsdk.ui.tools.k)localObject1).getVideoPath();
      Object localObject2 = this.ALh;
      if (localObject2 == null) {
        p.iCn();
      }
      if ((p.h(localObject1, ((t)localObject2).path) ^ true))
      {
        localObject1 = this.txH;
        p.j(localObject1, "videoView");
        localObject2 = this.ALh;
        if (localObject2 == null) {
          p.iCn();
        }
        ((com.tencent.mm.pluginsdk.ui.tools.k)localObject1).setVideoPath(((t)localObject2).path);
      }
      this.mft = null;
      this.mfw = 3;
      this.AOX = 0;
      localObject1 = this.AOW;
      if (localObject1 != null) {
        ((SynchronizedVideoPlayTextureView)localObject1).setIsOnlineVideoType(false);
      }
      boolean bool = bqo();
      if (!bool)
      {
        localObject1 = this.txH;
        p.j(localObject1, "videoView");
        localObject1 = (CharSequence)((com.tencent.mm.pluginsdk.ui.tools.k)localObject1).getVideoPath();
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label536;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = new StringBuilder("[start] ERROR! videoPath=");
          localObject2 = this.txH;
          p.j(localObject2, "videoView");
          localObject1 = ((StringBuilder)localObject1).append(((com.tencent.mm.pluginsdk.ui.tools.k)localObject2).getVideoPath()).append(" completedPath=");
          localObject2 = this.ALh;
          if (localObject2 == null) {
            p.iCn();
          }
          Log.e("Finder.VideoView", ((t)localObject2).path);
        }
      }
      localObject1 = new StringBuilder("[start] ret=").append(bool).append(" has download! local path:");
      localObject2 = this.txH;
      p.j(localObject2, "videoView");
      Log.i("Finder.VideoView", ((com.tencent.mm.pluginsdk.ui.tools.k)localObject2).getVideoPath());
    }
    for (;;)
    {
      EW(1L + getReportIdkey());
      this.ALl = false;
      AppMethodBeat.o(168188);
      return;
      label536:
      i = 0;
      break;
      localObject1 = this.AOW;
      if (localObject1 != null) {
        ((SynchronizedVideoPlayTextureView)localObject1).setIsOnlineVideoType(true);
      }
      if ((this.mft != null) && (this.mfw != 1))
      {
        Log.i("Finder.VideoView", "[start] need to download..." + getDefaultLog());
        showLoading();
        setDownloadStatus(1);
        this.mft.a((f.a)this);
        this.mft.s(this.mfu, this.mfv, this.url);
        fUH();
      }
      else
      {
        showLoading();
        if (this.mft == null) {
          Log.e("Finder.VideoView", "why proxy is null! " + getDefaultLog());
        }
        Log.i("Finder.VideoView", "[start] wait for download..." + getDefaultLog());
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(168182);
    super.stop();
    z localz = this.ALf;
    if (localz != null) {
      z.a.a(localz, this.ALh);
    }
    this.ALl = true;
    this.ALh = null;
    this.AOV = null;
    this.ALj = false;
    this.AOX = 0;
    Log.i("Finder.VideoView", "[stop] " + getDefaultLog() + "  " + "");
    AppMethodBeat.o(168182);
  }
  
  public final boolean xb(int paramInt)
  {
    AppMethodBeat.i(168197);
    if (this.mfw == 3)
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
      if ((paramInt != 0) || (this.mfy == null)) {
        break label571;
      }
      localPInt2.value = 0;
      localPInt1.value = localPInt2.value;
      bool = this.mfy.b(paramInt + 1, localPInt1, localPInt2);
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
      if ((this.mft != null) && (this.mfy != null) && (this.mfy.a(paramInt, i, (PInt)localObject1, (PInt)localObject2)))
      {
        bool = this.mft.isVideoDataAvailable(this.mfu, ((PInt)localObject1).value, ((PInt)localObject2).value);
        if (bool) {}
        for (;;)
        {
          try
          {
            this.mfD = Math.max(i, this.mfD);
            localObject1 = this.xkW;
            if (localObject1 != null)
            {
              localObject1 = ((l)localObject1).ANC;
              if (localObject1 != null)
              {
                localObject2 = getMediaId();
                i = this.mfD;
                int j = this.mfz;
                p.k(localObject2, "mediaId");
                if (((c)localObject1).dMF())
                {
                  Object localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
                  localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.bC((String)localObject2, false);
                  if (((((c)localObject1).getPreloadModel().zKK <= i) || (((c)localObject1).getPreloadModel().zKJ <= ((av)localObject3).dKP())) && (((c)localObject1).zKi))
                  {
                    ((c)localObject1).aDD("startPreloadSecs=" + ((c)localObject1).getPreloadModel().zKK + ", startPreloadPercent=" + ((c)localObject1).getPreloadModel().zKJ + ' ' + "cachePercent=" + ((av)localObject3).dKP() + " cacheTime=" + i + ", timeDuration=" + j + ", [onOnlineCachePlaying#" + (String)localObject2 + ']');
                    ((c)localObject1).zKi = false;
                  }
                }
              }
            }
            Log.i("Finder.VideoView", "ret=%s %s checkCanPlay range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { Boolean.valueOf(bool), bqf(), Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.mfx), Integer.valueOf(this.mfD), Integer.valueOf(this.mfE), this.mfu });
            AppMethodBeat.o(168197);
            return bool;
          }
          catch (Exception localException1) {}
          this.mfD = paramInt;
          continue;
          Log.e(this.TAG, "%s check video data error %s ", new Object[] { bqf(), localException1.toString() });
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVideoView$Companion;", "", "()V", "FINDER_VIDEO_VIEW_IDKEY_STAT", "", "_TAG", "", "isDebug", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderVideoView$createVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "getBusinessType", "", "setVideoPath", "", "fullFile", "", "stop", "plugin-finder_release"})
  public static final class b
    extends SynchronizedVideoPlayTextureView
  {
    b(Context paramContext1, Context paramContext2)
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
      Log.i("Finder.VideoView", "[setVideoPath] " + FinderVideoView.a(this.APd));
      super.setVideoPath(paramString);
      AppMethodBeat.o(168175);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(168174);
      Log.i("Finder.VideoView", "[stop] " + FinderVideoView.a(this.APd));
      super.stop();
      AppMethodBeat.o(168174);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.model.a>
  {
    public static final c APf;
    
    static
    {
      AppMethodBeat.i(221602);
      APf = new c();
      AppMethodBeat.o(221602);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoView
 * JD-Core Version:    0.7.0.1
 */