package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
  implements d.a
{
  public static d.a.a a(Context paramContext, int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155650);
    d.a.a locala = new d.a.a();
    locala.gaZ = null;
    try
    {
      l = bu.HQ();
      ae.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", new Object[] { Integer.valueOf(paramInt) });
      locala.gaZ = w.b(paramInt, paramLooper);
      ae.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back,  %dms", new Object[] { Long.valueOf(bu.aO(l)) });
      if (locala.gaZ == null)
      {
        ae.e("MicroMsg.CameraUtil", "open camera error, not exception, but camera null");
        AppMethodBeat.o(155650);
        return null;
      }
    }
    catch (Exception paramContext)
    {
      ae.e("MicroMsg.CameraUtil", "open camera error %s", new Object[] { paramContext.getMessage() });
      ae.printErrStackTrace("MicroMsg.CameraUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(155650);
      return null;
    }
    paramLooper = new Camera.CameraInfo();
    long l = bu.HQ();
    ae.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", new Object[] { Integer.valueOf(paramInt) });
    Camera.getCameraInfo(paramInt, paramLooper);
    ae.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", new Object[] { Long.valueOf(bu.aO(l)) });
    switch (((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default: 
      paramInt = 0;
      if (paramLooper.facing != 1) {
        break;
      }
    }
    for (paramInt = (360 - paramLooper.orientation % 360) % 360;; paramInt = (paramLooper.orientation - paramInt + 360) % 360)
    {
      l = bu.HQ();
      ae.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      locala.gaZ.setDisplayOrientation(paramInt);
      ae.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", new Object[] { Long.valueOf(bu.aO(l)) });
      locala.dHi = paramLooper.orientation;
      AppMethodBeat.o(155650);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.g
 * JD-Core Version:    0.7.0.1
 */