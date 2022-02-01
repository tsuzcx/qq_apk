package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.flash.permission.FaceFlashPermissionUI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;

public enum f
{
  private static MMHandler zSQ;
  public FaceDetectProcessService zSP = null;
  
  static
  {
    AppMethodBeat.i(103738);
    zSO = new f("INSTANCE");
    zSR = new f[] { zSO };
    zSQ = new MMHandler("face_process");
    AppMethodBeat.o(103738);
  }
  
  private f() {}
  
  public static boolean a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(103733);
    Log.i("MicroMsg.FaceDetectManager", "start wx internal face verify");
    if ((paramContext == null) || (paramBundle == null))
    {
      AppMethodBeat.o(103733);
      return false;
    }
    FaceFlashPermissionUI.aw(paramBundle);
    FaceFlashPermissionUI.b(paramContext, paramBundle, paramInt);
    AppMethodBeat.o(103733);
    return true;
  }
  
  public static void aB(Runnable paramRunnable)
  {
    AppMethodBeat.i(103727);
    zSQ.postToWorker(paramRunnable);
    AppMethodBeat.o(103727);
  }
  
  public static void dOJ()
  {
    AppMethodBeat.i(103728);
    zSQ.removeCallbacksAndMessages(null);
    AppMethodBeat.o(103728);
  }
  
  public static MMHandler dOK()
  {
    AppMethodBeat.i(103729);
    MMHandler localMMHandler = zSQ;
    AppMethodBeat.o(103729);
    return localMMHandler;
  }
  
  public static boolean dOL()
  {
    AppMethodBeat.i(271887);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zbu, true);
    if ((!aw.jkP()) || (bool))
    {
      AppMethodBeat.o(271887);
      return true;
    }
    AppMethodBeat.o(271887);
    return false;
  }
  
  public static boolean dOM()
  {
    AppMethodBeat.i(369751);
    boolean bool = k.dOW();
    AppMethodBeat.o(369751);
    return bool;
  }
  
  static boolean gj(Context paramContext)
  {
    AppMethodBeat.i(103732);
    boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
    AppMethodBeat.o(103732);
    return bool;
  }
  
  public static boolean pg(boolean paramBoolean)
  {
    AppMethodBeat.i(103730);
    Log.i("MicroMsg.FaceDetectManager", "alvinluo: face detect isCheckDynCfg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    boolean bool1 = gj(MMApplicationContext.getContext());
    boolean bool2 = k.dOW();
    boolean bool3 = PluginFace.isEnabled();
    boolean bool4 = dOL();
    if (paramBoolean)
    {
      if (Util.getInt(((a)h.ax(a.class)).aRC().getValue("BioSigFaceEntry"), 0) == 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        Log.i("MicroMsg.FaceDetectManager", "hy: face config support: %b, hardware support: %b, isModelFileValid: %b, isPluginFaceEnabled: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((!paramBoolean) || (!(bool1 & bool2)) || (!bool3) || (!bool4)) {
          break;
        }
        AppMethodBeat.o(103730);
        return true;
      }
      AppMethodBeat.o(103730);
      return false;
    }
    Log.i("MicroMsg.FaceDetectManager", "hy: hardware support: %b, isModelFileValid: %b, isPluginFaceEnabled: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((bool2) && (bool1) && (bool3) && (bool4))
    {
      AppMethodBeat.o(103730);
      return true;
    }
    AppMethodBeat.o(103730);
    return false;
  }
  
  public final int dON()
  {
    AppMethodBeat.i(103734);
    g localg = this.zSP.zUR;
    if (localg.zSS == null)
    {
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
      AppMethodBeat.o(103734);
      return -3;
    }
    int i = localg.zSS.engineReleaseCurrMotion();
    AppMethodBeat.o(103734);
    return i;
  }
  
  public final int dOO()
  {
    AppMethodBeat.i(103735);
    g localg = this.zSP.zUR;
    if (localg.zSS == null)
    {
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: getCurrentMotion not init");
      AppMethodBeat.o(103735);
      return -1;
    }
    int i = localg.zSS.engineGetCurrMotion();
    AppMethodBeat.o(103735);
    return i;
  }
  
  public final int dOP()
  {
    AppMethodBeat.i(103737);
    g localg = this.zSP.zUR;
    if (localg.zSS == null)
    {
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
      AppMethodBeat.o(103737);
      return -1;
    }
    int i = localg.zSS.engineGroupChange();
    AppMethodBeat.o(103737);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.f
 * JD-Core Version:    0.7.0.1
 */