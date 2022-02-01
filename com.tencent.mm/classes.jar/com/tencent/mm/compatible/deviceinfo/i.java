package com.tencent.mm.compatible.deviceinfo;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class i
  implements d.a
{
  public static d.a.a a(int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155652);
    d.a.a locala = new d.a.a();
    locala.gGr = null;
    try
    {
      locala.gGr = w.b(paramInt, paramLooper);
      if (locala.gGr == null)
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
    locala.dYT = 0;
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.hasVRInfo " + ae.gKt.gFI);
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceRotate " + ae.gKt.gFJ);
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + ae.gKt.gFK);
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackRotate " + ae.gKt.gFL);
    Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + ae.gKt.gFM);
    if (getNumberOfCameras() > 1) {}
    for (;;)
    {
      try
      {
        paramLooper = new Camera.CameraInfo();
        Camera.getCameraInfo(paramInt, paramLooper);
        Log.d("CameraUtilImplConfig", "info.facing " + paramLooper.facing);
        if (paramLooper.facing != 1) {
          continue;
        }
        if ((ae.gKt.gFI) && (ae.gKt.gFJ != -1)) {
          locala.dYT = ae.gKt.gFJ;
        }
        if ((ae.gKt.gFI) && (ae.gKt.gFK != -1)) {
          locala.gGr.setDisplayOrientation(ae.gKt.gFK);
        }
      }
      catch (Exception paramLooper)
      {
        Log.printErrStackTrace("CameraUtilImplConfig", paramLooper, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(155652);
      return locala;
      if ((ae.gKt.gFI) && (ae.gKt.gFL != -1)) {
        locala.dYT = ae.gKt.gFL;
      }
      if ((ae.gKt.gFI) && (ae.gKt.gFM != -1))
      {
        locala.gGr.setDisplayOrientation(ae.gKt.gFM);
        continue;
        if ((ae.gKt.gFI) && (ae.gKt.gFL != -1)) {
          locala.dYT = ae.gKt.gFL;
        }
        if ((ae.gKt.gFI) && (ae.gKt.gFM != -1)) {
          locala.gGr.setDisplayOrientation(ae.gKt.gFM);
        }
      }
    }
  }
  
  public static int getNumberOfCameras()
  {
    AppMethodBeat.i(155651);
    if ((ae.gKt.gFO) && (ae.gKt.gFN != -1))
    {
      i = ae.gKt.gFN;
      Log.d("CameraUtilImplConfig", "mVRCameraNum ".concat(String.valueOf(i)));
      AppMethodBeat.o(155651);
      return i;
    }
    int i = d.getNumberOfCameras();
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