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
  private com.tencent.mm.plugin.fts.ui.d.a tyl;
  protected boolean tym;
  private ap tyn;
  
  public c(e parame)
  {
    super(parame);
    AppMethodBeat.i(111813);
    this.tyn = new ap(Looper.getMainLooper());
    this.tyl = new com.tencent.mm.plugin.fts.ui.d.a(parame.getContext(), this, 0);
    AppMethodBeat.o(111813);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a GR(int paramInt)
  {
    AppMethodBeat.i(111814);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.tyl.GR(paramInt);
    AppMethodBeat.o(111814);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111816);
    int i = this.tyl.GQ(0);
    setCount(i);
    notifyDataSetChanged();
    al(i, true);
    AppMethodBeat.o(111816);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    return false;
  }
  
  protected final int cSU()
  {
    AppMethodBeat.i(111817);
    int i = this.tyl.cTm();
    AppMethodBeat.o(111817);
    return i;
  }
  
  protected final void cTn()
  {
    AppMethodBeat.i(111815);
    this.tym = false;
    this.tyl.a(this.query, this.tyn, new HashSet(), 0L);
    AppMethodBeat.o(111815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c
 * JD-Core Version:    0.7.0.1
 */