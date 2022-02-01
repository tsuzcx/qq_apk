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
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.oa.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class f
  implements SensorEventListener
{
  protected static int tCc = 2147483647;
  static boolean tCu = true;
  protected boolean aMX;
  protected v fBM;
  protected q gwE;
  protected Size gwH;
  protected boolean gwS;
  Camera.AutoFocusCallback gwZ;
  protected boolean gwz;
  protected List<g> gxk;
  protected d.a.a gxm;
  protected Point gxn;
  protected int gxo;
  protected int gxp;
  private c gxq;
  private c gxr;
  private c gxs;
  private c gxt;
  private c gxu;
  public volatile boolean gxv;
  public volatile byte[] gxw;
  protected Context mContext;
  protected SensorManager mSensorManager;
  private int scene;
  protected boolean tCa;
  protected int tCb;
  protected Sensor tCd;
  protected float tCe;
  protected float tCf;
  protected float tCg;
  protected Point tCh;
  protected Point tCi;
  protected int tCj;
  protected byte[] tCk;
  protected boolean tCl;
  protected com.tencent.mm.plugin.base.model.a tCm;
  protected boolean tCn;
  protected boolean tCo;
  private f.a tCp;
  private c tCq;
  protected VideoTransPara tCr;
  public boolean tCs;
  private boolean tCt;
  public c tCv;
  
  public f(VideoTransPara paramVideoTransPara, int paramInt)
  {
    AppMethodBeat.i(89371);
    this.gxp = -1;
    this.gxo = -1;
    this.gwS = false;
    this.aMX = false;
    this.fBM = null;
    this.tCa = false;
    this.tCb = 0;
    this.tCe = 0.0F;
    this.tCf = 0.0F;
    this.tCg = 0.0F;
    this.mContext = null;
    this.tCh = null;
    this.tCi = null;
    this.gxn = null;
    this.tCj = 0;
    this.tCl = false;
    this.tCm = new com.tencent.mm.plugin.base.model.a();
    this.tCn = false;
    this.gxk = new ArrayList();
    this.tCo = false;
    this.gwH = null;
    this.tCp = f.a.tCx;
    this.gxq = new c("prevcameraCallback");
    this.gxr = new c("cameraCallback");
    this.gxs = new c("cameraPreviewCallback");
    this.gxt = new c("cameraCropCallback");
    this.tCq = new c("mirrorCameraCallback");
    this.gxu = new c("finishCallbackTimeCallback");
    this.scene = 0;
    this.gxw = null;
    this.gxv = false;
    this.tCs = false;
    this.tCt = false;
    this.gwZ = new Camera.AutoFocusCallback()
    {
      public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(89362);
        ad.v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), f.f(f.this) });
        f.tCu = true;
        AppMethodBeat.o(89362);
      }
    };
    this.tCv = new c(Looper.getMainLooper());
    this.gwz = true;
    this.gwE = q.cQb();
    this.tCr = paramVideoTransPara;
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
        if (this.gwH == null)
        {
          localObject = ai.cf(aj.getContext());
          Point localPoint = new Point(Math.min(((Point)localObject).x, ((Point)localObject).y), Math.max(((Point)localObject).x, ((Point)localObject).y));
          ad.i("MicroMsg.MMSightCamera", "screenSize: %s, currentScreenSize: %s", new Object[] { localPoint, localObject });
          float f1 = Math.min(localPoint.x, localPoint.y) / Math.max(localPoint.x, localPoint.y);
          f2 = 1.0F / paramFloat;
          if (paramFloat >= 1.0F) {
            break label709;
          }
          i = paramInt;
          ad.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[] { Integer.valueOf(i), Float.valueOf(paramFloat), Float.valueOf(f1) });
          if (this.gxm.dwp == 90) {
            break label756;
          }
          if (this.gxm.dwp != 270) {
            break label768;
          }
          break label756;
          h.c localc = h.a(localParameters, localPoint, i, bool);
          if (localc != null)
          {
            localObject = localc;
            if (localc.tCB != null) {}
          }
          else
          {
            ad.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
            if (this.gxm.dwp == 90) {
              break label762;
            }
            if (this.gxm.dwp != 270) {
              break label774;
            }
            break label762;
            localObject = h.d(localParameters, localPoint, paramInt, bool);
            this.tCs = false;
          }
          if ((localObject != null) && (((h.c)localObject).tCB != null))
          {
            paramInt = (int)(((h.c)localObject).tCB.x * paramFloat);
            ad.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio result preview size: %s, cropHeight: %s", new Object[] { ((h.c)localObject).tCB, Integer.valueOf(paramInt) });
            if (paramInt > ((h.c)localObject).tCB.y) {
              break label726;
            }
            this.tCs = false;
          }
          if ((localObject != null) && (((h.c)localObject).tCB != null))
          {
            localObject = ((h.c)localObject).tCB;
            this.gwE.pUc = ((Point)localObject).x;
            this.gwE.pUd = ((Point)localObject).y;
            this.tCi = ((Point)localObject);
            this.gxn = null;
            if (!paramBoolean)
            {
              if ((k.tCN.fEc != 2) || (com.tencent.mm.plugin.mmsight.d.GO(this.tCi.y))) {
                break label745;
              }
              paramInt = com.tencent.mm.plugin.mmsight.d.GP(this.tCi.y);
              if (Math.abs(paramInt - this.tCi.y) > 16) {
                break label734;
              }
              ad.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.tCi, Integer.valueOf(paramInt) });
              this.tCh = new Point(this.tCi.x, this.tCi.y);
              this.tCi.y = paramInt;
              this.tCl = true;
              this.tCk = new byte[this.tCi.x * this.tCi.y * 3 / 2];
            }
            ad.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s, cropWidth: %s", new Object[] { localObject, this.tCi, this.gxn, Boolean.valueOf(this.tCs) });
            localParameters.setPreviewSize(this.gwE.pUc, this.gwE.pUd);
            paramv.setParameters(localParameters);
            AppMethodBeat.o(89377);
            return true;
          }
        }
        else
        {
          localObject = new Point(this.gwH.getWidth(), this.gwH.getHeight());
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
      this.tCs = true;
      continue;
      label734:
      k.d(this.tCi);
      continue;
      label745:
      k.d(this.tCi);
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
          if (ae.fFw.fBm > 0)
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
        if (ae.fFw.fBm <= 0) {
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
  
  private void amI()
  {
    AppMethodBeat.i(89384);
    if (this.fBM != null) {
      try
      {
        Object localObject = this.fBM.getParameters();
        ad.i("MicroMsg.MMSightCamera", "setPreviewCallbackImpl");
        int i = this.gwE.pUc;
        int j = this.gwE.pUd;
        j = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject).getPreviewFormat()) * (i * j) / 8;
        i = 0;
        while (i < 5)
        {
          localObject = j.tEA.g(Integer.valueOf(j));
          this.fBM.addCallbackBuffer((byte[])localObject);
          i += 1;
        }
        this.gxq.reset();
        this.gxr.reset();
        this.gxs.reset();
        this.gxt.reset();
        this.tCq.reset();
        this.gxu.reset();
        this.tCm = new com.tencent.mm.plugin.base.model.a();
        this.fBM.setPreviewCallbackWithBuffer(new Camera.PreviewCallback()
        {
          public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
          {
            AppMethodBeat.i(89361);
            if (!f.this.tCo)
            {
              ad.i("MicroMsg.MMSightCamera", "onPreviewFrame: %s %s", new Object[] { paramAnonymousArrayOfByte, f.this.fBM });
              f.this.tCo = true;
            }
            if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
            {
              ad.e("MicroMsg.MMSightCamera", "onPreviewFrame, frame data is null!!");
              AppMethodBeat.o(89361);
              return;
            }
            paramAnonymousCamera = f.this.tCm;
            if (paramAnonymousCamera.mJU == 0)
            {
              paramAnonymousCamera.mJT += 1;
              paramAnonymousCamera.mJS = bt.aGh(m.WI());
            }
            paramAnonymousCamera.mJU += 1;
            int i;
            long l1;
            byte[] arrayOfByte;
            label367:
            long l2;
            int j;
            boolean bool;
            if (paramAnonymousCamera.mJU >= 90)
            {
              i = 0;
              paramAnonymousCamera.mJU = i;
              if ((f.a(f.this)) || (f.this.gxk == null) || (f.this.gxk.size() <= 0)) {
                break label944;
              }
              if (f.this.gxn == null) {
                break label584;
              }
              paramAnonymousCamera = j.tEA.g(Integer.valueOf(f.this.gwE.pUc * f.this.gxn.y * 3 / 2));
              f.b(f.this).rt(1L);
              l1 = bt.GC();
              SightVideoJNI.cropCameraData(paramAnonymousArrayOfByte, paramAnonymousCamera, f.this.gwE.pUc, f.this.gwE.pUd, f.this.gxn.y);
              if (f.this.gxn.x >= f.this.gwE.pUc) {
                break label941;
              }
              arrayOfByte = j.tEA.g(Integer.valueOf(f.this.gxn.x * f.this.gxn.y * 3 / 2));
              SightVideoJNI.cropCameraDataLongEdge(paramAnonymousCamera, arrayOfByte, f.this.gwE.pUc, f.this.gxn.x, f.this.gxn.y);
              j.tEA.k(paramAnonymousCamera);
              paramAnonymousCamera = arrayOfByte;
              l2 = bt.aS(l1);
              f.c(f.this).rt(l2);
              if (!f.this.gwz)
              {
                l1 = bt.GC();
                i = f.this.gxn.x;
                j = f.this.gxn.y;
                if ((f.this.gxm.dwp != 270) && (f.this.gxm.dwp != 90)) {
                  break label578;
                }
                bool = true;
                label458:
                SightVideoJNI.mirrorCameraData(paramAnonymousCamera, i, j, bool);
                l2 = bt.aS(l1);
                f.d(f.this).rt(l2);
              }
              bool = f.a(f.this, paramAnonymousCamera);
              l1 = bt.aS(l1);
              if (bool) {
                f.e(f.this).rt(l1);
              }
            }
            for (;;)
            {
              f.b(f.this, paramAnonymousCamera);
              if (f.f(f.this) == f.a.tCx) {
                f.g(f.this).rt(1L);
              }
              for (;;)
              {
                f.this.fBM.addCallbackBuffer(paramAnonymousArrayOfByte);
                AppMethodBeat.o(89361);
                return;
                i = paramAnonymousCamera.mJU;
                break;
                label578:
                bool = false;
                break label458;
                label584:
                l1 = bt.GC();
                label656:
                label753:
                f localf;
                if (!f.this.gwz)
                {
                  i = f.this.gwE.pUc;
                  j = f.this.gwE.pUd;
                  if ((f.this.gxm.dwp == 270) || (f.this.gxm.dwp == 90))
                  {
                    bool = true;
                    SightVideoJNI.mirrorCameraData(paramAnonymousArrayOfByte, i, j, bool);
                    l2 = bt.aS(l1);
                    f.d(f.this).rt(l2);
                  }
                }
                else
                {
                  if ((!f.this.tCl) || (f.this.tCk == null)) {
                    break label898;
                  }
                  SightVideoJNI.paddingYuvData16(paramAnonymousArrayOfByte, f.this.tCk, f.this.tCi.x, f.this.tCh.y, f.this.tCi.y);
                  paramAnonymousCamera = f.this.tCk;
                  bool = f.a(f.this, paramAnonymousCamera);
                  l1 = bt.aS(l1);
                  if (bool) {
                    f.e(f.this).rt(l1);
                  }
                  if (f.this.tCl)
                  {
                    arrayOfByte = paramAnonymousArrayOfByte;
                    if (f.this.tCk != null) {}
                  }
                  else
                  {
                    arrayOfByte = paramAnonymousArrayOfByte;
                    if (bool) {
                      arrayOfByte = j.tEA.g(Integer.valueOf(paramAnonymousArrayOfByte.length));
                    }
                  }
                  if ((f.this.tCl) && (f.this.tCk != null))
                  {
                    localf = f.this;
                    if (!bool) {
                      break label903;
                    }
                  }
                }
                label898:
                label903:
                for (paramAnonymousArrayOfByte = j.tEA.g(Integer.valueOf(f.this.tCk.length));; paramAnonymousArrayOfByte = f.this.tCk)
                {
                  localf.tCk = paramAnonymousArrayOfByte;
                  paramAnonymousArrayOfByte = arrayOfByte;
                  break;
                  bool = false;
                  break label656;
                  paramAnonymousCamera = paramAnonymousArrayOfByte;
                  break label753;
                }
                if (f.f(f.this) == f.a.tCy) {
                  f.h(f.this).rt(1L);
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
  
  private void amt()
  {
    AppMethodBeat.i(89388);
    if (true == this.tCt)
    {
      AppMethodBeat.o(89388);
      return;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(89388);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.d.b.XC()))
    {
      AppMethodBeat.o(89388);
      return;
    }
    Object localObject = new oa();
    ((oa)localObject).dti.type = 2;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    if (((oa)localObject).dtj.dth)
    {
      this.tCt = true;
      AppMethodBeat.o(89388);
      return;
    }
    localObject = com.tencent.mm.ui.base.h.j(this.mContext, 2131763668, 2131755906);
    if (localObject != null)
    {
      ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
      ((com.tencent.mm.ui.widget.a.d)localObject).setCanceledOnTouchOutside(false);
      ((com.tencent.mm.ui.widget.a.d)localObject).show();
      this.tCt = true;
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
        if (this.gwH == null)
        {
          localPoint = com.tencent.mm.plugin.mmsight.d.fv(this.mContext);
          if (this.gwz)
          {
            localObject1 = b.cPB();
            localObject2 = localParameters.getSupportedPreviewSizes();
            localObject3 = localParameters.getSupportedPictureSizes();
            i = this.gxm.dwp;
            if (bt.isNullOrNil(((b)localObject1).tBz)) {
              ((b)localObject1).tBz = com.tencent.mm.plugin.mmsight.d.eg((List)localObject2);
            }
            if (bt.isNullOrNil(((b)localObject1).tBA)) {
              ((b)localObject1).tBA = com.tencent.mm.plugin.mmsight.d.eg((List)localObject3);
            }
            ((b)localObject1).dwp = i;
            ((b)localObject1).tBU = 1;
            if (paramBoolean)
            {
              if (this.gxm.dwp == 90) {
                break label2498;
              }
              if (this.gxm.dwp != 270) {
                break label501;
              }
              break label2498;
              k.a(localParameters, bool);
            }
            com.tencent.mm.plugin.mmsight.model.a.k.cQk();
            i = com.tencent.mm.plugin.mmsight.model.a.k.cQn();
            if (this.gxm.dwp == 90) {
              break label2504;
            }
            if (this.gxm.dwp != 270) {
              break label507;
            }
            break label2504;
            label206:
            localObject2 = h.a(localParameters, localPoint, i, bool);
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((h.c)localObject2).tCB != null) {}
            }
            else
            {
              ad.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
              localPoint = new Point(Math.min(localPoint.x, localPoint.y), Math.max(localPoint.x, localPoint.y));
              if (this.gxm.dwp == 90) {
                break label2510;
              }
              if (this.gxm.dwp != 270) {
                break label513;
              }
              break label2510;
              label308:
              localObject1 = h.d(localParameters, localPoint, 2100, bool);
              this.tCs = false;
            }
            k.a((h.c)localObject1);
            localPoint = ((h.c)localObject1).tCB;
            if (localPoint != null) {
              break;
            }
            l.amV();
            AppMethodBeat.o(89376);
            return false;
          }
        }
        else
        {
          localPoint = new Point(this.gwH.getWidth(), this.gwH.getHeight());
          continue;
        }
        localObject1 = b.cPB();
        localObject2 = localParameters.getSupportedPreviewSizes();
        localObject3 = localParameters.getSupportedPictureSizes();
        i = this.gxm.dwp;
        if (bt.isNullOrNil(((b)localObject1).tBB)) {
          ((b)localObject1).tBB = com.tencent.mm.plugin.mmsight.d.eg((List)localObject2);
        }
        if (bt.isNullOrNil(((b)localObject1).tBC)) {
          ((b)localObject1).tBC = com.tencent.mm.plugin.mmsight.d.eg((List)localObject3);
        }
        ((b)localObject1).dwp = i;
        ((b)localObject1).tBU = 2;
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
    this.gwE.pUc = localPoint.x;
    this.gwE.pUd = localPoint.y;
    this.tCi = localPoint;
    Object localObject2 = this.mContext;
    if (this.gxm.dwp != 90) {
      if (this.gxm.dwp == 270)
      {
        break label2516;
        label583:
        bool = com.tencent.mm.plugin.mmsight.d.a((Context)localObject2, localPoint, bool);
        i = 1;
        if ((this.gxm.dwp != 90) && (this.gxm.dwp != 270)) {
          break label1348;
        }
        if ((localPoint.y < this.tCr.width) || (localPoint.x < this.tCr.height))
        {
          i = 0;
          ad.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localPoint });
        }
        label673:
        ad.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label1434;
        }
        if (k.tCN.fEc != 2) {
          break label1422;
        }
        this.gxn = ((h.c)localObject1).tCD;
        if ((this.gxn.x < localPoint.x) || (this.gxn.y < localPoint.y))
        {
          if ((this.gxm.dwp != 90) && (this.gxm.dwp != 270)) {
            break label1402;
          }
          this.gxn.y = com.tencent.mm.plugin.mmsight.d.GQ(this.gxn.y);
        }
        label789:
        this.tCi = new Point(this.gxn.x, this.gxn.y);
        this.tCj = (this.gxn.x * this.gxn.y * 3 / 2);
        ad.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", new Object[] { this.gxn });
      }
    }
    label856:
    label2522:
    for (;;)
    {
      int j;
      int k;
      if (k.tCN.tDa)
      {
        if ((this.gxm.dwp != 90) && (this.gxm.dwp != 270)) {
          break label2035;
        }
        if (i != 0)
        {
          if (k.tCN.gwG != 1080) {
            break label1863;
          }
          if (this.gxn != null) {
            break label1811;
          }
          j = localPoint.x / 2;
          if (this.gxn != null) {
            break label1825;
          }
          i = localPoint.y / 2;
          if (this.gxn != null) {
            break label1839;
          }
          k = localPoint.x;
          k = com.tencent.mm.plugin.mmsight.d.ga(j, k);
          if (this.gxn != null) {
            break label1851;
          }
          j = localPoint.y;
          this.tCi = new Point(k, com.tencent.mm.plugin.mmsight.d.ga(i, j));
        }
      }
      label996:
      localObject1 = b.cPB();
      localObject2 = this.gxn;
      localObject3 = this.tCi;
      ((b)localObject1).tBI = -1;
      ((b)localObject1).tBH = -1;
      ((b)localObject1).tBE = -1;
      ((b)localObject1).tBD = -1;
      ((b)localObject1).tBG = -1;
      ((b)localObject1).tBF = -1;
      if (localPoint != null)
      {
        ((b)localObject1).tBF = localPoint.x;
        ((b)localObject1).tBG = localPoint.y;
      }
      if (localObject2 != null)
      {
        ((b)localObject1).tBD = ((Point)localObject2).x;
        ((b)localObject1).tBE = ((Point)localObject2).y;
      }
      if (localObject3 != null)
      {
        ((b)localObject1).tBH = ((Point)localObject3).x;
        ((b)localObject1).tBI = ((Point)localObject3).y;
      }
      if (paramBoolean) {
        if ((!bool) && (k.tCN.fEc == 2) && (!com.tencent.mm.plugin.mmsight.d.GO(this.tCi.y)))
        {
          i = com.tencent.mm.plugin.mmsight.d.GP(this.tCi.y);
          if (Math.abs(i - this.tCi.y) <= 16)
          {
            ad.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.tCi, Integer.valueOf(i) });
            this.tCh = new Point(this.tCi.x, this.tCi.y);
            this.tCi.y = i;
            this.tCl = true;
            this.tCk = new byte[this.tCi.x * this.tCi.y * 3 / 2];
          }
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", new Object[] { localPoint, this.tCi, this.gxn });
        localParameters.setPreviewSize(this.gwE.pUc, this.gwE.pUd);
        paramv.setParameters(localParameters);
        AppMethodBeat.o(89376);
        return true;
        bool = false;
        break;
        if ((localPoint.x >= this.tCr.width) && (localPoint.y >= this.tCr.height)) {
          break label673;
        }
        i = 0;
        ad.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localPoint });
        break label673;
        label1402:
        this.gxn.x = com.tencent.mm.plugin.mmsight.d.GQ(this.gxn.x);
        break label789;
        this.gxn = ((h.c)localObject1).tCC;
        break label789;
        if ((!k.tCN.tDa) || (k.tCN.gwG != 1080) || (i == 0)) {
          break label2495;
        }
        if ((this.gxm.dwp == 90) || (this.gxm.dwp == 270))
        {
          j = localPoint.y / 2;
          k = com.tencent.mm.plugin.mmsight.d.GP(j);
          m = localPoint.x / 2;
          n = com.tencent.mm.plugin.mmsight.d.GP(m);
          if ((Math.abs(k - j) < 8) && (Math.abs(n - m) < 8)) {
            break label2522;
          }
          this.gxn = new Point(localPoint.x, localPoint.y);
          this.gxn.y = com.tencent.mm.plugin.mmsight.d.GQ(localPoint.y);
          this.gxn.x = com.tencent.mm.plugin.mmsight.d.GQ(localPoint.x);
          this.tCi = new Point(this.gxn.x, this.gxn.y);
          this.tCj = (this.gxn.x * this.gxn.y * 3 / 2);
          bool = true;
          break label2522;
        }
        j = localPoint.x / 2;
        k = com.tencent.mm.plugin.mmsight.d.GP(j);
        int m = localPoint.y / 2;
        int n = com.tencent.mm.plugin.mmsight.d.GP(m);
        if ((Math.abs(k - j) < 8) && (Math.abs(n - m) < 8)) {
          break label2495;
        }
        this.gxn = new Point(localPoint.x, localPoint.y);
        this.gxn.y = com.tencent.mm.plugin.mmsight.d.GQ(localPoint.x);
        this.gxn.x = com.tencent.mm.plugin.mmsight.d.GQ(localPoint.y);
        this.tCi = new Point(this.gxn.x, this.gxn.y);
        this.tCj = (this.gxn.x * this.gxn.y * 3 / 2);
        bool = true;
        break label856;
        j = this.gxn.x / 2;
        break label923;
        i = this.gxn.y / 2;
        break label939;
        k = this.gxn.x;
        break label953;
        j = this.gxn.y;
        break label976;
        if (k.tCN.gwG != 720) {
          break label996;
        }
        float f;
        if (this.gxn == null)
        {
          f = localPoint.x * 0.75F;
          label1893:
          k = (int)f;
          if (this.gxn != null) {
            break label1995;
          }
          f = localPoint.y * 0.75F;
          label1915:
          j = (int)f;
          if (this.gxn != null) {
            break label2011;
          }
          i = localPoint.x;
          k = com.tencent.mm.plugin.mmsight.d.ga(k, i);
          if (this.gxn != null) {
            break label2023;
          }
        }
        label2011:
        label2023:
        for (i = localPoint.y;; i = this.gxn.y)
        {
          this.tCi = new Point(k, com.tencent.mm.plugin.mmsight.d.ga(j, i));
          break;
          f = this.gxn.x * 0.75F;
          break label1893;
          f = this.gxn.y * 0.75F;
          break label1915;
          i = this.gxn.x;
          break label1933;
        }
        label2035:
        if (i == 0) {
          break label996;
        }
        if (k.tCN.gwG == 1080)
        {
          if (this.gxn == null)
          {
            j = localPoint.y / 2;
            if (this.gxn != null) {
              break label2158;
            }
            i = localPoint.x / 2;
            if (this.gxn != null) {
              break label2172;
            }
            k = localPoint.y;
            k = com.tencent.mm.plugin.mmsight.d.ga(j, k);
            if (this.gxn != null) {
              break label2184;
            }
          }
          for (j = localPoint.x;; j = this.gxn.x)
          {
            this.tCi = new Point(k, com.tencent.mm.plugin.mmsight.d.ga(i, j));
            break;
            j = this.gxn.y / 2;
            break label2068;
            label2158:
            i = this.gxn.x / 2;
            break label2084;
            label2172:
            k = this.gxn.y;
            break label2098;
          }
        }
        if (k.tCN.gwG != 720) {
          break label996;
        }
        if (this.gxn == null)
        {
          f = localPoint.y * 0.75F;
          k = (int)f;
          if (this.gxn != null) {
            break label2328;
          }
          f = localPoint.x * 0.75F;
          j = (int)f;
          if (this.gxn != null) {
            break label2344;
          }
          i = localPoint.y;
          label2266:
          k = com.tencent.mm.plugin.mmsight.d.ga(k, i);
          if (this.gxn != null) {
            break label2356;
          }
        }
        for (i = localPoint.x;; i = this.gxn.x)
        {
          this.tCi = new Point(k, com.tencent.mm.plugin.mmsight.d.ga(j, i));
          break;
          f = this.gxn.y * 0.75F;
          break label2226;
          f = this.gxn.x * 0.75F;
          break label2248;
          i = this.gxn.y;
          break label2266;
        }
        k.d(this.tCi);
        continue;
        k.d(this.tCi);
        continue;
        if ((!bool) && (k.tCN.fEc == 2) && (!com.tencent.mm.plugin.mmsight.d.GO(this.tCi.y)) && (this.tCl) && (this.tCk != null) && (this.tCh.y == this.tCi.y))
        {
          i = com.tencent.mm.plugin.mmsight.d.GP(this.tCi.y);
          if (this.tCk.length == this.tCi.x * i * 3 / 2) {
            this.tCi.y = i;
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
  
  private void cPF()
  {
    AppMethodBeat.i(89375);
    try
    {
      if ((this.mSensorManager != null) && (this.tCd != null)) {
        this.mSensorManager.unregisterListener(this);
      }
      ad.i("MicroMsg.MMSightCamera", this.gxq.getValue());
      ad.i("MicroMsg.MMSightCamera", this.gxr.getValue());
      ad.i("MicroMsg.MMSightCamera", this.gxs.getValue());
      ad.i("MicroMsg.MMSightCamera", this.gxt.getValue());
      ad.i("MicroMsg.MMSightCamera", this.tCq.getValue());
      ad.i("MicroMsg.MMSightCamera", this.gxu.getValue());
      if (this.fBM != null)
      {
        long l = bt.GC();
        ad.i("MicroMsg.MMSightCamera", "release camera beg, %s", new Object[] { Looper.myLooper() });
        this.tCv.removeCallbacksAndMessages(null);
        this.tCv.gwU = true;
        this.fBM.setPreviewCallback(null);
        this.fBM.stopPreview();
        this.fBM.release();
        this.fBM = null;
        this.tCa = false;
        ad.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", new Object[] { Long.valueOf(bt.aS(l)), Looper.myLooper() });
      }
      this.gwS = false;
      this.tCe = 0.0F;
      this.tCf = 0.0F;
      this.tCg = 0.0F;
      tCu = true;
      this.mContext = null;
      this.tCt = false;
      this.tCi = null;
      this.gxn = null;
      this.gxw = null;
      this.tCo = false;
      AppMethodBeat.o(89375);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MMSightCamera", localException, "cameraRelease error", new Object[0]);
      AppMethodBeat.o(89375);
    }
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
  
  public final void GS(int paramInt)
  {
    AppMethodBeat.i(89395);
    if (this.fBM != null) {
      try
      {
        Camera.Parameters localParameters = this.fBM.getParameters();
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
        if (this.aMX)
        {
          ad.d("MicroMsg.MMSightCamera", "setForceZoomTargetRatio, zooming, ignore");
          return;
        }
        this.aMX = true;
        localParameters.setZoom(paramInt);
        this.fBM.setParameters(localParameters);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.MMSightCamera", "getZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.aMX = false;
        AppMethodBeat.o(89395);
      }
    }
    AppMethodBeat.o(89395);
  }
  
  public final int a(SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(89386);
    long l = bt.GC();
    this.tCo = false;
    ad.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s", new Object[] { Boolean.valueOf(this.tCa), Looper.myLooper(), paramSurfaceTexture });
    if (this.tCa)
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
        a(this.fBM, paramInt, paramFloat, paramBoolean);
        if (com.tencent.mm.plugin.mmsight.model.a.k.cQk().tEC == null) {
          break label654;
        }
        localInteger = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.k.cQk().tEC.tBj);
        if (ae.fFw.fBr == 1)
        {
          str = "Range";
          if (ae.fFw.fBs != 1) {
            break label671;
          }
          paramBoolean = true;
          if (ae.fFw.fBt != 1) {
            break label677;
          }
          bool1 = true;
          if (ae.fFw.fBu != 1) {
            break label683;
          }
          bool2 = true;
          if (ae.fFw.fBv != 1) {
            break label689;
          }
          bool3 = true;
          ad.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((ae.fFw.fBr == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            a(this.fBM, false);
            if ((ae.fFw.fBs == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              b(this.fBM);
            }
            if ((ae.fFD.fEk != -1) && (ae.fFD.fEk == 1) && (com.tencent.mm.compatible.util.d.lh(14))) {
              c(this.fBM);
            }
            if ((ae.fFw.fBu == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              a(this.fBM);
            }
            if ((ae.fFw.fBv == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            d(this.fBM);
            amI();
            this.fBM.setPreviewTexture(paramSurfaceTexture);
            this.fBM.startPreview();
            if (!k.tCN.tDb) {
              break label637;
            }
            if ((ae.fFw.fBu == 0) && (this.mSensorManager != null) && (this.tCd != null)) {
              this.mSensorManager.registerListener(this, this.tCd, 2);
            }
            this.tCa = true;
            ad.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(bt.aS(l)), Looper.myLooper() });
            AppMethodBeat.o(89386);
            return 0;
          }
        }
        else
        {
          if (ae.fFw.fBq != 1) {
            break label663;
          }
          str = "Fix";
          continue;
        }
        if ((ae.fFw.fBq != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        a(this.fBM, true);
        continue;
        this.mSensorManager.registerListener(this, this.tCd, 2);
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
    long l = bt.GC();
    this.tCo = false;
    ad.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", new Object[] { Boolean.valueOf(this.tCa), Looper.myLooper(), paramSurfaceTexture, Boolean.valueOf(paramBoolean) });
    if (this.tCa)
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
        b(this.fBM, paramBoolean);
        if (com.tencent.mm.plugin.mmsight.model.a.k.cQk().tEC == null) {
          break label656;
        }
        localInteger = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.k.cQk().tEC.tBj);
        if (ae.fFw.fBr == 1)
        {
          str = "Range";
          if (ae.fFw.fBs != 1) {
            break label673;
          }
          paramBoolean = true;
          if (ae.fFw.fBt != 1) {
            break label678;
          }
          bool1 = true;
          if (ae.fFw.fBu != 1) {
            break label684;
          }
          bool2 = true;
          if (ae.fFw.fBv != 1) {
            break label690;
          }
          bool3 = true;
          ad.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((ae.fFw.fBr == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            a(this.fBM, false);
            if ((ae.fFw.fBs == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              b(this.fBM);
            }
            if ((ae.fFD.fEk != -1) && (ae.fFD.fEk == 1) && (com.tencent.mm.compatible.util.d.lh(14))) {
              c(this.fBM);
            }
            if ((ae.fFw.fBu == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              a(this.fBM);
            }
            if ((ae.fFw.fBv == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            d(this.fBM);
            amI();
            this.fBM.setPreviewTexture(paramSurfaceTexture);
            this.fBM.startPreview();
            if (!k.tCN.tDb) {
              break label639;
            }
            if ((ae.fFw.fBu == 0) && (this.mSensorManager != null) && (this.tCd != null)) {
              this.mSensorManager.registerListener(this, this.tCd, 2);
            }
            this.tCa = true;
            ad.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(bt.aS(l)), Looper.myLooper() });
            AppMethodBeat.o(89385);
            return 0;
          }
        }
        else
        {
          if (ae.fFw.fBq != 1) {
            break label665;
          }
          str = "Fix";
          continue;
        }
        if ((ae.fFw.fBq != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        a(this.fBM, true);
        continue;
        this.mSensorManager.registerListener(this, this.tCd, 2);
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
    this.tCp = parama;
    String str1;
    String str2;
    com.tencent.mm.plugin.base.model.a locala;
    if (parama == f.a.tCz)
    {
      parama = b.cPB();
      str1 = this.gxr.cPD();
      str2 = this.gxq.cPD();
      locala = this.tCm;
      if (locala.mJT != 0) {
        break label94;
      }
    }
    label94:
    for (int i = 0;; i = locala.mJS / locala.mJT)
    {
      parama.tBJ = ((int)(bt.aGj(str1) * 10.0D));
      parama.tBK = ((int)(bt.aGj(str2) * 10.0D));
      parama.tBP = i;
      AppMethodBeat.o(89374);
      return;
    }
  }
  
  public final void a(b paramb, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(89390);
    ad.i("MicroMsg.MMSightCamera", "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s", new Object[] { paramb, this.gxw, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.gxw != null) {
      try
      {
        this.gxv = true;
        Point localPoint = new Point();
        if (this.gxn != null) {
          localPoint.x = this.gxn.x;
        }
        for (localPoint.y = this.gxn.y;; localPoint.y = this.tCi.y)
        {
          byte[] arrayOfByte = j.tEA.g(Integer.valueOf(this.gxw.length));
          System.arraycopy(this.gxw, 0, arrayOfByte, 0, this.gxw.length);
          int i = this.gxm.dwp;
          paramb.a(arrayOfByte, localPoint.x, localPoint.y, i, paramInt);
          return;
          if ((this.tCk == null) || (!this.tCl)) {
            break;
          }
          localPoint.x = this.tCi.x;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.MMSightCamera", "takePicture error: %s", new Object[] { localException.getMessage() });
          this.gxv = false;
          paramb.a(null, 0, 0, -1, 0);
          return;
          localException.x = this.gwE.pUc;
          localException.y = this.gwE.pUd;
        }
      }
      finally
      {
        this.gxv = false;
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
      this.gxk.add(paramg);
    }
    AppMethodBeat.o(89372);
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(89400);
    ad.i("MicroMsg.MMSightCamera", "switch camera with limit, current useBack: %s", new Object[] { Boolean.valueOf(this.gwz) });
    try
    {
      cPL();
      if (!this.gwz) {}
      for (boolean bool = true;; bool = false)
      {
        x(paramContext, bool);
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
    ad.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", new Object[] { Boolean.valueOf(this.gwz) });
    try
    {
      cPL();
      if (!this.gwz) {}
      for (boolean bool = true;; bool = false)
      {
        x(paramContext, bool);
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
  
  public final boolean ani()
  {
    return this.gwz;
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89392);
    if (com.tencent.mm.compatible.util.d.lg(14))
    {
      AppMethodBeat.o(89392);
      return;
    }
    this.tCv.removeMessages(4354);
    this.tCv.fPl = paramFloat1;
    this.tCv.fPm = paramFloat2;
    this.tCv.gwV = paramInt1;
    this.tCv.gwW = paramInt2;
    this.tCv.sendMessageDelayed(this.tCv.obtainMessage(4354, this.fBM), 400L);
    AppMethodBeat.o(89392);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(89373);
    if (paramg != null) {
      this.gxk.remove(paramg);
    }
    AppMethodBeat.o(89373);
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(89396);
    if ((this.fBM != null) && (this.tCa)) {}
    for (;;)
    {
      int m;
      int k;
      int j;
      try
      {
        ad.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (this.aMX)
        {
          ad.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
          return;
        }
        Camera.Parameters localParameters = this.fBM.getParameters();
        if (localParameters.isZoomSupported())
        {
          this.aMX = true;
          m = localParameters.getZoom();
          k = localParameters.getMaxZoom();
          if (!paramBoolean2)
          {
            if (this.gxp <= 0)
            {
              this.gxp = Math.round(k / 15.0F);
              if (this.gxp > 5) {
                this.gxp = 5;
              }
            }
            i = this.gxp;
            ad.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(this.gxp), Integer.valueOf(this.gxo), Integer.valueOf(paramInt) });
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
            if (this.gxo <= 0)
            {
              ad.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", new Object[] { Integer.valueOf(this.gxo) });
              return;
            }
            i = this.gxo;
            continue;
            ad.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", new Object[] { Integer.valueOf(paramInt) });
            localParameters.setZoom(paramInt);
            this.fBM.setParameters(localParameters);
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
        this.aMX = false;
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
  
  public final void cPG()
  {
    AppMethodBeat.i(89382);
    ad.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
    if ((this.fBM != null) && (this.tCa)) {
      try
      {
        Camera.Parameters localParameters = this.fBM.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          ad.i("MicroMsg.MMSightCameraSetting", "support continuous video");
          localParameters.setFocusMode("continuous-video");
        }
        this.fBM.setParameters(localParameters);
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
  
  public final void cPH()
  {
    AppMethodBeat.i(89383);
    ad.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode");
    if ((this.fBM != null) && (this.tCa)) {
      try
      {
        Camera.Parameters localParameters = this.fBM.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          ad.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
        }
        this.fBM.setParameters(localParameters);
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
  
  public final String cPI()
  {
    AppMethodBeat.i(89389);
    if (this.fBM == null)
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
        localObject3 = com.tencent.mm.plugin.mmsight.d.f(this.fBM.getParameters());
        if (this.gwH == null)
        {
          Object localObject1 = com.tencent.mm.plugin.mmsight.d.fv(this.mContext);
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
        localObject2 = new Point(this.gwH.getWidth(), this.gwH.getHeight());
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
    if (this.gxn != null) {
      localStringBuffer.append("\nSIGHTCROPMODE:  " + this.gxn.x + " " + this.gxn.y + " from " + this.gwE.pUc + " " + this.gwE.pUd);
    }
    for (;;)
    {
      localStringBuffer.append("\ngetOrientation:" + getOrientation());
      localStringBuffer.append("\nrecorderOption: " + ae.fFD.fEj);
      localObject2 = localStringBuffer.toString();
      AppMethodBeat.o(89389);
      return localObject2;
      localStringBuffer.append("\nFinalPreviewSize: " + getPreviewWidth() + " " + getPreviewHeight());
    }
  }
  
  public final void cPJ()
  {
    AppMethodBeat.i(89393);
    if ((this.fBM != null) && (this.tCa)) {
      try
      {
        Camera.Parameters localParameters = this.fBM.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("auto")))
        {
          ad.i("MicroMsg.MMSightCameraSetting", "support auto focus");
          localParameters.setFocusMode("auto");
          this.fBM.setParameters(localParameters);
        }
        this.fBM.cancelAutoFocus();
        AppMethodBeat.o(89393);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.fBM.autoFocus(new Camera.AutoFocusCallback()
            {
              public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
              {
                AppMethodBeat.i(89363);
                if ((paramAnonymousCamera != null) && (f.this.cPP())) {
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
  
  public final List<Integer> cPK()
  {
    AppMethodBeat.i(89394);
    if (this.fBM != null) {
      try
      {
        Object localObject = this.fBM.getParameters();
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
  
  public final int cPL()
  {
    AppMethodBeat.i(89401);
    cPF();
    AppMethodBeat.o(89401);
    return 0;
  }
  
  public final void cPM()
  {
    AppMethodBeat.i(89402);
    ad.i("MicroMsg.MMSightCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[] { this.fBM, Boolean.valueOf(this.tCa) });
    if ((this.fBM != null) && (this.tCa)) {
      try
      {
        this.tCn = true;
        Camera.Parameters localParameters = this.fBM.getParameters();
        if ((!bt.gL(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("torch")))
        {
          localParameters.setFlashMode("torch");
          this.fBM.setParameters(localParameters);
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
  
  public final void cPN()
  {
    AppMethodBeat.i(89403);
    ad.i("MicroMsg.MMSightCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[] { this.fBM, Boolean.valueOf(this.tCa) });
    if ((this.fBM != null) && (this.tCa)) {
      try
      {
        this.tCn = false;
        Camera.Parameters localParameters = this.fBM.getParameters();
        if ((!bt.gL(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("off")))
        {
          localParameters.setFlashMode("off");
          this.fBM.setParameters(localParameters);
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
  
  public final void cPO()
  {
    AppMethodBeat.i(89404);
    ad.i("MicroMsg.MMSightCamera", "autoFlash, camera: %s, isPreviewing: %s", new Object[] { this.fBM, Boolean.valueOf(this.tCa) });
    if ((this.fBM != null) && (this.tCa)) {
      try
      {
        this.tCn = true;
        Camera.Parameters localParameters = this.fBM.getParameters();
        if ((!bt.gL(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("auto")))
        {
          localParameters.setFlashMode("auto");
          this.fBM.setParameters(localParameters);
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
  
  public final boolean cPP()
  {
    return this.tCa;
  }
  
  public final Point getEncodeVideoBestSize()
  {
    return this.tCi;
  }
  
  public final int getOrientation()
  {
    if ((this.gxm != null) && (this.tCa)) {
      return this.gxm.dwp;
    }
    return -1;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(89406);
    if (this.fBM == null)
    {
      AppMethodBeat.o(89406);
      return 0;
    }
    if (this.gxm != null) {
      try
      {
        int i;
        if ((this.tCl) && (this.tCk != null)) {
          if ((this.gxm.dwp == 0) || (this.gxm.dwp == 180)) {
            i = this.tCi.y;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89406);
          return i;
          i = this.tCi.x;
          continue;
          if (this.gxn == null)
          {
            if ((this.gxm.dwp == 0) || (this.gxm.dwp == 180)) {
              i = this.gwE.pUd;
            } else {
              i = this.gwE.pUc;
            }
          }
          else if ((this.gxm.dwp == 0) || (this.gxm.dwp == 180)) {
            i = this.gxn.y;
          } else {
            i = this.gxn.x;
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
    if (this.fBM == null)
    {
      AppMethodBeat.o(89405);
      return 0;
    }
    if (this.gxm != null) {
      try
      {
        int i;
        if ((this.tCl) && (this.tCk != null)) {
          if ((this.gxm.dwp == 0) || (this.gxm.dwp == 180)) {
            i = this.tCi.x;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(89405);
          return i;
          i = this.tCi.y;
          continue;
          if (this.gxn == null)
          {
            if ((this.gxm.dwp == 0) || (this.gxm.dwp == 180)) {
              i = this.gwE.pUc;
            } else {
              i = this.gwE.pUd;
            }
          }
          else if ((this.gxm.dwp == 0) || (this.gxm.dwp == 180)) {
            i = this.gxn.x;
          } else {
            i = this.gxn.y;
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
  
  public final void mJ(int paramInt)
  {
    AppMethodBeat.i(89397);
    if (this.gxo > 0)
    {
      AppMethodBeat.o(89397);
      return;
    }
    if (this.gwH == null) {}
    int i;
    for (Point localPoint = ai.cf(aj.getContext());; localPoint = new Point(this.gwH.getWidth(), this.gwH.getHeight()))
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
      if (this.fBM != null)
      {
        i = this.fBM.getParameters().getMaxZoom();
        this.gxo = ((int)(i / (paramInt / 3.0D / 10.0D)) + 1);
        ad.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.gxo), Integer.valueOf(i) });
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
    if ((Math.abs(this.tCe - f1) > 5.0F) || (Math.abs(this.tCf - f2) > 5.0F) || (Math.abs(this.tCg - f3) > 5.0F))
    {
      ad.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", new Object[] { Float.valueOf(5.0F), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      this.tCv.e(this.fBM);
      this.tCe = f1;
      this.tCf = f2;
      this.tCg = f3;
    }
    AppMethodBeat.o(89391);
  }
  
  public final boolean x(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(89398);
    if ((!k.tCN.tDb) || ((ae.fFw.fBu == 0) && (this.mSensorManager == null) && (this.tCd == null)))
    {
      this.mSensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
      this.tCd = this.mSensorManager.getDefaultSensor(1);
    }
    if (this.fBM == null)
    {
      cPF();
      this.gwz = paramBoolean;
      if (paramBoolean) {}
      try
      {
        for (this.tCb = com.tencent.mm.compatible.deviceinfo.d.Wz();; this.tCb = com.tencent.mm.compatible.deviceinfo.d.WA())
        {
          ad.i("MicroMsg.MMSightCamera", "use camera id %d, SrvDeviceInfo id %d", new Object[] { Integer.valueOf(this.tCb), Integer.valueOf(ae.fFw.fBx) });
          this.tCt = false;
          this.mContext = paramContext;
          this.gxm = new o().V(paramContext, this.tCb);
          ad.i("MicroMsg.MMSightCamera", "open camera end, %s", new Object[] { Looper.myLooper() });
          if (this.gxm != null) {
            break;
          }
          ad.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", new Object[] { Looper.myLooper() });
          amt();
          AppMethodBeat.o(89398);
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.MMSightCamera", localException, "try to get cameraid error %s, useBackCamera: %s", new Object[] { localException.getMessage(), Boolean.valueOf(this.gwz) });
          this.tCb = 0;
        }
        this.fBM = this.gxm.fBM;
        this.tCv.gwU = false;
        this.gwE.dwp = this.gxm.dwp;
        if (this.fBM == null)
        {
          ad.e("MicroMsg.MMSightCamera", "start camera FAILED!");
          amt();
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
    extends ap
  {
    float fPl;
    float fPm;
    int gwR = 0;
    boolean gwS = false;
    boolean gwT = false;
    boolean gwU = false;
    int gwV;
    int gwW;
    
    public c(Looper paramLooper)
    {
      super();
    }
    
    private static int GT(int paramInt)
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
      localObject = new Rect(GT(Math.round(((RectF)localObject).left)), GT(Math.round(((RectF)localObject).top)), GT(Math.round(((RectF)localObject).right)), GT(Math.round(((RectF)localObject).bottom)));
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
      if (!f.tCu)
      {
        ad.w("MicroMsg.MMSightCamera", "auto focus not back");
        AppMethodBeat.o(89368);
        return;
      }
      f.tCu = false;
      try
      {
        ad.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
        paramv.cancelAutoFocus();
        paramv.autoFocus(f.this.gwZ);
        AppMethodBeat.o(89368);
        return;
      }
      catch (Exception paramv)
      {
        ad.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", new Object[] { paramv.getMessage() });
        f.tCu = true;
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
        if ((this.gwV == 0) || (this.gwW == 0) || (com.tencent.mm.compatible.util.d.lg(14)))
        {
          e(paramMessage);
          AppMethodBeat.o(89370);
          return;
        }
        float f1 = this.fPl;
        float f2 = this.fPm;
        int i = this.gwV;
        j = this.gwW;
        if (paramMessage == null)
        {
          ad.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
          AppMethodBeat.o(89370);
          return;
        }
        if (!f.tCu)
        {
          ad.w("MicroMsg.MMSightCamera", "auto focus not back");
          AppMethodBeat.o(89370);
          return;
        }
        f.tCu = false;
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
          paramMessage.autoFocus(f.this.gwZ);
          AppMethodBeat.o(89370);
          return;
        }
        catch (Exception paramMessage)
        {
          ad.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
          f.tCu = true;
          AppMethodBeat.o(89370);
          return;
        }
        if (this.gwU)
        {
          AppMethodBeat.o(89370);
          return;
        }
        Object localObject1 = (Camera)paramMessage.obj;
        Camera.Parameters localParameters = ((Camera)localObject1).getParameters();
        ad.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(this.gwS), Integer.valueOf(this.gwR), Integer.valueOf(localParameters.getZoom()) });
        i = localParameters.getZoom() + this.gwR;
        if (this.gwS)
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
          this.gwV = 0;
          this.gwW = 0;
          continue;
          paramMessage = obtainMessage(4353, paramMessage.obj);
          if (this.gwT) {}
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
          if (this.gwT) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.f
 * JD-Core Version:    0.7.0.1
 */