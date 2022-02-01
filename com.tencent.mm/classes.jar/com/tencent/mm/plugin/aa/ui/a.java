package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.p;

public final class a
  extends p
{
  private a mLE;
  
  public a(a parama)
  {
    super(2, null);
    this.mLE = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63470);
    if (this.mLE != null) {
      this.mLE.bwz();
    }
    AppMethodBeat.o(63470);
  }
  
  public static abstract interface a
  {
    public abstract void bwz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.a
 * JD-Core Version:    0.7.0.1
 */