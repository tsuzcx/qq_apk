package com.tencent.mm.plugin.flutter.d;

import android.content.Context;
import android.view.Surface;
import com.tencent.e.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.thumbplayer.b.a;
import com.tencent.thumbplayer.b.b.b;
import com.tencent.thumbplayer.b.b.c;
import com.tencent.thumbplayer.b.b.d;
import com.tencent.thumbplayer.b.b.e;
import com.tencent.thumbplayer.b.b.f;
import com.tencent.thumbplayer.b.b.g;
import com.tencent.thumbplayer.b.b.h;
import com.tencent.thumbplayer.b.p.a;
import d.aa;
import d.g.b.k;
import d.l;
import d.v;
import java.nio.charset.Charset;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer;", "Lcom/tencent/mm/plugin/flutter/video/IVideoPlayer;", "_context", "Landroid/content/Context;", "_path", "", "(Landroid/content/Context;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "cacheFilePath", "getCacheFilePath", "setCacheFilePath", "(Ljava/lang/String;)V", "cdnDownloadProxy", "Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "getCdnDownloadProxy", "()Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "setCdnDownloadProxy", "(Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;)V", "cdnTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getCdnTask", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setCdnTask", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "context", "downloadingMode", "", "getDownloadingMode", "()I", "setDownloadingMode", "(I)V", "isPrepared", "", "()Z", "setPrepared", "(Z)V", "mListener", "Lcom/tencent/mm/plugin/flutter/video/IVideoPlayerEventListener;", "mediaId", "getMediaId", "setMediaId", "mediaPlayer", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "playerState", "getPlayerState", "setPlayerState", "rangeLength", "", "rangeOffset", "url", "addListener", "", "listener", "changeSurface", "_surface", "Landroid/view/Surface;", "getBufferedPercentage", "getCurrPlayMs", "getCurrentPosition", "getDurationMs", "getHeight", "getPlayRate", "", "getVideoPath", "getWidth", "info", "initPlayer", "pause", "prepare", "release", "seek", "mSec", "seekMs", "isPrecision", "setAudioAttributes", "setLooping", "loop", "setMute", "mute", "setPath", "dataSource", "setPlayRate", "rate", "setPlayerCallback", "_callback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "setSurface", "setVolume", "volume", "", "start", "stop", "Companion", "ResourceLoaderProxy", "plugin-flutter_release"})
public final class d
  implements g
{
  public static final d.a smA;
  private static Boolean smz;
  final String TAG;
  boolean Xy;
  private Context context;
  String mediaId;
  private long rangeOffset;
  private a sms;
  private h smt;
  private String smu;
  int smv;
  private int smw;
  private long smx;
  private b smy;
  private String url;
  
  static
  {
    AppMethodBeat.i(209756);
    smA = new d.a((byte)0);
    smz = Boolean.FALSE;
    AppMethodBeat.o(209756);
  }
  
  public d(Context paramContext, String paramString)
  {
    AppMethodBeat.i(209755);
    this.TAG = "MicroMsg.FlutterVideoPlayer";
    this.context = paramContext;
    this.smu = paramString;
    paramContext = smz;
    if (paramContext == null) {
      k.fOy();
    }
    if (!paramContext.booleanValue())
    {
      smz = Boolean.TRUE;
      com.tencent.thumbplayer.b.h.cw(this.context, "60303");
      com.tencent.thumbplayer.b.h.fFe();
      com.tencent.thumbplayer.b.h.fFf();
    }
    this.sms = com.tencent.thumbplayer.b.g.kU(this.context);
    paramContext = this.sms;
    if (paramContext != null) {
      paramContext.a((b.e)new c(this));
    }
    paramContext = this.sms;
    if (paramContext != null) {
      paramContext.a((b.c)new d(this));
    }
    paramContext = this.sms;
    if (paramContext != null) {
      paramContext.a((b.b)new e(this));
    }
    paramContext = this.sms;
    if (paramContext != null) {
      paramContext.a((b.g)new f(this));
    }
    paramContext = this.sms;
    if (paramContext != null) {
      paramContext.a((b.h)new g(this));
    }
    paramContext = this.sms;
    if (paramContext != null)
    {
      paramContext.a((b.d)new h(this));
      AppMethodBeat.o(209755);
      return;
    }
    AppMethodBeat.o(209755);
  }
  
  public final void a(h paramh)
  {
    this.smt = paramh;
  }
  
  public final boolean cIc()
  {
    AppMethodBeat.i(209742);
    Object localObject1 = this.mediaId;
    if (localObject1 == null) {
      k.fOy();
    }
    Object localObject2 = this.smu;
    if (localObject2 == null) {
      k.fOy();
    }
    this.smy = new b((String)localObject1, (String)localObject2);
    localObject1 = this.sms;
    if (localObject1 != null) {
      ((a)localObject1).a((b.f)this.smy);
    }
    ac.d(this.TAG, "video_status prepare url: " + this.url + ", media:" + this.mediaId);
    if (this.smv < 3)
    {
      localObject1 = e.smI.cIf().smF.aeX(this.mediaId);
      localObject2 = new p.a();
      ((p.a)localObject2).aTJ(this.mediaId);
      ((p.a)localObject2).a(new com.tencent.thumbplayer.b.b.b((byte)0));
      a locala = this.sms;
      if (locala != null) {
        locala.a(((p.a)localObject2).fFh());
      }
      if ((localObject1 == null) || (!((b.a)localObject1).bhc))
      {
        localObject1 = this.sms;
        if (localObject1 != null) {
          ((a)localObject1).setDataSource(this.url);
        }
        localObject1 = this.sms;
        if (localObject1 != null) {
          ((a)localObject1).prepareAsync();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(209742);
      return true;
      localObject2 = this.sms;
      if (localObject2 == null) {
        break;
      }
      ((a)localObject2).setDataSource(((b.a)localObject1).path);
      break;
      ac.d(this.TAG, "video_status prepare playerState " + this.smv + ' ');
    }
  }
  
  public final int getBufferedPercentage()
  {
    Long localLong2 = null;
    AppMethodBeat.i(209752);
    b.a locala = e.smI.cIf().smF.aeX(this.mediaId);
    if (locala != null) {}
    for (Long localLong1 = Long.valueOf(locala.cacheSize);; localLong1 = null)
    {
      if (locala != null) {
        localLong2 = Long.valueOf(locala.mSs);
      }
      if (localLong1 == null) {
        k.fOy();
      }
      if (localLong1.longValue() <= 0L) {
        break;
      }
      if (localLong2 == null) {
        k.fOy();
      }
      if (localLong2.longValue() <= 0L) {
        break;
      }
      int i = (int)(localLong1.longValue() * 100L / localLong2.longValue());
      AppMethodBeat.o(209752);
      return i;
    }
    AppMethodBeat.o(209752);
    return 0;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(209741);
    a locala = this.sms;
    if (locala != null)
    {
      long l = locala.getCurrentPositionMs();
      AppMethodBeat.o(209741);
      return l;
    }
    AppMethodBeat.o(209741);
    return 0L;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(209747);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("getDurationMs: ");
    Object localObject = this.sms;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((a)localObject).getDurationMs());; localObject = null)
    {
      ac.d(str, localObject);
      localObject = this.sms;
      if (localObject == null) {
        break;
      }
      long l = ((a)localObject).getDurationMs();
      AppMethodBeat.o(209747);
      return l;
    }
    AppMethodBeat.o(209747);
    return 0L;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(209745);
    a locala = this.sms;
    if (locala != null)
    {
      int i = locala.getVideoHeight();
      AppMethodBeat.o(209745);
      return i;
    }
    AppMethodBeat.o(209745);
    return 0;
  }
  
  public final String getVideoPath()
  {
    return this.url;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(209748);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("getWidth ").append(this.sms).append("  ");
    a locala = this.sms;
    if (locala != null) {}
    for (int i = locala.getVideoWidth();; i = 0)
    {
      ac.d((String)localObject, i);
      localObject = this.sms;
      if (localObject == null) {
        break;
      }
      i = ((a)localObject).getVideoWidth();
      AppMethodBeat.o(209748);
      return i;
    }
    AppMethodBeat.o(209748);
    return 0;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(209746);
    ac.d(this.TAG, "video_status pause " + this.sms + ", mediaId:" + this.mediaId + ", url:" + this.url);
    a locala = this.sms;
    if (locala != null) {
      locala.pause();
    }
    locala = this.sms;
    if (locala != null)
    {
      locala.pauseDownload();
      AppMethodBeat.o(209746);
      return;
    }
    AppMethodBeat.o(209746);
  }
  
  public final void release()
  {
    AppMethodBeat.i(209754);
    ac.d(this.TAG, "video_status release " + this.sms + " , url: " + this.url);
    a locala = this.sms;
    if (locala != null) {
      locala.setSurface(null);
    }
    locala = this.sms;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(209754);
      return;
    }
    AppMethodBeat.o(209754);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(209740);
    ac.i(this.TAG, "video_status seek " + this.sms + ", state: " + this.smv);
    if (this.smv < 4)
    {
      ac.e(this.TAG, "video_status wrong seek");
      AppMethodBeat.o(209740);
      return;
    }
    a locala = this.sms;
    if (locala != null) {
      locala.fFd();
    }
    locala = this.sms;
    if (locala != null)
    {
      locala.seekTo(paramInt);
      AppMethodBeat.o(209740);
      return;
    }
    AppMethodBeat.o(209740);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(209749);
    a locala = this.sms;
    if (locala != null)
    {
      locala.yI(paramBoolean);
      AppMethodBeat.o(209749);
      return;
    }
    AppMethodBeat.o(209749);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(209753);
    ac.d(this.TAG, "setPath mediaId:" + this.mediaId + " dataSource:" + paramString + ' ');
    this.url = paramString;
    paramString = this.url;
    if (paramString != null)
    {
      Charset localCharset = d.n.d.UTF_8;
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(209753);
        throw paramString;
      }
      paramString = paramString.getBytes(localCharset);
      k.g(paramString, "(this as java.lang.String).getBytes(charset)");
    }
    for (;;)
    {
      this.mediaId = com.tencent.mm.b.g.getMessageDigest(paramString);
      AppMethodBeat.o(209753);
      return;
      paramString = null;
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(209750);
    Object localObject = this.TAG;
    if (paramSurface != null) {}
    for (int i = paramSurface.hashCode();; i = 0)
    {
      ac.d((String)localObject, "setSurface %s", new Object[] { Integer.valueOf(i) });
      localObject = this.sms;
      if (localObject == null) {
        break;
      }
      ((a)localObject).setSurface(paramSurface);
      AppMethodBeat.o(209750);
      return;
    }
    AppMethodBeat.o(209750);
  }
  
  public final void start()
  {
    AppMethodBeat.i(209743);
    ac.d(this.TAG, "video_status play " + this.sms + ", mediaId:" + this.mediaId + ", download: " + this.smw + " state:" + this.smv + " : " + this.url);
    if (this.smv == 5)
    {
      ac.d(this.TAG, "video_status already playing " + this.sms);
      AppMethodBeat.o(209743);
      return;
    }
    if (this.smv >= 4) {}
    for (int i = 1; (aa.KTq) && (i == 0); i = 0)
    {
      localObject = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(209743);
      throw ((Throwable)localObject);
    }
    Object localObject = this.sms;
    if (localObject != null) {
      ((a)localObject).fFd();
    }
    localObject = this.sms;
    if (localObject != null)
    {
      ((a)localObject).start();
      AppMethodBeat.o(209743);
      return;
    }
    AppMethodBeat.o(209743);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(209751);
    ac.d(this.TAG, "video_status stop: " + this.sms + " , url: " + this.url);
    a locala = this.sms;
    if (locala != null)
    {
      locala.stop();
      AppMethodBeat.o(209751);
      return;
    }
    AppMethodBeat.o(209751);
  }
  
  public final void u(double paramDouble)
  {
    AppMethodBeat.i(209744);
    ac.d(this.TAG, "setVolume");
    a locala = this.sms;
    if (locala != null)
    {
      locala.cd((float)paramDouble);
      AppMethodBeat.o(209744);
      return;
    }
    AppMethodBeat.o(209744);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnResourceLoaderListener;", "mediaId", "", "path", "(Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer;Ljava/lang/String;Ljava/lang/String;)V", "acacheSize", "", "getAcacheSize", "()J", "setAcacheSize", "(J)V", "getMediaId", "()Ljava/lang/String;", "getPath", "getContentType", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "taskId", "fileKey", "getDataFilePath", "getDataTotalSize", "onReadData", "", "offset", "length", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "plugin-flutter_release"})
  public final class b
    implements b.f
  {
    private final String mediaId;
    private final String path;
    private long smB;
    
    public b(String paramString)
    {
      AppMethodBeat.i(209733);
      this.mediaId = paramString;
      this.path = localObject;
      AppMethodBeat.o(209733);
    }
    
    public final int a(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(209730);
      ac.d(d.this.TAG, "[onStopReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " taskId: " + paramLong);
      AppMethodBeat.o(209730);
      return 0;
    }
    
    public final int a(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(209728);
      ac.d(d.this.TAG, "[onStartReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " taskId: " + paramLong1);
      int i = this.mediaId.hashCode();
      AppMethodBeat.o(209728);
      return i;
    }
    
    public final int b(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(209729);
      ac.d(d.this.TAG, "[onReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " taskId: " + paramLong1 + " state:" + d.this.smv);
      if (paramLong3 <= 0L)
      {
        ac.d(d.this.TAG, "FVPlayer onReadDate 0");
        AppMethodBeat.o(209729);
        return 0;
      }
      paramString = e.smI.cIf().smF.aeX(this.mediaId);
      if ((paramString != null) && (this.smB != paramString.cacheSize))
      {
        this.smB = paramString.cacheSize;
        com.tencent.e.h.JZN.aQ((Runnable)new a(this));
      }
      int i;
      if ((paramString != null) && (paramString.bhc))
      {
        ac.d(d.this.TAG, "onreaddata completed");
        i = (int)paramLong3;
        AppMethodBeat.o(209729);
        return i;
      }
      boolean bool1;
      if (d.this.smv != 6)
      {
        bool1 = CdnLogic.taskExist(this.mediaId);
        if (bool1)
        {
          boolean bool2 = CdnLogic.isVideoDataAvailable(this.mediaId, paramLong2, paramLong3);
          if (bool2)
          {
            ac.d(d.this.TAG, "FVPlayer onReadData isVideoDataAvailable " + bool2 + " offset:" + paramLong2 + " length:" + paramLong3 + " mediaId" + this.mediaId);
            i = (int)paramLong3;
            AppMethodBeat.o(209729);
            return i;
          }
        }
      }
      for (;;)
      {
        if ((d.this.smv != 3) && (d.this.smv != 5))
        {
          ac.v(d.this.TAG, "not in need data state, ignore, state:" + d.this.smv + ", media:" + this.mediaId);
          AppMethodBeat.o(209729);
          return 0;
        }
        String str;
        StringBuilder localStringBuilder;
        if (d.this.smv == 3)
        {
          if (paramString != null) {}
          for (parama = Long.valueOf(paramString.smj);; parama = null)
          {
            if (parama == null) {
              k.fOy();
            }
            if (parama.longValue() < paramLong2 + paramLong3) {
              break;
            }
            ac.v(d.this.TAG, "onreaddata preload enough: " + this.mediaId);
            i = (int)paramLong3;
            AppMethodBeat.o(209729);
            return i;
          }
          if (bool1)
          {
            if (paramString != null) {
              parama = Boolean.valueOf(paramString.sml);
            }
            for (;;)
            {
              if (parama.booleanValue()) {
                if ((d.c(d.this) == paramLong2) && (d.d(d.this) == paramLong3))
                {
                  ac.d(d.this.TAG, "range(" + paramLong2 + ", " + paramLong3 + ") is already requesting");
                  AppMethodBeat.o(209729);
                  return 0;
                  parama = null;
                }
                else
                {
                  i = e.smI.cIf().smG.x(this.mediaId, paramLong2, paramLong3);
                  if (i != 0)
                  {
                    str = d.this.TAG;
                    localStringBuilder = new StringBuilder("[key] request video data error ").append(this.mediaId).append(", ret:").append(i).append(" state:").append(d.this.smv).append(" exists:").append(bool1).append(", offset:").append(paramLong2).append(", length:").append(paramLong3).append(", cache:");
                    if (paramString != null)
                    {
                      parama = Long.valueOf(paramString.cacheSize);
                      ac.e(str, parama.longValue());
                      e.smI.cIf().smF.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong2 + paramLong3));
                      d.b(d.this, 0L);
                    }
                  }
                }
              }
            }
          }
          label903:
          for (;;)
          {
            ac.d(d.this.TAG, "onreaddata need more: " + this.mediaId);
            AppMethodBeat.o(209729);
            return 0;
            parama = null;
            break;
            d.a(d.this, paramLong2);
            d.b(d.this, paramLong3);
            continue;
            if (paramString != null) {}
            for (parama = Boolean.valueOf(paramString.smk);; parama = null)
            {
              if (parama.booleanValue()) {
                break label903;
              }
              e.smI.cIf().smF.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong2 + paramLong3));
              break;
            }
          }
        }
        if (d.this.smv == 5)
        {
          if ((d.c(d.this) == paramLong2) && (d.d(d.this) == paramLong3))
          {
            ac.d(d.this.TAG, "range(" + paramLong2 + ", " + paramLong3 + ") is already requesting");
            AppMethodBeat.o(209729);
            return 0;
          }
          i = e.smI.cIf().smG.x(this.mediaId, paramLong2, paramLong3);
          if (i != 0)
          {
            str = d.this.TAG;
            localStringBuilder = new StringBuilder("onreaddata request more data ret:").append(i).append(" state:").append(d.this.smv).append(' ').append(this.mediaId).append(", ret:").append(i).append(", exists:").append(bool1).append(", offset:").append(paramLong2).append(", length:").append(paramLong3).append(", cache:");
            if (paramString != null)
            {
              parama = Long.valueOf(paramString.cacheSize);
              ac.d(str, parama);
              e.smI.cIf().smF.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong2 + paramLong3));
              d.b(d.this, 0L);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(209729);
            return 0;
            parama = null;
            break;
            d.a(d.this, paramLong2);
            d.b(d.this, paramLong3);
          }
        }
        AppMethodBeat.o(209729);
        return 0;
        bool1 = false;
      }
    }
    
    public final long b(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(209731);
      parama = e.smI.cIf().smF.aeX(this.mediaId);
      if (parama != null) {}
      for (parama = Long.valueOf(parama.mSs);; parama = null)
      {
        if (parama == null) {
          k.fOy();
        }
        paramLong = parama.longValue();
        AppMethodBeat.o(209731);
        return paramLong;
      }
    }
    
    public final String c(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(209732);
      parama = e.smI.cIf().smF.aeX(this.mediaId);
      if (parama != null) {}
      for (parama = parama.path;; parama = null)
      {
        if (parama == null) {
          k.fOy();
        }
        ac.d(d.this.TAG, "[getDataFilePath] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " taskId: " + paramLong + ", path: " + parama);
        AppMethodBeat.o(209732);
        return parama;
      }
    }
    
    public final String d(a parama, long paramLong, String paramString)
    {
      return "video/mp4";
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(d.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(209727);
        h localh = d.b(this.smD.smC);
        if (localh != null)
        {
          localh.e(false, 2);
          AppMethodBeat.o(209727);
          return;
        }
        AppMethodBeat.o(209727);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class c
    implements b.e
  {
    c(d paramd) {}
    
    public final void a(a parama)
    {
      AppMethodBeat.i(209734);
      ac.i(this.smC.TAG, "FVPlayer video_status " + parama + " prepared");
      this.smC.Xy = true;
      parama = d.b(this.smC);
      if (parama != null) {
        parama.e(false, 3);
      }
      com.tencent.mm.plugin.report.service.h.wUl.dB(1414, 0);
      AppMethodBeat.o(209734);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "errorType", "", "errorCode", "arg1", "", "arg2", "onError"})
  static final class d
    implements b.c
  {
    d(d paramd) {}
    
    public final void a(a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(209735);
      ac.e(this.smC.TAG, "tplayer log " + parama + " error " + paramInt1 + ' ' + paramInt2);
      parama = d.b(this.smC);
      if (parama != null) {
        parama.d(paramInt2, paramInt1, "视频加载失败，请检查网络连接后重试", "重试");
      }
      com.tencent.mm.plugin.report.service.h.wUl.dB(1414, 1);
      AppMethodBeat.o(209735);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class e
    implements b.b
  {
    e(d paramd) {}
    
    public final void b(a parama)
    {
      AppMethodBeat.i(209736);
      ac.i(this.smC.TAG, parama + " on complete");
      parama = d.b(this.smC);
      if (parama != null)
      {
        parama.e(false, 4);
        AppMethodBeat.o(209736);
        return;
      }
      AppMethodBeat.o(209736);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class f
    implements b.g
  {
    f(d paramd) {}
    
    public final void c(a parama)
    {
      AppMethodBeat.i(209737);
      ac.i(this.smC.TAG, parama + " on seek");
      AppMethodBeat.o(209737);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "preState", "", "curState", "onStateChange"})
  static final class g
    implements b.h
  {
    g(d paramd) {}
    
    public final void fI(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209738);
      ac.i(this.smC.TAG, d.a(this.smC) + " prestate: " + paramInt1 + ", curState: " + paramInt2);
      this.smC.smv = paramInt2;
      switch (paramInt2)
      {
      }
      h localh;
      do
      {
        AppMethodBeat.o(209738);
        return;
        localh = d.b(this.smC);
      } while (localh == null);
      localh.e(false, 5);
      AppMethodBeat.o(209738);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "what", "", "arg1", "", "arg2", "extraObject", "", "onInfo"})
  static final class h
    implements b.d
  {
    h(d paramd) {}
    
    public final void a(a parama, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(209739);
      ac.i(this.smC.TAG, "tplayer log " + parama + ", msg:" + paramInt);
      switch (paramInt)
      {
      }
      do
      {
        AppMethodBeat.o(209739);
        return;
        ac.i(this.smC.TAG, "video_status need buffer: " + parama + " mediaId:" + this.smC.mediaId);
        parama = d.b(this.smC);
        if (parama != null)
        {
          parama.e(false, 7);
          AppMethodBeat.o(209739);
          return;
        }
        AppMethodBeat.o(209739);
        return;
        ac.i(this.smC.TAG, "video_status buffer ok: ".concat(String.valueOf(parama)));
        parama = d.b(this.smC);
      } while (parama == null);
      parama.e(false, 8);
      AppMethodBeat.o(209739);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.d
 * JD-Core Version:    0.7.0.1
 */