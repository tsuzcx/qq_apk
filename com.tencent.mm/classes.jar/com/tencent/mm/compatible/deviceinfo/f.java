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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

final class f
  implements d.a
{
  public final d.a.a a(final int paramInt, Looper paramLooper)
  {
    int k = 90;
    AppMethodBeat.i(155649);
    d.a.a locala = new d.a.a();
    try
    {
      locala.lTN = x.g(paramLooper);
      locala.hYK = 90;
      if (locala.lTN == null)
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
          AppMethodBeat.i(240850);
          try
          {
            Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(paramInt, localCameraInfo);
            a locala = a.lQF;
            a.a(paramInt, localCameraInfo);
            AppMethodBeat.o(240850);
            return;
          }
          finally
          {
            Log.e("MicroMsg.CameraUtil.CameraUtilImpl22", "CameraUtilImpl22 update cache failed : " + localObject.getMessage());
            AppMethodBeat.o(240850);
          }
        }
      }, "openCamera-checkCache");
      paramInt = k;
      switch (((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getRotation())
      {
      default: 
        paramInt = 0;
      case 1: 
        label166:
        if (j != 1) {
          break;
        }
      }
    }
    for (int j = (360 - (i + paramInt) % 360) % 360;; j = (i - paramInt + 360) % 360)
    {
      Log.d("MicroMsg.CameraUtil.CameraUtilImpl22", "CameraUtilImpl22, open camera, info.orientation: %d, degrees: %d, result:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
      locala.lTN.qV(j);
      AppMethodBeat.o(155649);
      return locala;
      Camera.getCameraInfo(paramInt, paramLooper);
      j = paramLooper.facing;
      i = paramLooper.orientation;
      break;
      paramInt = 0;
      break label166;
      paramInt = 180;
      break label166;
      paramInt = 270;
      break label166;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.f
 * JD-Core Version:    0.7.0.1
 */