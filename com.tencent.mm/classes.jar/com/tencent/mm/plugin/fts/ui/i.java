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
  private boolean BNo;
  private g BNr;
  private MMHandler qdR;
  
  public i(e parame, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(111919);
    this.qdR = new MMHandler();
    this.BNr = new g(parame.getContext(), this, paramInt1);
    this.BNr.BIO = paramString2;
    this.BNr.talker = paramString1;
    this.BNr.BIN = paramString3;
    this.BNr.fwp = paramInt2;
    AppMethodBeat.o(111919);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a SC(int paramInt)
  {
    AppMethodBeat.i(111920);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.BNr.SC(paramInt);
    if (locala != null) {
      locala.pageType = 5;
    }
    AppMethodBeat.o(111920);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111923);
    setCount(parame.SB(0));
    notifyDataSetChanged();
    aB(getCount(), true);
    AppMethodBeat.o(111923);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111922);
    paramBoolean = this.BNr.a(paramView, parama, paramBoolean);
    if ((parama.BJP) && (!this.BNo))
    {
      this.BNo = true;
      l.c(getQuery(), true, this.BNr.eru(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.BNr.SB(0));
      notifyDataSetChanged();
      aB(getCount(), true);
    }
    AppMethodBeat.o(111922);
    return paramBoolean;
  }
  
  protected final int erb()
  {
    AppMethodBeat.i(292773);
    int i = this.BNr.eru();
    AppMethodBeat.o(292773);
    return i;
  }
  
  protected final void erv()
  {
    AppMethodBeat.i(111921);
    this.BNo = false;
    this.BNr.a(getQuery(), this.qdR, new HashSet(), 0L);
    AppMethodBeat.o(111921);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111924);
    super.finish();
    if (!this.BNo)
    {
      this.BNo = true;
      l.c(getQuery(), false, this.BNr.eru(), -2);
    }
    AppMethodBeat.o(111924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.i
 * JD-Core Version:    0.7.0.1
 */