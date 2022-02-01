package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class g
  implements d.a
{
  public static d.a.a a(Context paramContext, int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155650);
    d.a.a locala = new d.a.a();
    locala.jqD = null;
    try
    {
      l = Util.currentTicks();
      Log.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", new Object[] { Integer.valueOf(paramInt) });
      locala.jqD = x.b(paramInt, paramLooper);
      Log.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back,  %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      if (locala.jqD == null)
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
    long l = Util.currentTicks();
    Log.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", new Object[] { Integer.valueOf(paramInt) });
    paramLooper = new Camera.CameraInfo();
    if (d.gaj)
    {
      paramLooper = a.jnC.qJ(paramInt);
      Log.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      switch (((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation())
      {
      default: 
        paramInt = 0;
        label250:
        if (paramLooper.facing != 1) {
          break;
        }
      }
    }
    for (paramInt = (360 - paramLooper.orientation % 360) % 360;; paramInt = (paramLooper.orientation - paramInt + 360) % 360)
    {
      l = Util.currentTicks();
      Log.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      locala.jqD.qO(paramInt);
      Log.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      locala.fSM = paramLooper.orientation;
      AppMethodBeat.o(155650);
      return locala;
      Camera.getCameraInfo(paramInt, paramLooper);
      break;
      paramInt = 0;
      break label250;
      paramInt = 90;
      break label250;
      paramInt = 180;
      break label250;
      paramInt = 270;
      break label250;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.g
 * JD-Core Version:    0.7.0.1
 */