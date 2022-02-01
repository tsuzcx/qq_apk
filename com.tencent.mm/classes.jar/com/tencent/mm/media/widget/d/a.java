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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import d.n.n;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/util/CameraHelper;", "", "()V", "CAMERA_API_LEVEL1", "", "CAMERA_API_LEVEL2", "SCENE_APPBRAND", "SCENE_CHATTING", "SCENE_EMOJI", "SCENE_FAV", "SCENE_GAME", "SCENE_SNS", "SCENE_SNS_VLOG", "SCENE_STICK_PREVIEW", "SCENE_STORY", "SCENE_STORY_VLOG", "TAG", "", "cameraNum", "getCameraNum", "()I", "setCameraNum", "(I)V", "hasBackCamera", "", "getHasBackCamera", "()Z", "setHasBackCamera", "(Z)V", "hasFrontCamera", "getHasFrontCamera", "setHasFrontCamera", "checkSceneSupportRecordStream", "scene", "enableSwitchCamera", "hasBackCameraInThread", "hasFrontCameraInThread", "isCameraApi2CanUse", "isCaptureUseImageCallback", "isProcessCaptureUseImageCallback", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "cameraApiLevel", "isProcessUseCamera2", "isProcessUseCamera2RecordStream", "isProcessUseVideoStabilization", "isRenderscriptSupported", "isUseRecordStream", "isVendorCameraEffectSupported", "isVendorDebugModeSupported", "plugin-mediaeditor_release"})
public final class a
{
  private static boolean fBc;
  private static boolean fBe;
  private static int gDI;
  public static final a gDJ;
  
  static
  {
    AppMethodBeat.i(94381);
    gDJ = new a();
    gDI = 2;
    fBc = true;
    fBe = true;
    h.Iye.aP((Runnable)1.gDK);
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
    boolean bool = aoG();
    AppMethodBeat.o(94375);
    return bool;
  }
  
  public static final boolean anO()
  {
    AppMethodBeat.i(94380);
    if (gDI > 1) {}
    for (;;)
    {
      int i;
      try
      {
        int m = gDI;
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
        ad.printErrStackTrace("MicroMsg.CameraHelper", (Throwable)localException, " error", new Object[0]);
        AppMethodBeat.o(94380);
        return true;
      }
      AppMethodBeat.o(94380);
      return false;
      label120:
      i += 1;
    }
  }
  
  public static int aoD()
  {
    return gDI;
  }
  
  public static boolean aoE()
  {
    return fBc;
  }
  
  public static boolean aoF()
  {
    return fBe;
  }
  
  private static boolean aoG()
  {
    AppMethodBeat.i(94374);
    if ((ae.fFD != null) && (ae.fFD.fEt != -1)) {
      if (ae.fFD.fEt != 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if ((((b)g.ab(b.class)).a(b.a.poP, 2) != 2) || (i == 0))
      {
        AppMethodBeat.o(94374);
        return false;
        if (ae.fFD.fEt == 1)
        {
          AppMethodBeat.o(94374);
          return true;
        }
        AppMethodBeat.o(94374);
        return false;
      }
      if (com.tencent.mm.compatible.util.d.lg(21))
      {
        AppMethodBeat.o(94374);
        return false;
      }
      if (com.tencent.mm.compatible.util.k.XS())
      {
        AppMethodBeat.o(94374);
        return false;
      }
      if (com.tencent.mm.compatible.util.k.XT())
      {
        AppMethodBeat.o(94374);
        return false;
      }
      Object localObject = aj.getContext().getSystemService("camera");
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
            d.g.b.k.fvU();
          }
          i = ((Number)localObject).intValue();
          switch (i)
          {
          }
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.CameraHelper", "a camera access exception happend");
          AppMethodBeat.o(94374);
          return false;
          c localc1 = c.gya;
          c.and();
          continue;
        }
        catch (AssertionError localAssertionError)
        {
          ad.e("MicroMsg.CameraHelper", "some device has some problem in LegecyCamera ");
          AppMethodBeat.o(94374);
          return false;
        }
        if ((i == 0) || (i == 2)) {
          break;
        }
        AppMethodBeat.o(94374);
        return true;
        localObject = c.gya;
        c.anc();
        continue;
        c localc2 = c.gya;
        c.ane();
        continue;
        localc2 = c.gya;
        c.anf();
        continue;
        localc2 = c.gya;
        c.ang();
      }
      AppMethodBeat.o(94374);
      return false;
    }
  }
  
  public static final boolean aoH()
  {
    AppMethodBeat.i(177321);
    if (((b)g.ab(b.class)).a(b.a.poS, true))
    {
      AppMethodBeat.o(177321);
      return true;
    }
    AppMethodBeat.o(177321);
    return false;
  }
  
  public static final boolean aoI()
  {
    AppMethodBeat.i(94378);
    if ((ae.fFD != null) && (ae.fFD.fEw != -1))
    {
      if (ae.fFD.fEw == 1)
      {
        AppMethodBeat.o(94378);
        return true;
      }
      AppMethodBeat.o(94378);
      return false;
    }
    boolean bool = ((b)g.ab(b.class)).a(b.a.poT, false);
    AppMethodBeat.o(94378);
    return bool;
  }
  
  public static final boolean aoJ()
  {
    if ((ae.fFD != null) && (ae.fFD.fEv != -1)) {
      return ae.fFD.fEv == 1;
    }
    return false;
  }
  
  public static final boolean aoK()
  {
    AppMethodBeat.i(94379);
    if ((ae.fFD != null) && (ae.fFD.fEx != -1))
    {
      if (ae.fFD.fEx == 1)
      {
        AppMethodBeat.o(94379);
        return true;
      }
      AppMethodBeat.o(94379);
      return false;
    }
    boolean bool = ((b)g.ab(b.class)).a(b.a.poU, false);
    AppMethodBeat.o(94379);
    return bool;
  }
  
  public static final boolean aoL()
  {
    if ((ae.fFD != null) && (ae.fFD.fEy != -1)) {
      return ae.fFD.fEy == 1;
    }
    return false;
  }
  
  public static final boolean aoM()
  {
    return fBc;
  }
  
  public static final boolean aoN()
  {
    return fBe;
  }
  
  public static final boolean b(com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94376);
    d.g.b.k.h(parama, "process");
    if ((ae.fFD != null) && (ae.fFD.fEu != -1)) {
      if (ae.fFD.fEt != 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if (((b)g.ab(b.class)).a(b.a.poR, false)) {
        i = 0;
      }
      while (i != 0)
      {
        i = parama.getRecordScene();
        parama = ((b)g.ab(b.class)).a(b.a.poQ, "");
        if (!bt.isNullOrNil(parama))
        {
          d.g.b.k.g(parama, "supportScene");
          if (n.a((CharSequence)parama, (CharSequence)String.valueOf(i), false))
          {
            ad.i("MicroMsg.CameraHelper", "the scene = " + i + " is support record stream ");
            AppMethodBeat.o(94376);
            return true;
            if (ae.fFD.fEt == 1)
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
    if ((aoI()) && (a(parama)) && (aoG()))
    {
      AppMethodBeat.o(94377);
      return true;
    }
    AppMethodBeat.o(94377);
    return false;
  }
  
  public static void dW(boolean paramBoolean)
  {
    fBc = paramBoolean;
  }
  
  public static void dX(boolean paramBoolean)
  {
    fBe = paramBoolean;
  }
  
  public static void mT(int paramInt)
  {
    gDI = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.a
 * JD-Core Version:    0.7.0.1
 */