package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
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
  boolean crS;
  boolean crT;
  TXLivePlayer.ITXSnapshotListener csA;
  int csB;
  private String csC;
  private String csD;
  private String csE;
  private float csF;
  private float csG;
  private boolean csH;
  boolean csI;
  private boolean csJ;
  private boolean csK;
  private boolean csL;
  String csd;
  boolean csg;
  private WXLivePlayConfig csx;
  WXLivePlayer csy;
  ITXLivePlayListener csz;
  boolean kPo;
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
    this.csd = "";
    this.csB = 0;
    this.mInited = false;
    this.kPo = false;
    this.csg = false;
    this.mMode = 1;
    this.mMuteAudio = false;
    this.mMuteVideo = false;
    this.csC = "vertical";
    this.csD = "contain";
    this.csE = "speaker";
    this.csF = 1.0F;
    this.csG = 3.0F;
    this.csH = true;
    this.csI = false;
    this.csJ = false;
    this.csK = false;
    this.csL = false;
    this.crS = true;
    this.crT = true;
    this.mContext = paramContext;
    this.csx = new WXLivePlayConfig();
    this.csy = new WXLivePlayer(this.mContext);
    this.csy.enableHardwareDecode(true);
    this.csy.setConfig(this.csx);
    this.csy.setPlayListener(this);
    this.csy.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(145906);
  }
  
  private void a(final boolean paramBoolean, final TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(145908);
    if (this.csy != null) {
      this.csy.snapshot(new TXLivePlayer.ITXSnapshotListener()
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
    ad.i("TXLivePlayerJSAdapter", paramString);
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
        this.csy.muteAudio(bool);
      }
      this.mMuteAudio = bool;
      bool = paramBundle.getBoolean("muteVideo", this.mMuteVideo);
      if ((paramBoolean) || (bool != this.mMuteVideo)) {
        this.csy.muteVideo(bool);
      }
      this.mMuteVideo = bool;
      localObject = paramBundle.getString("orientation", this.csC);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.csC)))
      {
        if (!((String)localObject).equalsIgnoreCase("horizontal")) {
          break label540;
        }
        this.csy.setRenderRotation(270);
      }
      label156:
      this.csC = ((String)localObject);
      localObject = paramBundle.getString("objectFit", this.csD);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.csD)))
      {
        if (!((String)localObject).equalsIgnoreCase("fillCrop")) {
          break label561;
        }
        this.csy.setRenderMode(0);
      }
      label209:
      this.csD = ((String)localObject);
      if (paramBundle.keySet().contains("soundMode"))
      {
        localObject = paramBundle.getString("soundMode", this.csE);
        if (!((String)localObject).equalsIgnoreCase(this.csE))
        {
          if (!((String)localObject).equalsIgnoreCase("speaker")) {
            break label582;
          }
          this.csy.setAudioRoute(0);
        }
      }
    }
    for (;;)
    {
      this.csE = ((String)localObject);
      this.csF = paramBundle.getFloat("minCache", this.csF);
      this.csG = paramBundle.getFloat("maxCache", this.csG);
      this.csx.setAutoAdjustCacheTime(true);
      this.csx.setCacheTime(this.csF);
      this.csx.setMinAutoAdjustCacheTime(this.csF);
      this.csx.setMaxAutoAdjustCacheTime(this.csG);
      this.csK = paramBundle.getBoolean("enableRecvMessage", this.csK);
      this.csx.setEnableMessage(this.csK);
      this.csy.setConfig(this.csx);
      this.csI = paramBundle.getBoolean("needEvent", this.csI);
      this.crS = paramBundle.getBoolean("autoPauseIfNavigate", this.crS);
      this.crT = paramBundle.getBoolean("autoPauseIfOpenNative", this.crT);
      paramBoolean = paramBundle.getBoolean("needAudioVolume", this.csJ);
      if (paramBoolean != this.csJ)
      {
        localObject = this.csy;
        if (paramBoolean) {
          i = 300;
        }
        ((WXLivePlayer)localObject).enableAudioVolumeEvaluation(i);
      }
      this.csJ = paramBoolean;
      paramBoolean = paramBundle.getBoolean("debug", this.csL);
      if (paramBoolean != this.csL) {
        this.csy.showDebugLog(paramBoolean);
      }
      this.csL = paramBoolean;
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
      this.csy.setRenderRotation(0);
      break label156;
      label561:
      if (!((String)localObject).equalsIgnoreCase("contain")) {
        break label209;
      }
      this.csy.setRenderMode(1);
      break label209;
      label582:
      if (((String)localObject).equalsIgnoreCase("ear")) {
        this.csy.setAudioRoute(1);
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
    ad.i("TXLivePlayerJSAdapter", "operateLivePlayer: type = " + paramString + " params = " + str);
    if (!this.mInited)
    {
      paramString = new i(-3, "uninited livePlayer");
      AppMethodBeat.o(145907);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("play")) {
      this.csy.startPlay(this.csd, this.csB);
    }
    for (;;)
    {
      paramString = new i();
      AppMethodBeat.o(145907);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.csy.stopPlay(true);
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        this.csy.pause();
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.csy.resume();
      }
      else
      {
        if (paramString.equalsIgnoreCase("mute"))
        {
          if (!this.mMuteAudio) {}
          for (bool1 = true;; bool1 = false)
          {
            this.mMuteAudio = bool1;
            this.csy.muteAudio(this.mMuteAudio);
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
        a(bool1, this.csA);
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
      if (this.csd == null)
      {
        AppMethodBeat.o(145912);
        return 0;
      }
      if ((this.csd != null) && ((this.csd.startsWith("http://")) || (this.csd.startsWith("https://"))) && (this.csd.contains(".flv")))
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
    if ((this.csJ) && (this.mAudioVolumeListener != null)) {
      this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(145911);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(145910);
    if (this.csz != null) {
      this.csz.onNetStatus(paramBundle);
    }
    ad.i("TXLivePlayerJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
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
      if (!this.csK) {
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
        if ((this.csI) && (this.csz != null)) {
          this.csz.onPlayEvent(paramInt, paramBundle);
        }
        paramBundle = paramBundle.getString("EVT_MSG");
        ad.i("TXLivePlayerJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
        AppMethodBeat.o(145909);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
      label157:
      String str = "";
    }
    label163:
    ad.i("TXLivePlayerJSAdapter", "onPushEvent: ignore sei message");
    AppMethodBeat.o(145909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.l
 * JD-Core Version:    0.7.0.1
 */