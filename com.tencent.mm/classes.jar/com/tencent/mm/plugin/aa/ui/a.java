package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.t;

public final class a
  extends t
{
  private a pIm;
  
  public a(a parama)
  {
    super(2, null);
    this.pIm = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63470);
    if (this.pIm != null) {
      this.pIm.bVr();
    }
    AppMethodBeat.o(63470);
  }
  
  public static abstract interface a
  {
    public abstract void bVr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.a
 * JD-Core Version:    0.7.0.1
 */