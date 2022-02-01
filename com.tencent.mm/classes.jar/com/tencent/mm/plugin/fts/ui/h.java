package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.d.f;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.LinkedList;

public final class h
  extends d
  implements e.b
{
  private ap tyn;
  private f tzx;
  private boolean tzy;
  
  public h(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(111906);
    this.tyn = new ap(Looper.getMainLooper());
    parame = parame.getContext();
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(160));
    parame = (f)((n)g.ad(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt).get(0);
    parame.tvc = paramString;
    if (w.vF(paramString)) {
      parame.tzs = ((c)g.ab(c.class)).azz().AN(paramString);
    }
    this.tzx = parame;
    AppMethodBeat.o(111906);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a GR(int paramInt)
  {
    AppMethodBeat.i(111908);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.tzx.GR(paramInt);
    if (locala != null)
    {
      locala.tvV = paramInt;
      locala.pageType = 4;
    }
    AppMethodBeat.o(111908);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111907);
    setCount(parame.GQ(0));
    notifyDataSetChanged();
    al(getCount(), true);
    AppMethodBeat.o(111907);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111910);
    this.tzx.a(paramView, parama, paramBoolean);
    if ((parama.twd) && (!this.tzy))
    {
      this.tzy = true;
      l.c(this.query, true, this.tzx.cTm(), -2);
    }
    AppMethodBeat.o(111910);
    return false;
  }
  
  protected final int cSU()
  {
    AppMethodBeat.i(221186);
    int i = this.tzx.cTm();
    AppMethodBeat.o(221186);
    return i;
  }
  
  protected final void cTn()
  {
    AppMethodBeat.i(111909);
    this.tzy = false;
    this.tzx.a(this.query, this.tyn, new HashSet(), 0L);
    AppMethodBeat.o(111909);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111911);
    super.finish();
    if (!this.tzy)
    {
      this.tzy = true;
      l.c(this.query, false, this.tzx.cTm(), -2);
    }
    AppMethodBeat.o(111911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.h
 * JD-Core Version:    0.7.0.1
 */