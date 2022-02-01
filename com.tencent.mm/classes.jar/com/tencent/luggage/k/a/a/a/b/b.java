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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
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
  private String clO;
  private int clU;
  private String cll;
  private boolean clr;
  private boolean cls;
  private boolean clu;
  private String cmA;
  private int cmB;
  private int cmC;
  private String cmD;
  private String cmE;
  private boolean cmF;
  private boolean cmG;
  private boolean cmH;
  private boolean cmI;
  private String cmJ;
  private float cmK;
  private float cmL;
  private String cmM;
  private boolean cmN;
  private String cmO;
  private int cmP;
  private WXLivePushConfig cmf;
  WXLivePusher cmg;
  ITXLivePushListener cmh;
  String cmi;
  private boolean cmj;
  private String cmk;
  boolean cml;
  boolean cmm;
  TXLivePusher.ITXSnapshotListener cmn;
  TXLivePusher.OnBGMNotify cmo;
  TXLivePusher.ITXAudioVolumeEvaluationListener cmp;
  private boolean cmq;
  private boolean cmr;
  boolean cms;
  private int cmt;
  private int cmu;
  private int cmv;
  private boolean cmw;
  private int cmx;
  boolean cmy;
  boolean cmz;
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
    this.clU = 0;
    this.mInited = false;
    this.cmj = false;
    this.mFrontCamera = true;
    this.cmk = "front";
    this.cml = false;
    this.cmm = false;
    this.cmq = false;
    this.cmr = false;
    this.cms = false;
    this.mMode = 1;
    this.cmt = 2;
    this.cmu = -1;
    this.cmv = -1;
    this.cmw = false;
    this.cmx = 0;
    this.cmy = true;
    this.cmz = true;
    this.cll = "vertical";
    this.cmA = "high";
    this.cmB = 5;
    this.cmC = 3;
    this.cmD = "smooth";
    this.clO = "";
    this.cmE = "";
    this.cmF = false;
    this.cmG = false;
    this.mEnableZoom = true;
    this.clr = false;
    this.cmH = false;
    this.clu = false;
    this.cmI = false;
    this.cmJ = "auto";
    this.cmK = 0.0F;
    this.cmL = 0.0F;
    this.mWatermarkWidth = 0.1F;
    this.cmM = "";
    this.mEnableAgc = false;
    this.mEnableAns = false;
    this.cmN = false;
    this.cmO = "auto";
    this.cmP = 0;
    this.mVideoWidth = 368;
    this.mVideoHeight = 640;
    this.cls = false;
    this.mContext = paramContext;
    this.cmf = new WXLivePushConfig();
    this.cmg = new WXLivePusher(paramContext);
    this.cmg.setConfig(this.cmf);
    this.cmg.setPushListener(this);
    this.cmg.setBGMNofify(this);
    this.cmg.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(138900);
  }
  
  private void j(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(138902);
    ad.i("TXLivePusherJSAdapter", "adjustHomeOrientation, angle:" + paramInt + ", orientation:" + paramString);
    if (paramInt == 1)
    {
      if (paramString.equals("horizontal")) {
        break label168;
      }
      paramInt = i;
    }
    for (;;)
    {
      ad.i("TXLivePusherJSAdapter", "adjustHomeOrientation, homeOrientation:".concat(String.valueOf(paramInt)));
      if (paramInt != -2147483648)
      {
        this.cmf.setHomeOrientation(paramInt);
        this.cmg.setConfig(this.cmf);
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
    ad.i("TXLivePusherJSAdapter", paramString);
    AppMethodBeat.o(138917);
  }
  
  private void stopPreview()
  {
    AppMethodBeat.i(138906);
    this.cmg.stopCameraPreview(true);
    this.cmj = false;
    AppMethodBeat.o(138906);
  }
  
  public final a Fk()
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
      this.cmg.stopBGM();
      stopPreview();
      this.cmg.stopAudioRecord();
      this.cmg.stopPusher();
      this.cmg.setPushListener(null);
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
      m = this.cmu;
      n = this.cmv;
      i = paramBundle.getInt("minBitrate", -1);
      j = paramBundle.getInt("maxBitrate", -1);
      if (i > j)
      {
        ad.e("TXLivePusherJSAdapter", "parseAndApplyParams -> swap min and max bitrate, may be something error. min = " + i + " max = " + j);
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
                this.cmf.setMinVideoBitrate(m);
                this.cmf.setMaxVideoBitrate(i);
                i1 = m;
                j = i;
              }
            }
          }
        }
      }
      k = paramBundle.getInt("aspect", this.cmt);
      m = paramBundle.getInt("videoWidth", this.mVideoWidth);
      n = paramBundle.getInt("videoHeight", this.mVideoHeight);
      Object localObject1 = paramBundle.getString("audioQuality", this.cmA);
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
          this.cmf.setVideoResolution(13);
          if ((m > 0) && (m <= 1920) && (n > 0) && (n <= 1920)) {
            this.cmf.setVideoResolution(m, n);
          }
          if (!((String)localObject1).equalsIgnoreCase("low")) {
            break label1982;
          }
          this.cmf.setAudioSampleRate(16000);
        }
      }
      else
      {
        int i3 = paramBundle.getInt("focusMode", this.cmx);
        localObject2 = this.cmf;
        if (i3 == 0) {
          break label2005;
        }
        bool1 = true;
        ((WXLivePushConfig)localObject2).setTouchFocus(bool1);
        bool2 = this.mFrontCamera;
        bool1 = bool2;
        if (paramBundle.keySet().contains("devicePosition"))
        {
          this.cmk = paramBundle.getString("devicePosition", this.cmk);
          bool1 = bool2;
          if (this.cmk.equalsIgnoreCase("back")) {
            bool1 = false;
          }
          this.cmf.setFrontCamera(bool1);
        }
        localObject2 = paramBundle.getString("orientation", this.cll);
        if (!((String)localObject2).equalsIgnoreCase(this.cll))
        {
          if (!((String)localObject2).equalsIgnoreCase("horizontal")) {
            break label2011;
          }
          j(this.clU, (String)localObject2);
          this.cmg.setRenderRotation(90);
        }
        str1 = paramBundle.getString("localMirror", this.cmJ);
        if (!str1.equalsIgnoreCase(this.cmJ))
        {
          if (!str1.equalsIgnoreCase("auto")) {
            break label2042;
          }
          this.cmf.setLocalVideoMirrorType(0);
        }
        String str2 = paramBundle.getString("backgroundImage", this.cmE);
        Object localObject3 = BitmapFactory.decodeFile(str2);
        if (localObject3 != null) {
          this.cmf.setPauseImg((Bitmap)localObject3);
        }
        boolean bool3 = paramBundle.getBoolean("backgroundMute", this.cmF);
        if (i2 != 6) {
          break label2086;
        }
        this.cmf.setPauseFlag(1);
        boolean bool4 = paramBundle.getBoolean("zoom", this.mEnableZoom);
        this.cmf.setEnableZoom(bool4);
        f1 = paramBundle.getFloat("watermarkLeft", this.cmK);
        f2 = paramBundle.getFloat("watermarkTop", this.cmL);
        f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
        localObject3 = paramBundle.getString("watermarkImage", this.cmM);
        localObject4 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject4 == null) {
          break label2097;
        }
        this.cmf.setWatermark((Bitmap)localObject4, f1, f2, f3);
        label821:
        boolean bool5 = paramBundle.getBoolean("enableAGC", this.mEnableAgc);
        this.cmf.enableAGC(bool5);
        boolean bool6 = paramBundle.getBoolean("enableANS", this.mEnableAns);
        this.cmf.enableANS(bool6);
        boolean bool7 = paramBundle.getBoolean("enableEarMonitor", this.cmN);
        this.cmf.enableAudioEarMonitoring(bool7);
        localObject4 = paramBundle.getString("audioVolumeType", this.cmO);
        if (!((String)localObject4).equalsIgnoreCase("voicecall")) {
          break label2139;
        }
        this.cmf.setVolumeType(2);
        label919:
        boolean bool8 = paramBundle.getBoolean("enableCamera", this.cmy);
        Object localObject5 = this.cmf;
        if (bool8) {
          break label2172;
        }
        bool2 = true;
        label946:
        ((WXLivePushConfig)localObject5).enablePureAudioPush(bool2);
        i = 0;
        if ((k != this.cmt) || (i1 != this.cmu) || (j != this.cmv) || (i3 != this.cmx) || (bool1 != this.mFrontCamera) || (bool3 != this.cmF) || (bool4 != this.mEnableZoom) || (bool5 != this.mEnableAgc) || (bool6 != this.mEnableAns) || (bool7 != this.cmN) || (bool8 != this.cmy) || (m != this.mVideoWidth) || (n != this.mVideoHeight) || (f1 != this.cmK) || (f2 != this.cmL) || (f3 != this.mWatermarkWidth) || (!str1.equalsIgnoreCase(this.cmJ)) || (!((String)localObject4).equalsIgnoreCase(this.cmO)) || (!str2.equalsIgnoreCase(this.cmE)) || (!((String)localObject2).equalsIgnoreCase(this.cll)) || (!((String)localObject1).equalsIgnoreCase(this.cmA)) || (!((String)localObject3).equalsIgnoreCase(this.cmM))) {
          i = 1;
        }
        if ((paramBoolean) || (i != 0)) {
          this.cmg.setConfig(this.cmf);
        }
        if (bool8 != this.cmy)
        {
          if (!bool8) {
            break label2178;
          }
          stopPreview();
          bC(true);
        }
        label1220:
        if (!paramBundle.keySet().contains("enableMic")) {
          break label2207;
        }
        boolean bool9 = paramBundle.getBoolean("enableMic", this.cmz);
        if (bool9 != this.cmz)
        {
          if (!bool9) {
            break label2185;
          }
          this.cmg.stopAudioRecord();
          bD(true);
        }
        label1274:
        if ((paramBoolean) || (bool9 != this.cmz))
        {
          localObject5 = this.cmg;
          if (bool9) {
            break label2195;
          }
          bool2 = true;
          ((WXLivePusher)localObject5).setMute(bool2);
        }
        label1301:
        this.cmz = bool9;
        if (bool9) {
          break label2201;
        }
        bool2 = true;
        label1322:
        this.cmw = bool2;
        label1328:
        this.mMode = i2;
        this.cmt = k;
        this.cmx = i3;
        this.cmy = bool8;
        this.mEnableAgc = bool5;
        this.mEnableAns = bool6;
        this.cmN = bool7;
        this.cmJ = str1;
        this.cmO = ((String)localObject4);
        this.mVideoWidth = m;
        this.mVideoHeight = n;
        this.mFrontCamera = bool1;
        this.cll = ((String)localObject2);
        this.cmF = bool3;
        this.cmE = str2;
        this.cmu = i1;
        this.cmv = j;
        this.cmA = ((String)localObject1);
        this.mEnableZoom = bool4;
        this.cmK = f1;
        this.cmL = f2;
        this.mWatermarkWidth = f3;
        this.cmM = ((String)localObject3);
        this.clr = paramBundle.getBoolean("needEvent", this.clr);
        this.cmH = paramBundle.getBoolean("needBGMEvent", this.cmH);
        bool1 = this.cmI;
        if (!paramBundle.keySet().contains("remoteMirror")) {
          break label2266;
        }
        bool1 = paramBundle.getBoolean("remoteMirror");
        label1525:
        if (bool1 != this.cmI) {
          this.cmg.setMirror(bool1);
        }
        this.cmI = bool1;
        i = paramBundle.getInt("beauty", this.cmB);
        j = paramBundle.getInt("whiteness", this.cmC);
        localObject1 = paramBundle.getString("beautyStyle", this.cmD);
        if ((paramBoolean) || (i != this.cmB) || (!((String)localObject1).equalsIgnoreCase(this.cmD)))
        {
          if (!((String)localObject1).equalsIgnoreCase("nature")) {
            break label2293;
          }
          this.cmg.setBeautyFilter(1, i, j, 2);
        }
        label1639:
        this.cmB = i;
        this.cmC = j;
        this.cmD = ((String)localObject1);
        localObject1 = paramBundle.getString("filterImage", this.clO);
        if (!((String)localObject1).equalsIgnoreCase(this.clO))
        {
          localObject2 = BitmapFactory.decodeFile((String)localObject1);
          this.cmg.setFilter((Bitmap)localObject2);
        }
        this.clO = ((String)localObject1);
        i = paramBundle.getInt("audioReverbType", this.cmP);
        if (i != this.cmP) {
          this.cmg.setReverb(i);
        }
        this.cmP = i;
        bool1 = paramBundle.getBoolean("needAudioVolume", this.cls);
        if (bool1 != this.cls)
        {
          localObject1 = this.cmg;
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
        this.cls = bool1;
        bool1 = paramBundle.getBoolean("debug", this.clu);
        if ((paramBoolean) || (bool1 != this.clu)) {
          this.cmg.showDebugLog(bool1);
        }
        this.clu = bool1;
        AppMethodBeat.o(138916);
        return;
        this.cmg.setVideoQuality(1, true, false);
        this.cmf.setVideoEncodeGop(5);
        break;
        this.cmg.setVideoQuality(2, true, false);
        this.cmf.setVideoEncodeGop(5);
        break;
        this.cmg.setVideoQuality(3, true, false);
        this.cmf.setVideoEncodeGop(5);
        break;
        this.cmg.setVideoQuality(4, true, false);
        break;
        this.cmg.setVideoQuality(5, true, false);
        break;
        this.cmg.setVideoQuality(6, false, false);
        break;
        this.cmg.setVideoQuality(7, true, false);
        this.cmf.setVideoEncodeGop(5);
        break;
        if (k != 2) {
          break label401;
        }
        this.cmf.setVideoResolution(0);
        break label401;
        label1982:
        if (!((String)localObject1).equalsIgnoreCase("high")) {
          break label459;
        }
        this.cmf.setAudioSampleRate(48000);
        break label459;
        label2005:
        bool1 = false;
        break label486;
        label2011:
        if (!((String)localObject2).equalsIgnoreCase("vertical")) {
          break label617;
        }
        j(this.clU, (String)localObject2);
        this.cmg.setRenderRotation(0);
        break label617;
        label2042:
        if (str1.equalsIgnoreCase("enable"))
        {
          this.cmf.setLocalVideoMirrorType(1);
          break label660;
        }
        if (!str1.equalsIgnoreCase("disable")) {
          break label660;
        }
        this.cmf.setLocalVideoMirrorType(2);
        break label660;
        label2086:
        this.cmf.setPauseFlag(3);
        break label722;
        label2097:
        if ((!this.cmg.isPushing()) || (!paramBundle.keySet().contains("watermarkImage"))) {
          break label821;
        }
        this.cmf.setWatermark((Bitmap)localObject4, f1, f2, f3);
        break label821;
        label2139:
        if (((String)localObject4).equalsIgnoreCase("media"))
        {
          this.cmf.setVolumeType(1);
          break label919;
        }
        this.cmf.setVolumeType(0);
        break label919;
        label2172:
        bool2 = false;
        break label946;
        stopPreview();
        break label1220;
        label2185:
        this.cmg.stopAudioRecord();
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
        bool2 = paramBundle.getBoolean("muted", this.cmw);
        if ((paramBoolean) || (bool2 != this.cmw)) {
          this.cmg.setMute(bool2);
        }
        this.cmw = bool2;
        break label1328;
        label2266:
        if (!paramBundle.keySet().contains("mirror")) {
          break label1525;
        }
        bool1 = paramBundle.getBoolean("mirror");
        break label1525;
        label2293:
        this.cmg.setBeautyFilter(0, i, j, 2);
        break label1639;
      }
      k = i;
      i = j;
    }
  }
  
  final void bC(boolean paramBoolean)
  {
    AppMethodBeat.i(138905);
    if ((!this.cmj) && (paramBoolean))
    {
      if (this.mVideoView != null) {
        this.mVideoView.setVisibility(0);
      }
      if (this.mSurface != null) {
        this.cmg.setSurface(this.mSurface);
      }
      this.cmg.startCameraPreview(this.mVideoView);
      this.cmj = true;
    }
    AppMethodBeat.o(138905);
  }
  
  final void bD(boolean paramBoolean)
  {
    AppMethodBeat.i(138907);
    if (paramBoolean) {
      this.cmg.startAudioRecord();
    }
    AppMethodBeat.o(138907);
  }
  
  public final a bE(boolean paramBoolean)
  {
    AppMethodBeat.i(138910);
    this.cml = this.cmg.isPushing();
    if (this.cml)
    {
      if (paramBoolean)
      {
        this.cmm = paramBoolean;
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
  
  public final a bW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138909);
    this.cmg.setSurfaceSize(paramInt1, paramInt2);
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
    ad.i("TXLivePusherJSAdapter", "operateLivePusher: type = " + paramString + " params = " + str);
    if (paramString.equalsIgnoreCase("start")) {
      if ((this.cmi != null) && (!this.cmi.isEmpty()) && (!this.cmg.isPushing()))
      {
        bC(this.cmy);
        bD(this.cmz);
        if ((this.cmy) && (this.mSurface != null)) {
          this.cmg.setSurface(this.mSurface);
        }
        this.cmg.startPusher(this.cmi);
      }
    }
    for (;;)
    {
      paramString = new a();
      AppMethodBeat.o(138904);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.cmG = false;
        try
        {
          this.cmg.stopBGM();
          stopPreview();
          this.cmg.stopAudioRecord();
          this.cmg.stopPusher();
          continue;
        }
        finally
        {
          AppMethodBeat.o(138904);
        }
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        if ((this.cmG) && (this.cmg.isPushing())) {
          this.cmg.turnOnFlashLight(false);
        }
        this.cmg.pausePusher();
        this.cmr = this.cmq;
        if (this.cmr) {
          c("pauseBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.cmg.resumePusher();
        if (this.cmr) {
          c("resumeBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("startPreview"))
      {
        if (this.cmg.isPushing())
        {
          ad.i("TXLivePusherJSAdapter", "do not support startPreview when pushing");
        }
        else
        {
          stopPreview();
          bC(this.cmy);
        }
      }
      else if (paramString.equalsIgnoreCase("stopPreview"))
      {
        if (this.cmg.isPushing()) {
          ad.i("TXLivePusherJSAdapter", "do not support stopPreview when pushing");
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
            this.cmf.setFrontCamera(this.mFrontCamera);
            this.cmg.switchCamera();
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
          paramString = this.cmn;
          if ((this.cmg != null) && (this.cmg.isPushing())) {
            this.cmg.snapshot(new TXLivePusher.ITXSnapshotListener()
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
            if (!this.cmG)
            {
              bool2 = this.cmg.turnOnFlashLight(bool1);
              if (!bool2) {
                break label699;
              }
              label654:
              this.cmG = bool1;
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
              bool1 = this.cmG;
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
            ad.i("TXLivePusherJSAdapter", "playBGM filePath = ".concat(String.valueOf(paramString)));
            if ((paramString != null) && (paramString.length() > 0))
            {
              this.cmg.playBGM(paramString);
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
            this.cmg.stopBGM();
            this.cmq = false;
          }
          else if (paramString.equalsIgnoreCase("pauseBGM"))
          {
            this.cmg.pauseBGM();
            this.cmq = false;
          }
          else
          {
            if (!paramString.equalsIgnoreCase("resumeBGM")) {
              break;
            }
            this.cmg.resumeBGM();
            this.cmq = true;
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
      this.cmg.setBGMVolume((float)d);
      break;
      if (paramString.equalsIgnoreCase("setMICVolume"))
      {
        if (paramJSONObject != null) {
          d = paramJSONObject.optDouble("volume", 1.0D);
        }
        this.cmg.setMicVolume((float)d);
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
          bool1 = this.cmg.sendMessageEx(paramString.getBytes());
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
  
  public final void gV(final int paramInt)
  {
    AppMethodBeat.i(138901);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138898);
        b.a(b.this, paramInt);
        ad.i("TXLivePusherJSAdapter", "notifyOrientationChanged, angle:" + paramInt + ", orientation:" + b.a(b.this));
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
    String str = paramBundle.getString("pushUrl", this.cmi);
    if ((str != null) && (!str.isEmpty()) && (this.cmi != null) && (!this.cmi.equalsIgnoreCase(str)) && (this.cmg.isPushing()))
    {
      ad.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
      stopPreview();
      this.cmg.stopAudioRecord();
      this.cmg.stopPusher();
    }
    this.cmi = str;
    this.cmg.setPusherUrl(this.cmi);
    this.cms = paramBundle.getBoolean("autopush", this.cms);
    if ((this.cms) && (this.cmi != null) && (!this.cmi.isEmpty()) && (!this.cmg.isPushing()))
    {
      ad.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
      bC(this.cmy);
      bD(this.cmz);
      if ((this.cmy) && (this.mSurface != null)) {
        this.cmg.setSurface(this.mSurface);
      }
      this.cmg.startPusher(this.cmi);
    }
    paramBundle = new a();
    AppMethodBeat.o(138903);
    return paramBundle;
  }
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(178841);
    if ((this.cls) && (this.cmp != null)) {
      this.cmp.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(178841);
  }
  
  public final void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(138915);
    this.cmq = false;
    if ((this.cmH) && (this.cmo != null)) {
      this.cmo.onBGMComplete(paramInt);
    }
    AppMethodBeat.o(138915);
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(138914);
    if ((this.cmH) && (this.cmo != null)) {
      this.cmo.onBGMProgress(paramLong1, paramLong2);
    }
    AppMethodBeat.o(138914);
  }
  
  public final void onBGMStart()
  {
    AppMethodBeat.i(138913);
    this.cmq = true;
    if ((this.cmH) && (this.cmo != null)) {
      this.cmo.onBGMStart();
    }
    AppMethodBeat.o(138913);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(138912);
    if (this.cmh != null) {
      this.cmh.onNetStatus(paramBundle);
    }
    ad.i("TXLivePusherJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
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
      if (this.cmh != null) {
        this.cmh.onPushEvent(paramInt, paramBundle);
      }
      paramBundle = paramBundle.getString("EVT_MSG");
      ad.i("TXLivePusherJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
      AppMethodBeat.o(138911);
      return;
      if ((paramInt == 1003) && (this.cmG)) {
        this.cmg.turnOnFlashLight(this.cmG);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */