package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.d.f;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.LinkedList;

public final class g
  extends d
  implements e.b
{
  private ap rsS;
  private f rtP;
  private boolean rtQ;
  
  public g(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(111906);
    this.rsS = new ap(Looper.getMainLooper());
    parame = parame.getContext();
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(160));
    parame = (f)((n)com.tencent.mm.kernel.g.ad(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt).get(0);
    parame.rpH = paramString;
    if (w.pF(paramString)) {
      parame.rtK = ((c)com.tencent.mm.kernel.g.ab(c.class)).apV().tH(paramString);
    }
    this.rtP = parame;
    AppMethodBeat.o(111906);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a DG(int paramInt)
  {
    AppMethodBeat.i(111908);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.rtP.DG(paramInt);
    if (locala != null)
    {
      locala.rqA = paramInt;
      locala.pageType = 4;
    }
    AppMethodBeat.o(111908);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111907);
    setCount(parame.DF(0));
    notifyDataSetChanged();
    ae(getCount(), true);
    AppMethodBeat.o(111907);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111910);
    this.rtP.a(paramView, parama, paramBoolean);
    if ((parama.rqI) && (!this.rtQ))
    {
      this.rtQ = true;
      k.c(this.query, true, this.rtP.cxL(), -2);
    }
    AppMethodBeat.o(111910);
    return false;
  }
  
  protected final void cxM()
  {
    AppMethodBeat.i(111909);
    this.rtQ = false;
    this.rtP.a(this.query, this.rsS, new HashSet(), 0L);
    AppMethodBeat.o(111909);
  }
  
  protected final int cxt()
  {
    AppMethodBeat.i(205069);
    int i = this.rtP.cxL();
    AppMethodBeat.o(205069);
    return i;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111911);
    super.finish();
    if (!this.rtQ)
    {
      this.rtQ = true;
      k.c(this.query, false, this.rtP.cxL(), -2);
    }
    AppMethodBeat.o(111911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.g
 * JD-Core Version:    0.7.0.1
 */