package com.tencent.mm.compatible.c;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.media.MediaCodecList;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/compatible/camera/PluginCamera;", "", "()V", "CAMERA2_NUMBER_INFO_CACHE", "", "CAMERA2_SUPPORT_LEVELS_CACHE", "CAMERA_NUMBER_CACHE", "TAG", "cameraInfoList", "Ljava/util/ArrayList;", "Landroid/hardware/Camera$CameraInfo;", "Lkotlin/collections/ArrayList;", "futureTask", "Ljava/util/concurrent/FutureTask;", "", "mBackCameraId", "mCameraNumber", "mCameraNumberInApi2", "mCameraSupportLevels", "mFrontCameraId", "useMMKVCache", "", "getBackCameraId", "getCamera2LevelListInfoFromDevice", "", "getCamera2NumberInfo", "getCamera2NumbersInfoFromDevice", "getCamera2SupportLevelLists", "getCameraInfo", "id", "getCameraNumbers", "getFrontCameraId", "initCameraNumbers", "initCodecCount", "makeCameraInfoCache", "libcompatible_release"})
public final class a
{
  private static FutureTask<Integer> cCU;
  public static int jnA;
  public static int jnB;
  public static final a jnC;
  private static int jnv;
  private static boolean jnw;
  private static int jnx;
  private static String jny;
  private static ArrayList<Camera.CameraInfo> jnz;
  
  static
  {
    AppMethodBeat.i(262435);
    jnC = new a();
    jnv = -1;
    jnx = -1;
    jnz = new ArrayList();
    jnA = -1;
    jnB = -1;
    AppMethodBeat.o(262435);
  }
  
  public static int atL()
  {
    AppMethodBeat.i(262422);
    int i;
    if (jnv == -1)
    {
      Log.i("MicroMsg.PluginCamera", "mCameraNumber == -1，slow initCameraNumbers, use MMKV cache");
      i = MultiProcessMMKV.getDefault().getInt("cameraNumberCache", -1);
      Log.i("MicroMsg.PluginCamera", "get cameraNumberCache from MMKV cameraNumberCache is ".concat(String.valueOf(i)));
      if (i == -1)
      {
        Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV failed, just getNumberOfCameras freshly");
        jnv = Camera.getNumberOfCameras();
        Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV failed, just getNumberOfCameras freshly DONE");
        MultiProcessMMKV.getDefault().putInt("cameraNumberCache", jnv);
        Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV failed, just getNumberOfCameras freshly save cache done");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.PluginCamera", "mCameraNumber is " + jnv);
      i = jnv;
      AppMethodBeat.o(262422);
      return i;
      Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV successful, return cameraNumberCache : ".concat(String.valueOf(i)));
      if (jnw)
      {
        if (i == 0) {
          Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV is 0, error, getNumberOfCameras freshly ");
        }
      }
      else
      {
        i = Camera.getNumberOfCameras();
        jnv = i;
        AppMethodBeat.o(262422);
        return i;
      }
      jnv = i;
      AppMethodBeat.o(262422);
      return i;
      if (jnv == 0)
      {
        Log.i("MicroMsg.PluginCamera", "mCameraNumber == 0， happened error to get camera number and try again");
        jnv = Camera.getNumberOfCameras();
        Log.i("MicroMsg.PluginCamera", "mCameraNumber == 0， happened error to get camera number and try again DONE");
        MultiProcessMMKV.getDefault().putInt("cameraNumberCache", jnv);
      }
    }
  }
  
  public static int atM()
  {
    AppMethodBeat.i(262425);
    int i;
    if (jnx == -1)
    {
      i = MultiProcessMMKV.getDefault().getInt("camera2NumberInfoCache", -1);
      if (i == -1)
      {
        atO();
        MultiProcessMMKV.getDefault().putInt("camera2NumberInfoCache", jnx);
      }
    }
    for (;;)
    {
      i = jnx;
      AppMethodBeat.o(262425);
      return i;
      if ((jnw) && (i != 0))
      {
        jnx = i;
        AppMethodBeat.o(262425);
        return i;
      }
      atO();
      i = jnx;
      AppMethodBeat.o(262425);
      return i;
      if (jnx == 0)
      {
        atO();
        MultiProcessMMKV.getDefault().putInt("camera2NumberInfoCache", jnx);
      }
    }
  }
  
