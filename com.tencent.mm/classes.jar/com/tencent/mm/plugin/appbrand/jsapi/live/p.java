package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.WXLivePlayConfig;
import com.tencent.rtmp.WXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class p
  implements a, ITXLivePlayListener, TXLivePlayer.ITXAudioVolumeEvaluationListener
{
  private boolean eyE;
  private boolean eyF;
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
  private boolean mInited;
  private int mMode;
  private boolean mMuteAudio;
  private boolean mMuteVideo;
  private TXLivePlayer.ITXSnapshotListener mSnapshotListener;
  private TXCloudVideoView mVideoView;
  private boolean sbp;
  
  public p(Context paramContext)
  {
    AppMethodBeat.i(326143);
    this.eyQ = "";
    this.ezr = 0;
    this.mInited = false;
    this.sbp = false;
    this.eyT = false;
    this.mMode = 1;
    this.mMuteAudio = false;
    this.mMuteVideo = false;
    this.ezs = "vertical";
    this.ezt = "contain";
    this.ezu = "speaker";
    this.ezv = 1.0F;
    this.ezw = 3.0F;
    this.ezx = true;
    this.ezy = false;
    this.ezz = false;
    this.ezA = false;
    this.ezB = false;
    this.eyE = true;
    this.eyF = true;
    this.mContext = paramContext;
    this.ezo = new WXLivePlayConfig();
    this.ezp = new WXLivePlayer(this.mContext);
    this.ezp.enableHardwareDecode(true);
    this.ezp.setConfig(this.ezo);
    this.ezp.setPlayListener(this);
    this.ezp.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(326143);
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(326162);
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
          break label533;
        }
        this.ezp.setRenderRotation(270);
      }
      label151:
      this.ezs = ((String)localObject);
      localObject = paramBundle.getString("objectFit", this.ezt);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.ezt)))
      {
        if (!((String)localObject).equalsIgnoreCase("fillCrop")) {
          break label554;
        }
        this.ezp.setRenderMode(0);
      }
      label203:
      this.ezt = ((String)localObject);
      if (paramBundle.keySet().contains("soundMode"))
      {
        localObject = paramBundle.getString("soundMode", this.ezu);
        if (!((String)localObject).equalsIgnoreCase(this.ezu))
        {
          if (!((String)localObject).equalsIgnoreCase("speaker")) {
            break label575;
          }
          this.ezp.setAudioRoute(0);
        }
      }
    }
    for (;;)
    {
      this.ezu = ((String)localObject);
      this.ezv = paramBundle.getFloat("minCache", this.ezv);
      this.ezw = paramBundle.getFloat("maxCache", this.ezw);
      this.ezo.setAutoAdjustCacheTime(true);
      this.ezo.setCacheTime(this.ezv);
      this.ezo.setMinAutoAdjustCacheTime(this.ezv);
      this.ezo.setMaxAutoAdjustCacheTime(this.ezw);
      this.ezA = paramBundle.getBoolean("enableRecvMessage", this.ezA);
      this.ezo.setEnableMessage(this.ezA);
      this.ezp.setConfig(this.ezo);
      this.ezy = paramBundle.getBoolean("needEvent", this.ezy);
      this.eyE = paramBundle.getBoolean("autoPauseIfNavigate", this.eyE);
      this.eyF = paramBundle.getBoolean("autoPauseIfOpenNative", this.eyF);
      paramBoolean = paramBundle.getBoolean("needAudioVolume", this.ezz);
      if (paramBoolean != this.ezz)
      {
        localObject = this.ezp;
        if (paramBoolean) {
          i = 300;
        }
        ((WXLivePlayer)localObject).enableAudioVolumeEvaluation(i);
      }
      this.ezz = paramBoolean;
      paramBoolean = paramBundle.getBoolean("debug", this.ezB);
      if (paramBoolean != this.ezB) {
        this.ezp.showDebugLog(paramBoolean);
      }
      this.ezB = paramBoolean;
      AppMethodBeat.o(326162);
      return;
      if (!paramBundle.keySet().contains("muted")) {
        break;
      }
      bool = paramBundle.getBoolean("muted");
      break;
      label533:
      if (!((String)localObject).equalsIgnoreCase("vertical")) {
        break label151;
      }
      this.ezp.setRenderRotation(0);
      break label151;
      label554:
      if (!((String)localObject).equalsIgnoreCase("contain")) {
        break label203;
      }
      this.ezp.setRenderMode(1);
      break label203;
      label575:
      if (((String)localObject).equalsIgnoreCase("ear")) {
        this.ezp.setAudioRoute(1);
      }
    }
  }
  
  private static void q(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(326171);
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
    Log.i("TXLivePlayerJSAdapterV1", paramString);
    AppMethodBeat.o(326171);
  }
  
  private int w(Bundle paramBundle)
  {
    AppMethodBeat.i(326148);
    this.mMode = paramBundle.getInt("mode", this.mMode);
    if (this.mMode == 1)
    {
      if (this.eyQ == null)
      {
        AppMethodBeat.o(326148);
        return 0;
      }
      if ((this.eyQ != null) && ((this.eyQ.startsWith("http://")) || (this.eyQ.startsWith("https://"))) && (this.eyQ.contains(".flv")))
      {
        AppMethodBeat.o(326148);
        return 1;
      }
      AppMethodBeat.o(326148);
      return 0;
    }
    AppMethodBeat.o(326148);
    return 5;
  }
  
  public final k a(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(326191);
    if ((paramTXCloudVideoView == null) || (paramBundle == null))
    {
      paramTXCloudVideoView = new k(-1, "invalid params");
      AppMethodBeat.o(326191);
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
      Log.i("TXLivePlayerJSAdapterV1", "initLivePlayer: startPlay");
      this.ezp.startPlay(this.eyQ, this.ezr);
    }
    this.mInited = true;
    paramTXCloudVideoView = new k();
    AppMethodBeat.o(326191);
    return paramTXCloudVideoView;
  }
  
  public final k aud()
  {
    AppMethodBeat.i(326208);
    if (this.sbp)
    {
      localk = d("resume", null);
      AppMethodBeat.o(326208);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(326208);
    return localk;
  }
  
  public final k aue()
  {
    AppMethodBeat.i(326201);
    if (!this.mInited)
    {
      localk = new k(-3, "uninited livePlayer");
      AppMethodBeat.o(326201);
      return localk;
    }
    this.ezp.stopPlay(true);
    this.ezp.setPlayListener(null);
    this.mInited = false;
    k localk = new k();
    AppMethodBeat.o(326201);
    return localk;
  }
  
  public final k d(String paramString, JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    AppMethodBeat.i(326200);
    if (paramString == null)
    {
      paramString = new k(-1, "invalid params");
      AppMethodBeat.o(326200);
      return paramString;
    }
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    }
    Log.i("TXLivePlayerJSAdapterV1", "operateLivePlayer: type = " + paramString + " params = " + str);
    if (!this.mInited)
    {
      paramString = new k(-3, "uninited livePlayer");
      AppMethodBeat.o(326200);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("play")) {
      this.ezp.startPlay(this.eyQ, this.ezr);
    }
    for (;;)
    {
      paramString = new k();
      AppMethodBeat.o(326200);
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
    AppMethodBeat.o(326200);
    return paramString;
  }
  
  public final k mA(int paramInt)
  {
    AppMethodBeat.i(326206);
    Log.i("TXLivePlayerJSAdapterV1", "enterBackground");
    if (((paramInt == 2) && (!this.eyF)) || ((paramInt == 1) && (!this.eyE)))
    {
      this.sbp = false;
      localk = new k();
      AppMethodBeat.o(326206);
      return localk;
    }
    this.sbp = this.ezp.isPlaying();
    if (this.sbp)
    {
      if ((this.ezy) && (this.ezq != null)) {
        this.ezq.onPlayEvent(6000, new Bundle());
      }
      localk = d("pause", null);
      AppMethodBeat.o(326206);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(326206);
    return localk;
  }
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(326224);
    if ((this.ezz) && (this.mAudioVolumeListener != null)) {
      this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(326224);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(326218);
    if (this.ezq != null) {
      this.ezq.onNetStatus(paramBundle);
    }
    Log.i("TXLivePlayerJSAdapterV1", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(326218);
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(326214);
    if ((paramInt == 2006) || (paramInt == -2301)) {
      d("stop", null);
    }
    Object localObject;
    if (paramInt == 2012)
    {
      if (!this.ezA) {
        break label175;
      }
      if (paramBundle != null)
      {
        localObject = paramBundle.getByteArray("EVT_GET_MSG");
        if ((localObject == null) || (localObject.length <= 0)) {
          break label169;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = new String((byte[])localObject, "UTF-8");
        paramBundle.putString("EVT_MSG", (String)localObject);
        if ((this.ezy) && (this.ezq != null)) {
          this.ezq.onPlayEvent(paramInt, paramBundle);
        }
        paramBundle = paramBundle.getString("EVT_MSG");
        Log.i("TXLivePlayerJSAdapterV1", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
        AppMethodBeat.o(326214);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Log.printErrStackTrace("TXLivePlayerJSAdapterV1", localUnsupportedEncodingException, "", new Object[0]);
      }
      label169:
      String str = "";
    }
    label175:
    Log.i("TXLivePlayerJSAdapterV1", "onPushEvent: ignore sei message");
    AppMethodBeat.o(326214);
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
  
  public final void takePhoto(final boolean paramBoolean, final TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(326211);
    if (this.ezp != null) {
      this.ezp.snapshot(new TXLivePlayer.ITXSnapshotListener()
      {
        public final void onSnapshot(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(326127);
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
                p.Z(paramAnonymousBitmap);
                AppMethodBeat.o(326127);
                return;
              }
              paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
              AppMethodBeat.o(326127);
              return;
            }
            paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
          }
          AppMethodBeat.o(326127);
        }
      });
    }
    AppMethodBeat.o(326211);
  }
  
  public final k v(Bundle paramBundle)
  {
    AppMethodBeat.i(326197);
    if (paramBundle == null)
    {
      paramBundle = new k(-1, "invalid params");
      AppMethodBeat.o(326197);
      return paramBundle;
    }
    if (!this.mInited)
    {
      paramBundle = new k(-3, "uninited livePlayer");
      AppMethodBeat.o(326197);
      return paramBundle;
    }
    q("updateLivePlayer", paramBundle);
    a(paramBundle, false);
    boolean bool = this.ezp.isPlaying();
    String str = paramBundle.getString("playUrl", this.eyQ);
    if ((str != null) && (!str.isEmpty()) && (this.eyQ != null) && (!this.eyQ.equalsIgnoreCase(str)) && (this.ezp.isPlaying()))
    {
      Log.i("TXLivePlayerJSAdapterV1", "updateLivePlayer: stopPlay playUrl-old = " + this.eyQ + " playUrl-new = " + str);
      this.ezp.stopPlay(true);
    }
    this.eyQ = str;
    int i = w(paramBundle);
    if ((i != this.ezr) && (this.ezp.isPlaying()))
    {
      Log.i("TXLivePlayerJSAdapterV1", "updateLivePlayer: stopPlay  playType-old = " + this.ezr + " playType-new = " + i);
      this.ezp.stopPlay(true);
    }
    this.ezr = i;
    this.eyT = paramBundle.getBoolean("autoplay", this.eyT);
    if (((this.eyT) || (bool)) && (this.eyQ != null) && (!this.eyQ.isEmpty()) && (!this.ezp.isPlaying()))
    {
      Log.i("TXLivePlayerJSAdapterV1", "updateLivePlayer: startPlay");
      this.ezp.startPlay(this.eyQ, this.ezr);
    }
    paramBundle = new k();
    AppMethodBeat.o(326197);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.p
 * JD-Core Version:    0.7.0.1
 */