package com.tencent.mm.media.widget.d;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.widget.b.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/util/CameraHelper;", "", "()V", "CAMERA_API_LEVEL1", "", "CAMERA_API_LEVEL2", "SCENE_APPBRAND", "SCENE_CHATTING", "SCENE_EMOJI", "SCENE_FAV", "SCENE_GAME", "SCENE_SNS", "SCENE_SNS_VLOG", "SCENE_STICK_PREVIEW", "SCENE_STORY", "SCENE_STORY_VLOG", "TAG", "", "cameraNum", "getCameraNum", "()I", "setCameraNum", "(I)V", "hasBackCamera", "", "getHasBackCamera", "()Z", "setHasBackCamera", "(Z)V", "hasFrontCamera", "getHasFrontCamera", "setHasFrontCamera", "checkSceneSupportRecordStream", "scene", "enableSwitchCamera", "hasBackCameraInThread", "hasFrontCameraInThread", "isCameraApi2CanUse", "isCaptureUseImageCallback", "isProcessCaptureUseImageCallback", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "cameraApiLevel", "isProcessUseCamera2", "isProcessUseCamera2RecordStream", "isProcessUseVideoStabilization", "isRenderscriptSupported", "isUseRecordStream", "isVendorCameraEffectSupported", "isVendorDebugModeSupported", "plugin-mediaeditor_release"})
public final class a
{
  private static boolean gao;
  private static boolean gar;
  private static int hzf;
  public static final a hzg;
  
  static
  {
    AppMethodBeat.i(94381);
    hzg = new a();
    hzf = 2;
    gao = true;
    gar = true;
    h.MqF.aO((Runnable)1.hzh);
    AppMethodBeat.o(94381);
  }
  
