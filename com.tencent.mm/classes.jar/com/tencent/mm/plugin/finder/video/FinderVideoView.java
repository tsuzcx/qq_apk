package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "firstCacheTimeStep", "", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isViewFocused", "setViewFocused", "lastDownloadStatus", "lastSeconds", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "limitSeconds", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "preloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "preloadModel$delegate", "Lkotlin/Lazy;", "textureView", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "totalSeconds", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "videoMatrix", "Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "getVideoMatrix", "()Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "setVideoMatrix", "(Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;)V", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkCompleted", "createMp4Parser", "Lcom/tencent/mm/plugin/Atom/IMp4Parser;", "createVideoFilePath", "", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrPosSec", "getDefaultLog", "", "getMediaId", "getVideoDurationSec", "getVideoMediaId", "isPlaying", "layoutId", "logTips", "onCompletion", "onM3U8Ready", "mediaId", "m3u8", "onMediaInfoAndMatrixPrepared", "onMoovReady", "moovPos", "", "length", "isPreparedMoovReadyResult", "onPrepareMoovReady", "onProgress", "offset", "total", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "pauseWithCancel", "play", "requestAudioFocus", "reset", "seekTo", "seconds", "", "afterPlay", "time", "afterSeekPlay", "setIMMVideoViewCallback", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setInterceptDetach", "isInterceptDetach", "setLocalVideoMedia", "path", "matrix", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setLoop", "loop", "setMute", "mute", "setVideoCore", "setVideoMedia", "isLocal", "downloadUrl", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setVideoTotalTime", "startOrPlay", "stop", "updateTime", "Companion", "plugin-finder_release"})
public class FinderVideoView
  extends MMVideoView
{
  public static final a wgh;
  private final com.tencent.mm.model.d hWh;
  private k tCD;
  private final kotlin.f uTP;
  boolean wcA;
  boolean wcB;
  volatile boolean wcC;
  private y wcw;
  private s wcy;
  private boolean weo;
  private t wep;
  private bej wga;
  private SynchronizedVideoPlayTextureView wgb;
  private int wgc;
  private final int wgd;
  private int wge;
  private int wgf;
  private int wgg;
  
  static
  {
    AppMethodBeat.i(168206);
    wgh = new a((byte)0);
    AppMethodBeat.o(168206);
  }
  
  public FinderVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168204);
    setReporter((i.c)new i.c()
    {
      public final void DX(String paramAnonymousString) {}
      
      public final void yU(long paramAnonymousLong)
      {
        AppMethodBeat.i(168171);
        Object localObject = this.wgi.getMediaInfo();
        if (localObject != null)
        {
          localObject = ((s)localObject).wgl;
          if (localObject == null) {
            break label384;
          }
          if (paramAnonymousLong < 200L) {
            h.CyF.idkeyStat(1302L, paramAnonymousLong, 1L, false);
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
            h.CyF.idkeyStat(1302L, 200L, 1L, false);
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
              h.CyF.idkeyStat(1302L, 204L, 1L, false);
              break;
              if (124L < paramAnonymousLong) {
                break label103;
              }
              h.CyF.idkeyStat(1302L, 201L, 1L, false);
              break label103;
              if (129L < paramAnonymousLong) {
                break label111;
              }
              h.CyF.idkeyStat(1302L, 202L, 1L, false);
              break label111;
              if (134L >= paramAnonymousLong) {
                h.CyF.idkeyStat(1302L, 203L, 1L, false);
              }
            }
          }
        }
        label177:
        label227:
        if (160L >= paramAnonymousLong)
        {
          h.CyF.idkeyStat(1302L, 210L, 1L, false);
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
            h.CyF.idkeyStat(1302L, 211L, 1L, false);
            break;
            if (150L < paramAnonymousLong) {
              break label265;
            }
            h.CyF.idkeyStat(1302L, 212L, 1L, false);
            break label265;
            if (155L >= paramAnonymousLong) {
              h.CyF.idkeyStat(1302L, 213L, 1L, false);
            }
          }
          label362:
          if (160L >= paramAnonymousLong) {
            h.CyF.idkeyStat(1302L, 214L, 1L, false);
          }
        }
        label265:
        label312:
        label337:
        AppMethodBeat.o(168171);
        label384:
      }
    });
    this.uTP = g.ah((kotlin.g.a.a)c.wgk);
    this.wcA = true;
    this.wcC = true;
    this.hWh = com.tencent.mm.model.d.aTu();
    paramContext = c.vCb;
    this.wgd = c.drG();
    this.wge = -1;
    this.wgg = 3;
    AppMethodBeat.o(168204);
  }
  
  public FinderVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168205);
    setReporter((i.c)new i.c()
    {
      public final void DX(String paramAnonymousString) {}
      
      public final void yU(long paramAnonymousLong)
      {
        AppMethodBeat.i(168171);
        Object localObject = this.wgi.getMediaInfo();
        if (localObject != null)
        {
          localObject = ((s)localObject).wgl;
          if (localObject == null) {
            break label384;
          }
          if (paramAnonymousLong < 200L) {
            h.CyF.idkeyStat(1302L, paramAnonymousLong, 1L, false);
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
            h.CyF.idkeyStat(1302L, 200L, 1L, false);
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
              h.CyF.idkeyStat(1302L, 204L, 1L, false);
              break;
              if (124L < paramAnonymousLong) {
                break label103;
              }
              h.CyF.idkeyStat(1302L, 201L, 1L, false);
              break label103;
              if (129L < paramAnonymousLong) {
                break label111;
              }
              h.CyF.idkeyStat(1302L, 202L, 1L, false);
              break label111;
              if (134L >= paramAnonymousLong) {
                h.CyF.idkeyStat(1302L, 203L, 1L, false);
              }
            }
          }
        }
        label177:
        label227:
        if (160L >= paramAnonymousLong)
        {
          h.CyF.idkeyStat(1302L, 210L, 1L, false);
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
            h.CyF.idkeyStat(1302L, 211L, 1L, false);
            break;
            if (150L < paramAnonymousLong) {
              break label265;
            }
            h.CyF.idkeyStat(1302L, 212L, 1L, false);
            break label265;
            if (155L >= paramAnonymousLong) {
              h.CyF.idkeyStat(1302L, 213L, 1L, false);
            }
          }
          label362:
          if (160L >= paramAnonymousLong) {
            h.CyF.idkeyStat(1302L, 214L, 1L, false);
          }
        }
        label265:
        label312:
        label337:
        AppMethodBeat.o(168171);
        label384:
      }
    });
    this.uTP = g.ah((kotlin.g.a.a)c.wgk);
    this.wcA = true;
    this.wcC = true;
    this.hWh = com.tencent.mm.model.d.aTu();
    paramContext = c.vCb;
    this.wgd = c.drG();
    this.wge = -1;
    this.wgg = 3;
    AppMethodBeat.o(168205);
  }
  
  private final void a(String paramString1, String paramString2, bej parambej, com.tencent.mm.plugin.finder.loader.s params, FeedData paramFeedData)
  {
    AppMethodBeat.i(254391);
    this.wga = parambej;
    a("", paramString1, paramString2, null, params, paramFeedData);
    AppMethodBeat.o(254391);
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, cjl paramcjl, com.tencent.mm.plugin.finder.loader.s params, FeedData paramFeedData)
  {
    AppMethodBeat.i(254392);
    this.wcy = new s(paramString1, paramString2, paramString3, paramcjl, params, paramFeedData);
    paramString3 = this.wcy;
    if (paramString3 != null)
    {
      if ((paramcjl != null) && (paramcjl.MoO == true))
      {
        paramString2 = paramcjl.uOR;
        if (paramString2 == null) {
          break label155;
        }
      }
      label155:
      for (paramString2 = paramString2.Mpr;; paramString2 = null)
      {
        this.wga = paramString2;
        Log.i("Finder.VideoView", "[setVideoMedia] needCrop, " + this.wga);
        dEQ();
        super.c(false, paramString1, 0);
        this.jpU = paramString3.path;
        this.jpT = paramString3.mediaId;
        Log.i("Finder.VideoView", "[setVideoMedia] " + getDefaultLog());
        AppMethodBeat.o(254392);
        return;
      }
    }
    AppMethodBeat.o(254392);
  }
  
  private final boolean c(s params)
  {
    AppMethodBeat.i(254388);
    if (params == null)
    {
      Log.w("Finder.VideoView", "[checkCompleted] mediaInfo is null");
      AppMethodBeat.o(254388);
      return false;
    }
    if (params.wgl == null)
    {
      Log.w("Finder.VideoView", "[checkCompleted] localFinderMedia is null");
      AppMethodBeat.o(254388);
      return true;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.bv(params.mediaId, true);
    int j = ((at)localObject1).aui(params.path);
    Log.i("Finder.VideoView", "[checkCompleted] isDownloadFinishAndCheckFile=" + j + " cache=" + localObject1 + " path=" + params.path + ' ' + getDefaultLog());
    Object localObject2 = MediaPreloadCore.uTV;
    if (MediaPreloadCore.dlF())
    {
      localObject2 = new pw();
      ((pw)localObject2).dVW.mediaId = params.wgl.mediaId;
      ((pw)localObject2).dVW.dVY = ((at)localObject1).field_fileFormat;
      ((pw)localObject2).dVW.dVX = ((at)localObject1).field_hasPlayed;
      params = ((pw)localObject2).dVW;
      if (j != 0) {
        break label254;
      }
    }
    label254:
    for (int i = (int)(100.0F * (float)((at)localObject1).field_cacheSize / (float)((at)localObject1).field_totalSize);; i = 0)
    {
      params.process = i;
      EventCenter.instance.publish((IEvent)localObject2);
      if (j != 0) {
        break;
      }
      AppMethodBeat.o(254388);
      return true;
    }
    AppMethodBeat.o(254388);
    return false;
  }
  
  private final String getDefaultLog()
  {
    AppMethodBeat.i(168195);
    StringBuilder localStringBuilder = new StringBuilder("videoView=").append(hashCode()).append("->textureView=").append(this.qbJ.hashCode()).append(" mediaId=");
    Object localObject = this.wcy;
    if (localObject != null) {}
    for (localObject = ((s)localObject).mediaId;; localObject = null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(168195);
      return localObject;
    }
  }
  
  private final com.tencent.mm.plugin.finder.preload.model.a getPreloadModel()
  {
    AppMethodBeat.i(254384);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)this.uTP.getValue();
    AppMethodBeat.o(254384);
    return locala;
  }
  
  private final void requestAudioFocus()
  {
    AppMethodBeat.i(168202);
    this.hWh.a((d.a)new d());
    AppMethodBeat.o(168202);
  }
  
  public final void B(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(168200);
    Log.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s isPreparedMoovReadyResult:%s", new Object[] { bgQ(), Long.valueOf(paramLong), Integer.valueOf(this.jpY), this.jpT, Boolean.valueOf(paramBoolean) });
    if (this.jpY != 0)
    {
      Log.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(168200);
      return;
    }
    goq();
    try
    {
      if (this.jpX == null)
      {
        Log.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bgQ() });
        AppMethodBeat.o(168200);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "%s deal moov ready error [%s]", new Object[] { bgQ(), this.jpT });
      AppMethodBeat.o(168200);
      return;
    }
    if ((paramBoolean) || (this.jpX.L(this.jpU, paramLong)))
    {
      com.tencent.mm.plugin.a.f localf = this.jpX;
      p.g(localf, "parser");
      this.jpY = localf.blS();
      Log.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { bgQ(), Integer.valueOf(this.jpY), this.jpT });
      if (ub(0)) {
        bgV();
      }
      if (this.jpZ != -1) {
        break label333;
      }
    }
    label333:
    for (int i = 1;; i = 2)
    {
      this.jpW = i;
      AppMethodBeat.o(168200);
      return;
      Log.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { bgQ(), this.jpT });
      this.jpS.requestVideoData(this.jpT, 0, -1);
      AppMethodBeat.o(168200);
      return;
    }
  }
  
  public final boolean G(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168189);
    Log.i("Finder.VideoView", "[seekTo] time=" + paramInt + " afterSeekPlay=" + paramBoolean + ' ' + getDefaultLog());
    requestAudioFocus();
    paramBoolean = super.G(paramInt, paramBoolean);
    AppMethodBeat.o(168189);
    return paramBoolean;
  }
  
  public final boolean Gs(long paramLong)
  {
    AppMethodBeat.i(254393);
    if (this.jpX == null)
    {
      Log.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bgQ() });
      AppMethodBeat.o(254393);
      return false;
    }
    boolean bool = this.jpX.L(this.jpU, paramLong);
    AppMethodBeat.o(254393);
    return bool;
  }
  
  public boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    int i = 0;
    AppMethodBeat.i(168199);
    p.h(paramPInt1, "start");
    p.h(paramPInt2, "end");
    paramPInt1.value = Math.max(paramInt, this.jqc);
    if (this.jpW == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt2.value = (paramPInt1.value + this.wgg + 1);
    }
    this.wgg += this.jqh.jqm;
    if (this.jpW == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.jqd + 8);
    }
    int j;
    if ((this.jpW == 3) || (this.jpW == 4))
    {
      paramPInt1.value = this.jqc;
      paramPInt2.value = (this.jqd + paramInt + 1 + this.jqh.jqn);
      j = Math.min(kotlin.h.a.cR(getPreloadModel().uUo / 100.0F * this.jpY), getPreloadModel().uUu);
      if (j > 0) {
        break label435;
      }
      i = j;
      if (paramPInt2.value < this.jpY / 2.0F)
      {
        paramPInt2.value = ((int)(this.jpY / 2.0F + 1.0F));
        i = j;
      }
    }
    for (;;)
    {
      if (paramPInt2.value >= this.jpY + 1) {
        paramPInt2.value = (this.jpY + 1);
      }
      if (paramPInt2.value >= paramPInt1.value) {
        break;
      }
      paramPInt1.value += this.jqh.jqn;
      Log.i("Finder.VideoView", bgQ() + " [start:end]=[" + paramPInt1.value + ':' + paramPInt2.value + "],playStatus=" + this.jpW + ",playTime=" + paramInt + ",cachePlayTime=" + this.jqc + ",cacheTimeStep=" + this.jqd + ",timeDuration=" + this.jpY + ",targetSecond=" + i + ",cdnMediaId=" + this.jpT);
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
    Log.i("Finder.VideoView", bgQ() + " [start:end]=[" + paramPInt1.value + ':' + paramPInt2.value + "],playStatus=" + this.jpW + ",playTime=" + paramInt + ",cachePlayTime=" + this.jqc + ",cacheTimeStep=" + this.jqd + ",timeDuration=" + this.jpY + ",targetSecond=" + i + ",cdnMediaId=" + this.jpT);
    AppMethodBeat.o(168199);
    return true;
  }
  
  public final void b(com.tencent.mm.plugin.finder.loader.s params, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(254390);
    p.h(params, "video");
    p.h(paramFeedData, "feedData");
    if (paramBoolean)
    {
      Object localObject2 = params.uIw.url;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str = params.auA();
      localObject2 = params.uIw.uOR;
      if (localObject2 != null) {}
      for (localObject2 = ((cjx)localObject2).Mpr;; localObject2 = null)
      {
        a((String)localObject1, str, (bej)localObject2, params, paramFeedData);
        AppMethodBeat.o(254390);
        return;
      }
    }
    a(params.getUrl(), params.getPath(), params.auA(), params.uIw, params, paramFeedData);
    AppMethodBeat.o(254390);
  }
  
  public final void bLh()
  {
    AppMethodBeat.i(168203);
    super.bLh();
    y localy = this.wcw;
    if (localy != null)
    {
      localy.Gr(0L);
      AppMethodBeat.o(168203);
      return;
    }
    AppMethodBeat.o(168203);
  }
  
  public final String bgQ()
  {
    AppMethodBeat.i(254402);
    String str = "mediaId:" + getMediaId() + hashCode();
    AppMethodBeat.o(254402);
    return str;
  }
  
  public final void bgR() {}
  
  public final com.tencent.mm.plugin.a.f bgT()
  {
    AppMethodBeat.i(254401);
    Object localObject = c.vCb;
    if (c.dsi() == 1)
    {
      localObject = (com.tencent.mm.plugin.a.f)new com.tencent.mm.plugin.a.j();
      AppMethodBeat.o(254401);
      return localObject;
    }
    localObject = c.vCb;
    if (c.dsi() == 2)
    {
      localObject = (com.tencent.mm.plugin.a.f)new com.tencent.mm.plugin.a.k();
      AppMethodBeat.o(254401);
      return localObject;
    }
    localObject = (com.tencent.mm.plugin.a.f)new com.tencent.mm.plugin.finder.video.parser.a();
    AppMethodBeat.o(254401);
    return localObject;
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(254400);
    paramBoolean = super.c(paramDouble, paramBoolean);
    AppMethodBeat.o(254400);
    return paramBoolean;
  }
  
  public int dEP()
  {
    return 2131494106;
  }
  
  public void dEQ() {}
  
  public final boolean dFj()
  {
    AppMethodBeat.i(254387);
    boolean bool = this.wcC;
    start();
    AppMethodBeat.o(254387);
    return bool;
  }
  
  public final int dFk()
  {
    AppMethodBeat.i(254386);
    Log.i("Finder.VideoView", "[pauseWithCancel] " + getDefaultLog() + " downloadStatus=" + this.jpV + ", isPrepared=" + this.ZA);
    this.wgc = this.jpV;
    b localb = this.jpS;
    if (localb != null) {
      localb.he(getVideoMediaId());
    }
    pause();
    AppMethodBeat.o(254386);
    return 0;
  }
  
  public final com.tencent.mm.pluginsdk.ui.tools.j di(final Context paramContext)
  {
    AppMethodBeat.i(168180);
    this.mEJ = 1;
    paramContext = new b(this, paramContext, paramContext);
    paramContext.setIsOnlineVideoType(true);
    paramContext.setNeedResetExtractor(true);
    this.wgb = ((SynchronizedVideoPlayTextureView)paramContext);
    paramContext = this.wgb;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext = (com.tencent.mm.pluginsdk.ui.tools.j)paramContext;
    AppMethodBeat.o(168180);
    return paramContext;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(254385);
    Object localObject = this.wgb;
    if (localObject != null)
    {
      localObject = ((SynchronizedVideoPlayTextureView)localObject).getBitmap();
      AppMethodBeat.o(254385);
      return localObject;
    }
    AppMethodBeat.o(254385);
    return null;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(254394);
    int i = super.getCurrPosSec();
    AppMethodBeat.o(254394);
    return i;
  }
  
  public final y getLifecycle()
  {
    return this.wcw;
  }
  
  public String getMediaId()
  {
    Object localObject = this.wcy;
    if (localObject != null)
    {
      String str = ((s)localObject).mediaId;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final s getMediaInfo()
  {
    return this.wcy;
  }
  
  public final t getMuteListener()
  {
    return this.wep;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(254395);
    int i = super.getVideoDurationSec();
    AppMethodBeat.o(254395);
    return i;
  }
  
  public final bej getVideoMatrix()
  {
    return this.wga;
  }
  
  public final String getVideoMediaId()
  {
    s locals = this.wcy;
    if (locals != null) {
      return locals.mediaId;
    }
    return null;
  }
  
  public final boolean get_isPreviewing()
  {
    return this.weo;
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(168196);
    if (!Util.isEqual(this.jpT, paramString))
    {
      AppMethodBeat.o(168196);
      return;
    }
    Log.i("Finder.VideoView", "%s download  onPlayProgress [%d, %d] pauseByLoadData=%s playStatus=%s", new Object[] { bgQ(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(this.jqb), Integer.valueOf(this.jpW) });
    if ((this.jqb) && (this.jpW == 3)) {
      ub(getCurrPosSec());
    }
    AppMethodBeat.o(168196);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(254398);
    boolean bool = super.isPlaying();
    AppMethodBeat.o(254398);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(254389);
    Object localObject = this.wcy;
    if (localObject != null)
    {
      y localy = this.wcw;
      if (localy != null) {
        localy.a(((s)localObject).wgl, getVideoDurationSec(), getVideoDurationSec());
      }
      if (this.jqj)
      {
        localObject = this.wcw;
        if (localObject != null) {
          ((y)localObject).dFM();
        }
      }
    }
    super.onCompletion();
    AppMethodBeat.o(254389);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(178468);
    super.onUIDestroy();
    this.wcA = false;
    this.wcy = null;
    this.wga = null;
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
    AppMethodBeat.i(254399);
    boolean bool = super.p(paramDouble);
    AppMethodBeat.o(254399);
    return bool;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(168183);
    this.hWh.apm();
    Log.i("Finder.VideoView", "[pause] " + getDefaultLog() + "  " + "");
    y localy = this.wcw;
    if (localy != null) {
      localy.dFL();
    }
    boolean bool = super.pause();
    AppMethodBeat.o(168183);
    return bool;
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(168185);
    Object localObject;
    if (!this.wcA)
    {
      StringBuilder localStringBuilder = new StringBuilder("[play] unFocused. ").append(getDefaultLog()).append(" mediaId=");
      localObject = this.wcy;
      if (localObject != null) {}
      for (localObject = ((s)localObject).mediaId;; localObject = null)
      {
        Log.i("Finder.VideoView", (String)localObject);
        AppMethodBeat.o(168185);
        return false;
      }
    }
    if (this.wgc == 1)
    {
      this.jpV = 1;
      this.wgc = 0;
      localObject = this.jpS;
      if (localObject != null) {
        ((b)localObject).p(getVideoMediaId(), this.jpU, this.url);
      }
      localObject = this.qbJ;
      p.g(localObject, "videoView");
      int i = ((com.tencent.mm.pluginsdk.ui.tools.j)localObject).getCurrentPosition() / 1000;
      ub(i);
      Log.i("Finder.VideoView", "continue to download... mediaId=" + getVideoMediaId() + " playSec=" + i);
    }
    if ((this.wcA) && (super.play()))
    {
      requestAudioFocus();
      localObject = this.wgb;
      if (localObject != null) {
        ((SynchronizedVideoPlayTextureView)localObject).setOneTimeVideoTextureUpdateCallback((j.e)this);
      }
      localObject = this.wcw;
      if (localObject != null) {
        ((y)localObject).dFN();
      }
      AppMethodBeat.o(168185);
      return true;
    }
    AppMethodBeat.o(168185);
    return false;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(168198);
    super.reset();
    this.wgg = 3;
    AppMethodBeat.o(168198);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(254396);
    p.h(paramb, "_callback");
    super.setIMMVideoViewCallback(paramb);
    AppMethodBeat.o(254396);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    AppMethodBeat.i(168181);
    SynchronizedVideoPlayTextureView localSynchronizedVideoPlayTextureView = this.wgb;
    if (localSynchronizedVideoPlayTextureView != null)
    {
      localSynchronizedVideoPlayTextureView.setInterceptDetach(paramBoolean);
      AppMethodBeat.o(168181);
      return;
    }
    AppMethodBeat.o(168181);
  }
  
  public final void setLifecycle(y paramy)
  {
    this.wcw = paramy;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(254397);
    super.setLoop(paramBoolean);
    AppMethodBeat.o(254397);
  }
  
  public final void setMediaInfo(s params)
  {
    this.wcy = params;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(168194);
    super.setMute(paramBoolean);
    AppMethodBeat.o(168194);
  }
  
  public final void setMuteListener(t paramt)
  {
    this.wep = paramt;
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.wcC = paramBoolean;
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.wcB = paramBoolean;
  }
  
  public final void setVideoCore(k paramk)
  {
    this.tCD = paramk;
  }
  
  public final void setVideoMatrix(bej parambej)
  {
    this.wga = parambej;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(168191);
    super.setVideoTotalTime(paramInt);
    this.wgf = paramInt;
    AppMethodBeat.o(168191);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.wcA = paramBoolean;
  }
  
  public final void set_isPreviewing(boolean paramBoolean)
  {
    this.weo = paramBoolean;
  }
  
  public final void start()
  {
    AppMethodBeat.i(168188);
    if (!this.wcA)
    {
      Log.w("Finder.VideoView", "isViewFocused=" + this.wcA);
      AppMethodBeat.o(168188);
      return;
    }
    if (this.wcy == null)
    {
      Log.w("Finder.VideoView", "mediaInfo is null!");
      AppMethodBeat.o(168188);
      return;
    }
    if (this.qbJ == null)
    {
      Log.w("Finder.VideoView", "videoView is null!");
      AppMethodBeat.o(168188);
      return;
    }
    if (this.jpW == 3) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(168188);
      return;
    }
    Log.i("Finder.VideoView", "[start#1] isNeverStart=" + this.wcC + " isViewFocused=" + this.wcA + " isPlaying=false " + getDefaultLog());
    if (!this.wcC)
    {
      play();
      AppMethodBeat.o(168188);
      return;
    }
    Object localObject1 = this.wcw;
    if (localObject1 != null) {
      ((y)localObject1).a(this.wcy, 0);
    }
    if (c(this.wcy))
    {
      localObject1 = this.qbJ;
      p.g(localObject1, "videoView");
      localObject1 = ((com.tencent.mm.pluginsdk.ui.tools.j)localObject1).getVideoPath();
      Object localObject2 = this.wcy;
      if (localObject2 == null) {
        p.hyc();
      }
      if ((p.j(localObject1, ((s)localObject2).path) ^ true))
      {
        localObject1 = this.qbJ;
        p.g(localObject1, "videoView");
        localObject2 = this.wcy;
        if (localObject2 == null) {
          p.hyc();
        }
        ((com.tencent.mm.pluginsdk.ui.tools.j)localObject1).setVideoPath(((s)localObject2).path);
      }
      this.jpS = null;
      this.jpV = 3;
      this.wgc = 0;
      localObject1 = this.wgb;
      if (localObject1 != null) {
        ((SynchronizedVideoPlayTextureView)localObject1).setIsOnlineVideoType(false);
      }
      boolean bool = play();
      if (!bool)
      {
        localObject1 = this.qbJ;
        p.g(localObject1, "videoView");
        localObject1 = (CharSequence)((com.tencent.mm.pluginsdk.ui.tools.j)localObject1).getVideoPath();
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label536;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = new StringBuilder("[start] ERROR! videoPath=");
          localObject2 = this.qbJ;
          p.g(localObject2, "videoView");
          localObject1 = ((StringBuilder)localObject1).append(((com.tencent.mm.pluginsdk.ui.tools.j)localObject2).getVideoPath()).append(" completedPath=");
          localObject2 = this.wcy;
          if (localObject2 == null) {
            p.hyc();
          }
          Log.e("Finder.VideoView", ((s)localObject2).path);
        }
      }
      localObject1 = new StringBuilder("[start] ret=").append(bool).append(" has download! local path:");
      localObject2 = this.qbJ;
      p.g(localObject2, "videoView");
      Log.i("Finder.VideoView", ((com.tencent.mm.pluginsdk.ui.tools.j)localObject2).getVideoPath());
    }
    for (;;)
    {
      yU(1L + getReportIdkey());
      this.wcC = false;
      AppMethodBeat.o(168188);
      return;
      label536:
      i = 0;
      break;
      localObject1 = this.wgb;
      if (localObject1 != null) {
        ((SynchronizedVideoPlayTextureView)localObject1).setIsOnlineVideoType(true);
      }
      if ((this.jpS != null) && (this.jpV != 1))
      {
        Log.i("Finder.VideoView", "[start] need to download..." + getDefaultLog());
        showLoading();
        setDownloadStatus(1);
        this.jpS.a((b.a)this);
        this.jpS.p(this.jpT, this.jpU, this.url);
        fgB();
      }
      else
      {
        showLoading();
        if (this.jpS == null) {
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
    y localy = this.wcw;
    if (localy != null) {
      localy.b(this.wcy);
    }
    this.wcC = true;
    this.wcy = null;
    this.wga = null;
    this.wcA = false;
    this.wgc = 0;
    Log.i("Finder.VideoView", "[stop] " + getDefaultLog() + "  " + "");
    AppMethodBeat.o(168182);
  }
  
  public final boolean uc(int paramInt)
  {
    AppMethodBeat.i(168197);
    if (this.jpV == 3)
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
      if ((paramInt != 0) || (this.jpX == null)) {
        break label571;
      }
      localPInt2.value = 0;
      localPInt1.value = localPInt2.value;
      bool = this.jpX.b(paramInt + 1, localPInt1, localPInt2);
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
      if ((this.jpS != null) && (this.jpX != null) && (this.jpX.a(paramInt, i, (PInt)localObject1, (PInt)localObject2)))
      {
        bool = this.jpS.isVideoDataAvailable(this.jpT, ((PInt)localObject1).value, ((PInt)localObject2).value);
        if (bool) {}
        for (;;)
        {
          try
          {
            this.jqc = Math.max(i, this.jqc);
            localObject1 = this.tCD;
            if (localObject1 != null)
            {
              localObject1 = ((k)localObject1).weU;
              if (localObject1 != null)
              {
                localObject2 = getMediaId();
                i = this.jqc;
                int j = this.jpY;
                p.h(localObject2, "mediaId");
                if (((MediaPreloadCore)localObject1).dlE())
                {
                  Object localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                  localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.bv((String)localObject2, false);
                  if (((((MediaPreloadCore)localObject1).getPreloadModel().uUu <= i) || (((MediaPreloadCore)localObject1).getPreloadModel().uUt <= ((at)localObject3).dkP())) && (((MediaPreloadCore)localObject1).uTS))
                  {
                    ((MediaPreloadCore)localObject1).aun("startPreloadSecs=" + ((MediaPreloadCore)localObject1).getPreloadModel().uUu + ", startPreloadPercent=" + ((MediaPreloadCore)localObject1).getPreloadModel().uUt + ' ' + "cachePercent=" + ((at)localObject3).dkP() + " cacheTime=" + i + ", timeDuration=" + j + ", [onOnlineCachePlaying#" + (String)localObject2 + ']');
                    ((MediaPreloadCore)localObject1).uTS = false;
                  }
                }
              }
            }
            Log.i("Finder.VideoView", "ret=%s %s checkCanPlay range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { Boolean.valueOf(bool), bgQ(), Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.jpW), Integer.valueOf(this.jqc), Integer.valueOf(this.jqd), this.jpT });
            AppMethodBeat.o(168197);
            return bool;
          }
          catch (Exception localException1) {}
          this.jqc = paramInt;
          continue;
          Log.e(this.TAG, "%s check video data error %s ", new Object[] { bgQ(), localException1.toString() });
        }
      }
    }
  }
  
  public final void xv(int paramInt)
  {
    AppMethodBeat.i(168190);
    super.xv(paramInt);
    y localy;
    if (this.wge != paramInt)
    {
      localy = this.wcw;
      if (localy != null)
      {
        localObject = this.wcy;
        if (localObject == null) {
          break label66;
        }
      }
    }
    label66:
    for (Object localObject = ((s)localObject).wgl;; localObject = null)
    {
      localy.a((cjl)localObject, paramInt, this.wgf);
      this.wge = paramInt;
      AppMethodBeat.o(168190);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoView$Companion;", "", "()V", "FINDER_VIDEO_VIEW_IDKEY_STAT", "", "_TAG", "", "isDebug", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderVideoView$createVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "getBusinessType", "", "setVideoPath", "", "fullFile", "", "stop", "plugin-finder_release"})
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
      Log.i("Finder.VideoView", "[setVideoPath] " + FinderVideoView.a(this.wgi));
      super.setVideoPath(paramString);
      AppMethodBeat.o(168175);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(168174);
      Log.i("Finder.VideoView", "[stop] " + FinderVideoView.a(this.wgi));
      super.stop();
      AppMethodBeat.o(168174);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.model.a>
  {
    public static final c wgk;
    
    static
    {
      AppMethodBeat.i(254383);
      wgk = new c();
      AppMethodBeat.o(254383);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderVideoView$requestAudioFocus$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"})
  public static final class d
    implements d.a
  {
    public final void aTw()
    {
      AppMethodBeat.i(168176);
      Log.i("Finder.VideoView", "[audioHelperTool] gain");
      AppMethodBeat.o(168176);
    }
    
    public final void aTx()
    {
      AppMethodBeat.i(168178);
      Log.i("Finder.VideoView", "[audioHelperTool] loss");
      AppMethodBeat.o(168178);
    }
    
    public final void aTy()
    {
      AppMethodBeat.i(168177);
      Log.i("Finder.VideoView", "[audioHelperTool] lossTransient");
      AppMethodBeat.o(168177);
    }
    
    public final void aTz()
    {
      AppMethodBeat.i(168179);
      Log.i("Finder.VideoView", "[audioHelperTool] lossTransientCanDuck");
      AppMethodBeat.o(168179);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoView
 * JD-Core Version:    0.7.0.1
 */