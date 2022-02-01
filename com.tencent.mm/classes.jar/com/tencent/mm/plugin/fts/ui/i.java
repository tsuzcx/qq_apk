package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.g;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class i
  extends d
  implements e.b
{
  private MMHandler ndA;
  private boolean xbo;
  private g xbr;
  
  public i(e parame, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(111919);
    this.ndA = new MMHandler();
    this.xbr = new g(parame.getContext(), this, paramInt1);
    this.xbr.wWT = paramString2;
    this.xbr.talker = paramString1;
    this.xbr.wWS = paramString3;
    this.xbr.dDG = paramInt2;
    AppMethodBeat.o(111919);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a No(int paramInt)
  {
    AppMethodBeat.i(111920);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.xbr.No(paramInt);
    if (locala != null) {
      locala.pageType = 5;
    }
    AppMethodBeat.o(111920);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111923);
    setCount(parame.Nn(0));
    notifyDataSetChanged();
    ax(getCount(), true);
    AppMethodBeat.o(111923);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111922);
    paramBoolean = this.xbr.a(paramView, parama, paramBoolean);
    if ((parama.wXT) && (!this.xbo))
    {
      this.xbo = true;
      l.c(this.query, true, this.xbr.dPa(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.xbr.Nn(0));
      notifyDataSetChanged();
      ax(getCount(), true);
    }
    AppMethodBeat.o(111922);
    return paramBoolean;
  }
  
  protected final int dOI()
  {
    AppMethodBeat.i(258736);
    int i = this.xbr.dPa();
    AppMethodBeat.o(258736);
    return i;
  }
  
  protected final void dPb()
  {
    AppMethodBeat.i(111921);
    this.xbo = false;
    this.xbr.a(this.query, this.ndA, new HashSet(), 0L);
    AppMethodBeat.o(111921);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111924);
    super.finish();
    if (!this.xbo)
    {
      this.xbo = true;
      l.c(this.query, false, this.xbr.dPa(), -2);
    }
    AppMethodBeat.o(111924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.i
 * JD-Core Version:    0.7.0.1
 */