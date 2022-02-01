package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.p;

public final class a
  extends p
{
  private a.a jUr;
  
  public a(a.a parama)
  {
    super(2, null);
    this.jUr = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63470);
    if (this.jUr != null) {
      this.jUr.bmr();
    }
    AppMethodBeat.o(63470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.a
 * JD-Core Version:    0.7.0.1
 */