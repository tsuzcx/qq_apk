package com.tencent.mapsdk.internal;

import android.content.Context;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pu
  extends ListView
{
  private a a;
  
  public pu(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void handleDataChanged()
  {
    AppMethodBeat.i(225690);
    super.handleDataChanged();
    if (this.a != null) {
      this.a.g();
    }
    AppMethodBeat.o(225690);
  }
  
  public final void setOnDataChangedListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pu
 * JD-Core Version:    0.7.0.1
 */