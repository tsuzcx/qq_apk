package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.g.a.ol.a;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.MMVideoView.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.a.i;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.tools.SynchronizedVideoPlayTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoView;", "Lcom/tencent/mm/modelvideo/MMVideoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "firstCacheTimeStep", "", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isViewFocused", "setViewFocused", "lastDownloadStatus", "lastSeconds", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "limitSeconds", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "textureView", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "totalSeconds", "videoMatrix", "Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "getVideoMatrix", "()Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;", "setVideoMatrix", "(Lcom/tencent/mm/protocal/protobuf/FinderViewMatrix;)V", "calcDownloadRange", "playTime", "start", "Lcom/tencent/mm/pointers/PInt;", "end", "checkCanPlay", "checkCompleted", "createMp4Parser", "Lcom/tencent/mm/plugin/Atom/IMp4Parser;", "createVideoFilePath", "", "createVideoView", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView;", "mContext", "getCurrPosSec", "getDefaultLog", "", "getMediaId", "getVideoDurationSec", "getVideoMediaId", "isPlaying", "layoutId", "onCompletion", "onMediaInfoAndMatrixPrepared", "onMoovReady", "mediaId", "moovPos", "", "length", "isPreparedMoovReadyResult", "onPrepareMoovReady", "onProgress", "offset", "total", "onTextureUpdate", "onUIDestroy", "onUIPause", "onUIResume", "pause", "pauseWithCancel", "play", "requestAudioFocus", "reset", "seekTo", "seconds", "", "afterPlay", "time", "afterSeekPlay", "setIMMVideoViewCallback", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setInterceptDetach", "isInterceptDetach", "setLocalVideoMedia", "path", "matrix", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setLoop", "loop", "setMute", "mute", "setVideoMedia", "isLocal", "downloadUrl", "localFinderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setVideoTotalTime", "startOrPlay", "stop", "updateTime", "Companion", "plugin-finder_release"})
public class FinderVideoView
  extends MMVideoView
{
  public static final a qUY;
  private p Lch;
  private boolean Lci;
  private q Lcj;
  private t Lck;
  alw qUN;
  boolean qUO;
  boolean qUP;
  volatile boolean qUQ;
  private SynchronizedVideoPlayTextureView qUR;
  private int qUS;
  private final int qUT;
  private int qUU;
  private int qUV;
  private int qUX;
  private final d qnr;
  
  static
  {
    AppMethodBeat.i(168206);
    qUY = new a((byte)0);
    AppMethodBeat.o(168206);
  }
  
  public FinderVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(168204);
    setReporter((h.c)new h.c()
    {
      public final void ln(long paramAnonymousLong)
      {
        AppMethodBeat.i(168171);
        Object localObject = this.qUZ.getMediaInfo();
        if (localObject != null)
        {
          localObject = ((p)localObject).LcX;
          if (localObject == null) {
            break label384;
          }
          if (paramAnonymousLong < 200L) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, paramAnonymousLong, 1L, false);
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
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 200L, 1L, false);
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
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 204L, 1L, false);
              break;
              if (124L < paramAnonymousLong) {
                break label103;
              }
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 201L, 1L, false);
              break label103;
              if (129L < paramAnonymousLong) {
                break label111;
              }
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 202L, 1L, false);
              break label111;
              if (134L >= paramAnonymousLong) {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 203L, 1L, false);
              }
            }
          }
        }
        label177:
        label227:
        if (160L >= paramAnonymousLong)
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 210L, 1L, false);
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
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 211L, 1L, false);
            break;
            if (150L < paramAnonymousLong) {
              break label265;
            }
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 212L, 1L, false);
            break label265;
            if (155L >= paramAnonymousLong) {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 213L, 1L, false);
            }
          }
          label362:
          if (160L >= paramAnonymousLong) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 214L, 1L, false);
          }
        }
        label265:
        label312:
        label337:
        AppMethodBeat.o(168171);
        label384:
      }
      
      public final void pj(String paramAnonymousString) {}
    });
    this.qUO = true;
    this.qUQ = true;
    this.qnr = d.aqs();
    paramContext = com.tencent.mm.plugin.finder.storage.b.qJA;
    this.qUT = com.tencent.mm.plugin.finder.storage.b.cpG();
    this.qUU = -1;
    this.qUX = 3;
    AppMethodBeat.o(168204);
  }
  
  public FinderVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168205);
    setReporter((h.c)new h.c()
    {
      public final void ln(long paramAnonymousLong)
      {
        AppMethodBeat.i(168171);
        Object localObject = this.qUZ.getMediaInfo();
        if (localObject != null)
        {
          localObject = ((p)localObject).LcX;
          if (localObject == null) {
            break label384;
          }
          if (paramAnonymousLong < 200L) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, paramAnonymousLong, 1L, false);
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
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 200L, 1L, false);
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
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 204L, 1L, false);
              break;
              if (124L < paramAnonymousLong) {
                break label103;
              }
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 201L, 1L, false);
              break label103;
              if (129L < paramAnonymousLong) {
                break label111;
              }
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 202L, 1L, false);
              break label111;
              if (134L >= paramAnonymousLong) {
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 203L, 1L, false);
              }
            }
          }
        }
        label177:
        label227:
        if (160L >= paramAnonymousLong)
        {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 210L, 1L, false);
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
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 211L, 1L, false);
            break;
            if (150L < paramAnonymousLong) {
              break label265;
            }
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 212L, 1L, false);
            break label265;
            if (155L >= paramAnonymousLong) {
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 213L, 1L, false);
            }
          }
          label362:
          if (160L >= paramAnonymousLong) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1302L, 214L, 1L, false);
          }
        }
        label265:
        label312:
        label337:
        AppMethodBeat.o(168171);
        label384:
      }
      
      public final void pj(String paramAnonymousString) {}
    });
    this.qUO = true;
    this.qUQ = true;
    this.qnr = d.aqs();
    paramContext = com.tencent.mm.plugin.finder.storage.b.qJA;
    this.qUT = com.tencent.mm.plugin.finder.storage.b.cpG();
    this.qUU = -1;
    this.qUX = 3;
    AppMethodBeat.o(168205);
  }
  
  private final boolean b(p paramp)
  {
    AppMethodBeat.i(199846);
    if (paramp == null)
    {
      ad.w("Finder.VideoView", "[checkCompleted] mediaInfo is null");
      AppMethodBeat.o(199846);
      return false;
    }
    if (paramp.LcX == null)
    {
      ad.w("Finder.VideoView", "[checkCompleted] localFinderMedia is null");
      AppMethodBeat.o(199846);
      return true;
    }
    Object localObject1 = c.KXF;
    localObject1 = c.dm(paramp.mediaId, true);
    int j = ((r)localObject1).aVm(paramp.path);
    ad.i("Finder.VideoView", "[checkCompleted] isDownloadFinishAndCheckFile=" + j + " cache=" + localObject1 + " path=" + paramp.path + ' ' + getDefaultLog());
    Object localObject2 = MediaPreloadCore.KTA;
    if (MediaPreloadCore.fTP())
    {
      localObject2 = new ol();
      ((ol)localObject2).dtC.mediaId = paramp.LcX.mediaId;
      ((ol)localObject2).dtC.DkS = ((r)localObject1).field_fileFormat;
      ((ol)localObject2).dtC.bfS = ((r)localObject1).field_hasPlayed;
      paramp = ((ol)localObject2).dtC;
      if (j != 0) {
        break label246;
      }
    }
    label246:
    for (int i = (int)(100.0F * (float)((r)localObject1).field_cacheSize / (float)((r)localObject1).field_totalSize);; i = 0)
    {
      paramp.process = i;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
      if (j != 0) {
        break;
      }
      AppMethodBeat.o(199846);
      return true;
    }
    AppMethodBeat.o(199846);
    return false;
  }
  
  private final String getDefaultLog()
  {
    AppMethodBeat.i(168195);
    StringBuilder localStringBuilder = new StringBuilder("videoView=").append(hashCode()).append("->textureView=").append(this.nAZ.hashCode()).append(" mediaId=");
    Object localObject = this.Lch;
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
    this.qnr.a((d.a)new f());
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
  
  public final boolean Cb(long paramLong)
  {
    AppMethodBeat.i(199848);
    if (this.KCd == null)
    {
      ad.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bel() });
      AppMethodBeat.o(199848);
      return false;
    }
    boolean bool = this.KCd.E(this.hxQ, paramLong);
    AppMethodBeat.o(199848);
    return bool;
  }
  
  final void a(String paramString1, String paramString2, String paramString3, bmd parambmd, com.tencent.mm.plugin.finder.loader.l paraml, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(199847);
    this.Lch = new p(paramString1, paramString2, paramString3, parambmd, paraml, paramFinderItem);
    paramString3 = this.Lch;
    if (paramString3 != null)
    {
      if ((parambmd != null) && (parambmd.DJD == true))
      {
        paramString2 = parambmd.qDR;
        if (paramString2 == null) {
          break label153;
        }
      }
      label153:
      for (paramString2 = paramString2.DJV;; paramString2 = null)
      {
        this.qUN = paramString2;
        ad.i("Finder.VideoView", "[setVideoMedia] needCrop, " + this.qUN);
        csh();
        super.c(false, paramString1, 0);
        this.hxQ = paramString3.path;
        this.hxP = paramString3.mediaId;
        ad.i("Finder.VideoView", "[setVideoMedia] " + getDefaultLog());
        AppMethodBeat.o(199847);
        return;
      }
    }
    AppMethodBeat.o(199847);
  }
  
  public final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(168199);
    k.h(paramPInt1, "start");
    k.h(paramPInt2, "end");
    paramPInt1.value = Math.max(paramInt, this.hxZ);
    if (this.hxT == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.qUX;
    }
    this.qUX += this.hye.hyj;
    if (this.hxT == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.hya + 8);
    }
    if ((this.hxT == 3) || (this.hxT == 4))
    {
      paramPInt1.value = this.hxZ;
      paramPInt2.value = (this.hya + paramInt + 1 + this.hye.hyk);
      if (paramPInt2.value < this.hxV / 2.0F) {
        paramPInt2.value = ((int)(this.hxV / 2.0F + 1.0F));
      }
    }
    if (paramPInt2.value >= this.hxV + 1) {
      paramPInt2.value = (this.hxV + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.hye.hyk;
      ad.i("Finder.VideoView", "%s end smaller start calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bel(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.hxT), Integer.valueOf(this.hxZ), Integer.valueOf(this.hya), this.hxP });
      AppMethodBeat.o(168199);
      return true;
    }
    ad.d("Finder.VideoView", "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s] firstCacheTimeStep=%s", new Object[] { bel(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.hxT), Integer.valueOf(this.hxZ), Integer.valueOf(this.hya), this.hxP, Integer.valueOf(this.qUX) });
    AppMethodBeat.o(168199);
    return true;
  }
  
  public final void aCr() {}
  
  public final void beo()
  {
    AppMethodBeat.i(168203);
    super.beo();
    t localt = this.Lck;
    if (localt != null)
    {
      localt.csu();
      AppMethodBeat.o(168203);
      return;
    }
    AppMethodBeat.o(168203);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(199855);
    paramBoolean = super.c(paramDouble, paramBoolean);
    AppMethodBeat.o(199855);
    return paramBoolean;
  }
  
  public final com.tencent.mm.pluginsdk.ui.tools.h cF(final Context paramContext)
  {
    AppMethodBeat.i(168180);
    this.kuZ = 1;
    paramContext = new e(this, paramContext, paramContext);
    paramContext.setIsOnlineVideoType(true);
    paramContext.setNeedResetExtractor(true);
    this.qUR = ((SynchronizedVideoPlayTextureView)paramContext);
    paramContext = this.qUR;
    if (paramContext == null) {
      k.fvU();
    }
    paramContext = (com.tencent.mm.pluginsdk.ui.tools.h)paramContext;
    AppMethodBeat.o(168180);
    return paramContext;
  }
  
  public int csg()
  {
    return 2131493938;
  }
  
  public void csh() {}
  
  public final void csz()
  {
    AppMethodBeat.i(168184);
    ad.i("Finder.VideoView", "[pauseWithCancel] " + getDefaultLog() + " downloadStatus=" + this.hxS + ", isPrepared=" + this.WD);
    this.qUS = this.hxS;
    com.tencent.mm.modelvideo.b localb = this.hxO;
    if (localb != null) {
      localb.fy(getVideoMediaId());
    }
    pause();
    AppMethodBeat.o(168184);
  }
  
  public final com.tencent.mm.plugin.a.p fQM()
  {
    AppMethodBeat.i(199856);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.fUO() == 1)
    {
      localObject = (com.tencent.mm.plugin.a.p)new i();
      AppMethodBeat.o(199856);
      return localObject;
    }
    localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.fUO() == 2)
    {
      localObject = (com.tencent.mm.plugin.a.p)new j();
      AppMethodBeat.o(199856);
      return localObject;
    }
    localObject = (com.tencent.mm.plugin.a.p)new com.tencent.mm.plugin.finder.video.a.a();
    AppMethodBeat.o(199856);
    return localObject;
  }
  
  public final boolean fWp()
  {
    AppMethodBeat.i(199845);
    boolean bool = this.qUQ;
    start();
    AppMethodBeat.o(199845);
    return bool;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(199849);
    int i = super.getCurrPosSec();
    AppMethodBeat.o(199849);
    return i;
  }
  
  public final t getLifecycle()
  {
    return this.Lck;
  }
  
  public String getMediaId()
  {
    Object localObject = this.Lch;
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
    return this.Lch;
  }
  
  public final q getMuteListener()
  {
    return this.Lcj;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(199850);
    int i = super.getVideoDurationSec();
    AppMethodBeat.o(199850);
    return i;
  }
  
  public final alw getVideoMatrix()
  {
    return this.qUN;
  }
  
  public final String getVideoMediaId()
  {
    p localp = this.Lch;
    if (localp != null) {
      return localp.mediaId;
    }
    return null;
  }
  
  public final boolean get_isPreviewing()
  {
    return this.Lci;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(199853);
    boolean bool = super.isPlaying();
    AppMethodBeat.o(199853);
    return bool;
  }
  
  public final void k(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(168196);
    if (!bt.kU(this.hxP, paramString))
    {
      AppMethodBeat.o(168196);
      return;
    }
    ad.i("Finder.VideoView", "%s download  onPlayProgress [%d, %d] pauseByLoadData=%s playStatus=%s", new Object[] { bel(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(this.hxY), Integer.valueOf(this.hxT) });
    if ((this.hxY) && (this.hxT == 3)) {
      oR(getCurrPosSec());
    }
    paramString = MediaPreloadCore.KTA;
    ol localol;
    Object localObject;
    if (MediaPreloadCore.fTP())
    {
      localol = new ol();
      localObject = localol.dtC;
      paramString = this.Lch;
      if (paramString == null) {
        break label244;
      }
      paramString = paramString.LcX;
      if (paramString == null) {
        break label244;
      }
    }
    label244:
    for (paramString = paramString.mediaId;; paramString = null)
    {
      ((ol.a)localObject).mediaId = paramString;
      localol.dtC.process = ((int)(100.0F * (float)paramLong1 / (float)paramLong2));
      paramString = c.KXF;
      paramString = this.Lch;
      if (paramString != null)
      {
        localObject = paramString.mediaId;
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = "";
      }
      paramString = c.dm(paramString, true);
      localol.dtC.DkS = paramString.field_fileFormat;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localol);
      AppMethodBeat.o(168196);
      return;
    }
  }
  
  public final boolean oS(int paramInt)
  {
    AppMethodBeat.i(168197);
    if (this.hxS == 3)
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
      if ((paramInt != 0) || (this.KCd == null)) {
        break label343;
      }
      localPInt4.value = 0;
      localPInt3.value = localPInt4.value;
      bool = this.KCd.b(paramInt + 1, localPInt3, localPInt4);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          PInt localPInt3;
          PInt localPInt4;
          this.hxZ = Math.max(i, this.hxZ);
          ad.i("Finder.VideoView", "ret=%s %s checkCanPlay range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { Boolean.valueOf(bool), bel(), Integer.valueOf(localPInt3.value), Integer.valueOf(localPInt4.value), Integer.valueOf(paramInt), Integer.valueOf(this.hxT), Integer.valueOf(this.hxZ), Integer.valueOf(this.hya), this.hxP });
          AppMethodBeat.o(168197);
          return bool;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        boolean bool = false;
        ad.e(this.TAG, "%s check video data error %s ", new Object[] { bel(), localException1.toString() });
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
      if ((this.hxO != null) && (this.KCd != null) && (this.KCd.a(paramInt, i, localPInt1, localPInt2)))
      {
        bool = this.hxO.isVideoDataAvailable(this.hxP, localPInt1.value, localPInt2.value);
        if (!bool) {}
      }
    }
  }
  
  public final void onCompletion()
  {
    AppMethodBeat.i(190893);
    if (this.Lch != null)
    {
      t localt = this.Lck;
      if (localt != null) {
        localt.fD(getVideoDurationSec(), getVideoDurationSec());
      }
      if (this.hyg)
      {
        localt = this.Lck;
        if (localt != null) {
          localt.csw();
        }
      }
    }
    super.onCompletion();
    AppMethodBeat.o(190893);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(178468);
    super.onUIDestroy();
    this.qUO = false;
    this.Lch = null;
    this.qUN = null;
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
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(199854);
    boolean bool = super.p(paramDouble);
    AppMethodBeat.o(199854);
    return bool;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(168183);
    this.qnr.XF();
    ad.i("Finder.VideoView", "[pause] " + getDefaultLog() + "  " + "");
    t localt = this.Lck;
    if (localt != null) {
      localt.csv();
    }
    boolean bool = super.pause();
    AppMethodBeat.o(168183);
    return bool;
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(168185);
    Object localObject;
    if (!this.qUO)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("[play] unFocused. ").append(getDefaultLog()).append(" mediaId=");
      localObject = this.Lch;
      if (localObject != null) {}
      for (localObject = ((p)localObject).mediaId;; localObject = null)
      {
        ad.i(str, (String)localObject);
        AppMethodBeat.o(168185);
        return false;
      }
    }
    if (this.qUS == 1)
    {
      this.hxS = 1;
      this.qUS = 0;
      localObject = this.hxO;
      if (localObject != null) {
        ((com.tencent.mm.modelvideo.b)localObject).q(getVideoMediaId(), this.hxQ, this.url);
      }
      localObject = this.nAZ;
      k.g(localObject, "videoView");
      int i = ((com.tencent.mm.pluginsdk.ui.tools.h)localObject).getCurrentPosition() / 1000;
      oR(i);
      ad.i("Finder.VideoView", "continue to download... mediaId=" + getVideoMediaId() + " playSec=" + i);
    }
    if ((this.qUO) && (super.play()))
    {
      requestAudioFocus();
      localObject = this.qUR;
      if (localObject != null) {
        ((SynchronizedVideoPlayTextureView)localObject).setOneTimeVideoTextureUpdateCallback((h.e)this);
      }
      localObject = this.Lck;
      if (localObject != null) {
        ((t)localObject).csx();
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
    this.qUX = 3;
    AppMethodBeat.o(168198);
  }
  
  public final void sa(int paramInt)
  {
    AppMethodBeat.i(168190);
    super.sa(paramInt);
    if (this.qUU != paramInt)
    {
      t localt = this.Lck;
      if (localt != null) {
        localt.fD(paramInt, this.qUV);
      }
      this.qUU = paramInt;
    }
    AppMethodBeat.o(168190);
  }
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    AppMethodBeat.i(199851);
    k.h(paramb, "_callback");
    super.setIMMVideoViewCallback(paramb);
    AppMethodBeat.o(199851);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    AppMethodBeat.i(168181);
    SynchronizedVideoPlayTextureView localSynchronizedVideoPlayTextureView = this.qUR;
    if (localSynchronizedVideoPlayTextureView != null)
    {
      localSynchronizedVideoPlayTextureView.setInterceptDetach(paramBoolean);
      AppMethodBeat.o(168181);
      return;
    }
    AppMethodBeat.o(168181);
  }
  
  public final void setLifecycle(t paramt)
  {
    this.Lck = paramt;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(199852);
    super.setLoop(paramBoolean);
    AppMethodBeat.o(199852);
  }
  
  public final void setMediaInfo(p paramp)
  {
    this.Lch = paramp;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(168194);
    super.setMute(paramBoolean);
    AppMethodBeat.o(168194);
  }
  
  public final void setMuteListener(q paramq)
  {
    this.Lcj = paramq;
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.qUQ = paramBoolean;
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.qUP = paramBoolean;
  }
  
  public final void setVideoMatrix(alw paramalw)
  {
    this.qUN = paramalw;
  }
  
  public void setVideoTotalTime(int paramInt)
  {
    AppMethodBeat.i(168191);
    super.setVideoTotalTime(paramInt);
    this.qUV = paramInt;
    AppMethodBeat.o(168191);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.qUO = paramBoolean;
  }
  
  public final void set_isPreviewing(boolean paramBoolean)
  {
    this.Lci = paramBoolean;
  }
  
  public final void start()
  {
    AppMethodBeat.i(168188);
    if (!this.qUO)
    {
      ad.w("Finder.VideoView", "isViewFocused=" + this.qUO);
      AppMethodBeat.o(168188);
      return;
    }
    if (this.Lch == null)
    {
      ad.w("Finder.VideoView", "mediaInfo is null!");
      AppMethodBeat.o(168188);
      return;
    }
    if (this.nAZ == null)
    {
      ad.w("Finder.VideoView", "videoView is null!");
      AppMethodBeat.o(168188);
      return;
    }
    if (this.hxT == 3) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(168188);
      return;
    }
    ad.i("Finder.VideoView", "[start#1] isNeverStart=" + this.qUQ + " isViewFocused=" + this.qUO + " isPlaying=false " + getDefaultLog());
    if (!this.qUQ)
    {
      play();
      AppMethodBeat.o(168188);
      return;
    }
    Object localObject1 = this.Lck;
    if (localObject1 != null) {
      ((t)localObject1).fWu();
    }
    if (b(this.Lch))
    {
      localObject1 = this.nAZ;
      k.g(localObject1, "videoView");
      localObject1 = ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getVideoPath();
      Object localObject2 = this.Lch;
      if (localObject2 == null) {
        k.fvU();
      }
      if ((k.g(localObject1, ((p)localObject2).path) ^ true))
      {
        localObject1 = this.nAZ;
        k.g(localObject1, "videoView");
        localObject2 = this.Lch;
        if (localObject2 == null) {
          k.fvU();
        }
        ((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).setVideoPath(((p)localObject2).path);
      }
      this.hxO = null;
      this.hxS = 3;
      this.qUS = 0;
      localObject1 = this.qUR;
      if (localObject1 != null) {
        ((SynchronizedVideoPlayTextureView)localObject1).setIsOnlineVideoType(false);
      }
      boolean bool = play();
      if (!bool)
      {
        localObject1 = this.nAZ;
        k.g(localObject1, "videoView");
        localObject1 = (CharSequence)((com.tencent.mm.pluginsdk.ui.tools.h)localObject1).getVideoPath();
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label525;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = new StringBuilder("[start] ERROR! videoPath=");
          localObject2 = this.nAZ;
          k.g(localObject2, "videoView");
          localObject1 = ((StringBuilder)localObject1).append(((com.tencent.mm.pluginsdk.ui.tools.h)localObject2).getVideoPath()).append(" completedPath=");
          localObject2 = this.Lch;
          if (localObject2 == null) {
            k.fvU();
          }
          ad.e("Finder.VideoView", ((p)localObject2).path);
        }
      }
      localObject1 = new StringBuilder("[start] ret=").append(bool).append(" has download! local path:");
      localObject2 = this.nAZ;
      k.g(localObject2, "videoView");
      ad.i("Finder.VideoView", ((com.tencent.mm.pluginsdk.ui.tools.h)localObject2).getVideoPath());
    }
    for (;;)
    {
      ln(1L + getReportIdkey());
      this.qUQ = false;
      AppMethodBeat.o(168188);
      return;
      label525:
      i = 0;
      break;
      localObject1 = this.qUR;
      if (localObject1 != null) {
        ((SynchronizedVideoPlayTextureView)localObject1).setIsOnlineVideoType(true);
      }
      if ((this.hxO != null) && (this.hxS != 1))
      {
        ad.i("Finder.VideoView", "[start] need to download..." + getDefaultLog());
        showLoading();
        setDownloadStatus(1);
        this.hxO.a((b.a)this);
        this.hxO.q(this.hxP, this.hxQ, this.url);
        dzT();
      }
      else
      {
        showLoading();
        if (this.hxO == null) {
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
    t localt = this.Lck;
    if (localt != null) {
      localt.a(this.Lch);
    }
    this.qUQ = true;
    this.Lch = null;
    this.qUN = null;
    this.qUO = false;
    this.qUS = 0;
    ad.i("Finder.VideoView", "[stop] " + getDefaultLog() + "  " + "");
    AppMethodBeat.o(168182);
  }
  
  public final void v(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(168200);
    ad.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s isPreparedMoovReadyResult:%s", new Object[] { bel(), Long.valueOf(paramLong), Integer.valueOf(this.hxV), this.hxP, Boolean.valueOf(paramBoolean) });
    if (this.hxV != 0)
    {
      ad.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(168200);
      return;
    }
    exb();
    try
    {
      if (this.KCd == null)
      {
        ad.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bel() });
        AppMethodBeat.o(168200);
        return;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, (Throwable)localException, "%s deal moov ready error [%s]", new Object[] { bel(), this.hxP });
      AppMethodBeat.o(168200);
      return;
    }
    if ((paramBoolean) || (this.KCd.E(this.hxQ, paramLong)))
    {
      com.tencent.mm.plugin.a.p localp = this.KCd;
      k.g(localp, "parser");
      this.hxV = localp.aGR();
      ad.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { bel(), Integer.valueOf(this.hxV), this.hxP });
      if (oR(0)) {
        aCu();
      }
      if (this.hxW != -1) {
        break label333;
      }
    }
    label333:
    for (int i = 1;; i = 2)
    {
      this.hxT = i;
      AppMethodBeat.o(168200);
      return;
      ad.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { bel(), this.hxP });
      this.hxO.requestVideoData(this.hxP, 0, -1);
      AppMethodBeat.o(168200);
      return;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoView$Companion;", "", "()V", "FINDER_VIDEO_VIEW_IDKEY_STAT", "", "_TAG", "", "isDebug", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/video/FinderVideoView$createVideoView$1", "Lcom/tencent/mm/pluginsdk/ui/tools/SynchronizedVideoPlayTextureView;", "setVideoPath", "", "fullFile", "", "stop", "plugin-finder_release"})
  public static final class e
    extends SynchronizedVideoPlayTextureView
  {
    e(Context paramContext1, Context paramContext2)
    {
      super();
    }
    
    public final void setVideoPath(String paramString)
    {
      AppMethodBeat.i(168175);
      ad.i("Finder.VideoView", "[setVideoPath] " + FinderVideoView.a(this.qUZ));
      super.setVideoPath(paramString);
      AppMethodBeat.o(168175);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(168174);
      ad.i("Finder.VideoView", "[stop] " + FinderVideoView.a(this.qUZ));
      super.stop();
      AppMethodBeat.o(168174);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/video/FinderVideoView$requestAudioFocus$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"})
  public static final class f
    implements d.a
  {
    public final void aqt()
    {
      AppMethodBeat.i(168176);
      ad.i("Finder.VideoView", "[audioHelperTool] gain");
      AppMethodBeat.o(168176);
    }
    
    public final void aqu()
    {
      AppMethodBeat.i(168178);
      ad.i("Finder.VideoView", "[audioHelperTool] loss");
      AppMethodBeat.o(168178);
    }
    
    public final void aqv()
    {
      AppMethodBeat.i(168177);
      ad.i("Finder.VideoView", "[audioHelperTool] lossTransient");
      AppMethodBeat.o(168177);
    }
    
    public final void aqw()
    {
      AppMethodBeat.i(168179);
      ad.i("Finder.VideoView", "[audioHelperTool] lossTransientCanDuck");
      AppMethodBeat.o(168179);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoView
 * JD-Core Version:    0.7.0.1
 */