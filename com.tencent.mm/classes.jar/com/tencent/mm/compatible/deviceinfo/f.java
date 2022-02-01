package com.tencent.mm.compatible.deviceinfo;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class f
  implements d.a
{
  @TargetApi(8)
  public static d.a.a a(int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155649);
    d.a.a locala = new d.a.a();
    try
    {
      locala.gGr = w.e(paramLooper);
      locala.dYT = 90;
      if (locala.gGr == null)
      {
        AppMethodBeat.o(155649);
        return null;
      }
    }
    catch (Exception paramLooper)
    {
      AppMethodBeat.o(155649);
      return null;
    }
    paramLooper = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, paramLooper);
    switch (((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default: 
      paramInt = 0;
      if (paramLooper.facing != 1) {
        break;
      }
    }
    for (int i = (360 - (paramLooper.orientation + paramInt) % 360) % 360;; i = (paramLooper.orientation - paramInt + 360) % 360)
    {
      Log.d("MicroMsg.CameraUtil.CameraUtilImpl22", "CameraUtilImpl22, open camera, info.orientation: %d, degrees: %d, result:%d", new Object[] { Integer.valueOf(paramLooper.orientation), Integer.valueOf(paramInt), Integer.valueOf(i) });
      locala.gGr.setDisplayOrientation(i);
      AppMethodBeat.o(155649);
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
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.f
 * JD-Core Version:    0.7.0.1
 */