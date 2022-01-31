package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class l
  extends d
  implements e.b
{
  private ak ipC;
  private boolean mXb;
  private com.tencent.mm.plugin.fts.ui.d.l mYl;
  
  public l(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(61943);
    this.ipC = new ak();
    this.mYl = new com.tencent.mm.plugin.fts.ui.d.l(parame.getContext(), this, paramInt);
    this.mYl.mSO = paramString;
    AppMethodBeat.o(61943);
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(61947);
    setCount(parame.wt(0));
    notifyDataSetChanged();
    V(getCount(), true);
    AppMethodBeat.o(61947);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(61946);
    paramBoolean = this.mYl.a(paramView, parama, paramBoolean);
    if ((parama.mTP) && (!this.mXb))
    {
      this.mXb = true;
      k.c(this.query, true, this.mYl.bCx(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.mYl.wt(0));
      notifyDataSetChanged();
      V(getCount(), true);
    }
    AppMethodBeat.o(61946);
    return paramBoolean;
  }
  
  protected final int bCf()
  {
    AppMethodBeat.i(156823);
    int i = this.mYl.bCx();
    AppMethodBeat.o(156823);
    return i;
  }
  
  protected final void bCy()
  {
    AppMethodBeat.i(61945);
    this.mXb = false;
    this.mYl.a(this.query, this.ipC, new HashSet(), 0L);
    AppMethodBeat.o(61945);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(61948);
    super.finish();
    if (!this.mXb)
    {
      this.mXb = true;
      k.c(this.query, false, this.mYl.bCx(), -2);
    }
    AppMethodBeat.o(61948);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a wu(int paramInt)
  {
    AppMethodBeat.i(61944);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.mYl.wu(paramInt);
    if (locala != null) {
      locala.pageType = 3;
    }
    AppMethodBeat.o(61944);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.l
 * JD-Core Version:    0.7.0.1
 */