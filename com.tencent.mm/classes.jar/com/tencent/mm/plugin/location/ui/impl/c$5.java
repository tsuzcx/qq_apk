package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$5
  implements AdapterView.OnItemClickListener
{
  c$5(c paramc) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(113599);
    paramView = null;
    paramAdapterView = paramView;
    if (paramInt >= 0)
    {
      paramAdapterView = paramView;
      if (paramInt < c.v(this.ogD).getCount()) {
        paramAdapterView = c.v(this.ogD).ye(paramInt);
      }
    }
    c.b(this.ogD, paramAdapterView);
    c.a(this.ogD, paramAdapterView);
    AppMethodBeat.o(113599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.5
 * JD-Core Version:    0.7.0.1
 */