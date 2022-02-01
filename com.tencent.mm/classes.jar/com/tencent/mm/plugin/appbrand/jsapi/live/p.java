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
  private String cFC;
  private boolean cFF;
  private boolean cFq;
  private boolean cFr;
  private WXLivePlayConfig cGa;
  private WXLivePlayer cGb;
  private ITXLivePlayListener cGc;
  private int cGd;
  private String cGe;
  private String cGf;
  private String cGg;
  private float cGh;
  private float cGi;
  private boolean cGj;
  private boolean cGk;
  private boolean cGl;
  private boolean cGm;
  private boolean cGn;
  private TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
  private Context mContext;
  private boolean mInited;
  private int mMode;
  private boolean mMuteAudio;
  private boolean mMuteVideo;
  private TXLivePlayer.ITXSnapshotListener mSnapshotListener;
  private TXCloudVideoView mVideoView;
  private boolean oVR;
  
  public p(Context paramContext)
  {
    AppMethodBeat.i(212767);
    this.cFC = "";
    this.cGd = 0;
    this.mInited = false;
    this.oVR = false;
    this.cFF = false;
    this.mMode = 1;
    this.mMuteAudio = false;
    this.mMuteVideo = false;
    this.cGe = "vertical";
    this.cGf = "contain";
    this.cGg = "speaker";
    this.cGh = 1.0F;
    this.cGi = 3.0F;
    this.cGj = true;
    this.cGk = false;
    this.cGl = false;
    this.cGm = false;
    this.cGn = false;
    this.cFq = true;
    this.cFr = true;
    this.mContext = paramContext;
    this.cGa = new WXLivePlayConfig();
    this.cGb = new WXLivePlayer(this.mContext);
    this.cGb.enableHardwareDecode(true);
    this.cGb.setConfig(this.cGa);
    this.cGb.setPlayListener(this);
    this.cGb.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(212767);
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(212803);
    boolean bool = this.mMuteAudio;
    Object localObject;
    if (paramBundle.keySet().contains("muteAudio"))
    {
      bool = paramBundle.getBoolean("muteAudio");
      if ((paramBoolean) || (bool != this.mMuteAudio)) {
        this.cGb.muteAudio(bool);
      }
      this.mMuteAudio = bool;
      bool = paramBundle.getBoolean("muteVideo", this.mMuteVideo);
      if ((paramBoolean) || (bool != this.mMuteVideo)) {
        this.cGb.muteVideo(bool);
      }
      this.mMuteVideo = bool;
      localObject = paramBundle.getString("orientation", this.cGe);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.cGe)))
      {
        if (!((String)localObject).equalsIgnoreCase("horizontal")) {
          break label533;
        }
        this.cGb.setRenderRotation(270);
      }
      label151:
      this.cGe = ((String)localObject);
      localObject = paramBundle.getString("objectFit", this.cGf);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.cGf)))
      {
        if (!((String)localObject).equalsIgnoreCase("fillCrop")) {
          break label554;
        }
        this.cGb.setRenderMode(0);
      }
      label203:
      this.cGf = ((String)localObject);
      if (paramBundle.keySet().contains("soundMode"))
      {
        localObject = paramBundle.getString("soundMode", this.cGg);
        if (!((String)localObject).equalsIgnoreCase(this.cGg))
        {
          if (!((String)localObject).equalsIgnoreCase("speaker")) {
            break label575;
          }
          this.cGb.setAudioRoute(0);
        }
      }
    }
    for (;;)
    {
      this.cGg = ((String)localObject);
      this.cGh = paramBundle.getFloat("minCache", this.cGh);
      this.cGi = paramBundle.getFloat("maxCache", this.cGi);
      this.cGa.setAutoAdjustCacheTime(true);
      this.cGa.setCacheTime(this.cGh);
      this.cGa.setMinAutoAdjustCacheTime(this.cGh);
      this.cGa.setMaxAutoAdjustCacheTime(this.cGi);
      this.cGm = paramBundle.getBoolean("enableRecvMessage", this.cGm);
      this.cGa.setEnableMessage(this.cGm);
      this.cGb.setConfig(this.cGa);
      this.cGk = paramBundle.getBoolean("needEvent", this.cGk);
      this.cFq = paramBundle.getBoolean("autoPauseIfNavigate", this.cFq);
      this.cFr = paramBundle.getBoolean("autoPauseIfOpenNative", this.cFr);
      paramBoolean = paramBundle.getBoolean("needAudioVolume", this.cGl);
      if (paramBoolean != this.cGl)
      {
        localObject = this.cGb;
        if (paramBoolean) {
          i = 300;
        }
        ((WXLivePlayer)localObject).enableAudioVolumeEvaluation(i);
      }
      this.cGl = paramBoolean;
      paramBoolean = paramBundle.getBoolean("debug", this.cGn);
      if (paramBoolean != this.cGn) {
        this.cGb.showDebugLog(paramBoolean);
      }
      this.cGn = paramBoolean;
      AppMethodBeat.o(212803);
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
      this.cGb.setRenderRotation(0);
      break label151;
      label554:
      if (!((String)localObject).equalsIgnoreCase("contain")) {
        break label203;
      }
      this.cGb.setRenderMode(1);
      break label203;
      label575:
      if (((String)localObject).equalsIgnoreCase("ear")) {
        this.cGb.setAudioRoute(1);
      }
    }
  }
  
  private static void q(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(212808);
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
    AppMethodBeat.o(212808);
  }
  
  private int r(Bundle paramBundle)
  {
    AppMethodBeat.i(212799);
    this.mMode = paramBundle.getInt("mode", this.mMode);
    if (this.mMode == 1)
    {
      if (this.cFC == null)
      {
        AppMethodBeat.o(212799);
        return 0;
      }
      if ((this.cFC != null) && ((this.cFC.startsWith("http://")) || (this.cFC.startsWith("https://"))) && (this.cFC.contains(".flv")))
      {
        AppMethodBeat.o(212799);
        return 1;
      }
      AppMethodBeat.o(212799);
      return 0;
    }
    AppMethodBeat.o(212799);
    return 5;
  }
  
  public final k Ty()
  {
    AppMethodBeat.i(212788);
    if (this.oVR)
    {
      localk = d("resume", null);
      AppMethodBeat.o(212788);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(212788);
    return localk;
  }
  
  public final k Tz()
  {
    AppMethodBeat.i(212784);
    if (!this.mInited)
    {
      localk = new k(-3, "uninited livePlayer");
      AppMethodBeat.o(212784);
      return localk;
    }
    this.cGb.stopPlay(true);
    this.cGb.setPlayListener(null);
    this.mInited = false;
    k localk = new k();
    AppMethodBeat.o(212784);
    return localk;
  }
  
  public final k a(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(212775);
    if ((paramTXCloudVideoView == null) || (paramBundle == null))
    {
      paramTXCloudVideoView = new k(-1, "invalid params");
      AppMethodBeat.o(212775);
      return paramTXCloudVideoView;
    }
    q("initLivePlayer", paramBundle);
    this.mVideoView = paramTXCloudVideoView;
    this.mVideoView.disableLog(false);
    this.cGb.setPlayerView(paramTXCloudVideoView);
    this.cFC = paramBundle.getString("playUrl", this.cFC);
    this.cGd = r(paramBundle);
    a(paramBundle, true);
    this.cFF = paramBundle.getBoolean("autoplay", this.cFF);
    if ((this.cFF) && (this.cFC != null) && (!this.cFC.isEmpty()))
    {
      Log.i("TXLivePlayerJSAdapterV1", "initLivePlayer: startPlay");
      this.cGb.startPlay(this.cFC, this.cGd);
    }
    this.mInited = true;
    paramTXCloudVideoView = new k();
    AppMethodBeat.o(212775);
    return paramTXCloudVideoView;
  }
  
  public final k d(String paramString, JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    AppMethodBeat.i(212782);
    if (paramString == null)
    {
      paramString = new k(-1, "invalid params");
      AppMethodBeat.o(212782);
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
      AppMethodBeat.o(212782);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("play")) {
      this.cGb.startPlay(this.cFC, this.cGd);
    }
    for (;;)
    {
      paramString = new k();
      AppMethodBeat.o(212782);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.cGb.stopPlay(true);
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        this.cGb.pause();
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.cGb.resume();
      }
      else
      {
        if (paramString.equalsIgnoreCase("mute"))
        {
          if (!this.mMuteAudio) {}
          for (bool1 = true;; bool1 = false)
          {
            this.mMuteAudio = bool1;
            this.cGb.muteAudio(this.mMuteAudio);
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
    AppMethodBeat.o(212782);
    return paramString;
  }
  
  public final k iY(int paramInt)
  {
    AppMethodBeat.i(212786);
    Log.i("TXLivePlayerJSAdapterV1", "enterBackground");
    if (((paramInt == 2) && (!this.cFr)) || ((paramInt == 1) && (!this.cFq)))
    {
      this.oVR = false;
      localk = new k();
      AppMethodBeat.o(212786);
      return localk;
    }
    this.oVR = this.cGb.isPlaying();
    if (this.oVR)
    {
      if ((this.cGk) && (this.cGc != null)) {
        this.cGc.onPlayEvent(6000, new Bundle());
      }
      localk = d("pause", null);
      AppMethodBeat.o(212786);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(212786);
    return localk;
  }
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(212796);
    if ((this.cGl) && (this.mAudioVolumeListener != null)) {
      this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(212796);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(212795);
    if (this.cGc != null) {
      this.cGc.onNetStatus(paramBundle);
    }
    Log.i("TXLivePlayerJSAdapterV1", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(212795);
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(212792);
    if ((paramInt == 2006) || (paramInt == -2301)) {
      d("stop", null);
    }
    Object localObject;
    if (paramInt == 2012)
    {
      if (!this.cGm) {
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
        if ((this.cGk) && (this.cGc != null)) {
          this.cGc.onPlayEvent(paramInt, paramBundle);
        }
        paramBundle = paramBundle.getString("EVT_MSG");
        Log.i("TXLivePlayerJSAdapterV1", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
        AppMethodBeat.o(212792);
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
    AppMethodBeat.o(212792);
  }
  
  public final k q(Bundle paramBundle)
  {
    AppMethodBeat.i(212777);
    if (paramBundle == null)
    {
      paramBundle = new k(-1, "invalid params");
      AppMethodBeat.o(212777);
      return paramBundle;
    }
    if (!this.mInited)
    {
      paramBundle = new k(-3, "uninited livePlayer");
      AppMethodBeat.o(212777);
      return paramBundle;
    }
    q("updateLivePlayer", paramBundle);
    a(paramBundle, false);
    boolean bool = this.cGb.isPlaying();
    String str = paramBundle.getString("playUrl", this.cFC);
    if ((str != null) && (!str.isEmpty()) && (this.cFC != null) && (!this.cFC.equalsIgnoreCase(str)) && (this.cGb.isPlaying()))
    {
      Log.i("TXLivePlayerJSAdapterV1", "updateLivePlayer: stopPlay playUrl-old = " + this.cFC + " playUrl-new = " + str);
      this.cGb.stopPlay(true);
    }
    this.cFC = str;
    int i = r(paramBundle);
    if ((i != this.cGd) && (this.cGb.isPlaying()))
    {
      Log.i("TXLivePlayerJSAdapterV1", "updateLivePlayer: stopPlay  playType-old = " + this.cGd + " playType-new = " + i);
      this.cGb.stopPlay(true);
    }
    this.cGd = i;
    this.cFF = paramBundle.getBoolean("autoplay", this.cFF);
    if (((this.cFF) || (bool)) && (this.cFC != null) && (!this.cFC.isEmpty()) && (!this.cGb.isPlaying()))
    {
      Log.i("TXLivePlayerJSAdapterV1", "updateLivePlayer: startPlay");
      this.cGb.startPlay(this.cFC, this.cGd);
    }
    paramBundle = new k();
    AppMethodBeat.o(212777);
    return paramBundle;
  }
  
  public final void setAudioVolumeListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.mAudioVolumeListener = paramITXAudioVolumeEvaluationListener;
  }
  
  public final void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    this.cGc = paramITXLivePlayListener;
  }
  
  public final void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.mSnapshotListener = paramITXSnapshotListener;
  }
  
  public final void takePhoto(final boolean paramBoolean, final TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(212789);
    if (this.cGb != null) {
      this.cGb.snapshot(new TXLivePlayer.ITXSnapshotListener()
      {
        public final void onSnapshot(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(213040);
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
                p.R(paramAnonymousBitmap);
                AppMethodBeat.o(213040);
                return;
              }
              paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
              AppMethodBeat.o(213040);
              return;
            }
            paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
          }
          AppMethodBeat.o(213040);
        }
      });
    }
    AppMethodBeat.o(212789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.p
 * JD-Core Version:    0.7.0.1
 */