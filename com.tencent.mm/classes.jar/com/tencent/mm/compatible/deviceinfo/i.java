package com.tencent.mm.compatible.deviceinfo;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i
  implements d.a
{
  public static d.a.a a(int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155652);
    d.a.a locala = new d.a.a();
    locala.gaZ = null;
    try
    {
      locala.gaZ = w.b(paramInt, paramLooper);
      if (locala.gaZ == null)
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
    locala.dHi = 0;
    com.tencent.mm.sdk.platformtools.ae.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.hasVRInfo " + ae.geM.gas);
    com.tencent.mm.sdk.platformtools.ae.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceRotate " + ae.geM.gat);
    com.tencent.mm.sdk.platformtools.ae.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + ae.geM.gau);
    com.tencent.mm.sdk.platformtools.ae.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackRotate " + ae.geM.gav);
    com.tencent.mm.sdk.platformtools.ae.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + ae.geM.gaw);
    if (getNumberOfCameras() > 1) {}
    for (;;)
    {
      try
      {
        paramLooper = new Camera.CameraInfo();
        Camera.getCameraInfo(paramInt, paramLooper);
        com.tencent.mm.sdk.platformtools.ae.d("CameraUtilImplConfig", "info.facing " + paramLooper.facing);
        if (paramLooper.facing != 1) {
          continue;
        }
        if ((ae.geM.gas) && (ae.geM.gat != -1)) {
          locala.dHi = ae.geM.gat;
        }
        if ((ae.geM.gas) && (ae.geM.gau != -1)) {
          locala.gaZ.setDisplayOrientation(ae.geM.gau);
        }
      }
      catch (Exception paramLooper)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("CameraUtilImplConfig", paramLooper, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(155652);
      return locala;
      if ((ae.geM.gas) && (ae.geM.gav != -1)) {
        locala.dHi = ae.geM.gav;
      }
      if ((ae.geM.gas) && (ae.geM.gaw != -1))
      {
        locala.gaZ.setDisplayOrientation(ae.geM.gaw);
        continue;
        if ((ae.geM.gas) && (ae.geM.gav != -1)) {
          locala.dHi = ae.geM.gav;
        }
        if ((ae.geM.gas) && (ae.geM.gaw != -1)) {
          locala.gaZ.setDisplayOrientation(ae.geM.gaw);
        }
      }
    }
  }
  
  public static int getNumberOfCameras()
  {
    AppMethodBeat.i(155651);
    if ((ae.geM.gay) && (ae.geM.gax != -1))
    {
      i = ae.geM.gax;
      com.tencent.mm.sdk.platformtools.ae.d("CameraUtilImplConfig", "mVRCameraNum ".concat(String.valueOf(i)));
      AppMethodBeat.o(155651);
      return i;
    }
    int i = d.getNumberOfCameras();
    com.tencent.mm.sdk.platformtools.ae.d("CameraUtilImplConfig", "getNumberOfCameras ".concat(String.valueOf(i)));
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