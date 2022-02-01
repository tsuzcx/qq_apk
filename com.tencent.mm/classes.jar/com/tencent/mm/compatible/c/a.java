package com.tencent.mm.compatible.c;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.media.MediaCodecList;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/compatible/camera/PluginCamera;", "", "()V", "CAMERA2_NUMBER_INFO_CACHE", "", "CAMERA2_SUPPORT_LEVELS_CACHE", "CAMERA_NUMBER_CACHE", "TAG", "futureTask", "Ljava/util/concurrent/FutureTask;", "", "mCameraNumber", "mCameraNumberInApi2", "mCameraSupportLevels", "useMMKVCache", "", "getCamera2LevelListInfoFromDevice", "", "getCamera2NumberInfo", "getCamera2NumbersInfoFromDevice", "getCamera2SupportLevelLists", "getCameraNumbers", "initCameraNumbers", "initCodecCount", "libcompatible_release"})
public final class a
{
  private static FutureTask<Integer> cCr;
  private static int gDo;
  private static boolean gDp;
  private static int gDq;
  private static String gDr;
  public static final a gDs;
  
  static
  {
    AppMethodBeat.i(215472);
    gDs = new a();
    gDo = -1;
    gDq = -1;
    AppMethodBeat.o(215472);
  }
  
  public static int anJ()
  {
    AppMethodBeat.i(215466);
    int i;
    if (gDo == -1)
    {
      Log.i("MicroMsg.PluginCamera", "mCameraNumber == -1，slow initCameraNumbers, use MMKV cache");
      i = MultiProcessMMKV.getDefault().getInt("cameraNumberCache", -1);
      Log.i("MicroMsg.PluginCamera", "get cameraNumberCache from MMKV cameraNumberCache is ".concat(String.valueOf(i)));
      if (i == -1)
      {
        Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV failed, just getNumberOfCameras freshly");
        gDo = Camera.getNumberOfCameras();
        Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV failed, just getNumberOfCameras freshly DONE");
        MultiProcessMMKV.getDefault().putInt("cameraNumberCache", gDo);
        Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV failed, just getNumberOfCameras freshly save cache done");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.PluginCamera", "mCameraNumber is " + gDo);
      i = gDo;
      AppMethodBeat.o(215466);
      return i;
      Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV successful, return cameraNumberCache : ".concat(String.valueOf(i)));
      if (gDp)
      {
        if (i == 0) {
          Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV is 0, error, getNumberOfCameras freshly ");
        }
      }
      else
      {
        i = Camera.getNumberOfCameras();
        gDo = i;
        AppMethodBeat.o(215466);
        return i;
      }
      gDo = i;
      AppMethodBeat.o(215466);
      return i;
      if (gDo == 0)
      {
        Log.i("MicroMsg.PluginCamera", "mCameraNumber == 0， happened error to get camera number and try again");
        gDo = Camera.getNumberOfCameras();
        Log.i("MicroMsg.PluginCamera", "mCameraNumber == 0， happened error to get camera number and try again DONE");
        MultiProcessMMKV.getDefault().putInt("cameraNumberCache", gDo);
      }
    }
  }
  
  public static int anK()
  {
    AppMethodBeat.i(215467);
    int i;
    if (gDq == -1)
    {
      i = MultiProcessMMKV.getDefault().getInt("camera2NumberInfoCache", -1);
      if (i == -1)
      {
        anM();
        MultiProcessMMKV.getDefault().putInt("camera2NumberInfoCache", gDq);
      }
    }
    for (;;)
    {
      i = gDq;
      AppMethodBeat.o(215467);
      return i;
      if ((gDp) && (i != 0))
      {
        gDq = i;
        AppMethodBeat.o(215467);
        return i;
      }
      anM();
      i = gDq;
      AppMethodBeat.o(215467);
      return i;
      if (gDq == 0)
      {
        anM();
        MultiProcessMMKV.getDefault().putInt("camera2NumberInfoCache", gDq);
      }
    }
  }
  
  public static String anL()
  {
    AppMethodBeat.i(215468);
    String str;
    if (gDr == null)
    {
      str = MultiProcessMMKV.getDefault().getString("camera2SupportLevelsCache", null);
      if (str == null)
      {
        anN();
        MultiProcessMMKV.getDefault().putString("camera2SupportLevelsCache", gDr);
      }
    }
    for (;;)
    {
      str = gDr;
      AppMethodBeat.o(215468);
      return str;
      if (gDp)
      {
        gDr = str;
        AppMethodBeat.o(215468);
        return str;
      }
      anN();
      str = gDr;
      AppMethodBeat.o(215468);
      return str;
      if (gDq == 0)
      {
        anN();
        MultiProcessMMKV.getDefault().putString("camera2SupportLevelsCache", gDr);
      }
    }
  }
  
