package com.tencent.luggage.k.a.a.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.luggage.k.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
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

public final class b
  implements ITXLivePushListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.OnBGMNotify
{
  private String ciQ;
  private int ciW;
  private String cin;
  private boolean cit;
  private boolean ciu;
  private boolean ciw;
  boolean cjA;
  boolean cjB;
  private String cjC;
  private int cjD;
  private int cjE;
  private String cjF;
  private String cjG;
  private boolean cjH;
  private boolean cjI;
  private boolean cjJ;
  private boolean cjK;
  private String cjL;
  private float cjM;
  private float cjN;
  private String cjO;
  private boolean cjP;
  private String cjQ;
  private int cjR;
  private WXLivePushConfig cjh;
  WXLivePusher cji;
  ITXLivePushListener cjj;
  String cjk;
  private boolean cjl;
  private String cjm;
  boolean cjn;
  boolean cjo;
  TXLivePusher.ITXSnapshotListener cjp;
  TXLivePusher.OnBGMNotify cjq;
  TXLivePusher.ITXAudioVolumeEvaluationListener cjr;
  private boolean cjs;
  private boolean cjt;
  boolean cju;
  private int cjv;
  private int cjw;
  private int cjx;
  private boolean cjy;
  private int cjz;
  private Context mContext;
  private boolean mEnableAgc;
  private boolean mEnableAns;
  private boolean mEnableZoom;
  private boolean mFrontCamera;
  Handler mHandler;
  boolean mInited;
  private int mMode;
  Surface mSurface;
  private int mVideoHeight;
  TXCloudVideoView mVideoView;
  private int mVideoWidth;
  private float mWatermarkWidth;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(138900);
    this.ciW = 0;
    this.mInited = false;
    this.cjl = false;
    this.mFrontCamera = true;
    this.cjm = "front";
    this.cjn = false;
    this.cjo = false;
    this.cjs = false;
    this.cjt = false;
    this.cju = false;
    this.mMode = 1;
    this.cjv = 2;
    this.cjw = -1;
    this.cjx = -1;
    this.cjy = false;
    this.cjz = 0;
    this.cjA = true;
    this.cjB = true;
    this.cin = "vertical";
    this.cjC = "high";
    this.cjD = 5;
    this.cjE = 3;
    this.cjF = "smooth";
    this.ciQ = "";
    this.cjG = "";
    this.cjH = false;
    this.cjI = false;
    this.mEnableZoom = true;
    this.cit = false;
    this.cjJ = false;
    this.ciw = false;
    this.cjK = false;
    this.cjL = "auto";
    this.cjM = 0.0F;
    this.cjN = 0.0F;
    this.mWatermarkWidth = 0.1F;
    this.cjO = "";
    this.mEnableAgc = false;
    this.mEnableAns = false;
    this.cjP = false;
    this.cjQ = "auto";
    this.cjR = 0;
    this.mVideoWidth = 368;
    this.mVideoHeight = 640;
    this.ciu = false;
    this.mContext = paramContext;
    this.cjh = new WXLivePushConfig();
    this.cji = new WXLivePusher(paramContext);
    this.cji.setConfig(this.cjh);
    this.cji.setPushListener(this);
    this.cji.setBGMNofify(this);
    this.cji.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(138900);
  }
  
  private void j(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(138902);
    ac.i("TXLivePusherJSAdapter", "adjustHomeOrientation, angle:" + paramInt + ", orientation:" + paramString);
    if (paramInt == 1)
    {
      if (paramString.equals("horizontal")) {
        break label168;
      }
      paramInt = i;
    }
    for (;;)
    {
      ac.i("TXLivePusherJSAdapter", "adjustHomeOrientation, homeOrientation:".concat(String.valueOf(paramInt)));
      if (paramInt != -2147483648)
      {
        this.cjh.setHomeOrientation(paramInt);
        this.cji.setConfig(this.cjh);
      }
      AppMethodBeat.o(138902);
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
          label168:
          paramInt = 3;
        }
      }
      else
      {
        paramInt = -2147483648;
      }
    }
  }
  
  static void l(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(138917);
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
    ac.i("TXLivePusherJSAdapter", paramString);
    AppMethodBeat.o(138917);
  }
  
  private void stopPreview()
  {
    AppMethodBeat.i(138906);
    this.cji.stopCameraPreview(true);
    this.cjl = false;
    AppMethodBeat.o(138906);
  }
  
  public final a ES()
  {
    AppMethodBeat.i(138908);
    a locala;
    if (!this.mInited)
    {
      locala = new a(-3, "uninited livePusher");
      AppMethodBeat.o(138908);
      return locala;
    }
    try
    {
      this.cji.stopBGM();
      stopPreview();
      this.cji.stopAudioRecord();
      this.cji.stopPusher();
      this.cji.setPushListener(null);
      this.mInited = false;
      locala = new a();
      AppMethodBeat.o(138908);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(138908);
    }
  }
  
  final void a(Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(138916);
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0))
    {
      AppMethodBeat.o(138916);
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
      m = this.cjw;
      n = this.cjx;
      i = paramBundle.getInt("minBitrate", -1);
      j = paramBundle.getInt("maxBitrate", -1);
      if (i > j)
      {
        ac.e("TXLivePusherJSAdapter", "parseAndApplyParams -> swap min and max bitrate, may be something error. min = " + i + " max = " + j);
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
                this.cjh.setMinVideoBitrate(m);
                this.cjh.setMaxVideoBitrate(i);
                i1 = m;
                j = i;
              }
            }
          }
        }
      }
      k = paramBundle.getInt("aspect", this.cjv);
      m = paramBundle.getInt("videoWidth", this.mVideoWidth);
      n = paramBundle.getInt("videoHeight", this.mVideoHeight);
      Object localObject1 = paramBundle.getString("audioQuality", this.cjC);
      label401:
      label459:
      Object localObject2;
      boolean bool1;
      label486:
      boolean bool2;
      label617:
      String str1;
      label660:
      label722:
      float f1;
      float f2;
      float f3;
      Object localObject4;
      if (i2 == 6)
      {
        if (k == 1)
        {
          this.cjh.setVideoResolution(13);
          if ((m > 0) && (m <= 1920) && (n > 0) && (n <= 1920)) {
            this.cjh.setVideoResolution(m, n);
          }
          if (!((String)localObject1).equalsIgnoreCase("low")) {
            break label1982;
          }
          this.cjh.setAudioSampleRate(16000);
        }
      }
      else
      {
        int i3 = paramBundle.getInt("focusMode", this.cjz);
        localObject2 = this.cjh;
        if (i3 == 0) {
          break label2005;
        }
        bool1 = true;
        ((WXLivePushConfig)localObject2).setTouchFocus(bool1);
        bool2 = this.mFrontCamera;
        bool1 = bool2;
        if (paramBundle.keySet().contains("devicePosition"))
        {
          this.cjm = paramBundle.getString("devicePosition", this.cjm);
          bool1 = bool2;
          if (this.cjm.equalsIgnoreCase("back")) {
            bool1 = false;
          }
          this.cjh.setFrontCamera(bool1);
        }
        localObject2 = paramBundle.getString("orientation", this.cin);
        if (!((String)localObject2).equalsIgnoreCase(this.cin))
        {
          if (!((String)localObject2).equalsIgnoreCase("horizontal")) {
            break label2011;
          }
          j(this.ciW, (String)localObject2);
          this.cji.setRenderRotation(90);
        }
        str1 = paramBundle.getString("localMirror", this.cjL);
        if (!str1.equalsIgnoreCase(this.cjL))
        {
          if (!str1.equalsIgnoreCase("auto")) {
            break label2042;
          }
          this.cjh.setLocalVideoMirrorType(0);
        }
        String str2 = paramBundle.getString("backgroundImage", this.cjG);
        Object localObject3 = BitmapFactory.decodeFile(str2);
        if (localObject3 != null) {
          this.cjh.setPauseImg((Bitmap)localObject3);
        }
        boolean bool3 = paramBundle.getBoolean("backgroundMute", this.cjH);
        if (i2 != 6) {
          break label2086;
        }
        this.cjh.setPauseFlag(1);
        boolean bool4 = paramBundle.getBoolean("zoom", this.mEnableZoom);
        this.cjh.setEnableZoom(bool4);
        f1 = paramBundle.getFloat("watermarkLeft", this.cjM);
        f2 = paramBundle.getFloat("watermarkTop", this.cjN);
        f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
        localObject3 = paramBundle.getString("watermarkImage", this.cjO);
        localObject4 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject4 == null) {
          break label2097;
        }
        this.cjh.setWatermark((Bitmap)localObject4, f1, f2, f3);
        label821:
        boolean bool5 = paramBundle.getBoolean("enableAGC", this.mEnableAgc);
        this.cjh.enableAGC(bool5);
        boolean bool6 = paramBundle.getBoolean("enableANS", this.mEnableAns);
        this.cjh.enableANS(bool6);
        boolean bool7 = paramBundle.getBoolean("enableEarMonitor", this.cjP);
        this.cjh.enableAudioEarMonitoring(bool7);
        localObject4 = paramBundle.getString("audioVolumeType", this.cjQ);
        if (!((String)localObject4).equalsIgnoreCase("voicecall")) {
          break label2139;
        }
        this.cjh.setVolumeType(2);
        label919:
        boolean bool8 = paramBundle.getBoolean("enableCamera", this.cjA);
        Object localObject5 = this.cjh;
        if (bool8) {
          break label2172;
        }
        bool2 = true;
        label946:
        ((WXLivePushConfig)localObject5).enablePureAudioPush(bool2);
        i = 0;
        if ((k != this.cjv) || (i1 != this.cjw) || (j != this.cjx) || (i3 != this.cjz) || (bool1 != this.mFrontCamera) || (bool3 != this.cjH) || (bool4 != this.mEnableZoom) || (bool5 != this.mEnableAgc) || (bool6 != this.mEnableAns) || (bool7 != this.cjP) || (bool8 != this.cjA) || (m != this.mVideoWidth) || (n != this.mVideoHeight) || (f1 != this.cjM) || (f2 != this.cjN) || (f3 != this.mWatermarkWidth) || (!str1.equalsIgnoreCase(this.cjL)) || (!((String)localObject4).equalsIgnoreCase(this.cjQ)) || (!str2.equalsIgnoreCase(this.cjG)) || (!((String)localObject2).equalsIgnoreCase(this.cin)) || (!((String)localObject1).equalsIgnoreCase(this.cjC)) || (!((String)localObject3).equalsIgnoreCase(this.cjO))) {
          i = 1;
        }
        if ((paramBoolean) || (i != 0)) {
          this.cji.setConfig(this.cjh);
        }
        if (bool8 != this.cjA)
        {
          if (!bool8) {
            break label2178;
          }
          stopPreview();
          bB(true);
        }
        label1220:
        if (!paramBundle.keySet().contains("enableMic")) {
          break label2207;
        }
        boolean bool9 = paramBundle.getBoolean("enableMic", this.cjB);
        if (bool9 != this.cjB)
        {
          if (!bool9) {
            break label2185;
          }
          this.cji.stopAudioRecord();
          bC(true);
        }
        label1274:
        if ((paramBoolean) || (bool9 != this.cjB))
        {
          localObject5 = this.cji;
          if (bool9) {
            break label2195;
          }
          bool2 = true;
          ((WXLivePusher)localObject5).setMute(bool2);
        }
        label1301:
        this.cjB = bool9;
        if (bool9) {
          break label2201;
        }
        bool2 = true;
        label1322:
        this.cjy = bool2;
        label1328:
        this.mMode = i2;
        this.cjv = k;
        this.cjz = i3;
        this.cjA = bool8;
        this.mEnableAgc = bool5;
        this.mEnableAns = bool6;
        this.cjP = bool7;
        this.cjL = str1;
        this.cjQ = ((String)localObject4);
        this.mVideoWidth = m;
        this.mVideoHeight = n;
        this.mFrontCamera = bool1;
        this.cin = ((String)localObject2);
        this.cjH = bool3;
        this.cjG = str2;
        this.cjw = i1;
        this.cjx = j;
        this.cjC = ((String)localObject1);
        this.mEnableZoom = bool4;
        this.cjM = f1;
        this.cjN = f2;
        this.mWatermarkWidth = f3;
        this.cjO = ((String)localObject3);
        this.cit = paramBundle.getBoolean("needEvent", this.cit);
        this.cjJ = paramBundle.getBoolean("needBGMEvent", this.cjJ);
        bool1 = this.cjK;
        if (!paramBundle.keySet().contains("remoteMirror")) {
          break label2266;
        }
        bool1 = paramBundle.getBoolean("remoteMirror");
        label1525:
        if (bool1 != this.cjK) {
          this.cji.setMirror(bool1);
        }
        this.cjK = bool1;
        i = paramBundle.getInt("beauty", this.cjD);
        j = paramBundle.getInt("whiteness", this.cjE);
        localObject1 = paramBundle.getString("beautyStyle", this.cjF);
        if ((paramBoolean) || (i != this.cjD) || (!((String)localObject1).equalsIgnoreCase(this.cjF)))
        {
          if (!((String)localObject1).equalsIgnoreCase("nature")) {
            break label2293;
          }
          this.cji.setBeautyFilter(1, i, j, 2);
        }
        label1639:
        this.cjD = i;
        this.cjE = j;
        this.cjF = ((String)localObject1);
        localObject1 = paramBundle.getString("filterImage", this.ciQ);
        if (!((String)localObject1).equalsIgnoreCase(this.ciQ))
        {
          localObject2 = BitmapFactory.decodeFile((String)localObject1);
          this.cji.setFilter((Bitmap)localObject2);
        }
        this.ciQ = ((String)localObject1);
        i = paramBundle.getInt("audioReverbType", this.cjR);
        if (i != this.cjR) {
          this.cji.setReverb(i);
        }
        this.cjR = i;
        bool1 = paramBundle.getBoolean("needAudioVolume", this.ciu);
        if (bool1 != this.ciu)
        {
          localObject1 = this.cji;
          if (!bool1) {
            break label2310;
          }
        }
      }
      label2178:
      label2310:
      for (i = 300;; i = 0)
      {
        ((WXLivePusher)localObject1).enableAudioVolumeEvaluation(i);
        this.ciu = bool1;
        bool1 = paramBundle.getBoolean("debug", this.ciw);
        if ((paramBoolean) || (bool1 != this.ciw)) {
          this.cji.showDebugLog(bool1);
        }
        this.ciw = bool1;
        AppMethodBeat.o(138916);
        return;
        this.cji.setVideoQuality(1, true, false);
        this.cjh.setVideoEncodeGop(5);
        break;
        this.cji.setVideoQuality(2, true, false);
        this.cjh.setVideoEncodeGop(5);
        break;
        this.cji.setVideoQuality(3, true, false);
        this.cjh.setVideoEncodeGop(5);
        break;
        this.cji.setVideoQuality(4, true, false);
        break;
        this.cji.setVideoQuality(5, true, false);
        break;
        this.cji.setVideoQuality(6, false, false);
        break;
        this.cji.setVideoQuality(7, true, false);
        this.cjh.setVideoEncodeGop(5);
        break;
        if (k != 2) {
          break label401;
        }
        this.cjh.setVideoResolution(0);
        break label401;
        label1982:
        if (!((String)localObject1).equalsIgnoreCase("high")) {
          break label459;
        }
        this.cjh.setAudioSampleRate(48000);
        break label459;
        label2005:
        bool1 = false;
        break label486;
        label2011:
        if (!((String)localObject2).equalsIgnoreCase("vertical")) {
          break label617;
        }
        j(this.ciW, (String)localObject2);
        this.cji.setRenderRotation(0);
        break label617;
        label2042:
        if (str1.equalsIgnoreCase("enable"))
        {
          this.cjh.setLocalVideoMirrorType(1);
          break label660;
        }
        if (!str1.equalsIgnoreCase("disable")) {
          break label660;
        }
        this.cjh.setLocalVideoMirrorType(2);
        break label660;
        label2086:
        this.cjh.setPauseFlag(3);
        break label722;
        label2097:
        if ((!this.cji.isPushing()) || (!paramBundle.keySet().contains("watermarkImage"))) {
          break label821;
        }
        this.cjh.setWatermark((Bitmap)localObject4, f1, f2, f3);
        break label821;
        label2139:
        if (((String)localObject4).equalsIgnoreCase("media"))
        {
          this.cjh.setVolumeType(1);
          break label919;
        }
        this.cjh.setVolumeType(0);
        break label919;
        label2172:
        bool2 = false;
        break label946;
        stopPreview();
        break label1220;
        label2185:
        this.cji.stopAudioRecord();
        break label1274;
        label2195:
        bool2 = false;
        break label1301;
        label2201:
        bool2 = false;
        break label1322;
        label2207:
        if (!paramBundle.keySet().contains("muted")) {
          break label1328;
        }
        bool2 = paramBundle.getBoolean("muted", this.cjy);
        if ((paramBoolean) || (bool2 != this.cjy)) {
          this.cji.setMute(bool2);
        }
        this.cjy = bool2;
        break label1328;
        label2266:
        if (!paramBundle.keySet().contains("mirror")) {
          break label1525;
        }
        bool1 = paramBundle.getBoolean("mirror");
        break label1525;
        label2293:
        this.cji.setBeautyFilter(0, i, j, 2);
        break label1639;
      }
      k = i;
      i = j;
    }
  }
  
  final void bB(boolean paramBoolean)
  {
    AppMethodBeat.i(138905);
    if ((!this.cjl) && (paramBoolean))
    {
      if (this.mVideoView != null) {
        this.mVideoView.setVisibility(0);
      }
      if (this.mSurface != null) {
        this.cji.setSurface(this.mSurface);
      }
      this.cji.startCameraPreview(this.mVideoView);
      this.cjl = true;
    }
    AppMethodBeat.o(138905);
  }
  
  final void bC(boolean paramBoolean)
  {
    AppMethodBeat.i(138907);
    if (paramBoolean) {
      this.cji.startAudioRecord();
    }
    AppMethodBeat.o(138907);
  }
  
  public final a bD(boolean paramBoolean)
  {
    AppMethodBeat.i(138910);
    this.cjn = this.cji.isPushing();
    if (this.cjn)
    {
      if (paramBoolean)
      {
        this.cjo = paramBoolean;
        locala = c("stop", null);
        AppMethodBeat.o(138910);
        return locala;
      }
      locala = c("pause", null);
      AppMethodBeat.o(138910);
      return locala;
    }
    a locala = new a();
    AppMethodBeat.o(138910);
    return locala;
  }
  
  public final a bT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138909);
    this.cji.setSurfaceSize(paramInt1, paramInt2);
    a locala = new a();
    AppMethodBeat.o(138909);
    return locala;
  }
  
  public final a c(final String paramString, JSONObject paramJSONObject)
  {
    final boolean bool1 = true;
    double d = 1.0D;
    int i = 0;
    int j = 0;
    boolean bool2 = false;
    AppMethodBeat.i(138904);
    if (paramString == null)
    {
      paramString = new a(-1, "invalid params");
      AppMethodBeat.o(138904);
      return paramString;
    }
    if (!this.mInited)
    {
      paramString = new a(-3, "uninited livePusher");
      AppMethodBeat.o(138904);
      return paramString;
    }
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    }
    ac.i("TXLivePusherJSAdapter", "operateLivePusher: type = " + paramString + " params = " + str);
    if (paramString.equalsIgnoreCase("start")) {
      if ((this.cjk != null) && (!this.cjk.isEmpty()) && (!this.cji.isPushing()))
      {
        bB(this.cjA);
        bC(this.cjB);
        if ((this.cjA) && (this.mSurface != null)) {
          this.cji.setSurface(this.mSurface);
        }
        this.cji.startPusher(this.cjk);
      }
    }
    for (;;)
    {
      paramString = new a();
      AppMethodBeat.o(138904);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.cjI = false;
        try
        {
          this.cji.stopBGM();
          stopPreview();
          this.cji.stopAudioRecord();
          this.cji.stopPusher();
          continue;
        }
        finally
        {
          AppMethodBeat.o(138904);
        }
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        if ((this.cjI) && (this.cji.isPushing())) {
          this.cji.turnOnFlashLight(false);
        }
        this.cji.pausePusher();
        this.cjt = this.cjs;
        if (this.cjt) {
          c("pauseBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.cji.resumePusher();
        if (this.cjt) {
          c("resumeBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("startPreview"))
      {
        if (this.cji.isPushing())
        {
          ac.i("TXLivePusherJSAdapter", "do not support startPreview when pushing");
        }
        else
        {
          stopPreview();
          bB(this.cjA);
        }
      }
      else if (paramString.equalsIgnoreCase("stopPreview"))
      {
        if (this.cji.isPushing()) {
          ac.i("TXLivePusherJSAdapter", "do not support stopPreview when pushing");
        } else {
          stopPreview();
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
            this.cjh.setFrontCamera(this.mFrontCamera);
            this.cji.switchCamera();
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
          paramString = this.cjp;
          if ((this.cji != null) && (this.cji.isPushing())) {
            this.cji.snapshot(new TXLivePusher.ITXSnapshotListener()
            {
              public final void onSnapshot(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(138899);
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
                      b.q(paramAnonymousBitmap);
                      AppMethodBeat.o(138899);
                      return;
                    }
                    paramString.onSnapshot(paramAnonymousBitmap);
                    AppMethodBeat.o(138899);
                    return;
                  }
                  paramString.onSnapshot(paramAnonymousBitmap);
                }
                AppMethodBeat.o(138899);
              }
            });
          }
        }
        else
        {
          if (paramString.equalsIgnoreCase("toggleTorch"))
          {
            if (!this.cjI)
            {
              bool2 = this.cji.turnOnFlashLight(bool1);
              if (!bool2) {
                break label699;
              }
              label654:
              this.cjI = bool1;
              if (!bool2) {
                break label708;
              }
              label665:
              if (!bool2) {
                break label715;
              }
            }
            label699:
            label708:
            label715:
            for (paramString = "Success";; paramString = "Failed")
            {
              paramString = new a(i, paramString);
              AppMethodBeat.o(138904);
              return paramString;
              bool1 = false;
              break;
              bool1 = this.cjI;
              break label654;
              i = -2;
              break label665;
            }
          }
          if (paramString.equalsIgnoreCase("playBGM"))
          {
            paramString = "";
            if (paramJSONObject != null) {
              paramString = paramJSONObject.optString("BGMFilePath", "");
            }
            ac.i("TXLivePusherJSAdapter", "playBGM filePath = ".concat(String.valueOf(paramString)));
            if ((paramString != null) && (paramString.length() > 0))
            {
              this.cji.playBGM(paramString);
            }
            else
            {
              paramString = new a(-2, "fail");
              AppMethodBeat.o(138904);
              return paramString;
            }
          }
          else if (paramString.equalsIgnoreCase("stopBGM"))
          {
            this.cji.stopBGM();
            this.cjs = false;
          }
          else if (paramString.equalsIgnoreCase("pauseBGM"))
          {
            this.cji.pauseBGM();
            this.cjs = false;
          }
          else
          {
            if (!paramString.equalsIgnoreCase("resumeBGM")) {
              break;
            }
            this.cji.resumeBGM();
            this.cjs = true;
          }
        }
      }
    }
    if (paramString.equalsIgnoreCase("setBGMVolume")) {
      if (paramJSONObject == null) {
        break label1092;
      }
    }
    label1043:
    label1092:
    for (d = paramJSONObject.optDouble("volume", 1.0D);; d = 1.0D)
    {
      this.cji.setBGMVolume((float)d);
      break;
      if (paramString.equalsIgnoreCase("setMICVolume"))
      {
        if (paramJSONObject != null) {
          d = paramJSONObject.optDouble("volume", 1.0D);
        }
        this.cji.setMicVolume((float)d);
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
          bool1 = this.cji.sendMessageEx(paramString.getBytes());
          if (bool1)
          {
            i = j;
            if (!bool1) {
              break label1043;
            }
          }
          for (paramString = "Success";; paramString = "Failed")
          {
            paramString = new a(i, paramString);
            AppMethodBeat.o(138904);
            return paramString;
            i = -2;
            break;
          }
        }
        paramString = new a(-2, "fail");
        AppMethodBeat.o(138904);
        return paramString;
      }
      paramString = new a(-4, "invalid operate command");
      AppMethodBeat.o(138904);
      return paramString;
    }
  }
  
  public final void gF(final int paramInt)
  {
    AppMethodBeat.i(138901);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138898);
        b.a(b.this, paramInt);
        ac.i("TXLivePusherJSAdapter", "notifyOrientationChanged, angle:" + paramInt + ", orientation:" + b.a(b.this));
        b.a(b.this, paramInt, b.a(b.this));
        AppMethodBeat.o(138898);
      }
    });
    AppMethodBeat.o(138901);
  }
  
  public final a o(Bundle paramBundle)
  {
    AppMethodBeat.i(138903);
    if (paramBundle == null)
    {
      paramBundle = new a(-1, "invalid params");
      AppMethodBeat.o(138903);
      return paramBundle;
    }
    l("updateLivePusher", paramBundle);
    if (!this.mInited)
    {
      paramBundle = new a(-3, "uninited livePusher");
      AppMethodBeat.o(138903);
      return paramBundle;
    }
    a(paramBundle, false);
    String str = paramBundle.getString("pushUrl", this.cjk);
    if ((str != null) && (!str.isEmpty()) && (this.cjk != null) && (!this.cjk.equalsIgnoreCase(str)) && (this.cji.isPushing()))
    {
      ac.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
      stopPreview();
      this.cji.stopAudioRecord();
      this.cji.stopPusher();
    }
    this.cjk = str;
    this.cji.setPusherUrl(this.cjk);
    this.cju = paramBundle.getBoolean("autopush", this.cju);
    if ((this.cju) && (this.cjk != null) && (!this.cjk.isEmpty()) && (!this.cji.isPushing()))
    {
      ac.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
      bB(this.cjA);
      bC(this.cjB);
      if ((this.cjA) && (this.mSurface != null)) {
        this.cji.setSurface(this.mSurface);
      }
      this.cji.startPusher(this.cjk);
    }
    paramBundle = new a();
    AppMethodBeat.o(138903);
    return paramBundle;
  }
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(178841);
    if ((this.ciu) && (this.cjr != null)) {
      this.cjr.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(178841);
  }
  
  public final void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(138915);
    this.cjs = false;
    if ((this.cjJ) && (this.cjq != null)) {
      this.cjq.onBGMComplete(paramInt);
    }
    AppMethodBeat.o(138915);
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(138914);
    if ((this.cjJ) && (this.cjq != null)) {
      this.cjq.onBGMProgress(paramLong1, paramLong2);
    }
    AppMethodBeat.o(138914);
  }
  
  public final void onBGMStart()
  {
    AppMethodBeat.i(138913);
    this.cjs = true;
    if ((this.cjJ) && (this.cjq != null)) {
      this.cjq.onBGMStart();
    }
    AppMethodBeat.o(138913);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(138912);
    if (this.cjj != null) {
      this.cjj.onNetStatus(paramBundle);
    }
    ac.i("TXLivePusherJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(138912);
  }
  
  public final void onPushEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(138911);
    if ((paramInt == -1307) || (paramInt == -1313))
    {
      Runnable local3 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(178840);
          b.this.c("stop", null);
          AppMethodBeat.o(178840);
        }
      };
      if (this.mHandler != null) {
        this.mHandler.post(local3);
      }
    }
    for (;;)
    {
      if (this.cjj != null) {
        this.cjj.onPushEvent(paramInt, paramBundle);
      }
      paramBundle = paramBundle.getString("EVT_MSG");
      ac.i("TXLivePusherJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
      AppMethodBeat.o(138911);
      return;
      if ((paramInt == 1003) && (this.cjI)) {
        this.cji.turnOnFlashLight(this.cjI);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */