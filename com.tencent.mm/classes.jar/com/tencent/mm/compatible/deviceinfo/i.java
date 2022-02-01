package com.tencent.mm.compatible.deviceinfo;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class i
  implements d.a
{
  public static d.a.a a(int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155652);
    d.a.a locala = new d.a.a();
    locala.fBM = null;
    try
    {
      locala.fBM = w.b(paramInt, paramLooper);
      if (locala.fBM == null)
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
    locala.dwp = 0;
    ad.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.hasVRInfo " + ae.fFw.fBf);
    ad.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceRotate " + ae.fFw.fBg);
    ad.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + ae.fFw.fBh);
    ad.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackRotate " + ae.fFw.fBi);
    ad.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + ae.fFw.fBj);
    if (getNumberOfCameras() > 1) {}
    for (;;)
    {
      try
      {
        paramLooper = new Camera.CameraInfo();
        Camera.getCameraInfo(paramInt, paramLooper);
        ad.d("CameraUtilImplConfig", "info.facing " + paramLooper.facing);
        if (paramLooper.facing != 1) {
          continue;
        }
        if ((ae.fFw.fBf) && (ae.fFw.fBg != -1)) {
          locala.dwp = ae.fFw.fBg;
        }
        if ((ae.fFw.fBf) && (ae.fFw.fBh != -1)) {
          locala.fBM.setDisplayOrientation(ae.fFw.fBh);
        }
      }
      catch (Exception paramLooper)
      {
        ad.printErrStackTrace("CameraUtilImplConfig", paramLooper, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(155652);
      return locala;
      if ((ae.fFw.fBf) && (ae.fFw.fBi != -1)) {
        locala.dwp = ae.fFw.fBi;
      }
      if ((ae.fFw.fBf) && (ae.fFw.fBj != -1))
      {
        locala.fBM.setDisplayOrientation(ae.fFw.fBj);
        continue;
        if ((ae.fFw.fBf) && (ae.fFw.fBi != -1)) {
          locala.dwp = ae.fFw.fBi;
        }
        if ((ae.fFw.fBf) && (ae.fFw.fBj != -1)) {
          locala.fBM.setDisplayOrientation(ae.fFw.fBj);
        }
      }
    }
  }
  
  public static int getNumberOfCameras()
  {
    AppMethodBeat.i(155651);
    if ((ae.fFw.fBl) && (ae.fFw.fBk != -1))
    {
      i = ae.fFw.fBk;
      ad.d("CameraUtilImplConfig", "mVRCameraNum ".concat(String.valueOf(i)));
      AppMethodBeat.o(155651);
      return i;
    }
    int i = d.getNumberOfCameras();
    ad.d("CameraUtilImplConfig", "getNumberOfCameras ".concat(String.valueOf(i)));
    if (i > 1)
    {
      AppMethodBeat.o(155651);
      return i;
    }
    AppMethodBeat.o(155651);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.i
 * JD-Core Version:    0.7.0.1
 */