package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.o;

public final class a
  extends o
{
  private a ibo;
  
  public a(a parama)
  {
    super(2, null);
    this.ibo = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63470);
    if (this.ibo != null) {
      this.ibo.aHn();
    }
    AppMethodBeat.o(63470);
  }
  
  public static abstract interface a
  {
    public abstract void aHn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.a
 * JD-Core Version:    0.7.0.1
 */