package com.tencent.liteav.capturer;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a
  implements Camera.AutoFocusCallback
{
  private static final String c = a.class.getSimpleName();
  private Matrix a = new Matrix();
  private int b = 0;
  private Camera d;
  private boolean e = true;
  private int f = 15;
  private int g;
  private int h = 1;
  private int i;
  private int j;
  private int k;
  private int l;
  private SurfaceTexture m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q = false;
  
  private Rect a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i4 = 1000;
    float f1 = 200.0F * paramFloat3;
    paramFloat3 = paramFloat1;
    if (this.e == true) {
      paramFloat3 = 1.0F - paramFloat1;
    }
    int i2 = this.k / 90;
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
          return new Rect(i1, i2, i3, i4);
          i4 = i5;
        }
      }
    }
  }
  
  private a e(int paramInt)
  {
    List localList = this.d.getParameters().getSupportedPreviewSizes();
    ArrayList localArrayList = new ArrayList();
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt >= localArrayList.size()) {
        break label890;
      }
      a locala = (a)localArrayList.get(paramInt);
      int i1 = 0;
      for (;;)
      {
        if (i1 >= localList.size()) {
          break label883;
        }
        Camera.Size localSize = (Camera.Size)localList.get(i1);
        if ((localSize.width == locala.a) && (localSize.height == locala.b))
        {
          TXCLog.w(c, "wanted:" + locala.a + "*" + locala.b);
          return locala;
          localArrayList.add(new a(640, 360));
          localArrayList.add(new a(768, 432));
          localArrayList.add(new a(960, 540));
          localArrayList.add(new a(800, 480));
          localArrayList.add(new a(640, 480));
          localArrayList.add(new a(960, 720));
          localArrayList.add(new a(1280, 720));
          break;
          localArrayList.add(new a(960, 540));
          localArrayList.add(new a(960, 720));
          localArrayList.add(new a(1280, 720));
          localArrayList.add(new a(800, 480));
          localArrayList.add(new a(640, 360));
          localArrayList.add(new a(640, 480));
          break;
          localArrayList.add(new a(1280, 720));
          localArrayList.add(new a(1920, 1080));
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
          localArrayList.add(new a(1280, 720));
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
      label883:
      paramInt += 1;
    }
    label890:
    return null;
  }
  
  private int f(int paramInt)
  {
    int i1 = 0;
    List localList = this.d.getParameters().getSupportedPreviewFrameRates();
    if (localList == null)
    {
      TXCLog.e(c, "getSupportedFPS error");
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
    TXCLog.i(c, "choose fpts=" + i2);
    return i2;
  }
  
  private int[] g(int paramInt)
  {
    paramInt *= 1000;
    String str = "camera supported preview fps range: wantFPS = " + paramInt + "\n";
    Object localObject2 = this.d.getParameters().getSupportedPreviewFpsRange();
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = (int[])((List)localObject2).get(0);
      Collections.sort((List)localObject2, new a.1(this));
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
      return localObject1;
      return null;
    }
  }
  
  private int h(int paramInt)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    if (localCameraInfo.facing == 1) {
      return (360 - localCameraInfo.orientation) % 360;
    }
    return (localCameraInfo.orientation + 360) % 360;
  }
  
  public int a()
  {
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
    return i1;
  }
  
  public void a(float paramFloat)
  {
    float f2 = 1.0F;
    float f1 = -1.0F;
    if (this.d != null)
    {
      if (paramFloat <= 1.0F) {
        break label201;
      }
      paramFloat = f2;
    }
    label201:
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
          int i3 = b.a().d();
          paramFloat *= i2;
          if ((i3 != 0) && (i3 <= i2) && (i3 >= i1))
          {
            TXCLog.d(c, "camera setExposureCompensation: " + i3);
            localParameters.setExposureCompensation(i3);
          }
        }
        for (;;)
        {
          try
          {
            this.d.setParameters(localParameters);
            return;
          }
          catch (Exception localException)
          {
            return;
          }
          if ((paramFloat <= i2) && (paramFloat >= i1))
          {
            TXCLog.d(c, "camera setExposureCompensation: " + paramFloat);
            localParameters.setExposureCompensation((int)paramFloat);
            continue;
            TXCLog.e(c, "camera not support setExposureCompensation!");
          }
        }
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (!this.q) {
      return;
    }
    try
    {
      this.d.cancelAutoFocus();
      Camera.Parameters localParameters = this.d.getParameters();
      ArrayList localArrayList;
      if (this.n)
      {
        localArrayList = new ArrayList();
        localArrayList.add(new Camera.Area(a(paramFloat1, paramFloat2, 2.0F), 1000));
        localParameters.setFocusAreas(localArrayList);
      }
      if (this.o)
      {
        localArrayList = new ArrayList();
        localArrayList.add(new Camera.Area(a(paramFloat1, paramFloat2, 3.0F), 1000));
        localParameters.setMeteringAreas(localArrayList);
      }
      try
      {
        this.d.setParameters(localParameters);
        this.d.autoFocus(this);
        return;
      }
      catch (Exception localException1) {}
      return;
    }
    catch (Exception localException2) {}
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.m = paramSurfaceTexture;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.p = paramBoolean;
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
      for (;;)
      {
        try
        {
          this.d.setParameters(localParameters);
          return paramBoolean;
        }
        catch (Exception localException)
        {
          return false;
        }
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
    return false;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   4: ifnull +35 -> 39
    //   7: aload_0
    //   8: getfield 75	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   11: aconst_null
    //   12: invokevirtual 316	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   15: aload_0
    //   16: getfield 75	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   19: invokevirtual 319	android/hardware/Camera:stopPreview	()V
    //   22: aload_0
    //   23: getfield 75	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   26: invokevirtual 322	android/hardware/Camera:release	()V
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 75	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 292	com/tencent/liteav/capturer/a:m	Landroid/graphics/SurfaceTexture;
    //   39: return
    //   40: astore_1
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 75	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 292	com/tencent/liteav/capturer/a:m	Landroid/graphics/SurfaceTexture;
    //   51: return
    //   52: astore_1
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 75	com/tencent/liteav/capturer/a:d	Landroid/hardware/Camera;
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 292	com/tencent/liteav/capturer/a:m	Landroid/graphics/SurfaceTexture;
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	a
    //   40	1	1	localException	Exception
    //   52	12	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	29	40	java/lang/Exception
    //   7	29	52	finally
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public int c()
  {
    return this.k;
  }
  
  public int c(boolean paramBoolean)
  {
    try
    {
      if (this.m == null) {
        return -2;
      }
      if (this.d != null) {
        b();
      }
      Object localObject1 = new Camera.CameraInfo();
      int i2 = 0;
      int i1 = -1;
      int i3 = -1;
      label175:
      Camera.Parameters localParameters;
      Object localObject2;
      if (i2 < Camera.getNumberOfCameras())
      {
        Camera.getCameraInfo(i2, (Camera.CameraInfo)localObject1);
        TXCLog.i(c, "camera index " + i2 + ", facing = " + ((Camera.CameraInfo)localObject1).facing);
        if (((Camera.CameraInfo)localObject1).facing == 1) {
          i3 = i2;
        }
        if (((Camera.CameraInfo)localObject1).facing == 0) {
          i1 = i2;
        }
      }
      else
      {
        TXCLog.i(c, "camera front, id = " + i3);
        TXCLog.i(c, "camera back , id = " + i1);
        if ((i3 == -1) && (i1 != -1))
        {
          i2 = i1;
          break label725;
          this.e = paramBoolean;
          if (this.e)
          {
            this.d = Camera.open(i2);
            localParameters = this.d.getParameters();
            localObject1 = localParameters.getSupportedFocusModes();
            if ((!this.q) || (localObject1 == null) || (!((List)localObject1).contains("auto"))) {
              break label410;
            }
            TXCLog.i(c, "support FOCUS_MODE_AUTO");
            localParameters.setFocusMode("auto");
          }
          for (;;)
          {
            if (Build.VERSION.SDK_INT >= 14)
            {
              if (localParameters.getMaxNumFocusAreas() > 0) {
                this.n = true;
              }
              if (localParameters.getMaxNumMeteringAreas() > 0) {
                this.o = true;
              }
            }
            localObject1 = "";
            localObject2 = localParameters.getSupportedPreviewSizes();
            if (localObject2 == null) {
              break label448;
            }
            i3 = 0;
            localObject1 = "";
            while (i3 < ((List)localObject2).size())
            {
              Camera.Size localSize = (Camera.Size)((List)localObject2).get(i3);
              localObject1 = (String)localObject1 + String.format("camera supported preview size %d x %d\n", new Object[] { Integer.valueOf(localSize.width), Integer.valueOf(localSize.height) });
              i3 += 1;
            }
            this.d = Camera.open(i1);
            break;
            label410:
            if ((localObject1 != null) && (((List)localObject1).contains("continuous-video")))
            {
              TXCLog.i(c, "support FOCUS_MODE_CONTINUOUS_VIDEO");
              localParameters.setFocusMode("continuous-video");
            }
          }
        }
      }
      for (;;)
      {
        label448:
        localObject2 = e(this.g);
        if (localObject2 == null)
        {
          this.d.release();
          this.d = null;
          TXCLog.d(c, "不支持的视频分辨率");
          return -3;
        }
        localObject1 = (String)localObject1 + String.format("choose preview size %d x %d ", new Object[] { Integer.valueOf(((a)localObject2).a), Integer.valueOf(((a)localObject2).b) });
        TXCLog.i(c, (String)localObject1);
        this.i = ((a)localObject2).a;
        this.j = ((a)localObject2).b;
        localParameters.setPreviewSize(((a)localObject2).a, ((a)localObject2).b);
        localObject1 = g(this.f);
        if (localObject1 != null)
        {
          localParameters.setPreviewFpsRange(localObject1[0], localObject1[1]);
          if (!this.e) {
            break label704;
          }
        }
        for (;;)
        {
          this.l = h(i2);
          this.k = ((this.l - 90 + this.h * 90 + 360) % 360);
          this.d.setDisplayOrientation(0);
          this.d.setPreviewTexture(this.m);
          this.d.setParameters(localParameters);
          this.d.startPreview();
          return 0;
          localParameters.setPreviewFrameRate(f(this.f));
          break;
          label704:
          i2 = i1;
        }
        label725:
        do
        {
          break label175;
          i2 = i3;
          continue;
          i2 += 1;
          break;
        } while ((i1 != -1) || (i2 == -1));
        i1 = i2;
        break label175;
      }
    }
    catch (IOException localIOException)
    {
      return -1;
    }
    catch (Exception localException)
    {
      return -1;
    }
  }
  
  public boolean c(int paramInt)
  {
    boolean bool = false;
    Camera.Parameters localParameters;
    if (this.d != null)
    {
      localParameters = this.d.getParameters();
      if ((localParameters.getMaxZoom() > 0) && (localParameters.isZoomSupported()) && ((paramInt < 0) || (paramInt > localParameters.getMaxZoom()))) {
        break label60;
      }
    }
    label60:
    try
    {
      localParameters.setZoom(paramInt);
      this.d.setParameters(localParameters);
      bool = true;
      return bool;
    }
    catch (Exception localException) {}
    TXCLog.e(c, "invalid zoom value : " + paramInt + ", while max zoom is " + localParameters.getMaxZoom());
    return false;
    TXCLog.e(c, "camera not support zoom!");
    return false;
    return false;
  }
  
  public void d(int paramInt)
  {
    this.h = paramInt;
    this.k = ((this.l - 90 + this.h * 90 + 360) % 360);
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public int e()
  {
    return this.i;
  }
  
  public int f()
  {
    return this.j;
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (paramBoolean)
    {
      TXCLog.i(c, "AUTO focus success");
      return;
    }
    TXCLog.i(c, "AUTO focus failed");
  }
  
  private class a
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.capturer.a
 * JD-Core Version:    0.7.0.1
 */