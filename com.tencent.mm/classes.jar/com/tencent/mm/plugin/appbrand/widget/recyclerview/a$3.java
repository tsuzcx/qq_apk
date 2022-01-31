package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$3
  implements View.OnLongClickListener
{
  a$3(a parama, RecyclerView.v paramv, int paramInt) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(77463);
    if (a.c(this.jwm) != null)
    {
      boolean bool = a.c(this.jwm).M(this.acv.aku, this.jwn);
      AppMethodBeat.o(77463);
      return bool;
    }
    AppMethodBeat.o(77463);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.a.3
 * JD-Core Version:    0.7.0.1
 */