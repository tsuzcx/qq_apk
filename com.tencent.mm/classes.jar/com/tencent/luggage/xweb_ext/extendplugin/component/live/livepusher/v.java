package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.WXLivePushConfig;
import com.tencent.rtmp.WXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class v
  implements m, ITXLivePushListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.OnBGMNotify
{
  private String eBs;
  private String eCA;
  private String eCB;
  private boolean eCC;
  private boolean eCD;
  private boolean eCE;
  private boolean eCF;
  private String eCG;
  private float eCH;
  private float eCI;
  private String eCJ;
  private boolean eCK;
  private String eCL;
  private int eCM;
  private boolean eCN;
  private final x eCO;
  private WXLivePushConfig eCh;
  private final WXLivePusher eCi;
  private String eCj;
  private boolean eCk;
  private String eCl;
  private boolean eCm;
  private boolean eCn;
  private boolean eCo;
  private boolean eCp;
  private boolean eCq;
  private int eCr;
  private int eCs;
  private int eCt;
  private int eCu;
  private boolean eCv;
  private boolean eCw;
  private String eCx;
  private int eCy;
  private int eCz;
  private boolean ezB;
  private String ezs;
  private boolean ezy;
  private boolean ezz;
  private TXLivePusher.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
  private TXLivePusher.OnBGMNotify mBGMNotifyListener;
  private Context mContext;
  private boolean mEnableAgc;
  private boolean mEnableAns;
  private boolean mEnableZoom;
  private boolean mFrontCamera;
  private Handler mHandler;
  private boolean mInited;
  private int mLastAngle;
  private ITXLivePushListener mLivePushListener;
  private int mMode;
  private boolean mMute;
  private TXLivePusher.ITXSnapshotListener mSnapshotListener;
  private Surface mSurface;
  private int mVideoHeight;
  private TXCloudVideoView mVideoView;
  private int mVideoWidth;
  private float mWatermarkWidth;
  
  public v(Context paramContext)
  {
    AppMethodBeat.i(220880);
    this.mLastAngle = 0;
    this.mInited = false;
    this.eCk = false;
    this.mFrontCamera = true;
    this.eCl = "front";
    this.eCm = false;
    this.eCn = false;
    this.eCo = false;
    this.eCp = false;
    this.eCq = false;
    this.mMode = 1;
    this.eCr = 2;
    this.eCs = -1;
    this.eCt = -1;
    this.mMute = false;
    this.eCu = 0;
    this.eCv = true;
    this.eCw = true;
    this.ezs = "vertical";
    this.eCx = "high";
    this.eCy = 5;
    this.eCz = 3;
    this.eCA = "smooth";
    this.eBs = "";
    this.eCB = "";
    this.eCC = false;
    this.eCD = false;
    this.mEnableZoom = true;
    this.ezy = false;
    this.eCE = false;
    this.ezB = false;
    this.eCF = false;
    this.eCG = "auto";
    this.eCH = 0.0F;
    this.eCI = 0.0F;
    this.mWatermarkWidth = 0.1F;
    this.eCJ = "";
    this.mEnableAgc = false;
    this.mEnableAns = false;
    this.eCK = false;
    this.eCL = "auto";
    this.eCM = 0;
    this.mVideoWidth = 368;
    this.mVideoHeight = 640;
    this.ezz = false;
    this.eCN = false;
    this.mContext = paramContext;
    this.eCh = new WXLivePushConfig();
    this.eCi = new WXLivePusher(paramContext);
    this.eCi.setConfig(this.eCh);
    this.eCi.setPushListener(this);
    this.eCi.setBGMNofify(this);
    this.eCi.setAudioVolumeEvaluationListener(this);
    this.eCO = new x(this.eCi);
    AppMethodBeat.o(220880);
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(220972);
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0))
    {
      AppMethodBeat.o(220972);
      return;
    }
    int i2 = paramBundle.getInt("mode", this.mMode);
    if ((paramBoolean) || (i2 != this.mMode)) {}
    int m;
    int n;
    int i;
    int j;
    int k;
    switch (i2)
    {
    default: 
      m = this.eCs;
      n = this.eCt;
      i = paramBundle.getInt("minBitrate", -1);
      j = paramBundle.getInt("maxBitrate", -1);
      if (i > j)
      {
        Log.e("TXLivePusherJSAdapter", "parseAndApplyParams -> swap min and max bitrate, may be something error. min = " + i + " max = " + j);
        k = j;
      }
      break;
    }
    for (;;)
    {
      j = n;
      int i1 = m;
      if (k != -1)
      {
        j = n;
        i1 = m;
        if (i != -1)
        {
          j = k;
          if (k < 200) {
            j = 200;
          }
          k = i;
          if (i > 5000) {
            k = 5000;
          }
          i = n;
          if (j <= k)
          {
            i = k;
            m = j;
          }
          j = i;
          i1 = m;
          if (m != -1)
          {
            j = i;
            i1 = m;
            if (i != -1)
            {
              j = i;
              i1 = m;
              if (m <= i)
              {
                this.eCh.setMinVideoBitrate(m);
                this.eCh.setMaxVideoBitrate(i);
                i1 = m;
                j = i;
              }
            }
          }
        }
      }
      k = paramBundle.getInt("aspect", this.eCr);
      m = paramBundle.getInt("videoWidth", this.mVideoWidth);
      n = paramBundle.getInt("videoHeight", this.mVideoHeight);
      Object localObject1 = paramBundle.getString("audioQuality", this.eCx);
      label398:
      label456:
      Object localObject2;
      boolean bool1;
      label483:
      boolean bool2;
      label614:
      String str1;
      label657:
      label734:
      float f1;
      float f2;
      float f3;
      Object localObject4;
      if (i2 == 6)
      {
        if (k == 1)
        {
          this.eCh.setVideoResolution(13);
          if ((m > 0) && (m <= 1920) && (n > 0) && (n <= 1920)) {
            this.eCh.setVideoResolution(m, n);
          }
          if (!((String)localObject1).equalsIgnoreCase("low")) {
            break label2002;
          }
          this.eCh.setAudioSampleRate(16000);
        }
      }
      else
      {
        int i3 = paramBundle.getInt("focusMode", this.eCu);
        localObject2 = this.eCh;
        if (i3 == 0) {
          break label2025;
        }
        bool1 = true;
        ((WXLivePushConfig)localObject2).setTouchFocus(bool1);
        bool2 = this.mFrontCamera;
        bool1 = bool2;
        if (paramBundle.keySet().contains("devicePosition"))
        {
          this.eCl = paramBundle.getString("devicePosition", this.eCl);
          bool1 = bool2;
          if (this.eCl.equalsIgnoreCase("back")) {
            bool1 = false;
          }
          this.eCh.setFrontCamera(bool1);
        }
        localObject2 = paramBundle.getString("orientation", this.ezs);
        if (!((String)localObject2).equalsIgnoreCase(this.ezs))
        {
          if (!((String)localObject2).equalsIgnoreCase("horizontal")) {
            break label2031;
          }
          m(this.mLastAngle, (String)localObject2);
          this.eCi.setRenderRotation(90);
        }
        str1 = paramBundle.getString("localMirror", this.eCG);
        if (!str1.equalsIgnoreCase(this.eCG))
        {
          if (!str1.equalsIgnoreCase("auto")) {
            break label2062;
          }
          this.eCh.setLocalVideoMirrorType(0);
        }
        String str2 = paramBundle.getString("backgroundImage", this.eCB);
        Object localObject3 = BitmapFactory.decodeFile(str2);
        if (localObject3 != null) {
          this.eCh.setPauseImg((Bitmap)localObject3);
        }
        boolean bool3 = paramBundle.getBoolean("backgroundMute", this.eCC);
        this.eCN = paramBundle.getBoolean("isVoip", this.eCN);
        if (!this.eCN) {
          break label2106;
        }
        this.eCh.setPauseFlag(1);
        boolean bool4 = paramBundle.getBoolean("zoom", this.mEnableZoom);
        this.eCh.setEnableZoom(bool4);
        f1 = paramBundle.getFloat("watermarkLeft", this.eCH);
        f2 = paramBundle.getFloat("watermarkTop", this.eCI);
        f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
        localObject3 = paramBundle.getString("watermarkImage", this.eCJ);
        localObject4 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject4 == null) {
          break label2117;
        }
        this.eCh.setWatermark((Bitmap)localObject4, f1, f2, f3);
        label833:
        boolean bool5 = paramBundle.getBoolean("enableAGC", this.mEnableAgc);
        this.eCh.enableAGC(bool5);
        boolean bool6 = paramBundle.getBoolean("enableANS", this.mEnableAns);
        this.eCh.enableANS(bool6);
        boolean bool7 = paramBundle.getBoolean("enableEarMonitor", this.eCK);
        this.eCh.enableAudioEarMonitoring(bool7);
        localObject4 = paramBundle.getString("audioVolumeType", this.eCL);
        if (!((String)localObject4).equalsIgnoreCase("voicecall")) {
          break label2159;
        }
        this.eCh.setVolumeType(2);
        label931:
        boolean bool8 = paramBundle.getBoolean("enableCamera", this.eCv);
        Object localObject5 = this.eCh;
        if (bool8) {
          break label2192;
        }
        bool2 = true;
        label958:
        ((WXLivePushConfig)localObject5).enablePureAudioPush(bool2);
        i = 0;
        if ((k != this.eCr) || (i1 != this.eCs) || (j != this.eCt) || (i3 != this.eCu) || (bool1 != this.mFrontCamera) || (bool3 != this.eCC) || (bool4 != this.mEnableZoom) || (bool5 != this.mEnableAgc) || (bool6 != this.mEnableAns) || (bool7 != this.eCK) || (bool8 != this.eCv) || (m != this.mVideoWidth) || (n != this.mVideoHeight) || (f1 != this.eCH) || (f2 != this.eCI) || (f3 != this.mWatermarkWidth) || (!str1.equalsIgnoreCase(this.eCG)) || (!((String)localObject4).equalsIgnoreCase(this.eCL)) || (!str2.equalsIgnoreCase(this.eCB)) || (!((String)localObject2).equalsIgnoreCase(this.ezs)) || (!((String)localObject1).equalsIgnoreCase(this.eCx)) || (!((String)localObject3).equalsIgnoreCase(this.eCJ))) {
          i = 1;
        }
        if ((paramBoolean) || (i != 0)) {
          this.eCi.setConfig(this.eCh);
        }
        if (bool8 != this.eCv)
        {
          if (!bool8) {
            break label2198;
          }
          auq();
          cU(true);
        }
        label1232:
        if (!paramBundle.keySet().contains("enableMic")) {
          break label2227;
        }
        boolean bool9 = paramBundle.getBoolean("enableMic", this.eCw);
        if (bool9 != this.eCw)
        {
          if (!bool9) {
            break label2205;
          }
          this.eCi.stopAudioRecord();
          cV(true);
        }
        label1286:
        if ((paramBoolean) || (bool9 != this.eCw))
        {
          localObject5 = this.eCi;
          if (bool9) {
            break label2215;
          }
          bool2 = true;
          label1313:
          ((WXLivePusher)localObject5).setMute(bool2);
          if (bool9) {
            break label2221;
          }
          bool2 = true;
          label1328:
          this.mMute = bool2;
        }
        this.eCw = bool9;
        label1340:
        this.mMode = i2;
        this.eCr = k;
        this.eCu = i3;
        this.eCv = bool8;
        this.mEnableAgc = bool5;
        this.mEnableAns = bool6;
        this.eCK = bool7;
        this.eCG = str1;
        this.eCL = ((String)localObject4);
        this.mVideoWidth = m;
        this.mVideoHeight = n;
        this.mFrontCamera = bool1;
        this.ezs = ((String)localObject2);
        this.eCC = bool3;
        this.eCB = str2;
        this.eCs = i1;
        this.eCt = j;
        this.eCx = ((String)localObject1);
        this.mEnableZoom = bool4;
        this.eCH = f1;
        this.eCI = f2;
        this.mWatermarkWidth = f3;
        this.eCJ = ((String)localObject3);
        this.ezy = paramBundle.getBoolean("needEvent", this.ezy);
        this.eCE = paramBundle.getBoolean("needBGMEvent", this.eCE);
        bool1 = this.eCF;
        if (!paramBundle.keySet().contains("remoteMirror")) {
          break label2328;
        }
        bool1 = paramBundle.getBoolean("remoteMirror");
        label1537:
        if (bool1 != this.eCF) {
          this.eCi.setMirror(bool1);
        }
        this.eCF = bool1;
        i = paramBundle.getInt("beauty", this.eCy);
        j = paramBundle.getInt("whiteness", this.eCz);
        localObject1 = paramBundle.getString("beautyStyle", this.eCA);
        if ((paramBoolean) || (i != this.eCy) || (j != this.eCz) || (!((String)localObject1).equalsIgnoreCase(this.eCA)))
        {
          if (!((String)localObject1).equalsIgnoreCase("nature")) {
            break label2355;
          }
          this.eCi.setBeautyFilter(1, i, j, 2);
        }
        label1660:
        this.eCy = i;
        this.eCz = j;
        this.eCA = ((String)localObject1);
        localObject1 = paramBundle.getString("filterImage", this.eBs);
        if (!((String)localObject1).equalsIgnoreCase(this.eBs))
        {
          localObject2 = BitmapFactory.decodeFile((String)localObject1);
          this.eCi.setFilter((Bitmap)localObject2);
        }
        this.eBs = ((String)localObject1);
        i = paramBundle.getInt("audioReverbType", this.eCM);
        if (i != this.eCM) {
          this.eCi.setReverb(i);
        }
        this.eCM = i;
        bool1 = paramBundle.getBoolean("needAudioVolume", this.ezz);
        if (bool1 != this.ezz)
        {
          localObject1 = this.eCi;
          if (!bool1) {
            break label2372;
          }
        }
      }
      label2062:
      label2106:
      label2372:
      for (i = 300;; i = 0)
      {
        ((WXLivePusher)localObject1).enableAudioVolumeEvaluation(i);
        this.ezz = bool1;
        bool1 = paramBundle.getBoolean("debug", this.ezB);
        if ((paramBoolean) || (bool1 != this.ezB)) {
          this.eCi.showDebugLog(bool1);
        }
        this.ezB = bool1;
        AppMethodBeat.o(220972);
        return;
        this.eCi.setVideoQuality(1, true, false);
        this.eCh.setVideoEncodeGop(5);
        break;
        this.eCi.setVideoQuality(2, true, false);
        this.eCh.setVideoEncodeGop(5);
        break;
        this.eCi.setVideoQuality(3, true, false);
        this.eCh.setVideoEncodeGop(5);
        break;
        this.eCi.setVideoQuality(4, true, false);
        break;
        this.eCi.setVideoQuality(5, true, false);
        break;
        this.eCi.setVideoQuality(6, false, false);
        break;
        this.eCi.setVideoQuality(7, true, false);
        this.eCh.setVideoEncodeGop(5);
        break;
        if (k != 2) {
          break label398;
        }
        this.eCh.setVideoResolution(0);
        break label398;
        label2002:
        if (!((String)localObject1).equalsIgnoreCase("high")) {
          break label456;
        }
        this.eCh.setAudioSampleRate(48000);
        break label456;
        label2025:
        bool1 = false;
        break label483;
        label2031:
        if (!((String)localObject2).equalsIgnoreCase("vertical")) {
          break label614;
        }
        m(this.mLastAngle, (String)localObject2);
        this.eCi.setRenderRotation(0);
        break label614;
        if (str1.equalsIgnoreCase("enable"))
        {
          this.eCh.setLocalVideoMirrorType(1);
          break label657;
        }
        if (!str1.equalsIgnoreCase("disable")) {
          break label657;
        }
        this.eCh.setLocalVideoMirrorType(2);
        break label657;
        this.eCh.setPauseFlag(3);
        break label734;
        label2117:
        if ((!this.eCi.isPushing()) || (!paramBundle.keySet().contains("watermarkImage"))) {
          break label833;
        }
        this.eCh.setWatermark((Bitmap)localObject4, f1, f2, f3);
        break label833;
        label2159:
        if (((String)localObject4).equalsIgnoreCase("media"))
        {
          this.eCh.setVolumeType(1);
          break label931;
        }
        this.eCh.setVolumeType(0);
        break label931;
        bool2 = false;
        break label958;
        auq();
        break label1232;
        this.eCi.stopAudioRecord();
        break label1286;
        bool2 = false;
        break label1313;
        bool2 = false;
        break label1328;
        if (!paramBundle.keySet().contains("muted")) {
          break label1340;
        }
        bool2 = paramBundle.getBoolean("muted", this.mMute);
        if (!this.eCw)
        {
          Log.i("TXLivePusherJSAdapter", String.format("parseAndApplyParams, enableMic: %b, mute: %b", new Object[] { Boolean.FALSE, Boolean.valueOf(this.mMute) }));
          bool2 = true;
        }
        if ((paramBoolean) || (bool2 != this.mMute)) {
          this.eCi.setMute(bool2);
        }
        this.mMute = bool2;
        break label1340;
        if (!paramBundle.keySet().contains("mirror")) {
          break label1537;
        }
        bool1 = paramBundle.getBoolean("mirror");
        break label1537;
        this.eCi.setBeautyFilter(0, i, j, 2);
        break label1660;
      }
      label2192:
      label2198:
      label2205:
      label2215:
      label2221:
      label2227:
      label2355:
      k = i;
      label2328:
      i = j;
    }
  }
  
  public static void a(p.b paramb)
  {
    AppMethodBeat.i(220856);
    x.a(paramb);
    AppMethodBeat.o(220856);
  }
  
  private void auq()
  {
    AppMethodBeat.i(220932);
    this.eCi.stopCameraPreview(true);
    this.eCk = false;
    AppMethodBeat.o(220932);
  }
  
  private void cU(boolean paramBoolean)
  {
    AppMethodBeat.i(220920);
    if ((!this.eCk) && (paramBoolean))
    {
      if (this.mVideoView != null) {
        this.mVideoView.setVisibility(0);
      }
      if (this.mSurface != null) {
        this.eCi.setSurface(this.mSurface);
      }
      this.eCi.startCameraPreview(this.mVideoView);
      this.eCk = true;
    }
    AppMethodBeat.o(220920);
  }
  
  private void cV(boolean paramBoolean)
  {
    AppMethodBeat.i(220940);
    if (paramBoolean) {
      this.eCi.startAudioRecord();
    }
    AppMethodBeat.o(220940);
  }
  
  private void m(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(220898);
    Log.i("TXLivePusherJSAdapter", "adjustHomeOrientation, angle:" + paramInt + ", orientation:" + paramString);
    if (paramInt == 1)
    {
      if (paramString.equals("horizontal")) {
        break label173;
      }
      paramInt = i;
    }
    for (;;)
    {
      Log.i("TXLivePusherJSAdapter", "adjustHomeOrientation, homeOrientation:".concat(String.valueOf(paramInt)));
      if (paramInt != -2147483648)
      {
        this.eCh.setHomeOrientation(paramInt);
        this.eCi.setConfig(this.eCh);
      }
      AppMethodBeat.o(220898);
      return;
      if (paramInt == 3)
      {
        if (paramString.equals("horizontal")) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
      }
      else if (paramInt == 0)
      {
        paramInt = i;
        if (!paramString.equals("horizontal")) {
          paramInt = 1;
        }
      }
      else if (paramInt == 2)
      {
        if (paramString.equals("horizontal")) {
          paramInt = 2;
        } else {
          label173:
          paramInt = 3;
        }
      }
      else
      {
        paramInt = -2147483648;
      }
    }
  }
  
  private static void q(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(220985);
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str.equalsIgnoreCase("pushUrl")) || (str.equalsIgnoreCase("orientation")) || (str.equalsIgnoreCase("backgroundImage")) || (str.equalsIgnoreCase("audioQuality")) || (str.equalsIgnoreCase("watermarkImage")) || (str.equalsIgnoreCase("audioVolumeType")) || (str.equalsIgnoreCase("localMirror")) || (str.equalsIgnoreCase("devicePosition")) || (str.equalsIgnoreCase("beautyStyle")) || (str.equalsIgnoreCase("filterImage"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getString(str);
      } else if ((str.equalsIgnoreCase("mode")) || (str.equalsIgnoreCase("focusMode")) || (str.equalsIgnoreCase("beauty")) || (str.equalsIgnoreCase("whiteness")) || (str.equalsIgnoreCase("aspect")) || (str.equalsIgnoreCase("videoWidth")) || (str.equalsIgnoreCase("videoHeight")) || (str.equalsIgnoreCase("audioReverbType")) || (str.equalsIgnoreCase("minBitrate")) || (str.equalsIgnoreCase("maxBitrate"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getInt(str);
      } else if ((str.equalsIgnoreCase("hide")) || (str.equalsIgnoreCase("autopush")) || (str.equalsIgnoreCase("muted")) || (str.equalsIgnoreCase("enableCamera")) || (str.equalsIgnoreCase("enableMic")) || (str.equalsIgnoreCase("enableAGC")) || (str.equalsIgnoreCase("enableANS")) || (str.equalsIgnoreCase("enableEarMonitor")) || (str.equalsIgnoreCase("backgroundMute")) || (str.equalsIgnoreCase("zoom")) || (str.equalsIgnoreCase("needEvent")) || (str.equalsIgnoreCase("needBGMEvent")) || (str.equalsIgnoreCase("debug")) || (str.equalsIgnoreCase("mirror")) || (str.equalsIgnoreCase("remoteMirror")) || (str.equalsIgnoreCase("needAudioVolume"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getBoolean(str);
      } else if ((str.equalsIgnoreCase("watermarkLeft")) || (str.equalsIgnoreCase("watermarkTop")) || (str.equalsIgnoreCase("watermarkWidth"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getFloat(str);
      }
    }
    Log.i("TXLivePusherJSAdapter", paramString);
    AppMethodBeat.o(220985);
  }
  
  public final k aa(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(221032);
    this.eCi.setFocusPosition(paramFloat1, paramFloat2);
    k localk = new k();
    AppMethodBeat.o(221032);
    return localk;
  }
  
  public final void atU()
  {
    AppMethodBeat.i(221039);
    if (this.mLivePushListener != null)
    {
      Log.i("TXLivePusherJSAdapter", "sendHandupStop, send event 5000");
      this.mLivePushListener.onPushEvent(5000, new Bundle());
    }
    AppMethodBeat.o(221039);
  }
  
  public final void atV()
  {
    AppMethodBeat.i(221040);
    if (this.mLivePushListener != null)
    {
      Log.i("TXLivePusherJSAdapter", "sendWeChatStop, send event 5001");
      this.mLivePushListener.onPushEvent(5001, new Bundle());
    }
    AppMethodBeat.o(221040);
  }
  
  public final k aud()
  {
    AppMethodBeat.i(221041);
    if (this.eCm)
    {
      if (this.eCn)
      {
        localk = e("start", null);
        AppMethodBeat.o(221041);
        return localk;
      }
      localk = e("resume", null);
      AppMethodBeat.o(221041);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(221041);
    return localk;
  }
  
  public final k aup()
  {
    AppMethodBeat.i(221027);
    k localk;
    if (!this.mInited)
    {
      localk = new k(-3, "uninited livePusher");
      AppMethodBeat.o(221027);
      return localk;
    }
    try
    {
      this.eCi.stopBGM();
      auq();
      this.eCi.stopAudioRecord();
      this.eCi.stopPusher();
      this.eCi.setPushListener(null);
      this.mInited = false;
      this.eCO.mInited = false;
      localk = new k();
      AppMethodBeat.o(221027);
      return localk;
    }
    finally
    {
      AppMethodBeat.o(221027);
    }
  }
  
  public final k b(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(221021);
    if ((paramTXCloudVideoView == null) || (paramBundle == null))
    {
      paramTXCloudVideoView = new k(-1, "invalid params");
      AppMethodBeat.o(221021);
      return paramTXCloudVideoView;
    }
    q("InitLivePusher", paramBundle);
    this.mVideoView = paramTXCloudVideoView;
    this.mVideoView.disableLog(false);
    this.eCj = paramBundle.getString("pushUrl", "");
    this.eCi.setPusherUrl(this.eCj);
    a(paramBundle, true);
    this.eCO.c(paramTXCloudVideoView, paramBundle);
    this.eCq = paramBundle.getBoolean("autopush", this.eCq);
    if ((this.eCq) && (this.eCj != null) && (!this.eCj.isEmpty()) && (!this.eCi.isPushing()))
    {
      Log.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
      cU(this.eCv);
      cV(this.eCw);
      this.eCi.startPusher(this.eCj);
    }
    this.mInited = true;
    paramTXCloudVideoView = new k();
    AppMethodBeat.o(221021);
    return paramTXCloudVideoView;
  }
  
  public final k cT(boolean paramBoolean)
  {
    AppMethodBeat.i(221038);
    this.eCm = this.eCi.isPushing();
    if (this.eCm)
    {
      if (paramBoolean)
      {
        this.eCn = paramBoolean;
        localk = e("stop", null);
        AppMethodBeat.o(221038);
        return localk;
      }
      localk = e("pause", null);
      AppMethodBeat.o(221038);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(221038);
    return localk;
  }
  
  public final k dc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221030);
    this.eCi.setSurfaceSize(paramInt1, paramInt2);
    k localk = new k();
    AppMethodBeat.o(221030);
    return localk;
  }
  
  public final k e(final String paramString, JSONObject paramJSONObject)
  {
    final boolean bool1 = true;
    double d = 1.0D;
    int i = 0;
    int j = 0;
    boolean bool2 = false;
    AppMethodBeat.i(221026);
    if (paramString == null)
    {
      paramString = new k(-1, "invalid params");
      AppMethodBeat.o(221026);
      return paramString;
    }
    if (!this.mInited)
    {
      paramString = new k(-3, "uninited livePusher");
      AppMethodBeat.o(221026);
      return paramString;
    }
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    }
    Log.i("TXLivePusherJSAdapter", "operateLivePusher: type = " + paramString + " params = " + str);
    if (paramString.equalsIgnoreCase("start")) {
      if ((this.eCj != null) && (!this.eCj.isEmpty()) && (!this.eCi.isPushing()))
      {
        cU(this.eCv);
        cV(this.eCw);
        if ((this.eCv) && (this.mSurface != null)) {
          this.eCi.setSurface(this.mSurface);
        }
        this.eCi.startPusher(this.eCj);
      }
    }
    for (;;)
    {
      paramString = new k();
      AppMethodBeat.o(221026);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.eCD = false;
        try
        {
          this.eCi.stopBGM();
          auq();
          this.eCi.stopAudioRecord();
          this.eCi.stopPusher();
          continue;
        }
        finally
        {
          paramString = finally;
          AppMethodBeat.o(221026);
          throw paramString;
        }
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        if ((this.eCD) && (this.eCi.isPushing())) {
          this.eCi.turnOnFlashLight(false);
        }
        this.eCi.pausePusher();
        this.eCp = this.eCo;
        if (this.eCp) {
          e("pauseBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.eCi.resumePusher();
        if (this.eCp) {
          e("resumeBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("startPreview"))
      {
        if (this.eCi.isPushing())
        {
          Log.i("TXLivePusherJSAdapter", "do not support startPreview when pushing");
        }
        else
        {
          auq();
          cU(this.eCv);
        }
      }
      else if (paramString.equalsIgnoreCase("stopPreview"))
      {
        if (this.eCi.isPushing()) {
          Log.i("TXLivePusherJSAdapter", "do not support stopPreview when pushing");
        } else {
          auq();
        }
      }
      else
      {
        if (paramString.equalsIgnoreCase("switchCamera"))
        {
          if (!this.mFrontCamera) {}
          for (bool1 = true;; bool1 = false)
          {
            this.mFrontCamera = bool1;
            this.eCh.setFrontCamera(this.mFrontCamera);
            this.eCi.switchCamera();
            break;
          }
        }
        if (paramString.equalsIgnoreCase("snapshot"))
        {
          bool1 = bool2;
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
          paramString = this.mSnapshotListener;
          if ((this.eCi != null) && (this.eCi.isPushing())) {
            this.eCi.snapshot(new TXLivePusher.ITXSnapshotListener()
            {
              public final void onSnapshot(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(220693);
                if (paramString != null)
                {
                  if (bool1)
                  {
                    if (paramAnonymousBitmap != null)
                    {
                      int i = paramAnonymousBitmap.getWidth();
                      int j = paramAnonymousBitmap.getHeight();
                      Object localObject = new Matrix();
                      ((Matrix)localObject).setScale(0.5F, 0.5F);
                      localObject = Bitmap.createBitmap(paramAnonymousBitmap, 0, 0, i, j, (Matrix)localObject, false);
                      paramString.onSnapshot((Bitmap)localObject);
                      v.x(paramAnonymousBitmap);
                      AppMethodBeat.o(220693);
                      return;
                    }
                    paramString.onSnapshot(paramAnonymousBitmap);
                    AppMethodBeat.o(220693);
                    return;
                  }
                  paramString.onSnapshot(paramAnonymousBitmap);
                }
                AppMethodBeat.o(220693);
              }
            });
          }
        }
        else
        {
          if (paramString.equalsIgnoreCase("toggleTorch"))
          {
            if (!this.eCD)
            {
              bool2 = this.eCi.turnOnFlashLight(bool1);
              if (!bool2) {
                break label702;
              }
              label657:
              this.eCD = bool1;
              if (!bool2) {
                break label711;
              }
              label668:
              if (!bool2) {
                break label718;
              }
            }
            label702:
            label711:
            label718:
            for (paramString = "Success";; paramString = "Failed")
            {
              paramString = new k(i, paramString);
              AppMethodBeat.o(221026);
              return paramString;
              bool1 = false;
              break;
              bool1 = this.eCD;
              break label657;
              i = -2;
              break label668;
            }
          }
          if (paramString.equalsIgnoreCase("playBGM"))
          {
            paramString = "";
            if (paramJSONObject != null) {
              paramString = paramJSONObject.optString("BGMFilePath", "");
            }
            Log.i("TXLivePusherJSAdapter", "playBGM filePath = ".concat(String.valueOf(paramString)));
            if ((paramString != null) && (paramString.length() > 0))
            {
              this.eCi.playBGM(paramString);
            }
            else
            {
              paramString = new k(-2, "fail");
              AppMethodBeat.o(221026);
              return paramString;
            }
          }
          else if (paramString.equalsIgnoreCase("stopBGM"))
          {
            this.eCi.stopBGM();
            this.eCo = false;
          }
          else if (paramString.equalsIgnoreCase("pauseBGM"))
          {
            this.eCi.pauseBGM();
            this.eCo = false;
          }
          else
          {
            if (!paramString.equalsIgnoreCase("resumeBGM")) {
              break;
            }
            this.eCi.resumeBGM();
            this.eCo = true;
          }
        }
      }
    }
    if (paramString.equalsIgnoreCase("setBGMVolume")) {
      if (paramJSONObject == null) {
        break label1093;
      }
    }
    label1047:
    label1093:
    for (d = paramJSONObject.optDouble("volume", 1.0D);; d = 1.0D)
    {
      this.eCi.setBGMVolume((float)d);
      break;
      if (paramString.equalsIgnoreCase("setMICVolume"))
      {
        if (paramJSONObject != null) {
          d = paramJSONObject.optDouble("volume", 1.0D);
        }
        this.eCi.setMicVolume((float)d);
        break;
      }
      if (paramString.equalsIgnoreCase("sendMessage"))
      {
        paramString = null;
        if (paramJSONObject != null) {
          paramString = paramJSONObject.optString("msg");
        }
        if (paramString != null)
        {
          bool1 = this.eCi.sendMessageEx(paramString.getBytes());
          if (bool1)
          {
            i = j;
            if (!bool1) {
              break label1047;
            }
          }
          for (paramString = "Success";; paramString = "Failed")
          {
            paramString = new k(i, paramString);
            AppMethodBeat.o(221026);
            return paramString;
            i = -2;
            break;
          }
        }
        paramString = new k(-2, "fail");
        AppMethodBeat.o(221026);
        return paramString;
      }
      paramString = this.eCO.e(paramString, paramJSONObject);
      AppMethodBeat.o(221026);
      return paramString;
    }
  }
  
  public final int getMaxZoom()
  {
    AppMethodBeat.i(221036);
    if (this.eCi != null)
    {
      int i = this.eCi.getMaxZoom();
      AppMethodBeat.o(221036);
      return i;
    }
    AppMethodBeat.o(221036);
    return 0;
  }
  
  public final k h(Surface paramSurface)
  {
    AppMethodBeat.i(221029);
    this.mSurface = paramSurface;
    this.eCi.setSurface(paramSurface);
    paramSurface = new k();
    AppMethodBeat.o(221029);
    return paramSurface;
  }
  
  public final k mF(int paramInt)
  {
    AppMethodBeat.i(221034);
    this.eCi.setZoom(paramInt);
    k localk = new k();
    AppMethodBeat.o(221034);
    return localk;
  }
  
  public final void notifyOrientationChanged(final int paramInt)
  {
    AppMethodBeat.i(221013);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220692);
        v.a(v.this, paramInt);
        Log.i("TXLivePusherJSAdapter", "notifyOrientationChanged, angle:" + paramInt + ", orientation:" + v.a(v.this));
        v.a(v.this, paramInt, v.a(v.this));
        AppMethodBeat.o(220692);
      }
    });
    AppMethodBeat.o(221013);
  }
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(221053);
    if ((this.ezz) && (this.mAudioVolumeListener != null)) {
      this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(221053);
  }
  
  public final void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(221051);
    this.eCo = false;
    if ((this.eCE) && (this.mBGMNotifyListener != null)) {
      this.mBGMNotifyListener.onBGMComplete(paramInt);
    }
    AppMethodBeat.o(221051);
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221049);
    if ((this.eCE) && (this.mBGMNotifyListener != null)) {
      this.mBGMNotifyListener.onBGMProgress(paramLong1, paramLong2);
    }
    AppMethodBeat.o(221049);
  }
  
  public final void onBGMStart()
  {
    AppMethodBeat.i(221047);
    this.eCo = true;
    if ((this.eCE) && (this.mBGMNotifyListener != null)) {
      this.mBGMNotifyListener.onBGMStart();
    }
    AppMethodBeat.o(221047);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(221044);
    if (this.mLivePushListener != null) {
      this.mLivePushListener.onNetStatus(paramBundle);
    }
    Log.i("TXLivePusherJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(221044);
  }
  
  public final void onPushEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(221042);
    if ((paramInt == -1307) || (paramInt == -1313))
    {
      Runnable local3 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220685);
          v.this.e("stop", null);
          AppMethodBeat.o(220685);
        }
      };
      if (this.mHandler != null) {
        this.mHandler.post(local3);
      }
    }
    for (;;)
    {
      if (this.mLivePushListener != null) {
        this.mLivePushListener.onPushEvent(paramInt, paramBundle);
      }
      paramBundle = paramBundle.getString("EVT_MSG");
      Log.i("TXLivePusherJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
      AppMethodBeat.o(221042);
      return;
      if ((paramInt == 1003) && (this.eCD)) {
        this.eCi.turnOnFlashLight(this.eCD);
      }
    }
  }
  
  public final void setAudioVolumeListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.mAudioVolumeListener = paramITXAudioVolumeEvaluationListener;
  }
  
  public final void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    this.mBGMNotifyListener = paramOnBGMNotify;
  }
  
  public final void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    this.mLivePushListener = paramITXLivePushListener;
  }
  
  public final void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.mSnapshotListener = paramITXSnapshotListener;
  }
  
  public final void setThreadHandler(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public final k y(Bundle paramBundle)
  {
    AppMethodBeat.i(221023);
    if (paramBundle == null)
    {
      paramBundle = new k(-1, "invalid params");
      AppMethodBeat.o(221023);
      return paramBundle;
    }
    if (this.mLivePushListener != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
      localBundle.putLong("EVT_TIME", System.currentTimeMillis());
      this.mLivePushListener.onPushEvent(-9999999, localBundle);
    }
    q("InitLivePusher", paramBundle);
    this.mVideoView = null;
    this.eCj = paramBundle.getString("pushUrl", "");
    this.eCi.setPusherUrl(this.eCj);
    a(paramBundle, true);
    this.eCO.A(paramBundle);
    this.eCq = paramBundle.getBoolean("autopush", this.eCq);
    if ((this.eCq) && (this.eCj != null) && (!this.eCj.isEmpty()) && (!this.eCi.isPushing()))
    {
      Log.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
      cU(this.eCv);
      cV(this.eCw);
      if ((this.eCv) && (this.mSurface != null)) {
        this.eCi.setSurface(this.mSurface);
      }
      this.eCi.startPusher(this.eCj);
    }
    this.mInited = true;
    paramBundle = new k();
    AppMethodBeat.o(221023);
    return paramBundle;
  }
  
  public final k z(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(221024);
    if (paramBundle == null)
    {
      paramBundle = new k(-1, "invalid params");
      AppMethodBeat.o(221024);
      return paramBundle;
    }
    q("updateLivePusher", paramBundle);
    if (!this.mInited)
    {
      paramBundle = new k(-3, "uninited livePusher");
      AppMethodBeat.o(221024);
      return paramBundle;
    }
    a(paramBundle, false);
    this.eCO.B(paramBundle);
    String str = paramBundle.getString("pushUrl", this.eCj);
    if ((str != null) && (!str.isEmpty()) && (this.eCj != null) && (!this.eCj.equalsIgnoreCase(str)) && (this.eCi.isPushing()))
    {
      Log.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
      auq();
      this.eCi.stopAudioRecord();
      this.eCi.stopPusher();
    }
    this.eCj = str;
    this.eCi.setPusherUrl(this.eCj);
    this.eCq = paramBundle.getBoolean("autopush", this.eCq);
    if ((this.eCq) && (this.eCj != null) && (!this.eCj.isEmpty()) && (!this.eCi.isPushing()))
    {
      Log.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
      cU(this.eCv);
      if (!this.eCw) {
        break label330;
      }
      this.eCi.stopAudioRecord();
      cV(true);
      paramBundle = this.eCi;
      if (this.eCw) {
        break label340;
      }
    }
    for (;;)
    {
      paramBundle.setMute(bool);
      if ((this.eCv) && (this.mSurface != null)) {
        this.eCi.setSurface(this.mSurface);
      }
      this.eCi.startPusher(this.eCj);
      paramBundle = new k();
      AppMethodBeat.o(221024);
      return paramBundle;
      label330:
      this.eCi.stopAudioRecord();
      break;
      label340:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.v
 * JD-Core Version:    0.7.0.1
 */