package com.tencent.mm.plugin.appbrand.widget.i;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$7
  implements View.OnClickListener
{
  a$7(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(87536);
    int i = this.jwQ.jwD.indexOfChild(paramView);
    this.jwQ.qX(i);
    this.jwQ.aSo();
    AppMethodBeat.o(87536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.a.7
 * JD-Core Version:    0.7.0.1
 */