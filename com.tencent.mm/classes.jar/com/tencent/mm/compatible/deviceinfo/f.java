package com.tencent.mm.compatible.deviceinfo;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.c.a;
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
      locala.jqD = x.f(paramLooper);
      locala.fSM = 90;
      if (locala.jqD == null)
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
    if (d.gaj)
    {
      paramLooper = a.jnC.qJ(paramInt);
      switch (((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getRotation())
      {
      default: 
        paramInt = 0;
        label122:
        if (paramLooper.facing != 1) {
          break;
        }
      }
    }
    for (int i = (360 - (paramLooper.orientation + paramInt) % 360) % 360;; i = (paramLooper.orientation - paramInt + 360) % 360)
    {
      Log.d("MicroMsg.CameraUtil.CameraUtilImpl22", "CameraUtilImpl22, open camera, info.orientation: %d, degrees: %d, result:%d", new Object[] { Integer.valueOf(paramLooper.orientation), Integer.valueOf(paramInt), Integer.valueOf(i) });
      locala.jqD.qO(i);
      AppMethodBeat.o(155649);
      return locala;
      Camera.getCameraInfo(paramInt, paramLooper);
      break;
      paramInt = 0;
      break label122;
      paramInt = 90;
      break label122;
      paramInt = 180;
      break label122;
      paramInt = 270;
      break label122;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.f
 * JD-Core Version:    0.7.0.1
 */