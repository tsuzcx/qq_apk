package com.tencent.mm.media.widget.d;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.widget.b.c;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;
import d.n.n;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/util/CameraHelper;", "", "()V", "CAMERA_API_LEVEL1", "", "CAMERA_API_LEVEL2", "SCENE_APPBRAND", "SCENE_CHATTING", "SCENE_EMOJI", "SCENE_FAV", "SCENE_GAME", "SCENE_SNS", "SCENE_SNS_VLOG", "SCENE_STICK_PREVIEW", "SCENE_STORY", "SCENE_STORY_VLOG", "TAG", "", "cameraNum", "getCameraNum", "()I", "setCameraNum", "(I)V", "hasBackCamera", "", "getHasBackCamera", "()Z", "setHasBackCamera", "(Z)V", "hasFrontCamera", "getHasFrontCamera", "setHasFrontCamera", "checkSceneSupportRecordStream", "scene", "enableSwitchCamera", "hasBackCameraInThread", "hasFrontCameraInThread", "isCameraApi2CanUse", "isCaptureUseImageCallback", "isProcessCaptureUseImageCallback", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "cameraApiLevel", "isProcessUseCamera2", "isProcessUseCamera2RecordStream", "isProcessUseVideoStabilization", "isRenderscriptSupported", "isUseRecordStream", "isVendorCameraEffectSupported", "isVendorDebugModeSupported", "plugin-mediaeditor_release"})
public final class a
{
  private static boolean fEJ;
  private static boolean fEL;
  private static int hej;
  public static final a hek;
  
  static
  {
    AppMethodBeat.i(94381);
    hek = new a();
    hej = 2;
    fEJ = true;
    fEL = true;
    h.JZN.aS((Runnable)1.hel);
    AppMethodBeat.o(94381);
  }
  
