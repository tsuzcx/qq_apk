package com.tencent.mm.compatible.e;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
  implements d.a
{
  public static d.a.a a(Context paramContext, int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(92929);
    d.a.a locala = new d.a.a();
    locala.eoH = null;
    try
    {
      l = bo.yB();
      ab.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", new Object[] { Integer.valueOf(paramInt) });
      locala.eoH = v.b(paramInt, paramLooper);
      ab.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back, use %dms", new Object[] { Long.valueOf(bo.av(l)) });
      if (locala.eoH == null)
      {
        ab.e("MicroMsg.CameraUtil", "open camera error, not exception, but camera null");
        AppMethodBeat.o(92929);
        return null;
      }
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.CameraUtil", "open camera error %s", new Object[] { paramContext.getMessage() });
      ab.printErrStackTrace("MicroMsg.CameraUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(92929);
      return null;
    }
    paramLooper = new Camera.CameraInfo();
    long l = bo.yB();
    ab.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", new Object[] { Integer.valueOf(paramInt) });
    Camera.getCameraInfo(paramInt, paramLooper);
    ab.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", new Object[] { Long.valueOf(bo.av(l)) });
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
      l = bo.yB();
      ab.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      locala.eoH.setDisplayOrientation(paramInt);
      ab.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", new Object[] { Long.valueOf(bo.av(l)) });
      locala.rotate = paramLooper.orientation;
      AppMethodBeat.o(92929);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.compatible.e.g
 * JD-Core Version:    0.7.0.1
 */