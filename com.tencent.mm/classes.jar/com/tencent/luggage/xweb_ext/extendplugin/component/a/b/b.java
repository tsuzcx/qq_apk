package com.tencent.luggage.xweb_ext.extendplugin.component.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.component.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
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
  private String ctJ;
  private int ctP;
  private String ctf;
  private boolean ctl;
  private boolean ctm;
  private boolean cto;
  private boolean cuA;
  private boolean cuB;
  private boolean cuC;
  private boolean cuD;
  private String cuE;
  private float cuF;
  private float cuG;
  private String cuH;
  private boolean cuI;
  private String cuJ;
  private int cuK;
  private WXLivePushConfig cua;
  WXLivePusher cub;
  ITXLivePushListener cuc;
  String cud;
  private boolean cue;
  private String cuf;
  boolean cug;
  boolean cuh;
  TXLivePusher.ITXSnapshotListener cui;
  TXLivePusher.OnBGMNotify cuj;
  TXLivePusher.ITXAudioVolumeEvaluationListener cuk;
  private boolean cul;
  private boolean cum;
  boolean cun;
  private int cuo;
  private int cup;
  private int cuq;
  private boolean cur;
  private int cus;
  boolean cut;
  boolean cuu;
  private String cuv;
  private int cuw;
  private int cux;
  private String cuy;
  private String cuz;
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
    this.ctP = 0;
    this.mInited = false;
    this.cue = false;
    this.mFrontCamera = true;
    this.cuf = "front";
    this.cug = false;
    this.cuh = false;
    this.cul = false;
    this.cum = false;
    this.cun = false;
    this.mMode = 1;
    this.cuo = 2;
    this.cup = -1;
    this.cuq = -1;
    this.cur = false;
    this.cus = 0;
    this.cut = true;
    this.cuu = true;
    this.ctf = "vertical";
    this.cuv = "high";
    this.cuw = 5;
    this.cux = 3;
    this.cuy = "smooth";
    this.ctJ = "";
    this.cuz = "";
    this.cuA = false;
    this.cuB = false;
    this.mEnableZoom = true;
    this.ctl = false;
    this.cuC = false;
    this.cto = false;
    this.cuD = false;
    this.cuE = "auto";
    this.cuF = 0.0F;
    this.cuG = 0.0F;
    this.mWatermarkWidth = 0.1F;
    this.cuH = "";
    this.mEnableAgc = false;
    this.mEnableAns = false;
    this.cuI = false;
    this.cuJ = "auto";
    this.cuK = 0;
    this.mVideoWidth = 368;
    this.mVideoHeight = 640;
    this.ctm = false;
    this.mContext = paramContext;
    this.cua = new WXLivePushConfig();
    this.cub = new WXLivePusher(paramContext);
    this.cub.setConfig(this.cua);
    this.cub.setPushListener(this);
    this.cub.setBGMNofify(this);
    this.cub.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(138900);
  }
  
  private void j(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(138902);
    ae.i("TXLivePusherJSAdapter", "adjustHomeOrientation, angle:" + paramInt + ", orientation:" + paramString);
    if (paramInt == 1)
    {
      if (paramString.equals("horizontal")) {
        break label168;
      }
      paramInt = i;
    }
    for (;;)
    {
      ae.i("TXLivePusherJSAdapter", "adjustHomeOrientation, homeOrientation:".concat(String.valueOf(paramInt)));
      if (paramInt != -2147483648)
      {
        this.cua.setHomeOrientation(paramInt);
        this.cub.setConfig(this.cua);
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
    ae.i("TXLivePusherJSAdapter", paramString);
    AppMethodBeat.o(138917);
  }
  
  private void stopPreview()
  {
    AppMethodBeat.i(138906);
    this.cub.stopCameraPreview(true);
    this.cue = false;
    AppMethodBeat.o(138906);
  }
  
  public final a Gt()
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
      this.cub.stopBGM();
      stopPreview();
      this.cub.stopAudioRecord();
      this.cub.stopPusher();
      this.cub.setPushListener(null);
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
      m = this.cup;
      n = this.cuq;
      i = paramBundle.getInt("minBitrate", -1);
      j = paramBundle.getInt("maxBitrate", -1);
      if (i > j)
      {
        ae.e("TXLivePusherJSAdapter", "parseAndApplyParams -> swap min and max bitrate, may be something error. min = " + i + " max = " + j);
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
                this.cua.setMinVideoBitrate(m);
                this.cua.setMaxVideoBitrate(i);
                i1 = m;
                j = i;
              }
            }
          }
        }
      }
      k = paramBundle.getInt("aspect", this.cuo);
      m = paramBundle.getInt("videoWidth", this.mVideoWidth);
      n = paramBundle.getInt("videoHeight", this.mVideoHeight);
      Object localObject1 = paramBundle.getString("audioQuality", this.cuv);
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
          this.cua.setVideoResolution(13);
          if ((m > 0) && (m <= 1920) && (n > 0) && (n <= 1920)) {
            this.cua.setVideoResolution(m, n);
          }
          if (!((String)localObject1).equalsIgnoreCase("low")) {
            break label1991;
          }
          this.cua.setAudioSampleRate(16000);
        }
      }
      else
      {
        int i3 = paramBundle.getInt("focusMode", this.cus);
        localObject2 = this.cua;
        if (i3 == 0) {
          break label2014;
        }
        bool1 = true;
        ((WXLivePushConfig)localObject2).setTouchFocus(bool1);
        bool2 = this.mFrontCamera;
        bool1 = bool2;
        if (paramBundle.keySet().contains("devicePosition"))
        {
          this.cuf = paramBundle.getString("devicePosition", this.cuf);
          bool1 = bool2;
          if (this.cuf.equalsIgnoreCase("back")) {
            bool1 = false;
          }
          this.cua.setFrontCamera(bool1);
        }
        localObject2 = paramBundle.getString("orientation", this.ctf);
        if (!((String)localObject2).equalsIgnoreCase(this.ctf))
        {
          if (!((String)localObject2).equalsIgnoreCase("horizontal")) {
            break label2020;
          }
          j(this.ctP, (String)localObject2);
          this.cub.setRenderRotation(90);
        }
        str1 = paramBundle.getString("localMirror", this.cuE);
        if (!str1.equalsIgnoreCase(this.cuE))
        {
          if (!str1.equalsIgnoreCase("auto")) {
            break label2051;
          }
          this.cua.setLocalVideoMirrorType(0);
        }
        String str2 = paramBundle.getString("backgroundImage", this.cuz);
        Object localObject3 = BitmapFactory.decodeFile(str2);
        if (localObject3 != null) {
          this.cua.setPauseImg((Bitmap)localObject3);
        }
        boolean bool3 = paramBundle.getBoolean("backgroundMute", this.cuA);
        if (i2 != 6) {
          break label2095;
        }
        this.cua.setPauseFlag(1);
        boolean bool4 = paramBundle.getBoolean("zoom", this.mEnableZoom);
        this.cua.setEnableZoom(bool4);
        f1 = paramBundle.getFloat("watermarkLeft", this.cuF);
        f2 = paramBundle.getFloat("watermarkTop", this.cuG);
        f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
        localObject3 = paramBundle.getString("watermarkImage", this.cuH);
        localObject4 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject4 == null) {
          break label2106;
        }
        this.cua.setWatermark((Bitmap)localObject4, f1, f2, f3);
        label821:
        boolean bool5 = paramBundle.getBoolean("enableAGC", this.mEnableAgc);
        this.cua.enableAGC(bool5);
        boolean bool6 = paramBundle.getBoolean("enableANS", this.mEnableAns);
        this.cua.enableANS(bool6);
        boolean bool7 = paramBundle.getBoolean("enableEarMonitor", this.cuI);
        this.cua.enableAudioEarMonitoring(bool7);
        localObject4 = paramBundle.getString("audioVolumeType", this.cuJ);
        if (!((String)localObject4).equalsIgnoreCase("voicecall")) {
          break label2148;
        }
        this.cua.setVolumeType(2);
        label919:
        boolean bool8 = paramBundle.getBoolean("enableCamera", this.cut);
        Object localObject5 = this.cua;
        if (bool8) {
          break label2181;
        }
        bool2 = true;
        label946:
        ((WXLivePushConfig)localObject5).enablePureAudioPush(bool2);
        i = 0;
        if ((k != this.cuo) || (i1 != this.cup) || (j != this.cuq) || (i3 != this.cus) || (bool1 != this.mFrontCamera) || (bool3 != this.cuA) || (bool4 != this.mEnableZoom) || (bool5 != this.mEnableAgc) || (bool6 != this.mEnableAns) || (bool7 != this.cuI) || (bool8 != this.cut) || (m != this.mVideoWidth) || (n != this.mVideoHeight) || (f1 != this.cuF) || (f2 != this.cuG) || (f3 != this.mWatermarkWidth) || (!str1.equalsIgnoreCase(this.cuE)) || (!((String)localObject4).equalsIgnoreCase(this.cuJ)) || (!str2.equalsIgnoreCase(this.cuz)) || (!((String)localObject2).equalsIgnoreCase(this.ctf)) || (!((String)localObject1).equalsIgnoreCase(this.cuv)) || (!((String)localObject3).equalsIgnoreCase(this.cuH))) {
          i = 1;
        }
        if ((paramBoolean) || (i != 0)) {
          this.cub.setConfig(this.cua);
        }
        if (bool8 != this.cut)
        {
          if (!bool8) {
            break label2187;
          }
          stopPreview();
          bB(true);
        }
        label1220:
        if (!paramBundle.keySet().contains("enableMic")) {
          break label2216;
        }
        boolean bool9 = paramBundle.getBoolean("enableMic", this.cuu);
        if (bool9 != this.cuu)
        {
          if (!bool9) {
            break label2194;
          }
          this.cub.stopAudioRecord();
          bC(true);
        }
        label1274:
        if ((paramBoolean) || (bool9 != this.cuu))
        {
          localObject5 = this.cub;
          if (bool9) {
            break label2204;
          }
          bool2 = true;
          ((WXLivePusher)localObject5).setMute(bool2);
        }
        label1301:
        this.cuu = bool9;
        if (bool9) {
          break label2210;
        }
        bool2 = true;
        label1322:
        this.cur = bool2;
        label1328:
        this.mMode = i2;
        this.cuo = k;
        this.cus = i3;
        this.cut = bool8;
        this.mEnableAgc = bool5;
        this.mEnableAns = bool6;
        this.cuI = bool7;
        this.cuE = str1;
        this.cuJ = ((String)localObject4);
        this.mVideoWidth = m;
        this.mVideoHeight = n;
        this.mFrontCamera = bool1;
        this.ctf = ((String)localObject2);
        this.cuA = bool3;
        this.cuz = str2;
        this.cup = i1;
        this.cuq = j;
        this.cuv = ((String)localObject1);
        this.mEnableZoom = bool4;
        this.cuF = f1;
        this.cuG = f2;
        this.mWatermarkWidth = f3;
        this.cuH = ((String)localObject3);
        this.ctl = paramBundle.getBoolean("needEvent", this.ctl);
        this.cuC = paramBundle.getBoolean("needBGMEvent", this.cuC);
        bool1 = this.cuD;
        if (!paramBundle.keySet().contains("remoteMirror")) {
          break label2275;
        }
        bool1 = paramBundle.getBoolean("remoteMirror");
        label1525:
        if (bool1 != this.cuD) {
          this.cub.setMirror(bool1);
        }
        this.cuD = bool1;
        i = paramBundle.getInt("beauty", this.cuw);
        j = paramBundle.getInt("whiteness", this.cux);
        localObject1 = paramBundle.getString("beautyStyle", this.cuy);
        if ((paramBoolean) || (i != this.cuw) || (j != this.cux) || (!((String)localObject1).equalsIgnoreCase(this.cuy)))
        {
          if (!((String)localObject1).equalsIgnoreCase("nature")) {
            break label2302;
          }
          this.cub.setBeautyFilter(1, i, j, 2);
        }
        label1648:
        this.cuw = i;
        this.cux = j;
        this.cuy = ((String)localObject1);
        localObject1 = paramBundle.getString("filterImage", this.ctJ);
        if (!((String)localObject1).equalsIgnoreCase(this.ctJ))
        {
          localObject2 = BitmapFactory.decodeFile((String)localObject1);
          this.cub.setFilter((Bitmap)localObject2);
        }
        this.ctJ = ((String)localObject1);
        i = paramBundle.getInt("audioReverbType", this.cuK);
        if (i != this.cuK) {
          this.cub.setReverb(i);
        }
        this.cuK = i;
        bool1 = paramBundle.getBoolean("needAudioVolume", this.ctm);
        if (bool1 != this.ctm)
        {
          localObject1 = this.cub;
          if (!bool1) {
            break label2319;
          }
        }
      }
      label2051:
      label2181:
      label2187:
      label2319:
      for (i = 300;; i = 0)
      {
        ((WXLivePusher)localObject1).enableAudioVolumeEvaluation(i);
        this.ctm = bool1;
        bool1 = paramBundle.getBoolean("debug", this.cto);
        if ((paramBoolean) || (bool1 != this.cto)) {
          this.cub.showDebugLog(bool1);
        }
        this.cto = bool1;
        AppMethodBeat.o(138916);
        return;
        this.cub.setVideoQuality(1, true, false);
        this.cua.setVideoEncodeGop(5);
        break;
        this.cub.setVideoQuality(2, true, false);
        this.cua.setVideoEncodeGop(5);
        break;
        this.cub.setVideoQuality(3, true, false);
        this.cua.setVideoEncodeGop(5);
        break;
        this.cub.setVideoQuality(4, true, false);
        break;
        this.cub.setVideoQuality(5, true, false);
        break;
        this.cub.setVideoQuality(6, false, false);
        break;
        this.cub.setVideoQuality(7, true, false);
        this.cua.setVideoEncodeGop(5);
        break;
        if (k != 2) {
          break label401;
        }
        this.cua.setVideoResolution(0);
        break label401;
        label1991:
        if (!((String)localObject1).equalsIgnoreCase("high")) {
          break label459;
        }
        this.cua.setAudioSampleRate(48000);
        break label459;
        label2014:
        bool1 = false;
        break label486;
        label2020:
        if (!((String)localObject2).equalsIgnoreCase("vertical")) {
          break label617;
        }
        j(this.ctP, (String)localObject2);
        this.cub.setRenderRotation(0);
        break label617;
        if (str1.equalsIgnoreCase("enable"))
        {
          this.cua.setLocalVideoMirrorType(1);
          break label660;
        }
        if (!str1.equalsIgnoreCase("disable")) {
          break label660;
        }
        this.cua.setLocalVideoMirrorType(2);
        break label660;
        label2095:
        this.cua.setPauseFlag(3);
        break label722;
        label2106:
        if ((!this.cub.isPushing()) || (!paramBundle.keySet().contains("watermarkImage"))) {
          break label821;
        }
        this.cua.setWatermark((Bitmap)localObject4, f1, f2, f3);
        break label821;
        label2148:
        if (((String)localObject4).equalsIgnoreCase("media"))
        {
          this.cua.setVolumeType(1);
          break label919;
        }
        this.cua.setVolumeType(0);
        break label919;
        bool2 = false;
        break label946;
        stopPreview();
        break label1220;
        label2194:
        this.cub.stopAudioRecord();
        break label1274;
        label2204:
        bool2 = false;
        break label1301;
        label2210:
        bool2 = false;
        break label1322;
        label2216:
        if (!paramBundle.keySet().contains("muted")) {
          break label1328;
        }
        bool2 = paramBundle.getBoolean("muted", this.cur);
        if ((paramBoolean) || (bool2 != this.cur)) {
          this.cub.setMute(bool2);
        }
        this.cur = bool2;
        break label1328;
        label2275:
        if (!paramBundle.keySet().contains("mirror")) {
          break label1525;
        }
        bool1 = paramBundle.getBoolean("mirror");
        break label1525;
        label2302:
        this.cub.setBeautyFilter(0, i, j, 2);
        break label1648;
      }
      k = i;
      i = j;
    }
  }
  
  final void bB(boolean paramBoolean)
  {
    AppMethodBeat.i(138905);
    if ((!this.cue) && (paramBoolean))
    {
      if (this.mVideoView != null) {
        this.mVideoView.setVisibility(0);
      }
      if (this.mSurface != null) {
        this.cub.setSurface(this.mSurface);
      }
      this.cub.startCameraPreview(this.mVideoView);
      this.cue = true;
    }
    AppMethodBeat.o(138905);
  }
  
  final void bC(boolean paramBoolean)
  {
    AppMethodBeat.i(138907);
    if (paramBoolean) {
      this.cub.startAudioRecord();
    }
    AppMethodBeat.o(138907);
  }
  
  public final a bD(boolean paramBoolean)
  {
    AppMethodBeat.i(138910);
    this.cug = this.cub.isPushing();
    if (this.cug)
    {
      if (paramBoolean)
      {
        this.cuh = paramBoolean;
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
  
  public final a bV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138909);
    this.cub.setSurfaceSize(paramInt1, paramInt2);
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
    ae.i("TXLivePusherJSAdapter", "operateLivePusher: type = " + paramString + " params = " + str);
    if (paramString.equalsIgnoreCase("start")) {
      if ((this.cud != null) && (!this.cud.isEmpty()) && (!this.cub.isPushing()))
      {
        bB(this.cut);
        bC(this.cuu);
        if ((this.cut) && (this.mSurface != null)) {
          this.cub.setSurface(this.mSurface);
        }
        this.cub.startPusher(this.cud);
      }
    }
    for (;;)
    {
      paramString = new a();
      AppMethodBeat.o(138904);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.cuB = false;
        try
        {
          this.cub.stopBGM();
          stopPreview();
          this.cub.stopAudioRecord();
          this.cub.stopPusher();
          continue;
        }
        finally
        {
          AppMethodBeat.o(138904);
        }
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        if ((this.cuB) && (this.cub.isPushing())) {
          this.cub.turnOnFlashLight(false);
        }
        this.cub.pausePusher();
        this.cum = this.cul;
        if (this.cum) {
          c("pauseBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.cub.resumePusher();
        if (this.cum) {
          c("resumeBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("startPreview"))
      {
        if (this.cub.isPushing())
        {
          ae.i("TXLivePusherJSAdapter", "do not support startPreview when pushing");
        }
        else
        {
          stopPreview();
          bB(this.cut);
        }
      }
      else if (paramString.equalsIgnoreCase("stopPreview"))
      {
        if (this.cub.isPushing()) {
          ae.i("TXLivePusherJSAdapter", "do not support stopPreview when pushing");
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
            this.cua.setFrontCamera(this.mFrontCamera);
            this.cub.switchCamera();
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
          paramString = this.cui;
          if ((this.cub != null) && (this.cub.isPushing())) {
            this.cub.snapshot(new TXLivePusher.ITXSnapshotListener()
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
                      b.r(paramAnonymousBitmap);
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
            if (!this.cuB)
            {
              bool2 = this.cub.turnOnFlashLight(bool1);
              if (!bool2) {
                break label699;
              }
              label654:
              this.cuB = bool1;
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
              bool1 = this.cuB;
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
            ae.i("TXLivePusherJSAdapter", "playBGM filePath = ".concat(String.valueOf(paramString)));
            if ((paramString != null) && (paramString.length() > 0))
            {
              this.cub.playBGM(paramString);
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
            this.cub.stopBGM();
            this.cul = false;
          }
          else if (paramString.equalsIgnoreCase("pauseBGM"))
          {
            this.cub.pauseBGM();
            this.cul = false;
          }
          else
          {
            if (!paramString.equalsIgnoreCase("resumeBGM")) {
              break;
            }
            this.cub.resumeBGM();
            this.cul = true;
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
      this.cub.setBGMVolume((float)d);
      break;
      if (paramString.equalsIgnoreCase("setMICVolume"))
      {
        if (paramJSONObject != null) {
          d = paramJSONObject.optDouble("volume", 1.0D);
        }
        this.cub.setMicVolume((float)d);
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
          bool1 = this.cub.sendMessageEx(paramString.getBytes());
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
  
  public final void gL(final int paramInt)
  {
    AppMethodBeat.i(138901);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138898);
        b.a(b.this, paramInt);
        ae.i("TXLivePusherJSAdapter", "notifyOrientationChanged, angle:" + paramInt + ", orientation:" + b.a(b.this));
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
    String str = paramBundle.getString("pushUrl", this.cud);
    if ((str != null) && (!str.isEmpty()) && (this.cud != null) && (!this.cud.equalsIgnoreCase(str)) && (this.cub.isPushing()))
    {
      ae.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
      stopPreview();
      this.cub.stopAudioRecord();
      this.cub.stopPusher();
    }
    this.cud = str;
    this.cub.setPusherUrl(this.cud);
    this.cun = paramBundle.getBoolean("autopush", this.cun);
    if ((this.cun) && (this.cud != null) && (!this.cud.isEmpty()) && (!this.cub.isPushing()))
    {
      ae.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
      bB(this.cut);
      bC(this.cuu);
      if ((this.cut) && (this.mSurface != null)) {
        this.cub.setSurface(this.mSurface);
      }
      this.cub.startPusher(this.cud);
    }
    paramBundle = new a();
    AppMethodBeat.o(138903);
    return paramBundle;
  }
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(178841);
    if ((this.ctm) && (this.cuk != null)) {
      this.cuk.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(178841);
  }
  
  public final void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(138915);
    this.cul = false;
    if ((this.cuC) && (this.cuj != null)) {
      this.cuj.onBGMComplete(paramInt);
    }
    AppMethodBeat.o(138915);
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(138914);
    if ((this.cuC) && (this.cuj != null)) {
      this.cuj.onBGMProgress(paramLong1, paramLong2);
    }
    AppMethodBeat.o(138914);
  }
  
  public final void onBGMStart()
  {
    AppMethodBeat.i(138913);
    this.cul = true;
    if ((this.cuC) && (this.cuj != null)) {
      this.cuj.onBGMStart();
    }
    AppMethodBeat.o(138913);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(138912);
    if (this.cuc != null) {
      this.cuc.onNetStatus(paramBundle);
    }
    ae.i("TXLivePusherJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
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
      if (this.cuc != null) {
        this.cuc.onPushEvent(paramInt, paramBundle);
      }
      paramBundle = paramBundle.getString("EVT_MSG");
      ae.i("TXLivePusherJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
      AppMethodBeat.o(138911);
      return;
      if ((paramInt == 1003) && (this.cuB)) {
        this.cub.turnOnFlashLight(this.cuB);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.b
 * JD-Core Version:    0.7.0.1
 */