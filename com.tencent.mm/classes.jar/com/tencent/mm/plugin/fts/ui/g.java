package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.d.f;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.LinkedList;

public final class g
  extends d
  implements e.b
{
  private ak mWd;
  private f mXa;
  private boolean mXb;
  
  public g(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(61811);
    this.mWd = new ak(Looper.getMainLooper());
    parame = parame.getContext();
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(160));
    parame = (f)((n)com.tencent.mm.kernel.g.G(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt).get(0);
    parame.mSN = paramString;
    if (t.lA(paramString)) {
      parame.mWV = ((c)com.tencent.mm.kernel.g.E(c.class)).YJ().oU(paramString);
    }
    this.mXa = parame;
    AppMethodBeat.o(61811);
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(61812);
    setCount(parame.wt(0));
    notifyDataSetChanged();
    V(getCount(), true);
    AppMethodBeat.o(61812);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(61815);
    this.mXa.a(paramView, parama, paramBoolean);
    if ((parama.mTP) && (!this.mXb))
    {
      this.mXb = true;
      k.c(this.query, true, this.mXa.bCx(), -2);
    }
    AppMethodBeat.o(61815);
    return false;
  }
  
  protected final int bCf()
  {
    AppMethodBeat.i(156821);
    int i = this.mXa.bCx();
    AppMethodBeat.o(156821);
    return i;
  }
  
  protected final void bCy()
  {
    AppMethodBeat.i(61814);
    this.mXb = false;
    this.mXa.a(this.query, this.mWd, new HashSet(), 0L);
    AppMethodBeat.o(61814);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(61816);
    super.finish();
    if (!this.mXb)
    {
      this.mXb = true;
      k.c(this.query, false, this.mXa.bCx(), -2);
    }
    AppMethodBeat.o(61816);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a wu(int paramInt)
  {
    AppMethodBeat.i(61813);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.mXa.wu(paramInt);
    if (locala != null)
    {
      locala.mTI = paramInt;
      locala.pageType = 4;
    }
    AppMethodBeat.o(61813);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.g
 * JD-Core Version:    0.7.0.1
 */