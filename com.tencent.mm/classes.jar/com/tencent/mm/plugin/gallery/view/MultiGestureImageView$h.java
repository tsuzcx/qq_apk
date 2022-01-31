package com.tencent.mm.plugin.gallery.view;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MultiGestureImageView$h
  extends MultiGestureImageView.a
{
  float[] nhN;
  MultiTouchImageView nhO;
  
  public MultiGestureImageView$h(MultiGestureImageView paramMultiGestureImageView, MultiTouchImageView paramMultiTouchImageView)
  {
    super(paramMultiGestureImageView);
    AppMethodBeat.i(21631);
    this.nhN = new float[9];
    this.nhO = paramMultiTouchImageView;
    AppMethodBeat.o(21631);
  }
  
  public final void play()
  {
    AppMethodBeat.i(21632);
    MultiGestureImageView.h(this.nhM).getHandler().post(new MultiGestureImageView.h.1(this));
    AppMethodBeat.o(21632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.h
 * JD-Core Version:    0.7.0.1
 */