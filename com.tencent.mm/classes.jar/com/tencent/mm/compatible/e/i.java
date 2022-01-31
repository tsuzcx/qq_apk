package com.tencent.mm.compatible.e;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.tencent.mm.sdk.platformtools.y;

final class i
  implements d.a
{
  public static int getNumberOfCameras()
  {
    int i;
    if ((q.dyd.dwm) && (q.dyd.dwl != -1))
    {
      i = q.dyd.dwl;
      y.d("CameraUtilImplConfig", "mVRCameraNum " + i);
    }
    int j;
    do
    {
      return i;
      j = d.getNumberOfCameras();
      y.d("CameraUtilImplConfig", "getNumberOfCameras " + j);
      i = j;
    } while (j > 1);
    return 0;
  }
  
  public static d.a.a gy(int paramInt)
  {
    d.a.a locala = new d.a.a();
    locala.dwJ = null;
    try
    {
      locala.dwJ = Camera.open(paramInt);
      if (locala.dwJ == null) {
        return null;
      }
      locala.rotate = 0;
      y.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.hasVRInfo " + q.dyd.dwg);
      y.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceRotate " + q.dyd.dwh);
      y.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + q.dyd.dwi);
      y.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackRotate " + q.dyd.dwj);
      y.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + q.dyd.dwk);
      if (getNumberOfCameras() > 1)
      {
        try
        {
          Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
          Camera.getCameraInfo(paramInt, localCameraInfo);
          y.d("CameraUtilImplConfig", "info.facing " + localCameraInfo.facing);
          if (localCameraInfo.facing == 1)
          {
            if ((q.dyd.dwg) && (q.dyd.dwh != -1)) {
              locala.rotate = q.dyd.dwh;
            }
            if ((q.dyd.dwg) && (q.dyd.dwi != -1)) {
              locala.dwJ.setDisplayOrientation(q.dyd.dwi);
            }
          }
          else
          {
            if ((q.dyd.dwg) && (q.dyd.dwj != -1)) {
              locala.rotate = q.dyd.dwj;
            }
            if ((q.dyd.dwg) && (q.dyd.dwk != -1)) {
              locala.dwJ.setDisplayOrientation(q.dyd.dwk);
            }
          }
        }
        catch (Exception localException2)
        {
          y.printErrStackTrace("CameraUtilImplConfig", localException2, "", new Object[0]);
        }
      }
      else
      {
        if ((q.dyd.dwg) && (q.dyd.dwj != -1)) {
          locala.rotate = q.dyd.dwj;
        }
        if ((q.dyd.dwg) && (q.dyd.dwk != -1)) {
          locala.dwJ.setDisplayOrientation(q.dyd.dwk);
        }
      }
    }
    catch (Exception localException1)
    {
      return null;
    }
    return localException1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.e.i
 * JD-Core Version:    0.7.0.1
 */