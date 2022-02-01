package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;

public final class m
  extends d
  implements e.b
{
  private boolean BNo;
  private com.tencent.mm.plugin.fts.ui.d.l BOl;
  private MMHandler qdR;
  
  public m(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(112024);
    this.qdR = new MMHandler();
    this.BOl = new com.tencent.mm.plugin.fts.ui.d.l(parame.getContext(), this, paramInt);
    this.BOl.BIO = paramString;
    AppMethodBeat.o(112024);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a SC(int paramInt)
  {
    AppMethodBeat.i(112025);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.BOl.SC(paramInt);
    if (locala != null) {
      locala.pageType = 3;
    }
    AppMethodBeat.o(112025);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(112028);
    setCount(parame.SB(0));
    notifyDataSetChanged();
    aB(getCount(), true);
    AppMethodBeat.o(112028);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112027);
    paramBoolean = this.BOl.a(paramView, parama, paramBoolean);
    if ((parama.BJP) && (!this.BNo))
    {
      this.BNo = true;
      l.c(getQuery(), true, this.BOl.eru(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.BOl.SB(0));
      notifyDataSetChanged();
      aB(getCount(), true);
    }
    AppMethodBeat.o(112027);
    return paramBoolean;
  }
  
  protected final int erb()
  {
    AppMethodBeat.i(292769);
    int i = this.BOl.eru();
    AppMethodBeat.o(292769);
    return i;
  }
  
  protected final void erv()
  {
    AppMethodBeat.i(112026);
    this.BNo = false;
    this.BOl.a(getQuery(), this.qdR, new HashSet(), 0L);
    AppMethodBeat.o(112026);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(112029);
    super.finish();
    if (!this.BNo)
    {
      this.BNo = true;
      l.c(getQuery(), false, this.BOl.eru(), -2);
    }
    AppMethodBeat.o(112029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.m
 * JD-Core Version:    0.7.0.1
 */