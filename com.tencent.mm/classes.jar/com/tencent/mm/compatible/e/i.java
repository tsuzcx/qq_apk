package com.tencent.mm.compatible.e;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class i
  implements d.a
{
  public static d.a.a a(int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(92931);
    d.a.a locala = new d.a.a();
    locala.eoH = null;
    try
    {
      locala.eoH = v.b(paramInt, paramLooper);
      if (locala.eoH == null)
      {
        AppMethodBeat.o(92931);
        return null;
      }
    }
    catch (Exception paramLooper)
    {
      AppMethodBeat.o(92931);
      return null;
    }
    locala.rotate = 0;
    ab.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.hasVRInfo " + ac.eru.enZ);
    ab.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceRotate " + ac.eru.eoa);
    ab.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + ac.eru.eob);
    ab.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackRotate " + ac.eru.eoc);
    ab.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + ac.eru.eod);
    if (getNumberOfCameras() > 1) {}
    for (;;)
    {
      try
      {
        paramLooper = new Camera.CameraInfo();
        Camera.getCameraInfo(paramInt, paramLooper);
        ab.d("CameraUtilImplConfig", "info.facing " + paramLooper.facing);
        if (paramLooper.facing != 1) {
          continue;
        }
        if ((ac.eru.enZ) && (ac.eru.eoa != -1)) {
          locala.rotate = ac.eru.eoa;
        }
        if ((ac.eru.enZ) && (ac.eru.eob != -1)) {
          locala.eoH.setDisplayOrientation(ac.eru.eob);
        }
      }
      catch (Exception paramLooper)
      {
        ab.printErrStackTrace("CameraUtilImplConfig", paramLooper, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(92931);
      return locala;
      if ((ac.eru.enZ) && (ac.eru.eoc != -1)) {
        locala.rotate = ac.eru.eoc;
      }
      if ((ac.eru.enZ) && (ac.eru.eod != -1))
      {
        locala.eoH.setDisplayOrientation(ac.eru.eod);
        continue;
        if ((ac.eru.enZ) && (ac.eru.eoc != -1)) {
          locala.rotate = ac.eru.eoc;
        }
        if ((ac.eru.enZ) && (ac.eru.eod != -1)) {
          locala.eoH.setDisplayOrientation(ac.eru.eod);
        }
      }
    }
  }
  
  public static int getNumberOfCameras()
  {
    AppMethodBeat.i(92930);
    if ((ac.eru.eog) && (ac.eru.eoe != -1))
    {
      i = ac.eru.eoe;
      ab.d("CameraUtilImplConfig", "mVRCameraNum ".concat(String.valueOf(i)));
      AppMethodBeat.o(92930);
      return i;
    }
    int i = d.getNumberOfCameras();
    ab.d("CameraUtilImplConfig", "getNumberOfCameras ".concat(String.valueOf(i)));
    if (i > 1)
    {
      AppMethodBeat.o(92930);
      return i;
    }
    AppMethodBeat.o(92930);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.compatible.e.i
 * JD-Core Version:    0.7.0.1
 */