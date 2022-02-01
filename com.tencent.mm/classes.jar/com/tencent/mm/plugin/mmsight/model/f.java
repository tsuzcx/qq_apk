package com.tencent.mm.plugin.mmsight.model;

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
import com.tencent.mm.autogen.a.rw;
import com.tencent.mm.autogen.a.rw.b;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.base.model.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.v.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class f
  implements SensorEventListener
{
  protected static int KUY = 2147483647;
  static boolean KVq = true;
  protected boolean KUV;
  protected boolean KUW;
  protected int KUX;
  protected Sensor KUZ;
  protected float KVa;
  protected float KVb;
  protected float KVc;
  protected Point KVd;
  protected Point KVe;
  protected int KVf;
  protected byte[] KVg;
  protected boolean KVh;
  protected a KVi;
  protected boolean KVj;
  protected boolean KVk;
  private a KVl;
  private c KVm;
  protected VideoTransPara KVn;
  public boolean KVo;
  private boolean KVp;
  public c KVr;
  protected boolean isZooming;
  protected w lTN;
  protected Context mContext;
  protected SensorManager mSensorManager;
  protected boolean nFR;
  protected p nFW;
  protected Size nFZ;
  protected Point nGb;
  protected int nGc;
  protected int nGd;
  protected List<g> nGq;
  protected d.a.a nGr;
  private c nGs;
  private c nGt;
  private c nGu;
  private c nGv;
  private c nGw;
  public volatile boolean nGx;
  public volatile byte[] nGy;
  Camera.AutoFocusCallback nuM;
  private int scene;
  
  public f(VideoTransPara paramVideoTransPara, int paramInt)
  {
    AppMethodBeat.i(89371);
    this.nGd = -1;
    this.nGc = -1;
    this.KUV = false;
    this.isZooming = false;
    this.lTN = null;
    this.KUW = false;
    this.KUX = 0;
    this.KVa = 0.0F;
    this.KVb = 0.0F;
    this.KVc = 0.0F;
    this.mContext = null;
    this.KVd = null;
    this.KVe = null;
    this.nGb = null;
    this.KVf = 0;
    this.KVh = false;
    this.KVi = new a();
    this.KVj = false;
    this.nGq = new ArrayList();
    this.KVk = false;
    this.nFZ = null;
    this.KVl = a.KVt;
    this.nGs = new c("prevcameraCallback");
    this.nGt = new c("cameraCallback");
    this.nGu = new c("cameraPreviewCallback");
    this.nGv = new c("cameraCropCallback");
    this.KVm = new c("mirrorCameraCallback");
    this.nGw = new c("finishCallbackTimeCallback");
    this.scene = 0;
    this.nGy = null;
    this.nGx = false;
    this.KVo = false;
    this.KVp = false;
    this.nuM = new Camera.AutoFocusCallback()
    {
      public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(89362);
        Log.v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), f.f(f.this) });
        f.KVq = true;
        AppMethodBeat.o(89362);
      }
    };
    this.KVr = new c(Looper.getMainLooper());
    this.nFR = true;
    this.nFW = p.gct();
    this.KVn = paramVideoTransPara;
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
        localParameters = paramw.aPy();
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
        Camera.Parameters localParameters = paramw.aPy();
        new Point(paramInt, (int)(paramInt / paramFloat));
        Object localObject;
        if (this.nFZ == null)
        {
          localObject = aw.bf(MMApplicationContext.getContext());
          Point localPoint = new Point(Math.min(((Point)localObject).x, ((Point)localObject).y), Math.max(((Point)localObject).x, ((Point)localObject).y));
          Log.i("MicroMsg.MMSightCamera", "screenSize: %s, currentScreenSize: %s", new Object[] { localPoint, localObject });
          float f1 = Math.min(localPoint.x, localPoint.y) / Math.max(localPoint.x, localPoint.y);
          f2 = 1.0F / paramFloat;
          if (paramFloat >= 1.0F) {
            break label709;
          }
          i = paramInt;
          Log.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[] { Integer.valueOf(i), Float.valueOf(paramFloat), Float.valueOf(f1) });
          if (this.nGr.hYK == 90) {
            break label756;
          }
          if (this.nGr.hYK != 270) {
            break label768;
          }
          break label756;
          h.c localc = h.a(localParameters, localPoint, i, bool);
          if (localc != null)
          {
            localObject = localc;
            if (localc.KVz != null) {}
          }
          else
          {
            Log.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
            if (this.nGr.hYK == 90) {
              break label762;
            }
            if (this.nGr.hYK != 270) {
              break label774;
            }
            break label762;
            localObject = h.d(localParameters, localPoint, paramInt, bool);
            this.KVo = false;
          }
          if ((localObject != null) && (((h.c)localObject).KVz != null))
          {
            paramInt = (int)(((h.c)localObject).KVz.x * paramFloat);
            Log.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio result preview size: %s, cropHeight: %s", new Object[] { ((h.c)localObject).KVz, Integer.valueOf(paramInt) });
            if (paramInt > ((h.c)localObject).KVz.y) {
              break label726;
            }
            this.KVo = false;
          }
          if ((localObject != null) && (((h.c)localObject).KVz != null))
          {
            localObject = ((h.c)localObject).KVz;
            this.nFW.zWH = ((Point)localObject).x;
            this.nFW.zWI = ((Point)localObject).y;
            this.KVe = ((Point)localObject);
            this.nGb = null;
            if (!paramBoolean)
            {
              if ((j.KVJ.lWy != 2) || (com.tencent.mm.plugin.mmsight.d.aaY(this.KVe.y))) {
                break label745;
              }
              paramInt = com.tencent.mm.plugin.mmsight.d.aaZ(this.KVe.y);
              if (Math.abs(paramInt - this.KVe.y) > 16) {
                break label734;
              }
              Log.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.KVe, Integer.valueOf(paramInt) });
              this.KVd = new Point(this.KVe.x, this.KVe.y);
              this.KVe.y = paramInt;
              this.KVh = true;
              this.KVg = new byte[this.KVe.x * this.KVe.y * 3 / 2];
            }
            Log.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s, cropWidth: %s", new Object[] { localObject, this.KVe, this.nGb, Boolean.valueOf(this.KVo) });
            localParameters.setPreviewSize(this.nFW.zWH, this.nFW.zWI);
            paramw.c(localParameters);
            AppMethodBeat.o(89377);
            return true;
          }
        }
        else
        {
          localObject = new Point(this.nFZ.getWidth(), this.nFZ.getHeight());
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
      this.KVo = true;
      continue;
      label734:
      j.k(this.KVe);
      continue;
      label745:
      j.k(this.KVe);
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
          localParameters = paramw.aPy();
          if (!paramBoolean) {
            break label235;
          }
          if (af.lXY.lTg > 0)
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
        if (af.lXY.lTg <= 0) {
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
    AppMethodBeat.i(303565);
    if (paramw == null)
    {
      AppMethodBeat.o(303565);
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
        localParameters = paramw.aPy();
        if (this.nFZ == null)
        {
          localPoint = com.tencent.mm.plugin.mmsight.d.iQ(this.mContext);
          if (this.nFR)
          {
            localObject1 = b.gbT();
            localObject2 = localParameters.getSupportedPreviewSizes();
            localObject3 = localParameters.getSupportedPictureSizes();
            paramInt = this.nGr.hYK;
            if (Util.isNullOrNil(((b)localObject1).KUu)) {
              ((b)localObject1).KUu = com.tencent.mm.plugin.mmsight.d.iW((List)localObject2);
            }
            if (Util.isNullOrNil(((b)localObject1).KUv)) {
              ((b)localObject1).KUv = com.tencent.mm.plugin.mmsight.d.iW((List)localObject3);
            }
            ((b)localObject1).hYK = paramInt;
            ((b)localObject1).KUP = 1;
            if (paramBoolean)
            {
              if (this.nGr.hYK == 90) {
                break label2473;
              }
              if (this.nGr.hYK != 270) {
                break label495;
              }
              break label2473;
              j.a(localParameters, bool);
            }
            com.tencent.mm.plugin.mmsight.model.a.k.gcB();
            paramInt = com.tencent.mm.plugin.mmsight.model.a.k.gcD();
            if (this.nGr.hYK == 90) {
              break label2479;
            }
            if (this.nGr.hYK != 270) {
              break label501;
            }
            break label2479;
            label203:
            localObject2 = h.a(localParameters, localPoint, paramInt, bool);
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((h.c)localObject2).KVz != null) {}
            }
            else
            {
              Log.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
              localPoint = new Point(Math.min(localPoint.x, localPoint.y), Math.max(localPoint.x, localPoint.y));
              if (this.nGr.hYK == 90) {
                break label2485;
              }
              if (this.nGr.hYK != 270) {
                break label507;
              }
              break label2485;
              label304:
              localObject1 = h.d(localParameters, localPoint, 2100, bool);
              this.KVo = false;
            }
            j.a((h.c)localObject1);
            localPoint = ((h.c)localObject1).KVz;
            if (localPoint != null) {
              break;
            }
            k.gcn();
            AppMethodBeat.o(303565);
            return false;
          }
        }
        else
        {
          localPoint = new Point(this.nFZ.getWidth(), this.nFZ.getHeight());
          continue;
        }
        localObject1 = b.gbT();
        localObject2 = localParameters.getSupportedPreviewSizes();
        localObject3 = localParameters.getSupportedPictureSizes();
        paramInt = this.nGr.hYK;
        if (Util.isNullOrNil(((b)localObject1).KUw)) {
          ((b)localObject1).KUw = com.tencent.mm.plugin.mmsight.d.iW((List)localObject2);
        }
        if (Util.isNullOrNil(((b)localObject1).KUx)) {
          ((b)localObject1).KUx = com.tencent.mm.plugin.mmsight.d.iW((List)localObject3);
        }
        ((b)localObject1).hYK = paramInt;
        ((b)localObject1).KUP = 2;
        continue;
        bool = false;
      }
      catch (Exception paramw)
      {
        Log.i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), paramw.getMessage() });
        AppMethodBeat.o(303565);
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
    this.nFW.zWH = localPoint.x;
    this.nFW.zWI = localPoint.y;
    this.KVe = localPoint;
    Object localObject2 = this.mContext;
    if (this.nGr.hYK != 90) {
      if (this.nGr.hYK == 270)
      {
        break label2491;
        label577:
        bool = com.tencent.mm.plugin.mmsight.d.a((Context)localObject2, localPoint, bool);
        paramInt = 1;
        if ((this.nGr.hYK != 90) && (this.nGr.hYK != 270)) {
          break label1333;
        }
        if ((localPoint.y < this.KVn.width) || (localPoint.x < this.KVn.height))
        {
          paramInt = 0;
          Log.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localPoint });
        }
        label665:
        Log.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label1418;
        }
        if (j.KVJ.lWy != 2) {
          break label1406;
        }
        this.nGb = ((h.c)localObject1).KVB;
        if ((this.nGb.x < localPoint.x) || (this.nGb.y < localPoint.y))
        {
          if ((this.nGr.hYK != 90) && (this.nGr.hYK != 270)) {
            break label1386;
          }
          this.nGb.y = com.tencent.mm.plugin.mmsight.d.aba(this.nGb.y);
        }
        label781:
        this.KVe = new Point(this.nGb.x, this.nGb.y);
        this.KVf = (this.nGb.x * this.nGb.y * 3 / 2);
        Log.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", new Object[] { this.nGb });
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
      if (j.KVJ.KVU)
      {
        if ((this.nGr.hYK != 90) && (this.nGr.hYK != 270)) {
          break label2017;
        }
        if (paramInt != 0)
        {
          if (j.KVJ.nFY != 1080) {
            break label1845;
          }
          if (this.nGb != null) {
            break label1794;
          }
          i = localPoint.x / 2;
          if (this.nGb != null) {
            break label1808;
          }
          paramInt = localPoint.y / 2;
          if (this.nGb != null) {
            break label1821;
          }
          j = localPoint.x;
          j = com.tencent.mm.plugin.mmsight.d.jI(i, j);
          if (this.nGb != null) {
            break label1833;
          }
          i = localPoint.y;
          label966:
          this.KVe = new Point(j, com.tencent.mm.plugin.mmsight.d.jI(paramInt, i));
        }
      }
      label985:
      localObject1 = b.gbT();
      localObject2 = this.nGb;
      localObject3 = this.KVe;
      ((b)localObject1).KUD = -1;
      ((b)localObject1).KUC = -1;
      ((b)localObject1).KUz = -1;
      ((b)localObject1).KUy = -1;
      ((b)localObject1).KUB = -1;
      ((b)localObject1).KUA = -1;
      if (localPoint != null)
      {
        ((b)localObject1).KUA = localPoint.x;
        ((b)localObject1).KUB = localPoint.y;
      }
      if (localObject2 != null)
      {
        ((b)localObject1).KUy = ((Point)localObject2).x;
        ((b)localObject1).KUz = ((Point)localObject2).y;
      }
      if (localObject3 != null)
      {
        ((b)localObject1).KUC = ((Point)localObject3).x;
        ((b)localObject1).KUD = ((Point)localObject3).y;
      }
      if (paramBoolean) {
        if ((!bool) && (j.KVJ.lWy == 2) && (!com.tencent.mm.plugin.mmsight.d.aaY(this.KVe.y)))
        {
          paramInt = com.tencent.mm.plugin.mmsight.d.aaZ(this.KVe.y);
          if (Math.abs(paramInt - this.KVe.y) <= 16)
          {
            Log.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.KVe, Integer.valueOf(paramInt) });
            this.KVd = new Point(this.KVe.x, this.KVe.y);
            this.KVe.y = paramInt;
            this.KVh = true;
            this.KVg = new byte[this.KVe.x * this.KVe.y * 3 / 2];
          }
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", new Object[] { localPoint, this.KVe, this.nGb });
        localParameters.setPreviewSize(this.nFW.zWH, this.nFW.zWI);
        paramw.c(localParameters);
        AppMethodBeat.o(303565);
        return true;
        bool = false;
        break;
        if ((localPoint.x >= this.KVn.width) && (localPoint.y >= this.KVn.height)) {
          break label665;
        }
        paramInt = 0;
        Log.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localPoint });
        break label665;
        label1386:
        this.nGb.x = com.tencent.mm.plugin.mmsight.d.aba(this.nGb.x);
        break label781;
        label1406:
        this.nGb = ((h.c)localObject1).KVA;
        break label781;
        if ((!j.KVJ.KVU) || (j.KVJ.nFY != 1080) || (paramInt == 0)) {
          break label2470;
        }
        if ((this.nGr.hYK == 90) || (this.nGr.hYK == 270))
        {
          i = localPoint.y / 2;
          j = com.tencent.mm.plugin.mmsight.d.aaZ(i);
          k = localPoint.x / 2;
          m = com.tencent.mm.plugin.mmsight.d.aaZ(k);
          if ((Math.abs(j - i) < 8) && (Math.abs(m - k) < 8)) {
            break label2497;
          }
          this.nGb = new Point(localPoint.x, localPoint.y);
          this.nGb.y = com.tencent.mm.plugin.mmsight.d.aba(localPoint.y);
          this.nGb.x = com.tencent.mm.plugin.mmsight.d.aba(localPoint.x);
          this.KVe = new Point(this.nGb.x, this.nGb.y);
          this.KVf = (this.nGb.x * this.nGb.y * 3 / 2);
          bool = true;
          break label2497;
        }
        i = localPoint.x / 2;
        j = com.tencent.mm.plugin.mmsight.d.aaZ(i);
        int k = localPoint.y / 2;
        int m = com.tencent.mm.plugin.mmsight.d.aaZ(k);
        if ((Math.abs(j - i) < 8) && (Math.abs(m - k) < 8)) {
          break label2470;
        }
        this.nGb = new Point(localPoint.x, localPoint.y);
        this.nGb.y = com.tencent.mm.plugin.mmsight.d.aba(localPoint.x);
        this.nGb.x = com.tencent.mm.plugin.mmsight.d.aba(localPoint.y);
        this.KVe = new Point(this.nGb.x, this.nGb.y);
        this.KVf = (this.nGb.x * this.nGb.y * 3 / 2);
        bool = true;
        break label848;
        i = this.nGb.x / 2;
        break label914;
        paramInt = this.nGb.y / 2;
        break label929;
        j = this.nGb.x;
        break label943;
        i = this.nGb.y;
        break label966;
        if (j.KVJ.nFY != 720) {
          break label985;
        }
        float f;
        if (this.nGb == null)
        {
          f = localPoint.x * 0.75F;
          label1876:
          j = (int)f;
          if (this.nGb != null) {
            break label1978;
          }
          f = localPoint.y * 0.75F;
          label1900:
          i = (int)f;
          if (this.nGb != null) {
            break label1995;
          }
          paramInt = localPoint.x;
          label1918:
          j = com.tencent.mm.plugin.mmsight.d.jI(j, paramInt);
          if (this.nGb != null) {
            break label2006;
          }
        }
        label1995:
        label2006:
        for (paramInt = localPoint.y;; paramInt = this.nGb.y)
        {
          this.KVe = new Point(j, com.tencent.mm.plugin.mmsight.d.jI(i, paramInt));
          break;
          f = this.nGb.x * 0.75F;
          break label1876;
          f = this.nGb.y * 0.75F;
          break label1900;
          paramInt = this.nGb.x;
          break label1918;
        }
        label2017:
        if (paramInt == 0) {
          break label985;
        }
        if (j.KVJ.nFY == 1080)
        {
          if (this.nGb == null)
          {
            i = localPoint.y / 2;
            if (this.nGb != null) {
              break label2137;
            }
            paramInt = localPoint.x / 2;
            if (this.nGb != null) {
              break label2150;
            }
            j = localPoint.y;
            j = com.tencent.mm.plugin.mmsight.d.jI(i, j);
            if (this.nGb != null) {
              break label2162;
            }
          }
          label2137:
          label2150:
          label2162:
          for (i = localPoint.x;; i = this.nGb.x)
          {
            this.KVe = new Point(j, com.tencent.mm.plugin.mmsight.d.jI(paramInt, i));
            break;
            i = this.nGb.y / 2;
            break label2049;
            paramInt = this.nGb.x / 2;
            break label2064;
            j = this.nGb.y;
            break label2078;
          }
        }
        if (j.KVJ.nFY != 720) {
          break label985;
        }
        if (this.nGb == null)
        {
          f = localPoint.y * 0.75F;
          j = (int)f;
          if (this.nGb != null) {
            break label2307;
          }
          f = localPoint.x * 0.75F;
          i = (int)f;
          if (this.nGb != null) {
            break label2324;
          }
          paramInt = localPoint.y;
          label2247:
          j = com.tencent.mm.plugin.mmsight.d.jI(j, paramInt);
          if (this.nGb != null) {
            break label2335;
          }
        }
        for (paramInt = localPoint.x;; paramInt = this.nGb.x)
        {
          this.KVe = new Point(j, com.tencent.mm.plugin.mmsight.d.jI(i, paramInt));
          break;
          f = this.nGb.y * 0.75F;
          break label2205;
          f = this.nGb.x * 0.75F;
          break label2229;
          paramInt = this.nGb.y;
          break label2247;
        }
        j.k(this.KVe);
        continue;
        j.k(this.KVe);
        continue;
        if ((!bool) && (j.KVJ.lWy == 2) && (!com.tencent.mm.plugin.mmsight.d.aaY(this.KVe.y)) && (this.KVh) && (this.KVg != null) && (this.KVd.y == this.KVe.y))
        {
          paramInt = com.tencent.mm.plugin.mmsight.d.aaZ(this.KVe.y);
          if (this.KVg.length == this.KVe.x * paramInt * 3 / 2) {
            this.KVe.y = paramInt;
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
      Camera.Parameters localParameters = paramw.aPy();
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
  
  private void bsB()
  {
    AppMethodBeat.i(89388);
    if (true == this.KVp)
    {
      AppMethodBeat.o(89388);
      return;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(89388);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.e.b.aPP()))
    {
      AppMethodBeat.o(89388);
      return;
    }
    Object localObject = new rw();
    ((rw)localObject).hUY.type = 2;
    ((rw)localObject).publish();
    if (((rw)localObject).hUZ.hUX)
    {
      this.KVp = true;
      AppMethodBeat.o(89388);
      return;
    }
    localObject = com.tencent.mm.ui.base.k.s(this.mContext, a.a.short_video_no_record_video_permission, a.a.app_tip);
    if (localObject != null)
    {
      ((e)localObject).setCancelable(false);
      ((e)localObject).setCanceledOnTouchOutside(false);
      ((e)localObject).show();
      this.KVp = true;
    }
    AppMethodBeat.o(89388);
  }
  
  private void btd()
  {
    AppMethodBeat.i(89384);
    if (this.lTN != null) {
      try
      {
        Object localObject = this.lTN.aPy();
        Log.i("MicroMsg.MMSightCamera", "setPreviewCallbackImpl");
        int i = this.nFW.zWH;
        int j = this.nFW.zWI;
        j = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject).getPreviewFormat()) * (i * j) / 8;
        i = 0;
        while (i < 5)
        {
          localObject = com.tencent.mm.plugin.mmsight.model.a.j.KXq.m(Integer.valueOf(j));
          this.lTN.aj((byte[])localObject);
          i += 1;
        }
        this.nGs.reset();
        this.nGt.reset();
        this.nGu.reset();
        this.nGv.reset();
        this.KVm.reset();
        this.nGw.reset();
        this.KVi = new a();
        this.lTN.b(new Camera.PreviewCallback()
        {
          public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
          {
            AppMethodBeat.i(89361);
            if (!f.this.KVk)
            {
              Log.i("MicroMsg.MMSightCamera", "onPreviewFrame: %s %s", new Object[] { paramAnonymousArrayOfByte, f.this.lTN });
              f.this.KVk = true;
            }
            if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
            {
              Log.e("MicroMsg.MMSightCamera", "onPreviewFrame, frame data is null!!");
              AppMethodBeat.o(89361);
              return;
            }
            paramAnonymousCamera = f.this.KVi;
            if (paramAnonymousCamera.vqU == 0)
            {
              paramAnonymousCamera.vqT += 1;
              paramAnonymousCamera.vqS = Util.safeParseInt(m.aON());
            }
            paramAnonymousCamera.vqU += 1;
            int i;
            long l1;
            byte[] arrayOfByte;
            label367:
            long l2;
            int j;
            boolean bool;
            if (paramAnonymousCamera.vqU >= 90)
            {
              i = 0;
              paramAnonymousCamera.vqU = i;
              if ((f.a(f.this)) || (f.this.nGq == null) || (f.this.nGq.size() <= 0)) {
                break label944;
              }
              if (f.this.nGb == null) {
                break label584;
              }
              paramAnonymousCamera = com.tencent.mm.plugin.mmsight.model.a.j.KXq.m(Integer.valueOf(f.this.nFW.zWH * f.this.nGb.y * 3 / 2));
              f.b(f.this).ss(1L);
              l1 = Util.currentTicks();
              SightVideoJNI.cropCameraData(paramAnonymousArrayOfByte, paramAnonymousCamera, f.this.nFW.zWH, f.this.nFW.zWI, f.this.nGb.y);
              if (f.this.nGb.x >= f.this.nFW.zWH) {
                break label941;
              }
              arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.j.KXq.m(Integer.valueOf(f.this.nGb.x * f.this.nGb.y * 3 / 2));
              SightVideoJNI.cropCameraDataLongEdge(paramAnonymousCamera, arrayOfByte, f.this.nFW.zWH, f.this.nGb.x, f.this.nGb.y);
              com.tencent.mm.plugin.mmsight.model.a.j.KXq.as(paramAnonymousCamera);
              paramAnonymousCamera = arrayOfByte;
              l2 = Util.ticksToNow(l1);
              f.c(f.this).ss(l2);
              if (!f.this.nFR)
              {
                l1 = Util.currentTicks();
                i = f.this.nGb.x;
                j = f.this.nGb.y;
                if ((f.this.nGr.hYK != 270) && (f.this.nGr.hYK != 90)) {
                  break label578;
                }
                bool = true;
                label458:
                SightVideoJNI.mirrorCameraData(paramAnonymousCamera, i, j, bool);
                l2 = Util.ticksToNow(l1);
                f.d(f.this).ss(l2);
              }
              bool = f.a(f.this, paramAnonymousCamera);
              l1 = Util.ticksToNow(l1);
              if (bool) {
                f.e(f.this).ss(l1);
              }
            }
            for (;;)
            {
              f.b(f.this, paramAnonymousCamera);
              if (f.f(f.this) == f.a.KVt) {
                f.g(f.this).ss(1L);
              }
              for (;;)
              {
                f.this.lTN.aj(paramAnonymousArrayOfByte);
                AppMethodBeat.o(89361);
                return;
                i = paramAnonymousCamera.vqU;
                break;
                label578:
                bool = false;
                break label458;
                label584:
                l1 = Util.currentTicks();
                label656:
                label753:
                f localf;
                if (!f.this.nFR)
                {
                  i = f.this.nFW.zWH;
                  j = f.this.nFW.zWI;
                  if ((f.this.nGr.hYK == 270) || (f.this.nGr.hYK == 90))
                  {
                    bool = true;
                    SightVideoJNI.mirrorCameraData(paramAnonymousArrayOfByte, i, j, bool);
                    l2 = Util.ticksToNow(l1);
                    f.d(f.this).ss(l2);
                  }
                }
                else
                {
                  if ((!f.this.KVh) || (f.this.KVg == null)) {
                    break label898;
                  }
                  SightVideoJNI.paddingYuvData16(paramAnonymousArrayOfByte, f.this.KVg, f.this.KVe.x, f.this.KVd.y, f.this.KVe.y);
                  paramAnonymousCamera = f.this.KVg;
                  bool = f.a(f.this, paramAnonymousCamera);
                  l1 = Util.ticksToNow(l1);
                  if (bool) {
                    f.e(f.this).ss(l1);
                  }
                  if (f.this.KVh)
                  {
                    arrayOfByte = paramAnonymousArrayOfByte;
                    if (f.this.KVg != null) {}
                  }
                  else
                  {
                    arrayOfByte = paramAnonymousArrayOfByte;
                    if (bool) {
                      arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.j.KXq.m(Integer.valueOf(paramAnonymousArrayOfByte.length));
                    }
                  }
                  if ((f.this.KVh) && (f.this.KVg != null))
                  {
                    localf = f.this;
                    if (!bool) {
                      break label903;
                    }
                  }
                }
                label898:
                label903:
                for (paramAnonymousArrayOfByte = com.tencent.mm.plugin.mmsight.model.a.j.KXq.m(Integer.valueOf(f.this.KVg.length));; paramAnonymousArrayOfByte = f.this.KVg)
                {
                  localf.KVg = paramAnonymousArrayOfByte;
                  paramAnonymousArrayOfByte = arrayOfByte;
                  break;
                  bool = false;
                  break label656;
                  paramAnonymousCamera = paramAnonymousArrayOfByte;
                  break label753;
                }
                if (f.f(f.this) == f.a.KVu) {
                  f.h(f.this).ss(1L);
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
      Camera.Parameters localParameters = paramw.aPy();
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
      Camera.Parameters localParameters = paramw.aPy();
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
  
  private void gbX()
  {
    AppMethodBeat.i(89375);
    try
    {
      if ((this.mSensorManager != null) && (this.KUZ != null)) {
        this.mSensorManager.unregisterListener(this);
      }
      Log.i("MicroMsg.MMSightCamera", this.nGs.getValue());
      Log.i("MicroMsg.MMSightCamera", this.nGt.getValue());
      Log.i("MicroMsg.MMSightCamera", this.nGu.getValue());
      Log.i("MicroMsg.MMSightCamera", this.nGv.getValue());
      Log.i("MicroMsg.MMSightCamera", this.KVm.getValue());
      Log.i("MicroMsg.MMSightCamera", this.nGw.getValue());
      if (this.lTN != null)
      {
        long l = Util.currentTicks();
        Log.i("MicroMsg.MMSightCamera", "release camera beg, %s", new Object[] { Looper.myLooper() });
        this.KVr.removeCallbacksAndMessages(null);
        this.KVr.nGA = true;
        this.lTN.a(null);
        this.lTN.auq();
        this.lTN.release();
        this.lTN = null;
        this.KUW = false;
        Log.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
      }
      this.KUV = false;
      this.KVa = 0.0F;
      this.KVb = 0.0F;
      this.KVc = 0.0F;
      KVq = true;
      this.mContext = null;
      this.KVp = false;
      this.KVe = null;
      this.nGb = null;
      this.nGy = null;
      this.KVk = false;
      AppMethodBeat.o(89375);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMSightCamera", localException, "cameraRelease error", new Object[0]);
      AppMethodBeat.o(89375);
    }
  }
  
  public final boolean N(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(89398);
    if ((!j.KVJ.KVV) || ((af.lXY.lTo == 0) && (this.mSensorManager == null) && (this.KUZ == null)))
    {
      this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      this.KUZ = this.mSensorManager.getDefaultSensor(1);
    }
    if (this.lTN == null)
    {
      gbX();
      this.nFR = paramBoolean;
      if (paramBoolean) {}
      try
      {
        for (this.KUX = com.tencent.mm.compatible.deviceinfo.d.aOr();; this.KUX = com.tencent.mm.compatible.deviceinfo.d.aOs())
        {
          Log.i("MicroMsg.MMSightCamera", "use camera id %d, SrvDeviceInfo id %d", new Object[] { Integer.valueOf(this.KUX), Integer.valueOf(af.lXY.lTr) });
          this.KVp = false;
          this.mContext = paramContext;
          this.nGr = new n().G(paramContext, this.KUX);
          Log.i("MicroMsg.MMSightCamera", "open camera end, %s", new Object[] { Looper.myLooper() });
          if (this.nGr != null) {
            break;
          }
          Log.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", new Object[] { Looper.myLooper() });
          bsB();
          AppMethodBeat.o(89398);
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.MMSightCamera", localException, "try to get cameraid error %s, useBackCamera: %s", new Object[] { localException.getMessage(), Boolean.valueOf(this.nFR) });
          this.KUX = 0;
        }
        this.lTN = this.nGr.lTN;
        this.KVr.nGA = false;
        this.nFW.hYK = this.nGr.hYK;
        if (this.lTN == null)
        {
          Log.e("MicroMsg.MMSightCamera", "start camera FAILED!");
          bsB();
          AppMethodBeat.o(89398);
          return false;
        }
      }
    }
    AppMethodBeat.o(89398);
    return true;
  }
  
  public final int a(SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(89386);
    long l = Util.currentTicks();
    this.KVk = false;
    Log.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s", new Object[] { Boolean.valueOf(this.KUW), Looper.myLooper(), paramSurfaceTexture });
    if (this.KUW)
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
        a(this.lTN, paramInt, paramFloat, paramBoolean);
        if (com.tencent.mm.plugin.mmsight.model.a.k.gcB().KXs == null) {
          break label654;
        }
        localInteger = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.k.gcB().KXs.KUe);
        if (af.lXY.lTl == 1)
        {
          str = "Range";
          if (af.lXY.lTm != 1) {
            break label671;
          }
          paramBoolean = true;
          if (af.lXY.lTn != 1) {
            break label677;
          }
          bool1 = true;
          if (af.lXY.lTo != 1) {
            break label683;
          }
          bool2 = true;
          if (af.lXY.lTp != 1) {
            break label689;
          }
          bool3 = true;
          Log.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((af.lXY.lTl == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            a(this.lTN, false);
            if ((af.lXY.lTm == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              b(this.lTN);
            }
            if ((af.lYf.lWG != -1) && (af.lYf.lWG == 1) && (com.tencent.mm.compatible.util.d.rd(14))) {
              c(this.lTN);
            }
            if ((af.lXY.lTo == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              a(this.lTN);
            }
            if ((af.lXY.lTp == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            d(this.lTN);
            btd();
            this.lTN.f(paramSurfaceTexture);
            this.lTN.aPz();
            if (!j.KVJ.KVV) {
              break label637;
            }
            if ((af.lXY.lTo == 0) && (this.mSensorManager != null) && (this.KUZ != null)) {
              this.mSensorManager.registerListener(this, this.KUZ, 2);
            }
            this.KUW = true;
            Log.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
            AppMethodBeat.o(89386);
            return 0;
          }
        }
        else
        {
          if (af.lXY.lTk != 1) {
            break label663;
          }
          str = "Fix";
          continue;
        }
        if ((af.lXY.lTk != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        a(this.lTN, true);
        continue;
        this.mSensorManager.registerListener(this, this.KUZ, 2);
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
  
  public final int a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    AppMethodBeat.i(89385);
    long l = Util.currentTicks();
    this.KVk = false;
    Log.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", new Object[] { Boolean.valueOf(this.KUW), Looper.myLooper(), paramSurfaceTexture, Boolean.valueOf(paramBoolean) });
    if (this.KUW)
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
        a(this.lTN, paramBoolean, 0);
        if (com.tencent.mm.plugin.mmsight.model.a.k.gcB().KXs == null) {
          break label657;
        }
        localInteger = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.k.gcB().KXs.KUe);
        if (af.lXY.lTl == 1)
        {
          str = "Range";
          if (af.lXY.lTm != 1) {
            break label674;
          }
          paramBoolean = true;
          if (af.lXY.lTn != 1) {
            break label679;
          }
          bool1 = true;
          if (af.lXY.lTo != 1) {
            break label685;
          }
          bool2 = true;
          if (af.lXY.lTp != 1) {
            break label691;
          }
          bool3 = true;
          Log.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((af.lXY.lTl == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            a(this.lTN, false);
            if ((af.lXY.lTm == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              b(this.lTN);
            }
            if ((af.lYf.lWG != -1) && (af.lYf.lWG == 1) && (com.tencent.mm.compatible.util.d.rd(14))) {
              c(this.lTN);
            }
            if ((af.lXY.lTo == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              a(this.lTN);
            }
            if ((af.lXY.lTp == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            d(this.lTN);
            btd();
            this.lTN.f(paramSurfaceTexture);
            this.lTN.aPz();
            if (!j.KVJ.KVV) {
              break label640;
            }
            if ((af.lXY.lTo == 0) && (this.mSensorManager != null) && (this.KUZ != null)) {
              this.mSensorManager.registerListener(this, this.KUZ, 2);
            }
            this.KUW = true;
            Log.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Looper.myLooper() });
            AppMethodBeat.o(89385);
            return 0;
          }
        }
        else
        {
          if (af.lXY.lTk != 1) {
            break label666;
          }
          str = "Fix";
          continue;
        }
        if ((af.lXY.lTk != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        a(this.lTN, true);
        continue;
        this.mSensorManager.registerListener(this, this.KUZ, 2);
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
  
  public final void a(a parama)
  {
    AppMethodBeat.i(89374);
    this.KVl = parama;
    String str1;
    String str2;
    a locala;
    if (parama == a.KVv)
    {
      parama = b.gbT();
      str1 = this.nGt.gbV();
      str2 = this.nGs.gbV();
      locala = this.KVi;
      if (locala.vqT != 0) {
        break label94;
      }
    }
    label94:
    for (int i = 0;; i = locala.vqS / locala.vqT)
    {
      parama.KUE = ((int)(Util.safeParseDouble(str1) * 10.0D));
      parama.KUF = ((int)(Util.safeParseDouble(str2) * 10.0D));
      parama.KUK = i;
      AppMethodBeat.o(89374);
      return;
    }
  }
  
  public final void a(b paramb, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(89390);
    Log.i("MicroMsg.MMSightCamera", "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s", new Object[] { paramb, this.nGy, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.nGy != null) {
      try
      {
        this.nGx = true;
        Point localPoint = new Point();
        if (this.nGb != null) {
          localPoint.x = this.nGb.x;
        }
        for (localPoint.y = this.nGb.y;; localPoint.y = this.KVe.y)
        {
          byte[] arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.j.KXq.m(Integer.valueOf(this.nGy.length));
          System.arraycopy(this.nGy, 0, arrayOfByte, 0, this.nGy.length);
          int i = this.nGr.hYK;
          paramb.a(arrayOfByte, localPoint.x, localPoint.y, i, paramInt);
          return;
          if ((this.KVg == null) || (!this.KVh)) {
            break;
          }
          localPoint.x = this.KVe.x;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.MMSightCamera", "takePicture error: %s", new Object[] { localException.getMessage() });
          this.nGx = false;
          paramb.a(null, 0, 0, -1, 0);
          return;
          localException.x = this.nFW.zWH;
          localException.y = this.nFW.zWI;
        }
      }
      finally
      {
        this.nGx = false;
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
      this.nGq.add(paramg);
    }
    AppMethodBeat.o(89372);
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(89400);
    Log.i("MicroMsg.MMSightCamera", "switch camera with limit, current useBack: %s", new Object[] { Boolean.valueOf(this.nFR) });
    try
    {
      gcd();
      if (!this.nFR) {}
      for (boolean bool = true;; bool = false)
      {
        N(paramContext, bool);
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
    Log.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", new Object[] { Boolean.valueOf(this.nFR) });
    try
    {
      gcd();
      if (!this.nFR) {}
      for (boolean bool = true;; bool = false)
      {
        N(paramContext, bool);
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
  
  public final void abc(int paramInt)
  {
    AppMethodBeat.i(89395);
    if (this.lTN != null) {
      try
      {
        Camera.Parameters localParameters = this.lTN.aPy();
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
        if (this.isZooming)
        {
          Log.d("MicroMsg.MMSightCamera", "setForceZoomTargetRatio, zooming, ignore");
          return;
        }
        this.isZooming = true;
        localParameters.setZoom(paramInt);
        this.lTN.c(localParameters);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MMSightCamera", "getZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.isZooming = false;
        AppMethodBeat.o(89395);
      }
    }
    AppMethodBeat.o(89395);
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89392);
    if (com.tencent.mm.compatible.util.d.rc(14))
    {
      AppMethodBeat.o(89392);
      return;
    }
    this.KVr.removeMessages(4354);
    this.KVr.mkm = paramFloat1;
    this.KVr.mkn = paramFloat2;
    this.KVr.nGM = paramInt1;
    this.KVr.nGN = paramInt2;
    this.KVr.sendMessageDelayed(this.KVr.obtainMessage(4354, this.lTN), 400L);
    AppMethodBeat.o(89392);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(89373);
    if (paramg != null) {
      this.nGq.remove(paramg);
    }
    AppMethodBeat.o(89373);
  }
  
  public final boolean boa()
  {
    return this.KUW;
  }
  
  public final boolean btn()
  {
    return this.nFR;
  }
  
  public final Point dPz()
  {
    return this.KVe;
  }
  
  public final void e(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(89396);
    if ((this.lTN != null) && (this.KUW)) {}
    for (;;)
    {
      int m;
      int k;
      int j;
      try
      {
        Log.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (this.isZooming)
        {
          Log.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
          return;
        }
        Camera.Parameters localParameters = this.lTN.aPy();
        if (localParameters.isZoomSupported())
        {
          this.isZooming = true;
          m = localParameters.getZoom();
          k = localParameters.getMaxZoom();
          if (!paramBoolean2)
          {
            if (this.nGd <= 0)
            {
              this.nGd = Math.round(k / 15.0F);
              if (this.nGd > 5) {
                this.nGd = 5;
              }
            }
            i = this.nGd;
            Log.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(this.nGd), Integer.valueOf(this.nGc), Integer.valueOf(paramInt) });
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
            if (this.nGc <= 0)
            {
              Log.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", new Object[] { Integer.valueOf(this.nGc) });
              return;
            }
            i = this.nGc;
            continue;
            Log.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", new Object[] { Integer.valueOf(paramInt) });
            localParameters.setZoom(paramInt);
            this.lTN.c(localParameters);
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
        this.isZooming = false;
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
  
  public final void gbY()
  {
    AppMethodBeat.i(89382);
    Log.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
    if ((this.lTN != null) && (this.KUW)) {
      try
      {
        Camera.Parameters localParameters = this.lTN.aPy();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          Log.i("MicroMsg.MMSightCameraSetting", "support continuous video");
          localParameters.setFocusMode("continuous-video");
        }
        this.lTN.c(localParameters);
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
  
  public final void gbZ()
  {
    AppMethodBeat.i(89383);
    Log.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode");
    if ((this.lTN != null) && (this.KUW)) {
      try
      {
        Camera.Parameters localParameters = this.lTN.aPy();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          Log.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
        }
        this.lTN.c(localParameters);
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
  
  public final String gca()
  {
    AppMethodBeat.i(89389);
    if (this.lTN == null)
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
        localObject3 = com.tencent.mm.plugin.mmsight.d.h(this.lTN.aPy());
        if (this.nFZ == null)
        {
          Object localObject1 = com.tencent.mm.plugin.mmsight.d.iQ(this.mContext);
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
        localObject2 = new Point(this.nFZ.getWidth(), this.nFZ.getHeight());
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
    if (this.nGb != null) {
      localStringBuffer.append("\nSIGHTCROPMODE:  " + this.nGb.x + " " + this.nGb.y + " from " + this.nFW.zWH + " " + this.nFW.zWI);
    }
    for (;;)
    {
      localStringBuffer.append("\ngetOrientation:" + getOrientation());
      localStringBuffer.append("\nrecorderOption: " + af.lYf.lWF);
      localObject2 = localStringBuffer.toString();
      AppMethodBeat.o(89389);
      return localObject2;
      localStringBuffer.append("\nFinalPreviewSize: " + getPreviewWidth() + " " + getPreviewHeight());
    }
  }
  
  public final void gcb()
  {
    AppMethodBeat.i(89393);
    if ((this.lTN != null) && (this.KUW)) {
      try
      {
        Camera.Parameters localParameters = this.lTN.aPy();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("auto")))
        {
          Log.i("MicroMsg.MMSightCameraSetting", "support auto focus");
          localParameters.setFocusMode("auto");
          this.lTN.c(localParameters);
        }
        this.lTN.aPA();
        AppMethodBeat.o(89393);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.lTN.a(new Camera.AutoFocusCallback()
            {
              public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
              {
                AppMethodBeat.i(89363);
                if ((paramAnonymousCamera != null) && (f.this.boa())) {
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
  
  public final List<Integer> gcc()
  {
    AppMethodBeat.i(89394);
    if (this.lTN != null) {
      try
      {
        Object localObject = this.lTN.aPy();
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
  
  public final int gcd()
  {
    AppMethodBeat.i(89401);
    gbX();
    AppMethodBeat.o(89401);
    return 0;
  }
  
  public final void gce()
  {
    AppMethodBeat.i(89402);
    Log.i("MicroMsg.MMSightCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[] { this.lTN, Boolean.valueOf(this.KUW) });
    if ((this.lTN != null) && (this.KUW)) {
      try
      {
        this.KVj = true;
        Camera.Parameters localParameters = this.lTN.aPy();
        if ((!Util.isNullOrNil(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("torch")))
        {
          localParameters.setFlashMode("torch");
          this.lTN.c(localParameters);
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
  
  public final void gcf()
  {
    AppMethodBeat.i(89403);
    Log.i("MicroMsg.MMSightCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[] { this.lTN, Boolean.valueOf(this.KUW) });
    if ((this.lTN != null) && (this.KUW)) {
      try
      {
        this.KVj = false;
        Camera.Parameters localParameters = this.lTN.aPy();
        if ((!Util.isNullOrNil(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("off")))
        {
          localParameters.setFlashMode("off");
          this.lTN.c(localParameters);
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
  
  public final void gcg()
  {
    AppMethodBeat.i(89404);
    Log.i("MicroMsg.MMSightCamera", "autoFlash, camera: %s, isPreviewing: %s", new Object[] { this.lTN, Boolean.valueOf(this.KUW) });
    if ((this.lTN != null) && (this.KUW)) {
      try
      {
        this.KVj = true;
        Camera.Parameters localParameters = this.lTN.aPy();
        if ((!Util.isNullOrNil(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("auto")))
        {
          localParameters.setFlashMode("auto");
          this.lTN.c(localParameters);
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
  
  public final int getOrientation()
  {
    if ((this.nGr != null) && (this.KUW)) {
      return this.nGr.hYK;
    }
    return -1;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(89406);
    if (this.lTN == null)
    {
      AppMethodBeat.o(89406);
      return 0;
    }
    if (this.nGr != null) {
      try
      {
        int i;
        if ((this.KVh) && (this.KVg != null)) {
          if ((this.nGr.hYK == 0) || (this.nGr.hYK == 180)) {
            i = this.KVe.y;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89406);
          return i;
          i = this.KVe.x;
          continue;
          if (this.nGb == null)
          {
            if ((this.nGr.hYK == 0) || (this.nGr.hYK == 180)) {
              i = this.nFW.zWI;
            } else {
              i = this.nFW.zWH;
            }
          }
          else if ((this.nGr.hYK == 0) || (this.nGr.hYK == 180)) {
            i = this.nGb.y;
          } else {
            i = this.nGb.x;
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
    if (this.lTN == null)
    {
      AppMethodBeat.o(89405);
      return 0;
    }
    if (this.nGr != null) {
      try
      {
        int i;
        if ((this.KVh) && (this.KVg != null)) {
          if ((this.nGr.hYK == 0) || (this.nGr.hYK == 180)) {
            i = this.KVe.x;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89405);
          return i;
          i = this.KVe.y;
          continue;
          if (this.nGb == null)
          {
            if ((this.nGr.hYK == 0) || (this.nGr.hYK == 180)) {
              i = this.nFW.zWH;
            } else {
              i = this.nFW.zWI;
            }
          }
          else if ((this.nGr.hYK == 0) || (this.nGr.hYK == 180)) {
            i = this.nGb.x;
          } else {
            i = this.nGb.y;
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
    if ((Math.abs(this.KVa - f1) > 5.0F) || (Math.abs(this.KVb - f2) > 5.0F) || (Math.abs(this.KVc - f3) > 5.0F))
    {
      Log.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", new Object[] { Float.valueOf(5.0F), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      this.KVr.e(this.lTN);
      this.KVa = f1;
      this.KVb = f2;
      this.KVc = f3;
    }
    AppMethodBeat.o(89391);
  }
  
  public final void up(int paramInt)
  {
    AppMethodBeat.i(89397);
    if (this.nGc > 0)
    {
      AppMethodBeat.o(89397);
      return;
    }
    if (this.nFZ == null) {}
    int i;
    for (Point localPoint = aw.bf(MMApplicationContext.getContext());; localPoint = new Point(this.nFZ.getWidth(), this.nFZ.getHeight()))
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
      if (this.lTN != null)
      {
        i = this.lTN.aPy().getMaxZoom();
        this.nGc = ((int)(i / (paramInt / 3.0D / 10.0D)) + 1);
        Log.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.nGc), Integer.valueOf(i) });
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
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(89366);
      KVt = new a("Preview", 0);
      KVu = new a("Recording", 1);
      KVv = new a("Stoping", 2);
      KVw = new a[] { KVt, KVu, KVv };
      AppMethodBeat.o(89366);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public final class c
    extends MMHandler
  {
    boolean KUV = false;
    int KVx = 0;
    boolean KVy = false;
    float mkm;
    float mkn;
    boolean nGA = false;
    int nGM;
    int nGN;
    
    public c(Looper paramLooper)
    {
      super();
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
      localObject = new Rect(abd(Math.round(((RectF)localObject).left)), abd(Math.round(((RectF)localObject).top)), abd(Math.round(((RectF)localObject).right)), abd(Math.round(((RectF)localObject).bottom)));
      AppMethodBeat.o(89367);
      return localObject;
    }
    
    private static int abd(int paramInt)
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
    
    private static int i(Camera.Parameters paramParameters)
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
      if (!f.KVq)
      {
        Log.w("MicroMsg.MMSightCamera", "auto focus not back");
        AppMethodBeat.o(89368);
        return;
      }
      f.KVq = false;
      try
      {
        Log.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
        paramw.aPA();
        paramw.a(f.this.nuM);
        AppMethodBeat.o(89368);
        return;
      }
      catch (Exception paramw)
      {
        Log.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", new Object[] { paramw.getMessage() });
        f.KVq = true;
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
        if ((this.nGM == 0) || (this.nGN == 0) || (com.tencent.mm.compatible.util.d.rc(14)))
        {
          e(paramMessage);
          AppMethodBeat.o(89370);
          return;
        }
        float f1 = this.mkm;
        float f2 = this.mkn;
        int i = this.nGM;
        j = this.nGN;
        if (paramMessage == null)
        {
          Log.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
          AppMethodBeat.o(89370);
          return;
        }
        if (!f.KVq)
        {
          Log.w("MicroMsg.MMSightCamera", "auto focus not back");
          AppMethodBeat.o(89370);
          return;
        }
        f.KVq = false;
        try
        {
          paramMessage.aPA();
          Log.i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
          Object localObject2 = a(f1, f2, 1.0F, i, j);
          localObject1 = a(f1, f2, 1.5F, i, j);
          Log.i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
          localParameters = paramMessage.aPy();
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
          paramMessage.a(f.this.nuM);
          AppMethodBeat.o(89370);
          return;
        }
        catch (Exception paramMessage)
        {
          Log.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
          f.KVq = true;
          AppMethodBeat.o(89370);
          return;
        }
        if (this.nGA)
        {
          AppMethodBeat.o(89370);
          return;
        }
        Object localObject1 = (Camera)paramMessage.obj;
        Camera.Parameters localParameters = ((Camera)localObject1).getParameters();
        Log.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(this.KUV), Integer.valueOf(this.KVx), Integer.valueOf(localParameters.getZoom()) });
        i = localParameters.getZoom() + this.KVx;
        if (this.KUV)
        {
          int k = i(localParameters);
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
          this.nGM = 0;
          this.nGN = 0;
          continue;
          paramMessage = obtainMessage(4353, paramMessage.obj);
          if (this.KVy) {}
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
          if (this.KVy) {}
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