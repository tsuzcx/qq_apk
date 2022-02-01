package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;

public final class l
  extends d
  implements e.b
{
  private ap kQO;
  private boolean rtQ;
  private com.tencent.mm.plugin.fts.ui.d.l ruM;
  
  public l(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(112024);
    this.kQO = new ap();
    this.ruM = new com.tencent.mm.plugin.fts.ui.d.l(parame.getContext(), this, paramInt);
    this.ruM.rpI = paramString;
    AppMethodBeat.o(112024);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a DG(int paramInt)
  {
    AppMethodBeat.i(112025);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.ruM.DG(paramInt);
    if (locala != null) {
      locala.pageType = 3;
    }
    AppMethodBeat.o(112025);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(112028);
    setCount(parame.DF(0));
    notifyDataSetChanged();
    ae(getCount(), true);
    AppMethodBeat.o(112028);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112027);
    paramBoolean = this.ruM.a(paramView, parama, paramBoolean);
    if ((parama.rqI) && (!this.rtQ))
    {
      this.rtQ = true;
      k.c(this.query, true, this.ruM.cxL(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.ruM.DF(0));
      notifyDataSetChanged();
      ae(getCount(), true);
    }
    AppMethodBeat.o(112027);
    return paramBoolean;
  }
  
  protected final void cxM()
  {
    AppMethodBeat.i(112026);
    this.rtQ = false;
    this.ruM.a(this.query, this.kQO, new HashSet(), 0L);
    AppMethodBeat.o(112026);
  }
  
  protected final int cxt()
  {
    AppMethodBeat.i(205071);
    int i = this.ruM.cxL();
    AppMethodBeat.o(205071);
    return i;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(112029);
    super.finish();
    if (!this.rtQ)
    {
      this.rtQ = true;
      k.c(this.query, false, this.ruM.cxL(), -2);
    }
    AppMethodBeat.o(112029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.l
 * JD-Core Version:    0.7.0.1
 */