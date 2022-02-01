package com.tencent.mm.media.widget.d;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.media.widget.camerarecordview.d.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/util/CameraHelper;", "", "()V", "CAMERA_API_LEVEL1", "", "CAMERA_API_LEVEL2", "DEFAULT_CAMERA2_SUPPORT_SENCE", "", "SCENE_APPBRAND", "SCENE_CHATTING", "SCENE_EMOJI", "SCENE_FAV", "SCENE_FINDER", "SCENE_GAME", "SCENE_SNS", "SCENE_SNS_VLOG", "SCENE_STICK_PREVIEW", "SCENE_STORY", "SCENE_STORY_VLOG", "SCENE_VOIP", "TAG", "", "cameraNum", "getCameraNum", "()I", "setCameraNum", "(I)V", "hasBackCamera", "", "getHasBackCamera", "()Z", "setHasBackCamera", "(Z)V", "hasFrontCamera", "getHasFrontCamera", "setHasFrontCamera", "checkSceneSupportRecordStream", "scene", "enableSwitchCamera", "hasBackCameraInThread", "hasFrontCameraInThread", "isCameraApi2CanUse", "isCaptureUseImageCallback", "isProcessAllowToResponseCamera2", "isProcessCaptureUseImageCallback", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "cameraApiLevel", "isProcessUseCamera2", "(Ljava/lang/Integer;)Z", "isProcessUseCamera2RecordStream", "isProcessUseVideoStabilization", "isRenderscriptSupported", "isUseRecordStream", "isVendorCameraEffectSupported", "isVendorDebugModeSupported", "plugin-mediaeditor_release"})
public final class c
{
  private static boolean jpP;
  private static boolean jpR;
  private static final int[] lip;
  private static int liq;
  public static final c lir;
  
  static
  {
    AppMethodBeat.i(94381);
    lir = new c();
    int[] arrayOfInt;
    if ((af.juO.jtA == 1) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
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
      lip = arrayOfInt;
      liq = 2;
      jpP = true;
      jpR = true;
      com.tencent.e.h.ZvG.be((Runnable)1.lis);
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
    p.k(parama, "process");
    switch (parama.getRecordScene())
    {
    default: 
      AppMethodBeat.o(94377);
      return false;
    }
    if ((baz()) && (f(Integer.valueOf(parama.getRecordScene()))) && (bax()))
    {
      AppMethodBeat.o(94377);
      return true;
    }
    AppMethodBeat.o(94377);
    return false;
  }
  
  public static final boolean aYX()
  {
    AppMethodBeat.i(94380);
    if (liq > 1) {}
    for (;;)
    {
      int i;
      try
      {
        int m = liq;
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
  
  public static final boolean baA()
  {
    if ((af.juO != null) && (af.juO.jtB != -1)) {
      return af.juO.jtB == 1;
    }
    return false;
  }
  
  public static final boolean baB()
  {
    AppMethodBeat.i(94379);
    if ((af.juO != null) && (af.juO.jtD != -1))
    {
      if (af.juO.jtD == 1)
      {
        AppMethodBeat.o(94379);
        return true;
      }
      AppMethodBeat.o(94379);
      return false;
    }
    boolean bool = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vEo, false);
    AppMethodBeat.o(94379);
    return bool;
  }
  
  public static final boolean baC()
  {
    if ((af.juO != null) && (af.juO.jtE != -1)) {
      return af.juO.jtE == 1;
    }
    return false;
  }
  
  public static final boolean baD()
  {
    return jpP;
  }
  
  public static final boolean baE()
  {
    return jpR;
  }
  
  public static int bau()
  {
    return liq;
  }
  
  public static boolean bav()
  {
    return jpP;
  }
  
  public static boolean baw()
  {
    return jpR;
  }
  
  private static boolean bax()
  {
    AppMethodBeat.i(94374);
    if ((af.juO != null) && (af.juO.jty != -1)) {
      if (af.juO.jty != 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if ((((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vEi, 2) != 2) || (i == 0))
      {
        AppMethodBeat.o(94374);
        return false;
        if (af.juO.jty == 1)
        {
          AppMethodBeat.o(94374);
          return true;
        }
        AppMethodBeat.o(94374);
        return false;
      }
      if (com.tencent.mm.compatible.util.d.qW(21))
      {
        AppMethodBeat.o(94374);
        return false;
      }
      if (k.avO())
      {
        AppMethodBeat.o(94374);
        return false;
      }
      if (k.avP())
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
          p.iCn();
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
  
  public static final boolean bay()
  {
    AppMethodBeat.i(177321);
    if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vEm, true))
    {
      AppMethodBeat.o(177321);
      return true;
    }
    AppMethodBeat.o(177321);
    return false;
  }
  
  public static final boolean baz()
  {
    AppMethodBeat.i(94378);
    if ((af.juO != null) && (af.juO.jtC != -1))
    {
      if (af.juO.jtC == 1)
      {
        AppMethodBeat.o(94378);
        return true;
      }
      AppMethodBeat.o(94378);
      return false;
    }
    boolean bool = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vEn, false);
    AppMethodBeat.o(94378);
    return bool;
  }
  
  public static final boolean f(Integer paramInteger)
  {
    boolean bool = true;
    AppMethodBeat.i(258541);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.YyX;
    if (com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.YxM, 0) == 1)
    {
      AppMethodBeat.o(258541);
      return true;
    }
    if (paramInteger != null)
    {
      int i = paramInteger.intValue();
      paramInteger = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vEj, "");
      if (p.h(paramInteger, "")) {
        bool = e.contains(lip, i);
      }
      while (bool)
      {
        bool = bax();
        AppMethodBeat.o(258541);
        return bool;
        if (!Util.isNullOrNil(paramInteger))
        {
          p.j(paramInteger, "supportScene");
          if (n.a((CharSequence)paramInteger, (CharSequence)String.valueOf(i), false)) {}
        }
        else
        {
          bool = false;
        }
      }
    }
    AppMethodBeat.o(258541);
    return false;
  }
  
  public static void fV(boolean paramBoolean)
  {
    jpP = paramBoolean;
  }
  
  public static void fW(boolean paramBoolean)
  {
    jpR = paramBoolean;
  }
  
  public static final boolean uA(int paramInt)
  {
    AppMethodBeat.i(258543);
    if ((af.juO != null) && (af.juO.jtz != -1)) {
      if (af.juO.jty != 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vEl, false)) {
        i = 0;
      }
      while (i != 0)
      {
        String str = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vEk, "");
        if (!Util.isNullOrNil(str))
        {
          p.j(str, "supportScene");
          if (n.a((CharSequence)str, (CharSequence)String.valueOf(paramInt), false))
          {
            Log.i("MicroMsg.CameraHelper", "the scene = " + paramInt + " is support record stream ");
            AppMethodBeat.o(258543);
            return true;
            if (af.juO.jty == 1)
            {
              i = 1;
              continue;
            }
            i = 0;
            continue;
          }
        }
        AppMethodBeat.o(258543);
        return false;
      }
      AppMethodBeat.o(258543);
      return false;
    }
  }
  
  public static void uz(int paramInt)
  {
    liq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.c
 * JD-Core Version:    0.7.0.1
 */