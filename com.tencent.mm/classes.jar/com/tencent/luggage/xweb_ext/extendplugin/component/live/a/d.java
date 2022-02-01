package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.WXLivePlayConfig;
import com.tencent.rtmp.WXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class d
  implements a, ITXLivePlayListener, TXLivePlayer.ITXAudioVolumeEvaluationListener
{
  private String eyQ;
  private boolean eyT;
  private boolean ezA;
  private boolean ezB;
  private WXLivePlayConfig ezo;
  private WXLivePlayer ezp;
  private ITXLivePlayListener ezq;
  private int ezr;
  private String ezs;
  private String ezt;
  private String ezu;
  private float ezv;
  private float ezw;
  private boolean ezx;
  private boolean ezy;
  private boolean ezz;
  private TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
  private Context mContext;
  private Handler mHandler;
  private boolean mInited;
  private int mMode;
  private boolean mMuteAudio;
  private boolean mMuteVideo;
  private TXLivePlayer.ITXSnapshotListener mSnapshotListener;
  private Surface mSurface;
  private TXCloudVideoView mVideoView;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(220656);
    this.eyQ = "";
    this.ezr = 0;
    this.mInited = false;
    this.eyT = false;
    this.mMode = 1;
    this.mMuteAudio = false;
    this.mMuteVideo = false;
    this.ezs = "vertical";
    this.ezt = "fillCrop";
    this.ezu = "speaker";
    this.ezv = 1.0F;
    this.ezw = 3.0F;
    this.ezx = true;
    this.ezy = false;
    this.ezz = false;
    this.ezA = false;
    this.ezB = false;
    this.mContext = paramContext;
    this.ezo = new WXLivePlayConfig();
    this.ezp = new WXLivePlayer(this.mContext);
    this.ezp.enableHardwareDecode(true);
    this.ezp.setConfig(this.ezo);
    this.ezp.setPlayListener(this);
    this.ezp.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(220656);
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(220691);
    boolean bool = this.mMuteAudio;
    Object localObject;
    if (paramBundle.keySet().contains("muteAudio"))
    {
      bool = paramBundle.getBoolean("muteAudio");
      if ((paramBoolean) || (bool != this.mMuteAudio)) {
        this.ezp.muteAudio(bool);
      }
      this.mMuteAudio = bool;
      bool = paramBundle.getBoolean("muteVideo", this.mMuteVideo);
      if ((paramBoolean) || (bool != this.mMuteVideo)) {
        this.ezp.muteVideo(bool);
      }
      this.mMuteVideo = bool;
      localObject = paramBundle.getString("orientation", this.ezs);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.ezs)))
      {
        if (!((String)localObject).equalsIgnoreCase("horizontal")) {
          break label561;
        }
        this.ezp.setRenderRotation(270);
      }
      label149:
      this.ezs = ((String)localObject);
      localObject = paramBundle.getString("objectFit", this.ezt);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.ezt)))
      {
        if (!((String)localObject).equalsIgnoreCase("fillCrop")) {
          break label582;
        }
        this.ezp.setRenderMode(0);
      }
      label201:
      this.ezt = ((String)localObject);
      if (paramBundle.keySet().contains("soundMode"))
      {
        localObject = paramBundle.getString("soundMode", this.ezu);
        if (!((String)localObject).equalsIgnoreCase(this.ezu))
        {
          if (!((String)localObject).equalsIgnoreCase("speaker")) {
            break label604;
          }
          this.ezp.setAudioRoute(0);
        }
        label263:
        this.ezu = ((String)localObject);
      }
      localObject = null;
      if (paramBundle.keySet().contains("referrer"))
      {
        localObject = paramBundle.getString("referrer");
        Log.i("TXLivePlayerJSAdapter", "parseAndApplyParams, referrer: ".concat(String.valueOf(localObject)));
      }
      this.ezv = paramBundle.getFloat("minCache", this.ezv);
      this.ezw = paramBundle.getFloat("maxCache", this.ezw);
      this.ezo.setAutoAdjustCacheTime(true);
      this.ezo.setCacheTime(this.ezv);
      this.ezo.setMinAutoAdjustCacheTime(this.ezv);
      this.ezo.setMaxAutoAdjustCacheTime(this.ezw);
      localObject = com.tencent.mm.plugin.appbrand.jsapi.y.d.abw((String)localObject);
      if (localObject != null) {
        this.ezo.setHeaders((Map)localObject);
      }
      this.ezA = paramBundle.getBoolean("enableRecvMessage", this.ezA);
      this.ezo.setEnableMessage(this.ezA);
      this.ezp.setConfig(this.ezo);
      this.ezy = paramBundle.getBoolean("needEvent", this.ezy);
      paramBoolean = paramBundle.getBoolean("needAudioVolume", this.ezz);
      if (paramBoolean != this.ezz)
      {
        localObject = this.ezp;
        if (!paramBoolean) {
          break label626;
        }
      }
    }
    label561:
    label582:
    label604:
    label626:
    for (int i = 300;; i = 0)
    {
      ((WXLivePlayer)localObject).enableAudioVolumeEvaluation(i);
      this.ezz = paramBoolean;
      paramBoolean = paramBundle.getBoolean("debug", this.ezB);
      if (paramBoolean != this.ezB) {
        this.ezp.showDebugLog(paramBoolean);
      }
      this.ezB = paramBoolean;
      AppMethodBeat.o(220691);
      return;
      if (!paramBundle.keySet().contains("muted")) {
        break;
      }
      bool = paramBundle.getBoolean("muted");
      break;
      if (!((String)localObject).equalsIgnoreCase("vertical")) {
        break label149;
      }
      this.ezp.setRenderRotation(0);
      break label149;
      if (!((String)localObject).equalsIgnoreCase("contain")) {
        break label201;
      }
      this.ezp.setRenderMode(1);
      break label201;
      if (!((String)localObject).equalsIgnoreCase("ear")) {
        break label263;
      }
      this.ezp.setAudioRoute(1);
      break label263;
    }
  }
  
  private static void q(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(220704);
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str.equalsIgnoreCase("playUrl")) || (str.equalsIgnoreCase("orientation")) || (str.equalsIgnoreCase("objectFit")) || (str.equalsIgnoreCase("soundMode"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getString(str);
      } else if ((str.equalsIgnoreCase("mode")) || (str.equalsIgnoreCase("playType"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getInt(str);
      } else if ((str.equalsIgnoreCase("minCache")) || (str.equalsIgnoreCase("maxCache"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getFloat(str);
      } else if ((str.equalsIgnoreCase("hide")) || (str.equalsIgnoreCase("autoplay")) || (str.equalsIgnoreCase("muted")) || (str.equalsIgnoreCase("muteAudio")) || (str.equalsIgnoreCase("muteVideo")) || (str.equalsIgnoreCase("backgroundMute")) || (str.equalsIgnoreCase("needEvent")) || (str.equalsIgnoreCase("needAudioVolume")) || (str.equalsIgnoreCase("enableRecvMessage")) || (str.equalsIgnoreCase("debug"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getBoolean(str);
      }
    }
    Log.i("TXLivePlayerJSAdapter", paramString);
    AppMethodBeat.o(220704);
  }
  
  private int w(Bundle paramBundle)
  {
    AppMethodBeat.i(220667);
    this.mMode = paramBundle.getInt("mode", this.mMode);
    if (this.mMode == 1)
    {
      if (this.eyQ == null)
      {
        AppMethodBeat.o(220667);
        return 0;
      }
      if ((this.eyQ != null) && ((this.eyQ.startsWith("http://")) || (this.eyQ.startsWith("https://"))) && (this.eyQ.contains(".flv")))
      {
        AppMethodBeat.o(220667);
        return 1;
      }
      AppMethodBeat.o(220667);
      return 0;
    }
    AppMethodBeat.o(220667);
    return 5;
  }
  
  public final k a(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(220751);
    if ((paramTXCloudVideoView == null) || (paramBundle == null))
    {
      paramTXCloudVideoView = new k(-1, "invalid params");
      AppMethodBeat.o(220751);
      return paramTXCloudVideoView;
    }
    q("initLivePlayer", paramBundle);
    this.mVideoView = paramTXCloudVideoView;
    this.mVideoView.disableLog(false);
    this.ezp.setPlayerView(paramTXCloudVideoView);
    this.eyQ = paramBundle.getString("playUrl", this.eyQ);
    this.ezr = w(paramBundle);
    a(paramBundle, true);
    this.eyT = paramBundle.getBoolean("autoplay", this.eyT);
    if ((this.eyT) && (this.eyQ != null) && (!this.eyQ.isEmpty()))
    {
      Log.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
      this.ezp.startPlay(this.eyQ, this.ezr);
    }
    this.mInited = true;
    paramTXCloudVideoView = new k();
    AppMethodBeat.o(220751);
    return paramTXCloudVideoView;
  }
  
  public final k atT()
  {
    AppMethodBeat.i(220822);
    if (this.ezp.isPlaying())
    {
      localk = d("pause", null);
      AppMethodBeat.o(220822);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(220822);
    return localk;
  }
  
  public final void atU()
  {
    AppMethodBeat.i(220837);
    if (this.ezq != null) {
      this.ezq.onPlayEvent(6000, new Bundle());
    }
    AppMethodBeat.o(220837);
  }
  
  public final void atV()
  {
    AppMethodBeat.i(220849);
    if (this.ezq != null) {
      this.ezq.onPlayEvent(6001, new Bundle());
    }
    AppMethodBeat.o(220849);
  }
  
  public final k aud()
  {
    AppMethodBeat.i(220861);
    k localk = d("resume", null);
    AppMethodBeat.o(220861);
    return localk;
  }
  
  public final k aue()
  {
    AppMethodBeat.i(220808);
    if (!this.mInited)
    {
      localk = new k(-3, "uninited livePlayer");
      AppMethodBeat.o(220808);
      return localk;
    }
    this.ezp.stopPlay(true);
    this.ezp.setPlayListener(null);
    this.mInited = false;
    k localk = new k();
    AppMethodBeat.o(220808);
    return localk;
  }
  
  public final k d(String paramString, JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    AppMethodBeat.i(220794);
    if (paramString == null)
    {
      paramString = new k(-1, "invalid params");
      AppMethodBeat.o(220794);
      return paramString;
    }
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    }
    Log.i("TXLivePlayerJSAdapter", "operateLivePlayer: type = " + paramString + " params = " + str);
    if (!this.mInited)
    {
      paramString = new k(-3, "uninited livePlayer");
      AppMethodBeat.o(220794);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("play")) {
      this.ezp.startPlay(this.eyQ, this.ezr);
    }
    for (;;)
    {
      paramString = new k();
      AppMethodBeat.o(220794);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.ezp.stopPlay(true);
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        this.ezp.pause();
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.ezp.resume();
      }
      else
      {
        if (paramString.equalsIgnoreCase("mute"))
        {
          if (!this.mMuteAudio) {}
          for (bool1 = true;; bool1 = false)
          {
            this.mMuteAudio = bool1;
            this.ezp.muteAudio(this.mMuteAudio);
            break;
          }
        }
        if (!paramString.equalsIgnoreCase("snapshot")) {
          break;
        }
        boolean bool1 = bool2;
        if (paramJSONObject != null)
        {
          paramString = paramJSONObject.optString("quality");
          bool1 = bool2;
          if (paramString != null)
          {
            bool1 = bool2;
            if (paramString.equalsIgnoreCase("compressed")) {
              bool1 = true;
            }
          }
        }
        takePhoto(bool1, this.mSnapshotListener);
      }
    }
    paramString = new k(-4, "invalid operate command");
    AppMethodBeat.o(220794);
    return paramString;
  }
  
  public final k dc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220779);
    this.ezp.setSurfaceSize(paramInt1, paramInt2);
    k localk = new k();
    AppMethodBeat.o(220779);
    return localk;
  }
  
  public final k h(Surface paramSurface)
  {
    AppMethodBeat.i(220774);
    this.mSurface = paramSurface;
    this.ezp.setSurface(paramSurface);
    paramSurface = new k();
    AppMethodBeat.o(220774);
    return paramSurface;
  }
  
  public final boolean isMuted()
  {
    return this.mMuteAudio;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(220874);
    boolean bool = this.ezp.isPlaying();
    AppMethodBeat.o(220874);
    return bool;
  }
  
  public final k mA(int paramInt)
  {
    AppMethodBeat.i(220962);
    k localk = new k();
    AppMethodBeat.o(220962);
    return localk;
  }
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(220955);
    if ((this.ezz) && (this.mAudioVolumeListener != null)) {
      this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(220955);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(220949);
    if (this.ezq != null) {
      this.ezq.onNetStatus(paramBundle);
    }
    Log.i("TXLivePlayerJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(220949);
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(220929);
    Object localObject;
    if ((paramInt == 2006) || (paramInt == -2301))
    {
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220636);
          d.this.d("stop", null);
          AppMethodBeat.o(220636);
        }
      };
      if (this.mHandler != null) {
        this.mHandler.post((Runnable)localObject);
      }
    }
    if (paramInt == 2012)
    {
      if (!this.ezA) {
        break label184;
      }
      if (paramBundle != null)
      {
        localObject = paramBundle.getByteArray("EVT_GET_MSG");
        if ((localObject == null) || (localObject.length <= 0)) {
          break label178;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = new String((byte[])localObject, "UTF-8");
        paramBundle.putString("EVT_MSG", (String)localObject);
        if (this.ezq != null) {
          this.ezq.onPlayEvent(paramInt, paramBundle);
        }
        paramBundle = paramBundle.getString("EVT_MSG");
        Log.i("TXLivePlayerJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
        AppMethodBeat.o(220929);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Log.printErrStackTrace("TXLivePlayerJSAdapter", localUnsupportedEncodingException, "", new Object[0]);
      }
      label178:
      String str = "";
    }
    label184:
    Log.i("TXLivePlayerJSAdapter", "onPushEvent: ignore sei message");
    AppMethodBeat.o(220929);
  }
  
  public final void setAudioVolumeListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.mAudioVolumeListener = paramITXAudioVolumeEvaluationListener;
  }
  
  public final void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    this.ezq = paramITXLivePlayListener;
  }
  
  public final void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.mSnapshotListener = paramITXSnapshotListener;
  }
  
  public final void setThreadHandler(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public final void takePhoto(final boolean paramBoolean, final TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(220905);
    if ((this.ezp != null) && (this.ezp.isPlaying())) {
      this.ezp.snapshot(new TXLivePlayer.ITXSnapshotListener()
      {
        public final void onSnapshot(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(220639);
          if (paramITXSnapshotListener != null)
          {
            if (paramBoolean)
            {
              if (paramAnonymousBitmap != null)
              {
                int i = paramAnonymousBitmap.getWidth();
                int j = paramAnonymousBitmap.getHeight();
                Object localObject = new Matrix();
                ((Matrix)localObject).setScale(0.5F, 0.5F);
                localObject = Bitmap.createBitmap(paramAnonymousBitmap, 0, 0, i, j, (Matrix)localObject, false);
                paramITXSnapshotListener.onSnapshot((Bitmap)localObject);
                d.w(paramAnonymousBitmap);
                AppMethodBeat.o(220639);
                return;
              }
              paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
              AppMethodBeat.o(220639);
              return;
            }
            paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
          }
          AppMethodBeat.o(220639);
        }
      });
    }
    AppMethodBeat.o(220905);
  }
  
  public final k u(Bundle paramBundle)
  {
    AppMethodBeat.i(220767);
    if (paramBundle == null)
    {
      paramBundle = new k(-1, "invalid params");
      AppMethodBeat.o(220767);
      return paramBundle;
    }
    if (this.ezq != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
      localBundle.putLong("EVT_TIME", System.currentTimeMillis());
      this.ezq.onPlayEvent(-9999999, localBundle);
    }
    q("initLivePlayer", paramBundle);
    this.mVideoView = null;
    this.eyQ = paramBundle.getString("playUrl", this.eyQ);
    this.ezr = w(paramBundle);
    a(paramBundle, true);
    this.eyT = paramBundle.getBoolean("autoplay", this.eyT);
    if ((paramBundle.getBoolean("canStartPlay", true)) && (this.eyT) && (this.eyQ != null) && (!this.eyQ.isEmpty()))
    {
      Log.i("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
      this.ezp.startPlay(this.eyQ, this.ezr);
    }
    this.mInited = true;
    paramBundle = new k();
    AppMethodBeat.o(220767);
    return paramBundle;
  }
  
  public final k v(Bundle paramBundle)
  {
    AppMethodBeat.i(220787);
    if (paramBundle == null)
    {
      paramBundle = new k(-1, "invalid params");
      AppMethodBeat.o(220787);
      return paramBundle;
    }
    if (!this.mInited)
    {
      paramBundle = new k(-3, "uninited livePlayer");
      AppMethodBeat.o(220787);
      return paramBundle;
    }
    q("updateLivePlayer", paramBundle);
    a(paramBundle, false);
    boolean bool = this.ezp.isPlaying();
    String str = paramBundle.getString("playUrl", this.eyQ);
    if ((str != null) && (!str.isEmpty()) && (this.eyQ != null) && (!this.eyQ.equalsIgnoreCase(str)) && (this.ezp.isPlaying()))
    {
      Log.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + this.eyQ + " playUrl-new = " + str);
      this.ezp.stopPlay(true);
    }
    this.eyQ = str;
    int i = w(paramBundle);
    if ((i != this.ezr) && (this.ezp.isPlaying()))
    {
      Log.i("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + this.ezr + " playType-new = " + i);
      this.ezp.stopPlay(true);
    }
    this.ezr = i;
    this.eyT = paramBundle.getBoolean("autoplay", this.eyT);
    if (((this.eyT) || (bool)) && (this.eyQ != null) && (!this.eyQ.isEmpty()) && (!this.ezp.isPlaying()))
    {
      Log.i("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
      this.ezp.startPlay(this.eyQ, this.ezr);
    }
    paramBundle = new k();
    AppMethodBeat.o(220787);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.d
 * JD-Core Version:    0.7.0.1
 */