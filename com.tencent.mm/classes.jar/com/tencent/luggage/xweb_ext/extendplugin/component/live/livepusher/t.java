package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.WXLivePushConfig;
import com.tencent.rtmp.WXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t
  implements l, ITXLivePushListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.OnBGMNotify
{
  private static n.b cJk = n.b.cHy;
  private String cGe;
  private boolean cGk;
  private boolean cGl;
  private boolean cGn;
  private String cHV;
  private WXLivePushConfig cIB;
  private final WXLivePusher cIC;
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
  private final n cJh;
  private boolean cJi;
  private boolean cJj;
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
  
  public t(Context paramContext)
  {
    AppMethodBeat.i(220783);
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
    this.cJh = cJk.TI();
    this.cJi = false;
    this.cJj = false;
    this.mContext = paramContext;
    this.cIB = new WXLivePushConfig();
    this.cIC = new WXLivePusher(paramContext);
    this.cIC.setConfig(this.cIB);
    this.cIC.setPushListener(this);
    this.cIC.setBGMNofify(this);
    this.cIC.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(220783);
  }
  
  private void TL()
  {
    AppMethodBeat.i(220862);
    this.cIC.stopCameraPreview(true);
    this.cIE = false;
    AppMethodBeat.o(220862);
  }
  
  private boolean TM()
  {
    AppMethodBeat.i(221019);
    if ((this.cJj) && (this.cJh.isEnabled()))
    {
      AppMethodBeat.o(221019);
      return true;
    }
    AppMethodBeat.o(221019);
    return false;
  }
  
  private void TN()
  {
    AppMethodBeat.i(221078);
    if (!this.cJi)
    {
      Log.d("TXLivePusherJSAdapter", "applyWeEffect");
      this.cIB.setCustomModeType(256);
      this.cIC.setConfig(this.cIB);
      this.cIC.setVideoProcessListener(this.cJh);
      this.cJi = true;
    }
    AppMethodBeat.o(221078);
  }
  
  private void a(Bundle paramBundle, String paramString, m.a parama)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(221065);
    if (!paramBundle.containsKey(paramString))
    {
      Log.d("TXLivePusherJSAdapter", "applyFaceBeautyIfNeed, %s is not exist in params", new Object[] { paramString });
      AppMethodBeat.o(221065);
      return;
    }
    float f2 = paramBundle.getFloat(paramString, 0.0F);
    if (f2 < 0.0F) {
      Log.i("TXLivePusherJSAdapter", "applyFaceBeautyIfNeed, rate(%f) of %s is illegal", new Object[] { Float.valueOf(f2), paramString });
    }
    for (;;)
    {
      f2 = f1;
      if (f1 > 1.0F)
      {
        Log.i("TXLivePusherJSAdapter", "applyFaceBeautyIfNeed, rate(%f) of %s is illegal", new Object[] { Float.valueOf(f1), paramString });
        f2 = 1.0F;
      }
      TN();
      Log.d("TXLivePusherJSAdapter", "applyFaceBeauty, faceBeautyType: %s, rate: %f", new Object[] { parama, Float.valueOf(f2) });
      this.cJh.a(parama, f2);
      AppMethodBeat.o(221065);
      return;
      f1 = f2;
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(221001);
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0))
    {
      AppMethodBeat.o(221001);
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
      label723:
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
            break label2043;
          }
          this.cIB.setAudioSampleRate(16000);
        }
      }
      else
      {
        int i3 = paramBundle.getInt("focusMode", this.cIO);
        localObject2 = this.cIB;
        if (i3 == 0) {
          break label2066;
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
            break label2072;
          }
          m(this.mLastAngle, (String)localObject2);
          this.cIC.setRenderRotation(90);
        }
        str1 = paramBundle.getString("localMirror", this.cJa);
        if (!str1.equalsIgnoreCase(this.cJa))
        {
          if (!str1.equalsIgnoreCase("auto")) {
            break label2103;
          }
          this.cIB.setLocalVideoMirrorType(0);
        }
        String str2 = paramBundle.getString("backgroundImage", this.cIV);
        Object localObject3 = BitmapFactory.decodeFile(str2);
        if (localObject3 != null) {
          this.cIB.setPauseImg((Bitmap)localObject3);
        }
        boolean bool3 = paramBundle.getBoolean("backgroundMute", this.cIW);
        if (i2 != 6) {
          break label2147;
        }
        this.cIB.setPauseFlag(1);
        boolean bool4 = paramBundle.getBoolean("zoom", this.mEnableZoom);
        this.cIB.setEnableZoom(bool4);
        f1 = paramBundle.getFloat("watermarkLeft", this.cJb);
        f2 = paramBundle.getFloat("watermarkTop", this.cJc);
        f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
        localObject3 = paramBundle.getString("watermarkImage", this.cJd);
        localObject4 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject4 == null) {
          break label2158;
        }
        this.cIB.setWatermark((Bitmap)localObject4, f1, f2, f3);
        label822:
        boolean bool5 = paramBundle.getBoolean("enableAGC", this.mEnableAgc);
        this.cIB.enableAGC(bool5);
        boolean bool6 = paramBundle.getBoolean("enableANS", this.mEnableAns);
        this.cIB.enableANS(bool6);
        boolean bool7 = paramBundle.getBoolean("enableEarMonitor", this.cJe);
        this.cIB.enableAudioEarMonitoring(bool7);
        localObject4 = paramBundle.getString("audioVolumeType", this.cJf);
        if (!((String)localObject4).equalsIgnoreCase("voicecall")) {
          break label2200;
        }
        this.cIB.setVolumeType(2);
        label920:
        boolean bool8 = paramBundle.getBoolean("enableCamera", this.cIP);
        Object localObject5 = this.cIB;
        if (bool8) {
          break label2233;
        }
        bool2 = true;
        label947:
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
            break label2239;
          }
          TL();
          co(true);
        }
        label1221:
        if (!paramBundle.keySet().contains("enableMic")) {
          break label2268;
        }
        boolean bool9 = paramBundle.getBoolean("enableMic", this.cIQ);
        if (bool9 != this.cIQ)
        {
          if (!bool9) {
            break label2246;
          }
          this.cIC.stopAudioRecord();
          cp(true);
        }
        label1275:
        if ((paramBoolean) || (bool9 != this.cIQ))
        {
          localObject5 = this.cIC;
          if (bool9) {
            break label2256;
          }
          bool2 = true;
          ((WXLivePusher)localObject5).setMute(bool2);
          if (bool9) {
            break label2262;
          }
          bool2 = true;
          this.mMute = bool2;
        }
        label1302:
        label1317:
        this.cIQ = bool9;
        label1329:
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
          break label2369;
        }
        bool1 = paramBundle.getBoolean("remoteMirror");
        label1526:
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
            break label2396;
          }
          this.cIC.setBeautyFilter(1, i, j, 2);
        }
        label1649:
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
            break label2413;
          }
        }
      }
      label2066:
      label2072:
      label2103:
      label2147:
      label2413:
      for (i = 300;; i = 0)
      {
        ((WXLivePusher)localObject1).enableAudioVolumeEvaluation(i);
        this.cGl = bool1;
        bool1 = paramBundle.getBoolean("debug", this.cGn);
        if ((paramBoolean) || (bool1 != this.cGn)) {
          this.cIC.showDebugLog(bool1);
        }
        this.cGn = bool1;
        this.cJj = paramBundle.getBoolean("customEffect", this.cJj);
        if (TM())
        {
          Log.i("TXLivePusherJSAdapter", "parseAndApplyParams, useCustomEffect");
          v(paramBundle);
          w(paramBundle);
          x(paramBundle);
          y(paramBundle);
        }
        AppMethodBeat.o(221001);
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
        label2043:
        if (!((String)localObject1).equalsIgnoreCase("high")) {
          break label460;
        }
        this.cIB.setAudioSampleRate(48000);
        break label460;
        bool1 = false;
        break label487;
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
        this.cIB.setPauseFlag(3);
        break label723;
        label2158:
        if ((!this.cIC.isPushing()) || (!paramBundle.keySet().contains("watermarkImage"))) {
          break label822;
        }
        this.cIB.setWatermark((Bitmap)localObject4, f1, f2, f3);
        break label822;
        if (((String)localObject4).equalsIgnoreCase("media"))
        {
          this.cIB.setVolumeType(1);
          break label920;
        }
        this.cIB.setVolumeType(0);
        break label920;
        bool2 = false;
        break label947;
        TL();
        break label1221;
        this.cIC.stopAudioRecord();
        break label1275;
        bool2 = false;
        break label1302;
        bool2 = false;
        break label1317;
        if (!paramBundle.keySet().contains("muted")) {
          break label1329;
        }
        bool2 = paramBundle.getBoolean("muted", this.mMute);
        if (!this.cIQ)
        {
          Log.i("TXLivePusherJSAdapter", String.format("parseAndApplyParams, enableMic: %b, mute: %b", new Object[] { Boolean.FALSE, Boolean.valueOf(this.mMute) }));
          bool2 = true;
        }
        if ((paramBoolean) || (bool2 != this.mMute)) {
          this.cIC.setMute(bool2);
        }
        this.mMute = bool2;
        break label1329;
        if (!paramBundle.keySet().contains("mirror")) {
          break label1526;
        }
        bool1 = paramBundle.getBoolean("mirror");
        break label1526;
        this.cIC.setBeautyFilter(0, i, j, 2);
        break label1649;
      }
      label2200:
      label2233:
      label2239:
      label2246:
      label2256:
      label2262:
      label2268:
      label2396:
      k = i;
      label2369:
      i = j;
    }
  }
  
  public static void a(n.b paramb)
  {
    cJk = paramb;
  }
  
  private static float b(JSONObject paramJSONObject, String paramString)
  {
    float f2 = 1.0F;
    float f1 = 0.0F;
    AppMethodBeat.i(221052);
    float f3 = (float)paramJSONObject.optDouble(paramString, 1.0D);
    if (f3 < 0.0F) {
      Log.i("TXLivePusherJSAdapter", "parseAlpha, alpha(%f) is illegal", new Object[] { Float.valueOf(f3) });
    }
    for (;;)
    {
      if (f1 > 1.0F)
      {
        Log.i("TXLivePusherJSAdapter", "parseAlpha, alpha(%f)  is illegal", new Object[] { Float.valueOf(f1) });
        f1 = f2;
      }
      for (;;)
      {
        AppMethodBeat.o(221052);
        return f1;
      }
      f1 = f3;
    }
  }
  
  private void co(boolean paramBoolean)
  {
    AppMethodBeat.i(220860);
    if ((!this.cIE) && (paramBoolean))
    {
      if (this.mVideoView != null) {
        this.mVideoView.setVisibility(0);
      }
      if (this.mSurface != null) {
        this.cIC.setSurface(this.mSurface);
      }
      this.cIC.startCameraPreview(this.mVideoView);
      this.cIE = true;
    }
    AppMethodBeat.o(220860);
  }
  
  private void cp(boolean paramBoolean)
  {
    AppMethodBeat.i(220864);
    if (paramBoolean) {
      this.cIC.startAudioRecord();
    }
    AppMethodBeat.o(220864);
  }
  
  private void m(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(220791);
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
        this.cIB.setHomeOrientation(paramInt);
        this.cIC.setConfig(this.cIB);
      }
      AppMethodBeat.o(220791);
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
  
  private boolean p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(221047);
    if (!TM())
    {
      Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, useCustomEffect is false");
      AppMethodBeat.o(221047);
      return false;
    }
    m.c localc = r(paramJSONObject);
    if (localc == null)
    {
      Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, stickerType is null");
      AppMethodBeat.o(221047);
      return false;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("stickers");
    int j;
    if (localJSONArray != null)
    {
      j = localJSONArray.length();
      if (j != 0) {}
    }
    else
    {
      Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, stickersJsonArr is empty");
      AppMethodBeat.o(221047);
      return false;
    }
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = localJSONArray.optJSONObject(i);
      if (localJSONObject == null)
      {
        Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, stickerJsonObj(%d) is null", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(221047);
        return false;
      }
      try
      {
        String str1 = localJSONObject.getString("title");
        int k = localJSONObject.getInt("len");
        String str2 = localJSONObject.getString("path");
        if (Util.isNullOrNil(str2))
        {
          Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, resDirPath is empty", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(221047);
          return false;
        }
        String str3 = localJSONObject.optString("md5", "");
        paramJSONObject = null;
        if ((m.c.cHt == localc) || (m.c.cHs == localc))
        {
          paramJSONObject = localJSONObject.getJSONArray("pos");
          if (4 != paramJSONObject.length())
          {
            Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, length of posJsonArr is not 4", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(221047);
            return false;
          }
          paramJSONObject = new StickerItemInfo.a(paramJSONObject.getDouble(0), paramJSONObject.getDouble(1), paramJSONObject.getDouble(2), paramJSONObject.getDouble(3));
        }
        Object localObject1 = StickerItemInfo.StickerBackType.BACKGROUND;
        if (m.c.cHr == localc)
        {
          localObject2 = StickerItemInfo.StickerBackType.from(localJSONObject.getInt("segtype"));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, type is null", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(221047);
            return false;
          }
        }
        int m = localJSONObject.optInt("active", StickerItemInfo.TriggerAction.DEFAULT_ACTION_LOOP.getJsonVal());
        Object localObject2 = StickerItemInfo.TriggerAction.from(m);
        if (localObject2 == null)
        {
          Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, actionInt: %d, action is null", new Object[] { Integer.valueOf(i), Integer.valueOf(m) });
          AppMethodBeat.o(221047);
          return false;
        }
        localArrayList.add(new StickerItemInfo(localJSONObject.optInt("id", i), str1, k, (StickerItemInfo.TriggerAction)localObject2, str2, str3, paramJSONObject, (StickerItemInfo.StickerBackType)localObject1));
        i += 1;
      }
      catch (Exception paramJSONObject)
      {
        Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, convert fail since %s", new Object[] { Integer.valueOf(i), paramJSONObject });
        AppMethodBeat.o(221047);
        return false;
      }
    }
    TN();
    Log.d("TXLivePusherJSAdapter", "applyStickerWorkaround, stickerType: %s", new Object[] { localc });
    boolean bool = this.cJh.a(localc, localArrayList);
    AppMethodBeat.o(221047);
    return bool;
  }
  
  private static o.a q(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(221057);
    paramJSONObject = paramJSONObject.optString("color");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("TXLivePusherJSAdapter", "parseColor, colorStr is empty");
      AppMethodBeat.o(221057);
      return null;
    }
    try
    {
      int i = Color.parseColor(paramJSONObject);
      paramJSONObject = new o.a(Color.red(i), Color.green(i), Color.blue(i));
      AppMethodBeat.o(221057);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      Log.w("TXLivePusherJSAdapter", "parseColor, colorStr is illegal");
      AppMethodBeat.o(221057);
    }
    return null;
  }
  
  private static void q(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(221017);
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
    AppMethodBeat.o(221017);
  }
  
  private static m.c r(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(221070);
    paramJSONObject = paramJSONObject.optString("stickerType", null);
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("TXLivePusherJSAdapter", "parseStickerType, stickerTypeStr is empty");
      AppMethodBeat.o(221070);
      return null;
    }
    if (paramJSONObject.equalsIgnoreCase("back"))
    {
      paramJSONObject = m.c.cHr;
      AppMethodBeat.o(221070);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("front"))
    {
      paramJSONObject = m.c.cHs;
      AppMethodBeat.o(221070);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("2d"))
    {
      paramJSONObject = m.c.cHt;
      AppMethodBeat.o(221070);
      return paramJSONObject;
    }
    Log.w("TXLivePusherJSAdapter", "parseStickerType, stickerTypeStr: ".concat(String.valueOf(paramJSONObject)));
    AppMethodBeat.o(221070);
    return null;
  }
  
  private static m.b s(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(221073);
    paramJSONObject = paramJSONObject.optString("makeupType", null);
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("TXLivePusherJSAdapter", "parseMakeupType, makeupTypeStr is empty");
      AppMethodBeat.o(221073);
      return null;
    }
    if (paramJSONObject.equalsIgnoreCase("lipStick"))
    {
      paramJSONObject = m.b.cHl;
      AppMethodBeat.o(221073);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("eyeShadow"))
    {
      paramJSONObject = m.b.cHm;
      AppMethodBeat.o(221073);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("blusherStick"))
    {
      paramJSONObject = m.b.cHn;
      AppMethodBeat.o(221073);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("faceContour"))
    {
      paramJSONObject = m.b.cHo;
      AppMethodBeat.o(221073);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("eyeBrow"))
    {
      paramJSONObject = m.b.cHp;
      AppMethodBeat.o(221073);
      return paramJSONObject;
    }
    Log.w("TXLivePusherJSAdapter", "parseMakeupType, makeupTypeStr: ".concat(String.valueOf(paramJSONObject)));
    AppMethodBeat.o(221073);
    return null;
  }
  
  private void v(Bundle paramBundle)
  {
    AppMethodBeat.i(221020);
    a(paramBundle, "skinWhiteness", m.a.cHg);
    AppMethodBeat.o(221020);
  }
  
  private void w(Bundle paramBundle)
  {
    AppMethodBeat.i(221022);
    a(paramBundle, "skinSmoothness", m.a.cHh);
    AppMethodBeat.o(221022);
  }
  
  private void x(Bundle paramBundle)
  {
    AppMethodBeat.i(221024);
    a(paramBundle, "faceThinness", m.a.cHi);
    AppMethodBeat.o(221024);
  }
  
  private void y(Bundle paramBundle)
  {
    AppMethodBeat.i(221025);
    a(paramBundle, "eyeBigness", m.a.cHj);
    AppMethodBeat.o(221025);
  }
  
  public final k TK()
  {
    AppMethodBeat.i(220869);
    k localk;
    if (!this.mInited)
    {
      localk = new k(-3, "uninited livePusher");
      AppMethodBeat.o(220869);
      return localk;
    }
    try
    {
      this.cIC.stopBGM();
      TL();
      this.cIC.stopAudioRecord();
      this.cIC.stopPusher();
      this.cIC.setPushListener(null);
      this.mInited = false;
      localk = new k();
      AppMethodBeat.o(220869);
      return localk;
    }
    finally
    {
      AppMethodBeat.o(220869);
    }
  }
  
  public final void Tp()
  {
    AppMethodBeat.i(220878);
    if (this.mLivePushListener != null)
    {
      Log.i("TXLivePusherJSAdapter", "sendHandupStop, send event 5000");
      this.mLivePushListener.onPushEvent(5000, new Bundle());
    }
    AppMethodBeat.o(220878);
  }
  
  public final void Tq()
  {
    AppMethodBeat.i(220880);
    if (this.mLivePushListener != null)
    {
      Log.i("TXLivePusherJSAdapter", "sendWeChatStop, send event 5001");
      this.mLivePushListener.onPushEvent(5001, new Bundle());
    }
    AppMethodBeat.o(220880);
  }
  
  public final k Ty()
  {
    AppMethodBeat.i(220882);
    if (this.cIG)
    {
      if (this.cIH)
      {
        localk = e("start", null);
        AppMethodBeat.o(220882);
        return localk;
      }
      localk = e("resume", null);
      AppMethodBeat.o(220882);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(220882);
    return localk;
  }
  
  public final k b(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(220804);
    if ((paramTXCloudVideoView == null) || (paramBundle == null))
    {
      paramTXCloudVideoView = new k(-1, "invalid params");
      AppMethodBeat.o(220804);
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
      Log.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
      co(this.cIP);
      cp(this.cIQ);
      this.cIC.startPusher(this.cID);
    }
    this.mInited = true;
    paramTXCloudVideoView = new k();
    AppMethodBeat.o(220804);
    return paramTXCloudVideoView;
  }
  
  public final k cn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220871);
    this.cIC.setSurfaceSize(paramInt1, paramInt2);
    k localk = new k();
    AppMethodBeat.o(220871);
    return localk;
  }
  
  public final k cn(boolean paramBoolean)
  {
    AppMethodBeat.i(220877);
    this.cIG = this.cIC.isPushing();
    if (this.cIG)
    {
      if (paramBoolean)
      {
        this.cIH = paramBoolean;
        localk = e("stop", null);
        AppMethodBeat.o(220877);
        return localk;
      }
      localk = e("pause", null);
      AppMethodBeat.o(220877);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(220877);
    return localk;
  }
  
  public final k e(Surface paramSurface)
  {
    AppMethodBeat.i(220870);
    this.mSurface = paramSurface;
    this.cIC.setSurface(paramSurface);
    paramSurface = new k();
    AppMethodBeat.o(220870);
    return paramSurface;
  }
  
  public final k e(final String paramString, JSONObject paramJSONObject)
  {
    int m = 1;
    int i4 = 1;
    int i5 = 1;
    int i6 = 1;
    int i = 1;
    int i7 = 1;
    final boolean bool1 = true;
    String str3 = null;
    String str4 = null;
    String str1 = null;
    String str2 = null;
    Object localObject2 = null;
    int i8 = 0;
    int i9 = 0;
    int j = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int k = 0;
    int i3 = 0;
    boolean bool2 = false;
    AppMethodBeat.i(220855);
    if (paramString == null)
    {
      paramString = new k(-1, "invalid params");
      AppMethodBeat.o(220855);
      return paramString;
    }
    if (!this.mInited)
    {
      paramString = new k(-3, "uninited livePusher");
      AppMethodBeat.o(220855);
      return paramString;
    }
    Object localObject1 = "";
    if (paramJSONObject != null) {
      localObject1 = paramJSONObject.toString();
    }
    Log.i("TXLivePusherJSAdapter", "operateLivePusher: type = " + paramString + " params = " + (String)localObject1);
    if (paramString.equalsIgnoreCase("start")) {
      if ((this.cID != null) && (!this.cID.isEmpty()) && (!this.cIC.isPushing()))
      {
        co(this.cIP);
        cp(this.cIQ);
        if ((this.cIP) && (this.mSurface != null)) {
          this.cIC.setSurface(this.mSurface);
        }
        this.cIC.startPusher(this.cID);
      }
    }
    for (;;)
    {
      paramString = new k();
      AppMethodBeat.o(220855);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.cIX = false;
        try
        {
          this.cIC.stopBGM();
          TL();
          this.cIC.stopAudioRecord();
          this.cIC.stopPusher();
          continue;
        }
        finally
        {
          paramString = finally;
          AppMethodBeat.o(220855);
          throw paramString;
        }
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
          Log.i("TXLivePusherJSAdapter", "do not support startPreview when pushing");
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
          Log.i("TXLivePusherJSAdapter", "do not support stopPreview when pushing");
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
                AppMethodBeat.i(222380);
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
                      t.m(paramAnonymousBitmap);
                      AppMethodBeat.o(222380);
                      return;
                    }
                    paramString.onSnapshot(paramAnonymousBitmap);
                    AppMethodBeat.o(222380);
                    return;
                  }
                  paramString.onSnapshot(paramAnonymousBitmap);
                }
                AppMethodBeat.o(222380);
              }
            });
          }
        }
        else
        {
          if (paramString.equalsIgnoreCase("toggleTorch"))
          {
            if (!this.cIX)
            {
              bool2 = this.cIC.turnOnFlashLight(bool1);
              if (!bool2) {
                break label755;
              }
              label706:
              this.cIX = bool1;
              if (!bool2) {
                break label764;
              }
              i = i8;
              label721:
              if (!bool2) {
                break label771;
              }
            }
            label771:
            for (paramString = "Success";; paramString = "Failed")
            {
              paramString = new k(i, paramString);
              AppMethodBeat.o(220855);
              return paramString;
              bool1 = false;
              break;
              label755:
              bool1 = this.cIX;
              break label706;
              label764:
              i = -2;
              break label721;
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
              this.cIC.playBGM(paramString);
            }
            else
            {
              paramString = new k(-2, "fail");
              AppMethodBeat.o(220855);
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
          else if (paramString.equalsIgnoreCase("resumeBGM"))
          {
            this.cIC.resumeBGM();
            this.cII = true;
          }
          else
          {
            double d;
            if (paramString.equalsIgnoreCase("setBGMVolume"))
            {
              d = 1.0D;
              if (paramJSONObject != null) {
                d = paramJSONObject.optDouble("volume", 1.0D);
              }
              this.cIC.setBGMVolume((float)d);
            }
            else
            {
              if (!paramString.equalsIgnoreCase("setMICVolume")) {
                break;
              }
              d = 1.0D;
              if (paramJSONObject != null) {
                d = paramJSONObject.optDouble("volume", 1.0D);
              }
              this.cIC.setMicVolume((float)d);
            }
          }
        }
      }
    }
    if (paramString.equalsIgnoreCase("sendMessage"))
    {
      paramString = localObject2;
      if (paramJSONObject != null) {
        paramString = paramJSONObject.optString("msg");
      }
      if (paramString != null)
      {
        bool1 = this.cIC.sendMessageEx(paramString.getBytes());
        if (bool1)
        {
          i = i9;
          if (!bool1) {
            break label1105;
          }
        }
        label1105:
        for (paramString = "Success";; paramString = "Failed")
        {
          paramString = new k(i, paramString);
          AppMethodBeat.o(220855);
          return paramString;
          i = -2;
          break;
        }
      }
      paramString = new k(-2, "fail");
      AppMethodBeat.o(220855);
      return paramString;
    }
    label1175:
    label1180:
    float f2;
    float f1;
    if (paramString.equalsIgnoreCase("applyFilter"))
    {
      if (paramJSONObject != null) {
        if (!TM())
        {
          Log.w("TXLivePusherJSAdapter", "applyFilter, useCustomEffect is false");
          i = 0;
          if (i == 0) {
            break label1367;
          }
          i = m;
          if (i == 0) {
            break label1373;
          }
          if (i == 0) {
            break label1380;
          }
        }
      }
      label1367:
      label1373:
      label1380:
      for (paramString = "Success";; paramString = "Failed")
      {
        paramString = new k(j, paramString);
        AppMethodBeat.o(220855);
        return paramString;
        paramString = paramJSONObject.optString("path", null);
        if (Util.isNullOrNil(paramString))
        {
          Log.w("TXLivePusherJSAdapter", "applyFilter, resourcePath is null");
          i = 0;
          break;
        }
        f2 = (float)paramJSONObject.optDouble("alpha", 1.0D);
        f1 = f2;
        if (f2 < 0.0F)
        {
          Log.i("TXLivePusherJSAdapter", "applyFaceBeautyIfNeed, alpha(%f) is illegal", new Object[] { Float.valueOf(f2) });
          f1 = 0.0F;
        }
        f2 = f1;
        if (f1 > 1.0F)
        {
          Log.i("TXLivePusherJSAdapter", "applyFaceBeautyIfNeed, alpha(%f)  is illegal", new Object[] { Float.valueOf(f1) });
          f2 = 1.0F;
        }
        TN();
        Log.d("TXLivePusherJSAdapter", "applyFilter, resourcePath: %s, alpha: %f", new Object[] { paramString, Float.valueOf(f2) });
        this.cJh.b(paramString, f2);
        i = 1;
        break;
        i = 0;
        break label1175;
        j = -2;
        break label1180;
      }
    }
    if (paramString.equalsIgnoreCase("clearFilters"))
    {
      if (!TM())
      {
        Log.w("TXLivePusherJSAdapter", "clearFilters, useCustomEffect is false");
        i = 0;
        if (i == 0) {
          break label1482;
        }
        j = n;
        label1425:
        if (i == 0) {
          break label1489;
        }
      }
      label1482:
      label1489:
      for (paramString = "Success";; paramString = "Failed")
      {
        paramString = new k(j, paramString);
        AppMethodBeat.o(220855);
        return paramString;
        TN();
        Log.d("TXLivePusherJSAdapter", "clearFilters");
        this.cJh.clearFilters();
        i = i4;
        break;
        j = -2;
        break label1425;
      }
    }
    if (paramString.equalsIgnoreCase("applySticker"))
    {
      if (paramJSONObject != null) {
        if (!TM())
        {
          Log.w("TXLivePusherJSAdapter", "applySticker, useCustomEffect is false");
          bool1 = false;
          if (!bool1) {
            break label1676;
          }
          i = i5;
          label1538:
          if (i == 0) {
            break label1682;
          }
          j = i1;
          label1547:
          if (i == 0) {
            break label1689;
          }
        }
      }
      label1676:
      label1682:
      label1689:
      for (paramString = "Success";; paramString = "Failed")
      {
        paramString = new k(j, paramString);
        AppMethodBeat.o(220855);
        return paramString;
        paramString = paramJSONObject.optString("path", null);
        if (Util.isNullOrNil(paramString))
        {
          Log.i("TXLivePusherJSAdapter", "applySticker, resourcePath is null");
          bool1 = p(paramJSONObject);
          break;
        }
        paramJSONObject = r(paramJSONObject);
        if (paramJSONObject == null)
        {
          Log.w("TXLivePusherJSAdapter", "applySticker, stickerType is null");
          bool1 = false;
          break;
        }
        TN();
        Log.d("TXLivePusherJSAdapter", "applySticker, stickerType: %s, resourcePath: %s", new Object[] { paramJSONObject, paramString });
        this.cJh.a(paramJSONObject, paramString);
        bool1 = true;
        break;
        i = 0;
        break label1538;
        j = -2;
        break label1547;
      }
    }
    if (paramString.equalsIgnoreCase("clearStickers"))
    {
      if (!TM())
      {
        Log.w("TXLivePusherJSAdapter", "clearStickers, useCustomEffect is false");
        i = 0;
        if (i == 0) {
          break label1791;
        }
        j = i2;
        label1734:
        if (i == 0) {
          break label1798;
        }
      }
      label1798:
      for (paramString = "Success";; paramString = "Failed")
      {
        paramString = new k(j, paramString);
        AppMethodBeat.o(220855);
        return paramString;
        TN();
        Log.d("TXLivePusherJSAdapter", "clearStickers");
        this.cJh.TG();
        i = i6;
        break;
        label1791:
        j = -2;
        break label1734;
      }
    }
    label2311:
    label2954:
    if (paramString.equalsIgnoreCase("applyMakeup"))
    {
      if (paramJSONObject != null) {
        if (!TM())
        {
          Log.w("TXLivePusherJSAdapter", "applyMakeup, useCustomEffect is false");
          bool1 = false;
          if (!bool1) {
            break label2948;
          }
          label1843:
          if (i == 0) {
            break label2954;
          }
          j = k;
          label1852:
          if (i == 0) {
            break label2961;
          }
        }
      }
      label2192:
      label2961:
      for (paramString = "Success";; paramString = "Failed")
      {
        paramString = new k(j, paramString);
        AppMethodBeat.o(220855);
        return paramString;
        paramString = paramJSONObject.optString("path", null);
        if (Util.isNullOrNil(paramString))
        {
          Log.i("TXLivePusherJSAdapter", "applyMakeup, resourcePath is null");
          if (!TM())
          {
            Log.w("TXLivePusherJSAdapter", "applyMakeupWorkaround, useCustomEffect is false");
            bool1 = false;
            break;
          }
          localObject1 = s(paramJSONObject);
          if (localObject1 == null)
          {
            Log.w("TXLivePusherJSAdapter", "applyMakeupWorkaround, makeupType is null");
            bool1 = false;
            break;
          }
          paramString = paramJSONObject.optJSONObject("makeup");
          if (paramString == null)
          {
            Log.w("TXLivePusherJSAdapter", "applyMakeupWorkaround, makeupJsonObj is null");
            bool1 = false;
            break;
          }
          TN();
          Log.d("TXLivePusherJSAdapter", "applyMakeupWorkaround, makeupType: %s", new Object[] { localObject1 });
          switch (4.cJm[localObject1.ordinal()])
          {
          default: 
            Log.w("TXLivePusherJSAdapter", "applyMakeupWorkaround, should not reach");
            bool1 = false;
            break;
          case 1: 
            f1 = b(paramString, "alpha");
            paramJSONObject = q(paramString);
            if (paramJSONObject == null)
            {
              Log.w("TXLivePusherJSAdapter", "parseLipStickInfo, color is null");
              paramString = str3;
            }
            for (;;)
            {
              if (paramString != null) {
                break label2192;
              }
              Log.w("TXLivePusherJSAdapter", "applyMakeupWorkaround, lipStickInfo is null");
              bool1 = false;
              break;
              localObject1 = o.b.jd(paramString.optInt("lipstickType", 0));
              if (localObject1 == null)
              {
                Log.w("TXLivePusherJSAdapter", "parseLipStickInfo, type is null");
                paramString = str3;
              }
              else
              {
                j = paramString.optInt("faceModel", 0);
                if (j != 0)
                {
                  Log.w("TXLivePusherJSAdapter", "parseLipStickInfo, faceModel is illegal");
                  paramString = str3;
                }
                else
                {
                  paramString = new o(f1, paramJSONObject, (o.b)localObject1, j, o.c.cHP);
                }
              }
            }
            bool1 = this.cJh.a(paramString);
            break;
          case 2: 
            f1 = b(paramString, "alpha");
            paramJSONObject = paramString.optString("leftPath", "");
            if (Util.isNullOrNil(paramJSONObject)) {
              Log.w("TXLivePusherJSAdapter", "parseEyeShadowInfo, leftPath is empty");
            }
            for (paramString = str4;; paramString = new c(f1, paramJSONObject, (String)localObject1, paramJSONObject, (String)localObject1, paramString.optString("shimmerPosition", null), paramString.optString("shimmerPositionMD5", "")))
            {
              if (paramString != null) {
                break label2311;
              }
              Log.w("TXLivePusherJSAdapter", "applyMakeupWorkaround, eyeShadowInfo is null");
              bool1 = false;
              break;
              localObject1 = paramString.optString("leftPathMD5", "");
            }
            bool1 = this.cJh.a(paramString);
            break;
          case 3: 
            f1 = b(paramString, "alpha");
            paramJSONObject = a.a.cGJ;
            localObject1 = paramString.optString("leftPath", "");
            if (Util.isNullOrNil((String)localObject1))
            {
              Log.w("TXLivePusherJSAdapter", "parseBlusherStickInfo, leftPath is empty");
              paramString = str1;
            }
            for (;;)
            {
              if (paramString != null) {
                break label2499;
              }
              Log.w("TXLivePusherJSAdapter", "applyMakeupWorkaround, blusherStickInfo is null");
              bool1 = false;
              break;
              str2 = paramString.optString("leftPathMD5", "");
              str3 = paramString.optString("rightPath", "");
              if (Util.isNullOrNil(str3))
              {
                Log.w("TXLivePusherJSAdapter", "parseBlusherStickInfo, rightPath is empty");
                paramString = str1;
              }
              else
              {
                str4 = paramString.optString("rightPathMD5", "");
                j = paramString.optInt("faceModel", 0);
                if (j != 0)
                {
                  Log.w("TXLivePusherJSAdapter", "parseBlusherStickInfo, faceModel is illegal");
                  paramString = str1;
                }
                else
                {
                  paramString = new a(f1, paramJSONObject, (String)localObject1, str2, str3, str4, j);
                }
              }
            }
            bool1 = this.cJh.a(paramString);
            break;
          case 4: 
            f1 = b(paramString, "highlightAlpha");
            f2 = b(paramString, "shadowAlpha");
            paramJSONObject = paramString.optString("highlightPath", "");
            if (Util.isNullOrNil(paramJSONObject))
            {
              Log.w("TXLivePusherJSAdapter", "parseFaceContourInfo, highLightPath is empty");
              paramString = str2;
            }
            for (;;)
            {
              if (paramString != null) {
                break label2690;
              }
              Log.w("TXLivePusherJSAdapter", "applyMakeupWorkaround, faceContourInfo is null");
              bool1 = false;
              break;
              localObject1 = paramString.optString("highlightPathMD5", "");
              str1 = paramString.optString("shadowPath", "");
              if (Util.isNullOrNil(str1))
              {
                Log.w("TXLivePusherJSAdapter", "parseFaceContourInfo, shadowPath is empty");
                paramString = str2;
              }
              else
              {
                str3 = paramString.optString("shadowPathMD5", "");
                j = paramString.optInt("faceModel", 0);
                if (j != 0)
                {
                  Log.w("TXLivePusherJSAdapter", "parseFaceContourInfo, faceModel is illegal");
                  paramString = str2;
                }
                else
                {
                  paramString = new d(f1, f2, paramJSONObject, (String)localObject1, str1, str3, j);
                }
              }
            }
            bool1 = this.cJh.a(paramString);
            break;
          case 5: 
            label2499:
            f1 = b(paramString, "alpha");
            paramJSONObject = paramString.optString("leftPath", "");
            if (Util.isNullOrNil(paramJSONObject))
            {
              Log.w("TXLivePusherJSAdapter", "parseEyeBrowInfo, leftPath is empty");
              paramString = null;
            }
            for (;;)
            {
              if (paramString != null) {
                break label2867;
              }
              Log.w("TXLivePusherJSAdapter", "applyMakeupWorkaround, eyeBrowInfo is null");
              bool1 = false;
              break;
              localObject1 = paramString.optString("leftPathMD5", "");
              str1 = paramString.optString("rightPath", "");
              if (Util.isNullOrNil(str1))
              {
                Log.w("TXLivePusherJSAdapter", "parseEyeBrowInfo, rightPath is empty");
                paramString = null;
              }
              else
              {
                str2 = paramString.optString("rightPathMD5", "");
                j = paramString.optInt("faceModel", 0);
                if (j != 0)
                {
                  Log.w("TXLivePusherJSAdapter", "parseEyeBrowInfo, faceModel is illegal");
                  paramString = null;
                }
                else
                {
                  paramString = new b(f1, paramJSONObject, (String)localObject1, str1, str2, j);
                }
              }
            }
            label2867:
            bool1 = this.cJh.a(paramString);
            break;
          }
        }
        paramJSONObject = s(paramJSONObject);
        if (paramJSONObject == null)
        {
          Log.w("TXLivePusherJSAdapter", "applyMakeup, makeupType is null");
          bool1 = false;
          break;
        }
        TN();
        Log.d("TXLivePusherJSAdapter", "applyMakeup, makeupType: %s, resourcePath: %s", new Object[] { paramJSONObject, paramString });
        this.cJh.a(paramJSONObject, paramString);
        bool1 = true;
        break;
        i = 0;
        break label1843;
        j = -2;
        break label1852;
      }
    }
    label2690:
    label2948:
    if (paramString.equalsIgnoreCase("clearMakeups"))
    {
      if (!TM())
      {
        Log.w("TXLivePusherJSAdapter", "clearMakeups, useCustomEffect is false");
        i = 0;
        if (i == 0) {
          break label3063;
        }
        j = i3;
        label3006:
        if (i == 0) {
          break label3070;
        }
      }
      label3063:
      label3070:
      for (paramString = "Success";; paramString = "Failed")
      {
        paramString = new k(j, paramString);
        AppMethodBeat.o(220855);
        return paramString;
        TN();
        Log.d("TXLivePusherJSAdapter", "clearMakeups");
        this.cJh.TH();
        i = i7;
        break;
        j = -2;
        break label3006;
      }
    }
    paramString = new k(-4, "invalid operate command");
    AppMethodBeat.o(220855);
    return paramString;
  }
  
  public final int getMaxZoom()
  {
    AppMethodBeat.i(220874);
    if (this.cIC != null)
    {
      int i = this.cIC.getMaxZoom();
      AppMethodBeat.o(220874);
      return i;
    }
    AppMethodBeat.o(220874);
    return 0;
  }
  
  public final k jc(int paramInt)
  {
    AppMethodBeat.i(220873);
    this.cIC.setZoom(paramInt);
    k localk = new k();
    AppMethodBeat.o(220873);
    return localk;
  }
  
  public final void notifyOrientationChanged(final int paramInt)
  {
    AppMethodBeat.i(220785);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224743);
        t.a(t.this, paramInt);
        Log.i("TXLivePusherJSAdapter", "notifyOrientationChanged, angle:" + paramInt + ", orientation:" + t.a(t.this));
        t.a(t.this, paramInt, t.a(t.this));
        AppMethodBeat.o(224743);
      }
    });
    AppMethodBeat.o(220785);
  }
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(220919);
    if ((this.cGl) && (this.mAudioVolumeListener != null)) {
      this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(220919);
  }
  
  public final void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(220915);
    this.cII = false;
    if ((this.cIY) && (this.mBGMNotifyListener != null)) {
      this.mBGMNotifyListener.onBGMComplete(paramInt);
    }
    AppMethodBeat.o(220915);
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(220912);
    if ((this.cIY) && (this.mBGMNotifyListener != null)) {
      this.mBGMNotifyListener.onBGMProgress(paramLong1, paramLong2);
    }
    AppMethodBeat.o(220912);
  }
  
  public final void onBGMStart()
  {
    AppMethodBeat.i(220909);
    this.cII = true;
    if ((this.cIY) && (this.mBGMNotifyListener != null)) {
      this.mBGMNotifyListener.onBGMStart();
    }
    AppMethodBeat.o(220909);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(220907);
    if (this.mLivePushListener != null) {
      this.mLivePushListener.onNetStatus(paramBundle);
    }
    Log.i("TXLivePusherJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(220907);
  }
  
  public final void onPushEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(220887);
    if ((paramInt == -1307) || (paramInt == -1313))
    {
      Runnable local3 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(225689);
          t.this.e("stop", null);
          AppMethodBeat.o(225689);
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
      AppMethodBeat.o(220887);
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
  
  public final void setThreadHandler(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public final k t(Bundle paramBundle)
  {
    AppMethodBeat.i(220809);
    if (paramBundle == null)
    {
      paramBundle = new k(-1, "invalid params");
      AppMethodBeat.o(220809);
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
    this.cID = paramBundle.getString("pushUrl", "");
    this.cIC.setPusherUrl(this.cID);
    a(paramBundle, true);
    this.cIK = paramBundle.getBoolean("autopush", this.cIK);
    if ((this.cIK) && (this.cID != null) && (!this.cID.isEmpty()) && (!this.cIC.isPushing()))
    {
      Log.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
      co(this.cIP);
      cp(this.cIQ);
      if ((this.cIP) && (this.mSurface != null)) {
        this.cIC.setSurface(this.mSurface);
      }
      this.cIC.startPusher(this.cID);
    }
    this.mInited = true;
    paramBundle = new k();
    AppMethodBeat.o(220809);
    return paramBundle;
  }
  
  public final k u(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(220872);
    this.cIC.setFocusPosition(paramFloat1, paramFloat2);
    k localk = new k();
    AppMethodBeat.o(220872);
    return localk;
  }
  
  public final k u(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(220811);
    if (paramBundle == null)
    {
      paramBundle = new k(-1, "invalid params");
      AppMethodBeat.o(220811);
      return paramBundle;
    }
    q("updateLivePusher", paramBundle);
    if (!this.mInited)
    {
      paramBundle = new k(-3, "uninited livePusher");
      AppMethodBeat.o(220811);
      return paramBundle;
    }
    a(paramBundle, false);
    String str = paramBundle.getString("pushUrl", this.cID);
    if ((str != null) && (!str.isEmpty()) && (this.cID != null) && (!this.cID.equalsIgnoreCase(str)) && (this.cIC.isPushing()))
    {
      Log.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
      TL();
      this.cIC.stopAudioRecord();
      this.cIC.stopPusher();
    }
    this.cID = str;
    this.cIC.setPusherUrl(this.cID);
    this.cIK = paramBundle.getBoolean("autopush", this.cIK);
    if ((this.cIK) && (this.cID != null) && (!this.cID.isEmpty()) && (!this.cIC.isPushing()))
    {
      Log.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
      co(this.cIP);
      if (!this.cIQ) {
        break label322;
      }
      this.cIC.stopAudioRecord();
      cp(true);
      paramBundle = this.cIC;
      if (this.cIQ) {
        break label332;
      }
    }
    for (;;)
    {
      paramBundle.setMute(bool);
      if ((this.cIP) && (this.mSurface != null)) {
        this.cIC.setSurface(this.mSurface);
      }
      this.cIC.startPusher(this.cID);
      paramBundle = new k();
      AppMethodBeat.o(220811);
      return paramBundle;
      label322:
      this.cIC.stopAudioRecord();
      break;
      label332:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.t
 * JD-Core Version:    0.7.0.1
 */