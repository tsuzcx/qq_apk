package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;

public final class m
  extends d
  implements e.b
{
  private ap lRx;
  private com.tencent.mm.plugin.fts.ui.d.l tAt;
  private boolean tzy;
  
  public m(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(112024);
    this.lRx = new ap();
    this.tAt = new com.tencent.mm.plugin.fts.ui.d.l(parame.getContext(), this, paramInt);
    this.tAt.tvd = paramString;
    AppMethodBeat.o(112024);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a GR(int paramInt)
  {
    AppMethodBeat.i(112025);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.tAt.GR(paramInt);
    if (locala != null) {
      locala.pageType = 3;
    }
    AppMethodBeat.o(112025);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(112028);
    setCount(parame.GQ(0));
    notifyDataSetChanged();
    al(getCount(), true);
    AppMethodBeat.o(112028);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112027);
    paramBoolean = this.tAt.a(paramView, parama, paramBoolean);
    if ((parama.twd) && (!this.tzy))
    {
      this.tzy = true;
      l.c(this.query, true, this.tAt.cTm(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.tAt.GQ(0));
      notifyDataSetChanged();
      al(getCount(), true);
    }
    AppMethodBeat.o(112027);
    return paramBoolean;
  }
  
  protected final int cSU()
  {
    AppMethodBeat.i(221188);
    int i = this.tAt.cTm();
    AppMethodBeat.o(221188);
    return i;
  }
  
  protected final void cTn()
  {
    AppMethodBeat.i(112026);
    this.tzy = false;
    this.tAt.a(this.query, this.lRx, new HashSet(), 0L);
    AppMethodBeat.o(112026);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(112029);
    super.finish();
    if (!this.tzy)
    {
      this.tzy = true;
      l.c(this.query, false, this.tAt.cTm(), -2);
    }
    AppMethodBeat.o(112029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.m
 * JD-Core Version:    0.7.0.1
 */