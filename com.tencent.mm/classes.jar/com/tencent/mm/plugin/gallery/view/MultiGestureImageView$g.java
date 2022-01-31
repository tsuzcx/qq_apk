package com.tencent.mm.plugin.gallery.view;

import android.os.Handler;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MultiGestureImageView$g
  extends MultiGestureImageView.a
{
  float[] kLk = new float[9];
  MultiTouchImageView kLl;
  
  public MultiGestureImageView$g(MultiGestureImageView paramMultiGestureImageView, MultiTouchImageView paramMultiTouchImageView)
  {
    super(paramMultiGestureImageView);
    this.kLl = paramMultiTouchImageView;
  }
  
  public final void play()
  {
    MultiGestureImageView.h(this.kLj).getHandler().post(new MultiGestureImageView.g.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.g
 * JD-Core Version:    0.7.0.1
 */