package com.tencent.mm.plugin.gallery.view;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class MultiGestureImageView$g
  extends MultiGestureImageView.a
{
  float[] nhN;
  MultiTouchImageView nhO;
  
  public MultiGestureImageView$g(MultiGestureImageView paramMultiGestureImageView, MultiTouchImageView paramMultiTouchImageView)
  {
    super(paramMultiGestureImageView);
    AppMethodBeat.i(21628);
    this.nhN = new float[9];
    this.nhO = paramMultiTouchImageView;
    AppMethodBeat.o(21628);
  }
  
  public final void play()
  {
    AppMethodBeat.i(21629);
    MultiGestureImageView.h(this.nhM).getHandler().post(new MultiGestureImageView.g.1(this));
    AppMethodBeat.o(21629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView.g
 * JD-Core Version:    0.7.0.1
 */