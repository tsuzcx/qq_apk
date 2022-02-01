package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.d.f;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashSet;
import java.util.LinkedList;

public final class h
  extends d
  implements e.b
{
  private aq tJe;
  private f tKo;
  private boolean tKp;
  
  public h(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(111906);
    this.tJe = new aq(Looper.getMainLooper());
    parame = parame.getContext();
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(160));
    parame = (f)((n)g.ad(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt).get(0);
    parame.tFT = paramString;
    if (x.wb(paramString)) {
      parame.tKj = ((c)g.ab(c.class)).azP().Bx(paramString);
    }
    this.tKo = parame;
    AppMethodBeat.o(111906);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a Ho(int paramInt)
  {
    AppMethodBeat.i(111908);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.tKo.Ho(paramInt);
    if (locala != null)
    {
      locala.tGM = paramInt;
      locala.pageType = 4;
    }
    AppMethodBeat.o(111908);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111907);
    setCount(parame.Hn(0));
    notifyDataSetChanged();
    ao(getCount(), true);
    AppMethodBeat.o(111907);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111910);
    this.tKo.a(paramView, parama, paramBoolean);
    if ((parama.tGU) && (!this.tKp))
    {
      this.tKp = true;
      l.c(this.query, true, this.tKo.cVR(), -2);
    }
    AppMethodBeat.o(111910);
    return false;
  }
  
  protected final void cVS()
  {
    AppMethodBeat.i(111909);
    this.tKp = false;
    this.tKo.a(this.query, this.tJe, new HashSet(), 0L);
    AppMethodBeat.o(111909);
  }
  
  protected final int cVz()
  {
    AppMethodBeat.i(224510);
    int i = this.tKo.cVR();
    AppMethodBeat.o(224510);
    return i;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111911);
    super.finish();
    if (!this.tKp)
    {
      this.tKp = true;
      l.c(this.query, false, this.tKo.cVR(), -2);
    }
    AppMethodBeat.o(111911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.h
 * JD-Core Version:    0.7.0.1
 */