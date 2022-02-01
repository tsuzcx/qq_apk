package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class c
  extends d
  implements e.b
{
  private com.tencent.mm.plugin.fts.ui.e.a HwW;
  protected boolean HwX;
  private MMHandler HwY;
  
  public c(e parame)
  {
    super(parame);
    AppMethodBeat.i(111813);
    this.HwY = new MMHandler(Looper.getMainLooper());
    this.HwW = new com.tencent.mm.plugin.fts.ui.e.a(parame.getContext(), this, 0);
    AppMethodBeat.o(111813);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a Wj(int paramInt)
  {
    AppMethodBeat.i(111814);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.HwW.Wj(paramInt);
    AppMethodBeat.o(111814);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(265604);
    int i = this.HwW.Wi(0);
    setCount(i);
    notifyDataSetChanged();
    aZ(i, true);
    AppMethodBeat.o(265604);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    return false;
  }
  
  protected final int fxI()
  {
    AppMethodBeat.i(111817);
    int i = this.HwW.fyc();
    AppMethodBeat.o(111817);
    return i;
  }
  
  protected final void fyd()
  {
    AppMethodBeat.i(111815);
    this.HwX = false;
    this.HwW.a(getQuery(), this.HwY, new HashSet());
    AppMethodBeat.o(111815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c
 * JD-Core Version:    0.7.0.1
 */