package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.Iterator;
import java.util.Set;

public final class k
  implements ITXLivePlayListener
{
  boolean bGe;
  boolean bGf;
  TXCloudVideoView bGi;
  private TXLivePlayConfig bGj;
  TXLivePlayer bGk;
  ITXLivePlayListener bGl;
  TXLivePlayer.ITXSnapshotListener bGm;
  String bGn;
  int bGo;
  boolean bGp;
  private String bGq;
  private String bGr;
  private String bGs;
  private float bGt;
  private float bGu;
  private boolean bGv;
  boolean bGw;
  private boolean bGx;
  boolean mAutoPlay;
  private Context mContext;
  boolean mInited;
  private int mMode;
  private boolean mMute;
  
  public k(Context paramContext)
  {
    AppMethodBeat.i(96131);
    this.bGn = "";
    this.bGo = 0;
    this.mInited = false;
    this.bGp = false;
    this.mAutoPlay = false;
    this.mMode = 1;
    this.mMute = false;
    this.bGq = "vertical";
    this.bGr = "contain";
    this.bGs = "speaker";
    this.bGt = 1.0F;
    this.bGu = 3.0F;
    this.bGv = true;
    this.bGw = false;
    this.bGx = false;
    this.bGe = true;
    this.bGf = true;
    this.mContext = paramContext;
    this.bGj = new TXLivePlayConfig();
    this.bGk = new TXLivePlayer(this.mContext);
    this.bGk.setConfig(this.bGj);
    this.bGk.setPlayListener(this);
    AppMethodBeat.o(96131);
  }
  
  private void a(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(96133);
    if (this.bGk != null) {
      this.bGk.snapshot(new k.1(this, paramITXSnapshotListener));
    }
    AppMethodBeat.o(96133);
  }
  
  static void k(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(96139);
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
    ab.i("TXLivePlayerJSAdapter", paramString);
    AppMethodBeat.o(96139);
  }
  
  public final i Ce(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(96132);
    if (paramString == null)
    {
      paramString = new i(-1, "invalid params");
      AppMethodBeat.o(96132);
      return paramString;
    }
    ab.i("TXLivePlayerJSAdapter", "operateLivePlayer: ".concat(String.valueOf(paramString)));
    if (!this.mInited)
    {
      paramString = new i(-3, "uninited livePlayer");
      AppMethodBeat.o(96132);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("play"))
    {
      cm(this.bGn);
      this.bGk.startPlay(this.bGn, this.bGo);
    }
    for (;;)
    {
      paramString = new i();
      AppMethodBeat.o(96132);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.bGk.stopPlay(true);
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        this.bGk.pause();
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.bGk.resume();
      }
      else
      {
        if (paramString.equalsIgnoreCase("mute"))
        {
          if (!this.mMute) {}
          for (;;)
          {
            this.mMute = bool;
            this.bGk.setMute(this.mMute);
            break;
            bool = false;
          }
        }
        if (!paramString.equalsIgnoreCase("snapshot")) {
          break;
        }
        a(this.bGm);
      }
    }
    paramString = new i(-4, "invalid operate command");
    AppMethodBeat.o(96132);
    return paramString;
  }
  
  final void cm(String paramString)
  {
    AppMethodBeat.i(96137);
    if (paramString != null)
    {
      if (!paramString.startsWith("room")) {}
      for (boolean bool = true;; bool = false)
      {
        this.bGk.enableHardwareDecode(bool);
        ab.i("TXLivePlayerJSAdapter", "checkHardWareDecoder: hardwareDecode = " + bool + ", playUrl = " + paramString);
        AppMethodBeat.o(96137);
        return;
      }
    }
    ab.i("TXLivePlayerJSAdapter", "checkHardWareDecoder: invalid playUrl");
    AppMethodBeat.o(96137);
  }
  
  final int l(Bundle paramBundle)
  {
    AppMethodBeat.i(96136);
    this.mMode = paramBundle.getInt("mode", this.mMode);
    if (this.mMode == 1)
    {
      if (this.bGn == null)
      {
        AppMethodBeat.o(96136);
        return 0;
      }
      if ((this.bGn != null) && ((this.bGn.startsWith("http://")) || (this.bGn.startsWith("https://"))) && (this.bGn.contains(".flv")))
      {
        AppMethodBeat.o(96136);
        return 1;
      }
      AppMethodBeat.o(96136);
      return 0;
    }
    AppMethodBeat.o(96136);
    return 5;
  }
  
  final void m(Bundle paramBundle)
  {
    AppMethodBeat.i(96138);
    this.mMute = paramBundle.getBoolean("muted", this.mMute);
    this.bGk.setMute(this.mMute);
    this.bGq = paramBundle.getString("orientation", this.bGq);
    if (this.bGq.equalsIgnoreCase("horizontal"))
    {
      this.bGk.setRenderRotation(270);
      this.bGr = paramBundle.getString("objectFit", this.bGr);
      if (!this.bGr.equalsIgnoreCase("fillCrop")) {
        break label330;
      }
      this.bGk.setRenderMode(0);
      label103:
      if (paramBundle.keySet().contains("soundMode"))
      {
        this.bGs = paramBundle.getString("soundMode", this.bGs);
        if (!this.bGs.equalsIgnoreCase("speaker")) {
          break label353;
        }
        this.bGk.setAudioRoute(0);
      }
    }
    for (;;)
    {
      this.bGt = paramBundle.getFloat("minCache", this.bGt);
      this.bGu = paramBundle.getFloat("maxCache", this.bGu);
      this.bGj.setAutoAdjustCacheTime(true);
      this.bGj.setCacheTime(this.bGt);
      this.bGj.setMinAutoAdjustCacheTime(this.bGt);
      this.bGj.setMaxAutoAdjustCacheTime(this.bGu);
      this.bGk.setConfig(this.bGj);
      this.bGw = paramBundle.getBoolean("needEvent", this.bGw);
      this.bGe = paramBundle.getBoolean("autoPauseIfNavigate", this.bGe);
      this.bGf = paramBundle.getBoolean("autoPauseIfOpenNative", this.bGf);
      this.bGx = paramBundle.getBoolean("debug", this.bGx);
      this.bGi.showLog(this.bGx);
      AppMethodBeat.o(96138);
      return;
      if (!this.bGq.equalsIgnoreCase("vertical")) {
        break;
      }
      this.bGk.setRenderRotation(0);
      break;
      label330:
      if (!this.bGr.equalsIgnoreCase("contain")) {
        break label103;
      }
      this.bGk.setRenderMode(1);
      break label103;
      label353:
      if (this.bGs.equalsIgnoreCase("ear")) {
        this.bGk.setAudioRoute(1);
      }
    }
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(96135);
    if (this.bGl != null) {
      this.bGl.onNetStatus(paramBundle);
    }
    ab.i("TXLivePlayerJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(96135);
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(96134);
    if ((paramInt == 2006) || (paramInt == -2301)) {
      Ce("stop");
    }
    if ((this.bGw) && (this.bGl != null)) {
      this.bGl.onPlayEvent(paramInt, paramBundle);
    }
    paramBundle = paramBundle.getString("EVT_MSG");
    ab.i("TXLivePlayerJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
    AppMethodBeat.o(96134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.k
 * JD-Core Version:    0.7.0.1
 */