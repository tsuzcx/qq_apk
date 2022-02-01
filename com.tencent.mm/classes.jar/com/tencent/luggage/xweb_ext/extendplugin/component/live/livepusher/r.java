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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePushListener;
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

public final class r
  implements ITXLivePushListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.OnBGMNotify
{
  private static m.b cIH = m.b.cGS;
  private boolean cFE;
  private boolean cFF;
  private boolean cFH;
  private String cFy;
  private WXLivePushConfig cHU;
  final WXLivePusher cHV;
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
  private final m cIE;
  private boolean cIF;
  private boolean cIG;
  boolean cIa;
  boolean cIb;
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
  Handler mHandler;
  boolean mInited;
  private int mMode;
  private boolean mMute;
  Surface mSurface;
  private int mVideoHeight;
  TXCloudVideoView mVideoView;
  private int mVideoWidth;
  private float mWatermarkWidth;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(138900);
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
    this.cIE = cIH.Qh();
    this.cIF = false;
    this.cIG = false;
    this.mContext = paramContext;
    this.cHU = new WXLivePushConfig();
    this.cHV = new WXLivePusher(paramContext);
    this.cHV.setConfig(this.cHU);
    this.cHV.setPushListener(this);
    this.cHV.setBGMNofify(this);
    this.cHV.setAudioVolumeEvaluationListener(this);
    AppMethodBeat.o(138900);
  }
  
  private boolean Qk()
  {
    AppMethodBeat.i(215656);
    if ((this.cIG) && (this.cIE.isEnabled()))
    {
      AppMethodBeat.o(215656);
      return true;
    }
    AppMethodBeat.o(215656);
    return false;
  }
  
  private void Ql()
  {
    AppMethodBeat.i(215667);
    if (!this.cIF)
    {
      Log.d("TXLivePusherJSAdapter", "applyWeEffect");
      this.cHU.setCustomModeType(256);
      this.cHV.setConfig(this.cHU);
      this.cHV.setVideoProcessListener(this.cIE);
      this.cIF = true;
    }
    AppMethodBeat.o(215667);
  }
  
  private static float a(JSONObject paramJSONObject, String paramString)
  {
    float f2 = 1.0F;
    float f1 = 0.0F;
    AppMethodBeat.i(215662);
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
        AppMethodBeat.o(215662);
        return f1;
      }
      f1 = f3;
    }
  }
  
  private void a(Bundle paramBundle, String paramString, l.a parama)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(215664);
    if (!paramBundle.containsKey(paramString))
    {
      Log.d("TXLivePusherJSAdapter", "applyFaceBeautyIfNeed, %s is not exist in params", new Object[] { paramString });
      AppMethodBeat.o(215664);
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
      Ql();
      Log.d("TXLivePusherJSAdapter", "applyFaceBeauty, faceBeautyType: %s, rate: %f", new Object[] { parama, Float.valueOf(f2) });
      this.cIE.a(parama, f2);
      AppMethodBeat.o(215664);
      return;
      f1 = f2;
    }
  }
  
  public static void a(m.b paramb)
  {
    cIH = paramb;
  }
  
  private void k(int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(138902);
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
        this.cHU.setHomeOrientation(paramInt);
        this.cHV.setConfig(this.cHU);
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
    Log.i("TXLivePusherJSAdapter", paramString);
    AppMethodBeat.o(138917);
  }
  
  private boolean m(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(215661);
    if (!Qk())
    {
      Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, useCustomEffect is false");
      AppMethodBeat.o(215661);
      return false;
    }
    l.c localc = o(paramJSONObject);
    if (localc == null)
    {
      Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, stickerType is null");
      AppMethodBeat.o(215661);
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
      AppMethodBeat.o(215661);
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
        AppMethodBeat.o(215661);
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
          AppMethodBeat.o(215661);
          return false;
        }
        String str3 = localJSONObject.optString("md5", "");
        paramJSONObject = null;
        if ((l.c.cGN == localc) || (l.c.cGM == localc))
        {
          paramJSONObject = localJSONObject.getJSONArray("pos");
          if (4 != paramJSONObject.length())
          {
            Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, length of posJsonArr is not 4", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(215661);
            return false;
          }
          paramJSONObject = new StickerItemInfo.a(paramJSONObject.getDouble(0), paramJSONObject.getDouble(1), paramJSONObject.getDouble(2), paramJSONObject.getDouble(3));
        }
        Object localObject1 = StickerItemInfo.StickerBackType.BACKGROUND;
        if (l.c.cGL == localc)
        {
          localObject2 = StickerItemInfo.StickerBackType.from(localJSONObject.getInt("segtype"));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, type is null", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(215661);
            return false;
          }
        }
        int m = localJSONObject.optInt("active", StickerItemInfo.TriggerAction.DEFAULT_ACTION_LOOP.getJsonVal());
        Object localObject2 = StickerItemInfo.TriggerAction.from(m);
        if (localObject2 == null)
        {
          Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, actionInt: %d, action is null", new Object[] { Integer.valueOf(i), Integer.valueOf(m) });
          AppMethodBeat.o(215661);
          return false;
        }
        localArrayList.add(new StickerItemInfo(localJSONObject.optInt("id", i), str1, k, (StickerItemInfo.TriggerAction)localObject2, str2, str3, paramJSONObject, (StickerItemInfo.StickerBackType)localObject1));
        i += 1;
      }
      catch (Exception paramJSONObject)
      {
        Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, convert fail since %s", new Object[] { Integer.valueOf(i), paramJSONObject });
        AppMethodBeat.o(215661);
        return false;
      }
    }
    Ql();
    Log.d("TXLivePusherJSAdapter", "applyStickerWorkaround, stickerType: %s", new Object[] { localc });
    boolean bool = this.cIE.a(localc, localArrayList);
    AppMethodBeat.o(215661);
    return bool;
  }
  
  private static n.a n(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(215663);
    paramJSONObject = paramJSONObject.optString("color");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("TXLivePusherJSAdapter", "parseColor, colorStr is empty");
      AppMethodBeat.o(215663);
      return null;
    }
    try
    {
      int i = Color.parseColor(paramJSONObject);
      paramJSONObject = new n.a(Color.red(i), Color.green(i), Color.blue(i));
      AppMethodBeat.o(215663);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      Log.w("TXLivePusherJSAdapter", "parseColor, colorStr is illegal");
      AppMethodBeat.o(215663);
    }
    return null;
  }
  
  private static l.c o(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(215665);
    paramJSONObject = paramJSONObject.optString("stickerType", null);
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("TXLivePusherJSAdapter", "parseStickerType, stickerTypeStr is empty");
      AppMethodBeat.o(215665);
      return null;
    }
    if (paramJSONObject.equalsIgnoreCase("back"))
    {
      paramJSONObject = l.c.cGL;
      AppMethodBeat.o(215665);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("front"))
    {
      paramJSONObject = l.c.cGM;
      AppMethodBeat.o(215665);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("2d"))
    {
      paramJSONObject = l.c.cGN;
      AppMethodBeat.o(215665);
      return paramJSONObject;
    }
    Log.w("TXLivePusherJSAdapter", "parseStickerType, stickerTypeStr: ".concat(String.valueOf(paramJSONObject)));
    AppMethodBeat.o(215665);
    return null;
  }
  
  private static l.b p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(215666);
    paramJSONObject = paramJSONObject.optString("makeupType", null);
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("TXLivePusherJSAdapter", "parseMakeupType, makeupTypeStr is empty");
      AppMethodBeat.o(215666);
      return null;
    }
    if (paramJSONObject.equalsIgnoreCase("lipStick"))
    {
      paramJSONObject = l.b.cGF;
      AppMethodBeat.o(215666);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("eyeShadow"))
    {
      paramJSONObject = l.b.cGG;
      AppMethodBeat.o(215666);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("blusherStick"))
    {
      paramJSONObject = l.b.cGH;
      AppMethodBeat.o(215666);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("faceContour"))
    {
      paramJSONObject = l.b.cGI;
      AppMethodBeat.o(215666);
      return paramJSONObject;
    }
    if (paramJSONObject.equalsIgnoreCase("eyeBrow"))
    {
      paramJSONObject = l.b.cGJ;
      AppMethodBeat.o(215666);
      return paramJSONObject;
    }
    Log.w("TXLivePusherJSAdapter", "parseMakeupType, makeupTypeStr: ".concat(String.valueOf(paramJSONObject)));
    AppMethodBeat.o(215666);
    return null;
  }
  
  private void p(Bundle paramBundle)
  {
    AppMethodBeat.i(215657);
    a(paramBundle, "skinWhiteness", l.a.cGA);
    AppMethodBeat.o(215657);
  }
  
  private void q(Bundle paramBundle)
  {
    AppMethodBeat.i(215658);
    a(paramBundle, "skinSmoothness", l.a.cGB);
    AppMethodBeat.o(215658);
  }
  
  private void r(Bundle paramBundle)
  {
    AppMethodBeat.i(215659);
    a(paramBundle, "faceThinness", l.a.cGC);
    AppMethodBeat.o(215659);
  }
  
  private void s(Bundle paramBundle)
  {
    AppMethodBeat.i(215660);
    a(paramBundle, "eyeBigness", l.a.cGD);
    AppMethodBeat.o(215660);
  }
  
  private void stopPreview()
  {
    AppMethodBeat.i(138906);
    this.cHV.stopCameraPreview(true);
    this.cHY = false;
    AppMethodBeat.o(138906);
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a Qj()
  {
    AppMethodBeat.i(138908);
    com.tencent.luggage.xweb_ext.extendplugin.component.live.a locala;
    if (!this.mInited)
    {
      locala = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(-3, "uninited livePusher");
      AppMethodBeat.o(138908);
      return locala;
    }
    try
    {
      this.cHV.stopBGM();
      stopPreview();
      this.cHV.stopAudioRecord();
      this.cHV.stopPusher();
      this.cHV.setPushListener(null);
      this.mInited = false;
      locala = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
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
          this.cHU.setVideoResolution(13);
          if ((m > 0) && (m <= 1920) && (n > 0) && (n <= 1920)) {
            this.cHU.setVideoResolution(m, n);
          }
          if (!((String)localObject1).equalsIgnoreCase("low")) {
            break label2043;
          }
          this.cHU.setAudioSampleRate(16000);
        }
      }
      else
      {
        int i3 = paramBundle.getInt("focusMode", this.cIl);
        localObject2 = this.cHU;
        if (i3 == 0) {
          break label2066;
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
            break label2072;
          }
          k(this.cHv, (String)localObject2);
          this.cHV.setRenderRotation(90);
        }
        str1 = paramBundle.getString("localMirror", this.cIx);
        if (!str1.equalsIgnoreCase(this.cIx))
        {
          if (!str1.equalsIgnoreCase("auto")) {
            break label2103;
          }
          this.cHU.setLocalVideoMirrorType(0);
        }
        String str2 = paramBundle.getString("backgroundImage", this.cIs);
        Object localObject3 = BitmapFactory.decodeFile(str2);
        if (localObject3 != null) {
          this.cHU.setPauseImg((Bitmap)localObject3);
        }
        boolean bool3 = paramBundle.getBoolean("backgroundMute", this.cIt);
        if (i2 != 6) {
          break label2147;
        }
        this.cHU.setPauseFlag(1);
        boolean bool4 = paramBundle.getBoolean("zoom", this.mEnableZoom);
        this.cHU.setEnableZoom(bool4);
        f1 = paramBundle.getFloat("watermarkLeft", this.cIy);
        f2 = paramBundle.getFloat("watermarkTop", this.cIz);
        f3 = paramBundle.getFloat("watermarkWidth", this.mWatermarkWidth);
        localObject3 = paramBundle.getString("watermarkImage", this.cIA);
        localObject4 = BitmapFactory.decodeFile((String)localObject3);
        if (localObject4 == null) {
          break label2158;
        }
        this.cHU.setWatermark((Bitmap)localObject4, f1, f2, f3);
        label822:
        boolean bool5 = paramBundle.getBoolean("enableAGC", this.mEnableAgc);
        this.cHU.enableAGC(bool5);
        boolean bool6 = paramBundle.getBoolean("enableANS", this.mEnableAns);
        this.cHU.enableANS(bool6);
        boolean bool7 = paramBundle.getBoolean("enableEarMonitor", this.cIB);
        this.cHU.enableAudioEarMonitoring(bool7);
        localObject4 = paramBundle.getString("audioVolumeType", this.cIC);
        if (!((String)localObject4).equalsIgnoreCase("voicecall")) {
          break label2200;
        }
        this.cHU.setVolumeType(2);
        label920:
        boolean bool8 = paramBundle.getBoolean("enableCamera", this.cIm);
        Object localObject5 = this.cHU;
        if (bool8) {
          break label2233;
        }
        bool2 = true;
        label947:
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
            break label2239;
          }
          stopPreview();
          ca(true);
        }
        label1221:
        if (!paramBundle.keySet().contains("enableMic")) {
          break label2268;
        }
        boolean bool9 = paramBundle.getBoolean("enableMic", this.cIn);
        if (bool9 != this.cIn)
        {
          if (!bool9) {
            break label2246;
          }
          this.cHV.stopAudioRecord();
          cb(true);
        }
        label1275:
        if ((paramBoolean) || (bool9 != this.cIn))
        {
          localObject5 = this.cHV;
          if (bool9) {
            break label2256;
          }
          bool2 = true;
          ((WXLivePusher)localObject5).setMute(bool2);
        }
        label1302:
        this.cIn = bool9;
        if (bool9) {
          break label2262;
        }
        bool2 = true;
        label1323:
        this.mMute = bool2;
        label1329:
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
          break label2327;
        }
        bool1 = paramBundle.getBoolean("remoteMirror");
        label1526:
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
            break label2354;
          }
          this.cHV.setBeautyFilter(1, i, j, 2);
        }
        label1649:
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
            break label2371;
          }
        }
      }
      label2066:
      label2072:
      label2103:
      label2233:
      label2239:
      label2371:
      for (i = 300;; i = 0)
      {
        ((WXLivePusher)localObject1).enableAudioVolumeEvaluation(i);
        this.cFF = bool1;
        bool1 = paramBundle.getBoolean("debug", this.cFH);
        if ((paramBoolean) || (bool1 != this.cFH)) {
          this.cHV.showDebugLog(bool1);
        }
        this.cFH = bool1;
        this.cIG = paramBundle.getBoolean("customEffect", this.cIG);
        if (Qk())
        {
          Log.i("TXLivePusherJSAdapter", "parseAndApplyParams, useCustomEffect");
          p(paramBundle);
          q(paramBundle);
          r(paramBundle);
          s(paramBundle);
        }
        AppMethodBeat.o(138916);
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
          break label402;
        }
        this.cHU.setVideoResolution(0);
        break label402;
        label2043:
        if (!((String)localObject1).equalsIgnoreCase("high")) {
          break label460;
        }
        this.cHU.setAudioSampleRate(48000);
        break label460;
        bool1 = false;
        break label487;
        if (!((String)localObject2).equalsIgnoreCase("vertical")) {
          break label618;
        }
        k(this.cHv, (String)localObject2);
        this.cHV.setRenderRotation(0);
        break label618;
        if (str1.equalsIgnoreCase("enable"))
        {
          this.cHU.setLocalVideoMirrorType(1);
          break label661;
        }
        if (!str1.equalsIgnoreCase("disable")) {
          break label661;
        }
        this.cHU.setLocalVideoMirrorType(2);
        break label661;
        label2147:
        this.cHU.setPauseFlag(3);
        break label723;
        label2158:
        if ((!this.cHV.isPushing()) || (!paramBundle.keySet().contains("watermarkImage"))) {
          break label822;
        }
        this.cHU.setWatermark((Bitmap)localObject4, f1, f2, f3);
        break label822;
        if (((String)localObject4).equalsIgnoreCase("media"))
        {
          this.cHU.setVolumeType(1);
          break label920;
        }
        this.cHU.setVolumeType(0);
        break label920;
        bool2 = false;
        break label947;
        stopPreview();
        break label1221;
        label2246:
        this.cHV.stopAudioRecord();
        break label1275;
        label2256:
        bool2 = false;
        break label1302;
        label2262:
        bool2 = false;
        break label1323;
        label2268:
        if (!paramBundle.keySet().contains("muted")) {
          break label1329;
        }
        bool2 = paramBundle.getBoolean("muted", this.mMute);
        if ((paramBoolean) || (bool2 != this.mMute)) {
          this.cHV.setMute(bool2);
        }
        this.mMute = bool2;
        break label1329;
        if (!paramBundle.keySet().contains("mirror")) {
          break label1526;
        }
        bool1 = paramBundle.getBoolean("mirror");
        break label1526;
        this.cHV.setBeautyFilter(0, i, j, 2);
        break label1649;
      }
      label2200:
      label2354:
      k = i;
      label2327:
      i = j;
    }
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a bV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138909);
    this.cHV.setSurfaceSize(paramInt1, paramInt2);
    com.tencent.luggage.xweb_ext.extendplugin.component.live.a locala = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
    AppMethodBeat.o(138909);
    return locala;
  }
  
  final void ca(boolean paramBoolean)
  {
    AppMethodBeat.i(138905);
    if ((!this.cHY) && (paramBoolean))
    {
      if (this.mVideoView != null) {
        this.mVideoView.setVisibility(0);
      }
      if (this.mSurface != null) {
        this.cHV.setSurface(this.mSurface);
      }
      this.cHV.startCameraPreview(this.mVideoView);
      this.cHY = true;
    }
    AppMethodBeat.o(138905);
  }
  
  final void cb(boolean paramBoolean)
  {
    AppMethodBeat.i(138907);
    if (paramBoolean) {
      this.cHV.startAudioRecord();
    }
    AppMethodBeat.o(138907);
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a cc(boolean paramBoolean)
  {
    AppMethodBeat.i(138910);
    this.cIa = this.cHV.isPushing();
    if (this.cIa)
    {
      if (paramBoolean)
      {
        this.cIb = paramBoolean;
        locala = f("stop", null);
        AppMethodBeat.o(138910);
        return locala;
      }
      locala = f("pause", null);
      AppMethodBeat.o(138910);
      return locala;
    }
    com.tencent.luggage.xweb_ext.extendplugin.component.live.a locala = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
    AppMethodBeat.o(138910);
    return locala;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a f(final String paramString, JSONObject paramJSONObject)
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
    AppMethodBeat.i(138904);
    if (paramString == null)
    {
      paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(-1, "invalid params");
      AppMethodBeat.o(138904);
      return paramString;
    }
    if (!this.mInited)
    {
      paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(-3, "uninited livePusher");
      AppMethodBeat.o(138904);
      return paramString;
    }
    Object localObject1 = "";
    if (paramJSONObject != null) {
      localObject1 = paramJSONObject.toString();
    }
    Log.i("TXLivePusherJSAdapter", "operateLivePusher: type = " + paramString + " params = " + (String)localObject1);
    if (paramString.equalsIgnoreCase("start")) {
      if ((this.cHX != null) && (!this.cHX.isEmpty()) && (!this.cHV.isPushing()))
      {
        ca(this.cIm);
        cb(this.cIn);
        if ((this.cIm) && (this.mSurface != null)) {
          this.cHV.setSurface(this.mSurface);
        }
        this.cHV.startPusher(this.cHX);
      }
    }
    for (;;)
    {
      paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
      AppMethodBeat.o(138904);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.cIu = false;
        try
        {
          this.cHV.stopBGM();
          stopPreview();
          this.cHV.stopAudioRecord();
          this.cHV.stopPusher();
          continue;
        }
        finally
        {
          AppMethodBeat.o(138904);
        }
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        if ((this.cIu) && (this.cHV.isPushing())) {
          this.cHV.turnOnFlashLight(false);
        }
        this.cHV.pausePusher();
        this.cIg = this.cIf;
        if (this.cIg) {
          f("pauseBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        this.cHV.resumePusher();
        if (this.cIg) {
          f("resumeBGM", null);
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
          paramString = this.cIc;
          if ((this.cHV != null) && (this.cHV.isPushing())) {
            this.cHV.snapshot(new TXLivePusher.ITXSnapshotListener()
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
                      r.r(paramAnonymousBitmap);
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
            if (!this.cIu)
            {
              bool2 = this.cHV.turnOnFlashLight(bool1);
              if (!bool2) {
                break label755;
              }
              label706:
              this.cIu = bool1;
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
              paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(i, paramString);
              AppMethodBeat.o(138904);
              return paramString;
              bool1 = false;
              break;
              label755:
              bool1 = this.cIu;
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
              this.cHV.playBGM(paramString);
            }
            else
            {
              paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(-2, "fail");
              AppMethodBeat.o(138904);
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
          else if (paramString.equalsIgnoreCase("resumeBGM"))
          {
            this.cHV.resumeBGM();
            this.cIf = true;
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
              this.cHV.setBGMVolume((float)d);
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
              this.cHV.setMicVolume((float)d);
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
        bool1 = this.cHV.sendMessageEx(paramString.getBytes());
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
          paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(i, paramString);
          AppMethodBeat.o(138904);
          return paramString;
          i = -2;
          break;
        }
      }
      paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(-2, "fail");
      AppMethodBeat.o(138904);
      return paramString;
    }
    label1175:
    label1180:
    float f2;
    float f1;
    if (paramString.equalsIgnoreCase("applyFilter"))
    {
      if (paramJSONObject != null) {
        if (!Qk())
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
        paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(j, paramString);
        AppMethodBeat.o(138904);
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
        Ql();
        Log.d("TXLivePusherJSAdapter", "applyFilter, resourcePath: %s, alpha: %f", new Object[] { paramString, Float.valueOf(f2) });
        this.cIE.b(paramString, f2);
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
      if (!Qk())
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
        paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(j, paramString);
        AppMethodBeat.o(138904);
        return paramString;
        Ql();
        Log.d("TXLivePusherJSAdapter", "clearFilters");
        this.cIE.clearFilters();
        i = i4;
        break;
        j = -2;
        break label1425;
      }
    }
    if (paramString.equalsIgnoreCase("applySticker"))
    {
      if (paramJSONObject != null) {
        if (!Qk())
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
        paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(j, paramString);
        AppMethodBeat.o(138904);
        return paramString;
        paramString = paramJSONObject.optString("path", null);
        if (Util.isNullOrNil(paramString))
        {
          Log.i("TXLivePusherJSAdapter", "applySticker, resourcePath is null");
          bool1 = m(paramJSONObject);
          break;
        }
        paramJSONObject = o(paramJSONObject);
        if (paramJSONObject == null)
        {
          Log.w("TXLivePusherJSAdapter", "applySticker, stickerType is null");
          bool1 = false;
          break;
        }
        Ql();
        Log.d("TXLivePusherJSAdapter", "applySticker, stickerType: %s, resourcePath: %s", new Object[] { paramJSONObject, paramString });
        this.cIE.a(paramJSONObject, paramString);
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
      if (!Qk())
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
        paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(j, paramString);
        AppMethodBeat.o(138904);
        return paramString;
        Ql();
        Log.d("TXLivePusherJSAdapter", "clearStickers");
        this.cIE.Qf();
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
        if (!Qk())
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
        paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(j, paramString);
        AppMethodBeat.o(138904);
        return paramString;
        paramString = paramJSONObject.optString("path", null);
        if (Util.isNullOrNil(paramString))
        {
          Log.i("TXLivePusherJSAdapter", "applyMakeup, resourcePath is null");
          if (!Qk())
          {
            Log.w("TXLivePusherJSAdapter", "applyMakeupWorkaround, useCustomEffect is false");
            bool1 = false;
            break;
          }
          localObject1 = p(paramJSONObject);
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
          Ql();
          Log.d("TXLivePusherJSAdapter", "applyMakeupWorkaround, makeupType: %s", new Object[] { localObject1 });
          switch (4.cIK[localObject1.ordinal()])
          {
          default: 
            Log.w("TXLivePusherJSAdapter", "applyMakeupWorkaround, should not reach");
            bool1 = false;
            break;
          case 1: 
            f1 = a(paramString, "alpha");
            paramJSONObject = n(paramString);
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
              localObject1 = n.b.hZ(paramString.optInt("lipstickType", 0));
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
                  paramString = new n(f1, paramJSONObject, (n.b)localObject1, j, n.c.cHj);
                }
              }
            }
            bool1 = this.cIE.a(paramString);
            break;
          case 2: 
            f1 = a(paramString, "alpha");
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
            bool1 = this.cIE.a(paramString);
            break;
          case 3: 
            f1 = a(paramString, "alpha");
            paramJSONObject = a.a.cGd;
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
            bool1 = this.cIE.a(paramString);
            break;
          case 4: 
            f1 = a(paramString, "highlightAlpha");
            f2 = a(paramString, "shadowAlpha");
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
            bool1 = this.cIE.a(paramString);
            break;
          case 5: 
            label2499:
            f1 = a(paramString, "alpha");
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
            bool1 = this.cIE.a(paramString);
            break;
          }
        }
        paramJSONObject = p(paramJSONObject);
        if (paramJSONObject == null)
        {
          Log.w("TXLivePusherJSAdapter", "applyMakeup, makeupType is null");
          bool1 = false;
          break;
        }
        Ql();
        Log.d("TXLivePusherJSAdapter", "applyMakeup, makeupType: %s, resourcePath: %s", new Object[] { paramJSONObject, paramString });
        this.cIE.a(paramJSONObject, paramString);
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
      if (!Qk())
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
        paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(j, paramString);
        AppMethodBeat.o(138904);
        return paramString;
        Ql();
        Log.d("TXLivePusherJSAdapter", "clearMakeups");
        this.cIE.Qg();
        i = i7;
        break;
        j = -2;
        break label3006;
      }
    }
    paramString = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(-4, "invalid operate command");
    AppMethodBeat.o(138904);
    return paramString;
  }
  
  public final void ib(final int paramInt)
  {
    AppMethodBeat.i(138901);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138898);
        r.a(r.this, paramInt);
        Log.i("TXLivePusherJSAdapter", "notifyOrientationChanged, angle:" + paramInt + ", orientation:" + r.a(r.this));
        r.a(r.this, paramInt, r.a(r.this));
        AppMethodBeat.o(138898);
      }
    });
    AppMethodBeat.o(138901);
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a o(Bundle paramBundle)
  {
    AppMethodBeat.i(138903);
    if (paramBundle == null)
    {
      paramBundle = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(-1, "invalid params");
      AppMethodBeat.o(138903);
      return paramBundle;
    }
    l("updateLivePusher", paramBundle);
    if (!this.mInited)
    {
      paramBundle = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a(-3, "uninited livePusher");
      AppMethodBeat.o(138903);
      return paramBundle;
    }
    a(paramBundle, false);
    String str = paramBundle.getString("pushUrl", this.cHX);
    if ((str != null) && (!str.isEmpty()) && (this.cHX != null) && (!this.cHX.equalsIgnoreCase(str)) && (this.cHV.isPushing()))
    {
      Log.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
      stopPreview();
      this.cHV.stopAudioRecord();
      this.cHV.stopPusher();
    }
    this.cHX = str;
    this.cHV.setPusherUrl(this.cHX);
    this.cIh = paramBundle.getBoolean("autopush", this.cIh);
    if ((this.cIh) && (this.cHX != null) && (!this.cHX.isEmpty()) && (!this.cHV.isPushing()))
    {
      Log.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
      ca(this.cIm);
      cb(this.cIn);
      if ((this.cIm) && (this.mSurface != null)) {
        this.cHV.setSurface(this.mSurface);
      }
      this.cHV.startPusher(this.cHX);
    }
    paramBundle = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
    AppMethodBeat.o(138903);
    return paramBundle;
  }
  
  public final void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(178841);
    if ((this.cFF) && (this.cIe != null)) {
      this.cIe.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(178841);
  }
  
  public final void onBGMComplete(int paramInt)
  {
    AppMethodBeat.i(138915);
    this.cIf = false;
    if ((this.cIv) && (this.cId != null)) {
      this.cId.onBGMComplete(paramInt);
    }
    AppMethodBeat.o(138915);
  }
  
  public final void onBGMProgress(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(138914);
    if ((this.cIv) && (this.cId != null)) {
      this.cId.onBGMProgress(paramLong1, paramLong2);
    }
    AppMethodBeat.o(138914);
  }
  
  public final void onBGMStart()
  {
    AppMethodBeat.i(138913);
    this.cIf = true;
    if ((this.cIv) && (this.cId != null)) {
      this.cId.onBGMStart();
    }
    AppMethodBeat.o(138913);
  }
  
  public final void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(138912);
    if (this.cHW != null) {
      this.cHW.onNetStatus(paramBundle);
    }
    Log.i("TXLivePusherJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") }))));
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
          r.this.f("stop", null);
          AppMethodBeat.o(178840);
        }
      };
      if (this.mHandler != null) {
        this.mHandler.post(local3);
      }
    }
    for (;;)
    {
      if (this.cHW != null) {
        this.cHW.onPushEvent(paramInt, paramBundle);
      }
      paramBundle = paramBundle.getString("EVT_MSG");
      Log.i("TXLivePusherJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
      AppMethodBeat.o(138911);
      return;
      if ((paramInt == 1003) && (this.cIu)) {
        this.cHV.turnOnFlashLight(this.cIu);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r
 * JD-Core Version:    0.7.0.1
 */