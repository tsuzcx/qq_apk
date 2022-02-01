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
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.widget.b.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/util/CameraHelper;", "", "()V", "CAMERA_API_LEVEL1", "", "CAMERA_API_LEVEL2", "SCENE_APPBRAND", "SCENE_CHATTING", "SCENE_EMOJI", "SCENE_FAV", "SCENE_GAME", "SCENE_SNS", "SCENE_SNS_VLOG", "SCENE_STICK_PREVIEW", "SCENE_STORY", "SCENE_STORY_VLOG", "TAG", "", "cameraNum", "getCameraNum", "()I", "setCameraNum", "(I)V", "hasBackCamera", "", "getHasBackCamera", "()Z", "setHasBackCamera", "(Z)V", "hasFrontCamera", "getHasFrontCamera", "setHasFrontCamera", "checkSceneSupportRecordStream", "scene", "enableSwitchCamera", "hasBackCameraInThread", "hasFrontCameraInThread", "isCameraApi2CanUse", "isCaptureUseImageCallback", "isProcessCaptureUseImageCallback", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "cameraApiLevel", "isProcessUseCamera2", "isProcessUseCamera2RecordStream", "isProcessUseVideoStabilization", "isRenderscriptSupported", "isUseRecordStream", "isVendorCameraEffectSupported", "isVendorDebugModeSupported", "plugin-mediaeditor_release"})
public final class a
{
  private static boolean fYi;
  private static boolean fYk;
  private static int hwr;
  public static final a hws;
  
  static
  {
    AppMethodBeat.i(94381);
    hws = new a();
    hwr = 2;
    fYi = true;
    fYk = true;
    h.LTJ.aR((Runnable)1.hwt);
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
    boolean bool = ayk();
    AppMethodBeat.o(94375);
    return bool;
  }
  
  public static final boolean axt()
  {
    AppMethodBeat.i(94380);
    if (hwr > 1) {}
    for (;;)
    {
      int i;
      try
      {
        int m = hwr;
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
  
  public static int ayh()
  {
    return hwr;
  }
  
  public static boolean ayi()
  {
    return fYi;
  }
  
  public static boolean ayj()
  {
    return fYk;
  }
  
  private static boolean ayk()
  {
    AppMethodBeat.i(94374);
    if ((ae.gcL != null) && (ae.gcL.gbA != -1)) {
      if (ae.gcL.gbA != 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if ((((b)g.ab(b.class)).a(b.a.qxe, 2) != 2) || (i == 0))
      {
        AppMethodBeat.o(94374);
        return false;
        if (ae.gcL.gbA == 1)
        {
          AppMethodBeat.o(94374);
          return true;
        }
        AppMethodBeat.o(94374);
        return false;
      }
      if (com.tencent.mm.compatible.util.d.lz(21))
      {
        AppMethodBeat.o(94374);
        return false;
      }
      if (k.abq())
      {
        AppMethodBeat.o(94374);
        return false;
      }
      if (k.abr())
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
            p.gfZ();
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
          c localc1 = c.hqE;
          c.awJ();
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
        localObject = c.hqE;
        c.awI();
        continue;
        c localc2 = c.hqE;
        c.awK();
        continue;
        localc2 = c.hqE;
        c.awL();
        continue;
        localc2 = c.hqE;
        c.awM();
      }
      AppMethodBeat.o(94374);
      return false;
    }
  }
  
  public static final boolean ayl()
  {
    AppMethodBeat.i(177321);
    if (((b)g.ab(b.class)).a(b.a.qxh, true))
    {
      AppMethodBeat.o(177321);
      return true;
    }
    AppMethodBeat.o(177321);
    return false;
  }
  
  public static final boolean aym()
  {
    AppMethodBeat.i(94378);
    if ((ae.gcL != null) && (ae.gcL.gbD != -1))
    {
      if (ae.gcL.gbD == 1)
      {
        AppMethodBeat.o(94378);
        return true;
      }
      AppMethodBeat.o(94378);
      return false;
    }
    boolean bool = ((b)g.ab(b.class)).a(b.a.qxi, false);
    AppMethodBeat.o(94378);
    return bool;
  }
  
  public static final boolean ayn()
  {
    if ((ae.gcL != null) && (ae.gcL.gbC != -1)) {
      return ae.gcL.gbC == 1;
    }
    return false;
  }
  
  public static final boolean ayo()
  {
    AppMethodBeat.i(94379);
    if ((ae.gcL != null) && (ae.gcL.gbE != -1))
    {
      if (ae.gcL.gbE == 1)
      {
        AppMethodBeat.o(94379);
        return true;
      }
      AppMethodBeat.o(94379);
      return false;
    }
    boolean bool = ((b)g.ab(b.class)).a(b.a.qxj, false);
    AppMethodBeat.o(94379);
    return bool;
  }
  
  public static final boolean ayp()
  {
    if ((ae.gcL != null) && (ae.gcL.gbF != -1)) {
      return ae.gcL.gbF == 1;
    }
    return false;
  }
  
  public static final boolean ayq()
  {
    return fYi;
  }
  
  public static final boolean ayr()
  {
    return fYk;
  }
  
  public static final boolean b(com.tencent.mm.media.widget.camerarecordview.d.a parama)
  {
    AppMethodBeat.i(94376);
    p.h(parama, "process");
    if ((ae.gcL != null) && (ae.gcL.gbB != -1)) {
      if (ae.gcL.gbA != 3) {}
    }
    for (int i = 1;; i = 0)
    {
      if (((b)g.ab(b.class)).a(b.a.qxg, false)) {
        i = 0;
      }
      while (i != 0)
      {
        i = parama.getRecordScene();
        parama = ((b)g.ab(b.class)).a(b.a.qxf, "");
        if (!bt.isNullOrNil(parama))
        {
          p.g(parama, "supportScene");
          if (n.a((CharSequence)parama, (CharSequence)String.valueOf(i), false))
          {
            ad.i("MicroMsg.CameraHelper", "the scene = " + i + " is support record stream ");
            AppMethodBeat.o(94376);
            return true;
            if (ae.gcL.gbA == 1)
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
    if ((aym()) && (a(parama)) && (ayk()))
    {
      AppMethodBeat.o(94377);
      return true;
    }
    AppMethodBeat.o(94377);
    return false;
  }
  
  public static void et(boolean paramBoolean)
  {
    fYi = paramBoolean;
  }
  
  public static void eu(boolean paramBoolean)
  {
    fYk = paramBoolean;
  }
  
  public static void og(int paramInt)
  {
    hwr = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.a
 * JD-Core Version:    0.7.0.1
 */