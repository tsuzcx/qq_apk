package com.tencent.mm.plugin.box.c;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements View.OnTouchListener
{
  a$1(a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76331);
    this.mRJ.dismiss();
    AppMethodBeat.o(76331);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.c.a.1
 * JD-Core Version:    0.7.0.1
 */