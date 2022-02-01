package com.tencent.mm.plugin.flutter.e;

import android.content.Context;
import android.view.Surface;
import com.tencent.e.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer;", "Lcom/tencent/mm/plugin/flutter/video/IVideoPlayer;", "_context", "Landroid/content/Context;", "_path", "", "(Landroid/content/Context;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "cacheFilePath", "getCacheFilePath", "setCacheFilePath", "(Ljava/lang/String;)V", "cdnDownloadProxy", "Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "getCdnDownloadProxy", "()Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "setCdnDownloadProxy", "(Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;)V", "cdnTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getCdnTask", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setCdnTask", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "context", "downloadingMode", "", "getDownloadingMode", "()I", "setDownloadingMode", "(I)V", "isPrepared", "", "()Z", "setPrepared", "(Z)V", "mListener", "Lcom/tencent/mm/plugin/flutter/video/IVideoPlayerEventListener;", "mediaId", "getMediaId", "setMediaId", "mediaPlayer", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "playerState", "getPlayerState", "setPlayerState", "rangeLength", "", "rangeOffset", "url", "addListener", "", "listener", "changeSurface", "_surface", "Landroid/view/Surface;", "getBufferedPercentage", "getCurrPlayMs", "getCurrentPosition", "getDurationMs", "getHeight", "getPlayRate", "", "getVideoPath", "getWidth", "info", "initPlayer", "pause", "prepare", "release", "seek", "mSec", "seekMs", "isPrecision", "setAudioAttributes", "setLooping", "loop", "setMute", "mute", "setPath", "dataSource", "setPlayRate", "rate", "setPlayerCallback", "_callback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "setSurface", "setVolume", "volume", "", "start", "stop", "Companion", "ResourceLoaderProxy", "plugin-flutter_release"})
public final class d
  implements g
{
  private static Boolean tjd;
  public static final d.a tje;
  final String TAG;
  boolean Zn;
  private Context context;
  String mediaId;
  private long rangeOffset;
  private a tiW;
  private h tiX;
  private String tiY;
  int tiZ;
  private int tja;
  private long tjb;
  private b tjc;
  private String url;
  
  static
  {
    AppMethodBeat.i(219186);
    tje = new d.a((byte)0);
    tjd = Boolean.FALSE;
    AppMethodBeat.o(219186);
  }
  
  public d(Context paramContext, String paramString)
  {
    AppMethodBeat.i(219185);
    this.TAG = "MicroMsg.FlutterVideoPlayer";
    this.context = paramContext;
    this.tiY = paramString;
    paramContext = tjd;
    if (paramContext == null) {
      p.gfZ();
    }
    if (!paramContext.booleanValue())
    {
      tjd = Boolean.TRUE;
      com.tencent.thumbplayer.b.h.cB(this.context, "60303");
      com.tencent.thumbplayer.b.h.fWv();
      com.tencent.thumbplayer.b.h.fWw();
    }
    this.tiW = com.tencent.thumbplayer.b.g.lh(this.context);
    paramContext = this.tiW;
    if (paramContext != null) {
      paramContext.a((b.e)new c(this));
    }
    paramContext = this.tiW;
    if (paramContext != null) {
      paramContext.a((b.c)new d(this));
    }
    paramContext = this.tiW;
    if (paramContext != null) {
      paramContext.a((b.b)new e(this));
    }
    paramContext = this.tiW;
    if (paramContext != null) {
      paramContext.a((b.g)new f(this));
    }
    paramContext = this.tiW;
    if (paramContext != null) {
      paramContext.a((b.h)new g(this));
    }
    paramContext = this.tiW;
    if (paramContext != null)
    {
      paramContext.a((b.d)new h(this));
      AppMethodBeat.o(219185);
      return;
    }
    AppMethodBeat.o(219185);
  }
  
  public final void a(h paramh)
  {
    this.tiX = paramh;
  }
  
  public final boolean cQr()
  {
    AppMethodBeat.i(219172);
    Object localObject1 = this.mediaId;
    if (localObject1 == null) {
      p.gfZ();
    }
    Object localObject2 = this.tiY;
    if (localObject2 == null) {
      p.gfZ();
    }
    this.tjc = new b((String)localObject1, (String)localObject2);
    localObject1 = this.tiW;
    if (localObject1 != null) {
      ((a)localObject1).a((b.f)this.tjc);
    }
    ad.d(this.TAG, "video_status prepare url: " + this.url + ", media:" + this.mediaId);
    if (this.tiZ < 3)
    {
      localObject1 = e.tjm.cQu().tjj.ajv(this.mediaId);
      localObject2 = new p.a();
      ((p.a)localObject2).aZJ(this.mediaId);
      ((p.a)localObject2).a(new com.tencent.thumbplayer.b.b.b((byte)0));
      a locala = this.tiW;
      if (locala != null) {
        locala.a(((p.a)localObject2).fWy());
      }
      if ((localObject1 == null) || (!((b.a)localObject1).brw))
      {
        localObject1 = this.tiW;
        if (localObject1 != null) {
          ((a)localObject1).setDataSource(this.url);
        }
        localObject1 = this.tiW;
        if (localObject1 != null) {
          ((a)localObject1).prepareAsync();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(219172);
      return true;
      localObject2 = this.tiW;
      if (localObject2 == null) {
        break;
      }
      ((a)localObject2).setDataSource(((b.a)localObject1).path);
      break;
      ad.d(this.TAG, "video_status prepare playerState " + this.tiZ + ' ');
    }
  }
  
  public final int getBufferedPercentage()
  {
    Long localLong2 = null;
    AppMethodBeat.i(219182);
    b.a locala = e.tjm.cQu().tjj.ajv(this.mediaId);
    if (locala != null) {}
    for (Long localLong1 = Long.valueOf(locala.cacheSize);; localLong1 = null)
    {
      if (locala != null) {
        localLong2 = Long.valueOf(locala.nsQ);
      }
      if (localLong1 == null) {
        p.gfZ();
      }
      if (localLong1.longValue() <= 0L) {
        break;
      }
      if (localLong2 == null) {
        p.gfZ();
      }
      if (localLong2.longValue() <= 0L) {
        break;
      }
      int i = (int)(localLong1.longValue() * 100L / localLong2.longValue());
      AppMethodBeat.o(219182);
      return i;
    }
    AppMethodBeat.o(219182);
    return 0;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(219171);
    a locala = this.tiW;
    if (locala != null)
    {
      long l = locala.getCurrentPositionMs();
      AppMethodBeat.o(219171);
      return l;
    }
    AppMethodBeat.o(219171);
    return 0L;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(219177);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("getDurationMs: ");
    Object localObject = this.tiW;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((a)localObject).getDurationMs());; localObject = null)
    {
      ad.d(str, localObject);
      localObject = this.tiW;
      if (localObject == null) {
        break;
      }
      long l = ((a)localObject).getDurationMs();
      AppMethodBeat.o(219177);
      return l;
    }
    AppMethodBeat.o(219177);
    return 0L;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(219175);
    a locala = this.tiW;
    if (locala != null)
    {
      int i = locala.getVideoHeight();
      AppMethodBeat.o(219175);
      return i;
    }
    AppMethodBeat.o(219175);
    return 0;
  }
  
  public final String getVideoPath()
  {
    return this.url;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(219178);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("getWidth ").append(this.tiW).append("  ");
    a locala = this.tiW;
    if (locala != null) {}
    for (int i = locala.getVideoWidth();; i = 0)
    {
      ad.d((String)localObject, i);
      localObject = this.tiW;
      if (localObject == null) {
        break;
      }
      i = ((a)localObject).getVideoWidth();
      AppMethodBeat.o(219178);
      return i;
    }
    AppMethodBeat.o(219178);
    return 0;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(219176);
    ad.d(this.TAG, "video_status pause " + this.tiW + ", mediaId:" + this.mediaId + ", url:" + this.url);
    a locala = this.tiW;
    if (locala != null) {
      locala.pause();
    }
    locala = this.tiW;
    if (locala != null)
    {
      locala.pauseDownload();
      AppMethodBeat.o(219176);
      return;
    }
    AppMethodBeat.o(219176);
  }
  
  public final void release()
  {
    AppMethodBeat.i(219184);
    ad.d(this.TAG, "video_status release " + this.tiW + " , url: " + this.url);
    a locala = this.tiW;
    if (locala != null) {
      locala.setSurface(null);
    }
    locala = this.tiW;
    if (locala != null)
    {
      locala.release();
      AppMethodBeat.o(219184);
      return;
    }
    AppMethodBeat.o(219184);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(219170);
    ad.i(this.TAG, "video_status seek " + this.tiW + ", state: " + this.tiZ);
    if (this.tiZ < 4)
    {
      ad.e(this.TAG, "video_status wrong seek");
      AppMethodBeat.o(219170);
      return;
    }
    a locala = this.tiW;
    if (locala != null) {
      locala.fWu();
    }
    locala = this.tiW;
    if (locala != null)
    {
      locala.seekTo(paramInt);
      AppMethodBeat.o(219170);
      return;
    }
    AppMethodBeat.o(219170);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(219179);
    a locala = this.tiW;
    if (locala != null)
    {
      locala.zv(paramBoolean);
      AppMethodBeat.o(219179);
      return;
    }
    AppMethodBeat.o(219179);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(219183);
    ad.d(this.TAG, "setPath mediaId:" + this.mediaId + " dataSource:" + paramString + ' ');
    this.url = paramString;
    paramString = this.url;
    if (paramString != null)
    {
      Charset localCharset = d.n.d.UTF_8;
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(219183);
        throw paramString;
      }
      paramString = paramString.getBytes(localCharset);
      p.g(paramString, "(this as java.lang.String).getBytes(charset)");
    }
    for (;;)
    {
      this.mediaId = com.tencent.mm.b.g.getMessageDigest(paramString);
      AppMethodBeat.o(219183);
      return;
      paramString = null;
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(219180);
    Object localObject = this.TAG;
    if (paramSurface != null) {}
    for (int i = paramSurface.hashCode();; i = 0)
    {
      ad.d((String)localObject, "setSurface %s", new Object[] { Integer.valueOf(i) });
      localObject = this.tiW;
      if (localObject == null) {
        break;
      }
      ((a)localObject).setSurface(paramSurface);
      AppMethodBeat.o(219180);
      return;
    }
    AppMethodBeat.o(219180);
  }
  
  public final void start()
  {
    AppMethodBeat.i(219173);
    ad.d(this.TAG, "video_status play " + this.tiW + ", mediaId:" + this.mediaId + ", download: " + this.tja + " state:" + this.tiZ + " : " + this.url);
    if (this.tiZ == 5)
    {
      ad.d(this.TAG, "video_status already playing " + this.tiW);
      AppMethodBeat.o(219173);
      return;
    }
    if (this.tiZ >= 4) {}
    for (int i = 1; (ac.MKp) && (i == 0); i = 0)
    {
      localObject = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(219173);
      throw ((Throwable)localObject);
    }
    Object localObject = this.tiW;
    if (localObject != null) {
      ((a)localObject).fWu();
    }
    localObject = this.tiW;
    if (localObject != null)
    {
      ((a)localObject).start();
      AppMethodBeat.o(219173);
      return;
    }
    AppMethodBeat.o(219173);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(219181);
    ad.d(this.TAG, "video_status stop: " + this.tiW + " , url: " + this.url);
    a locala = this.tiW;
    if (locala != null)
    {
      locala.stop();
      AppMethodBeat.o(219181);
      return;
    }
    AppMethodBeat.o(219181);
  }
  
  public final void u(double paramDouble)
  {
    AppMethodBeat.i(219174);
    ad.d(this.TAG, "setVolume");
    a locala = this.tiW;
    if (locala != null)
    {
      locala.ci((float)paramDouble);
      AppMethodBeat.o(219174);
      return;
    }
    AppMethodBeat.o(219174);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnResourceLoaderListener;", "mediaId", "", "path", "(Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer;Ljava/lang/String;Ljava/lang/String;)V", "acacheSize", "", "getAcacheSize", "()J", "setAcacheSize", "(J)V", "getMediaId", "()Ljava/lang/String;", "getPath", "getContentType", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "taskId", "fileKey", "getDataFilePath", "getDataTotalSize", "onReadData", "", "offset", "length", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "plugin-flutter_release"})
  public final class b
    implements b.f
  {
    private final String mediaId;
    private final String path;
    private long tjf;
    
    public b(String paramString)
    {
      AppMethodBeat.i(219163);
      this.mediaId = paramString;
      this.path = localObject;
      AppMethodBeat.o(219163);
    }
    
    public final int a(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(219160);
      ad.d(d.this.TAG, "[onStopReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " taskId: " + paramLong);
      AppMethodBeat.o(219160);
      return 0;
    }
    
    public final int a(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(219158);
      ad.d(d.this.TAG, "[onStartReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " taskId: " + paramLong1);
      int i = this.mediaId.hashCode();
      AppMethodBeat.o(219158);
      return i;
    }
    
    public final int b(a parama, long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      AppMethodBeat.i(219159);
      ad.d(d.this.TAG, "[onReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " taskId: " + paramLong1 + " state:" + d.this.tiZ);
      if (paramLong3 <= 0L)
      {
        ad.d(d.this.TAG, "FVPlayer onReadDate 0");
        AppMethodBeat.o(219159);
        return 0;
      }
      paramString = e.tjm.cQu().tjj.ajv(this.mediaId);
      if ((paramString != null) && (this.tjf != paramString.cacheSize))
      {
        this.tjf = paramString.cacheSize;
        com.tencent.e.h.LTJ.aP((Runnable)new a(this));
      }
      int i;
      if ((paramString != null) && (paramString.brw))
      {
        ad.d(d.this.TAG, "onreaddata completed");
        i = (int)paramLong3;
        AppMethodBeat.o(219159);
        return i;
      }
      boolean bool1;
      if (d.this.tiZ != 6)
      {
        bool1 = CdnLogic.taskExist(this.mediaId);
        if (bool1)
        {
          boolean bool2 = CdnLogic.isVideoDataAvailable(this.mediaId, paramLong2, paramLong3);
          if (bool2)
          {
            ad.d(d.this.TAG, "FVPlayer onReadData isVideoDataAvailable " + bool2 + " offset:" + paramLong2 + " length:" + paramLong3 + " mediaId" + this.mediaId);
            i = (int)paramLong3;
            AppMethodBeat.o(219159);
            return i;
          }
        }
      }
      for (;;)
      {
        if ((d.this.tiZ != 3) && (d.this.tiZ != 5))
        {
          ad.v(d.this.TAG, "not in need data state, ignore, state:" + d.this.tiZ + ", media:" + this.mediaId);
          AppMethodBeat.o(219159);
          return 0;
        }
        String str;
        StringBuilder localStringBuilder;
        if (d.this.tiZ == 3)
        {
          if (paramString != null) {}
          for (parama = Long.valueOf(paramString.tiN);; parama = null)
          {
            if (parama == null) {
              p.gfZ();
            }
            if (parama.longValue() < paramLong2 + paramLong3) {
              break;
            }
            ad.v(d.this.TAG, "onreaddata preload enough: " + this.mediaId);
            i = (int)paramLong3;
            AppMethodBeat.o(219159);
            return i;
          }
          if (bool1)
          {
            if (paramString != null) {
              parama = Boolean.valueOf(paramString.tiP);
            }
            for (;;)
            {
              if (parama.booleanValue()) {
                if ((d.c(d.this) == paramLong2) && (d.d(d.this) == paramLong3))
                {
                  ad.d(d.this.TAG, "range(" + paramLong2 + ", " + paramLong3 + ") is already requesting");
                  AppMethodBeat.o(219159);
                  return 0;
                  parama = null;
                }
                else
                {
                  i = e.tjm.cQu().tjk.y(this.mediaId, paramLong2, paramLong3);
                  if (i != 0)
                  {
                    str = d.this.TAG;
                    localStringBuilder = new StringBuilder("[key] request video data error ").append(this.mediaId).append(", ret:").append(i).append(" state:").append(d.this.tiZ).append(" exists:").append(bool1).append(", offset:").append(paramLong2).append(", length:").append(paramLong3).append(", cache:");
                    if (paramString != null)
                    {
                      parama = Long.valueOf(paramString.cacheSize);
                      ad.e(str, parama.longValue());
                      e.tjm.cQu().tjj.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong2 + paramLong3));
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
            ad.d(d.this.TAG, "onreaddata need more: " + this.mediaId);
            AppMethodBeat.o(219159);
            return 0;
            parama = null;
            break;
            d.a(d.this, paramLong2);
            d.b(d.this, paramLong3);
            continue;
            if (paramString != null) {}
            for (parama = Boolean.valueOf(paramString.tiO);; parama = null)
            {
              if (parama.booleanValue()) {
                break label903;
              }
              e.tjm.cQu().tjj.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong2 + paramLong3));
              break;
            }
          }
        }
        if (d.this.tiZ == 5)
        {
          if ((d.c(d.this) == paramLong2) && (d.d(d.this) == paramLong3))
          {
            ad.d(d.this.TAG, "range(" + paramLong2 + ", " + paramLong3 + ") is already requesting");
            AppMethodBeat.o(219159);
            return 0;
          }
          i = e.tjm.cQu().tjk.y(this.mediaId, paramLong2, paramLong3);
          if (i != 0)
          {
            str = d.this.TAG;
            localStringBuilder = new StringBuilder("onreaddata request more data ret:").append(i).append(" state:").append(d.this.tiZ).append(' ').append(this.mediaId).append(", ret:").append(i).append(", exists:").append(bool1).append(", offset:").append(paramLong2).append(", length:").append(paramLong3).append(", cache:");
            if (paramString != null)
            {
              parama = Long.valueOf(paramString.cacheSize);
              ad.d(str, parama);
              e.tjm.cQu().tjj.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong2 + paramLong3));
              d.b(d.this, 0L);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(219159);
            return 0;
            parama = null;
            break;
            d.a(d.this, paramLong2);
            d.b(d.this, paramLong3);
          }
        }
        AppMethodBeat.o(219159);
        return 0;
        bool1 = false;
      }
    }
    
    public final long b(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(219161);
      parama = e.tjm.cQu().tjj.ajv(this.mediaId);
      if (parama != null) {}
      for (parama = Long.valueOf(parama.nsQ);; parama = null)
      {
        if (parama == null) {
          p.gfZ();
        }
        paramLong = parama.longValue();
        AppMethodBeat.o(219161);
        return paramLong;
      }
    }
    
    public final String c(a parama, long paramLong, String paramString)
    {
      AppMethodBeat.i(219162);
      parama = e.tjm.cQu().tjj.ajv(this.mediaId);
      if (parama != null) {}
      for (parama = parama.path;; parama = null)
      {
        if (parama == null) {
          p.gfZ();
        }
        ad.d(d.this.TAG, "[getDataFilePath] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " taskId: " + paramLong + ", path: " + parama);
        AppMethodBeat.o(219162);
        return parama;
      }
    }
    
    public final String d(a parama, long paramLong, String paramString)
    {
      return "video/mp4";
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(d.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(219157);
        h localh = d.b(this.tjh.tjg);
        if (localh != null)
        {
          localh.e(false, 2);
          AppMethodBeat.o(219157);
          return;
        }
        AppMethodBeat.o(219157);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class c
    implements b.e
  {
    c(d paramd) {}
    
    public final void a(a parama)
    {
      AppMethodBeat.i(219164);
      ad.i(this.tjg.TAG, "FVPlayer video_status " + parama + " prepared");
      this.tjg.Zn = true;
      parama = d.b(this.tjg);
      if (parama != null) {
        parama.e(false, 3);
      }
      com.tencent.mm.plugin.report.service.g.yhR.dD(1414, 0);
      AppMethodBeat.o(219164);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "errorType", "", "errorCode", "arg1", "", "arg2", "onError"})
  static final class d
    implements b.c
  {
    d(d paramd) {}
    
    public final void a(a parama, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(219165);
      ad.e(this.tjg.TAG, "tplayer log " + parama + " error " + paramInt1 + ' ' + paramInt2);
      parama = d.b(this.tjg);
      if (parama != null) {
        parama.d(paramInt2, paramInt1, "视频加载失败，请检查网络连接后重试", "重试");
      }
      com.tencent.mm.plugin.report.service.g.yhR.dD(1414, 1);
      AppMethodBeat.o(219165);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class e
    implements b.b
  {
    e(d paramd) {}
    
    public final void b(a parama)
    {
      AppMethodBeat.i(219166);
      ad.i(this.tjg.TAG, parama + " on complete");
      parama = d.b(this.tjg);
      if (parama != null)
      {
        parama.e(false, 4);
        AppMethodBeat.o(219166);
        return;
      }
      AppMethodBeat.o(219166);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class f
    implements b.g
  {
    f(d paramd) {}
    
    public final void c(a parama)
    {
      AppMethodBeat.i(219167);
      ad.i(this.tjg.TAG, parama + " on seek");
      AppMethodBeat.o(219167);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "preState", "", "curState", "onStateChange"})
  static final class g
    implements b.h
  {
    g(d paramd) {}
    
    public final void fW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(219168);
      ad.i(this.tjg.TAG, d.a(this.tjg) + " prestate: " + paramInt1 + ", curState: " + paramInt2);
      this.tjg.tiZ = paramInt2;
      switch (paramInt2)
      {
      }
      h localh;
      do
      {
        AppMethodBeat.o(219168);
        return;
        localh = d.b(this.tjg);
      } while (localh == null);
      localh.e(false, 5);
      AppMethodBeat.o(219168);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "what", "", "arg1", "", "arg2", "extraObject", "", "onInfo"})
  static final class h
    implements b.d
  {
    h(d paramd) {}
    
    public final void a(a parama, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(219169);
      ad.i(this.tjg.TAG, "tplayer log " + parama + ", msg:" + paramInt);
      switch (paramInt)
      {
      }
      do
      {
        AppMethodBeat.o(219169);
        return;
        ad.i(this.tjg.TAG, "video_status need buffer: " + parama + " mediaId:" + this.tjg.mediaId);
        parama = d.b(this.tjg);
        if (parama != null)
        {
          parama.e(false, 7);
          AppMethodBeat.o(219169);
          return;
        }
        AppMethodBeat.o(219169);
        return;
        ad.i(this.tjg.TAG, "video_status buffer ok: ".concat(String.valueOf(parama)));
        parama = d.b(this.tjg);
      } while (parama == null);
      parama.e(false, 8);
      AppMethodBeat.o(219169);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.d
 * JD-Core Version:    0.7.0.1
 */