package com.tencent.mm.plugin.facedetectlight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceDetectResult;

final class c$3
  implements YTFaceTraceInterface.FaceDetectResult
{
  c$3(c paramc) {}
  
  public final void onFailed(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(791);
    ab.i("MicroMsg.FaceReflectLogic", "camera detect failed: errorCode：%s 、message：%s、tips ：%s ", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(791);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(790);
    ab.i("MicroMsg.FaceReflectLogic", "camera detect success ");
    AppMethodBeat.o(790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.c.3
 * JD-Core Version:    0.7.0.1
 */