  public static final boolean a(com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94375);
    p.h(parama, "process");
    switch (parama.getRecordScene())
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 9: 
    default: 
      AppMethodBeat.o(94375);
      return false;
    }
    boolean bool = ayz();
    AppMethodBeat.o(94375);
    return bool;
  }
  
  public static final boolean axI()
  {
    AppMethodBeat.i(94380);
    if (hzf > 1) {}
    for (;;)
    {
      int i;
      try
      {
        int m = hzf;
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
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.CameraHelper", (Throwable)localException, " error", new Object[0]);
        AppMethodBeat.o(94380);
        return true;
      }
      AppMethodBeat.o(94380);
      return false;
      label120:
      i += 1;
    }
  }
  
  public static final boolean ayA()
  {
    AppMethodBeat.i(177321);
    if (((b)g.ab(b.class)).a(b.a.qEn, true))
    {
      AppMethodBeat.o(177321);
      return true;
    }
    AppMethodBeat.o(177321);
    return false;
  }
  
  public static final boolean ayB()
  {
    AppMethodBeat.i(94378);
    if ((com.tencent.mm.compatible.deviceinfo.ae.geT != null) && (com.tencent.mm.compatible.deviceinfo.ae.geT.gdL != -1))
    {
      if (com.tencent.mm.compatible.deviceinfo.ae.geT.gdL == 1)
      {
        AppMethodBeat.o(94378);
        return true;
      }
      AppMethodBeat.o(94378);
      return false;
    }
    boolean bool = ((b)g.ab(b.class)).a(b.a.qEo, false);
    AppMethodBeat.o(94378);
    return bool;
  }
  
  public static final boolean ayC()
  {
    if ((com.tencent.mm.compatible.deviceinfo.ae.geT != null) && (com.tencent.mm.compatible.deviceinfo.ae.geT.gdK != -1)) {
      return com.tencent.mm.compatible.deviceinfo.ae.geT.gdK == 1;
    }
    return false;
  }
  
  public static final boolean ayD()
  {
    AppMethodBeat.i(94379);
    if ((com.tencent.mm.compatible.deviceinfo.ae.geT != null) && (com.tencent.mm.compatible.deviceinfo.ae.geT.gdM != -1))
    {
      if (com.tencent.mm.compatible.deviceinfo.ae.geT.gdM == 1)
      {
        AppMethodBeat.o(94379);
        return true;
      }
      AppMethodBeat.o(94379);
      return false;
    }
    boolean bool = ((b)g.ab(b.class)).a(b.a.qEp, false);
    AppMethodBeat.o(94379);
    return bool;
  }
  
  public static final boolean ayE()
  {
    if ((com.tencent.mm.compatible.deviceinfo.ae.geT != null) && (com.tencent.mm.compatible.deviceinfo.ae.geT.gdN != -1)) {
      return com.tencent.mm.compatible.deviceinfo.ae.geT.gdN == 1;
    }
    return false;
  }
  
  public static final boolean ayF()
  {
    return gao;
  }
  
  public static final boolean ayG()
  {
    return gar;
  }
  
  public static int ayw()
  {
    return hzf;
  }
  
  public static boolean ayx()
  {
    return gao;
  }
  
  public static boolean ayy()
  {
    return gar;
  }
  
  private static boolean ayz()
  {
    AppMethodBeat.i(94374);
    if ((com.tencent.mm.compatible.deviceinfo.ae.geT != null) && (com.tencent.mm.compatible.deviceinfo.ae.geT.gdI != -1)) {
      if (com.tencent.mm.compatible.deviceinfo.ae.geT.gdI != 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if ((((b)g.ab(b.class)).a(b.a.qEk, 2) != 2) || (i == 0))
      {
        AppMethodBeat.o(94374);
        return false;
        if (com.tencent.mm.compatible.deviceinfo.ae.geT.gdI == 1)
        {
          AppMethodBeat.o(94374);
          return true;
        }
        AppMethodBeat.o(94374);
        return false;
      }
      if (com.tencent.mm.compatible.util.d.lB(21))
      {
        AppMethodBeat.o(94374);
        return false;
      }
      if (k.abz())
      {
        AppMethodBeat.o(94374);
        return false;
      }
      if (k.abA())
      {
        AppMethodBeat.o(94374);
        return false;
      }
      Object localObject = ak.getContext().getSystemService("camera");
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        AppMethodBeat.o(94374);
        throw ((Throwable)localObject);
      }
      localObject = (CameraManager)localObject;
      for (;;)
      {
        try
        {
          ((CameraManager)localObject).getCameraCharacteristics(localObject.getCameraIdList()[0]);
          localObject = ((CameraManager)localObject).getCameraCharacteristics("0").get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
          if (localObject == null) {
            p.gkB();
          }
          i = ((Number)localObject).intValue();
          switch (i)
          {
          }
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CameraHelper", "a camera access exception happend");
          AppMethodBeat.o(94374);
          return false;
          c localc1 = c.hts;
          c.awY();
          continue;
        }
        catch (AssertionError localAssertionError)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CameraHelper", "some device has some problem in LegecyCamera ");
          AppMethodBeat.o(94374);
          return false;
        }
        if ((i == 0) || (i == 2)) {
          break;
        }
        AppMethodBeat.o(94374);
        return true;
        localObject = c.hts;
        c.awX();
        continue;
        c localc2 = c.hts;
        c.awZ();
        continue;
        localc2 = c.hts;
        c.axa();
        continue;
        localc2 = c.hts;
        c.axb();
      }
      AppMethodBeat.o(94374);
      return false;
    }
  }
  
  public static final boolean b(com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94376);
    p.h(parama, "process");
    if ((com.tencent.mm.compatible.deviceinfo.ae.geT != null) && (com.tencent.mm.compatible.deviceinfo.ae.geT.gdJ != -1)) {
      if (com.tencent.mm.compatible.deviceinfo.ae.geT.gdI != 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if (((b)g.ab(b.class)).a(b.a.qEm, false)) {
        i = 0;
      }
      while (i != 0)
      {
        i = parama.getRecordScene();
        parama = ((b)g.ab(b.class)).a(b.a.qEl, "");
        if (!bu.isNullOrNil(parama))
        {
          p.g(parama, "supportScene");
          if (n.a((CharSequence)parama, (CharSequence)String.valueOf(i), false))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CameraHelper", "the scene = " + i + " is support record stream ");
            AppMethodBeat.o(94376);
            return true;
            if (com.tencent.mm.compatible.deviceinfo.ae.geT.gdI == 1)
            {
              i = 1;
              continue;
            }
            i = 0;
            continue;
          }
        }
        AppMethodBeat.o(94376);
        return false;
      }
      AppMethodBeat.o(94376);
      return false;
    }
  }
  
  public static final boolean c(com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94377);
    p.h(parama, "process");
    switch (parama.getRecordScene())
    {
    default: 
      AppMethodBeat.o(94377);
      return false;
    }
    if ((ayB()) && (a(parama)) && (ayz()))
    {
      AppMethodBeat.o(94377);
      return true;
    }
    AppMethodBeat.o(94377);
    return false;
  }
  
  public static void ev(boolean paramBoolean)
  {
    gao = paramBoolean;
  }
  
  public static void ew(boolean paramBoolean)
  {
    gar = paramBoolean;
  }
  
  public static void oj(int paramInt)
  {
    hzf = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.a
 * JD-Core Version:    0.7.0.1
 */