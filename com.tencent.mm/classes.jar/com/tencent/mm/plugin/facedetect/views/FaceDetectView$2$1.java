package com.tencent.mm.plugin.facedetect.views;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

final class FaceDetectView$2$1
  implements Runnable
{
  FaceDetectView$2$1(FaceDetectView.2 param2, Bitmap paramBitmap) {}
  
  public final void run()
  {
    FaceDetectView.i(this.jUK.jUI).setVisibility(0);
    FaceDetectView.i(this.jUK.jUI).setBackgroundDrawable(new BitmapDrawable(this.jUJ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView.2.1
 * JD-Core Version:    0.7.0.1
 */