  private static void anM()
  {
    AppMethodBeat.i(215469);
    try
    {
      Object localObject = MMApplicationContext.getContext().getSystemService("camera");
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        AppMethodBeat.o(215469);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.PluginCamera", "a camera access exception happend");
      AppMethodBeat.o(215469);
      return;
      gDq = ((CameraManager)localException).getCameraIdList().length;
      AppMethodBeat.o(215469);
      return;
    }
    catch (AssertionError localAssertionError)
    {
      Log.e("MicroMsg.PluginCamera", "some device has some problem in LegecyCamera ");
      AppMethodBeat.o(215469);
    }
  }
  
  private static void anN()
  {
    AppMethodBeat.i(215470);
    for (;;)
    {
      int i;
      try
      {
        gDr = null;
        Object localObject = MMApplicationContext.getContext().getSystemService("camera");
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
          AppMethodBeat.o(215470);
          throw ((Throwable)localObject);
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.PluginCamera", "a camera access exception happend");
        AppMethodBeat.o(215470);
        return;
        CameraManager localCameraManager = (CameraManager)localException;
        String[] arrayOfString = localCameraManager.getCameraIdList();
        p.g(arrayOfString, "manager.cameraIdList");
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          String str = arrayOfString[i];
          if (gDr == null) {
            gDr = str + '-' + (Integer)localCameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL) + '-' + (Integer)localCameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING) + '+';
          } else {
            gDr = p.I(gDr, str + '-' + (Integer)localCameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL) + '-' + (Integer)localCameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING) + '+');
          }
        }
      }
      catch (AssertionError localAssertionError)
      {
        Log.e("MicroMsg.PluginCamera", "some device has some problem in LegecyCamera ");
        AppMethodBeat.o(215470);
        return;
      }
      AppMethodBeat.o(215470);
      return;
      i += 1;
    }
  }
  
  public static void anO()
  {
    AppMethodBeat.i(215471);
    Log.i("MicroMsg.PluginCamera", "initCodecCount start");
    long l = System.currentTimeMillis();
    MediaCodecList.getCodecCount();
    Log.i("MicroMsg.PluginCamera", "initCodecCount end, duration : ".concat(String.valueOf(System.currentTimeMillis() - l)));
    AppMethodBeat.o(215471);
  }
  
  public static void dp(boolean paramBoolean)
  {
    AppMethodBeat.i(215465);
    gDp = paramBoolean;
    Log.i("MicroMsg.PluginCamera", "initCameraNumbers start, useMMKVCache : ".concat(String.valueOf(paramBoolean)));
    cCr = new FutureTask((Callable)a.gDt);
    h.RTc.aX((Runnable)b.gDu);
    AppMethodBeat.o(215465);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "call"})
  static final class a<V>
    implements Callable<Integer>
  {
    public static final a gDt;
    
    static
    {
      AppMethodBeat.i(215462);
      gDt = new a();
      AppMethodBeat.o(215462);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b gDu;
    
    static
    {
      AppMethodBeat.i(215464);
      gDu = new b();
      AppMethodBeat.o(215464);
    }
    
    public final void run()
    {
      AppMethodBeat.i(215463);
      Object localObject = h.RTc;
      a locala2 = a.gDs;
      ((i)localObject).aX((Runnable)a.anU());
      try
      {
        localObject = a.gDs;
        a.anU().get(10L, TimeUnit.SECONDS);
        AppMethodBeat.o(215463);
        return;
      }
      catch (TimeoutException localTimeoutException)
      {
        Log.e("MicroMsg.PluginCamera", "futureTask TimeoutException cancel");
        a locala1 = a.gDs;
        if (!a.anU().isCancelled())
        {
          locala1 = a.gDs;
          if (!a.anU().isDone())
          {
            locala1 = a.gDs;
            a.anU().cancel(true);
            AppMethodBeat.o(215463);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.PluginCamera", "futureTask Exception");
        AppMethodBeat.o(215463);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.c.a
 * JD-Core Version:    0.7.0.1
 */