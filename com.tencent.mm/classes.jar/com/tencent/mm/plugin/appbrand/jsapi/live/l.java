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

public final class l
  implements ITXLivePlayListener, TXLivePlayer.ITXAudioVolumeEvaluationListener
{
  boolean cEK;
  boolean cEL;
  String cEW;
  boolean cEZ;
  private String cFA;
  private float cFB;
  private float cFC;
  private boolean cFD;
  boolean cFE;
  private boolean cFF;
  private boolean cFG;
  private boolean cFH;
  private WXLivePlayConfig cFt;
  WXLivePlayer cFu;
  ITXLivePlayListener cFv;
  TXLivePlayer.ITXSnapshotListener cFw;
  int cFx;
  private String cFy;
  private String cFz;
  boolean lYb;
  TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
  private Context mContext;
  boolean mInited;
  private int mMode;
  private boolean mMuteAudio;
  private boolean mMuteVideo;
  TXCloudVideoView mVideoView;
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(145906);
    this.cEW = "";
    this.cFx = 0;
    this.mInited = false;
    this.lYb = false;
    this.cEZ = false;
    this.mMode = 1;
    this.mMuteAudio = false;
    this.mMuteVideo = false;
    this.cFy = "vertical";
    this.cFz = "contain";
    this.cFA = "speaker";
    this.cFB = 1.0F;
    this.cFC = 3.0F;
    this.cFD = true;
    this.cFE = false;
    this.cFF = false;
    this.cFG = false;
    this.cFH = false;
    this.cEK = true;
    this.cEL = true;
    this.mContext = paramContext;
    this.cFt = new WXLivePlayConfig();
    this.cFu = new WXLivePlayer(this.mContext);
    this.cFu.enableHardwareDecode(true);
    this.cFu.setConfig(this.cFt);
    this.cFu.setPlayListener(this);
    this.cFu.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(145906);
  }
  
  private void a(final boolean paramBoolean, final TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(145908);
    if (this.cFu != null) {
      this.cFu.snapshot(new TXLivePlayer.ITXSnapshotListener()
      {
        public final void onSnapshot(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(145905);
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
                l.T(paramAnonymousBitmap);
                AppMethodBeat.o(145905);
                return;
              }
              paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
              AppMethodBeat.o(145905);
              return;
            }
            paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
          }
          AppMethodBeat.o(145905);
        }
      });
    }
    AppMethodBeat.o(145908);
  }
  
  static void l(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(145914);
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
    AppMethodBeat.o(145914);
  }
  
  final void a(Bundle paramBundle, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(145913);
    boolean bool = this.mMuteAudio;
    Object localObject;
    if (paramBundle.keySet().contains("muteAudio"))
    {
      bool = paramBundle.getBoolean("muteAudio");
      if ((paramBoolean) || (bool != this.mMuteAudio)) {
        this.cFu.muteAudio(bool);
      }
      this.mMuteAudio = bool;
      bool = paramBundle.getBoolean("muteVideo", this.mMuteVideo);
      if ((paramBoolean) || (bool != this.mMuteVideo)) {
        this.cFu.muteVideo(bool);
      }
      this.mMuteVideo = bool;
      localObject = paramBundle.getString("orientation", this.cFy);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.cFy)))
      {
        if (!((String)localObject).equalsIgnoreCase("horizontal")) {
          break label540;
        }
        this.cFu.setRenderRotation(270);
      }
      label156:
      this.cFy = ((String)localObject);
      localObject = paramBundle.getString("objectFit", this.cFz);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.cFz)))
      {
        if (!((String)localObject).equalsIgnoreCase("fillCrop")) {
          break label561;
        }
        this.cFu.setRenderMode(0);
      }
      label209:
      this.cFz = ((String)localObject);
      if (paramBundle.keySet().contains("soundMode"))
      {
        localObject = paramBundle.getString("soundMode", this.cFA);
        if (!((String)localObject).equalsIgnoreCase(this.cFA))
        {
          if (!((String)localObject).equalsIgnoreCase("speaker")) {
            break label582;
          }
          this.cFu.setAudioRoute(0);
        }
      }
    }
    for (;;)
    {
      this.cFA = ((String)localObject);
      this.cFB = paramBundle.getFloat("minCache", this.cFB);
      this.cFC = paramBundle.getFloat("maxCache", this.cFC);
      this.cFt.setAutoAdjustCacheTime(true);
      this.cFt.setCacheTime(this.cFB);
      this.cFt.setMinAutoAdjustCacheTime(this.cFB);
      this.cFt.setMaxAutoAdjustCacheTime(this.cFC);
      this.cFG = paramBundle.getBoolean("enableRecvMessage", this.cFG);
      this.cFt.setEnableMessage(this.cFG);
      this.cFu.setConfig(this.cFt);
      this.cFE = paramBundle.getBoolean("needEvent", this.cFE);
      this.cEK = paramBundle.getBoolean("autoPauseIfNavigate", this.cEK);
      this.cEL = paramBundle.getBoolean("autoPauseIfOpenNative", this.cEL);
      paramBoolean = paramBundle.getBoolean("needAudioVolume", this.cFF);
      if (paramBoolean != this.cFF)
      {
        localObject = this.cFu;
        if (paramBoolean) {
          i = 300;
        }
        ((WXLivePlayer)localObject).enableAudioVolumeEvaluation(i);
      }
      this.cFF = paramBoolean;
      paramBoolean = paramBundle.getBoolean("debug", this.cFH);
      if (paramBoolean != this.cFH) {
        this.cFu.showDebugLog(paramBoolean);
      }
      this.cFH = paramBoolean;
      AppMethodBeat.o(145913);
      return;
      if (!paramBundle.keySet().contains("muted")) {
        break;
      }
      bool = paramBundle.getBoolean("muted");
      break;
      label540:
      if (!((String)localObject).equalsIgnoreCase("vertical")) {
        break label156;
      }
      this.cFu.setRenderRotation(0);
      break label156;
      label561:
      if (!((String)localObject).equalsIgnoreCase("contain")) {
        break label209;
      }
      this.cFu.setRenderMode(1);
      break label209;
      label582:
      if (((String)localObject).equalsIgnoreCase("ear")) {
        this.cFu.setAudioRoute(1);
      }
    }
  }
  
  public final i k(String paramString, JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    AppMethodBeat.i(145907);
    if (paramString == null)
    {
      paramString = new i(-1, "invalid params");
      AppMethodBeat.o(145907);
      return paramString;
    }
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    }
    Log.i("TXLivePlayerJSAdapter", "operateLivePlayer: type = " + paramString + " params = " + str);
    if (!this.mInited)
    {
      paramString = new i(-3, "uninited livePlayer");
      AppMethodBeat.o(145907);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("play")) {
      this.cFu.startPlay(this.cEW, this.cFx);
    }
    for (;;)
    {
      paramString = new i();
      AppMethodBeat.o(145907);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.cFu.stopPlay(true);
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        this.cFu.pause();
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.cFu.resume();
      }
      else
      {
        if (paramString.equalsIgnoreCase("mute"))
        {
          if (!this.mMuteAudio) {}
          for (bool1 = true;; bool1 = false)
          {
            this.mMuteAudio = bool1;
            this.cFu.muteAudio(this.mMuteAudio);
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
        a(bool1, this.cFw);
      }
    }
    paramString = new i(-4, "invalid operate command");
    AppMethodBeat.o(145907);
    return paramString;
  }
  
  final int n(Bundle paramBundle)
  {
    AppMethodBeat.i(145912);
    this.mMode = paramBundle.getInt("mode", this.mMode);
    if (this.mMode == 1)
    {
      if (this.cEW == null)
      {
        AppMethodBeat.o(145912);
        return 0;
      }
      if ((this.cEW != null) && ((this.cEW.startsWith("http://")) || (this.cEW.startsWith("https://"))) && (this.cEW.contains(".flv")))
      {
        AppMethodBeat.o(145912);
        return 1;
      }
      AppMethodBeat.o(145912);
      return 0;
    }
    AppMethodBeat.o(145912);
    return 5;
  }
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(145911);
    if ((this.cFF) && (this.mAudioVolumeListener != null)) {
      this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(145911);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(145910);
    if (this.cFv != null) {
      this.cFv.onNetStatus(paramBundle);
    }
    Log.i("TXLivePlayerJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(145910);
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(145909);
    if ((paramInt == 2006) || (paramInt == -2301)) {
      k("stop", null);
    }
    Object localObject;
    if (paramInt == 2012)
    {
      if (!this.cFG) {
        break label163;
      }
      if (paramBundle != null)
      {
        localObject = paramBundle.getByteArray("EVT_GET_MSG");
        if ((localObject == null) || (localObject.length <= 0)) {
          break label157;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = new String((byte[])localObject, "UTF-8");
        paramBundle.putString("EVT_MSG", (String)localObject);
        if ((this.cFE) && (this.cFv != null)) {
          this.cFv.onPlayEvent(paramInt, paramBundle);
        }
        paramBundle = paramBundle.getString("EVT_MSG");
        Log.i("TXLivePlayerJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
        AppMethodBeat.o(145909);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
      label157:
      String str = "";
    }
    label163:
    Log.i("TXLivePlayerJSAdapter", "onPushEvent: ignore sei message");
    AppMethodBeat.o(145909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.l
 * JD-Core Version:    0.7.0.1
 */