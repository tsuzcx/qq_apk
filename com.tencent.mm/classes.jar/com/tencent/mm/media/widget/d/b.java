package com.tencent.mm.media.widget.d;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.widget.camerarecordview.d.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/util/CameraHelper;", "", "()V", "CAMERA_API_LEVEL1", "", "CAMERA_API_LEVEL2", "DEFAULT_CAMERA2_SUPPORT_SENCE", "", "SCENE_APPBRAND", "SCENE_CHATTING", "SCENE_EMOJI", "SCENE_FAV", "SCENE_FINDER", "SCENE_GAME", "SCENE_SNS", "SCENE_SNS_VLOG", "SCENE_STICK_PREVIEW", "SCENE_STORY", "SCENE_STORY_VLOG", "SCENE_VOIP", "TAG", "", "cameraNum", "getCameraNum", "()I", "setCameraNum", "(I)V", "hasBackCamera", "", "getHasBackCamera", "()Z", "setHasBackCamera", "(Z)V", "hasFrontCamera", "getHasFrontCamera", "setHasFrontCamera", "checkSceneSupportRecordStream", "scene", "enableSwitchCamera", "hasBackCameraInThread", "hasFrontCameraInThread", "isCameraApi2CanUse", "isCaptureUseImageCallback", "isProcessAllowToResponseCamera2", "isProcessCaptureUseImageCallback", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "cameraApiLevel", "isProcessUseCamera2", "isProcessUseCamera2RecordStream", "isProcessUseVideoStabilization", "isRenderscriptSupported", "isUseRecordStream", "isVendorCameraEffectSupported", "isVendorDebugModeSupported", "plugin-mediaeditor_release"})
public final class b
{
  private static boolean gFF;
  private static boolean gFH;
  private static final int[] ith;
  private static int iti;
  public static final b itj;
  
  static
  {
    AppMethodBeat.i(94381);
    itj = new b();
    int[] arrayOfInt;
    if ((ae.gKA.gJi == 1) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
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
      arrayOfInt;
    }
    for (;;)
    {
      ith = arrayOfInt;
      iti = 2;
      gFF = true;
      gFH = true;
      h.RTc.aX((Runnable)1.itk);
      AppMethodBeat.o(94381);
      return;
      arrayOfInt = new int[6];
      arrayOfInt[0] = 2;
      arrayOfInt[1] = 1;
      arrayOfInt[2] = 3;
      arrayOfInt[3] = 8;
      arrayOfInt[4] = 10;
      arrayOfInt[5] = 12;
      arrayOfInt;
    }
  }
  
  public static final boolean a(a parama)
  {
    AppMethodBeat.i(94377);
    p.h(parama, "process");
    switch (parama.getRecordScene())
    {
    default: 
      AppMethodBeat.o(94377);
      return false;
    }
    if ((aRF()) && (rG(parama.getRecordScene())) && (aRD()))
    {
      AppMethodBeat.o(94377);
      return true;
    }
    AppMethodBeat.o(94377);
    return false;
  }
  
  public static final boolean aQg()
  {
    AppMethodBeat.i(94380);
    if (iti > 1) {}
    for (;;)
    {
      int i;
      try
      {
        int m = iti;
        i = 0;
        int j = 0;
        int k = 0;
        if (i < m)
        {
          Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
          Camera.getCameraInfo(i, localCameraInfo);
          if (localCameraInfo.facing == 1) {
            k = 1;
          }
          if (localCameraInfo.facing != 0) {
            break label120;
          }
          j = 1;
          break label120;
        }
        if ((k != 0) && (j != 0))
        {
          AppMethodBeat.o(94380);
          return true;
        }
        AppMethodBeat.o(94380);
        return false;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.CameraHelper", (Throwable)localException, " error", new Object[0]);
        AppMethodBeat.o(94380);
        return true;
      }
      AppMethodBeat.o(94380);
      return false;
      label120:
      i += 1;
    }
  }
  
  public static int aRA()
  {
    return iti;
  }
  
  public static boolean aRB()
  {
    return gFF;
  }
  
  public static boolean aRC()
  {
    return gFH;
  }
  
