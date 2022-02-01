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
import com.tencent.mm.g.a.os;
import com.tencent.mm.g.a.os.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class f
  implements SensorEventListener
{
  protected static int vNF = 2147483647;
  static boolean vNX = true;
  protected boolean aYh;
  protected v fYS;
  Camera.AutoFocusCallback hpC;
  protected List<g> hpN;
  protected d.a.a hpP;
  protected Point hpQ;
  protected int hpR;
  protected int hpS;
  private c hpT;
  private c hpU;
  private c hpV;
  private c hpW;
  private c hpX;
  public volatile boolean hpY;
  public volatile byte[] hpZ;
  protected boolean hpc;
  protected q hph;
  protected Size hpk;
  protected boolean hpv;
  protected Context mContext;
  protected SensorManager mSensorManager;
  private int scene;
  protected boolean vND;
  protected int vNE;
  protected Sensor vNG;
  protected float vNH;
  protected float vNI;
  protected float vNJ;
  protected Point vNK;
  protected Point vNL;
  protected int vNM;
  protected byte[] vNN;
  protected boolean vNO;
  protected com.tencent.mm.plugin.base.model.a vNP;
  protected boolean vNQ;
  protected boolean vNR;
  private f.a vNS;
  private c vNT;
  protected VideoTransPara vNU;
  public boolean vNV;
  private boolean vNW;
  public c vNY;
  
  public f(VideoTransPara paramVideoTransPara, int paramInt)
  {
    AppMethodBeat.i(89371);
    this.hpS = -1;
    this.hpR = -1;
    this.hpv = false;
    this.aYh = false;
    this.fYS = null;
    this.vND = false;
    this.vNE = 0;
    this.vNH = 0.0F;
    this.vNI = 0.0F;
    this.vNJ = 0.0F;
    this.mContext = null;
    this.vNK = null;
    this.vNL = null;
    this.hpQ = null;
    this.vNM = 0;
    this.vNO = false;
    this.vNP = new com.tencent.mm.plugin.base.model.a();
    this.vNQ = false;
    this.hpN = new ArrayList();
    this.vNR = false;
    this.hpk = null;
    this.vNS = f.a.vOa;
    this.hpT = new c("prevcameraCallback");
    this.hpU = new c("cameraCallback");
    this.hpV = new c("cameraPreviewCallback");
    this.hpW = new c("cameraCropCallback");
    this.vNT = new c("mirrorCameraCallback");
    this.hpX = new c("finishCallbackTimeCallback");
    this.scene = 0;
    this.hpZ = null;
    this.hpY = false;
    this.vNV = false;
    this.vNW = false;
    this.hpC = new Camera.AutoFocusCallback()
    {
      public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(89362);
        ad.v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), f.f(f.this) });
        f.vNX = true;
        AppMethodBeat.o(89362);
      }
    };
    this.vNY = new c(Looper.getMainLooper());
    this.hpc = true;
    this.hph = q.dnf();
    this.vNU = paramVideoTransPara;
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
          ad.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
          paramv.setParameters(localParameters);
          AppMethodBeat.o(89381);
          return true;
        }
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          ad.i("MicroMsg.MMSightCameraSetting", "support continuous video");
          localParameters.setFocusMode("continuous-video");
          continue;
        }
        if (localList == null) {
          break label167;
        }
      }
      catch (Exception paramv)
      {
        ad.i("MicroMsg.MMSightCameraSetting", "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
        AppMethodBeat.o(89381);
        return false;
      }
      if (localList.contains("auto"))
      {
        ad.i("MicroMsg.MMSightCameraSetting", "support auto focus");
        localParameters.setFocusMode("auto");
      }
      else
      {
        label167:
        ad.i("MicroMsg.MMSightCameraSetting", "not support continuous video or auto focus");
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
        if (this.hpk == null)
        {
          localObject = al.ci(aj.getContext());
          Point localPoint = new Point(Math.min(((Point)localObject).x, ((Point)localObject).y), Math.max(((Point)localObject).x, ((Point)localObject).y));
          ad.i("MicroMsg.MMSightCamera", "screenSize: %s, currentScreenSize: %s", new Object[] { localPoint, localObject });
          float f1 = Math.min(localPoint.x, localPoint.y) / Math.max(localPoint.x, localPoint.y);
          f2 = 1.0F / paramFloat;
          if (paramFloat >= 1.0F) {
            break label709;
          }
          i = paramInt;
          ad.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[] { Integer.valueOf(i), Float.valueOf(paramFloat), Float.valueOf(f1) });
          if (this.hpP.dGc == 90) {
            break label756;
          }
          if (this.hpP.dGc != 270) {
            break label768;
          }
          break label756;
          h.c localc = h.a(localParameters, localPoint, i, bool);
          if (localc != null)
          {
            localObject = localc;
            if (localc.vOe != null) {}
          }
          else
          {
            ad.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
            if (this.hpP.dGc == 90) {
              break label762;
            }
            if (this.hpP.dGc != 270) {
              break label774;
            }
            break label762;
            localObject = h.d(localParameters, localPoint, paramInt, bool);
            this.vNV = false;
          }
          if ((localObject != null) && (((h.c)localObject).vOe != null))
          {
            paramInt = (int)(((h.c)localObject).vOe.x * paramFloat);
            ad.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio result preview size: %s, cropHeight: %s", new Object[] { ((h.c)localObject).vOe, Integer.valueOf(paramInt) });
            if (paramInt > ((h.c)localObject).vOe.y) {
              break label726;
            }
            this.vNV = false;
          }
          if ((localObject != null) && (((h.c)localObject).vOe != null))
          {
            localObject = ((h.c)localObject).vOe;
            this.hph.rmx = ((Point)localObject).x;
            this.hph.rmy = ((Point)localObject).y;
            this.vNL = ((Point)localObject);
            this.hpQ = null;
            if (!paramBoolean)
            {
              if ((k.vOq.gbj != 2) || (com.tencent.mm.plugin.mmsight.d.Kh(this.vNL.y))) {
                break label745;
              }
              paramInt = com.tencent.mm.plugin.mmsight.d.Ki(this.vNL.y);
              if (Math.abs(paramInt - this.vNL.y) > 16) {
                break label734;
              }
              ad.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.vNL, Integer.valueOf(paramInt) });
              this.vNK = new Point(this.vNL.x, this.vNL.y);
              this.vNL.y = paramInt;
              this.vNO = true;
              this.vNN = new byte[this.vNL.x * this.vNL.y * 3 / 2];
            }
            ad.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s, cropWidth: %s", new Object[] { localObject, this.vNL, this.hpQ, Boolean.valueOf(this.vNV) });
            localParameters.setPreviewSize(this.hph.rmx, this.hph.rmy);
            paramv.setParameters(localParameters);
            AppMethodBeat.o(89377);
            return true;
          }
        }
        else
        {
          localObject = new Point(this.hpk.getWidth(), this.hpk.getHeight());
          continue;
        }
        f2 = paramInt / f2;
      }
      catch (Exception paramv)
      {
        ad.e("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimit error: %s", new Object[] { paramv.getMessage() });
        AppMethodBeat.o(89377);
        return false;
      }
      label709:
      int i = Math.round(f2);
      continue;
      label726:
      this.vNV = true;
      continue;
      label734:
      k.g(this.vNL);
      continue;
      label745:
      k.g(this.vNL);
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
          if (ae.gcE.fYs > 0)
          {
            ad.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview frame rate");
            ad.i("MicroMsg.MMSightCameraSetting", "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), localParameters.getSupportedPreviewFrameRates() });
            paramv.setParameters(localParameters);
            AppMethodBeat.o(89379);
            return true;
          }
          if (localParameters == null)
          {
            ad.e("MicroMsg.MMSightCamera", "trySetPreviewFrameRateParameters error, p is null!");
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
            ad.i("MicroMsg.MMSightCameraSetting", "set preview frame rate %d", new Object[] { Integer.valueOf(i) });
          }
          catch (Exception localException1)
          {
            ad.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException1.getMessage() });
          }
        }
        catch (Exception paramv)
        {
          ad.i("MicroMsg.MMSightCameraSetting", "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
          AppMethodBeat.o(89379);
          return false;
        }
        continue;
        if (ae.gcE.fYs <= 0) {
          break;
        }
        ad.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview fps range");
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
          ad.i("MicroMsg.MMSightCamera", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4) });
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
        ad.i("MicroMsg.MMSightCameraSetting", "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(30) });
        if ((j == 2147483647) || (i == 2147483647)) {
          break;
        }
        try
        {
          localParameters.setPreviewFpsRange(j, i);
          ad.i("MicroMsg.MMSightCameraSetting", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        }
        catch (Exception localException2)
        {
          ad.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException2.getMessage() });
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
  
  private void avY()
  {
    AppMethodBeat.i(89388);
    if (true == this.vNW)
    {
      AppMethodBeat.o(89388);
      return;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(89388);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.d.b.abb()))
    {
      AppMethodBeat.o(89388);
      return;
    }
    Object localObject = new os();
    ((os)localObject).dCJ.type = 2;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    if (((os)localObject).dCK.dCI)
    {
      this.vNW = true;
      AppMethodBeat.o(89388);
      return;
    }
    localObject = com.tencent.mm.ui.base.h.l(this.mContext, 2131763668, 2131755906);
    if (localObject != null)
    {
      ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
      ((com.tencent.mm.ui.widget.a.d)localObject).setCanceledOnTouchOutside(false);
      ((com.tencent.mm.ui.widget.a.d)localObject).show();
      this.vNW = true;
    }
    AppMethodBeat.o(89388);
  }
  
  private void awn()
  {
    AppMethodBeat.i(89384);
    if (this.fYS != null) {
      try
      {
        Object localObject = this.fYS.getParameters();
        ad.i("MicroMsg.MMSightCamera", "setPreviewCallbackImpl");
        int i = this.hph.rmx;
        int j = this.hph.rmy;
        j = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject).getPreviewFormat()) * (i * j) / 8;
        i = 0;
        while (i < 5)
        {
          localObject = com.tencent.mm.plugin.mmsight.model.a.k.vQc.g(Integer.valueOf(j));
          this.fYS.addCallbackBuffer((byte[])localObject);
          i += 1;
        }
        this.hpT.reset();
        this.hpU.reset();
        this.hpV.reset();
        this.hpW.reset();
        this.vNT.reset();
        this.hpX.reset();
        this.vNP = new com.tencent.mm.plugin.base.model.a();
        this.fYS.setPreviewCallbackWithBuffer(new Camera.PreviewCallback()
        {
          public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
          {
            AppMethodBeat.i(89361);
            if (!f.this.vNR)
            {
              ad.i("MicroMsg.MMSightCamera", "onPreviewFrame: %s %s", new Object[] { paramAnonymousArrayOfByte, f.this.fYS });
              f.this.vNR = true;
            }
            if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
            {
              ad.e("MicroMsg.MMSightCamera", "onPreviewFrame, frame data is null!!");
              AppMethodBeat.o(89361);
              return;
            }
            paramAnonymousCamera = f.this.vNP;
            if (paramAnonymousCamera.nMK == 0)
            {
              paramAnonymousCamera.nMJ += 1;
              paramAnonymousCamera.nMI = bt.aRe(m.aah());
            }
            paramAnonymousCamera.nMK += 1;
            int i;
            long l1;
            byte[] arrayOfByte;
            label367:
            long l2;
            int j;
            boolean bool;
            if (paramAnonymousCamera.nMK >= 90)
            {
              i = 0;
              paramAnonymousCamera.nMK = i;
              if ((f.a(f.this)) || (f.this.hpN == null) || (f.this.hpN.size() <= 0)) {
                break label944;
              }
              if (f.this.hpQ == null) {
                break label584;
              }
              paramAnonymousCamera = com.tencent.mm.plugin.mmsight.model.a.k.vQc.g(Integer.valueOf(f.this.hph.rmx * f.this.hpQ.y * 3 / 2));
              f.b(f.this).yf(1L);
              l1 = bt.HI();
              SightVideoJNI.cropCameraData(paramAnonymousArrayOfByte, paramAnonymousCamera, f.this.hph.rmx, f.this.hph.rmy, f.this.hpQ.y);
              if (f.this.hpQ.x >= f.this.hph.rmx) {
                break label941;
              }
              arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.k.vQc.g(Integer.valueOf(f.this.hpQ.x * f.this.hpQ.y * 3 / 2));
              SightVideoJNI.cropCameraDataLongEdge(paramAnonymousCamera, arrayOfByte, f.this.hph.rmx, f.this.hpQ.x, f.this.hpQ.y);
              com.tencent.mm.plugin.mmsight.model.a.k.vQc.k(paramAnonymousCamera);
              paramAnonymousCamera = arrayOfByte;
              l2 = bt.aO(l1);
              f.c(f.this).yf(l2);
              if (!f.this.hpc)
              {
                l1 = bt.HI();
                i = f.this.hpQ.x;
                j = f.this.hpQ.y;
                if ((f.this.hpP.dGc != 270) && (f.this.hpP.dGc != 90)) {
                  break label578;
                }
                bool = true;
                label458:
                SightVideoJNI.mirrorCameraData(paramAnonymousCamera, i, j, bool);
                l2 = bt.aO(l1);
                f.d(f.this).yf(l2);
              }
              bool = f.a(f.this, paramAnonymousCamera);
              l1 = bt.aO(l1);
              if (bool) {
                f.e(f.this).yf(l1);
              }
            }
            for (;;)
            {
              f.b(f.this, paramAnonymousCamera);
              if (f.f(f.this) == f.a.vOa) {
                f.g(f.this).yf(1L);
              }
              for (;;)
              {
                f.this.fYS.addCallbackBuffer(paramAnonymousArrayOfByte);
                AppMethodBeat.o(89361);
                return;
                i = paramAnonymousCamera.nMK;
                break;
                label578:
                bool = false;
                break label458;
                label584:
                l1 = bt.HI();
                label656:
                label753:
                f localf;
                if (!f.this.hpc)
                {
                  i = f.this.hph.rmx;
                  j = f.this.hph.rmy;
                  if ((f.this.hpP.dGc == 270) || (f.this.hpP.dGc == 90))
                  {
                    bool = true;
                    SightVideoJNI.mirrorCameraData(paramAnonymousArrayOfByte, i, j, bool);
                    l2 = bt.aO(l1);
                    f.d(f.this).yf(l2);
                  }
                }
                else
                {
                  if ((!f.this.vNO) || (f.this.vNN == null)) {
                    break label898;
                  }
                  SightVideoJNI.paddingYuvData16(paramAnonymousArrayOfByte, f.this.vNN, f.this.vNL.x, f.this.vNK.y, f.this.vNL.y);
                  paramAnonymousCamera = f.this.vNN;
                  bool = f.a(f.this, paramAnonymousCamera);
                  l1 = bt.aO(l1);
                  if (bool) {
                    f.e(f.this).yf(l1);
                  }
                  if (f.this.vNO)
                  {
                    arrayOfByte = paramAnonymousArrayOfByte;
                    if (f.this.vNN != null) {}
                  }
                  else
                  {
                    arrayOfByte = paramAnonymousArrayOfByte;
                    if (bool) {
                      arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.k.vQc.g(Integer.valueOf(paramAnonymousArrayOfByte.length));
                    }
                  }
                  if ((f.this.vNO) && (f.this.vNN != null))
                  {
                    localf = f.this;
                    if (!bool) {
                      break label903;
                    }
                  }
                }
                label898:
                label903:
                for (paramAnonymousArrayOfByte = com.tencent.mm.plugin.mmsight.model.a.k.vQc.g(Integer.valueOf(f.this.vNN.length));; paramAnonymousArrayOfByte = f.this.vNN)
                {
                  localf.vNN = paramAnonymousArrayOfByte;
                  paramAnonymousArrayOfByte = arrayOfByte;
                  break;
                  bool = false;
                  break label656;
                  paramAnonymousCamera = paramAnonymousArrayOfByte;
                  break label753;
                }
                if (f.f(f.this) == f.a.vOb) {
                  f.h(f.this).yf(1L);
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
        ad.e("MicroMsg.MMSightCamera", "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89384);
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
      ad.i("MicroMsg.MMSightCameraSetting", "safeSetPreviewFormat");
      Camera.Parameters localParameters = paramv.getParameters();
      List localList = localParameters.getSupportedPreviewFormats();
      if ((localList == null) || (!localList.contains(Integer.valueOf(17)))) {
        ad.e("MicroMsg.MMSightCameraSetting", "not support YCbCr_420_SP");
      }
      localParameters.setPreviewFormat(17);
      paramv.setParameters(localParameters);
      AppMethodBeat.o(89380);
      return true;
    }
    catch (Exception paramv)
    {
      ad.i("MicroMsg.MMSightCameraSetting", "setPreviewFormat Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
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
        if (this.hpk == null)
        {
          localPoint = com.tencent.mm.plugin.mmsight.d.fM(this.mContext);
          if (this.hpc)
          {
            localObject1 = b.dmG();
            localObject2 = localParameters.getSupportedPreviewSizes();
            localObject3 = localParameters.getSupportedPictureSizes();
            i = this.hpP.dGc;
            if (bt.isNullOrNil(((b)localObject1).vNc)) {
              ((b)localObject1).vNc = com.tencent.mm.plugin.mmsight.d.ex((List)localObject2);
            }
            if (bt.isNullOrNil(((b)localObject1).vNd)) {
              ((b)localObject1).vNd = com.tencent.mm.plugin.mmsight.d.ex((List)localObject3);
            }
            ((b)localObject1).dGc = i;
            ((b)localObject1).vNx = 1;
            if (paramBoolean)
            {
              if (this.hpP.dGc == 90) {
                break label2498;
              }
              if (this.hpP.dGc != 270) {
                break label501;
              }
              break label2498;
              k.a(localParameters, bool);
            }
            com.tencent.mm.plugin.mmsight.model.a.l.dno();
            i = com.tencent.mm.plugin.mmsight.model.a.l.dnr();
            if (this.hpP.dGc == 90) {
              break label2504;
            }
            if (this.hpP.dGc != 270) {
              break label507;
            }
            break label2504;
            label206:
            localObject2 = h.a(localParameters, localPoint, i, bool);
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((h.c)localObject2).vOe != null) {}
            }
            else
            {
              ad.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
              localPoint = new Point(Math.min(localPoint.x, localPoint.y), Math.max(localPoint.x, localPoint.y));
              if (this.hpP.dGc == 90) {
                break label2510;
              }
              if (this.hpP.dGc != 270) {
                break label513;
              }
              break label2510;
              label308:
              localObject1 = h.d(localParameters, localPoint, 2100, bool);
              this.vNV = false;
            }
            k.a((h.c)localObject1);
            localPoint = ((h.c)localObject1).vOe;
            if (localPoint != null) {
              break;
            }
            l.awB();
            AppMethodBeat.o(89376);
            return false;
          }
        }
        else
        {
          localPoint = new Point(this.hpk.getWidth(), this.hpk.getHeight());
          continue;
        }
        localObject1 = b.dmG();
        localObject2 = localParameters.getSupportedPreviewSizes();
        localObject3 = localParameters.getSupportedPictureSizes();
        i = this.hpP.dGc;
        if (bt.isNullOrNil(((b)localObject1).vNe)) {
          ((b)localObject1).vNe = com.tencent.mm.plugin.mmsight.d.ex((List)localObject2);
        }
        if (bt.isNullOrNil(((b)localObject1).vNf)) {
          ((b)localObject1).vNf = com.tencent.mm.plugin.mmsight.d.ex((List)localObject3);
        }
        ((b)localObject1).dGc = i;
        ((b)localObject1).vNx = 2;
        continue;
        bool = false;
      }
      catch (Exception paramv)
      {
        ad.i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
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
    this.hph.rmx = localPoint.x;
    this.hph.rmy = localPoint.y;
    this.vNL = localPoint;
    Object localObject2 = this.mContext;
    if (this.hpP.dGc != 90) {
      if (this.hpP.dGc == 270)
      {
        break label2516;
        label583:
        bool = com.tencent.mm.plugin.mmsight.d.a((Context)localObject2, localPoint, bool);
        i = 1;
        if ((this.hpP.dGc != 90) && (this.hpP.dGc != 270)) {
          break label1348;
        }
        if ((localPoint.y < this.vNU.width) || (localPoint.x < this.vNU.height))
        {
          i = 0;
          ad.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localPoint });
        }
        label673:
        ad.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label1434;
        }
        if (k.vOq.gbj != 2) {
          break label1422;
        }
        this.hpQ = ((h.c)localObject1).vOg;
        if ((this.hpQ.x < localPoint.x) || (this.hpQ.y < localPoint.y))
        {
          if ((this.hpP.dGc != 90) && (this.hpP.dGc != 270)) {
            break label1402;
          }
          this.hpQ.y = com.tencent.mm.plugin.mmsight.d.Kj(this.hpQ.y);
        }
        label789:
        this.vNL = new Point(this.hpQ.x, this.hpQ.y);
        this.vNM = (this.hpQ.x * this.hpQ.y * 3 / 2);
        ad.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", new Object[] { this.hpQ });
      }
    }
    label856:
    label2522:
    for (;;)
    {
      int j;
      int k;
      if (k.vOq.vOD)
      {
        if ((this.hpP.dGc != 90) && (this.hpP.dGc != 270)) {
          break label2035;
        }
        if (i != 0)
        {
          if (k.vOq.hpj != 1080) {
            break label1863;
          }
          if (this.hpQ != null) {
            break label1811;
          }
          j = localPoint.x / 2;
          if (this.hpQ != null) {
            break label1825;
          }
          i = localPoint.y / 2;
          if (this.hpQ != null) {
            break label1839;
          }
          k = localPoint.x;
          k = com.tencent.mm.plugin.mmsight.d.gy(j, k);
          if (this.hpQ != null) {
            break label1851;
          }
          j = localPoint.y;
          this.vNL = new Point(k, com.tencent.mm.plugin.mmsight.d.gy(i, j));
        }
      }
      label996:
      localObject1 = b.dmG();
      localObject2 = this.hpQ;
      localObject3 = this.vNL;
      ((b)localObject1).vNl = -1;
      ((b)localObject1).vNk = -1;
      ((b)localObject1).vNh = -1;
      ((b)localObject1).vNg = -1;
      ((b)localObject1).vNj = -1;
      ((b)localObject1).vNi = -1;
      if (localPoint != null)
      {
        ((b)localObject1).vNi = localPoint.x;
        ((b)localObject1).vNj = localPoint.y;
      }
      if (localObject2 != null)
      {
        ((b)localObject1).vNg = ((Point)localObject2).x;
        ((b)localObject1).vNh = ((Point)localObject2).y;
      }
      if (localObject3 != null)
      {
        ((b)localObject1).vNk = ((Point)localObject3).x;
        ((b)localObject1).vNl = ((Point)localObject3).y;
      }
      if (paramBoolean) {
        if ((!bool) && (k.vOq.gbj == 2) && (!com.tencent.mm.plugin.mmsight.d.Kh(this.vNL.y)))
        {
          i = com.tencent.mm.plugin.mmsight.d.Ki(this.vNL.y);
          if (Math.abs(i - this.vNL.y) <= 16)
          {
            ad.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.vNL, Integer.valueOf(i) });
            this.vNK = new Point(this.vNL.x, this.vNL.y);
            this.vNL.y = i;
            this.vNO = true;
            this.vNN = new byte[this.vNL.x * this.vNL.y * 3 / 2];
          }
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", new Object[] { localPoint, this.vNL, this.hpQ });
        localParameters.setPreviewSize(this.hph.rmx, this.hph.rmy);
        paramv.setParameters(localParameters);
        AppMethodBeat.o(89376);
        return true;
        bool = false;
        break;
        if ((localPoint.x >= this.vNU.width) && (localPoint.y >= this.vNU.height)) {
          break label673;
        }
        i = 0;
        ad.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localPoint });
        break label673;
        label1402:
        this.hpQ.x = com.tencent.mm.plugin.mmsight.d.Kj(this.hpQ.x);
        break label789;
        this.hpQ = ((h.c)localObject1).vOf;
        break label789;
        if ((!k.vOq.vOD) || (k.vOq.hpj != 1080) || (i == 0)) {
          break label2495;
        }
        if ((this.hpP.dGc == 90) || (this.hpP.dGc == 270))
        {
          j = localPoint.y / 2;
          k = com.tencent.mm.plugin.mmsight.d.Ki(j);
          m = localPoint.x / 2;
          n = com.tencent.mm.plugin.mmsight.d.Ki(m);
          if ((Math.abs(k - j) < 8) && (Math.abs(n - m) < 8)) {
            break label2522;
          }
          this.hpQ = new Point(localPoint.x, localPoint.y);
          this.hpQ.y = com.tencent.mm.plugin.mmsight.d.Kj(localPoint.y);
          this.hpQ.x = com.tencent.mm.plugin.mmsight.d.Kj(localPoint.x);
          this.vNL = new Point(this.hpQ.x, this.hpQ.y);
          this.vNM = (this.hpQ.x * this.hpQ.y * 3 / 2);
          bool = true;
          break label2522;
        }
        j = localPoint.x / 2;
        k = com.tencent.mm.plugin.mmsight.d.Ki(j);
        int m = localPoint.y / 2;
        int n = com.tencent.mm.plugin.mmsight.d.Ki(m);
        if ((Math.abs(k - j) < 8) && (Math.abs(n - m) < 8)) {
          break label2495;
        }
        this.hpQ = new Point(localPoint.x, localPoint.y);
        this.hpQ.y = com.tencent.mm.plugin.mmsight.d.Kj(localPoint.x);
        this.hpQ.x = com.tencent.mm.plugin.mmsight.d.Kj(localPoint.y);
        this.vNL = new Point(this.hpQ.x, this.hpQ.y);
        this.vNM = (this.hpQ.x * this.hpQ.y * 3 / 2);
        bool = true;
        break label856;
        j = this.hpQ.x / 2;
        break label923;
        i = this.hpQ.y / 2;
        break label939;
        k = this.hpQ.x;
        break label953;
        j = this.hpQ.y;
        break label976;
        if (k.vOq.hpj != 720) {
          break label996;
        }
        float f;
        if (this.hpQ == null)
        {
          f = localPoint.x * 0.75F;
          label1893:
          k = (int)f;
          if (this.hpQ != null) {
            break label1995;
          }
          f = localPoint.y * 0.75F;
          label1915:
          j = (int)f;
          if (this.hpQ != null) {
            break label2011;
          }
          i = localPoint.x;
          k = com.tencent.mm.plugin.mmsight.d.gy(k, i);
          if (this.hpQ != null) {
            break label2023;
          }
        }
        label2011:
        label2023:
        for (i = localPoint.y;; i = this.hpQ.y)
        {
          this.vNL = new Point(k, com.tencent.mm.plugin.mmsight.d.gy(j, i));
          break;
          f = this.hpQ.x * 0.75F;
          break label1893;
          f = this.hpQ.y * 0.75F;
          break label1915;
          i = this.hpQ.x;
          break label1933;
        }
        label2035:
        if (i == 0) {
          break label996;
        }
        if (k.vOq.hpj == 1080)
        {
          if (this.hpQ == null)
          {
            j = localPoint.y / 2;
            if (this.hpQ != null) {
              break label2158;
            }
            i = localPoint.x / 2;
            if (this.hpQ != null) {
              break label2172;
            }
            k = localPoint.y;
            k = com.tencent.mm.plugin.mmsight.d.gy(j, k);
            if (this.hpQ != null) {
              break label2184;
            }
          }
          for (j = localPoint.x;; j = this.hpQ.x)
          {
            this.vNL = new Point(k, com.tencent.mm.plugin.mmsight.d.gy(i, j));
            break;
            j = this.hpQ.y / 2;
            break label2068;
            label2158:
            i = this.hpQ.x / 2;
            break label2084;
            label2172:
            k = this.hpQ.y;
            break label2098;
          }
        }
        if (k.vOq.hpj != 720) {
          break label996;
        }
        if (this.hpQ == null)
        {
          f = localPoint.y * 0.75F;
          k = (int)f;
          if (this.hpQ != null) {
            break label2328;
          }
          f = localPoint.x * 0.75F;
          j = (int)f;
          if (this.hpQ != null) {
            break label2344;
          }
          i = localPoint.y;
          label2266:
          k = com.tencent.mm.plugin.mmsight.d.gy(k, i);
          if (this.hpQ != null) {
            break label2356;
          }
        }
        for (i = localPoint.x;; i = this.hpQ.x)
        {
          this.vNL = new Point(k, com.tencent.mm.plugin.mmsight.d.gy(j, i));
          break;
          f = this.hpQ.y * 0.75F;
          break label2226;
          f = this.hpQ.x * 0.75F;
          break label2248;
          i = this.hpQ.y;
          break label2266;
        }
        k.g(this.vNL);
        continue;
        k.g(this.vNL);
        continue;
        if ((!bool) && (k.vOq.gbj == 2) && (!com.tencent.mm.plugin.mmsight.d.Kh(this.vNL.y)) && (this.vNO) && (this.vNN != null) && (this.vNK.y == this.vNL.y))
        {
          i = com.tencent.mm.plugin.mmsight.d.Ki(this.vNL.y);
          if (this.vNN.length == this.vNL.x * i * 3 / 2) {
            this.vNL.y = i;
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
      ad.i("MicroMsg.MMSightCameraSetting", "safeSetMetering");
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
      ad.i("MicroMsg.MMSightCameraSetting", "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramv.getMessage() });
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
      ad.e("MicroMsg.MMSightCamera", "safeResetZoom error: %s", new Object[] { paramv.getMessage() });
      AppMethodBeat.o(89387);
    }
  }
  
  private void dmK()
  {
    AppMethodBeat.i(89375);
    try
    {
      if ((this.mSensorManager != null) && (this.vNG != null)) {
        this.mSensorManager.unregisterListener(this);
      }
      ad.i("MicroMsg.MMSightCamera", this.hpT.getValue());
      ad.i("MicroMsg.MMSightCamera", this.hpU.getValue());
      ad.i("MicroMsg.MMSightCamera", this.hpV.getValue());
      ad.i("MicroMsg.MMSightCamera", this.hpW.getValue());
      ad.i("MicroMsg.MMSightCamera", this.vNT.getValue());
      ad.i("MicroMsg.MMSightCamera", this.hpX.getValue());
      if (this.fYS != null)
      {
        long l = bt.HI();
        ad.i("MicroMsg.MMSightCamera", "release camera beg, %s", new Object[] { Looper.myLooper() });
        this.vNY.removeCallbacksAndMessages(null);
        this.vNY.hpx = true;
        this.fYS.setPreviewCallback(null);
        this.fYS.stopPreview();
        this.fYS.release();
        this.fYS = null;
        this.vND = false;
        ad.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", new Object[] { Long.valueOf(bt.aO(l)), Looper.myLooper() });
      }
      this.hpv = false;
      this.vNH = 0.0F;
      this.vNI = 0.0F;
      this.vNJ = 0.0F;
      vNX = true;
      this.mContext = null;
      this.vNW = false;
      this.vNL = null;
      this.hpQ = null;
      this.hpZ = null;
      this.vNR = false;
      AppMethodBeat.o(89375);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MMSightCamera", localException, "cameraRelease error", new Object[0]);
      AppMethodBeat.o(89375);
    }
  }
  
  public final boolean A(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(89398);
    if ((!k.vOq.vOE) || ((ae.gcE.fYA == 0) && (this.mSensorManager == null) && (this.vNG == null)))
    {
      this.mSensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
      this.vNG = this.mSensorManager.getDefaultSensor(1);
    }
    if (this.fYS == null)
    {
      dmK();
      this.hpc = paramBoolean;
      if (paramBoolean) {}
      try
      {
        for (this.vNE = com.tencent.mm.compatible.deviceinfo.d.ZY();; this.vNE = com.tencent.mm.compatible.deviceinfo.d.ZZ())
        {
          ad.i("MicroMsg.MMSightCamera", "use camera id %d, SrvDeviceInfo id %d", new Object[] { Integer.valueOf(this.vNE), Integer.valueOf(ae.gcE.fYD) });
          this.vNW = false;
          this.mContext = paramContext;
          this.hpP = new o().ae(paramContext, this.vNE);
          ad.i("MicroMsg.MMSightCamera", "open camera end, %s", new Object[] { Looper.myLooper() });
          if (this.hpP != null) {
            break;
          }
          ad.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", new Object[] { Looper.myLooper() });
          avY();
          AppMethodBeat.o(89398);
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.MMSightCamera", localException, "try to get cameraid error %s, useBackCamera: %s", new Object[] { localException.getMessage(), Boolean.valueOf(this.hpc) });
          this.vNE = 0;
        }
        this.fYS = this.hpP.fYS;
        this.vNY.hpx = false;
        this.hph.dGc = this.hpP.dGc;
        if (this.fYS == null)
        {
          ad.e("MicroMsg.MMSightCamera", "start camera FAILED!");
          avY();
          AppMethodBeat.o(89398);
          return false;
        }
      }
    }
    AppMethodBeat.o(89398);
    return true;
  }
  
  public final void Kl(int paramInt)
  {
    AppMethodBeat.i(89395);
    if (this.fYS != null) {
      try
      {
        Camera.Parameters localParameters = this.fYS.getParameters();
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
          ad.d("MicroMsg.MMSightCamera", "setForceZoomTargetRatio, zooming, ignore");
          return;
        }
        this.aYh = true;
        localParameters.setZoom(paramInt);
        this.fYS.setParameters(localParameters);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.MMSightCamera", "getZoom error: %s", new Object[] { localException.getMessage() });
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
    long l = bt.HI();
    this.vNR = false;
    ad.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s", new Object[] { Boolean.valueOf(this.vND), Looper.myLooper(), paramSurfaceTexture });
    if (this.vND)
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
    ad.i("MicroMsg.MMSightCamera", "this texture %s", new Object[] { paramSurfaceTexture });
    for (;;)
    {
      try
      {
        a(this.fYS, paramInt, paramFloat, paramBoolean);
        if (com.tencent.mm.plugin.mmsight.model.a.l.dno().vQe == null) {
          break label654;
        }
        localInteger = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.l.dno().vQe.vMM);
        if (ae.gcE.fYx == 1)
        {
          str = "Range";
          if (ae.gcE.fYy != 1) {
            break label671;
          }
          paramBoolean = true;
          if (ae.gcE.fYz != 1) {
            break label677;
          }
          bool1 = true;
          if (ae.gcE.fYA != 1) {
            break label683;
          }
          bool2 = true;
          if (ae.gcE.fYB != 1) {
            break label689;
          }
          bool3 = true;
          ad.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((ae.gcE.fYx == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            a(this.fYS, false);
            if ((ae.gcE.fYy == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              b(this.fYS);
            }
            if ((ae.gcL.gbr != -1) && (ae.gcL.gbr == 1) && (com.tencent.mm.compatible.util.d.lA(14))) {
              c(this.fYS);
            }
            if ((ae.gcE.fYA == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              a(this.fYS);
            }
            if ((ae.gcE.fYB == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            d(this.fYS);
            awn();
            this.fYS.setPreviewTexture(paramSurfaceTexture);
            this.fYS.startPreview();
            if (!k.vOq.vOE) {
              break label637;
            }
            if ((ae.gcE.fYA == 0) && (this.mSensorManager != null) && (this.vNG != null)) {
              this.mSensorManager.registerListener(this, this.vNG, 2);
            }
            this.vND = true;
            ad.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(bt.aO(l)), Looper.myLooper() });
            AppMethodBeat.o(89386);
            return 0;
          }
        }
        else
        {
          if (ae.gcE.fYw != 1) {
            break label663;
          }
          str = "Fix";
          continue;
        }
        if ((ae.gcE.fYw != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        a(this.fYS, true);
        continue;
        this.mSensorManager.registerListener(this, this.vNG, 2);
      }
      catch (Exception paramSurfaceTexture)
      {
        ad.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
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
    long l = bt.HI();
    this.vNR = false;
    ad.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", new Object[] { Boolean.valueOf(this.vND), Looper.myLooper(), paramSurfaceTexture, Boolean.valueOf(paramBoolean) });
    if (this.vND)
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
    ad.i("MicroMsg.MMSightCamera", "this texture %s", new Object[] { paramSurfaceTexture });
    for (;;)
    {
      try
      {
        b(this.fYS, paramBoolean);
        if (com.tencent.mm.plugin.mmsight.model.a.l.dno().vQe == null) {
          break label656;
        }
        localInteger = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.l.dno().vQe.vMM);
        if (ae.gcE.fYx == 1)
        {
          str = "Range";
          if (ae.gcE.fYy != 1) {
            break label673;
          }
          paramBoolean = true;
          if (ae.gcE.fYz != 1) {
            break label678;
          }
          bool1 = true;
          if (ae.gcE.fYA != 1) {
            break label684;
          }
          bool2 = true;
          if (ae.gcE.fYB != 1) {
            break label690;
          }
          bool3 = true;
          ad.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((ae.gcE.fYx == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            a(this.fYS, false);
            if ((ae.gcE.fYy == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              b(this.fYS);
            }
            if ((ae.gcL.gbr != -1) && (ae.gcL.gbr == 1) && (com.tencent.mm.compatible.util.d.lA(14))) {
              c(this.fYS);
            }
            if ((ae.gcE.fYA == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              a(this.fYS);
            }
            if ((ae.gcE.fYB == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            d(this.fYS);
            awn();
            this.fYS.setPreviewTexture(paramSurfaceTexture);
            this.fYS.startPreview();
            if (!k.vOq.vOE) {
              break label639;
            }
            if ((ae.gcE.fYA == 0) && (this.mSensorManager != null) && (this.vNG != null)) {
              this.mSensorManager.registerListener(this, this.vNG, 2);
            }
            this.vND = true;
            ad.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(bt.aO(l)), Looper.myLooper() });
            AppMethodBeat.o(89385);
            return 0;
          }
        }
        else
        {
          if (ae.gcE.fYw != 1) {
            break label665;
          }
          str = "Fix";
          continue;
        }
        if ((ae.gcE.fYw != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        a(this.fYS, true);
        continue;
        this.mSensorManager.registerListener(this, this.vNG, 2);
      }
      catch (Exception paramSurfaceTexture)
      {
        ad.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
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
    this.vNS = parama;
    String str1;
    String str2;
    com.tencent.mm.plugin.base.model.a locala;
    if (parama == f.a.vOc)
    {
      parama = b.dmG();
      str1 = this.hpU.dmI();
      str2 = this.hpT.dmI();
      locala = this.vNP;
      if (locala.nMJ != 0) {
        break label94;
      }
    }
    label94:
    for (int i = 0;; i = locala.nMI / locala.nMJ)
    {
      parama.vNm = ((int)(bt.aRg(str1) * 10.0D));
      parama.vNn = ((int)(bt.aRg(str2) * 10.0D));
      parama.vNs = i;
      AppMethodBeat.o(89374);
      return;
    }
  }
  
  public final void a(b paramb, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(89390);
    ad.i("MicroMsg.MMSightCamera", "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s", new Object[] { paramb, this.hpZ, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.hpZ != null) {
      try
      {
        this.hpY = true;
        Point localPoint = new Point();
        if (this.hpQ != null) {
          localPoint.x = this.hpQ.x;
        }
        for (localPoint.y = this.hpQ.y;; localPoint.y = this.vNL.y)
        {
          byte[] arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.k.vQc.g(Integer.valueOf(this.hpZ.length));
          System.arraycopy(this.hpZ, 0, arrayOfByte, 0, this.hpZ.length);
          int i = this.hpP.dGc;
          paramb.a(arrayOfByte, localPoint.x, localPoint.y, i, paramInt);
          return;
          if ((this.vNN == null) || (!this.vNO)) {
            break;
          }
          localPoint.x = this.vNL.x;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.MMSightCamera", "takePicture error: %s", new Object[] { localException.getMessage() });
          this.hpY = false;
          paramb.a(null, 0, 0, -1, 0);
          return;
          localException.x = this.hph.rmx;
          localException.y = this.hph.rmy;
        }
      }
      finally
      {
        this.hpY = false;
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
      this.hpN.add(paramg);
    }
    AppMethodBeat.o(89372);
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(89400);
    ad.i("MicroMsg.MMSightCamera", "switch camera with limit, current useBack: %s", new Object[] { Boolean.valueOf(this.hpc) });
    try
    {
      dmQ();
      if (!this.hpc) {}
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
      ad.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[] { paramContext });
      AppMethodBeat.o(89400);
    }
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    AppMethodBeat.i(89399);
    ad.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", new Object[] { Boolean.valueOf(this.hpc) });
    try
    {
      dmQ();
      if (!this.hpc) {}
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
      ad.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[] { paramContext });
      AppMethodBeat.o(89399);
    }
  }
  
  public final boolean awO()
  {
    return this.hpc;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89392);
    if (com.tencent.mm.compatible.util.d.lz(14))
    {
      AppMethodBeat.o(89392);
      return;
    }
    this.vNY.removeMessages(4354);
    this.vNY.gmK = paramFloat1;
    this.vNY.gmL = paramFloat2;
    this.vNY.hpy = paramInt1;
    this.vNY.hpz = paramInt2;
    this.vNY.sendMessageDelayed(this.vNY.obtainMessage(4354, this.fYS), 400L);
    AppMethodBeat.o(89392);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(89373);
    if (paramg != null) {
      this.hpN.remove(paramg);
    }
    AppMethodBeat.o(89373);
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(89396);
    if ((this.fYS != null) && (this.vND)) {}
    for (;;)
    {
      int m;
      int k;
      int j;
      try
      {
        ad.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (this.aYh)
        {
          ad.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
          return;
        }
        Camera.Parameters localParameters = this.fYS.getParameters();
        if (localParameters.isZoomSupported())
        {
          this.aYh = true;
          m = localParameters.getZoom();
          k = localParameters.getMaxZoom();
          if (!paramBoolean2)
          {
            if (this.hpS <= 0)
            {
              this.hpS = Math.round(k / 15.0F);
              if (this.hpS > 5) {
                this.hpS = 5;
              }
            }
            i = this.hpS;
            ad.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(this.hpS), Integer.valueOf(this.hpR), Integer.valueOf(paramInt) });
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
            if (this.hpR <= 0)
            {
              ad.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", new Object[] { Integer.valueOf(this.hpR) });
              return;
            }
            i = this.hpR;
            continue;
            ad.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", new Object[] { Integer.valueOf(paramInt) });
            localParameters.setZoom(paramInt);
            this.fYS.setParameters(localParameters);
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
        ad.e("MicroMsg.MMSightCamera", "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
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
  
  public final boolean cLT()
  {
    return this.vND;
  }
  
  public final void dmL()
  {
    AppMethodBeat.i(89382);
    ad.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
    if ((this.fYS != null) && (this.vND)) {
      try
      {
        Camera.Parameters localParameters = this.fYS.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          ad.i("MicroMsg.MMSightCameraSetting", "support continuous video");
          localParameters.setFocusMode("continuous-video");
        }
        this.fYS.setParameters(localParameters);
        AppMethodBeat.o(89382);
        return;
      }
      catch (Exception localException)
      {
        ad.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89382);
  }
  
  public final void dmM()
  {
    AppMethodBeat.i(89383);
    ad.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode");
    if ((this.fYS != null) && (this.vND)) {
      try
      {
        Camera.Parameters localParameters = this.fYS.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          ad.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
        }
        this.fYS.setParameters(localParameters);
        AppMethodBeat.o(89383);
        return;
      }
      catch (Exception localException)
      {
        ad.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89383);
  }
  
  public final String dmN()
  {
    AppMethodBeat.i(89389);
    if (this.fYS == null)
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
        localObject3 = com.tencent.mm.plugin.mmsight.d.d(this.fYS.getParameters());
        if (this.hpk == null)
        {
          Object localObject1 = com.tencent.mm.plugin.mmsight.d.fM(this.mContext);
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
        localObject2 = new Point(this.hpk.getWidth(), this.hpk.getHeight());
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.MMSightCamera", "getDebugInfo error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(89389);
        return null;
      }
      continue;
      label290:
      localStringBuffer.append(String.format("%s*%s X r:%.4f\n", new Object[] { Integer.valueOf(((Camera.Size)localObject3).width), Integer.valueOf(((Camera.Size)localObject3).height), Double.valueOf(((Camera.Size)localObject3).height * 1.0D / ((Camera.Size)localObject3).width) }));
    }
    if (this.hpQ != null) {
      localStringBuffer.append("\nSIGHTCROPMODE:  " + this.hpQ.x + " " + this.hpQ.y + " from " + this.hph.rmx + " " + this.hph.rmy);
    }
    for (;;)
    {
      localStringBuffer.append("\ngetOrientation:" + getOrientation());
      localStringBuffer.append("\nrecorderOption: " + ae.gcL.gbq);
      localObject2 = localStringBuffer.toString();
      AppMethodBeat.o(89389);
      return localObject2;
      localStringBuffer.append("\nFinalPreviewSize: " + getPreviewWidth() + " " + getPreviewHeight());
    }
  }
  
  public final void dmO()
  {
    AppMethodBeat.i(89393);
    if ((this.fYS != null) && (this.vND)) {
      try
      {
        Camera.Parameters localParameters = this.fYS.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("auto")))
        {
          ad.i("MicroMsg.MMSightCameraSetting", "support auto focus");
          localParameters.setFocusMode("auto");
          this.fYS.setParameters(localParameters);
        }
        this.fYS.cancelAutoFocus();
        AppMethodBeat.o(89393);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.fYS.autoFocus(new Camera.AutoFocusCallback()
            {
              public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
              {
                AppMethodBeat.i(89363);
                if ((paramAnonymousCamera != null) && (f.this.cLT())) {
                  try
                  {
                    Camera.Parameters localParameters = paramAnonymousCamera.getParameters();
                    List localList = localParameters.getSupportedFocusModes();
                    if ((localList != null) && (localList.contains("continuous-picture")))
                    {
                      ad.i("MicroMsg.MMSightCameraSetting", "support continues picture focus");
                      localParameters.setFocusMode("continuous-picture");
                      paramAnonymousCamera.setParameters(localParameters);
                    }
                    AppMethodBeat.o(89363);
                    return;
                  }
                  catch (Exception paramAnonymousCamera)
                  {
                    ad.printErrStackTrace("MicroMsg.MMSightCamera", paramAnonymousCamera, "simple auto focus resetToPictureFocus error", new Object[0]);
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
            ad.printErrStackTrace("MicroMsg.MMSightCamera", localException2, "autoFocus error", new Object[0]);
          }
          localException1 = localException1;
          ad.printErrStackTrace("MicroMsg.MMSightCamera", localException1, "simple auto focus error", new Object[0]);
        }
      }
    }
  }
  
  public final List<Integer> dmP()
  {
    AppMethodBeat.i(89394);
    if (this.fYS != null) {
      try
      {
        Object localObject = this.fYS.getParameters();
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
        ad.e("MicroMsg.MMSightCamera", "getZoom error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89394);
    return null;
  }
  
  public final int dmQ()
  {
    AppMethodBeat.i(89401);
    dmK();
    AppMethodBeat.o(89401);
    return 0;
  }
  
  public final void dmR()
  {
    AppMethodBeat.i(89402);
    ad.i("MicroMsg.MMSightCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[] { this.fYS, Boolean.valueOf(this.vND) });
    if ((this.fYS != null) && (this.vND)) {
      try
      {
        this.vNQ = true;
        Camera.Parameters localParameters = this.fYS.getParameters();
        if ((!bt.hj(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("torch")))
        {
          localParameters.setFlashMode("torch");
          this.fYS.setParameters(localParameters);
          ad.i("MicroMsg.MMSightCamera", "open flash");
          AppMethodBeat.o(89402);
          return;
        }
        ad.i("MicroMsg.MMSightCamera", "camera not support flash!!");
        AppMethodBeat.o(89402);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MMSightCamera", localException, "openFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89402);
  }
  
  public final void dmS()
  {
    AppMethodBeat.i(89403);
    ad.i("MicroMsg.MMSightCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[] { this.fYS, Boolean.valueOf(this.vND) });
    if ((this.fYS != null) && (this.vND)) {
      try
      {
        this.vNQ = false;
        Camera.Parameters localParameters = this.fYS.getParameters();
        if ((!bt.hj(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("off")))
        {
          localParameters.setFlashMode("off");
          this.fYS.setParameters(localParameters);
          ad.i("MicroMsg.MMSightCamera", "close flash");
          AppMethodBeat.o(89403);
          return;
        }
        ad.i("MicroMsg.MMSightCamera", "camera not support close flash!!");
        AppMethodBeat.o(89403);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MMSightCamera", localException, "closeFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89403);
  }
  
  public final void dmT()
  {
    AppMethodBeat.i(89404);
    ad.i("MicroMsg.MMSightCamera", "autoFlash, camera: %s, isPreviewing: %s", new Object[] { this.fYS, Boolean.valueOf(this.vND) });
    if ((this.fYS != null) && (this.vND)) {
      try
      {
        this.vNQ = true;
        Camera.Parameters localParameters = this.fYS.getParameters();
        if ((!bt.hj(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("auto")))
        {
          localParameters.setFlashMode("auto");
          this.fYS.setParameters(localParameters);
          ad.i("MicroMsg.MMSightCamera", "auto flash");
          AppMethodBeat.o(89404);
          return;
        }
        ad.i("MicroMsg.MMSightCamera", "camera not support auto flash!!");
        AppMethodBeat.o(89404);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.MMSightCamera", localException, "autoFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(89404);
  }
  
  public final Point getEncodeVideoBestSize()
  {
    return this.vNL;
  }
  
  public final int getOrientation()
  {
    if ((this.hpP != null) && (this.vND)) {
      return this.hpP.dGc;
    }
    return -1;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(89406);
    if (this.fYS == null)
    {
      AppMethodBeat.o(89406);
      return 0;
    }
    if (this.hpP != null) {
      try
      {
        int i;
        if ((this.vNO) && (this.vNN != null)) {
          if ((this.hpP.dGc == 0) || (this.hpP.dGc == 180)) {
            i = this.vNL.y;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89406);
          return i;
          i = this.vNL.x;
          continue;
          if (this.hpQ == null)
          {
            if ((this.hpP.dGc == 0) || (this.hpP.dGc == 180)) {
              i = this.hph.rmy;
            } else {
              i = this.hph.rmx;
            }
          }
          else if ((this.hpP.dGc == 0) || (this.hpP.dGc == 180)) {
            i = this.hpQ.y;
          } else {
            i = this.hpQ.x;
          }
        }
        AppMethodBeat.o(89406);
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.MMSightCamera", "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      }
    }
    return 0;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(89405);
    if (this.fYS == null)
    {
      AppMethodBeat.o(89405);
      return 0;
    }
    if (this.hpP != null) {
      try
      {
        int i;
        if ((this.vNO) && (this.vNN != null)) {
          if ((this.hpP.dGc == 0) || (this.hpP.dGc == 180)) {
            i = this.vNL.x;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89405);
          return i;
          i = this.vNL.y;
          continue;
          if (this.hpQ == null)
          {
            if ((this.hpP.dGc == 0) || (this.hpP.dGc == 180)) {
              i = this.hph.rmx;
            } else {
              i = this.hph.rmy;
            }
          }
          else if ((this.hpP.dGc == 0) || (this.hpP.dGc == 180)) {
            i = this.hpQ.x;
          } else {
            i = this.hpQ.y;
          }
        }
        AppMethodBeat.o(89405);
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.MMSightCamera", "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    return 0;
  }
  
  public final void nW(int paramInt)
  {
    AppMethodBeat.i(89397);
    if (this.hpR > 0)
    {
      AppMethodBeat.o(89397);
      return;
    }
    if (this.hpk == null) {}
    int i;
    for (Point localPoint = al.ci(aj.getContext());; localPoint = new Point(this.hpk.getWidth(), this.hpk.getHeight()))
    {
      i = localPoint.y;
      ad.i("MicroMsg.MMSightCamera", "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localPoint });
      if (i / 2 < paramInt) {
        break;
      }
      AppMethodBeat.o(89397);
      return;
    }
    try
    {
      if (this.fYS != null)
      {
        i = this.fYS.getParameters().getMaxZoom();
        this.hpR = ((int)(i / (paramInt / 3.0D / 10.0D)) + 1);
        ad.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.hpR), Integer.valueOf(i) });
      }
      AppMethodBeat.o(89397);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MMSightCamera", "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
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
    if ((Math.abs(this.vNH - f1) > 5.0F) || (Math.abs(this.vNI - f2) > 5.0F) || (Math.abs(this.vNJ - f3) > 5.0F))
    {
      ad.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", new Object[] { Float.valueOf(5.0F), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      this.vNY.e(this.fYS);
      this.vNH = f1;
      this.vNI = f2;
      this.vNJ = f3;
    }
    AppMethodBeat.o(89391);
  }
  
  public static abstract interface b
  {
    public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public final class c
    extends ap
  {
    float gmK;
    float gmL;
    int hpu = 0;
    boolean hpv = false;
    boolean hpw = false;
    boolean hpx = false;
    int hpy;
    int hpz;
    
    public c(Looper paramLooper)
    {
      super();
    }
    
    private static int Km(int paramInt)
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
      localObject = new Rect(Km(Math.round(((RectF)localObject).left)), Km(Math.round(((RectF)localObject).top)), Km(Math.round(((RectF)localObject).right)), Km(Math.round(((RectF)localObject).bottom)));
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
          ad.e("MicroMsg.MMSightCamera", "get target zoom value error: %s", new Object[] { paramParameters.getMessage() });
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
        ad.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
        AppMethodBeat.o(89368);
        return;
      }
      if (!f.vNX)
      {
        ad.w("MicroMsg.MMSightCamera", "auto focus not back");
        AppMethodBeat.o(89368);
        return;
      }
      f.vNX = false;
      try
      {
        ad.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
        paramv.cancelAutoFocus();
        paramv.autoFocus(f.this.hpC);
        AppMethodBeat.o(89368);
        return;
      }
      catch (Exception paramv)
      {
        ad.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", new Object[] { paramv.getMessage() });
        f.vNX = true;
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
        if ((this.hpy == 0) || (this.hpz == 0) || (com.tencent.mm.compatible.util.d.lz(14)))
        {
          e(paramMessage);
          AppMethodBeat.o(89370);
          return;
        }
        float f1 = this.gmK;
        float f2 = this.gmL;
        int i = this.hpy;
        j = this.hpz;
        if (paramMessage == null)
        {
          ad.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
          AppMethodBeat.o(89370);
          return;
        }
        if (!f.vNX)
        {
          ad.w("MicroMsg.MMSightCamera", "auto focus not back");
          AppMethodBeat.o(89370);
          return;
        }
        f.vNX = false;
        try
        {
          paramMessage.cancelAutoFocus();
          ad.i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
          Object localObject2 = b(f1, f2, 1.0F, i, j);
          localObject1 = b(f1, f2, 1.5F, i, j);
          ad.i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
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
          paramMessage.autoFocus(f.this.hpC);
          AppMethodBeat.o(89370);
          return;
        }
        catch (Exception paramMessage)
        {
          ad.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
          f.vNX = true;
          AppMethodBeat.o(89370);
          return;
        }
        if (this.hpx)
        {
          AppMethodBeat.o(89370);
          return;
        }
        Object localObject1 = (Camera)paramMessage.obj;
        Camera.Parameters localParameters = ((Camera)localObject1).getParameters();
        ad.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(this.hpv), Integer.valueOf(this.hpu), Integer.valueOf(localParameters.getZoom()) });
        i = localParameters.getZoom() + this.hpu;
        if (this.hpv)
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
          this.hpy = 0;
          this.hpz = 0;
          continue;
          paramMessage = obtainMessage(4353, paramMessage.obj);
          if (this.hpw) {}
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
          if (this.hpw) {}
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