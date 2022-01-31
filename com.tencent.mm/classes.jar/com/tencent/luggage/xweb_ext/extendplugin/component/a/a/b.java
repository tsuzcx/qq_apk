package com.tencent.luggage.xweb_ext.extendplugin.component.a.a;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.component.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.Iterator;
import java.util.Set;

public final class b
  implements ITXLivePlayListener
{
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
  private boolean bGw;
  private boolean bGx;
  boolean mAutoPlay;
  private Context mContext;
  boolean mInited;
  private int mMode;
  private boolean mMute;
  Surface mSurface;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(139771);
    this.bGn = "";
    this.bGo = 0;
    this.mInited = false;
    this.bGp = false;
    this.mAutoPlay = false;
    this.mMode = 1;
    this.mMute = false;
    this.bGq = "vertical";
    this.bGr = "fillCrop";
    this.bGs = "speaker";
    this.bGt = 1.0F;
    this.bGu = 3.0F;
    this.bGv = true;
    this.bGw = false;
    this.bGx = false;
    this.mContext = paramContext;
    this.bGj = new TXLivePlayConfig();
    this.bGk = new TXLivePlayer(this.mContext);
    this.bGk.setConfig(this.bGj);
    this.bGk.setPlayListener(this);
    AppMethodBeat.o(139771);
  }
  
  private void a(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(139774);
    if ((this.bGk != null) && (this.bGk.isPlaying())) {
      this.bGk.snapshot(new b.1(this, paramITXSnapshotListener));
    }
    AppMethodBeat.o(139774);
  }
  
  static void k(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(139780);
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
    AppMethodBeat.o(139780);
  }
  
  public final a bE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139772);
    this.bGk.setSurfaceSize(paramInt1, paramInt2);
    a locala = new a();
    AppMethodBeat.o(139772);
    return locala;
  }
  
  public final a cl(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(139773);
    if (paramString == null)
    {
      paramString = new a(-1, "invalid params");
      AppMethodBeat.o(139773);
      return paramString;
    }
    ab.i("TXLivePlayerJSAdapter", "operateLivePlayer: ".concat(String.valueOf(paramString)));
    if (!this.mInited)
    {
      paramString = new a(-3, "uninited livePlayer");
      AppMethodBeat.o(139773);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("play"))
    {
      cm(this.bGn);
      this.bGk.startPlay(this.bGn, this.bGo);
    }
    for (;;)
    {
      paramString = new a();
      AppMethodBeat.o(139773);
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
    paramString = new a(-4, "invalid operate command");
    AppMethodBeat.o(139773);
    return paramString;
  }
  
  final void cm(String paramString)
  {
    AppMethodBeat.i(139778);
    if (paramString != null)
    {
      if (!paramString.startsWith("room")) {}
      for (boolean bool = true;; bool = false)
      {
        this.bGk.enableHardwareDecode(bool);
        ab.i("TXLivePlayerJSAdapter", "checkHardWareDecoder: hardwareDecode = " + bool + ", playUrl = " + paramString);
        AppMethodBeat.o(139778);
        return;
      }
    }
    ab.i("TXLivePlayerJSAdapter", "checkHardWareDecoder: invalid playUrl");
    AppMethodBeat.o(139778);
  }
  
  final int l(Bundle paramBundle)
  {
    AppMethodBeat.i(139777);
    this.mMode = paramBundle.getInt("mode", this.mMode);
    if (this.mMode == 1)
    {
      if (this.bGn == null)
      {
        AppMethodBeat.o(139777);
        return 0;
      }
      if ((this.bGn != null) && ((this.bGn.startsWith("http://")) || (this.bGn.startsWith("https://"))) && (this.bGn.contains(".flv")))
      {
        AppMethodBeat.o(139777);
        return 1;
      }
      AppMethodBeat.o(139777);
      return 0;
    }
    AppMethodBeat.o(139777);
    return 5;
  }
  
  final void m(Bundle paramBundle)
  {
    AppMethodBeat.i(139779);
    this.mMute = paramBundle.getBoolean("muted", this.mMute);
    this.bGk.setMute(this.mMute);
    this.bGq = paramBundle.getString("orientation", this.bGq);
    if (this.bGq.equalsIgnoreCase("horizontal"))
    {
      this.bGk.setRenderRotation(270);
      this.bGr = paramBundle.getString("objectFit", this.bGr);
      if (!this.bGr.equalsIgnoreCase("fillCrop")) {
        break label306;
      }
      this.bGk.setRenderMode(0);
      label102:
      if (paramBundle.keySet().contains("soundMode"))
      {
        this.bGs = paramBundle.getString("soundMode", this.bGs);
        if (!this.bGs.equalsIgnoreCase("speaker")) {
          break label330;
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
      this.bGx = paramBundle.getBoolean("debug", this.bGx);
      if (this.bGi != null) {
        this.bGi.showLog(this.bGx);
      }
      AppMethodBeat.o(139779);
      return;
      if (!this.bGq.equalsIgnoreCase("vertical")) {
        break;
      }
      this.bGk.setRenderRotation(0);
      break;
      label306:
      if (!this.bGr.equalsIgnoreCase("contain")) {
        break label102;
      }
      this.bGk.setRenderMode(1);
      break label102;
      label330:
      if (this.bGs.equalsIgnoreCase("ear")) {
        this.bGk.setAudioRoute(1);
      }
    }
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(139776);
    if (this.bGl != null) {
      this.bGl.onNetStatus(paramBundle);
    }
    ab.i("TXLivePlayerJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(139776);
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(139775);
    if ((paramInt == 2006) || (paramInt == -2301)) {
      cl("stop");
    }
    if (this.bGl != null) {
      this.bGl.onPlayEvent(paramInt, paramBundle);
    }
    paramBundle = paramBundle.getString("EVT_MSG");
    ab.i("TXLivePlayerJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
    AppMethodBeat.o(139775);
  }
  
  public final a xu()
  {
    AppMethodBeat.i(154393);
    if (!this.mInited)
    {
      locala = new a(-3, "uninited livePlayer");
      AppMethodBeat.o(154393);
      return locala;
    }
    this.bGk.stopPlay(true);
    this.bGk.setPlayListener(null);
    this.mInited = false;
    a locala = new a();
    AppMethodBeat.o(154393);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.a.b
 * JD-Core Version:    0.7.0.1
 */