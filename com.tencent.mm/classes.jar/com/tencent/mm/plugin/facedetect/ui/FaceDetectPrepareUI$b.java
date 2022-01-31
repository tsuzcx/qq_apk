package com.tencent.mm.plugin.facedetect.ui;

import android.os.Bundle;

final class FaceDetectPrepareUI$b
{
  int errCode;
  String errMsg;
  int errType;
  Bundle extras;
  
  private FaceDetectPrepareUI$b(FaceDetectPrepareUI paramFaceDetectPrepareUI) {}
  
  final void e(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.errMsg = paramString;
    this.extras = paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI.b
 * JD-Core Version:    0.7.0.1
 */