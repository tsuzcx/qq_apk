package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;

public final class c
  extends d
  implements e.b
{
  private com.tencent.mm.plugin.fts.ui.d.a rsQ;
  protected boolean rsR;
  private ap rsS;
  
  public c(e parame)
  {
    super(parame);
    AppMethodBeat.i(111813);
    this.rsS = new ap(Looper.getMainLooper());
    this.rsQ = new com.tencent.mm.plugin.fts.ui.d.a(parame.getContext(), this, 0);
    AppMethodBeat.o(111813);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a DG(int paramInt)
  {
    AppMethodBeat.i(111814);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.rsQ.DG(paramInt);
    AppMethodBeat.o(111814);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111816);
    int i = this.rsQ.DF(0);
    setCount(i);
    notifyDataSetChanged();
    ae(i, true);
    AppMethodBeat.o(111816);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    return false;
  }
  
  protected final void cxM()
  {
    AppMethodBeat.i(111815);
    this.rsR = false;
    this.rsQ.a(this.query, this.rsS, new HashSet(), 0L);
    AppMethodBeat.o(111815);
  }
  
  protected final int cxt()
  {
    AppMethodBeat.i(111817);
    int i = this.rsQ.cxL();
    AppMethodBeat.o(111817);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c
 * JD-Core Version:    0.7.0.1
 */