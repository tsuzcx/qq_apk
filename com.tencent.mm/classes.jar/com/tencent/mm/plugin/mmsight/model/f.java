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
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.ot.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class f
  implements SensorEventListener
{
  protected static int vZI = 2147483647;
  static boolean waa = true;
  protected boolean aYh;
  protected v gaZ;
  protected boolean hrQ;
  protected q hrV;
  protected Size hrY;
  protected List<g> hsB;
  protected d.a.a hsD;
  protected Point hsE;
  protected int hsF;
  protected int hsG;
  private c hsH;
  private c hsI;
  private c hsJ;
  private c hsK;
  private c hsL;
  public volatile boolean hsM;
  public volatile byte[] hsN;
  protected boolean hsj;
  Camera.AutoFocusCallback hsq;
  protected Context mContext;
  protected SensorManager mSensorManager;
  private int scene;
  protected boolean vZG;
  protected int vZH;
  protected Sensor vZJ;
  protected float vZK;
  protected float vZL;
  protected float vZM;
  protected Point vZN;
  protected Point vZO;
  protected int vZP;
  protected byte[] vZQ;
  protected boolean vZR;
  protected com.tencent.mm.plugin.base.model.a vZS;
  protected boolean vZT;
  protected boolean vZU;
  private f.a vZV;
  private c vZW;
  protected VideoTransPara vZX;
  public boolean vZY;
  private boolean vZZ;
  public c wab;
  
  public f(VideoTransPara paramVideoTransPara, int paramInt)
  {
    AppMethodBeat.i(89371);
    this.hsG = -1;
    this.hsF = -1;
    this.hsj = false;
    this.aYh = false;
    this.gaZ = null;
    this.vZG = false;
    this.vZH = 0;
    this.vZK = 0.0F;
    this.vZL = 0.0F;
    this.vZM = 0.0F;
    this.mContext = null;
    this.vZN = null;
    this.vZO = null;
    this.hsE = null;
    this.vZP = 0;
    this.vZR = false;
    this.vZS = new com.tencent.mm.plugin.base.model.a();
    this.vZT = false;
    this.hsB = new ArrayList();
    this.vZU = false;
    this.hrY = null;
    this.vZV = f.a.wad;
    this.hsH = new c("prevcameraCallback");
    this.hsI = new c("cameraCallback");
    this.hsJ = new c("cameraPreviewCallback");
    this.hsK = new c("cameraCropCallback");
    this.vZW = new c("mirrorCameraCallback");
    this.hsL = new c("finishCallbackTimeCallback");
    this.scene = 0;
    this.hsN = null;
    this.hsM = false;
    this.vZY = false;
    this.vZZ = false;
    this.hsq = new f.2(this);
    this.wab = new c(Looper.getMainLooper());
    this.hrQ = true;
    this.hrV = q.dqd();
    this.vZX = paramVideoTransPara;
    this.scene = paramInt;
    AppMethodBeat.o(89371);
  }
  
  private static boolean a(v paramv)
  {
    AppMethodBeat.i(89381);
    if (paramv == null)
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
        localParameters = paramv.getParameters();
        localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
          paramv.setParameters(localParameters);
          AppMethodBeat.o(89381);
          return true;
        }
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "support continuous video");
          localParameters.setFocusMode("continuous-video");
          continue;
        }
        if (localList == null) {
          break label167;
        }
      }
      catch (Exception paramv)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
        AppMethodBeat.o(89381);
        return false;
      }
      if (localList.contains("auto"))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "support auto focus");
        localParameters.setFocusMode("auto");
      }
      else
      {
        label167:
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "not support continuous video or auto focus");
      }
    }
  }
  
  private boolean a(v paramv, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(89377);
    if ((paramv == null) || (paramInt <= 0))
    {
      AppMethodBeat.o(89377);
      return false;
    }
    for (;;)
    {
      float f2;
      try
      {
        Camera.Parameters localParameters = paramv.getParameters();
        new Point(paramInt, (int)(paramInt / paramFloat));
        Object localObject;
        if (this.hrY == null)
        {
          localObject = al.ck(ak.getContext());
          Point localPoint = new Point(Math.min(((Point)localObject).x, ((Point)localObject).y), Math.max(((Point)localObject).x, ((Point)localObject).y));
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "screenSize: %s, currentScreenSize: %s", new Object[] { localPoint, localObject });
          float f1 = Math.min(localPoint.x, localPoint.y) / Math.max(localPoint.x, localPoint.y);
          f2 = 1.0F / paramFloat;
          if (paramFloat >= 1.0F) {
            break label709;
          }
          i = paramInt;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[] { Integer.valueOf(i), Float.valueOf(paramFloat), Float.valueOf(f1) });
          if (this.hsD.dHi == 90) {
            break label756;
          }
          if (this.hsD.dHi != 270) {
            break label768;
          }
          break label756;
          h.c localc = h.a(localParameters, localPoint, i, bool);
          if (localc != null)
          {
            localObject = localc;
            if (localc.wah != null) {}
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
            if (this.hsD.dHi == 90) {
              break label762;
            }
            if (this.hsD.dHi != 270) {
              break label774;
            }
            break label762;
            localObject = h.d(localParameters, localPoint, paramInt, bool);
            this.vZY = false;
          }
          if ((localObject != null) && (((h.c)localObject).wah != null))
          {
            paramInt = (int)(((h.c)localObject).wah.x * paramFloat);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio result preview size: %s, cropHeight: %s", new Object[] { ((h.c)localObject).wah, Integer.valueOf(paramInt) });
            if (paramInt > ((h.c)localObject).wah.y) {
              break label726;
            }
            this.vZY = false;
          }
          if ((localObject != null) && (((h.c)localObject).wah != null))
          {
            localObject = ((h.c)localObject).wah;
            this.hrV.ruC = ((Point)localObject).x;
            this.hrV.ruD = ((Point)localObject).y;
            this.vZO = ((Point)localObject);
            this.hsE = null;
            if (!paramBoolean)
            {
              if ((k.wat.gdr != 2) || (com.tencent.mm.plugin.mmsight.d.KH(this.vZO.y))) {
                break label745;
              }
              paramInt = com.tencent.mm.plugin.mmsight.d.KI(this.vZO.y);
              if (Math.abs(paramInt - this.vZO.y) > 16) {
                break label734;
              }
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.vZO, Integer.valueOf(paramInt) });
              this.vZN = new Point(this.vZO.x, this.vZO.y);
              this.vZO.y = paramInt;
              this.vZR = true;
              this.vZQ = new byte[this.vZO.x * this.vZO.y * 3 / 2];
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s, cropWidth: %s", new Object[] { localObject, this.vZO, this.hsE, Boolean.valueOf(this.vZY) });
            localParameters.setPreviewSize(this.hrV.ruC, this.hrV.ruD);
            paramv.setParameters(localParameters);
            AppMethodBeat.o(89377);
            return true;
          }
        }
        else
        {
          localObject = new Point(this.hrY.getWidth(), this.hrY.getHeight());
          continue;
        }
        f2 = paramInt / f2;
      }
      catch (Exception paramv)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimit error: %s", new Object[] { paramv.getMessage() });
        AppMethodBeat.o(89377);
        return false;
      }
      label709:
      int i = Math.round(f2);
      continue;
      label726:
      this.vZY = true;
      continue;
      label734:
      k.h(this.vZO);
      continue;
      label745:
      k.h(this.vZO);
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
  
  private static boolean a(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(89379);
    if (paramv == null)
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
          localParameters = paramv.getParameters();
          if (!paramBoolean) {
            break label235;
          }
          if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaz > 0)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview frame rate");
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), localParameters.getSupportedPreviewFrameRates() });
            paramv.setParameters(localParameters);
            AppMethodBeat.o(89379);
            return true;
          }
          if (localParameters == null)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "trySetPreviewFrameRateParameters error, p is null!");
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
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "set preview frame rate %d", new Object[] { Integer.valueOf(i) });
          }
          catch (Exception localException1)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException1.getMessage() });
          }
        }
        catch (Exception paramv)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
          AppMethodBeat.o(89379);
          return false;
        }
        continue;
        if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaz <= 0) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview fps range");
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
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4) });
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(30) });
        if ((j == 2147483647) || (i == 2147483647)) {
          break;
        }
        try
        {
          localParameters.setPreviewFpsRange(j, i);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        }
        catch (Exception localException2)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException2.getMessage() });
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
  
  private void awC()
  {
    AppMethodBeat.i(89384);
    if (this.gaZ != null) {
      try
      {
        Object localObject = this.gaZ.getParameters();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "setPreviewCallbackImpl");
        int i = this.hrV.ruC;
        int j = this.hrV.ruD;
        j = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject).getPreviewFormat()) * (i * j) / 8;
        i = 0;
        while (i < 5)
        {
          localObject = com.tencent.mm.plugin.mmsight.model.a.k.wcg.h(Integer.valueOf(j));
          this.gaZ.addCallbackBuffer((byte[])localObject);
          i += 1;
        }
        this.hsH.reset();
        this.hsI.reset();
        this.hsJ.reset();
        this.hsK.reset();
        this.vZW.reset();
        this.hsL.reset();
        this.vZS = new com.tencent.mm.plugin.base.model.a();
        this.gaZ.setPreviewCallbackWithBuffer(new Camera.PreviewCallback()
        {
          public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
          {
            AppMethodBeat.i(89361);
            if (!f.this.vZU)
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "onPreviewFrame: %s %s", new Object[] { paramAnonymousArrayOfByte, f.this.gaZ });
              f.this.vZU = true;
            }
            if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "onPreviewFrame, frame data is null!!");
              AppMethodBeat.o(89361);
              return;
            }
            paramAnonymousCamera = f.this.vZS;
            if (paramAnonymousCamera.nSp == 0)
            {
              paramAnonymousCamera.nSo += 1;
              paramAnonymousCamera.nSn = bu.aSB(m.aaq());
            }
            paramAnonymousCamera.nSp += 1;
            int i;
            long l1;
            byte[] arrayOfByte;
            label367:
            long l2;
            int j;
            boolean bool;
            if (paramAnonymousCamera.nSp >= 90)
            {
              i = 0;
              paramAnonymousCamera.nSp = i;
              if ((f.a(f.this)) || (f.this.hsB == null) || (f.this.hsB.size() <= 0)) {
                break label944;
              }
              if (f.this.hsE == null) {
                break label584;
              }
              paramAnonymousCamera = com.tencent.mm.plugin.mmsight.model.a.k.wcg.h(Integer.valueOf(f.this.hrV.ruC * f.this.hsE.y * 3 / 2));
              f.b(f.this).yz(1L);
              l1 = bu.HQ();
              SightVideoJNI.cropCameraData(paramAnonymousArrayOfByte, paramAnonymousCamera, f.this.hrV.ruC, f.this.hrV.ruD, f.this.hsE.y);
              if (f.this.hsE.x >= f.this.hrV.ruC) {
                break label941;
              }
              arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.k.wcg.h(Integer.valueOf(f.this.hsE.x * f.this.hsE.y * 3 / 2));
              SightVideoJNI.cropCameraDataLongEdge(paramAnonymousCamera, arrayOfByte, f.this.hrV.ruC, f.this.hsE.x, f.this.hsE.y);
              com.tencent.mm.plugin.mmsight.model.a.k.wcg.k(paramAnonymousCamera);
              paramAnonymousCamera = arrayOfByte;
              l2 = bu.aO(l1);
              f.c(f.this).yz(l2);
              if (!f.this.hrQ)
              {
                l1 = bu.HQ();
                i = f.this.hsE.x;
                j = f.this.hsE.y;
                if ((f.this.hsD.dHi != 270) && (f.this.hsD.dHi != 90)) {
                  break label578;
                }
                bool = true;
                label458:
                SightVideoJNI.mirrorCameraData(paramAnonymousCamera, i, j, bool);
                l2 = bu.aO(l1);
                f.d(f.this).yz(l2);
              }
              bool = f.a(f.this, paramAnonymousCamera);
              l1 = bu.aO(l1);
              if (bool) {
                f.e(f.this).yz(l1);
              }
            }
            for (;;)
            {
              f.b(f.this, paramAnonymousCamera);
              if (f.f(f.this) == f.a.wad) {
                f.g(f.this).yz(1L);
              }
              for (;;)
              {
                f.this.gaZ.addCallbackBuffer(paramAnonymousArrayOfByte);
                AppMethodBeat.o(89361);
                return;
                i = paramAnonymousCamera.nSp;
                break;
                label578:
                bool = false;
                break label458;
                label584:
                l1 = bu.HQ();
                label656:
                label753:
                f localf;
                if (!f.this.hrQ)
                {
                  i = f.this.hrV.ruC;
                  j = f.this.hrV.ruD;
                  if ((f.this.hsD.dHi == 270) || (f.this.hsD.dHi == 90))
                  {
                    bool = true;
                    SightVideoJNI.mirrorCameraData(paramAnonymousArrayOfByte, i, j, bool);
                    l2 = bu.aO(l1);
                    f.d(f.this).yz(l2);
                  }
                }
                else
                {
                  if ((!f.this.vZR) || (f.this.vZQ == null)) {
                    break label898;
                  }
                  SightVideoJNI.paddingYuvData16(paramAnonymousArrayOfByte, f.this.vZQ, f.this.vZO.x, f.this.vZN.y, f.this.vZO.y);
                  paramAnonymousCamera = f.this.vZQ;
                  bool = f.a(f.this, paramAnonymousCamera);
                  l1 = bu.aO(l1);
                  if (bool) {
                    f.e(f.this).yz(l1);
                  }
                  if (f.this.vZR)
                  {
                    arrayOfByte = paramAnonymousArrayOfByte;
                    if (f.this.vZQ != null) {}
                  }
                  else
                  {
                    arrayOfByte = paramAnonymousArrayOfByte;
                    if (bool) {
                      arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.k.wcg.h(Integer.valueOf(paramAnonymousArrayOfByte.length));
                    }
                  }
                  if ((f.this.vZR) && (f.this.vZQ != null))
                  {
                    localf = f.this;
                    if (!bool) {
                      break label903;
                    }
                  }
                }
                label898:
                label903:
                for (paramAnonymousArrayOfByte = com.tencent.mm.plugin.mmsight.model.a.k.wcg.h(Integer.valueOf(f.this.vZQ.length));; paramAnonymousArrayOfByte = f.this.vZQ)
                {
                  localf.vZQ = paramAnonymousArrayOfByte;
                  paramAnonymousArrayOfByte = arrayOfByte;
                  break;
                  bool = false;
                  break label656;
                  paramAnonymousCamera = paramAnonymousArrayOfByte;
                  break label753;
                }
                if (f.f(f.this) == f.a.wae) {
                  f.h(f.this).yz(1L);
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
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89384);
  }
  
  private void awn()
  {
    AppMethodBeat.i(89388);
    if (true == this.vZZ)
    {
      AppMethodBeat.o(89388);
      return;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(89388);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.d.b.abk()))
    {
      AppMethodBeat.o(89388);
      return;
    }
    Object localObject = new ot();
    ((ot)localObject).dDO.type = 2;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    if (((ot)localObject).dDP.dDN)
    {
      this.vZZ = true;
      AppMethodBeat.o(89388);
      return;
    }
    localObject = com.tencent.mm.ui.base.h.l(this.mContext, 2131763668, 2131755906);
    if (localObject != null)
    {
      ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
      ((com.tencent.mm.ui.widget.a.d)localObject).setCanceledOnTouchOutside(false);
      ((com.tencent.mm.ui.widget.a.d)localObject).show();
      this.vZZ = true;
    }
    AppMethodBeat.o(89388);
  }
  
  private static boolean b(v paramv)
  {
    AppMethodBeat.i(89380);
    if (paramv == null)
    {
      AppMethodBeat.o(89380);
      return false;
    }
    try
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "safeSetPreviewFormat");
      Camera.Parameters localParameters = paramv.getParameters();
      List localList = localParameters.getSupportedPreviewFormats();
      if ((localList == null) || (!localList.contains(Integer.valueOf(17)))) {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCameraSetting", "not support YCbCr_420_SP");
      }
      localParameters.setPreviewFormat(17);
      paramv.setParameters(localParameters);
      AppMethodBeat.o(89380);
      return true;
    }
    catch (Exception paramv)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "setPreviewFormat Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
      AppMethodBeat.o(89380);
    }
    return false;
  }
  
  private boolean b(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(89376);
    if (paramv == null)
    {
      AppMethodBeat.o(89376);
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
        localParameters = paramv.getParameters();
        if (this.hrY == null)
        {
          localPoint = com.tencent.mm.plugin.mmsight.d.fS(this.mContext);
          if (this.hrQ)
          {
            localObject1 = b.dpE();
            localObject2 = localParameters.getSupportedPreviewSizes();
            localObject3 = localParameters.getSupportedPictureSizes();
            i = this.hsD.dHi;
            if (bu.isNullOrNil(((b)localObject1).vZf)) {
              ((b)localObject1).vZf = com.tencent.mm.plugin.mmsight.d.eC((List)localObject2);
            }
            if (bu.isNullOrNil(((b)localObject1).vZg)) {
              ((b)localObject1).vZg = com.tencent.mm.plugin.mmsight.d.eC((List)localObject3);
            }
            ((b)localObject1).dHi = i;
            ((b)localObject1).vZA = 1;
            if (paramBoolean)
            {
              if (this.hsD.dHi == 90) {
                break label2498;
              }
              if (this.hsD.dHi != 270) {
                break label501;
              }
              break label2498;
              k.a(localParameters, bool);
            }
            com.tencent.mm.plugin.mmsight.model.a.l.dqm();
            i = com.tencent.mm.plugin.mmsight.model.a.l.dqp();
            if (this.hsD.dHi == 90) {
              break label2504;
            }
            if (this.hsD.dHi != 270) {
              break label507;
            }
            break label2504;
            label206:
            localObject2 = h.a(localParameters, localPoint, i, bool);
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((h.c)localObject2).wah != null) {}
            }
            else
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
              localPoint = new Point(Math.min(localPoint.x, localPoint.y), Math.max(localPoint.x, localPoint.y));
              if (this.hsD.dHi == 90) {
                break label2510;
              }
              if (this.hsD.dHi != 270) {
                break label513;
              }
              break label2510;
              label308:
              localObject1 = h.d(localParameters, localPoint, 2100, bool);
              this.vZY = false;
            }
            k.a((h.c)localObject1);
            localPoint = ((h.c)localObject1).wah;
            if (localPoint != null) {
              break;
            }
            l.awQ();
            AppMethodBeat.o(89376);
            return false;
          }
        }
        else
        {
          localPoint = new Point(this.hrY.getWidth(), this.hrY.getHeight());
          continue;
        }
        localObject1 = b.dpE();
        localObject2 = localParameters.getSupportedPreviewSizes();
        localObject3 = localParameters.getSupportedPictureSizes();
        i = this.hsD.dHi;
        if (bu.isNullOrNil(((b)localObject1).vZh)) {
          ((b)localObject1).vZh = com.tencent.mm.plugin.mmsight.d.eC((List)localObject2);
        }
        if (bu.isNullOrNil(((b)localObject1).vZi)) {
          ((b)localObject1).vZi = com.tencent.mm.plugin.mmsight.d.eC((List)localObject3);
        }
        ((b)localObject1).dHi = i;
        ((b)localObject1).vZA = 2;
        continue;
        bool = false;
      }
      catch (Exception paramv)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
        AppMethodBeat.o(89376);
        return false;
      }
      label501:
      continue;
      label507:
      bool = false;
      continue;
      label513:
      bool = false;
    }
    this.hrV.ruC = localPoint.x;
    this.hrV.ruD = localPoint.y;
    this.vZO = localPoint;
    Object localObject2 = this.mContext;
    if (this.hsD.dHi != 90) {
      if (this.hsD.dHi == 270)
      {
        break label2516;
        label583:
        bool = com.tencent.mm.plugin.mmsight.d.a((Context)localObject2, localPoint, bool);
        i = 1;
        if ((this.hsD.dHi != 90) && (this.hsD.dHi != 270)) {
          break label1348;
        }
        if ((localPoint.y < this.vZX.width) || (localPoint.x < this.vZX.height))
        {
          i = 0;
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localPoint });
        }
        label673:
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label1434;
        }
        if (k.wat.gdr != 2) {
          break label1422;
        }
        this.hsE = ((h.c)localObject1).waj;
        if ((this.hsE.x < localPoint.x) || (this.hsE.y < localPoint.y))
        {
          if ((this.hsD.dHi != 90) && (this.hsD.dHi != 270)) {
            break label1402;
          }
          this.hsE.y = com.tencent.mm.plugin.mmsight.d.KJ(this.hsE.y);
        }
        label789:
        this.vZO = new Point(this.hsE.x, this.hsE.y);
        this.vZP = (this.hsE.x * this.hsE.y * 3 / 2);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", new Object[] { this.hsE });
      }
    }
    label856:
    label2522:
    for (;;)
    {
      int j;
      int k;
      if (k.wat.waG)
      {
        if ((this.hsD.dHi != 90) && (this.hsD.dHi != 270)) {
          break label2035;
        }
        if (i != 0)
        {
          if (k.wat.hrX != 1080) {
            break label1863;
          }
          if (this.hsE != null) {
            break label1811;
          }
          j = localPoint.x / 2;
          if (this.hsE != null) {
            break label1825;
          }
          i = localPoint.y / 2;
          if (this.hsE != null) {
            break label1839;
          }
          k = localPoint.x;
          k = com.tencent.mm.plugin.mmsight.d.gy(j, k);
          if (this.hsE != null) {
            break label1851;
          }
          j = localPoint.y;
          this.vZO = new Point(k, com.tencent.mm.plugin.mmsight.d.gy(i, j));
        }
      }
      label996:
      localObject1 = b.dpE();
      localObject2 = this.hsE;
      localObject3 = this.vZO;
      ((b)localObject1).vZo = -1;
      ((b)localObject1).vZn = -1;
      ((b)localObject1).vZk = -1;
      ((b)localObject1).vZj = -1;
      ((b)localObject1).vZm = -1;
      ((b)localObject1).vZl = -1;
      if (localPoint != null)
      {
        ((b)localObject1).vZl = localPoint.x;
        ((b)localObject1).vZm = localPoint.y;
      }
      if (localObject2 != null)
      {
        ((b)localObject1).vZj = ((Point)localObject2).x;
        ((b)localObject1).vZk = ((Point)localObject2).y;
      }
      if (localObject3 != null)
      {
        ((b)localObject1).vZn = ((Point)localObject3).x;
        ((b)localObject1).vZo = ((Point)localObject3).y;
      }
      if (paramBoolean) {
        if ((!bool) && (k.wat.gdr == 2) && (!com.tencent.mm.plugin.mmsight.d.KH(this.vZO.y)))
        {
          i = com.tencent.mm.plugin.mmsight.d.KI(this.vZO.y);
          if (Math.abs(i - this.vZO.y) <= 16)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.vZO, Integer.valueOf(i) });
            this.vZN = new Point(this.vZO.x, this.vZO.y);
            this.vZO.y = i;
            this.vZR = true;
            this.vZQ = new byte[this.vZO.x * this.vZO.y * 3 / 2];
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", new Object[] { localPoint, this.vZO, this.hsE });
        localParameters.setPreviewSize(this.hrV.ruC, this.hrV.ruD);
        paramv.setParameters(localParameters);
        AppMethodBeat.o(89376);
        return true;
        bool = false;
        break;
        if ((localPoint.x >= this.vZX.width) && (localPoint.y >= this.vZX.height)) {
          break label673;
        }
        i = 0;
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localPoint });
        break label673;
        label1402:
        this.hsE.x = com.tencent.mm.plugin.mmsight.d.KJ(this.hsE.x);
        break label789;
        this.hsE = ((h.c)localObject1).wai;
        break label789;
        if ((!k.wat.waG) || (k.wat.hrX != 1080) || (i == 0)) {
          break label2495;
        }
        if ((this.hsD.dHi == 90) || (this.hsD.dHi == 270))
        {
          j = localPoint.y / 2;
          k = com.tencent.mm.plugin.mmsight.d.KI(j);
          m = localPoint.x / 2;
          n = com.tencent.mm.plugin.mmsight.d.KI(m);
          if ((Math.abs(k - j) < 8) && (Math.abs(n - m) < 8)) {
            break label2522;
          }
          this.hsE = new Point(localPoint.x, localPoint.y);
          this.hsE.y = com.tencent.mm.plugin.mmsight.d.KJ(localPoint.y);
          this.hsE.x = com.tencent.mm.plugin.mmsight.d.KJ(localPoint.x);
          this.vZO = new Point(this.hsE.x, this.hsE.y);
          this.vZP = (this.hsE.x * this.hsE.y * 3 / 2);
          bool = true;
          break label2522;
        }
        j = localPoint.x / 2;
        k = com.tencent.mm.plugin.mmsight.d.KI(j);
        int m = localPoint.y / 2;
        int n = com.tencent.mm.plugin.mmsight.d.KI(m);
        if ((Math.abs(k - j) < 8) && (Math.abs(n - m) < 8)) {
          break label2495;
        }
        this.hsE = new Point(localPoint.x, localPoint.y);
        this.hsE.y = com.tencent.mm.plugin.mmsight.d.KJ(localPoint.x);
        this.hsE.x = com.tencent.mm.plugin.mmsight.d.KJ(localPoint.y);
        this.vZO = new Point(this.hsE.x, this.hsE.y);
        this.vZP = (this.hsE.x * this.hsE.y * 3 / 2);
        bool = true;
        break label856;
        j = this.hsE.x / 2;
        break label923;
        i = this.hsE.y / 2;
        break label939;
        k = this.hsE.x;
        break label953;
        j = this.hsE.y;
        break label976;
        if (k.wat.hrX != 720) {
          break label996;
        }
        float f;
        if (this.hsE == null)
        {
          f = localPoint.x * 0.75F;
          label1893:
          k = (int)f;
          if (this.hsE != null) {
            break label1995;
          }
          f = localPoint.y * 0.75F;
          label1915:
          j = (int)f;
          if (this.hsE != null) {
            break label2011;
          }
          i = localPoint.x;
          k = com.tencent.mm.plugin.mmsight.d.gy(k, i);
          if (this.hsE != null) {
            break label2023;
          }
        }
        label2011:
        label2023:
        for (i = localPoint.y;; i = this.hsE.y)
        {
          this.vZO = new Point(k, com.tencent.mm.plugin.mmsight.d.gy(j, i));
          break;
          f = this.hsE.x * 0.75F;
          break label1893;
          f = this.hsE.y * 0.75F;
          break label1915;
          i = this.hsE.x;
          break label1933;
        }
        label2035:
        if (i == 0) {
          break label996;
        }
        if (k.wat.hrX == 1080)
        {
          if (this.hsE == null)
          {
            j = localPoint.y / 2;
            if (this.hsE != null) {
              break label2158;
            }
            i = localPoint.x / 2;
            if (this.hsE != null) {
              break label2172;
            }
            k = localPoint.y;
            k = com.tencent.mm.plugin.mmsight.d.gy(j, k);
            if (this.hsE != null) {
              break label2184;
            }
          }
          for (j = localPoint.x;; j = this.hsE.x)
          {
            this.vZO = new Point(k, com.tencent.mm.plugin.mmsight.d.gy(i, j));
            break;
            j = this.hsE.y / 2;
            break label2068;
            label2158:
            i = this.hsE.x / 2;
            break label2084;
            label2172:
            k = this.hsE.y;
            break label2098;
          }
        }
        if (k.wat.hrX != 720) {
          break label996;
        }
        if (this.hsE == null)
        {
          f = localPoint.y * 0.75F;
          k = (int)f;
          if (this.hsE != null) {
            break label2328;
          }
          f = localPoint.x * 0.75F;
          j = (int)f;
          if (this.hsE != null) {
            break label2344;
          }
          i = localPoint.y;
          label2266:
          k = com.tencent.mm.plugin.mmsight.d.gy(k, i);
          if (this.hsE != null) {
            break label2356;
          }
        }
        for (i = localPoint.x;; i = this.hsE.x)
        {
          this.vZO = new Point(k, com.tencent.mm.plugin.mmsight.d.gy(j, i));
          break;
          f = this.hsE.y * 0.75F;
          break label2226;
          f = this.hsE.x * 0.75F;
          break label2248;
          i = this.hsE.y;
          break label2266;
        }
        k.h(this.vZO);
        continue;
        k.h(this.vZO);
        continue;
        if ((!bool) && (k.wat.gdr == 2) && (!com.tencent.mm.plugin.mmsight.d.KH(this.vZO.y)) && (this.vZR) && (this.vZQ != null) && (this.vZN.y == this.vZO.y))
        {
          i = com.tencent.mm.plugin.mmsight.d.KI(this.vZO.y);
          if (this.vZQ.length == this.vZO.x * i * 3 / 2) {
            this.vZO.y = i;
          }
        }
      }
      continue;
      bool = true;
      break;
      bool = true;
      break label206;
      bool = true;
      break label308;
      bool = true;
      break label583;
    }
  }
  
  @TargetApi(14)
  private static boolean c(v paramv)
  {
    AppMethodBeat.i(89378);
    if (paramv == null)
    {
      AppMethodBeat.o(89378);
      return false;
    }
    try
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "safeSetMetering");
      Camera.Parameters localParameters = paramv.getParameters();
      if (localParameters.getMaxNumMeteringAreas() > 0)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new Camera.Area(new Rect(-1000, -1000, 1000, 1000), 600));
        localParameters.setMeteringAreas(localArrayList);
      }
      paramv.setParameters(localParameters);
      AppMethodBeat.o(89378);
      return true;
    }
    catch (Exception paramv)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
      AppMethodBeat.o(89378);
    }
    return false;
  }
  
  private static void d(v paramv)
  {
    AppMethodBeat.i(89387);
    try
    {
      Camera.Parameters localParameters = paramv.getParameters();
      if (localParameters.isZoomSupported()) {
        localParameters.setZoom(0);
      }
      paramv.setParameters(localParameters);
      AppMethodBeat.o(89387);
      return;
    }
    catch (Exception paramv)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "safeResetZoom error: %s", new Object[] { paramv.getMessage() });
      AppMethodBeat.o(89387);
    }
  }
  
  private void dpI()
  {
    AppMethodBeat.i(89375);
    try
    {
      if ((this.mSensorManager != null) && (this.vZJ != null)) {
        this.mSensorManager.unregisterListener(this);
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", this.hsH.getValue());
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", this.hsI.getValue());
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", this.hsJ.getValue());
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", this.hsK.getValue());
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", this.vZW.getValue());
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", this.hsL.getValue());
      if (this.gaZ != null)
      {
        long l = bu.HQ();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "release camera beg, %s", new Object[] { Looper.myLooper() });
        this.wab.removeCallbacksAndMessages(null);
        this.wab.hsl = true;
        this.gaZ.setPreviewCallback(null);
        this.gaZ.stopPreview();
        this.gaZ.release();
        this.gaZ = null;
        this.vZG = false;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", new Object[] { Long.valueOf(bu.aO(l)), Looper.myLooper() });
      }
      this.hsj = false;
      this.vZK = 0.0F;
      this.vZL = 0.0F;
      this.vZM = 0.0F;
      waa = true;
      this.mContext = null;
      this.vZZ = false;
      this.vZO = null;
      this.hsE = null;
      this.hsN = null;
      this.vZU = false;
      AppMethodBeat.o(89375);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MMSightCamera", localException, "cameraRelease error", new Object[0]);
      AppMethodBeat.o(89375);
    }
  }
  
  public final boolean A(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(89398);
    if ((!k.wat.waH) || ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaH == 0) && (this.mSensorManager == null) && (this.vZJ == null)))
    {
      this.mSensorManager = ((SensorManager)ak.getContext().getSystemService("sensor"));
      this.vZJ = this.mSensorManager.getDefaultSensor(1);
    }
    if (this.gaZ == null)
    {
      dpI();
      this.hrQ = paramBoolean;
      if (paramBoolean) {}
      try
      {
        for (this.vZH = com.tencent.mm.compatible.deviceinfo.d.aah();; this.vZH = com.tencent.mm.compatible.deviceinfo.d.aai())
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "use camera id %d, SrvDeviceInfo id %d", new Object[] { Integer.valueOf(this.vZH), Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.geM.gaK) });
          this.vZZ = false;
          this.mContext = paramContext;
          this.hsD = new o().ae(paramContext, this.vZH);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "open camera end, %s", new Object[] { Looper.myLooper() });
          if (this.hsD != null) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", new Object[] { Looper.myLooper() });
          awn();
          AppMethodBeat.o(89398);
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MMSightCamera", localException, "try to get cameraid error %s, useBackCamera: %s", new Object[] { localException.getMessage(), Boolean.valueOf(this.hrQ) });
          this.vZH = 0;
        }
        this.gaZ = this.hsD.gaZ;
        this.wab.hsl = false;
        this.hrV.dHi = this.hsD.dHi;
        if (this.gaZ == null)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "start camera FAILED!");
          awn();
          AppMethodBeat.o(89398);
          return false;
        }
      }
    }
    AppMethodBeat.o(89398);
    return true;
  }
  
  public final void KL(int paramInt)
  {
    AppMethodBeat.i(89395);
    if (this.gaZ != null) {
      try
      {
        Camera.Parameters localParameters = this.gaZ.getParameters();
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
        if (this.aYh)
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMSightCamera", "setForceZoomTargetRatio, zooming, ignore");
          return;
        }
        this.aYh = true;
        localParameters.setZoom(paramInt);
        this.gaZ.setParameters(localParameters);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "getZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aYh = false;
        AppMethodBeat.o(89395);
      }
    }
    AppMethodBeat.o(89395);
  }
  
  public final int a(SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(89386);
    long l = bu.HQ();
    this.vZU = false;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s", new Object[] { Boolean.valueOf(this.vZG), Looper.myLooper(), paramSurfaceTexture });
    if (this.vZG)
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "this texture %s", new Object[] { paramSurfaceTexture });
    for (;;)
    {
      try
      {
        a(this.gaZ, paramInt, paramFloat, paramBoolean);
        if (com.tencent.mm.plugin.mmsight.model.a.l.dqm().wci == null) {
          break label654;
        }
        localInteger = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.l.dqm().wci.vYP);
        if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaE == 1)
        {
          str = "Range";
          if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaF != 1) {
            break label671;
          }
          paramBoolean = true;
          if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaG != 1) {
            break label677;
          }
          bool1 = true;
          if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaH != 1) {
            break label683;
          }
          bool2 = true;
          if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaI != 1) {
            break label689;
          }
          bool3 = true;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaE == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            a(this.gaZ, false);
            if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaF == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              b(this.gaZ);
            }
            if ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdz != -1) && (com.tencent.mm.compatible.deviceinfo.ae.geT.gdz == 1) && (com.tencent.mm.compatible.util.d.lC(14))) {
              c(this.gaZ);
            }
            if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaH == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              a(this.gaZ);
            }
            if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaI == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            d(this.gaZ);
            awC();
            this.gaZ.setPreviewTexture(paramSurfaceTexture);
            this.gaZ.startPreview();
            if (!k.wat.waH) {
              break label637;
            }
            if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaH == 0) && (this.mSensorManager != null) && (this.vZJ != null)) {
              this.mSensorManager.registerListener(this, this.vZJ, 2);
            }
            this.vZG = true;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(bu.aO(l)), Looper.myLooper() });
            AppMethodBeat.o(89386);
            return 0;
          }
        }
        else
        {
          if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaD != 1) {
            break label663;
          }
          str = "Fix";
          continue;
        }
        if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaD != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        a(this.gaZ, true);
        continue;
        this.mSensorManager.registerListener(this, this.vZJ, 2);
      }
      catch (Exception paramSurfaceTexture)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
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
    long l = bu.HQ();
    this.vZU = false;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", new Object[] { Boolean.valueOf(this.vZG), Looper.myLooper(), paramSurfaceTexture, Boolean.valueOf(paramBoolean) });
    if (this.vZG)
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "this texture %s", new Object[] { paramSurfaceTexture });
    for (;;)
    {
      try
      {
        b(this.gaZ, paramBoolean);
        if (com.tencent.mm.plugin.mmsight.model.a.l.dqm().wci == null) {
          break label656;
        }
        localInteger = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.l.dqm().wci.vYP);
        if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaE == 1)
        {
          str = "Range";
          if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaF != 1) {
            break label673;
          }
          paramBoolean = true;
          if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaG != 1) {
            break label678;
          }
          bool1 = true;
          if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaH != 1) {
            break label684;
          }
          bool2 = true;
          if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaI != 1) {
            break label690;
          }
          bool3 = true;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaE == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            a(this.gaZ, false);
            if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaF == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              b(this.gaZ);
            }
            if ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdz != -1) && (com.tencent.mm.compatible.deviceinfo.ae.geT.gdz == 1) && (com.tencent.mm.compatible.util.d.lC(14))) {
              c(this.gaZ);
            }
            if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaH == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              a(this.gaZ);
            }
            if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaI == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            d(this.gaZ);
            awC();
            this.gaZ.setPreviewTexture(paramSurfaceTexture);
            this.gaZ.startPreview();
            if (!k.wat.waH) {
              break label639;
            }
            if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaH == 0) && (this.mSensorManager != null) && (this.vZJ != null)) {
              this.mSensorManager.registerListener(this, this.vZJ, 2);
            }
            this.vZG = true;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(bu.aO(l)), Looper.myLooper() });
            AppMethodBeat.o(89385);
            return 0;
          }
        }
        else
        {
          if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaD != 1) {
            break label665;
          }
          str = "Fix";
          continue;
        }
        if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gaD != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        a(this.gaZ, true);
        continue;
        this.mSensorManager.registerListener(this, this.vZJ, 2);
      }
      catch (Exception paramSurfaceTexture)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        i = com.tencent.mm.compatible.util.f.getLine();
        AppMethodBeat.o(89385);
        return 0 - i;
      }
      label639:
      continue;
      label656:
      Integer localInteger = Integer.valueOf(0);
      continue;
      label665:
      String str = "Error";
      continue;
      label673:
      paramBoolean = false;
      continue;
      label678:
      boolean bool1 = false;
      continue;
      label684:
      boolean bool2 = false;
      continue;
      label690:
      boolean bool3 = false;
    }
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(89374);
    this.vZV = parama;
    String str1;
    String str2;
    com.tencent.mm.plugin.base.model.a locala;
    if (parama == f.a.waf)
    {
      parama = b.dpE();
      str1 = this.hsI.dpG();
      str2 = this.hsH.dpG();
      locala = this.vZS;
      if (locala.nSo != 0) {
        break label94;
      }
    }
    label94:
    for (int i = 0;; i = locala.nSn / locala.nSo)
    {
      parama.vZp = ((int)(bu.aSD(str1) * 10.0D));
      parama.vZq = ((int)(bu.aSD(str2) * 10.0D));
      parama.vZv = i;
      AppMethodBeat.o(89374);
      return;
    }
  }
  
  public final void a(b paramb, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(89390);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s", new Object[] { paramb, this.hsN, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.hsN != null) {
      try
      {
        this.hsM = true;
        Point localPoint = new Point();
        if (this.hsE != null) {
          localPoint.x = this.hsE.x;
        }
        for (localPoint.y = this.hsE.y;; localPoint.y = this.vZO.y)
        {
          byte[] arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.k.wcg.h(Integer.valueOf(this.hsN.length));
          System.arraycopy(this.hsN, 0, arrayOfByte, 0, this.hsN.length);
          int i = this.hsD.dHi;
          paramb.a(arrayOfByte, localPoint.x, localPoint.y, i, paramInt);
          return;
          if ((this.vZQ == null) || (!this.vZR)) {
            break;
          }
          localPoint.x = this.vZO.x;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "takePicture error: %s", new Object[] { localException.getMessage() });
          this.hsM = false;
          paramb.a(null, 0, 0, -1, 0);
          return;
          localException.x = this.hrV.ruC;
          localException.y = this.hrV.ruD;
        }
      }
      finally
      {
        this.hsM = false;
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
      this.hsB.add(paramg);
    }
    AppMethodBeat.o(89372);
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(89400);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "switch camera with limit, current useBack: %s", new Object[] { Boolean.valueOf(this.hrQ) });
    try
    {
      dpO();
      if (!this.hrQ) {}
      for (boolean bool = true;; bool = false)
      {
        A(paramContext, bool);
        a(paramSurfaceTexture, paramInt, paramFloat, paramBoolean);
        AppMethodBeat.o(89400);
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[] { paramContext });
      AppMethodBeat.o(89400);
    }
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    AppMethodBeat.i(89399);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", new Object[] { Boolean.valueOf(this.hrQ) });
    try
    {
      dpO();
      if (!this.hrQ) {}
      for (boolean bool = true;; bool = false)
      {
        A(paramContext, bool);
        a(paramSurfaceTexture, paramBoolean);
        AppMethodBeat.o(89399);
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[] { paramContext });
      AppMethodBeat.o(89399);
    }
  }
  
  public final boolean axd()
  {
    return this.hrQ;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89392);
    if (com.tencent.mm.compatible.util.d.lB(14))
    {
      AppMethodBeat.o(89392);
      return;
    }
    this.wab.removeMessages(4354);
    this.wab.gpg = paramFloat1;
    this.wab.gph = paramFloat2;
    this.wab.hsm = paramInt1;
    this.wab.hsn = paramInt2;
    this.wab.sendMessageDelayed(this.wab.obtainMessage(4354, this.gaZ), 400L);
    AppMethodBeat.o(89392);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(89373);
    if (paramg != null) {
      this.hsB.remove(paramg);
    }
    AppMethodBeat.o(89373);
  }
  
  public final boolean cOB()
  {
    return this.vZG;
  }
  
  public final void d(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(89396);
    if ((this.gaZ != null) && (this.vZG)) {}
    for (;;)
    {
      int m;
      int k;
      int j;
      try
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (this.aYh)
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
          return;
        }
        Camera.Parameters localParameters = this.gaZ.getParameters();
        if (localParameters.isZoomSupported())
        {
          this.aYh = true;
          m = localParameters.getZoom();
          k = localParameters.getMaxZoom();
          if (!paramBoolean2)
          {
            if (this.hsG <= 0)
            {
              this.hsG = Math.round(k / 15.0F);
              if (this.hsG > 5) {
                this.hsG = 5;
              }
            }
            i = this.hsG;
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(this.hsG), Integer.valueOf(this.hsF), Integer.valueOf(paramInt) });
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
            if (this.hsF <= 0)
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", new Object[] { Integer.valueOf(this.hsF) });
              return;
            }
            i = this.hsF;
            continue;
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", new Object[] { Integer.valueOf(paramInt) });
            localParameters.setZoom(paramInt);
            this.gaZ.setParameters(localParameters);
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
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aYh = false;
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
  
  public final void dpJ()
  {
    AppMethodBeat.i(89382);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
    if ((this.gaZ != null) && (this.vZG)) {
      try
      {
        Camera.Parameters localParameters = this.gaZ.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "support continuous video");
          localParameters.setFocusMode("continuous-video");
        }
        this.gaZ.setParameters(localParameters);
        AppMethodBeat.o(89382);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89382);
  }
  
  public final void dpK()
  {
    AppMethodBeat.i(89383);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode");
    if ((this.gaZ != null) && (this.vZG)) {
      try
      {
        Camera.Parameters localParameters = this.gaZ.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
        }
        this.gaZ.setParameters(localParameters);
        AppMethodBeat.o(89383);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89383);
  }
  
  public final String dpL()
  {
    AppMethodBeat.i(89389);
    if (this.gaZ == null)
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
        localObject3 = com.tencent.mm.plugin.mmsight.d.d(this.gaZ.getParameters());
        if (this.hrY == null)
        {
          Object localObject1 = com.tencent.mm.plugin.mmsight.d.fS(this.mContext);
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
        localObject2 = new Point(this.hrY.getWidth(), this.hrY.getHeight());
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "getDebugInfo error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(89389);
        return null;
      }
      continue;
      label290:
      localStringBuffer.append(String.format("%s*%s X r:%.4f\n", new Object[] { Integer.valueOf(((Camera.Size)localObject3).width), Integer.valueOf(((Camera.Size)localObject3).height), Double.valueOf(((Camera.Size)localObject3).height * 1.0D / ((Camera.Size)localObject3).width) }));
    }
    if (this.hsE != null) {
      localStringBuffer.append("\nSIGHTCROPMODE:  " + this.hsE.x + " " + this.hsE.y + " from " + this.hrV.ruC + " " + this.hrV.ruD);
    }
    for (;;)
    {
      localStringBuffer.append("\ngetOrientation:" + getOrientation());
      localStringBuffer.append("\nrecorderOption: " + com.tencent.mm.compatible.deviceinfo.ae.geT.gdy);
      localObject2 = localStringBuffer.toString();
      AppMethodBeat.o(89389);
      return localObject2;
      localStringBuffer.append("\nFinalPreviewSize: " + getPreviewWidth() + " " + getPreviewHeight());
    }
  }
  
  public final void dpM()
  {
    AppMethodBeat.i(89393);
    if ((this.gaZ != null) && (this.vZG)) {
      try
      {
        Camera.Parameters localParameters = this.gaZ.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("auto")))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCameraSetting", "support auto focus");
          localParameters.setFocusMode("auto");
          this.gaZ.setParameters(localParameters);
        }
        this.gaZ.cancelAutoFocus();
        AppMethodBeat.o(89393);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.gaZ.autoFocus(new f.3(this));
            AppMethodBeat.o(89393);
            return;
          }
          catch (Exception localException2)
          {
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MMSightCamera", localException2, "autoFocus error", new Object[0]);
          }
          localException1 = localException1;
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MMSightCamera", localException1, "simple auto focus error", new Object[0]);
        }
      }
    }
  }
  
  public final List<Integer> dpN()
  {
    AppMethodBeat.i(89394);
    if (this.gaZ != null) {
      try
      {
        Object localObject = this.gaZ.getParameters();
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
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "getZoom error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89394);
    return null;
  }
  
  public final int dpO()
  {
    AppMethodBeat.i(89401);
    dpI();
    AppMethodBeat.o(89401);
    return 0;
  }
  
  public final void dpP()
  {
    AppMethodBeat.i(89402);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[] { this.gaZ, Boolean.valueOf(this.vZG) });
    if ((this.gaZ != null) && (this.vZG)) {
      try
      {
        this.vZT = true;
        Camera.Parameters localParameters = this.gaZ.getParameters();
        if ((!bu.ht(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("torch")))
        {
          localParameters.setFlashMode("torch");
          this.gaZ.setParameters(localParameters);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "open flash");
          AppMethodBeat.o(89402);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "camera not support flash!!");
        AppMethodBeat.o(89402);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MMSightCamera", localException, "openFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89402);
  }
  
  public final void dpQ()
  {
    AppMethodBeat.i(89403);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[] { this.gaZ, Boolean.valueOf(this.vZG) });
    if ((this.gaZ != null) && (this.vZG)) {
      try
      {
        this.vZT = false;
        Camera.Parameters localParameters = this.gaZ.getParameters();
        if ((!bu.ht(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("off")))
        {
          localParameters.setFlashMode("off");
          this.gaZ.setParameters(localParameters);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "close flash");
          AppMethodBeat.o(89403);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "camera not support close flash!!");
        AppMethodBeat.o(89403);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MMSightCamera", localException, "closeFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89403);
  }
  
  public final void dpR()
  {
    AppMethodBeat.i(89404);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "autoFlash, camera: %s, isPreviewing: %s", new Object[] { this.gaZ, Boolean.valueOf(this.vZG) });
    if ((this.gaZ != null) && (this.vZG)) {
      try
      {
        this.vZT = true;
        Camera.Parameters localParameters = this.gaZ.getParameters();
        if ((!bu.ht(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("auto")))
        {
          localParameters.setFlashMode("auto");
          this.gaZ.setParameters(localParameters);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "auto flash");
          AppMethodBeat.o(89404);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "camera not support auto flash!!");
        AppMethodBeat.o(89404);
        return;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MMSightCamera", localException, "autoFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89404);
  }
  
  public final Point getEncodeVideoBestSize()
  {
    return this.vZO;
  }
  
  public final int getOrientation()
  {
    if ((this.hsD != null) && (this.vZG)) {
      return this.hsD.dHi;
    }
    return -1;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(89406);
    if (this.gaZ == null)
    {
      AppMethodBeat.o(89406);
      return 0;
    }
    if (this.hsD != null) {
      try
      {
        int i;
        if ((this.vZR) && (this.vZQ != null)) {
          if ((this.hsD.dHi == 0) || (this.hsD.dHi == 180)) {
            i = this.vZO.y;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89406);
          return i;
          i = this.vZO.x;
          continue;
          if (this.hsE == null)
          {
            if ((this.hsD.dHi == 0) || (this.hsD.dHi == 180)) {
              i = this.hrV.ruD;
            } else {
              i = this.hrV.ruC;
            }
          }
          else if ((this.hsD.dHi == 0) || (this.hsD.dHi == 180)) {
            i = this.hsE.y;
          } else {
            i = this.hsE.x;
          }
        }
        AppMethodBeat.o(89406);
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      }
    }
    return 0;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(89405);
    if (this.gaZ == null)
    {
      AppMethodBeat.o(89405);
      return 0;
    }
    if (this.hsD != null) {
      try
      {
        int i;
        if ((this.vZR) && (this.vZQ != null)) {
          if ((this.hsD.dHi == 0) || (this.hsD.dHi == 180)) {
            i = this.vZO.x;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89405);
          return i;
          i = this.vZO.y;
          continue;
          if (this.hsE == null)
          {
            if ((this.hsD.dHi == 0) || (this.hsD.dHi == 180)) {
              i = this.hrV.ruC;
            } else {
              i = this.hrV.ruD;
            }
          }
          else if ((this.hsD.dHi == 0) || (this.hsD.dHi == 180)) {
            i = this.hsE.x;
          } else {
            i = this.hsE.y;
          }
        }
        AppMethodBeat.o(89405);
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    return 0;
  }
  
  public final void nZ(int paramInt)
  {
    AppMethodBeat.i(89397);
    if (this.hsF > 0)
    {
      AppMethodBeat.o(89397);
      return;
    }
    if (this.hrY == null) {}
    int i;
    for (Point localPoint = al.ck(ak.getContext());; localPoint = new Point(this.hrY.getWidth(), this.hrY.getHeight()))
    {
      i = localPoint.y;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localPoint });
      if (i / 2 < paramInt) {
        break;
      }
      AppMethodBeat.o(89397);
      return;
    }
    try
    {
      if (this.gaZ != null)
      {
        i = this.gaZ.getParameters().getMaxZoom();
        this.hsF = ((int)(i / (paramInt / 3.0D / 10.0D)) + 1);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.hsF), Integer.valueOf(i) });
      }
      AppMethodBeat.o(89397);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89397);
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(89391);
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if ((Math.abs(this.vZK - f1) > 5.0F) || (Math.abs(this.vZL - f2) > 5.0F) || (Math.abs(this.vZM - f3) > 5.0F))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", new Object[] { Float.valueOf(5.0F), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      this.wab.e(this.gaZ);
      this.vZK = f1;
      this.vZL = f2;
      this.vZM = f3;
    }
    AppMethodBeat.o(89391);
  }
  
  public static abstract interface b
  {
    public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public final class c
    extends aq
  {
    float gpg;
    float gph;
    int hsi = 0;
    boolean hsj = false;
    boolean hsk = false;
    boolean hsl = false;
    int hsm;
    int hsn;
    
    public c(Looper paramLooper)
    {
      super();
    }
    
    private static int KM(int paramInt)
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
    
    private static Rect b(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(89367);
      paramFloat3 = 80.0F * paramFloat3;
      paramFloat1 /= paramInt1;
      paramFloat2 /= paramInt2;
      paramFloat1 = paramFloat1 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
      paramFloat2 = paramFloat2 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
      Object localObject = new RectF();
      ((RectF)localObject).set(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat3 + paramFloat2);
      localObject = new Rect(KM(Math.round(((RectF)localObject).left)), KM(Math.round(((RectF)localObject).top)), KM(Math.round(((RectF)localObject).right)), KM(Math.round(((RectF)localObject).bottom)));
      AppMethodBeat.o(89367);
      return localObject;
    }
    
    private static int e(Camera.Parameters paramParameters)
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
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMSightCamera", "get target zoom value error: %s", new Object[] { paramParameters.getMessage() });
          int i = 0;
        }
      }
      AppMethodBeat.o(89369);
      return i;
    }
    
    final void e(v paramv)
    {
      AppMethodBeat.i(89368);
      if (paramv == null)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
        AppMethodBeat.o(89368);
        return;
      }
      if (!f.waa)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.MMSightCamera", "auto focus not back");
        AppMethodBeat.o(89368);
        return;
      }
      f.waa = false;
      try
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
        paramv.cancelAutoFocus();
        paramv.autoFocus(f.this.hsq);
        AppMethodBeat.o(89368);
        return;
      }
      catch (Exception paramv)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", new Object[] { paramv.getMessage() });
        f.waa = true;
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
        paramMessage = (v)paramMessage.obj;
        if ((this.hsm == 0) || (this.hsn == 0) || (com.tencent.mm.compatible.util.d.lB(14)))
        {
          e(paramMessage);
          AppMethodBeat.o(89370);
          return;
        }
        float f1 = this.gpg;
        float f2 = this.gph;
        int i = this.hsm;
        j = this.hsn;
        if (paramMessage == null)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
          AppMethodBeat.o(89370);
          return;
        }
        if (!f.waa)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.MMSightCamera", "auto focus not back");
          AppMethodBeat.o(89370);
          return;
        }
        f.waa = false;
        try
        {
          paramMessage.cancelAutoFocus();
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
          Object localObject2 = b(f1, f2, 1.0F, i, j);
          localObject1 = b(f1, f2, 1.5F, i, j);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
          localParameters = paramMessage.getParameters();
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
          paramMessage.setParameters(localParameters);
          paramMessage.autoFocus(f.this.hsq);
          AppMethodBeat.o(89370);
          return;
        }
        catch (Exception paramMessage)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
          f.waa = true;
          AppMethodBeat.o(89370);
          return;
        }
        if (this.hsl)
        {
          AppMethodBeat.o(89370);
          return;
        }
        Object localObject1 = (Camera)paramMessage.obj;
        Camera.Parameters localParameters = ((Camera)localObject1).getParameters();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(this.hsj), Integer.valueOf(this.hsi), Integer.valueOf(localParameters.getZoom()) });
        i = localParameters.getZoom() + this.hsi;
        if (this.hsj)
        {
          int k = e(localParameters);
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
          this.hsm = 0;
          this.hsn = 0;
          continue;
          paramMessage = obtainMessage(4353, paramMessage.obj);
          if (this.hsk) {}
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
          if (this.hsk) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.f
 * JD-Core Version:    0.7.0.1
 */