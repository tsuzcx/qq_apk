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
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

final class g
  implements d.a
{
  public final d.a.a a(Context paramContext, final int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155650);
    d.a.a locala = new d.a.a();
    locala.lTN = null;
    try
    {
      l = Util.currentTicks();
      Log.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", new Object[] { Integer.valueOf(paramInt) });
      locala.lTN = x.b(paramInt, paramLooper);
      Log.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back,  %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      if (locala.lTN == null)
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
    int j;
    int i;
    if (d.igs)
    {
      paramLooper = a.lQF.qP(paramInt);
      j = paramLooper.facing;
      i = paramLooper.orientation;
      h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(240860);
          try
          {
            Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(paramInt, localCameraInfo);
            a locala = a.lQF;
            a.a(paramInt, localCameraInfo);
            AppMethodBeat.o(240860);
            return;
          }
          finally
          {
            Log.e("MicroMsg.CameraUtil", "CameraUtilImpl23 update CameraInfo Cache failed : " + localObject.getMessage());
            AppMethodBeat.o(240860);
          }
        }
      }, "openCamera-checkCache");
      Log.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      switch (((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation())
      {
      default: 
        paramInt = 0;
        label282:
        if (j != 1) {
          break;
        }
      }
    }
    for (paramInt = (360 - i % 360) % 360;; paramInt = (i - paramInt + 360) % 360)
    {
      l = Util.currentTicks();
      Log.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      locala.lTN.qV(paramInt);
      Log.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      locala.hYK = i;
      AppMethodBeat.o(155650);
      return locala;
      Camera.getCameraInfo(paramInt, paramLooper);
      j = paramLooper.facing;
      i = paramLooper.orientation;
      break;
      paramInt = 0;
      break label282;
      paramInt = 90;
      break label282;
      paramInt = 180;
      break label282;
      paramInt = 270;
      break label282;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.g
 * JD-Core Version:    0.7.0.1
 */