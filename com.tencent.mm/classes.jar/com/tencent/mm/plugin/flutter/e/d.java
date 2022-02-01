package com.tencent.mm.plugin.flutter.e;

import android.content.Context;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.e.a.a;
import kotlin.Metadata;
import kotlin.ak;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer;", "Lcom/tencent/mm/plugin/flutter/video/IVideoPlayer;", "_context", "Landroid/content/Context;", "_path", "", "(Landroid/content/Context;Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "cacheFilePath", "getCacheFilePath", "setCacheFilePath", "(Ljava/lang/String;)V", "cdnDownloadProxy", "Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "getCdnDownloadProxy", "()Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;", "setCdnDownloadProxy", "(Lcom/tencent/mm/plugin/flutter/video/FlutterVideoPlayer$ResourceLoaderProxy;)V", "cdnTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getCdnTask", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setCdnTask", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "context", "downloadingMode", "", "getDownloadingMode", "()I", "setDownloadingMode", "(I)V", "isPrepared", "", "()Z", "setPrepared", "(Z)V", "mListener", "Lcom/tencent/mm/plugin/flutter/video/IVideoPlayerEventListener;", "mediaId", "getMediaId", "setMediaId", "mediaPlayer", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "playerState", "getPlayerState", "setPlayerState", "rangeLength", "", "rangeOffset", "url", "addListener", "", "listener", "changeSurface", "_surface", "Landroid/view/Surface;", "getBufferedPercentage", "getCurrPlayMs", "getCurrentPosition", "getDurationMs", "getHeight", "getPlayRate", "", "getVideoPath", "getWidth", "info", "initPlayer", "pause", "prepare", "release", "seek", "mSec", "seekMs", "isPrecision", "setAudioAttributes", "setLooping", "loop", "setMute", "mute", "setPath", "dataSource", "setPlayRate", "rate", "setPlayerCallback", "_callback", "Lcom/tencent/mm/plugin/mmplayer/IPlayerCallback;", "setSurface", "setVolume", "volume", "", "start", "stop", "Companion", "ResourceLoaderProxy", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements g
{
  public static final d.a HlH;
  private static Boolean HlO;
  int GuE;
  private ITPPlayer HlI;
  private h HlJ;
  private String HlK;
  private int HlL;
  private long HlM;
  private d.b HlN;
  final String TAG;
  private long cAQ;
  private Context context;
  private boolean hS;
  private String mediaId;
  private String url;
  
  static
  {
    AppMethodBeat.i(263180);
    HlH = new d.a((byte)0);
    HlO = Boolean.FALSE;
    AppMethodBeat.o(263180);
  }
  
  public d(Context paramContext, String paramString)
  {
    AppMethodBeat.i(263076);
    this.TAG = "MicroMsg.FlutterVideoPlayer";
    this.context = paramContext;
    this.HlK = paramString;
    paramContext = HlO;
    s.checkNotNull(paramContext);
    if (!paramContext.booleanValue())
    {
      HlO = Boolean.TRUE;
      TPPlayerMgr.initSdk(this.context, "60303", 1);
      TPPlayerMgr.setProxyEnable(true);
      TPPlayerMgr.setProxyServiceType(100);
    }
    this.HlI = TPPlayerFactory.createTPPlayer(this.context);
    paramContext = this.HlI;
    if (paramContext != null) {
      paramContext.setOnPreparedListener(new d..ExternalSyntheticLambda3(this));
    }
    paramContext = this.HlI;
    if (paramContext != null) {
      paramContext.setOnErrorListener(new d..ExternalSyntheticLambda1(this));
    }
    paramContext = this.HlI;
    if (paramContext != null) {
      paramContext.setOnCompletionListener(new d..ExternalSyntheticLambda0(this));
    }
    paramContext = this.HlI;
    if (paramContext != null) {
      paramContext.setOnSeekCompleteListener(new d..ExternalSyntheticLambda4(this));
    }
    paramContext = this.HlI;
    if (paramContext != null) {
      paramContext.setOnPlayerStateChangeListener(new d..ExternalSyntheticLambda5(this));
    }
    paramContext = this.HlI;
    if (paramContext != null) {
      paramContext.setOnInfoListener(new d..ExternalSyntheticLambda2(this));
    }
    AppMethodBeat.o(263076);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(263082);
    s.u(paramd, "this$0");
    paramd = paramd.HlJ;
    if (paramd != null) {
      paramd.onPlayerStateChanged(false, 2);
    }
    AppMethodBeat.o(263082);
  }
  
  private static final void a(d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263122);
    s.u(paramd, "this$0");
    Log.i(paramd.TAG, paramd.HlI + " prestate: " + paramInt1 + ", curState: " + paramInt2);
    paramd.GuE = paramInt2;
    if (paramInt2 == 3)
    {
      paramd = paramd.HlJ;
      if (paramd != null) {
        paramd.onPlayerStateChanged(false, 5);
      }
    }
    AppMethodBeat.o(263122);
  }
  
  private static final void a(d paramd, ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(263090);
    s.u(paramd, "this$0");
    Log.i(paramd.TAG, "FVPlayer video_status " + paramITPPlayer + " prepared");
    paramd.hS = true;
    paramITPPlayer = paramd.HlJ;
    if (paramITPPlayer != null) {
      paramITPPlayer.onPlayerStateChanged(false, 3);
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1414, 0);
    com.tencent.threadpool.h.ahAA.bk(new d..ExternalSyntheticLambda6(paramd));
    AppMethodBeat.o(263090);
  }
  
  private static final void a(d paramd, ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(263099);
    s.u(paramd, "this$0");
    Log.e(paramd.TAG, "tplayer log " + paramITPPlayer + " error " + paramInt1 + ' ' + paramInt2);
    paramd = paramd.HlJ;
    if (paramd != null) {
      paramd.e(paramInt2, paramInt1, "视频加载失败，请检查网络连接后重试", "重试");
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1414, 1);
    AppMethodBeat.o(263099);
  }
  
  private static final void a(d paramd, ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(263132);
    s.u(paramd, "this$0");
    Log.i(paramd.TAG, "tplayer log " + paramITPPlayer + ", msg:" + paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(263132);
      return;
      Log.i(paramd.TAG, "video_status need buffer: " + paramITPPlayer + " mediaId:" + paramd.mediaId);
      paramd = paramd.HlJ;
      if (paramd != null)
      {
        paramd.onPlayerStateChanged(false, 7);
        AppMethodBeat.o(263132);
        return;
        Log.i(paramd.TAG, s.X("video_status buffer ok: ", paramITPPlayer));
        paramd = paramd.HlJ;
        if (paramd != null) {
          paramd.onPlayerStateChanged(false, 8);
        }
      }
    }
  }
  
  private static final void b(d paramd, ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(263107);
    s.u(paramd, "this$0");
    Log.i(paramd.TAG, paramITPPlayer + " on complete");
    paramd = paramd.HlJ;
    if (paramd != null) {
      paramd.onPlayerStateChanged(false, 4);
    }
    AppMethodBeat.o(263107);
  }
  
  private static final void c(d paramd, ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(263116);
    s.u(paramd, "this$0");
    Log.i(paramd.TAG, paramITPPlayer + " on seek");
    paramd = paramd.HlJ;
    if (paramd != null) {
      paramd.onPlayerStateChanged(false, 9);
    }
    AppMethodBeat.o(263116);
  }
  
  public final void M(double paramDouble)
  {
    AppMethodBeat.i(263258);
    Log.d(this.TAG, "setVolume");
    ITPPlayer localITPPlayer = this.HlI;
    if (localITPPlayer != null) {
      localITPPlayer.setAudioGainRatio((float)paramDouble);
    }
    AppMethodBeat.o(263258);
  }
  
  public final void a(h paramh)
  {
    this.HlJ = paramh;
  }
  
  public final int getBufferedPercentage()
  {
    Object localObject2 = null;
    AppMethodBeat.i(263312);
    b.a locala = e.HlR.fvk().HlT.aDD(this.mediaId);
    Object localObject1;
    if (locala == null)
    {
      localObject1 = null;
      if (locala != null) {
        break label99;
      }
    }
    for (;;)
    {
      s.checkNotNull(localObject1);
      if (((Long)localObject1).longValue() <= 0L) {
        break label111;
      }
      s.checkNotNull(localObject2);
      if (((Long)localObject2).longValue() <= 0L) {
        break label111;
      }
      int i = (int)(((Long)localObject1).longValue() * 100L / ((Long)localObject2).longValue());
      AppMethodBeat.o(263312);
      return i;
      localObject1 = Long.valueOf(locala.wbD);
      break;
      label99:
      localObject2 = Long.valueOf(locala.uWn);
    }
    label111:
    AppMethodBeat.o(263312);
    return 0;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(263234);
    ITPPlayer localITPPlayer = this.HlI;
    if (localITPPlayer == null)
    {
      AppMethodBeat.o(263234);
      return 0L;
    }
    long l = localITPPlayer.getCurrentPositionMs();
    AppMethodBeat.o(263234);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(263283);
    String str = this.TAG;
    Object localObject = this.HlI;
    if (localObject == null) {}
    for (localObject = null;; localObject = Long.valueOf(((ITPPlayer)localObject).getDurationMs()))
    {
      Log.d(str, s.X("getDurationMs: ", localObject));
      localObject = this.HlI;
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(263283);
      return 0L;
    }
    long l = ((ITPPlayer)localObject).getDurationMs();
    AppMethodBeat.o(263283);
    return l;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(263263);
    ITPPlayer localITPPlayer = this.HlI;
    if (localITPPlayer == null)
    {
      AppMethodBeat.o(263263);
      return 0;
    }
    int i = localITPPlayer.getVideoHeight();
    AppMethodBeat.o(263263);
    return i;
  }
  
  public final String getVideoPath()
  {
    return this.url;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(263288);
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("getWidth ").append(this.HlI).append("  ");
    ITPPlayer localITPPlayer = this.HlI;
    if (localITPPlayer == null) {}
    for (int i = 0;; i = localITPPlayer.getVideoWidth())
    {
      Log.d((String)localObject, i);
      localObject = this.HlI;
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(263288);
      return 0;
    }
    i = ((ITPPlayer)localObject).getVideoWidth();
    AppMethodBeat.o(263288);
    return i;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(263269);
    Log.d(this.TAG, "video_status pause " + this.HlI + ", mediaId:" + this.mediaId + ", url:" + this.url);
    ITPPlayer localITPPlayer = this.HlI;
    if (localITPPlayer != null) {
      localITPPlayer.pause();
    }
    localITPPlayer = this.HlI;
    if (localITPPlayer != null) {
      localITPPlayer.pauseDownload();
    }
    AppMethodBeat.o(263269);
  }
  
  public final boolean prepare()
  {
    AppMethodBeat.i(263245);
    Object localObject1 = this.mediaId;
    s.checkNotNull(localObject1);
    Object localObject2 = this.HlK;
    s.checkNotNull(localObject2);
    this.HlN = new d.b(this, (String)localObject1, (String)localObject2);
    localObject1 = this.HlI;
    if (localObject1 != null) {
      ((ITPPlayer)localObject1).enableTPAssetResourceLoader((a)this.HlN);
    }
    Log.d(this.TAG, "video_status prepare url: " + this.url + ", media:" + this.mediaId);
    if (this.GuE < 3)
    {
      localObject1 = e.HlR.fvk().HlT.aDD(this.mediaId);
      localObject2 = new TPVideoInfo.Builder();
      ((TPVideoInfo.Builder)localObject2).fileId(this.mediaId);
      ((TPVideoInfo.Builder)localObject2).downloadParam(new TPDownloadParamData(11));
      ITPPlayer localITPPlayer = this.HlI;
      if (localITPPlayer != null) {
        localITPPlayer.setVideoInfo(((TPVideoInfo.Builder)localObject2).build());
      }
      if ((localObject1 == null) || (!((b.a)localObject1).cUO))
      {
        localObject1 = this.HlI;
        if (localObject1 != null) {
          ((ITPPlayer)localObject1).setDataSource(this.url);
        }
        localObject1 = this.HlI;
        if (localObject1 != null) {
          ((ITPPlayer)localObject1).prepareAsync();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(263245);
      return true;
      localObject2 = this.HlI;
      if (localObject2 == null) {
        break;
      }
      ((ITPPlayer)localObject2).setDataSource(((b.a)localObject1).path);
      break;
      Log.d(this.TAG, "video_status prepare playerState " + this.GuE + ' ');
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(263327);
    Log.d(this.TAG, "video_status release " + this.HlI + " , url: " + this.url);
    ITPPlayer localITPPlayer = this.HlI;
    if (localITPPlayer != null) {
      localITPPlayer.setSurface(null);
    }
    localITPPlayer = this.HlI;
    if (localITPPlayer != null) {
      localITPPlayer.release();
    }
    AppMethodBeat.o(263327);
  }
  
  public final void seek(int paramInt)
  {
    AppMethodBeat.i(263226);
    Log.i(this.TAG, "video_status seek " + this.HlI + ", state: " + this.GuE);
    if (this.GuE < 4)
    {
      Log.e(this.TAG, "video_status wrong seek");
      AppMethodBeat.o(263226);
      return;
    }
    ITPPlayer localITPPlayer = this.HlI;
    if (localITPPlayer != null) {
      localITPPlayer.resumeDownload();
    }
    localITPPlayer = this.HlI;
    if (localITPPlayer != null) {
      localITPPlayer.seekTo(paramInt);
    }
    AppMethodBeat.o(263226);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(263292);
    ITPPlayer localITPPlayer = this.HlI;
    if (localITPPlayer != null) {
      localITPPlayer.setLoopback(paramBoolean);
    }
    AppMethodBeat.o(263292);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(263277);
    Log.d(this.TAG, "setMute %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ITPPlayer localITPPlayer = this.HlI;
    if (localITPPlayer != null) {
      localITPPlayer.setOutputMute(paramBoolean);
    }
    AppMethodBeat.o(263277);
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(263319);
    Log.d(this.TAG, "setPath mediaId:" + this.mediaId + " dataSource:" + paramString + ' ');
    this.url = paramString;
    paramString = this.url;
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      this.mediaId = com.tencent.mm.b.g.getMessageDigest(paramString);
      AppMethodBeat.o(263319);
      return;
      paramString = paramString.getBytes(kotlin.n.d.UTF_8);
      s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    }
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(263296);
    Object localObject = this.TAG;
    if (paramSurface != null) {}
    for (int i = paramSurface.hashCode();; i = 0)
    {
      Log.d((String)localObject, "setSurface %s", new Object[] { Integer.valueOf(i) });
      localObject = this.HlI;
      if (localObject != null) {
        ((ITPPlayer)localObject).setSurface(paramSurface);
      }
      AppMethodBeat.o(263296);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(263251);
    Log.d(this.TAG, "video_status play " + this.HlI + ", mediaId:" + this.mediaId + ", download: " + this.HlL + " state:" + this.GuE + " : " + this.url);
    if (this.GuE == 5)
    {
      Log.d(this.TAG, s.X("video_status already playing ", this.HlI));
      AppMethodBeat.o(263251);
      return;
    }
    if (this.GuE >= 4) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      localObject = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(263251);
      throw ((Throwable)localObject);
    }
    Object localObject = this.HlI;
    if (localObject != null) {
      ((ITPPlayer)localObject).resumeDownload();
    }
    localObject = this.HlI;
    if (localObject != null) {
      ((ITPPlayer)localObject).start();
    }
    AppMethodBeat.o(263251);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(263302);
    Log.d(this.TAG, "video_status stop: " + this.HlI + " , url: " + this.url);
    ITPPlayer localITPPlayer = this.HlI;
    if (localITPPlayer != null) {
      localITPPlayer.stop();
    }
    AppMethodBeat.o(263302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.e.d
 * JD-Core Version:    0.7.0.1
 */