package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashSet;

public final class l
  extends d
  implements e.b
{
  private ao lso;
  private boolean sCJ;
  private com.tencent.mm.plugin.fts.ui.d.l sDE;
  
  public l(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(112024);
    this.lso = new ao();
    this.sDE = new com.tencent.mm.plugin.fts.ui.d.l(parame.getContext(), this, paramInt);
    this.sDE.syC = paramString;
    AppMethodBeat.o(112024);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a FC(int paramInt)
  {
    AppMethodBeat.i(112025);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.sDE.FC(paramInt);
    if (locala != null) {
      locala.pageType = 3;
    }
    AppMethodBeat.o(112025);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(112028);
    setCount(parame.FB(0));
    notifyDataSetChanged();
    ah(getCount(), true);
    AppMethodBeat.o(112028);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(112027);
    paramBoolean = this.sDE.a(paramView, parama, paramBoolean);
    if ((parama.szC) && (!this.sCJ))
    {
      this.sCJ = true;
      k.c(this.query, true, this.sDE.cKX(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.sDE.FB(0));
      notifyDataSetChanged();
      ah(getCount(), true);
    }
    AppMethodBeat.o(112027);
    return paramBoolean;
  }
  
  protected final int cKF()
  {
    AppMethodBeat.i(210507);
    int i = this.sDE.cKX();
    AppMethodBeat.o(210507);
    return i;
  }
  
  protected final void cKY()
  {
    AppMethodBeat.i(112026);
    this.sCJ = false;
    this.sDE.a(this.query, this.lso, new HashSet(), 0L);
    AppMethodBeat.o(112026);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(112029);
    super.finish();
    if (!this.sCJ)
    {
      this.sCJ = true;
      k.c(this.query, false, this.sDE.cKX(), -2);
    }
    AppMethodBeat.o(112029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.l
 * JD-Core Version:    0.7.0.1
 */