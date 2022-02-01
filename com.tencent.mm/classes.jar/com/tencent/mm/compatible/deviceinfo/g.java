package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
  implements d.a
{
  public static d.a.a a(Context paramContext, int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155650);
    d.a.a locala = new d.a.a();
    locala.fFt = null;
    try
    {
      l = bs.Gn();
      ac.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", new Object[] { Integer.valueOf(paramInt) });
      locala.fFt = w.b(paramInt, paramLooper);
      ac.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back,  %dms", new Object[] { Long.valueOf(bs.aO(l)) });
      if (locala.fFt == null)
      {
        ac.e("MicroMsg.CameraUtil", "open camera error, not exception, but camera null");
        AppMethodBeat.o(155650);
        return null;
      }
    }
    catch (Exception paramContext)
    {
      ac.e("MicroMsg.CameraUtil", "open camera error %s", new Object[] { paramContext.getMessage() });
      ac.printErrStackTrace("MicroMsg.CameraUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(155650);
      return null;
    }
    paramLooper = new Camera.CameraInfo();
    long l = bs.Gn();
    ac.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", new Object[] { Integer.valueOf(paramInt) });
    Camera.getCameraInfo(paramInt, paramLooper);
    ac.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", new Object[] { Long.valueOf(bs.aO(l)) });
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
      l = bs.Gn();
      ac.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      locala.fFt.setDisplayOrientation(paramInt);
      ac.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", new Object[] { Long.valueOf(bs.aO(l)) });
      locala.duc = paramLooper.orientation;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.g
 * JD-Core Version:    0.7.0.1
 */