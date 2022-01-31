package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

final class FaceReflectUI$1
  implements View.OnClickListener
{
  FaceReflectUI$1(FaceReflectUI paramFaceReflectUI) {}
  
  public final void onClick(View paramView)
  {
    FaceReflectUI.a(this.jXT).setVisibility(8);
    FaceReflectUI.b(this.jXT).setVisibility(0);
    FaceReflectUI.c(this.jXT).setVisibility(4);
    FaceReflectUI.c(this.jXT).post(new FaceReflectUI.1.1(this));
    FaceReflectUI.f(this.jXT).setVisibility(0);
    FaceReflectUI.g(this.jXT).setTextColor(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.FaceReflectUI.1
 * JD-Core Version:    0.7.0.1
 */