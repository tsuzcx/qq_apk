package com.tencent.mm.plugin.facedetectaction.ui;

import com.tencent.mm.plugin.facedetectaction.b.d.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class FaceActionUI$2
  implements d.a
{
  FaceActionUI$2(FaceActionUI paramFaceActionUI) {}
  
  public final void Cu(String paramString)
  {
    y.i("MicroMsg.FaceActionUI", "onVerifyFinish:   authToken ：%s", new Object[] { paramString });
    ai.d(new FaceActionUI.2.3(this, paramString));
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    y.i("MicroMsg.FaceActionUI", "onError, err: %s, cgiErrCode: %s, cgiErrMsg: %s,retry: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3) });
    FaceActionUI.b(this.jWU, paramInt1);
    FaceActionUI.c(this.jWU, paramInt2);
    FaceActionUI.b(this.jWU, paramString);
    ai.d(new FaceActionUI.2.4(this, paramString, paramInt3, paramInt2));
  }
  
  public final void aPx()
  {
    y.i("MicroMsg.FaceActionUI", "onStartUpload");
    ai.d(new FaceActionUI.2.2(this));
  }
  
  public final void ah(int paramInt, String paramString)
  {
    y.i("MicroMsg.FaceActionUI", "onInitFaceCheckFinish: %s", new Object[] { Integer.valueOf(paramInt) });
    ai.d(new FaceActionUI.2.1(this, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.2
 * JD-Core Version:    0.7.0.1
 */