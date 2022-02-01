package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.List;

public final class d
{
  public static boolean igs;
  
  static
  {
    AppMethodBeat.i(240869);
    if ((MultiProcessMMKV.getDefault().decodeBool("clicfg_camera_util_use_cache_new", true)) || (BuildInfo.DEBUG)) {}
    for (boolean bool = true;; bool = false)
    {
      igs = bool;
      Log.i("MicroMsg.CameraUtil", "useCache = %b", new Object[] { Boolean.valueOf(igs) });
      AppMethodBeat.o(240869);
      return;
    }
  }
  
  public static d.a.a G(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(240863);
    paramContext = a(paramContext, paramInt, null);
    AppMethodBeat.o(240863);
    return paramContext;
  }
  
  public static d.a.a a(Context paramContext, int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155647);
    if (af.lXY.lTh == 1)
    {
      Log.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl20, cameraId = ".concat(String.valueOf(paramInt)));
      new e();
      paramContext = e.f(paramLooper);
      AppMethodBeat.o(155647);
      return paramContext;
    }
    if (af.lXY.lSZ)
    {
      Log.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImplConfig, cameraId = ".concat(String.valueOf(paramInt)));
      paramContext = new i().a(paramInt, paramLooper);
      AppMethodBeat.o(155647);
      return paramContext;
    }
    if (q.aPo().equals("M9"))
    {
      new j();
      paramContext = j.f(paramLooper);
      AppMethodBeat.o(155647);
      return paramContext;
    }
    if (aOG() > 1)
    {
      Log.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl23, cameraId = ".concat(String.valueOf(paramInt)));
      paramContext = new g().a(paramContext, paramInt, paramLooper);
      AppMethodBeat.o(155647);
      return paramContext;
    }
    paramContext = new f().a(paramInt, paramLooper);
    AppMethodBeat.o(155647);
    return paramContext;
  }
  
  public static List<Camera.Size> a(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(240866);
    new g();
    paramParameters = paramParameters.getSupportedPreviewSizes();
    AppMethodBeat.o(240866);
    return paramParameters;
  }
  
  public static int aOG()
  {
    AppMethodBeat.i(155644);
    if ((af.lXY.lSZ) && (af.lXY.lTf))
    {
      new i();
      i = i.aOG();
      AppMethodBeat.o(155644);
      return i;
    }
    new g();
    a locala = a.lQF;
    int i = a.aOk();
    AppMethodBeat.o(155644);
    return i;
  }
  
  public static boolean aOH()
  {
    AppMethodBeat.i(240862);
    if (af.lXY.lTh == 1)
    {
      AppMethodBeat.o(240862);
      return true;
    }
    if ((Build.VERSION.SDK_INT == 10) && (q.aPo().equals("GT-S5360")))
    {
      AppMethodBeat.o(240862);
      return true;
    }
    AppMethodBeat.o(240862);
    return false;
  }
  
  public static int aOr()
  {
    AppMethodBeat.i(155645);
    if (af.lYj.lUp == 1)
    {
      AppMethodBeat.o(155645);
      return 0;
    }
    int j;
    int i;
    if (igs)
    {
      j = a.lQF.aOr();
      i = j;
      if (j == -1) {
        i = 0;
      }
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(240851);
          for (;;)
          {
            try
            {
              Object localObject1 = a.lQF;
              int j = a.aOk();
              localObject1 = new Camera.CameraInfo();
              int i = 0;
              if (i < j)
              {
                Camera.getCameraInfo(i, (Camera.CameraInfo)localObject1);
                if (((Camera.CameraInfo)localObject1).facing == 0)
                {
                  Log.d("MicroMsg.CameraUtil", "tigercam get bid %d", new Object[] { Integer.valueOf(i) });
                  Log.i("MicroMsg.CameraUtil", "getBackCameraId cacheBid = %d, noCacheBid = %d", new Object[] { Integer.valueOf(this.lTL), Integer.valueOf(i) });
                  localObject1 = a.lQF;
                  a.qQ(i);
                  AppMethodBeat.o(240851);
                  return;
                }
                i += 1;
              }
              else
              {
                i = 0;
              }
            }
            finally
            {
              Log.e("MicroMsg.CameraUtil", "getBackCameraId get cache failed : " + localObject2.getMessage());
              AppMethodBeat.o(240851);
              return;
            }
          }
        }
      }, "getBackCameraId-checkCache");
    }
    for (;;)
    {
      Log.i("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(155645);
      return i;
      Object localObject = a.lQF;
      j = a.aOk();
      localObject = new Camera.CameraInfo();
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label151;
        }
        Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
        if (((Camera.CameraInfo)localObject).facing == 0)
        {
          Log.d("MicroMsg.CameraUtil", "tigercam get bid %d", new Object[] { Integer.valueOf(i) });
          break;
        }
        i += 1;
      }
      label151:
      i = 0;
    }
  }
  
  public static int aOs()
  {
    AppMethodBeat.i(155646);
    int j;
    int i;
    if (igs)
    {
      j = a.lQF.aOs();
      i = j;
      if (j == -1) {
        i = 0;
      }
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(240852);
          for (;;)
          {
            try
            {
              Object localObject1 = a.lQF;
              int j = a.aOk();
              localObject1 = new Camera.CameraInfo();
              int i = 0;
              if (i < j)
              {
                Camera.getCameraInfo(i, (Camera.CameraInfo)localObject1);
                if (((Camera.CameraInfo)localObject1).facing == 1)
                {
                  Log.d("MicroMsg.CameraUtil", "tigercam get fid %d", new Object[] { Integer.valueOf(i) });
                  Log.i("MicroMsg.CameraUtil", "getFrontCameraId cacheFid = %d, noCacheFid = %d", new Object[] { Integer.valueOf(this.lTM), Integer.valueOf(i) });
                  localObject1 = a.lQF;
                  a.qR(i);
                  AppMethodBeat.o(240852);
                  return;
                }
                i += 1;
              }
              else
              {
                i = 0;
              }
            }
            finally
            {
              Log.e("MicroMsg.CameraUtil", "getFrontCameraId get cache failed : " + localObject2.getMessage());
              AppMethodBeat.o(240852);
              return;
            }
          }
        }
      }, "getFrontCameraId-checkCache");
    }
    for (;;)
    {
      Log.i("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(155646);
      return i;
      Object localObject = a.lQF;
      j = a.aOk();
      localObject = new Camera.CameraInfo();
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label135;
        }
        Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
        if (((Camera.CameraInfo)localObject).facing == 1)
        {
          Log.d("MicroMsg.CameraUtil", "tigercam get fid %d", new Object[] { Integer.valueOf(i) });
          break;
        }
        i += 1;
      }
      label135:
      i = 0;
    }
  }
  
  public static List<Camera.Size> b(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(240868);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new h();
      paramParameters = paramParameters.getSupportedVideoSizes();
      AppMethodBeat.o(240868);
      return paramParameters;
    }
    AppMethodBeat.o(240868);
    return null;
  }
  
  public static abstract interface a
  {
    public static final class a
    {
      public int hYK;
      public w lTN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.d
 * JD-Core Version:    0.7.0.1
 */