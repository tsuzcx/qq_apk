package com.tencent.mm.media.widget.d;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.media.widget.camerarecordview.d.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.b.a;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/util/CameraHelper;", "", "()V", "CAMERA_API_LEVEL1", "", "CAMERA_API_LEVEL2", "DEFAULT_CAMERA2_SUPPORT_SENCE", "", "SCENE_APPBRAND", "SCENE_CHATTING", "SCENE_EMOJI", "SCENE_FAV", "SCENE_FINDER", "SCENE_GAME", "SCENE_SNS", "SCENE_SNS_VLOG", "SCENE_STICK_PREVIEW", "SCENE_STORY", "SCENE_STORY_VLOG", "SCENE_VOIP", "TAG", "", "cameraNum", "getCameraNum", "()I", "setCameraNum", "(I)V", "hasBackCamera", "", "getHasBackCamera", "()Z", "setHasBackCamera", "(Z)V", "hasFrontCamera", "getHasFrontCamera", "setHasFrontCamera", "checkSceneSupportRecordStream", "scene", "enableSwitchCamera", "getRemoteConfigCameraMirror", "isCameraFront", "getRemoteConfigCameraRotate", "defaultAngle", "hasBackCameraInThread", "hasFrontCameraInThread", "isCameraApi2CanUse", "isCaptureUseImageCallback", "isProcessAllowToResponseCamera2", "isProcessCaptureUseImageCallback", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "cameraApiLevel", "isProcessUseCamera2", "(Ljava/lang/Integer;)Z", "isProcessUseCamera2RecordStream", "isProcessUseVideoStabilization", "isRenderscriptSupported", "isUseRecordStream", "isVendorCameraEffectSupported", "isVendorDebugModeSupported", "parseCameraConfig", "Lcom/tencent/mm/json/JSONObject;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static boolean lSW;
  private static boolean lSY;
  public static final c nMY;
  private static final int[] nMZ;
  private static int nNa;
  
  static
  {
    AppMethodBeat.i(94381);
    nMY = new c();
    int[] arrayOfInt;
    if ((af.lYf.lWR == 1) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
    {
      arrayOfInt = new int[12];
      arrayOfInt[0] = 1;
      arrayOfInt[1] = 2;
      arrayOfInt[2] = 3;
      arrayOfInt[3] = 4;
      arrayOfInt[4] = 5;
      arrayOfInt[5] = 6;
      arrayOfInt[6] = 7;
      arrayOfInt[7] = 8;
      arrayOfInt[8] = 9;
      arrayOfInt[9] = 10;
      arrayOfInt[10] = 11;
      arrayOfInt[11] = 12;
    }
    for (;;)
    {
      nMZ = arrayOfInt;
      nNa = 2;
      lSW = true;
      lSY = true;
      com.tencent.threadpool.h.ahAA.bm(c..ExternalSyntheticLambda0.INSTANCE);
      AppMethodBeat.o(94381);
      return;
      arrayOfInt = new int[6];
      arrayOfInt[0] = 2;
      arrayOfInt[1] = 1;
      arrayOfInt[2] = 3;
      arrayOfInt[3] = 8;
      arrayOfInt[4] = 10;
      arrayOfInt[5] = 12;
    }
  }
  
  public static final boolean b(a parama)
  {
    AppMethodBeat.i(94377);
    s.u(parama, "process");
    int j = parama.getRecordScene();
    int i;
    if (j == 2)
    {
      i = 1;
      if (i == 0) {
        break label84;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if ((bvt()) && (f(Integer.valueOf(parama.getRecordScene()))) && (bvr()))
        {
          AppMethodBeat.o(94377);
          return true;
          if (j == 1)
          {
            i = 1;
            break;
          }
          i = 0;
          break;
          label84:
          if (j == 9)
          {
            i = 1;
            continue;
          }
          i = 0;
          continue;
        }
        AppMethodBeat.o(94377);
        return false;
      }
    }
    AppMethodBeat.o(94377);
    return false;
  }
  
  public static final boolean bod()
  {
    return lSW;
  }
  
  public static final boolean boe()
  {
    return lSY;
  }
  
  public static final boolean btW()
  {
    AppMethodBeat.i(94380);
    if (nNa > 1) {}
    for (;;)
    {
      int n;
      int k;
      int j;
      int i;
      int m;
      try
      {
        n = nNa;
        if (n <= 0) {
          break label130;
        }
        k = 0;
        j = 0;
        i = 0;
        m = k + 1;
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(k, localCameraInfo);
        if (localCameraInfo.facing == 1) {
          i = 1;
        }
        if (localCameraInfo.facing != 0) {
          break label137;
        }
        j = 1;
      }
      catch (Exception localException)
      {
        label71:
        Log.printErrStackTrace("MicroMsg.CameraHelper", (Throwable)localException, " error", new Object[0]);
        AppMethodBeat.o(94380);
        return true;
      }
      if ((i != 0) && (j != 0))
      {
        AppMethodBeat.o(94380);
        return true;
      }
      AppMethodBeat.o(94380);
      return false;
      AppMethodBeat.o(94380);
      return false;
      label130:
      label137:
      do
      {
        k = m;
        break;
        j = 0;
        i = 0;
        break label71;
      } while (m < n);
    }
  }
  
  private static boolean bvr()
  {
    AppMethodBeat.i(94374);
    if ((af.lYf != null) && (af.lYf.lWP != -1)) {
      if (af.lYf.lWP != 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTp, 2) != 2) || (i == 0))
      {
        AppMethodBeat.o(94374);
        return false;
        if (af.lYf.lWP == 1)
        {
          AppMethodBeat.o(94374);
          return true;
        }
        AppMethodBeat.o(94374);
        return false;
      }
      if (com.tencent.mm.compatible.util.d.rc(21))
      {
        AppMethodBeat.o(94374);
        return false;
      }
      if (Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("HMD Global".toLowerCase()))
      {
        AppMethodBeat.o(94374);
        return false;
      }
      if (Util.nullAs(Build.MANUFACTURER, "").toLowerCase().contains("smartisan".toLowerCase()))
      {
        AppMethodBeat.o(94374);
        return false;
      }
      Object localObject = MMApplicationContext.getContext().getSystemService("camera");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        AppMethodBeat.o(94374);
        throw ((Throwable)localObject);
      }
      localObject = (CameraManager)localObject;
      try
      {
        ((CameraManager)localObject).getCameraCharacteristics(localObject.getCameraIdList()[0]);
        localObject = ((CameraManager)localObject).getCameraCharacteristics("0").get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        s.checkNotNull(localObject);
        s.s(localObject, "manager.getCameraCharact…PPORTED_HARDWARE_LEVEL)!!");
        i = ((Number)localObject).intValue();
        if ((i != 0) && (i != 2))
        {
          AppMethodBeat.o(94374);
          return true;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.CameraHelper", "a camera access exception happend");
        AppMethodBeat.o(94374);
        return false;
      }
      catch (AssertionError localAssertionError)
      {
        Log.e("MicroMsg.CameraHelper", "some device has some problem in LegecyCamera ");
        AppMethodBeat.o(94374);
        return false;
      }
      AppMethodBeat.o(94374);
      return false;
    }
  }
  
  public static final boolean bvs()
  {
    AppMethodBeat.i(177321);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTt, true))
    {
      AppMethodBeat.o(177321);
      return true;
    }
    AppMethodBeat.o(177321);
    return false;
  }
  
  public static final boolean bvt()
  {
    AppMethodBeat.i(94378);
    if ((af.lYf != null) && (af.lYf.lWT != -1))
    {
      if (af.lYf.lWT == 1)
      {
        AppMethodBeat.o(94378);
        return true;
      }
      AppMethodBeat.o(94378);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTu, false);
    AppMethodBeat.o(94378);
    return bool;
  }
  
  public static final boolean bvu()
  {
    if ((af.lYf != null) && (af.lYf.lWS != -1)) {
      return af.lYf.lWS == 1;
    }
    return false;
  }
  
  public static final boolean bvv()
  {
    AppMethodBeat.i(94379);
    if ((af.lYf != null) && (af.lYf.lWU != -1))
    {
      if (af.lYf.lWU == 1)
      {
        AppMethodBeat.o(94379);
        return true;
      }
      AppMethodBeat.o(94379);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTv, false);
    AppMethodBeat.o(94379);
    return bool;
  }
  
  public static final boolean bvw()
  {
    if ((af.lYf != null) && (af.lYf.lWV != -1)) {
      return af.lYf.lWV == 1;
    }
    return false;
  }
  
  private static final boolean bvx()
  {
    AppMethodBeat.i(237588);
    int k = nNa;
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(i, localCameraInfo);
      if (localCameraInfo.facing == 0)
      {
        AppMethodBeat.o(237588);
        return true;
      }
      if (j >= k)
      {
        AppMethodBeat.o(237588);
        return false;
      }
    }
  }
  
  private static final void bvy()
  {
    boolean bool2 = false;
    AppMethodBeat.i(237592);
    try
    {
      nNa = com.tencent.mm.compatible.deviceinfo.d.aOG();
      int k = nNa;
      boolean bool1 = bool2;
      if (k > 0) {}
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 1;
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, localCameraInfo);
        if (localCameraInfo.facing == 1) {
          bool1 = true;
        }
        do
        {
          lSW = bool1;
          lSY = bvx();
          Log.i("MicroMsg.CameraHelper", "cameraNum : " + nNa + " hasFrontCamera:" + lSW + " hasBackCamera:" + lSY);
          AppMethodBeat.o(237592);
          return;
          bool1 = bool2;
        } while (j >= k);
      }
      return;
    }
    catch (Exception localException)
    {
      Log.i("MicroMsg.CameraHelper", "happen sth. error");
      AppMethodBeat.o(237592);
    }
  }
  
  public static final boolean f(Integer paramInteger)
  {
    boolean bool = true;
    AppMethodBeat.i(237526);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    if (com.tencent.mm.util.i.a(b.a.agqv, 0) == 1)
    {
      AppMethodBeat.o(237526);
      return true;
    }
    if (paramInteger != null)
    {
      int i = paramInteger.intValue();
      paramInteger = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTq, "");
      if (s.p(paramInteger, "")) {
        bool = k.contains(nMZ, i);
      }
      while (bool)
      {
        bool = bvr();
        AppMethodBeat.o(237526);
        return bool;
        if (!Util.isNullOrNil(paramInteger))
        {
          s.s(paramInteger, "supportScene");
          if (n.a((CharSequence)paramInteger, (CharSequence)String.valueOf(i), false)) {}
        }
        else
        {
          bool = false;
        }
      }
    }
    AppMethodBeat.o(237526);
    return false;
  }
  
  public static final boolean uz(int paramInt)
  {
    AppMethodBeat.i(237533);
    if ((af.lYf != null) && (af.lYf.lWQ != -1)) {
      if (af.lYf.lWP != 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTs, false)) {
        i = 0;
      }
      while (i != 0)
      {
        String str = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTr, "");
        if (!Util.isNullOrNil(str))
        {
          s.s(str, "supportScene");
          if (n.a((CharSequence)str, (CharSequence)String.valueOf(paramInt), false))
          {
            Log.i("MicroMsg.CameraHelper", "the scene = " + paramInt + " is support record stream ");
            AppMethodBeat.o(237533);
            return true;
            if (af.lYf.lWP == 1)
            {
              i = 1;
              continue;
            }
            i = 0;
            continue;
          }
        }
        AppMethodBeat.o(237533);
        return false;
      }
      AppMethodBeat.o(237533);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.c
 * JD-Core Version:    0.7.0.1
 */