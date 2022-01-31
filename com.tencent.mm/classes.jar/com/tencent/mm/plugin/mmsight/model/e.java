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
import android.hardware.Camera.Parameters;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.a.mo.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e
  implements SensorEventListener
{
  protected static int oGV = 2147483647;
  static boolean oHn = true;
  protected boolean asm;
  protected SensorManager bmB;
  protected boolean eZK;
  protected p eZN;
  protected boolean eZZ;
  protected u eoH;
  private b faA;
  private b faB;
  private b faC;
  public volatile boolean faD;
  public volatile byte[] faE;
  Camera.AutoFocusCallback fah;
  protected List<f> fas;
  protected d.a.a fau;
  protected Point fav;
  protected int faw;
  protected int fax;
  private b fay;
  private b faz;
  protected Context mContext;
  protected boolean oGT;
  protected int oGU;
  protected Sensor oGW;
  protected float oGX;
  protected float oGY;
  protected float oGZ;
  protected Point oHa;
  protected Point oHb;
  protected int oHc;
  protected byte[] oHd;
  protected boolean oHe;
  protected com.tencent.mm.plugin.base.model.a oHf;
  protected boolean oHg;
  protected boolean oHh;
  private a oHi;
  private b oHj;
  protected VideoTransPara oHk;
  public boolean oHl;
  private boolean oHm;
  public e.c oHo;
  private int scene;
  
  public e(VideoTransPara paramVideoTransPara, int paramInt)
  {
    AppMethodBeat.i(76478);
    this.fax = -1;
    this.faw = -1;
    this.eZZ = false;
    this.asm = false;
    this.eoH = null;
    this.oGT = false;
    this.oGU = 0;
    this.oGX = 0.0F;
    this.oGY = 0.0F;
    this.oGZ = 0.0F;
    this.mContext = null;
    this.oHa = null;
    this.oHb = null;
    this.fav = null;
    this.oHc = 0;
    this.oHe = false;
    this.oHf = new com.tencent.mm.plugin.base.model.a();
    this.oHg = false;
    this.fas = new ArrayList();
    this.oHh = false;
    this.oHi = a.oHq;
    this.fay = new b("prevcameraCallback");
    this.faz = new b("cameraCallback");
    this.faA = new b("cameraPreviewCallback");
    this.faB = new b("cameraCropCallback");
    this.oHj = new b("mirrorCameraCallback");
    this.faC = new b("finishCallbackTimeCallback");
    this.scene = 0;
    this.faE = null;
    this.faD = false;
    this.oHl = false;
    this.oHm = false;
    this.fah = new e.2(this);
    this.oHo = new e.c(this, Looper.getMainLooper());
    this.eZK = true;
    this.eZN = p.bRh();
    this.oHk = paramVideoTransPara;
    this.scene = paramInt;
    AppMethodBeat.o(76478);
  }
  
  private void WM()
  {
    AppMethodBeat.i(76495);
    if (true == this.oHm)
    {
      AppMethodBeat.o(76495);
      return;
    }
    if (this.mContext == null)
    {
      AppMethodBeat.o(76495);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.f.b.Me()))
    {
      AppMethodBeat.o(76495);
      return;
    }
    Object localObject = new mo();
    ((mo)localObject).cCK.type = 2;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    if (((mo)localObject).cCL.cCJ)
    {
      this.oHm = true;
      AppMethodBeat.o(76495);
      return;
    }
    localObject = h.h(this.mContext, 2131303686, 2131297087);
    if (localObject != null)
    {
      ((com.tencent.mm.ui.widget.b.c)localObject).setCancelable(false);
      ((com.tencent.mm.ui.widget.b.c)localObject).setCanceledOnTouchOutside(false);
      ((com.tencent.mm.ui.widget.b.c)localObject).show();
      this.oHm = true;
    }
    AppMethodBeat.o(76495);
  }
  
  private void Xa()
  {
    AppMethodBeat.i(76491);
    if (this.eoH != null) {
      try
      {
        Object localObject = this.eoH.getParameters();
        ab.i("MicroMsg.MMSightCamera", "setPreviewCallbackImpl");
        int i = this.eZN.mnr;
        int j = this.eZN.mns;
        j = ImageFormat.getBitsPerPixel(((Camera.Parameters)localObject).getPreviewFormat()) * (i * j) / 8;
        i = 0;
        while (i < 5)
        {
          localObject = com.tencent.mm.plugin.mmsight.model.a.j.oJp.f(Integer.valueOf(j));
          this.eoH.addCallbackBuffer((byte[])localObject);
          i += 1;
        }
        this.fay.reset();
        this.faz.reset();
        this.faA.reset();
        this.faB.reset();
        this.oHj.reset();
        this.faC.reset();
        this.oHf = new com.tencent.mm.plugin.base.model.a();
        this.eoH.setPreviewCallbackWithBuffer(new e.1(this));
        AppMethodBeat.o(76491);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.MMSightCamera", "setPreviewCallbackImpl error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(76491);
  }
  
  private static boolean a(u paramu)
  {
    AppMethodBeat.i(76488);
    if (paramu == null)
    {
      AppMethodBeat.o(76488);
      return false;
    }
    for (;;)
    {
      Camera.Parameters localParameters;
      List localList;
      try
      {
        localParameters = paramu.getParameters();
        localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          ab.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
          paramu.setParameters(localParameters);
          AppMethodBeat.o(76488);
          return true;
        }
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          ab.i("MicroMsg.MMSightCameraSetting", "support continuous video");
          localParameters.setFocusMode("continuous-video");
          continue;
        }
        if (localList == null) {
          break label178;
        }
      }
      catch (Exception paramu)
      {
        ab.i("MicroMsg.MMSightCameraSetting", "setFocusMode Exception, %s, %s", new Object[] { Looper.myLooper(), paramu.getMessage() });
        AppMethodBeat.o(76488);
        return false;
      }
      if (localList.contains("auto"))
      {
        ab.i("MicroMsg.MMSightCameraSetting", "support auto focus");
        localParameters.setFocusMode("auto");
      }
      else
      {
        label178:
        ab.i("MicroMsg.MMSightCameraSetting", "not support continuous video or auto focus");
      }
    }
  }
  
  private boolean a(u paramu, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(76484);
    if ((paramu == null) || (paramInt <= 0))
    {
      AppMethodBeat.o(76484);
      return false;
    }
    for (;;)
    {
      try
      {
        Camera.Parameters localParameters = paramu.getParameters();
        new Point(paramInt, (int)(paramInt / paramFloat));
        Object localObject = af.hQ(ah.getContext());
        Point localPoint = new Point(Math.min(((Point)localObject).x, ((Point)localObject).y), Math.max(((Point)localObject).x, ((Point)localObject).y));
        ab.i("MicroMsg.MMSightCamera", "screenSize: %s, currentScreenSize: %s", new Object[] { localPoint, localObject });
        float f1 = Math.min(localPoint.x, localPoint.y) / Math.max(localPoint.x, localPoint.y);
        float f2 = 1.0F / paramFloat;
        int i;
        if (paramFloat < 1.0F)
        {
          i = paramInt;
          ab.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", new Object[] { Integer.valueOf(i), Float.valueOf(paramFloat), Float.valueOf(f1) });
          if (this.fau.rotate == 90) {
            break label724;
          }
          if (this.fau.rotate != 270) {
            break label736;
          }
          break label724;
          g.b localb = g.a(localParameters, localPoint, i, bool);
          if (localb != null)
          {
            localObject = localb;
            if (localb.oHu != null) {}
          }
          else
          {
            ab.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
            if (this.fau.rotate == 90) {
              break label730;
            }
            if (this.fau.rotate != 270) {
              break label742;
            }
            break label730;
            localObject = g.c(localParameters, localPoint, paramInt, bool);
            this.oHl = false;
          }
          if ((localObject != null) && (((g.b)localObject).oHu != null))
          {
            paramInt = (int)(((g.b)localObject).oHu.x * paramFloat);
            ab.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio result preview size: %s, cropHeight: %s", new Object[] { ((g.b)localObject).oHu, Integer.valueOf(paramInt) });
            if (paramInt <= ((g.b)localObject).oHu.y) {
              this.oHl = false;
            }
          }
          else
          {
            if ((localObject == null) || (((g.b)localObject).oHu == null)) {
              continue;
            }
            localObject = ((g.b)localObject).oHu;
            this.eZN.mnr = ((Point)localObject).x;
            this.eZN.mns = ((Point)localObject).y;
            this.oHb = ((Point)localObject);
            this.fav = null;
            if (!paramBoolean)
            {
              if ((j.oHG.eqK != 2) || (com.tencent.mm.plugin.mmsight.d.zo(this.oHb.y))) {
                break label713;
              }
              paramInt = com.tencent.mm.plugin.mmsight.d.zp(this.oHb.y);
              if (Math.abs(paramInt - this.oHb.y) > 16) {
                break label702;
              }
              ab.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.oHb, Integer.valueOf(paramInt) });
              this.oHa = new Point(this.oHb.x, this.oHb.y);
              this.oHb.y = paramInt;
              this.oHe = true;
              this.oHd = new byte[this.oHb.x * this.oHb.y * 3 / 2];
            }
            ab.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s, cropWidth: %s", new Object[] { localObject, this.oHb, this.fav, Boolean.valueOf(this.oHl) });
            localParameters.setPreviewSize(this.eZN.mnr, this.eZN.mns);
            paramu.setParameters(localParameters);
            AppMethodBeat.o(76484);
            return true;
          }
        }
        else
        {
          f2 = paramInt / f2;
          i = Math.round(f2);
          continue;
        }
        this.oHl = true;
        continue;
        j.d(this.oHb);
      }
      catch (Exception paramu)
      {
        ab.e("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimit error: %s", new Object[] { paramu.getMessage() });
        AppMethodBeat.o(76484);
        return false;
      }
      label702:
      continue;
      label713:
      j.d(this.oHb);
      continue;
      label724:
      boolean bool = true;
      continue;
      label730:
      bool = true;
      continue;
      label736:
      bool = false;
      continue;
      label742:
      bool = false;
    }
  }
  
  private static boolean a(u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(76486);
    if (paramu == null)
    {
      AppMethodBeat.o(76486);
      return false;
    }
    Camera.Parameters localParameters;
    label240:
    List localList2;
    do
    {
      for (;;)
      {
        try
        {
          localParameters = paramu.getParameters();
          if (!paramBoolean) {
            break label240;
          }
          if (ac.eru.eoh > 0)
          {
            ab.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview frame rate");
            ab.i("MicroMsg.MMSightCameraSetting", "use fix mode %B, supported preview frame rates %s", new Object[] { Boolean.valueOf(paramBoolean), localParameters.getSupportedPreviewFrameRates() });
            paramu.setParameters(localParameters);
            AppMethodBeat.o(76486);
            return true;
          }
          if (localParameters == null)
          {
            ab.e("MicroMsg.MMSightCamera", "trySetPreviewFrameRateParameters error, p is null!");
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
            ab.i("MicroMsg.MMSightCameraSetting", "set preview frame rate %d", new Object[] { Integer.valueOf(i) });
          }
          catch (Exception localException1)
          {
            ab.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException1.getMessage() });
          }
        }
        catch (Exception paramu)
        {
          ab.i("MicroMsg.MMSightCameraSetting", "setPreviewFrameRate Exception, %s, %s", new Object[] { Looper.myLooper(), paramu.getMessage() });
          AppMethodBeat.o(76486);
          return false;
        }
        continue;
        if (ac.eru.eoh <= 0) {
          break;
        }
        ab.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview fps range");
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
            break label574;
          }
          i2 = i;
          i1 = j;
          if (arrayOfInt.length <= 1) {
            break label574;
          }
          int i5 = arrayOfInt[0];
          i4 = arrayOfInt[1];
          ab.i("MicroMsg.MMSightCamera", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4) });
          i2 = i;
          i1 = j;
          if (i5 < 0) {
            break label574;
          }
          i2 = i;
          i1 = j;
          if (i4 < i5) {
            break label574;
          }
          k = i;
          m = j;
          if (i4 < i) {
            break label587;
          }
          k = i;
          m = j;
          if (n != 0) {
            break label587;
          }
          k = i4;
          m = i5;
          break label587;
        }
        ab.i("MicroMsg.MMSightCameraSetting", "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(30) });
        if ((j == 2147483647) || (i == 2147483647)) {
          break;
        }
        try
        {
          localParameters.setPreviewFpsRange(j, i);
          ab.i("MicroMsg.MMSightCameraSetting", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        }
        catch (Exception localException2)
        {
          ab.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), localException2.getMessage() });
        }
      }
      break;
      label574:
      label587:
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
  
  private static boolean b(u paramu)
  {
    AppMethodBeat.i(76487);
    if (paramu == null)
    {
      AppMethodBeat.o(76487);
      return false;
    }
    try
    {
      ab.i("MicroMsg.MMSightCameraSetting", "safeSetPreviewFormat");
      Camera.Parameters localParameters = paramu.getParameters();
      List localList = localParameters.getSupportedPreviewFormats();
      if ((localList == null) || (!localList.contains(Integer.valueOf(17)))) {
        ab.e("MicroMsg.MMSightCameraSetting", "not support YCbCr_420_SP");
      }
      localParameters.setPreviewFormat(17);
      paramu.setParameters(localParameters);
      AppMethodBeat.o(76487);
      return true;
    }
    catch (Exception paramu)
    {
      ab.i("MicroMsg.MMSightCameraSetting", "setPreviewFormat Exception, %s, %s", new Object[] { Looper.myLooper(), paramu.getMessage() });
      AppMethodBeat.o(76487);
    }
    return false;
  }
  
  private boolean b(u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(76483);
    if (paramu == null)
    {
      AppMethodBeat.o(76483);
      return false;
    }
    Camera.Parameters localParameters;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    int i;
    boolean bool;
    for (;;)
    {
      try
      {
        localParameters = paramu.getParameters();
        localObject3 = com.tencent.mm.plugin.mmsight.d.ex(this.mContext);
        if (this.eZK)
        {
          localObject1 = a.bQG();
          localObject2 = localParameters.getSupportedPreviewSizes();
          localObject4 = localParameters.getSupportedPictureSizes();
          i = this.fau.rotate;
          if (bo.isNullOrNil(((a)localObject1).oGr)) {
            ((a)localObject1).oGr = com.tencent.mm.plugin.mmsight.d.cn((List)localObject2);
          }
          if (bo.isNullOrNil(((a)localObject1).oGs)) {
            ((a)localObject1).oGs = com.tencent.mm.plugin.mmsight.d.cn((List)localObject4);
          }
          ((a)localObject1).rotate = i;
          ((a)localObject1).oGM = 1;
          if (paramBoolean)
          {
            if (this.fau.rotate == 90) {
              break label2469;
            }
            if (this.fau.rotate == 270)
            {
              break label2469;
              j.a(localParameters, bool);
            }
          }
          else
          {
            com.tencent.mm.plugin.mmsight.model.a.k.bRq();
            i = com.tencent.mm.plugin.mmsight.model.a.k.bRt();
            if (this.fau.rotate == 90) {
              break label2475;
            }
            if (this.fau.rotate != 270) {
              break label475;
            }
            break label2475;
            label199:
            localObject2 = g.a(localParameters, (Point)localObject3, i, bool);
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((g.b)localObject2).oHu != null) {}
            }
            else
            {
              ab.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
              localObject1 = new Point(Math.min(((Point)localObject3).x, ((Point)localObject3).y), Math.max(((Point)localObject3).x, ((Point)localObject3).y));
              if (this.fau.rotate == 90) {
                break label2481;
              }
              if (this.fau.rotate != 270) {
                break label481;
              }
              break label2481;
              label301:
              localObject1 = g.c(localParameters, (Point)localObject1, 2100, bool);
              this.oHl = false;
            }
            j.a((g.b)localObject1);
            localObject2 = ((g.b)localObject1).oHu;
            if (localObject2 != null) {
              break;
            }
            k.bRb();
            AppMethodBeat.o(76483);
            return false;
          }
        }
        else
        {
          localObject1 = a.bQG();
          localObject2 = localParameters.getSupportedPreviewSizes();
          localObject4 = localParameters.getSupportedPictureSizes();
          i = this.fau.rotate;
          if (bo.isNullOrNil(((a)localObject1).oGt)) {
            ((a)localObject1).oGt = com.tencent.mm.plugin.mmsight.d.cn((List)localObject2);
          }
          if (bo.isNullOrNil(((a)localObject1).oGu)) {
            ((a)localObject1).oGu = com.tencent.mm.plugin.mmsight.d.cn((List)localObject4);
          }
          ((a)localObject1).rotate = i;
          ((a)localObject1).oGM = 2;
          continue;
        }
        bool = false;
      }
      catch (Exception paramu)
      {
        ab.i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), paramu.getMessage() });
        AppMethodBeat.o(76483);
        return false;
      }
      continue;
      label475:
      bool = false;
      continue;
      label481:
      bool = false;
    }
    this.eZN.mnr = ((Point)localObject2).x;
    this.eZN.mns = ((Point)localObject2).y;
    this.oHb = ((Point)localObject2);
    Object localObject3 = this.mContext;
    if (this.fau.rotate != 90) {
      if (this.fau.rotate == 270)
      {
        break label2487;
        label551:
        bool = com.tencent.mm.plugin.mmsight.d.a((Context)localObject3, (Point)localObject2, bool);
        i = 1;
        if ((this.fau.rotate != 90) && (this.fau.rotate != 270)) {
          break label1319;
        }
        if ((((Point)localObject2).y < this.oHk.width) || (((Point)localObject2).x < this.oHk.height))
        {
          i = 0;
          ab.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localObject2 });
        }
        label641:
        ab.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label1405;
        }
        if (j.oHG.eqK != 2) {
          break label1393;
        }
        this.fav = ((g.b)localObject1).oHw;
        if ((this.fav.x < ((Point)localObject2).x) || (this.fav.y < ((Point)localObject2).y))
        {
          if ((this.fau.rotate != 90) && (this.fau.rotate != 270)) {
            break label1373;
          }
          this.fav.y = com.tencent.mm.plugin.mmsight.d.zq(this.fav.y);
        }
        label758:
        this.oHb = new Point(this.fav.x, this.fav.y);
        this.oHc = (this.fav.x * this.fav.y * 3 / 2);
        ab.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", new Object[] { this.fav });
      }
    }
    label826:
    label2493:
    for (;;)
    {
      int j;
      label893:
      int k;
      if (j.oHG.oHS)
      {
        if ((this.fau.rotate != 90) && (this.fau.rotate != 270)) {
          break label2006;
        }
        if (i != 0)
        {
          if (j.oHG.eZQ != 1080) {
            break label1834;
          }
          if (this.fav != null) {
            break label1782;
          }
          j = ((Point)localObject2).x / 2;
          if (this.fav != null) {
            break label1796;
          }
          i = ((Point)localObject2).y / 2;
          if (this.fav != null) {
            break label1810;
          }
          k = ((Point)localObject2).x;
          k = com.tencent.mm.plugin.mmsight.d.eE(j, k);
          if (this.fav != null) {
            break label1822;
          }
          j = ((Point)localObject2).y;
          this.oHb = new Point(k, com.tencent.mm.plugin.mmsight.d.eE(i, j));
        }
      }
      label966:
      localObject1 = a.bQG();
      localObject3 = this.fav;
      localObject4 = this.oHb;
      ((a)localObject1).oGA = -1;
      ((a)localObject1).oGz = -1;
      ((a)localObject1).oGw = -1;
      ((a)localObject1).oGv = -1;
      ((a)localObject1).oGy = -1;
      ((a)localObject1).oGx = -1;
      if (localObject2 != null)
      {
        ((a)localObject1).oGx = ((Point)localObject2).x;
        ((a)localObject1).oGy = ((Point)localObject2).y;
      }
      if (localObject3 != null)
      {
        ((a)localObject1).oGv = ((Point)localObject3).x;
        ((a)localObject1).oGw = ((Point)localObject3).y;
      }
      if (localObject4 != null)
      {
        ((a)localObject1).oGz = ((Point)localObject4).x;
        ((a)localObject1).oGA = ((Point)localObject4).y;
      }
      if (paramBoolean) {
        if ((!bool) && (j.oHG.eqK == 2) && (!com.tencent.mm.plugin.mmsight.d.zo(this.oHb.y)))
        {
          i = com.tencent.mm.plugin.mmsight.d.zp(this.oHb.y);
          if (Math.abs(i - this.oHb.y) <= 16)
          {
            ab.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", new Object[] { this.oHb, Integer.valueOf(i) });
            this.oHa = new Point(this.oHb.x, this.oHb.y);
            this.oHb.y = i;
            this.oHe = true;
            this.oHd = new byte[this.oHb.x * this.oHb.y * 3 / 2];
          }
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", new Object[] { localObject2, this.oHb, this.fav });
        localParameters.setPreviewSize(this.eZN.mnr, this.eZN.mns);
        paramu.setParameters(localParameters);
        AppMethodBeat.o(76483);
        return true;
        bool = false;
        break;
        if ((((Point)localObject2).x >= this.oHk.width) && (((Point)localObject2).y >= this.oHk.height)) {
          break label641;
        }
        i = 0;
        ab.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", new Object[] { localObject2 });
        break label641;
        label1373:
        this.fav.x = com.tencent.mm.plugin.mmsight.d.zq(this.fav.x);
        break label758;
        label1393:
        this.fav = ((g.b)localObject1).oHv;
        break label758;
        label1405:
        if ((!j.oHG.oHS) || (j.oHG.eZQ != 1080) || (i == 0)) {
          break label2466;
        }
        if ((this.fau.rotate == 90) || (this.fau.rotate == 270))
        {
          j = ((Point)localObject2).y / 2;
          k = com.tencent.mm.plugin.mmsight.d.zp(j);
          m = ((Point)localObject2).x / 2;
          n = com.tencent.mm.plugin.mmsight.d.zp(m);
          if ((Math.abs(k - j) < 8) && (Math.abs(n - m) < 8)) {
            break label2493;
          }
          this.fav = new Point(((Point)localObject2).x, ((Point)localObject2).y);
          this.fav.y = com.tencent.mm.plugin.mmsight.d.zq(((Point)localObject2).y);
          this.fav.x = com.tencent.mm.plugin.mmsight.d.zq(((Point)localObject2).x);
          this.oHb = new Point(this.fav.x, this.fav.y);
          this.oHc = (this.fav.x * this.fav.y * 3 / 2);
          bool = true;
          break label2493;
        }
        j = ((Point)localObject2).x / 2;
        k = com.tencent.mm.plugin.mmsight.d.zp(j);
        int m = ((Point)localObject2).y / 2;
        int n = com.tencent.mm.plugin.mmsight.d.zp(m);
        if ((Math.abs(k - j) < 8) && (Math.abs(n - m) < 8)) {
          break label2466;
        }
        this.fav = new Point(((Point)localObject2).x, ((Point)localObject2).y);
        this.fav.y = com.tencent.mm.plugin.mmsight.d.zq(((Point)localObject2).x);
        this.fav.x = com.tencent.mm.plugin.mmsight.d.zq(((Point)localObject2).y);
        this.oHb = new Point(this.fav.x, this.fav.y);
        this.oHc = (this.fav.x * this.fav.y * 3 / 2);
        bool = true;
        break label826;
        label1782:
        j = this.fav.x / 2;
        break label893;
        i = this.fav.y / 2;
        break label909;
        k = this.fav.x;
        break label923;
        j = this.fav.y;
        break label946;
        if (j.oHG.eZQ != 720) {
          break label966;
        }
        float f;
        if (this.fav == null)
        {
          f = ((Point)localObject2).x * 0.75F;
          label1864:
          k = (int)f;
          if (this.fav != null) {
            break label1966;
          }
          f = ((Point)localObject2).y * 0.75F;
          label1886:
          j = (int)f;
          if (this.fav != null) {
            break label1982;
          }
          i = ((Point)localObject2).x;
          label1904:
          k = com.tencent.mm.plugin.mmsight.d.eE(k, i);
          if (this.fav != null) {
            break label1994;
          }
        }
        label1982:
        label1994:
        for (i = ((Point)localObject2).y;; i = this.fav.y)
        {
          this.oHb = new Point(k, com.tencent.mm.plugin.mmsight.d.eE(j, i));
          break;
          f = this.fav.x * 0.75F;
          break label1864;
          f = this.fav.y * 0.75F;
          break label1886;
          i = this.fav.x;
          break label1904;
        }
        label2006:
        if (i == 0) {
          break label966;
        }
        if (j.oHG.eZQ == 1080)
        {
          if (this.fav == null)
          {
            j = ((Point)localObject2).y / 2;
            label2039:
            if (this.fav != null) {
              break label2129;
            }
            i = ((Point)localObject2).x / 2;
            if (this.fav != null) {
              break label2143;
            }
            k = ((Point)localObject2).y;
            k = com.tencent.mm.plugin.mmsight.d.eE(j, k);
            if (this.fav != null) {
              break label2155;
            }
          }
          label2129:
          label2143:
          label2155:
          for (j = ((Point)localObject2).x;; j = this.fav.x)
          {
            this.oHb = new Point(k, com.tencent.mm.plugin.mmsight.d.eE(i, j));
            break;
            j = this.fav.y / 2;
            break label2039;
            i = this.fav.x / 2;
            break label2055;
            k = this.fav.y;
            break label2069;
          }
        }
        if (j.oHG.eZQ != 720) {
          break label966;
        }
        if (this.fav == null)
        {
          f = ((Point)localObject2).y * 0.75F;
          k = (int)f;
          if (this.fav != null) {
            break label2299;
          }
          f = ((Point)localObject2).x * 0.75F;
          j = (int)f;
          if (this.fav != null) {
            break label2315;
          }
          i = ((Point)localObject2).y;
          label2237:
          k = com.tencent.mm.plugin.mmsight.d.eE(k, i);
          if (this.fav != null) {
            break label2327;
          }
        }
        for (i = ((Point)localObject2).x;; i = this.fav.x)
        {
          this.oHb = new Point(k, com.tencent.mm.plugin.mmsight.d.eE(j, i));
          break;
          f = this.fav.y * 0.75F;
          break label2197;
          label2299:
          f = this.fav.x * 0.75F;
          break label2219;
          i = this.fav.y;
          break label2237;
        }
        j.d(this.oHb);
        continue;
        j.d(this.oHb);
        continue;
        if ((!bool) && (j.oHG.eqK == 2) && (!com.tencent.mm.plugin.mmsight.d.zo(this.oHb.y)) && (this.oHe) && (this.oHd != null) && (this.oHa.y == this.oHb.y))
        {
          i = com.tencent.mm.plugin.mmsight.d.zp(this.oHb.y);
          if (this.oHd.length == this.oHb.x * i * 3 / 2) {
            this.oHb.y = i;
          }
        }
      }
      continue;
      bool = true;
      break;
      bool = true;
      break label199;
      bool = true;
      break label301;
      bool = true;
      break label551;
    }
  }
  
  private void bQK()
  {
    AppMethodBeat.i(76482);
    try
    {
      if ((this.bmB != null) && (this.oGW != null)) {
        this.bmB.unregisterListener(this);
      }
      ab.i("MicroMsg.MMSightCamera", this.fay.getValue());
      ab.i("MicroMsg.MMSightCamera", this.faz.getValue());
      ab.i("MicroMsg.MMSightCamera", this.faA.getValue());
      ab.i("MicroMsg.MMSightCamera", this.faB.getValue());
      ab.i("MicroMsg.MMSightCamera", this.oHj.getValue());
      ab.i("MicroMsg.MMSightCamera", this.faC.getValue());
      if (this.eoH != null)
      {
        long l = bo.yB();
        ab.i("MicroMsg.MMSightCamera", "release camera beg, %s", new Object[] { Looper.myLooper() });
        this.oHo.removeCallbacksAndMessages(null);
        this.oHo.fab = true;
        this.eoH.setPreviewCallback(null);
        this.eoH.stopPreview();
        this.eoH.release();
        this.eoH = null;
        this.oGT = false;
        ab.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", new Object[] { Long.valueOf(bo.av(l)), Looper.myLooper() });
      }
      this.eZZ = false;
      this.oGX = 0.0F;
      this.oGY = 0.0F;
      this.oGZ = 0.0F;
      oHn = true;
      this.mContext = null;
      this.oHm = false;
      this.oHb = null;
      this.fav = null;
      this.faE = null;
      this.oHh = false;
      AppMethodBeat.o(76482);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MMSightCamera", localException, "cameraRelease error", new Object[0]);
      AppMethodBeat.o(76482);
    }
  }
  
  @TargetApi(14)
  private static boolean c(u paramu)
  {
    AppMethodBeat.i(76485);
    if (paramu == null)
    {
      AppMethodBeat.o(76485);
      return false;
    }
    try
    {
      ab.i("MicroMsg.MMSightCameraSetting", "safeSetMetering");
      Camera.Parameters localParameters = paramu.getParameters();
      if (localParameters.getMaxNumMeteringAreas() > 0)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new Camera.Area(new Rect(-1000, -1000, 1000, 1000), 600));
        localParameters.setMeteringAreas(localArrayList);
      }
      paramu.setParameters(localParameters);
      AppMethodBeat.o(76485);
      return true;
    }
    catch (Exception paramu)
    {
      ab.i("MicroMsg.MMSightCameraSetting", "safeSetMetering Exception, %s, %s", new Object[] { Looper.myLooper(), paramu.getMessage() });
      AppMethodBeat.o(76485);
    }
    return false;
  }
  
  private static void d(u paramu)
  {
    AppMethodBeat.i(76494);
    try
    {
      Camera.Parameters localParameters = paramu.getParameters();
      if (localParameters.isZoomSupported()) {
        localParameters.setZoom(0);
      }
      paramu.setParameters(localParameters);
      AppMethodBeat.o(76494);
      return;
    }
    catch (Exception paramu)
    {
      ab.e("MicroMsg.MMSightCamera", "safeResetZoom error: %s", new Object[] { paramu.getMessage() });
      AppMethodBeat.o(76494);
    }
  }
  
  public final int a(SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(76493);
    long l = bo.yB();
    this.oHh = false;
    ab.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s", new Object[] { Boolean.valueOf(this.oGT), Looper.myLooper(), paramSurfaceTexture });
    if (this.oGT)
    {
      AppMethodBeat.o(76493);
      return 0;
    }
    if (paramSurfaceTexture == null)
    {
      paramInt = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(76493);
      return 0 - paramInt;
    }
    ab.i("MicroMsg.MMSightCamera", "this texture %s", new Object[] { paramSurfaceTexture });
    for (;;)
    {
      try
      {
        a(this.eoH, paramInt, paramFloat, paramBoolean);
        if (com.tencent.mm.plugin.mmsight.model.a.k.bRq().oJr == null) {
          break label654;
        }
        localInteger = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.k.bRq().oJr.oGa);
        if (ac.eru.eom == 1)
        {
          str = "Range";
          if (ac.eru.eon != 1) {
            break label671;
          }
          paramBoolean = true;
          if (ac.eru.eoo != 1) {
            break label677;
          }
          bool1 = true;
          if (ac.eru.eop != 1) {
            break label683;
          }
          bool2 = true;
          if (ac.eru.eoq != 1) {
            break label689;
          }
          bool3 = true;
          ab.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((ac.eru.eom == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            a(this.eoH, false);
            if ((ac.eru.eon == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              b(this.eoH);
            }
            if ((ac.erB.eqS != -1) && (ac.erB.eqS == 1) && (com.tencent.mm.compatible.util.d.iU(14))) {
              c(this.eoH);
            }
            if ((ac.eru.eop == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              a(this.eoH);
            }
            if ((ac.eru.eoq == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            d(this.eoH);
            Xa();
            this.eoH.setPreviewTexture(paramSurfaceTexture);
            this.eoH.startPreview();
            if (!j.oHG.oHT) {
              break label637;
            }
            if ((ac.eru.eop == 0) && (this.bmB != null) && (this.oGW != null)) {
              this.bmB.registerListener(this, this.oGW, 2);
            }
            this.oGT = true;
            ab.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(bo.av(l)), Looper.myLooper() });
            AppMethodBeat.o(76493);
            return 0;
          }
        }
        else
        {
          if (ac.eru.eol != 1) {
            break label663;
          }
          str = "Fix";
          continue;
        }
        if ((ac.eru.eol != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        a(this.eoH, true);
        continue;
        this.bmB.registerListener(this, this.oGW, 2);
      }
      catch (Exception paramSurfaceTexture)
      {
        ab.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        paramInt = com.tencent.mm.compatible.util.g.getLine();
        AppMethodBeat.o(76493);
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
    AppMethodBeat.i(76492);
    long l = bo.yB();
    this.oHh = false;
    ab.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", new Object[] { Boolean.valueOf(this.oGT), Looper.myLooper(), paramSurfaceTexture, Boolean.valueOf(paramBoolean) });
    if (this.oGT)
    {
      AppMethodBeat.o(76492);
      return 0;
    }
    int i;
    if (paramSurfaceTexture == null)
    {
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(76492);
      return 0 - i;
    }
    ab.i("MicroMsg.MMSightCamera", "this texture %s", new Object[] { paramSurfaceTexture });
    for (;;)
    {
      try
      {
        b(this.eoH, paramBoolean);
        if (com.tencent.mm.plugin.mmsight.model.a.k.bRq().oJr == null) {
          break label656;
        }
        localInteger = Integer.valueOf(com.tencent.mm.plugin.mmsight.model.a.k.bRq().oJr.oGa);
        if (ac.eru.eom == 1)
        {
          str = "Range";
          if (ac.eru.eon != 1) {
            break label673;
          }
          paramBoolean = true;
          if (ac.eru.eoo != 1) {
            break label678;
          }
          bool1 = true;
          if (ac.eru.eop != 1) {
            break label684;
          }
          bool2 = true;
          if (ac.eru.eoq != 1) {
            break label690;
          }
          bool3 = true;
          ab.i("MicroMsg.MMSightCamera", "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]", new Object[] { localInteger, str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((ac.eru.eom == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 1)))
          {
            a(this.eoH, false);
            if ((ac.eru.eon == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 2))) {
              b(this.eoH);
            }
            if ((ac.erB.eqS != -1) && (ac.erB.eqS == 1) && (com.tencent.mm.compatible.util.d.iU(14))) {
              c(this.eoH);
            }
            if ((ac.eru.eop == 1) && ((localInteger.intValue() == 0) || (localInteger.intValue() == 4))) {
              a(this.eoH);
            }
            if ((ac.eru.eoq == 1) && (localInteger.intValue() != 0)) {
              localInteger.intValue();
            }
            d(this.eoH);
            Xa();
            this.eoH.setPreviewTexture(paramSurfaceTexture);
            this.eoH.startPreview();
            if (!j.oHG.oHT) {
              break label639;
            }
            if ((ac.eru.eop == 0) && (this.bmB != null) && (this.oGW != null)) {
              this.bmB.registerListener(this, this.oGW, 2);
            }
            this.oGT = true;
            ab.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", new Object[] { Long.valueOf(bo.av(l)), Looper.myLooper() });
            AppMethodBeat.o(76492);
            return 0;
          }
        }
        else
        {
          if (ac.eru.eol != 1) {
            break label665;
          }
          str = "Fix";
          continue;
        }
        if ((ac.eru.eol != 1) || ((localInteger.intValue() != 0) && (localInteger.intValue() != 5))) {
          continue;
        }
        a(this.eoH, true);
        continue;
        this.bmB.registerListener(this, this.oGW, 2);
      }
      catch (Exception paramSurfaceTexture)
      {
        ab.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", new Object[] { Looper.myLooper(), paramSurfaceTexture.getMessage() });
        i = com.tencent.mm.compatible.util.g.getLine();
        AppMethodBeat.o(76492);
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
  
  public final void a(a parama)
  {
    AppMethodBeat.i(76481);
    this.oHi = parama;
    String str1;
    String str2;
    com.tencent.mm.plugin.base.model.a locala;
    if (parama == a.oHs)
    {
      parama = a.bQG();
      str1 = this.faz.bQI();
      str2 = this.fay.bQI();
      locala = this.oHf;
      if (locala.jLi != 0) {
        break label94;
      }
    }
    label94:
    for (int i = 0;; i = locala.jLh / locala.jLi)
    {
      parama.oGB = ((int)(bo.apX(str1) * 10.0D));
      parama.oGC = ((int)(bo.apX(str2) * 10.0D));
      parama.oGH = i;
      AppMethodBeat.o(76481);
      return;
    }
  }
  
  public final void a(e.b paramb, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(76497);
    ab.i("MicroMsg.MMSightCamera", "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s", new Object[] { paramb, this.faE, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.faE != null) {
      try
      {
        this.faD = true;
        Point localPoint = new Point();
        if (this.fav != null) {
          localPoint.x = this.fav.x;
        }
        for (localPoint.y = this.fav.y;; localPoint.y = this.oHb.y)
        {
          byte[] arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.j.oJp.f(Integer.valueOf(this.faE.length));
          System.arraycopy(this.faE, 0, arrayOfByte, 0, this.faE.length);
          int i = this.fau.rotate;
          paramb.a(arrayOfByte, localPoint.x, localPoint.y, i, paramInt);
          return;
          if ((this.oHd == null) || (!this.oHe)) {
            break;
          }
          localPoint.x = this.oHb.x;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.MMSightCamera", "takePicture error: %s", new Object[] { localException.getMessage() });
          this.faD = false;
          paramb.a(null, 0, 0, -1, 0);
          return;
          localException.x = this.eZN.mnr;
          localException.y = this.eZN.mns;
        }
      }
      finally
      {
        this.faD = false;
        AppMethodBeat.o(76497);
      }
    }
    paramb.a(null, 0, 0, -1, 0);
    AppMethodBeat.o(76497);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(76479);
    if (paramf != null) {
      this.fas.add(paramf);
    }
    AppMethodBeat.o(76479);
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture, int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(76505);
    ab.i("MicroMsg.MMSightCamera", "switch camera with limit, current useBack: %s", new Object[] { Boolean.valueOf(this.eZK) });
    try
    {
      bQP();
      if (!this.eZK) {}
      for (boolean bool = true;; bool = false)
      {
        v(paramContext, bool);
        a(paramSurfaceTexture, paramInt, paramFloat, paramBoolean);
        AppMethodBeat.o(76505);
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[] { paramContext });
      AppMethodBeat.o(76505);
    }
  }
  
  public final boolean a(Context paramContext, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    AppMethodBeat.i(76504);
    ab.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", new Object[] { Boolean.valueOf(this.eZK) });
    try
    {
      bQP();
      if (!this.eZK) {}
      for (boolean bool = true;; bool = false)
      {
        v(paramContext, bool);
        a(paramSurfaceTexture, paramBoolean);
        AppMethodBeat.o(76504);
        return true;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.MMSightCamera", "switchCamera error: %s", new Object[] { paramContext });
      AppMethodBeat.o(76504);
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76499);
    if (com.tencent.mm.compatible.util.d.fw(14))
    {
      AppMethodBeat.o(76499);
      return;
    }
    this.oHo.removeMessages(4354);
    this.oHo.fac = paramFloat1;
    this.oHo.fad = paramFloat2;
    this.oHo.fae = paramInt1;
    this.oHo.faf = paramInt2;
    this.oHo.sendMessageDelayed(this.oHo.obtainMessage(4354, this.eoH), 400L);
    AppMethodBeat.o(76499);
  }
  
  public final void b(f paramf)
  {
    AppMethodBeat.i(76480);
    if (paramf != null) {
      this.fas.remove(paramf);
    }
    AppMethodBeat.o(76480);
  }
  
  public final void bQL()
  {
    AppMethodBeat.i(76489);
    ab.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
    if ((this.eoH != null) && (this.oGT)) {
      try
      {
        Camera.Parameters localParameters = this.eoH.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-video")))
        {
          ab.i("MicroMsg.MMSightCameraSetting", "support continuous video");
          localParameters.setFocusMode("continuous-video");
        }
        this.eoH.setParameters(localParameters);
        AppMethodBeat.o(76489);
        return;
      }
      catch (Exception localException)
      {
        ab.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(76489);
  }
  
  public final void bQM()
  {
    AppMethodBeat.i(76490);
    ab.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode");
    if ((this.eoH != null) && (this.oGT)) {
      try
      {
        Camera.Parameters localParameters = this.eoH.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          ab.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
          localParameters.setFocusMode("continuous-picture");
        }
        this.eoH.setParameters(localParameters);
        AppMethodBeat.o(76490);
        return;
      }
      catch (Exception localException)
      {
        ab.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(76490);
  }
  
  /* Error */
  public final String bQN()
  {
    // Byte code:
    //   0: ldc_w 1062
    //   3: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 106	com/tencent/mm/plugin/mmsight/model/e:eoH	Lcom/tencent/mm/compatible/e/u;
    //   10: ifnonnull +13 -> 23
    //   13: ldc_w 1062
    //   16: invokestatic 219	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc_w 1064
    //   22: areturn
    //   23: new 1066	java/lang/StringBuffer
    //   26: dup
    //   27: invokespecial 1067	java/lang/StringBuffer:<init>	()V
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 106	com/tencent/mm/plugin/mmsight/model/e:eoH	Lcom/tencent/mm/compatible/e/u;
    //   35: invokevirtual 302	com/tencent/mm/compatible/e/u:getParameters	()Landroid/hardware/Camera$Parameters;
    //   38: invokestatic 1070	com/tencent/mm/plugin/mmsight/d:e	(Landroid/hardware/Camera$Parameters;)Ljava/util/ArrayList;
    //   41: astore_2
    //   42: aload_0
    //   43: getfield 118	com/tencent/mm/plugin/mmsight/model/e:mContext	Landroid/content/Context;
    //   46: invokestatic 639	com/tencent/mm/plugin/mmsight/d:ex	(Landroid/content/Context;)Landroid/graphics/Point;
    //   49: astore_3
    //   50: aload_1
    //   51: ldc_w 1072
    //   54: iconst_3
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_3
    //   61: getfield 433	android/graphics/Point:x	I
    //   64: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: aload_3
    //   71: getfield 436	android/graphics/Point:y	I
    //   74: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: dup
    //   79: iconst_2
    //   80: aload_3
    //   81: getfield 433	android/graphics/Point:x	I
    //   84: i2d
    //   85: dconst_1
    //   86: dmul
    //   87: aload_3
    //   88: getfield 436	android/graphics/Point:y	I
    //   91: i2d
    //   92: ddiv
    //   93: invokestatic 1077	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   96: aastore
    //   97: invokestatic 1081	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   100: invokevirtual 1085	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   103: pop
    //   104: aload_2
    //   105: invokevirtual 1086	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   108: astore_2
    //   109: aload_2
    //   110: invokeinterface 610 1 0
    //   115: ifeq +200 -> 315
    //   118: aload_2
    //   119: invokeinterface 614 1 0
    //   124: checkcast 1088	android/hardware/Camera$Size
    //   127: astore_3
    //   128: aload_0
    //   129: invokevirtual 1091	com/tencent/mm/plugin/mmsight/model/e:getPreviewWidth	()I
    //   132: aload_3
    //   133: getfield 1092	android/hardware/Camera$Size:width	I
    //   136: if_icmpne +14 -> 150
    //   139: aload_0
    //   140: invokevirtual 1095	com/tencent/mm/plugin/mmsight/model/e:getPreviewHeight	()I
    //   143: aload_3
    //   144: getfield 1096	android/hardware/Camera$Size:height	I
    //   147: if_icmpeq +25 -> 172
    //   150: aload_0
    //   151: invokevirtual 1091	com/tencent/mm/plugin/mmsight/model/e:getPreviewWidth	()I
    //   154: aload_3
    //   155: getfield 1096	android/hardware/Camera$Size:height	I
    //   158: if_icmpne +100 -> 258
    //   161: aload_0
    //   162: invokevirtual 1095	com/tencent/mm/plugin/mmsight/model/e:getPreviewHeight	()I
    //   165: aload_3
    //   166: getfield 1092	android/hardware/Camera$Size:width	I
    //   169: if_icmpne +89 -> 258
    //   172: aload_1
    //   173: ldc_w 1098
    //   176: iconst_3
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_3
    //   183: getfield 1092	android/hardware/Camera$Size:width	I
    //   186: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: aastore
    //   190: dup
    //   191: iconst_1
    //   192: aload_3
    //   193: getfield 1096	android/hardware/Camera$Size:height	I
    //   196: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: aastore
    //   200: dup
    //   201: iconst_2
    //   202: aload_3
    //   203: getfield 1096	android/hardware/Camera$Size:height	I
    //   206: i2d
    //   207: dconst_1
    //   208: dmul
    //   209: aload_3
    //   210: getfield 1092	android/hardware/Camera$Size:width	I
    //   213: i2d
    //   214: ddiv
    //   215: invokestatic 1077	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   218: aastore
    //   219: invokestatic 1081	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   222: invokevirtual 1085	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   225: pop
    //   226: goto -117 -> 109
    //   229: astore_1
    //   230: ldc_w 304
    //   233: ldc_w 1100
    //   236: iconst_1
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: aload_1
    //   243: invokevirtual 365	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   246: aastore
    //   247: invokestatic 369	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: ldc_w 1062
    //   253: invokestatic 219	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aconst_null
    //   257: areturn
    //   258: aload_1
    //   259: ldc_w 1102
    //   262: iconst_3
    //   263: anewarray 4	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: aload_3
    //   269: getfield 1092	android/hardware/Camera$Size:width	I
    //   272: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   275: aastore
    //   276: dup
    //   277: iconst_1
    //   278: aload_3
    //   279: getfield 1096	android/hardware/Camera$Size:height	I
    //   282: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: dup
    //   287: iconst_2
    //   288: aload_3
    //   289: getfield 1096	android/hardware/Camera$Size:height	I
    //   292: i2d
    //   293: dconst_1
    //   294: dmul
    //   295: aload_3
    //   296: getfield 1092	android/hardware/Camera$Size:width	I
    //   299: i2d
    //   300: ddiv
    //   301: invokestatic 1077	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   304: aastore
    //   305: invokestatic 1081	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   308: invokevirtual 1085	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   311: pop
    //   312: goto -203 -> 109
    //   315: aload_0
    //   316: getfield 124	com/tencent/mm/plugin/mmsight/model/e:fav	Landroid/graphics/Point;
    //   319: ifnull +144 -> 463
    //   322: aload_1
    //   323: new 1104	java/lang/StringBuilder
    //   326: dup
    //   327: ldc_w 1106
    //   330: invokespecial 1107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   333: aload_0
    //   334: getfield 124	com/tencent/mm/plugin/mmsight/model/e:fav	Landroid/graphics/Point;
    //   337: getfield 433	android/graphics/Point:x	I
    //   340: invokevirtual 1110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: ldc_w 1112
    //   346: invokevirtual 1115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_0
    //   350: getfield 124	com/tencent/mm/plugin/mmsight/model/e:fav	Landroid/graphics/Point;
    //   353: getfield 436	android/graphics/Point:y	I
    //   356: invokevirtual 1110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: ldc_w 1117
    //   362: invokevirtual 1115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_0
    //   366: getfield 214	com/tencent/mm/plugin/mmsight/model/e:eZN	Lcom/tencent/mm/plugin/mmsight/model/p;
    //   369: getfield 314	com/tencent/mm/plugin/mmsight/model/p:mnr	I
    //   372: invokevirtual 1110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: ldc_w 1112
    //   378: invokevirtual 1115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_0
    //   382: getfield 214	com/tencent/mm/plugin/mmsight/model/e:eZN	Lcom/tencent/mm/plugin/mmsight/model/p;
    //   385: getfield 317	com/tencent/mm/plugin/mmsight/model/p:mns	I
    //   388: invokevirtual 1110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   391: invokevirtual 1120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokevirtual 1085	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   397: pop
    //   398: aload_1
    //   399: new 1104	java/lang/StringBuilder
    //   402: dup
    //   403: ldc_w 1122
    //   406: invokespecial 1107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   409: aload_0
    //   410: invokevirtual 1125	com/tencent/mm/plugin/mmsight/model/e:getOrientation	()I
    //   413: invokevirtual 1110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   416: invokevirtual 1120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokevirtual 1085	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   422: pop
    //   423: aload_1
    //   424: new 1104	java/lang/StringBuilder
    //   427: dup
    //   428: ldc_w 1127
    //   431: invokespecial 1107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   434: getstatic 896	com/tencent/mm/compatible/e/ac:erB	Lcom/tencent/mm/compatible/e/w;
    //   437: getfield 1130	com/tencent/mm/compatible/e/w:eqR	I
    //   440: invokevirtual 1110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   443: invokevirtual 1120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokevirtual 1085	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   449: pop
    //   450: aload_1
    //   451: invokevirtual 1131	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   454: astore_1
    //   455: ldc_w 1062
    //   458: invokestatic 219	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   461: aload_1
    //   462: areturn
    //   463: aload_1
    //   464: new 1104	java/lang/StringBuilder
    //   467: dup
    //   468: ldc_w 1133
    //   471: invokespecial 1107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   474: aload_0
    //   475: invokevirtual 1091	com/tencent/mm/plugin/mmsight/model/e:getPreviewWidth	()I
    //   478: invokevirtual 1110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   481: ldc_w 1112
    //   484: invokevirtual 1115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload_0
    //   488: invokevirtual 1095	com/tencent/mm/plugin/mmsight/model/e:getPreviewHeight	()I
    //   491: invokevirtual 1110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: invokevirtual 1120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokevirtual 1085	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   500: pop
    //   501: goto -103 -> 398
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	this	e
    //   30	143	1	localStringBuffer	java.lang.StringBuffer
    //   229	222	1	localException	Exception
    //   454	10	1	str	String
    //   41	78	2	localObject1	Object
    //   49	247	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	109	229	java/lang/Exception
    //   109	150	229	java/lang/Exception
    //   150	172	229	java/lang/Exception
    //   172	226	229	java/lang/Exception
    //   258	312	229	java/lang/Exception
    //   315	398	229	java/lang/Exception
    //   398	455	229	java/lang/Exception
    //   463	501	229	java/lang/Exception
  }
  
  public final void bQO()
  {
    AppMethodBeat.i(76500);
    if ((this.eoH != null) && (this.oGT)) {
      try
      {
        Camera.Parameters localParameters = this.eoH.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("auto")))
        {
          ab.i("MicroMsg.MMSightCameraSetting", "support auto focus");
          localParameters.setFocusMode("auto");
          this.eoH.setParameters(localParameters);
        }
        this.eoH.cancelAutoFocus();
        AppMethodBeat.o(76500);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.eoH.autoFocus(new Camera.AutoFocusCallback()
            {
              public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
              {
                AppMethodBeat.i(76470);
                if ((paramAnonymousCamera != null) && (e.this.bQT())) {
                  try
                  {
                    Camera.Parameters localParameters = paramAnonymousCamera.getParameters();
                    List localList = localParameters.getSupportedFocusModes();
                    if ((localList != null) && (localList.contains("continuous-picture")))
                    {
                      ab.i("MicroMsg.MMSightCameraSetting", "support continues picture focus");
                      localParameters.setFocusMode("continuous-picture");
                      paramAnonymousCamera.setParameters(localParameters);
                    }
                    AppMethodBeat.o(76470);
                    return;
                  }
                  catch (Exception paramAnonymousCamera)
                  {
                    ab.printErrStackTrace("MicroMsg.MMSightCamera", paramAnonymousCamera, "simple auto focus resetToPictureFocus error", new Object[0]);
                  }
                }
                AppMethodBeat.o(76470);
              }
            });
            AppMethodBeat.o(76500);
            return;
          }
          catch (Exception localException2)
          {
            ab.printErrStackTrace("MicroMsg.MMSightCamera", localException2, "autoFocus error", new Object[0]);
          }
          localException1 = localException1;
          ab.printErrStackTrace("MicroMsg.MMSightCamera", localException1, "simple auto focus error", new Object[0]);
        }
      }
    }
  }
  
  public final int bQP()
  {
    AppMethodBeat.i(76506);
    bQK();
    AppMethodBeat.o(76506);
    return 0;
  }
  
  public final void bQQ()
  {
    AppMethodBeat.i(76507);
    ab.i("MicroMsg.MMSightCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[] { this.eoH, Boolean.valueOf(this.oGT) });
    if ((this.eoH != null) && (this.oGT)) {
      try
      {
        this.oHg = true;
        Camera.Parameters localParameters = this.eoH.getParameters();
        if ((!bo.es(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("torch")))
        {
          localParameters.setFlashMode("torch");
          this.eoH.setParameters(localParameters);
          ab.i("MicroMsg.MMSightCamera", "open flash");
          AppMethodBeat.o(76507);
          return;
        }
        ab.i("MicroMsg.MMSightCamera", "camera not support flash!!");
        AppMethodBeat.o(76507);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MMSightCamera", localException, "openFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(76507);
  }
  
  public final void bQR()
  {
    AppMethodBeat.i(76508);
    ab.i("MicroMsg.MMSightCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[] { this.eoH, Boolean.valueOf(this.oGT) });
    if ((this.eoH != null) && (this.oGT)) {
      try
      {
        this.oHg = false;
        Camera.Parameters localParameters = this.eoH.getParameters();
        if ((!bo.es(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("off")))
        {
          localParameters.setFlashMode("off");
          this.eoH.setParameters(localParameters);
          ab.i("MicroMsg.MMSightCamera", "close flash");
          AppMethodBeat.o(76508);
          return;
        }
        ab.i("MicroMsg.MMSightCamera", "camera not support close flash!!");
        AppMethodBeat.o(76508);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MMSightCamera", localException, "closeFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(76508);
  }
  
  public final void bQS()
  {
    AppMethodBeat.i(76509);
    ab.i("MicroMsg.MMSightCamera", "autoFlash, camera: %s, isPreviewing: %s", new Object[] { this.eoH, Boolean.valueOf(this.oGT) });
    if ((this.eoH != null) && (this.oGT)) {
      try
      {
        this.oHg = true;
        Camera.Parameters localParameters = this.eoH.getParameters();
        if ((!bo.es(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("auto")))
        {
          localParameters.setFlashMode("auto");
          this.eoH.setParameters(localParameters);
          ab.i("MicroMsg.MMSightCamera", "auto flash");
          AppMethodBeat.o(76509);
          return;
        }
        ab.i("MicroMsg.MMSightCamera", "camera not support auto flash!!");
        AppMethodBeat.o(76509);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MMSightCamera", localException, "autoFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(76509);
  }
  
  public final boolean bQT()
  {
    return this.oGT;
  }
  
  public final boolean bQU()
  {
    return this.eZK;
  }
  
  public final void d(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(76501);
    if ((this.eoH != null) && (this.oGT)) {}
    for (;;)
    {
      int m;
      int k;
      int j;
      try
      {
        ab.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (this.asm)
        {
          ab.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
          return;
        }
        Camera.Parameters localParameters = this.eoH.getParameters();
        if (localParameters.isZoomSupported())
        {
          this.asm = true;
          m = localParameters.getZoom();
          k = localParameters.getMaxZoom();
          if (!paramBoolean2)
          {
            if (this.fax <= 0)
            {
              this.fax = Math.round(k / 15.0F);
              if (this.fax > 5) {
                this.fax = 5;
              }
            }
            i = this.fax;
            ab.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(this.fax), Integer.valueOf(this.faw), Integer.valueOf(paramInt) });
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
            if (this.faw <= 0)
            {
              ab.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", new Object[] { Integer.valueOf(this.faw) });
              return;
            }
            i = this.faw;
            continue;
            ab.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", new Object[] { Integer.valueOf(paramInt) });
            localParameters.setZoom(paramInt);
            this.eoH.setParameters(localParameters);
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
        AppMethodBeat.o(76501);
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.MMSightCamera", "triggerSmallZoom error: %s", new Object[] { localException.getMessage() });
        return;
      }
      finally
      {
        this.asm = false;
        AppMethodBeat.o(76501);
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
  
  public final Point getEncodeVideoBestSize()
  {
    return this.oHb;
  }
  
  public final int getOrientation()
  {
    if ((this.fau != null) && (this.oGT)) {
      return this.fau.rotate;
    }
    return -1;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(76511);
    if (this.eoH == null)
    {
      AppMethodBeat.o(76511);
      return 0;
    }
    if (this.fau != null) {
      try
      {
        int i;
        if ((this.oHe) && (this.oHd != null)) {
          if ((this.fau.rotate == 0) || (this.fau.rotate == 180)) {
            i = this.oHb.y;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(76511);
          return i;
          i = this.oHb.x;
          continue;
          if (this.fav == null)
          {
            if ((this.fau.rotate == 0) || (this.fau.rotate == 180)) {
              i = this.eZN.mns;
            } else {
              i = this.eZN.mnr;
            }
          }
          else if ((this.fau.rotate == 0) || (this.fau.rotate == 180)) {
            i = this.fav.y;
          } else {
            i = this.fav.x;
          }
        }
        AppMethodBeat.o(76511);
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.MMSightCamera", "getPreviewHeight: %s", new Object[] { localException.getMessage() });
      }
    }
    return 0;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(76510);
    if (this.eoH == null)
    {
      AppMethodBeat.o(76510);
      return 0;
    }
    if (this.fau != null) {
      try
      {
        int i;
        if ((this.oHe) && (this.oHd != null)) {
          if ((this.fau.rotate == 0) || (this.fau.rotate == 180)) {
            i = this.oHb.x;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(76510);
          return i;
          i = this.oHb.y;
          continue;
          if (this.fav == null)
          {
            if ((this.fau.rotate == 0) || (this.fau.rotate == 180)) {
              i = this.eZN.mnr;
            } else {
              i = this.eZN.mns;
            }
          }
          else if ((this.fau.rotate == 0) || (this.fau.rotate == 180)) {
            i = this.fav.x;
          } else {
            i = this.fav.y;
          }
        }
        AppMethodBeat.o(76510);
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.MMSightCamera", "getPreviewWidth: %s", new Object[] { localException.getMessage() });
      }
    }
    return 0;
  }
  
  public final void kh(int paramInt)
  {
    AppMethodBeat.i(76502);
    if (this.faw > 0)
    {
      AppMethodBeat.o(76502);
      return;
    }
    Point localPoint = af.hQ(ah.getContext());
    int i = localPoint.y;
    ab.i("MicroMsg.MMSightCamera", "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[] { Integer.valueOf(paramInt), localPoint });
    if (i / 2 >= paramInt)
    {
      AppMethodBeat.o(76502);
      return;
    }
    try
    {
      if (this.eoH != null)
      {
        i = this.eoH.getParameters().getMaxZoom();
        this.faw = ((int)(i / (paramInt / 3.0D / 10.0D)) + 1);
        ab.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", new Object[] { Integer.valueOf(this.faw), Integer.valueOf(i) });
      }
      AppMethodBeat.o(76502);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMSightCamera", "calcScrollZoomStep error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(76502);
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(76498);
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if ((Math.abs(this.oGX - f1) > 5.0F) || (Math.abs(this.oGY - f2) > 5.0F) || (Math.abs(this.oGZ - f3) > 5.0F))
    {
      ab.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", new Object[] { Float.valueOf(5.0F), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
      this.oHo.e(this.eoH);
      this.oGX = f1;
      this.oGY = f2;
      this.oGZ = f3;
    }
    AppMethodBeat.o(76498);
  }
  
  public final boolean v(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(76503);
    if ((!j.oHG.oHT) || ((ac.eru.eop == 0) && (this.bmB == null) && (this.oGW == null)))
    {
      this.bmB = ((SensorManager)ah.getContext().getSystemService("sensor"));
      this.oGW = this.bmB.getDefaultSensor(1);
    }
    if (this.eoH == null)
    {
      bQK();
      this.eZK = paramBoolean;
      if (paramBoolean) {}
      try
      {
        for (this.oGU = com.tencent.mm.compatible.e.d.Lj();; this.oGU = com.tencent.mm.compatible.e.d.Lk())
        {
          ab.i("MicroMsg.MMSightCamera", "use camera id %d, SrvDeviceInfo id %d", new Object[] { Integer.valueOf(this.oGU), Integer.valueOf(ac.eru.eos) });
          this.oHm = false;
          this.mContext = paramContext;
          this.fau = new n().S(paramContext, this.oGU);
          ab.i("MicroMsg.MMSightCamera", "open camera end, %s", new Object[] { Looper.myLooper() });
          if (this.fau != null) {
            break;
          }
          ab.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", new Object[] { Looper.myLooper() });
          WM();
          AppMethodBeat.o(76503);
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.MMSightCamera", localException, "try to get cameraid error %s, useBackCamera: %s", new Object[] { localException.getMessage(), Boolean.valueOf(this.eZK) });
          this.oGU = 0;
        }
        this.eoH = this.fau.eoH;
        this.oHo.fab = false;
        this.eZN.rotate = this.fau.rotate;
        if (this.eoH == null)
        {
          ab.e("MicroMsg.MMSightCamera", "start camera FAILED!");
          WM();
          AppMethodBeat.o(76503);
          return false;
        }
      }
    }
    AppMethodBeat.o(76503);
    return true;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(76473);
      oHq = new a("Preview", 0);
      oHr = new a("Recording", 1);
      oHs = new a("Stoping", 2);
      oHt = new a[] { oHq, oHr, oHs };
      AppMethodBeat.o(76473);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.e
 * JD-Core Version:    0.7.0.1
 */