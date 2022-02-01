package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;

public final class m
  extends d
  implements e.b
{
  private aq lVY;
  private boolean tKp;
  private com.tencent.mm.plugin.fts.ui.d.l tLk;
  
  public m(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(112024);
    this.lVY = new aq();
    this.tLk = new com.tencent.mm.plugin.fts.ui.d.l(parame.getContext(), this, paramInt);
    this.tLk.tFU = paramString;
    AppMethodBeat.o(112024);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a Ho(int paramInt)
  {
    AppMethodBeat.i(112025);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.tLk.Ho(paramInt);
    if (locala != null) {
      locala.pageType = 3;
    }
    AppMethodBeat.o(112025);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(112028);
    setCount(parame.Hn(0));
    notifyDataSetChanged();
    ao(getCount(), true);
    AppMethodBeat.o(112028);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112027);
    paramBoolean = this.tLk.a(paramView, parama, paramBoolean);
    if ((parama.tGU) && (!this.tKp))
    {
      this.tKp = true;
      l.c(this.query, true, this.tLk.cVR(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.tLk.Hn(0));
      notifyDataSetChanged();
      ao(getCount(), true);
    }
    AppMethodBeat.o(112027);
    return paramBoolean;
  }
  
  protected final void cVS()
  {
    AppMethodBeat.i(112026);
    this.tKp = false;
    this.tLk.a(this.query, this.lVY, new HashSet(), 0L);
    AppMethodBeat.o(112026);
  }
  
  protected final int cVz()
  {
    AppMethodBeat.i(224512);
    int i = this.tLk.cVR();
    AppMethodBeat.o(224512);
    return i;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(112029);
    super.finish();
    if (!this.tKp)
    {
      this.tKp = true;
      l.c(this.query, false, this.tLk.cVR(), -2);
    }
    AppMethodBeat.o(112029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.m
 * JD-Core Version:    0.7.0.1
 */