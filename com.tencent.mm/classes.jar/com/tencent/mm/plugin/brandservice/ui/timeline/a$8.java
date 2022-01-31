package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.q;

final class a$8
  implements View.OnLongClickListener
{
  a$8(a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(14105);
    this.jVZ.jVF = ((q)paramView.getTag());
    this.jVZ.jVH = 0;
    a.e(this.jVZ).a(paramView, this.jVZ, a.b(this.jVZ), a.c(this.jVZ), a.d(this.jVZ));
    AppMethodBeat.o(14105);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.8
 * JD-Core Version:    0.7.0.1
 */