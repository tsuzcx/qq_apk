package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.o;

public final class a
  extends o
{
  private a iXu;
  
  public a(a parama)
  {
    super(2, null);
    this.iXu = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63470);
    if (this.iXu != null) {
      this.iXu.aRM();
    }
    AppMethodBeat.o(63470);
  }
  
  public static abstract interface a
  {
    public abstract void aRM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.a
 * JD-Core Version:    0.7.0.1
 */