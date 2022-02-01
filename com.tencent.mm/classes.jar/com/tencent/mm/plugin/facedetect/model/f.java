package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

public enum f
{
  private static aq rpq;
  public FaceDetectProcessService rpp = null;
  
  static
  {
    AppMethodBeat.i(103738);
    rpo = new f("INSTANCE");
    rpr = new f[] { rpo };
    rpq = new aq("face_process");
    AppMethodBeat.o(103738);
  }
  
  private f() {}
  
  public static boolean a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(103733);
    ae.i("MicroMsg.FaceDetectManager", "start wx internal face verify");
    if ((paramContext == null) || (paramBundle == null))
    {
      AppMethodBeat.o(103733);
      return false;
    }
    Intent localIntent = new Intent(paramContext, FaceDetectPrepareUI.class);
    localIntent.putExtras(paramBundle);
    ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(103733);
    return true;
  }
  
  public static void ai(Runnable paramRunnable)
  {
    AppMethodBeat.i(103727);
    rpq.postToWorker(paramRunnable);
    AppMethodBeat.o(103727);
  }
  
  public static boolean cuA()
  {
    AppMethodBeat.i(224492);
    boolean bool = p.cuL();
    AppMethodBeat.o(224492);
    return bool;
  }
  
  public static int cuD()
  {
    AppMethodBeat.i(103736);
    if (!PluginFace.isEnabled())
    {
      AppMethodBeat.o(103736);
      return -1;
    }
    int i = FaceProNative.engineVersion();
    AppMethodBeat.o(103736);
    return i;
  }
  
  public static void cuy()
  {
    AppMethodBeat.i(103728);
    rpq.removeCallbacksAndMessages(null);
    AppMethodBeat.o(103728);
  }
  
  public static aq cuz()
  {
    AppMethodBeat.i(103729);
    aq localaq = rpq;
    AppMethodBeat.o(103729);
    return localaq;
  }
  
  static boolean eM(Context paramContext)
  {
    AppMethodBeat.i(103732);
    boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
    AppMethodBeat.o(103732);
    return bool;
  }
  
  public static boolean lr(boolean paramBoolean)
  {
    AppMethodBeat.i(103730);
    ae.i("MicroMsg.FaceDetectManager", "alvinluo: face detect isCheckDynCfg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    boolean bool1 = eM(ak.getContext());
    boolean bool2 = p.cuL();
    boolean bool3 = PluginFace.isEnabled();
    if (paramBoolean)
    {
      if (bu.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).acL().getValue("BioSigFaceEntry"), 0) == 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ae.i("MicroMsg.FaceDetectManager", "hy: face config support: %b, hardware support: %b, isModelFileValid: %b, isPluginFaceEnabled: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((!paramBoolean) || (!(bool1 & bool2)) || (!bool3)) {
          break;
        }
        AppMethodBeat.o(103730);
        return true;
      }
      AppMethodBeat.o(103730);
      return false;
    }
    ae.i("MicroMsg.FaceDetectManager", "hy: hardware support: %b, isModelFileValid: %b, isPluginFaceEnabled: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((bool2) && (bool1) && (bool3))
    {
      AppMethodBeat.o(103730);
      return true;
    }
    AppMethodBeat.o(103730);
    return false;
  }
  
  public final int cuB()
  {
    AppMethodBeat.i(103734);
    g localg = this.rpp.rrr;
    if (localg.rps == null)
    {
      ae.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
      AppMethodBeat.o(103734);
      return -3;
    }
    int i = localg.rps.engineReleaseCurrMotion();
    AppMethodBeat.o(103734);
    return i;
  }
  
  public final int cuC()
  {
    AppMethodBeat.i(103735);
    g localg = this.rpp.rrr;
    if (localg.rps == null)
    {
      ae.e("MicroMsg.FaceDetectNativeManager", "hy: getCurrentMotion not init");
      AppMethodBeat.o(103735);
      return -1;
    }
    int i = localg.rps.engineGetCurrMotion();
    AppMethodBeat.o(103735);
    return i;
  }
  
  public final int cuE()
  {
    AppMethodBeat.i(103737);
    g localg = this.rpp.rrr;
    if (localg.rps == null)
    {
      ae.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
      AppMethodBeat.o(103737);
      return -1;
    }
    int i = localg.rps.engineGroupChange();
    AppMethodBeat.o(103737);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.f
 * JD-Core Version:    0.7.0.1
 */