package com.tencent.mm.plugin.gallery.view;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MultiGestureImageView$e
  extends MultiGestureImageView.a
{
  float[] nhN;
  MultiTouchImageView nhO;
  
  public MultiGestureImageView$e(MultiGestureImageView paramMultiGestureImageView, MultiTouchImageView paramMultiTouchImageView)
  {
    super(paramMultiGestureImageView);
    AppMethodBeat.i(21622);
    this.nhN = new float[9];
    this.nhO = paramMultiTouchImageView;
    AppMethodBeat.o(21622);
  }
  
  public final void play()
  {
    AppMethodBeat.i(21623);
    MultiGestureImageView.h(this.nhM).getHandler().post(new MultiGestureImageView.e.1(this));
    AppMethodBeat.o(21623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.e
 * JD-Core Version:    0.7.0.1
 */