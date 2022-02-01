package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public enum f
{
  private static ap pOO;
  public FaceDetectProcessService pON = null;
  
  static
  {
    AppMethodBeat.i(103738);
    pOM = new f("INSTANCE");
    pOP = new f[] { pOM };
    pOO = new ap("face_process");
    AppMethodBeat.o(103738);
  }
  
  private f() {}
  
  public static boolean a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(103733);
    ad.i("MicroMsg.FaceDetectManager", "start wx internal face verify");
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
  
  public static void aj(Runnable paramRunnable)
  {
    AppMethodBeat.i(103727);
    pOO.postToWorker(paramRunnable);
    AppMethodBeat.o(103727);
  }
  
  public static void cfL()
  {
    AppMethodBeat.i(103728);
    pOO.removeCallbacksAndMessages(null);
    AppMethodBeat.o(103728);
  }
  
  public static ap cfM()
  {
    AppMethodBeat.i(103729);
    ap localap = pOO;
    AppMethodBeat.o(103729);
    return localap;
  }
  
  public static boolean cfN()
  {
    AppMethodBeat.i(204827);
    boolean bool = p.cfY();
    AppMethodBeat.o(204827);
    return bool;
  }
  
  public static int cfQ()
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
  
  static boolean eA(Context paramContext)
  {
    AppMethodBeat.i(103732);
    boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
    AppMethodBeat.o(103732);
    return bool;
  }
  
  public static boolean ku(boolean paramBoolean)
  {
    AppMethodBeat.i(103730);
    ad.i("MicroMsg.FaceDetectManager", "alvinluo: face detect isCheckDynCfg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    boolean bool1 = eA(aj.getContext());
    boolean bool2 = p.cfY();
    boolean bool3 = PluginFace.isEnabled();
    if (paramBoolean)
    {
      if (bt.getInt(((a)com.tencent.mm.kernel.g.ab(a.class)).Zd().getValue("BioSigFaceEntry"), 0) == 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ad.i("MicroMsg.FaceDetectManager", "hy: face config support: %b, hardware support: %b, isModelFileValid: %b, isPluginFaceEnabled: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((!paramBoolean) || (!(bool1 & bool2)) || (!bool3)) {
          break;
        }
        AppMethodBeat.o(103730);
        return true;
      }
      AppMethodBeat.o(103730);
      return false;
    }
    ad.i("MicroMsg.FaceDetectManager", "hy: hardware support: %b, isModelFileValid: %b, isPluginFaceEnabled: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
    if ((bool2) && (bool1) && (bool3))
    {
      AppMethodBeat.o(103730);
      return true;
    }
    AppMethodBeat.o(103730);
    return false;
  }
  
  public final int cfO()
  {
    AppMethodBeat.i(103734);
    g localg = this.pON.pQQ;
    if (localg.pOQ == null)
    {
      ad.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
      AppMethodBeat.o(103734);
      return -3;
    }
    int i = localg.pOQ.engineReleaseCurrMotion();
    AppMethodBeat.o(103734);
    return i;
  }
  
  public final int cfP()
  {
    AppMethodBeat.i(103735);
    g localg = this.pON.pQQ;
    if (localg.pOQ == null)
    {
      ad.e("MicroMsg.FaceDetectNativeManager", "hy: getCurrentMotion not init");
      AppMethodBeat.o(103735);
      return -1;
    }
    int i = localg.pOQ.engineGetCurrMotion();
    AppMethodBeat.o(103735);
    return i;
  }
  
  public final int cfR()
  {
    AppMethodBeat.i(103737);
    g localg = this.pON.pQQ;
    if (localg.pOQ == null)
    {
      ad.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
      AppMethodBeat.o(103737);
      return -1;
    }
    int i = localg.pOQ.engineGroupChange();
    AppMethodBeat.o(103737);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.f
 * JD-Core Version:    0.7.0.1
 */