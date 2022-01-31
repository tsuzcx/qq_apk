package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public enum f
{
  private static ai jNO = new ai("face_process");
  public FaceDetectProcessService jNN = null;
  
  private f() {}
  
  public static void J(Runnable paramRunnable)
  {
    jNO.O(paramRunnable);
  }
  
  public static void aOo()
  {
    jNO.crf().removeCallbacksAndMessages(null);
  }
  
  public static ah aOp()
  {
    return jNO.crf();
  }
  
  public static boolean aOq()
  {
    return ae.getContext().getPackageManager().hasSystemFeature("android.hardware.camera.front");
  }
  
  public static boolean aOr()
  {
    return o.aOB();
  }
  
  public static int aOu()
  {
    return FaceProNative.engineVersion();
  }
  
  public static boolean fO(boolean paramBoolean)
  {
    y.i("MicroMsg.FaceDetectManager", "alvinluo: face detect isCheckDynCfg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    boolean bool1 = aOq();
    boolean bool2 = o.aOB();
    if (paramBoolean) {
      if (bk.getInt(((a)com.tencent.mm.kernel.g.r(a.class)).AA().getValue("BioSigFaceEntry"), 0) == 1)
      {
        paramBoolean = true;
        y.i("MicroMsg.FaceDetectManager", "hy: face config support: %b, hardware support: %b, isModelFileValid: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!paramBoolean) || (!(bool1 & bool2))) {
          break label107;
        }
      }
    }
    label107:
    do
    {
      return true;
      paramBoolean = false;
      break;
      return false;
      y.i("MicroMsg.FaceDetectManager", "hy: hardware support: %b, isModelFileValid: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    } while ((bool2) && (bool1));
    return false;
  }
  
  public final int aOs()
  {
    g localg = this.jNN.jPP;
    if (localg.jNQ == null)
    {
      y.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
      return -3;
    }
    return localg.jNQ.engineReleaseCurrMotion();
  }
  
  public final int aOt()
  {
    g localg = this.jNN.jPP;
    if (localg.jNQ == null)
    {
      y.e("MicroMsg.FaceDetectNativeManager", "hy: getCurrentMotion not init");
      return -1;
    }
    return localg.jNQ.engineGetCurrMotion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.f
 * JD-Core Version:    0.7.0.1
 */