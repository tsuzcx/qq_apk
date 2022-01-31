package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.Iterator;
import java.util.Set;

public final class l
  implements ITXLivePlayListener
{
  int gsA = 0;
  boolean gsB = false;
  private String gsC = "vertical";
  private String gsD = "fillCrop";
  private String gsE = "speaker";
  private float gsF = 1.0F;
  private float gsG = 3.0F;
  boolean gsH = true;
  private boolean gsI = false;
  boolean gsa = false;
  TXCloudVideoView gsv;
  private TXLivePlayConfig gsw;
  TXLivePlayer gsx;
  ITXLivePlayListener gsy;
  String gsz = "";
  boolean mAutoPlay = false;
  private Context mContext;
  boolean mInited = false;
  private int mMode = 1;
  private boolean mMute = false;
  
  public l(Context paramContext)
  {
    this.mContext = paramContext;
    this.gsw = new TXLivePlayConfig();
    this.gsx = new TXLivePlayer(this.mContext);
    this.gsx.setConfig(this.gsw);
    this.gsx.setPlayListener(this);
    this.gsx.enableHardwareDecode(true);
  }
  
  static void h(String paramString, Bundle paramBundle)
  {
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
      } else if ((str.equalsIgnoreCase("hide")) || (str.equalsIgnoreCase("autoplay")) || (str.equalsIgnoreCase("muted")) || (str.equalsIgnoreCase("backgroundMute")) || (str.equalsIgnoreCase("needEvent")) || (str.equalsIgnoreCase("debug"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getBoolean(str);
      }
    }
    y.i("TXLivePlayerJSAdapter", paramString);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    if (this.gsy != null) {
      this.gsy.onNetStatus(paramBundle);
    }
    paramBundle = String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("CODEC_CACHE") + " | " + paramBundle.getInt("CACHE_SIZE") + "," + paramBundle.getInt("VIDEO_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_PLAY_SPEED")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("CODEC_DROP_CNT") + "|" + paramBundle.getInt("DROP_SIZE"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") });
    y.i("TXLivePlayerJSAdapter", "onNetStatus:" + paramBundle);
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 2006) || (paramInt == -2301)) {
      ue("stop");
    }
    if ((this.gsa) && (this.gsy != null)) {
      this.gsy.onPlayEvent(paramInt, paramBundle);
    }
    paramBundle = paramBundle.getString("EVT_MSG");
    y.i("TXLivePlayerJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
  }
  
  public final j ue(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return new j(-1, "invalid params");
    }
    y.i("TXLivePlayerJSAdapter", "operateLivePlayer: " + paramString);
    if (!this.mInited) {
      return new j(-3, "uninited livePlayer");
    }
    if (paramString.equalsIgnoreCase("play")) {
      this.gsx.startPlay(this.gsz, this.gsA);
    }
    for (;;)
    {
      return new j();
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.gsx.stopPlay(true);
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        this.gsx.pause();
      }
      else
      {
        if (!paramString.equalsIgnoreCase("resume")) {
          break;
        }
        this.gsx.resume();
      }
    }
    if (paramString.equalsIgnoreCase("mute"))
    {
      if (!this.mMute) {}
      for (;;)
      {
        this.mMute = bool;
        this.gsx.setMute(this.mMute);
        break;
        bool = false;
      }
    }
    return new j(-4, "invalid operate command");
  }
  
  final int v(Bundle paramBundle)
  {
    this.mMode = paramBundle.getInt("mode", this.mMode);
    if (this.mMode == 1)
    {
      if (this.gsz == null) {}
      while ((this.gsz == null) || ((!this.gsz.startsWith("http://")) && (!this.gsz.startsWith("https://"))) || (!this.gsz.contains(".flv"))) {
        return 0;
      }
      return 1;
    }
    return 5;
  }
  
  final void w(Bundle paramBundle)
  {
    this.mMute = paramBundle.getBoolean("muted", this.mMute);
    this.gsx.setMute(this.mMute);
    this.gsC = paramBundle.getString("orientation", this.gsC);
    if (this.gsC.equalsIgnoreCase("horizontal"))
    {
      this.gsx.setRenderRotation(270);
      this.gsD = paramBundle.getString("objectFit", this.gsD);
      if (!this.gsD.equalsIgnoreCase("fillCrop")) {
        break label273;
      }
      this.gsx.setRenderMode(0);
      label96:
      this.gsE = paramBundle.getString("soundMode", this.gsE);
      if (!this.gsE.equalsIgnoreCase("speaker")) {
        break label297;
      }
      this.gsx.setAudioRoute(0);
    }
    for (;;)
    {
      this.gsF = paramBundle.getFloat("minCache", this.gsF);
      this.gsG = paramBundle.getFloat("maxCache", this.gsG);
      this.gsw.setAutoAdjustCacheTime(true);
      this.gsw.setCacheTime(this.gsF);
      this.gsw.setMinAutoAdjustCacheTime(this.gsF);
      this.gsw.setMaxAutoAdjustCacheTime(this.gsG);
      this.gsx.setConfig(this.gsw);
      this.gsa = paramBundle.getBoolean("needEvent", this.gsa);
      this.gsI = paramBundle.getBoolean("debug", this.gsI);
      this.gsv.showLog(this.gsI);
      return;
      if (!this.gsC.equalsIgnoreCase("vertical")) {
        break;
      }
      this.gsx.setRenderRotation(0);
      break;
      label273:
      if (!this.gsD.equalsIgnoreCase("contain")) {
        break label96;
      }
      this.gsx.setRenderMode(1);
      break label96;
      label297:
      if (this.gsE.equalsIgnoreCase("ear")) {
        this.gsx.setAudioRoute(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.l
 * JD-Core Version:    0.7.0.1
 */