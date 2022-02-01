package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "firstCacheTimeStep", "", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isViewFocused", "setViewFocused", "lastDownloadStatus", "lastSeconds", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "limitSeconds", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "textureView", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "totalSeconds", "videoMatrix", "Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "getVideoMatrix", "()Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "setVideoMatrix", "(Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;)V", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkCompleted", "createMp4Parser", "Lcom/tencent/mm/plugin/Atom/IMp4Parser;", "createVideoFilePath", "", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "getCurrPosSec", "getDefaultLog", "", "getMediaId", "getVideoDurationSec", "getVideoMediaId", "isPlaying", "layoutId", "onCompletion", "onMediaInfoAndMatrixPrepared", "onMoovReady", "mediaId", "moovPos", "", "length", "isPreparedMoovReadyResult", "onPrepareMoovReady", "onProgress", "offset", "total", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "pauseWithCancel", "play", "requestAudioFocus", "reset", "seekTo", "seconds", "", "afterPlay", "time", "afterSeekPlay", "setIMMVideoViewCallback", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setInterceptDetach", "isInterceptDetach", "setLocalVideoMedia", "path", "matrix", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setLoop", "loop", "setMute", "mute", "setVideoMedia", "isLocal", "downloadUrl", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setVideoTotalTime", "startOrPlay", "stop", "updateTime", "Companion", "plugin-finder_release"})
public class FinderVideoView
  extends MMVideoView
{
  public static final FinderVideoView.a rTB;
  private final d gGY;
  boolean rRA;
  boolean rRB;
  private p rRF;
  private u rRI;
  private boolean rRY;
  volatile boolean rRZ;
  private q rSa;
  private int rTA;
  aoz rTu;
  private SynchronizedVideoPlayTextureView rTv;
  private int rTw;
  private final int rTx;
  private int rTy;
  private int rTz;
  
  static
  {
    AppMethodBeat.i(168206);
    rTB = new FinderVideoView.a((byte)0);
    AppMethodBeat.o(168206);
  }
  
  public FinderVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168204);
    setReporter((h.c)new h.c()
    {
      public final void oQ(long paramAnonymousLong)
      {
        AppMethodBeat.i(168171);
        Object localObject = this.rTC.getMediaInfo();
        if (localObject != null)
        {
          localObject = ((p)localObject).rTE;
          if (localObject == null) {
            break label384;
          }
          if (paramAnonymousLong < 200L) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, paramAnonymousLong, 1L, false);
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
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 200L, 1L, false);
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
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 204L, 1L, false);
              break;
              if (124L < paramAnonymousLong) {
                break label103;
              }
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 201L, 1L, false);
              break label103;
              if (129L < paramAnonymousLong) {
                break label111;
              }
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 202L, 1L, false);
              break label111;
              if (134L >= paramAnonymousLong) {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 203L, 1L, false);
              }
            }
          }
        }
        label177:
        label227:
        if (160L >= paramAnonymousLong)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 210L, 1L, false);
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
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 211L, 1L, false);
            break;
            if (150L < paramAnonymousLong) {
              break label265;
            }
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 212L, 1L, false);
            break label265;
            if (155L >= paramAnonymousLong) {
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 213L, 1L, false);
            }
          }
          label362:
          if (160L >= paramAnonymousLong) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 214L, 1L, false);
          }
        }
        label265:
        label312:
        label337:
        AppMethodBeat.o(168171);
        label384:
      }
      
      public final void sv(String paramAnonymousString) {}
    });
    this.rRA = true;
    this.rRZ = true;
    this.gGY = d.axh();
    paramContext = com.tencent.mm.plugin.finder.storage.b.rCU;
    this.rTx = com.tencent.mm.plugin.finder.storage.b.cze();
    this.rTy = -1;
    this.rTA = 3;
    AppMethodBeat.o(168204);
  }
  
  public FinderVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168205);
    setReporter((h.c)new h.c()
    {
      public final void oQ(long paramAnonymousLong)
      {
        AppMethodBeat.i(168171);
        Object localObject = this.rTC.getMediaInfo();
        if (localObject != null)
        {
          localObject = ((p)localObject).rTE;
          if (localObject == null) {
            break label384;
          }
          if (paramAnonymousLong < 200L) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, paramAnonymousLong, 1L, false);
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
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 200L, 1L, false);
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
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 204L, 1L, false);
              break;
              if (124L < paramAnonymousLong) {
                break label103;
              }
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 201L, 1L, false);
              break label103;
              if (129L < paramAnonymousLong) {
                break label111;
              }
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 202L, 1L, false);
              break label111;
              if (134L >= paramAnonymousLong) {
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 203L, 1L, false);
              }
            }
          }
        }
        label177:
        label227:
        if (160L >= paramAnonymousLong)
        {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 210L, 1L, false);
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
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 211L, 1L, false);
            break;
            if (150L < paramAnonymousLong) {
              break label265;
            }
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 212L, 1L, false);
            break label265;
            if (155L >= paramAnonymousLong) {
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 213L, 1L, false);
            }
          }
          label362:
          if (160L >= paramAnonymousLong) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1302L, 214L, 1L, false);
          }
        }
        label265:
        label312:
        label337:
        AppMethodBeat.o(168171);
        label384:
      }
      
      public final void sv(String paramAnonymousString) {}
    });
    this.rRA = true;
    this.rRZ = true;
    this.gGY = d.axh();
    paramContext = com.tencent.mm.plugin.finder.storage.b.rCU;
    this.rTx = com.tencent.mm.plugin.finder.storage.b.cze();
    this.rTy = -1;
    this.rTA = 3;
    AppMethodBeat.o(168205);
  }
  
  private final boolean c(p paramp)
  {
    AppMethodBeat.i(203912);
    if (paramp == null)
    {
      ac.w("Finder.VideoView", "[checkCompleted] mediaInfo is null");
      AppMethodBeat.o(203912);
      return false;
    }
    if (paramp.rTE == null)
    {
      ac.w("Finder.VideoView", "[checkCompleted] localFinderMedia is null");
      AppMethodBeat.o(203912);
      return true;
    }
    Object localObject1 = c.rFo;
    localObject1 = c.ba(paramp.mediaId, true);
    int j = ((w)localObject1).adF(paramp.path);
    ac.i("Finder.VideoView", "[checkCompleted] isDownloadFinishAndCheckFile=" + j + " cache=" + localObject1 + " path=" + paramp.path + ' ' + getDefaultLog());
    Object localObject2 = MediaPreloadCore.rvo;
    if (MediaPreloadCore.cwJ())
    {
      localObject2 = new ou();
      ((ou)localObject2).drl.mediaId = paramp.rTE.mediaId;
      ((ou)localObject2).drl.drn = ((w)localObject1).field_fileFormat;
      ((ou)localObject2).drl.drm = ((w)localObject1).field_hasPlayed;
      paramp = ((ou)localObject2).drl;
      if (j != 0) {
        break label246;
      }
    }
    label246:
    for (int i = (int)(100.0F * (float)((w)localObject1).field_cacheSize / (float)((w)localObject1).field_totalSize);; i = 0)
    {
      paramp.process = i;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
      if (j != 0) {
        break;
      }
      AppMethodBeat.o(203912);
      return true;
    }
    AppMethodBeat.o(203912);
    return false;
  }
  
  private final String getDefaultLog()
  {
    AppMethodBeat.i(168195);
    StringBuilder localStringBuilder = new StringBuilder("videoView=").append(hashCode()).append("->textureView=").append(this.odZ.hashCode()).append(" mediaId=");
    Object localObject = this.rRF;
    if (localObject != null) {}
    for (localObject = ((p)localObject).mediaId;; localObject = null)
    {
      localObject = (String)localObject;
      AppMethodBeat.o(168195);
      return localObject;
    }
  }
  
  private final void requestAudioFocus()
  {
    AppMethodBeat.i(168202);
    this.gGY.a((d.a)new c());
    AppMethodBeat.o(168202);
  }
  
  public final boolean C(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(168189);
    ac.i("Finder.VideoView", "[seekTo] time=" + paramInt + " afterSeekPlay=" + paramBoolean + ' ' + getDefaultLog());
    requestAudioFocus();
    paramBoolean = super.C(paramInt, paramBoolean);
    AppMethodBeat.o(168189);
    return paramBoolean;
  }
  
  final void a(String paramString1, String paramString2, String paramString3, bqs parambqs, com.tencent.mm.plugin.finder.loader.l paraml, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(203914);
    this.rRF = new p(paramString1, paramString2, paramString3, parambqs, paraml, paramFinderItem);
    paramString3 = this.rRF;
    if (paramString3 != null)
    {
      if ((parambqs != null) && (parambqs.FfP == true))
      {
        paramString2 = parambqs.rvh;
        if (paramString2 == null) {
          break label153;
        }
      }
      label153:
      for (paramString2 = paramString2.Fgk;; paramString2 = null)
      {
        this.rTu = paramString2;
        ac.i("Finder.VideoView", "[setVideoMedia] needCrop, " + this.rTu);
        cDB();
        super.c(false, paramString1, 0);
        this.hYr = paramString3.path;
        this.hYq = paramString3.mediaId;
        ac.i("Finder.VideoView", "[setVideoMedia] " + getDefaultLog());
        AppMethodBeat.o(203914);
        return;
      }
    }
    AppMethodBeat.o(203914);
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(168199);
    d.g.b.k.h(paramPInt1, "start");
    d.g.b.k.h(paramPInt2, "end");
    paramPInt1.value = Math.max(paramInt, this.hYA);
    if (this.hYu == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt2.value = (paramPInt1.value + this.rTA + 1);
    }
    this.rTA += this.hYF.hYK;
    if (this.hYu == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.hYB + 8);
    }
    if ((this.hYu == 3) || (this.hYu == 4))
    {
      paramPInt1.value = this.hYA;
      paramPInt2.value = (this.hYB + paramInt + 1 + this.hYF.hYL);
      if (paramPInt2.value < this.hYw / 2.0F) {
        paramPInt2.value = ((int)(this.hYw / 2.0F + 1.0F));
      }
    }
    if (paramPInt2.value >= this.hYw + 1) {
      paramPInt2.value = (this.hYw + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.hYF.hYL;
      ac.i("Finder.VideoView", "%s end smaller start calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { blf(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.hYu), Integer.valueOf(this.hYA), Integer.valueOf(this.hYB), this.hYq });
      AppMethodBeat.o(168199);
      return true;
    }
    ac.i("Finder.VideoView", "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s] firstCacheTimeStep=%s", new Object[] { blf(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.hYu), Integer.valueOf(this.hYA), Integer.valueOf(this.hYB), this.hYq, Integer.valueOf(this.rTA) });
    AppMethodBeat.o(168199);
    return true;
  }
  
  public final void aJh() {}
  
  public final f aJj()
  {
    AppMethodBeat.i(203923);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.cAl() == 1)
    {
      localObject = (f)new j();
      AppMethodBeat.o(203923);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.cAl() == 2)
    {
      localObject = (f)new com.tencent.mm.plugin.a.k();
      AppMethodBeat.o(203923);
      return localObject;
    }
    localObject = (f)new com.tencent.mm.plugin.finder.video.parser.a();
    AppMethodBeat.o(203923);
    return localObject;
  }
  
  public final void bli()
  {
    AppMethodBeat.i(168203);
    super.bli();
    u localu = this.rRI;
    if (localu != null)
    {
      localu.cEh();
      AppMethodBeat.o(168203);
      return;
    }
    AppMethodBeat.o(168203);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(203922);
    paramBoolean = super.c(paramDouble, paramBoolean);
    AppMethodBeat.o(203922);
    return paramBoolean;
  }
  
  public int cDA()
  {
    return 2131493938;
  }
  
  public void cDB() {}
  
  public final boolean cDM()
  {
    AppMethodBeat.i(203911);
    boolean bool = this.rRZ;
    start();
    AppMethodBeat.o(203911);
    return bool;
  }
  
  public final int cDN()
  {
    AppMethodBeat.i(203910);
    ac.i("Finder.VideoView", "[pauseWithCancel] " + getDefaultLog() + " downloadStatus=" + this.hYt + ", isPrepared=" + this.Xy);
    this.rTw = this.hYt;
    com.tencent.mm.modelvideo.b localb = this.hYp;
    if (localb != null) {
      localb.fo(getVideoMediaId());
    }
    pause();
    AppMethodBeat.o(203910);
    return 0;
  }
  
  public final com.tencent.mm.pluginsdk.ui.tools.h cO(final Context paramContext)
  {
    AppMethodBeat.i(168180);
    this.kWn = 1;
    paramContext = new b(this, paramContext, paramContext);
    paramContext.setIsOnlineVideoType(true);
    paramContext.setNeedResetExtractor(true);
    this.rTv = ((SynchronizedVideoPlayTextureView)paramContext);
    paramContext = this.rTv;
    if (paramContext == null) {
      d.g.b.k.fOy();
    }
    paramContext = (com.tencent.mm.pluginsdk.ui.tools.h)paramContext;
    AppMethodBeat.o(168180);
    return paramContext;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(203916);
    int i = super.getCurrPosSec();
    AppMethodBeat.o(203916);
    return i;
  }
  
  public final u getLifecycle()
  {
    return this.rRI;
  }
  
  public String getMediaId()
  {
    Object localObject = this.rRF;
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
    return this.rRF;
  }
  
  public final q getMuteListener()
  {
    return this.rSa;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(203917);
    int i = super.getVideoDurationSec();
    AppMethodBeat.o(203917);
    return i;
  }
  
  public final aoz getVideoMatrix()
  {
    return this.rTu;
  }
  
  public final String getVideoMediaId()
  {
    p localp = this.rRF;
    if (localp != null) {
      return localp.mediaId;
    }
    return null;
  }
  
  public final boolean get_isPreviewing()
  {
    return this.rRY;
  }
  
  public final void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(168196);
    if (!bs.lr(this.hYq, paramString))
    {
      AppMethodBeat.o(168196);
      return;
    }
    ac.i("Finder.VideoView", "%s download  onPlayProgress [%d, %d] pauseByLoadData=%s playStatus=%s", new Object[] { blf(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(this.hYz), Integer.valueOf(this.hYu) });
    if ((this.hYz) && (this.hYu == 3)) {
      pG(getCurrPosSec());
    }
    AppMethodBeat.o(168196);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(203920);
    boolean bool = super.isPlaying();
    AppMethodBeat.o(203920);
    return bool;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(203921);
    boolean bool = super.o(paramDouble);
    AppMethodBeat.o(203921);
    return bool;
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(203913);
    if (this.rRF != null)
    {
      u localu = this.rRI;
      if (localu != null) {
        localu.fJ(getVideoDurationSec(), getVideoDurationSec());
      }
      if (this.hYH)
      {
        localu = this.rRI;
        if (localu != null) {
          localu.cEj();
        }
      }
    }
    super.onCompletion();
    AppMethodBeat.o(203913);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(178468);
    super.onUIDestroy();
    this.rRA = false;
    this.rRF = null;
    this.rTu = null;
    ac.i("Finder.VideoView", "[onUIDestroy] " + getDefaultLog() + "  " + "");
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
  
  public final boolean pH(int paramInt)
  {
    AppMethodBeat.i(168197);
    if (this.hYt == 3)
    {
      AppMethodBeat.o(168197);
      return true;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      localPInt3 = new PInt();
      localPInt4 = new PInt();
      if ((paramInt != 0) || (this.hYv == null)) {
        break label351;
      }
      localPInt4.value = 0;
      localPInt3.value = localPInt4.value;
      bool = this.hYv.b(paramInt + 1, localPInt3, localPInt4);
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        PInt localPInt3;
        PInt localPInt4;
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
      i = localPInt4.value + 1;
      if ((this.hYp != null) && (this.hYv != null) && (this.hYv.a(paramInt, i, localPInt1, localPInt2)))
      {
        bool = this.hYp.isVideoDataAvailable(this.hYq, localPInt1.value, localPInt2.value);
        if (bool) {}
        for (;;)
        {
          try
          {
            this.hYA = Math.max(i, this.hYA);
            ac.i("Finder.VideoView", "ret=%s %s checkCanPlay range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { Boolean.valueOf(bool), blf(), Integer.valueOf(localPInt3.value), Integer.valueOf(localPInt4.value), Integer.valueOf(paramInt), Integer.valueOf(this.hYu), Integer.valueOf(this.hYA), Integer.valueOf(this.hYB), this.hYq });
            AppMethodBeat.o(168197);
            return bool;
          }
          catch (Exception localException1) {}
          this.hYA = paramInt;
          continue;
          ac.e(this.TAG, "%s check video data error %s ", new Object[] { blf(), localException1.toString() });
        }
      }
    }
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(168183);
    this.gGY.YC();
    ac.i("Finder.VideoView", "[pause] " + getDefaultLog() + "  " + "");
    u localu = this.rRI;
    if (localu != null) {
      localu.cEi();
    }
    boolean bool = super.pause();
    AppMethodBeat.o(168183);
    return bool;
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(168185);
    Object localObject;
    if (!this.rRA)
    {
      StringBuilder localStringBuilder = new StringBuilder("[play] unFocused. ").append(getDefaultLog()).append(" mediaId=");
      localObject = this.rRF;
      if (localObject != null) {}
      for (localObject = ((p)localObject).mediaId;; localObject = null)
      {
        ac.i("Finder.VideoView", (String)localObject);
        AppMethodBeat.o(168185);
        return false;
      }
    }
    if (this.rTw == 1)
    {
      this.hYt = 1;
      this.rTw = 0;
      localObject = this.hYp;
      if (localObject != null) {
        ((com.tencent.mm.modelvideo.b)localObject).q(getVideoMediaId(), this.hYr, this.url);
      }
      localObject = this.odZ;
      d.g.b.k.g(localObject, "videoView");
      int i = ((com.tencent.mm.pluginsdk.ui.tools.h)localObject).getCurrentPosition() / 1000;
      pG(i);
      ac.i("Finder.VideoView", "continue to download... mediaId=" + getVideoMediaId() + " playSec=" + i);
    }
    if ((this.rRA) && (super.play()))
    {
      requestAudioFocus();
      localObject = this.rTv;
      if (localObject != null) {
        ((SynchronizedVideoPlayTextureView)localObject).setOneTimeVideoTextureUpdateCallback((h.e)this);
      }
      localObject = this.rRI;
      if (localObject != null) {
        ((u)localObject).cEk();
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
    this.rTA = 3;
    AppMethodBeat.o(168198);
  }
  
  public final void sQ(int paramInt)
  {
    AppMethodBeat.i(168190);
    super.sQ(paramInt);
    if (this.rTy != paramInt)
    {
      u localu = this.rRI;
      if (localu != null) {
        localu.fJ(paramInt, this.rTz);
      }
      this.rTy = paramInt;
    }
    AppMethodBeat.o(168190);
  }
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    AppMethodBeat.i(203918);
    d.g.b.k.h(paramb, "_callback");
    super.setIMMVideoViewCallback(paramb);
    AppMethodBeat.o(203918);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    AppMethodBeat.i(168181);
    SynchronizedVideoPlayTextureView localSynchronizedVideoPlayTextureView = this.rTv;
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
    this.rRI = paramu;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(203919);
    super.setLoop(paramBoolean);
    AppMethodBeat.o(203919);
  }
  
  public final void setMediaInfo(p paramp)
  {
    this.rRF = paramp;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(168194);
    super.setMute(paramBoolean);
    AppMethodBeat.o(168194);
  }
  
  public final void setMuteListener(q paramq)
  {
    this.rSa = paramq;
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.rRZ = paramBoolean;
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.rRB = paramBoolean;
  }
  
  public final void setVideoMatrix(aoz paramaoz)
  {
    this.rTu = paramaoz;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(168191);
    super.setVideoTotalTime(paramInt);
    this.rTz = paramInt;
    AppMethodBeat.o(168191);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.rRA = paramBoolean;
  }
  
  public final void set_isPreviewing(boolean paramBoolean)
  {
    this.rRY = paramBoolean;
  }
  
  public final void start()
  {
    AppMethodBeat.i(168188);
    if (!this.rRA)
    {
      ac.w("Finder.VideoView", "isViewFocused=" + this.rRA);
      AppMethodBeat.o(168188);
      return;
    }
    if (this.rRF == null)
    {
      ac.w("Finder.VideoView", "mediaInfo is null!");
      AppMethodBeat.o(168188);
      return;
    }
    if (this.odZ == null)
    {
      ac.w("Finder.VideoView", "videoView is null!");
      AppMethodBeat.o(168188);
      return;
    }
    if (this.hYu == 3) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(168188);
      return;
    }
    ac.i("Finder.VideoView", "[start#1] isNeverStart=" + this.rRZ + " isViewFocused=" + this.rRA + " isPlaying=false " + getDefaultLog());
    if (!this.rRZ)
    {
      play();
      AppMethodBeat.o(168188);
      return;
    }
    Object localObject1 = this.rRI;
    if (localObject1 != null) {
      ((u)localObject1).cEg();
    }
    if (c(this.rRF))
    {
      localObject1 = this.odZ;
      d.g.b.k.g(localObject1, "videoView");
      localObject1 = ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getVideoPath();
      Object localObject2 = this.rRF;
      if (localObject2 == null) {
        d.g.b.k.fOy();
      }
      if ((d.g.b.k.g(localObject1, ((p)localObject2).path) ^ true))
      {
        localObject1 = this.odZ;
        d.g.b.k.g(localObject1, "videoView");
        localObject2 = this.rRF;
        if (localObject2 == null) {
          d.g.b.k.fOy();
        }
        ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).setVideoPath(((p)localObject2).path);
      }
      this.hYp = null;
      this.hYt = 3;
      this.rTw = 0;
      localObject1 = this.rTv;
      if (localObject1 != null) {
        ((SynchronizedVideoPlayTextureView)localObject1).setIsOnlineVideoType(false);
      }
      boolean bool = play();
      if (!bool)
      {
        localObject1 = this.odZ;
        d.g.b.k.g(localObject1, "videoView");
        localObject1 = (CharSequence)((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getVideoPath();
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label525;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = new StringBuilder("[start] ERROR! videoPath=");
          localObject2 = this.odZ;
          d.g.b.k.g(localObject2, "videoView");
          localObject1 = ((StringBuilder)localObject1).append(((com.tencent.mm.pluginsdk.ui.tools.h)localObject2).getVideoPath()).append(" completedPath=");
          localObject2 = this.rRF;
          if (localObject2 == null) {
            d.g.b.k.fOy();
          }
          ac.e("Finder.VideoView", ((p)localObject2).path);
        }
      }
      localObject1 = new StringBuilder("[start] ret=").append(bool).append(" has download! local path:");
      localObject2 = this.odZ;
      d.g.b.k.g(localObject2, "videoView");
      ac.i("Finder.VideoView", ((com.tencent.mm.pluginsdk.ui.tools.h)localObject2).getVideoPath());
    }
    for (;;)
    {
      oQ(1L + getReportIdkey());
      this.rRZ = false;
      AppMethodBeat.o(168188);
      return;
      label525:
      i = 0;
      break;
      localObject1 = this.rTv;
      if (localObject1 != null) {
        ((SynchronizedVideoPlayTextureView)localObject1).setIsOnlineVideoType(true);
      }
      if ((this.hYp != null) && (this.hYt != 1))
      {
        ac.i("Finder.VideoView", "[start] need to download..." + getDefaultLog());
        showLoading();
        setDownloadStatus(1);
        this.hYp.a((b.a)this);
        this.hYp.q(this.hYq, this.hYr, this.url);
        dOq();
      }
      else
      {
        showLoading();
        if (this.hYp == null) {
          ac.e("Finder.VideoView", "why proxy is null! " + getDefaultLog());
        }
        ac.i("Finder.VideoView", "[start] wait for download..." + getDefaultLog());
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(168182);
    super.stop();
    u localu = this.rRI;
    if (localu != null) {
      localu.b(this.rRF);
    }
    this.rRZ = true;
    this.rRF = null;
    this.rTu = null;
    this.rRA = false;
    this.rTw = 0;
    ac.i("Finder.VideoView", "[stop] " + getDefaultLog() + "  " + "");
    AppMethodBeat.o(168182);
  }
  
  public final void v(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(168200);
    ac.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s isPreparedMoovReadyResult:%s", new Object[] { blf(), Long.valueOf(paramLong), Integer.valueOf(this.hYw), this.hYq, Boolean.valueOf(paramBoolean) });
    if (this.hYw != 0)
    {
      ac.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(168200);
      return;
    }
    eMv();
    try
    {
      if (this.hYv == null)
      {
        ac.w(this.TAG, "%s parser is null, thread is error.", new Object[] { blf() });
        AppMethodBeat.o(168200);
        return;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)localException, "%s deal moov ready error [%s]", new Object[] { blf(), this.hYq });
      AppMethodBeat.o(168200);
      return;
    }
    if ((paramBoolean) || (this.hYv.F(this.hYr, paramLong)))
    {
      f localf = this.hYv;
      d.g.b.k.g(localf, "parser");
      this.hYw = localf.aND();
      ac.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { blf(), Integer.valueOf(this.hYw), this.hYq });
      if (pG(0)) {
        aJl();
      }
      if (this.hYx != -1) {
        break label333;
      }
    }
    label333:
    for (int i = 1;; i = 2)
    {
      this.hYu = i;
      AppMethodBeat.o(168200);
      return;
      ac.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { blf(), this.hYq });
      this.hYp.requestVideoData(this.hYq, 0, -1);
      AppMethodBeat.o(168200);
      return;
    }
  }
  
  public final boolean vn(long paramLong)
  {
    AppMethodBeat.i(203915);
    if (this.hYv == null)
    {
      ac.w(this.TAG, "%s parser is null, thread is error.", new Object[] { blf() });
      AppMethodBeat.o(203915);
      return false;
    }
    boolean bool = this.hYv.F(this.hYr, paramLong);
    AppMethodBeat.o(203915);
    return bool;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/video/FinderVideoView$createVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "setVideoPath", "", "fullFile", "", "stop", "plugin-finder_release"})
  public static final class b
    extends SynchronizedVideoPlayTextureView
  {
    b(Context paramContext1, Context paramContext2)
    {
      super();
    }
    
    public final void setVideoPath(String paramString)
    {
      AppMethodBeat.i(168175);
      ac.i("Finder.VideoView", "[setVideoPath] " + FinderVideoView.a(this.rTC));
      super.setVideoPath(paramString);
      AppMethodBeat.o(168175);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(168174);
      ac.i("Finder.VideoView", "[stop] " + FinderVideoView.a(this.rTC));
      super.stop();
      AppMethodBeat.o(168174);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/video/FinderVideoView$requestAudioFocus$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"})
  public static final class c
    implements d.a
  {
    public final void axj()
    {
      AppMethodBeat.i(168176);
      ac.i("Finder.VideoView", "[audioHelperTool] gain");
      AppMethodBeat.o(168176);
    }
    
    public final void axk()
    {
      AppMethodBeat.i(168178);
      ac.i("Finder.VideoView", "[audioHelperTool] loss");
      AppMethodBeat.o(168178);
    }
    
    public final void axl()
    {
      AppMethodBeat.i(168177);
      ac.i("Finder.VideoView", "[audioHelperTool] lossTransient");
      AppMethodBeat.o(168177);
    }
    
    public final void axm()
    {
      AppMethodBeat.i(168179);
      ac.i("Finder.VideoView", "[audioHelperTool] lossTransientCanDuck");
      AppMethodBeat.o(168179);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoView
 * JD-Core Version:    0.7.0.1
 */