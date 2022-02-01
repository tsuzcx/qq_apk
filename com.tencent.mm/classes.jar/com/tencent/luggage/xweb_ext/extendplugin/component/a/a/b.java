package com.tencent.luggage.xweb_ext.extendplugin.component.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.component.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.rtmp.ITXLivePlayListener;
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

public final class b
  implements ITXLivePlayListener, TXLivePlayer.ITXAudioVolumeEvaluationListener
{
  String csG;
  boolean csJ;
  private WXLivePlayConfig cta;
  WXLivePlayer ctb;
  ITXLivePlayListener ctc;
  TXLivePlayer.ITXSnapshotListener ctd;
  int cte;
  private String ctf;
  private String ctg;
  private String cth;
  private float cti;
  private float ctj;
  private boolean ctk;
  private boolean ctl;
  private boolean ctm;
  private boolean ctn;
  private boolean cto;
  TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
  private Context mContext;
  Handler mHandler;
  boolean mInited;
  private int mMode;
  private boolean mMuteAudio;
  private boolean mMuteVideo;
  private Surface mSurface;
  TXCloudVideoView mVideoView;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(138839);
    this.csG = "";
    this.cte = 0;
    this.mInited = false;
    this.csJ = false;
    this.mMode = 1;
    this.mMuteAudio = false;
    this.mMuteVideo = false;
    this.ctf = "vertical";
    this.ctg = "fillCrop";
    this.cth = "speaker";
    this.cti = 1.0F;
    this.ctj = 3.0F;
    this.ctk = true;
    this.ctl = false;
    this.ctm = false;
    this.ctn = false;
    this.cto = false;
    this.mContext = paramContext;
    this.cta = new WXLivePlayConfig();
    this.ctb = new WXLivePlayer(this.mContext);
    this.ctb.enableHardwareDecode(true);
    this.ctb.setConfig(this.cta);
    this.ctb.setPlayListener(this);
    this.ctb.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(138839);
  }
  
  static void l(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(138849);
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
    ae.i("TXLivePlayerJSAdapter", paramString);
    AppMethodBeat.o(138849);
  }
  
  public final a Go()
  {
    AppMethodBeat.i(138842);
    if (this.ctb.isPlaying())
    {
      locala = b("pause", null);
      AppMethodBeat.o(138842);
      return locala;
    }
    a locala = new a();
    AppMethodBeat.o(138842);
    return locala;
  }
  
  public final a Gp()
  {
    AppMethodBeat.i(177136);
    a locala = b("resume", null);
    AppMethodBeat.o(177136);
    return locala;
  }
  
  final void a(Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(138848);
    boolean bool = this.mMuteAudio;
    Object localObject;
    if (paramBundle.keySet().contains("muteAudio"))
    {
      bool = paramBundle.getBoolean("muteAudio");
      if ((paramBoolean) || (bool != this.mMuteAudio)) {
        this.ctb.muteAudio(bool);
      }
      this.mMuteAudio = bool;
      bool = paramBundle.getBoolean("muteVideo", this.mMuteVideo);
      if ((paramBoolean) || (bool != this.mMuteVideo)) {
        this.ctb.muteVideo(bool);
      }
      this.mMuteVideo = bool;
      localObject = paramBundle.getString("orientation", this.ctf);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.ctf)))
      {
        if (!((String)localObject).equalsIgnoreCase("horizontal")) {
          break label562;
        }
        this.ctb.setRenderRotation(270);
      }
      label151:
      this.ctf = ((String)localObject);
      localObject = paramBundle.getString("objectFit", this.ctg);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.ctg)))
      {
        if (!((String)localObject).equalsIgnoreCase("fillCrop")) {
          break label583;
        }
        this.ctb.setRenderMode(0);
      }
      label203:
      this.ctg = ((String)localObject);
      if (paramBundle.keySet().contains("soundMode"))
      {
        localObject = paramBundle.getString("soundMode", this.cth);
        if (!((String)localObject).equalsIgnoreCase(this.cth))
        {
          if (!((String)localObject).equalsIgnoreCase("speaker")) {
            break label605;
          }
          this.ctb.setAudioRoute(0);
        }
        label265:
        this.cth = ((String)localObject);
      }
      localObject = null;
      if (paramBundle.keySet().contains("referrer"))
      {
        localObject = paramBundle.getString("referrer");
        ae.i("TXLivePlayerJSAdapter", "parseAndApplyParams, referrer: ".concat(String.valueOf(localObject)));
      }
      this.cti = paramBundle.getFloat("minCache", this.cti);
      this.ctj = paramBundle.getFloat("maxCache", this.ctj);
      this.cta.setAutoAdjustCacheTime(true);
      this.cta.setCacheTime(this.cti);
      this.cta.setMinAutoAdjustCacheTime(this.cti);
      this.cta.setMaxAutoAdjustCacheTime(this.ctj);
      localObject = d.Re((String)localObject);
      if (localObject != null) {
        this.cta.setHeaders((Map)localObject);
      }
      this.ctn = paramBundle.getBoolean("enableRecvMessage", this.ctn);
      this.cta.setEnableMessage(this.ctn);
      this.ctb.setConfig(this.cta);
      this.ctl = paramBundle.getBoolean("needEvent", this.ctl);
      paramBoolean = paramBundle.getBoolean("needAudioVolume", this.ctm);
      if (paramBoolean != this.ctm)
      {
        localObject = this.ctb;
        if (!paramBoolean) {
          break label627;
        }
      }
    }
    label562:
    label583:
    label605:
    label627:
    for (int i = 300;; i = 0)
    {
      ((WXLivePlayer)localObject).enableAudioVolumeEvaluation(i);
      this.ctm = paramBoolean;
      paramBoolean = paramBundle.getBoolean("debug", this.cto);
      if (paramBoolean != this.cto) {
        this.ctb.showDebugLog(paramBoolean);
      }
      this.cto = paramBoolean;
      AppMethodBeat.o(138848);
      return;
      if (!paramBundle.keySet().contains("muted")) {
        break;
      }
      bool = paramBundle.getBoolean("muted");
      break;
      if (!((String)localObject).equalsIgnoreCase("vertical")) {
        break label151;
      }
      this.ctb.setRenderRotation(0);
      break label151;
      if (!((String)localObject).equalsIgnoreCase("contain")) {
        break label203;
      }
      this.ctb.setRenderMode(1);
      break label203;
      if (!((String)localObject).equalsIgnoreCase("ear")) {
        break label265;
      }
      this.ctb.setAudioRoute(1);
      break label265;
    }
  }
  
  public final void a(final boolean paramBoolean, final TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(138843);
    if ((this.ctb != null) && (this.ctb.isPlaying())) {
      this.ctb.snapshot(new TXLivePlayer.ITXSnapshotListener()
      {
        public final void onSnapshot(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(138838);
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
                b.q(paramAnonymousBitmap);
                AppMethodBeat.o(138838);
                return;
              }
              paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
              AppMethodBeat.o(138838);
              return;
            }
            paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
          }
          AppMethodBeat.o(138838);
        }
      });
    }
    AppMethodBeat.o(138843);
  }
  
  public final a b(String paramString, JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    AppMethodBeat.i(138841);
    if (paramString == null)
    {
      paramString = new a(-1, "invalid params");
      AppMethodBeat.o(138841);
      return paramString;
    }
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    }
    ae.i("TXLivePlayerJSAdapter", "operateLivePlayer: type = " + paramString + " params = " + str);
    if (!this.mInited)
    {
      paramString = new a(-3, "uninited livePlayer");
      AppMethodBeat.o(138841);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("play")) {
      this.ctb.startPlay(this.csG, this.cte);
    }
    for (;;)
    {
      paramString = new a();
      AppMethodBeat.o(138841);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.ctb.stopPlay(true);
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        this.ctb.pause();
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.ctb.resume();
      }
      else
      {
        if (paramString.equalsIgnoreCase("mute"))
        {
          if (!this.mMuteAudio) {}
          for (bool1 = true;; bool1 = false)
          {
            this.mMuteAudio = bool1;
            this.ctb.muteAudio(this.mMuteAudio);
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
        a(bool1, this.ctd);
      }
    }
    paramString = new a(-4, "invalid operate command");
    AppMethodBeat.o(138841);
    return paramString;
  }
  
  public final a bV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138840);
    this.ctb.setSurfaceSize(paramInt1, paramInt2);
    a locala = new a();
    AppMethodBeat.o(138840);
    return locala;
  }
  
  public final a f(Surface paramSurface)
  {
    AppMethodBeat.i(177135);
    this.mSurface = paramSurface;
    this.ctb.setSurface(paramSurface);
    paramSurface = new a();
    AppMethodBeat.o(177135);
    return paramSurface;
  }
  
  final int n(Bundle paramBundle)
  {
    AppMethodBeat.i(138847);
    this.mMode = paramBundle.getInt("mode", this.mMode);
    if (this.mMode == 1)
    {
      if (this.csG == null)
      {
        AppMethodBeat.o(138847);
        return 0;
      }
      if ((this.csG != null) && ((this.csG.startsWith("http://")) || (this.csG.startsWith("https://"))) && (this.csG.contains(".flv")))
      {
        AppMethodBeat.o(138847);
        return 1;
      }
      AppMethodBeat.o(138847);
      return 0;
    }
    AppMethodBeat.o(138847);
    return 5;
  }
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(138846);
    if ((this.ctm) && (this.mAudioVolumeListener != null)) {
      this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(138846);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(138845);
    if (this.ctc != null) {
      this.ctc.onNetStatus(paramBundle);
    }
    ae.i("TXLivePlayerJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(138845);
  }
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(138844);
    Object localObject;
    if ((paramInt == 2006) || (paramInt == -2301))
    {
      localObject = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178812);
          b.this.b("stop", null);
          AppMethodBeat.o(178812);
        }
      };
      if (this.mHandler != null) {
        this.mHandler.post((Runnable)localObject);
      }
    }
    if (paramInt == 2012)
    {
      if (!this.ctn) {
        break label172;
      }
      if (paramBundle != null)
      {
        localObject = paramBundle.getByteArray("EVT_GET_MSG");
        if ((localObject == null) || (localObject.length <= 0)) {
          break label166;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = new String((byte[])localObject, "UTF-8");
        paramBundle.putString("EVT_MSG", (String)localObject);
        if (this.ctc != null) {
          this.ctc.onPlayEvent(paramInt, paramBundle);
        }
        paramBundle = paramBundle.getString("EVT_MSG");
        ae.i("TXLivePlayerJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
        AppMethodBeat.o(138844);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
      label166:
      String str = "";
    }
    label172:
    ae.i("TXLivePlayerJSAdapter", "onPushEvent: ignore sei message");
    AppMethodBeat.o(138844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.a.b
 * JD-Core Version:    0.7.0.1
 */