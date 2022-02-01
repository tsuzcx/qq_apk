package com.tencent.mm.compatible.c;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.media.MediaCodecList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/compatible/camera/PluginCamera;", "", "()V", "CAMERA2_NUMBER_INFO_CACHE", "", "CAMERA2_SUPPORT_LEVELS_CACHE", "CAMERA_NUMBER_CACHE", "TAG", "cameraInfoList", "Ljava/util/ArrayList;", "Landroid/hardware/Camera$CameraInfo;", "Lkotlin/collections/ArrayList;", "futureTask", "Ljava/util/concurrent/FutureTask;", "", "mBackCameraId", "mCameraNumber", "mCameraNumberInApi2", "mCameraSupportLevels", "mFrontCameraId", "useMMKVCache", "", "getBackCameraId", "getCamera2LevelListInfoFromDevice", "", "getCamera2NumberInfo", "getCamera2NumbersInfoFromDevice", "getCamera2SupportLevelLists", "getCameraInfo", "id", "getCameraNumbers", "getFrontCameraId", "initCameraNumbers", "initCodecCount", "makeCameraInfoCache", "updateBackCameraId", "backCameraId", "updateCameraInfoCache", "cameraInfo", "updateFrontCameraId", "frontCameraId", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static FutureTask<Integer> evy;
  public static final a lQF;
  private static int lQG;
  private static boolean lQH;
  private static int lQI;
  private static String lQJ;
  private static ArrayList<Camera.CameraInfo> lQK;
  private static int lQL;
  private static int lQM;
  
  static
  {
    AppMethodBeat.i(240825);
    lQF = new a();
    lQG = -1;
    lQI = -1;
    lQK = new ArrayList();
    lQL = -1;
    lQM = -1;
    AppMethodBeat.o(240825);
  }
  
  public static void a(int paramInt, Camera.CameraInfo paramCameraInfo)
  {
    AppMethodBeat.i(240814);
    s.u(paramCameraInfo, "cameraInfo");
    Log.i("MicroMsg.PluginCamera", s.X("updateCameraInfoCache ", Integer.valueOf(paramInt)));
    lQK.set(paramInt, paramCameraInfo);
    AppMethodBeat.o(240814);
  }
  
  public static void aOj()
  {
    AppMethodBeat.i(240781);
    lQH = true;
    Log.i("MicroMsg.PluginCamera", s.X("initCameraNumbers start, useMMKVCache : ", Boolean.TRUE));
    evy = new FutureTask(a..ExternalSyntheticLambda1.INSTANCE);
    h.ahAA.bm(a..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(240781);
  }
  
  public static int aOk()
  {
    AppMethodBeat.i(240788);
    int i;
    if (lQG == -1)
    {
      Log.i("MicroMsg.PluginCamera", "mCameraNumber == -1，slow initCameraNumbers, use MMKV cache");
      i = MultiProcessMMKV.getDefault().getInt("cameraNumberCache", -1);
      Log.i("MicroMsg.PluginCamera", s.X("get cameraNumberCache from MMKV cameraNumberCache is ", Integer.valueOf(i)));
      if (i == -1)
      {
        Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV failed, just getNumberOfCameras freshly");
        lQG = Camera.getNumberOfCameras();
        Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV failed, just getNumberOfCameras freshly DONE");
        MultiProcessMMKV.getDefault().putInt("cameraNumberCache", lQG);
        Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV failed, just getNumberOfCameras freshly save cache done");
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.PluginCamera", s.X("mCameraNumber is ", Integer.valueOf(lQG)));
      i = lQG;
      AppMethodBeat.o(240788);
      return i;
      Log.i("MicroMsg.PluginCamera", s.X("cameraNumberCache from MMKV successful, return cameraNumberCache : ", Integer.valueOf(i)));
      if (lQH)
      {
        if (i == 0) {
          Log.i("MicroMsg.PluginCamera", "cameraNumberCache from MMKV is 0, error, getNumberOfCameras freshly ");
        }
      }
      else
      {
        i = Camera.getNumberOfCameras();
        lQG = i;
        AppMethodBeat.o(240788);
        return i;
      }
      lQG = i;
      AppMethodBeat.o(240788);
      return i;
      if (lQG == 0)
      {
        Log.i("MicroMsg.PluginCamera", "mCameraNumber == 0， happened error to get camera number and try again");
        lQG = Camera.getNumberOfCameras();
        Log.i("MicroMsg.PluginCamera", "mCameraNumber == 0， happened error to get camera number and try again DONE");
        MultiProcessMMKV.getDefault().putInt("cameraNumberCache", lQG);
      }
    }
  }
  
  public static int aOl()
  {
    AppMethodBeat.i(240793);
    int i;
    if (lQI == -1)
    {
      i = MultiProcessMMKV.getDefault().getInt("camera2NumberInfoCache", -1);
      if (i == -1)
      {
        aOn();
        MultiProcessMMKV.getDefault().putInt("camera2NumberInfoCache", lQI);
      }
    }
    for (;;)
    {
      i = lQI;
      AppMethodBeat.o(240793);
      return i;
      if ((lQH) && (i != 0))
      {
        lQI = i;
        AppMethodBeat.o(240793);
        return i;
      }
      aOn();
      i = lQI;
      AppMethodBeat.o(240793);
      return i;
      if (lQI == 0)
      {
        aOn();
        MultiProcessMMKV.getDefault().putInt("camera2NumberInfoCache", lQI);
      }
    }
  }
  
  public static String aOm()
  {
    AppMethodBeat.i(240800);
    String str;
    if (lQJ == null)
    {
      str = MultiProcessMMKV.getDefault().getString("camera2SupportLevelsCache", null);
      if (str == null)
      {
        aOo();
        MultiProcessMMKV.getDefault().putString("camera2SupportLevelsCache", lQJ);
      }
    }
    for (;;)
    {
      str = lQJ;
      AppMethodBeat.o(240800);
      return str;
      if (lQH)
      {
        lQJ = str;
        AppMethodBeat.o(240800);
        return str;
      }
      aOo();
      str = lQJ;
      AppMethodBeat.o(240800);
      return str;
      if (lQI == 0)
      {
        aOo();
        MultiProcessMMKV.getDefault().putString("camera2SupportLevelsCache", lQJ);
      }
    }
  }
  
  private static void aOn()
  {
    AppMethodBeat.i(240806);
    try
    {
      Object localObject = MMApplicationContext.getContext().getSystemService("camera");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        AppMethodBeat.o(240806);
        throw ((Throwable)localObject);
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.PluginCamera", "a camera access exception happend");
      AppMethodBeat.o(240806);
      return;
      lQI = ((CameraManager)localException).getCameraIdList().length;
      AppMethodBeat.o(240806);
      return;
    }
    catch (AssertionError localAssertionError)
    {
      Log.e("MicroMsg.PluginCamera", "some device has some problem in LegecyCamera ");
      AppMethodBeat.o(240806);
    }
  }
  
  private static void aOo()
  {
    AppMethodBeat.i(240810);
    for (;;)
    {
      int i;
      try
      {
        lQJ = null;
        Object localObject1 = MMApplicationContext.getContext().getSystemService("camera");
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
          AppMethodBeat.o(240810);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.PluginCamera", "a camera access exception happend");
        AppMethodBeat.o(240810);
        return;
        CameraManager localCameraManager = (CameraManager)localException;
        Object localObject2 = localCameraManager.getCameraIdList();
        s.s(localObject2, "manager.cameraIdList");
        localObject2 = (Object[])localObject2;
        int j = localObject2.length;
        i = 0;
        if (i < j)
        {
          String str = (String)localObject2[i];
          if (lQJ == null) {
            lQJ = str + '-' + localCameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL) + '-' + localCameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING) + '+';
          } else {
            lQJ = lQJ + str + '-' + localCameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL) + '-' + localCameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING) + '+';
          }
        }
      }
      catch (AssertionError localAssertionError)
      {
        Log.e("MicroMsg.PluginCamera", "some device has some problem in LegecyCamera ");
        AppMethodBeat.o(240810);
        return;
      }
      AppMethodBeat.o(240810);
      return;
      i += 1;
    }
  }
  
  public static void aOp()
  {
    AppMethodBeat.i(240813);
    try
    {
      Log.i("MicroMsg.PluginCamera", "initCodecCount start");
      long l = System.currentTimeMillis();
      MediaCodecList.getCodecCount();
      Log.i("MicroMsg.PluginCamera", s.X("initCodecCount end, duration : ", Long.valueOf(System.currentTimeMillis() - l)));
      AppMethodBeat.o(240813);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.PluginCamera", "initCodecCount error");
      AppMethodBeat.o(240813);
    }
  }
  
  private static final Integer aOt()
  {
    AppMethodBeat.i(240822);
    Log.i("MicroMsg.PluginCamera", "initCameraNumbers getNumberOfCameras start");
    lQG = Camera.getNumberOfCameras();
    Log.i("MicroMsg.PluginCamera", s.X("initCameraNumbers getNumberOfCameras Done mCameraNumber is ", Integer.valueOf(lQG)));
    aOn();
    aOo();
    MultiProcessMMKV.getDefault().putInt("cameraNumberCache", lQG);
    MultiProcessMMKV.getDefault().putInt("camera2NumberInfoCache", lQI);
    MultiProcessMMKV.getDefault().putString("camera2SupportLevelsCache", lQJ);
    int i = lQG;
    AppMethodBeat.o(240822);
    return Integer.valueOf(i);
  }
  
  private static final void aOu()
  {
    Object localObject2 = null;
    AppMethodBeat.i(240824);
    i locali = h.ahAA;
    FutureTask localFutureTask2 = evy;
    FutureTask localFutureTask1 = localFutureTask2;
    if (localFutureTask2 == null)
    {
      s.bIx("futureTask");
      localFutureTask1 = null;
    }
    locali.bm((Runnable)localFutureTask1);
    try
    {
      localFutureTask2 = evy;
      localFutureTask1 = localFutureTask2;
      if (localFutureTask2 == null)
      {
        s.bIx("futureTask");
        localFutureTask1 = null;
      }
      localFutureTask1.get(10L, TimeUnit.SECONDS);
      AppMethodBeat.o(240824);
      return;
    }
    catch (TimeoutException localTimeoutException)
    {
      Log.e("MicroMsg.PluginCamera", "futureTask TimeoutException cancel");
      localFutureTask2 = evy;
      Object localObject1 = localFutureTask2;
      if (localFutureTask2 == null)
      {
        s.bIx("futureTask");
        localObject1 = null;
      }
      if (!((FutureTask)localObject1).isCancelled())
      {
        localFutureTask2 = evy;
        localObject1 = localFutureTask2;
        if (localFutureTask2 == null)
        {
          s.bIx("futureTask");
          localObject1 = null;
        }
        if (!((FutureTask)localObject1).isDone())
        {
          localObject1 = evy;
          if (localObject1 == null)
          {
            s.bIx("futureTask");
            localObject1 = localObject2;
          }
          for (;;)
          {
            ((FutureTask)localObject1).cancel(true);
            AppMethodBeat.o(240824);
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.PluginCamera", "futureTask Exception");
      AppMethodBeat.o(240824);
    }
  }
  
  public static void qQ(int paramInt)
  {
    AppMethodBeat.i(240816);
    Log.i("MicroMsg.PluginCamera", s.X("updateBackCameraId ", Integer.valueOf(paramInt)));
    lQL = paramInt;
    AppMethodBeat.o(240816);
  }
  
  public static void qR(int paramInt)
  {
    AppMethodBeat.i(240818);
    Log.i("MicroMsg.PluginCamera", s.X("updateFrontCameraId ", Integer.valueOf(paramInt)));
    lQM = paramInt;
    AppMethodBeat.o(240818);
  }
  
  public final void aOq()
  {
    AppMethodBeat.i(240836);
    Log.i("MicroMsg.PluginCamera", "makeCameraInfoCache");
    for (;;)
    {
      try
      {
        int k = Camera.getNumberOfCameras();
        int j;
        Object localObject1;
        if (k > 0)
        {
          i = 0;
          j = i + 1;
          localObject1 = new Camera.CameraInfo();
          Camera.getCameraInfo(i, (Camera.CameraInfo)localObject1);
          lQK.add(localObject1);
          if ((lQL == -1) && (((Camera.CameraInfo)lQK.get(i)).facing == 0)) {
            lQL = i;
          }
          if ((lQM == -1) && (((Camera.CameraInfo)lQK.get(i)).facing == 1)) {
            lQM = i;
          }
          Log.i("MicroMsg.PluginCamera", "makeCameraInfoCache, id = " + i + ", facint = " + ((Camera.CameraInfo)localObject1).facing);
          if (j < k) {}
        }
        else
        {
          Log.i("MicroMsg.PluginCamera", "makeCameraInfoCache mBackCameraId = " + lQL + ", mFrontCameraId = " + lQM);
        }
        int i = j;
      }
      finally
      {
        try
        {
          localObject1 = ah.aiuX;
          return;
        }
        finally
        {
          AppMethodBeat.o(240836);
        }
        localObject2 = finally;
        Log.e("MicroMsg.PluginCamera", "makeCameraInfoCache failed : " + localObject2.getMessage() + ", clear cameraInfoList");
        lQK.clear();
      }
    }
  }
  
  public final int aOr()
  {
    AppMethodBeat.i(240842);
    Log.i("MicroMsg.PluginCamera", s.X("getBackCameraId mBackCameraId = ", Integer.valueOf(lQL)));
    if (lQL == -1) {
      aOq();
    }
    int i = lQL;
    AppMethodBeat.o(240842);
    return i;
  }
  
  public final int aOs()
  {
    AppMethodBeat.i(240845);
    Log.i("MicroMsg.PluginCamera", s.X("getBackCameraId mFrontCameraId = ", Integer.valueOf(lQM)));
    if (lQM == -1) {
      aOq();
    }
    int i = lQM;
    AppMethodBeat.o(240845);
    return i;
  }
  
  public final Camera.CameraInfo qP(int paramInt)
  {
    AppMethodBeat.i(240841);
    if (lQK.isEmpty())
    {
      Log.i("MicroMsg.PluginCamera", "cameraInfoList is empty, miss Cache, to make CameraInfo Cache");
      aOq();
    }
    Object localObject = lQK.get(paramInt);
    s.s(localObject, "cameraInfoList[id]");
    localObject = (Camera.CameraInfo)localObject;
    Log.i("MicroMsg.PluginCamera", s.X("getCameraInfo cameraInfoList.size = ", Integer.valueOf(lQK.size())));
    if (lQK.size() != 2)
    {
      localObject = new Camera.CameraInfo();
      Camera.getCameraInfo(paramInt, (Camera.CameraInfo)localObject);
      AppMethodBeat.o(240841);
      return localObject;
    }
    Log.i("MicroMsg.PluginCamera", "getCameraInfo id = " + paramInt + ", ret = " + localObject);
    AppMethodBeat.o(240841);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.c.a
 * JD-Core Version:    0.7.0.1
 */