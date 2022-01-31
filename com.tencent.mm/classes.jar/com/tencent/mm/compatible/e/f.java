package com.tencent.mm.compatible.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class f
  implements d.a
{
  @TargetApi(8)
  public static d.a.a a(int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(92928);
    d.a.a locala = new d.a.a();
    try
    {
      locala.eoH = v.c(paramLooper);
      locala.rotate = 90;
      if (locala.eoH == null)
      {
        AppMethodBeat.o(92928);
        return null;
      }
    }
    catch (Exception paramLooper)
    {
      AppMethodBeat.o(92928);
      return null;
    }
    paramLooper = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, paramLooper);
    switch (((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default: 
      paramInt = 0;
      if (paramLooper.facing != 1) {
        break;
      }
    }
    for (int i = (360 - (paramLooper.orientation + paramInt) % 360) % 360;; i = (paramLooper.orientation - paramInt + 360) % 360)
    {
      ab.d("MicroMsg.CameraUtil.CameraUtilImpl22", "CameraUtilImpl22, open camera, info.orientation: %d, degrees: %d, result:%d", new Object[] { Integer.valueOf(paramLooper.orientation), Integer.valueOf(paramInt), Integer.valueOf(i) });
      locala.eoH.setDisplayOrientation(i);
      AppMethodBeat.o(92928);
      return locala;
      paramInt = 0;
      break;
      paramInt = 90;
      break;
      paramInt = 180;
      break;
      paramInt = 270;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.e.f
 * JD-Core Version:    0.7.0.1
 */