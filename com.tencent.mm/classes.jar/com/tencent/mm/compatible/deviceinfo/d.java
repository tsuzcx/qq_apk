package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
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
  public static boolean gaj;
  
  static
  {
    AppMethodBeat.i(262161);
    if ((MultiProcessMMKV.getDefault().decodeBool("clicfg_camera_util_use_cache", false)) || (BuildInfo.DEBUG)) {}
    for (boolean bool = true;; bool = false)
    {
      gaj = bool;
      Log.i("MicroMsg.CameraUtil", "useCache = %b", new Object[] { Boolean.valueOf(gaj) });
      AppMethodBeat.o(262161);
      return;
    }
  }
  
  public static d.a.a D(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(262154);
    paramContext = a(paramContext, paramInt, null);
    AppMethodBeat.o(262154);
    return paramContext;
  }
  
  public static d.a.a a(Context paramContext, int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155647);
    if (af.juH.jqa == 1)
    {
      Log.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl20, cameraId = ".concat(String.valueOf(paramInt)));
      new e();
      paramContext = e.e(paramLooper);
      AppMethodBeat.o(155647);
      return paramContext;
    }
    if (af.juH.jpS)
    {
      Log.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImplConfig, cameraId = ".concat(String.valueOf(paramInt)));
      new i();
      paramContext = i.a(paramInt, paramLooper);
      AppMethodBeat.o(155647);
      return paramContext;
    }
    if (Build.MODEL.equals("M9"))
    {
      new j();
      paramContext = j.e(paramLooper);
      AppMethodBeat.o(155647);
      return paramContext;
    }
    if (auj() > 1)
    {
      Log.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl23, cameraId = ".concat(String.valueOf(paramInt)));
      new g();
      paramContext = g.a(paramContext, paramInt, paramLooper);
      AppMethodBeat.o(155647);
      return paramContext;
    }
    new f();
    paramContext = f.a(paramInt, paramLooper);
    AppMethodBeat.o(155647);
    return paramContext;
  }
  
  public static List<Camera.Size> a(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(262157);
    new g();
    paramParameters = paramParameters.getSupportedPreviewSizes();
    AppMethodBeat.o(262157);
    return paramParameters;
  }
  
  public static int auj()
  {
    AppMethodBeat.i(155644);
    if ((af.juH.jpS) && (af.juH.jpY))
    {
      new i();
      i = i.auj();
      AppMethodBeat.o(155644);
      return i;
    }
    new g();
    a locala = a.jnC;
    int i = a.atL();
    AppMethodBeat.o(155644);
    return i;
  }
  
  public static int auk()
  {
    AppMethodBeat.i(155645);
    if (af.juS.jrb == 1)
    {
      AppMethodBeat.o(155645);
      return 0;
    }
    Object localObject;
    int i;
    if (gaj)
    {
      localObject = a.jnC;
      Log.i("MicroMsg.PluginCamera", "getBackCameraId mBackCameraId = " + a.jnA);
      if (a.jnA == -1) {
        ((a)localObject).atR();
      }
      i = a.jnA;
    }
    for (;;)
    {
      Log.i("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(155645);
      return i;
      localObject = a.jnC;
      int j = a.atL();
      localObject = new Camera.CameraInfo();
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label158;
        }
        Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
        if (((Camera.CameraInfo)localObject).facing == 0)
        {
          Log.d("MicroMsg.CameraUtil", "tigercam get bid %d", new Object[] { Integer.valueOf(i) });
          break;
        }
        i += 1;
      }
      label158:
      i = 0;
    }
  }
  
  public static int aul()
  {
    AppMethodBeat.i(155646);
    Object localObject;
    int i;
    if (gaj)
    {
      localObject = a.jnC;
      Log.i("MicroMsg.PluginCamera", "getBackCameraId mFrontCameraId = " + a.jnB);
      if (a.jnB == -1) {
        ((a)localObject).atR();
      }
      i = a.jnB;
    }
    for (;;)
    {
      Log.i("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(155646);
      return i;
      localObject = a.jnC;
      int j = a.atL();
      localObject = new Camera.CameraInfo();
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label142;
        }
        Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
        if (((Camera.CameraInfo)localObject).facing == 1)
        {
          Log.d("MicroMsg.CameraUtil", "tigercam get fid %d", new Object[] { Integer.valueOf(i) });
          break;
        }
        i += 1;
      }
      label142:
      i = 0;
    }
  }
  
  public static boolean aum()
  {
    AppMethodBeat.i(262153);
    if (af.juH.jqa == 1)
    {
      AppMethodBeat.o(262153);
      return true;
    }
    if ((Build.VERSION.SDK_INT == 10) && (Build.MODEL.equals("GT-S5360")))
    {
      AppMethodBeat.o(262153);
      return true;
    }
    AppMethodBeat.o(262153);
    return false;
  }
  
  public static List<Camera.Size> b(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(262159);
    if (Build.VERSION.SDK_INT >= 11)
    {
      new h();
      paramParameters = paramParameters.getSupportedVideoSizes();
      AppMethodBeat.o(262159);
      return paramParameters;
    }
    AppMethodBeat.o(262159);
    return null;
  }
  
  public static abstract interface a
  {
    public static final class a
    {
      public int fSM;
      public w jqD;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.d
 * JD-Core Version:    0.7.0.1
 */