  private static boolean aRD()
  {
    AppMethodBeat.i(94374);
    if ((ae.gKA != null) && (ae.gKA.gJg != -1)) {
      if (ae.gKA.gJg != 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if ((((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXq, 2) != 2) || (i == 0))
      {
        AppMethodBeat.o(94374);
        return false;
        if (ae.gKA.gJg == 1)
        {
          AppMethodBeat.o(94374);
          return true;
        }
        AppMethodBeat.o(94374);
        return false;
      }
      if (com.tencent.mm.compatible.util.d.oE(21))
      {
        AppMethodBeat.o(94374);
        return false;
      }
      if (k.apw())
      {
        AppMethodBeat.o(94374);
        return false;
      }
      if (k.apx())
      {
        AppMethodBeat.o(94374);
        return false;
      }
      Object localObject = MMApplicationContext.getContext().getSystemService("camera");
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        AppMethodBeat.o(94374);
        throw ((Throwable)localObject);
      }
      localObject = (CameraManager)localObject;
      try
      {
        ((CameraManager)localObject).getCameraCharacteristics(localObject.getCameraIdList()[0]);
        localObject = ((CameraManager)localObject).getCameraCharacteristics("0").get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (localObject == null) {
          p.hyc();
        }
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
  
  public static final boolean aRE()
  {
    AppMethodBeat.i(177321);
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXu, true))
    {
      AppMethodBeat.o(177321);
      return true;
    }
    AppMethodBeat.o(177321);
    return false;
  }
  
  public static final boolean aRF()
  {
    AppMethodBeat.i(94378);
    if ((ae.gKA != null) && (ae.gKA.gJk != -1))
    {
      if (ae.gKA.gJk == 1)
      {
        AppMethodBeat.o(94378);
        return true;
      }
      AppMethodBeat.o(94378);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXv, false);
    AppMethodBeat.o(94378);
    return bool;
  }
  
  public static final boolean aRG()
  {
    if ((ae.gKA != null) && (ae.gKA.gJj != -1)) {
      return ae.gKA.gJj == 1;
    }
    return false;
  }
  
  public static final boolean aRH()
  {
    AppMethodBeat.i(94379);
    if ((ae.gKA != null) && (ae.gKA.gJl != -1))
    {
      if (ae.gKA.gJl == 1)
      {
        AppMethodBeat.o(94379);
        return true;
      }
      AppMethodBeat.o(94379);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXw, false);
    AppMethodBeat.o(94379);
    return bool;
  }
  
  public static final boolean aRI()
  {
    if ((ae.gKA != null) && (ae.gKA.gJm != -1)) {
      return ae.gKA.gJm == 1;
    }
    return false;
  }
  
  public static final boolean aRJ()
  {
    return gFF;
  }
  
  public static final boolean aRK()
  {
    return gFH;
  }
  
  public static void fl(boolean paramBoolean)
  {
    gFF = paramBoolean;
  }
  
  public static void fm(boolean paramBoolean)
  {
    gFH = paramBoolean;
  }
  
  public static void rF(int paramInt)
  {
    iti = paramInt;
  }
  
  public static final boolean rG(int paramInt)
  {
    AppMethodBeat.i(218939);
    String str = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXr, "");
    boolean bool;
    if (p.j(str, "")) {
      bool = e.contains(ith, paramInt);
    }
    while (bool)
    {
      bool = aRD();
      AppMethodBeat.o(218939);
      return bool;
      if (!Util.isNullOrNil(str))
      {
        p.g(str, "supportScene");
        if (n.a((CharSequence)str, (CharSequence)String.valueOf(paramInt), false))
        {
          bool = true;
          continue;
        }
      }
      bool = false;
    }
    AppMethodBeat.o(218939);
    return false;
  }
  
  public static final boolean rH(int paramInt)
  {
    AppMethodBeat.i(218940);
    if ((ae.gKA != null) && (ae.gKA.gJh != -1)) {
      if (ae.gKA.gJg != 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXt, false)) {
        i = 0;
      }
      while (i != 0)
      {
        String str = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXs, "");
        if (!Util.isNullOrNil(str))
        {
          p.g(str, "supportScene");
          if (n.a((CharSequence)str, (CharSequence)String.valueOf(paramInt), false))
          {
            Log.i("MicroMsg.CameraHelper", "the scene = " + paramInt + " is support record stream ");
            AppMethodBeat.o(218940);
            return true;
            if (ae.gKA.gJg == 1)
            {
              i = 1;
              continue;
            }
            i = 0;
            continue;
          }
        }
        AppMethodBeat.o(218940);
        return false;
      }
      AppMethodBeat.o(218940);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.b
 * JD-Core Version:    0.7.0.1
 */