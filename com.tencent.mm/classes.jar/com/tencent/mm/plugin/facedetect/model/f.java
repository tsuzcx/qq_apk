package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.flash.FaceFlashUI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;

public enum f
{
  private static MMHandler sQO;
  public FaceDetectProcessService sQN = null;
  
  static
  {
    AppMethodBeat.i(103738);
    sQM = new f("INSTANCE");
    sQP = new f[] { sQM };
    sQO = new MMHandler("face_process");
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
    FaceFlashUI.a((Activity)paramContext, paramBundle, paramInt);
    AppMethodBeat.o(103733);
    return true;
  }
  
  public static void ao(Runnable paramRunnable)
  {
    AppMethodBeat.i(103727);
    sQO.postToWorker(paramRunnable);
    AppMethodBeat.o(103727);
  }
  
  public static void cSU()
  {
    AppMethodBeat.i(103728);
    sQO.removeCallbacksAndMessages(null);
    AppMethodBeat.o(103728);
  }
  
  public static MMHandler cSV()
  {
    AppMethodBeat.i(103729);
    MMHandler localMMHandler = sQO;
    AppMethodBeat.o(103729);
    return localMMHandler;
  }
  
  public static boolean cSW()
  {
    AppMethodBeat.i(186366);
    boolean bool = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.scG, false);
    if ((!ao.gJH()) || (bool))
    {
      AppMethodBeat.o(186366);
      return true;
    }
    AppMethodBeat.o(186366);
    return false;
  }
  
  public static boolean cSX()
  {
    AppMethodBeat.i(258582);
    boolean bool = p.cTg();
    AppMethodBeat.o(258582);
    return bool;
  }
  
  static boolean fg(Context paramContext)
  {
    AppMethodBeat.i(103732);
    boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
    AppMethodBeat.o(103732);
    return bool;
  }
  
  public static boolean mt(boolean paramBoolean)
  {
    AppMethodBeat.i(103730);
    Log.i("MicroMsg.FaceDetectManager", "alvinluo: face detect isCheckDynCfg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    boolean bool1 = fg(MMApplicationContext.getContext());
    boolean bool2 = p.cTg();
    boolean bool3 = PluginFace.isEnabled();
    boolean bool4 = cSW();
    if (paramBoolean)
    {
      if (Util.getInt(((a)com.tencent.mm.kernel.g.af(a.class)).aqJ().getValue("BioSigFaceEntry"), 0) == 1) {}
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
  
  public final int cSY()
  {
    AppMethodBeat.i(103734);
    g localg = this.sQN.sSO;
    if (localg.sQQ == null)
    {
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
      AppMethodBeat.o(103734);
      return -3;
    }
    int i = localg.sQQ.engineReleaseCurrMotion();
    AppMethodBeat.o(103734);
    return i;
  }
  
  public final int cSZ()
  {
    AppMethodBeat.i(103735);
    g localg = this.sQN.sSO;
    if (localg.sQQ == null)
    {
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: getCurrentMotion not init");
      AppMethodBeat.o(103735);
      return -1;
    }
    int i = localg.sQQ.engineGetCurrMotion();
    AppMethodBeat.o(103735);
    return i;
  }
  
  public final int cTa()
  {
    AppMethodBeat.i(103737);
    g localg = this.sQN.sSO;
    if (localg.sQQ == null)
    {
      Log.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
      AppMethodBeat.o(103737);
      return -1;
    }
    int i = localg.sQQ.engineGroupChange();
    AppMethodBeat.o(103737);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.f
 * JD-Core Version:    0.7.0.1
 */