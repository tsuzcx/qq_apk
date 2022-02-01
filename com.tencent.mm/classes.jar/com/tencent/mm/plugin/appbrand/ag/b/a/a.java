package com.tencent.mm.plugin.appbrand.ag.b.a;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.composition.TPMediaCompositionFactory;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.d;
import kotlin.n.n;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/player/thumb/ThumbMediaPlayer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/BaseMediaPlayer;", "context", "Landroid/content/Context;", "mainLooper", "Landroid/os/Looper;", "mp4Only", "", "(Landroid/content/Context;Landroid/os/Looper;Z)V", "isBuffering", "isRealPlayerAvailable", "()Z", "isRealPlayerReleased", "isSeeking", "lastNotifiedBufferPercent", "", "Ljava/lang/Integer;", "myTag", "", "getMyTag", "()Ljava/lang/String;", "onCompletionListener", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnCompletionListener;", "onErrorListener", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnErrorListener;", "onInfoListener", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnInfoListener;", "onPlayerStateChangeListener", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "onPreparedListener", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnPreparedListener;", "onSeekCompleteListener", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnSeekCompleteListener;", "onVideoSizeChangedListener", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoSizeChangedListener;", "realPlayer", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "getRealPlayer", "()Lcom/tencent/thumbplayer/api/ITPPlayer;", "buildHeaders", "", "referrer", "canStart", "castTo", "PlayerImpl", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "playerClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "dispatchErrorWhenCaughtException", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getCurrentPosition", "getDuration", "getPlayerType", "getVideoHeight", "getVideoWidth", "isPlaying", "isPrepared", "isPreparing", "notifyOnBufferingUpdate", "percent", "notifyOnSeekComplete", "onTTPlayerInfoUpdate", "player", "what", "arg1", "", "arg2", "extraObject", "", "pause", "prepareAsync", "release", "reset", "seekTo", "msc", "setDataSource", "path", "useProxy", "downloadType", "videoType", "setDrmDataSource", "sourceUrl", "provisionUrl", "licenseUrl", "setLooping", "looping", "setMute", "mute", "setSpeed", "speed", "", "setSurface", "surface", "Landroid/view/Surface;", "setVolume", "left", "right", "start", "stop", "doIfAvailable", "R", "name", "defaultVal", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/thumbplayer/api/ITPPlayer;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "luggage-tp-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends com.tencent.mm.plugin.appbrand.jsapi.video.e.a
{
  private boolean cFq;
  private final String djQ;
  private volatile boolean msx;
  private final boolean usR;
  private final ITPPlayer usS;
  private volatile boolean usT;
  private Integer usU;
  private final ITPPlayerListener.IOnPreparedListener usV;
  private final ITPPlayerListener.IOnSeekCompleteListener usW;
  private final ITPPlayerListener.IOnCompletionListener usX;
  private final ITPPlayerListener.IOnVideoSizeChangedListener usY;
  private final ITPPlayerListener.IOnErrorListener usZ;
  private final ITPPlayerListener.IOnStateChangeListener uta;
  private final ITPPlayerListener.IOnInfoListener utb;
  
  public a(Context paramContext, Looper paramLooper, boolean paramBoolean)
  {
    AppMethodBeat.i(318030);
    this.usR = paramBoolean;
    this.djQ = s.X("MicroMsg.AppBrand.ThumbMediaPlayer#", Integer.valueOf(hashCode()));
    this.usV = new a..ExternalSyntheticLambda3(this);
    this.usW = new a..ExternalSyntheticLambda4(this);
    this.usX = new a..ExternalSyntheticLambda0(this);
    this.usY = new a..ExternalSyntheticLambda6(this);
    this.usZ = new a..ExternalSyntheticLambda1(this);
    this.uta = new a..ExternalSyntheticLambda5(this);
    Log.d(this.djQ, "init");
    c localc = c.utd;
    c.fq(paramContext);
    paramContext = TPPlayerFactory.createTPPlayer(paramContext, paramLooper);
    s.s(paramContext, "createTPPlayer(context, mainLooper)");
    this.usS = paramContext;
    this.usS.setOnPreparedListener(this.usV);
    this.usS.setOnSeekCompleteListener(this.usW);
    this.usS.setOnCompletionListener(this.usX);
    this.usS.setOnVideoSizeChangedListener(this.usY);
    this.usS.setOnErrorListener(this.usZ);
    this.usS.setOnPlayerStateChangeListener(this.uta);
    this.utb = new a..ExternalSyntheticLambda2(this);
    this.usS.setOnInfoListener(this.utb);
    setLooping(false);
    AppMethodBeat.o(318030);
  }
  
  private static final void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(318115);
    s.u(parama, "this$0");
    Log.d(parama.djQ, "onStateChange, preState: " + paramInt1 + ", curState: " + paramInt2);
    AppMethodBeat.o(318115);
  }
  
  private static final void a(a parama, ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(318077);
    s.u(parama, "this$0");
    Log.d(parama.djQ, "onPrepared");
    paramITPPlayer.pauseDownload();
    parama.sEu = 2;
    parama.cwu();
    AppMethodBeat.o(318077);
  }
  
  private static final void a(a parama, ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    int j = 0;
    AppMethodBeat.i(318107);
    s.u(parama, "this$0");
    Log.w(parama.djQ, "onError, errorType: " + paramInt1 + ", errorCode: " + paramInt2 + ", arg1: " + paramLong1 + ", arg2: " + paramLong2);
    if (1000 == paramInt2)
    {
      AppMethodBeat.o(318107);
      return;
    }
    if (1100 == paramInt1)
    {
      int i = j;
      if (11070000 <= paramInt2)
      {
        i = j;
        if (paramInt2 <= 11079999) {
          i = 1;
        }
      }
      if (i != 0)
      {
        parama.fB(-20000, paramInt2 - 11070000);
        AppMethodBeat.o(318107);
        return;
      }
    }
    parama.fB(-10000 - paramInt1, paramInt2);
    AppMethodBeat.o(318107);
  }
  
  private static final void a(a parama, ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    int j = 0;
    AppMethodBeat.i(318122);
    s.u(parama, "this$0");
    Log.d(parama.djQ, "onInfo, what: " + paramInt + ", arg1: " + paramLong1 + ", arg2: " + paramLong2 + ", extraObject: " + paramObject);
    if ((201 == paramInt) && (7 == parama.usS.getCurrentState()))
    {
      Log.i(parama.djQ, "onInfo, buffering end when COMPLETE, notify seek complete");
      parama.cww();
    }
    int i;
    switch (paramInt)
    {
    default: 
      i = -1;
      label147:
      if (-1 != i) {
        parama.fC(i, j);
      }
      if (1006 == paramInt)
      {
        if ((paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo)) {
          break label283;
        }
        Log.w(parama.djQ, "onInfo, extraObject is not TPDownLoadProgressInfo");
      }
      break;
    }
    for (;;)
    {
      s.s(paramITPPlayer, "ttplayer");
      parama.a(paramITPPlayer, paramInt, paramLong1, paramLong2, paramObject);
      AppMethodBeat.o(318122);
      return;
      i = 3;
      break label147;
      if ((parama.cNW()) || (parama.msx)) {
        break;
      }
      i = 701;
      j = b.a(parama.usS);
      parama.cFq = true;
      break label147;
      if (!parama.cFq) {
        break;
      }
      parama.cFq = false;
      i = 702;
      j = b.a(parama.usS);
      break label147;
      label283:
      parama.Bq(b.a(parama.usS));
    }
  }
  
  private static final void a(a parama, ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(318098);
    s.u(parama, "this$0");
    Log.d(parama.djQ, "onVideoSizeChanged, width: " + paramLong1 + ", height: " + paramLong2);
    parama.fA((int)paramLong1, (int)paramLong2);
    AppMethodBeat.o(318098);
  }
  
  private static final void b(a parama, ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(318084);
    s.u(parama, "this$0");
    Log.d(parama.djQ, "onSeekComplete");
    parama.cww();
    AppMethodBeat.o(318084);
  }
  
  private static final void c(a parama, ITPPlayer paramITPPlayer)
  {
    AppMethodBeat.i(318091);
    s.u(parama, "this$0");
    Log.d(parama.djQ, "onCompletion");
    parama.sEu = 6;
    parama.cwv();
    AppMethodBeat.o(318091);
  }
  
  private final boolean cNW()
  {
    AppMethodBeat.i(318050);
    if (3 == this.usS.getCurrentState())
    {
      AppMethodBeat.o(318050);
      return true;
    }
    AppMethodBeat.o(318050);
    return false;
  }
  
  private final boolean cNX()
  {
    AppMethodBeat.i(318068);
    switch (this.usS.getCurrentState())
    {
    default: 
      AppMethodBeat.o(318068);
      return false;
    }
    AppMethodBeat.o(318068);
    return true;
  }
  
  private final boolean cxs()
  {
    AppMethodBeat.i(318059);
    switch (this.usS.getCurrentState())
    {
    default: 
      AppMethodBeat.o(318059);
      return false;
    }
    AppMethodBeat.o(318059);
    return true;
  }
  
  public final void Bq(int paramInt)
  {
    AppMethodBeat.i(318186);
    Log.d(this.djQ, s.X("notifyOnBufferingUpdate, percent:", Integer.valueOf(paramInt)));
    Integer localInteger = this.usU;
    if (localInteger == null) {}
    for (;;)
    {
      super.Bq(paramInt);
      this.usU = Integer.valueOf(paramInt);
      do
      {
        AppMethodBeat.o(318186);
        return;
      } while (paramInt == localInteger.intValue());
    }
  }
  
  public final void M(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(318211);
    s.u(paramString1, "sourceUrl");
    ITPPlayer localITPPlayer = this.usS;
    Object localObject = ah.aiuX;
    int i;
    int j;
    if (cNV())
    {
      for (;;)
      {
        try
        {
          Log.d(this.djQ, "setDataSource");
          Log.d(this.djQ, "setDrmDataSource, sourceUrl: " + paramString1 + ", provisionUrl: " + paramString2 + ", licenseUrl: " + paramString3);
          if (n.U(paramString1, "file://", false))
          {
            paramString1 = paramString1.substring(7);
            s.s(paramString1, "(this as java.lang.String).substring(startIndex)");
            i = 1;
            localITPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000L).buildLong(504, 1L).buildBoolean(206, true));
            localObject = d.UTF_8;
            if (paramString1 != null) {
              break;
            }
            paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(318211);
            throw paramString1;
          }
        }
        catch (Exception paramString1)
        {
          Log.e(this.djQ, "setDataSource" + ", fail since " + paramString1);
          j(paramString1);
          AppMethodBeat.o(318211);
          return;
        }
        i = 0;
      }
      localObject = paramString1.getBytes((Charset)localObject);
      s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      localObject = com.tencent.mm.b.g.getMessageDigest((byte[])localObject);
      Log.i(this.djQ, s.X("setDrmDataSource, fileId: ", localObject));
      localObject = new TPVideoInfo.Builder().fileId((String)localObject);
      ((TPVideoInfo.Builder)localObject).downloadParam(new TPDownloadParamData(3));
      localITPPlayer.setVideoInfo(((TPVideoInfo.Builder)localObject).build());
      paramString1 = TPMediaCompositionFactory.createMediaDRMAsset(0, paramString1);
      localObject = (CharSequence)paramString2;
      if (localObject == null) {
        break label490;
      }
      if (((CharSequence)localObject).length() == 0)
      {
        break label490;
        if (j == 0) {
          paramString1.setDrmProperty("drm_property_provision_url", paramString2);
        }
        paramString2 = (CharSequence)paramString3;
        if (paramString2 == null) {
          break label496;
        }
        if (paramString2.length() != 0) {
          break label447;
        }
        break label496;
      }
    }
    for (;;)
    {
      label373:
      if (j == 0) {
        paramString1.setDrmProperty("drm_property_license_url", paramString3);
      }
      if (i != 0)
      {
        paramString1 = paramString1.getUrl();
        s.s(paramString1, "drmAsset.url");
        b.a(localITPPlayer, paramString1, ak.l(v.Y("protocol_whitelist", "file,crypto,http,https,tls,tcp")));
      }
      for (;;)
      {
        this.sEu = 1;
        paramString1 = ah.aiuX;
        AppMethodBeat.o(318211);
        return;
        j = 0;
        break;
        label447:
        j = 0;
        break label373;
        localITPPlayer.setDataSource((ITPMediaAsset)paramString1);
      }
      Log.w(this.djQ, s.X("setDataSource", ", player is not available"));
      AppMethodBeat.o(318211);
      return;
      label490:
      j = 1;
      break;
      label496:
      j = 1;
    }
  }
  
  public void a(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(318351);
    s.u(paramITPPlayer, "player");
    AppMethodBeat.o(318351);
  }
  
  public final <PlayerImpl extends com.tencent.mm.plugin.appbrand.jsapi.video.e.g> PlayerImpl aU(Class<PlayerImpl> paramClass)
  {
    Object localObject2 = null;
    AppMethodBeat.i(318174);
    s.u(paramClass, "playerClass");
    Object localObject1 = localObject2;
    if (a.class.isAssignableFrom(paramClass))
    {
      localObject1 = localObject2;
      if ((this instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.g)) {
        localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.video.e.g)this;
      }
    }
    Log.i(this.djQ, "castTo, playerClass: " + paramClass + ", playerImpl: " + localObject1);
    AppMethodBeat.o(318174);
    return localObject1;
  }
  
  protected final void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(318344);
    s.u(paramString1, "path");
    ITPPlayer localITPPlayer = this.usS;
    Object localObject1 = ah.aiuX;
    if (cNV()) {}
    for (;;)
    {
      try
      {
        Log.d(this.djQ, "setDataSource");
        Log.d(this.djQ, "setDataSource, path: " + paramString1 + ", referrer: " + paramString2);
        localObject1 = paramString1;
        if (n.U(paramString1, "file://", false))
        {
          localObject1 = paramString1.substring(7);
          s.s(localObject1, "(this as java.lang.String).substring(startIndex)");
        }
        paramString1 = (CharSequence)paramString2;
        if (paramString1 == null) {
          break label449;
        }
        if (paramString1.length() != 0) {
          break label263;
        }
      }
      catch (Exception paramString1)
      {
        Log.e(this.djQ, "setDataSource" + ", fail since " + paramString1);
        j(paramString1);
        AppMethodBeat.o(318344);
        return;
      }
      if (i == 0)
      {
        paramString1 = new HashMap();
        paramString1.put("Referrer", paramString2);
        paramString1 = (Map)paramString1;
        localITPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000L).buildLong(504, 1L).buildBoolean(206, paramBoolean));
        paramString2 = d.UTF_8;
        if (localObject1 == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(318344);
          throw paramString1;
          label263:
          i = 0;
        }
      }
      else
      {
        paramString1 = null;
        continue;
      }
      paramString2 = ((String)localObject1).getBytes(paramString2);
      s.s(paramString2, "(this as java.lang.String).getBytes(charset)");
      paramString2 = com.tencent.mm.b.g.getMessageDigest(paramString2);
      Log.i(this.djQ, s.X("setDataSource, fileId: ", paramString2));
      paramString2 = new TPVideoInfo.Builder().fileId(paramString2);
      TPDownloadParamData localTPDownloadParamData = new TPDownloadParamData(paramInt);
      if (paramString1 != null) {}
      try
      {
        localTPDownloadParamData.setHeadersList(p.listOf(paramString1));
        ah localah = ah.aiuX;
        paramString2.downloadParam(localTPDownloadParamData);
        localITPPlayer.setVideoInfo(paramString2.build());
        if (paramString1 != null)
        {
          b.a(localITPPlayer, (String)localObject1, paramString1);
          this.sEu = 1;
          paramString1 = ah.aiuX;
          AppMethodBeat.o(318344);
          return;
        }
      }
      finally
      {
        for (;;)
        {
          Log.i(this.djQ, s.X("setDataSource, use custom api fail since ", localObject2));
          continue;
          localITPPlayer.setDataSource((String)localObject1);
        }
      }
      Log.w(this.djQ, s.X("setDataSource", ", player is not available"));
      AppMethodBeat.o(318344);
      return;
      label449:
      int i = 1;
    }
  }
  
  public final boolean bN(float paramFloat)
  {
    boolean bool = false;
    AppMethodBeat.i(318272);
    ITPPlayer localITPPlayer = this.usS;
    if (cNV())
    {
      try
      {
        Log.d(this.djQ, "setSpeed");
        localITPPlayer.setPlaySpeedRatio(paramFloat);
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(this.djQ, "setSpeed" + ", fail since " + localException);
          j(localException);
        }
      }
      AppMethodBeat.o(318272);
      return bool;
    }
    Log.w(this.djQ, s.X("setSpeed", ", player is not available"));
    AppMethodBeat.o(318272);
    return false;
  }
  
  public void cM(String paramString, int paramInt)
  {
    AppMethodBeat.i(318192);
    if (paramString == null)
    {
      AppMethodBeat.o(318192);
      return;
    }
    setDataSource(paramString);
    AppMethodBeat.o(318192);
  }
  
  public final String cNT()
  {
    return this.djQ;
  }
  
  public final ITPPlayer cNU()
  {
    return this.usS;
  }
  
  public final boolean cNV()
  {
    return !this.usT;
  }
  
  public final void cww()
  {
    AppMethodBeat.i(318336);
    this.msx = false;
    super.cww();
    AppMethodBeat.o(318336);
  }
  
  public void ey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(318197);
    s.u(paramString1, "path");
    a(this, paramString1, paramString2, true);
    AppMethodBeat.o(318197);
  }
  
  public final int getCurrentPosition()
  {
    int i = 0;
    AppMethodBeat.i(318332);
    ITPPlayer localITPPlayer = this.usS;
    if (cNV())
    {
      try
      {
        Log.d(this.djQ, "getCurrentPosition");
        long l = localITPPlayer.getCurrentPositionMs();
        i = (int)l;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(this.djQ, "getCurrentPosition" + ", fail since " + localException);
          j(localException);
        }
      }
      AppMethodBeat.o(318332);
      return i;
    }
    Log.w(this.djQ, s.X("getCurrentPosition", ", player is not available"));
    AppMethodBeat.o(318332);
    return 0;
  }
  
  public final int getDuration()
  {
    int i = 0;
    AppMethodBeat.i(318326);
    ITPPlayer localITPPlayer = this.usS;
    if (cNV())
    {
      try
      {
        Log.d(this.djQ, "getDuration");
        long l = localITPPlayer.getDurationMs();
        i = (int)l;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(this.djQ, "getDuration" + ", fail since " + localException);
          j(localException);
        }
      }
      AppMethodBeat.o(318326);
      return i;
    }
    Log.w(this.djQ, s.X("getDuration", ", player is not available"));
    AppMethodBeat.o(318326);
    return 0;
  }
  
  public final int getPlayerType()
  {
    return 3;
  }
  
  public final int getVideoHeight()
  {
    int i = 0;
    AppMethodBeat.i(318318);
    ITPPlayer localITPPlayer = this.usS;
    if (cNV())
    {
      try
      {
        Log.d(this.djQ, "getVideoHeight");
        int j = localITPPlayer.getVideoHeight();
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(this.djQ, "getVideoHeight" + ", fail since " + localException);
          j(localException);
        }
      }
      AppMethodBeat.o(318318);
      return i;
    }
    Log.w(this.djQ, s.X("getVideoHeight", ", player is not available"));
    AppMethodBeat.o(318318);
    return 0;
  }
  
  public final int getVideoWidth()
  {
    int i = 0;
    AppMethodBeat.i(318315);
    ITPPlayer localITPPlayer = this.usS;
    if (cNV())
    {
      try
      {
        Log.d(this.djQ, "getVideoWidth");
        int j = localITPPlayer.getVideoWidth();
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(this.djQ, "getVideoWidth" + ", fail since " + localException);
          j(localException);
        }
      }
      AppMethodBeat.o(318315);
      return i;
    }
    Log.w(this.djQ, s.X("getVideoWidth", ", player is not available"));
    AppMethodBeat.o(318315);
    return 0;
  }
  
  public final boolean isPlaying()
  {
    boolean bool = false;
    AppMethodBeat.i(318311);
    ITPPlayer localITPPlayer = this.usS;
    if (cNV())
    {
      try
      {
        Log.d(this.djQ, "isPlaying");
        int i = localITPPlayer.getCurrentState();
        if (5 == i) {
          bool = true;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(this.djQ, "isPlaying" + ", fail since " + localException);
          j(localException);
        }
      }
      AppMethodBeat.o(318311);
      return bool;
    }
    Log.w(this.djQ, s.X("isPlaying", ", player is not available"));
    AppMethodBeat.o(318311);
    return false;
  }
  
  public final void j(Exception paramException)
  {
    AppMethodBeat.i(318348);
    s.u(paramException, "e");
    if ((paramException instanceof IllegalStateException))
    {
      fB(-10001, -1);
      AppMethodBeat.o(318348);
      return;
    }
    if (((paramException instanceof IllegalArgumentException)) && (s.p("drm asset url is null or drm property is null", paramException.getMessage())))
    {
      fB(-20000, 10000);
      AppMethodBeat.o(318348);
      return;
    }
    fB(-10999, -1);
    AppMethodBeat.o(318348);
  }
  
  public void pause()
  {
    AppMethodBeat.i(318235);
    Object localObject = this.usS;
    ah localah = ah.aiuX;
    if (cNV()) {
      try
      {
        Log.d(this.djQ, "pause");
        if ((!cNW()) && (!isPlaying())) {
          Log.w(this.djQ, "pause, is not preparing and not playing");
        }
        for (;;)
        {
          localObject = ah.aiuX;
          AppMethodBeat.o(318235);
          return;
          ((ITPPlayer)localObject).pause();
          ((ITPPlayer)localObject).pauseDownload();
          this.sEu = 4;
        }
        Log.w(this.djQ, s.X("pause", ", player is not available"));
      }
      catch (Exception localException)
      {
        Log.e(this.djQ, "pause" + ", fail since " + localException);
        j(localException);
        AppMethodBeat.o(318235);
        return;
      }
    }
    AppMethodBeat.o(318235);
  }
  
  public void prepareAsync()
  {
    AppMethodBeat.i(318222);
    Object localObject = this.usS;
    ah localah = ah.aiuX;
    if (cNV()) {
      for (;;)
      {
        try
        {
          Log.d(this.djQ, "prepareAsync");
          if (getState() == 0)
          {
            Log.w(this.djQ, "prepareAsync, idle");
            localObject = ah.aiuX;
            AppMethodBeat.o(318222);
            return;
          }
          if (cNW())
          {
            Log.w(this.djQ, "prepareAsync, isPreparing");
            continue;
          }
          if (!cxs()) {
            break label146;
          }
        }
        catch (Exception localException)
        {
          Log.e(this.djQ, "prepareAsync" + ", fail since " + localException);
          j(localException);
          AppMethodBeat.o(318222);
          return;
        }
        Log.w(this.djQ, "prepareAsync, isPrepared");
        continue;
        label146:
        localException.prepareAsync();
      }
    }
    Log.w(this.djQ, s.X("prepareAsync", ", player is not available"));
    AppMethodBeat.o(318222);
  }
  
  public void release()
  {
    AppMethodBeat.i(318180);
    ah localah = ah.aiuX;
    if (cNV()) {}
    for (;;)
    {
      try
      {
        Log.d(this.djQ, "release");
        this.usS.setOnPreparedListener(null);
        this.usS.setOnSeekCompleteListener(null);
        this.usS.setOnCompletionListener(null);
        this.usS.setOnVideoSizeChangedListener(null);
        this.usS.setOnErrorListener(null);
        this.usS.setOnPlayerStateChangeListener(null);
        this.usS.setOnInfoListener(null);
        this.usS.release();
        this.sEu = -2;
        localah = ah.aiuX;
        super.release();
        this.usT = true;
        AppMethodBeat.o(318180);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.djQ, "release" + ", fail since " + localException);
        j(localException);
        continue;
      }
      Log.w(this.djQ, s.X("release", ", player is not available"));
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(318265);
    Object localObject = this.usS;
    ah localah = ah.aiuX;
    if (cNV()) {
      try
      {
        Log.d(this.djQ, "reset");
        ((ITPPlayer)localObject).reset();
        this.sEu = 0;
        localObject = ah.aiuX;
        AppMethodBeat.o(318265);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.djQ, "reset" + ", fail since " + localException);
        j(localException);
        AppMethodBeat.o(318265);
        return;
      }
    }
    Log.w(this.djQ, s.X("reset", ", player is not available"));
    AppMethodBeat.o(318265);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(318257);
    Object localObject = this.usS;
    ah localah = ah.aiuX;
    if (cNV()) {
      try
      {
        Log.d(this.djQ, "seekTo");
        ((ITPPlayer)localObject).seekTo((int)paramLong, 3);
        this.msx = true;
        localObject = ah.aiuX;
        AppMethodBeat.o(318257);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.djQ, "seekTo" + ", fail since " + localException);
        j(localException);
        AppMethodBeat.o(318257);
        return;
      }
    }
    Log.w(this.djQ, s.X("seekTo", ", player is not available"));
    AppMethodBeat.o(318257);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(318190);
    s.u(paramString, "path");
    ey(paramString, null);
    AppMethodBeat.o(318190);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(318303);
    Object localObject = this.usS;
    ah localah = ah.aiuX;
    if (cNV()) {
      try
      {
        Log.d(this.djQ, "setLooping");
        ((ITPPlayer)localObject).setLoopback(paramBoolean);
        localObject = ah.aiuX;
        AppMethodBeat.o(318303);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.djQ, "setLooping" + ", fail since " + localException);
        j(localException);
        AppMethodBeat.o(318303);
        return;
      }
    }
    Log.w(this.djQ, s.X("setLooping", ", player is not available"));
    AppMethodBeat.o(318303);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(318296);
    Object localObject = this.usS;
    ah localah = ah.aiuX;
    if (cNV()) {
      try
      {
        Log.d(this.djQ, "setMute");
        ((ITPPlayer)localObject).setOutputMute(paramBoolean);
        localObject = ah.aiuX;
        AppMethodBeat.o(318296);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.djQ, "setMute" + ", fail since " + localException);
        j(localException);
        AppMethodBeat.o(318296);
        return;
      }
    }
    Log.w(this.djQ, s.X("setMute", ", player is not available"));
    AppMethodBeat.o(318296);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(318215);
    ITPPlayer localITPPlayer = this.usS;
    ah localah = ah.aiuX;
    if (cNV()) {
      try
      {
        Log.d(this.djQ, "setSurface");
        localITPPlayer.setSurface(paramSurface);
        paramSurface = ah.aiuX;
        AppMethodBeat.o(318215);
        return;
      }
      catch (Exception paramSurface)
      {
        Log.e(this.djQ, "setSurface" + ", fail since " + paramSurface);
        j(paramSurface);
        AppMethodBeat.o(318215);
        return;
      }
    }
    Log.w(this.djQ, s.X("setSurface", ", player is not available"));
    AppMethodBeat.o(318215);
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(318285);
    Object localObject = this.usS;
    ah localah = ah.aiuX;
    if (cNV()) {
      try
      {
        Log.d(this.djQ, "setVolume");
        ((ITPPlayer)localObject).setAudioGainRatio(paramFloat1);
        localObject = ah.aiuX;
        AppMethodBeat.o(318285);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.djQ, "setVolume" + ", fail since " + localException);
        j(localException);
        AppMethodBeat.o(318285);
        return;
      }
    }
    Log.w(this.djQ, s.X("setVolume", ", player is not available"));
    AppMethodBeat.o(318285);
  }
  
  public void start()
  {
    AppMethodBeat.i(318230);
    Object localObject = this.usS;
    ah localah = ah.aiuX;
    if (cNV()) {
      for (;;)
      {
        try
        {
          Log.d(this.djQ, "start");
          if (!cNX())
          {
            Log.w(this.djQ, "start, can not start");
            localObject = ah.aiuX;
            AppMethodBeat.o(318230);
            return;
          }
          if (isPlaying())
          {
            Log.w(this.djQ, "start, isPlaying");
            continue;
          }
          if (cxs()) {
            break label146;
          }
        }
        catch (Exception localException)
        {
          Log.e(this.djQ, "start" + ", fail since " + localException);
          j(localException);
          AppMethodBeat.o(318230);
          return;
        }
        Log.w(this.djQ, "start, is not prepared");
        continue;
        label146:
        if (7 == localException.getCurrentState()) {
          seekTo(0L);
        }
        localException.start();
        localException.resumeDownload();
        this.sEu = 3;
      }
    }
    Log.w(this.djQ, s.X("start", ", player is not available"));
    AppMethodBeat.o(318230);
  }
  
  public void stop()
  {
    AppMethodBeat.i(318244);
    Object localObject = this.usS;
    ah localah = ah.aiuX;
    if (cNV()) {
      try
      {
        Log.d(this.djQ, "stop");
        if (!cNX()) {
          Log.w(this.djQ, "stop, can not start");
        }
        for (;;)
        {
          localObject = ah.aiuX;
          AppMethodBeat.o(318244);
          return;
          ((ITPPlayer)localObject).stop();
          ((ITPPlayer)localObject).pauseDownload();
          this.sEu = 5;
        }
        Log.w(this.djQ, s.X("stop", ", player is not available"));
      }
      catch (Exception localException)
      {
        Log.e(this.djQ, "stop" + ", fail since " + localException);
        j(localException);
        AppMethodBeat.o(318244);
        return;
      }
    }
    AppMethodBeat.o(318244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.b.a.a
 * JD-Core Version:    0.7.0.1
 */