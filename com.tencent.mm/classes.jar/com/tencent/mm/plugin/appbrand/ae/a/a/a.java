package com.tencent.mm.plugin.appbrand.ae.a.a;

import android.content.Context;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.thumbplayer.f.d.a;
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
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPVideoInfo.Builder;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.util.HashMap;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/video/player/thumb/ThumbMediaPlayer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/BaseMediaPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isBuffering", "", "isRealPlayerAvailable", "()Z", "isRealPlayerReleased", "isSeeking", "lastNotifiedBufferPercent", "", "Ljava/lang/Integer;", "myTag", "", "getMyTag", "()Ljava/lang/String;", "onCompletionListener", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnCompletionListener;", "onErrorListener", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnErrorListener;", "onInfoListener", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnInfoListener;", "onPlayerStateChangeListener", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnStateChangeListener;", "onPreparedListener", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnPreparedListener;", "onSeekCompleteListener", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnSeekCompleteListener;", "onVideoSizeChangedListener", "Lcom/tencent/thumbplayer/api/ITPPlayerListener$IOnVideoSizeChangedListener;", "realPlayer", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "getRealPlayer", "()Lcom/tencent/thumbplayer/api/ITPPlayer;", "buildHeaders", "", "referrer", "canStart", "dispatchErrorWhenCaughtException", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getCurrentPosition", "getDuration", "getVideoHeight", "getVideoWidth", "isPlaying", "isPrepared", "isPreparing", "notifyOnBufferingUpdate", "percent", "notifyOnSeekComplete", "onTTPlayerInfoUpdate", "player", "what", "arg1", "", "arg2", "extraObject", "", "pause", "prepareAsync", "release", "reset", "seekTo", "msc", "setDataSource", "path", "useProxy", "setLooping", "looping", "setMute", "mute", "setSpeed", "speed", "", "setSurface", "surface", "Landroid/view/Surface;", "setVolume", "left", "right", "start", "stop", "doIfAvailable", "R", "name", "defaultVal", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/thumbplayer/api/ITPPlayer;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "plugin-compat_release"})
public class a
  extends com.tencent.mm.plugin.appbrand.jsapi.video.e.a
{
  boolean aLt;
  final String bqj;
  final ITPPlayer rjW;
  private volatile boolean rjX;
  private Integer rjY;
  volatile boolean rjZ;
  private final ITPPlayerListener.IOnPreparedListener rka;
  private final ITPPlayerListener.IOnSeekCompleteListener rkb;
  private final ITPPlayerListener.IOnCompletionListener rkc;
  private final ITPPlayerListener.IOnVideoSizeChangedListener rkd;
  private final ITPPlayerListener.IOnErrorListener rke;
  private final ITPPlayerListener.IOnStateChangeListener rkf;
  private final ITPPlayerListener.IOnInfoListener rkg;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(207412);
    this.bqj = ("MicroMsg.AppBrand.ThumbMediaPlayer#" + hashCode());
    this.rka = ((ITPPlayerListener.IOnPreparedListener)new d(this));
    this.rkb = ((ITPPlayerListener.IOnSeekCompleteListener)new e(this));
    this.rkc = ((ITPPlayerListener.IOnCompletionListener)new a(this));
    this.rkd = ((ITPPlayerListener.IOnVideoSizeChangedListener)new f(this));
    this.rke = ((ITPPlayerListener.IOnErrorListener)new b(this));
    this.rkf = ((ITPPlayerListener.IOnStateChangeListener)new c(this));
    Log.d(this.bqj, "init");
    Object localObject = c.rkl;
    c.eu(paramContext);
    localObject = com.tencent.mm.plugin.thumbplayer.f.d.MTv;
    this.rjW = ((ITPPlayer)d.a.iz(paramContext));
    this.rjW.setOnPreparedListener(this.rka);
    this.rjW.setOnSeekCompleteListener(this.rkb);
    this.rjW.setOnCompletionListener(this.rkc);
    this.rjW.setOnVideoSizeChangedListener(this.rkd);
    this.rjW.setOnErrorListener(this.rke);
    this.rjW.setOnPlayerStateChangeListener(this.rkf);
    this.rkg = ((ITPPlayerListener.IOnInfoListener)new ITPPlayerListener.IOnInfoListener()
    {
      public final void onInfo(ITPPlayer paramAnonymousITPPlayer, int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(207438);
        Log.d(this.rkh.bqj, "onInfo, what: " + paramAnonymousInt + ", arg1: " + paramAnonymousLong1 + ", arg2: " + paramAnonymousLong2 + ", extraObject: " + paramAnonymousObject);
        if ((201 == paramAnonymousInt) && (7 == ((com.tencent.mm.plugin.thumbplayer.f.a)this.rkh.rjW).getCurrentState()))
        {
          Log.i(this.rkh.bqj, "onInfo, buffering end when COMPLETE, notify seek complete");
          this.rkh.bWk();
        }
        int m = -1;
        int k = 0;
        int i;
        int j;
        switch (paramAnonymousInt)
        {
        default: 
          i = m;
          j = k;
          if (-1 != i) {
            this.rkh.eI(i, j);
          }
          if (1006 == paramAnonymousInt)
          {
            if ((paramAnonymousObject instanceof TPPlayerMsg.TPDownLoadProgressInfo)) {
              break label351;
            }
            Log.w(this.rkh.bqj, "onInfo, extraObject is not TPDownLoadProgressInfo");
          }
          break;
        }
        for (;;)
        {
          a locala = this.rkh;
          p.j(paramAnonymousITPPlayer, "ttplayer");
          locala.a(paramAnonymousITPPlayer, paramAnonymousInt, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousObject);
          AppMethodBeat.o(207438);
          return;
          i = 3;
          j = k;
          break;
          j = k;
          i = m;
          if (this.rkh.cmp()) {
            break;
          }
          j = k;
          i = m;
          if (this.rkh.rjZ) {
            break;
          }
          i = 701;
          j = b.a(this.rkh.rjW);
          this.rkh.aLt = true;
          break;
          j = k;
          i = m;
          if (!this.rkh.aLt) {
            break;
          }
          this.rkh.aLt = false;
          i = 702;
          j = b.a(this.rkh.rjW);
          break;
          label351:
          this.rkh.Bc(b.a(this.rkh.rjW));
        }
      }
    });
    this.rjW.setOnInfoListener(this.rkg);
    setLooping(false);
    AppMethodBeat.o(207412);
  }
  
  private static Map<String, String> aiy(String paramString)
  {
    AppMethodBeat.i(207402);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("Referrer", paramString);
      paramString = (Map)localObject;
      AppMethodBeat.o(207402);
      return paramString;
    }
    AppMethodBeat.o(207402);
    return null;
  }
  
  private final boolean ayN()
  {
    AppMethodBeat.i(207405);
    switch (this.rjW.getCurrentState())
    {
    default: 
      AppMethodBeat.o(207405);
      return false;
    }
    AppMethodBeat.o(207405);
    return true;
  }
  
  private final boolean cmq()
  {
    AppMethodBeat.i(207407);
    switch (this.rjW.getCurrentState())
    {
    default: 
      AppMethodBeat.o(207407);
      return false;
    }
    AppMethodBeat.o(207407);
    return true;
  }
  
  public final void Bc(int paramInt)
  {
    AppMethodBeat.i(207374);
    Log.d(this.bqj, "notifyOnBufferingUpdate, percent:".concat(String.valueOf(paramInt)));
    Integer localInteger = this.rjY;
    if (localInteger == null) {}
    for (;;)
    {
      super.Bc(paramInt);
      this.rjY = Integer.valueOf(paramInt);
      do
      {
        AppMethodBeat.o(207374);
        return;
      } while (paramInt == localInteger.intValue());
    }
  }
  
  public void a(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(207411);
    p.k(paramITPPlayer, "player");
    AppMethodBeat.o(207411);
  }
  
  public final boolean aP(float paramFloat)
  {
    boolean bool = false;
    AppMethodBeat.i(207389);
    ITPPlayer localITPPlayer = this.rjW;
    if (cmo())
    {
      try
      {
        Log.d(this.bqj, "setSpeed");
        localITPPlayer.setPlaySpeedRatio(paramFloat);
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(this.bqj, "setSpeed" + ", fail since " + localException);
          i(localException);
        }
      }
      AppMethodBeat.o(207389);
      return bool;
    }
    Log.w(this.bqj, "setSpeed" + ", player is not available");
    AppMethodBeat.o(207389);
    return false;
  }
  
  public final void bWk()
  {
    AppMethodBeat.i(207400);
    this.rjZ = false;
    super.bWk();
    AppMethodBeat.o(207400);
  }
  
  public final boolean cmo()
  {
    return !this.rjX;
  }
  
  final boolean cmp()
  {
    AppMethodBeat.i(207403);
    if (3 == this.rjW.getCurrentState())
    {
      AppMethodBeat.o(207403);
      return true;
    }
    AppMethodBeat.o(207403);
    return false;
  }
  
  public void ef(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207377);
    p.k(paramString1, "path");
    m(paramString1, paramString2, true);
    AppMethodBeat.o(207377);
  }
  
  public final int getCurrentPosition()
  {
    int i = 0;
    AppMethodBeat.i(207399);
    ITPPlayer localITPPlayer = this.rjW;
    if (cmo())
    {
      try
      {
        Log.d(this.bqj, "getCurrentPosition");
        long l = localITPPlayer.getCurrentPositionMs();
        i = (int)l;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(this.bqj, "getCurrentPosition" + ", fail since " + localException);
          i(localException);
        }
      }
      AppMethodBeat.o(207399);
      return i;
    }
    Log.w(this.bqj, "getCurrentPosition" + ", player is not available");
    AppMethodBeat.o(207399);
    return 0;
  }
  
  public final int getDuration()
  {
    int i = 0;
    AppMethodBeat.i(207398);
    ITPPlayer localITPPlayer = this.rjW;
    if (cmo())
    {
      try
      {
        Log.d(this.bqj, "getDuration");
        long l = localITPPlayer.getDurationMs();
        i = (int)l;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(this.bqj, "getDuration" + ", fail since " + localException);
          i(localException);
        }
      }
      AppMethodBeat.o(207398);
      return i;
    }
    Log.w(this.bqj, "getDuration" + ", player is not available");
    AppMethodBeat.o(207398);
    return 0;
  }
  
  public final int getVideoHeight()
  {
    int i = 0;
    AppMethodBeat.i(207397);
    ITPPlayer localITPPlayer = this.rjW;
    if (cmo())
    {
      try
      {
        Log.d(this.bqj, "getVideoHeight");
        int j = localITPPlayer.getVideoHeight();
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(this.bqj, "getVideoHeight" + ", fail since " + localException);
          i(localException);
        }
      }
      AppMethodBeat.o(207397);
      return i;
    }
    Log.w(this.bqj, "getVideoHeight" + ", player is not available");
    AppMethodBeat.o(207397);
    return 0;
  }
  
  public final int getVideoWidth()
  {
    int i = 0;
    AppMethodBeat.i(207396);
    ITPPlayer localITPPlayer = this.rjW;
    if (cmo())
    {
      try
      {
        Log.d(this.bqj, "getVideoWidth");
        int j = localITPPlayer.getVideoWidth();
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(this.bqj, "getVideoWidth" + ", fail since " + localException);
          i(localException);
        }
      }
      AppMethodBeat.o(207396);
      return i;
    }
    Log.w(this.bqj, "getVideoWidth" + ", player is not available");
    AppMethodBeat.o(207396);
    return 0;
  }
  
  public final void i(Exception paramException)
  {
    AppMethodBeat.i(207409);
    p.k(paramException, "e");
    if ((paramException instanceof IllegalStateException))
    {
      eH(-10001, -1);
      AppMethodBeat.o(207409);
      return;
    }
    eH(-10999, -1);
    AppMethodBeat.o(207409);
  }
  
  public final boolean isPlaying()
  {
    boolean bool = false;
    AppMethodBeat.i(207395);
    ITPPlayer localITPPlayer = this.rjW;
    if (cmo())
    {
      try
      {
        Log.d(this.bqj, "isPlaying");
        int i = localITPPlayer.getCurrentState();
        if (5 == i) {
          bool = true;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(this.bqj, "isPlaying" + ", fail since " + localException);
          i(localException);
        }
      }
      AppMethodBeat.o(207395);
      return bool;
    }
    Log.w(this.bqj, "isPlaying" + ", player is not available");
    AppMethodBeat.o(207395);
    return false;
  }
  
  protected final void m(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(207401);
    p.k(paramString1, "path");
    ITPPlayer localITPPlayer = this.rjW;
    Object localObject1 = x.aazN;
    if (cmo()) {
      try
      {
        Log.d(this.bqj, "setDataSource");
        Log.d(this.bqj, "setDataSource, path: " + paramString1 + ", referrer: " + paramString2);
        paramString2 = aiy(paramString2);
        localITPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000L).buildBoolean(123, true).buildBoolean(205, paramBoolean));
        localObject1 = new TPVideoInfo.Builder();
        Object localObject2 = paramString1.getBytes(kotlin.n.d.UTF_8);
        p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
        localObject1 = ((TPVideoInfo.Builder)localObject1).fileId(g.getMessageDigest((byte[])localObject2));
        localObject2 = new TPDownloadParamData(0);
        if (paramString2 != null) {
          ((TPDownloadParamData)localObject2).setHeadersList(j.listOf(paramString2));
        }
        ((TPVideoInfo.Builder)localObject1).downloadParam((TPDownloadParamData)localObject2);
        localITPPlayer.setVideoInfo(((TPVideoInfo.Builder)localObject1).build());
        if (paramString2 != null) {
          b.a(localITPPlayer, paramString1, paramString2);
        }
        for (;;)
        {
          setState(1);
          paramString1 = x.aazN;
          AppMethodBeat.o(207401);
          return;
          localITPPlayer.setDataSource(paramString1);
        }
        Log.w(this.bqj, "setDataSource" + ", player is not available");
      }
      catch (Exception paramString1)
      {
        Log.e(this.bqj, "setDataSource" + ", fail since " + paramString1);
        i(paramString1);
        AppMethodBeat.o(207401);
        return;
      }
    }
    AppMethodBeat.o(207401);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(207384);
    Object localObject = this.rjW;
    x localx = x.aazN;
    if (cmo()) {
      try
      {
        Log.d(this.bqj, "pause");
        if ((!cmp()) && (!isPlaying())) {
          Log.w(this.bqj, "pause, is not preparing and not playing");
        }
        for (;;)
        {
          localObject = x.aazN;
          AppMethodBeat.o(207384);
          return;
          ((ITPPlayer)localObject).pause();
          ((ITPPlayer)localObject).pauseDownload();
          setState(4);
        }
        Log.w(this.bqj, "pause" + ", player is not available");
      }
      catch (Exception localException)
      {
        Log.e(this.bqj, "pause" + ", fail since " + localException);
        i(localException);
        AppMethodBeat.o(207384);
        return;
      }
    }
    AppMethodBeat.o(207384);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(207380);
    Object localObject = this.rjW;
    x localx = x.aazN;
    if (cmo()) {
      for (;;)
      {
        try
        {
          Log.d(this.bqj, "prepareAsync");
          if (getState() == 0)
          {
            Log.w(this.bqj, "prepareAsync, idle");
            localObject = x.aazN;
            AppMethodBeat.o(207380);
            return;
          }
          if (cmp())
          {
            Log.w(this.bqj, "prepareAsync, isPreparing");
            continue;
          }
          if (!ayN()) {
            break label146;
          }
        }
        catch (Exception localException)
        {
          Log.e(this.bqj, "prepareAsync" + ", fail since " + localException);
          i(localException);
          AppMethodBeat.o(207380);
          return;
        }
        Log.w(this.bqj, "prepareAsync, isPrepared");
        continue;
        label146:
        localException.prepareAsync();
      }
    }
    Log.w(this.bqj, "prepareAsync" + ", player is not available");
    AppMethodBeat.o(207380);
  }
  
  public final void release()
  {
    AppMethodBeat.i(207372);
    x localx = x.aazN;
    if (cmo()) {}
    for (;;)
    {
      try
      {
        Log.d(this.bqj, "release");
        this.rjW.setOnPreparedListener(null);
        this.rjW.setOnSeekCompleteListener(null);
        this.rjW.setOnCompletionListener(null);
        this.rjW.setOnVideoSizeChangedListener(null);
        this.rjW.setOnErrorListener(null);
        this.rjW.setOnPlayerStateChangeListener(null);
        this.rjW.setOnInfoListener(null);
        this.rjW.release();
        setState(-2);
        localx = x.aazN;
        super.release();
        this.rjX = true;
        AppMethodBeat.o(207372);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.bqj, "release" + ", fail since " + localException);
        i(localException);
        continue;
      }
      Log.w(this.bqj, "release" + ", player is not available");
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(207388);
    Object localObject = this.rjW;
    x localx = x.aazN;
    if (cmo()) {
      try
      {
        Log.d(this.bqj, "reset");
        ((ITPPlayer)localObject).reset();
        setState(0);
        localObject = x.aazN;
        AppMethodBeat.o(207388);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.bqj, "reset" + ", fail since " + localException);
        i(localException);
        AppMethodBeat.o(207388);
        return;
      }
    }
    Log.w(this.bqj, "reset" + ", player is not available");
    AppMethodBeat.o(207388);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(207386);
    Object localObject = this.rjW;
    x localx = x.aazN;
    if (cmo()) {
      try
      {
        Log.d(this.bqj, "seekTo");
        ((ITPPlayer)localObject).seekTo((int)paramLong, 3);
        this.rjZ = true;
        localObject = x.aazN;
        AppMethodBeat.o(207386);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.bqj, "seekTo" + ", fail since " + localException);
        i(localException);
        AppMethodBeat.o(207386);
        return;
      }
    }
    Log.w(this.bqj, "seekTo" + ", player is not available");
    AppMethodBeat.o(207386);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(207376);
    p.k(paramString, "path");
    ef(paramString, null);
    AppMethodBeat.o(207376);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(207394);
    Object localObject = this.rjW;
    x localx = x.aazN;
    if (cmo()) {
      try
      {
        Log.d(this.bqj, "setLooping");
        ((ITPPlayer)localObject).setLoopback(paramBoolean);
        localObject = x.aazN;
        AppMethodBeat.o(207394);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.bqj, "setLooping" + ", fail since " + localException);
        i(localException);
        AppMethodBeat.o(207394);
        return;
      }
    }
    Log.w(this.bqj, "setLooping" + ", player is not available");
    AppMethodBeat.o(207394);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(207392);
    Object localObject = this.rjW;
    x localx = x.aazN;
    if (cmo()) {
      try
      {
        Log.d(this.bqj, "setMute");
        ((ITPPlayer)localObject).setOutputMute(paramBoolean);
        localObject = x.aazN;
        AppMethodBeat.o(207392);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.bqj, "setMute" + ", fail since " + localException);
        i(localException);
        AppMethodBeat.o(207392);
        return;
      }
    }
    Log.w(this.bqj, "setMute" + ", player is not available");
    AppMethodBeat.o(207392);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(207378);
    ITPPlayer localITPPlayer = this.rjW;
    x localx = x.aazN;
    if (cmo()) {
      try
      {
        Log.d(this.bqj, "setSurface");
        localITPPlayer.setSurface(paramSurface);
        paramSurface = x.aazN;
        AppMethodBeat.o(207378);
        return;
      }
      catch (Exception paramSurface)
      {
        Log.e(this.bqj, "setSurface" + ", fail since " + paramSurface);
        i(paramSurface);
        AppMethodBeat.o(207378);
        return;
      }
    }
    Log.w(this.bqj, "setSurface" + ", player is not available");
    AppMethodBeat.o(207378);
  }
  
  public final void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(207390);
    Object localObject = this.rjW;
    x localx = x.aazN;
    if (cmo()) {
      try
      {
        Log.d(this.bqj, "setVolume");
        ((ITPPlayer)localObject).setAudioGainRatio(paramFloat1);
        localObject = x.aazN;
        AppMethodBeat.o(207390);
        return;
      }
      catch (Exception localException)
      {
        Log.e(this.bqj, "setVolume" + ", fail since " + localException);
        i(localException);
        AppMethodBeat.o(207390);
        return;
      }
    }
    Log.w(this.bqj, "setVolume" + ", player is not available");
    AppMethodBeat.o(207390);
  }
  
  public final void start()
  {
    AppMethodBeat.i(207383);
    Object localObject = this.rjW;
    x localx = x.aazN;
    if (cmo()) {
      for (;;)
      {
        try
        {
          Log.d(this.bqj, "start");
          if (!cmq())
          {
            Log.w(this.bqj, "start, can not start");
            localObject = x.aazN;
            AppMethodBeat.o(207383);
            return;
          }
          if (isPlaying())
          {
            Log.w(this.bqj, "start, isPlaying");
            continue;
          }
          if (ayN()) {
            break label146;
          }
        }
        catch (Exception localException)
        {
          Log.e(this.bqj, "start" + ", fail since " + localException);
          i(localException);
          AppMethodBeat.o(207383);
          return;
        }
        Log.w(this.bqj, "start, is not prepared");
        continue;
        label146:
        if (7 == localException.getCurrentState()) {
          seekTo(0L);
        }
        localException.start();
        localException.resumeDownload();
        setState(3);
      }
    }
    Log.w(this.bqj, "start" + ", player is not available");
    AppMethodBeat.o(207383);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(207385);
    Object localObject = this.rjW;
    x localx = x.aazN;
    if (cmo()) {
      try
      {
        Log.d(this.bqj, "stop");
        if (!cmq()) {
          Log.w(this.bqj, "stop, can not start");
        }
        for (;;)
        {
          localObject = x.aazN;
          AppMethodBeat.o(207385);
          return;
          ((ITPPlayer)localObject).stop();
          ((ITPPlayer)localObject).pauseDownload();
          setState(5);
        }
        Log.w(this.bqj, "stop" + ", player is not available");
      }
      catch (Exception localException)
      {
        Log.e(this.bqj, "stop" + ", fail since " + localException);
        i(localException);
        AppMethodBeat.o(207385);
        return;
      }
    }
    AppMethodBeat.o(207385);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onCompletion"})
  static final class a
    implements ITPPlayerListener.IOnCompletionListener
  {
    a(a parama) {}
    
    public final void onCompletion(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(207678);
      Log.d(this.rkh.bqj, "onCompletion");
      this.rkh.setState(6);
      this.rkh.bWj();
      AppMethodBeat.o(207678);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "errorType", "", "errorCode", "arg1", "", "arg2", "onError"})
  static final class b
    implements ITPPlayerListener.IOnErrorListener
  {
    b(a parama) {}
    
    public final void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(207680);
      Log.w(this.rkh.bqj, "onError, errorType: " + paramInt1 + ", errorCode: " + paramInt2 + ", arg1: " + paramLong1 + ", arg2: " + paramLong2);
      if (1000 == paramInt2)
      {
        AppMethodBeat.o(207680);
        return;
      }
      this.rkh.eH(-10000 - paramInt1, paramInt2);
      AppMethodBeat.o(207680);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "preState", "", "curState", "onStateChange"})
  static final class c
    implements ITPPlayerListener.IOnStateChangeListener
  {
    c(a parama) {}
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(207454);
      Log.d(this.rkh.bqj, "onStateChange, preState: " + paramInt1 + ", curState: " + paramInt2);
      AppMethodBeat.o(207454);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onPrepared"})
  static final class d
    implements ITPPlayerListener.IOnPreparedListener
  {
    d(a parama) {}
    
    public final void onPrepared(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(207531);
      Log.d(this.rkh.bqj, "onPrepared");
      this.rkh.setState(2);
      this.rkh.bWi();
      AppMethodBeat.o(207531);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "onSeekComplete"})
  static final class e
    implements ITPPlayerListener.IOnSeekCompleteListener
  {
    e(a parama) {}
    
    public final void onSeekComplete(ITPPlayer paramITPPlayer)
    {
      AppMethodBeat.i(207470);
      Log.d(this.rkh.bqj, "onSeekComplete");
      this.rkh.bWk();
      AppMethodBeat.o(207470);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "kotlin.jvm.PlatformType", "width", "", "height", "onVideoSizeChanged"})
  static final class f
    implements ITPPlayerListener.IOnVideoSizeChangedListener
  {
    f(a parama) {}
    
    public final void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(207561);
      Log.d(this.rkh.bqj, "onVideoSizeChanged, width: " + paramLong1 + ", height: " + paramLong2);
      this.rkh.eG((int)paramLong1, (int)paramLong2);
      AppMethodBeat.o(207561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.a.a.a
 * JD-Core Version:    0.7.0.1
 */