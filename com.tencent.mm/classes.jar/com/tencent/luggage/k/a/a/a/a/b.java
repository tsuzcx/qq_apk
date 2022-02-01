package com.tencent.luggage.k.a.a.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.luggage.k.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.d;
import com.tencent.mm.sdk.platformtools.ac;
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
  private boolean cit;
  private boolean ciu;
  private boolean civ;
  private boolean ciw;
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
    this.chO = "";
    this.cim = 0;
    this.mInited = false;
    this.chR = false;
    this.mMode = 1;
    this.mMuteAudio = false;
    this.mMuteVideo = false;
    this.cin = "vertical";
    this.cio = "fillCrop";
    this.cip = "speaker";
    this.ciq = 1.0F;
    this.cir = 3.0F;
    this.cis = true;
    this.cit = false;
    this.ciu = false;
    this.civ = false;
    this.ciw = false;
    this.mContext = paramContext;
    this.cii = new WXLivePlayConfig();
    this.cij = new WXLivePlayer(this.mContext);
    this.cij.enableHardwareDecode(true);
    this.cij.setConfig(this.cii);
    this.cij.setPlayListener(this);
    this.cij.setAudioVolumeEvaluationListener(this);
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
    ac.i("TXLivePlayerJSAdapter", paramString);
    AppMethodBeat.o(138849);
  }
  
  public final a EN()
  {
    AppMethodBeat.i(138842);
    if (this.cij.isPlaying())
    {
      locala = b("pause", null);
      AppMethodBeat.o(138842);
      return locala;
    }
    a locala = new a();
    AppMethodBeat.o(138842);
    return locala;
  }
  
  public final a EO()
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
          break label562;
        }
        this.cij.setRenderRotation(270);
      }
      label151:
      this.cin = ((String)localObject);
      localObject = paramBundle.getString("objectFit", this.cio);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.cio)))
      {
        if (!((String)localObject).equalsIgnoreCase("fillCrop")) {
          break label583;
        }
        this.cij.setRenderMode(0);
      }
      label203:
      this.cio = ((String)localObject);
      if (paramBundle.keySet().contains("soundMode"))
      {
        localObject = paramBundle.getString("soundMode", this.cip);
        if (!((String)localObject).equalsIgnoreCase(this.cip))
        {
          if (!((String)localObject).equalsIgnoreCase("speaker")) {
            break label605;
          }
          this.cij.setAudioRoute(0);
        }
        label265:
        this.cip = ((String)localObject);
      }
      localObject = null;
      if (paramBundle.keySet().contains("referrer"))
      {
        localObject = paramBundle.getString("referrer");
        ac.i("TXLivePlayerJSAdapter", "parseAndApplyParams, referrer: ".concat(String.valueOf(localObject)));
      }
      this.ciq = paramBundle.getFloat("minCache", this.ciq);
      this.cir = paramBundle.getFloat("maxCache", this.cir);
      this.cii.setAutoAdjustCacheTime(true);
      this.cii.setCacheTime(this.ciq);
      this.cii.setMinAutoAdjustCacheTime(this.ciq);
      this.cii.setMaxAutoAdjustCacheTime(this.cir);
      localObject = d.MY((String)localObject);
      if (localObject != null) {
        this.cii.setHeaders((Map)localObject);
      }
      this.civ = paramBundle.getBoolean("enableRecvMessage", this.civ);
      this.cii.setEnableMessage(this.civ);
      this.cij.setConfig(this.cii);
      this.cit = paramBundle.getBoolean("needEvent", this.cit);
      paramBoolean = paramBundle.getBoolean("needAudioVolume", this.ciu);
      if (paramBoolean != this.ciu)
      {
        localObject = this.cij;
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
      this.ciu = paramBoolean;
      paramBoolean = paramBundle.getBoolean("debug", this.ciw);
      if (paramBoolean != this.ciw) {
        this.cij.showDebugLog(paramBoolean);
      }
      this.ciw = paramBoolean;
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
      this.cij.setRenderRotation(0);
      break label151;
      if (!((String)localObject).equalsIgnoreCase("contain")) {
        break label203;
      }
      this.cij.setRenderMode(1);
      break label203;
      if (!((String)localObject).equalsIgnoreCase("ear")) {
        break label265;
      }
      this.cij.setAudioRoute(1);
      break label265;
    }
  }
  
  public final void a(final boolean paramBoolean, final TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(138843);
    if ((this.cij != null) && (this.cij.isPlaying())) {
      this.cij.snapshot(new TXLivePlayer.ITXSnapshotListener()
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
                b.p(paramAnonymousBitmap);
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
    ac.i("TXLivePlayerJSAdapter", "operateLivePlayer: type = " + paramString + " params = " + str);
    if (!this.mInited)
    {
      paramString = new a(-3, "uninited livePlayer");
      AppMethodBeat.o(138841);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("play")) {
      this.cij.startPlay(this.chO, this.cim);
    }
    for (;;)
    {
      paramString = new a();
      AppMethodBeat.o(138841);
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
    paramString = new a(-4, "invalid operate command");
    AppMethodBeat.o(138841);
    return paramString;
  }
  
  public final a bT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138840);
    this.cij.setSurfaceSize(paramInt1, paramInt2);
    a locala = new a();
    AppMethodBeat.o(138840);
    return locala;
  }
  
  public final a f(Surface paramSurface)
  {
    AppMethodBeat.i(177135);
    this.mSurface = paramSurface;
    this.cij.setSurface(paramSurface);
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
      if (this.chO == null)
      {
        AppMethodBeat.o(138847);
        return 0;
      }
      if ((this.chO != null) && ((this.chO.startsWith("http://")) || (this.chO.startsWith("https://"))) && (this.chO.contains(".flv")))
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
    if ((this.ciu) && (this.mAudioVolumeListener != null)) {
      this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(138846);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(138845);
    if (this.cik != null) {
      this.cik.onNetStatus(paramBundle);
    }
    ac.i("TXLivePlayerJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
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
      if (!this.civ) {
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
        if (this.cik != null) {
          this.cik.onPlayEvent(paramInt, paramBundle);
        }
        paramBundle = paramBundle.getString("EVT_MSG");
        ac.i("TXLivePlayerJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
        AppMethodBeat.o(138844);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
      label166:
      String str = "";
    }
    label172:
    ac.i("TXLivePlayerJSAdapter", "onPushEvent: ignore sei message");
    AppMethodBeat.o(138844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */