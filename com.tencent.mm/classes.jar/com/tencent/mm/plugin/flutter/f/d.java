package com.tencent.mm.plugin.flutter.f;

import android.content.Context;
import android.view.Surface;
import com.tencent.f.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.nio.charset.Charset;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer;", "Lcom/tencent/mm/plugin/flutter/video/IVideoPlayer;", "_context", "Landroid/content/Context;", "_path", "", "(Landroid/content/Context;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "cacheFilePath", "getCacheFilePath", "setCacheFilePath", "(Ljava/lang/String;)V", "cdnDownloadProxy", "Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "getCdnDownloadProxy", "()Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "setCdnDownloadProxy", "(Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;)V", "cdnTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getCdnTask", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setCdnTask", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "context", "downloadingMode", "", "getDownloadingMode", "()I", "setDownloadingMode", "(I)V", "isPrepared", "", "()Z", "setPrepared", "(Z)V", "mListener", "Lcom/tencent/mm/plugin/flutter/video/IVideoPlayerEventListener;", "mediaId", "getMediaId", "setMediaId", "mediaPlayer", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "playerState", "getPlayerState", "setPlayerState", "rangeLength", "", "rangeOffset", "url", "addListener", "", "listener", "changeSurface", "_surface", "Landroid/view/Surface;", "getBufferedPercentage", "getCurrPlayMs", "getCurrentPosition", "getDurationMs", "getHeight", "getPlayRate", "", "getVideoPath", "getWidth", "info", "initPlayer", "pause", "prepare", "release", "seek", "mSec", "seekMs", "isPrecision", "setAudioAttributes", "setLooping", "loop", "setMute", "mute", "setPath", "dataSource", "setPlayRate", "rate", "setPlayerCallback", "_callback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "setSurface", "setVolume", "volume", "", "start", "stop", "Companion", "ResourceLoaderProxy", "plugin-flutter_release"})
public final class d
  implements g
{
  private static Boolean wLj;
  public static final d.a wLk;
  final String TAG;
  boolean ZA;
  private Context context;
  String mediaId;
  private long rangeOffset;
  private String url;
  private ITPPlayer wLc;
  private h wLd;
  private String wLe;
  int wLf;
  private int wLg;
  private long wLh;
  private b wLi;
  
  static
  {
    AppMethodBeat.i(241173);
    wLk = new d.a((byte)0);
    wLj = Boolean.FALSE;
    AppMethodBeat.o(241173);
  }
  
  public d(Context paramContext, String paramString)
  {
    AppMethodBeat.i(241172);
    this.TAG = "MicroMsg.FlutterVideoPlayer";
    this.context = paramContext;
    this.wLe = paramString;
    paramContext = wLj;
    if (paramContext == null) {
      p.hyc();
    }
    if (!paramContext.booleanValue())
    {
      wLj = Boolean.TRUE;
      TPPlayerMgr.initSdk(this.context, "60303", 1);
      TPPlayerMgr.setProxyEnable(true);
      TPPlayerMgr.setProxyServiceType(100);
    }
    this.wLc = TPPlayerFactory.createTPPlayer(this.context);
    paramContext = this.wLc;
    if (paramContext != null) {
      paramContext.setOnPreparedListener((ITPPlayerListener.IOnPreparedListener)new c(this));
    }
    paramContext = this.wLc;
    if (paramContext != null) {
      paramContext.setOnErrorListener((ITPPlayerListener.IOnErrorListener)new d(this));
    }
    paramContext = this.wLc;
    if (paramContext != null) {
      paramContext.setOnCompletionListener((ITPPlayerListener.IOnCompletionListener)new e(this));
    }
    paramContext = this.wLc;
    if (paramContext != null) {
      paramContext.setOnSeekCompleteListener((ITPPlayerListener.IOnSeekCompleteListener)new f(this));
    }
    paramContext = this.wLc;
    if (paramContext != null) {
      paramContext.setOnPlayerStateChangeListener((ITPPlayerListener.IOnStateChangeListener)new g(this));
    }
    paramContext = this.wLc;
    if (paramContext != null)
    {
      paramContext.setOnInfoListener((ITPPlayerListener.IOnInfoListener)new h(this));
      AppMethodBeat.o(241172);
      return;
    }
    AppMethodBeat.o(241172);
  }
  
  public final void a(h paramh)
  {
    this.wLd = paramh;
  }
  
  public final int getBufferedPercentage()
  {
    Long localLong2 = null;
    AppMethodBeat.i(241169);
    b.a locala = e.wLs.dMk().wLp.axy(this.mediaId);
    if (locala != null) {}
    for (Long localLong1 = Long.valueOf(locala.cacheSize);; localLong1 = null)
    {
      if (locala != null) {
        localLong2 = Long.valueOf(locala.oJj);
      }
      if (localLong1 == null) {
        p.hyc();
      }
      if (localLong1.longValue() <= 0L) {
        break;
      }
      if (localLong2 == null) {
        p.hyc();
      }
      if (localLong2.longValue() <= 0L) {
        break;
      }
      int i = (int)(localLong1.longValue() * 100L / localLong2.longValue());
      AppMethodBeat.o(241169);
      return i;
    }
    AppMethodBeat.o(241169);
    return 0;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(241158);
    ITPPlayer localITPPlayer = this.wLc;
    if (localITPPlayer != null)
    {
      long l = localITPPlayer.getCurrentPositionMs();
      AppMethodBeat.o(241158);
      return l;
    }
    AppMethodBeat.o(241158);
    return 0L;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(241164);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("getDurationMs: ");
    Object localObject = this.wLc;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((ITPPlayer)localObject).getDurationMs());; localObject = null)
    {
      Log.d(str, localObject);
      localObject = this.wLc;
      if (localObject == null) {
        break;
      }
      long l = ((ITPPlayer)localObject).getDurationMs();
      AppMethodBeat.o(241164);
      return l;
    }
    AppMethodBeat.o(241164);
    return 0L;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(241162);
    ITPPlayer localITPPlayer = this.wLc;
    if (localITPPlayer != null)
    {
      int i = localITPPlayer.getVideoHeight();
      AppMethodBeat.o(241162);
      return i;
    }
    AppMethodBeat.o(241162);
    return 0;
  }
  
  public final String getVideoPath()
  {
    return this.url;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(241165);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("getWidth ").append(this.wLc).append("  ");
    ITPPlayer localITPPlayer = this.wLc;
    if (localITPPlayer != null) {}
    for (int i = localITPPlayer.getVideoWidth();; i = 0)
    {
      Log.d((String)localObject, i);
      localObject = this.wLc;
      if (localObject == null) {
        break;
      }
      i = ((ITPPlayer)localObject).getVideoWidth();
      AppMethodBeat.o(241165);
      return i;
    }
    AppMethodBeat.o(241165);
    return 0;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(241163);
    Log.d(this.TAG, "video_status pause " + this.wLc + ", mediaId:" + this.mediaId + ", url:" + this.url);
    ITPPlayer localITPPlayer = this.wLc;
    if (localITPPlayer != null) {
      localITPPlayer.pause();
    }
    localITPPlayer = this.wLc;
    if (localITPPlayer != null)
    {
      localITPPlayer.pauseDownload();
      AppMethodBeat.o(241163);
      return;
    }
    AppMethodBeat.o(241163);
  }
  
  public final boolean prepare()
  {
    AppMethodBeat.i(241159);
    Object localObject1 = this.mediaId;
    if (localObject1 == null) {
      p.hyc();
    }
    Object localObject2 = this.wLe;
    if (localObject2 == null) {
      p.hyc();
    }
    this.wLi = new b((String)localObject1, (String)localObject2);
    localObject1 = this.wLc;
    if (localObject1 != null) {
      ((ITPPlayer)localObject1).enableTPAssetResourceLoader((com.tencent.thumbplayer.e.a.a)this.wLi);
    }
    Log.d(this.TAG, "video_status prepare url: " + this.url + ", media:" + this.mediaId);
    if (this.wLf < 3)
    {
      localObject1 = e.wLs.dMk().wLp.axy(this.mediaId);
      localObject2 = new TPVideoInfo.Builder();
      ((TPVideoInfo.Builder)localObject2).fileId(this.mediaId);
      ((TPVideoInfo.Builder)localObject2).downloadParam(new TPDownloadParamData(11));
      ITPPlayer localITPPlayer = this.wLc;
      if (localITPPlayer != null) {
        localITPPlayer.setVideoInfo(((TPVideoInfo.Builder)localObject2).build());
      }
      if ((localObject1 == null) || (!((b.a)localObject1).brr))
      {
        localObject1 = this.wLc;
        if (localObject1 != null) {
          ((ITPPlayer)localObject1).setDataSource(this.url);
        }
        localObject1 = this.wLc;
        if (localObject1 != null) {
          ((ITPPlayer)localObject1).prepareAsync();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(241159);
      return true;
      localObject2 = this.wLc;
      if (localObject2 == null) {
        break;
      }
      ((ITPPlayer)localObject2).setDataSource(((b.a)localObject1).path);
      break;
      Log.d(this.TAG, "video_status prepare playerState " + this.wLf + ' ');
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(241171);
    Log.d(this.TAG, "video_status release " + this.wLc + " , url: " + this.url);
    ITPPlayer localITPPlayer = this.wLc;
    if (localITPPlayer != null) {
      localITPPlayer.setSurface(null);
    }
    localITPPlayer = this.wLc;
    if (localITPPlayer != null)
    {
      localITPPlayer.release();
      AppMethodBeat.o(241171);
      return;
    }
    AppMethodBeat.o(241171);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(241157);
    Log.i(this.TAG, "video_status seek " + this.wLc + ", state: " + this.wLf);
    if (this.wLf < 4)
    {
      Log.e(this.TAG, "video_status wrong seek");
      AppMethodBeat.o(241157);
      return;
    }
    ITPPlayer localITPPlayer = this.wLc;
    if (localITPPlayer != null) {
      localITPPlayer.resumeDownload();
    }
    localITPPlayer = this.wLc;
    if (localITPPlayer != null)
    {
      localITPPlayer.seekTo(paramInt);
      AppMethodBeat.o(241157);
      return;
    }
    AppMethodBeat.o(241157);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(241166);
    ITPPlayer localITPPlayer = this.wLc;
    if (localITPPlayer != null)
    {
      localITPPlayer.setLoopback(paramBoolean);
      AppMethodBeat.o(241166);
      return;
    }
    AppMethodBeat.o(241166);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(241170);
    Log.d(this.TAG, "setPath mediaId:" + this.mediaId + " dataSource:" + paramString + ' ');
    this.url = paramString;
    paramString = this.url;
    if (paramString != null)
    {
      Charset localCharset = kotlin.n.d.UTF_8;
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(241170);
        throw paramString;
      }
      paramString = paramString.getBytes(localCharset);
      p.g(paramString, "(this as java.lang.String).getBytes(charset)");
    }
    for (;;)
    {
      this.mediaId = com.tencent.mm.b.g.getMessageDigest(paramString);
      AppMethodBeat.o(241170);
      return;
      paramString = null;
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(241167);
    Object localObject = this.TAG;
    if (paramSurface != null) {}
    for (int i = paramSurface.hashCode();; i = 0)
    {
      Log.d((String)localObject, "setSurface %s", new Object[] { Integer.valueOf(i) });
      localObject = this.wLc;
      if (localObject == null) {
        break;
      }
      ((ITPPlayer)localObject).setSurface(paramSurface);
      AppMethodBeat.o(241167);
      return;
    }
    AppMethodBeat.o(241167);
  }
  
  public final void start()
  {
    AppMethodBeat.i(241160);
    Log.d(this.TAG, "video_status play " + this.wLc + ", mediaId:" + this.mediaId + ", download: " + this.wLg + " state:" + this.wLf + " : " + this.url);
    if (this.wLf == 5)
    {
      Log.d(this.TAG, "video_status already playing " + this.wLc);
      AppMethodBeat.o(241160);
      return;
    }
    if (this.wLf >= 4) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0)
    {
      localObject = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(241160);
      throw ((Throwable)localObject);
    }
    Object localObject = this.wLc;
    if (localObject != null) {
      ((ITPPlayer)localObject).resumeDownload();
    }
    localObject = this.wLc;
    if (localObject != null)
    {
      ((ITPPlayer)localObject).start();
      AppMethodBeat.o(241160);
      return;
    }
    AppMethodBeat.o(241160);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(241168);
    Log.d(this.TAG, "video_status stop: " + this.wLc + " , url: " + this.url);
    ITPPlayer localITPPlayer = this.wLc;
    if (localITPPlayer != null)
    {
      localITPPlayer.stop();
      AppMethodBeat.o(241168);
      return;
    }
    AppMethodBeat.o(241168);
  }
  
  public final void u(double paramDouble)
  {
    AppMethodBeat.i(241161);
    Log.d(this.TAG, "setVolume");
    ITPPlayer localITPPlayer = this.wLc;
    if (localITPPlayer != null)
    {
      localITPPlayer.setAudioGainRatio((float)paramDouble);
      AppMethodBeat.o(241161);
      return;
    }
    AppMethodBeat.o(241161);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "Lplatform/android/ThumbPlayerAndroid/src/main/java/com/tencent/thumbplayer/datatransport/resourceloader/AbsTPAssetResourceLoader;", "mediaId", "", "path", "(Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer;Ljava/lang/String;Ljava/lang/String;)V", "acacheSize", "", "getAcacheSize", "()J", "setAcacheSize", "(J)V", "getMediaId", "()Ljava/lang/String;", "getPath", "getContentType", "fileId", "", "fileKey", "getDataFilePath", "getDataTotalSize", "onReadData", "offset", "length", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "requestId", "plugin-flutter_release"})
  public final class b
    extends h.a.a.a.a.a.a.a.a.a.a.a
  {
    private final String mediaId;
    private final String path;
    private long wLl;
    
    public b(String paramString)
    {
      AppMethodBeat.i(241150);
      this.mediaId = paramString;
      this.path = localObject;
      AppMethodBeat.o(241150);
    }
    
    public final String Mf(int paramInt)
    {
      AppMethodBeat.i(241149);
      Object localObject = e.wLs.dMk().wLp.axy(this.mediaId);
      if (localObject != null) {}
      for (localObject = ((b.a)localObject).path;; localObject = null)
      {
        if (localObject == null) {
          p.hyc();
        }
        Log.d(d.this.TAG, "[getDataFilePath] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " fileId: " + paramInt + ", path: " + (String)localObject);
        AppMethodBeat.o(241149);
        return localObject;
      }
    }
    
    public final String getContentType(int paramInt, String paramString)
    {
      return "video/mp4";
    }
    
    public final long getDataTotalSize(int paramInt, String paramString)
    {
      AppMethodBeat.i(241148);
      paramString = e.wLs.dMk().wLp.axy(this.mediaId);
      if (paramString != null) {}
      for (paramString = Long.valueOf(paramString.oJj);; paramString = null)
      {
        if (paramString == null) {
          p.hyc();
        }
        long l = paramString.longValue();
        AppMethodBeat.o(241148);
        return l;
      }
    }
    
    public final int k(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(241146);
      Log.d(d.this.TAG, "[onReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " fileId: " + paramInt + " state:" + d.this.wLf);
      if (paramLong2 <= 0L)
      {
        Log.d(d.this.TAG, "FVPlayer onReadDate 0");
        AppMethodBeat.o(241146);
        return 0;
      }
      b.a locala = e.wLs.dMk().wLp.axy(this.mediaId);
      if ((locala != null) && (this.wLl != locala.cacheSize))
      {
        this.wLl = locala.cacheSize;
        com.tencent.f.h.RTc.aV((Runnable)new a(this));
      }
      if ((locala != null) && (locala.brr))
      {
        Log.d(d.this.TAG, "onreaddata completed");
        paramInt = (int)paramLong2;
        AppMethodBeat.o(241146);
        return paramInt;
      }
      boolean bool1;
      if (d.this.wLf != 6)
      {
        bool1 = CdnLogic.taskExist(this.mediaId);
        if (bool1)
        {
          boolean bool2 = CdnLogic.isVideoDataAvailable(this.mediaId, paramLong1, paramLong2);
          if (bool2)
          {
            Log.d(d.this.TAG, "FVPlayer onReadData isVideoDataAvailable " + bool2 + " offset:" + paramLong1 + " length:" + paramLong2 + " mediaId" + this.mediaId);
            paramInt = (int)paramLong2;
            AppMethodBeat.o(241146);
            return paramInt;
          }
        }
      }
      for (;;)
      {
        if ((d.this.wLf != 3) && (d.this.wLf != 5))
        {
          Log.v(d.this.TAG, "not in need data state, ignore, state:" + d.this.wLf + ", media:" + this.mediaId);
          AppMethodBeat.o(241146);
          return 0;
        }
        Object localObject;
        String str;
        StringBuilder localStringBuilder;
        if (d.this.wLf == 3)
        {
          if (locala != null) {}
          for (localObject = Long.valueOf(locala.wKT);; localObject = null)
          {
            if (localObject == null) {
              p.hyc();
            }
            if (((Long)localObject).longValue() < paramLong1 + paramLong2) {
              break;
            }
            Log.v(d.this.TAG, "onreaddata preload enough: " + this.mediaId);
            paramInt = (int)paramLong2;
            AppMethodBeat.o(241146);
            return paramInt;
          }
          if (bool1)
          {
            if (locala != null) {
              localObject = Boolean.valueOf(locala.wKV);
            }
            for (;;)
            {
              if (((Boolean)localObject).booleanValue()) {
                if ((d.c(d.this) == paramLong1) && (d.d(d.this) == paramLong2))
                {
                  Log.d(d.this.TAG, "range(" + paramLong1 + ", " + paramLong2 + ") is already requesting");
                  AppMethodBeat.o(241146);
                  return 0;
                  localObject = null;
                }
                else
                {
                  paramInt = e.wLs.dMk().wLq.z(this.mediaId, paramLong1, paramLong2);
                  if (paramInt != 0)
                  {
                    str = d.this.TAG;
                    localStringBuilder = new StringBuilder("[key] request video data error ").append(this.mediaId).append(", ret:").append(paramInt).append(" state:").append(d.this.wLf).append(" exists:").append(bool1).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(", cache:");
                    if (locala != null)
                    {
                      localObject = Long.valueOf(locala.cacheSize);
                      Log.e(str, ((Long)localObject).longValue());
                      e.wLs.dMk().wLp.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong1 + paramLong2));
                      d.b(d.this, 0L);
                    }
                  }
                }
              }
            }
          }
          label897:
          for (;;)
          {
            Log.d(d.this.TAG, "onreaddata need more: " + this.mediaId);
            AppMethodBeat.o(241146);
            return 0;
            localObject = null;
            break;
            d.a(d.this, paramLong1);
            d.b(d.this, paramLong2);
            continue;
            if (locala != null) {}
            for (localObject = Boolean.valueOf(locala.wKU);; localObject = null)
            {
              if (((Boolean)localObject).booleanValue()) {
                break label897;
              }
              e.wLs.dMk().wLp.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong1 + paramLong2));
              break;
            }
          }
        }
        if (d.this.wLf == 5)
        {
          if ((d.c(d.this) == paramLong1) && (d.d(d.this) == paramLong2))
          {
            Log.d(d.this.TAG, "range(" + paramLong1 + ", " + paramLong2 + ") is already requesting");
            AppMethodBeat.o(241146);
            return 0;
          }
          paramInt = e.wLs.dMk().wLq.z(this.mediaId, paramLong1, paramLong2);
          if (paramInt != 0)
          {
            str = d.this.TAG;
            localStringBuilder = new StringBuilder("onreaddata request more data ret:").append(paramInt).append(" state:").append(d.this.wLf).append(' ').append(this.mediaId).append(", ret:").append(paramInt).append(", exists:").append(bool1).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(", cache:");
            if (locala != null)
            {
              localObject = Long.valueOf(locala.cacheSize);
              Log.d(str, localObject);
              e.wLs.dMk().wLp.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong1 + paramLong2));
              d.b(d.this, 0L);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(241146);
            return 0;
            localObject = null;
            break;
            d.a(d.this, paramLong1);
            d.b(d.this, paramLong2);
          }
        }
        AppMethodBeat.o(241146);
        return 0;
        bool1 = false;
      }
    }
    
    public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(241145);
      Log.d(d.this.TAG, "[onStartReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " fileId: " + paramInt);
      paramInt = this.mediaId.hashCode();
      AppMethodBeat.o(241145);
      return paramInt;
    }
    
    public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(241147);
      Log.d(d.this.TAG, "[onStopReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " taskId: " + paramInt1);
      AppMethodBeat.o(241147);
      return 0;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(d.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(241144);
        h localh = d.b(this.wLn.wLm);
        if (localh != null)
        {
          localh.c(false, 2);
          AppMethodBeat.o(241144);
          return;
        }
        AppMethodBeat.o(241144);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class c
    implements ITPPlayerListener.IOnPreparedListener
  {
    c(d paramd) {}
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(241151);
      Log.i(this.wLm.TAG, "FVPlayer video_status " + paramITPPlayer + " prepared");
      this.wLm.ZA = true;
      paramITPPlayer = d.b(this.wLm);
      if (paramITPPlayer != null) {
        paramITPPlayer.c(false, 3);
      }
      com.tencent.mm.plugin.report.service.h.CyF.dN(1414, 0);
      AppMethodBeat.o(241151);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "errorType", "", "errorCode", "arg1", "", "arg2", "onError"})
  static final class d
    implements ITPPlayerListener.IOnErrorListener
  {
    d(d paramd) {}
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(241152);
      Log.e(this.wLm.TAG, "tplayer log " + paramITPPlayer + " error " + paramInt1 + ' ' + paramInt2);
      paramITPPlayer = d.b(this.wLm);
      if (paramITPPlayer != null) {
        paramITPPlayer.c(paramInt2, paramInt1, "视频加载失败，请检查网络连接后重试", "重试");
      }
      com.tencent.mm.plugin.report.service.h.CyF.dN(1414, 1);
      AppMethodBeat.o(241152);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class e
    implements ITPPlayerListener.IOnCompletionListener
  {
    e(d paramd) {}
    
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(241153);
      Log.i(this.wLm.TAG, paramITPPlayer + " on complete");
      paramITPPlayer = d.b(this.wLm);
      if (paramITPPlayer != null)
      {
        paramITPPlayer.c(false, 4);
        AppMethodBeat.o(241153);
        return;
      }
      AppMethodBeat.o(241153);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class f
    implements ITPPlayerListener.IOnSeekCompleteListener
  {
    f(d paramd) {}
    
    public final void onSeekComplete(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(241154);
      Log.i(this.wLm.TAG, paramITPPlayer + " on seek");
      AppMethodBeat.o(241154);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "preState", "", "curState", "onStateChange"})
  static final class g
    implements ITPPlayerListener.IOnStateChangeListener
  {
    g(d paramd) {}
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(241155);
      Log.i(this.wLm.TAG, d.a(this.wLm) + " prestate: " + paramInt1 + ", curState: " + paramInt2);
      this.wLm.wLf = paramInt2;
      switch (paramInt2)
      {
      }
      h localh;
      do
      {
        AppMethodBeat.o(241155);
        return;
        localh = d.b(this.wLm);
      } while (localh == null);
      localh.c(false, 5);
      AppMethodBeat.o(241155);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "what", "", "arg1", "", "arg2", "extraObject", "", "onInfo"})
  static final class h
    implements ITPPlayerListener.IOnInfoListener
  {
    h(d paramd) {}
    
    public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(241156);
      Log.i(this.wLm.TAG, "tplayer log " + paramITPPlayer + ", msg:" + paramInt);
      switch (paramInt)
      {
      }
      do
      {
        AppMethodBeat.o(241156);
        return;
        Log.i(this.wLm.TAG, "video_status need buffer: " + paramITPPlayer + " mediaId:" + this.wLm.mediaId);
        paramITPPlayer = d.b(this.wLm);
        if (paramITPPlayer != null)
        {
          paramITPPlayer.c(false, 7);
          AppMethodBeat.o(241156);
          return;
        }
        AppMethodBeat.o(241156);
        return;
        Log.i(this.wLm.TAG, "video_status buffer ok: ".concat(String.valueOf(paramITPPlayer)));
        paramITPPlayer = d.b(this.wLm);
      } while (paramITPPlayer == null);
      paramITPPlayer.c(false, 8);
      AppMethodBeat.o(241156);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.f.d
 * JD-Core Version:    0.7.0.1
 */