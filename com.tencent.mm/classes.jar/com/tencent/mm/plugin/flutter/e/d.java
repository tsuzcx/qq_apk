package com.tencent.mm.plugin.flutter.e;

import android.content.Context;
import android.view.Surface;
import com.tencent.e.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.thumbplayer.b.a;
import com.tencent.thumbplayer.b.b.b;
import com.tencent.thumbplayer.b.b.c;
import com.tencent.thumbplayer.b.b.d;
import com.tencent.thumbplayer.b.b.e;
import com.tencent.thumbplayer.b.b.f;
import com.tencent.thumbplayer.b.b.g;
import com.tencent.thumbplayer.b.b.h;
import com.tencent.thumbplayer.b.p.a;
import d.ac;
import d.g.b.p;
import d.l;
import d.v;
import java.nio.charset.Charset;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer;", "Lcom/tencent/mm/plugin/flutter/video/IVideoPlayer;", "_context", "Landroid/content/Context;", "_path", "", "(Landroid/content/Context;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "cacheFilePath", "getCacheFilePath", "setCacheFilePath", "(Ljava/lang/String;)V", "cdnDownloadProxy", "Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "getCdnDownloadProxy", "()Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "setCdnDownloadProxy", "(Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;)V", "cdnTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getCdnTask", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setCdnTask", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "context", "downloadingMode", "", "getDownloadingMode", "()I", "setDownloadingMode", "(I)V", "isPrepared", "", "()Z", "setPrepared", "(Z)V", "mListener", "Lcom/tencent/mm/plugin/flutter/video/IVideoPlayerEventListener;", "mediaId", "getMediaId", "setMediaId", "mediaPlayer", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "playerState", "getPlayerState", "setPlayerState", "rangeLength", "", "rangeOffset", "url", "addListener", "", "listener", "changeSurface", "_surface", "Landroid/view/Surface;", "getBufferedPercentage", "getCurrPlayMs", "getCurrentPosition", "getDurationMs", "getHeight", "getPlayRate", "", "getVideoPath", "getWidth", "info", "initPlayer", "pause", "prepare", "release", "seek", "mSec", "seekMs", "isPrecision", "setAudioAttributes", "setLooping", "loop", "setMute", "mute", "setPath", "dataSource", "setPlayRate", "rate", "setPlayerCallback", "_callback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "setSurface", "setVolume", "volume", "", "start", "stop", "Companion", "ResourceLoaderProxy", "plugin-flutter_release"})
public final class d
  implements g
{
  private static Boolean ttV;
  public static final d.a ttW;
  final String TAG;
  boolean Zn;
  private Context context;
  String mediaId;
  private long rangeOffset;
  private a ttO;
  private h ttP;
  private String ttQ;
  int ttR;
  private int ttS;
  private long ttT;
  private b ttU;
  private String url;
  
  static
  {
    AppMethodBeat.i(213515);
    ttW = new d.a((byte)0);
    ttV = Boolean.FALSE;
    AppMethodBeat.o(213515);
  }
  
  public d(Context paramContext, String paramString)
  {
    AppMethodBeat.i(213514);
    this.TAG = "MicroMsg.FlutterVideoPlayer";
    this.context = paramContext;
    this.ttQ = paramString;
    paramContext = ttV;
    if (paramContext == null) {
      p.gkB();
    }
    if (!paramContext.booleanValue())
    {
      ttV = Boolean.TRUE;
      com.tencent.thumbplayer.b.h.cC(this.context, "60303");
      com.tencent.thumbplayer.b.h.gaU();
      com.tencent.thumbplayer.b.h.gaV();
    }
    this.ttO = com.tencent.thumbplayer.b.g.ln(this.context);
    paramContext = this.ttO;
    if (paramContext != null) {
      paramContext.a((b.e)new c(this));
    }
    paramContext = this.ttO;
    if (paramContext != null) {
      paramContext.a((b.c)new d(this));
    }
    paramContext = this.ttO;
    if (paramContext != null) {
      paramContext.a((b.b)new e(this));
    }
    paramContext = this.ttO;
    if (paramContext != null) {
      paramContext.a((b.g)new f(this));
    }
    paramContext = this.ttO;
    if (paramContext != null) {
      paramContext.a((b.h)new g(this));
    }
    paramContext = this.ttO;
    if (paramContext != null)
    {
      paramContext.a((b.d)new h(this));
      AppMethodBeat.o(213514);
      return;
    }
    AppMethodBeat.o(213514);
  }
  
  public final void a(h paramh)
  {
    this.ttP = paramh;
  }
  
  public final boolean cSW()
  {
    AppMethodBeat.i(213501);
    Object localObject1 = this.mediaId;
    if (localObject1 == null) {
      p.gkB();
    }
    Object localObject2 = this.ttQ;
    if (localObject2 == null) {
      p.gkB();
    }
    this.ttU = new b((String)localObject1, (String)localObject2);
    localObject1 = this.ttO;
    if (localObject1 != null) {
      ((a)localObject1).a((b.f)this.ttU);
    }
    ae.d(this.TAG, "video_status prepare url: " + this.url + ", media:" + this.mediaId);
    if (this.ttR < 3)
    {
      localObject1 = e.tue.cSZ().tub.akt(this.mediaId);
      localObject2 = new p.a();
      ((p.a)localObject2).bbm(this.mediaId);
      ((p.a)localObject2).a(new com.tencent.thumbplayer.b.b.b((byte)0));
      a locala = this.ttO;
      if (locala != null) {
        locala.a(((p.a)localObject2).gaX());
      }
      if ((localObject1 == null) || (!((b.a)localObject1).brw))
      {
        localObject1 = this.ttO;
        if (localObject1 != null) {
          ((a)localObject1).setDataSource(this.url);
        }
        localObject1 = this.ttO;
        if (localObject1 != null) {
          ((a)localObject1).prepareAsync();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(213501);
      return true;
      localObject2 = this.ttO;
      if (localObject2 == null) {
        break;
      }
      ((a)localObject2).setDataSource(((b.a)localObject1).path);
      break;
      ae.d(this.TAG, "video_status prepare playerState " + this.ttR + ' ');
    }
  }
  
  public final int getBufferedPercentage()
  {
    Long localLong2 = null;
    AppMethodBeat.i(213511);
    b.a locala = e.tue.cSZ().tub.akt(this.mediaId);
    if (locala != null) {}
    for (Long localLong1 = Long.valueOf(locala.cacheSize);; localLong1 = null)
    {
      if (locala != null) {
        localLong2 = Long.valueOf(locala.nyl);
      }
      if (localLong1 == null) {
        p.gkB();
      }
      if (localLong1.longValue() <= 0L) {
        break;
      }
      if (localLong2 == null) {
        p.gkB();
      }
      if (localLong2.longValue() <= 0L) {
        break;
      }
      int i = (int)(localLong1.longValue() * 100L / localLong2.longValue());
      AppMethodBeat.o(213511);
      return i;
    }
    AppMethodBeat.o(213511);
    return 0;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(213500);
    a locala = this.ttO;
    if (locala != null)
    {
      long l = locala.getCurrentPositionMs();
      AppMethodBeat.o(213500);
      return l;
    }
    AppMethodBeat.o(213500);
    return 0L;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(213506);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("getDurationMs: ");
    Object localObject = this.ttO;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((a)localObject).getDurationMs());; localObject = null)
    {
      ae.d(str, localObject);
      localObject = this.ttO;
      if (localObject == null) {
        break;
      }
      long l = ((a)localObject).getDurationMs();
      AppMethodBeat.o(213506);
      return l;
    }
    AppMethodBeat.o(213506);
    return 0L;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(213504);
    a locala = this.ttO;
    if (locala != null)
    {
      int i = locala.getVideoHeight();
      AppMethodBeat.o(213504);
      return i;
    }
    AppMethodBeat.o(213504);
    return 0;
  }
  
  public final String getVideoPath()
  {
    return this.url;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(213507);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("getWidth ").append(this.ttO).append("  ");
    a locala = this.ttO;
    if (locala != null) {}
    for (int i = locala.getVideoWidth();; i = 0)
    {
      ae.d((String)localObject, i);
      localObject = this.ttO;
      if (localObject == null) {
        break;
      }
      i = ((a)localObject).getVideoWidth();
      AppMethodBeat.o(213507);
      return i;
    }
    AppMethodBeat.o(213507);
    return 0;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(213505);
    ae.d(this.TAG, "video_status pause " + this.ttO + ", mediaId:" + this.mediaId + ", url:" + this.url);
    a locala = this.ttO;
    if (locala != null) {
      locala.pause();
    }
    locala = this.ttO;
    if (locala != null)
    {
      locala.pauseDownload();
      AppMethodBeat.o(213505);
      return;
    }
    AppMethodBeat.o(213505);
  }
  
  public final void release()
  {
    AppMethodBeat.i(213513);
    ae.d(this.TAG, "video_status release " + this.ttO + " , url: " + this.url);
    a locala = this.ttO;
    if (locala != null) {
      locala.setSurface(null);
    }
    locala = this.ttO;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(213513);
      return;
    }
    AppMethodBeat.o(213513);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(213499);
    ae.i(this.TAG, "video_status seek " + this.ttO + ", state: " + this.ttR);
    if (this.ttR < 4)
    {
      ae.e(this.TAG, "video_status wrong seek");
      AppMethodBeat.o(213499);
      return;
    }
    a locala = this.ttO;
    if (locala != null) {
      locala.gaT();
    }
    locala = this.ttO;
    if (locala != null)
    {
      locala.seekTo(paramInt);
      AppMethodBeat.o(213499);
      return;
    }
    AppMethodBeat.o(213499);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(213508);
    a locala = this.ttO;
    if (locala != null)
    {
      locala.zJ(paramBoolean);
      AppMethodBeat.o(213508);
      return;
    }
    AppMethodBeat.o(213508);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(213512);
    ae.d(this.TAG, "setPath mediaId:" + this.mediaId + " dataSource:" + paramString + ' ');
    this.url = paramString;
    paramString = this.url;
    if (paramString != null)
    {
      Charset localCharset = d.n.d.UTF_8;
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(213512);
        throw paramString;
      }
      paramString = paramString.getBytes(localCharset);
      p.g(paramString, "(this as java.lang.String).getBytes(charset)");
    }
    for (;;)
    {
      this.mediaId = com.tencent.mm.b.g.getMessageDigest(paramString);
      AppMethodBeat.o(213512);
      return;
      paramString = null;
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(213509);
    Object localObject = this.TAG;
    if (paramSurface != null) {}
    for (int i = paramSurface.hashCode();; i = 0)
    {
      ae.d((String)localObject, "setSurface %s", new Object[] { Integer.valueOf(i) });
      localObject = this.ttO;
      if (localObject == null) {
        break;
      }
      ((a)localObject).setSurface(paramSurface);
      AppMethodBeat.o(213509);
      return;
    }
    AppMethodBeat.o(213509);
  }
  
  public final void start()
  {
    AppMethodBeat.i(213502);
    ae.d(this.TAG, "video_status play " + this.ttO + ", mediaId:" + this.mediaId + ", download: " + this.ttS + " state:" + this.ttR + " : " + this.url);
    if (this.ttR == 5)
    {
      ae.d(this.TAG, "video_status already playing " + this.ttO);
      AppMethodBeat.o(213502);
      return;
    }
    if (this.ttR >= 4) {}
    for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
    {
      localObject = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(213502);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ttO;
    if (localObject != null) {
      ((a)localObject).gaT();
    }
    localObject = this.ttO;
    if (localObject != null)
    {
      ((a)localObject).start();
      AppMethodBeat.o(213502);
      return;
    }
    AppMethodBeat.o(213502);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(213510);
    ae.d(this.TAG, "video_status stop: " + this.ttO + " , url: " + this.url);
    a locala = this.ttO;
    if (locala != null)
    {
      locala.stop();
      AppMethodBeat.o(213510);
      return;
    }
    AppMethodBeat.o(213510);
  }
  
  public final void u(double paramDouble)
  {
    AppMethodBeat.i(213503);
    ae.d(this.TAG, "setVolume");
    a locala = this.ttO;
    if (locala != null)
    {
      locala.cg((float)paramDouble);
      AppMethodBeat.o(213503);
      return;
    }
    AppMethodBeat.o(213503);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnResourceLoaderListener;", "mediaId", "", "path", "(Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer;Ljava/lang/String;Ljava/lang/String;)V", "acacheSize", "", "getAcacheSize", "()J", "setAcacheSize", "(J)V", "getMediaId", "()Ljava/lang/String;", "getPath", "getContentType", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "taskId", "fileKey", "getDataFilePath", "getDataTotalSize", "onReadData", "", "offset", "length", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "plugin-flutter_release"})
  public final class b
    implements b.f
  {
    private final String mediaId;
    private final String path;
    private long ttX;
    
    public b(String paramString)
    {
      AppMethodBeat.i(213492);
      this.mediaId = paramString;
      this.path = localObject;
      AppMethodBeat.o(213492);
    }
    
    public final int a(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(213489);
      ae.d(d.this.TAG, "[onStopReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " taskId: " + paramLong);
      AppMethodBeat.o(213489);
      return 0;
    }
    
    public final int a(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(213487);
      ae.d(d.this.TAG, "[onStartReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " taskId: " + paramLong1);
      int i = this.mediaId.hashCode();
      AppMethodBeat.o(213487);
      return i;
    }
    
    public final int b(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(213488);
      ae.d(d.this.TAG, "[onReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " taskId: " + paramLong1 + " state:" + d.this.ttR);
      if (paramLong3 <= 0L)
      {
        ae.d(d.this.TAG, "FVPlayer onReadDate 0");
        AppMethodBeat.o(213488);
        return 0;
      }
      paramString = e.tue.cSZ().tub.akt(this.mediaId);
      if ((paramString != null) && (this.ttX != paramString.cacheSize))
      {
        this.ttX = paramString.cacheSize;
        com.tencent.e.h.MqF.aM((Runnable)new a(this));
      }
      int i;
      if ((paramString != null) && (paramString.brw))
      {
        ae.d(d.this.TAG, "onreaddata completed");
        i = (int)paramLong3;
        AppMethodBeat.o(213488);
        return i;
      }
      boolean bool1;
      if (d.this.ttR != 6)
      {
        bool1 = CdnLogic.taskExist(this.mediaId);
        if (bool1)
        {
          boolean bool2 = CdnLogic.isVideoDataAvailable(this.mediaId, paramLong2, paramLong3);
          if (bool2)
          {
            ae.d(d.this.TAG, "FVPlayer onReadData isVideoDataAvailable " + bool2 + " offset:" + paramLong2 + " length:" + paramLong3 + " mediaId" + this.mediaId);
            i = (int)paramLong3;
            AppMethodBeat.o(213488);
            return i;
          }
        }
      }
      for (;;)
      {
        if ((d.this.ttR != 3) && (d.this.ttR != 5))
        {
          ae.v(d.this.TAG, "not in need data state, ignore, state:" + d.this.ttR + ", media:" + this.mediaId);
          AppMethodBeat.o(213488);
          return 0;
        }
        String str;
        StringBuilder localStringBuilder;
        if (d.this.ttR == 3)
        {
          if (paramString != null) {}
          for (parama = Long.valueOf(paramString.ttF);; parama = null)
          {
            if (parama == null) {
              p.gkB();
            }
            if (parama.longValue() < paramLong2 + paramLong3) {
              break;
            }
            ae.v(d.this.TAG, "onreaddata preload enough: " + this.mediaId);
            i = (int)paramLong3;
            AppMethodBeat.o(213488);
            return i;
          }
          if (bool1)
          {
            if (paramString != null) {
              parama = Boolean.valueOf(paramString.ttH);
            }
            for (;;)
            {
              if (parama.booleanValue()) {
                if ((d.c(d.this) == paramLong2) && (d.d(d.this) == paramLong3))
                {
                  ae.d(d.this.TAG, "range(" + paramLong2 + ", " + paramLong3 + ") is already requesting");
                  AppMethodBeat.o(213488);
                  return 0;
                  parama = null;
                }
                else
                {
                  i = e.tue.cSZ().tuc.y(this.mediaId, paramLong2, paramLong3);
                  if (i != 0)
                  {
                    str = d.this.TAG;
                    localStringBuilder = new StringBuilder("[key] request video data error ").append(this.mediaId).append(", ret:").append(i).append(" state:").append(d.this.ttR).append(" exists:").append(bool1).append(", offset:").append(paramLong2).append(", length:").append(paramLong3).append(", cache:");
                    if (paramString != null)
                    {
                      parama = Long.valueOf(paramString.cacheSize);
                      ae.e(str, parama.longValue());
                      e.tue.cSZ().tub.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong2 + paramLong3));
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
            ae.d(d.this.TAG, "onreaddata need more: " + this.mediaId);
            AppMethodBeat.o(213488);
            return 0;
            parama = null;
            break;
            d.a(d.this, paramLong2);
            d.b(d.this, paramLong3);
            continue;
            if (paramString != null) {}
            for (parama = Boolean.valueOf(paramString.ttG);; parama = null)
            {
              if (parama.booleanValue()) {
                break label903;
              }
              e.tue.cSZ().tub.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong2 + paramLong3));
              break;
            }
          }
        }
        if (d.this.ttR == 5)
        {
          if ((d.c(d.this) == paramLong2) && (d.d(d.this) == paramLong3))
          {
            ae.d(d.this.TAG, "range(" + paramLong2 + ", " + paramLong3 + ") is already requesting");
            AppMethodBeat.o(213488);
            return 0;
          }
          i = e.tue.cSZ().tuc.y(this.mediaId, paramLong2, paramLong3);
          if (i != 0)
          {
            str = d.this.TAG;
            localStringBuilder = new StringBuilder("onreaddata request more data ret:").append(i).append(" state:").append(d.this.ttR).append(' ').append(this.mediaId).append(", ret:").append(i).append(", exists:").append(bool1).append(", offset:").append(paramLong2).append(", length:").append(paramLong3).append(", cache:");
            if (paramString != null)
            {
              parama = Long.valueOf(paramString.cacheSize);
              ae.d(str, parama);
              e.tue.cSZ().tub.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong2 + paramLong3));
              d.b(d.this, 0L);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(213488);
            return 0;
            parama = null;
            break;
            d.a(d.this, paramLong2);
            d.b(d.this, paramLong3);
          }
        }
        AppMethodBeat.o(213488);
        return 0;
        bool1 = false;
      }
    }
    
    public final long b(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(213490);
      parama = e.tue.cSZ().tub.akt(this.mediaId);
      if (parama != null) {}
      for (parama = Long.valueOf(parama.nyl);; parama = null)
      {
        if (parama == null) {
          p.gkB();
        }
        paramLong = parama.longValue();
        AppMethodBeat.o(213490);
        return paramLong;
      }
    }
    
    public final String c(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(213491);
      parama = e.tue.cSZ().tub.akt(this.mediaId);
      if (parama != null) {}
      for (parama = parama.path;; parama = null)
      {
        if (parama == null) {
          p.gkB();
        }
        ae.d(d.this.TAG, "[getDataFilePath] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " taskId: " + paramLong + ", path: " + parama);
        AppMethodBeat.o(213491);
        return parama;
      }
    }
    
    public final String d(a parama, long paramLong, String paramString)
    {
      return "video/mp4";
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(d.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(213486);
        h localh = d.b(this.ttZ.ttY);
        if (localh != null)
        {
          localh.e(false, 2);
          AppMethodBeat.o(213486);
          return;
        }
        AppMethodBeat.o(213486);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class c
    implements b.e
  {
    c(d paramd) {}
    
    public final void a(a parama)
    {
      AppMethodBeat.i(213493);
      ae.i(this.ttY.TAG, "FVPlayer video_status " + parama + " prepared");
      this.ttY.Zn = true;
      parama = d.b(this.ttY);
      if (parama != null) {
        parama.e(false, 3);
      }
      com.tencent.mm.plugin.report.service.g.yxI.dD(1414, 0);
      AppMethodBeat.o(213493);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "errorType", "", "errorCode", "arg1", "", "arg2", "onError"})
  static final class d
    implements b.c
  {
    d(d paramd) {}
    
    public final void a(a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(213494);
      ae.e(this.ttY.TAG, "tplayer log " + parama + " error " + paramInt1 + ' ' + paramInt2);
      parama = d.b(this.ttY);
      if (parama != null) {
        parama.d(paramInt2, paramInt1, "视频加载失败，请检查网络连接后重试", "重试");
      }
      com.tencent.mm.plugin.report.service.g.yxI.dD(1414, 1);
      AppMethodBeat.o(213494);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class e
    implements b.b
  {
    e(d paramd) {}
    
    public final void b(a parama)
    {
      AppMethodBeat.i(213495);
      ae.i(this.ttY.TAG, parama + " on complete");
      parama = d.b(this.ttY);
      if (parama != null)
      {
        parama.e(false, 4);
        AppMethodBeat.o(213495);
        return;
      }
      AppMethodBeat.o(213495);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class f
    implements b.g
  {
    f(d paramd) {}
    
    public final void c(a parama)
    {
      AppMethodBeat.i(213496);
      ae.i(this.ttY.TAG, parama + " on seek");
      AppMethodBeat.o(213496);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "preState", "", "curState", "onStateChange"})
  static final class g
    implements b.h
  {
    g(d paramd) {}
    
    public final void fW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(213497);
      ae.i(this.ttY.TAG, d.a(this.ttY) + " prestate: " + paramInt1 + ", curState: " + paramInt2);
      this.ttY.ttR = paramInt2;
      switch (paramInt2)
      {
      }
      h localh;
      do
      {
        AppMethodBeat.o(213497);
        return;
        localh = d.b(this.ttY);
      } while (localh == null);
      localh.e(false, 5);
      AppMethodBeat.o(213497);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "what", "", "arg1", "", "arg2", "extraObject", "", "onInfo"})
  static final class h
    implements b.d
  {
    h(d paramd) {}
    
    public final void a(a parama, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(213498);
      ae.i(this.ttY.TAG, "tplayer log " + parama + ", msg:" + paramInt);
      switch (paramInt)
      {
      }
      do
      {
        AppMethodBeat.o(213498);
        return;
        ae.i(this.ttY.TAG, "video_status need buffer: " + parama + " mediaId:" + this.ttY.mediaId);
        parama = d.b(this.ttY);
        if (parama != null)
        {
          parama.e(false, 7);
          AppMethodBeat.o(213498);
          return;
        }
        AppMethodBeat.o(213498);
        return;
        ae.i(this.ttY.TAG, "video_status buffer ok: ".concat(String.valueOf(parama)));
        parama = d.b(this.ttY);
      } while (parama == null);
      parama.e(false, 8);
      AppMethodBeat.o(213498);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.d
 * JD-Core Version:    0.7.0.1
 */