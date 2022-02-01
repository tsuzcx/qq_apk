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
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.g.a.oj.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class f
  implements SensorEventListener
{
  static boolean uKR = true;
  protected static int uKz = 2147483647;
  protected boolean aNN;
  protected v fFt;
  protected boolean gWW;
  protected List<g> gXH;
  protected d.a.a gXJ;
  protected Point gXK;
  protected int gXL;
  protected int gXM;
  private c gXN;
  private c gXO;
  private c gXP;
  private c gXQ;
  private c gXR;
  public volatile boolean gXS;
  public volatile byte[] gXT;
  protected q gXb;
  protected Size gXe;
  protected boolean gXp;
  Camera.AutoFocusCallback gXw;
  protected Context mContext;
  protected SensorManager mSensorManager;
  private int scene;
  protected Sensor uKA;
  protected float uKB;
  protected float uKC;
  protected float uKD;
  protected Point uKE;
  protected Point uKF;
  protected int uKG;
  protected byte[] uKH;
  protected boolean uKI;
  protected com.tencent.mm.plugin.base.model.a uKJ;
  protected boolean uKK;
  protected boolean uKL;
  private f.a uKM;
  private c uKN;
  protected VideoTransPara uKO;
  public boolean uKP;
  private boolean uKQ;
  public c uKS;
  protected boolean uKx;
  protected int uKy;
  
  public f(VideoTransPara paramVideoTransPara, int paramInt)
  {
    AppMethodBeat.i(89371);
    this.gXM = -1;
    this.gXL = -1;
    this.gXp = false;
    this.aNN = false;
    this.fFt = null;
    this.uKx = false;
    this.uKy = 0;
    this.uKB = 0.0F;
    this.uKC = 0.0F;
    this.uKD = 0.0F;
    this.mContext = null;
    this.uKE = null;
    this.uKF = null;
    this.gXK = null;
    this.uKG = 0;
    this.uKI = false;
    this.uKJ = new com.tencent.mm.plugin.base.model.a();
    this.uKK = false;
    this.gXH = new ArrayList();
    this.uKL = false;
    this.gXe = null;
    this.uKM = f.a.uKU;
    this.gXN = new c("prevcameraCallback");
    this.gXO = new c("cameraCallback");
    this.gXP = new c("cameraPreviewCallback");
    this.gXQ = new c("cameraCropCallback");
    this.uKN = new c("mirrorCameraCallback");
    this.gXR = new c("finishCallbackTimeCallback");
    this.scene = 0;
    this.gXT = null;
    this.gXS = false;
    this.uKP = false;
    this.uKQ = false;
    this.gXw = new Camera.AutoFocusCallback()
    {
      public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(89362);
        ac.v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), f.f(f.this) });
        f.uKR = true;
        AppMethodBeat.o(89362);
      }
    };
    this.uKS = new c(Looper.getMainLooper());
    this.gWW = true;
    this.gXb = q.ddJ();
    this.uKO = paramVideoTransPara;
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
          ac.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
          paramv.setParameters(localParameters);
          AppMethodBeat.o(89381);
          return true;
        }
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          ac.i("MicroMsg.MMSightCameraSetting", "support continuous video");
          localParameters.setFocusMode("continuous-video");
          continue;
        }
        if (localList == null) {
          break label167;
        }
      }
      catch (Exception paramv)
      {
        ac.i("MicroMsg.MMSightCameraSetting", "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
        AppMethodBeat.o(89381);
        return false;
      }
      if (localList.contains("auto"))
      {
        ac.i("MicroMsg.MMSightCameraSetting", "support auto focus");
        localParameters.setFocusMode("auto");
      }
      else
      {
        label167:
        ac.i("MicroMsg.MMSightCameraSetting", "not support continuous video or auto focus");
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
        if (this.gXe == null)
        {
          localObject = aj.cl(ai.getContext());
          Point localPoint = new Point(Math.min(((Point)localObject).x, ((Point)localObject).y), Math.max(((Point)localObject).x, ((Point)localObject).y));
          ac.i("MicroMsg.MMSightCamera", "screenSize: %s, currentScreenSize: %s", new Object[] { localPoint, localObject });
          float f1 = Math.min(localPoint.x, localPoint.y) / Math.max(localPoint.x, localPoint.y);
          f2 = 1.0F / paramFloat;
          if (paramFloat >= 1.0F) {
            break label709;
          }
          i = paramInt;
          ac.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[] { Integer.valueOf(i), Float.valueOf(paramFloat), Float.valueOf(f1) });
          if (this.gXJ.duc == 90) {
            break label756;
          }
          if (this.gXJ.duc != 270) {
            break label768;
          }
          break label756;
          h.c localc = h.a(localParameters, localPoint, i, bool);
          if (localc != null)
          {
            localObject = localc;
            if (localc.uKY != null) {}
          }
          else
          {
            ac.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
            if (this.gXJ.duc == 90) {
              break label762;
            }
            if (this.gXJ.duc != 270) {
              break label774;
            }
            break label762;
            localObject = h.d(localParameters, localPoint, paramInt, bool);
            this.uKP = false;
          }
          if ((localObject != null) && (((h.c)localObject).uKY != null))
          {
            paramInt = (int)(((h.c)localObject).uKY.x * paramFloat);
            ac.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio result preview size: %s, cropHeight: %s", new Object[] { ((h.c)localObject).uKY, Integer.valueOf(paramInt) });
            if (paramInt > ((h.c)localObject).uKY.y) {
              break label726;
            }
            this.uKP = false;
          }
          if ((localObject != null) && (((h.c)localObject).uKY != null))
          {
            localObject = ((h.c)localObject).uKY;
            this.gXb.qCH = ((Point)localObject).x;
            this.gXb.qCI = ((Point)localObject).y;
            this.uKF = ((Point)localObject);
            this.gXK = null;
            if (!paramBoolean)
            {
              if ((k.uLk.fHJ != 2) || (com.tencent.mm.plugin.mmsight.d.IK(this.uKF.y))) {
                break label745;
              }
              paramInt = com.tencent.mm.plugin.mmsight.d.IL(this.uKF.y);
              if (Math.abs(paramInt - this.uKF.y) > 16) {
                break label734;
              }
              ac.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.uKF, Integer.valueOf(paramInt) });
              this.uKE = new Point(this.uKF.x, this.uKF.y);
              this.uKF.y = paramInt;
              this.uKI = true;
              this.uKH = new byte[this.uKF.x * this.uKF.y * 3 / 2];
            }
            ac.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s, cropWidth: %s", new Object[] { localObject, this.uKF, this.gXK, Boolean.valueOf(this.uKP) });
            localParameters.setPreviewSize(this.gXb.qCH, this.gXb.qCI);
            paramv.setParameters(localParameters);
            AppMethodBeat.o(89377);
            return true;
          }
        }
        else
        {
          localObject = new Point(this.gXe.getWidth(), this.gXe.getHeight());
          continue;
        }
        f2 = paramInt / f2;
      }
      catch (Exception paramv)
      {
        ac.e("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimit error: %s", new Object[] { paramv.getMessage() });
        AppMethodBeat.o(89377);
        return false;
      }
      label709:
      int i = Math.round(f2);
      continue;
      label726:
      this.uKP = true;
      continue;
      label734:
      k.f(this.uKF);
      continue;
      label745:
      k.f(this.uKF);
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
          if (ae.fJd.fET > 0)
          {
            ac.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview frame rate");
            ac.i("MicroMsg.MMSightCameraSetting", "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), localParameters.getSupportedPreviewFrameRates() });
            paramv.setParameters(localParameters);
            AppMethodBeat.o(89379);
            return true;
          }
          if (localParameters == null)
          {
            ac.e("MicroMsg.MMSightCamera", "trySetPreviewFrameRateParameters error, p is null!");
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
            ac.i("MicroMsg.MMSightCameraSetting", "set preview frame rate %d", new Object[] { Integer.valueOf(i) });
          }
          catch (Exception localException1)
          {
            ac.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException1.getMessage() });
          }
        }
        catch (Exception paramv)
        {
          ac.i("MicroMsg.MMSightCameraSetting", "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
          AppMethodBeat.o(89379);
          return false;
        }
        continue;
        if (ae.fJd.fET <= 0) {
          break;
        }
        ac.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview fps range");
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
          ac.i("MicroMsg.MMSightCamera", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4) });
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
        ac.i("MicroMsg.MMSightCameraSetting", "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(30) });
        if ((j == 2147483647) || (i == 2147483647)) {
          break;
        }
        try
        {
          localParameters.setPreviewFpsRange(j, i);
          ac.i("MicroMsg.MMSightCameraSetting", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        }
        catch (Exception localException2)
        {
          ac.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException2.getMessage() });
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
  
  private void atA()
  {
    AppMethodBeat.i(89384);
    if (this.fFt != null) {
      try
      {
        Object localObject = this.fFt.getParameters();
        ac.i("MicroMsg.MMSightCamera", "setPreviewCallbackImpl");
        int i = this.gXb.qCH;
        int j = this.gXb.qCI;
        j = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject).getPreviewFormat()) * (i * j) / 8;
        i = 0;
        while (i < 5)
        {
          localObject = j.uMV.g(Integer.valueOf(j));
          this.fFt.addCallbackBuffer((byte[])localObject);
          i += 1;
        }
        this.gXN.reset();
        this.gXO.reset();
        this.gXP.reset();
        this.gXQ.reset();
        this.uKN.reset();
        this.gXR.reset();
        this.uKJ = new com.tencent.mm.plugin.base.model.a();
        this.fFt.setPreviewCallbackWithBuffer(new Camera.PreviewCallback()
        {
          public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
          {
            AppMethodBeat.i(89361);
            if (!f.this.uKL)
            {
              ac.i("MicroMsg.MMSightCamera", "onPreviewFrame: %s %s", new Object[] { paramAnonymousArrayOfByte, f.this.fFt });
              f.this.uKL = true;
            }
            if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
            {
              ac.e("MicroMsg.MMSightCamera", "onPreviewFrame, frame data is null!!");
              AppMethodBeat.o(89361);
              return;
            }
            paramAnonymousCamera = f.this.uKJ;
            if (paramAnonymousCamera.nmd == 0)
            {
              paramAnonymousCamera.nmc += 1;
              paramAnonymousCamera.nmb = bs.aLy(m.XG());
            }
            paramAnonymousCamera.nmd += 1;
            int i;
            long l1;
            byte[] arrayOfByte;
            label367:
            long l2;
            int j;
            boolean bool;
            if (paramAnonymousCamera.nmd >= 90)
            {
              i = 0;
              paramAnonymousCamera.nmd = i;
              if ((f.a(f.this)) || (f.this.gXH == null) || (f.this.gXH.size() <= 0)) {
                break label944;
              }
              if (f.this.gXK == null) {
                break label584;
              }
              paramAnonymousCamera = j.uMV.g(Integer.valueOf(f.this.gXb.qCH * f.this.gXK.y * 3 / 2));
              f.b(f.this).vW(1L);
              l1 = bs.Gn();
              SightVideoJNI.cropCameraData(paramAnonymousArrayOfByte, paramAnonymousCamera, f.this.gXb.qCH, f.this.gXb.qCI, f.this.gXK.y);
              if (f.this.gXK.x >= f.this.gXb.qCH) {
                break label941;
              }
              arrayOfByte = j.uMV.g(Integer.valueOf(f.this.gXK.x * f.this.gXK.y * 3 / 2));
              SightVideoJNI.cropCameraDataLongEdge(paramAnonymousCamera, arrayOfByte, f.this.gXb.qCH, f.this.gXK.x, f.this.gXK.y);
              j.uMV.k(paramAnonymousCamera);
              paramAnonymousCamera = arrayOfByte;
              l2 = bs.aO(l1);
              f.c(f.this).vW(l2);
              if (!f.this.gWW)
              {
                l1 = bs.Gn();
                i = f.this.gXK.x;
                j = f.this.gXK.y;
                if ((f.this.gXJ.duc != 270) && (f.this.gXJ.duc != 90)) {
                  break label578;
                }
                bool = true;
                label458:
                SightVideoJNI.mirrorCameraData(paramAnonymousCamera, i, j, bool);
                l2 = bs.aO(l1);
                f.d(f.this).vW(l2);
              }
              bool = f.a(f.this, paramAnonymousCamera);
              l1 = bs.aO(l1);
              if (bool) {
                f.e(f.this).vW(l1);
              }
            }
            for (;;)
            {
              f.b(f.this, paramAnonymousCamera);
              if (f.f(f.this) == f.a.uKU) {
                f.g(f.this).vW(1L);
              }
              for (;;)
              {
                f.this.fFt.addCallbackBuffer(paramAnonymousArrayOfByte);
                AppMethodBeat.o(89361);
                return;
                i = paramAnonymousCamera.nmd;
                break;
                label578:
                bool = false;
                break label458;
                label584:
                l1 = bs.Gn();
                label656:
                label753:
                f localf;
                if (!f.this.gWW)
                {
                  i = f.this.gXb.qCH;
                  j = f.this.gXb.qCI;
                  if ((f.this.gXJ.duc == 270) || (f.this.gXJ.duc == 90))
                  {
                    bool = true;
                    SightVideoJNI.mirrorCameraData(paramAnonymousArrayOfByte, i, j, bool);
                    l2 = bs.aO(l1);
                    f.d(f.this).vW(l2);
                  }
                }
                else
                {
                  if ((!f.this.uKI) || (f.this.uKH == null)) {
                    break label898;
                  }
                  SightVideoJNI.paddingYuvData16(paramAnonymousArrayOfByte, f.this.uKH, f.this.uKF.x, f.this.uKE.y, f.this.uKF.y);
                  paramAnonymousCamera = f.this.uKH;
                  bool = f.a(f.this, paramAnonymousCamera);
                  l1 = bs.aO(l1);
                  if (bool) {
                    f.e(f.this).vW(l1);
                  }
                  if (f.this.uKI)
                  {
                    arrayOfByte = paramAnonymousArrayOfByte;
                    if (f.this.uKH != null) {}
                  }
                  else
                  {
                    arrayOfByte = paramAnonymousArrayOfByte;
                    if (bool) {
                      arrayOfByte = j.uMV.g(Integer.valueOf(paramAnonymousArrayOfByte.length));
                    }
                  }
                  if ((f.this.uKI) && (f.this.uKH != null))
                  {
                    localf = f.this;
                    if (!bool) {
                      break label903;
                    }
                  }
                }
                label898:
                label903:
                for (paramAnonymousArrayOfByte = j.uMV.g(Integer.valueOf(f.this.uKH.length));; paramAnonymousArrayOfByte = f.this.uKH)
                {
                  localf.uKH = paramAnonymousArrayOfByte;
                  paramAnonymousArrayOfByte = arrayOfByte;
                  break;
                  bool = false;
                  break label656;
                  paramAnonymousCamera = paramAnonymousArrayOfByte;
                  break label753;
                }
                if (f.f(f.this) == f.a.uKV) {
                  f.h(f.this).vW(1L);
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
        ac.e("MicroMsg.MMSightCamera", "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89384);
  }
  
  private void atl()
  {
    AppMethodBeat.i(89388);
    if (true == this.uKQ)
    {
      AppMethodBeat.o(89388);
      return;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(89388);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.d.b.Yz()))
    {
      AppMethodBeat.o(89388);
      return;
    }
    Object localObject = new oj();
    ((oj)localObject).dqS.type = 2;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    if (((oj)localObject).dqT.dqR)
    {
      this.uKQ = true;
      AppMethodBeat.o(89388);
      return;
    }
    localObject = com.tencent.mm.ui.base.h.l(this.mContext, 2131763668, 2131755906);
    if (localObject != null)
    {
      ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
      ((com.tencent.mm.ui.widget.a.d)localObject).setCanceledOnTouchOutside(false);
      ((com.tencent.mm.ui.widget.a.d)localObject).show();
      this.uKQ = true;
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
      ac.i("MicroMsg.MMSightCameraSetting", "safeSetPreviewFormat");
      Camera.Parameters localParameters = paramv.getParameters();
      List localList = localParameters.getSupportedPreviewFormats();
      if ((localList == null) || (!localList.contains(Integer.valueOf(17)))) {
        ac.e("MicroMsg.MMSightCameraSetting", "not support YCbCr_420_SP");
      }
      localParameters.setPreviewFormat(17);
      paramv.setParameters(localParameters);
      AppMethodBeat.o(89380);
      return true;
    }
    catch (Exception paramv)
    {
      ac.i("MicroMsg.MMSightCameraSetting", "setPreviewFormat Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
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
        if (this.gXe == null)
        {
          localPoint = com.tencent.mm.plugin.mmsight.d.fH(this.mContext);
          if (this.gWW)
          {
            localObject1 = b.ddk();
            localObject2 = localParameters.getSupportedPreviewSizes();
            localObject3 = localParameters.getSupportedPictureSizes();
            i = this.gXJ.duc;
            if (bs.isNullOrNil(((b)localObject1).uJW)) {
              ((b)localObject1).uJW = com.tencent.mm.plugin.mmsight.d.ek((List)localObject2);
            }
            if (bs.isNullOrNil(((b)localObject1).uJX)) {
              ((b)localObject1).uJX = com.tencent.mm.plugin.mmsight.d.ek((List)localObject3);
            }
            ((b)localObject1).duc = i;
            ((b)localObject1).uKr = 1;
            if (paramBoolean)
            {
              if (this.gXJ.duc == 90) {
                break label2498;
              }
              if (this.gXJ.duc != 270) {
                break label501;
              }
              break label2498;
              k.a(localParameters, bool);
            }
            com.tencent.mm.plugin.mmsight.model.a.k.ddS();
            i = com.tencent.mm.plugin.mmsight.model.a.k.ddV();
            if (this.gXJ.duc == 90) {
              break label2504;
            }
            if (this.gXJ.duc != 270) {
              break label507;
            }
            break label2504;
            label206:
            localObject2 = h.a(localParameters, localPoint, i, bool);
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((h.c)localObject2).uKY != null) {}
            }
            else
            {
              ac.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
              localPoint = new Point(Math.min(localPoint.x, localPoint.y), Math.max(localPoint.x, localPoint.y));
              if (this.gXJ.duc == 90) {
                break label2510;
              }
              if (this.gXJ.duc != 270) {
                break label513;
              }
              break label2510;
              label308:
              localObject1 = h.d(localParameters, localPoint, 2100, bool);
              this.uKP = false;
            }
            k.a((h.c)localObject1);
            localPoint = ((h.c)localObject1).uKY;
            if (localPoint != null) {
              break;
            }
            l.atO();
            AppMethodBeat.o(89376);
            return false;
          }
        }
        else
        {
          localPoint = new Point(this.gXe.getWidth(), this.gXe.getHeight());
          continue;
        }
        localObject1 = b.ddk();
        localObject2 = localParameters.getSupportedPreviewSizes();
        localObject3 = localParameters.getSupportedPictureSizes();
        i = this.gXJ.duc;
        if (bs.isNullOrNil(((b)localObject1).uJY)) {
          ((b)localObject1).uJY = com.tencent.mm.plugin.mmsight.d.ek((List)localObject2);
        }
        if (bs.isNullOrNil(((b)localObject1).uJZ)) {
          ((b)localObject1).uJZ = com.tencent.mm.plugin.mmsight.d.ek((List)localObject3);
        }
        ((b)localObject1).duc = i;
        ((b)localObject1).uKr = 2;
        continue;
        bool = false;
      }
      catch (Exception paramv)
      {
        ac.i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
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
    this.gXb.qCH = localPoint.x;
    this.gXb.qCI = localPoint.y;
    this.uKF = localPoint;
    Object localObject2 = this.mContext;
    if (this.gXJ.duc != 90) {
      if (this.gXJ.duc == 270)
      {
        break label2516;
        label583:
        bool = com.tencent.mm.plugin.mmsight.d.a((Context)localObject2, localPoint, bool);
        i = 1;
        if ((this.gXJ.duc != 90) && (this.gXJ.duc != 270)) {
          break label1348;
        }
        if ((localPoint.y < this.uKO.width) || (localPoint.x < this.uKO.height))
        {
          i = 0;
          ac.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localPoint });
        }
        label673:
        ac.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label1434;
        }
        if (k.uLk.fHJ != 2) {
          break label1422;
        }
        this.gXK = ((h.c)localObject1).uLa;
        if ((this.gXK.x < localPoint.x) || (this.gXK.y < localPoint.y))
        {
          if ((this.gXJ.duc != 90) && (this.gXJ.duc != 270)) {
            break label1402;
          }
          this.gXK.y = com.tencent.mm.plugin.mmsight.d.IM(this.gXK.y);
        }
        label789:
        this.uKF = new Point(this.gXK.x, this.gXK.y);
        this.uKG = (this.gXK.x * this.gXK.y * 3 / 2);
        ac.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", new Object[] { this.gXK });
      }
    }
    label856:
    label2522:
    for (;;)
    {
      int j;
      int k;
      if (k.uLk.uLx)
      {
        if ((this.gXJ.duc != 90) && (this.gXJ.duc != 270)) {
          break label2035;
        }
        if (i != 0)
        {
          if (k.uLk.gXd != 1080) {
            break label1863;
          }
          if (this.gXK != null) {
            break label1811;
          }
          j = localPoint.x / 2;
          if (this.gXK != null) {
            break label1825;
          }
          i = localPoint.y / 2;
          if (this.gXK != null) {
            break label1839;
          }
          k = localPoint.x;
          k = com.tencent.mm.plugin.mmsight.d.gh(j, k);
          if (this.gXK != null) {
            break label1851;
          }
          j = localPoint.y;
          this.uKF = new Point(k, com.tencent.mm.plugin.mmsight.d.gh(i, j));
        }
      }
      label996:
      localObject1 = b.ddk();
      localObject2 = this.gXK;
      localObject3 = this.uKF;
      ((b)localObject1).uKf = -1;
      ((b)localObject1).uKe = -1;
      ((b)localObject1).uKb = -1;
      ((b)localObject1).uKa = -1;
      ((b)localObject1).uKd = -1;
      ((b)localObject1).uKc = -1;
      if (localPoint != null)
      {
        ((b)localObject1).uKc = localPoint.x;
        ((b)localObject1).uKd = localPoint.y;
      }
      if (localObject2 != null)
      {
        ((b)localObject1).uKa = ((Point)localObject2).x;
        ((b)localObject1).uKb = ((Point)localObject2).y;
      }
      if (localObject3 != null)
      {
        ((b)localObject1).uKe = ((Point)localObject3).x;
        ((b)localObject1).uKf = ((Point)localObject3).y;
      }
      if (paramBoolean) {
        if ((!bool) && (k.uLk.fHJ == 2) && (!com.tencent.mm.plugin.mmsight.d.IK(this.uKF.y)))
        {
          i = com.tencent.mm.plugin.mmsight.d.IL(this.uKF.y);
          if (Math.abs(i - this.uKF.y) <= 16)
          {
            ac.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.uKF, Integer.valueOf(i) });
            this.uKE = new Point(this.uKF.x, this.uKF.y);
            this.uKF.y = i;
            this.uKI = true;
            this.uKH = new byte[this.uKF.x * this.uKF.y * 3 / 2];
          }
        }
      }
      for (;;)
      {
        ac.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", new Object[] { localPoint, this.uKF, this.gXK });
        localParameters.setPreviewSize(this.gXb.qCH, this.gXb.qCI);
        paramv.setParameters(localParameters);
        AppMethodBeat.o(89376);
        return true;
        bool = false;
        break;
        if ((localPoint.x >= this.uKO.width) && (localPoint.y >= this.uKO.height)) {
          break label673;
        }
        i = 0;
        ac.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localPoint });
        break label673;
        label1402:
        this.gXK.x = com.tencent.mm.plugin.mmsight.d.IM(this.gXK.x);
        break label789;
        this.gXK = ((h.c)localObject1).uKZ;
        break label789;
        if ((!k.uLk.uLx) || (k.uLk.gXd != 1080) || (i == 0)) {
          break label2495;
        }
        if ((this.gXJ.duc == 90) || (this.gXJ.duc == 270))
        {
          j = localPoint.y / 2;
          k = com.tencent.mm.plugin.mmsight.d.IL(j);
          m = localPoint.x / 2;
          n = com.tencent.mm.plugin.mmsight.d.IL(m);
          if ((Math.abs(k - j) < 8) && (Math.abs(n - m) < 8)) {
            break label2522;
          }
          this.gXK = new Point(localPoint.x, localPoint.y);
          this.gXK.y = com.tencent.mm.plugin.mmsight.d.IM(localPoint.y);
          this.gXK.x = com.tencent.mm.plugin.mmsight.d.IM(localPoint.x);
          this.uKF = new Point(this.gXK.x, this.gXK.y);
          this.uKG = (this.gXK.x * this.gXK.y * 3 / 2);
          bool = true;
          break label2522;
        }
        j = localPoint.x / 2;
        k = com.tencent.mm.plugin.mmsight.d.IL(j);
        int m = localPoint.y / 2;
        int n = com.tencent.mm.plugin.mmsight.d.IL(m);
        if ((Math.abs(k - j) < 8) && (Math.abs(n - m) < 8)) {
          break label2495;
        }
        this.gXK = new Point(localPoint.x, localPoint.y);
        this.gXK.y = com.tencent.mm.plugin.mmsight.d.IM(localPoint.x);
        this.gXK.x = com.tencent.mm.plugin.mmsight.d.IM(localPoint.y);
        this.uKF = new Point(this.gXK.x, this.gXK.y);
        this.uKG = (this.gXK.x * this.gXK.y * 3 / 2);
        bool = true;
        break label856;
        j = this.gXK.x / 2;
        break label923;
        i = this.gXK.y / 2;
        break label939;
        k = this.gXK.x;
        break label953;
        j = this.gXK.y;
        break label976;
        if (k.uLk.gXd != 720) {
          break label996;
        }
        float f;
        if (this.gXK == null)
        {
          f = localPoint.x * 0.75F;
          label1893:
          k = (int)f;
          if (this.gXK != null) {
            break label1995;
          }
          f = localPoint.y * 0.75F;
          label1915:
          j = (int)f;
          if (this.gXK != null) {
            break label2011;
          }
          i = localPoint.x;
          k = com.tencent.mm.plugin.mmsight.d.gh(k, i);
          if (this.gXK != null) {
            break label2023;
          }
        }
        label2011:
        label2023:
        for (i = localPoint.y;; i = this.gXK.y)
        {
          this.uKF = new Point(k, com.tencent.mm.plugin.mmsight.d.gh(j, i));
          break;
          f = this.gXK.x * 0.75F;
          break label1893;
          f = this.gXK.y * 0.75F;
          break label1915;
          i = this.gXK.x;
          break label1933;
        }
        label2035:
        if (i == 0) {
          break label996;
        }
        if (k.uLk.gXd == 1080)
        {
          if (this.gXK == null)
          {
            j = localPoint.y / 2;
            if (this.gXK != null) {
              break label2158;
            }
            i = localPoint.x / 2;
            if (this.gXK != null) {
              break label2172;
            }
            k = localPoint.y;
            k = com.tencent.mm.plugin.mmsight.d.gh(j, k);
            if (this.gXK != null) {
              break label2184;
            }
          }
          for (j = localPoint.x;; j = this.gXK.x)
          {
            this.uKF = new Point(k, com.tencent.mm.plugin.mmsight.d.gh(i, j));
            break;
            j = this.gXK.y / 2;
            break label2068;
            label2158:
            i = this.gXK.x / 2;
            break label2084;
            label2172:
            k = this.gXK.y;
            break label2098;
          }
        }
        if (k.uLk.gXd != 720) {
          break label996;
        }
        if (this.gXK == null)
        {
          f = localPoint.y * 0.75F;
          k = (int)f;
          if (this.gXK != null) {
            break label2328;
          }
          f = localPoint.x * 0.75F;
          j = (int)f;
          if (this.gXK != null) {
            break label2344;
          }
          i = localPoint.y;
          label2266:
          k = com.tencent.mm.plugin.mmsight.d.gh(k, i);
          if (this.gXK != null) {
            break label2356;
          }
        }
        for (i = localPoint.x;; i = this.gXK.x)
        {
          this.uKF = new Point(k, com.tencent.mm.plugin.mmsight.d.gh(j, i));
          break;
          f = this.gXK.y * 0.75F;
          break label2226;
          f = this.gXK.x * 0.75F;
          break label2248;
          i = this.gXK.y;
          break label2266;
        }
        k.f(this.uKF);
        continue;
        k.f(this.uKF);
        continue;
        if ((!bool) && (k.uLk.fHJ == 2) && (!com.tencent.mm.plugin.mmsight.d.IK(this.uKF.y)) && (this.uKI) && (this.uKH != null) && (this.uKE.y == this.uKF.y))
        {
          i = com.tencent.mm.plugin.mmsight.d.IL(this.uKF.y);
          if (this.uKH.length == this.uKF.x * i * 3 / 2) {
            this.uKF.y = i;
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
      ac.i("MicroMsg.MMSightCameraSetting", "safeSetMetering");
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
      ac.i("MicroMsg.MMSightCameraSetting", "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
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
      ac.e("MicroMsg.MMSightCamera", "safeResetZoom error: %s", new Object[] { paramv.getMessage() });
      AppMethodBeat.o(89387);
    }
  }
  
  private void ddo()
  {
    AppMethodBeat.i(89375);
    try
    {
      if ((this.mSensorManager != null) && (this.uKA != null)) {
        this.mSensorManager.unregisterListener(this);
      }
      ac.i("MicroMsg.MMSightCamera", this.gXN.getValue());
      ac.i("MicroMsg.MMSightCamera", this.gXO.getValue());
      ac.i("MicroMsg.MMSightCamera", this.gXP.getValue());
      ac.i("MicroMsg.MMSightCamera", this.gXQ.getValue());
      ac.i("MicroMsg.MMSightCamera", this.uKN.getValue());
      ac.i("MicroMsg.MMSightCamera", this.gXR.getValue());
      if (this.fFt != null)
      {
        long l = bs.Gn();
        ac.i("MicroMsg.MMSightCamera", "release camera beg, %s", new Object[] { Looper.myLooper() });
        this.uKS.removeCallbacksAndMessages(null);
        this.uKS.gXr = true;
        this.fFt.setPreviewCallback(null);
        this.fFt.stopPreview();
        this.fFt.release();
        this.fFt = null;
        this.uKx = false;
        ac.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", new Object[] { Long.valueOf(bs.aO(l)), Looper.myLooper() });
      }
      this.gXp = false;
      this.uKB = 0.0F;
      this.uKC = 0.0F;
      this.uKD = 0.0F;
      uKR = true;
      this.mContext = null;
      this.uKQ = false;
      this.uKF = null;
      this.gXK = null;
      this.gXT = null;
      this.uKL = false;
      AppMethodBeat.o(89375);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MMSightCamera", localException, "cameraRelease error", new Object[0]);
      AppMethodBeat.o(89375);
    }
  }
  
  public final void IO(int paramInt)
  {
    AppMethodBeat.i(89395);
    if (this.fFt != null) {
      try
      {
        Camera.Parameters localParameters = this.fFt.getParameters();
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
        if (this.aNN)
        {
          ac.d("MicroMsg.MMSightCamera", "setForceZoomTargetRatio, zooming, ignore");
          return;
        }
        this.aNN = true;
        localParameters.setZoom(paramInt);
        this.fFt.setParameters(localParameters);
        return;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.MMSightCamera", "getZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aNN = false;
        AppMethodBeat.o(89395);
      }
    }
    AppMethodBeat.o(89395);
  }
  
  public final int a(SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(89386);
    long l = bs.Gn();
    this.uKL = false;
    ac.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s", new Object[] { Boolean.valueOf(this.uKx), Looper.myLooper(), paramSurfaceTexture });
    if (this.uKx)
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
    ac.i("MicroMsg.MMSightCamera", "this texture %s", new Object[] { paramSurfaceTexture });
    for (;;)
    {
      try
      {
        a(this.fFt, paramInt, paramFloat, paramBoolean);
        if (com.tencent.mm.plugin.mmsight.model.a.k.ddS().uMX == null) {
          break label654;
        }
        localInteger = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.k.ddS().uMX.uJG);
        if (ae.fJd.fEY == 1)
        {
          str = "Range";
          if (ae.fJd.fEZ != 1) {
            break label671;
          }
          paramBoolean = true;
          if (ae.fJd.fFa != 1) {
            break label677;
          }
          bool1 = true;
          if (ae.fJd.fFb != 1) {
            break label683;
          }
          bool2 = true;
          if (ae.fJd.fFc != 1) {
            break label689;
          }
          bool3 = true;
          ac.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((ae.fJd.fEY == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            a(this.fFt, false);
            if ((ae.fJd.fEZ == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              b(this.fFt);
            }
            if ((ae.fJk.fHR != -1) && (ae.fJk.fHR == 1) && (com.tencent.mm.compatible.util.d.lb(14))) {
              c(this.fFt);
            }
            if ((ae.fJd.fFb == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              a(this.fFt);
            }
            if ((ae.fJd.fFc == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            d(this.fFt);
            atA();
            this.fFt.setPreviewTexture(paramSurfaceTexture);
            this.fFt.startPreview();
            if (!k.uLk.uLy) {
              break label637;
            }
            if ((ae.fJd.fFb == 0) && (this.mSensorManager != null) && (this.uKA != null)) {
              this.mSensorManager.registerListener(this, this.uKA, 2);
            }
            this.uKx = true;
            ac.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(bs.aO(l)), Looper.myLooper() });
            AppMethodBeat.o(89386);
            return 0;
          }
        }
        else
        {
          if (ae.fJd.fEX != 1) {
            break label663;
          }
          str = "Fix";
          continue;
        }
        if ((ae.fJd.fEX != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        a(this.fFt, true);
        continue;
        this.mSensorManager.registerListener(this, this.uKA, 2);
      }
      catch (Exception paramSurfaceTexture)
      {
        ac.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
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
    long l = bs.Gn();
    this.uKL = false;
    ac.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", new Object[] { Boolean.valueOf(this.uKx), Looper.myLooper(), paramSurfaceTexture, Boolean.valueOf(paramBoolean) });
    if (this.uKx)
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
    ac.i("MicroMsg.MMSightCamera", "this texture %s", new Object[] { paramSurfaceTexture });
    for (;;)
    {
      try
      {
        b(this.fFt, paramBoolean);
        if (com.tencent.mm.plugin.mmsight.model.a.k.ddS().uMX == null) {
          break label656;
        }
        localInteger = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.k.ddS().uMX.uJG);
        if (ae.fJd.fEY == 1)
        {
          str = "Range";
          if (ae.fJd.fEZ != 1) {
            break label673;
          }
          paramBoolean = true;
          if (ae.fJd.fFa != 1) {
            break label678;
          }
          bool1 = true;
          if (ae.fJd.fFb != 1) {
            break label684;
          }
          bool2 = true;
          if (ae.fJd.fFc != 1) {
            break label690;
          }
          bool3 = true;
          ac.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((ae.fJd.fEY == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            a(this.fFt, false);
            if ((ae.fJd.fEZ == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              b(this.fFt);
            }
            if ((ae.fJk.fHR != -1) && (ae.fJk.fHR == 1) && (com.tencent.mm.compatible.util.d.lb(14))) {
              c(this.fFt);
            }
            if ((ae.fJd.fFb == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              a(this.fFt);
            }
            if ((ae.fJd.fFc == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            d(this.fFt);
            atA();
            this.fFt.setPreviewTexture(paramSurfaceTexture);
            this.fFt.startPreview();
            if (!k.uLk.uLy) {
              break label639;
            }
            if ((ae.fJd.fFb == 0) && (this.mSensorManager != null) && (this.uKA != null)) {
              this.mSensorManager.registerListener(this, this.uKA, 2);
            }
            this.uKx = true;
            ac.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(bs.aO(l)), Looper.myLooper() });
            AppMethodBeat.o(89385);
            return 0;
          }
        }
        else
        {
          if (ae.fJd.fEX != 1) {
            break label665;
          }
          str = "Fix";
          continue;
        }
        if ((ae.fJd.fEX != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        a(this.fFt, true);
        continue;
        this.mSensorManager.registerListener(this, this.uKA, 2);
      }
      catch (Exception paramSurfaceTexture)
      {
        ac.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
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
    this.uKM = parama;
    String str1;
    String str2;
    com.tencent.mm.plugin.base.model.a locala;
    if (parama == f.a.uKW)
    {
      parama = b.ddk();
      str1 = this.gXO.ddm();
      str2 = this.gXN.ddm();
      locala = this.uKJ;
      if (locala.nmc != 0) {
        break label94;
      }
    }
    label94:
    for (int i = 0;; i = locala.nmb / locala.nmc)
    {
      parama.uKg = ((int)(bs.aLA(str1) * 10.0D));
      parama.uKh = ((int)(bs.aLA(str2) * 10.0D));
      parama.uKm = i;
      AppMethodBeat.o(89374);
      return;
    }
  }
  
  public final void a(b paramb, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(89390);
    ac.i("MicroMsg.MMSightCamera", "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s", new Object[] { paramb, this.gXT, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.gXT != null) {
      try
      {
        this.gXS = true;
        Point localPoint = new Point();
        if (this.gXK != null) {
          localPoint.x = this.gXK.x;
        }
        for (localPoint.y = this.gXK.y;; localPoint.y = this.uKF.y)
        {
          byte[] arrayOfByte = j.uMV.g(Integer.valueOf(this.gXT.length));
          System.arraycopy(this.gXT, 0, arrayOfByte, 0, this.gXT.length);
          int i = this.gXJ.duc;
          paramb.a(arrayOfByte, localPoint.x, localPoint.y, i, paramInt);
          return;
          if ((this.uKH == null) || (!this.uKI)) {
            break;
          }
          localPoint.x = this.uKF.x;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.MMSightCamera", "takePicture error: %s", new Object[] { localException.getMessage() });
          this.gXS = false;
          paramb.a(null, 0, 0, -1, 0);
          return;
          localException.x = this.gXb.qCH;
          localException.y = this.gXb.qCI;
        }
      }
      finally
      {
        this.gXS = false;
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
      this.gXH.add(paramg);
    }
    AppMethodBeat.o(89372);
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(89400);
    ac.i("MicroMsg.MMSightCamera", "switch camera with limit, current useBack: %s", new Object[] { Boolean.valueOf(this.gWW) });
    try
    {
      ddu();
      if (!this.gWW) {}
      for (boolean bool = true;; bool = false)
      {
        y(paramContext, bool);
        a(paramSurfaceTexture, paramInt, paramFloat, paramBoolean);
        AppMethodBeat.o(89400);
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      ac.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[] { paramContext });
      AppMethodBeat.o(89400);
    }
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    AppMethodBeat.i(89399);
    ac.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", new Object[] { Boolean.valueOf(this.gWW) });
    try
    {
      ddu();
      if (!this.gWW) {}
      for (boolean bool = true;; bool = false)
      {
        y(paramContext, bool);
        a(paramSurfaceTexture, paramBoolean);
        AppMethodBeat.o(89399);
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      ac.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[] { paramContext });
      AppMethodBeat.o(89399);
    }
  }
  
  public final boolean aub()
  {
    return this.gWW;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89392);
    if (com.tencent.mm.compatible.util.d.la(14))
    {
      AppMethodBeat.o(89392);
      return;
    }
    this.uKS.removeMessages(4354);
    this.uKS.fTg = paramFloat1;
    this.uKS.fTh = paramFloat2;
    this.uKS.gXs = paramInt1;
    this.uKS.gXt = paramInt2;
    this.uKS.sendMessageDelayed(this.uKS.obtainMessage(4354, this.fFt), 400L);
    AppMethodBeat.o(89392);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(89373);
    if (paramg != null) {
      this.gXH.remove(paramg);
    }
    AppMethodBeat.o(89373);
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(89396);
    if ((this.fFt != null) && (this.uKx)) {}
    for (;;)
    {
      int m;
      int k;
      int j;
      try
      {
        ac.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (this.aNN)
        {
          ac.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
          return;
        }
        Camera.Parameters localParameters = this.fFt.getParameters();
        if (localParameters.isZoomSupported())
        {
          this.aNN = true;
          m = localParameters.getZoom();
          k = localParameters.getMaxZoom();
          if (!paramBoolean2)
          {
            if (this.gXM <= 0)
            {
              this.gXM = Math.round(k / 15.0F);
              if (this.gXM > 5) {
                this.gXM = 5;
              }
            }
            i = this.gXM;
            ac.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(this.gXM), Integer.valueOf(this.gXL), Integer.valueOf(paramInt) });
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
            if (this.gXL <= 0)
            {
              ac.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", new Object[] { Integer.valueOf(this.gXL) });
              return;
            }
            i = this.gXL;
            continue;
            ac.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", new Object[] { Integer.valueOf(paramInt) });
            localParameters.setZoom(paramInt);
            this.fFt.setParameters(localParameters);
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
        ac.e("MicroMsg.MMSightCamera", "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aNN = false;
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
  
  public final boolean cDz()
  {
    return this.uKx;
  }
  
  public final void ddp()
  {
    AppMethodBeat.i(89382);
    ac.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
    if ((this.fFt != null) && (this.uKx)) {
      try
      {
        Camera.Parameters localParameters = this.fFt.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          ac.i("MicroMsg.MMSightCameraSetting", "support continuous video");
          localParameters.setFocusMode("continuous-video");
        }
        this.fFt.setParameters(localParameters);
        AppMethodBeat.o(89382);
        return;
      }
      catch (Exception localException)
      {
        ac.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89382);
  }
  
  public final void ddq()
  {
    AppMethodBeat.i(89383);
    ac.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode");
    if ((this.fFt != null) && (this.uKx)) {
      try
      {
        Camera.Parameters localParameters = this.fFt.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          ac.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
        }
        this.fFt.setParameters(localParameters);
        AppMethodBeat.o(89383);
        return;
      }
      catch (Exception localException)
      {
        ac.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89383);
  }
  
  public final String ddr()
  {
    AppMethodBeat.i(89389);
    if (this.fFt == null)
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
        localObject3 = com.tencent.mm.plugin.mmsight.d.f(this.fFt.getParameters());
        if (this.gXe == null)
        {
          Object localObject1 = com.tencent.mm.plugin.mmsight.d.fH(this.mContext);
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
        localObject2 = new Point(this.gXe.getWidth(), this.gXe.getHeight());
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.MMSightCamera", "getDebugInfo error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(89389);
        return null;
      }
      continue;
      label290:
      localStringBuffer.append(String.format("%s*%s X r:%.4f\n", new Object[] { Integer.valueOf(((Camera.Size)localObject3).width), Integer.valueOf(((Camera.Size)localObject3).height), Double.valueOf(((Camera.Size)localObject3).height * 1.0D / ((Camera.Size)localObject3).width) }));
    }
    if (this.gXK != null) {
      localStringBuffer.append("\nSIGHTCROPMODE:  " + this.gXK.x + " " + this.gXK.y + " from " + this.gXb.qCH + " " + this.gXb.qCI);
    }
    for (;;)
    {
      localStringBuffer.append("\ngetOrientation:" + getOrientation());
      localStringBuffer.append("\nrecorderOption: " + ae.fJk.fHQ);
      localObject2 = localStringBuffer.toString();
      AppMethodBeat.o(89389);
      return localObject2;
      localStringBuffer.append("\nFinalPreviewSize: " + getPreviewWidth() + " " + getPreviewHeight());
    }
  }
  
  public final void dds()
  {
    AppMethodBeat.i(89393);
    if ((this.fFt != null) && (this.uKx)) {
      try
      {
        Camera.Parameters localParameters = this.fFt.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("auto")))
        {
          ac.i("MicroMsg.MMSightCameraSetting", "support auto focus");
          localParameters.setFocusMode("auto");
          this.fFt.setParameters(localParameters);
        }
        this.fFt.cancelAutoFocus();
        AppMethodBeat.o(89393);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.fFt.autoFocus(new Camera.AutoFocusCallback()
            {
              public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
              {
                AppMethodBeat.i(89363);
                if ((paramAnonymousCamera != null) && (f.this.cDz())) {
                  try
                  {
                    Camera.Parameters localParameters = paramAnonymousCamera.getParameters();
                    List localList = localParameters.getSupportedFocusModes();
                    if ((localList != null) && (localList.contains("continuous-picture")))
                    {
                      ac.i("MicroMsg.MMSightCameraSetting", "support continues picture focus");
                      localParameters.setFocusMode("continuous-picture");
                      paramAnonymousCamera.setParameters(localParameters);
                    }
                    AppMethodBeat.o(89363);
                    return;
                  }
                  catch (Exception paramAnonymousCamera)
                  {
                    ac.printErrStackTrace("MicroMsg.MMSightCamera", paramAnonymousCamera, "simple auto focus resetToPictureFocus error", new Object[0]);
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
            ac.printErrStackTrace("MicroMsg.MMSightCamera", localException2, "autoFocus error", new Object[0]);
          }
          localException1 = localException1;
          ac.printErrStackTrace("MicroMsg.MMSightCamera", localException1, "simple auto focus error", new Object[0]);
        }
      }
    }
  }
  
  public final List<Integer> ddt()
  {
    AppMethodBeat.i(89394);
    if (this.fFt != null) {
      try
      {
        Object localObject = this.fFt.getParameters();
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
        ac.e("MicroMsg.MMSightCamera", "getZoom error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89394);
    return null;
  }
  
  public final int ddu()
  {
    AppMethodBeat.i(89401);
    ddo();
    AppMethodBeat.o(89401);
    return 0;
  }
  
  public final void ddv()
  {
    AppMethodBeat.i(89402);
    ac.i("MicroMsg.MMSightCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[] { this.fFt, Boolean.valueOf(this.uKx) });
    if ((this.fFt != null) && (this.uKx)) {
      try
      {
        this.uKK = true;
        Camera.Parameters localParameters = this.fFt.getParameters();
        if ((!bs.gY(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("torch")))
        {
          localParameters.setFlashMode("torch");
          this.fFt.setParameters(localParameters);
          ac.i("MicroMsg.MMSightCamera", "open flash");
          AppMethodBeat.o(89402);
          return;
        }
        ac.i("MicroMsg.MMSightCamera", "camera not support flash!!");
        AppMethodBeat.o(89402);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.MMSightCamera", localException, "openFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89402);
  }
  
  public final void ddw()
  {
    AppMethodBeat.i(89403);
    ac.i("MicroMsg.MMSightCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[] { this.fFt, Boolean.valueOf(this.uKx) });
    if ((this.fFt != null) && (this.uKx)) {
      try
      {
        this.uKK = false;
        Camera.Parameters localParameters = this.fFt.getParameters();
        if ((!bs.gY(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("off")))
        {
          localParameters.setFlashMode("off");
          this.fFt.setParameters(localParameters);
          ac.i("MicroMsg.MMSightCamera", "close flash");
          AppMethodBeat.o(89403);
          return;
        }
        ac.i("MicroMsg.MMSightCamera", "camera not support close flash!!");
        AppMethodBeat.o(89403);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.MMSightCamera", localException, "closeFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89403);
  }
  
  public final void ddx()
  {
    AppMethodBeat.i(89404);
    ac.i("MicroMsg.MMSightCamera", "autoFlash, camera: %s, isPreviewing: %s", new Object[] { this.fFt, Boolean.valueOf(this.uKx) });
    if ((this.fFt != null) && (this.uKx)) {
      try
      {
        this.uKK = true;
        Camera.Parameters localParameters = this.fFt.getParameters();
        if ((!bs.gY(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("auto")))
        {
          localParameters.setFlashMode("auto");
          this.fFt.setParameters(localParameters);
          ac.i("MicroMsg.MMSightCamera", "auto flash");
          AppMethodBeat.o(89404);
          return;
        }
        ac.i("MicroMsg.MMSightCamera", "camera not support auto flash!!");
        AppMethodBeat.o(89404);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.MMSightCamera", localException, "autoFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89404);
  }
  
  public final Point getEncodeVideoBestSize()
  {
    return this.uKF;
  }
  
  public final int getOrientation()
  {
    if ((this.gXJ != null) && (this.uKx)) {
      return this.gXJ.duc;
    }
    return -1;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(89406);
    if (this.fFt == null)
    {
      AppMethodBeat.o(89406);
      return 0;
    }
    if (this.gXJ != null) {
      try
      {
        int i;
        if ((this.uKI) && (this.uKH != null)) {
          if ((this.gXJ.duc == 0) || (this.gXJ.duc == 180)) {
            i = this.uKF.y;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89406);
          return i;
          i = this.uKF.x;
          continue;
          if (this.gXK == null)
          {
            if ((this.gXJ.duc == 0) || (this.gXJ.duc == 180)) {
              i = this.gXb.qCI;
            } else {
              i = this.gXb.qCH;
            }
          }
          else if ((this.gXJ.duc == 0) || (this.gXJ.duc == 180)) {
            i = this.gXK.y;
          } else {
            i = this.gXK.x;
          }
        }
        AppMethodBeat.o(89406);
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.MMSightCamera", "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      }
    }
    return 0;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(89405);
    if (this.fFt == null)
    {
      AppMethodBeat.o(89405);
      return 0;
    }
    if (this.gXJ != null) {
      try
      {
        int i;
        if ((this.uKI) && (this.uKH != null)) {
          if ((this.gXJ.duc == 0) || (this.gXJ.duc == 180)) {
            i = this.uKF.x;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89405);
          return i;
          i = this.uKF.y;
          continue;
          if (this.gXK == null)
          {
            if ((this.gXJ.duc == 0) || (this.gXJ.duc == 180)) {
              i = this.gXb.qCH;
            } else {
              i = this.gXb.qCI;
            }
          }
          else if ((this.gXJ.duc == 0) || (this.gXJ.duc == 180)) {
            i = this.gXK.x;
          } else {
            i = this.gXK.y;
          }
        }
        AppMethodBeat.o(89405);
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.MMSightCamera", "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    return 0;
  }
  
  public final void nx(int paramInt)
  {
    AppMethodBeat.i(89397);
    if (this.gXL > 0)
    {
      AppMethodBeat.o(89397);
      return;
    }
    if (this.gXe == null) {}
    int i;
    for (Point localPoint = aj.cl(ai.getContext());; localPoint = new Point(this.gXe.getWidth(), this.gXe.getHeight()))
    {
      i = localPoint.y;
      ac.i("MicroMsg.MMSightCamera", "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localPoint });
      if (i / 2 < paramInt) {
        break;
      }
      AppMethodBeat.o(89397);
      return;
    }
    try
    {
      if (this.fFt != null)
      {
        i = this.fFt.getParameters().getMaxZoom();
        this.gXL = ((int)(i / (paramInt / 3.0D / 10.0D)) + 1);
        ac.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.gXL), Integer.valueOf(i) });
      }
      AppMethodBeat.o(89397);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.MMSightCamera", "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
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
    if ((Math.abs(this.uKB - f1) > 5.0F) || (Math.abs(this.uKC - f2) > 5.0F) || (Math.abs(this.uKD - f3) > 5.0F))
    {
      ac.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", new Object[] { Float.valueOf(5.0F), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      this.uKS.e(this.fFt);
      this.uKB = f1;
      this.uKC = f2;
      this.uKD = f3;
    }
    AppMethodBeat.o(89391);
  }
  
  public final boolean y(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(89398);
    if ((!k.uLk.uLy) || ((ae.fJd.fFb == 0) && (this.mSensorManager == null) && (this.uKA == null)))
    {
      this.mSensorManager = ((SensorManager)ai.getContext().getSystemService("sensor"));
      this.uKA = this.mSensorManager.getDefaultSensor(1);
    }
    if (this.fFt == null)
    {
      ddo();
      this.gWW = paramBoolean;
      if (paramBoolean) {}
      try
      {
        for (this.uKy = com.tencent.mm.compatible.deviceinfo.d.Xx();; this.uKy = com.tencent.mm.compatible.deviceinfo.d.Xy())
        {
          ac.i("MicroMsg.MMSightCamera", "use camera id %d, SrvDeviceInfo id %d", new Object[] { Integer.valueOf(this.uKy), Integer.valueOf(ae.fJd.fFe) });
          this.uKQ = false;
          this.mContext = paramContext;
          this.gXJ = new o().ab(paramContext, this.uKy);
          ac.i("MicroMsg.MMSightCamera", "open camera end, %s", new Object[] { Looper.myLooper() });
          if (this.gXJ != null) {
            break;
          }
          ac.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", new Object[] { Looper.myLooper() });
          atl();
          AppMethodBeat.o(89398);
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.MMSightCamera", localException, "try to get cameraid error %s, useBackCamera: %s", new Object[] { localException.getMessage(), Boolean.valueOf(this.gWW) });
          this.uKy = 0;
        }
        this.fFt = this.gXJ.fFt;
        this.uKS.gXr = false;
        this.gXb.duc = this.gXJ.duc;
        if (this.fFt == null)
        {
          ac.e("MicroMsg.MMSightCamera", "start camera FAILED!");
          atl();
          AppMethodBeat.o(89398);
          return false;
        }
      }
    }
    AppMethodBeat.o(89398);
    return true;
  }
  
  public static abstract interface b
  {
    public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public final class c
    extends ao
  {
    float fTg;
    float fTh;
    int gXo = 0;
    boolean gXp = false;
    boolean gXq = false;
    boolean gXr = false;
    int gXs;
    int gXt;
    
    public c(Looper paramLooper)
    {
      super();
    }
    
    private static int IP(int paramInt)
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
      localObject = new Rect(IP(Math.round(((RectF)localObject).left)), IP(Math.round(((RectF)localObject).top)), IP(Math.round(((RectF)localObject).right)), IP(Math.round(((RectF)localObject).bottom)));
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
          ac.e("MicroMsg.MMSightCamera", "get target zoom value error: %s", new Object[] { paramParameters.getMessage() });
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
        ac.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
        AppMethodBeat.o(89368);
        return;
      }
      if (!f.uKR)
      {
        ac.w("MicroMsg.MMSightCamera", "auto focus not back");
        AppMethodBeat.o(89368);
        return;
      }
      f.uKR = false;
      try
      {
        ac.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
        paramv.cancelAutoFocus();
        paramv.autoFocus(f.this.gXw);
        AppMethodBeat.o(89368);
        return;
      }
      catch (Exception paramv)
      {
        ac.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", new Object[] { paramv.getMessage() });
        f.uKR = true;
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
        if ((this.gXs == 0) || (this.gXt == 0) || (com.tencent.mm.compatible.util.d.la(14)))
        {
          e(paramMessage);
          AppMethodBeat.o(89370);
          return;
        }
        float f1 = this.fTg;
        float f2 = this.fTh;
        int i = this.gXs;
        j = this.gXt;
        if (paramMessage == null)
        {
          ac.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
          AppMethodBeat.o(89370);
          return;
        }
        if (!f.uKR)
        {
          ac.w("MicroMsg.MMSightCamera", "auto focus not back");
          AppMethodBeat.o(89370);
          return;
        }
        f.uKR = false;
        try
        {
          paramMessage.cancelAutoFocus();
          ac.i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
          Object localObject2 = b(f1, f2, 1.0F, i, j);
          localObject1 = b(f1, f2, 1.5F, i, j);
          ac.i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
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
          paramMessage.autoFocus(f.this.gXw);
          AppMethodBeat.o(89370);
          return;
        }
        catch (Exception paramMessage)
        {
          ac.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
          f.uKR = true;
          AppMethodBeat.o(89370);
          return;
        }
        if (this.gXr)
        {
          AppMethodBeat.o(89370);
          return;
        }
        Object localObject1 = (Camera)paramMessage.obj;
        Camera.Parameters localParameters = ((Camera)localObject1).getParameters();
        ac.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(this.gXp), Integer.valueOf(this.gXo), Integer.valueOf(localParameters.getZoom()) });
        i = localParameters.getZoom() + this.gXo;
        if (this.gXp)
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
          this.gXs = 0;
          this.gXt = 0;
          continue;
          paramMessage = obtainMessage(4353, paramMessage.obj);
          if (this.gXq) {}
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
          if (this.gXq) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.f
 * JD-Core Version:    0.7.0.1
 */