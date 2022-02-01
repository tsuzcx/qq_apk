package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.e.m;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class n
  extends d
  implements e.b
{
  private boolean HyH;
  private m Hzo;
  private MMHandler tiG;
  
  public n(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(112024);
    this.tiG = new MMHandler();
    this.Hzo = new m(parame.getContext(), this, paramInt);
    this.Hzo.Htw = paramString;
    AppMethodBeat.o(112024);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a Wj(int paramInt)
  {
    AppMethodBeat.i(112025);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.Hzo.Wj(paramInt);
    if (locala != null) {
      locala.pageType = 3;
    }
    AppMethodBeat.o(112025);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(265623);
    setCount(parame.Wi(0));
    notifyDataSetChanged();
    aZ(getCount(), true);
    AppMethodBeat.o(265623);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112027);
    paramBoolean = this.Hzo.a(paramView, parama, paramBoolean);
    if ((parama.Huy) && (!this.HyH))
    {
      this.HyH = true;
      l.c(getQuery(), true, this.Hzo.fyc(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.Hzo.Wi(0));
      notifyDataSetChanged();
      aZ(getCount(), true);
    }
    AppMethodBeat.o(112027);
    return paramBoolean;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(112029);
    super.finish();
    if (!this.HyH)
    {
      this.HyH = true;
      l.c(getQuery(), false, this.Hzo.fyc(), -2);
    }
    AppMethodBeat.o(112029);
  }
  
  protected final int fxI()
  {
    AppMethodBeat.i(369732);
    int i = this.Hzo.fyc();
    AppMethodBeat.o(369732);
    return i;
  }
  
  protected final void fyd()
  {
    AppMethodBeat.i(112026);
    this.HyH = false;
    this.Hzo.a(getQuery(), this.tiG, new HashSet());
    AppMethodBeat.o(112026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.n
 * JD-Core Version:    0.7.0.1
 */