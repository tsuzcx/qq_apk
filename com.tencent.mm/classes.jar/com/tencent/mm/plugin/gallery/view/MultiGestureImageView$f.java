package com.tencent.mm.plugin.gallery.view;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MultiGestureImageView$f
  extends MultiGestureImageView.a
{
  float[] nhN;
  MultiTouchImageView nhO;
  
  public MultiGestureImageView$f(MultiGestureImageView paramMultiGestureImageView, MultiTouchImageView paramMultiTouchImageView)
  {
    super(paramMultiGestureImageView);
    AppMethodBeat.i(21625);
    this.nhN = new float[9];
    this.nhO = paramMultiTouchImageView;
    AppMethodBeat.o(21625);
  }
  
  public final void play()
  {
    AppMethodBeat.i(21626);
    MultiGestureImageView.h(this.nhM).getHandler().post(new MultiGestureImageView.f.1(this));
    AppMethodBeat.o(21626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.f
 * JD-Core Version:    0.7.0.1
 */