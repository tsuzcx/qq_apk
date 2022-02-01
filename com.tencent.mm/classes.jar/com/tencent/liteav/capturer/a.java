package com.tencent.liteav.capturer;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class a
  implements Camera.AutoFocusCallback, Camera.ErrorCallback, Camera.PreviewCallback
{
  private Matrix a;
  private int b;
  private Camera c;
  private boolean d;
  private b e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private SurfaceTexture l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private int q;
  private int r;
  private boolean s;
  private boolean t;
  
  public a()
  {
    AppMethodBeat.i(15504);
    this.a = new Matrix();
    this.b = 0;
    this.d = true;
    this.f = 15;
    this.g = 1;
    this.p = false;
    this.s = false;
    this.t = false;
    AppMethodBeat.o(15504);
  }
  
  private Rect a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i4 = 1000;
    AppMethodBeat.i(15510);
    float f1 = 200.0F * paramFloat3;
    paramFloat3 = paramFloat1;
    if (this.d == true) {
      paramFloat3 = 1.0F - paramFloat1;
    }
    int i2 = this.j / 90;
    int i1 = 0;
    while (i1 < i2)
    {
      paramFloat1 = --(paramFloat2 - 0.5F);
      paramFloat2 = -(paramFloat3 - 0.5F);
      paramFloat3 = paramFloat1 + 0.5F;
      paramFloat2 += 0.5F;
      i1 += 1;
    }
    i1 = (int)(paramFloat3 * 2000.0F - 1000.0F);
    i2 = (int)(paramFloat2 * 2000.0F - 1000.0F);
    if (i1 < -1000) {
      i1 = -1000;
    }
    for (;;)
    {
      if (i2 < -1000) {
        i2 = -1000;
      }
      for (;;)
      {
        int i6 = i1 + (int)f1;
        int i5 = (int)f1 + i2;
        int i3 = i6;
        if (i6 > 1000) {
          i3 = 1000;
        }
        if (i5 > 1000) {}
        for (;;)
        {
          Rect localRect = new Rect(i1, i2, i3, i4);
          AppMethodBeat.o(15510);
          return localRect;
          i4 = i5;
        }
      }
    }
  }
  
  private static d a(Camera.Parameters paramParameters, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187378);
    TXCLog.d("TXCCameraCapturer", "camera preview wanted: %d x %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramParameters = paramParameters.getSupportedPreviewSizes();
    float f1 = 1.0F * paramInt1 / paramInt2;
    Object localObject1 = new ArrayList();
    paramParameters = paramParameters.iterator();
    int i2 = 2147483647;
    while (paramParameters.hasNext())
    {
      localObject2 = (Camera.Size)paramParameters.next();
      TXCLog.d("TXCCameraCapturer", "camera support preview size: %dx%d", new Object[] { Integer.valueOf(((Camera.Size)localObject2).width), Integer.valueOf(((Camera.Size)localObject2).height) });
      if ((((Camera.Size)localObject2).width < 640) || (((Camera.Size)localObject2).height < 480)) {}
      for (int i1 = 2147483647;; i1 = Math.round(10.0F * Math.abs(1.0F * ((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height - f1)))
      {
        if (i1 >= i2) {
          break label204;
        }
        ((List)localObject1).clear();
        ((List)localObject1).add(localObject2);
        i2 = i1;
        break;
      }
      label204:
      if (i1 == i2) {
        ((List)localObject1).add(localObject2);
      }
    }
    Collections.sort((List)localObject1, new Comparator()
    {
      public final int a(Camera.Size paramAnonymousSize1, Camera.Size paramAnonymousSize2)
      {
        return paramAnonymousSize2.width * paramAnonymousSize2.height - paramAnonymousSize1.width * paramAnonymousSize1.height;
      }
    });
    paramParameters = (Camera.Size)((List)localObject1).get(0);
    float f2 = paramInt1 * paramInt2;
    f1 = 2.147484E+009F;
    Object localObject2 = ((List)localObject1).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Camera.Size)((Iterator)localObject2).next();
      TXCLog.i("TXCCameraCapturer", "size in same buck: %dx%d", new Object[] { Integer.valueOf(((Camera.Size)localObject1).width), Integer.valueOf(((Camera.Size)localObject1).height) });
      paramInt1 = ((Camera.Size)localObject1).width * ((Camera.Size)localObject1).height;
      if ((paramInt1 / f2 < 0.9D) || (Math.abs(paramInt1 - f2) >= f1)) {
        break label428;
      }
      f1 = Math.abs(paramInt1 - f2);
      paramParameters = (Camera.Parameters)localObject1;
    }
    label428:
    for (;;)
    {
      break;
      TXCLog.i("TXCCameraCapturer", "best match preview size: %d x %d", new Object[] { Integer.valueOf(paramParameters.width), Integer.valueOf(paramParameters.height) });
      paramParameters = new d(paramParameters.width, paramParameters.height);
      AppMethodBeat.o(187378);
      return paramParameters;
    }
  }
  
  private static d b(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187377);
    if (paramBoolean)
    {
      locald1 = new d(paramInt1, paramInt2);
      AppMethodBeat.o(187377);
      return locald1;
    }
    d locald1 = new d(1080, 1920);
    float f1 = Math.min(paramInt1, paramInt2);
    float f2 = Math.max(paramInt1, paramInt2);
    int i2 = 0;
    for (;;)
    {
      int i3 = paramInt1;
      int i1 = paramInt2;
      if (i2 <= 0)
      {
        d locald2 = new d[] { locald1 }[0];
        if ((f1 <= locald2.a) && (f2 <= locald2.b))
        {
          f1 = Math.min(locald2.a / f1, locald2.b / f2);
          i3 = (int)(paramInt1 * f1);
          i1 = (int)(f1 * paramInt2);
        }
      }
      else
      {
        locald1 = new d(i3, i1);
        AppMethodBeat.o(187377);
        return locald1;
      }
      i2 += 1;
    }
  }
  
  private int d(int paramInt)
  {
    int i1 = 0;
    AppMethodBeat.i(187379);
    List localList = this.c.getParameters().getSupportedPreviewFrameRates();
    if (localList == null)
    {
      TXCLog.e("TXCCameraCapturer", "getSupportedFPS error");
      AppMethodBeat.o(187379);
      return 1;
    }
    int i3;
    for (int i2 = ((Integer)localList.get(0)).intValue(); i1 < localList.size(); i2 = i3)
    {
      int i4 = ((Integer)localList.get(i1)).intValue();
      i3 = i2;
      if (Math.abs(i4 - paramInt) - Math.abs(i2 - paramInt) < 0) {
        i3 = i4;
      }
      i1 += 1;
    }
    TXCLog.i("TXCCameraCapturer", "choose fps=".concat(String.valueOf(i2)));
    AppMethodBeat.o(187379);
    return i2;
  }
  
  private int[] e(int paramInt)
  {
    AppMethodBeat.i(187380);
    paramInt *= 1000;
    String str = "camera supported preview fps range: wantFPS = " + paramInt + "\n";
    Object localObject2 = this.c.getParameters().getSupportedPreviewFpsRange();
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = (int[])((List)localObject2).get(0);
      Collections.sort((List)localObject2, new Comparator()
      {
        public int a(int[] paramAnonymousArrayOfInt1, int[] paramAnonymousArrayOfInt2)
        {
          return paramAnonymousArrayOfInt1[1] - paramAnonymousArrayOfInt2[1];
        }
      });
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        int[] arrayOfInt = (int[])localIterator.next();
        str = str + "camera supported preview fps range: " + arrayOfInt[0] + " - " + arrayOfInt[1] + "\n";
      }
      localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (int[])localIterator.next();
        if ((localObject2[0] <= paramInt) && (paramInt <= localObject2[1])) {
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      TXCLog.i("TXCCameraCapturer", str + "choose preview fps range: " + localObject1[0] + " - " + localObject1[1]);
      AppMethodBeat.o(187380);
      return localObject1;
      AppMethodBeat.o(187380);
      return null;
    }
  }
  
  private int f(int paramInt)
  {
    AppMethodBeat.i(15523);
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    StringBuilder localStringBuilder = new StringBuilder("vsize camera orientation ").append(localCameraInfo.orientation).append(", front ");
    boolean bool;
    if (localCameraInfo.facing == 1)
    {
      bool = true;
      TXCLog.i("TXCCameraCapturer", bool);
      int i1 = localCameraInfo.orientation;
      if (i1 != 0)
      {
        paramInt = i1;
        if (i1 != 180) {}
      }
      else
      {
        paramInt = i1 + 90;
      }
      if (localCameraInfo.facing != 1) {
        break label128;
      }
    }
    label128:
    for (paramInt = (360 - paramInt) % 360;; paramInt = (paramInt + 360) % 360)
    {
      AppMethodBeat.o(15523);
      return paramInt;
      bool = false;
      break;
    }
  }
  
  public void a(float paramFloat)
  {
    float f2 = 1.0F;
    float f1 = -1.0F;
    AppMethodBeat.i(15513);
    if (this.c != null)
    {
      if (paramFloat <= 1.0F) {
        break label206;
      }
      paramFloat = f2;
    }
    label206:
    for (;;)
    {
      if (paramFloat < -1.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        Camera.Parameters localParameters = this.c.getParameters();
        int i1 = localParameters.getMinExposureCompensation();
        int i2 = localParameters.getMaxExposureCompensation();
        if ((i1 != 0) && (i2 != 0))
        {
          int i3 = com.tencent.liteav.basic.e.b.a().d();
          paramFloat *= i2;
          if ((i3 != 0) && (i3 <= i2) && (i3 >= i1))
          {
            TXCLog.i("TXCCameraCapturer", "camera setExposureCompensation: ".concat(String.valueOf(i3)));
            localParameters.setExposureCompensation(i3);
          }
        }
        for (;;)
        {
          try
          {
            this.c.setParameters(localParameters);
            AppMethodBeat.o(15513);
            return;
          }
          catch (Exception localException) {}
          if ((paramFloat <= i2) && (paramFloat >= i1))
          {
            TXCLog.i("TXCCameraCapturer", "camera setExposureCompensation: ".concat(String.valueOf(paramFloat)));
            localParameters.setExposureCompensation((int)paramFloat);
            continue;
            TXCLog.e("TXCCameraCapturer", "camera not support setExposureCompensation!");
          }
        }
        AppMethodBeat.o(15513);
        return;
      }
    }
  }
  
  /* Error */
  public void a(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: sipush 15509
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 68	com/tencent/liteav/capturer/a:s	Z
    //   10: ifne +10 -> 20
    //   13: sipush 15509
    //   16: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_0
    //   21: getfield 200	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   24: invokevirtual 328	android/hardware/Camera:cancelAutoFocus	()V
    //   27: aload_0
    //   28: getfield 200	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   31: invokevirtual 206	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   34: astore_3
    //   35: aload_0
    //   36: getfield 330	com/tencent/liteav/capturer/a:m	Z
    //   39: ifeq +43 -> 82
    //   42: new 110	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 111	java/util/ArrayList:<init>	()V
    //   49: astore 4
    //   51: aload 4
    //   53: new 332	android/hardware/Camera$Area
    //   56: dup
    //   57: aload_0
    //   58: fload_1
    //   59: fload_2
    //   60: fconst_2
    //   61: invokespecial 334	com/tencent/liteav/capturer/a:a	(FFF)Landroid/graphics/Rect;
    //   64: sipush 1000
    //   67: invokespecial 337	android/hardware/Camera$Area:<init>	(Landroid/graphics/Rect;I)V
    //   70: invokeinterface 145 2 0
    //   75: pop
    //   76: aload_3
    //   77: aload 4
    //   79: invokevirtual 341	android/hardware/Camera$Parameters:setFocusAreas	(Ljava/util/List;)V
    //   82: aload_0
    //   83: getfield 343	com/tencent/liteav/capturer/a:n	Z
    //   86: ifeq +45 -> 131
    //   89: new 110	java/util/ArrayList
    //   92: dup
    //   93: invokespecial 111	java/util/ArrayList:<init>	()V
    //   96: astore 4
    //   98: aload 4
    //   100: new 332	android/hardware/Camera$Area
    //   103: dup
    //   104: aload_0
    //   105: fload_1
    //   106: fload_2
    //   107: ldc_w 344
    //   110: invokespecial 334	com/tencent/liteav/capturer/a:a	(FFF)Landroid/graphics/Rect;
    //   113: sipush 1000
    //   116: invokespecial 337	android/hardware/Camera$Area:<init>	(Landroid/graphics/Rect;I)V
    //   119: invokeinterface 145 2 0
    //   124: pop
    //   125: aload_3
    //   126: aload 4
    //   128: invokevirtual 347	android/hardware/Camera$Parameters:setMeteringAreas	(Ljava/util/List;)V
    //   131: aload_0
    //   132: getfield 200	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   135: aload_3
    //   136: invokevirtual 319	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   139: aload_0
    //   140: getfield 200	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   143: aload_0
    //   144: invokevirtual 351	android/hardware/Camera:autoFocus	(Landroid/hardware/Camera$AutoFocusCallback;)V
    //   147: sipush 15509
    //   150: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: return
    //   154: astore_3
    //   155: sipush 15509
    //   158: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: return
    //   162: astore_3
    //   163: sipush 15509
    //   166: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	a
    //   0	170	1	paramFloat1	float
    //   0	170	2	paramFloat2	float
    //   34	102	3	localParameters	Camera.Parameters
    //   154	1	3	localException1	Exception
    //   162	1	3	localException2	Exception
    //   49	78	4	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   20	35	154	java/lang/Exception
    //   131	147	162	java/lang/Exception
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.l = paramSurfaceTexture;
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(187371);
    if (parama != a.a)
    {
      this.q = a.a(parama);
      this.r = a.b(parama);
    }
    TXCLog.i("TXCCameraCapturer", "set resolution ".concat(String.valueOf(parama)));
    AppMethodBeat.o(187371);
  }
  
  public void a(b paramb)
  {
    this.e = paramb;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187374);
    this.p = paramBoolean;
    this.q = paramInt1;
    this.r = paramInt2;
    TXCLog.i("TXCCameraCapturer", "setCaptureBuffer %b, width: %d, height: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(187374);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(15505);
    if (this.c != null)
    {
      Camera.Parameters localParameters = this.c.getParameters();
      if ((localParameters.getMaxZoom() > 0) && (localParameters.isZoomSupported()))
      {
        AppMethodBeat.o(15505);
        return true;
      }
    }
    AppMethodBeat.o(15505);
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    AppMethodBeat.i(15508);
    this.o = paramBoolean;
    if (this.c != null)
    {
      boolean bool = true;
      Camera.Parameters localParameters = this.c.getParameters();
      List localList = localParameters.getSupportedFlashModes();
      if (paramBoolean) {
        if ((localList != null) && (localList.contains("torch")))
        {
          TXCLog.i("TXCCameraCapturer", "set FLASH_MODE_TORCH");
          localParameters.setFlashMode("torch");
          paramBoolean = bool;
        }
      }
      try
      {
        for (;;)
        {
          this.c.setParameters(localParameters);
          AppMethodBeat.o(15508);
          return paramBoolean;
          paramBoolean = false;
          continue;
          if ((localList != null) && (localList.contains("off")))
          {
            TXCLog.i("TXCCameraCapturer", "set FLASH_MODE_OFF");
            localParameters.setFlashMode("off");
            paramBoolean = bool;
          }
          else
          {
            paramBoolean = false;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramBoolean = false;
        }
      }
    }
    AppMethodBeat.o(15508);
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(187372);
    this.t = paramBoolean;
    TXCLog.i("TXCCameraCapturer", "set performance mode to ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(187372);
  }
  
  public boolean b()
  {
    AppMethodBeat.i(15506);
    if (this.c != null)
    {
      if (this.c.getParameters().getSupportedFlashModes() != null)
      {
        AppMethodBeat.o(15506);
        return true;
      }
      AppMethodBeat.o(15506);
      return false;
    }
    AppMethodBeat.o(15506);
    return false;
  }
  
  public boolean b(int paramInt)
  {
    bool2 = false;
    AppMethodBeat.i(187373);
    bool1 = bool2;
    Camera.Parameters localParameters;
    if (this.c != null)
    {
      localParameters = this.c.getParameters();
      if ((localParameters.getMaxZoom() > 0) && (localParameters.isZoomSupported()) && ((paramInt < 0) || (paramInt > localParameters.getMaxZoom()))) {
        break label80;
      }
    }
    for (;;)
    {
      try
      {
        localParameters.setZoom(paramInt);
        this.c.setParameters(localParameters);
        bool1 = true;
      }
      catch (Exception localException)
      {
        label80:
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(187373);
      return bool1;
      TXCLog.e("TXCCameraCapturer", "invalid zoom value : " + paramInt + ", while max zoom is " + localParameters.getMaxZoom());
      bool1 = bool2;
      continue;
      TXCLog.e("TXCCameraCapturer", "camera not support zoom!");
      bool1 = bool2;
    }
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(187375);
    TXCLog.w("TXCCameraCapturer", "vsize setHomeOrientation ".concat(String.valueOf(paramInt)));
    this.g = paramInt;
    this.j = ((this.k - 90 + this.g * 90 + 360) % 360);
    AppMethodBeat.o(187375);
  }
  
  public void c(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public boolean c()
  {
    return this.m;
  }
  
  public int d(boolean paramBoolean)
  {
    AppMethodBeat.i(187376);
    for (;;)
    {
      int i4;
      try
      {
        TXCLog.i("TXCCameraCapturer", "trtc_capture: start capture");
        localObject1 = this.l;
        if (localObject1 == null)
        {
          AppMethodBeat.o(187376);
          return -2;
        }
        if (this.c != null) {
          f();
        }
        localObject1 = new Camera.CameraInfo();
        i2 = 0;
        i1 = -1;
        i3 = -1;
        if (i2 < Camera.getNumberOfCameras())
        {
          Camera.getCameraInfo(i2, (Camera.CameraInfo)localObject1);
          TXCLog.i("TXCCameraCapturer", "camera index " + i2 + ", facing = " + ((Camera.CameraInfo)localObject1).facing);
          i4 = i3;
          if (((Camera.CameraInfo)localObject1).facing == 1)
          {
            i4 = i3;
            if (i3 == -1) {
              i4 = i2;
            }
          }
          i3 = i1;
          if (((Camera.CameraInfo)localObject1).facing != 0) {
            break label742;
          }
          i3 = i1;
          if (i1 != -1) {
            break label742;
          }
          i3 = i2;
          break label742;
        }
        TXCLog.i("TXCCameraCapturer", "camera front, id = ".concat(String.valueOf(i3)));
        TXCLog.i("TXCCameraCapturer", "camera back , id = ".concat(String.valueOf(i1)));
        if ((i3 != -1) || (i1 == -1)) {
          break label736;
        }
        i2 = i1;
      }
      catch (IOException localIOException)
      {
        Object localObject1;
        Object localObject2;
        TXCLog.e("TXCCameraCapturer", "open camera failed." + localIOException.getMessage());
        AppMethodBeat.o(187376);
        return -1;
        if ((localObject2 == null) || (!((List)localObject2).contains("continuous-video"))) {
          continue;
        }
        TXCLog.i("TXCCameraCapturer", "support FOCUS_MODE_CONTINUOUS_VIDEO");
        localIOException.setFocusMode("continuous-video");
        continue;
      }
      catch (Exception localException)
      {
        TXCLog.e("TXCCameraCapturer", "open camera failed." + localException.getMessage());
        AppMethodBeat.o(187376);
        return -1;
      }
      this.d = paramBoolean;
      if (this.d)
      {
        this.c = Camera.open(i2);
        localObject1 = this.c.getParameters();
        localObject2 = ((Camera.Parameters)localObject1).getSupportedFocusModes();
        if ((this.s) && (localObject2 != null) && (((List)localObject2).contains("auto")))
        {
          TXCLog.i("TXCCameraCapturer", "support FOCUS_MODE_AUTO");
          ((Camera.Parameters)localObject1).setFocusMode("auto");
          if (Build.VERSION.SDK_INT >= 14)
          {
            if (((Camera.Parameters)localObject1).getMaxNumFocusAreas() > 0) {
              this.m = true;
            }
            if (((Camera.Parameters)localObject1).getMaxNumMeteringAreas() > 0) {
              this.n = true;
            }
          }
          if (this.p)
          {
            ((Camera.Parameters)localObject1).setPreviewFormat(17);
            this.c.setPreviewCallback(this);
          }
          localObject2 = b(this.t, this.q, this.r);
          localObject2 = a((Camera.Parameters)localObject1, Math.max(((d)localObject2).a, ((d)localObject2).b), Math.min(((d)localObject2).a, ((d)localObject2).b));
          this.h = ((d)localObject2).a;
          this.i = ((d)localObject2).b;
          ((Camera.Parameters)localObject1).setPreviewSize(this.h, this.i);
          localObject2 = e(this.f);
          if (localObject2 == null) {
            break label720;
          }
          ((Camera.Parameters)localObject1).setPreviewFpsRange(localObject2[0], localObject2[1]);
          if (this.d) {
            i3 = i2;
          }
          this.k = f(i3);
          this.j = ((this.k - 90 + this.g * 90 + 360) % 360);
          this.c.setDisplayOrientation(0);
          TXCLog.i("TXCCameraCapturer", "vsize camera orientation " + this.k + ", preview " + this.j + ", home orientation " + this.g);
          this.c.setPreviewTexture(this.l);
          this.c.setParameters((Camera.Parameters)localObject1);
          this.c.setErrorCallback(this);
          this.c.startPreview();
          AppMethodBeat.o(187376);
          return 0;
        }
      }
      else
      {
        this.c = Camera.open(i3);
        continue;
      }
      label720:
      localException.setPreviewFrameRate(d(this.f));
      continue;
      label736:
      int i2 = i3;
      break label756;
      label742:
      i2 += 1;
      int i1 = i3;
      int i3 = i4;
      continue;
      label756:
      i3 = i1;
      if (i1 == -1)
      {
        i3 = i1;
        if (i2 != -1) {
          i3 = i2;
        }
      }
    }
  }
  
  public boolean d()
  {
    AppMethodBeat.i(15507);
    if (this.c != null)
    {
      if (this.c.getParameters().getMaxNumDetectedFaces() > 0)
      {
        AppMethodBeat.o(15507);
        return true;
      }
      AppMethodBeat.o(15507);
      return false;
    }
    AppMethodBeat.o(15507);
    return false;
  }
  
  public int e()
  {
    AppMethodBeat.i(15511);
    int i2 = 0;
    int i1 = i2;
    if (this.c != null)
    {
      Camera.Parameters localParameters = this.c.getParameters();
      i1 = i2;
      if (localParameters.getMaxZoom() > 0)
      {
        i1 = i2;
        if (localParameters.isZoomSupported()) {
          i1 = localParameters.getMaxZoom();
        }
      }
    }
    AppMethodBeat.o(15511);
    return i1;
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: sipush 15517
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 200	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   10: ifnull +87 -> 97
    //   13: aload_0
    //   14: getfield 200	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   17: aconst_null
    //   18: invokevirtual 520	android/hardware/Camera:setErrorCallback	(Landroid/hardware/Camera$ErrorCallback;)V
    //   21: aload_0
    //   22: getfield 200	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   25: aconst_null
    //   26: invokevirtual 488	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   29: aload_0
    //   30: getfield 200	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   33: invokevirtual 544	android/hardware/Camera:stopPreview	()V
    //   36: aload_0
    //   37: getfield 200	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   40: invokevirtual 547	android/hardware/Camera:release	()V
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 200	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 354	com/tencent/liteav/capturer/a:l	Landroid/graphics/SurfaceTexture;
    //   53: sipush 15517
    //   56: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: astore_1
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 200	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 354	com/tencent/liteav/capturer/a:l	Landroid/graphics/SurfaceTexture;
    //   71: sipush 15517
    //   74: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 200	com/tencent/liteav/capturer/a:c	Landroid/hardware/Camera;
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 354	com/tencent/liteav/capturer/a:l	Landroid/graphics/SurfaceTexture;
    //   89: sipush 15517
    //   92: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_1
    //   96: athrow
    //   97: sipush 15517
    //   100: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	a
    //   60	1	1	localException	Exception
    //   78	18	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	43	60	java/lang/Exception
    //   13	43	78	finally
  }
  
  public int g()
  {
    return this.j;
  }
  
  public boolean h()
  {
    return this.d;
  }
  
  public int i()
  {
    return this.h;
  }
  
  public int j()
  {
    return this.i;
  }
  
  public Camera k()
  {
    return this.c;
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(15521);
    if (paramBoolean)
    {
      TXCLog.i("TXCCameraCapturer", "AUTO focus success");
      AppMethodBeat.o(15521);
      return;
    }
    TXCLog.i("TXCCameraCapturer", "AUTO focus failed");
    AppMethodBeat.o(15521);
  }
  
  public void onError(int paramInt, Camera paramCamera)
  {
    AppMethodBeat.i(15522);
    TXCLog.w("TXCCameraCapturer", "camera catch error ".concat(String.valueOf(paramInt)));
    if (((paramInt == 1) || (paramInt == 2) || (paramInt == 100)) && (this.e != null)) {
      this.e.m();
    }
    AppMethodBeat.o(15522);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(15516);
    paramCamera = this.e;
    if (paramCamera != null) {
      paramCamera.a(paramArrayOfByte);
    }
    AppMethodBeat.o(15516);
  }
  
  public static enum a
  {
    private final int mHeight;
    private final int mWidth;
    
    static
    {
      AppMethodBeat.i(187370);
      a = new a("RESOLUTION_INVALID", 0, -1, -1);
      b = new a("RESOLUTION_180_320", 1, 180, 320);
      c = new a("RESOLUTION_270_480", 2, 270, 480);
      d = new a("RESOLUTION_320_480", 3, 320, 480);
      e = new a("RESOLUTION_360_640", 4, 360, 640);
      f = new a("RESOLUTION_540_960", 5, 540, 960);
      g = new a("RESOLUTION_720_1280", 6, 720, 1280);
      h = new a("RESOLUTION_1080_1920", 7, 1080, 1920);
      i = new a("RESOLUTION_HIGHEST", 8, 1080, 1920);
      j = new a[] { a, b, c, d, e, f, g, h, i };
      AppMethodBeat.o(187370);
    }
    
    private a(int paramInt1, int paramInt2)
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
    }
    
    private int a()
    {
      return this.mWidth;
    }
    
    private int b()
    {
      return this.mHeight;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.capturer.a
 * JD-Core Version:    0.7.0.1
 */