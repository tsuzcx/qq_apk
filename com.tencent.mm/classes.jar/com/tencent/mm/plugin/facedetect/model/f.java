package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public enum f
{
  private static al mia;
  public FaceDetectProcessService mhZ = null;
  
  static
  {
    AppMethodBeat.i(213);
    mhY = new f("INSTANCE");
    mib = new f[] { mhY };
    mia = new al("face_process");
    AppMethodBeat.o(213);
  }
  
  private f() {}
  
  public static void S(Runnable paramRunnable)
  {
    AppMethodBeat.i(202);
    mia.ac(paramRunnable);
    AppMethodBeat.o(202);
  }
  
  public static boolean a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(208);
    ab.i("MicroMsg.FaceDetectManager", "start wx internal face verify");
    if ((paramContext == null) || (paramBundle == null))
    {
      AppMethodBeat.o(208);
      return false;
    }
    Intent localIntent = new Intent(paramContext, FaceDetectPrepareUI.class);
    localIntent.putExtras(paramBundle);
    ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(208);
    return true;
  }
  
  public static void bur()
  {
    AppMethodBeat.i(203);
    mia.caB().removeCallbacksAndMessages(null);
    AppMethodBeat.o(203);
  }
  
  public static ak bus()
  {
    AppMethodBeat.i(204);
    ak localak = mia.caB();
    AppMethodBeat.o(204);
    return localak;
  }
  
  public static boolean but()
  {
    AppMethodBeat.i(156793);
    boolean bool = p.buF();
    AppMethodBeat.o(156793);
    return bool;
  }
  
  public static int buw()
  {
    AppMethodBeat.i(211);
    int i = FaceProNative.engineVersion();
    AppMethodBeat.o(211);
    return i;
  }
  
  static boolean dQ(Context paramContext)
  {
    AppMethodBeat.i(207);
    boolean bool = paramContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
    AppMethodBeat.o(207);
    return bool;
  }
  
  public static boolean hr(boolean paramBoolean)
  {
    AppMethodBeat.i(205);
    ab.i("MicroMsg.FaceDetectManager", "alvinluo: face detect isCheckDynCfg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    boolean bool1 = dQ(ah.getContext());
    boolean bool2 = p.buF();
    if (paramBoolean)
    {
      if (bo.getInt(((a)com.tencent.mm.kernel.g.E(a.class)).Nq().getValue("BioSigFaceEntry"), 0) == 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ab.i("MicroMsg.FaceDetectManager", "hy: face config support: %b, hardware support: %b, isModelFileValid: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!paramBoolean) || (!(bool1 & bool2))) {
          break;
        }
        AppMethodBeat.o(205);
        return true;
      }
      AppMethodBeat.o(205);
      return false;
    }
    ab.i("MicroMsg.FaceDetectManager", "hy: hardware support: %b, isModelFileValid: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool2) && (bool1))
    {
      AppMethodBeat.o(205);
      return true;
    }
    AppMethodBeat.o(205);
    return false;
  }
  
  public final int buu()
  {
    AppMethodBeat.i(209);
    g localg = this.mhZ.mkf;
    if (localg.mic == null)
    {
      ab.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
      AppMethodBeat.o(209);
      return -3;
    }
    int i = localg.mic.engineReleaseCurrMotion();
    AppMethodBeat.o(209);
    return i;
  }
  
  public final int buv()
  {
    AppMethodBeat.i(210);
    g localg = this.mhZ.mkf;
    if (localg.mic == null)
    {
      ab.e("MicroMsg.FaceDetectNativeManager", "hy: getCurrentMotion not init");
      AppMethodBeat.o(210);
      return -1;
    }
    int i = localg.mic.engineGetCurrMotion();
    AppMethodBeat.o(210);
    return i;
  }
  
  public final int bux()
  {
    AppMethodBeat.i(212);
    g localg = this.mhZ.mkf;
    if (localg.mic == null)
    {
      ab.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
      AppMethodBeat.o(212);
      return -1;
    }
    int i = localg.mic.engineGroupChange();
    AppMethodBeat.o(212);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.f
 * JD-Core Version:    0.7.0.1
 */