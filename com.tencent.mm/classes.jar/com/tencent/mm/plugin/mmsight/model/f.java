package com.tencent.mm.plugin.mmsight.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.f.a.qj;
import com.tencent.mm.f.a.qj.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.base.model.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.v.a.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class f
  implements SensorEventListener
{
  static boolean EZE = true;
  protected static int EZm = 2147483647;
  private c EZA;
  protected VideoTransPara EZB;
  public boolean EZC;
  private boolean EZD;
  public c EZF;
  protected boolean EZj;
  protected boolean EZk;
  protected int EZl;
  protected Sensor EZn;
  protected float EZo;
  protected float EZp;
  protected float EZq;
  protected Point EZr;
  protected Point EZs;
  protected int EZt;
  protected byte[] EZu;
  protected boolean EZv;
  protected a EZw;
  protected boolean EZx;
  protected boolean EZy;
  private f.a EZz;
  protected boolean aHx;
  protected w jqD;
  protected boolean laM;
  protected p laR;
  protected Size laU;
  protected Point laW;
  protected int laX;
  protected int laY;
  protected List<g> lbj;
  protected d.a.a lbk;
  Camera.AutoFocusCallback lbl;
  private c lbm;
  private c lbn;
  private c lbo;
  private c lbp;
  private c lbq;
  public volatile boolean lbr;
  public volatile byte[] lbt;
  protected Context mContext;
  protected SensorManager mSensorManager;
  private int scene;
  
  public f(VideoTransPara paramVideoTransPara, int paramInt)
  {
    AppMethodBeat.i(89371);
    this.laY = -1;
    this.laX = -1;
    this.EZj = false;
    this.aHx = false;
    this.jqD = null;
    this.EZk = false;
    this.EZl = 0;
    this.EZo = 0.0F;
    this.EZp = 0.0F;
    this.EZq = 0.0F;
    this.mContext = null;
    this.EZr = null;
    this.EZs = null;
    this.laW = null;
    this.EZt = 0;
    this.EZv = false;
    this.EZw = new a();
    this.EZx = false;
    this.lbj = new ArrayList();
    this.EZy = false;
    this.laU = null;
    this.EZz = f.a.EZH;
    this.lbm = new c("prevcameraCallback");
    this.lbn = new c("cameraCallback");
    this.lbo = new c("cameraPreviewCallback");
    this.lbp = new c("cameraCropCallback");
    this.EZA = new c("mirrorCameraCallback");
    this.lbq = new c("finishCallbackTimeCallback");
    this.scene = 0;
    this.lbt = null;
    this.lbr = false;
    this.EZC = false;
    this.EZD = false;
    this.lbl = new Camera.AutoFocusCallback()
    {
      public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(89362);
        Log.v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), f.f(f.this) });
        f.EZE = true;
        AppMethodBeat.o(89362);
      }
    };
    this.EZF = new c(Looper.getMainLooper());
    this.laM = true;
    this.laR = p.eTA();
    this.EZB = paramVideoTransPara;
    this.scene = paramInt;
    AppMethodBeat.o(89371);
  }
  
  private static boolean a(w paramw)
  {
    AppMethodBeat.i(89381);
    if (paramw == null)
    {
      AppMethodBeat.o(89381);
      return false;
    }
    for (;;)
    {
      Camera.Parameters localParameters;
      List localList;
      try
      {
        localParameters = paramw.avd();
        localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          Log.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
          paramw.c(localParameters);
          AppMethodBeat.o(89381);
          return true;
        }
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          Log.i("MicroMsg.MMSightCameraSetting", "support continuous video");
          localParameters.setFocusMode("continuous-video");
          continue;
        }
        if (localList == null) {
          break label167;
        }
      }
      catch (Exception paramw)
      {
        Log.i("MicroMsg.MMSightCameraSetting", "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
        AppMethodBeat.o(89381);
        return false;
      }
      if (localList.contains("auto"))
      {
        Log.i("MicroMsg.MMSightCameraSetting", "support auto focus");
        localParameters.setFocusMode("auto");
      }
      else
      {
        label167:
        Log.i("MicroMsg.MMSightCameraSetting", "not support continuous video or auto focus");
      }
    }
  }
  
  private boolean a(w paramw, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(89377);
    if ((paramw == null) || (paramInt <= 0))
    {
      AppMethodBeat.o(89377);
      return false;
    }
    for (;;)
    {
      float f2;
      try
      {
        Camera.Parameters localParameters = paramw.avd();
        new Point(paramInt, (int)(paramInt / paramFloat));
        Object localObject;
        if (this.laU == null)
        {
          localObject = ar.au(MMApplicationContext.getContext());
          Point localPoint = new Point(Math.min(((Point)localObject).x, ((Point)localObject).y), Math.max(((Point)localObject).x, ((Point)localObject).y));
          Log.i("MicroMsg.MMSightCamera", "screenSize: %s, currentScreenSize: %s", new Object[] { localPoint, localObject });
          float f1 = Math.min(localPoint.x, localPoint.y) / Math.max(localPoint.x, localPoint.y);
          f2 = 1.0F / paramFloat;
          if (paramFloat >= 1.0F) {
            break label709;
          }
          i = paramInt;
          Log.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[] { Integer.valueOf(i), Float.valueOf(paramFloat), Float.valueOf(f1) });
          if (this.lbk.fSM == 90) {
            break label756;
          }
          if (this.lbk.fSM != 270) {
            break label768;
          }
          break label756;
          h.c localc = h.a(localParameters, localPoint, i, bool);
          if (localc != null)
          {
            localObject = localc;
            if (localc.EZN != null) {}
          }
          else
          {
            Log.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
            if (this.lbk.fSM == 90) {
              break label762;
            }
            if (this.lbk.fSM != 270) {
              break label774;
            }
            break label762;
            localObject = h.d(localParameters, localPoint, paramInt, bool);
            this.EZC = false;
          }
          if ((localObject != null) && (((h.c)localObject).EZN != null))
          {
            paramInt = (int)(((h.c)localObject).EZN.x * paramFloat);
            Log.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio result preview size: %s, cropHeight: %s", new Object[] { ((h.c)localObject).EZN, Integer.valueOf(paramInt) });
            if (paramInt > ((h.c)localObject).EZN.y) {
              break label726;
            }
            this.EZC = false;
          }
          if ((localObject != null) && (((h.c)localObject).EZN != null))
          {
            localObject = ((h.c)localObject).EZN;
            this.laR.wAw = ((Point)localObject).x;
            this.laR.wAx = ((Point)localObject).y;
            this.EZs = ((Point)localObject);
            this.laW = null;
            if (!paramBoolean)
            {
              if ((j.EZX.jth != 2) || (com.tencent.mm.plugin.mmsight.d.WW(this.EZs.y))) {
                break label745;
              }
              paramInt = com.tencent.mm.plugin.mmsight.d.WX(this.EZs.y);
              if (Math.abs(paramInt - this.EZs.y) > 16) {
                break label734;
              }
              Log.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.EZs, Integer.valueOf(paramInt) });
              this.EZr = new Point(this.EZs.x, this.EZs.y);
              this.EZs.y = paramInt;
              this.EZv = true;
              this.EZu = new byte[this.EZs.x * this.EZs.y * 3 / 2];
            }
            Log.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s, cropWidth: %s", new Object[] { localObject, this.EZs, this.laW, Boolean.valueOf(this.EZC) });
            localParameters.setPreviewSize(this.laR.wAw, this.laR.wAx);
            paramw.c(localParameters);
            AppMethodBeat.o(89377);
            return true;
          }
        }
        else
        {
          localObject = new Point(this.laU.getWidth(), this.laU.getHeight());
          continue;
        }
        f2 = paramInt / f2;
      }
      catch (Exception paramw)
      {
        Log.e("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimit error: %s", new Object[] { paramw.getMessage() });
        AppMethodBeat.o(89377);
        return false;
      }
      label709:
      int i = Math.round(f2);
      continue;
      label726:
      this.EZC = true;
      continue;
      label734:
      j.i(this.EZs);
      continue;
      label745:
      j.i(this.EZs);
      continue;
      label756:
      boolean bool = true;
      continue;
      label762:
      bool = true;
      continue;
      label768:
      bool = false;
      continue;
      label774:
      bool = false;
    }
  }
  
  private static boolean a(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(89379);
    if (paramw == null)
    {
      AppMethodBeat.o(89379);
      return false;
    }
    Camera.Parameters localParameters;
    label235:
    List localList2;
    do
    {
      for (;;)
      {
        try
        {
          localParameters = paramw.avd();
          if (!paramBoolean) {
            break label235;
          }
          if (af.juH.jpZ > 0)
          {
            Log.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview frame rate");
            Log.i("MicroMsg.MMSightCameraSetting", "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), localParameters.getSupportedPreviewFrameRates() });
            paramw.c(localParameters);
            AppMethodBeat.o(89379);
            return true;
          }
          if (localParameters == null)
          {
            Log.e("MicroMsg.MMSightCamera", "trySetPreviewFrameRateParameters error, p is null!");
            continue;
          }
          try
          {
            List localList1 = localParameters.getSupportedPreviewFrameRates();
            if ((localList1 == null) || (localList1.size() <= 0)) {
              continue;
            }
            i = Math.min(30, ((Integer)Collections.max(localList1)).intValue());
            localParameters.setPreviewFrameRate(i);
            Log.i("MicroMsg.MMSightCameraSetting", "set preview frame rate %d", new Object[] { Integer.valueOf(i) });
          }
          catch (Exception localException1)
          {
            Log.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException1.getMessage() });
          }
        }
        catch (Exception paramw)
        {
          Log.i("MicroMsg.MMSightCameraSetting", "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
          AppMethodBeat.o(89379);
          return false;
        }
        continue;
        if (af.juH.jpZ <= 0) {
          break;
        }
        Log.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview fps range");
      }
      localList2 = localParameters.getSupportedPreviewFpsRange();
    } while ((localList2 == null) || (localList2.size() == 0));
    int j = -2147483648;
    int i = -2147483648;
    int n = 0;
    int i6 = localList2.size();
    int i3 = 0;
    for (;;)
    {
      int i2;
      int i1;
      int i4;
      int m;
      for (;;)
      {
        if (i3 < i6)
        {
          int[] arrayOfInt = (int[])localList2.get(i3);
          i2 = i;
          i1 = j;
          if (arrayOfInt == null) {
            break label565;
          }
          i2 = i;
          i1 = j;
          if (arrayOfInt.length <= 1) {
            break label565;
          }
          int i5 = arrayOfInt[0];
          i4 = arrayOfInt[1];
          Log.i("MicroMsg.MMSightCamera", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4) });
          i2 = i;
          i1 = j;
          if (i5 < 0) {
            break label565;
          }
          i2 = i;
          i1 = j;
          if (i4 < i5) {
            break label565;
          }
          k = i;
          m = j;
          if (i4 < i) {
            break label578;
          }
          k = i;
          m = j;
          if (n != 0) {
            break label578;
          }
          k = i4;
          m = i5;
          break label578;
        }
        Log.i("MicroMsg.MMSightCameraSetting", "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(30) });
        if ((j == 2147483647) || (i == 2147483647)) {
          break;
        }
        try
        {
          localParameters.setPreviewFpsRange(j, i);
          Log.i("MicroMsg.MMSightCameraSetting", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        }
        catch (Exception localException2)
        {
          Log.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException2.getMessage() });
        }
      }
      break;
      label565:
      label578:
      do
      {
        k = n;
        i = i2;
        j = i1;
        break;
        i2 = k;
        i1 = m;
      } while (i4 < 30000);
      n = 1;
      j = m;
      i = k;
      int k = n;
      i3 += 1;
      n = k;
    }
  }
  
  private boolean a(w paramw, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(253358);
    if (paramw == null)
    {
      AppMethodBeat.o(253358);
      return false;
    }
    Camera.Parameters localParameters;
    Point localPoint;
    Object localObject1;
    Object localObject3;
    boolean bool;
    for (;;)
    {
      try
      {
        localParameters = paramw.avd();
        if (this.laU == null)
        {
          localPoint = com.tencent.mm.plugin.mmsight.d.hv(this.mContext);
          if (this.laM)
          {
            localObject1 = b.eTa();
            localObject2 = localParameters.getSupportedPreviewSizes();
            localObject3 = localParameters.getSupportedPictureSizes();
            paramInt = this.lbk.fSM;
            if (Util.isNullOrNil(((b)localObject1).EYI)) {
              ((b)localObject1).EYI = com.tencent.mm.plugin.mmsight.d.fZ((List)localObject2);
            }
            if (Util.isNullOrNil(((b)localObject1).EYJ)) {
              ((b)localObject1).EYJ = com.tencent.mm.plugin.mmsight.d.fZ((List)localObject3);
            }
            ((b)localObject1).fSM = paramInt;
            ((b)localObject1).EZd = 1;
            if (paramBoolean)
            {
              if (this.lbk.fSM == 90) {
                break label2473;
              }
              if (this.lbk.fSM != 270) {
                break label495;
              }
              break label2473;
              j.a(localParameters, bool);
            }
            com.tencent.mm.plugin.mmsight.model.a.k.eTI();
            paramInt = com.tencent.mm.plugin.mmsight.model.a.k.eTL();
            if (this.lbk.fSM == 90) {
              break label2479;
            }
            if (this.lbk.fSM != 270) {
              break label501;
            }
            break label2479;
            label203:
            localObject2 = h.a(localParameters, localPoint, paramInt, bool);
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((h.c)localObject2).EZN != null) {}
            }
            else
            {
              Log.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
              localPoint = new Point(Math.min(localPoint.x, localPoint.y), Math.max(localPoint.x, localPoint.y));
              if (this.lbk.fSM == 90) {
                break label2485;
              }
              if (this.lbk.fSM != 270) {
                break label507;
              }
              break label2485;
              label304:
              localObject1 = h.d(localParameters, localPoint, 2100, bool);
              this.EZC = false;
            }
            j.a((h.c)localObject1);
            localPoint = ((h.c)localObject1).EZN;
            if (localPoint != null) {
              break;
            }
            k.eTu();
            AppMethodBeat.o(253358);
            return false;
          }
        }
        else
        {
          localPoint = new Point(this.laU.getWidth(), this.laU.getHeight());
          continue;
        }
        localObject1 = b.eTa();
        localObject2 = localParameters.getSupportedPreviewSizes();
        localObject3 = localParameters.getSupportedPictureSizes();
        paramInt = this.lbk.fSM;
        if (Util.isNullOrNil(((b)localObject1).EYK)) {
          ((b)localObject1).EYK = com.tencent.mm.plugin.mmsight.d.fZ((List)localObject2);
        }
        if (Util.isNullOrNil(((b)localObject1).EYL)) {
          ((b)localObject1).EYL = com.tencent.mm.plugin.mmsight.d.fZ((List)localObject3);
        }
        ((b)localObject1).fSM = paramInt;
        ((b)localObject1).EZd = 2;
        continue;
        bool = false;
      }
      catch (Exception paramw)
      {
        Log.i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
        AppMethodBeat.o(253358);
        return false;
      }
      label495:
      continue;
      label501:
      bool = false;
      continue;
      label507:
      bool = false;
    }
    this.laR.wAw = localPoint.x;
    this.laR.wAx = localPoint.y;
    this.EZs = localPoint;
    Object localObject2 = this.mContext;
    if (this.lbk.fSM != 90) {
      if (this.lbk.fSM == 270)
      {
        break label2491;
        label577:
        bool = com.tencent.mm.plugin.mmsight.d.a((Context)localObject2, localPoint, bool);
        paramInt = 1;
        if ((this.lbk.fSM != 90) && (this.lbk.fSM != 270)) {
          break label1333;
        }
        if ((localPoint.y < this.EZB.width) || (localPoint.x < this.EZB.height))
        {
          paramInt = 0;
          Log.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localPoint });
        }
        label665:
        Log.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label1418;
        }
        if (j.EZX.jth != 2) {
          break label1406;
        }
        this.laW = ((h.c)localObject1).EZP;
        if ((this.laW.x < localPoint.x) || (this.laW.y < localPoint.y))
        {
          if ((this.lbk.fSM != 90) && (this.lbk.fSM != 270)) {
            break label1386;
          }
          this.laW.y = com.tencent.mm.plugin.mmsight.d.WY(this.laW.y);
        }
        label781:
        this.EZs = new Point(this.laW.x, this.laW.y);
        this.EZt = (this.laW.x * this.laW.y * 3 / 2);
        Log.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", new Object[] { this.laW });
      }
    }
    label914:
    label929:
    label943:
    label1333:
    label1845:
    label1978:
    label2491:
    label2497:
    for (;;)
    {
      label848:
      int i;
      int j;
      if (j.EZX.Fak)
      {
        if ((this.lbk.fSM != 90) && (this.lbk.fSM != 270)) {
          break label2017;
        }
        if (paramInt != 0)
        {
          if (j.EZX.laT != 1080) {
            break label1845;
          }
          if (this.laW != null) {
            break label1794;
          }
          i = localPoint.x / 2;
          if (this.laW != null) {
            break label1808;
          }
          paramInt = localPoint.y / 2;
          if (this.laW != null) {
            break label1821;
          }
          j = localPoint.x;
          j = com.tencent.mm.plugin.mmsight.d.id(i, j);
          if (this.laW != null) {
            break label1833;
          }
          i = localPoint.y;
          label966:
          this.EZs = new Point(j, com.tencent.mm.plugin.mmsight.d.id(paramInt, i));
        }
      }
      label985:
      localObject1 = b.eTa();
      localObject2 = this.laW;
      localObject3 = this.EZs;
      ((b)localObject1).EYR = -1;
      ((b)localObject1).EYQ = -1;
      ((b)localObject1).EYN = -1;
      ((b)localObject1).EYM = -1;
      ((b)localObject1).EYP = -1;
      ((b)localObject1).EYO = -1;
      if (localPoint != null)
      {
        ((b)localObject1).EYO = localPoint.x;
        ((b)localObject1).EYP = localPoint.y;
      }
      if (localObject2 != null)
      {
        ((b)localObject1).EYM = ((Point)localObject2).x;
        ((b)localObject1).EYN = ((Point)localObject2).y;
      }
      if (localObject3 != null)
      {
        ((b)localObject1).EYQ = ((Point)localObject3).x;
        ((b)localObject1).EYR = ((Point)localObject3).y;
      }
      if (paramBoolean) {
        if ((!bool) && (j.EZX.jth == 2) && (!com.tencent.mm.plugin.mmsight.d.WW(this.EZs.y)))
        {
          paramInt = com.tencent.mm.plugin.mmsight.d.WX(this.EZs.y);
          if (Math.abs(paramInt - this.EZs.y) <= 16)
          {
            Log.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.EZs, Integer.valueOf(paramInt) });
            this.EZr = new Point(this.EZs.x, this.EZs.y);
            this.EZs.y = paramInt;
            this.EZv = true;
            this.EZu = new byte[this.EZs.x * this.EZs.y * 3 / 2];
          }
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", new Object[] { localPoint, this.EZs, this.laW });
        localParameters.setPreviewSize(this.laR.wAw, this.laR.wAx);
        paramw.c(localParameters);
        AppMethodBeat.o(253358);
        return true;
        bool = false;
        break;
        if ((localPoint.x >= this.EZB.width) && (localPoint.y >= this.EZB.height)) {
          break label665;
        }
        paramInt = 0;
        Log.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localPoint });
        break label665;
        label1386:
        this.laW.x = com.tencent.mm.plugin.mmsight.d.WY(this.laW.x);
        break label781;
        label1406:
        this.laW = ((h.c)localObject1).EZO;
        break label781;
        if ((!j.EZX.Fak) || (j.EZX.laT != 1080) || (paramInt == 0)) {
          break label2470;
        }
        if ((this.lbk.fSM == 90) || (this.lbk.fSM == 270))
        {
          i = localPoint.y / 2;
          j = com.tencent.mm.plugin.mmsight.d.WX(i);
          k = localPoint.x / 2;
          m = com.tencent.mm.plugin.mmsight.d.WX(k);
          if ((Math.abs(j - i) < 8) && (Math.abs(m - k) < 8)) {
            break label2497;
          }
          this.laW = new Point(localPoint.x, localPoint.y);
          this.laW.y = com.tencent.mm.plugin.mmsight.d.WY(localPoint.y);
          this.laW.x = com.tencent.mm.plugin.mmsight.d.WY(localPoint.x);
          this.EZs = new Point(this.laW.x, this.laW.y);
          this.EZt = (this.laW.x * this.laW.y * 3 / 2);
          bool = true;
          break label2497;
        }
        i = localPoint.x / 2;
        j = com.tencent.mm.plugin.mmsight.d.WX(i);
        int k = localPoint.y / 2;
        int m = com.tencent.mm.plugin.mmsight.d.WX(k);
        if ((Math.abs(j - i) < 8) && (Math.abs(m - k) < 8)) {
          break label2470;
        }
        this.laW = new Point(localPoint.x, localPoint.y);
        this.laW.y = com.tencent.mm.plugin.mmsight.d.WY(localPoint.x);
        this.laW.x = com.tencent.mm.plugin.mmsight.d.WY(localPoint.y);
        this.EZs = new Point(this.laW.x, this.laW.y);
        this.EZt = (this.laW.x * this.laW.y * 3 / 2);
        bool = true;
        break label848;
        i = this.laW.x / 2;
        break label914;
        paramInt = this.laW.y / 2;
        break label929;
        j = this.laW.x;
        break label943;
        i = this.laW.y;
        break label966;
        if (j.EZX.laT != 720) {
          break label985;
        }
        float f;
        if (this.laW == null)
        {
          f = localPoint.x * 0.75F;
          label1876:
          j = (int)f;
          if (this.laW != null) {
            break label1978;
          }
          f = localPoint.y * 0.75F;
          label1900:
          i = (int)f;
          if (this.laW != null) {
            break label1995;
          }
          paramInt = localPoint.x;
          label1918:
          j = com.tencent.mm.plugin.mmsight.d.id(j, paramInt);
          if (this.laW != null) {
            break label2006;
          }
        }
        label1995:
        label2006:
        for (paramInt = localPoint.y;; paramInt = this.laW.y)
        {
          this.EZs = new Point(j, com.tencent.mm.plugin.mmsight.d.id(i, paramInt));
          break;
          f = this.laW.x * 0.75F;
          break label1876;
          f = this.laW.y * 0.75F;
          break label1900;
          paramInt = this.laW.x;
          break label1918;
        }
        label2017:
        if (paramInt == 0) {
          break label985;
        }
        if (j.EZX.laT == 1080)
        {
          if (this.laW == null)
          {
            i = localPoint.y / 2;
            if (this.laW != null) {
              break label2137;
            }
            paramInt = localPoint.x / 2;
            if (this.laW != null) {
              break label2150;
            }
            j = localPoint.y;
            j = com.tencent.mm.plugin.mmsight.d.id(i, j);
            if (this.laW != null) {
              break label2162;
            }
          }
          label2137:
          label2150:
          label2162:
          for (i = localPoint.x;; i = this.laW.x)
          {
            this.EZs = new Point(j, com.tencent.mm.plugin.mmsight.d.id(paramInt, i));
            break;
            i = this.laW.y / 2;
            break label2049;
            paramInt = this.laW.x / 2;
            break label2064;
            j = this.laW.y;
            break label2078;
          }
        }
        if (j.EZX.laT != 720) {
          break label985;
        }
        if (this.laW == null)
        {
          f = localPoint.y * 0.75F;
          j = (int)f;
          if (this.laW != null) {
            break label2307;
          }
          f = localPoint.x * 0.75F;
          i = (int)f;
          if (this.laW != null) {
            break label2324;
          }
          paramInt = localPoint.y;
          label2247:
          j = com.tencent.mm.plugin.mmsight.d.id(j, paramInt);
          if (this.laW != null) {
            break label2335;
          }
        }
        for (paramInt = localPoint.x;; paramInt = this.laW.x)
        {
          this.EZs = new Point(j, com.tencent.mm.plugin.mmsight.d.id(i, paramInt));
          break;
          f = this.laW.y * 0.75F;
          break label2205;
          f = this.laW.x * 0.75F;
          break label2229;
          paramInt = this.laW.y;
          break label2247;
        }
        j.i(this.EZs);
        continue;
        j.i(this.EZs);
        continue;
        if ((!bool) && (j.EZX.jth == 2) && (!com.tencent.mm.plugin.mmsight.d.WW(this.EZs.y)) && (this.EZv) && (this.EZu != null) && (this.EZr.y == this.EZs.y))
        {
          paramInt = com.tencent.mm.plugin.mmsight.d.WX(this.EZs.y);
          if (this.EZu.length == this.EZs.x * paramInt * 3 / 2) {
            this.EZs.y = paramInt;
          }
        }
      }
      continue;
      bool = true;
      break;
      bool = true;
      break label203;
      bool = true;
      break label304;
      bool = true;
      break label577;
    }
  }
  
  private void aXO()
  {
    AppMethodBeat.i(89388);
    if (true == this.EZD)
    {
      AppMethodBeat.o(89388);
      return;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(89388);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.e.b.avv()))
    {
      AppMethodBeat.o(89388);
      return;
    }
    Object localObject = new qj();
    ((qj)localObject).fPf.type = 2;
    EventCenter.instance.publish((IEvent)localObject);
    if (((qj)localObject).fPg.fPe)
    {
      this.EZD = true;
      AppMethodBeat.o(89388);
      return;
    }
    localObject = com.tencent.mm.ui.base.h.p(this.mContext, a.a.short_video_no_record_video_permission, a.a.app_tip);
    if (localObject != null)
    {
      ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
      ((com.tencent.mm.ui.widget.a.d)localObject).setCanceledOnTouchOutside(false);
      ((com.tencent.mm.ui.widget.a.d)localObject).show();
      this.EZD = true;
    }
    AppMethodBeat.o(89388);
  }
  
  private void aYg()
  {
    AppMethodBeat.i(89384);
    if (this.jqD != null) {
      try
      {
        Object localObject = this.jqD.avd();
        Log.i("MicroMsg.MMSightCamera", "setPreviewCallbackImpl");
        int i = this.laR.wAw;
        int j = this.laR.wAx;
        j = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject).getPreviewFormat()) * (i * j) / 8;
        i = 0;
        while (i < 5)
        {
          localObject = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(j));
          this.jqD.aj((byte[])localObject);
          i += 1;
        }
        this.lbm.reset();
        this.lbn.reset();
        this.lbo.reset();
        this.lbp.reset();
        this.EZA.reset();
        this.lbq.reset();
        this.EZw = new a();
        this.jqD.b(new Camera.PreviewCallback()
        {
          public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
          {
            AppMethodBeat.i(89361);
            if (!f.this.EZy)
            {
              Log.i("MicroMsg.MMSightCamera", "onPreviewFrame: %s %s", new Object[] { paramAnonymousArrayOfByte, f.this.jqD });
              f.this.EZy = true;
            }
            if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
            {
              Log.e("MicroMsg.MMSightCamera", "onPreviewFrame, frame data is null!!");
              AppMethodBeat.o(89361);
              return;
            }
            paramAnonymousCamera = f.this.EZw;
            if (paramAnonymousCamera.sfh == 0)
            {
              paramAnonymousCamera.sfg += 1;
              paramAnonymousCamera.sff = Util.safeParseInt(m.auu());
            }
            paramAnonymousCamera.sfh += 1;
            int i;
            long l1;
            byte[] arrayOfByte;
            label367:
            long l2;
            int j;
            boolean bool;
            if (paramAnonymousCamera.sfh >= 90)
            {
              i = 0;
              paramAnonymousCamera.sfh = i;
              if ((f.a(f.this)) || (f.this.lbj == null) || (f.this.lbj.size() <= 0)) {
                break label944;
              }
              if (f.this.laW == null) {
                break label584;
              }
              paramAnonymousCamera = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(f.this.laR.wAw * f.this.laW.y * 3 / 2));
              f.b(f.this).Ox(1L);
              l1 = Util.currentTicks();
              SightVideoJNI.cropCameraData(paramAnonymousArrayOfByte, paramAnonymousCamera, f.this.laR.wAw, f.this.laR.wAx, f.this.laW.y);
              if (f.this.laW.x >= f.this.laR.wAw) {
                break label941;
              }
              arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(f.this.laW.x * f.this.laW.y * 3 / 2));
              SightVideoJNI.cropCameraDataLongEdge(paramAnonymousCamera, arrayOfByte, f.this.laR.wAw, f.this.laW.x, f.this.laW.y);
              com.tencent.mm.plugin.mmsight.model.a.j.FbH.as(paramAnonymousCamera);
              paramAnonymousCamera = arrayOfByte;
              l2 = Util.ticksToNow(l1);
              f.c(f.this).Ox(l2);
              if (!f.this.laM)
              {
                l1 = Util.currentTicks();
                i = f.this.laW.x;
                j = f.this.laW.y;
                if ((f.this.lbk.fSM != 270) && (f.this.lbk.fSM != 90)) {
                  break label578;
                }
                bool = true;
                label458:
                SightVideoJNI.mirrorCameraData(paramAnonymousCamera, i, j, bool);
                l2 = Util.ticksToNow(l1);
                f.d(f.this).Ox(l2);
              }
              bool = f.a(f.this, paramAnonymousCamera);
              l1 = Util.ticksToNow(l1);
              if (bool) {
                f.e(f.this).Ox(l1);
              }
            }
            for (;;)
            {
              f.b(f.this, paramAnonymousCamera);
              if (f.f(f.this) == f.a.EZH) {
                f.g(f.this).Ox(1L);
              }
              for (;;)
              {
                f.this.jqD.aj(paramAnonymousArrayOfByte);
                AppMethodBeat.o(89361);
                return;
                i = paramAnonymousCamera.sfh;
                break;
                label578:
                bool = false;
                break label458;
                label584:
                l1 = Util.currentTicks();
                label656:
                label753:
                f localf;
                if (!f.this.laM)
                {
                  i = f.this.laR.wAw;
                  j = f.this.laR.wAx;
                  if ((f.this.lbk.fSM == 270) || (f.this.lbk.fSM == 90))
                  {
                    bool = true;
                    SightVideoJNI.mirrorCameraData(paramAnonymousArrayOfByte, i, j, bool);
                    l2 = Util.ticksToNow(l1);
                    f.d(f.this).Ox(l2);
                  }
                }
                else
                {
                  if ((!f.this.EZv) || (f.this.EZu == null)) {
                    break label898;
                  }
                  SightVideoJNI.paddingYuvData16(paramAnonymousArrayOfByte, f.this.EZu, f.this.EZs.x, f.this.EZr.y, f.this.EZs.y);
                  paramAnonymousCamera = f.this.EZu;
                  bool = f.a(f.this, paramAnonymousCamera);
                  l1 = Util.ticksToNow(l1);
                  if (bool) {
                    f.e(f.this).Ox(l1);
                  }
                  if (f.this.EZv)
                  {
                    arrayOfByte = paramAnonymousArrayOfByte;
                    if (f.this.EZu != null) {}
                  }
                  else
                  {
                    arrayOfByte = paramAnonymousArrayOfByte;
                    if (bool) {
                      arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(paramAnonymousArrayOfByte.length));
                    }
                  }
                  if ((f.this.EZv) && (f.this.EZu != null))
                  {
                    localf = f.this;
                    if (!bool) {
                      break label903;
                    }
                  }
                }
                label898:
                label903:
                for (paramAnonymousArrayOfByte = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(f.this.EZu.length));; paramAnonymousArrayOfByte = f.this.EZu)
                {
                  localf.EZu = paramAnonymousArrayOfByte;
                  paramAnonymousArrayOfByte = arrayOfByte;
                  break;
                  bool = false;
                  break label656;
                  paramAnonymousCamera = paramAnonymousArrayOfByte;
                  break label753;
                }
                if (f.f(f.this) == f.a.EZI) {
                  f.h(f.this).Ox(1L);
                }
              }
              label941:
              break label367;
              label944:
              arrayOfByte = paramAnonymousArrayOfByte;
              paramAnonymousCamera = paramAnonymousArrayOfByte;
              paramAnonymousArrayOfByte = arrayOfByte;
            }
          }
        });
        AppMethodBeat.o(89384);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MMSightCamera", "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89384);
  }
  
  private static boolean b(w paramw)
  {
    AppMethodBeat.i(89380);
    if (paramw == null)
    {
      AppMethodBeat.o(89380);
      return false;
    }
    try
    {
      Log.i("MicroMsg.MMSightCameraSetting", "safeSetPreviewFormat");
      Camera.Parameters localParameters = paramw.avd();
      List localList = localParameters.getSupportedPreviewFormats();
      if ((localList == null) || (!localList.contains(Integer.valueOf(17)))) {
        Log.e("MicroMsg.MMSightCameraSetting", "not support YCbCr_420_SP");
      }
      localParameters.setPreviewFormat(17);
      paramw.c(localParameters);
      AppMethodBeat.o(89380);
      return true;
    }
    catch (Exception paramw)
    {
      Log.i("MicroMsg.MMSightCameraSetting", "setPreviewFormat Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
      AppMethodBeat.o(89380);
    }
    return false;
  }
  
  @TargetApi(14)
  private static boolean c(w paramw)
  {
    AppMethodBeat.i(89378);
    if (paramw == null)
    {
      AppMethodBeat.o(89378);
      return false;
    }
    try
    {
      Log.i("MicroMsg.MMSightCameraSetting", "safeSetMetering");
      Camera.Parameters localParameters = paramw.avd();
      if (localParameters.getMaxNumMeteringAreas() > 0)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new Camera.Area(new Rect(-1000, -1000, 1000, 1000), 600));
        localParameters.setMeteringAreas(localArrayList);
      }
      paramw.c(localParameters);
      AppMethodBeat.o(89378);
      return true;
    }
    catch (Exception paramw)
    {
      Log.i("MicroMsg.MMSightCameraSetting", "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
      AppMethodBeat.o(89378);
    }
    return false;
  }
  
  private static void d(w paramw)
  {
    AppMethodBeat.i(89387);
    try
    {
      Camera.Parameters localParameters = paramw.avd();
      if (localParameters.isZoomSupported()) {
        localParameters.setZoom(0);
      }
      paramw.c(localParameters);
      AppMethodBeat.o(89387);
      return;
    }
    catch (Exception paramw)
    {
      Log.e("MicroMsg.MMSightCamera", "safeResetZoom error: %s", new Object[] { paramw.getMessage() });
      AppMethodBeat.o(89387);
    }
  }
  
  private void eTe()
  {
    AppMethodBeat.i(89375);
    try
    {
      if ((this.mSensorManager != null) && (this.EZn != null)) {
        this.mSensorManager.unregisterListener(this);
      }
      Log.i("MicroMsg.MMSightCamera", this.lbm.getValue());
      Log.i("MicroMsg.MMSightCamera", this.lbn.getValue());
      Log.i("MicroMsg.MMSightCamera", this.lbo.getValue());
      Log.i("MicroMsg.MMSightCamera", this.lbp.getValue());
      Log.i("MicroMsg.MMSightCamera", this.EZA.getValue());
      Log.i("MicroMsg.MMSightCamera", this.lbq.getValue());
      if (this.jqD != null)
      {
        long l = Util.currentTicks();
        Log.i("MicroMsg.MMSightCamera", "release camera beg, %s", new Object[] { Looper.myLooper() });
        this.EZF.removeCallbacksAndMessages(null);
        this.EZF.lbw = true;
        this.jqD.a(null);
        this.jqD.TL();
        this.jqD.release();
        this.jqD = null;
        this.EZk = false;
        Log.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
      }
      this.EZj = false;
      this.EZo = 0.0F;
      this.EZp = 0.0F;
      this.EZq = 0.0F;
      EZE = true;
      this.mContext = null;
      this.EZD = false;
      this.EZs = null;
      this.laW = null;
      this.lbt = null;
      this.EZy = false;
      AppMethodBeat.o(89375);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMSightCamera", localException, "cameraRelease error", new Object[0]);
      AppMethodBeat.o(89375);
    }
  }
  
  public final boolean G(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(89398);
    if ((!j.EZX.Fal) || ((af.juH.jqh == 0) && (this.mSensorManager == null) && (this.EZn == null)))
    {
      this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      this.EZn = this.mSensorManager.getDefaultSensor(1);
    }
    if (this.jqD == null)
    {
      eTe();
      this.laM = paramBoolean;
      if (paramBoolean) {}
      try
      {
        for (this.EZl = com.tencent.mm.compatible.deviceinfo.d.auk();; this.EZl = com.tencent.mm.compatible.deviceinfo.d.aul())
        {
          Log.i("MicroMsg.MMSightCamera", "use camera id %d, SrvDeviceInfo id %d", new Object[] { Integer.valueOf(this.EZl), Integer.valueOf(af.juH.jqk) });
          this.EZD = false;
          this.mContext = paramContext;
          this.lbk = new n().D(paramContext, this.EZl);
          Log.i("MicroMsg.MMSightCamera", "open camera end, %s", new Object[] { Looper.myLooper() });
          if (this.lbk != null) {
            break;
          }
          Log.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", new Object[] { Looper.myLooper() });
          aXO();
          AppMethodBeat.o(89398);
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.MMSightCamera", localException, "try to get cameraid error %s, useBackCamera: %s", new Object[] { localException.getMessage(), Boolean.valueOf(this.laM) });
          this.EZl = 0;
        }
        this.jqD = this.lbk.jqD;
        this.EZF.lbw = false;
        this.laR.fSM = this.lbk.fSM;
        if (this.jqD == null)
        {
          Log.e("MicroMsg.MMSightCamera", "start camera FAILED!");
          aXO();
          AppMethodBeat.o(89398);
          return false;
        }
      }
    }
    AppMethodBeat.o(89398);
    return true;
  }
  
  public final void Xa(int paramInt)
  {
    AppMethodBeat.i(89395);
    if (this.jqD != null) {
      try
      {
        Camera.Parameters localParameters = this.jqD.avd();
        boolean bool = localParameters.isZoomSupported();
        if (!bool) {
          return;
        }
        if (paramInt >= 0)
        {
          int i = localParameters.getMaxZoom();
          if (paramInt <= i) {}
        }
        else
        {
          return;
        }
        if (this.aHx)
        {
          Log.d("MicroMsg.MMSightCamera", "setForceZoomTargetRatio, zooming, ignore");
          return;
        }
        this.aHx = true;
        localParameters.setZoom(paramInt);
        this.jqD.c(localParameters);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MMSightCamera", "getZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aHx = false;
        AppMethodBeat.o(89395);
      }
    }
    AppMethodBeat.o(89395);
  }
  
  public final int a(SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(89386);
    long l = Util.currentTicks();
    this.EZy = false;
    Log.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s", new Object[] { Boolean.valueOf(this.EZk), Looper.myLooper(), paramSurfaceTexture });
    if (this.EZk)
    {
      AppMethodBeat.o(89386);
      return 0;
    }
    if (paramSurfaceTexture == null)
    {
      paramInt = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(89386);
      return 0 - paramInt;
    }
    Log.i("MicroMsg.MMSightCamera", "this texture %s", new Object[] { paramSurfaceTexture });
    for (;;)
    {
      try
      {
        a(this.jqD, paramInt, paramFloat, paramBoolean);
        if (com.tencent.mm.plugin.mmsight.model.a.k.eTI().FbJ == null) {
          break label654;
        }
        localInteger = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.k.eTI().FbJ.EYs);
        if (af.juH.jqe == 1)
        {
          str = "Range";
          if (af.juH.jqf != 1) {
            break label671;
          }
          paramBoolean = true;
          if (af.juH.jqg != 1) {
            break label677;
          }
          bool1 = true;
          if (af.juH.jqh != 1) {
            break label683;
          }
          bool2 = true;
          if (af.juH.jqi != 1) {
            break label689;
          }
          bool3 = true;
          Log.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((af.juH.jqe == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            a(this.jqD, false);
            if ((af.juH.jqf == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              b(this.jqD);
            }
            if ((af.juO.jtp != -1) && (af.juO.jtp == 1) && (com.tencent.mm.compatible.util.d.qX(14))) {
              c(this.jqD);
            }
            if ((af.juH.jqh == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              a(this.jqD);
            }
            if ((af.juH.jqi == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            d(this.jqD);
            aYg();
            this.jqD.f(paramSurfaceTexture);
            this.jqD.ave();
            if (!j.EZX.Fal) {
              break label637;
            }
            if ((af.juH.jqh == 0) && (this.mSensorManager != null) && (this.EZn != null)) {
              this.mSensorManager.registerListener(this, this.EZn, 2);
            }
            this.EZk = true;
            Log.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
            AppMethodBeat.o(89386);
            return 0;
          }
        }
        else
        {
          if (af.juH.jqd != 1) {
            break label663;
          }
          str = "Fix";
          continue;
        }
        if ((af.juH.jqd != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        a(this.jqD, true);
        continue;
        this.mSensorManager.registerListener(this, this.EZn, 2);
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramInt = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(89386);
        return 0 - paramInt;
      }
      label637:
      continue;
      label654:
      Integer localInteger = Integer.valueOf(0);
      continue;
      label663:
      String str = "Error";
      continue;
      label671:
      paramBoolean = false;
      continue;
      label677:
      boolean bool1 = false;
      continue;
      label683:
      boolean bool2 = false;
      continue;
      label689:
      boolean bool3 = false;
    }
  }
  
  @TargetApi(11)
  public final int a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    AppMethodBeat.i(89385);
    long l = Util.currentTicks();
    this.EZy = false;
    Log.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", new Object[] { Boolean.valueOf(this.EZk), Looper.myLooper(), paramSurfaceTexture, Boolean.valueOf(paramBoolean) });
    if (this.EZk)
    {
      AppMethodBeat.o(89385);
      return 0;
    }
    int i;
    if (paramSurfaceTexture == null)
    {
      i = com.tencent.mm.compatible.util.f.getLine();
      AppMethodBeat.o(89385);
      return 0 - i;
    }
    Log.i("MicroMsg.MMSightCamera", "this texture %s", new Object[] { paramSurfaceTexture });
    for (;;)
    {
      try
      {
        a(this.jqD, paramBoolean, 0);
        if (com.tencent.mm.plugin.mmsight.model.a.k.eTI().FbJ == null) {
          break label657;
        }
        localInteger = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.k.eTI().FbJ.EYs);
        if (af.juH.jqe == 1)
        {
          str = "Range";
          if (af.juH.jqf != 1) {
            break label674;
          }
          paramBoolean = true;
          if (af.juH.jqg != 1) {
            break label679;
          }
          bool1 = true;
          if (af.juH.jqh != 1) {
            break label685;
          }
          bool2 = true;
          if (af.juH.jqi != 1) {
            break label691;
          }
          bool3 = true;
          Log.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((af.juH.jqe == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            a(this.jqD, false);
            if ((af.juH.jqf == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              b(this.jqD);
            }
            if ((af.juO.jtp != -1) && (af.juO.jtp == 1) && (com.tencent.mm.compatible.util.d.qX(14))) {
              c(this.jqD);
            }
            if ((af.juH.jqh == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              a(this.jqD);
            }
            if ((af.juH.jqi == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            d(this.jqD);
            aYg();
            this.jqD.f(paramSurfaceTexture);
            this.jqD.ave();
            if (!j.EZX.Fal) {
              break label640;
            }
            if ((af.juH.jqh == 0) && (this.mSensorManager != null) && (this.EZn != null)) {
              this.mSensorManager.registerListener(this, this.EZn, 2);
            }
            this.EZk = true;
            Log.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
            AppMethodBeat.o(89385);
            return 0;
          }
        }
        else
        {
          if (af.juH.jqd != 1) {
            break label666;
          }
          str = "Fix";
          continue;
        }
        if ((af.juH.jqd != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        a(this.jqD, true);
        continue;
        this.mSensorManager.registerListener(this, this.EZn, 2);
      }
      catch (Exception paramSurfaceTexture)
      {
        Log.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        i = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(89385);
        return 0 - i;
      }
      label640:
      continue;
      label657:
      Integer localInteger = Integer.valueOf(0);
      continue;
      label666:
      String str = "Error";
      continue;
      label674:
      paramBoolean = false;
      continue;
      label679:
      boolean bool1 = false;
      continue;
      label685:
      boolean bool2 = false;
      continue;
      label691:
      boolean bool3 = false;
    }
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(89374);
    this.EZz = parama;
    String str1;
    String str2;
    a locala;
    if (parama == f.a.EZJ)
    {
      parama = b.eTa();
      str1 = this.lbn.eTc();
      str2 = this.lbm.eTc();
      locala = this.EZw;
      if (locala.sfg != 0) {
        break label94;
      }
    }
    label94:
    for (int i = 0;; i = locala.sff / locala.sfg)
    {
      parama.EYS = ((int)(Util.safeParseDouble(str1) * 10.0D));
      parama.EYT = ((int)(Util.safeParseDouble(str2) * 10.0D));
      parama.EYY = i;
      AppMethodBeat.o(89374);
      return;
    }
  }
  
  public final void a(b paramb, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(89390);
    Log.i("MicroMsg.MMSightCamera", "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s", new Object[] { paramb, this.lbt, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.lbt != null) {
      try
      {
        this.lbr = true;
        Point localPoint = new Point();
        if (this.laW != null) {
          localPoint.x = this.laW.x;
        }
        for (localPoint.y = this.laW.y;; localPoint.y = this.EZs.y)
        {
          byte[] arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(this.lbt.length));
          System.arraycopy(this.lbt, 0, arrayOfByte, 0, this.lbt.length);
          int i = this.lbk.fSM;
          paramb.a(arrayOfByte, localPoint.x, localPoint.y, i, paramInt);
          return;
          if ((this.EZu == null) || (!this.EZv)) {
            break;
          }
          localPoint.x = this.EZs.x;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMSightCamera", "takePicture error: %s", new Object[] { localException.getMessage() });
          this.lbr = false;
          paramb.a(null, 0, 0, -1, 0);
          return;
          localException.x = this.laR.wAw;
          localException.y = this.laR.wAx;
        }
      }
      finally
      {
        this.lbr = false;
        AppMethodBeat.o(89390);
      }
    }
    paramb.a(null, 0, 0, -1, 0);
    AppMethodBeat.o(89390);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(89372);
    if (paramg != null) {
      this.lbj.add(paramg);
    }
    AppMethodBeat.o(89372);
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(89400);
    Log.i("MicroMsg.MMSightCamera", "switch camera with limit, current useBack: %s", new Object[] { Boolean.valueOf(this.laM) });
    try
    {
      eTk();
      if (!this.laM) {}
      for (boolean bool = true;; bool = false)
      {
        G(paramContext, bool);
        a(paramSurfaceTexture, paramInt, paramFloat, paramBoolean);
        AppMethodBeat.o(89400);
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[] { paramContext });
      AppMethodBeat.o(89400);
    }
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    AppMethodBeat.i(89399);
    Log.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", new Object[] { Boolean.valueOf(this.laM) });
    try
    {
      eTk();
      if (!this.laM) {}
      for (boolean bool = true;; bool = false)
      {
        G(paramContext, bool);
        a(paramSurfaceTexture, paramBoolean);
        AppMethodBeat.o(89399);
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[] { paramContext });
      AppMethodBeat.o(89399);
    }
  }
  
  public final boolean aYp()
  {
    return this.laM;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89392);
    if (com.tencent.mm.compatible.util.d.qW(14))
    {
      AppMethodBeat.o(89392);
      return;
    }
    this.EZF.removeMessages(4354);
    this.EZF.jLa = paramFloat1;
    this.EZF.jLb = paramFloat2;
    this.EZF.lbP = paramInt1;
    this.EZF.lbQ = paramInt2;
    this.EZF.sendMessageDelayed(this.EZF.obtainMessage(4354, this.jqD), 400L);
    AppMethodBeat.o(89392);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(89373);
    if (paramg != null) {
      this.lbj.remove(paramg);
    }
    AppMethodBeat.o(89373);
  }
  
  public final void d(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(89396);
    if ((this.jqD != null) && (this.EZk)) {}
    for (;;)
    {
      int m;
      int k;
      int j;
      try
      {
        Log.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (this.aHx)
        {
          Log.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
          return;
        }
        Camera.Parameters localParameters = this.jqD.avd();
        if (localParameters.isZoomSupported())
        {
          this.aHx = true;
          m = localParameters.getZoom();
          k = localParameters.getMaxZoom();
          if (!paramBoolean2)
          {
            if (this.laY <= 0)
            {
              this.laY = Math.round(k / 15.0F);
              if (this.laY > 5) {
                this.laY = 5;
              }
            }
            i = this.laY;
            Log.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(this.laY), Integer.valueOf(this.laX), Integer.valueOf(paramInt) });
            j = i;
            if (paramInt > 0) {
              j = i * paramInt;
            }
            if (paramBoolean1) {
              if (m < k) {
                break label437;
              }
            }
          }
          else
          {
            if (this.laX <= 0)
            {
              Log.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", new Object[] { Integer.valueOf(this.laX) });
              return;
            }
            i = this.laX;
            continue;
            Log.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", new Object[] { Integer.valueOf(paramInt) });
            localParameters.setZoom(paramInt);
            this.jqD.c(localParameters);
          }
        }
        else
        {
          return;
        }
        if (m == 0) {
          return;
        }
        int i = m - j;
        paramInt = i;
        if (i > 0) {
          continue;
        }
        paramInt = 0;
        continue;
        AppMethodBeat.o(89396);
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MMSightCamera", "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aHx = false;
        AppMethodBeat.o(89396);
      }
      return;
      label437:
      do
      {
        break;
        paramInt = j + m;
      } while (paramInt < k);
      paramInt = k;
    }
  }
  
  public final Point diO()
  {
    return this.EZs;
  }
  
  public final void eTf()
  {
    AppMethodBeat.i(89382);
    Log.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
    if ((this.jqD != null) && (this.EZk)) {
      try
      {
        Camera.Parameters localParameters = this.jqD.avd();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          Log.i("MicroMsg.MMSightCameraSetting", "support continuous video");
          localParameters.setFocusMode("continuous-video");
        }
        this.jqD.c(localParameters);
        AppMethodBeat.o(89382);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89382);
  }
  
  public final void eTg()
  {
    AppMethodBeat.i(89383);
    Log.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode");
    if ((this.jqD != null) && (this.EZk)) {
      try
      {
        Camera.Parameters localParameters = this.jqD.avd();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          Log.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
        }
        this.jqD.c(localParameters);
        AppMethodBeat.o(89383);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89383);
  }
  
  public final String eTh()
  {
    AppMethodBeat.i(89389);
    if (this.jqD == null)
    {
      AppMethodBeat.o(89389);
      return "";
    }
    StringBuffer localStringBuffer;
    Object localObject2;
    for (;;)
    {
      Object localObject3;
      try
      {
        localStringBuffer = new StringBuffer();
        localObject3 = com.tencent.mm.plugin.mmsight.d.f(this.jqD.avd());
        if (this.laU == null)
        {
          Object localObject1 = com.tencent.mm.plugin.mmsight.d.hv(this.mContext);
          localStringBuffer.append(String.format("Screen size %d %d r:%.4f\n", new Object[] { Integer.valueOf(((Point)localObject1).x), Integer.valueOf(((Point)localObject1).y), Double.valueOf(((Point)localObject1).x * 1.0D / ((Point)localObject1).y) }));
          localObject1 = ((ArrayList)localObject3).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject3 = (Camera.Size)((Iterator)localObject1).next();
          if (((getPreviewWidth() != ((Camera.Size)localObject3).width) || (getPreviewHeight() != ((Camera.Size)localObject3).height)) && ((getPreviewWidth() != ((Camera.Size)localObject3).height) || (getPreviewHeight() != ((Camera.Size)localObject3).width))) {
            break label290;
          }
          localStringBuffer.append(String.format("%s*%s √ r:%.4f\n", new Object[] { Integer.valueOf(((Camera.Size)localObject3).width), Integer.valueOf(((Camera.Size)localObject3).height), Double.valueOf(((Camera.Size)localObject3).height * 1.0D / ((Camera.Size)localObject3).width) }));
          continue;
        }
        localObject2 = new Point(this.laU.getWidth(), this.laU.getHeight());
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MMSightCamera", "getDebugInfo error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(89389);
        return null;
      }
      continue;
      label290:
      localStringBuffer.append(String.format("%s*%s X r:%.4f\n", new Object[] { Integer.valueOf(((Camera.Size)localObject3).width), Integer.valueOf(((Camera.Size)localObject3).height), Double.valueOf(((Camera.Size)localObject3).height * 1.0D / ((Camera.Size)localObject3).width) }));
    }
    if (this.laW != null) {
      localStringBuffer.append("\nSIGHTCROPMODE:  " + this.laW.x + " " + this.laW.y + " from " + this.laR.wAw + " " + this.laR.wAx);
    }
    for (;;)
    {
      localStringBuffer.append("\ngetOrientation:" + getOrientation());
      localStringBuffer.append("\nrecorderOption: " + af.juO.jto);
      localObject2 = localStringBuffer.toString();
      AppMethodBeat.o(89389);
      return localObject2;
      localStringBuffer.append("\nFinalPreviewSize: " + getPreviewWidth() + " " + getPreviewHeight());
    }
  }
  
  public final void eTi()
  {
    AppMethodBeat.i(89393);
    if ((this.jqD != null) && (this.EZk)) {
      try
      {
        Camera.Parameters localParameters = this.jqD.avd();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("auto")))
        {
          Log.i("MicroMsg.MMSightCameraSetting", "support auto focus");
          localParameters.setFocusMode("auto");
          this.jqD.c(localParameters);
        }
        this.jqD.avf();
        AppMethodBeat.o(89393);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.jqD.a(new Camera.AutoFocusCallback()
            {
              public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
              {
                AppMethodBeat.i(89363);
                if ((paramAnonymousCamera != null) && (f.this.egx())) {
                  try
                  {
                    Camera.Parameters localParameters = paramAnonymousCamera.getParameters();
                    List localList = localParameters.getSupportedFocusModes();
                    if ((localList != null) && (localList.contains("continuous-picture")))
                    {
                      Log.i("MicroMsg.MMSightCameraSetting", "support continues picture focus");
                      localParameters.setFocusMode("continuous-picture");
                      paramAnonymousCamera.setParameters(localParameters);
                    }
                    AppMethodBeat.o(89363);
                    return;
                  }
                  catch (Exception paramAnonymousCamera)
                  {
                    Log.printErrStackTrace("MicroMsg.MMSightCamera", paramAnonymousCamera, "simple auto focus resetToPictureFocus error", new Object[0]);
                  }
                }
                AppMethodBeat.o(89363);
              }
            });
            AppMethodBeat.o(89393);
            return;
          }
          catch (Exception localException2)
          {
            Log.printErrStackTrace("MicroMsg.MMSightCamera", localException2, "autoFocus error", new Object[0]);
          }
          localException1 = localException1;
          Log.printErrStackTrace("MicroMsg.MMSightCamera", localException1, "simple auto focus error", new Object[0]);
        }
      }
    }
  }
  
  public final List<Integer> eTj()
  {
    AppMethodBeat.i(89394);
    if (this.jqD != null) {
      try
      {
        Object localObject = this.jqD.avd();
        boolean bool = ((Camera.Parameters)localObject).isZoomSupported();
        if (!bool)
        {
          AppMethodBeat.o(89394);
          return null;
        }
        localObject = ((Camera.Parameters)localObject).getZoomRatios();
        AppMethodBeat.o(89394);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MMSightCamera", "getZoom error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89394);
    return null;
  }
  
  public final int eTk()
  {
    AppMethodBeat.i(89401);
    eTe();
    AppMethodBeat.o(89401);
    return 0;
  }
  
  public final void eTl()
  {
    AppMethodBeat.i(89402);
    Log.i("MicroMsg.MMSightCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[] { this.jqD, Boolean.valueOf(this.EZk) });
    if ((this.jqD != null) && (this.EZk)) {
      try
      {
        this.EZx = true;
        Camera.Parameters localParameters = this.jqD.avd();
        if ((!Util.isNullOrNil(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("torch")))
        {
          localParameters.setFlashMode("torch");
          this.jqD.c(localParameters);
          Log.i("MicroMsg.MMSightCamera", "open flash");
          AppMethodBeat.o(89402);
          return;
        }
        Log.i("MicroMsg.MMSightCamera", "camera not support flash!!");
        AppMethodBeat.o(89402);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MMSightCamera", localException, "openFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89402);
  }
  
  public final void eTm()
  {
    AppMethodBeat.i(89403);
    Log.i("MicroMsg.MMSightCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[] { this.jqD, Boolean.valueOf(this.EZk) });
    if ((this.jqD != null) && (this.EZk)) {
      try
      {
        this.EZx = false;
        Camera.Parameters localParameters = this.jqD.avd();
        if ((!Util.isNullOrNil(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("off")))
        {
          localParameters.setFlashMode("off");
          this.jqD.c(localParameters);
          Log.i("MicroMsg.MMSightCamera", "close flash");
          AppMethodBeat.o(89403);
          return;
        }
        Log.i("MicroMsg.MMSightCamera", "camera not support close flash!!");
        AppMethodBeat.o(89403);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MMSightCamera", localException, "closeFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89403);
  }
  
  public final void eTn()
  {
    AppMethodBeat.i(89404);
    Log.i("MicroMsg.MMSightCamera", "autoFlash, camera: %s, isPreviewing: %s", new Object[] { this.jqD, Boolean.valueOf(this.EZk) });
    if ((this.jqD != null) && (this.EZk)) {
      try
      {
        this.EZx = true;
        Camera.Parameters localParameters = this.jqD.avd();
        if ((!Util.isNullOrNil(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("auto")))
        {
          localParameters.setFlashMode("auto");
          this.jqD.c(localParameters);
          Log.i("MicroMsg.MMSightCamera", "auto flash");
          AppMethodBeat.o(89404);
          return;
        }
        Log.i("MicroMsg.MMSightCamera", "camera not support auto flash!!");
        AppMethodBeat.o(89404);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MMSightCamera", localException, "autoFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89404);
  }
  
  public final boolean egx()
  {
    return this.EZk;
  }
  
  public final int getOrientation()
  {
    if ((this.lbk != null) && (this.EZk)) {
      return this.lbk.fSM;
    }
    return -1;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(89406);
    if (this.jqD == null)
    {
      AppMethodBeat.o(89406);
      return 0;
    }
    if (this.lbk != null) {
      try
      {
        int i;
        if ((this.EZv) && (this.EZu != null)) {
          if ((this.lbk.fSM == 0) || (this.lbk.fSM == 180)) {
            i = this.EZs.y;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89406);
          return i;
          i = this.EZs.x;
          continue;
          if (this.laW == null)
          {
            if ((this.lbk.fSM == 0) || (this.lbk.fSM == 180)) {
              i = this.laR.wAx;
            } else {
              i = this.laR.wAw;
            }
          }
          else if ((this.lbk.fSM == 0) || (this.lbk.fSM == 180)) {
            i = this.laW.y;
          } else {
            i = this.laW.x;
          }
        }
        AppMethodBeat.o(89406);
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MMSightCamera", "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      }
    }
    return 0;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(89405);
    if (this.jqD == null)
    {
      AppMethodBeat.o(89405);
      return 0;
    }
    if (this.lbk != null) {
      try
      {
        int i;
        if ((this.EZv) && (this.EZu != null)) {
          if ((this.lbk.fSM == 0) || (this.lbk.fSM == 180)) {
            i = this.EZs.x;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89405);
          return i;
          i = this.EZs.y;
          continue;
          if (this.laW == null)
          {
            if ((this.lbk.fSM == 0) || (this.lbk.fSM == 180)) {
              i = this.laR.wAw;
            } else {
              i = this.laR.wAx;
            }
          }
          else if ((this.lbk.fSM == 0) || (this.lbk.fSM == 180)) {
            i = this.laW.x;
          } else {
            i = this.laW.y;
          }
        }
        AppMethodBeat.o(89405);
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MMSightCamera", "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    return 0;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(89391);
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if ((Math.abs(this.EZo - f1) > 5.0F) || (Math.abs(this.EZp - f2) > 5.0F) || (Math.abs(this.EZq - f3) > 5.0F))
    {
      Log.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", new Object[] { Float.valueOf(5.0F), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      this.EZF.e(this.jqD);
      this.EZo = f1;
      this.EZp = f2;
      this.EZq = f3;
    }
    AppMethodBeat.o(89391);
  }
  
  public final void up(int paramInt)
  {
    AppMethodBeat.i(89397);
    if (this.laX > 0)
    {
      AppMethodBeat.o(89397);
      return;
    }
    if (this.laU == null) {}
    int i;
    for (Point localPoint = ar.au(MMApplicationContext.getContext());; localPoint = new Point(this.laU.getWidth(), this.laU.getHeight()))
    {
      i = localPoint.y;
      Log.i("MicroMsg.MMSightCamera", "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localPoint });
      if (i / 2 < paramInt) {
        break;
      }
      AppMethodBeat.o(89397);
      return;
    }
    try
    {
      if (this.jqD != null)
      {
        i = this.jqD.avd().getMaxZoom();
        this.laX = ((int)(i / (paramInt / 3.0D / 10.0D)) + 1);
        Log.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.laX), Integer.valueOf(i) });
      }
      AppMethodBeat.o(89397);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMSightCamera", "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89397);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public final class c
    extends MMHandler
  {
    int EZL = 0;
    boolean EZM = false;
    boolean EZj = false;
    float jLa;
    float jLb;
    int lbP;
    int lbQ;
    boolean lbw = false;
    
    public c(Looper paramLooper)
    {
      super();
    }
    
    private static int Xb(int paramInt)
    {
      int i;
      if (paramInt > 1000) {
        i = 1000;
      }
      do
      {
        return i;
        i = paramInt;
      } while (paramInt >= -1000);
      return -1000;
    }
    
    private static Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(89367);
      paramFloat3 = 80.0F * paramFloat3;
      paramFloat1 /= paramInt1;
      paramFloat2 /= paramInt2;
      paramFloat1 = paramFloat1 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
      paramFloat2 = paramFloat2 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
      Object localObject = new RectF();
      ((RectF)localObject).set(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat3 + paramFloat2);
      localObject = new Rect(Xb(Math.round(((RectF)localObject).left)), Xb(Math.round(((RectF)localObject).top)), Xb(Math.round(((RectF)localObject).right)), Xb(Math.round(((RectF)localObject).bottom)));
      AppMethodBeat.o(89367);
      return localObject;
    }
    
    private static int g(Camera.Parameters paramParameters)
    {
      AppMethodBeat.i(89369);
      if (paramParameters == null)
      {
        AppMethodBeat.o(89369);
        return 0;
      }
      try
      {
        int j = paramParameters.getMaxZoom() / 2;
        i = j;
        if (j <= 0) {
          i = paramParameters.getMaxZoom();
        }
      }
      catch (Exception paramParameters)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMSightCamera", "get target zoom value error: %s", new Object[] { paramParameters.getMessage() });
          int i = 0;
        }
      }
      AppMethodBeat.o(89369);
      return i;
    }
    
    final void e(w paramw)
    {
      AppMethodBeat.i(89368);
      if (paramw == null)
      {
        Log.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
        AppMethodBeat.o(89368);
        return;
      }
      if (!f.EZE)
      {
        Log.w("MicroMsg.MMSightCamera", "auto focus not back");
        AppMethodBeat.o(89368);
        return;
      }
      f.EZE = false;
      try
      {
        Log.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
        paramw.avf();
        paramw.a(f.this.lbl);
        AppMethodBeat.o(89368);
        return;
      }
      catch (Exception paramw)
      {
        Log.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", new Object[] { paramw.getMessage() });
        f.EZE = true;
        AppMethodBeat.o(89368);
      }
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int j = 1;
      AppMethodBeat.i(89370);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(89370);
        return;
        paramMessage = (w)paramMessage.obj;
        if ((this.lbP == 0) || (this.lbQ == 0) || (com.tencent.mm.compatible.util.d.qW(14)))
        {
          e(paramMessage);
          AppMethodBeat.o(89370);
          return;
        }
        float f1 = this.jLa;
        float f2 = this.jLb;
        int i = this.lbP;
        j = this.lbQ;
        if (paramMessage == null)
        {
          Log.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
          AppMethodBeat.o(89370);
          return;
        }
        if (!f.EZE)
        {
          Log.w("MicroMsg.MMSightCamera", "auto focus not back");
          AppMethodBeat.o(89370);
          return;
        }
        f.EZE = false;
        try
        {
          paramMessage.avf();
          Log.i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
          Object localObject2 = a(f1, f2, 1.0F, i, j);
          localObject1 = a(f1, f2, 1.5F, i, j);
          Log.i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
          localParameters = paramMessage.avd();
          Object localObject3 = localParameters.getSupportedFocusModes();
          if ((localObject3 != null) && (((List)localObject3).contains("auto"))) {
            localParameters.setFocusMode("auto");
          }
          if (localParameters.getMaxNumFocusAreas() > 0)
          {
            localObject3 = new ArrayList(1);
            ((ArrayList)localObject3).add(new Camera.Area((Rect)localObject2, 1000));
            localParameters.setFocusAreas((List)localObject3);
          }
          if (localParameters.getMaxNumMeteringAreas() > 0)
          {
            localObject2 = new ArrayList(1);
            ((ArrayList)localObject2).add(new Camera.Area((Rect)localObject1, 1000));
            localParameters.setMeteringAreas((List)localObject2);
          }
          paramMessage.c(localParameters);
          paramMessage.a(f.this.lbl);
          AppMethodBeat.o(89370);
          return;
        }
        catch (Exception paramMessage)
        {
          Log.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
          f.EZE = true;
          AppMethodBeat.o(89370);
          return;
        }
        if (this.lbw)
        {
          AppMethodBeat.o(89370);
          return;
        }
        Object localObject1 = (Camera)paramMessage.obj;
        Camera.Parameters localParameters = ((Camera)localObject1).getParameters();
        Log.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(this.EZj), Integer.valueOf(this.EZL), Integer.valueOf(localParameters.getZoom()) });
        i = localParameters.getZoom() + this.EZL;
        if (this.EZj)
        {
          int k = g(localParameters);
          if (i >= k)
          {
            i = k;
            label519:
            localParameters.setZoom(i);
          }
        }
        try
        {
          ((Camera)localObject1).setParameters(localParameters);
          label533:
          if (j == 0) {
            continue;
          }
          this.lbP = 0;
          this.lbQ = 0;
          continue;
          paramMessage = obtainMessage(4353, paramMessage.obj);
          if (this.EZM) {}
          for (long l = 10L;; l = 20L)
          {
            sendMessageDelayed(paramMessage, l);
            j = 0;
            break;
          }
          if (i <= 0)
          {
            i = 0;
            break label519;
          }
          paramMessage = obtainMessage(4353, paramMessage.obj);
          if (this.EZM) {}
          for (l = 10L;; l = 20L)
          {
            sendMessageDelayed(paramMessage, l);
            j = 0;
            break;
          }
        }
        catch (Exception paramMessage)
        {
          break label533;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.f
 * JD-Core Version:    0.7.0.1
 */