package com.tencent.luggage.xweb_ext.extendplugin.component.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.luggage.xweb_ext.extendplugin.component.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class b
  implements ITXLivePushListener, TXLivePusher.OnBGMNotify
{
  private int bGH;
  private TXLivePushConfig bGP;
  TXLivePusher bGQ;
  ITXLivePushListener bGR;
  String bGS;
  private boolean bGT;
  private String bGU;
  boolean bGV;
  boolean bGW;
  TXLivePusher.ITXSnapshotListener bGX;
  TXLivePusher.OnBGMNotify bGY;
  private boolean bGZ;
  TXCloudVideoView bGi;
  private String bGq;
  private boolean bGw;
  private boolean bGx;
  private boolean bHa;
  boolean bHb;
  private int bHc;
  private int bHd;
  private int bHe;
  private int bHf;
  boolean bHg;
  private String bHh;
  private int bHi;
  private int bHj;
  private String bHk;
  private boolean bHl;
  private boolean bHm;
  private boolean bHn;
  private boolean bHo;
  private float bHp;
  private float bHq;
  private String bHr;
  private Context mContext;
  private boolean mEnableZoom;
  private boolean mFrontCamera;
  boolean mInited;
  private int mMode;
  private boolean mMute;
  Surface mSurface;
  private float mWatermarkWidth;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(139822);
    this.bGH = 0;
    this.mInited = false;
    this.bGT = false;
    this.mFrontCamera = true;
    this.bGU = "front";
    this.bGV = false;
    this.bGW = false;
    this.bGZ = false;
    this.bHa = false;
    this.bHb = false;
    this.mMode = 1;
    this.bHc = 2;
    this.bHd = -1;
    this.bHe = -1;
    this.mMute = false;
    this.bHf = 0;
    this.bHg = true;
    this.bGq = "vertical";
    this.bHh = "high";
    this.bHi = 5;
    this.bHj = 3;
    this.bHk = "";
    this.bHl = false;
    this.bHm = false;
    this.mEnableZoom = true;
    this.bGw = false;
    this.bHn = false;
    this.bGx = false;
    this.bHo = false;
    this.bHp = 0.0F;
    this.bHq = 0.0F;
    this.mWatermarkWidth = 0.1F;
    this.bHr = "";
    this.mContext = paramContext;
    this.bGP = new TXLivePushConfig();
    this.bGQ = new TXLivePusher(paramContext);
    this.bGQ.setConfig(this.bGP);
    this.bGQ.setPushListener(this);
    this.bGQ.setBGMNofify(this);
    AppMethodBeat.o(139822);
  }
  
  private void j(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(139824);
    ab.i("TXLivePusherJSAdapter", "adjustHomeOrientation, angle:" + paramInt + ", orientation:" + paramString);
    if (paramInt == 1)
    {
      if (paramString.equals("horizontal")) {
        break label161;
      }
      paramInt = i;
    }
    for (;;)
    {
      ab.i("TXLivePusherJSAdapter", "adjustHomeOrientation, homeOrientation:".concat(String.valueOf(paramInt)));
      if (paramInt != -2147483648)
      {
        this.bGP.setHomeOrientation(paramInt);
        this.bGQ.setConfig(this.bGP);
      }
      AppMethodBeat.o(139824);
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
          label161:
          paramInt = 3;
        }
      }
      else
      {
        paramInt = -2147483648;
      }
    }
  }
  
  static void k(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(139838);
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str.equalsIgnoreCase("pushUrl")) || (str.equalsIgnoreCase("orientation")) || (str.equalsIgnoreCase("backgroundImage")) || (str.equalsIgnoreCase("audioQuality")) || (str.equalsIgnoreCase("watermarkImage")) || (str.equalsIgnoreCase("devicePosition"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getString(str);
      } else if ((str.equalsIgnoreCase("mode")) || (str.equalsIgnoreCase("focusMode")) || (str.equalsIgnoreCase("beauty")) || (str.equalsIgnoreCase("whiteness")) || (str.equalsIgnoreCase("aspect")) || (str.equalsIgnoreCase("minBitrate")) || (str.equalsIgnoreCase("maxBitrate"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getInt(str);
      } else if ((str.equalsIgnoreCase("hide")) || (str.equalsIgnoreCase("autopush")) || (str.equalsIgnoreCase("muted")) || (str.equalsIgnoreCase("enableCamera")) || (str.equalsIgnoreCase("backgroundMute")) || (str.equalsIgnoreCase("zoom")) || (str.equalsIgnoreCase("needEvent")) || (str.equalsIgnoreCase("needBGMEvent")) || (str.equalsIgnoreCase("debug")) || (str.equalsIgnoreCase("mirror"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getBoolean(str);
      } else if ((str.equalsIgnoreCase("watermarkLeft")) || (str.equalsIgnoreCase("watermarkTop")) || (str.equalsIgnoreCase("watermarkWidth"))) {
        paramString = paramString + "\n" + str + " = " + paramBundle.getFloat(str);
      }
    }
    ab.i("TXLivePusherJSAdapter", paramString);
    AppMethodBeat.o(139838);
  }
  
  private void stopPreview()
  {
    AppMethodBeat.i(139828);
    this.bGQ.stopCameraPreview(true);
    this.bGT = false;
    AppMethodBeat.o(139828);
  }
  
  final void a(Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(139837);
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0))
    {
      AppMethodBeat.o(139837);
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
      k = this.bHd;
      m = this.bHe;
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
    for (;;)
    {
      n = paramBundle.getInt("aspect", this.bHc);
      String str1 = paramBundle.getString("audioQuality", this.bHh);
      label233:
      int i2;
      label291:
      Object localObject1;
      boolean bool1;
      label318:
      boolean bool3;
      boolean bool2;
      label447:
      int i3;
      int i4;
      String str2;
      Object localObject2;
      label545:
      boolean bool4;
      boolean bool5;
      float f1;
      float f2;
      float f3;
      Bitmap localBitmap;
      if (i1 == 6)
      {
        if (n == 1)
        {
          this.bGP.setVideoResolution(13);
          if ((k != -1) && (j != -1) && (k <= j))
          {
            this.bGP.setMinVideoBitrate(k);
            this.bGP.setMaxVideoBitrate(j);
          }
          if (!str1.equalsIgnoreCase("low")) {
            break label1274;
          }
          this.bGP.setAudioSampleRate(16000);
        }
      }
      else
      {
        i2 = paramBundle.getInt("focusMode", this.bHf);
        localObject1 = this.bGP;
        if (i2 == 0) {
          break label1297;
        }
        bool1 = true;
        ((TXLivePushConfig)localObject1).setTouchFocus(bool1);
        bool3 = paramBundle.getBoolean("enableCamera", this.bHg);
        bool2 = this.mFrontCamera;
        bool1 = bool2;
        if (paramBundle.keySet().contains("devicePosition"))
        {
          this.bGU = paramBundle.getString("devicePosition", this.bGU);
          bool1 = bool2;
          if (this.bGU.equalsIgnoreCase("back")) {
            bool1 = false;
          }
          this.bGP.setFrontCamera(bool1);
        }
        localObject1 = paramBundle.getString("orientation", this.bGq);
        i = 0;
        if (!((String)localObject1).equalsIgnoreCase("horizontal")) {
          break label1303;
        }
        j(this.bGH, (String)localObject1);
        i = 90;
        i3 = paramBundle.getInt("beauty", this.bHi);
        i4 = paramBundle.getInt("whiteness", this.bHj);
        this.bGP.setBeautyFilter(i3, i4, 5);
        str2 = paramBundle.getString("backgroundImage", this.bHk);
        localObject2 = BitmapFactory.decodeFile(str2);
        if (localObject2 != null) {
          this.bGP.setPauseImg((Bitmap)localObject2);
        }
        bool2 = paramBundle.getBoolean("backgroundMute", this.bHl);
        if (!bool2) {
          break label1329;
        }
        this.bGP.setPauseFlag(3);
        bool4 = paramBundle.getBoolean("zoom", this.mEnableZoom);
        this.bGP.setEnableZoom(bool4);
        bool5 = paramBundle.getBoolean("mirror", this.bHo);
        this.bGQ.setMirror(bool5);
        f1 = paramBundle.getFloat("watermarkLeft", this.bHp);
        f2 = paramBundle.getFloat("watermarkTop", this.bHq);
        f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
        localObject2 = paramBundle.getString("watermarkImage", this.bHr);
        localBitmap = BitmapFactory.decodeFile((String)localObject2);
        if (localBitmap == null) {
          break label1340;
        }
        this.bGP.setWatermark(localBitmap, f1, f2, f3);
        label667:
        m = 0;
        if ((n != this.bHc) || (k != this.bHd) || (j != this.bHe) || (i2 != this.bHf) || (bool1 != this.mFrontCamera) || (bool3 != this.bHg) || (i3 != this.bHi) || (i4 != this.bHj) || (bool2 != this.bHl) || (bool4 != this.mEnableZoom) || (bool5 != this.bHo) || (f1 != this.bHp) || (f2 != this.bHq) || (f3 != this.mWatermarkWidth) || (!str2.equalsIgnoreCase(this.bHk)) || (!((String)localObject1).equalsIgnoreCase(this.bGq)) || (!str1.equalsIgnoreCase(this.bHh)) || (!((String)localObject2).equalsIgnoreCase(this.bHr))) {
          m = 1;
        }
        if ((paramBoolean) || (m != 0))
        {
          this.bGQ.setConfig(this.bGP);
          this.bGQ.setRenderRotation(i);
          this.bGQ.setBeautyFilter(0, i3, i4, 2);
        }
        if (bool3 != this.bHg)
        {
          if (!bool3) {
            break label1382;
          }
          stopPreview();
          bg(true);
        }
      }
      for (;;)
      {
        this.mMode = i1;
        this.bHc = n;
        this.bHf = i2;
        this.bHg = bool3;
        this.mFrontCamera = bool1;
        this.bGq = ((String)localObject1);
        this.bHi = i3;
        this.bHj = i4;
        this.bHl = bool2;
        this.bHk = str2;
        this.bHd = k;
        this.bHe = j;
        this.bHh = str1;
        this.mEnableZoom = bool4;
        this.bHo = bool5;
        this.bHp = f1;
        this.bHq = f2;
        this.mWatermarkWidth = f3;
        this.bHr = ((String)localObject2);
        this.bGw = paramBundle.getBoolean("needEvent", this.bGw);
        this.bHn = paramBundle.getBoolean("needBGMEvent", this.bHn);
        bool1 = paramBundle.getBoolean("muted", this.mMute);
        if ((paramBoolean) || (bool1 != this.mMute)) {
          this.bGQ.setMute(bool1);
        }
        this.mMute = bool1;
        bool1 = paramBundle.getBoolean("debug", this.bGx);
        if ((this.bGi != null) && ((paramBoolean) || (bool1 != this.bGx))) {
          this.bGi.showLog(bool1);
        }
        this.bGx = bool1;
        AppMethodBeat.o(139837);
        return;
        this.bGQ.setVideoQuality(1, false, false);
        this.bGP.setVideoEncodeGop(5);
        break;
        this.bGQ.setVideoQuality(2, true, false);
        this.bGP.setVideoEncodeGop(5);
        break;
        this.bGQ.setVideoQuality(3, true, false);
        this.bGP.setVideoEncodeGop(5);
        break;
        this.bGQ.setVideoQuality(4, true, false);
        break;
        this.bGQ.setVideoQuality(5, true, false);
        break;
        this.bGQ.setVideoQuality(6, false, false);
        break;
        if (n != 2) {
          break label233;
        }
        this.bGP.setVideoResolution(0);
        break label233;
        label1274:
        if (!str1.equalsIgnoreCase("high")) {
          break label291;
        }
        this.bGP.setAudioSampleRate(48000);
        break label291;
        label1297:
        bool1 = false;
        break label318;
        label1303:
        if (!((String)localObject1).equalsIgnoreCase("vertical")) {
          break label447;
        }
        j(this.bGH, (String)localObject1);
        i = 0;
        break label447;
        label1329:
        this.bGP.setPauseFlag(1);
        break label545;
        label1340:
        if ((!this.bGQ.isPushing()) || (!paramBundle.keySet().contains("watermarkImage"))) {
          break label667;
        }
        this.bGP.setWatermark(localBitmap, f1, f2, f3);
        break label667;
        label1382:
        stopPreview();
      }
      j = m;
    }
  }
  
  public final a b(String paramString, JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int i = 0;
    AppMethodBeat.i(139826);
    if (paramString == null)
    {
      paramString = new a(-1, "invalid params");
      AppMethodBeat.o(139826);
      return paramString;
    }
    if (!this.mInited)
    {
      paramString = new a(-3, "uninited livePusher");
      AppMethodBeat.o(139826);
      return paramString;
    }
    ab.i("TXLivePusherJSAdapter", "operateLivePusher: ".concat(String.valueOf(paramString)));
    if (paramString.equalsIgnoreCase("start")) {
      if ((this.bGS != null) && (!this.bGS.isEmpty()) && (!this.bGQ.isPushing()))
      {
        bg(this.bHg);
        if ((this.bHg) && (this.mSurface != null)) {
          this.bGQ.setSurface(this.mSurface);
        }
        this.bGQ.startPusher(this.bGS);
      }
    }
    for (;;)
    {
      paramString = new a();
      AppMethodBeat.o(139826);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.bHm = false;
        try
        {
          this.bGQ.stopBGM();
          stopPreview();
          this.bGQ.stopPusher();
          continue;
        }
        finally
        {
          AppMethodBeat.o(139826);
        }
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        if ((this.bHm) && (this.bGQ.isPushing())) {
          this.bGQ.turnOnFlashLight(false);
        }
        this.bGQ.pausePusher();
        this.bHa = this.bGZ;
        if (this.bHa) {
          b("pauseBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.bGQ.resumePusher();
        if (this.bHa) {
          b("resumeBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("startPreview"))
      {
        if (this.bGQ.isPushing())
        {
          ab.i("TXLivePusherJSAdapter", "do not support startPreview when pushing");
        }
        else
        {
          stopPreview();
          bg(this.bHg);
        }
      }
      else if (paramString.equalsIgnoreCase("stopPreview"))
      {
        if (this.bGQ.isPushing()) {
          ab.i("TXLivePusherJSAdapter", "do not support stopPreview when pushing");
        } else {
          stopPreview();
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
            this.bGP.setFrontCamera(this.mFrontCamera);
            this.bGQ.switchCamera();
            break;
            bool1 = false;
          }
        }
        if (paramString.equalsIgnoreCase("snapshot"))
        {
          paramString = this.bGX;
          if ((this.bGQ != null) && (this.bGQ.isPushing())) {
            this.bGQ.snapshot(new b.2(this, paramString));
          }
        }
        else
        {
          if (paramString.equalsIgnoreCase("toggleTorch"))
          {
            if (this.bGQ.isPushing())
            {
              if (!this.bHm)
              {
                bool1 = bool2;
                bool2 = this.bGQ.turnOnFlashLight(bool1);
                if (!bool2) {
                  break label615;
                }
                label570:
                this.bHm = bool1;
                if (!bool2) {
                  break label624;
                }
                label581:
                if (!bool2) {
                  break label631;
                }
              }
              label615:
              label624:
              label631:
              for (paramString = "Success";; paramString = "Failed")
              {
                paramString = new a(i, paramString);
                AppMethodBeat.o(139826);
                return paramString;
                bool1 = false;
                break;
                bool1 = this.bHm;
                break label570;
                i = -2;
                break label581;
              }
            }
            paramString = new a(-2, "fail");
            AppMethodBeat.o(139826);
            return paramString;
          }
          if (paramString.equalsIgnoreCase("playBGM"))
          {
            paramString = "";
            if (paramJSONObject != null) {
              paramString = paramJSONObject.optString("BGMFilePath", "");
            }
            ab.i("TXLivePusherJSAdapter", "playBGM filePath = ".concat(String.valueOf(paramString)));
            if ((paramString != null) && (paramString.length() > 0))
            {
              this.bGQ.playBGM(paramString);
            }
            else
            {
              paramString = new a(-2, "fail");
              AppMethodBeat.o(139826);
              return paramString;
            }
          }
          else if (paramString.equalsIgnoreCase("stopBGM"))
          {
            this.bGQ.stopBGM();
            this.bGZ = false;
          }
          else if (paramString.equalsIgnoreCase("pauseBGM"))
          {
            this.bGQ.pauseBGM();
            this.bGZ = false;
          }
          else
          {
            if (!paramString.equalsIgnoreCase("resumeBGM")) {
              break;
            }
            this.bGQ.resumeBGM();
            this.bGZ = true;
          }
        }
      }
    }
    if (paramString.equalsIgnoreCase("setBGMVolume")) {
      if (paramJSONObject == null) {
        break label880;
      }
    }
    label880:
    for (double d = paramJSONObject.optDouble("volume", 1.0D);; d = 1.0D)
    {
      this.bGQ.setBGMVolume((float)d);
      break;
      paramString = new a(-4, "invalid operate command");
      AppMethodBeat.o(139826);
      return paramString;
    }
  }
  
  public final a bE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139830);
    this.bGQ.setSurfaceSize(paramInt1, paramInt2);
    a locala = new a();
    AppMethodBeat.o(139830);
    return locala;
  }
  
  public final a bG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139831);
    this.bGQ.setFocusPosition(paramInt1, paramInt2);
    a locala = new a();
    AppMethodBeat.o(139831);
    return locala;
  }
  
  final void bg(boolean paramBoolean)
  {
    AppMethodBeat.i(139827);
    if ((!this.bGT) && (paramBoolean))
    {
      if (this.bGi != null) {
        this.bGi.setVisibility(0);
      }
      if (this.mSurface != null) {
        this.bGQ.setSurface(this.mSurface);
      }
      this.bGQ.startCameraPreview(this.bGi);
      this.bGT = true;
    }
    AppMethodBeat.o(139827);
  }
  
  public final void fA(int paramInt)
  {
    AppMethodBeat.i(139823);
    al.d(new b.1(this, paramInt));
    AppMethodBeat.o(139823);
  }
  
  public final a n(Bundle paramBundle)
  {
    AppMethodBeat.i(139825);
    if (paramBundle == null)
    {
      paramBundle = new a(-1, "invalid params");
      AppMethodBeat.o(139825);
      return paramBundle;
    }
    k("updateLivePusher", paramBundle);
    if (!this.mInited)
    {
      paramBundle = new a(-3, "uninited livePusher");
      AppMethodBeat.o(139825);
      return paramBundle;
    }
    a(paramBundle, false);
    String str = paramBundle.getString("pushUrl", this.bGS);
    if ((str != null) && (!str.isEmpty()) && (this.bGS != null) && (!this.bGS.equalsIgnoreCase(str)) && (this.bGQ.isPushing()))
    {
      ab.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
      stopPreview();
      this.bGQ.stopPusher();
    }
    this.bGS = str;
    this.bHb = paramBundle.getBoolean("autopush", this.bHb);
    if ((this.bHb) && (this.bGS != null) && (!this.bGS.isEmpty()) && (!this.bGQ.isPushing()))
    {
      ab.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
      bg(this.bHg);
      if ((this.bHg) && (this.mSurface != null)) {
        this.bGQ.setSurface(this.mSurface);
      }
      this.bGQ.startPusher(this.bGS);
    }
    paramBundle = new a();
    AppMethodBeat.o(139825);
    return paramBundle;
  }
  
  public final void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(139836);
    this.bGZ = false;
    if ((this.bHn) && (this.bGY != null)) {
      this.bGY.onBGMComplete(paramInt);
    }
    AppMethodBeat.o(139836);
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(139835);
    if ((this.bHn) && (this.bGY != null)) {
      this.bGY.onBGMProgress(paramLong1, paramLong2);
    }
    AppMethodBeat.o(139835);
  }
  
  public final void onBGMStart()
  {
    AppMethodBeat.i(139834);
    this.bGZ = true;
    if ((this.bHn) && (this.bGY != null)) {
      this.bGY.onBGMStart();
    }
    AppMethodBeat.o(139834);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(139833);
    if (this.bGR != null) {
      this.bGR.onNetStatus(paramBundle);
    }
    ab.i("TXLivePusherJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
    AppMethodBeat.o(139833);
  }
  
  public final void onPushEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(139832);
    if ((paramInt == -1307) || (paramInt == -1313)) {
      b("stop", null);
    }
    for (;;)
    {
      if (this.bGR != null) {
        this.bGR.onPushEvent(paramInt, paramBundle);
      }
      paramBundle = paramBundle.getString("EVT_MSG");
      ab.i("TXLivePusherJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
      AppMethodBeat.o(139832);
      return;
      if ((paramInt == 1003) && (this.bHm)) {
        this.bGQ.turnOnFlashLight(this.bHm);
      }
    }
  }
  
  public final a xx()
  {
    AppMethodBeat.i(139829);
    a locala;
    if (!this.mInited)
    {
      locala = new a(-3, "uninited livePusher");
      AppMethodBeat.o(139829);
      return locala;
    }
    try
    {
      this.bGQ.stopBGM();
      stopPreview();
      this.bGQ.stopPusher();
      this.bGQ.setPushListener(null);
      this.mInited = false;
      locala = new a();
      AppMethodBeat.o(139829);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(139829);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.a.b.b
 * JD-Core Version:    0.7.0.1
 */