  public static String atN()
  {
    AppMethodBeat.i(262426);
    String str;
    if (jny == null)
    {
      str = MultiProcessMMKV.getDefault().getString("camera2SupportLevelsCache", null);
      if (str == null)
      {
        atP();
        MultiProcessMMKV.getDefault().putString("camera2SupportLevelsCache", jny);
      }
    }
    for (;;)
    {
      str = jny;
      AppMethodBeat.o(262426);
      return str;
      if (jnw)
      {
        jny = str;
        AppMethodBeat.o(262426);
        return str;
      }
      atP();
      str = jny;
      AppMethodBeat.o(262426);
      return str;
      if (jnx == 0)
      {
        atP();
        MultiProcessMMKV.getDefault().putString("camera2SupportLevelsCache", jny);
      }
    }
  }
  
  private static void atO()
  {
    AppMethodBeat.i(262427);
    try
    {
      Object localObject = MMApplicationContext.getContext().getSystemService("camera");
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        AppMethodBeat.o(262427);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.PluginCamera", "a camera access exception happend");
      AppMethodBeat.o(262427);
      return;
      jnx = ((CameraManager)localException).getCameraIdList().length;
      AppMethodBeat.o(262427);
      return;
    }
    catch (AssertionError localAssertionError)
    {
      Log.e("MicroMsg.PluginCamera", "some device has some problem in LegecyCamera ");
      AppMethodBeat.o(262427);
    }
  }
  
