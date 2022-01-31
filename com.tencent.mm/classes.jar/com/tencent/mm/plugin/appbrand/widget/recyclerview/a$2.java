package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama, RecyclerView.v paramv, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(77462);
    if (a.b(this.jwm) != null) {
      a.b(this.jwm).L(this.acv.aku, this.jwn);
    }
    AppMethodBeat.o(77462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.a.2
 * JD-Core Version:    0.7.0.1
 */