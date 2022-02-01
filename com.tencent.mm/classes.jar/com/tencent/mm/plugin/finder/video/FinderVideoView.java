package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.plugin.a.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "firstCacheTimeStep", "", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isViewFocused", "setViewFocused", "lastDownloadStatus", "lastSeconds", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "limitSeconds", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "preloadModel", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "getPreloadModel", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "preloadModel$delegate", "Lkotlin/Lazy;", "textureView", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "totalSeconds", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "videoMatrix", "Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "getVideoMatrix", "()Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "setVideoMatrix", "(Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;)V", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkCompleted", "createMp4Parser", "Lcom/tencent/mm/plugin/Atom/IMp4Parser;", "createVideoFilePath", "", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrPosSec", "getDefaultLog", "", "getMediaId", "getVideoDurationSec", "getVideoMediaId", "isPlaying", "layoutId", "logTips", "onCompletion", "onMediaInfoAndMatrixPrepared", "onMoovReady", "mediaId", "moovPos", "", "length", "isPreparedMoovReadyResult", "onPrepareMoovReady", "onProgress", "offset", "total", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "pauseWithCancel", "play", "requestAudioFocus", "reset", "seekTo", "seconds", "", "afterPlay", "time", "afterSeekPlay", "setIMMVideoViewCallback", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setInterceptDetach", "isInterceptDetach", "setLocalVideoMedia", "path", "matrix", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setLoop", "loop", "setMute", "mute", "setVideoCore", "setVideoMedia", "isLocal", "downloadUrl", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setVideoTotalTime", "startOrPlay", "stop", "updateTime", "Companion", "plugin-finder_release"})
public class FinderVideoView
  extends MMVideoView
{
  public static final a sQl;
  private final d haI;
  private i rOe;
  private boolean sOC;
  volatile boolean sOD;
  private q sOE;
  boolean sOb;
  boolean sOc;
  private p sOh;
  private u sOk;
  asu sQe;
  private SynchronizedVideoPlayTextureView sQf;
  private int sQg;
  private final int sQh;
  private int sQi;
  private int sQj;
  private int sQk;
  private final d.f skI;
  
  static
  {
    AppMethodBeat.i(168206);
    sQl = new a((byte)0);
    AppMethodBeat.o(168206);
  }
  
  public FinderVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168204);
    setReporter((i.c)new i.c()
    {
      public final void qQ(long paramAnonymousLong)
      {
        AppMethodBeat.i(168171);
        Object localObject = this.sQm.getMediaInfo();
        if (localObject != null)
        {
          localObject = ((p)localObject).sQp;
          if (localObject == null) {
            break label384;
          }
          if (paramAnonymousLong < 200L) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, paramAnonymousLong, 1L, false);
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
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 200L, 1L, false);
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
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 204L, 1L, false);
              break;
              if (124L < paramAnonymousLong) {
                break label103;
              }
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 201L, 1L, false);
              break label103;
              if (129L < paramAnonymousLong) {
                break label111;
              }
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 202L, 1L, false);
              break label111;
              if (134L >= paramAnonymousLong) {
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 203L, 1L, false);
              }
            }
          }
        }
        label177:
        label227:
        if (160L >= paramAnonymousLong)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 210L, 1L, false);
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
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 211L, 1L, false);
            break;
            if (150L < paramAnonymousLong) {
              break label265;
            }
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 212L, 1L, false);
            break label265;
            if (155L >= paramAnonymousLong) {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 213L, 1L, false);
            }
          }
          label362:
          if (160L >= paramAnonymousLong) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 214L, 1L, false);
          }
        }
        label265:
        label312:
        label337:
        AppMethodBeat.o(168171);
        label384:
      }
      
      public final void vk(String paramAnonymousString) {}
    });
    this.skI = d.g.O((d.g.a.a)c.sQo);
    this.sOb = true;
    this.sOD = true;
    this.haI = d.azW();
    paramContext = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.sQh = com.tencent.mm.plugin.finder.storage.b.cFZ();
    this.sQi = -1;
    this.sQk = 3;
    AppMethodBeat.o(168204);
  }
  
  public FinderVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168205);
    setReporter((i.c)new i.c()
    {
      public final void qQ(long paramAnonymousLong)
      {
        AppMethodBeat.i(168171);
        Object localObject = this.sQm.getMediaInfo();
        if (localObject != null)
        {
          localObject = ((p)localObject).sQp;
          if (localObject == null) {
            break label384;
          }
          if (paramAnonymousLong < 200L) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, paramAnonymousLong, 1L, false);
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
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 200L, 1L, false);
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
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 204L, 1L, false);
              break;
              if (124L < paramAnonymousLong) {
                break label103;
              }
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 201L, 1L, false);
              break label103;
              if (129L < paramAnonymousLong) {
                break label111;
              }
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 202L, 1L, false);
              break label111;
              if (134L >= paramAnonymousLong) {
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 203L, 1L, false);
              }
            }
          }
        }
        label177:
        label227:
        if (160L >= paramAnonymousLong)
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 210L, 1L, false);
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
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 211L, 1L, false);
            break;
            if (150L < paramAnonymousLong) {
              break label265;
            }
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 212L, 1L, false);
            break label265;
            if (155L >= paramAnonymousLong) {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 213L, 1L, false);
            }
          }
          label362:
          if (160L >= paramAnonymousLong) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1302L, 214L, 1L, false);
          }
        }
        label265:
        label312:
        label337:
        AppMethodBeat.o(168171);
        label384:
      }
      
      public final void vk(String paramAnonymousString) {}
    });
    this.skI = d.g.O((d.g.a.a)c.sQo);
    this.sOb = true;
    this.sOD = true;
    this.haI = d.azW();
    paramContext = com.tencent.mm.plugin.finder.storage.b.sxa;
    this.sQh = com.tencent.mm.plugin.finder.storage.b.cFZ();
    this.sQi = -1;
    this.sQk = 3;
    AppMethodBeat.o(168205);
  }
  
  private final boolean c(p paramp)
  {
    AppMethodBeat.i(204868);
    if (paramp == null)
    {
      ad.w("Finder.VideoView", "[checkCompleted] mediaInfo is null");
      AppMethodBeat.o(204868);
      return false;
    }
    if (paramp.sQp == null)
    {
      ad.w("Finder.VideoView", "[checkCompleted] localFinderMedia is null");
      AppMethodBeat.o(204868);
      return true;
    }
    Object localObject1 = c.sAv;
    localObject1 = c.bf(paramp.mediaId, true);
    int j = ((y)localObject1).ahy(paramp.path);
    ad.i("Finder.VideoView", "[checkCompleted] isDownloadFinishAndCheckFile=" + j + " cache=" + localObject1 + " path=" + paramp.path + ' ' + getDefaultLog());
    Object localObject2 = MediaPreloadCore.skO;
    if (MediaPreloadCore.cDb())
    {
      localObject2 = new pd();
      ((pd)localObject2).dDd.mediaId = paramp.sQp.mediaId;
      ((pd)localObject2).dDd.dDf = ((y)localObject1).field_fileFormat;
      ((pd)localObject2).dDd.dDe = ((y)localObject1).field_hasPlayed;
      paramp = ((pd)localObject2).dDd;
      if (j != 0) {
        break label254;
      }
    }
    label254:
    for (int i = (int)(100.0F * (float)((y)localObject1).field_cacheSize / (float)((y)localObject1).field_totalSize);; i = 0)
    {
      paramp.process = i;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
      if (j != 0) {
        break;
      }
      AppMethodBeat.o(204868);
      return true;
    }
    AppMethodBeat.o(204868);
    return false;
  }
  
  private final String getDefaultLog()
  {
    AppMethodBeat.i(168195);
    StringBuilder localStringBuilder = new StringBuilder("videoView=").append(hashCode()).append("->textureView=").append(this.oHt.hashCode()).append(" mediaId=");
    Object localObject = this.sOh;
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
    AppMethodBeat.i(204864);
    com.tencent.mm.plugin.finder.preload.model.a locala = (com.tencent.mm.plugin.finder.preload.model.a)this.skI.getValue();
    AppMethodBeat.o(204864);
    return locala;
  }
  
  private final void requestAudioFocus()
  {
    AppMethodBeat.i(168202);
    this.haI.a((d.a)new d());
    AppMethodBeat.o(168202);
  }
  
  public final boolean C(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168189);
    ad.i("Finder.VideoView", "[seekTo] time=" + paramInt + " afterSeekPlay=" + paramBoolean + ' ' + getDefaultLog());
    requestAudioFocus();
    paramBoolean = super.C(paramInt, paramBoolean);
    AppMethodBeat.o(168189);
    return paramBoolean;
  }
  
  final void a(String paramString1, String paramString2, String paramString3, bvf parambvf, m paramm, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(204870);
    this.sOh = new p(paramString1, paramString2, paramString3, parambvf, paramm, paramFinderItem);
    paramString3 = this.sOh;
    if (paramString3 != null)
    {
      if ((parambvf != null) && (parambvf.GPt == true))
      {
        paramString2 = parambvf.skC;
        if (paramString2 == null) {
          break label155;
        }
      }
      label155:
      for (paramString2 = paramString2.GPM;; paramString2 = null)
      {
        this.sQe = paramString2;
        ad.i("Finder.VideoView", "[setVideoMedia] needCrop, " + this.sQe);
        cLV();
        super.c(false, paramString1, 0);
        this.irN = paramString3.path;
        this.irM = paramString3.mediaId;
        ad.i("Finder.VideoView", "[setVideoMedia] " + getDefaultLog());
        AppMethodBeat.o(204870);
        return;
      }
    }
    AppMethodBeat.o(204870);
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    int i = 0;
    AppMethodBeat.i(168199);
    d.g.b.p.h(paramPInt1, "start");
    d.g.b.p.h(paramPInt2, "end");
    paramPInt1.value = Math.max(paramInt, this.irW);
    if (this.irQ == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt2.value = (paramPInt1.value + this.sQk + 1);
    }
    this.sQk += this.isb.isg;
    if (this.irQ == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.irX + 8);
    }
    int j;
    if ((this.irQ == 3) || (this.irQ == 4))
    {
      paramPInt1.value = this.irW;
      paramPInt2.value = (this.irX + paramInt + 1 + this.isb.ish);
      j = Math.min(d.h.a.co(getPreloadModel().slh / 100.0F * this.irS), getPreloadModel().sln);
      if (j > 0) {
        break label435;
      }
      i = j;
      if (paramPInt2.value < this.irS / 2.0F)
      {
        paramPInt2.value = ((int)(this.irS / 2.0F + 1.0F));
        i = j;
      }
    }
    for (;;)
    {
      if (paramPInt2.value >= this.irS + 1) {
        paramPInt2.value = (this.irS + 1);
      }
      if (paramPInt2.value >= paramPInt1.value) {
        break;
      }
      paramPInt1.value += this.isb.ish;
      ad.i("Finder.VideoView", boQ() + " [start:end]=[" + paramPInt1.value + ':' + paramPInt2.value + "],playStatus=" + this.irQ + ",playTime=" + paramInt + ",cachePlayTime=" + this.irW + ",cacheTimeStep=" + this.irX + ",timeDuration=" + this.irS + ",targetSecond=" + i + ",cdnMediaId=" + this.irM);
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
    ad.i("Finder.VideoView", boQ() + " [start:end]=[" + paramPInt1.value + ':' + paramPInt2.value + "],playStatus=" + this.irQ + ",playTime=" + paramInt + ",cachePlayTime=" + this.irW + ",cacheTimeStep=" + this.irX + ",timeDuration=" + this.irS + ",targetSecond=" + i + ",cdnMediaId=" + this.irM);
    AppMethodBeat.o(168199);
    return true;
  }
  
  public final void aMr() {}
  
  public final com.tencent.mm.plugin.a.f aMt()
  {
    AppMethodBeat.i(204879);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cGF() == 1)
    {
      localObject = (com.tencent.mm.plugin.a.f)new j();
      AppMethodBeat.o(204879);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cGF() == 2)
    {
      localObject = (com.tencent.mm.plugin.a.f)new k();
      AppMethodBeat.o(204879);
      return localObject;
    }
    localObject = (com.tencent.mm.plugin.a.f)new com.tencent.mm.plugin.finder.video.parser.a();
    AppMethodBeat.o(204879);
    return localObject;
  }
  
  public final String boQ()
  {
    AppMethodBeat.i(204880);
    String str = "mediaId:" + getMediaId() + hashCode();
    AppMethodBeat.o(204880);
    return str;
  }
  
  public final void boT()
  {
    AppMethodBeat.i(168203);
    super.boT();
    u localu = this.sOk;
    if (localu != null)
    {
      localu.xq(0L);
      AppMethodBeat.o(168203);
      return;
    }
    AppMethodBeat.o(168203);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(204878);
    paramBoolean = super.c(paramDouble, paramBoolean);
    AppMethodBeat.o(204878);
    return paramBoolean;
  }
  
  public final h cL(final Context paramContext)
  {
    AppMethodBeat.i(168180);
    this.ltm = 1;
    paramContext = new b(this, paramContext, paramContext);
    paramContext.setIsOnlineVideoType(true);
    paramContext.setNeedResetExtractor(true);
    this.sQf = ((SynchronizedVideoPlayTextureView)paramContext);
    paramContext = this.sQf;
    if (paramContext == null) {
      d.g.b.p.gfZ();
    }
    paramContext = (h)paramContext;
    AppMethodBeat.o(168180);
    return paramContext;
  }
  
  public int cLU()
  {
    return 2131493938;
  }
  
  public void cLV() {}
  
  public final boolean cMf()
  {
    AppMethodBeat.i(204867);
    boolean bool = this.sOD;
    start();
    AppMethodBeat.o(204867);
    return bool;
  }
  
  public final int cMg()
  {
    AppMethodBeat.i(204866);
    ad.i("Finder.VideoView", "[pauseWithCancel] " + getDefaultLog() + " downloadStatus=" + this.irP + ", isPrepared=" + this.Zn);
    this.sQg = this.irP;
    com.tencent.mm.modelvideo.b localb = this.irL;
    if (localb != null) {
      localb.gj(getVideoMediaId());
    }
    pause();
    AppMethodBeat.o(204866);
    return 0;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(204865);
    Object localObject = this.sQf;
    if (localObject != null)
    {
      localObject = ((SynchronizedVideoPlayTextureView)localObject).getBitmap();
      AppMethodBeat.o(204865);
      return localObject;
    }
    AppMethodBeat.o(204865);
    return null;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(204872);
    int i = super.getCurrPosSec();
    AppMethodBeat.o(204872);
    return i;
  }
  
  public final u getLifecycle()
  {
    return this.sOk;
  }
  
  public String getMediaId()
  {
    Object localObject = this.sOh;
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
    return this.sOh;
  }
  
  public final q getMuteListener()
  {
    return this.sOE;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(204873);
    int i = super.getVideoDurationSec();
    AppMethodBeat.o(204873);
    return i;
  }
  
  public final asu getVideoMatrix()
  {
    return this.sQe;
  }
  
  public final String getVideoMediaId()
  {
    p localp = this.sOh;
    if (localp != null) {
      return localp.mediaId;
    }
    return null;
  }
  
  public final boolean get_isPreviewing()
  {
    return this.sOC;
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(168196);
    if (!bt.lQ(this.irM, paramString))
    {
      AppMethodBeat.o(168196);
      return;
    }
    ad.i("Finder.VideoView", "%s download  onPlayProgress [%d, %d] pauseByLoadData=%s playStatus=%s", new Object[] { boQ(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(this.irV), Integer.valueOf(this.irQ) });
    if ((this.irV) && (this.irQ == 3)) {
      qi(getCurrPosSec());
    }
    AppMethodBeat.o(168196);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(204876);
    boolean bool = super.isPlaying();
    AppMethodBeat.o(204876);
    return bool;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(204877);
    boolean bool = super.o(paramDouble);
    AppMethodBeat.o(204877);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(204869);
    if (this.sOh != null)
    {
      u localu = this.sOk;
      if (localu != null) {
        localu.fX(getVideoDurationSec(), getVideoDurationSec());
      }
      if (this.isd)
      {
        localu = this.sOk;
        if (localu != null) {
          localu.cMD();
        }
      }
    }
    super.onCompletion();
    AppMethodBeat.o(204869);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(178468);
    super.onUIDestroy();
    this.sOb = false;
    this.sOh = null;
    this.sQe = null;
    ad.i("Finder.VideoView", "[onUIDestroy] " + getDefaultLog() + "  " + "");
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
    this.haI.abe();
    ad.i("Finder.VideoView", "[pause] " + getDefaultLog() + "  " + "");
    u localu = this.sOk;
    if (localu != null) {
      localu.cMC();
    }
    boolean bool = super.pause();
    AppMethodBeat.o(168183);
    return bool;
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(168185);
    Object localObject;
    if (!this.sOb)
    {
      StringBuilder localStringBuilder = new StringBuilder("[play] unFocused. ").append(getDefaultLog()).append(" mediaId=");
      localObject = this.sOh;
      if (localObject != null) {}
      for (localObject = ((p)localObject).mediaId;; localObject = null)
      {
        ad.i("Finder.VideoView", (String)localObject);
        AppMethodBeat.o(168185);
        return false;
      }
    }
    if (this.sQg == 1)
    {
      this.irP = 1;
      this.sQg = 0;
      localObject = this.irL;
      if (localObject != null) {
        ((com.tencent.mm.modelvideo.b)localObject).p(getVideoMediaId(), this.irN, this.url);
      }
      localObject = this.oHt;
      d.g.b.p.g(localObject, "videoView");
      int i = ((h)localObject).getCurrentPosition() / 1000;
      qi(i);
      ad.i("Finder.VideoView", "continue to download... mediaId=" + getVideoMediaId() + " playSec=" + i);
    }
    if ((this.sOb) && (super.play()))
    {
      requestAudioFocus();
      localObject = this.sQf;
      if (localObject != null) {
        ((SynchronizedVideoPlayTextureView)localObject).setOneTimeVideoTextureUpdateCallback((h.e)this);
      }
      localObject = this.sOk;
      if (localObject != null) {
        ((u)localObject).cME();
      }
      AppMethodBeat.o(168185);
      return true;
    }
    AppMethodBeat.o(168185);
    return false;
  }
  
  public final boolean qj(int paramInt)
  {
    AppMethodBeat.i(168197);
    if (this.irP == 3)
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
      if ((paramInt != 0) || (this.irR == null)) {
        break label571;
      }
      localPInt2.value = 0;
      localPInt1.value = localPInt2.value;
      bool = this.irR.b(paramInt + 1, localPInt1, localPInt2);
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
      if ((this.irL != null) && (this.irR != null) && (this.irR.a(paramInt, i, (PInt)localObject1, (PInt)localObject2)))
      {
        bool = this.irL.isVideoDataAvailable(this.irM, ((PInt)localObject1).value, ((PInt)localObject2).value);
        if (bool) {}
        for (;;)
        {
          try
          {
            this.irW = Math.max(i, this.irW);
            localObject1 = this.rOe;
            if (localObject1 != null)
            {
              localObject1 = ((i)localObject1).sPb;
              if (localObject1 != null)
              {
                localObject2 = getMediaId();
                i = this.irW;
                int j = this.irS;
                d.g.b.p.h(localObject2, "mediaId");
                if (((MediaPreloadCore)localObject1).cDa())
                {
                  Object localObject3 = c.sAv;
                  localObject3 = c.bf((String)localObject2, false);
                  if (((((MediaPreloadCore)localObject1).getPreloadModel().sln <= i) || (((MediaPreloadCore)localObject1).getPreloadModel().slm <= ((y)localObject3).cCY())) && (((MediaPreloadCore)localObject1).skL))
                  {
                    ((MediaPreloadCore)localObject1).ahA("startPreloadSecs=" + ((MediaPreloadCore)localObject1).getPreloadModel().sln + ", startPreloadPercent=" + ((MediaPreloadCore)localObject1).getPreloadModel().slm + ' ' + "cachePercent=" + ((y)localObject3).cCY() + " cacheTime=" + i + ", timeDuration=" + j + ", [onOnlineCachePlaying#" + (String)localObject2 + ']');
                    ((MediaPreloadCore)localObject1).skL = false;
                  }
                }
              }
            }
            ad.i("Finder.VideoView", "ret=%s %s checkCanPlay range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { Boolean.valueOf(bool), boQ(), Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.irQ), Integer.valueOf(this.irW), Integer.valueOf(this.irX), this.irM });
            AppMethodBeat.o(168197);
            return bool;
          }
          catch (Exception localException1) {}
          this.irW = paramInt;
          continue;
          ad.e(this.TAG, "%s check video data error %s ", new Object[] { boQ(), localException1.toString() });
        }
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(168198);
    super.reset();
    this.sQk = 3;
    AppMethodBeat.o(168198);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(204874);
    d.g.b.p.h(paramb, "_callback");
    super.setIMMVideoViewCallback(paramb);
    AppMethodBeat.o(204874);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    AppMethodBeat.i(168181);
    SynchronizedVideoPlayTextureView localSynchronizedVideoPlayTextureView = this.sQf;
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
    this.sOk = paramu;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(204875);
    super.setLoop(paramBoolean);
    AppMethodBeat.o(204875);
  }
  
  public final void setMediaInfo(p paramp)
  {
    this.sOh = paramp;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(168194);
    super.setMute(paramBoolean);
    AppMethodBeat.o(168194);
  }
  
  public final void setMuteListener(q paramq)
  {
    this.sOE = paramq;
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.sOD = paramBoolean;
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.sOc = paramBoolean;
  }
  
  public final void setVideoCore(i parami)
  {
    this.rOe = parami;
  }
  
  public final void setVideoMatrix(asu paramasu)
  {
    this.sQe = paramasu;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(168191);
    super.setVideoTotalTime(paramInt);
    this.sQj = paramInt;
    AppMethodBeat.o(168191);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.sOb = paramBoolean;
  }
  
  public final void set_isPreviewing(boolean paramBoolean)
  {
    this.sOC = paramBoolean;
  }
  
  public final void start()
  {
    AppMethodBeat.i(168188);
    if (!this.sOb)
    {
      ad.w("Finder.VideoView", "isViewFocused=" + this.sOb);
      AppMethodBeat.o(168188);
      return;
    }
    if (this.sOh == null)
    {
      ad.w("Finder.VideoView", "mediaInfo is null!");
      AppMethodBeat.o(168188);
      return;
    }
    if (this.oHt == null)
    {
      ad.w("Finder.VideoView", "videoView is null!");
      AppMethodBeat.o(168188);
      return;
    }
    if (this.irQ == 3) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(168188);
      return;
    }
    ad.i("Finder.VideoView", "[start#1] isNeverStart=" + this.sOD + " isViewFocused=" + this.sOb + " isPlaying=false " + getDefaultLog());
    if (!this.sOD)
    {
      play();
      AppMethodBeat.o(168188);
      return;
    }
    Object localObject1 = this.sOk;
    if (localObject1 != null) {
      ((u)localObject1).Ga(0);
    }
    if (c(this.sOh))
    {
      localObject1 = this.oHt;
      d.g.b.p.g(localObject1, "videoView");
      localObject1 = ((h)localObject1).getVideoPath();
      Object localObject2 = this.sOh;
      if (localObject2 == null) {
        d.g.b.p.gfZ();
      }
      if ((d.g.b.p.i(localObject1, ((p)localObject2).path) ^ true))
      {
        localObject1 = this.oHt;
        d.g.b.p.g(localObject1, "videoView");
        localObject2 = this.sOh;
        if (localObject2 == null) {
          d.g.b.p.gfZ();
        }
        ((h)localObject1).setVideoPath(((p)localObject2).path);
      }
      this.irL = null;
      this.irP = 3;
      this.sQg = 0;
      localObject1 = this.sQf;
      if (localObject1 != null) {
        ((SynchronizedVideoPlayTextureView)localObject1).setIsOnlineVideoType(false);
      }
      boolean bool = play();
      if (!bool)
      {
        localObject1 = this.oHt;
        d.g.b.p.g(localObject1, "videoView");
        localObject1 = (CharSequence)((h)localObject1).getVideoPath();
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label532;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = new StringBuilder("[start] ERROR! videoPath=");
          localObject2 = this.oHt;
          d.g.b.p.g(localObject2, "videoView");
          localObject1 = ((StringBuilder)localObject1).append(((h)localObject2).getVideoPath()).append(" completedPath=");
          localObject2 = this.sOh;
          if (localObject2 == null) {
            d.g.b.p.gfZ();
          }
          ad.e("Finder.VideoView", ((p)localObject2).path);
        }
      }
      localObject1 = new StringBuilder("[start] ret=").append(bool).append(" has download! local path:");
      localObject2 = this.oHt;
      d.g.b.p.g(localObject2, "videoView");
      ad.i("Finder.VideoView", ((h)localObject2).getVideoPath());
    }
    for (;;)
    {
      qQ(1L + getReportIdkey());
      this.sOD = false;
      AppMethodBeat.o(168188);
      return;
      label532:
      i = 0;
      break;
      localObject1 = this.sQf;
      if (localObject1 != null) {
        ((SynchronizedVideoPlayTextureView)localObject1).setIsOnlineVideoType(true);
      }
      if ((this.irL != null) && (this.irP != 1))
      {
        ad.i("Finder.VideoView", "[start] need to download..." + getDefaultLog());
        showLoading();
        setDownloadStatus(1);
        this.irL.a((b.a)this);
        this.irL.p(this.irM, this.irN, this.url);
        eaE();
      }
      else
      {
        showLoading();
        if (this.irL == null) {
          ad.e("Finder.VideoView", "why proxy is null! " + getDefaultLog());
        }
        ad.i("Finder.VideoView", "[start] wait for download..." + getDefaultLog());
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(168182);
    super.stop();
    u localu = this.sOk;
    if (localu != null) {
      localu.b(this.sOh);
    }
    this.sOD = true;
    this.sOh = null;
    this.sQe = null;
    this.sOb = false;
    this.sQg = 0;
    ad.i("Finder.VideoView", "[stop] " + getDefaultLog() + "  " + "");
    AppMethodBeat.o(168182);
  }
  
  public final void tt(int paramInt)
  {
    AppMethodBeat.i(168190);
    super.tt(paramInt);
    if (this.sQi != paramInt)
    {
      u localu = this.sOk;
      if (localu != null) {
        localu.fX(paramInt, this.sQj);
      }
      this.sQi = paramInt;
    }
    AppMethodBeat.o(168190);
  }
  
  public final void v(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(168200);
    ad.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s isPreparedMoovReadyResult:%s", new Object[] { boQ(), Long.valueOf(paramLong), Integer.valueOf(this.irS), this.irM, Boolean.valueOf(paramBoolean) });
    if (this.irS != 0)
    {
      ad.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(168200);
      return;
    }
    fbs();
    try
    {
      if (this.irR == null)
      {
        ad.w(this.TAG, "%s parser is null, thread is error.", new Object[] { boQ() });
        AppMethodBeat.o(168200);
        return;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "%s deal moov ready error [%s]", new Object[] { boQ(), this.irM });
      AppMethodBeat.o(168200);
      return;
    }
    if ((paramBoolean) || (this.irR.L(this.irN, paramLong)))
    {
      com.tencent.mm.plugin.a.f localf = this.irR;
      d.g.b.p.g(localf, "parser");
      this.irS = localf.aQP();
      ad.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { boQ(), Integer.valueOf(this.irS), this.irM });
      if (qi(0)) {
        aMv();
      }
      if (this.irT != -1) {
        break label333;
      }
    }
    label333:
    for (int i = 1;; i = 2)
    {
      this.irQ = i;
      AppMethodBeat.o(168200);
      return;
      ad.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { boQ(), this.irM });
      this.irL.requestVideoData(this.irM, 0, -1);
      AppMethodBeat.o(168200);
      return;
    }
  }
  
  public final boolean xr(long paramLong)
  {
    AppMethodBeat.i(204871);
    if (this.irR == null)
    {
      ad.w(this.TAG, "%s parser is null, thread is error.", new Object[] { boQ() });
      AppMethodBeat.o(204871);
      return false;
    }
    boolean bool = this.irR.L(this.irN, paramLong);
    AppMethodBeat.o(204871);
    return bool;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoView$Companion;", "", "()V", "FINDER_VIDEO_VIEW_IDKEY_STAT", "", "_TAG", "", "isDebug", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderVideoView$createVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "getBusinessType", "", "setVideoPath", "", "fullFile", "", "stop", "plugin-finder_release"})
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
      ad.i("Finder.VideoView", "[setVideoPath] " + FinderVideoView.a(this.sQm));
      super.setVideoPath(paramString);
      AppMethodBeat.o(168175);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(168174);
      ad.i("Finder.VideoView", "[stop] " + FinderVideoView.a(this.sQm));
      super.stop();
      AppMethodBeat.o(168174);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.plugin.finder.preload.model.a>
  {
    public static final c sQo;
    
    static
    {
      AppMethodBeat.i(204863);
      sQo = new c();
      AppMethodBeat.o(204863);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderVideoView$requestAudioFocus$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"})
  public static final class d
    implements d.a
  {
    public final void aAa()
    {
      AppMethodBeat.i(168177);
      ad.i("Finder.VideoView", "[audioHelperTool] lossTransient");
      AppMethodBeat.o(168177);
    }
    
    public final void aAb()
    {
      AppMethodBeat.i(168179);
      ad.i("Finder.VideoView", "[audioHelperTool] lossTransientCanDuck");
      AppMethodBeat.o(168179);
    }
    
    public final void azY()
    {
      AppMethodBeat.i(168176);
      ad.i("Finder.VideoView", "[audioHelperTool] gain");
      AppMethodBeat.o(168176);
    }
    
    public final void azZ()
    {
      AppMethodBeat.i(168178);
      ad.i("Finder.VideoView", "[audioHelperTool] loss");
      AppMethodBeat.o(168178);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoView
 * JD-Core Version:    0.7.0.1
 */