  private static void atP()
  {
    AppMethodBeat.i(262429);
    for (;;)
    {
      int i;
      try
      {
        jny = null;
        Object localObject = MMApplicationContext.getContext().getSystemService("camera");
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
          AppMethodBeat.o(262429);
          throw ((Throwable)localObject);
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.PluginCamera", "a camera access exception happend");
        AppMethodBeat.o(262429);
        return;
        CameraManager localCameraManager = (CameraManager)localException;
        String[] arrayOfString = localCameraManager.getCameraIdList();
        p.j(arrayOfString, "manager.cameraIdList");
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          String str = arrayOfString[i];
          if (jny == null) {
            jny = str + '-' + (Integer)localCameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL) + '-' + (Integer)localCameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING) + '+';
          } else {
            jny = p.I(jny, str + '-' + (Integer)localCameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL) + '-' + (Integer)localCameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING) + '+');
          }
        }
      }
      catch (AssertionError localAssertionError)
      {
        Log.e("MicroMsg.PluginCamera", "some device has some problem in LegecyCamera ");
        AppMethodBeat.o(262429);
        return;
      }
      AppMethodBeat.o(262429);
      return;
      i += 1;
    }
  }
  
  public static void atQ()
  {
    AppMethodBeat.i(262430);
    try
    {
      Log.i("MicroMsg.PluginCamera", "initCodecCount start");
      long l = System.currentTimeMillis();
      MediaCodecList.getCodecCount();
      Log.i("MicroMsg.PluginCamera", "initCodecCount end, duration : ".concat(String.valueOf(System.currentTimeMillis() - l)));
      AppMethodBeat.o(262430);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.PluginCamera", "initCodecCount error");
      AppMethodBeat.o(262430);
    }
  }
  
  public static void dP(boolean paramBoolean)
  {
    AppMethodBeat.i(262420);
    jnw = paramBoolean;
    Log.i("MicroMsg.PluginCamera", "initCameraNumbers start, useMMKVCache : ".concat(String.valueOf(paramBoolean)));
    cCU = new FutureTask((Callable)a.jnD);
    h.ZvG.be((Runnable)b.jnE);
    AppMethodBeat.o(262420);
  }
  
  public final void atR()
  {
    AppMethodBeat.i(262433);
    Log.i("MicroMsg.PluginCamera", "makeCameraInfoCache");
    try
    {
      int j = Camera.getNumberOfCameras();
      int i = 0;
      while (i < j)
      {
        localObject1 = new Camera.CameraInfo();
        Camera.getCameraInfo(i, (Camera.CameraInfo)localObject1);
        jnz.add(localObject1);
        if ((jnA == -1) && (((Camera.CameraInfo)jnz.get(i)).facing == 0)) {
          jnA = i;
        }
        if ((jnB == -1) && (((Camera.CameraInfo)jnz.get(i)).facing == 1)) {
          jnB = i;
        }
        Log.i("MicroMsg.PluginCamera", "makeCameraInfoCache, id = " + i + ", facint = " + ((Camera.CameraInfo)localObject1).facing);
        i += 1;
      }
      Log.i("MicroMsg.PluginCamera", "makeCameraInfoCache mBackCameraId = " + jnA + ", mFrontCameraId = " + jnB);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1;
        Log.e("MicroMsg.PluginCamera", "makeCameraInfoCache failed : " + localThrowable.getMessage() + ", clear cameraInfoList");
        jnz.clear();
      }
    }
    finally
    {
      AppMethodBeat.o(262433);
    }
    localObject1 = x.aazN;
    AppMethodBeat.o(262433);
  }
  
  public final Camera.CameraInfo qJ(int paramInt)
  {
    AppMethodBeat.i(262434);
    try
    {
      if (jnz.isEmpty())
      {
        Log.i("MicroMsg.PluginCamera", "cameraInfoList is empty, miss Cache, to make CameraInfo Cache");
        jnC.atR();
      }
      Object localObject1 = x.aazN;
      localObject1 = jnz.get(paramInt);
      p.j(localObject1, "cameraInfoList[id]");
      localObject1 = (Camera.CameraInfo)localObject1;
      Log.i("MicroMsg.PluginCamera", "getCameraInfo cameraInfoList.size = " + jnz.size());
      if (jnz.size() != 2)
      {
        localObject1 = new Camera.CameraInfo();
        Camera.getCameraInfo(paramInt, (Camera.CameraInfo)localObject1);
        AppMethodBeat.o(262434);
        return localObject1;
      }
    }
    finally
    {
      AppMethodBeat.o(262434);
    }
    Log.i("MicroMsg.PluginCamera", "getCameraInfo id = " + paramInt + ", ret = " + localObject2);
    AppMethodBeat.o(262434);
    return localObject2;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "call"})
  static final class a<V>
    implements Callable<Integer>
  {
    public static final a jnD;
    
    static
    {
      AppMethodBeat.i(261944);
      jnD = new a();
      AppMethodBeat.o(261944);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b jnE;
    
    static
    {
      AppMethodBeat.i(262237);
      jnE = new b();
      AppMethodBeat.o(262237);
    }
    
    public final void run()
    {
      AppMethodBeat.i(262233);
      Object localObject = h.ZvG;
      a locala2 = a.jnC;
      ((i)localObject).be((Runnable)a.atX());
      try
      {
        localObject = a.jnC;
        a.atX().get(10L, TimeUnit.SECONDS);
        AppMethodBeat.o(262233);
        return;
      }
      catch (TimeoutException localTimeoutException)
      {
        Log.e("MicroMsg.PluginCamera", "futureTask TimeoutException cancel");
        a locala1 = a.jnC;
        if (!a.atX().isCancelled())
        {
          locala1 = a.jnC;
          if (!a.atX().isDone())
          {
            locala1 = a.jnC;
            a.atX().cancel(true);
            AppMethodBeat.o(262233);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.PluginCamera", "futureTask Exception");
        AppMethodBeat.o(262233);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.c.a
 * JD-Core Version:    0.7.0.1
 */