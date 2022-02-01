package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.plugin.a.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.atk;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "firstCacheTimeStep", "", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isViewFocused", "setViewFocused", "lastDownloadStatus", "lastSeconds", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "limitSeconds", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "preloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "preloadModel$delegate", "Lkotlin/Lazy;", "textureView", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "totalSeconds", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "videoMatrix", "Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "getVideoMatrix", "()Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "setVideoMatrix", "(Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;)V", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkCompleted", "createMp4Parser", "Lcom/tencent/mm/plugin/Atom/IMp4Parser;", "createVideoFilePath", "", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrPosSec", "getDefaultLog", "", "getMediaId", "getVideoDurationSec", "getVideoMediaId", "isPlaying", "layoutId", "logTips", "onCompletion", "onMediaInfoAndMatrixPrepared", "onMoovReady", "mediaId", "moovPos", "", "length", "isPreparedMoovReadyResult", "onPrepareMoovReady", "onProgress", "offset", "total", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "pauseWithCancel", "play", "requestAudioFocus", "reset", "seekTo", "seconds", "", "afterPlay", "time", "afterSeekPlay", "setIMMVideoViewCallback", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setInterceptDetach", "isInterceptDetach", "setLocalVideoMedia", "path", "matrix", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setLoop", "loop", "setMute", "mute", "setVideoCore", "setVideoMedia", "isLocal", "downloadUrl", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setVideoTotalTime", "startOrPlay", "stop", "updateTime", "Companion", "plugin-finder_release"})
public class FinderVideoView
  extends MMVideoView
{
  public static final FinderVideoView.a tbw;
  private final d hdv;
  private i rWB;
  private boolean sZN;
  volatile boolean sZO;
  private q sZP;
  boolean sZm;
  boolean sZn;
  private p sZs;
  private u sZv;
  private final d.f stF;
  atk tbp;
  private SynchronizedVideoPlayTextureView tbq;
  private int tbr;
  private final int tbs;
  private int tbt;
  private int tbu;
  private int tbv;
  
  static
  {
    AppMethodBeat.i(168206);
    tbw = new FinderVideoView.a((byte)0);
    AppMethodBeat.o(168206);
  }
  
  public FinderVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168204);
    setReporter((i.c)new i.c()
    {
      public final void rd(long paramAnonymousLong)
      {
        AppMethodBeat.i(168171);
        Object localObject = this.tbx.getMediaInfo();
        if (localObject != null)
        {
          localObject = ((p)localObject).tbA;
          if (localObject == null) {
            break label384;
          }
          if (paramAnonymousLong < 200L) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, paramAnonymousLong, 1L, false);
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
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 200L, 1L, false);
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
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 204L, 1L, false);
              break;
              if (124L < paramAnonymousLong) {
                break label103;
              }
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 201L, 1L, false);
              break label103;
              if (129L < paramAnonymousLong) {
                break label111;
              }
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 202L, 1L, false);
              break label111;
              if (134L >= paramAnonymousLong) {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 203L, 1L, false);
              }
            }
          }
        }
        label177:
        label227:
        if (160L >= paramAnonymousLong)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 210L, 1L, false);
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
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 211L, 1L, false);
            break;
            if (150L < paramAnonymousLong) {
              break label265;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 212L, 1L, false);
            break label265;
            if (155L >= paramAnonymousLong) {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 213L, 1L, false);
            }
          }
          label362:
          if (160L >= paramAnonymousLong) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 214L, 1L, false);
          }
        }
        label265:
        label312:
        label337:
        AppMethodBeat.o(168171);
        label384:
      }
      
      public final void vG(String paramAnonymousString) {}
    });
    this.stF = d.g.O((d.g.a.a)c.tbz);
    this.sZm = true;
    this.sZO = true;
    this.hdv = d.aAm();
    paramContext = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.tbs = com.tencent.mm.plugin.finder.storage.b.cHW();
    this.tbt = -1;
    this.tbv = 3;
    AppMethodBeat.o(168204);
  }
  
  public FinderVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168205);
    setReporter((i.c)new i.c()
    {
      public final void rd(long paramAnonymousLong)
      {
        AppMethodBeat.i(168171);
        Object localObject = this.tbx.getMediaInfo();
        if (localObject != null)
        {
          localObject = ((p)localObject).tbA;
          if (localObject == null) {
            break label384;
          }
          if (paramAnonymousLong < 200L) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, paramAnonymousLong, 1L, false);
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
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 200L, 1L, false);
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
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 204L, 1L, false);
              break;
              if (124L < paramAnonymousLong) {
                break label103;
              }
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 201L, 1L, false);
              break label103;
              if (129L < paramAnonymousLong) {
                break label111;
              }
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 202L, 1L, false);
              break label111;
              if (134L >= paramAnonymousLong) {
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 203L, 1L, false);
              }
            }
          }
        }
        label177:
        label227:
        if (160L >= paramAnonymousLong)
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 210L, 1L, false);
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
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 211L, 1L, false);
            break;
            if (150L < paramAnonymousLong) {
              break label265;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 212L, 1L, false);
            break label265;
            if (155L >= paramAnonymousLong) {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 213L, 1L, false);
            }
          }
          label362:
          if (160L >= paramAnonymousLong) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1302L, 214L, 1L, false);
          }
        }
        label265:
        label312:
        label337:
        AppMethodBeat.o(168171);
        label384:
      }
      
      public final void vG(String paramAnonymousString) {}
    });
    this.stF = d.g.O((d.g.a.a)c.tbz);
    this.sZm = true;
    this.sZO = true;
    this.hdv = d.aAm();
    paramContext = com.tencent.mm.plugin.finder.storage.b.sHP;
    this.tbs = com.tencent.mm.plugin.finder.storage.b.cHW();
    this.tbt = -1;
    this.tbv = 3;
    AppMethodBeat.o(168205);
  }
  
  private final boolean c(p paramp)
  {
    AppMethodBeat.i(205493);
    if (paramp == null)
    {
      ae.w("Finder.VideoView", "[checkCompleted] mediaInfo is null");
      AppMethodBeat.o(205493);
      return false;
    }
    if (paramp.tbA == null)
    {
      ae.w("Finder.VideoView", "[checkCompleted] localFinderMedia is null");
      AppMethodBeat.o(205493);
      return true;
    }
    Object localObject1 = c.sLt;
    localObject1 = c.bi(paramp.mediaId, true);
    int j = ((z)localObject1).aiv(paramp.path);
    ae.i("Finder.VideoView", "[checkCompleted] isDownloadFinishAndCheckFile=" + j + " cache=" + localObject1 + " path=" + paramp.path + ' ' + getDefaultLog());
    Object localObject2 = MediaPreloadCore.stL;
    if (MediaPreloadCore.cEO())
    {
      localObject2 = new pe();
      ((pe)localObject2).dEi.mediaId = paramp.tbA.mediaId;
      ((pe)localObject2).dEi.dEk = ((z)localObject1).field_fileFormat;
      ((pe)localObject2).dEi.dEj = ((z)localObject1).field_hasPlayed;
      paramp = ((pe)localObject2).dEi;
      if (j != 0) {
        break label254;
      }
    }
    label254:
    for (int i = (int)(100.0F * (float)((z)localObject1).field_cacheSize / (float)((z)localObject1).field_totalSize);; i = 0)
    {
      paramp.process = i;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
      if (j != 0) {
        break;
      }
      AppMethodBeat.o(205493);
      return true;
    }
    AppMethodBeat.o(205493);
    return false;
  }
  
  private final String getDefaultLog()
  {
    AppMethodBeat.i(168195);
    StringBuilder localStringBuilder = new StringBuilder("videoView=").append(hashCode()).append("->textureView=").append(this.oNV.hashCode()).append(" mediaId=");
    Object localObject = this.sZs;
    if (localObject != null) {}
    for (localObject = ((p)localObject).mediaId;; localObject = null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(168195);
      return localObject;
    }
  }
  
  private final com.tencent.mm.plugin.finder.preload.model.a getPreloadModel()
  {
    AppMethodBeat.i(205489);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)this.stF.getValue();
    AppMethodBeat.o(205489);
    return locala;
  }
  
  private final void requestAudioFocus()
  {
    AppMethodBeat.i(168202);
    this.hdv.a((d.a)new d());
    AppMethodBeat.o(168202);
  }
  
  public final boolean C(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168189);
    ae.i("Finder.VideoView", "[seekTo] time=" + paramInt + " afterSeekPlay=" + paramBoolean + ' ' + getDefaultLog());
    requestAudioFocus();
    paramBoolean = super.C(paramInt, paramBoolean);
    AppMethodBeat.o(168189);
    return paramBoolean;
  }
  
  final void a(String paramString1, String paramString2, String paramString3, bvz parambvz, m paramm, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(205495);
    this.sZs = new p(paramString1, paramString2, paramString3, parambvz, paramm, paramFinderItem);
    paramString3 = this.sZs;
    if (paramString3 != null)
    {
      if ((parambvz != null) && (parambvz.HiV == true))
      {
        paramString2 = parambvz.stz;
        if (paramString2 == null) {
          break label155;
        }
      }
      label155:
      for (paramString2 = paramString2.Hjo;; paramString2 = null)
      {
        this.tbp = paramString2;
        ae.i("Finder.VideoView", "[setVideoMedia] needCrop, " + this.tbp);
        cOD();
        super.c(false, paramString1, 0);
        this.iuH = paramString3.path;
        this.iuG = paramString3.mediaId;
        ae.i("Finder.VideoView", "[setVideoMedia] " + getDefaultLog());
        AppMethodBeat.o(205495);
        return;
      }
    }
    AppMethodBeat.o(205495);
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    int i = 0;
    AppMethodBeat.i(168199);
    d.g.b.p.h(paramPInt1, "start");
    d.g.b.p.h(paramPInt2, "end");
    paramPInt1.value = Math.max(paramInt, this.iuQ);
    if (this.iuK == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt2.value = (paramPInt1.value + this.tbv + 1);
    }
    this.tbv += this.iuV.iva;
    if (this.iuK == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.iuR + 8);
    }
    int j;
    if ((this.iuK == 3) || (this.iuK == 4))
    {
      paramPInt1.value = this.iuQ;
      paramPInt2.value = (this.iuR + paramInt + 1 + this.iuV.ivb);
      j = Math.min(d.h.a.cm(getPreloadModel().sue / 100.0F * this.iuM), getPreloadModel().suk);
      if (j > 0) {
        break label435;
      }
      i = j;
      if (paramPInt2.value < this.iuM / 2.0F)
      {
        paramPInt2.value = ((int)(this.iuM / 2.0F + 1.0F));
        i = j;
      }
    }
    for (;;)
    {
      if (paramPInt2.value >= this.iuM + 1) {
        paramPInt2.value = (this.iuM + 1);
      }
      if (paramPInt2.value >= paramPInt1.value) {
        break;
      }
      paramPInt1.value += this.iuV.ivb;
      ae.i("Finder.VideoView", bpA() + " [start:end]=[" + paramPInt1.value + ':' + paramPInt2.value + "],playStatus=" + this.iuK + ",playTime=" + paramInt + ",cachePlayTime=" + this.iuQ + ",cacheTimeStep=" + this.iuR + ",timeDuration=" + this.iuM + ",targetSecond=" + i + ",cdnMediaId=" + this.iuG);
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
    ae.i("Finder.VideoView", bpA() + " [start:end]=[" + paramPInt1.value + ':' + paramPInt2.value + "],playStatus=" + this.iuK + ",playTime=" + paramInt + ",cachePlayTime=" + this.iuQ + ",cacheTimeStep=" + this.iuR + ",timeDuration=" + this.iuM + ",targetSecond=" + i + ",cdnMediaId=" + this.iuG);
    AppMethodBeat.o(168199);
    return true;
  }
  
  public final void aMP() {}
  
  public final com.tencent.mm.plugin.a.f aMR()
  {
    AppMethodBeat.i(205504);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (com.tencent.mm.plugin.finder.storage.b.cIC() == 1)
    {
      localObject = (com.tencent.mm.plugin.a.f)new j();
      AppMethodBeat.o(205504);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (com.tencent.mm.plugin.finder.storage.b.cIC() == 2)
    {
      localObject = (com.tencent.mm.plugin.a.f)new k();
      AppMethodBeat.o(205504);
      return localObject;
    }
    localObject = (com.tencent.mm.plugin.a.f)new com.tencent.mm.plugin.finder.video.parser.a();
    AppMethodBeat.o(205504);
    return localObject;
  }
  
  public final String bpA()
  {
    AppMethodBeat.i(205505);
    String str = "mediaId:" + getMediaId() + hashCode();
    AppMethodBeat.o(205505);
    return str;
  }
  
  public final void bpD()
  {
    AppMethodBeat.i(168203);
    super.bpD();
    u localu = this.sZv;
    if (localu != null)
    {
      localu.xK(0L);
      AppMethodBeat.o(168203);
      return;
    }
    AppMethodBeat.o(168203);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(205503);
    paramBoolean = super.c(paramDouble, paramBoolean);
    AppMethodBeat.o(205503);
    return paramBoolean;
  }
  
  public final h cN(final Context paramContext)
  {
    AppMethodBeat.i(168180);
    this.lxL = 1;
    paramContext = new b(this, paramContext, paramContext);
    paramContext.setIsOnlineVideoType(true);
    paramContext.setNeedResetExtractor(true);
    this.tbq = ((SynchronizedVideoPlayTextureView)paramContext);
    paramContext = this.tbq;
    if (paramContext == null) {
      d.g.b.p.gkB();
    }
    paramContext = (h)paramContext;
    AppMethodBeat.o(168180);
    return paramContext;
  }
  
  public int cOC()
  {
    return 2131493938;
  }
  
  public void cOD() {}
  
  public final boolean cON()
  {
    AppMethodBeat.i(205492);
    boolean bool = this.sZO;
    start();
    AppMethodBeat.o(205492);
    return bool;
  }
  
  public final int cOO()
  {
    AppMethodBeat.i(205491);
    ae.i("Finder.VideoView", "[pauseWithCancel] " + getDefaultLog() + " downloadStatus=" + this.iuJ + ", isPrepared=" + this.Zn);
    this.tbr = this.iuJ;
    com.tencent.mm.modelvideo.b localb = this.iuF;
    if (localb != null) {
      localb.gp(getVideoMediaId());
    }
    pause();
    AppMethodBeat.o(205491);
    return 0;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(205490);
    Object localObject = this.tbq;
    if (localObject != null)
    {
      localObject = ((SynchronizedVideoPlayTextureView)localObject).getBitmap();
      AppMethodBeat.o(205490);
      return localObject;
    }
    AppMethodBeat.o(205490);
    return null;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(205497);
    int i = super.getCurrPosSec();
    AppMethodBeat.o(205497);
    return i;
  }
  
  public final u getLifecycle()
  {
    return this.sZv;
  }
  
  public String getMediaId()
  {
    Object localObject = this.sZs;
    if (localObject != null)
    {
      String str = ((p)localObject).mediaId;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final p getMediaInfo()
  {
    return this.sZs;
  }
  
  public final q getMuteListener()
  {
    return this.sZP;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(205498);
    int i = super.getVideoDurationSec();
    AppMethodBeat.o(205498);
    return i;
  }
  
  public final atk getVideoMatrix()
  {
    return this.tbp;
  }
  
  public final String getVideoMediaId()
  {
    p localp = this.sZs;
    if (localp != null) {
      return localp.mediaId;
    }
    return null;
  }
  
  public final boolean get_isPreviewing()
  {
    return this.sZN;
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(168196);
    if (!bu.lX(this.iuG, paramString))
    {
      AppMethodBeat.o(168196);
      return;
    }
    ae.i("Finder.VideoView", "%s download  onPlayProgress [%d, %d] pauseByLoadData=%s playStatus=%s", new Object[] { bpA(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(this.iuP), Integer.valueOf(this.iuK) });
    if ((this.iuP) && (this.iuK == 3)) {
      ql(getCurrPosSec());
    }
    AppMethodBeat.o(168196);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(205501);
    boolean bool = super.isPlaying();
    AppMethodBeat.o(205501);
    return bool;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(205502);
    boolean bool = super.o(paramDouble);
    AppMethodBeat.o(205502);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(205494);
    if (this.sZs != null)
    {
      u localu = this.sZv;
      if (localu != null) {
        localu.fX(getVideoDurationSec(), getVideoDurationSec());
      }
      if (this.iuX)
      {
        localu = this.sZv;
        if (localu != null) {
          localu.cPm();
        }
      }
    }
    super.onCompletion();
    AppMethodBeat.o(205494);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(178468);
    super.onUIDestroy();
    this.sZm = false;
    this.sZs = null;
    this.tbp = null;
    ae.i("Finder.VideoView", "[onUIDestroy] " + getDefaultLog() + "  " + "");
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
    this.hdv.abn();
    ae.i("Finder.VideoView", "[pause] " + getDefaultLog() + "  " + "");
    u localu = this.sZv;
    if (localu != null) {
      localu.cPl();
    }
    boolean bool = super.pause();
    AppMethodBeat.o(168183);
    return bool;
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(168185);
    Object localObject;
    if (!this.sZm)
    {
      StringBuilder localStringBuilder = new StringBuilder("[play] unFocused. ").append(getDefaultLog()).append(" mediaId=");
      localObject = this.sZs;
      if (localObject != null) {}
      for (localObject = ((p)localObject).mediaId;; localObject = null)
      {
        ae.i("Finder.VideoView", (String)localObject);
        AppMethodBeat.o(168185);
        return false;
      }
    }
    if (this.tbr == 1)
    {
      this.iuJ = 1;
      this.tbr = 0;
      localObject = this.iuF;
      if (localObject != null) {
        ((com.tencent.mm.modelvideo.b)localObject).p(getVideoMediaId(), this.iuH, this.url);
      }
      localObject = this.oNV;
      d.g.b.p.g(localObject, "videoView");
      int i = ((h)localObject).getCurrentPosition() / 1000;
      ql(i);
      ae.i("Finder.VideoView", "continue to download... mediaId=" + getVideoMediaId() + " playSec=" + i);
    }
    if ((this.sZm) && (super.play()))
    {
      requestAudioFocus();
      localObject = this.tbq;
      if (localObject != null) {
        ((SynchronizedVideoPlayTextureView)localObject).setOneTimeVideoTextureUpdateCallback((h.e)this);
      }
      localObject = this.sZv;
      if (localObject != null) {
        ((u)localObject).cPn();
      }
      AppMethodBeat.o(168185);
      return true;
    }
    AppMethodBeat.o(168185);
    return false;
  }
  
  public final boolean qm(int paramInt)
  {
    AppMethodBeat.i(168197);
    if (this.iuJ == 3)
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
      if ((paramInt != 0) || (this.iuL == null)) {
        break label571;
      }
      localPInt2.value = 0;
      localPInt1.value = localPInt2.value;
      bool = this.iuL.b(paramInt + 1, localPInt1, localPInt2);
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
      if ((this.iuF != null) && (this.iuL != null) && (this.iuL.a(paramInt, i, (PInt)localObject1, (PInt)localObject2)))
      {
        bool = this.iuF.isVideoDataAvailable(this.iuG, ((PInt)localObject1).value, ((PInt)localObject2).value);
        if (bool) {}
        for (;;)
        {
          try
          {
            this.iuQ = Math.max(i, this.iuQ);
            localObject1 = this.rWB;
            if (localObject1 != null)
            {
              localObject1 = ((i)localObject1).tao;
              if (localObject1 != null)
              {
                localObject2 = getMediaId();
                i = this.iuQ;
                int j = this.iuM;
                d.g.b.p.h(localObject2, "mediaId");
                if (((MediaPreloadCore)localObject1).cEN())
                {
                  Object localObject3 = c.sLt;
                  localObject3 = c.bi((String)localObject2, false);
                  if (((((MediaPreloadCore)localObject1).getPreloadModel().suk <= i) || (((MediaPreloadCore)localObject1).getPreloadModel().suj <= ((z)localObject3).cEL())) && (((MediaPreloadCore)localObject1).stI))
                  {
                    ((MediaPreloadCore)localObject1).aix("startPreloadSecs=" + ((MediaPreloadCore)localObject1).getPreloadModel().suk + ", startPreloadPercent=" + ((MediaPreloadCore)localObject1).getPreloadModel().suj + ' ' + "cachePercent=" + ((z)localObject3).cEL() + " cacheTime=" + i + ", timeDuration=" + j + ", [onOnlineCachePlaying#" + (String)localObject2 + ']');
                    ((MediaPreloadCore)localObject1).stI = false;
                  }
                }
              }
            }
            ae.i("Finder.VideoView", "ret=%s %s checkCanPlay range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { Boolean.valueOf(bool), bpA(), Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.iuK), Integer.valueOf(this.iuQ), Integer.valueOf(this.iuR), this.iuG });
            AppMethodBeat.o(168197);
            return bool;
          }
          catch (Exception localException1) {}
          this.iuQ = paramInt;
          continue;
          ae.e(this.TAG, "%s check video data error %s ", new Object[] { bpA(), localException1.toString() });
        }
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(168198);
    super.reset();
    this.tbv = 3;
    AppMethodBeat.o(168198);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(205499);
    d.g.b.p.h(paramb, "_callback");
    super.setIMMVideoViewCallback(paramb);
    AppMethodBeat.o(205499);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    AppMethodBeat.i(168181);
    SynchronizedVideoPlayTextureView localSynchronizedVideoPlayTextureView = this.tbq;
    if (localSynchronizedVideoPlayTextureView != null)
    {
      localSynchronizedVideoPlayTextureView.setInterceptDetach(paramBoolean);
      AppMethodBeat.o(168181);
      return;
    }
    AppMethodBeat.o(168181);
  }
  
  public final void setLifecycle(u paramu)
  {
    this.sZv = paramu;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(205500);
    super.setLoop(paramBoolean);
    AppMethodBeat.o(205500);
  }
  
  public final void setMediaInfo(p paramp)
  {
    this.sZs = paramp;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(168194);
    super.setMute(paramBoolean);
    AppMethodBeat.o(168194);
  }
  
  public final void setMuteListener(q paramq)
  {
    this.sZP = paramq;
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.sZO = paramBoolean;
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.sZn = paramBoolean;
  }
  
  public final void setVideoCore(i parami)
  {
    this.rWB = parami;
  }
  
  public final void setVideoMatrix(atk paramatk)
  {
    this.tbp = paramatk;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(168191);
    super.setVideoTotalTime(paramInt);
    this.tbu = paramInt;
    AppMethodBeat.o(168191);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.sZm = paramBoolean;
  }
  
  public final void set_isPreviewing(boolean paramBoolean)
  {
    this.sZN = paramBoolean;
  }
  
  public final void start()
  {
    AppMethodBeat.i(168188);
    if (!this.sZm)
    {
      ae.w("Finder.VideoView", "isViewFocused=" + this.sZm);
      AppMethodBeat.o(168188);
      return;
    }
    if (this.sZs == null)
    {
      ae.w("Finder.VideoView", "mediaInfo is null!");
      AppMethodBeat.o(168188);
      return;
    }
    if (this.oNV == null)
    {
      ae.w("Finder.VideoView", "videoView is null!");
      AppMethodBeat.o(168188);
      return;
    }
    if (this.iuK == 3) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(168188);
      return;
    }
    ae.i("Finder.VideoView", "[start#1] isNeverStart=" + this.sZO + " isViewFocused=" + this.sZm + " isPlaying=false " + getDefaultLog());
    if (!this.sZO)
    {
      play();
      AppMethodBeat.o(168188);
      return;
    }
    Object localObject1 = this.sZv;
    if (localObject1 != null) {
      ((u)localObject1).GA(0);
    }
    if (c(this.sZs))
    {
      localObject1 = this.oNV;
      d.g.b.p.g(localObject1, "videoView");
      localObject1 = ((h)localObject1).getVideoPath();
      Object localObject2 = this.sZs;
      if (localObject2 == null) {
        d.g.b.p.gkB();
      }
      if ((d.g.b.p.i(localObject1, ((p)localObject2).path) ^ true))
      {
        localObject1 = this.oNV;
        d.g.b.p.g(localObject1, "videoView");
        localObject2 = this.sZs;
        if (localObject2 == null) {
          d.g.b.p.gkB();
        }
        ((h)localObject1).setVideoPath(((p)localObject2).path);
      }
      this.iuF = null;
      this.iuJ = 3;
      this.tbr = 0;
      localObject1 = this.tbq;
      if (localObject1 != null) {
        ((SynchronizedVideoPlayTextureView)localObject1).setIsOnlineVideoType(false);
      }
      boolean bool = play();
      if (!bool)
      {
        localObject1 = this.oNV;
        d.g.b.p.g(localObject1, "videoView");
        localObject1 = (CharSequence)((h)localObject1).getVideoPath();
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label532;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = new StringBuilder("[start] ERROR! videoPath=");
          localObject2 = this.oNV;
          d.g.b.p.g(localObject2, "videoView");
          localObject1 = ((StringBuilder)localObject1).append(((h)localObject2).getVideoPath()).append(" completedPath=");
          localObject2 = this.sZs;
          if (localObject2 == null) {
            d.g.b.p.gkB();
          }
          ae.e("Finder.VideoView", ((p)localObject2).path);
        }
      }
      localObject1 = new StringBuilder("[start] ret=").append(bool).append(" has download! local path:");
      localObject2 = this.oNV;
      d.g.b.p.g(localObject2, "videoView");
      ae.i("Finder.VideoView", ((h)localObject2).getVideoPath());
    }
    for (;;)
    {
      rd(1L + getReportIdkey());
      this.sZO = false;
      AppMethodBeat.o(168188);
      return;
      label532:
      i = 0;
      break;
      localObject1 = this.tbq;
      if (localObject1 != null) {
        ((SynchronizedVideoPlayTextureView)localObject1).setIsOnlineVideoType(true);
      }
      if ((this.iuF != null) && (this.iuJ != 1))
      {
        ae.i("Finder.VideoView", "[start] need to download..." + getDefaultLog());
        showLoading();
        setDownloadStatus(1);
        this.iuF.a((b.a)this);
        this.iuF.p(this.iuG, this.iuH, this.url);
        eek();
      }
      else
      {
        showLoading();
        if (this.iuF == null) {
          ae.e("Finder.VideoView", "why proxy is null! " + getDefaultLog());
        }
        ae.i("Finder.VideoView", "[start] wait for download..." + getDefaultLog());
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(168182);
    super.stop();
    u localu = this.sZv;
    if (localu != null) {
      localu.b(this.sZs);
    }
    this.sZO = true;
    this.sZs = null;
    this.tbp = null;
    this.sZm = false;
    this.tbr = 0;
    ae.i("Finder.VideoView", "[stop] " + getDefaultLog() + "  " + "");
    AppMethodBeat.o(168182);
  }
  
  public final void tx(int paramInt)
  {
    AppMethodBeat.i(168190);
    super.tx(paramInt);
    if (this.tbt != paramInt)
    {
      u localu = this.sZv;
      if (localu != null) {
        localu.fX(paramInt, this.tbu);
      }
      this.tbt = paramInt;
    }
    AppMethodBeat.o(168190);
  }
  
  public final void v(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(168200);
    ae.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s isPreparedMoovReadyResult:%s", new Object[] { bpA(), Long.valueOf(paramLong), Integer.valueOf(this.iuM), this.iuG, Boolean.valueOf(paramBoolean) });
    if (this.iuM != 0)
    {
      ae.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(168200);
      return;
    }
    ffg();
    try
    {
      if (this.iuL == null)
      {
        ae.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bpA() });
        AppMethodBeat.o(168200);
        return;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(this.TAG, (Throwable)localException, "%s deal moov ready error [%s]", new Object[] { bpA(), this.iuG });
      AppMethodBeat.o(168200);
      return;
    }
    if ((paramBoolean) || (this.iuL.L(this.iuH, paramLong)))
    {
      com.tencent.mm.plugin.a.f localf = this.iuL;
      d.g.b.p.g(localf, "parser");
      this.iuM = localf.aRo();
      ae.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { bpA(), Integer.valueOf(this.iuM), this.iuG });
      if (ql(0)) {
        aMT();
      }
      if (this.iuN != -1) {
        break label333;
      }
    }
    label333:
    for (int i = 1;; i = 2)
    {
      this.iuK = i;
      AppMethodBeat.o(168200);
      return;
      ae.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { bpA(), this.iuG });
      this.iuF.requestVideoData(this.iuG, 0, -1);
      AppMethodBeat.o(168200);
      return;
    }
  }
  
  public final boolean xL(long paramLong)
  {
    AppMethodBeat.i(205496);
    if (this.iuL == null)
    {
      ae.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bpA() });
      AppMethodBeat.o(205496);
      return false;
    }
    boolean bool = this.iuL.L(this.iuH, paramLong);
    AppMethodBeat.o(205496);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderVideoView$createVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "getBusinessType", "", "setVideoPath", "", "fullFile", "", "stop", "plugin-finder_release"})
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
      ae.i("Finder.VideoView", "[setVideoPath] " + FinderVideoView.a(this.tbx));
      super.setVideoPath(paramString);
      AppMethodBeat.o(168175);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(168174);
      ae.i("Finder.VideoView", "[stop] " + FinderVideoView.a(this.tbx));
      super.stop();
      AppMethodBeat.o(168174);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.plugin.finder.preload.model.a>
  {
    public static final c tbz;
    
    static
    {
      AppMethodBeat.i(205488);
      tbz = new c();
      AppMethodBeat.o(205488);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderVideoView$requestAudioFocus$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"})
  public static final class d
    implements d.a
  {
    public final void aAo()
    {
      AppMethodBeat.i(168176);
      ae.i("Finder.VideoView", "[audioHelperTool] gain");
      AppMethodBeat.o(168176);
    }
    
    public final void aAp()
    {
      AppMethodBeat.i(168178);
      ae.i("Finder.VideoView", "[audioHelperTool] loss");
      AppMethodBeat.o(168178);
    }
    
    public final void aAq()
    {
      AppMethodBeat.i(168177);
      ae.i("Finder.VideoView", "[audioHelperTool] lossTransient");
      AppMethodBeat.o(168177);
    }
    
    public final void aAr()
    {
      AppMethodBeat.i(168179);
      ae.i("Finder.VideoView", "[audioHelperTool] lossTransientCanDuck");
      AppMethodBeat.o(168179);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoView
 * JD-Core Version:    0.7.0.1
 */