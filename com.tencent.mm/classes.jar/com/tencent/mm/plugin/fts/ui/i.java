package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.e.g;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class i
  extends d
  implements e.b
{
  private boolean HyH;
  private g HyK;
  private MMHandler tiG;
  
  public i(e parame, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(111919);
    this.tiG = new MMHandler();
    this.HyK = new g(parame.getContext(), this, paramInt1);
    this.HyK.Htw = paramString2;
    this.HyK.talker = paramString1;
    this.HyK.Htv = paramString3;
    this.HyK.hAN = paramInt2;
    AppMethodBeat.o(111919);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a Wj(int paramInt)
  {
    AppMethodBeat.i(111920);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.HyK.Wj(paramInt);
    if (locala != null) {
      locala.pageType = 5;
    }
    AppMethodBeat.o(111920);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(265646);
    setCount(parame.Wi(0));
    notifyDataSetChanged();
    aZ(getCount(), true);
    AppMethodBeat.o(265646);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111922);
    paramBoolean = this.HyK.a(paramView, parama, paramBoolean);
    if ((parama.Huy) && (!this.HyH))
    {
      this.HyH = true;
      l.c(getQuery(), true, this.HyK.fyc(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.HyK.Wi(0));
      notifyDataSetChanged();
      aZ(getCount(), true);
    }
    AppMethodBeat.o(111922);
    return paramBoolean;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111924);
    super.finish();
    if (!this.HyH)
    {
      this.HyH = true;
      l.c(getQuery(), false, this.HyK.fyc(), -2);
    }
    AppMethodBeat.o(111924);
  }
  
  protected final int fxI()
  {
    AppMethodBeat.i(369733);
    int i = this.HyK.fyc();
    AppMethodBeat.o(369733);
    return i;
  }
  
  protected final void fyd()
  {
    AppMethodBeat.i(111921);
    this.HyH = false;
    this.HyK.a(getQuery(), this.tiG, new HashSet());
    AppMethodBeat.o(111921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.i
 * JD-Core Version:    0.7.0.1
 */