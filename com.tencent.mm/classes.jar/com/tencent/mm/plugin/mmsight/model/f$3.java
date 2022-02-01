package com.tencent.mm.plugin.mmsight.model;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.List;

final class f$3
  implements Camera.AutoFocusCallback
{
  f$3(f paramf) {}
  
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(89363);
    if ((paramCamera != null) && (this.wac.cOB())) {
      try
      {
        Camera.Parameters localParameters = paramCamera.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("continuous-picture")))
        {
          ae.i("MicroMsg.MMSightCameraSetting", "support continues picture focus");
          localParameters.setFocusMode("continuous-picture");
          paramCamera.setParameters(localParameters);
        }
        AppMethodBeat.o(89363);
        return;
      }
      catch (Exception paramCamera)
      {
        ae.printErrStackTrace("MicroMsg.MMSightCamera", paramCamera, "simple auto focus resetToPictureFocus error", new Object[0]);
      }
    }
    AppMethodBeat.o(89363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.f.3
 * JD-Core Version:    0.7.0.1
 */