package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.g;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;

public final class h
  extends d
  implements e.b
{
  private ak ipC;
  private boolean mXb;
  private g mXe;
  
  public h(e parame, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super(parame);
    AppMethodBeat.i(61824);
    this.ipC = new ak();
    this.mXe = new g(parame.getContext(), this, paramInt1);
    this.mXe.mSO = paramString2;
    this.mXe.talker = paramString1;
    this.mXe.mSN = paramString3;
    this.mXe.showType = paramInt2;
    AppMethodBeat.o(61824);
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(61828);
    setCount(parame.wt(0));
    notifyDataSetChanged();
    V(getCount(), true);
    AppMethodBeat.o(61828);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(61827);
    paramBoolean = this.mXe.a(paramView, parama, paramBoolean);
    if ((parama.mTP) && (!this.mXb))
    {
      this.mXb = true;
      k.c(this.query, true, this.mXe.bCx(), -2);
    }
    if (paramBoolean)
    {
      clearCache();
      setCount(this.mXe.wt(0));
      notifyDataSetChanged();
      V(getCount(), true);
    }
    AppMethodBeat.o(61827);
    return paramBoolean;
  }
  
  protected final int bCf()
  {
    AppMethodBeat.i(156822);
    int i = this.mXe.bCx();
    AppMethodBeat.o(156822);
    return i;
  }
  
  protected final void bCy()
  {
    AppMethodBeat.i(61826);
    this.mXb = false;
    this.mXe.a(this.query, this.ipC, new HashSet(), 0L);
    AppMethodBeat.o(61826);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(61829);
    super.finish();
    if (!this.mXb)
    {
      this.mXb = true;
      k.c(this.query, false, this.mXe.bCx(), -2);
    }
    AppMethodBeat.o(61829);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a wu(int paramInt)
  {
    AppMethodBeat.i(61825);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.mXe.wu(paramInt);
    if (locala != null) {
      locala.pageType = 5;
    }
    AppMethodBeat.o(61825);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.h
 * JD-Core Version:    0.7.0.1
 */