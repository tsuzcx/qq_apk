package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.n;

public final class a
  extends n
{
  private a.a gpk;
  
  public a(a.a parama)
  {
    super(2, null);
    this.gpk = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40707);
    if (this.gpk != null) {
      this.gpk.aoW();
    }
    AppMethodBeat.o(40707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.a
 * JD-Core Version:    0.7.0.1
 */