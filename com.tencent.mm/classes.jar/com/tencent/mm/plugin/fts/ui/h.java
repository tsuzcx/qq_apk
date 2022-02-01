package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.d.f;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.LinkedList;

public final class h
  extends d
  implements e.b
{
  private MMHandler BMc;
  private f BNn;
  private boolean BNo;
  
  public h(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(111906);
    this.BMc = new MMHandler(Looper.getMainLooper());
    parame = parame.getContext();
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(160));
    parame = (f)((n)com.tencent.mm.kernel.h.ag(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt).get(0);
    parame.BIN = paramString;
    if (ab.Lj(paramString)) {
      parame.BNi = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().Rw(paramString);
    }
    this.BNn = parame;
    AppMethodBeat.o(111906);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a SC(int paramInt)
  {
    AppMethodBeat.i(111908);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.BNn.SC(paramInt);
    if (locala != null)
    {
      locala.BJH = paramInt;
      locala.pageType = 4;
    }
    AppMethodBeat.o(111908);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111907);
    setCount(parame.SB(0));
    notifyDataSetChanged();
    aB(getCount(), true);
    AppMethodBeat.o(111907);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111910);
    this.BNn.a(paramView, parama, paramBoolean);
    if ((parama.BJP) && (!this.BNo))
    {
      this.BNo = true;
      l.c(getQuery(), true, this.BNn.eru(), -2);
    }
    AppMethodBeat.o(111910);
    return false;
  }
  
  protected final int erb()
  {
    AppMethodBeat.i(292772);
    int i = this.BNn.eru();
    AppMethodBeat.o(292772);
    return i;
  }
  
  protected final void erv()
  {
    AppMethodBeat.i(111909);
    this.BNo = false;
    this.BNn.a(getQuery(), this.BMc, new HashSet(), 0L);
    AppMethodBeat.o(111909);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111911);
    super.finish();
    if (!this.BNo)
    {
      this.BNo = true;
      l.c(getQuery(), false, this.BNn.eru(), -2);
    }
    AppMethodBeat.o(111911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.h
 * JD-Core Version:    0.7.0.1
 */