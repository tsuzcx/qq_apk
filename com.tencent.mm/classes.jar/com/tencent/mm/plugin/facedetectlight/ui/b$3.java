package com.tencent.mm.plugin.facedetectlight.ui;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceDetectResult;

final class b$3
  implements YTFaceTraceInterface.FaceDetectResult
{
  b$3(b paramb) {}
  
  public final void onFailed(int paramInt, String paramString1, String paramString2)
  {
    y.i("MicroMsg.FaceReflectLogic", "camera detect failed: errorCode：%s 、message：%s、tips ：%s ", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
  }
  
  public final void onSuccess()
  {
    y.i("MicroMsg.FaceReflectLogic", "camera detect success ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b.3
 * JD-Core Version:    0.7.0.1
 */