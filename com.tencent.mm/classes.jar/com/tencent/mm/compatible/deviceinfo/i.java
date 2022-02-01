package com.tencent.mm.compatible.deviceinfo;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;

final class i
  implements d.a
{
  public static int aOG()
  {
    AppMethodBeat.i(155651);
    if ((af.lXY.lTf) && (af.lXY.lTe != -1))
    {
      i = af.lXY.lTe;
      Log.d("CameraUtilImplConfig", "mVRCameraNum ".concat(String.valueOf(i)));
      AppMethodBeat.o(155651);
      return i;
    }
    int i = d.aOG();
    Log.d("CameraUtilImplConfig", "getNumberOfCameras ".concat(String.valueOf(i)));
    if (i > 1)
    {
      AppMethodBeat.o(155651);
      return i;
    }
    AppMethodBeat.o(155651);
    return 0;
  }
  
  public final d.a.a a(final int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155652);
    d.a.a locala = new d.a.a();
    locala.lTN = null;
    try
    {
      locala.lTN = x.b(paramInt, paramLooper);
      if (locala.lTN == null)
      {
        AppMethodBeat.o(155652);
        return null;
      }
    }
    catch (Exception paramLooper)
    {
      AppMethodBeat.o(155652);
      return null;
    }
    locala.hYK = 0;
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.hasVRInfo " + af.lXY.lSZ);
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceRotate " + af.lXY.lTa);
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + af.lXY.lTb);
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackRotate " + af.lXY.lTc);
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + af.lXY.lTd);
    if (aOG() > 1) {}
    for (;;)
    {
      try
      {
        paramLooper = new Camera.CameraInfo();
        if (!d.igs) {
          continue;
        }
        int i = a.lQF.qP(paramInt).facing;
        h.ahAA.g(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(240855);
            try
            {
              Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
              Camera.getCameraInfo(paramInt, localCameraInfo);
              a locala = a.lQF;
              a.a(paramInt, localCameraInfo);
              AppMethodBeat.o(240855);
              return;
            }
            finally
            {
              Log.e("CameraUtilImplConfig", "CameraUtilImplConfig update CameraInfo Cache failed : " + localObject.getMessage());
              AppMethodBeat.o(240855);
            }
          }
        }, "openCamera-checkCache");
        paramInt = i;
        Log.d("CameraUtilImplConfig", "info.facing ".concat(String.valueOf(paramInt)));
        if (paramInt != 1) {
          continue;
        }
        if ((af.lXY.lSZ) && (af.lXY.lTa != -1)) {
          locala.hYK = af.lXY.lTa;
        }
        if ((af.lXY.lSZ) && (af.lXY.lTb != -1)) {
          locala.lTN.qV(af.lXY.lTb);
        }
      }
      catch (Exception paramLooper)
      {
        Log.printErrStackTrace("CameraUtilImplConfig", paramLooper, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(155652);
      return locala;
      Camera.getCameraInfo(paramInt, paramLooper);
      paramInt = paramLooper.facing;
      continue;
      if ((af.lXY.lSZ) && (af.lXY.lTc != -1)) {
        locala.hYK = af.lXY.lTc;
      }
      if ((af.lXY.lSZ) && (af.lXY.lTd != -1))
      {
        locala.lTN.qV(af.lXY.lTd);
        continue;
        if ((af.lXY.lSZ) && (af.lXY.lTc != -1)) {
          locala.hYK = af.lXY.lTc;
        }
        if ((af.lXY.lSZ) && (af.lXY.lTd != -1)) {
          locala.lTN.qV(af.lXY.lTd);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.i
 * JD-Core Version:    0.7.0.1
 */