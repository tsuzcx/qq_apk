package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  implements d.a
{
  public static d.a.a a(Context paramContext, int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155650);
    d.a.a locala = new d.a.a();
    locala.gGr = null;
    try
    {
      l = Util.currentTicks();
      Log.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", new Object[] { Integer.valueOf(paramInt) });
      locala.gGr = w.b(paramInt, paramLooper);
      Log.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back,  %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      if (locala.gGr == null)
      {
        Log.e("MicroMsg.CameraUtil", "open camera error, not exception, but camera null");
        AppMethodBeat.o(155650);
        return null;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.CameraUtil", "open camera error %s", new Object[] { paramContext.getMessage() });
      Log.printErrStackTrace("MicroMsg.CameraUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(155650);
      return null;
    }
    paramLooper = new Camera.CameraInfo();
    long l = Util.currentTicks();
    Log.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", new Object[] { Integer.valueOf(paramInt) });
    Camera.getCameraInfo(paramInt, paramLooper);
    Log.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
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
      l = Util.currentTicks();
      Log.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      locala.gGr.setDisplayOrientation(paramInt);
      Log.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      locala.dYT = paramLooper.orientation;
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