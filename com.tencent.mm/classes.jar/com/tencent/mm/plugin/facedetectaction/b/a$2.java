package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceDetectResult;

public final class a$2
  implements YTFaceTraceInterface.FaceDetectResult
{
  public a$2(a parama) {}
  
  public final void onFailed(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(680);
    ab.i("MicroMsg.FaceActionLogic", "camera detect failed: errorCode：%s 、message：%s、tips ：%s ", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    AppMethodBeat.o(680);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(679);
    ab.i("MicroMsg.FaceActionLogic", "camera detect success ");
    AppMethodBeat.o(679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.a.2
 * JD-Core Version:    0.7.0.1
 */