package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class c
  extends d
  implements e.b
{
  private com.tencent.mm.plugin.fts.ui.d.a mWb;
  protected boolean mWc;
  private ak mWd;
  
  public c(e parame)
  {
    super(parame);
    AppMethodBeat.i(61720);
    this.mWd = new ak(Looper.getMainLooper());
    this.mWb = new com.tencent.mm.plugin.fts.ui.d.a(parame.getContext(), this, 0);
    AppMethodBeat.o(61720);
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(61723);
    int i = this.mWb.wt(0);
    setCount(i);
    notifyDataSetChanged();
    V(i, true);
    AppMethodBeat.o(61723);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    return false;
  }
  
  protected final int bCf()
  {
    AppMethodBeat.i(61724);
    int i = this.mWb.bCx();
    AppMethodBeat.o(61724);
    return i;
  }
  
  protected final void bCy()
  {
    AppMethodBeat.i(61722);
    this.mWc = false;
    this.mWb.a(this.query, this.mWd, new HashSet(), 0L);
    AppMethodBeat.o(61722);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a wu(int paramInt)
  {
    AppMethodBeat.i(61721);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.mWb.wu(paramInt);
    AppMethodBeat.o(61721);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c
 * JD-Core Version:    0.7.0.1
 */