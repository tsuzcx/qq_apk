package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$3
  implements View.OnClickListener
{
  k$3(k paramk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55965);
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    k.a(this.ubG, arrayOfInt[0], arrayOfInt[1]);
    AppMethodBeat.o(55965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k.3
 * JD-Core Version:    0.7.0.1
 */