package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult;

public final class a$1
  implements YTPoseDetectInterface.PoseDetectResult
{
  public a$1(a parama) {}
  
  public final void onFailed(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104202);
    ac.i("MicroMsg.FaceActionLogic", "onFailed s:" + paramString1 + " s1:" + paramString2);
    AppMethodBeat.o(104202);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(104201);
    ac.i("MicroMsg.FaceActionLogic", "onSuccess");
    AppMethodBeat.o(104201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.a.1
 * JD-Core Version:    0.7.0.1
 */