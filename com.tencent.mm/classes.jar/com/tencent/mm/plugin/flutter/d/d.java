package com.tencent.mm.plugin.flutter.d;

import android.content.Context;
import android.view.Surface;
import com.tencent.e.i;
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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.z;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer;", "Lcom/tencent/mm/plugin/flutter/video/IVideoPlayer;", "_context", "Landroid/content/Context;", "_path", "", "(Landroid/content/Context;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "cacheFilePath", "getCacheFilePath", "setCacheFilePath", "(Ljava/lang/String;)V", "cdnDownloadProxy", "Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "getCdnDownloadProxy", "()Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "setCdnDownloadProxy", "(Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;)V", "cdnTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getCdnTask", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setCdnTask", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "context", "downloadingMode", "", "getDownloadingMode", "()I", "setDownloadingMode", "(I)V", "isPrepared", "", "()Z", "setPrepared", "(Z)V", "mListener", "Lcom/tencent/mm/plugin/flutter/video/IVideoPlayerEventListener;", "mediaId", "getMediaId", "setMediaId", "mediaPlayer", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "playerState", "getPlayerState", "setPlayerState", "rangeLength", "", "rangeOffset", "url", "addListener", "", "listener", "changeSurface", "_surface", "Landroid/view/Surface;", "getBufferedPercentage", "getCurrPlayMs", "getCurrentPosition", "getDurationMs", "getHeight", "getPlayRate", "", "getVideoPath", "getWidth", "info", "initPlayer", "pause", "prepare", "release", "seek", "mSec", "seekMs", "isPrecision", "setAudioAttributes", "setLooping", "loop", "setMute", "mute", "setPath", "dataSource", "setPlayRate", "rate", "setPlayerCallback", "_callback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "setSurface", "setVolume", "volume", "", "start", "stop", "Companion", "ResourceLoaderProxy", "plugin-flutter_release"})
public final class d
  implements g
{
  private static Boolean BDf;
  public static final d.a BDg;
  int ASE;
  private ITPPlayer BCZ;
  private h BDa;
  private String BDb;
  private int BDc;
  private long BDd;
  private b BDe;
  final String TAG;
  private long aFe;
  private Context context;
  boolean gX;
  String mediaId;
  private String url;
  
  static
  {
    AppMethodBeat.i(221281);
    BDg = new d.a((byte)0);
    BDf = Boolean.FALSE;
    AppMethodBeat.o(221281);
  }
  
  public d(Context paramContext, String paramString)
  {
    AppMethodBeat.i(221279);
    this.TAG = "MicroMsg.FlutterVideoPlayer";
    this.context = paramContext;
    this.BDb = paramString;
    paramContext = BDf;
    if (paramContext == null) {
      p.iCn();
    }
    if (!paramContext.booleanValue())
    {
      BDf = Boolean.TRUE;
      TPPlayerMgr.initSdk(this.context, "60303", 1);
      TPPlayerMgr.setProxyEnable(true);
      TPPlayerMgr.setProxyServiceType(100);
    }
    this.BCZ = TPPlayerFactory.createTPPlayer(this.context);
    paramContext = this.BCZ;
    if (paramContext != null) {
      paramContext.setOnPreparedListener((ITPPlayerListener.IOnPreparedListener)new c(this));
    }
    paramContext = this.BCZ;
    if (paramContext != null) {
      paramContext.setOnErrorListener((ITPPlayerListener.IOnErrorListener)new d(this));
    }
    paramContext = this.BCZ;
    if (paramContext != null) {
      paramContext.setOnCompletionListener((ITPPlayerListener.IOnCompletionListener)new e(this));
    }
    paramContext = this.BCZ;
    if (paramContext != null) {
      paramContext.setOnSeekCompleteListener((ITPPlayerListener.IOnSeekCompleteListener)new f(this));
    }
    paramContext = this.BCZ;
    if (paramContext != null) {
      paramContext.setOnPlayerStateChangeListener((ITPPlayerListener.IOnStateChangeListener)new g(this));
    }
    paramContext = this.BCZ;
    if (paramContext != null)
    {
      paramContext.setOnInfoListener((ITPPlayerListener.IOnInfoListener)new h(this));
      AppMethodBeat.o(221279);
      return;
    }
    AppMethodBeat.o(221279);
  }
  
  public final void a(h paramh)
  {
    this.BDa = paramh;
  }
  
  public final int getBufferedPercentage()
  {
    Long localLong2 = null;
    AppMethodBeat.i(221251);
    b.a locala = e.BDo.eqd().BDl.aHl(this.mediaId);
    if (locala != null) {}
    for (Long localLong1 = Long.valueOf(locala.sXm);; localLong1 = null)
    {
      if (locala != null) {
        localLong2 = Long.valueOf(locala.rKZ);
      }
      if (localLong1 == null) {
        p.iCn();
      }
      if (localLong1.longValue() <= 0L) {
        break;
      }
      if (localLong2 == null) {
        p.iCn();
      }
      if (localLong2.longValue() <= 0L) {
        break;
      }
      int i = (int)(localLong1.longValue() * 100L / localLong2.longValue());
      AppMethodBeat.o(221251);
      return i;
    }
    AppMethodBeat.o(221251);
    return 0;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(221192);
    ITPPlayer localITPPlayer = this.BCZ;
    if (localITPPlayer != null)
    {
      long l = localITPPlayer.getCurrentPositionMs();
      AppMethodBeat.o(221192);
      return l;
    }
    AppMethodBeat.o(221192);
    return 0L;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(221227);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("getDurationMs: ");
    Object localObject = this.BCZ;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((ITPPlayer)localObject).getDurationMs());; localObject = null)
    {
      Log.d(str, localObject);
      localObject = this.BCZ;
      if (localObject == null) {
        break;
      }
      long l = ((ITPPlayer)localObject).getDurationMs();
      AppMethodBeat.o(221227);
      return l;
    }
    AppMethodBeat.o(221227);
    return 0L;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(221220);
    ITPPlayer localITPPlayer = this.BCZ;
    if (localITPPlayer != null)
    {
      int i = localITPPlayer.getVideoHeight();
      AppMethodBeat.o(221220);
      return i;
    }
    AppMethodBeat.o(221220);
    return 0;
  }
  
  public final String getVideoPath()
  {
    return this.url;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(221230);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("getWidth ").append(this.BCZ).append("  ");
    ITPPlayer localITPPlayer = this.BCZ;
    if (localITPPlayer != null) {}
    for (int i = localITPPlayer.getVideoWidth();; i = 0)
    {
      Log.d((String)localObject, i);
      localObject = this.BCZ;
      if (localObject == null) {
        break;
      }
      i = ((ITPPlayer)localObject).getVideoWidth();
      AppMethodBeat.o(221230);
      return i;
    }
    AppMethodBeat.o(221230);
    return 0;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(221222);
    Log.d(this.TAG, "video_status pause " + this.BCZ + ", mediaId:" + this.mediaId + ", url:" + this.url);
    ITPPlayer localITPPlayer = this.BCZ;
    if (localITPPlayer != null) {
      localITPPlayer.pause();
    }
    localITPPlayer = this.BCZ;
    if (localITPPlayer != null)
    {
      localITPPlayer.pauseDownload();
      AppMethodBeat.o(221222);
      return;
    }
    AppMethodBeat.o(221222);
  }
  
  public final boolean prepare()
  {
    AppMethodBeat.i(221205);
    Object localObject1 = this.mediaId;
    if (localObject1 == null) {
      p.iCn();
    }
    Object localObject2 = this.BDb;
    if (localObject2 == null) {
      p.iCn();
    }
    this.BDe = new b((String)localObject1, (String)localObject2);
    localObject1 = this.BCZ;
    if (localObject1 != null) {
      ((ITPPlayer)localObject1).enableTPAssetResourceLoader((com.tencent.thumbplayer.e.a.a)this.BDe);
    }
    Log.d(this.TAG, "video_status prepare url: " + this.url + ", media:" + this.mediaId);
    if (this.ASE < 3)
    {
      localObject1 = e.BDo.eqd().BDl.aHl(this.mediaId);
      localObject2 = new TPVideoInfo.Builder();
      ((TPVideoInfo.Builder)localObject2).fileId(this.mediaId);
      ((TPVideoInfo.Builder)localObject2).downloadParam(new TPDownloadParamData(11));
      ITPPlayer localITPPlayer = this.BCZ;
      if (localITPPlayer != null) {
        localITPPlayer.setVideoInfo(((TPVideoInfo.Builder)localObject2).build());
      }
      if ((localObject1 == null) || (!((b.a)localObject1).baT))
      {
        localObject1 = this.BCZ;
        if (localObject1 != null) {
          ((ITPPlayer)localObject1).setDataSource(this.url);
        }
        localObject1 = this.BCZ;
        if (localObject1 != null) {
          ((ITPPlayer)localObject1).prepareAsync();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(221205);
      return true;
      localObject2 = this.BCZ;
      if (localObject2 == null) {
        break;
      }
      ((ITPPlayer)localObject2).setDataSource(((b.a)localObject1).path);
      break;
      Log.d(this.TAG, "video_status prepare playerState " + this.ASE + ' ');
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(221260);
    Log.d(this.TAG, "video_status release " + this.BCZ + " , url: " + this.url);
    ITPPlayer localITPPlayer = this.BCZ;
    if (localITPPlayer != null) {
      localITPPlayer.setSurface(null);
    }
    localITPPlayer = this.BCZ;
    if (localITPPlayer != null)
    {
      localITPPlayer.release();
      AppMethodBeat.o(221260);
      return;
    }
    AppMethodBeat.o(221260);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(221187);
    Log.i(this.TAG, "video_status seek " + this.BCZ + ", state: " + this.ASE);
    if (this.ASE < 4)
    {
      Log.e(this.TAG, "video_status wrong seek");
      AppMethodBeat.o(221187);
      return;
    }
    ITPPlayer localITPPlayer = this.BCZ;
    if (localITPPlayer != null) {
      localITPPlayer.resumeDownload();
    }
    localITPPlayer = this.BCZ;
    if (localITPPlayer != null)
    {
      localITPPlayer.seekTo(paramInt);
      AppMethodBeat.o(221187);
      return;
    }
    AppMethodBeat.o(221187);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(221235);
    ITPPlayer localITPPlayer = this.BCZ;
    if (localITPPlayer != null)
    {
      localITPPlayer.setLoopback(paramBoolean);
      AppMethodBeat.o(221235);
      return;
    }
    AppMethodBeat.o(221235);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(221256);
    Log.d(this.TAG, "setPath mediaId:" + this.mediaId + " dataSource:" + paramString + ' ');
    this.url = paramString;
    paramString = this.url;
    if (paramString != null)
    {
      Charset localCharset = kotlin.n.d.UTF_8;
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(221256);
        throw paramString;
      }
      paramString = paramString.getBytes(localCharset);
      p.j(paramString, "(this as java.lang.String).getBytes(charset)");
    }
    for (;;)
    {
      this.mediaId = com.tencent.mm.b.g.getMessageDigest(paramString);
      AppMethodBeat.o(221256);
      return;
      paramString = null;
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(221238);
    Object localObject = this.TAG;
    if (paramSurface != null) {}
    for (int i = paramSurface.hashCode();; i = 0)
    {
      Log.d((String)localObject, "setSurface %s", new Object[] { Integer.valueOf(i) });
      localObject = this.BCZ;
      if (localObject == null) {
        break;
      }
      ((ITPPlayer)localObject).setSurface(paramSurface);
      AppMethodBeat.o(221238);
      return;
    }
    AppMethodBeat.o(221238);
  }
  
  public final void start()
  {
    AppMethodBeat.i(221214);
    Log.d(this.TAG, "video_status play " + this.BCZ + ", mediaId:" + this.mediaId + ", download: " + this.BDc + " state:" + this.ASE + " : " + this.url);
    if (this.ASE == 5)
    {
      Log.d(this.TAG, "video_status already playing " + this.BCZ);
      AppMethodBeat.o(221214);
      return;
    }
    if (this.ASE >= 4) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      localObject = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(221214);
      throw ((Throwable)localObject);
    }
    Object localObject = this.BCZ;
    if (localObject != null) {
      ((ITPPlayer)localObject).resumeDownload();
    }
    localObject = this.BCZ;
    if (localObject != null)
    {
      ((ITPPlayer)localObject).start();
      AppMethodBeat.o(221214);
      return;
    }
    AppMethodBeat.o(221214);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(221240);
    Log.d(this.TAG, "video_status stop: " + this.BCZ + " , url: " + this.url);
    ITPPlayer localITPPlayer = this.BCZ;
    if (localITPPlayer != null)
    {
      localITPPlayer.stop();
      AppMethodBeat.o(221240);
      return;
    }
    AppMethodBeat.o(221240);
  }
  
  public final void u(double paramDouble)
  {
    AppMethodBeat.i(221218);
    Log.d(this.TAG, "setVolume");
    ITPPlayer localITPPlayer = this.BCZ;
    if (localITPPlayer != null)
    {
      localITPPlayer.setAudioGainRatio((float)paramDouble);
      AppMethodBeat.o(221218);
      return;
    }
    AppMethodBeat.o(221218);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "Lplatform/android/ThumbPlayerAndroid/src/main/java/com/tencent/thumbplayer/datatransport/resourceloader/AbsTPAssetResourceLoader;", "mediaId", "", "path", "(Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer;Ljava/lang/String;Ljava/lang/String;)V", "acacheSize", "", "getAcacheSize", "()J", "setAcacheSize", "(J)V", "getMediaId", "()Ljava/lang/String;", "getPath", "getContentType", "fileId", "", "fileKey", "getDataFilePath", "getDataTotalSize", "onReadData", "offset", "length", "onStartReadData", "requestStart", "requestEnd", "onStopReadData", "requestId", "plugin-flutter_release"})
  public final class b
    extends h.a.a.a.a.a.a.a.a.a.a.a
  {
    private long BDh;
    private final String mediaId;
    private final String path;
    
    public b(String paramString)
    {
      AppMethodBeat.i(221089);
      this.mediaId = paramString;
      this.path = localObject;
      AppMethodBeat.o(221089);
    }
    
    public final String Rv(int paramInt)
    {
      AppMethodBeat.i(221083);
      Object localObject = e.BDo.eqd().BDl.aHl(this.mediaId);
      if (localObject != null) {}
      for (localObject = ((b.a)localObject).path;; localObject = null)
      {
        if (localObject == null) {
          p.iCn();
        }
        Log.d(d.this.TAG, "[getDataFilePath] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " fileId: " + paramInt + ", path: " + (String)localObject);
        AppMethodBeat.o(221083);
        return localObject;
      }
    }
    
    public final String getContentType(int paramInt, String paramString)
    {
      return "video/mp4";
    }
    
    public final long getDataTotalSize(int paramInt, String paramString)
    {
      AppMethodBeat.i(221076);
      paramString = e.BDo.eqd().BDl.aHl(this.mediaId);
      if (paramString != null) {}
      for (paramString = Long.valueOf(paramString.rKZ);; paramString = null)
      {
        if (paramString == null) {
          p.iCn();
        }
        long l = paramString.longValue();
        AppMethodBeat.o(221076);
        return l;
      }
    }
    
    public final int n(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(221071);
      Log.d(d.this.TAG, "[onReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " fileId: " + paramInt + " state:" + d.this.ASE);
      if (paramLong2 <= 0L)
      {
        Log.d(d.this.TAG, "FVPlayer onReadDate 0");
        AppMethodBeat.o(221071);
        return 0;
      }
      b.a locala = e.BDo.eqd().BDl.aHl(this.mediaId);
      if ((locala != null) && (this.BDh != locala.sXm))
      {
        this.BDh = locala.sXm;
        com.tencent.e.h.ZvG.bc((Runnable)new a(this));
      }
      if ((locala != null) && (locala.baT))
      {
        Log.d(d.this.TAG, "onreaddata completed");
        paramInt = (int)paramLong2;
        AppMethodBeat.o(221071);
        return paramInt;
      }
      boolean bool1;
      if (d.this.ASE != 6)
      {
        bool1 = CdnLogic.taskExist(this.mediaId);
        if (bool1)
        {
          boolean bool2 = CdnLogic.isVideoDataAvailable(this.mediaId, paramLong1, paramLong2);
          if (bool2)
          {
            Log.d(d.this.TAG, "FVPlayer onReadData isVideoDataAvailable " + bool2 + " offset:" + paramLong1 + " length:" + paramLong2 + " mediaId" + this.mediaId);
            paramInt = (int)paramLong2;
            AppMethodBeat.o(221071);
            return paramInt;
          }
        }
      }
      for (;;)
      {
        if ((d.this.ASE != 3) && (d.this.ASE != 5))
        {
          Log.v(d.this.TAG, "not in need data state, ignore, state:" + d.this.ASE + ", media:" + this.mediaId);
          AppMethodBeat.o(221071);
          return 0;
        }
        Object localObject;
        String str;
        StringBuilder localStringBuilder;
        if (d.this.ASE == 3)
        {
          if (locala != null) {}
          for (localObject = Long.valueOf(locala.BCQ);; localObject = null)
          {
            if (localObject == null) {
              p.iCn();
            }
            if (((Long)localObject).longValue() < paramLong1 + paramLong2) {
              break;
            }
            Log.v(d.this.TAG, "onreaddata preload enough: " + this.mediaId);
            paramInt = (int)paramLong2;
            AppMethodBeat.o(221071);
            return paramInt;
          }
          if (bool1)
          {
            if (locala != null) {
              localObject = Boolean.valueOf(locala.BCS);
            }
            for (;;)
            {
              if (((Boolean)localObject).booleanValue()) {
                if ((d.c(d.this) == paramLong1) && (d.d(d.this) == paramLong2))
                {
                  Log.d(d.this.TAG, "range(" + paramLong1 + ", " + paramLong2 + ") is already requesting");
                  AppMethodBeat.o(221071);
                  return 0;
                  localObject = null;
                }
                else
                {
                  paramInt = e.BDo.eqd().BDm.y(this.mediaId, paramLong1, paramLong2);
                  if (paramInt != 0)
                  {
                    str = d.this.TAG;
                    localStringBuilder = new StringBuilder("[key] request video data error ").append(this.mediaId).append(", ret:").append(paramInt).append(" state:").append(d.this.ASE).append(" exists:").append(bool1).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(", cache:");
                    if (locala != null)
                    {
                      localObject = Long.valueOf(locala.sXm);
                      Log.e(str, ((Long)localObject).longValue());
                      e.BDo.eqd().BDl.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong1 + paramLong2));
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
            AppMethodBeat.o(221071);
            return 0;
            localObject = null;
            break;
            d.a(d.this, paramLong1);
            d.b(d.this, paramLong2);
            continue;
            if (locala != null) {}
            for (localObject = Boolean.valueOf(locala.BCR);; localObject = null)
            {
              if (((Boolean)localObject).booleanValue()) {
                break label897;
              }
              e.BDo.eqd().BDl.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong1 + paramLong2));
              break;
            }
          }
        }
        if (d.this.ASE == 5)
        {
          if ((d.c(d.this) == paramLong1) && (d.d(d.this) == paramLong2))
          {
            Log.d(d.this.TAG, "range(" + paramLong1 + ", " + paramLong2 + ") is already requesting");
            AppMethodBeat.o(221071);
            return 0;
          }
          paramInt = e.BDo.eqd().BDm.y(this.mediaId, paramLong1, paramLong2);
          if (paramInt != 0)
          {
            str = d.this.TAG;
            localStringBuilder = new StringBuilder("onreaddata request more data ret:").append(paramInt).append(" state:").append(d.this.ASE).append(' ').append(this.mediaId).append(", ret:").append(paramInt).append(", exists:").append(bool1).append(", offset:").append(paramLong1).append(", length:").append(paramLong2).append(", cache:");
            if (locala != null)
            {
              localObject = Long.valueOf(locala.sXm);
              Log.d(str, localObject);
              e.BDo.eqd().BDl.a(d.e(d.this), this.mediaId, Long.valueOf(paramLong1 + paramLong2));
              d.b(d.this, 0L);
            }
          }
          for (;;)
          {
            AppMethodBeat.o(221071);
            return 0;
            localObject = null;
            break;
            d.a(d.this, paramLong1);
            d.b(d.this, paramLong2);
          }
        }
        AppMethodBeat.o(221071);
        return 0;
        bool1 = false;
      }
    }
    
    public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(221021);
      Log.d(d.this.TAG, "[onStartReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " fileId: " + paramInt);
      paramInt = this.mediaId.hashCode();
      AppMethodBeat.o(221021);
      return paramInt;
    }
    
    public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(221075);
      Log.d(d.this.TAG, "[onStopReadData] player: " + d.a(d.this) + " mediaId=" + this.mediaId + " taskId: " + paramInt1);
      AppMethodBeat.o(221075);
      return 0;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(d.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(220534);
        h localh = d.b(this.BDj.BDi);
        if (localh != null)
        {
          localh.e(false, 2);
          AppMethodBeat.o(220534);
          return;
        }
        AppMethodBeat.o(220534);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class c
    implements ITPPlayerListener.IOnPreparedListener
  {
    c(d paramd) {}
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(220889);
      Log.i(this.BDi.TAG, "FVPlayer video_status " + paramITPPlayer + " prepared");
      this.BDi.gX = true;
      paramITPPlayer = d.b(this.BDi);
      if (paramITPPlayer != null) {
        paramITPPlayer.e(false, 3);
      }
      com.tencent.mm.plugin.report.service.h.IzE.el(1414, 0);
      AppMethodBeat.o(220889);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "errorType", "", "errorCode", "arg1", "", "arg2", "onError"})
  static final class d
    implements ITPPlayerListener.IOnErrorListener
  {
    d(d paramd) {}
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(220988);
      Log.e(this.BDi.TAG, "tplayer log " + paramITPPlayer + " error " + paramInt1 + ' ' + paramInt2);
      paramITPPlayer = d.b(this.BDi);
      if (paramITPPlayer != null) {
        paramITPPlayer.d(paramInt2, paramInt1, "视频加载失败，请检查网络连接后重试", "重试");
      }
      com.tencent.mm.plugin.report.service.h.IzE.el(1414, 1);
      AppMethodBeat.o(220988);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class e
    implements ITPPlayerListener.IOnCompletionListener
  {
    e(d paramd) {}
    
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(221141);
      Log.i(this.BDi.TAG, paramITPPlayer + " on complete");
      paramITPPlayer = d.b(this.BDi);
      if (paramITPPlayer != null)
      {
        paramITPPlayer.e(false, 4);
        AppMethodBeat.o(221141);
        return;
      }
      AppMethodBeat.o(221141);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class f
    implements ITPPlayerListener.IOnSeekCompleteListener
  {
    f(d paramd) {}
    
    public final void onSeekComplete(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(220808);
      Log.i(this.BDi.TAG, paramITPPlayer + " on seek");
      AppMethodBeat.o(220808);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "preState", "", "curState", "onStateChange"})
  static final class g
    implements ITPPlayerListener.IOnStateChangeListener
  {
    g(d paramd) {}
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(220943);
      Log.i(this.BDi.TAG, d.a(this.BDi) + " prestate: " + paramInt1 + ", curState: " + paramInt2);
      this.BDi.ASE = paramInt2;
      switch (paramInt2)
      {
      }
      h localh;
      do
      {
        AppMethodBeat.o(220943);
        return;
        localh = d.b(this.BDi);
      } while (localh == null);
      localh.e(false, 5);
      AppMethodBeat.o(220943);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "what", "", "arg1", "", "arg2", "extraObject", "", "onInfo"})
  static final class h
    implements ITPPlayerListener.IOnInfoListener
  {
    h(d paramd) {}
    
    public final void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(221123);
      Log.i(this.BDi.TAG, "tplayer log " + paramITPPlayer + ", msg:" + paramInt);
      switch (paramInt)
      {
      }
      do
      {
        AppMethodBeat.o(221123);
        return;
        Log.i(this.BDi.TAG, "video_status need buffer: " + paramITPPlayer + " mediaId:" + this.BDi.mediaId);
        paramITPPlayer = d.b(this.BDi);
        if (paramITPPlayer != null)
        {
          paramITPPlayer.e(false, 7);
          AppMethodBeat.o(221123);
          return;
        }
        AppMethodBeat.o(221123);
        return;
        Log.i(this.BDi.TAG, "video_status buffer ok: ".concat(String.valueOf(paramITPPlayer)));
        paramITPPlayer = d.b(this.BDi);
      } while (paramITPPlayer == null);
      paramITPPlayer.e(false, 8);
      AppMethodBeat.o(221123);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.d
 * JD-Core Version:    0.7.0.1
 */