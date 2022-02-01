package com.tencent.mm.compatible.deviceinfo;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class i
  implements d.a
{
  public static d.a.a a(int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155652);
    d.a.a locala = new d.a.a();
    locala.fFt = null;
    try
    {
      locala.fFt = w.b(paramInt, paramLooper);
      if (locala.fFt == null)
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
    locala.duc = 0;
    ac.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.hasVRInfo " + ae.fJd.fEM);
    ac.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceRotate " + ae.fJd.fEN);
    ac.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + ae.fJd.fEO);
    ac.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackRotate " + ae.fJd.fEP);
    ac.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + ae.fJd.fEQ);
    if (getNumberOfCameras() > 1) {}
    for (;;)
    {
      try
      {
        paramLooper = new Camera.CameraInfo();
        Camera.getCameraInfo(paramInt, paramLooper);
        ac.d("CameraUtilImplConfig", "info.facing " + paramLooper.facing);
        if (paramLooper.facing != 1) {
          continue;
        }
        if ((ae.fJd.fEM) && (ae.fJd.fEN != -1)) {
          locala.duc = ae.fJd.fEN;
        }
        if ((ae.fJd.fEM) && (ae.fJd.fEO != -1)) {
          locala.fFt.setDisplayOrientation(ae.fJd.fEO);
        }
      }
      catch (Exception paramLooper)
      {
        ac.printErrStackTrace("CameraUtilImplConfig", paramLooper, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(155652);
      return locala;
      if ((ae.fJd.fEM) && (ae.fJd.fEP != -1)) {
        locala.duc = ae.fJd.fEP;
      }
      if ((ae.fJd.fEM) && (ae.fJd.fEQ != -1))
      {
        locala.fFt.setDisplayOrientation(ae.fJd.fEQ);
        continue;
        if ((ae.fJd.fEM) && (ae.fJd.fEP != -1)) {
          locala.duc = ae.fJd.fEP;
        }
        if ((ae.fJd.fEM) && (ae.fJd.fEQ != -1)) {
          locala.fFt.setDisplayOrientation(ae.fJd.fEQ);
        }
      }
    }
  }
  
  public static int getNumberOfCameras()
  {
    AppMethodBeat.i(155651);
    if ((ae.fJd.fES) && (ae.fJd.fER != -1))
    {
      i = ae.fJd.fER;
      ac.d("CameraUtilImplConfig", "mVRCameraNum ".concat(String.valueOf(i)));
      AppMethodBeat.o(155651);
      return i;
    }
    int i = d.getNumberOfCameras();
    ac.d("CameraUtilImplConfig", "getNumberOfCameras ".concat(String.valueOf(i)));
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