package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.plugin.facedetect.model.c;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class b$4
  implements Runnable
{
  b$4(b paramb, SurfaceTexture paramSurfaceTexture) {}
  
  public final void run()
  {
    AppMethodBeat.i(763);
    try
    {
      b.a(this.mrQ, this.iie);
      b localb = this.mrQ;
      Camera.PreviewCallback localPreviewCallback = b.v(this.mrQ);
      if (localb.mrD == null)
      {
        ab.w("MicroMsg.FaceReflectCam", "hy: camera is null. setPreviewCallback failed");
        AppMethodBeat.o(763);
        return;
      }
      int j = localb.mDesiredPreviewWidth * localb.mDesiredPreviewHeight * ImageFormat.getBitsPerPixel(localb.mrD.getParameters().getPreviewFormat()) / 8;
      int i = 0;
      while (i < 5)
      {
        byte[] arrayOfByte = c.mhN.f(Integer.valueOf(j));
        localb.mrD.addCallbackBuffer(arrayOfByte);
        i += 1;
      }
      localb.mrD.setPreviewCallbackWithBuffer(new b.9(localb, localPreviewCallback));
      d.bui().a(localb.moz);
      AppMethodBeat.o(763);
      return;
    }
    catch (Exception localException)
    {
      if (b.e(this.mrQ) == 1)
      {
        b.h(this.mrQ).u(90016, "preview error", ah.getContext().getString(2131304062));
        AppMethodBeat.o(763);
        return;
      }
      ab.i("MicroMsg.FaceReflectCam", "preview error");
      AppMethodBeat.o(763);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b.4
 * JD-Core Version:    0.7.0.1
 */