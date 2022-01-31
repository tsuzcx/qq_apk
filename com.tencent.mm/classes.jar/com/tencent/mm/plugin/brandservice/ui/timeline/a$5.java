package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.q;

final class a$5
  implements View.OnLongClickListener
{
  a$5(a parama, q paramq, int paramInt) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(14102);
    this.jVZ.jVF = this.jMz;
    this.jVZ.jVG = this.jMC;
    this.jVZ.jVH = 1;
    a.e(this.jVZ).a(paramView, this.jVZ, a.b(this.jVZ), a.c(this.jVZ), a.d(this.jVZ));
    AppMethodBeat.o(14102);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.5
 * JD-Core Version:    0.7.0.1
 */