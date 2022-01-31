package com.tencent.mm.plugin.facedetect.views;

final class FaceNumberItemView$1
  implements Runnable
{
  FaceNumberItemView$1(FaceNumberItemView paramFaceNumberItemView) {}
  
  public final void run()
  {
    if (FaceNumberItemView.a(this.jUV) <= 30)
    {
      FaceNumberItemView.b(this.jUV);
      this.jUV.invalidate();
      return;
    }
    this.jUV.aPv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceNumberItemView.1
 * JD-Core Version:    0.7.0.1
 */