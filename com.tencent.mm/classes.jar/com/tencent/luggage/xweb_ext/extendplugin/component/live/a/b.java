package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.u.d;
import com.tencent.mm.sdk.platformtools.Log;
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
  String cEW;
  boolean cEZ;
  private String cFA;
  private float cFB;
  private float cFC;
  private boolean cFD;
  private boolean cFE;
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
  TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
  private Context mContext;
  Handler mHandler;
  boolean mInited;
  private int mMode;
  boolean mMuteAudio;
  private boolean mMuteVideo;
  private Surface mSurface;
  TXCloudVideoView mVideoView;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(138839);
    this.cEW = "";
    this.cFx = 0;
    this.mInited = false;
    this.cEZ = false;
    this.mMode = 1;
    this.mMuteAudio = false;
    this.mMuteVideo = false;
    this.cFy = "vertical";
    this.cFz = "fillCrop";
    this.cFA = "speaker";
    this.cFB = 1.0F;
    this.cFC = 3.0F;
    this.cFD = true;
    this.cFE = false;
    this.cFF = false;
    this.cFG = false;
    this.cFH = false;
    this.mContext = paramContext;
    this.cFt = new WXLivePlayConfig();
    this.cFu = new WXLivePlayer(this.mContext);
    this.cFu.enableHardwareDecode(true);
    this.cFu.setConfig(this.cFt);
    this.cFu.setPlayListener(this);
    this.cFu.setAudioVolumeEvaluationListener(this);
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
    Log.i("TXLivePlayerJSAdapter", paramString);
    AppMethodBeat.o(138849);
  }
  
  public final a PX()
  {
    AppMethodBeat.i(138842);
    if (this.cFu.isPlaying())
    {
      locala = e("pause", null);
      AppMethodBeat.o(138842);
      return locala;
    }
    a locala = new a();
    AppMethodBeat.o(138842);
    return locala;
  }
  
  public final a PY()
  {
    AppMethodBeat.i(177136);
    a locala = e("resume", null);
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
          break label562;
        }
        this.cFu.setRenderRotation(270);
      }
      label151:
      this.cFy = ((String)localObject);
      localObject = paramBundle.getString("objectFit", this.cFz);
      if ((paramBoolean) || (!((String)localObject).equalsIgnoreCase(this.cFz)))
      {
        if (!((String)localObject).equalsIgnoreCase("fillCrop")) {
          break label583;
        }
        this.cFu.setRenderMode(0);
      }
      label203:
      this.cFz = ((String)localObject);
      if (paramBundle.keySet().contains("soundMode"))
      {
        localObject = paramBundle.getString("soundMode", this.cFA);
        if (!((String)localObject).equalsIgnoreCase(this.cFA))
        {
          if (!((String)localObject).equalsIgnoreCase("speaker")) {
            break label605;
          }
          this.cFu.setAudioRoute(0);
        }
        label265:
        this.cFA = ((String)localObject);
      }
      localObject = null;
      if (paramBundle.keySet().contains("referrer"))
      {
        localObject = paramBundle.getString("referrer");
        Log.i("TXLivePlayerJSAdapter", "parseAndApplyParams, referrer: ".concat(String.valueOf(localObject)));
      }
      this.cFB = paramBundle.getFloat("minCache", this.cFB);
      this.cFC = paramBundle.getFloat("maxCache", this.cFC);
      this.cFt.setAutoAdjustCacheTime(true);
      this.cFt.setCacheTime(this.cFB);
      this.cFt.setMinAutoAdjustCacheTime(this.cFB);
      this.cFt.setMaxAutoAdjustCacheTime(this.cFC);
      localObject = d.aaG((String)localObject);
      if (localObject != null) {
        this.cFt.setHeaders((Map)localObject);
      }
      this.cFG = paramBundle.getBoolean("enableRecvMessage", this.cFG);
      this.cFt.setEnableMessage(this.cFG);
      this.cFu.setConfig(this.cFt);
      this.cFE = paramBundle.getBoolean("needEvent", this.cFE);
      paramBoolean = paramBundle.getBoolean("needAudioVolume", this.cFF);
      if (paramBoolean != this.cFF)
      {
        localObject = this.cFu;
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
      this.cFF = paramBoolean;
      paramBoolean = paramBundle.getBoolean("debug", this.cFH);
      if (paramBoolean != this.cFH) {
        this.cFu.showDebugLog(paramBoolean);
      }
      this.cFH = paramBoolean;
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
      this.cFu.setRenderRotation(0);
      break label151;
      if (!((String)localObject).equalsIgnoreCase("contain")) {
        break label203;
      }
      this.cFu.setRenderMode(1);
      break label203;
      if (!((String)localObject).equalsIgnoreCase("ear")) {
        break label265;
      }
      this.cFu.setAudioRoute(1);
      break label265;
    }
  }
  
  public final void a(final boolean paramBoolean, final TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(138843);
    if ((this.cFu != null) && (this.cFu.isPlaying())) {
      this.cFu.snapshot(new TXLivePlayer.ITXSnapshotListener()
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
  
  public final a bV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138840);
    this.cFu.setSurfaceSize(paramInt1, paramInt2);
    a locala = new a();
    AppMethodBeat.o(138840);
    return locala;
  }
  
  public final a e(String paramString, JSONObject paramJSONObject)
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
    Log.i("TXLivePlayerJSAdapter", "operateLivePlayer: type = " + paramString + " params = " + str);
    if (!this.mInited)
    {
      paramString = new a(-3, "uninited livePlayer");
      AppMethodBeat.o(138841);
      return paramString;
    }
    if (paramString.equalsIgnoreCase("play")) {
      this.cFu.startPlay(this.cEW, this.cFx);
    }
    for (;;)
    {
      paramString = new a();
      AppMethodBeat.o(138841);
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
    paramString = new a(-4, "invalid operate command");
    AppMethodBeat.o(138841);
    return paramString;
  }
  
  public final a f(Surface paramSurface)
  {
    AppMethodBeat.i(177135);
    this.mSurface = paramSurface;
    this.cFu.setSurface(paramSurface);
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
      if (this.cEW == null)
      {
        AppMethodBeat.o(138847);
        return 0;
      }
      if ((this.cEW != null) && ((this.cEW.startsWith("http://")) || (this.cEW.startsWith("https://"))) && (this.cEW.contains(".flv")))
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
    if ((this.cFF) && (this.mAudioVolumeListener != null)) {
      this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(138846);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(138845);
    if (this.cFv != null) {
      this.cFv.onNetStatus(paramBundle);
    }
    Log.i("TXLivePlayerJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
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
          b.this.e("stop", null);
          AppMethodBeat.o(178812);
        }
      };
      if (this.mHandler != null) {
        this.mHandler.post((Runnable)localObject);
      }
    }
    if (paramInt == 2012)
    {
      if (!this.cFG) {
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
        if (this.cFv != null) {
          this.cFv.onPlayEvent(paramInt, paramBundle);
        }
        paramBundle = paramBundle.getString("EVT_MSG");
        Log.i("TXLivePlayerJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
        AppMethodBeat.o(138844);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
      label166:
      String str = "";
    }
    label172:
    Log.i("TXLivePlayerJSAdapter", "onPushEvent: ignore sei message");
    AppMethodBeat.o(138844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b
 * JD-Core Version:    0.7.0.1
 */