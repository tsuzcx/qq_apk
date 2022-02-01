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

public final class m
  implements ITXLivePushListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.OnBGMNotify
{
  private boolean cFE;
  private boolean cFF;
  private boolean cFH;
  private String cFy;
  private WXLivePushConfig cHU;
  WXLivePusher cHV;
  ITXLivePushListener cHW;
  String cHX;
  private boolean cHY;
  private String cHZ;
  private String cHp;
  private int cHv;
  private String cIA;
  private boolean cIB;
  private String cIC;
  private int cID;
  private boolean cIa;
  private boolean cIb;
  TXLivePusher.ITXSnapshotListener cIc;
  TXLivePusher.OnBGMNotify cId;
  TXLivePusher.ITXAudioVolumeEvaluationListener cIe;
  private boolean cIf;
  private boolean cIg;
  boolean cIh;
  private int cIi;
  private int cIj;
  private int cIk;
  private int cIl;
  boolean cIm;
  boolean cIn;
  private String cIo;
  private int cIp;
  private int cIq;
  private String cIr;
  private String cIs;
  private boolean cIt;
  private boolean cIu;
  private boolean cIv;
  private boolean cIw;
  private String cIx;
  private float cIy;
  private float cIz;
  private Context mContext;
  private boolean mEnableAgc;
  private boolean mEnableAns;
  private boolean mEnableZoom;
  private boolean mFrontCamera;
  private Handler mHandler;
  boolean mInited;
  private int mMode;
  private boolean mMute;
  private int mVideoHeight;
  TXCloudVideoView mVideoView;
  private int mVideoWidth;
  private float mWatermarkWidth;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(145918);
    this.cHv = 0;
    this.mInited = false;
    this.cHY = false;
    this.mFrontCamera = true;
    this.cHZ = "front";
    this.cIa = false;
    this.cIb = false;
    this.cIf = false;
    this.cIg = false;
    this.cIh = false;
    this.mMode = 1;
    this.cIi = 2;
    this.cIj = -1;
    this.cIk = -1;
    this.mMute = false;
    this.cIl = 0;
    this.cIm = true;
    this.cIn = true;
    this.cFy = "vertical";
    this.cIo = "high";
    this.cIp = 5;
    this.cIq = 3;
    this.cIr = "smooth";
    this.cHp = "";
    this.cIs = "";
    this.cIt = false;
    this.cIu = false;
    this.mEnableZoom = true;
    this.cFE = false;
    this.cIv = false;
    this.cFH = false;
    this.cIw = false;
    this.cIx = "auto";
    this.cIy = 0.0F;
    this.cIz = 0.0F;
    this.mWatermarkWidth = 0.1F;
    this.cIA = "";
    this.mEnableAgc = false;
    this.mEnableAns = false;
    this.cIB = false;
    this.cIC = "auto";
    this.cID = 0;
    this.mVideoWidth = 368;
    this.mVideoHeight = 640;
    this.cFF = false;
    this.mContext = paramContext;
    this.mHandler = new Handler(this.mContext.getMainLooper());
    this.cHU = new WXLivePushConfig();
    this.cHV = new WXLivePusher(paramContext);
    this.cHV.setConfig(this.cHU);
    this.cHV.setPushListener(this);
    this.cHV.setBGMNofify(this);
    this.cHV.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(145918);
  }
  
  private void a(final boolean paramBoolean, final TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(145927);
    if ((this.cHV != null) && (this.cHV.isPushing())) {
      this.cHV.snapshot(new TXLivePusher.ITXSnapshotListener()
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
                m.U(paramAnonymousBitmap);
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
  
  private void k(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(145920);
    Log.i("TXLivePusherJSAdapter", "adjustHomeOrientation, angle:" + paramInt + ", orientation:" + paramString);
    if (paramInt == 1)
    {
      if (paramString.equals("horizontal")) {
        break label171;
      }
      paramInt = i;
    }
    for (;;)
    {
      Log.i("TXLivePusherJSAdapter", "adjustHomeOrientation, homeOrientation:".concat(String.valueOf(paramInt)));
      if (paramInt != -2147483648)
      {
        this.cHU.setHomeOrientation(paramInt);
        this.cHV.setConfig(this.cHU);
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
    Log.i("TXLivePusherJSAdapter", paramString);
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
      m = this.cIj;
      n = this.cIk;
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
                this.cHU.setMinVideoBitrate(m);
                this.cHU.setMaxVideoBitrate(i);
                i1 = m;
                j = i;
              }
            }
          }
        }
      }
      k = paramBundle.getInt("aspect", this.cIi);
      m = paramBundle.getInt("videoWidth", this.mVideoWidth);
      n = paramBundle.getInt("videoHeight", this.mVideoHeight);
      Object localObject1 = paramBundle.getString("audioQuality", this.cIo);
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
          this.cHU.setVideoResolution(13);
          if ((m > 0) && (m <= 1920) && (n > 0) && (n <= 1920)) {
            this.cHU.setVideoResolution(m, n);
          }
          if (!((String)localObject1).equalsIgnoreCase("low")) {
            break label1990;
          }
          this.cHU.setAudioSampleRate(16000);
        }
      }
      else
      {
        int i3 = paramBundle.getInt("focusMode", this.cIl);
        localObject2 = this.cHU;
        if (i3 == 0) {
          break label2013;
        }
        bool1 = true;
        ((WXLivePushConfig)localObject2).setTouchFocus(bool1);
        bool2 = this.mFrontCamera;
        bool1 = bool2;
        if (paramBundle.keySet().contains("devicePosition"))
        {
          this.cHZ = paramBundle.getString("devicePosition", this.cHZ);
          bool1 = bool2;
          if (this.cHZ.equalsIgnoreCase("back")) {
            bool1 = false;
          }
          this.cHU.setFrontCamera(bool1);
        }
        localObject2 = paramBundle.getString("orientation", this.cFy);
        if (!((String)localObject2).equalsIgnoreCase(this.cFy))
        {
          if (!((String)localObject2).equalsIgnoreCase("horizontal")) {
            break label2019;
          }
          k(this.cHv, (String)localObject2);
          this.cHV.setRenderRotation(90);
        }
        str1 = paramBundle.getString("localMirror", this.cIx);
        if (!str1.equalsIgnoreCase(this.cIx))
        {
          if (!str1.equalsIgnoreCase("auto")) {
            break label2050;
          }
          this.cHU.setLocalVideoMirrorType(0);
        }
        String str2 = paramBundle.getString("backgroundImage", this.cIs);
        Object localObject3 = BitmapFactory.decodeFile(str2);
        if (localObject3 != null) {
          this.cHU.setPauseImg((Bitmap)localObject3);
        }
        boolean bool3 = paramBundle.getBoolean("backgroundMute", this.cIt);
        if (!bool3) {
          break label2094;
        }
        this.cHU.setPauseFlag(3);
        boolean bool4 = paramBundle.getBoolean("zoom", this.mEnableZoom);
        this.cHU.setEnableZoom(bool4);
        f1 = paramBundle.getFloat("watermarkLeft", this.cIy);
        f2 = paramBundle.getFloat("watermarkTop", this.cIz);
        f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
        localObject3 = paramBundle.getString("watermarkImage", this.cIA);
        localObject4 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject4 == null) {
          break label2105;
        }
        this.cHU.setWatermark((Bitmap)localObject4, f1, f2, f3);
        label819:
        boolean bool5 = paramBundle.getBoolean("enableAGC", this.mEnableAgc);
        this.cHU.enableAGC(bool5);
        boolean bool6 = paramBundle.getBoolean("enableANS", this.mEnableAns);
        this.cHU.enableANS(bool6);
        boolean bool7 = paramBundle.getBoolean("enableEarMonitor", this.cIB);
        this.cHU.enableAudioEarMonitoring(bool7);
        localObject4 = paramBundle.getString("audioVolumeType", this.cIC);
        if (!((String)localObject4).equalsIgnoreCase("voicecall")) {
          break label2147;
        }
        this.cHU.setVolumeType(2);
        label917:
        boolean bool8 = paramBundle.getBoolean("enableCamera", this.cIm);
        Object localObject5 = this.cHU;
        if (bool8) {
          break label2180;
        }
        bool2 = true;
        label944:
        ((WXLivePushConfig)localObject5).enablePureAudioPush(bool2);
        i = 0;
        if ((k != this.cIi) || (i1 != this.cIj) || (j != this.cIk) || (i3 != this.cIl) || (bool1 != this.mFrontCamera) || (bool3 != this.cIt) || (bool4 != this.mEnableZoom) || (bool5 != this.mEnableAgc) || (bool6 != this.mEnableAns) || (bool7 != this.cIB) || (bool8 != this.cIm) || (m != this.mVideoWidth) || (n != this.mVideoHeight) || (f1 != this.cIy) || (f2 != this.cIz) || (f3 != this.mWatermarkWidth) || (!str1.equalsIgnoreCase(this.cIx)) || (!((String)localObject4).equalsIgnoreCase(this.cIC)) || (!str2.equalsIgnoreCase(this.cIs)) || (!((String)localObject2).equalsIgnoreCase(this.cFy)) || (!((String)localObject1).equalsIgnoreCase(this.cIo)) || (!((String)localObject3).equalsIgnoreCase(this.cIA))) {
          i = 1;
        }
        if ((paramBoolean) || (i != 0)) {
          this.cHV.setConfig(this.cHU);
        }
        if (bool8 != this.cIm)
        {
          if (!bool8) {
            break label2186;
          }
          stopPreview();
          ca(bool8);
        }
        label1219:
        if (!paramBundle.keySet().contains("enableMic")) {
          break label2215;
        }
        boolean bool9 = paramBundle.getBoolean("enableMic", this.cIn);
        if (bool9 != this.cIn)
        {
          if (!bool9) {
            break label2193;
          }
          this.cHV.stopAudioRecord();
          cb(true);
        }
        label1273:
        if ((paramBoolean) || (bool9 != this.cIn))
        {
          localObject5 = this.cHV;
          if (bool9) {
            break label2203;
          }
          bool2 = true;
          ((WXLivePusher)localObject5).setMute(bool2);
        }
        label1300:
        this.cIn = bool9;
        if (bool9) {
          break label2209;
        }
        bool2 = true;
        label1321:
        this.mMute = bool2;
        label1327:
        this.mMode = i2;
        this.cIi = k;
        this.cIl = i3;
        this.cIm = bool8;
        this.mEnableAgc = bool5;
        this.mEnableAns = bool6;
        this.cIB = bool7;
        this.cIx = str1;
        this.cIC = ((String)localObject4);
        this.mVideoWidth = m;
        this.mVideoHeight = n;
        this.mFrontCamera = bool1;
        this.cFy = ((String)localObject2);
        this.cIt = bool3;
        this.cIs = str2;
        this.cIj = i1;
        this.cIk = j;
        this.cIo = ((String)localObject1);
        this.mEnableZoom = bool4;
        this.cIy = f1;
        this.cIz = f2;
        this.mWatermarkWidth = f3;
        this.cIA = ((String)localObject3);
        this.cFE = paramBundle.getBoolean("needEvent", this.cFE);
        this.cIv = paramBundle.getBoolean("needBGMEvent", this.cIv);
        bool1 = this.cIw;
        if (!paramBundle.keySet().contains("remoteMirror")) {
          break label2274;
        }
        bool1 = paramBundle.getBoolean("remoteMirror");
        label1524:
        if (bool1 != this.cIw) {
          this.cHV.setMirror(bool1);
        }
        this.cIw = bool1;
        i = paramBundle.getInt("beauty", this.cIp);
        j = paramBundle.getInt("whiteness", this.cIq);
        localObject1 = paramBundle.getString("beautyStyle", this.cIr);
        if ((paramBoolean) || (i != this.cIp) || (j != this.cIq) || (!((String)localObject1).equalsIgnoreCase(this.cIr)))
        {
          if (!((String)localObject1).equalsIgnoreCase("nature")) {
            break label2301;
          }
          this.cHV.setBeautyFilter(1, i, j, 2);
        }
        label1647:
        this.cIp = i;
        this.cIq = j;
        this.cIr = ((String)localObject1);
        localObject1 = paramBundle.getString("filterImage", this.cHp);
        if (!((String)localObject1).equalsIgnoreCase(this.cHp))
        {
          localObject2 = BitmapFactory.decodeFile((String)localObject1);
          this.cHV.setFilter((Bitmap)localObject2);
        }
        this.cHp = ((String)localObject1);
        i = paramBundle.getInt("audioReverbType", this.cID);
        if (i != this.cID) {
          this.cHV.setReverb(i);
        }
        this.cID = i;
        bool1 = paramBundle.getBoolean("needAudioVolume", this.cFF);
        if (bool1 != this.cFF)
        {
          localObject1 = this.cHV;
          if (!bool1) {
            break label2318;
          }
        }
      }
      label2050:
      label2180:
      label2186:
      label2318:
      for (i = 300;; i = 0)
      {
        ((WXLivePusher)localObject1).enableAudioVolumeEvaluation(i);
        this.cFF = bool1;
        bool1 = paramBundle.getBoolean("debug", this.cFH);
        if ((paramBoolean) || (bool1 != this.cFH)) {
          this.cHV.showDebugLog(bool1);
        }
        this.cFH = bool1;
        AppMethodBeat.o(145933);
        return;
        this.cHV.setVideoQuality(1, true, false);
        this.cHU.setVideoEncodeGop(5);
        break;
        this.cHV.setVideoQuality(2, true, false);
        this.cHU.setVideoEncodeGop(5);
        break;
        this.cHV.setVideoQuality(3, true, false);
        this.cHU.setVideoEncodeGop(5);
        break;
        this.cHV.setVideoQuality(4, true, false);
        break;
        this.cHV.setVideoQuality(5, true, false);
        break;
        this.cHV.setVideoQuality(6, false, false);
        break;
        this.cHV.setVideoQuality(7, true, false);
        this.cHU.setVideoEncodeGop(5);
        break;
        if (k != 2) {
          break label401;
        }
        this.cHU.setVideoResolution(0);
        break label401;
        label1990:
        if (!((String)localObject1).equalsIgnoreCase("high")) {
          break label459;
        }
        this.cHU.setAudioSampleRate(48000);
        break label459;
        label2013:
        bool1 = false;
        break label486;
        label2019:
        if (!((String)localObject2).equalsIgnoreCase("vertical")) {
          break label617;
        }
        k(this.cHv, (String)localObject2);
        this.cHV.setRenderRotation(0);
        break label617;
        if (str1.equalsIgnoreCase("enable"))
        {
          this.cHU.setLocalVideoMirrorType(1);
          break label660;
        }
        if (!str1.equalsIgnoreCase("disable")) {
          break label660;
        }
        this.cHU.setLocalVideoMirrorType(2);
        break label660;
        label2094:
        this.cHU.setPauseFlag(1);
        break label720;
        label2105:
        if ((!this.cHV.isPushing()) || (!paramBundle.keySet().contains("watermarkImage"))) {
          break label819;
        }
        this.cHU.setWatermark((Bitmap)localObject4, f1, f2, f3);
        break label819;
        label2147:
        if (((String)localObject4).equalsIgnoreCase("media"))
        {
          this.cHU.setVolumeType(1);
          break label917;
        }
        this.cHU.setVolumeType(0);
        break label917;
        bool2 = false;
        break label944;
        stopPreview();
        break label1219;
        label2193:
        this.cHV.stopAudioRecord();
        break label1273;
        label2203:
        bool2 = false;
        break label1300;
        label2209:
        bool2 = false;
        break label1321;
        label2215:
        if (!paramBundle.keySet().contains("muted")) {
          break label1327;
        }
        bool2 = paramBundle.getBoolean("muted", this.mMute);
        if ((paramBoolean) || (bool2 != this.mMute)) {
          this.cHV.setMute(bool2);
        }
        this.mMute = bool2;
        break label1327;
        label2274:
        if (!paramBundle.keySet().contains("mirror")) {
          break label1524;
        }
        bool1 = paramBundle.getBoolean("mirror");
        break label1524;
        label2301:
        this.cHV.setBeautyFilter(0, i, j, 2);
        break label1647;
      }
      k = i;
      i = j;
    }
  }
  
  public final i bGO()
  {
    AppMethodBeat.i(145926);
    if (this.cIa)
    {
      if (this.cIb)
      {
        locali = l("start", null);
        AppMethodBeat.o(145926);
        return locali;
      }
      locali = l("resume", null);
      AppMethodBeat.o(145926);
      return locali;
    }
    i locali = new i();
    AppMethodBeat.o(145926);
    return locali;
  }
  
  final void ca(boolean paramBoolean)
  {
    AppMethodBeat.i(145922);
    if ((!this.cHY) && (paramBoolean))
    {
      this.mVideoView.setVisibility(0);
      this.cHV.startCameraPreview(this.mVideoView);
      this.cHY = true;
    }
    AppMethodBeat.o(145922);
  }
  
  final void cb(boolean paramBoolean)
  {
    AppMethodBeat.i(145924);
    if (paramBoolean) {
      this.cHV.startAudioRecord();
    }
    AppMethodBeat.o(145924);
  }
  
  public final i hu(boolean paramBoolean)
  {
    AppMethodBeat.i(145925);
    this.cIa = this.cHV.isPushing();
    if (this.cIa)
    {
      if (paramBoolean)
      {
        this.cIb = paramBoolean;
        if ((this.cFE) && (this.cHW != null)) {
          this.cHW.onPushEvent(5000, new Bundle());
        }
        locali = l("stop", null);
        AppMethodBeat.o(145925);
        return locali;
      }
      locali = l("pause", null);
      AppMethodBeat.o(145925);
      return locali;
    }
    i locali = new i();
    AppMethodBeat.o(145925);
    return locali;
  }
  
  public final void ib(final int paramInt)
  {
    AppMethodBeat.i(145919);
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145916);
        m.a(m.this, paramInt);
        Log.i("TXLivePusherJSAdapter", "notifyOrientationChanged, angle:" + paramInt + ", orientation:" + m.a(m.this));
        m.a(m.this, paramInt, m.a(m.this));
        AppMethodBeat.o(145916);
      }
    });
    AppMethodBeat.o(145919);
  }
  
  public final i l(String paramString, JSONObject paramJSONObject)
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
    Log.i("TXLivePusherJSAdapter", "operateLivePusher: type = " + paramString + " params = " + str);
    if (paramString.equalsIgnoreCase("start")) {
      if ((this.cHX != null) && (!this.cHX.isEmpty()) && (!this.cHV.isPushing()))
      {
        ca(this.cIm);
        cb(this.cIn);
        this.cHV.startPusher(this.cHX);
      }
    }
    for (;;)
    {
      paramString = new i();
      AppMethodBeat.o(145921);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.cIu = false;
        this.cHV.stopBGM();
        stopPreview();
        this.cHV.stopAudioRecord();
        this.cHV.stopPusher();
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        if ((this.cIu) && (this.cHV.isPushing())) {
          this.cHV.turnOnFlashLight(false);
        }
        this.cHV.pausePusher();
        this.cIg = this.cIf;
        if (this.cIg) {
          l("pauseBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.cHV.resumePusher();
        if (this.cIg) {
          l("resumeBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("startPreview"))
      {
        if (this.cHV.isPushing())
        {
          Log.i("TXLivePusherJSAdapter", "do not support startPreview when pushing");
        }
        else
        {
          stopPreview();
          ca(this.cIm);
        }
      }
      else if (paramString.equalsIgnoreCase("stopPreview"))
      {
        if (this.cHV.isPushing()) {
          Log.i("TXLivePusherJSAdapter", "do not support stopPreview when pushing");
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
            this.cHU.setFrontCamera(this.mFrontCamera);
            this.cHV.switchCamera();
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
          a(bool1, this.cIc);
        }
        else
        {
          if (paramString.equalsIgnoreCase("toggleTorch"))
          {
            if (this.cHV.isPushing())
            {
              if (!this.cIu)
              {
                bool2 = this.cHV.turnOnFlashLight(bool1);
                if (!bool2) {
                  break label639;
                }
                label594:
                this.cIu = bool1;
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
                bool1 = this.cIu;
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
            Log.i("TXLivePusherJSAdapter", "playBGM filePath = ".concat(String.valueOf(paramString)));
            if ((paramString != null) && (paramString.length() > 0))
            {
              this.cHV.playBGM(paramString);
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
            this.cHV.stopBGM();
            this.cIf = false;
          }
          else if (paramString.equalsIgnoreCase("pauseBGM"))
          {
            this.cHV.pauseBGM();
            this.cIf = false;
          }
          else
          {
            if (!paramString.equalsIgnoreCase("resumeBGM")) {
              break;
            }
            this.cHV.resumeBGM();
            this.cIf = true;
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
      this.cHV.setBGMVolume((float)d);
      break;
      if (paramString.equalsIgnoreCase("setMICVolume"))
      {
        if (paramJSONObject != null) {
          d = paramJSONObject.optDouble("volume", 1.0D);
        }
        this.cHV.setMicVolume((float)d);
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
          bool1 = this.cHV.sendMessageEx(paramString.getBytes());
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
    if ((this.cFF) && (this.cIe != null)) {
      this.cIe.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(182556);
  }
  
  public final void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(145932);
    this.cIf = false;
    if ((this.cIv) && (this.cId != null)) {
      this.cId.onBGMComplete(paramInt);
    }
    AppMethodBeat.o(145932);
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(145931);
    if ((this.cIv) && (this.cId != null)) {
      this.cId.onBGMProgress(paramLong1, paramLong2);
    }
    AppMethodBeat.o(145931);
  }
  
  public final void onBGMStart()
  {
    AppMethodBeat.i(145930);
    this.cIf = true;
    if ((this.cIv) && (this.cId != null)) {
      this.cId.onBGMStart();
    }
    AppMethodBeat.o(145930);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(145929);
    if (this.cHW != null) {
      this.cHW.onNetStatus(paramBundle);
    }
    Log.i("TXLivePusherJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(145929);
  }
  
  public final void onPushEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(145928);
    if ((paramInt == -1307) || (paramInt == -1313)) {
      l("stop", null);
    }
    for (;;)
    {
      if ((this.cFE) && (this.cHW != null)) {
        this.cHW.onPushEvent(paramInt, paramBundle);
      }
      paramBundle = paramBundle.getString("EVT_MSG");
      Log.i("TXLivePusherJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
      AppMethodBeat.o(145928);
      return;
      if ((paramInt == 1003) && (this.cIu)) {
        this.cHV.turnOnFlashLight(this.cIu);
      }
    }
  }
  
  final void stopPreview()
  {
    AppMethodBeat.i(145923);
    this.cHV.stopCameraPreview(true);
    this.cHY = false;
    AppMethodBeat.o(145923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.m
 * JD-Core Version:    0.7.0.1
 */