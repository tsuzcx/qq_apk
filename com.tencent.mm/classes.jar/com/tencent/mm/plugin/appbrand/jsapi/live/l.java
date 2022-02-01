package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
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
  boolean chA;
  boolean chB;
  String chO;
  boolean chR;
  private WXLivePlayConfig cii;
  WXLivePlayer cij;
  ITXLivePlayListener cik;
  TXLivePlayer.ITXSnapshotListener cil;
  int cim;
  private String cin;
  private String cio;
  private String cip;
  private float ciq;
  private float cir;
  private boolean cis;
  boolean cit;
  private boolean ciu;
  private boolean civ;
  private boolean ciw;
  boolean ktS;
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
    this.chO = "";
    this.cim = 0;
    this.mInited = false;
    this.ktS = false;
    this.chR = false;
    this.mMode = 1;
    this.mMuteAudio = false;
    this.mMuteVideo = false;
    this.cin = "vertical";
    this.cio = "contain";
    this.cip = "speaker";
    this.ciq = 1.0F;
    this.cir = 3.0F;
    this.cis = true;
    this.cit = false;
    this.ciu = false;
    this.civ = false;
    this.ciw = false;
    this.chA = true;
    this.chB = true;
    this.mContext = paramContext;
    this.cii = new WXLivePlayConfig();
    this.cij = new WXLivePlayer(this.mContext);
    this.cij.enableHardwareDecode(true);
    this.cij.setConfig(this.cii);
    this.cij.setPlayListener(this);
    this.cij.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(145906);
  }
  
  private void a(final boolean paramBoolean, final TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(145908);
    if (this.cij != null) {
      this.cij.snapshot(new TXLivePlayer.ITXSnapshotListener()
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
                l.P(paramAnonymousBitmap);
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
    ac.i("TXLivePlayerJSAdapter", paramString);
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
        this.cij.muteAudio(bool);
      }
      this.mMuteAudio = bool;
      bool = paramBundle.getBoolean("muteVideo", this.mMuteVideo);
      if ((paramBoolean) || (bool != this.mMuteVideo)) {
        this.cij.muteVideo(bool);
      }
      this.mMuteVideo = bool;
      localObject = paramBundle.getString("orientation", this.cin);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.cin)))
      {
        if (!((String)localObject).equalsIgnoreCase("horizontal")) {
          break label540;
        }
        this.cij.setRenderRotation(270);
      }
      label156:
      this.cin = ((String)localObject);
      localObject = paramBundle.getString("objectFit", this.cio);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.cio)))
      {
        if (!((String)localObject).equalsIgnoreCase("fillCrop")) {
          break label561;
        }
        this.cij.setRenderMode(0);
      }
      label209:
      this.cio = ((String)localObject);
      if (paramBundle.keySet().contains("soundMode"))
      {
        localObject = paramBundle.getString("soundMode", this.cip);
        if (!((String)localObject).equalsIgnoreCase(this.cip))
        {
          if (!((String)localObject).equalsIgnoreCase("speaker")) {
            break label582;
          }
          this.cij.setAudioRoute(0);
        }
      }
    }
    for (;;)
    {
      this.cip = ((String)localObject);
      this.ciq = paramBundle.getFloat("minCache", this.ciq);
      this.cir = paramBundle.getFloat("maxCache", this.cir);
      this.cii.setAutoAdjustCacheTime(true);
      this.cii.setCacheTime(this.ciq);
      this.cii.setMinAutoAdjustCacheTime(this.ciq);
      this.cii.setMaxAutoAdjustCacheTime(this.cir);
      this.civ = paramBundle.getBoolean("enableRecvMessage", this.civ);
      this.cii.setEnableMessage(this.civ);
      this.cij.setConfig(this.cii);
      this.cit = paramBundle.getBoolean("needEvent", this.cit);
      this.chA = paramBundle.getBoolean("autoPauseIfNavigate", this.chA);
      this.chB = paramBundle.getBoolean("autoPauseIfOpenNative", this.chB);
      paramBoolean = paramBundle.getBoolean("needAudioVolume", this.ciu);
      if (paramBoolean != this.ciu)
      {
        localObject = this.cij;
        if (paramBoolean) {
          i = 300;
        }
        ((WXLivePlayer)localObject).enableAudioVolumeEvaluation(i);
      }
      this.ciu = paramBoolean;
      paramBoolean = paramBundle.getBoolean("debug", this.ciw);
      if (paramBoolean != this.ciw) {
        this.cij.showDebugLog(paramBoolean);
      }
      this.ciw = paramBoolean;
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
      this.cij.setRenderRotation(0);
      break label156;
      label561:
      if (!((String)localObject).equalsIgnoreCase("contain")) {
        break label209;
      }
      this.cij.setRenderMode(1);
      break label209;
      label582:
      if (((String)localObject).equalsIgnoreCase("ear")) {
        this.cij.setAudioRoute(1);
      }
    }
  }
  
  public final i h(String paramString, JSONObject paramJSONObject)
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
    ac.i("TXLivePlayerJSAdapter", "operateLivePlayer: type = " + paramString + " params = " + str);
    if (!this.mInited)
    {
      paramString = new i(-3, "uninited livePlayer");
      AppMethodBeat.o(145907);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("play")) {
      this.cij.startPlay(this.chO, this.cim);
    }
    for (;;)
    {
      paramString = new i();
      AppMethodBeat.o(145907);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.cij.stopPlay(true);
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        this.cij.pause();
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.cij.resume();
      }
      else
      {
        if (paramString.equalsIgnoreCase("mute"))
        {
          if (!this.mMuteAudio) {}
          for (bool1 = true;; bool1 = false)
          {
            this.mMuteAudio = bool1;
            this.cij.muteAudio(this.mMuteAudio);
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
        a(bool1, this.cil);
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
      if (this.chO == null)
      {
        AppMethodBeat.o(145912);
        return 0;
      }
      if ((this.chO != null) && ((this.chO.startsWith("http://")) || (this.chO.startsWith("https://"))) && (this.chO.contains(".flv")))
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
    if ((this.ciu) && (this.mAudioVolumeListener != null)) {
      this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(145911);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(145910);
    if (this.cik != null) {
      this.cik.onNetStatus(paramBundle);
    }
    ac.i("TXLivePlayerJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(145910);
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(145909);
    if ((paramInt == 2006) || (paramInt == -2301)) {
      h("stop", null);
    }
    Object localObject;
    if (paramInt == 2012)
    {
      if (!this.civ) {
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
        if ((this.cit) && (this.cik != null)) {
          this.cik.onPlayEvent(paramInt, paramBundle);
        }
        paramBundle = paramBundle.getString("EVT_MSG");
        ac.i("TXLivePlayerJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
        AppMethodBeat.o(145909);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
      label157:
      String str = "";
    }
    label163:
    ac.i("TXLivePlayerJSAdapter", "onPushEvent: ignore sei message");
    AppMethodBeat.o(145909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.l
 * JD-Core Version:    0.7.0.1
 */