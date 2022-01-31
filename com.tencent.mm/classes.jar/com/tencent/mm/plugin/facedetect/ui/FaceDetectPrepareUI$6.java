package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class FaceDetectPrepareUI$6
  implements c
{
  FaceDetectPrepareUI$6(FaceDetectPrepareUI paramFaceDetectPrepareUI) {}
  
  public final void aw(int paramInt, String paramString)
  {
    AppMethodBeat.i(406);
    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigFailed, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(90015), paramString });
    paramInt = FaceDetectPrepareUI.vM(paramInt);
    FaceDetectPrepareUI.a(this.mlC, paramInt, 90015, paramString, this.mlC.getString(2131299566));
    AppMethodBeat.o(406);
  }
  
  public final void e(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(405);
    ab.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigSuccess, bioId: %d, isCancel: %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(FaceDetectPrepareUI.h(this.mlC)) });
    if (FaceDetectPrepareUI.h(this.mlC))
    {
      AppMethodBeat.o(405);
      return;
    }
    FaceDetectPrepareUI.a(this.mlC, paramLong);
    FaceDetectPrepareUI.a(this.mlC, paramArrayOfByte);
    FaceDetectPrepareUI.a(this.mlC, paramLong, paramArrayOfByte);
    AppMethodBeat.o(405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.6
 * JD-Core Version:    0.7.0.1
 */