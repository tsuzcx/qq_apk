package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.WXLivePushConfig;
import com.tencent.rtmp.WXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class s
  implements b, ITXLivePushListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.OnBGMNotify
{
  private String cGe;
  private boolean cGk;
  private boolean cGl;
  private boolean cGn;
  private String cHV;
  private WXLivePushConfig cIB;
  private WXLivePusher cIC;
  private String cID;
  private boolean cIE;
  private String cIF;
  private boolean cIG;
  private boolean cIH;
  private boolean cII;
  private boolean cIJ;
  private boolean cIK;
  private int cIL;
  private int cIM;
  private int cIN;
  private int cIO;
  private boolean cIP;
  private boolean cIQ;
  private String cIR;
  private int cIS;
  private int cIT;
  private String cIU;
  private String cIV;
  private boolean cIW;
  private boolean cIX;
  private boolean cIY;
  private boolean cIZ;
  private String cJa;
  private float cJb;
  private float cJc;
  private String cJd;
  private boolean cJe;
  private String cJf;
  private int cJg;
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
  private int mVideoHeight;
  private TXCloudVideoView mVideoView;
  private int mVideoWidth;
  private float mWatermarkWidth;
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(212560);
    this.mLastAngle = 0;
    this.mInited = false;
    this.cIE = false;
    this.mFrontCamera = true;
    this.cIF = "front";
    this.cIG = false;
    this.cIH = false;
    this.cII = false;
    this.cIJ = false;
    this.cIK = false;
    this.mMode = 1;
    this.cIL = 2;
    this.cIM = -1;
    this.cIN = -1;
    this.mMute = false;
    this.cIO = 0;
    this.cIP = true;
    this.cIQ = true;
    this.cGe = "vertical";
    this.cIR = "high";
    this.cIS = 5;
    this.cIT = 3;
    this.cIU = "smooth";
    this.cHV = "";
    this.cIV = "";
    this.cIW = false;
    this.cIX = false;
    this.mEnableZoom = true;
    this.cGk = false;
    this.cIY = false;
    this.cGn = false;
    this.cIZ = false;
    this.cJa = "auto";
    this.cJb = 0.0F;
    this.cJc = 0.0F;
    this.mWatermarkWidth = 0.1F;
    this.cJd = "";
    this.mEnableAgc = false;
    this.mEnableAns = false;
    this.cJe = false;
    this.cJf = "auto";
    this.cJg = 0;
    this.mVideoWidth = 368;
    this.mVideoHeight = 640;
    this.cGl = false;
    this.mContext = paramContext;
    this.mHandler = new Handler(this.mContext.getMainLooper());
    this.cIB = new WXLivePushConfig();
    this.cIC = new WXLivePusher(paramContext);
    this.cIC.setConfig(this.cIB);
    this.cIC.setPushListener(this);
    this.cIC.setBGMNofify(this);
    this.cIC.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(212560);
  }
  
  private void TL()
  {
    AppMethodBeat.i(212598);
    this.cIC.stopCameraPreview(true);
    this.cIE = false;
    AppMethodBeat.o(212598);
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(212639);
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0))
    {
      AppMethodBeat.o(212639);
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
      m = this.cIM;
      n = this.cIN;
      i = paramBundle.getInt("minBitrate", -1);
      j = paramBundle.getInt("maxBitrate", -1);
      if (i > j)
      {
        Log.e("TXLivePusherJSAdapterV1", "parseAndApplyParams -> swap min and max bitrate, may be something error. min = " + i + " max = " + j);
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
                this.cIB.setMinVideoBitrate(m);
                this.cIB.setMaxVideoBitrate(i);
                i1 = m;
                j = i;
              }
            }
          }
        }
      }
      k = paramBundle.getInt("aspect", this.cIL);
      m = paramBundle.getInt("videoWidth", this.mVideoWidth);
      n = paramBundle.getInt("videoHeight", this.mVideoHeight);
      Object localObject1 = paramBundle.getString("audioQuality", this.cIR);
      label402:
      label460:
      Object localObject2;
      boolean bool1;
      label487:
      boolean bool2;
      label618:
      String str1;
      label661:
      label721:
      float f1;
      float f2;
      float f3;
      Object localObject4;
      if (i2 == 6)
      {
        if (k == 1)
        {
          this.cIB.setVideoResolution(13);
          if ((m > 0) && (m <= 1920) && (n > 0) && (n <= 1920)) {
            this.cIB.setVideoResolution(m, n);
          }
          if (!((String)localObject1).equalsIgnoreCase("low")) {
            break label1991;
          }
          this.cIB.setAudioSampleRate(16000);
        }
      }
      else
      {
        int i3 = paramBundle.getInt("focusMode", this.cIO);
        localObject2 = this.cIB;
        if (i3 == 0) {
          break label2014;
        }
        bool1 = true;
        ((WXLivePushConfig)localObject2).setTouchFocus(bool1);
        bool2 = this.mFrontCamera;
        bool1 = bool2;
        if (paramBundle.keySet().contains("devicePosition"))
        {
          this.cIF = paramBundle.getString("devicePosition", this.cIF);
          bool1 = bool2;
          if (this.cIF.equalsIgnoreCase("back")) {
            bool1 = false;
          }
          this.cIB.setFrontCamera(bool1);
        }
        localObject2 = paramBundle.getString("orientation", this.cGe);
        if (!((String)localObject2).equalsIgnoreCase(this.cGe))
        {
          if (!((String)localObject2).equalsIgnoreCase("horizontal")) {
            break label2020;
          }
          m(this.mLastAngle, (String)localObject2);
          this.cIC.setRenderRotation(90);
        }
        str1 = paramBundle.getString("localMirror", this.cJa);
        if (!str1.equalsIgnoreCase(this.cJa))
        {
          if (!str1.equalsIgnoreCase("auto")) {
            break label2051;
          }
          this.cIB.setLocalVideoMirrorType(0);
        }
        String str2 = paramBundle.getString("backgroundImage", this.cIV);
        Object localObject3 = BitmapFactory.decodeFile(str2);
        if (localObject3 != null) {
          this.cIB.setPauseImg((Bitmap)localObject3);
        }
        boolean bool3 = paramBundle.getBoolean("backgroundMute", this.cIW);
        if (!bool3) {
          break label2095;
        }
        this.cIB.setPauseFlag(3);
        boolean bool4 = paramBundle.getBoolean("zoom", this.mEnableZoom);
        this.cIB.setEnableZoom(bool4);
        f1 = paramBundle.getFloat("watermarkLeft", this.cJb);
        f2 = paramBundle.getFloat("watermarkTop", this.cJc);
        f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
        localObject3 = paramBundle.getString("watermarkImage", this.cJd);
        localObject4 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject4 == null) {
          break label2106;
        }
        this.cIB.setWatermark((Bitmap)localObject4, f1, f2, f3);
        label820:
        boolean bool5 = paramBundle.getBoolean("enableAGC", this.mEnableAgc);
        this.cIB.enableAGC(bool5);
        boolean bool6 = paramBundle.getBoolean("enableANS", this.mEnableAns);
        this.cIB.enableANS(bool6);
        boolean bool7 = paramBundle.getBoolean("enableEarMonitor", this.cJe);
        this.cIB.enableAudioEarMonitoring(bool7);
        localObject4 = paramBundle.getString("audioVolumeType", this.cJf);
        if (!((String)localObject4).equalsIgnoreCase("voicecall")) {
          break label2148;
        }
        this.cIB.setVolumeType(2);
        label918:
        boolean bool8 = paramBundle.getBoolean("enableCamera", this.cIP);
        Object localObject5 = this.cIB;
        if (bool8) {
          break label2181;
        }
        bool2 = true;
        label945:
        ((WXLivePushConfig)localObject5).enablePureAudioPush(bool2);
        i = 0;
        if ((k != this.cIL) || (i1 != this.cIM) || (j != this.cIN) || (i3 != this.cIO) || (bool1 != this.mFrontCamera) || (bool3 != this.cIW) || (bool4 != this.mEnableZoom) || (bool5 != this.mEnableAgc) || (bool6 != this.mEnableAns) || (bool7 != this.cJe) || (bool8 != this.cIP) || (m != this.mVideoWidth) || (n != this.mVideoHeight) || (f1 != this.cJb) || (f2 != this.cJc) || (f3 != this.mWatermarkWidth) || (!str1.equalsIgnoreCase(this.cJa)) || (!((String)localObject4).equalsIgnoreCase(this.cJf)) || (!str2.equalsIgnoreCase(this.cIV)) || (!((String)localObject2).equalsIgnoreCase(this.cGe)) || (!((String)localObject1).equalsIgnoreCase(this.cIR)) || (!((String)localObject3).equalsIgnoreCase(this.cJd))) {
          i = 1;
        }
        if ((paramBoolean) || (i != 0)) {
          this.cIC.setConfig(this.cIB);
        }
        if (bool8 != this.cIP)
        {
          if (!bool8) {
            break label2187;
          }
          TL();
          co(bool8);
        }
        label1220:
        if (!paramBundle.keySet().contains("enableMic")) {
          break label2216;
        }
        boolean bool9 = paramBundle.getBoolean("enableMic", this.cIQ);
        if (bool9 != this.cIQ)
        {
          if (!bool9) {
            break label2194;
          }
          this.cIC.stopAudioRecord();
          cp(true);
        }
        label1274:
        if ((paramBoolean) || (bool9 != this.cIQ))
        {
          localObject5 = this.cIC;
          if (bool9) {
            break label2204;
          }
          bool2 = true;
          ((WXLivePusher)localObject5).setMute(bool2);
          if (bool9) {
            break label2210;
          }
          bool2 = true;
          this.mMute = bool2;
        }
        label1301:
        label1316:
        this.cIQ = bool9;
        label1328:
        this.mMode = i2;
        this.cIL = k;
        this.cIO = i3;
        this.cIP = bool8;
        this.mEnableAgc = bool5;
        this.mEnableAns = bool6;
        this.cJe = bool7;
        this.cJa = str1;
        this.cJf = ((String)localObject4);
        this.mVideoWidth = m;
        this.mVideoHeight = n;
        this.mFrontCamera = bool1;
        this.cGe = ((String)localObject2);
        this.cIW = bool3;
        this.cIV = str2;
        this.cIM = i1;
        this.cIN = j;
        this.cIR = ((String)localObject1);
        this.mEnableZoom = bool4;
        this.cJb = f1;
        this.cJc = f2;
        this.mWatermarkWidth = f3;
        this.cJd = ((String)localObject3);
        this.cGk = paramBundle.getBoolean("needEvent", this.cGk);
        this.cIY = paramBundle.getBoolean("needBGMEvent", this.cIY);
        bool1 = this.cIZ;
        if (!paramBundle.keySet().contains("remoteMirror")) {
          break label2317;
        }
        bool1 = paramBundle.getBoolean("remoteMirror");
        label1525:
        if (bool1 != this.cIZ) {
          this.cIC.setMirror(bool1);
        }
        this.cIZ = bool1;
        i = paramBundle.getInt("beauty", this.cIS);
        j = paramBundle.getInt("whiteness", this.cIT);
        localObject1 = paramBundle.getString("beautyStyle", this.cIU);
        if ((paramBoolean) || (i != this.cIS) || (j != this.cIT) || (!((String)localObject1).equalsIgnoreCase(this.cIU)))
        {
          if (!((String)localObject1).equalsIgnoreCase("nature")) {
            break label2344;
          }
          this.cIC.setBeautyFilter(1, i, j, 2);
        }
        label1648:
        this.cIS = i;
        this.cIT = j;
        this.cIU = ((String)localObject1);
        localObject1 = paramBundle.getString("filterImage", this.cHV);
        if (!((String)localObject1).equalsIgnoreCase(this.cHV))
        {
          localObject2 = BitmapFactory.decodeFile((String)localObject1);
          this.cIC.setFilter((Bitmap)localObject2);
        }
        this.cHV = ((String)localObject1);
        i = paramBundle.getInt("audioReverbType", this.cJg);
        if (i != this.cJg) {
          this.cIC.setReverb(i);
        }
        this.cJg = i;
        bool1 = paramBundle.getBoolean("needAudioVolume", this.cGl);
        if (bool1 != this.cGl)
        {
          localObject1 = this.cIC;
          if (!bool1) {
            break label2361;
          }
        }
      }
      label2051:
      label2095:
      label2361:
      for (i = 300;; i = 0)
      {
        ((WXLivePusher)localObject1).enableAudioVolumeEvaluation(i);
        this.cGl = bool1;
        bool1 = paramBundle.getBoolean("debug", this.cGn);
        if ((paramBoolean) || (bool1 != this.cGn)) {
          this.cIC.showDebugLog(bool1);
        }
        this.cGn = bool1;
        AppMethodBeat.o(212639);
        return;
        this.cIC.setVideoQuality(1, true, false);
        this.cIB.setVideoEncodeGop(5);
        break;
        this.cIC.setVideoQuality(2, true, false);
        this.cIB.setVideoEncodeGop(5);
        break;
        this.cIC.setVideoQuality(3, true, false);
        this.cIB.setVideoEncodeGop(5);
        break;
        this.cIC.setVideoQuality(4, true, false);
        break;
        this.cIC.setVideoQuality(5, true, false);
        break;
        this.cIC.setVideoQuality(6, false, false);
        break;
        this.cIC.setVideoQuality(7, true, false);
        this.cIB.setVideoEncodeGop(5);
        break;
        if (k != 2) {
          break label402;
        }
        this.cIB.setVideoResolution(0);
        break label402;
        label1991:
        if (!((String)localObject1).equalsIgnoreCase("high")) {
          break label460;
        }
        this.cIB.setAudioSampleRate(48000);
        break label460;
        label2014:
        bool1 = false;
        break label487;
        label2020:
        if (!((String)localObject2).equalsIgnoreCase("vertical")) {
          break label618;
        }
        m(this.mLastAngle, (String)localObject2);
        this.cIC.setRenderRotation(0);
        break label618;
        if (str1.equalsIgnoreCase("enable"))
        {
          this.cIB.setLocalVideoMirrorType(1);
          break label661;
        }
        if (!str1.equalsIgnoreCase("disable")) {
          break label661;
        }
        this.cIB.setLocalVideoMirrorType(2);
        break label661;
        this.cIB.setPauseFlag(1);
        break label721;
        label2106:
        if ((!this.cIC.isPushing()) || (!paramBundle.keySet().contains("watermarkImage"))) {
          break label820;
        }
        this.cIB.setWatermark((Bitmap)localObject4, f1, f2, f3);
        break label820;
        label2148:
        if (((String)localObject4).equalsIgnoreCase("media"))
        {
          this.cIB.setVolumeType(1);
          break label918;
        }
        this.cIB.setVolumeType(0);
        break label918;
        bool2 = false;
        break label945;
        TL();
        break label1220;
        this.cIC.stopAudioRecord();
        break label1274;
        bool2 = false;
        break label1301;
        bool2 = false;
        break label1316;
        if (!paramBundle.keySet().contains("muted")) {
          break label1328;
        }
        bool2 = paramBundle.getBoolean("muted", this.mMute);
        if (!this.cIQ)
        {
          Log.i("TXLivePusherJSAdapterV1", String.format("parseAndApplyParams, enableMic: %b, mute: %b", new Object[] { Boolean.FALSE, Boolean.valueOf(this.mMute) }));
          bool2 = true;
        }
        if ((paramBoolean) || (bool2 != this.mMute)) {
          this.cIC.setMute(bool2);
        }
        this.mMute = bool2;
        break label1328;
        if (!paramBundle.keySet().contains("mirror")) {
          break label1525;
        }
        bool1 = paramBundle.getBoolean("mirror");
        break label1525;
        this.cIC.setBeautyFilter(0, i, j, 2);
        break label1648;
      }
      label2181:
      label2187:
      label2194:
      label2204:
      label2210:
      label2216:
      label2344:
      k = i;
      label2317:
      i = j;
    }
  }
  
  private void co(boolean paramBoolean)
  {
    AppMethodBeat.i(212594);
    if ((!this.cIE) && (paramBoolean))
    {
      this.mVideoView.setVisibility(0);
      this.cIC.startCameraPreview(this.mVideoView);
      this.cIE = true;
    }
    AppMethodBeat.o(212594);
  }
  
  private void cp(boolean paramBoolean)
  {
    AppMethodBeat.i(212601);
    if (paramBoolean) {
      this.cIC.startAudioRecord();
    }
    AppMethodBeat.o(212601);
  }
  
  private void m(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(212565);
    Log.i("TXLivePusherJSAdapterV1", "adjustHomeOrientation, angle:" + paramInt + ", orientation:" + paramString);
    if (paramInt == 1)
    {
      if (paramString.equals("horizontal")) {
        break label173;
      }
      paramInt = i;
    }
    for (;;)
    {
      Log.i("TXLivePusherJSAdapterV1", "adjustHomeOrientation, homeOrientation:".concat(String.valueOf(paramInt)));
      if (paramInt != -2147483648)
      {
        this.cIB.setHomeOrientation(paramInt);
        this.cIC.setConfig(this.cIB);
      }
      AppMethodBeat.o(212565);
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
    AppMethodBeat.i(212643);
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
    Log.i("TXLivePusherJSAdapterV1", paramString);
    AppMethodBeat.o(212643);
  }
  
  public final k TK()
  {
    AppMethodBeat.i(212604);
    if (!this.mInited)
    {
      localk = new k(-3, "uninited livePusher");
      AppMethodBeat.o(212604);
      return localk;
    }
    this.cIC.stopBGM();
    TL();
    this.cIC.stopAudioRecord();
    this.cIC.stopPusher();
    this.cIC.setPushListener(null);
    this.mInited = false;
    k localk = new k();
    AppMethodBeat.o(212604);
    return localk;
  }
  
  public final k Ty()
  {
    AppMethodBeat.i(212611);
    if (this.cIG)
    {
      if (this.cIH)
      {
        localk = e("start", null);
        AppMethodBeat.o(212611);
        return localk;
      }
      localk = e("resume", null);
      AppMethodBeat.o(212611);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(212611);
    return localk;
  }
  
  public final k b(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(212577);
    if ((paramTXCloudVideoView == null) || (paramBundle == null))
    {
      paramTXCloudVideoView = new k(-1, "invalid params");
      AppMethodBeat.o(212577);
      return paramTXCloudVideoView;
    }
    q("InitLivePusher", paramBundle);
    this.mVideoView = paramTXCloudVideoView;
    this.mVideoView.disableLog(false);
    this.cID = paramBundle.getString("pushUrl", "");
    this.cIC.setPusherUrl(this.cID);
    a(paramBundle, true);
    this.cIK = paramBundle.getBoolean("autopush", this.cIK);
    if ((this.cIK) && (this.cID != null) && (!this.cID.isEmpty()) && (!this.cIC.isPushing()))
    {
      Log.i("TXLivePusherJSAdapterV1", "initLivePusher: startPusher");
      co(this.cIP);
      cp(this.cIQ);
      this.cIC.startPusher(this.cID);
    }
    this.mInited = true;
    paramTXCloudVideoView = new k();
    AppMethodBeat.o(212577);
    return paramTXCloudVideoView;
  }
  
  public final k cn(boolean paramBoolean)
  {
    AppMethodBeat.i(212607);
    this.cIG = this.cIC.isPushing();
    if (this.cIG)
    {
      if (paramBoolean)
      {
        this.cIH = paramBoolean;
        if ((this.cGk) && (this.mLivePushListener != null)) {
          this.mLivePushListener.onPushEvent(5000, new Bundle());
        }
        localk = e("stop", null);
        AppMethodBeat.o(212607);
        return localk;
      }
      localk = e("pause", null);
      AppMethodBeat.o(212607);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(212607);
    return localk;
  }
  
  public final k e(final String paramString, JSONObject paramJSONObject)
  {
    final boolean bool1 = true;
    double d = 1.0D;
    int i = 0;
    int j = 0;
    boolean bool2 = false;
    AppMethodBeat.i(212592);
    if (paramString == null)
    {
      paramString = new k(-1, "invalid params");
      AppMethodBeat.o(212592);
      return paramString;
    }
    if (!this.mInited)
    {
      paramString = new k(-3, "uninited livePusher");
      AppMethodBeat.o(212592);
      return paramString;
    }
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    }
    Log.i("TXLivePusherJSAdapterV1", "operateLivePusher: type = " + paramString + " params = " + str);
    if (paramString.equalsIgnoreCase("start")) {
      if ((this.cID != null) && (!this.cID.isEmpty()) && (!this.cIC.isPushing()))
      {
        co(this.cIP);
        cp(this.cIQ);
        this.cIC.startPusher(this.cID);
      }
    }
    for (;;)
    {
      paramString = new k();
      AppMethodBeat.o(212592);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.cIX = false;
        this.cIC.stopBGM();
        TL();
        this.cIC.stopAudioRecord();
        this.cIC.stopPusher();
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        if ((this.cIX) && (this.cIC.isPushing())) {
          this.cIC.turnOnFlashLight(false);
        }
        this.cIC.pausePusher();
        this.cIJ = this.cII;
        if (this.cIJ) {
          e("pauseBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.cIC.resumePusher();
        if (this.cIJ) {
          e("resumeBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("startPreview"))
      {
        if (this.cIC.isPushing())
        {
          Log.i("TXLivePusherJSAdapterV1", "do not support startPreview when pushing");
        }
        else
        {
          TL();
          co(this.cIP);
        }
      }
      else if (paramString.equalsIgnoreCase("stopPreview"))
      {
        if (this.cIC.isPushing()) {
          Log.i("TXLivePusherJSAdapterV1", "do not support stopPreview when pushing");
        } else {
          TL();
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
            this.cIB.setFrontCamera(this.mFrontCamera);
            this.cIC.switchCamera();
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
          if ((this.cIC != null) && (this.cIC.isPushing())) {
            this.cIC.snapshot(new TXLivePusher.ITXSnapshotListener()
            {
              public final void onSnapshot(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(212741);
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
                      s.S(paramAnonymousBitmap);
                      AppMethodBeat.o(212741);
                      return;
                    }
                    paramString.onSnapshot(paramAnonymousBitmap);
                    AppMethodBeat.o(212741);
                    return;
                  }
                  paramString.onSnapshot(paramAnonymousBitmap);
                }
                AppMethodBeat.o(212741);
              }
            });
          }
        }
        else
        {
          if (paramString.equalsIgnoreCase("toggleTorch"))
          {
            if (this.cIC.isPushing())
            {
              if (!this.cIX)
              {
                bool2 = this.cIC.turnOnFlashLight(bool1);
                if (!bool2) {
                  break label672;
                }
                label627:
                this.cIX = bool1;
                if (!bool2) {
                  break label681;
                }
                label638:
                if (!bool2) {
                  break label688;
                }
              }
              label672:
              label681:
              label688:
              for (paramString = "Success";; paramString = "Failed")
              {
                paramString = new k(i, paramString);
                AppMethodBeat.o(212592);
                return paramString;
                bool1 = false;
                break;
                bool1 = this.cIX;
                break label627;
                i = -2;
                break label638;
              }
            }
            paramString = new k(-2, "fail");
            AppMethodBeat.o(212592);
            return paramString;
          }
          if (paramString.equalsIgnoreCase("playBGM"))
          {
            paramString = "";
            if (paramJSONObject != null) {
              paramString = paramJSONObject.optString("BGMFilePath", "");
            }
            Log.i("TXLivePusherJSAdapterV1", "playBGM filePath = ".concat(String.valueOf(paramString)));
            if ((paramString != null) && (paramString.length() > 0))
            {
              this.cIC.playBGM(paramString);
            }
            else
            {
              paramString = new k(-2, "fail");
              AppMethodBeat.o(212592);
              return paramString;
            }
          }
          else if (paramString.equalsIgnoreCase("stopBGM"))
          {
            this.cIC.stopBGM();
            this.cII = false;
          }
          else if (paramString.equalsIgnoreCase("pauseBGM"))
          {
            this.cIC.pauseBGM();
            this.cII = false;
          }
          else
          {
            if (!paramString.equalsIgnoreCase("resumeBGM")) {
              break;
            }
            this.cIC.resumeBGM();
            this.cII = true;
          }
        }
      }
    }
    if (paramString.equalsIgnoreCase("setBGMVolume")) {
      if (paramJSONObject == null) {
        break label1087;
      }
    }
    label1038:
    label1087:
    for (d = paramJSONObject.optDouble("volume", 1.0D);; d = 1.0D)
    {
      this.cIC.setBGMVolume((float)d);
      break;
      if (paramString.equalsIgnoreCase("setMICVolume"))
      {
        if (paramJSONObject != null) {
          d = paramJSONObject.optDouble("volume", 1.0D);
        }
        this.cIC.setMicVolume((float)d);
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
          bool1 = this.cIC.sendMessageEx(paramString.getBytes());
          if (bool1)
          {
            i = j;
            if (!bool1) {
              break label1038;
            }
          }
          for (paramString = "Success";; paramString = "Failed")
          {
            paramString = new k(i, paramString);
            AppMethodBeat.o(212592);
            return paramString;
            i = -2;
            break;
          }
        }
        paramString = new k(-2, "fail");
        AppMethodBeat.o(212592);
        return paramString;
      }
      paramString = new k(-4, "invalid operate command");
      AppMethodBeat.o(212592);
      return paramString;
    }
  }
  
  public final void notifyOrientationChanged(final int paramInt)
  {
    AppMethodBeat.i(212562);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(212834);
        s.a(s.this, paramInt);
        Log.i("TXLivePusherJSAdapterV1", "notifyOrientationChanged, angle:" + paramInt + ", orientation:" + s.a(s.this));
        s.a(s.this, paramInt, s.a(s.this));
        AppMethodBeat.o(212834);
      }
    });
    AppMethodBeat.o(212562);
  }
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(212627);
    if ((this.cGl) && (this.mAudioVolumeListener != null)) {
      this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(212627);
  }
  
  public final void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(212624);
    this.cII = false;
    if ((this.cIY) && (this.mBGMNotifyListener != null)) {
      this.mBGMNotifyListener.onBGMComplete(paramInt);
    }
    AppMethodBeat.o(212624);
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(212622);
    if ((this.cIY) && (this.mBGMNotifyListener != null)) {
      this.mBGMNotifyListener.onBGMProgress(paramLong1, paramLong2);
    }
    AppMethodBeat.o(212622);
  }
  
  public final void onBGMStart()
  {
    AppMethodBeat.i(212620);
    this.cII = true;
    if ((this.cIY) && (this.mBGMNotifyListener != null)) {
      this.mBGMNotifyListener.onBGMStart();
    }
    AppMethodBeat.o(212620);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(212618);
    if (this.mLivePushListener != null) {
      this.mLivePushListener.onNetStatus(paramBundle);
    }
    Log.i("TXLivePusherJSAdapterV1", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(212618);
  }
  
  public final void onPushEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(212614);
    if ((paramInt == -1307) || (paramInt == -1313)) {
      e("stop", null);
    }
    for (;;)
    {
      if ((this.cGk) && (this.mLivePushListener != null)) {
        this.mLivePushListener.onPushEvent(paramInt, paramBundle);
      }
      paramBundle = paramBundle.getString("EVT_MSG");
      Log.i("TXLivePusherJSAdapterV1", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
      AppMethodBeat.o(212614);
      return;
      if ((paramInt == 1003) && (this.cIX)) {
        this.cIC.turnOnFlashLight(this.cIX);
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
  
  public final k u(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(212583);
    if (paramBundle == null)
    {
      paramBundle = new k(-1, "invalid params");
      AppMethodBeat.o(212583);
      return paramBundle;
    }
    q("updateLivePusher", paramBundle);
    if (!this.mInited)
    {
      paramBundle = new k(-3, "uninited livePusher");
      AppMethodBeat.o(212583);
      return paramBundle;
    }
    a(paramBundle, false);
    String str = paramBundle.getString("pushUrl", this.cID);
    if ((str != null) && (!str.isEmpty()) && (this.cID != null) && (!this.cID.equalsIgnoreCase(str)) && (this.cIC.isPushing()))
    {
      Log.i("TXLivePusherJSAdapterV1", "updateLivePusher: stopPusher");
      TL();
      this.cIC.stopAudioRecord();
      this.cIC.stopPusher();
    }
    this.cID = str;
    this.cIC.setPusherUrl(this.cID);
    this.cIK = paramBundle.getBoolean("autopush", this.cIK);
    if ((this.cIK) && (this.cID != null) && (!this.cID.isEmpty()) && (!this.cIC.isPushing()))
    {
      Log.i("TXLivePusherJSAdapterV1", "updateLivePusher: startPusher");
      co(this.cIP);
      if (!this.cIQ) {
        break label297;
      }
      this.cIC.stopAudioRecord();
      cp(true);
      paramBundle = this.cIC;
      if (this.cIQ) {
        break label307;
      }
    }
    for (;;)
    {
      paramBundle.setMute(bool);
      this.cIC.startPusher(this.cID);
      paramBundle = new k();
      AppMethodBeat.o(212583);
      return paramBundle;
      label297:
      this.cIC.stopAudioRecord();
      break;
      label307:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.s
 * JD-Core Version:    0.7.0.1
 */