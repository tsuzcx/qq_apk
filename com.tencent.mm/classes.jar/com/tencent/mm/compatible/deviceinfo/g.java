package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  implements d.a
{
  public static d.a.a a(Context paramContext, int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155650);
    d.a.a locala = new d.a.a();
    locala.fYS = null;
    try
    {
      l = bt.HI();
      ad.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", new Object[] { Integer.valueOf(paramInt) });
      locala.fYS = w.b(paramInt, paramLooper);
      ad.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back,  %dms", new Object[] { Long.valueOf(bt.aO(l)) });
      if (locala.fYS == null)
      {
        ad.e("MicroMsg.CameraUtil", "open camera error, not exception, but camera null");
        AppMethodBeat.o(155650);
        return null;
      }
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.CameraUtil", "open camera error %s", new Object[] { paramContext.getMessage() });
      ad.printErrStackTrace("MicroMsg.CameraUtil", paramContext, "", new Object[0]);
      AppMethodBeat.o(155650);
      return null;
    }
    paramLooper = new Camera.CameraInfo();
    long l = bt.HI();
    ad.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", new Object[] { Integer.valueOf(paramInt) });
    Camera.getCameraInfo(paramInt, paramLooper);
    ad.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", new Object[] { Long.valueOf(bt.aO(l)) });
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
      l = bt.HI();
      ad.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      locala.fYS.setDisplayOrientation(paramInt);
      ad.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", new Object[] { Long.valueOf(bt.aO(l)) });
      locala.dGc = paramLooper.orientation;
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