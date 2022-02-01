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
  private static final String c;
  private Matrix a;
  private int b;
  private Camera d;
  private boolean e;
  private b f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private SurfaceTexture n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private int s;
  private int t;
  private boolean u;
  
  static
  {
    AppMethodBeat.i(15526);
    c = a.class.getSimpleName();
    AppMethodBeat.o(15526);
  }
  
  public a()
  {
    AppMethodBeat.i(15504);
    this.a = new Matrix();
    this.b = 0;
    this.e = true;
    this.g = 15;
    this.i = 1;
    this.r = false;
    this.u = false;
    AppMethodBeat.o(15504);
  }
  
  private Rect a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i4 = 1000;
    AppMethodBeat.i(15510);
    float f1 = 200.0F * paramFloat3;
    paramFloat3 = paramFloat1;
    if (this.e == true) {
      paramFloat3 = 1.0F - paramFloat1;
    }
    int i2 = this.l / 90;
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
  
  private void a(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(15518);
    List localList = paramParameters.getSupportedPreviewSizes();
    int i1;
    if (localList != null)
    {
      i1 = 0;
      paramParameters = "\n";
      for (;;)
      {
        localObject = paramParameters;
        if (i1 >= localList.size()) {
          break;
        }
        localObject = (Camera.Size)localList.get(i1);
        paramParameters = paramParameters + String.format("camera preview supported size %d x %d\n", new Object[] { Integer.valueOf(((Camera.Size)localObject).width), Integer.valueOf(((Camera.Size)localObject).height) });
        i1 += 1;
      }
    }
    Object localObject = "\n";
    TXCLog.i(c, (String)localObject);
    TXCLog.w(c, "vsize camera preview wanted:" + this.s + "*" + this.t);
    this.j = ((Camera.Size)localList.get(0)).width;
    this.k = ((Camera.Size)localList.get(0)).height;
    int i2;
    label222:
    int i3;
    if (this.s >= this.t)
    {
      i1 = this.s;
      if (this.s < this.t) {
        break label355;
      }
      i2 = this.t;
      i3 = localList.size() - 1;
    }
    for (;;)
    {
      if (i3 >= 0)
      {
        paramParameters = (Camera.Size)localList.get(i3);
        if ((paramParameters.width >= i1) && (paramParameters.width >= 640) && (paramParameters.height >= i2) && (paramParameters.height >= 480))
        {
          this.j = paramParameters.width;
          this.k = paramParameters.height;
        }
      }
      else
      {
        TXCLog.w(c, "vsize camera preview GOT:" + this.j + "*" + this.k);
        AppMethodBeat.o(15518);
        return;
        i1 = this.t;
        break;
        label355:
        i2 = this.s;
        break label222;
      }
      i3 -= 1;
    }
  }
  
  private void b(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(15519);
    List localList = paramParameters.getSupportedPreviewSizes();
    if (localList != null)
    {
      int i1 = 0;
      paramParameters = "\n";
      for (;;)
      {
        localObject = paramParameters;
        if (i1 >= localList.size()) {
          break;
        }
        localObject = (Camera.Size)localList.get(i1);
        paramParameters = paramParameters + String.format("camera preview supported size %d x %d\n", new Object[] { Integer.valueOf(((Camera.Size)localObject).width), Integer.valueOf(((Camera.Size)localObject).height) });
        i1 += 1;
      }
    }
    Object localObject = "\n";
    TXCLog.i(c, (String)localObject);
    paramParameters = e(this.h);
    if (paramParameters == null)
    {
      this.d.release();
      this.d = null;
      TXCLog.w(c, "camera preview 不支持的视频分辨率 " + this.h);
      AppMethodBeat.o(15519);
      return;
    }
    this.j = paramParameters.a;
    this.k = paramParameters.b;
    TXCLog.w(c, "vsize camera preview GOT:" + this.j + "*" + this.k);
    AppMethodBeat.o(15519);
  }
  
  private a e(int paramInt)
  {
    AppMethodBeat.i(15520);
    List localList = this.d.getParameters().getSupportedPreviewSizes();
    ArrayList localArrayList = new ArrayList();
    TXCLog.w(c, "wanted Resolution:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt >= localArrayList.size()) {
        break label1275;
      }
      a locala = (a)localArrayList.get(paramInt);
      int i1 = 0;
      for (;;)
      {
        if (i1 >= localList.size()) {
          break label1268;
        }
        Camera.Size localSize = (Camera.Size)localList.get(i1);
        if ((localSize.width == locala.a) && (localSize.height == locala.b))
        {
          TXCLog.w(c, "GOT Size:" + locala.a + "*" + locala.b);
          AppMethodBeat.o(15520);
          return locala;
          localArrayList.add(new a(640, 360));
          localArrayList.add(new a(768, 432));
          localArrayList.add(new a(640, 480));
          localArrayList.add(new a(960, 544));
          localArrayList.add(new a(960, 540));
          localArrayList.add(new a(800, 480));
          localArrayList.add(new a(960, 720));
          localArrayList.add(new a(1280, 720));
          break;
          localArrayList.add(new a(960, 544));
          localArrayList.add(new a(960, 540));
          localArrayList.add(new a(960, 720));
          localArrayList.add(new a(1280, 720));
          localArrayList.add(new a(800, 480));
          localArrayList.add(new a(640, 360));
          localArrayList.add(new a(640, 480));
          break;
          localArrayList.add(new a(1280, 720));
          localArrayList.add(new a(1920, 1088));
          localArrayList.add(new a(1920, 1080));
          localArrayList.add(new a(960, 544));
          localArrayList.add(new a(960, 540));
          localArrayList.add(new a(960, 720));
          localArrayList.add(new a(800, 480));
          localArrayList.add(new a(640, 360));
          localArrayList.add(new a(640, 480));
          localArrayList.add(new a(480, 320));
          localArrayList.add(new a(640, 360));
          localArrayList.add(new a(640, 480));
          localArrayList.add(new a(768, 432));
          break;
          localArrayList.add(new a(1920, 1088));
          localArrayList.add(new a(1920, 1080));
          localArrayList.add(new a(1280, 720));
          localArrayList.add(new a(960, 544));
          localArrayList.add(new a(960, 540));
          localArrayList.add(new a(960, 720));
          localArrayList.add(new a(800, 480));
          localArrayList.add(new a(640, 360));
          localArrayList.add(new a(640, 480));
          break;
          localArrayList.add(new a(1920, 1088));
          localArrayList.add(new a(1920, 1080));
          localArrayList.add(new a(1280, 720));
          localArrayList.add(new a(960, 544));
          localArrayList.add(new a(960, 540));
          localArrayList.add(new a(960, 720));
          localArrayList.add(new a(800, 480));
          localArrayList.add(new a(768, 432));
          localArrayList.add(new a(640, 360));
          localArrayList.add(new a(640, 480));
          break;
        }
        i1 += 1;
      }
      label1268:
      paramInt += 1;
    }
    label1275:
    AppMethodBeat.o(15520);
    return null;
  }
  
  private int f(int paramInt)
  {
    int i1 = 0;
    AppMethodBeat.i(15523);
    List localList = this.d.getParameters().getSupportedPreviewFrameRates();
    if (localList == null)
    {
      TXCLog.e(c, "getSupportedFPS error");
      AppMethodBeat.o(15523);
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
    TXCLog.i(c, "choose fps=".concat(String.valueOf(i2)));
    AppMethodBeat.o(15523);
    return i2;
  }
  
  private int[] g(int paramInt)
  {
    AppMethodBeat.i(15524);
    paramInt *= 1000;
    String str = "camera supported preview fps range: wantFPS = " + paramInt + "\n";
    Object localObject2 = this.d.getParameters().getSupportedPreviewFpsRange();
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
      str = str + "choose preview fps range: " + localObject1[0] + " - " + localObject1[1];
      TXCLog.i(c, str);
      AppMethodBeat.o(15524);
      return localObject1;
      AppMethodBeat.o(15524);
      return null;
    }
  }
  
  private int h(int paramInt)
  {
    AppMethodBeat.i(15525);
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    String str = c;
    StringBuilder localStringBuilder = new StringBuilder("vsize camera orientation ").append(localCameraInfo.orientation).append(", front ");
    boolean bool;
    if (localCameraInfo.facing == 1)
    {
      bool = true;
      TXCLog.i(str, bool);
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
        break label133;
      }
    }
    label133:
    for (paramInt = (360 - paramInt) % 360;; paramInt = (paramInt + 360) % 360)
    {
      AppMethodBeat.o(15525);
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
    if (this.d != null)
    {
      if (paramFloat <= 1.0F) {
        break label209;
      }
      paramFloat = f2;
    }
    label209:
    for (;;)
    {
      if (paramFloat < -1.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        Camera.Parameters localParameters = this.d.getParameters();
        int i1 = localParameters.getMinExposureCompensation();
        int i2 = localParameters.getMaxExposureCompensation();
        if ((i1 != 0) && (i2 != 0))
        {
          int i3 = com.tencent.liteav.basic.e.b.a().d();
          paramFloat *= i2;
          if ((i3 != 0) && (i3 <= i2) && (i3 >= i1))
          {
            TXCLog.i(c, "camera setExposureCompensation: ".concat(String.valueOf(i3)));
            localParameters.setExposureCompensation(i3);
          }
        }
        for (;;)
        {
          try
          {
            this.d.setParameters(localParameters);
            AppMethodBeat.o(15513);
            return;
          }
          catch (Exception localException) {}
          if ((paramFloat <= i2) && (paramFloat >= i1))
          {
            TXCLog.i(c, "camera setExposureCompensation: ".concat(String.valueOf(paramFloat)));
            localParameters.setExposureCompensation((int)paramFloat);
            continue;
            TXCLog.e(c, "camera not support setExposureCompensation!");
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
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 80	com/tencent/liteav/capturer/a:u	Z
    //   10: ifne +10 -> 20
    //   13: sipush 15509
    //   16: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_0
    //   21: getfield 178	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   24: invokevirtual 322	android/hardware/Camera:cancelAutoFocus	()V
    //   27: aload_0
    //   28: getfield 178	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   31: invokevirtual 192	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   34: astore_3
    //   35: aload_0
    //   36: getfield 324	com/tencent/liteav/capturer/a:o	Z
    //   39: ifeq +43 -> 82
    //   42: new 194	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 195	java/util/ArrayList:<init>	()V
    //   49: astore 4
    //   51: aload 4
    //   53: new 326	android/hardware/Camera$Area
    //   56: dup
    //   57: aload_0
    //   58: fload_1
    //   59: fload_2
    //   60: fconst_2
    //   61: invokespecial 328	com/tencent/liteav/capturer/a:a	(FFF)Landroid/graphics/Rect;
    //   64: sipush 1000
    //   67: invokespecial 331	android/hardware/Camera$Area:<init>	(Landroid/graphics/Rect;I)V
    //   70: invokeinterface 213 2 0
    //   75: pop
    //   76: aload_3
    //   77: aload 4
    //   79: invokevirtual 335	android/hardware/Camera$Parameters:setFocusAreas	(Ljava/util/List;)V
    //   82: aload_0
    //   83: getfield 337	com/tencent/liteav/capturer/a:p	Z
    //   86: ifeq +45 -> 131
    //   89: new 194	java/util/ArrayList
    //   92: dup
    //   93: invokespecial 195	java/util/ArrayList:<init>	()V
    //   96: astore 4
    //   98: aload 4
    //   100: new 326	android/hardware/Camera$Area
    //   103: dup
    //   104: aload_0
    //   105: fload_1
    //   106: fload_2
    //   107: ldc_w 338
    //   110: invokespecial 328	com/tencent/liteav/capturer/a:a	(FFF)Landroid/graphics/Rect;
    //   113: sipush 1000
    //   116: invokespecial 331	android/hardware/Camera$Area:<init>	(Landroid/graphics/Rect;I)V
    //   119: invokeinterface 213 2 0
    //   124: pop
    //   125: aload_3
    //   126: aload 4
    //   128: invokevirtual 341	android/hardware/Camera$Parameters:setMeteringAreas	(Ljava/util/List;)V
    //   131: aload_0
    //   132: getfield 178	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   135: aload_3
    //   136: invokevirtual 313	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   139: aload_0
    //   140: getfield 178	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   143: aload_0
    //   144: invokevirtual 345	android/hardware/Camera:autoFocus	(Landroid/hardware/Camera$AutoFocusCallback;)V
    //   147: sipush 15509
    //   150: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: return
    //   154: astore_3
    //   155: sipush 15509
    //   158: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: return
    //   162: astore_3
    //   163: sipush 15509
    //   166: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    this.h = paramInt;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.n = paramSurfaceTexture;
  }
  
  public void a(b paramb)
  {
    this.f = paramb;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.r = paramBoolean;
    this.s = paramInt1;
    this.t = paramInt2;
  }
  
  public boolean a()
  {
    AppMethodBeat.i(15505);
    if (this.d != null)
    {
      Camera.Parameters localParameters = this.d.getParameters();
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
    this.q = paramBoolean;
    if (this.d != null)
    {
      boolean bool = true;
      Camera.Parameters localParameters = this.d.getParameters();
      List localList = localParameters.getSupportedFlashModes();
      if (paramBoolean) {
        if ((localList != null) && (localList.contains("torch")))
        {
          TXCLog.i(c, "set FLASH_MODE_TORCH");
          localParameters.setFlashMode("torch");
          paramBoolean = bool;
        }
      }
      try
      {
        for (;;)
        {
          this.d.setParameters(localParameters);
          AppMethodBeat.o(15508);
          return paramBoolean;
          paramBoolean = false;
          continue;
          if ((localList != null) && (localList.contains("off")))
          {
            TXCLog.i(c, "set FLASH_MODE_OFF");
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
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public boolean b()
  {
    AppMethodBeat.i(15506);
    if (this.d != null)
    {
      if (this.d.getParameters().getSupportedFlashModes() != null)
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
  
  public int c(boolean paramBoolean)
  {
    AppMethodBeat.i(15515);
    for (;;)
    {
      int i4;
      try
      {
        TXCLog.i(c, "trtc_capture: start capture");
        localObject1 = this.n;
        if (localObject1 == null)
        {
          AppMethodBeat.o(15515);
          return -2;
        }
        if (this.d != null) {
          f();
        }
        localObject1 = new Camera.CameraInfo();
        i2 = 0;
        i1 = -1;
        i3 = -1;
        if (i2 < Camera.getNumberOfCameras())
        {
          Camera.getCameraInfo(i2, (Camera.CameraInfo)localObject1);
          TXCLog.i(c, "camera index " + i2 + ", facing = " + ((Camera.CameraInfo)localObject1).facing);
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
            break label644;
          }
          i3 = i1;
          if (i1 != -1) {
            break label644;
          }
          i3 = i2;
          break label644;
        }
        TXCLog.i(c, "camera front, id = ".concat(String.valueOf(i3)));
        TXCLog.i(c, "camera back , id = ".concat(String.valueOf(i1)));
        if ((i3 != -1) || (i1 == -1)) {
          break label638;
        }
        i2 = i1;
      }
      catch (IOException localIOException)
      {
        Object localObject1;
        Object localObject2;
        AppMethodBeat.o(15515);
        return -1;
        if ((localObject2 == null) || (!((List)localObject2).contains("continuous-video"))) {
          continue;
        }
        TXCLog.i(c, "support FOCUS_MODE_CONTINUOUS_VIDEO");
        localIOException.setFocusMode("continuous-video");
        continue;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(15515);
        return -1;
      }
      this.e = paramBoolean;
      if (this.e)
      {
        this.d = Camera.open(i2);
        localObject1 = this.d.getParameters();
        localObject2 = ((Camera.Parameters)localObject1).getSupportedFocusModes();
        if ((this.u) && (localObject2 != null) && (((List)localObject2).contains("auto")))
        {
          TXCLog.i(c, "support FOCUS_MODE_AUTO");
          ((Camera.Parameters)localObject1).setFocusMode("auto");
          if (Build.VERSION.SDK_INT >= 14)
          {
            if (((Camera.Parameters)localObject1).getMaxNumFocusAreas() > 0) {
              this.o = true;
            }
            if (((Camera.Parameters)localObject1).getMaxNumMeteringAreas() > 0) {
              this.p = true;
            }
          }
          if (!this.r) {
            break label613;
          }
          ((Camera.Parameters)localObject1).setPreviewFormat(17);
          this.d.setPreviewCallback(this);
          a((Camera.Parameters)localObject1);
          ((Camera.Parameters)localObject1).setPreviewSize(this.j, this.k);
          localObject2 = g(this.g);
          if (localObject2 == null) {
            break label622;
          }
          ((Camera.Parameters)localObject1).setPreviewFpsRange(localObject2[0], localObject2[1]);
          if (this.e) {
            i3 = i2;
          }
          this.m = h(i3);
          this.l = ((this.m - 90 + this.i * 90 + 360) % 360);
          this.d.setDisplayOrientation(0);
          TXCLog.i(c, "vsize camera orientation " + this.m + ", preview " + this.l + ", home orientation " + this.i);
          this.d.setPreviewTexture(this.n);
          this.d.setParameters((Camera.Parameters)localObject1);
          this.d.setErrorCallback(this);
          this.d.startPreview();
          AppMethodBeat.o(15515);
          return 0;
        }
      }
      else
      {
        this.d = Camera.open(i3);
        continue;
      }
      label613:
      b(localException);
      continue;
      label622:
      localException.setPreviewFrameRate(f(this.g));
      continue;
      label638:
      int i2 = i3;
      break label658;
      label644:
      i2 += 1;
      int i1 = i3;
      int i3 = i4;
      continue;
      label658:
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
  
  public boolean c()
  {
    return this.o;
  }
  
  public boolean c(int paramInt)
  {
    bool2 = false;
    AppMethodBeat.i(15512);
    bool1 = bool2;
    Camera.Parameters localParameters;
    if (this.d != null)
    {
      localParameters = this.d.getParameters();
      if ((localParameters.getMaxZoom() > 0) && (localParameters.isZoomSupported()) && ((paramInt < 0) || (paramInt > localParameters.getMaxZoom()))) {
        break label80;
      }
    }
    for (;;)
    {
      try
      {
        localParameters.setZoom(paramInt);
        this.d.setParameters(localParameters);
        bool1 = true;
      }
      catch (Exception localException)
      {
        label80:
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(15512);
      return bool1;
      TXCLog.e(c, "invalid zoom value : " + paramInt + ", while max zoom is " + localParameters.getMaxZoom());
      bool1 = bool2;
      continue;
      TXCLog.e(c, "camera not support zoom!");
      bool1 = bool2;
    }
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(15514);
    TXCLog.w(c, "vsize setHomeOrientation ".concat(String.valueOf(paramInt)));
    this.i = paramInt;
    this.l = ((this.m - 90 + this.i * 90 + 360) % 360);
    AppMethodBeat.o(15514);
  }
  
  public boolean d()
  {
    AppMethodBeat.i(15507);
    if (this.d != null)
    {
      if (this.d.getParameters().getMaxNumDetectedFaces() > 0)
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
    if (this.d != null)
    {
      Camera.Parameters localParameters = this.d.getParameters();
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
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 178	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   10: ifnull +87 -> 97
    //   13: aload_0
    //   14: getfield 178	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   17: aconst_null
    //   18: invokevirtual 458	android/hardware/Camera:setErrorCallback	(Landroid/hardware/Camera$ErrorCallback;)V
    //   21: aload_0
    //   22: getfield 178	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   25: aconst_null
    //   26: invokevirtual 429	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   29: aload_0
    //   30: getfield 178	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   33: invokevirtual 490	android/hardware/Camera:stopPreview	()V
    //   36: aload_0
    //   37: getfield 178	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   40: invokevirtual 183	android/hardware/Camera:release	()V
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 178	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 348	com/tencent/liteav/capturer/a:n	Landroid/graphics/SurfaceTexture;
    //   53: sipush 15517
    //   56: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: astore_1
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 178	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 348	com/tencent/liteav/capturer/a:n	Landroid/graphics/SurfaceTexture;
    //   71: sipush 15517
    //   74: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 178	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 348	com/tencent/liteav/capturer/a:n	Landroid/graphics/SurfaceTexture;
    //   89: sipush 15517
    //   92: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_1
    //   96: athrow
    //   97: sipush 15517
    //   100: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    return this.l;
  }
  
  public boolean h()
  {
    return this.e;
  }
  
  public int i()
  {
    return this.j;
  }
  
  public int j()
  {
    return this.k;
  }
  
  public Camera k()
  {
    return this.d;
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(15521);
    if (paramBoolean)
    {
      TXCLog.i(c, "AUTO focus success");
      AppMethodBeat.o(15521);
      return;
    }
    TXCLog.i(c, "AUTO focus failed");
    AppMethodBeat.o(15521);
  }
  
  public void onError(int paramInt, Camera paramCamera)
  {
    AppMethodBeat.i(15522);
    TXCLog.w(c, "camera catch error ".concat(String.valueOf(paramInt)));
    if (((paramInt == 1) || (paramInt == 2) || (paramInt == 100)) && (this.f != null)) {
      this.f.m();
    }
    AppMethodBeat.o(15522);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(15516);
    paramCamera = this.f;
    if (paramCamera != null) {
      paramCamera.a(paramArrayOfByte);
    }
    AppMethodBeat.o(15516);
  }
  
  class a
  {
    public int a = 1280;
    public int b = 720;
    
    a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.capturer.a
 * JD-Core Version:    0.7.0.1
 */