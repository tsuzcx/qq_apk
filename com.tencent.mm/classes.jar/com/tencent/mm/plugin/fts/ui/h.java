package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.g;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashSet;

public final class h
  extends d
  implements e.b
{
  private ao lso;
  private boolean sCJ;
  private g sCM;
  
  public h(e parame, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(111919);
    this.lso = new ao();
    this.sCM = new g(parame.getContext(), this, paramInt1);
    this.sCM.syC = paramString2;
    this.sCM.talker = paramString1;
    this.sCM.syB = paramString3;
    this.sCM.cZX = paramInt2;
    AppMethodBeat.o(111919);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a FC(int paramInt)
  {
    AppMethodBeat.i(111920);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.sCM.FC(paramInt);
    if (locala != null) {
      locala.pageType = 5;
    }
    AppMethodBeat.o(111920);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111923);
    setCount(parame.FB(0));
    notifyDataSetChanged();
    ah(getCount(), true);
    AppMethodBeat.o(111923);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111922);
    paramBoolean = this.sCM.a(paramView, parama, paramBoolean);
    if ((parama.szC) && (!this.sCJ))
    {
      this.sCJ = true;
      k.c(this.query, true, this.sCM.cKX(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.sCM.FB(0));
      notifyDataSetChanged();
      ah(getCount(), true);
    }
    AppMethodBeat.o(111922);
    return paramBoolean;
  }
  
  protected final int cKF()
  {
    AppMethodBeat.i(210506);
    int i = this.sCM.cKX();
    AppMethodBeat.o(210506);
    return i;
  }
  
  protected final void cKY()
  {
    AppMethodBeat.i(111921);
    this.sCJ = false;
    this.sCM.a(this.query, this.lso, new HashSet(), 0L);
    AppMethodBeat.o(111921);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111924);
    super.finish();
    if (!this.sCJ)
    {
      this.sCJ = true;
      k.c(this.query, false, this.sCM.cKX(), -2);
    }
    AppMethodBeat.o(111924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.h
 * JD-Core Version:    0.7.0.1
 */