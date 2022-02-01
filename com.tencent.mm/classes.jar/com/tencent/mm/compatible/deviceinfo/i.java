package com.tencent.mm.compatible.deviceinfo;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.c.a;
import com.tencent.mm.sdk.platformtools.Log;

final class i
  implements d.a
{
  public static d.a.a a(int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155652);
    d.a.a locala = new d.a.a();
    locala.jqD = null;
    try
    {
      locala.jqD = x.b(paramInt, paramLooper);
      if (locala.jqD == null)
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
    locala.fSM = 0;
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.hasVRInfo " + af.juH.jpS);
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceRotate " + af.juH.jpT);
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + af.juH.jpU);
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackRotate " + af.juH.jpV);
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + af.juH.jpW);
    if (auj() > 1) {}
    for (;;)
    {
      try
      {
        paramLooper = new Camera.CameraInfo();
        if (!d.gaj) {
          continue;
        }
        paramLooper = a.jnC.qJ(paramInt);
        Log.d("CameraUtilImplConfig", "info.facing " + paramLooper.facing);
        if (paramLooper.facing != 1) {
          continue;
        }
        if ((af.juH.jpS) && (af.juH.jpT != -1)) {
          locala.fSM = af.juH.jpT;
        }
        if ((af.juH.jpS) && (af.juH.jpU != -1)) {
          locala.jqD.qO(af.juH.jpU);
        }
      }
      catch (Exception paramLooper)
      {
        Log.printErrStackTrace("CameraUtilImplConfig", paramLooper, "", new Object[0]);
        continue;
        if ((!af.juH.jpS) || (af.juH.jpV == -1)) {
          continue;
        }
        locala.fSM = af.juH.jpV;
        if ((!af.juH.jpS) || (af.juH.jpW == -1)) {
          continue;
        }
        locala.jqD.qO(af.juH.jpW);
        continue;
      }
      AppMethodBeat.o(155652);
      return locala;
      Camera.getCameraInfo(paramInt, paramLooper);
      continue;
      if ((af.juH.jpS) && (af.juH.jpV != -1)) {
        locala.fSM = af.juH.jpV;
      }
      if ((af.juH.jpS) && (af.juH.jpW != -1)) {
        locala.jqD.qO(af.juH.jpW);
      }
    }
  }
  
  public static int auj()
  {
    AppMethodBeat.i(155651);
    if ((af.juH.jpY) && (af.juH.jpX != -1))
    {
      i = af.juH.jpX;
      Log.d("CameraUtilImplConfig", "mVRCameraNum ".concat(String.valueOf(i)));
      AppMethodBeat.o(155651);
      return i;
    }
    int i = d.auj();
    Log.d("CameraUtilImplConfig", "getNumberOfCameras ".concat(String.valueOf(i)));
    if (i > 1)
    {
      AppMethodBeat.o(155651);
      return i;
    }
    AppMethodBeat.o(155651);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.i
 * JD-Core Version:    0.7.0.1
 */