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
  private MMHandler ndA;
  private boolean xbo;
  private com.tencent.mm.plugin.fts.ui.d.l xcl;
  
  public m(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(112024);
    this.ndA = new MMHandler();
    this.xcl = new com.tencent.mm.plugin.fts.ui.d.l(parame.getContext(), this, paramInt);
    this.xcl.wWT = paramString;
    AppMethodBeat.o(112024);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a No(int paramInt)
  {
    AppMethodBeat.i(112025);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.xcl.No(paramInt);
    if (locala != null) {
      locala.pageType = 3;
    }
    AppMethodBeat.o(112025);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(112028);
    setCount(parame.Nn(0));
    notifyDataSetChanged();
    ax(getCount(), true);
    AppMethodBeat.o(112028);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112027);
    paramBoolean = this.xcl.a(paramView, parama, paramBoolean);
    if ((parama.wXT) && (!this.xbo))
    {
      this.xbo = true;
      l.c(this.query, true, this.xcl.dPa(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.xcl.Nn(0));
      notifyDataSetChanged();
      ax(getCount(), true);
    }
    AppMethodBeat.o(112027);
    return paramBoolean;
  }
  
  protected final int dOI()
  {
    AppMethodBeat.i(258737);
    int i = this.xcl.dPa();
    AppMethodBeat.o(258737);
    return i;
  }
  
  protected final void dPb()
  {
    AppMethodBeat.i(112026);
    this.xbo = false;
    this.xcl.a(this.query, this.ndA, new HashSet(), 0L);
    AppMethodBeat.o(112026);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(112029);
    super.finish();
    if (!this.xbo)
    {
      this.xbo = true;
      l.c(this.query, false, this.xcl.dPa(), -2);
    }
    AppMethodBeat.o(112029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.m
 * JD-Core Version:    0.7.0.1
 */