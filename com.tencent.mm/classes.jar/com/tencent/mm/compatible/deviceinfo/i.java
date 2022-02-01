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
    locala.fYS = null;
    try
    {
      locala.fYS = w.b(paramInt, paramLooper);
      if (locala.fYS == null)
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
    locala.dGc = 0;
    ad.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.hasVRInfo " + ae.gcE.fYl);
    ad.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceRotate " + ae.gcE.fYm);
    ad.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + ae.gcE.fYn);
    ad.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackRotate " + ae.gcE.fYo);
    ad.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + ae.gcE.fYp);
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
        if ((ae.gcE.fYl) && (ae.gcE.fYm != -1)) {
          locala.dGc = ae.gcE.fYm;
        }
        if ((ae.gcE.fYl) && (ae.gcE.fYn != -1)) {
          locala.fYS.setDisplayOrientation(ae.gcE.fYn);
        }
      }
      catch (Exception paramLooper)
      {
        ad.printErrStackTrace("CameraUtilImplConfig", paramLooper, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(155652);
      return locala;
      if ((ae.gcE.fYl) && (ae.gcE.fYo != -1)) {
        locala.dGc = ae.gcE.fYo;
      }
      if ((ae.gcE.fYl) && (ae.gcE.fYp != -1))
      {
        locala.fYS.setDisplayOrientation(ae.gcE.fYp);
        continue;
        if ((ae.gcE.fYl) && (ae.gcE.fYo != -1)) {
          locala.dGc = ae.gcE.fYo;
        }
        if ((ae.gcE.fYl) && (ae.gcE.fYp != -1)) {
          locala.fYS.setDisplayOrientation(ae.gcE.fYp);
        }
      }
    }
  }
  
  public static int getNumberOfCameras()
  {
    AppMethodBeat.i(155651);
    if ((ae.gcE.fYr) && (ae.gcE.fYq != -1))
    {
      i = ae.gcE.fYq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.i
 * JD-Core Version:    0.7.0.1
 */