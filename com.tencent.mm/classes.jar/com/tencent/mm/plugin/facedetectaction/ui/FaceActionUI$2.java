package com.tencent.mm.plugin.facedetectaction.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetectaction.b.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class FaceActionUI$2
  implements d.a
{
  FaceActionUI$2(FaceActionUI paramFaceActionUI) {}
  
  public final void Nv(String paramString)
  {
    AppMethodBeat.i(718);
    ab.i("MicroMsg.FaceActionUI", "onVerifyFinish:   authToken ：%s", new Object[] { paramString });
    al.d(new FaceActionUI.2.3(this, paramString));
    AppMethodBeat.o(718);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(719);
    ab.i("MicroMsg.FaceActionUI", "onError, err: %s, cgiErrCode: %s, cgiErrMsg: %s,retry: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3) });
    FaceActionUI.b(this.mrl, paramInt1);
    FaceActionUI.c(this.mrl, paramInt2);
    FaceActionUI.b(this.mrl, paramString);
    al.d(new FaceActionUI.2.4(this, paramString, paramInt3, paramInt2));
    AppMethodBeat.o(719);
  }
  
  public final void aA(int paramInt, String paramString)
  {
    AppMethodBeat.i(716);
    ab.i("MicroMsg.FaceActionUI", "onInitFaceCheckFinish: %s", new Object[] { Integer.valueOf(paramInt) });
    al.d(new FaceActionUI.2.1(this, paramInt, paramString));
    AppMethodBeat.o(716);
  }
  
  public final void bvG()
  {
    AppMethodBeat.i(717);
    ab.i("MicroMsg.FaceActionUI", "onStartUpload");
    al.d(new FaceActionUI.2.2(this));
    AppMethodBeat.o(717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.2
 * JD-Core Version:    0.7.0.1
 */