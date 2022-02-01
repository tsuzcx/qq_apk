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
  private String csC;
  private boolean csI;
  private boolean csJ;
  private boolean csL;
  String ctA;
  private boolean ctB;
  private String ctC;
  boolean ctD;
  boolean ctE;
  TXLivePusher.ITXSnapshotListener ctF;
  TXLivePusher.OnBGMNotify ctG;
  TXLivePusher.ITXAudioVolumeEvaluationListener ctH;
  private boolean ctI;
  private boolean ctJ;
  boolean ctK;
  private int ctL;
  private int ctM;
  private int ctN;
  private boolean ctO;
  private int ctP;
  boolean ctQ;
  boolean ctR;
  private String ctS;
  private int ctT;
  private int ctU;
  private String ctV;
  private String ctW;
  private boolean ctX;
  private boolean ctY;
  private boolean ctZ;
  private String ctf;
  private int ctl;
  private WXLivePushConfig ctw;
  WXLivePusher cty;
  ITXLivePushListener ctz;
  private boolean cua;
  private String cub;
  private float cuc;
  private float cud;
  private String cue;
  private boolean cuf;
  private String cug;
  private int cuh;
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
    this.ctl = 0;
    this.mInited = false;
    this.ctB = false;
    this.mFrontCamera = true;
    this.ctC = "front";
    this.ctD = false;
    this.ctE = false;
    this.ctI = false;
    this.ctJ = false;
    this.ctK = false;
    this.mMode = 1;
    this.ctL = 2;
    this.ctM = -1;
    this.ctN = -1;
    this.ctO = false;
    this.ctP = 0;
    this.ctQ = true;
    this.ctR = true;
    this.csC = "vertical";
    this.ctS = "high";
    this.ctT = 5;
    this.ctU = 3;
    this.ctV = "smooth";
    this.ctf = "";
    this.ctW = "";
    this.ctX = false;
    this.ctY = false;
    this.mEnableZoom = true;
    this.csI = false;
    this.ctZ = false;
    this.csL = false;
    this.cua = false;
    this.cub = "auto";
    this.cuc = 0.0F;
    this.cud = 0.0F;
    this.mWatermarkWidth = 0.1F;
    this.cue = "";
    this.mEnableAgc = false;
    this.mEnableAns = false;
    this.cuf = false;
    this.cug = "auto";
    this.cuh = 0;
    this.mVideoWidth = 368;
    this.mVideoHeight = 640;
    this.csJ = false;
    this.mContext = paramContext;
    this.ctw = new WXLivePushConfig();
    this.cty = new WXLivePusher(paramContext);
    this.cty.setConfig(this.ctw);
    this.cty.setPushListener(this);
    this.cty.setBGMNofify(this);
    this.cty.setAudioVolumeEvaluationListener(this);
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
        this.ctw.setHomeOrientation(paramInt);
        this.cty.setConfig(this.ctw);
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
    this.cty.stopCameraPreview(true);
    this.ctB = false;
    AppMethodBeat.o(138906);
  }
  
  public final a Gn()
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
      this.cty.stopBGM();
      stopPreview();
      this.cty.stopAudioRecord();
      this.cty.stopPusher();
      this.cty.setPushListener(null);
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
      m = this.ctM;
      n = this.ctN;
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
                this.ctw.setMinVideoBitrate(m);
                this.ctw.setMaxVideoBitrate(i);
                i1 = m;
                j = i;
              }
            }
          }
        }
      }
      k = paramBundle.getInt("aspect", this.ctL);
      m = paramBundle.getInt("videoWidth", this.mVideoWidth);
      n = paramBundle.getInt("videoHeight", this.mVideoHeight);
      Object localObject1 = paramBundle.getString("audioQuality", this.ctS);
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
          this.ctw.setVideoResolution(13);
          if ((m > 0) && (m <= 1920) && (n > 0) && (n <= 1920)) {
            this.ctw.setVideoResolution(m, n);
          }
          if (!((String)localObject1).equalsIgnoreCase("low")) {
            break label1982;
          }
          this.ctw.setAudioSampleRate(16000);
        }
      }
      else
      {
        int i3 = paramBundle.getInt("focusMode", this.ctP);
        localObject2 = this.ctw;
        if (i3 == 0) {
          break label2005;
        }
        bool1 = true;
        ((WXLivePushConfig)localObject2).setTouchFocus(bool1);
        bool2 = this.mFrontCamera;
        bool1 = bool2;
        if (paramBundle.keySet().contains("devicePosition"))
        {
          this.ctC = paramBundle.getString("devicePosition", this.ctC);
          bool1 = bool2;
          if (this.ctC.equalsIgnoreCase("back")) {
            bool1 = false;
          }
          this.ctw.setFrontCamera(bool1);
        }
        localObject2 = paramBundle.getString("orientation", this.csC);
        if (!((String)localObject2).equalsIgnoreCase(this.csC))
        {
          if (!((String)localObject2).equalsIgnoreCase("horizontal")) {
            break label2011;
          }
          j(this.ctl, (String)localObject2);
          this.cty.setRenderRotation(90);
        }
        str1 = paramBundle.getString("localMirror", this.cub);
        if (!str1.equalsIgnoreCase(this.cub))
        {
          if (!str1.equalsIgnoreCase("auto")) {
            break label2042;
          }
          this.ctw.setLocalVideoMirrorType(0);
        }
        String str2 = paramBundle.getString("backgroundImage", this.ctW);
        Object localObject3 = BitmapFactory.decodeFile(str2);
        if (localObject3 != null) {
          this.ctw.setPauseImg((Bitmap)localObject3);
        }
        boolean bool3 = paramBundle.getBoolean("backgroundMute", this.ctX);
        if (i2 != 6) {
          break label2086;
        }
        this.ctw.setPauseFlag(1);
        boolean bool4 = paramBundle.getBoolean("zoom", this.mEnableZoom);
        this.ctw.setEnableZoom(bool4);
        f1 = paramBundle.getFloat("watermarkLeft", this.cuc);
        f2 = paramBundle.getFloat("watermarkTop", this.cud);
        f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
        localObject3 = paramBundle.getString("watermarkImage", this.cue);
        localObject4 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject4 == null) {
          break label2097;
        }
        this.ctw.setWatermark((Bitmap)localObject4, f1, f2, f3);
        label821:
        boolean bool5 = paramBundle.getBoolean("enableAGC", this.mEnableAgc);
        this.ctw.enableAGC(bool5);
        boolean bool6 = paramBundle.getBoolean("enableANS", this.mEnableAns);
        this.ctw.enableANS(bool6);
        boolean bool7 = paramBundle.getBoolean("enableEarMonitor", this.cuf);
        this.ctw.enableAudioEarMonitoring(bool7);
        localObject4 = paramBundle.getString("audioVolumeType", this.cug);
        if (!((String)localObject4).equalsIgnoreCase("voicecall")) {
          break label2139;
        }
        this.ctw.setVolumeType(2);
        label919:
        boolean bool8 = paramBundle.getBoolean("enableCamera", this.ctQ);
        Object localObject5 = this.ctw;
        if (bool8) {
          break label2172;
        }
        bool2 = true;
        label946:
        ((WXLivePushConfig)localObject5).enablePureAudioPush(bool2);
        i = 0;
        if ((k != this.ctL) || (i1 != this.ctM) || (j != this.ctN) || (i3 != this.ctP) || (bool1 != this.mFrontCamera) || (bool3 != this.ctX) || (bool4 != this.mEnableZoom) || (bool5 != this.mEnableAgc) || (bool6 != this.mEnableAns) || (bool7 != this.cuf) || (bool8 != this.ctQ) || (m != this.mVideoWidth) || (n != this.mVideoHeight) || (f1 != this.cuc) || (f2 != this.cud) || (f3 != this.mWatermarkWidth) || (!str1.equalsIgnoreCase(this.cub)) || (!((String)localObject4).equalsIgnoreCase(this.cug)) || (!str2.equalsIgnoreCase(this.ctW)) || (!((String)localObject2).equalsIgnoreCase(this.csC)) || (!((String)localObject1).equalsIgnoreCase(this.ctS)) || (!((String)localObject3).equalsIgnoreCase(this.cue))) {
          i = 1;
        }
        if ((paramBoolean) || (i != 0)) {
          this.cty.setConfig(this.ctw);
        }
        if (bool8 != this.ctQ)
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
        boolean bool9 = paramBundle.getBoolean("enableMic", this.ctR);
        if (bool9 != this.ctR)
        {
          if (!bool9) {
            break label2185;
          }
          this.cty.stopAudioRecord();
          bC(true);
        }
        label1274:
        if ((paramBoolean) || (bool9 != this.ctR))
        {
          localObject5 = this.cty;
          if (bool9) {
            break label2195;
          }
          bool2 = true;
          ((WXLivePusher)localObject5).setMute(bool2);
        }
        label1301:
        this.ctR = bool9;
        if (bool9) {
          break label2201;
        }
        bool2 = true;
        label1322:
        this.ctO = bool2;
        label1328:
        this.mMode = i2;
        this.ctL = k;
        this.ctP = i3;
        this.ctQ = bool8;
        this.mEnableAgc = bool5;
        this.mEnableAns = bool6;
        this.cuf = bool7;
        this.cub = str1;
        this.cug = ((String)localObject4);
        this.mVideoWidth = m;
        this.mVideoHeight = n;
        this.mFrontCamera = bool1;
        this.csC = ((String)localObject2);
        this.ctX = bool3;
        this.ctW = str2;
        this.ctM = i1;
        this.ctN = j;
        this.ctS = ((String)localObject1);
        this.mEnableZoom = bool4;
        this.cuc = f1;
        this.cud = f2;
        this.mWatermarkWidth = f3;
        this.cue = ((String)localObject3);
        this.csI = paramBundle.getBoolean("needEvent", this.csI);
        this.ctZ = paramBundle.getBoolean("needBGMEvent", this.ctZ);
        bool1 = this.cua;
        if (!paramBundle.keySet().contains("remoteMirror")) {
          break label2266;
        }
        bool1 = paramBundle.getBoolean("remoteMirror");
        label1525:
        if (bool1 != this.cua) {
          this.cty.setMirror(bool1);
        }
        this.cua = bool1;
        i = paramBundle.getInt("beauty", this.ctT);
        j = paramBundle.getInt("whiteness", this.ctU);
        localObject1 = paramBundle.getString("beautyStyle", this.ctV);
        if ((paramBoolean) || (i != this.ctT) || (!((String)localObject1).equalsIgnoreCase(this.ctV)))
        {
          if (!((String)localObject1).equalsIgnoreCase("nature")) {
            break label2293;
          }
          this.cty.setBeautyFilter(1, i, j, 2);
        }
        label1639:
        this.ctT = i;
        this.ctU = j;
        this.ctV = ((String)localObject1);
        localObject1 = paramBundle.getString("filterImage", this.ctf);
        if (!((String)localObject1).equalsIgnoreCase(this.ctf))
        {
          localObject2 = BitmapFactory.decodeFile((String)localObject1);
          this.cty.setFilter((Bitmap)localObject2);
        }
        this.ctf = ((String)localObject1);
        i = paramBundle.getInt("audioReverbType", this.cuh);
        if (i != this.cuh) {
          this.cty.setReverb(i);
        }
        this.cuh = i;
        bool1 = paramBundle.getBoolean("needAudioVolume", this.csJ);
        if (bool1 != this.csJ)
        {
          localObject1 = this.cty;
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
        this.csJ = bool1;
        bool1 = paramBundle.getBoolean("debug", this.csL);
        if ((paramBoolean) || (bool1 != this.csL)) {
          this.cty.showDebugLog(bool1);
        }
        this.csL = bool1;
        AppMethodBeat.o(138916);
        return;
        this.cty.setVideoQuality(1, true, false);
        this.ctw.setVideoEncodeGop(5);
        break;
        this.cty.setVideoQuality(2, true, false);
        this.ctw.setVideoEncodeGop(5);
        break;
        this.cty.setVideoQuality(3, true, false);
        this.ctw.setVideoEncodeGop(5);
        break;
        this.cty.setVideoQuality(4, true, false);
        break;
        this.cty.setVideoQuality(5, true, false);
        break;
        this.cty.setVideoQuality(6, false, false);
        break;
        this.cty.setVideoQuality(7, true, false);
        this.ctw.setVideoEncodeGop(5);
        break;
        if (k != 2) {
          break label401;
        }
        this.ctw.setVideoResolution(0);
        break label401;
        label1982:
        if (!((String)localObject1).equalsIgnoreCase("high")) {
          break label459;
        }
        this.ctw.setAudioSampleRate(48000);
        break label459;
        label2005:
        bool1 = false;
        break label486;
        label2011:
        if (!((String)localObject2).equalsIgnoreCase("vertical")) {
          break label617;
        }
        j(this.ctl, (String)localObject2);
        this.cty.setRenderRotation(0);
        break label617;
        label2042:
        if (str1.equalsIgnoreCase("enable"))
        {
          this.ctw.setLocalVideoMirrorType(1);
          break label660;
        }
        if (!str1.equalsIgnoreCase("disable")) {
          break label660;
        }
        this.ctw.setLocalVideoMirrorType(2);
        break label660;
        label2086:
        this.ctw.setPauseFlag(3);
        break label722;
        label2097:
        if ((!this.cty.isPushing()) || (!paramBundle.keySet().contains("watermarkImage"))) {
          break label821;
        }
        this.ctw.setWatermark((Bitmap)localObject4, f1, f2, f3);
        break label821;
        label2139:
        if (((String)localObject4).equalsIgnoreCase("media"))
        {
          this.ctw.setVolumeType(1);
          break label919;
        }
        this.ctw.setVolumeType(0);
        break label919;
        label2172:
        bool2 = false;
        break label946;
        stopPreview();
        break label1220;
        label2185:
        this.cty.stopAudioRecord();
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
        bool2 = paramBundle.getBoolean("muted", this.ctO);
        if ((paramBoolean) || (bool2 != this.ctO)) {
          this.cty.setMute(bool2);
        }
        this.ctO = bool2;
        break label1328;
        label2266:
        if (!paramBundle.keySet().contains("mirror")) {
          break label1525;
        }
        bool1 = paramBundle.getBoolean("mirror");
        break label1525;
        label2293:
        this.cty.setBeautyFilter(0, i, j, 2);
        break label1639;
      }
      k = i;
      i = j;
    }
  }
  
  final void bB(boolean paramBoolean)
  {
    AppMethodBeat.i(138905);
    if ((!this.ctB) && (paramBoolean))
    {
      if (this.mVideoView != null) {
        this.mVideoView.setVisibility(0);
      }
      if (this.mSurface != null) {
        this.cty.setSurface(this.mSurface);
      }
      this.cty.startCameraPreview(this.mVideoView);
      this.ctB = true;
    }
    AppMethodBeat.o(138905);
  }
  
  final void bC(boolean paramBoolean)
  {
    AppMethodBeat.i(138907);
    if (paramBoolean) {
      this.cty.startAudioRecord();
    }
    AppMethodBeat.o(138907);
  }
  
  public final a bD(boolean paramBoolean)
  {
    AppMethodBeat.i(138910);
    this.ctD = this.cty.isPushing();
    if (this.ctD)
    {
      if (paramBoolean)
      {
        this.ctE = paramBoolean;
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
    this.cty.setSurfaceSize(paramInt1, paramInt2);
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
      if ((this.ctA != null) && (!this.ctA.isEmpty()) && (!this.cty.isPushing()))
      {
        bB(this.ctQ);
        bC(this.ctR);
        if ((this.ctQ) && (this.mSurface != null)) {
          this.cty.setSurface(this.mSurface);
        }
        this.cty.startPusher(this.ctA);
      }
    }
    for (;;)
    {
      paramString = new a();
      AppMethodBeat.o(138904);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.ctY = false;
        try
        {
          this.cty.stopBGM();
          stopPreview();
          this.cty.stopAudioRecord();
          this.cty.stopPusher();
          continue;
        }
        finally
        {
          AppMethodBeat.o(138904);
        }
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        if ((this.ctY) && (this.cty.isPushing())) {
          this.cty.turnOnFlashLight(false);
        }
        this.cty.pausePusher();
        this.ctJ = this.ctI;
        if (this.ctJ) {
          c("pauseBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.cty.resumePusher();
        if (this.ctJ) {
          c("resumeBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("startPreview"))
      {
        if (this.cty.isPushing())
        {
          ad.i("TXLivePusherJSAdapter", "do not support startPreview when pushing");
        }
        else
        {
          stopPreview();
          bB(this.ctQ);
        }
      }
      else if (paramString.equalsIgnoreCase("stopPreview"))
      {
        if (this.cty.isPushing()) {
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
            this.ctw.setFrontCamera(this.mFrontCamera);
            this.cty.switchCamera();
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
          paramString = this.ctF;
          if ((this.cty != null) && (this.cty.isPushing())) {
            this.cty.snapshot(new TXLivePusher.ITXSnapshotListener()
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
            if (!this.ctY)
            {
              bool2 = this.cty.turnOnFlashLight(bool1);
              if (!bool2) {
                break label699;
              }
              label654:
              this.ctY = bool1;
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
              bool1 = this.ctY;
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
              this.cty.playBGM(paramString);
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
            this.cty.stopBGM();
            this.ctI = false;
          }
          else if (paramString.equalsIgnoreCase("pauseBGM"))
          {
            this.cty.pauseBGM();
            this.ctI = false;
          }
          else
          {
            if (!paramString.equalsIgnoreCase("resumeBGM")) {
              break;
            }
            this.cty.resumeBGM();
            this.ctI = true;
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
      this.cty.setBGMVolume((float)d);
      break;
      if (paramString.equalsIgnoreCase("setMICVolume"))
      {
        if (paramJSONObject != null) {
          d = paramJSONObject.optDouble("volume", 1.0D);
        }
        this.cty.setMicVolume((float)d);
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
          bool1 = this.cty.sendMessageEx(paramString.getBytes());
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
  
  public final void gK(final int paramInt)
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
    String str = paramBundle.getString("pushUrl", this.ctA);
    if ((str != null) && (!str.isEmpty()) && (this.ctA != null) && (!this.ctA.equalsIgnoreCase(str)) && (this.cty.isPushing()))
    {
      ad.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
      stopPreview();
      this.cty.stopAudioRecord();
      this.cty.stopPusher();
    }
    this.ctA = str;
    this.cty.setPusherUrl(this.ctA);
    this.ctK = paramBundle.getBoolean("autopush", this.ctK);
    if ((this.ctK) && (this.ctA != null) && (!this.ctA.isEmpty()) && (!this.cty.isPushing()))
    {
      ad.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
      bB(this.ctQ);
      bC(this.ctR);
      if ((this.ctQ) && (this.mSurface != null)) {
        this.cty.setSurface(this.mSurface);
      }
      this.cty.startPusher(this.ctA);
    }
    paramBundle = new a();
    AppMethodBeat.o(138903);
    return paramBundle;
  }
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(178841);
    if ((this.csJ) && (this.ctH != null)) {
      this.ctH.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(178841);
  }
  
  public final void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(138915);
    this.ctI = false;
    if ((this.ctZ) && (this.ctG != null)) {
      this.ctG.onBGMComplete(paramInt);
    }
    AppMethodBeat.o(138915);
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(138914);
    if ((this.ctZ) && (this.ctG != null)) {
      this.ctG.onBGMProgress(paramLong1, paramLong2);
    }
    AppMethodBeat.o(138914);
  }
  
  public final void onBGMStart()
  {
    AppMethodBeat.i(138913);
    this.ctI = true;
    if ((this.ctZ) && (this.ctG != null)) {
      this.ctG.onBGMStart();
    }
    AppMethodBeat.o(138913);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(138912);
    if (this.ctz != null) {
      this.ctz.onNetStatus(paramBundle);
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
      if (this.ctz != null) {
        this.ctz.onPushEvent(paramInt, paramBundle);
      }
      paramBundle = paramBundle.getString("EVT_MSG");
      ad.i("TXLivePusherJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
      AppMethodBeat.o(138911);
      return;
      if ((paramInt == 1003) && (this.ctY)) {
        this.cty.turnOnFlashLight(this.ctY);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.b
 * JD-Core Version:    0.7.0.1
 */