package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2
  extends DataSetObserver
{
  c$2(c paramc) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(123899);
    if (!this.jpl.joV.aht.isShowing())
    {
      AppMethodBeat.o(123899);
      return;
    }
    this.jpl.qD(1);
    AppMethodBeat.o(123899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.c.2
 * JD-Core Version:    0.7.0.1
 */