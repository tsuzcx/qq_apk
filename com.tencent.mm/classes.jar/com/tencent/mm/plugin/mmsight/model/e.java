package com.tencent.mm.plugin.mmsight.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Looper;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.h.a.lx;
import com.tencent.mm.h.a.lx.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.t.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.ak;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class e
  implements SensorEventListener
{
  protected static int mgA = 2147483647;
  static boolean mhb = true;
  public SensorManager aVT;
  protected boolean apT = false;
  public Camera dwJ = null;
  public d.a.a jXx;
  public Context mContext = null;
  public Sensor mgB;
  protected float mgC = 0.0F;
  protected float mgD = 0.0F;
  protected float mgE = 0.0F;
  protected Point mgF = null;
  public Point mgG = null;
  public Point mgH = null;
  protected int mgI = 0;
  protected byte[] mgJ;
  protected boolean mgK = false;
  protected com.tencent.mm.plugin.base.model.a mgL = new com.tencent.mm.plugin.base.model.a();
  protected boolean mgM = false;
  protected List<f> mgN = new ArrayList();
  public boolean mgO = false;
  private a mgP = a.mhg;
  private b mgQ = new b("prevcameraCallback");
  private b mgR = new b("cameraCallback");
  private b mgS = new b("cameraPreviewCallback");
  private b mgT = new b("cameraCropCallback");
  private b mgU = new b("mirrorCameraCallback");
  private b mgV = new b("finishCallbackTimeCallback");
  public VideoTransPara mgW;
  public volatile byte[] mgX = null;
  public volatile boolean mgY = false;
  public boolean mgZ = false;
  protected int mgu = -1;
  protected int mgv = -1;
  public p mgw = p.bje();
  protected boolean mgx = false;
  public boolean mgy = false;
  protected int mgz = 0;
  private boolean mha = false;
  Camera.AutoFocusCallback mhc = new e.2(this);
  private e.c mhd = new e.c(this, Looper.getMainLooper());
  public boolean mhe = true;
  private int scene = 0;
  
  public e(VideoTransPara paramVideoTransPara, int paramInt)
  {
    this.mgW = paramVideoTransPara;
    this.scene = paramInt;
  }
  
  private boolean a(Camera paramCamera, int paramInt, float paramFloat, boolean paramBoolean)
  {
    if ((paramCamera == null) || (paramInt <= 0)) {
      return false;
    }
    for (;;)
    {
      try
      {
        Camera.Parameters localParameters = paramCamera.getParameters();
        new Point(paramInt, (int)(paramInt / paramFloat));
        Object localObject = ak.gx(ae.getContext());
        Point localPoint = new Point(Math.min(((Point)localObject).x, ((Point)localObject).y), Math.max(((Point)localObject).x, ((Point)localObject).y));
        y.i("MicroMsg.MMSightCamera", "screenSize: %s, currentScreenSize: %s", new Object[] { localPoint, localObject });
        float f1 = Math.min(localPoint.x, localPoint.y) / Math.max(localPoint.x, localPoint.y);
        float f2 = 1.0F / paramFloat;
        int i;
        if (paramFloat < 1.0F)
        {
          i = paramInt;
          y.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[] { Integer.valueOf(i), Float.valueOf(paramFloat), Float.valueOf(f1) });
          if (this.jXx.rotate == 90) {
            break label690;
          }
          if (this.jXx.rotate != 270) {
            break label702;
          }
          break label690;
          g.b localb = g.a(localParameters, localPoint, i, bool);
          if (localb != null)
          {
            localObject = localb;
            if (localb.jkk != null) {}
          }
          else
          {
            y.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
            if (this.jXx.rotate == 90) {
              break label696;
            }
            if (this.jXx.rotate != 270) {
              break label708;
            }
            break label696;
            localObject = g.c(localParameters, localPoint, paramInt, bool);
            this.mgZ = false;
          }
          if ((localObject != null) && (((g.b)localObject).jkk != null))
          {
            paramInt = (int)(((g.b)localObject).jkk.x * paramFloat);
            y.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio result preview size: %s, cropHeight: %s", new Object[] { ((g.b)localObject).jkk, Integer.valueOf(paramInt) });
            if (paramInt <= ((g.b)localObject).jkk.y) {
              this.mgZ = false;
            }
          }
          else
          {
            if ((localObject == null) || (((g.b)localObject).jkk == null)) {
              break label666;
            }
            localObject = ((g.b)localObject).jkk;
            this.mgw.jSV = ((Point)localObject).x;
            this.mgw.jSW = ((Point)localObject).y;
            this.mgG = ((Point)localObject);
            this.mgH = null;
            if (!paramBoolean)
            {
              if ((j.mhB.dys != 2) || (com.tencent.mm.plugin.mmsight.d.tU(this.mgG.y))) {
                break label679;
              }
              paramInt = com.tencent.mm.plugin.mmsight.d.tV(this.mgG.y);
              if (Math.abs(paramInt - this.mgG.y) > 16) {
                break label668;
              }
              y.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.mgG, Integer.valueOf(paramInt) });
              this.mgF = new Point(this.mgG.x, this.mgG.y);
              this.mgG.y = paramInt;
              this.mgK = true;
              this.mgJ = new byte[this.mgG.x * this.mgG.y * 3 / 2];
            }
            y.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s, cropWidth: %s", new Object[] { localObject, this.mgG, this.mgH, Boolean.valueOf(this.mgZ) });
            localParameters.setPreviewSize(this.mgw.jSV, this.mgw.jSW);
            paramCamera.setParameters(localParameters);
            return true;
          }
        }
        else
        {
          i = Math.round(paramInt / f2);
          continue;
        }
        this.mgZ = true;
        continue;
        return false;
      }
      catch (Exception paramCamera)
      {
        y.e("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimit error: %s", new Object[] { paramCamera.getMessage() });
      }
      label666:
      label668:
      j.f(this.mgG);
      continue;
      label679:
      j.f(this.mgG);
      continue;
      label690:
      boolean bool = true;
      continue;
      label696:
      bool = true;
      continue;
      label702:
      bool = false;
      continue;
      label708:
      bool = false;
    }
  }
  
  private boolean a(Camera paramCamera, boolean paramBoolean)
  {
    if (paramCamera == null) {
      return false;
    }
    Camera.Parameters localParameters;
    Point localPoint;
    Object localObject1;
    Object localObject3;
    int i;
    boolean bool;
    for (;;)
    {
      try
      {
        localParameters = paramCamera.getParameters();
        localPoint = com.tencent.mm.plugin.mmsight.d.dL(this.mContext);
        if (this.mhe)
        {
          localObject1 = a.biE();
          localObject2 = localParameters.getSupportedPreviewSizes();
          localObject3 = localParameters.getSupportedPictureSizes();
          i = this.jXx.rotate;
          if (bk.bl(((a)localObject1).mfR)) {
            ((a)localObject1).mfR = com.tencent.mm.plugin.mmsight.d.bP((List)localObject2);
          }
          if (bk.bl(((a)localObject1).mfS)) {
            ((a)localObject1).mfS = com.tencent.mm.plugin.mmsight.d.bP((List)localObject3);
          }
          ((a)localObject1).rotate = i;
          ((a)localObject1).mgn = 1;
          if (paramBoolean)
          {
            if (this.jXx.rotate == 90) {
              break label2327;
            }
            if (this.jXx.rotate == 270)
            {
              break label2327;
              j.a(localParameters, bool);
            }
          }
          else
          {
            k.bjA();
            i = k.bjD();
            if (this.jXx.rotate == 90) {
              break label2333;
            }
            if (this.jXx.rotate != 270) {
              break label354;
            }
            break label2333;
            label187:
            localObject1 = g.b(localParameters, localPoint, i, bool);
            j.a((g.b)localObject1);
            localPoint = ((g.b)localObject1).jkk;
            if (localPoint != null) {
              break;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.a(440L, 140L, 0L, false);
            return false;
          }
        }
        else
        {
          localObject1 = a.biE();
          localObject2 = localParameters.getSupportedPreviewSizes();
          localObject3 = localParameters.getSupportedPictureSizes();
          i = this.jXx.rotate;
          if (bk.bl(((a)localObject1).mfT)) {
            ((a)localObject1).mfT = com.tencent.mm.plugin.mmsight.d.bP((List)localObject2);
          }
          if (bk.bl(((a)localObject1).mfU)) {
            ((a)localObject1).mfU = com.tencent.mm.plugin.mmsight.d.bP((List)localObject3);
          }
          ((a)localObject1).rotate = i;
          ((a)localObject1).mgn = 2;
          continue;
        }
        bool = false;
      }
      catch (Exception paramCamera)
      {
        y.i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), paramCamera.getMessage() });
        return false;
      }
      continue;
      label354:
      bool = false;
    }
    this.mgw.jSV = localPoint.x;
    this.mgw.jSW = localPoint.y;
    this.mgG = localPoint;
    Object localObject2 = this.mContext;
    if (this.jXx.rotate != 90)
    {
      if (this.jXx.rotate != 270) {
        break label2345;
      }
      break label2339;
      label424:
      bool = com.tencent.mm.plugin.mmsight.d.a((Context)localObject2, localPoint, bool);
      i = 1;
      if ((this.jXx.rotate == 90) || (this.jXx.rotate == 270))
      {
        if ((localPoint.y < this.mgW.width) || (localPoint.x < this.mgW.height))
        {
          i = 0;
          y.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localPoint });
        }
        y.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label1263;
        }
        if (j.mhB.dys != 2) {
          break label1251;
        }
        this.mgH = ((g.b)localObject1).mhr;
        if ((this.mgH.x < localPoint.x) || (this.mgH.y < localPoint.y))
        {
          if ((this.jXx.rotate != 90) && (this.jXx.rotate != 270)) {
            break label1231;
          }
          this.mgH.y = com.tencent.mm.plugin.mmsight.d.tW(this.mgH.y);
        }
        label630:
        this.mgG = new Point(this.mgH.x, this.mgH.y);
        this.mgI = (this.mgH.x * this.mgH.y * 3 / 2);
        y.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", new Object[] { this.mgH });
      }
    }
    label781:
    label795:
    label1692:
    label1824:
    label2339:
    label2345:
    label2351:
    for (;;)
    {
      label698:
      int j;
      label765:
      int k;
      if (j.mhB.mhM)
      {
        if ((this.jXx.rotate != 90) && (this.jXx.rotate != 270)) {
          break label1864;
        }
        if (i != 0)
        {
          if (j.mhB.mgf != 1080) {
            break label1692;
          }
          if (this.mgH != null) {
            break label1640;
          }
          j = localPoint.x / 2;
          if (this.mgH != null) {
            break label1654;
          }
          i = localPoint.y / 2;
          if (this.mgH != null) {
            break label1668;
          }
          k = localPoint.x;
          k = com.tencent.mm.plugin.mmsight.d.df(j, k);
          if (this.mgH != null) {
            break label1680;
          }
          j = localPoint.y;
          label818:
          this.mgG = new Point(k, com.tencent.mm.plugin.mmsight.d.df(i, j));
        }
      }
      label838:
      localObject1 = a.biE();
      localObject2 = this.mgH;
      localObject3 = this.mgG;
      ((a)localObject1).mga = -1;
      ((a)localObject1).mfZ = -1;
      ((a)localObject1).mfW = -1;
      ((a)localObject1).mfV = -1;
      ((a)localObject1).mfY = -1;
      ((a)localObject1).mfX = -1;
      if (localPoint != null)
      {
        ((a)localObject1).mfX = localPoint.x;
        ((a)localObject1).mfY = localPoint.y;
      }
      if (localObject2 != null)
      {
        ((a)localObject1).mfV = ((Point)localObject2).x;
        ((a)localObject1).mfW = ((Point)localObject2).y;
      }
      if (localObject3 != null)
      {
        ((a)localObject1).mfZ = ((Point)localObject3).x;
        ((a)localObject1).mga = ((Point)localObject3).y;
      }
      if (paramBoolean) {
        if ((!bool) && (j.mhB.dys == 2) && (!com.tencent.mm.plugin.mmsight.d.tU(this.mgG.y)))
        {
          i = com.tencent.mm.plugin.mmsight.d.tV(this.mgG.y);
          if (Math.abs(i - this.mgG.y) <= 16)
          {
            y.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.mgG, Integer.valueOf(i) });
            this.mgF = new Point(this.mgG.x, this.mgG.y);
            this.mgG.y = i;
            this.mgK = true;
            this.mgJ = new byte[this.mgG.x * this.mgG.y * 3 / 2];
          }
        }
      }
      for (;;)
      {
        y.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", new Object[] { localPoint, this.mgG, this.mgH });
        localParameters.setPreviewSize(this.mgw.jSV, this.mgw.jSW);
        paramCamera.setParameters(localParameters);
        return true;
        if ((localPoint.x >= this.mgW.width) && (localPoint.y >= this.mgW.height)) {
          break;
        }
        i = 0;
        y.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localPoint });
        break;
        label1231:
        this.mgH.x = com.tencent.mm.plugin.mmsight.d.tW(this.mgH.x);
        break label630;
        label1251:
        this.mgH = ((g.b)localObject1).mhq;
        break label630;
        label1263:
        if ((!j.mhB.mhM) || (j.mhB.mgf != 1080) || (i == 0)) {
          break label2324;
        }
        if ((this.jXx.rotate == 90) || (this.jXx.rotate == 270))
        {
          j = localPoint.y / 2;
          k = com.tencent.mm.plugin.mmsight.d.tV(j);
          m = localPoint.x / 2;
          n = com.tencent.mm.plugin.mmsight.d.tV(m);
          if ((Math.abs(k - j) < 8) && (Math.abs(n - m) < 8)) {
            break label2351;
          }
          this.mgH = new Point(localPoint.x, localPoint.y);
          this.mgH.y = com.tencent.mm.plugin.mmsight.d.tW(localPoint.y);
          this.mgH.x = com.tencent.mm.plugin.mmsight.d.tW(localPoint.x);
          this.mgG = new Point(this.mgH.x, this.mgH.y);
          this.mgI = (this.mgH.x * this.mgH.y * 3 / 2);
          bool = true;
          break label2351;
        }
        j = localPoint.x / 2;
        k = com.tencent.mm.plugin.mmsight.d.tV(j);
        int m = localPoint.y / 2;
        int n = com.tencent.mm.plugin.mmsight.d.tV(m);
        if ((Math.abs(k - j) < 8) && (Math.abs(n - m) < 8)) {
          break label2324;
        }
        this.mgH = new Point(localPoint.x, localPoint.y);
        this.mgH.y = com.tencent.mm.plugin.mmsight.d.tW(localPoint.x);
        this.mgH.x = com.tencent.mm.plugin.mmsight.d.tW(localPoint.y);
        this.mgG = new Point(this.mgH.x, this.mgH.y);
        this.mgI = (this.mgH.x * this.mgH.y * 3 / 2);
        bool = true;
        break label698;
        label1640:
        j = this.mgH.x / 2;
        break label765;
        label1654:
        i = this.mgH.y / 2;
        break label781;
        k = this.mgH.x;
        break label795;
        j = this.mgH.y;
        break label818;
        if (j.mhB.mgf != 720) {
          break label838;
        }
        float f;
        if (this.mgH == null)
        {
          f = localPoint.x * 0.75F;
          label1722:
          k = (int)f;
          if (this.mgH != null) {
            break label1824;
          }
          f = localPoint.y * 0.75F;
          label1744:
          j = (int)f;
          if (this.mgH != null) {
            break label1840;
          }
          i = localPoint.x;
          label1762:
          k = com.tencent.mm.plugin.mmsight.d.df(k, i);
          if (this.mgH != null) {
            break label1852;
          }
        }
        label1840:
        label1852:
        for (i = localPoint.y;; i = this.mgH.y)
        {
          this.mgG = new Point(k, com.tencent.mm.plugin.mmsight.d.df(j, i));
          break;
          f = this.mgH.x * 0.75F;
          break label1722;
          f = this.mgH.y * 0.75F;
          break label1744;
          i = this.mgH.x;
          break label1762;
        }
        label1864:
        if (i == 0) {
          break label838;
        }
        if (j.mhB.mgf == 1080)
        {
          if (this.mgH == null)
          {
            j = localPoint.y / 2;
            label1897:
            if (this.mgH != null) {
              break label1987;
            }
            i = localPoint.x / 2;
            label1913:
            if (this.mgH != null) {
              break label2001;
            }
            k = localPoint.y;
            k = com.tencent.mm.plugin.mmsight.d.df(j, k);
            if (this.mgH != null) {
              break label2013;
            }
          }
          label1987:
          label2001:
          label2013:
          for (j = localPoint.x;; j = this.mgH.x)
          {
            this.mgG = new Point(k, com.tencent.mm.plugin.mmsight.d.df(i, j));
            break;
            j = this.mgH.y / 2;
            break label1897;
            i = this.mgH.x / 2;
            break label1913;
            k = this.mgH.y;
            break label1927;
          }
        }
        if (j.mhB.mgf != 720) {
          break label838;
        }
        if (this.mgH == null)
        {
          f = localPoint.y * 0.75F;
          k = (int)f;
          if (this.mgH != null) {
            break label2157;
          }
          f = localPoint.x * 0.75F;
          j = (int)f;
          if (this.mgH != null) {
            break label2173;
          }
          i = localPoint.y;
          label2095:
          k = com.tencent.mm.plugin.mmsight.d.df(k, i);
          if (this.mgH != null) {
            break label2185;
          }
        }
        for (i = localPoint.x;; i = this.mgH.x)
        {
          this.mgG = new Point(k, com.tencent.mm.plugin.mmsight.d.df(j, i));
          break;
          f = this.mgH.y * 0.75F;
          break label2055;
          label2157:
          f = this.mgH.x * 0.75F;
          break label2077;
          label2173:
          i = this.mgH.y;
          break label2095;
        }
        j.f(this.mgG);
        continue;
        j.f(this.mgG);
        continue;
        if ((!bool) && (j.mhB.dys == 2) && (!com.tencent.mm.plugin.mmsight.d.tU(this.mgG.y)) && (this.mgK) && (this.mgJ != null) && (this.mgF.y == this.mgG.y))
        {
          i = com.tencent.mm.plugin.mmsight.d.tV(this.mgG.y);
          if (this.mgJ.length == this.mgG.x * i * 3 / 2) {
            this.mgG.y = i;
          }
        }
      }
      continue;
      bool = true;
      break;
      bool = true;
      break label187;
      bool = true;
      break label424;
      bool = false;
      break label424;
    }
  }
  
  @TargetApi(14)
  public static boolean b(Camera paramCamera)
  {
    if (paramCamera == null) {
      return false;
    }
    try
    {
      y.i("MicroMsg.MMSightCameraSetting", "safeSetMetering");
      Camera.Parameters localParameters = paramCamera.getParameters();
      if (localParameters.getMaxNumMeteringAreas() > 0)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new Camera.Area(new Rect(-1000, -1000, 1000, 1000), 600));
        localParameters.setMeteringAreas(localArrayList);
      }
      paramCamera.setParameters(localParameters);
      return true;
    }
    catch (Exception paramCamera)
    {
      y.i("MicroMsg.MMSightCameraSetting", "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramCamera.getMessage() });
    }
    return false;
  }
  
  public static boolean b(Camera paramCamera, boolean paramBoolean)
  {
    if (paramCamera == null) {
      return false;
    }
    Camera.Parameters localParameters;
    label215:
    List localList2;
    do
    {
      for (;;)
      {
        try
        {
          localParameters = paramCamera.getParameters();
          if (!paramBoolean) {
            break label215;
          }
          if (q.dyd.dwn > 0)
          {
            y.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview frame rate");
            y.i("MicroMsg.MMSightCameraSetting", "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), localParameters.getSupportedPreviewFrameRates() });
            paramCamera.setParameters(localParameters);
            return true;
          }
          if (localParameters == null)
          {
            y.e("MicroMsg.MMSightCamera", "trySetPreviewFrameRateParameters error, p is null!");
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
            y.i("MicroMsg.MMSightCameraSetting", "set preview frame rate %d", new Object[] { Integer.valueOf(i) });
          }
          catch (Exception localException1)
          {
            y.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException1.getMessage() });
          }
        }
        catch (Exception paramCamera)
        {
          y.i("MicroMsg.MMSightCameraSetting", "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramCamera.getMessage() });
          return false;
        }
        continue;
        if (q.dyd.dwn <= 0) {
          break;
        }
        y.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview fps range");
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
            break label548;
          }
          i2 = i;
          i1 = j;
          if (arrayOfInt.length <= 1) {
            break label548;
          }
          int i5 = arrayOfInt[0];
          i4 = arrayOfInt[1];
          y.i("MicroMsg.MMSightCamera", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4) });
          i2 = i;
          i1 = j;
          if (i5 < 0) {
            break label548;
          }
          i2 = i;
          i1 = j;
          if (i4 < i5) {
            break label548;
          }
          k = i;
          m = j;
          if (i4 < i) {
            break label561;
          }
          k = i;
          m = j;
          if (n != 0) {
            break label561;
          }
          k = i4;
          m = i5;
          break label561;
        }
        y.i("MicroMsg.MMSightCameraSetting", "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(30) });
        if ((j == 2147483647) || (i == 2147483647)) {
          break;
        }
        try
        {
          localParameters.setPreviewFpsRange(j, i);
          y.i("MicroMsg.MMSightCameraSetting", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        }
        catch (Exception localException2)
        {
          y.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException2.getMessage() });
        }
      }
      break;
      label548:
      label561:
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
  
  private void biI()
  {
    if ((this.aVT != null) && (this.mgB != null)) {
      this.aVT.unregisterListener(this);
    }
    y.i("MicroMsg.MMSightCamera", this.mgQ.getValue());
    y.i("MicroMsg.MMSightCamera", this.mgR.getValue());
    y.i("MicroMsg.MMSightCamera", this.mgS.getValue());
    y.i("MicroMsg.MMSightCamera", this.mgT.getValue());
    y.i("MicroMsg.MMSightCamera", this.mgU.getValue());
    y.i("MicroMsg.MMSightCamera", this.mgV.getValue());
    if (this.dwJ != null)
    {
      long l = bk.UZ();
      y.i("MicroMsg.MMSightCamera", "release camera beg, %s", new Object[] { Looper.myLooper() });
      this.mhd.removeCallbacksAndMessages(null);
      this.mhd.mhm = true;
      this.dwJ.setPreviewCallback(null);
      this.dwJ.stopPreview();
      this.dwJ.release();
      this.dwJ = null;
      this.mgy = false;
      y.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", new Object[] { Long.valueOf(bk.cp(l)), Looper.myLooper() });
    }
    this.mgx = false;
    this.mgC = 0.0F;
    this.mgD = 0.0F;
    this.mgE = 0.0F;
    mhb = true;
    this.mContext = null;
    this.mha = false;
    this.mgG = null;
    this.mgH = null;
    this.mgX = null;
    this.mgO = false;
  }
  
  private void biL()
  {
    if (true == this.mha) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((this.mContext == null) || ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.f.b.zB())));
      localObject = new lx();
      ((lx)localObject).bVc.type = 2;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      if (((lx)localObject).bVd.bVb)
      {
        this.mha = true;
        return;
      }
      localObject = com.tencent.mm.ui.base.h.h(this.mContext, a.a.short_video_no_record_video_permission, a.a.app_tip);
    } while (localObject == null);
    ((com.tencent.mm.ui.widget.a.c)localObject).setCancelable(false);
    ((com.tencent.mm.ui.widget.a.c)localObject).setCanceledOnTouchOutside(false);
    ((com.tencent.mm.ui.widget.a.c)localObject).show();
    this.mha = true;
  }
  
  public static boolean c(Camera paramCamera)
  {
    if (paramCamera == null) {
      return false;
    }
    try
    {
      y.i("MicroMsg.MMSightCameraSetting", "safeSetPreviewFormat");
      Camera.Parameters localParameters = paramCamera.getParameters();
      List localList = localParameters.getSupportedPreviewFormats();
      if ((localList == null) || (!localList.contains(Integer.valueOf(17)))) {
        y.e("MicroMsg.MMSightCameraSetting", "not support YCbCr_420_SP");
      }
      localParameters.setPreviewFormat(17);
      paramCamera.setParameters(localParameters);
      return true;
    }
    catch (Exception paramCamera)
    {
      y.i("MicroMsg.MMSightCameraSetting", "setPreviewFormat Exception, %s, %s", new Object[] { Looper.myLooper(), paramCamera.getMessage() });
    }
    return false;
  }
  
  public static boolean d(Camera paramCamera)
  {
    if (paramCamera == null) {
      return false;
    }
    for (;;)
    {
      Camera.Parameters localParameters;
      List localList;
      try
      {
        localParameters = paramCamera.getParameters();
        localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          y.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
          paramCamera.setParameters(localParameters);
          return true;
        }
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          y.i("MicroMsg.MMSightCameraSetting", "support continuous video");
          localParameters.setFocusMode("continuous-video");
          continue;
        }
        if (localList == null) {
          break label154;
        }
      }
      catch (Exception paramCamera)
      {
        y.i("MicroMsg.MMSightCameraSetting", "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramCamera.getMessage() });
        return false;
      }
      if (localList.contains("auto"))
      {
        y.i("MicroMsg.MMSightCameraSetting", "support auto focus");
        localParameters.setFocusMode("auto");
      }
      else
      {
        label154:
        y.i("MicroMsg.MMSightCameraSetting", "not support continuous video or auto focus");
      }
    }
  }
  
  public static void e(Camera paramCamera)
  {
    try
    {
      Camera.Parameters localParameters = paramCamera.getParameters();
      if (localParameters.isZoomSupported()) {
        localParameters.setZoom(0);
      }
      paramCamera.setParameters(localParameters);
      return;
    }
    catch (Exception paramCamera)
    {
      y.e("MicroMsg.MMSightCamera", "safeResetZoom error: %s", new Object[] { paramCamera.getMessage() });
    }
  }
  
  public final int a(SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    long l = bk.UZ();
    this.mgO = false;
    y.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s", new Object[] { Boolean.valueOf(this.mgy), Looper.myLooper(), paramSurfaceTexture });
    if (this.mgy) {
      return 0;
    }
    if (paramSurfaceTexture == null) {
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    y.i("MicroMsg.MMSightCamera", "this texture %s", new Object[] { paramSurfaceTexture });
    for (;;)
    {
      try
      {
        a(this.dwJ, paramInt, paramFloat, paramBoolean);
        if (k.bjA().mjk == null) {
          break label615;
        }
        localInteger = Integer.valueOf(k.bjA().mjk.mfA);
        if (q.dyd.dws == 1)
        {
          str = "Range";
          if (q.dyd.dwt != 1) {
            break label632;
          }
          paramBoolean = true;
          if (q.dyd.dwu != 1) {
            break label638;
          }
          bool1 = true;
          if (q.dyd.dwv != 1) {
            break label644;
          }
          bool2 = true;
          if (q.dyd.dww != 1) {
            break label650;
          }
          bool3 = true;
          y.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((q.dyd.dws == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            b(this.dwJ, false);
            if ((q.dyd.dwt == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              c(this.dwJ);
            }
            if ((q.dyk.dyA != -1) && (q.dyk.dyA == 1) && (com.tencent.mm.compatible.util.d.gH(14))) {
              b(this.dwJ);
            }
            if ((q.dyd.dwv == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              d(this.dwJ);
            }
            if ((q.dyd.dww == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            e(this.dwJ);
            biK();
            this.dwJ.setPreviewTexture(paramSurfaceTexture);
            this.dwJ.startPreview();
            if (!j.mhB.mhN) {
              break label598;
            }
            if ((q.dyd.dwv == 0) && (this.aVT != null) && (this.mgB != null)) {
              this.aVT.registerListener(this, this.mgB, 2);
            }
            this.mgy = true;
            y.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(bk.cp(l)), Looper.myLooper() });
            return 0;
          }
        }
        else
        {
          if (q.dyd.dwr != 1) {
            break label624;
          }
          str = "Fix";
          continue;
        }
        if ((q.dyd.dwr != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        b(this.dwJ, true);
        continue;
        this.aVT.registerListener(this, this.mgB, 2);
      }
      catch (Exception paramSurfaceTexture)
      {
        y.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        return 0 - com.tencent.mm.compatible.util.g.getLine();
      }
      label598:
      continue;
      label615:
      Integer localInteger = Integer.valueOf(0);
      continue;
      label624:
      String str = "Error";
      continue;
      label632:
      paramBoolean = false;
      continue;
      label638:
      boolean bool1 = false;
      continue;
      label644:
      boolean bool2 = false;
      continue;
      label650:
      boolean bool3 = false;
    }
  }
  
  @TargetApi(11)
  public final int a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    long l = bk.UZ();
    this.mgO = false;
    y.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", new Object[] { Boolean.valueOf(this.mgy), Looper.myLooper(), paramSurfaceTexture, Boolean.valueOf(paramBoolean) });
    if (this.mgy) {
      return 0;
    }
    if (paramSurfaceTexture == null) {
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    y.i("MicroMsg.MMSightCamera", "this texture %s", new Object[] { paramSurfaceTexture });
    for (;;)
    {
      try
      {
        a(this.dwJ, paramBoolean);
        if (k.bjA().mjk == null) {
          break label615;
        }
        localInteger = Integer.valueOf(k.bjA().mjk.mfA);
        if (q.dyd.dws == 1)
        {
          str = "Range";
          if (q.dyd.dwt != 1) {
            break label632;
          }
          paramBoolean = true;
          if (q.dyd.dwu != 1) {
            break label637;
          }
          bool1 = true;
          if (q.dyd.dwv != 1) {
            break label642;
          }
          bool2 = true;
          if (q.dyd.dww != 1) {
            break label648;
          }
          bool3 = true;
          y.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((q.dyd.dws == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            b(this.dwJ, false);
            if ((q.dyd.dwt == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              c(this.dwJ);
            }
            if ((q.dyk.dyA != -1) && (q.dyk.dyA == 1) && (com.tencent.mm.compatible.util.d.gH(14))) {
              b(this.dwJ);
            }
            if ((q.dyd.dwv == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              d(this.dwJ);
            }
            if ((q.dyd.dww == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            e(this.dwJ);
            biK();
            this.dwJ.setPreviewTexture(paramSurfaceTexture);
            this.dwJ.startPreview();
            if (!j.mhB.mhN) {
              break label598;
            }
            if ((q.dyd.dwv == 0) && (this.aVT != null) && (this.mgB != null)) {
              this.aVT.registerListener(this, this.mgB, 2);
            }
            this.mgy = true;
            y.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(bk.cp(l)), Looper.myLooper() });
            return 0;
          }
        }
        else
        {
          if (q.dyd.dwr != 1) {
            break label624;
          }
          str = "Fix";
          continue;
        }
        if ((q.dyd.dwr != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        b(this.dwJ, true);
        continue;
        this.aVT.registerListener(this, this.mgB, 2);
      }
      catch (Exception paramSurfaceTexture)
      {
        y.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        return 0 - com.tencent.mm.compatible.util.g.getLine();
      }
      label598:
      continue;
      label615:
      Integer localInteger = Integer.valueOf(0);
      continue;
      label624:
      String str = "Error";
      continue;
      label632:
      paramBoolean = false;
      continue;
      label637:
      boolean bool1 = false;
      continue;
      label642:
      boolean bool2 = false;
      continue;
      label648:
      boolean bool3 = false;
    }
  }
  
  public final void a(a parama)
  {
    this.mgP = parama;
    String str1;
    String str2;
    com.tencent.mm.plugin.base.model.a locala;
    if (parama == a.mhi)
    {
      parama = a.biE();
      str1 = this.mgR.biG();
      str2 = this.mgQ.biG();
      locala = this.mgL;
      if (locala.hRH != 0) {
        break label82;
      }
    }
    label82:
    for (int i = 0;; i = locala.hRG / locala.hRH)
    {
      parama.mgb = ((int)(bk.ZT(str1) * 10.0D));
      parama.mgc = ((int)(bk.ZT(str2) * 10.0D));
      parama.mgi = i;
      return;
    }
  }
  
  public final void a(e.b paramb, boolean paramBoolean, int paramInt)
  {
    y.i("MicroMsg.MMSightCamera", "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s", new Object[] { paramb, this.mgX, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.mgX != null) {}
    try
    {
      this.mgY = true;
      Point localPoint = new Point();
      if (this.mgH != null) {
        localPoint.x = this.mgH.x;
      }
      for (localPoint.y = this.mgH.y;; localPoint.y = this.mgG.y)
      {
        byte[] arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.j.mji.f(Integer.valueOf(this.mgX.length));
        System.arraycopy(this.mgX, 0, arrayOfByte, 0, this.mgX.length);
        int i = this.jXx.rotate;
        paramb.a(arrayOfByte, localPoint.x, localPoint.y, i, paramInt);
        return;
        if ((this.mgJ == null) || (!this.mgK)) {
          break;
        }
        localPoint.x = this.mgG.x;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.MMSightCamera", "takePicture error: %s", new Object[] { localException.getMessage() });
        this.mgY = false;
        paramb.a(null, 0, 0, -1, 0);
        return;
        localException.x = this.mgw.jSV;
        localException.y = this.mgw.jSW;
      }
    }
    finally
    {
      this.mgY = false;
    }
  }
  
  public final void a(f paramf)
  {
    if (paramf != null) {
      this.mgN.add(paramf);
    }
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    y.i("MicroMsg.MMSightCamera", "switch camera with limit, current useBack: %s", new Object[] { Boolean.valueOf(this.mhe) });
    try
    {
      biI();
      if (!this.mhe) {}
      for (boolean bool = true;; bool = false)
      {
        r(paramContext, bool);
        a(paramSurfaceTexture, paramInt, paramFloat, paramBoolean);
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[] { paramContext });
    }
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    y.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", new Object[] { Boolean.valueOf(this.mhe) });
    try
    {
      biI();
      if (!this.mhe) {}
      for (boolean bool = true;; bool = false)
      {
        r(paramContext, bool);
        a(paramSurfaceTexture, paramBoolean);
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[] { paramContext });
    }
  }
  
  public final void aJP()
  {
    this.mhd.removeMessages(4354);
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (com.tencent.mm.compatible.util.d.gG(14)) {
      return;
    }
    this.mhd.removeMessages(4354);
    this.mhd.mhn = paramFloat1;
    this.mhd.lvi = paramFloat2;
    this.mhd.mho = paramInt1;
    this.mhd.mhp = paramInt2;
    this.mhd.sendMessageDelayed(this.mhd.obtainMessage(4354, this.dwJ), 400L);
  }
  
  public final void b(f paramf)
  {
    if (paramf != null) {
      this.mgN.remove(paramf);
    }
  }
  
  public final void biJ()
  {
    y.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode");
    if ((this.dwJ != null) && (this.mgy)) {}
    try
    {
      Camera.Parameters localParameters = this.dwJ.getParameters();
      List localList = localParameters.getSupportedFocusModes();
      if ((localList != null) && (localList.contains("continuous-picture")))
      {
        y.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
        localParameters.setFocusMode("continuous-picture");
      }
      this.dwJ.setParameters(localParameters);
      return;
    }
    catch (Exception localException)
    {
      y.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  public final void biK()
  {
    if (this.dwJ != null) {}
    try
    {
      Object localObject = this.dwJ.getParameters();
      y.i("MicroMsg.MMSightCamera", "setPreviewCallbackImpl");
      int i = this.mgw.jSV;
      int j = this.mgw.jSW;
      j = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject).getPreviewFormat()) * (i * j) / 8;
      i = 0;
      while (i < 5)
      {
        localObject = com.tencent.mm.plugin.mmsight.model.a.j.mji.f(Integer.valueOf(j));
        this.dwJ.addCallbackBuffer((byte[])localObject);
        i += 1;
      }
      this.mgQ.reset();
      this.mgR.reset();
      this.mgS.reset();
      this.mgT.reset();
      this.mgU.reset();
      this.mgV.reset();
      this.mgL = new com.tencent.mm.plugin.base.model.a();
      this.dwJ.setPreviewCallbackWithBuffer(new e.1(this));
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMSightCamera", "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  /* Error */
  public final String biM()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 99	com/tencent/mm/plugin/mmsight/model/e:dwJ	Landroid/hardware/Camera;
    //   4: ifnonnull +7 -> 11
    //   7: ldc_w 1040
    //   10: areturn
    //   11: new 1042	java/lang/StringBuffer
    //   14: dup
    //   15: invokespecial 1043	java/lang/StringBuffer:<init>	()V
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 99	com/tencent/mm/plugin/mmsight/model/e:dwJ	Landroid/hardware/Camera;
    //   23: invokevirtual 221	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   26: invokestatic 1046	com/tencent/mm/plugin/mmsight/d:b	(Landroid/hardware/Camera$Parameters;)Ljava/util/ArrayList;
    //   29: astore_2
    //   30: aload_0
    //   31: getfield 111	com/tencent/mm/plugin/mmsight/model/e:mContext	Landroid/content/Context;
    //   34: invokestatic 376	com/tencent/mm/plugin/mmsight/d:dL	(Landroid/content/Context;)Landroid/graphics/Point;
    //   37: astore_3
    //   38: aload_1
    //   39: ldc_w 1048
    //   42: iconst_3
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_3
    //   49: getfield 241	android/graphics/Point:x	I
    //   52: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: aload_3
    //   59: getfield 244	android/graphics/Point:y	I
    //   62: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aastore
    //   66: dup
    //   67: iconst_2
    //   68: aload_3
    //   69: getfield 241	android/graphics/Point:x	I
    //   72: i2d
    //   73: dconst_1
    //   74: dmul
    //   75: aload_3
    //   76: getfield 244	android/graphics/Point:y	I
    //   79: i2d
    //   80: ddiv
    //   81: invokestatic 1053	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   84: aastore
    //   85: invokestatic 1057	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokevirtual 1061	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   91: pop
    //   92: aload_2
    //   93: invokevirtual 1062	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   96: astore_2
    //   97: aload_2
    //   98: invokeinterface 532 1 0
    //   103: ifeq +193 -> 296
    //   106: aload_2
    //   107: invokeinterface 536 1 0
    //   112: checkcast 1064	android/hardware/Camera$Size
    //   115: astore_3
    //   116: aload_0
    //   117: invokevirtual 1067	com/tencent/mm/plugin/mmsight/model/e:getPreviewWidth	()I
    //   120: aload_3
    //   121: getfield 1068	android/hardware/Camera$Size:width	I
    //   124: if_icmpne +14 -> 138
    //   127: aload_0
    //   128: invokevirtual 1071	com/tencent/mm/plugin/mmsight/model/e:getPreviewHeight	()I
    //   131: aload_3
    //   132: getfield 1072	android/hardware/Camera$Size:height	I
    //   135: if_icmpeq +25 -> 160
    //   138: aload_0
    //   139: invokevirtual 1067	com/tencent/mm/plugin/mmsight/model/e:getPreviewWidth	()I
    //   142: aload_3
    //   143: getfield 1072	android/hardware/Camera$Size:height	I
    //   146: if_icmpne +93 -> 239
    //   149: aload_0
    //   150: invokevirtual 1071	com/tencent/mm/plugin/mmsight/model/e:getPreviewHeight	()I
    //   153: aload_3
    //   154: getfield 1068	android/hardware/Camera$Size:width	I
    //   157: if_icmpne +82 -> 239
    //   160: aload_1
    //   161: ldc_w 1074
    //   164: iconst_3
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload_3
    //   171: getfield 1068	android/hardware/Camera$Size:width	I
    //   174: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: aastore
    //   178: dup
    //   179: iconst_1
    //   180: aload_3
    //   181: getfield 1072	android/hardware/Camera$Size:height	I
    //   184: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: aastore
    //   188: dup
    //   189: iconst_2
    //   190: aload_3
    //   191: getfield 1072	android/hardware/Camera$Size:height	I
    //   194: i2d
    //   195: dconst_1
    //   196: dmul
    //   197: aload_3
    //   198: getfield 1068	android/hardware/Camera$Size:width	I
    //   201: i2d
    //   202: ddiv
    //   203: invokestatic 1053	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   206: aastore
    //   207: invokestatic 1057	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   210: invokevirtual 1061	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   213: pop
    //   214: goto -117 -> 97
    //   217: astore_1
    //   218: ldc 255
    //   220: ldc_w 1076
    //   223: iconst_1
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_1
    //   230: invokevirtual 366	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   233: aastore
    //   234: invokestatic 368	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: aconst_null
    //   238: areturn
    //   239: aload_1
    //   240: ldc_w 1078
    //   243: iconst_3
    //   244: anewarray 4	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: aload_3
    //   250: getfield 1068	android/hardware/Camera$Size:width	I
    //   253: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: aload_3
    //   260: getfield 1072	android/hardware/Camera$Size:height	I
    //   263: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   266: aastore
    //   267: dup
    //   268: iconst_2
    //   269: aload_3
    //   270: getfield 1072	android/hardware/Camera$Size:height	I
    //   273: i2d
    //   274: dconst_1
    //   275: dmul
    //   276: aload_3
    //   277: getfield 1068	android/hardware/Camera$Size:width	I
    //   280: i2d
    //   281: ddiv
    //   282: invokestatic 1053	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   285: aastore
    //   286: invokestatic 1057	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   289: invokevirtual 1061	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   292: pop
    //   293: goto -196 -> 97
    //   296: aload_0
    //   297: getfield 117	com/tencent/mm/plugin/mmsight/model/e:mgH	Landroid/graphics/Point;
    //   300: ifnull +136 -> 436
    //   303: aload_1
    //   304: new 1080	java/lang/StringBuilder
    //   307: dup
    //   308: ldc_w 1082
    //   311: invokespecial 1083	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: aload_0
    //   315: getfield 117	com/tencent/mm/plugin/mmsight/model/e:mgH	Landroid/graphics/Point;
    //   318: getfield 241	android/graphics/Point:x	I
    //   321: invokevirtual 1086	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: ldc_w 1088
    //   327: invokevirtual 1091	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_0
    //   331: getfield 117	com/tencent/mm/plugin/mmsight/model/e:mgH	Landroid/graphics/Point;
    //   334: getfield 244	android/graphics/Point:y	I
    //   337: invokevirtual 1086	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: ldc_w 1093
    //   343: invokevirtual 1091	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload_0
    //   347: getfield 207	com/tencent/mm/plugin/mmsight/model/e:mgw	Lcom/tencent/mm/plugin/mmsight/model/p;
    //   350: getfield 307	com/tencent/mm/plugin/mmsight/model/p:jSV	I
    //   353: invokevirtual 1086	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: ldc_w 1088
    //   359: invokevirtual 1091	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_0
    //   363: getfield 207	com/tencent/mm/plugin/mmsight/model/e:mgw	Lcom/tencent/mm/plugin/mmsight/model/p;
    //   366: getfield 310	com/tencent/mm/plugin/mmsight/model/p:jSW	I
    //   369: invokevirtual 1086	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   372: invokevirtual 1096	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokevirtual 1061	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   378: pop
    //   379: aload_1
    //   380: new 1080	java/lang/StringBuilder
    //   383: dup
    //   384: ldc_w 1098
    //   387: invokespecial 1083	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: aload_0
    //   391: invokevirtual 1101	com/tencent/mm/plugin/mmsight/model/e:getOrientation	()I
    //   394: invokevirtual 1086	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: invokevirtual 1096	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokevirtual 1061	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   403: pop
    //   404: aload_1
    //   405: new 1080	java/lang/StringBuilder
    //   408: dup
    //   409: ldc_w 1103
    //   412: invokespecial 1083	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   415: getstatic 853	com/tencent/mm/compatible/e/q:dyk	Lcom/tencent/mm/compatible/e/t;
    //   418: getfield 1106	com/tencent/mm/compatible/e/t:dyz	I
    //   421: invokevirtual 1086	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   424: invokevirtual 1096	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokevirtual 1061	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   430: pop
    //   431: aload_1
    //   432: invokevirtual 1107	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   435: areturn
    //   436: aload_1
    //   437: new 1080	java/lang/StringBuilder
    //   440: dup
    //   441: ldc_w 1109
    //   444: invokespecial 1083	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   447: aload_0
    //   448: invokevirtual 1067	com/tencent/mm/plugin/mmsight/model/e:getPreviewWidth	()I
    //   451: invokevirtual 1086	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   454: ldc_w 1088
    //   457: invokevirtual 1091	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload_0
    //   461: invokevirtual 1071	com/tencent/mm/plugin/mmsight/model/e:getPreviewHeight	()I
    //   464: invokevirtual 1086	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   467: invokevirtual 1096	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokevirtual 1061	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   473: pop
    //   474: goto -95 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	477	0	this	e
    //   18	143	1	localStringBuffer	java.lang.StringBuffer
    //   217	220	1	localException	Exception
    //   29	78	2	localObject1	Object
    //   37	240	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	97	217	java/lang/Exception
    //   97	138	217	java/lang/Exception
    //   138	160	217	java/lang/Exception
    //   160	214	217	java/lang/Exception
    //   239	293	217	java/lang/Exception
    //   296	379	217	java/lang/Exception
    //   379	436	217	java/lang/Exception
    //   436	474	217	java/lang/Exception
  }
  
  public final int biN()
  {
    biI();
    return 0;
  }
  
  public final void biO()
  {
    y.i("MicroMsg.MMSightCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[] { this.dwJ, Boolean.valueOf(this.mgy) });
    if ((this.dwJ != null) && (this.mgy)) {
      try
      {
        this.mgM = true;
        Camera.Parameters localParameters = this.dwJ.getParameters();
        if ((!bk.dk(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("torch")))
        {
          localParameters.setFlashMode("torch");
          this.dwJ.setParameters(localParameters);
          y.i("MicroMsg.MMSightCamera", "open flash");
          return;
        }
        y.i("MicroMsg.MMSightCamera", "camera not support flash!!");
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.MMSightCamera", localException, "openFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void biP()
  {
    y.i("MicroMsg.MMSightCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[] { this.dwJ, Boolean.valueOf(this.mgy) });
    if ((this.dwJ != null) && (this.mgy)) {
      try
      {
        this.mgM = false;
        Camera.Parameters localParameters = this.dwJ.getParameters();
        if ((!bk.dk(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("off")))
        {
          localParameters.setFlashMode("off");
          this.dwJ.setParameters(localParameters);
          y.i("MicroMsg.MMSightCamera", "close flash");
          return;
        }
        y.i("MicroMsg.MMSightCamera", "camera not support close flash!!");
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.MMSightCamera", localException, "closeFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void biQ()
  {
    y.i("MicroMsg.MMSightCamera", "autoFlash, camera: %s, isPreviewing: %s", new Object[] { this.dwJ, Boolean.valueOf(this.mgy) });
    if ((this.dwJ != null) && (this.mgy)) {
      try
      {
        this.mgM = true;
        Camera.Parameters localParameters = this.dwJ.getParameters();
        if ((!bk.dk(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("auto")))
        {
          localParameters.setFlashMode("auto");
          this.dwJ.setParameters(localParameters);
          y.i("MicroMsg.MMSightCamera", "auto flash");
          return;
        }
        y.i("MicroMsg.MMSightCamera", "camera not support auto flash!!");
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.MMSightCamera", localException, "autoFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final boolean biR()
  {
    return this.mgy;
  }
  
  public final boolean biS()
  {
    return this.mhe;
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((this.dwJ != null) && (this.mgy)) {}
    for (;;)
    {
      int m;
      int k;
      int j;
      try
      {
        y.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (this.apT)
        {
          y.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
          return;
        }
        Camera.Parameters localParameters = this.dwJ.getParameters();
        if (localParameters.isZoomSupported())
        {
          this.apT = true;
          m = localParameters.getZoom();
          k = localParameters.getMaxZoom();
          if (!paramBoolean2)
          {
            if (this.mgu <= 0)
            {
              this.mgu = Math.round(k / 15.0F);
              if (this.mgu > 5) {
                this.mgu = 5;
              }
            }
            i = this.mgu;
            y.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(this.mgu), Integer.valueOf(this.mgv), Integer.valueOf(paramInt) });
            j = i;
            if (paramInt > 0) {
              j = i * paramInt;
            }
            if (paramBoolean1) {
              if (m < k) {
                break label376;
              }
            }
          }
          else
          {
            if (this.mgv <= 0)
            {
              y.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", new Object[] { Integer.valueOf(this.mgv) });
              return;
            }
            i = this.mgv;
            continue;
            y.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", new Object[] { Integer.valueOf(paramInt) });
            localParameters.setZoom(paramInt);
            this.dwJ.setParameters(localParameters);
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
        continue;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.MMSightCamera", "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.apT = false;
      }
      label376:
      do
      {
        paramInt = j + m;
      } while (paramInt < k);
      paramInt = k;
    }
  }
  
  public final int getOrientation()
  {
    if ((this.jXx != null) && (this.mgy)) {
      return this.jXx.rotate;
    }
    return -1;
  }
  
  public final int getPreviewHeight()
  {
    if (this.dwJ == null) {}
    while (this.jXx == null) {
      return 0;
    }
    try
    {
      if ((this.mgK) && (this.mgJ != null))
      {
        if ((this.jXx.rotate == 0) || (this.jXx.rotate == 180)) {
          return this.mgG.y;
        }
        return this.mgG.x;
      }
      if (this.mgH == null)
      {
        if ((this.jXx.rotate == 0) || (this.jXx.rotate == 180)) {
          return this.mgw.jSW;
        }
        return this.mgw.jSV;
      }
      if ((this.jXx.rotate == 0) || (this.jXx.rotate == 180)) {
        return this.mgH.y;
      }
      int i = this.mgH.x;
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMSightCamera", "getPreviewHeight: %s", new Object[] { localException.getMessage() });
    }
    return 0;
  }
  
  public final int getPreviewWidth()
  {
    if (this.dwJ == null) {}
    while (this.jXx == null) {
      return 0;
    }
    try
    {
      if ((this.mgK) && (this.mgJ != null))
      {
        if ((this.jXx.rotate == 0) || (this.jXx.rotate == 180)) {
          return this.mgG.x;
        }
        return this.mgG.y;
      }
      if (this.mgH == null)
      {
        if ((this.jXx.rotate == 0) || (this.jXx.rotate == 180)) {
          return this.mgw.jSV;
        }
        return this.mgw.jSW;
      }
      if ((this.jXx.rotate == 0) || (this.jXx.rotate == 180)) {
        return this.mgH.x;
      }
      int i = this.mgH.y;
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMSightCamera", "getPreviewWidth: %s", new Object[] { localException.getMessage() });
    }
    return 0;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if ((Math.abs(this.mgC - f1) > 5.0F) || (Math.abs(this.mgD - f2) > 5.0F) || (Math.abs(this.mgE - f3) > 5.0F))
    {
      y.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", new Object[] { Float.valueOf(5.0F), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      this.mhd.f(this.dwJ);
      this.mgC = f1;
      this.mgD = f2;
      this.mgE = f3;
    }
  }
  
  public final boolean r(Context paramContext, boolean paramBoolean)
  {
    if ((!j.mhB.mhN) || ((q.dyd.dwv == 0) && (this.aVT == null) && (this.mgB == null)))
    {
      this.aVT = ((SensorManager)paramContext.getSystemService("sensor"));
      this.mgB = this.aVT.getDefaultSensor(1);
    }
    if (this.dwJ == null)
    {
      biI();
      this.mhe = paramBoolean;
      if (!paramBoolean) {}
    }
    for (;;)
    {
      try
      {
        this.mgz = com.tencent.mm.compatible.e.d.yM();
        y.i("MicroMsg.MMSightCamera", "use camera id %d, DeviceInfo id %d", new Object[] { Integer.valueOf(this.mgz), Integer.valueOf(q.dyd.dwy) });
        this.mha = false;
        this.mContext = paramContext;
        this.jXx = new n().u(paramContext, this.mgz);
        y.i("MicroMsg.MMSightCamera", "open camera end, %s", new Object[] { Looper.myLooper() });
        if (this.jXx == null)
        {
          y.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", new Object[] { Looper.myLooper() });
          biL();
          return false;
          int j = Camera.getNumberOfCameras();
          Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
          i = 0;
          if (i >= j) {
            break label387;
          }
          Camera.getCameraInfo(i, localCameraInfo);
          if (localCameraInfo.facing == 1)
          {
            y.d("MicroMsg.CameraUtil", "tigercam get fid %d", new Object[] { Integer.valueOf(i) });
            y.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[] { Integer.valueOf(i) });
            this.mgz = i;
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.MMSightCamera", localException, "try to get cameraid error %s, useBackCamera: %s", new Object[] { localException.getMessage(), Boolean.valueOf(this.mhe) });
        this.mgz = 0;
        continue;
        i += 1;
        continue;
        this.dwJ = this.jXx.dwJ;
        this.mhd.mhm = false;
        this.mgw.rotate = this.jXx.rotate;
        if (this.dwJ == null)
        {
          y.e("MicroMsg.MMSightCamera", "start camera FAILED!");
          biL();
          return false;
        }
      }
      return true;
      label387:
      int i = 0;
    }
  }
  
  public final void tY(int paramInt)
  {
    if (this.mgv > 0) {}
    for (;;)
    {
      return;
      Point localPoint = ak.gx(ae.getContext());
      int i = localPoint.y;
      y.i("MicroMsg.MMSightCamera", "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localPoint });
      if (i / 2 < paramInt) {
        try
        {
          if (this.dwJ != null)
          {
            i = this.dwJ.getParameters().getMaxZoom();
            this.mgv = ((int)(i / (paramInt / 3.0D / 10.0D)) + 1);
            y.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.mgv), Integer.valueOf(i) });
            return;
          }
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.MMSightCamera", "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.e
 * JD-Core Version:    0.7.0.1
 */