  public static final boolean a(com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94375);
    d.g.b.k.h(parama, "process");
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
    boolean bool = avx();
    AppMethodBeat.o(94375);
    return bool;
  }
  
  public static final boolean auG()
  {
    AppMethodBeat.i(94380);
    if (hej > 1) {}
    for (;;)
    {
      int i;
      try
      {
        int m = hej;
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
        ac.printErrStackTrace("MicroMsg.CameraHelper", (Throwable)localException, " error", new Object[0]);
        AppMethodBeat.o(94380);
        return true;
      }
      AppMethodBeat.o(94380);
      return false;
      label120:
      i += 1;
    }
  }
  
  public static final boolean avA()
  {
    if ((ae.fJk != null) && (ae.fJk.fIc != -1)) {
      return ae.fJk.fIc == 1;
    }
    return false;
  }
  
  public static final boolean avB()
  {
    AppMethodBeat.i(94379);
    if ((ae.fJk != null) && (ae.fJk.fIe != -1))
    {
      if (ae.fJk.fIe == 1)
      {
        AppMethodBeat.o(94379);
        return true;
      }
      AppMethodBeat.o(94379);
      return false;
    }
    boolean bool = ((b)g.ab(b.class)).a(b.a.pSF, false);
    AppMethodBeat.o(94379);
    return bool;
  }
  
  public static final boolean avC()
  {
    if ((ae.fJk != null) && (ae.fJk.fIf != -1)) {
      return ae.fJk.fIf == 1;
    }
    return false;
  }
  
  public static final boolean avD()
  {
    return fEJ;
  }
  
  public static final boolean avE()
  {
    return fEL;
  }
  
  public static int avu()
  {
    return hej;
  }
  
  public static boolean avv()
  {
    return fEJ;
  }
  
  public static boolean avw()
  {
    return fEL;
  }
  
  private static boolean avx()
  {
    AppMethodBeat.i(94374);
    if ((ae.fJk != null) && (ae.fJk.fIa != -1)) {
      if (ae.fJk.fIa != 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if ((((b)g.ab(b.class)).a(b.a.pSA, 2) != 2) || (i == 0))
      {
        AppMethodBeat.o(94374);
        return false;
        if (ae.fJk.fIa == 1)
        {
          AppMethodBeat.o(94374);
          return true;
        }
        AppMethodBeat.o(94374);
        return false;
      }
      if (com.tencent.mm.compatible.util.d.la(21))
      {
        AppMethodBeat.o(94374);
        return false;
      }
      if (com.tencent.mm.compatible.util.k.YP())
      {
        AppMethodBeat.o(94374);
        return false;
      }
      if (com.tencent.mm.compatible.util.k.YQ())
      {
        AppMethodBeat.o(94374);
        return false;
      }
      Object localObject = ai.getContext().getSystemService("camera");
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
            d.g.b.k.fOy();
          }
          i = ((Number)localObject).intValue();
          switch (i)
          {
          }
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.CameraHelper", "a camera access exception happend");
          AppMethodBeat.o(94374);
          return false;
          c localc1 = c.gYy;
          c.atW();
          continue;
        }
        catch (AssertionError localAssertionError)
        {
          ac.e("MicroMsg.CameraHelper", "some device has some problem in LegecyCamera ");
          AppMethodBeat.o(94374);
          return false;
        }
        if ((i == 0) || (i == 2)) {
          break;
        }
        AppMethodBeat.o(94374);
        return true;
        localObject = c.gYy;
        c.atV();
        continue;
        c localc2 = c.gYy;
        c.atX();
        continue;
        localc2 = c.gYy;
        c.atY();
        continue;
        localc2 = c.gYy;
        c.atZ();
      }
      AppMethodBeat.o(94374);
      return false;
    }
  }
  
  public static final boolean avy()
  {
    AppMethodBeat.i(177321);
    if (((b)g.ab(b.class)).a(b.a.pSD, true))
    {
      AppMethodBeat.o(177321);
      return true;
    }
    AppMethodBeat.o(177321);
    return false;
  }
  
  public static final boolean avz()
  {
    AppMethodBeat.i(94378);
    if ((ae.fJk != null) && (ae.fJk.fId != -1))
    {
      if (ae.fJk.fId == 1)
      {
        AppMethodBeat.o(94378);
        return true;
      }
      AppMethodBeat.o(94378);
      return false;
    }
    boolean bool = ((b)g.ab(b.class)).a(b.a.pSE, false);
    AppMethodBeat.o(94378);
    return bool;
  }
  
  public static final boolean b(com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94376);
    d.g.b.k.h(parama, "process");
    if ((ae.fJk != null) && (ae.fJk.fIb != -1)) {
      if (ae.fJk.fIa != 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if (((b)g.ab(b.class)).a(b.a.pSC, false)) {
        i = 0;
      }
      while (i != 0)
      {
        i = parama.getRecordScene();
        parama = ((b)g.ab(b.class)).a(b.a.pSB, "");
        if (!bs.isNullOrNil(parama))
        {
          d.g.b.k.g(parama, "supportScene");
          if (n.a((CharSequence)parama, (CharSequence)String.valueOf(i), false))
          {
            ac.i("MicroMsg.CameraHelper", "the scene = " + i + " is support record stream ");
            AppMethodBeat.o(94376);
            return true;
            if (ae.fJk.fIa == 1)
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
    d.g.b.k.h(parama, "process");
    switch (parama.getRecordScene())
    {
    default: 
      AppMethodBeat.o(94377);
      return false;
    }
    if ((avz()) && (a(parama)) && (avx()))
    {
      AppMethodBeat.o(94377);
      return true;
    }
    AppMethodBeat.o(94377);
    return false;
  }
  
  public static void er(boolean paramBoolean)
  {
    fEJ = paramBoolean;
  }
  
  public static void es(boolean paramBoolean)
  {
    fEL = paramBoolean;
  }
  
  public static void nH(int paramInt)
  {
    hej = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.a
 * JD-Core Version:    0.7.0.1
 */