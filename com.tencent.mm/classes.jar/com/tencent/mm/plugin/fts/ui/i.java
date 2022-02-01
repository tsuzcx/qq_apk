package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.g;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;

public final class i
  extends d
  implements e.b
{
  private aq lVY;
  private boolean tKp;
  private g tKs;
  
  public i(e parame, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(111919);
    this.lVY = new aq();
    this.tKs = new g(parame.getContext(), this, paramInt1);
    this.tKs.tFU = paramString2;
    this.tKs.talker = paramString1;
    this.tKs.tFT = paramString3;
    this.tKs.dmr = paramInt2;
    AppMethodBeat.o(111919);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a Ho(int paramInt)
  {
    AppMethodBeat.i(111920);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.tKs.Ho(paramInt);
    if (locala != null) {
      locala.pageType = 5;
    }
    AppMethodBeat.o(111920);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111923);
    setCount(parame.Hn(0));
    notifyDataSetChanged();
    ao(getCount(), true);
    AppMethodBeat.o(111923);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111922);
    paramBoolean = this.tKs.a(paramView, parama, paramBoolean);
    if ((parama.tGU) && (!this.tKp))
    {
      this.tKp = true;
      l.c(this.query, true, this.tKs.cVR(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.tKs.Hn(0));
      notifyDataSetChanged();
      ao(getCount(), true);
    }
    AppMethodBeat.o(111922);
    return paramBoolean;
  }
  
  protected final void cVS()
  {
    AppMethodBeat.i(111921);
    this.tKp = false;
    this.tKs.a(this.query, this.lVY, new HashSet(), 0L);
    AppMethodBeat.o(111921);
  }
  
  protected final int cVz()
  {
    AppMethodBeat.i(224511);
    int i = this.tKs.cVR();
    AppMethodBeat.o(224511);
    return i;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111924);
    super.finish();
    if (!this.tKp)
    {
      this.tKp = true;
      l.c(this.query, false, this.tKs.cVR(), -2);
    }
    AppMethodBeat.o(111924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.i
 * JD-Core Version:    0.7.0.1
 */