package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
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

public final class m
  implements ITXLivePushListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.OnBGMNotify
{
  private String csC;
  private boolean csI;
  private boolean csJ;
  private boolean csL;
  String ctA;
  private boolean ctB;
  private String ctC;
  private boolean ctD;
  private boolean ctE;
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
  private Handler mHandler;
  boolean mInited;
  private int mMode;
  private int mVideoHeight;
  TXCloudVideoView mVideoView;
  private int mVideoWidth;
  private float mWatermarkWidth;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(145918);
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
    this.mHandler = new Handler(this.mContext.getMainLooper());
    this.ctw = new WXLivePushConfig();
    this.cty = new WXLivePusher(paramContext);
    this.cty.setConfig(this.ctw);
    this.cty.setPushListener(this);
    this.cty.setBGMNofify(this);
    this.cty.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(145918);
  }
  
  private void a(final boolean paramBoolean, final TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(145927);
    if ((this.cty != null) && (this.cty.isPushing())) {
      this.cty.snapshot(new TXLivePusher.ITXSnapshotListener()
      {
        public final void onSnapshot(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(145917);
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
                m.Q(paramAnonymousBitmap);
                AppMethodBeat.o(145917);
                return;
              }
              paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
              AppMethodBeat.o(145917);
              return;
            }
            paramITXSnapshotListener.onSnapshot(paramAnonymousBitmap);
          }
          AppMethodBeat.o(145917);
        }
      });
    }
    AppMethodBeat.o(145927);
  }
  
  private void j(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(145920);
    ad.i("TXLivePusherJSAdapter", "adjustHomeOrientation, angle:" + paramInt + ", orientation:" + paramString);
    if (paramInt == 1)
    {
      if (paramString.equals("horizontal")) {
        break label171;
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
      AppMethodBeat.o(145920);
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
          label171:
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
    AppMethodBeat.i(145934);
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
    AppMethodBeat.o(145934);
  }
  
  final void a(Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(145933);
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0))
    {
      AppMethodBeat.o(145933);
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
      label720:
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
            break label1981;
          }
          this.ctw.setAudioSampleRate(16000);
        }
      }
      else
      {
        int i3 = paramBundle.getInt("focusMode", this.ctP);
        localObject2 = this.ctw;
        if (i3 == 0) {
          break label2004;
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
            break label2010;
          }
          j(this.ctl, (String)localObject2);
          this.cty.setRenderRotation(90);
        }
        str1 = paramBundle.getString("localMirror", this.cub);
        if (!str1.equalsIgnoreCase(this.cub))
        {
          if (!str1.equalsIgnoreCase("auto")) {
            break label2041;
          }
          this.ctw.setLocalVideoMirrorType(0);
        }
        String str2 = paramBundle.getString("backgroundImage", this.ctW);
        Object localObject3 = BitmapFactory.decodeFile(str2);
        if (localObject3 != null) {
          this.ctw.setPauseImg((Bitmap)localObject3);
        }
        boolean bool3 = paramBundle.getBoolean("backgroundMute", this.ctX);
        if (!bool3) {
          break label2085;
        }
        this.ctw.setPauseFlag(3);
        boolean bool4 = paramBundle.getBoolean("zoom", this.mEnableZoom);
        this.ctw.setEnableZoom(bool4);
        f1 = paramBundle.getFloat("watermarkLeft", this.cuc);
        f2 = paramBundle.getFloat("watermarkTop", this.cud);
        f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
        localObject3 = paramBundle.getString("watermarkImage", this.cue);
        localObject4 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject4 == null) {
          break label2096;
        }
        this.ctw.setWatermark((Bitmap)localObject4, f1, f2, f3);
        label819:
        boolean bool5 = paramBundle.getBoolean("enableAGC", this.mEnableAgc);
        this.ctw.enableAGC(bool5);
        boolean bool6 = paramBundle.getBoolean("enableANS", this.mEnableAns);
        this.ctw.enableANS(bool6);
        boolean bool7 = paramBundle.getBoolean("enableEarMonitor", this.cuf);
        this.ctw.enableAudioEarMonitoring(bool7);
        localObject4 = paramBundle.getString("audioVolumeType", this.cug);
        if (!((String)localObject4).equalsIgnoreCase("voicecall")) {
          break label2138;
        }
        this.ctw.setVolumeType(2);
        label917:
        boolean bool8 = paramBundle.getBoolean("enableCamera", this.ctQ);
        Object localObject5 = this.ctw;
        if (bool8) {
          break label2171;
        }
        bool2 = true;
        label944:
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
            break label2177;
          }
          stopPreview();
          bB(bool8);
        }
        label1219:
        if (!paramBundle.keySet().contains("enableMic")) {
          break label2206;
        }
        boolean bool9 = paramBundle.getBoolean("enableMic", this.ctR);
        if (bool9 != this.ctR)
        {
          if (!bool9) {
            break label2184;
          }
          this.cty.stopAudioRecord();
          bC(true);
        }
        label1273:
        if ((paramBoolean) || (bool9 != this.ctR))
        {
          localObject5 = this.cty;
          if (bool9) {
            break label2194;
          }
          bool2 = true;
          ((WXLivePusher)localObject5).setMute(bool2);
        }
        label1300:
        this.ctR = bool9;
        if (bool9) {
          break label2200;
        }
        bool2 = true;
        label1321:
        this.ctO = bool2;
        label1327:
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
          break label2265;
        }
        bool1 = paramBundle.getBoolean("remoteMirror");
        label1524:
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
            break label2292;
          }
          this.cty.setBeautyFilter(1, i, j, 2);
        }
        label1638:
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
            break label2309;
          }
        }
      }
      label2177:
      label2309:
      for (i = 300;; i = 0)
      {
        ((WXLivePusher)localObject1).enableAudioVolumeEvaluation(i);
        this.csJ = bool1;
        bool1 = paramBundle.getBoolean("debug", this.csL);
        if ((paramBoolean) || (bool1 != this.csL)) {
          this.cty.showDebugLog(bool1);
        }
        this.csL = bool1;
        AppMethodBeat.o(145933);
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
        label1981:
        if (!((String)localObject1).equalsIgnoreCase("high")) {
          break label459;
        }
        this.ctw.setAudioSampleRate(48000);
        break label459;
        label2004:
        bool1 = false;
        break label486;
        label2010:
        if (!((String)localObject2).equalsIgnoreCase("vertical")) {
          break label617;
        }
        j(this.ctl, (String)localObject2);
        this.cty.setRenderRotation(0);
        break label617;
        label2041:
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
        label2085:
        this.ctw.setPauseFlag(1);
        break label720;
        label2096:
        if ((!this.cty.isPushing()) || (!paramBundle.keySet().contains("watermarkImage"))) {
          break label819;
        }
        this.ctw.setWatermark((Bitmap)localObject4, f1, f2, f3);
        break label819;
        label2138:
        if (((String)localObject4).equalsIgnoreCase("media"))
        {
          this.ctw.setVolumeType(1);
          break label917;
        }
        this.ctw.setVolumeType(0);
        break label917;
        label2171:
        bool2 = false;
        break label944;
        stopPreview();
        break label1219;
        label2184:
        this.cty.stopAudioRecord();
        break label1273;
        label2194:
        bool2 = false;
        break label1300;
        label2200:
        bool2 = false;
        break label1321;
        label2206:
        if (!paramBundle.keySet().contains("muted")) {
          break label1327;
        }
        bool2 = paramBundle.getBoolean("muted", this.ctO);
        if ((paramBoolean) || (bool2 != this.ctO)) {
          this.cty.setMute(bool2);
        }
        this.ctO = bool2;
        break label1327;
        label2265:
        if (!paramBundle.keySet().contains("mirror")) {
          break label1524;
        }
        bool1 = paramBundle.getBoolean("mirror");
        break label1524;
        label2292:
        this.cty.setBeautyFilter(0, i, j, 2);
        break label1638;
      }
      k = i;
      i = j;
    }
  }
  
  final void bB(boolean paramBoolean)
  {
    AppMethodBeat.i(145922);
    if ((!this.ctB) && (paramBoolean))
    {
      this.mVideoView.setVisibility(0);
      this.cty.startCameraPreview(this.mVideoView);
      this.ctB = true;
    }
    AppMethodBeat.o(145922);
  }
  
  final void bC(boolean paramBoolean)
  {
    AppMethodBeat.i(145924);
    if (paramBoolean) {
      this.cty.startAudioRecord();
    }
    AppMethodBeat.o(145924);
  }
  
  public final i bkI()
  {
    AppMethodBeat.i(145926);
    if (this.ctD)
    {
      if (this.ctE)
      {
        locali = i("start", null);
        AppMethodBeat.o(145926);
        return locali;
      }
      locali = i("resume", null);
      AppMethodBeat.o(145926);
      return locali;
    }
    i locali = new i();
    AppMethodBeat.o(145926);
    return locali;
  }
  
  public final void gK(final int paramInt)
  {
    AppMethodBeat.i(145919);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145916);
        m.a(m.this, paramInt);
        ad.i("TXLivePusherJSAdapter", "notifyOrientationChanged, angle:" + paramInt + ", orientation:" + m.a(m.this));
        m.a(m.this, paramInt, m.a(m.this));
        AppMethodBeat.o(145916);
      }
    });
    AppMethodBeat.o(145919);
  }
  
  public final i gy(boolean paramBoolean)
  {
    AppMethodBeat.i(145925);
    this.ctD = this.cty.isPushing();
    if (this.ctD)
    {
      if (paramBoolean)
      {
        this.ctE = paramBoolean;
        if ((this.csI) && (this.ctz != null)) {
          this.ctz.onPushEvent(5000, new Bundle());
        }
        locali = i("stop", null);
        AppMethodBeat.o(145925);
        return locali;
      }
      locali = i("pause", null);
      AppMethodBeat.o(145925);
      return locali;
    }
    i locali = new i();
    AppMethodBeat.o(145925);
    return locali;
  }
  
  public final i i(String paramString, JSONObject paramJSONObject)
  {
    boolean bool1 = true;
    double d = 1.0D;
    int i = 0;
    int j = 0;
    boolean bool2 = false;
    AppMethodBeat.i(145921);
    if (paramString == null)
    {
      paramString = new i(-1, "invalid params");
      AppMethodBeat.o(145921);
      return paramString;
    }
    if (!this.mInited)
    {
      paramString = new i(-3, "uninited livePusher");
      AppMethodBeat.o(145921);
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
        this.cty.startPusher(this.ctA);
      }
    }
    for (;;)
    {
      paramString = new i();
      AppMethodBeat.o(145921);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.ctY = false;
        this.cty.stopBGM();
        stopPreview();
        this.cty.stopAudioRecord();
        this.cty.stopPusher();
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        if ((this.ctY) && (this.cty.isPushing())) {
          this.cty.turnOnFlashLight(false);
        }
        this.cty.pausePusher();
        this.ctJ = this.ctI;
        if (this.ctJ) {
          i("pauseBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.cty.resumePusher();
        if (this.ctJ) {
          i("resumeBGM", null);
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
          a(bool1, this.ctF);
        }
        else
        {
          if (paramString.equalsIgnoreCase("toggleTorch"))
          {
            if (this.cty.isPushing())
            {
              if (!this.ctY)
              {
                bool2 = this.cty.turnOnFlashLight(bool1);
                if (!bool2) {
                  break label639;
                }
                label594:
                this.ctY = bool1;
                if (!bool2) {
                  break label648;
                }
                label605:
                if (!bool2) {
                  break label655;
                }
              }
              label648:
              label655:
              for (paramString = "Success";; paramString = "Failed")
              {
                paramString = new i(i, paramString);
                AppMethodBeat.o(145921);
                return paramString;
                bool1 = false;
                break;
                label639:
                bool1 = this.ctY;
                break label594;
                i = -2;
                break label605;
              }
            }
            paramString = new i(-2, "fail");
            AppMethodBeat.o(145921);
            return paramString;
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
              paramString = new i(-2, "fail");
              AppMethodBeat.o(145921);
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
        break label1053;
      }
    }
    label1053:
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
              break label1004;
            }
          }
          label1004:
          for (paramString = "Success";; paramString = "Failed")
          {
            paramString = new i(i, paramString);
            AppMethodBeat.o(145921);
            return paramString;
            i = -2;
            break;
          }
        }
        paramString = new i(-2, "fail");
        AppMethodBeat.o(145921);
        return paramString;
      }
      paramString = new i(-4, "invalid operate command");
      AppMethodBeat.o(145921);
      return paramString;
    }
  }
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(182556);
    if ((this.csJ) && (this.ctH != null)) {
      this.ctH.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(182556);
  }
  
  public final void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(145932);
    this.ctI = false;
    if ((this.ctZ) && (this.ctG != null)) {
      this.ctG.onBGMComplete(paramInt);
    }
    AppMethodBeat.o(145932);
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(145931);
    if ((this.ctZ) && (this.ctG != null)) {
      this.ctG.onBGMProgress(paramLong1, paramLong2);
    }
    AppMethodBeat.o(145931);
  }
  
  public final void onBGMStart()
  {
    AppMethodBeat.i(145930);
    this.ctI = true;
    if ((this.ctZ) && (this.ctG != null)) {
      this.ctG.onBGMStart();
    }
    AppMethodBeat.o(145930);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(145929);
    if (this.ctz != null) {
      this.ctz.onNetStatus(paramBundle);
    }
    ad.i("TXLivePusherJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(145929);
  }
  
  public final void onPushEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(145928);
    if ((paramInt == -1307) || (paramInt == -1313)) {
      i("stop", null);
    }
    for (;;)
    {
      if ((this.csI) && (this.ctz != null)) {
        this.ctz.onPushEvent(paramInt, paramBundle);
      }
      paramBundle = paramBundle.getString("EVT_MSG");
      ad.i("TXLivePusherJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
      AppMethodBeat.o(145928);
      return;
      if ((paramInt == 1003) && (this.ctY)) {
        this.cty.turnOnFlashLight(this.ctY);
      }
    }
  }
  
  final void stopPreview()
  {
    AppMethodBeat.i(145923);
    this.cty.stopCameraPreview(true);
    this.ctB = false;
    AppMethodBeat.o(145923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.m
 * JD-Core Version:    0.7.0.1
 */