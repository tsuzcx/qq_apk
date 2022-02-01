package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.g;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;

public final class h
  extends d
  implements e.b
{
  private ap kQO;
  private boolean rtQ;
  private g rtT;
  
  public h(e parame, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(111919);
    this.kQO = new ap();
    this.rtT = new g(parame.getContext(), this, paramInt1);
    this.rtT.rpI = paramString2;
    this.rtT.talker = paramString1;
    this.rtT.rpH = paramString3;
    this.rtT.dcz = paramInt2;
    AppMethodBeat.o(111919);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a DG(int paramInt)
  {
    AppMethodBeat.i(111920);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.rtT.DG(paramInt);
    if (locala != null) {
      locala.pageType = 5;
    }
    AppMethodBeat.o(111920);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111923);
    setCount(parame.DF(0));
    notifyDataSetChanged();
    ae(getCount(), true);
    AppMethodBeat.o(111923);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111922);
    paramBoolean = this.rtT.a(paramView, parama, paramBoolean);
    if ((parama.rqI) && (!this.rtQ))
    {
      this.rtQ = true;
      k.c(this.query, true, this.rtT.cxL(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.rtT.DF(0));
      notifyDataSetChanged();
      ae(getCount(), true);
    }
    AppMethodBeat.o(111922);
    return paramBoolean;
  }
  
  protected final void cxM()
  {
    AppMethodBeat.i(111921);
    this.rtQ = false;
    this.rtT.a(this.query, this.kQO, new HashSet(), 0L);
    AppMethodBeat.o(111921);
  }
  
  protected final int cxt()
  {
    AppMethodBeat.i(205070);
    int i = this.rtT.cxL();
    AppMethodBeat.o(205070);
    return i;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111924);
    super.finish();
    if (!this.rtQ)
    {
      this.rtQ = true;
      k.c(this.query, false, this.rtT.cxL(), -2);
    }
    AppMethodBeat.o(111924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.h
 * JD-Core Version:    0.7.0.1
 */