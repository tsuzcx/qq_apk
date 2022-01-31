package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class m
  implements ITXLivePushListener, TXLivePusher.OnBGMNotify
{
  private String gow = "front";
  private String gsC = "vertical";
  private boolean gsI = false;
  private TXLivePushConfig gsJ;
  TXLivePusher gsK;
  ITXLivePushListener gsL;
  String gsM;
  private boolean gsN = false;
  private boolean gsO = false;
  TXLivePusher.ITXSnapshotListener gsP;
  TXLivePusher.OnBGMNotify gsQ;
  private boolean gsR = false;
  private boolean gsS = false;
  boolean gsT = false;
  private int gsU = 2;
  private int gsV = -1;
  private int gsW = -1;
  private int gsX = 0;
  boolean gsY = true;
  private String gsZ = "high";
  private boolean gsa = false;
  TXCloudVideoView gsv;
  private int gta = 5;
  private int gtb = 3;
  private String gtc = "";
  private boolean gtd = false;
  private boolean gte = false;
  private boolean gtf = false;
  private float gtg = 0.0F;
  private float gth = 0.0F;
  private String gti = "";
  private Context mContext;
  private boolean mEnableZoom = true;
  private boolean mFrontCamera = true;
  boolean mInited = false;
  private int mMode = 1;
  private boolean mMute = false;
  private float mWatermarkWidth = 0.1F;
  
  public m(Context paramContext)
  {
    this.mContext = paramContext;
    this.gsJ = new TXLivePushConfig();
    this.gsK = new TXLivePusher(paramContext);
    this.gsK.setConfig(this.gsJ);
    this.gsK.setPushListener(this);
    this.gsK.setBGMNofify(this);
  }
  
  static void h(String paramString, Bundle paramBundle)
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str.equalsIgnoreCase("pushUrl")) || (str.equalsIgnoreCase("orientation")) || (str.equalsIgnoreCase("backgroundImage")) || (str.equalsIgnoreCase("audioQuality")) || (str.equalsIgnoreCase("watermarkImage")) || (str.equalsIgnoreCase("devicePosition"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getString(str);
      } else if ((str.equalsIgnoreCase("mode")) || (str.equalsIgnoreCase("focusMode")) || (str.equalsIgnoreCase("beauty")) || (str.equalsIgnoreCase("whiteness")) || (str.equalsIgnoreCase("aspect")) || (str.equalsIgnoreCase("minBitrate")) || (str.equalsIgnoreCase("maxBitrate"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getInt(str);
      } else if ((str.equalsIgnoreCase("hide")) || (str.equalsIgnoreCase("autopush")) || (str.equalsIgnoreCase("muted")) || (str.equalsIgnoreCase("enableCamera")) || (str.equalsIgnoreCase("backgroundMute")) || (str.equalsIgnoreCase("zoom")) || (str.equalsIgnoreCase("needEvent")) || (str.equalsIgnoreCase("needBGMEvent")) || (str.equalsIgnoreCase("debug"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getBoolean(str);
      } else if ((str.equalsIgnoreCase("watermarkLeft")) || (str.equalsIgnoreCase("watermarkTop")) || (str.equalsIgnoreCase("watermarkWidth"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getFloat(str);
      }
    }
    y.i("TXLivePusherJSAdapter.javayhu", paramString);
  }
  
  public final j aje()
  {
    if (this.gsN)
    {
      if (this.gsO) {
        return c("start", null);
      }
      return c("resume", null);
    }
    return new j();
  }
  
  public final j c(String paramString, JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int i = 0;
    if (paramString == null) {
      return new j(-1, "invalid params");
    }
    if (!this.mInited) {
      return new j(-3, "uninited livePusher");
    }
    y.i("TXLivePusherJSAdapter.javayhu", "operateLivePusher: " + paramString);
    if (paramString.equalsIgnoreCase("start")) {
      if ((this.gsM != null) && (!this.gsM.isEmpty()) && (!this.gsK.isPushing()))
      {
        this.gsv.setVisibility(0);
        if (this.gsY) {
          this.gsK.startCameraPreview(this.gsv);
        }
        this.gsK.startPusher(this.gsM);
      }
    }
    for (;;)
    {
      return new j();
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.gte = false;
        this.gsK.stopBGM();
        this.gsK.stopCameraPreview(true);
        this.gsK.stopPusher();
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        if ((this.gte) && (this.gsK.isPushing())) {
          this.gsK.turnOnFlashLight(false);
        }
        this.gsK.pausePusher();
        this.gsS = this.gsR;
        if (this.gsS) {
          c("pauseBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.gsK.resumePusher();
        if (this.gsS) {
          c("resumeBGM", null);
        }
      }
      else
      {
        if (paramString.equalsIgnoreCase("switchCamera"))
        {
          if (!this.mFrontCamera) {}
          for (;;)
          {
            this.mFrontCamera = bool1;
            this.gsJ.setFrontCamera(this.mFrontCamera);
            this.gsK.switchCamera();
            break;
            bool1 = false;
          }
        }
        if (paramString.equalsIgnoreCase("snapshot"))
        {
          paramString = this.gsP;
          if ((this.gsK != null) && (this.gsK.isPushing())) {
            this.gsK.snapshot(new m.1(this, paramString));
          }
        }
        else
        {
          if (paramString.equalsIgnoreCase("toggleTorch"))
          {
            if (this.gsK.isPushing())
            {
              if (!this.gte)
              {
                bool1 = bool2;
                bool2 = this.gsK.turnOnFlashLight(bool1);
                if (!bool2) {
                  break label483;
                }
                label446:
                this.gte = bool1;
                if (!bool2) {
                  break label492;
                }
                label457:
                if (!bool2) {
                  break label499;
                }
              }
              label483:
              label492:
              label499:
              for (paramString = "Success";; paramString = "Failed")
              {
                return new j(i, paramString);
                bool1 = false;
                break;
                bool1 = this.gte;
                break label446;
                i = -2;
                break label457;
              }
            }
            return new j(-2, "fail");
          }
          if (paramString.equalsIgnoreCase("playBGM"))
          {
            paramString = "";
            if (paramJSONObject != null) {
              paramString = paramJSONObject.optString("BGMFilePath", "");
            }
            y.i("TXLivePusherJSAdapter.javayhu", "playBGM filePath = " + paramString);
            if ((paramString != null) && (paramString.length() > 0)) {
              this.gsK.playBGM(paramString);
            } else {
              return new j(-2, "fail");
            }
          }
          else if (paramString.equalsIgnoreCase("stopBGM"))
          {
            this.gsK.stopBGM();
            this.gsR = false;
          }
          else if (paramString.equalsIgnoreCase("pauseBGM"))
          {
            this.gsK.pauseBGM();
            this.gsR = false;
          }
          else
          {
            if (!paramString.equalsIgnoreCase("resumeBGM")) {
              break;
            }
            this.gsK.resumeBGM();
            this.gsR = true;
          }
        }
      }
    }
    if (paramString.equalsIgnoreCase("setBGMVolume")) {
      if (paramJSONObject == null) {
        break label732;
      }
    }
    label732:
    for (double d = paramJSONObject.optDouble("volume", 1.0D);; d = 1.0D)
    {
      this.gsK.setBGMVolume((float)d);
      break;
      return new j(-4, "invalid operate command");
    }
  }
  
  final void c(Bundle paramBundle, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0)) {
      return;
    }
    int i1 = paramBundle.getInt("mode", this.mMode);
    if ((paramBoolean) || (i1 != this.mMode)) {}
    int k;
    int m;
    int j;
    int n;
    int i;
    switch (i1)
    {
    default: 
      k = this.gsV;
      m = this.gsW;
      j = paramBundle.getInt("minBitrate", -1);
      n = paramBundle.getInt("maxBitrate", -1);
      if ((j != -1) && (n != -1))
      {
        i = j;
        if (j < 200) {
          i = 200;
        }
        j = n;
        if (n > 1800) {
          j = 1800;
        }
        if (i <= j) {
          k = i;
        }
      }
      break;
    }
    label1288:
    for (;;)
    {
      n = paramBundle.getInt("aspect", this.gsU);
      String str1 = paramBundle.getString("audioQuality", this.gsZ);
      label217:
      int i2;
      label275:
      Object localObject1;
      label301:
      boolean bool2;
      if (i1 == 6)
      {
        if (n == 1)
        {
          this.gsJ.setVideoResolution(13);
          if ((k != -1) && (j != -1) && (k <= j))
          {
            this.gsJ.setMinVideoBitrate(k);
            this.gsJ.setMaxVideoBitrate(j);
          }
          if (!str1.equalsIgnoreCase("low")) {
            break label1218;
          }
          this.gsJ.setAudioSampleRate(16000);
        }
      }
      else
      {
        i2 = paramBundle.getInt("focusMode", this.gsX);
        localObject1 = this.gsJ;
        if (i2 == 0) {
          break label1241;
        }
        bool1 = true;
        ((TXLivePushConfig)localObject1).setTouchFocus(bool1);
        bool2 = paramBundle.getBoolean("enableCamera", this.gsY);
        localObject1 = this.gsJ;
        if (bool2) {
          break label1247;
        }
        bool1 = true;
        label334:
        ((TXLivePushConfig)localObject1).enablePureAudioPush(bool1);
        if (i1 == 6) {
          break label1381;
        }
      }
      label431:
      label1218:
      label1241:
      label1247:
      label1381:
      for (boolean bool1 = true;; bool1 = bool2)
      {
        this.gow = paramBundle.getString("devicePosition", this.gow);
        bool2 = true;
        if (this.gow.equalsIgnoreCase("back")) {
          bool2 = false;
        }
        this.gsJ.setFrontCamera(bool2);
        localObject1 = paramBundle.getString("orientation", this.gsC);
        i = 0;
        int i3;
        int i4;
        String str2;
        Object localObject2;
        boolean bool3;
        boolean bool4;
        float f1;
        float f2;
        float f3;
        Bitmap localBitmap;
        if (((String)localObject1).equalsIgnoreCase("horizontal"))
        {
          this.gsJ.setHomeOrientation(0);
          i = 90;
          i3 = paramBundle.getInt("beauty", this.gta);
          i4 = paramBundle.getInt("whiteness", this.gtb);
          this.gsJ.setBeautyFilter(i3, i4, 5);
          str2 = paramBundle.getString("backgroundImage", this.gtc);
          localObject2 = BitmapFactory.decodeFile(str2);
          if (localObject2 != null) {
            this.gsJ.setPauseImg((Bitmap)localObject2);
          }
          bool3 = paramBundle.getBoolean("backgroundMute", this.gtd);
          if (!bool3) {
            break label1277;
          }
          this.gsJ.setPauseFlag(3);
          bool4 = paramBundle.getBoolean("zoom", this.mEnableZoom);
          this.gsJ.setEnableZoom(bool4);
          f1 = paramBundle.getFloat("watermarkLeft", this.gtg);
          f2 = paramBundle.getFloat("watermarkTop", this.gth);
          f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
          localObject2 = paramBundle.getString("watermarkImage", this.gti);
          localBitmap = BitmapFactory.decodeFile((String)localObject2);
          if (localBitmap == null) {
            break label1288;
          }
          this.gsJ.setWatermark(localBitmap, f1, f2, f3);
          label622:
          m = 0;
          if ((n != this.gsU) || (k != this.gsV) || (j != this.gsW) || (i2 != this.gsX) || (bool2 != this.mFrontCamera) || (bool1 != this.gsY) || (i3 != this.gta) || (i4 != this.gtb) || (bool3 != this.gtd) || (bool4 != this.mEnableZoom) || (f1 != this.gtg) || (f2 != this.gth) || (f3 != this.mWatermarkWidth) || (!str2.equalsIgnoreCase(this.gtc)) || (!((String)localObject1).equalsIgnoreCase(this.gsC)) || (!str1.equalsIgnoreCase(this.gsZ)) || (!((String)localObject2).equalsIgnoreCase(this.gti))) {
            m = 1;
          }
          if ((paramBoolean) || (m != 0))
          {
            this.gsK.setConfig(this.gsJ);
            this.gsK.setRenderRotation(i);
            this.gsK.setBeautyFilter(0, i3, i4, 2);
          }
          if (this.gsK.isPushing())
          {
            if (bool1 == this.gsY) {
              break label1340;
            }
            if (!bool1) {
              break label1329;
            }
            this.gsK.stopCameraPreview(true);
            this.gsK.startCameraPreview(this.gsv);
          }
        }
        for (;;)
        {
          this.mMode = i1;
          this.gsU = n;
          this.gsX = i2;
          this.gsY = bool1;
          this.mFrontCamera = bool2;
          this.gsC = ((String)localObject1);
          this.gta = i3;
          this.gtb = i4;
          this.gtd = bool3;
          this.gtc = str2;
          this.gsV = k;
          this.gsW = j;
          this.gsZ = str1;
          this.mEnableZoom = bool4;
          this.gtg = f1;
          this.gth = f2;
          this.mWatermarkWidth = f3;
          this.gti = ((String)localObject2);
          this.gsa = paramBundle.getBoolean("needEvent", this.gsa);
          this.gtf = paramBundle.getBoolean("needBGMEvent", this.gtf);
          bool1 = paramBundle.getBoolean("muted", this.mMute);
          if ((paramBoolean) || (bool1 != this.mMute)) {
            this.gsK.setMute(bool1);
          }
          this.mMute = bool1;
          bool1 = paramBundle.getBoolean("debug", this.gsI);
          if ((paramBoolean) || (bool1 != this.gsI)) {
            this.gsv.showLog(bool1);
          }
          this.gsI = bool1;
          return;
          this.gsK.setVideoQuality(1, false, false);
          this.gsJ.setVideoEncodeGop(5);
          break;
          this.gsK.setVideoQuality(2, true, false);
          this.gsJ.setVideoEncodeGop(5);
          break;
          this.gsK.setVideoQuality(3, true, false);
          this.gsJ.setVideoEncodeGop(5);
          break;
          this.gsK.setVideoQuality(4, true, false);
          break;
          this.gsK.setVideoQuality(5, true, false);
          break;
          this.gsK.setVideoQuality(6, false, false);
          break;
          if (n != 2) {
            break label217;
          }
          this.gsJ.setVideoResolution(0);
          break label217;
          if (!str1.equalsIgnoreCase("high")) {
            break label275;
          }
          this.gsJ.setAudioSampleRate(48000);
          break label275;
          bool1 = false;
          break label301;
          bool1 = false;
          break label334;
          if (!((String)localObject1).equalsIgnoreCase("vertical")) {
            break label431;
          }
          this.gsJ.setHomeOrientation(1);
          i = 0;
          break label431;
          label1277:
          this.gsJ.setPauseFlag(1);
          break label525;
          if ((!this.gsK.isPushing()) || (!paramBundle.keySet().contains("watermarkImage"))) {
            break label622;
          }
          this.gsJ.setWatermark(localBitmap, f1, f2, f3);
          break label622;
          this.gsK.stopCameraPreview(true);
          continue;
          if ((this.gsY) && (!((String)localObject1).equalsIgnoreCase(this.gsC)))
          {
            this.gsK.stopCameraPreview(true);
            this.gsK.startCameraPreview(this.gsv);
          }
        }
      }
      label525:
      label1329:
      label1340:
      j = m;
    }
  }
  
  public final j de(boolean paramBoolean)
  {
    this.gsN = this.gsK.isPushing();
    if (this.gsN)
    {
      if (paramBoolean)
      {
        this.gsO = paramBoolean;
        if ((this.gsa) && (this.gsL != null)) {
          this.gsL.onPushEvent(5000, new Bundle());
        }
        return c("stop", null);
      }
      return c("pause", null);
    }
    return new j();
  }
  
  public final void onBGMComplete(int paramInt)
  {
    this.gsR = false;
    if ((this.gtf) && (this.gsQ != null)) {
      this.gsQ.onBGMComplete(paramInt);
    }
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    if ((this.gtf) && (this.gsQ != null)) {
      this.gsQ.onBGMProgress(paramLong1, paramLong2);
    }
  }
  
  public final void onBGMStart()
  {
    this.gsR = true;
    if ((this.gtf) && (this.gsQ != null)) {
      this.gsQ.onBGMStart();
    }
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    if (this.gsL != null) {
      this.gsL.onNetStatus(paramBundle);
    }
    paramBundle = String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("CODEC_CACHE") + " | " + paramBundle.getInt("CACHE_SIZE") + "," + paramBundle.getInt("VIDEO_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_PLAY_SPEED")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("CODEC_DROP_CNT") + "|" + paramBundle.getInt("DROP_SIZE"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") });
    y.i("TXLivePusherJSAdapter.javayhu", "onNetStatus:" + paramBundle);
  }
  
  public final void onPushEvent(int paramInt, Bundle paramBundle)
  {
    if (paramInt == -1307) {
      c("stop", null);
    }
    for (;;)
    {
      if ((this.gsa) && (this.gsL != null)) {
        this.gsL.onPushEvent(paramInt, paramBundle);
      }
      paramBundle = paramBundle.getString("EVT_MSG");
      y.i("TXLivePusherJSAdapter.javayhu", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
      return;
      if ((paramInt == 1003) && (this.gte)) {
        this.gsK.turnOnFlashLight(this.gte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.m
 * JD-Core Version:    0.7.0.1
 */