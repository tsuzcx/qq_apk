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
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashSet;
import java.util.LinkedList;

public final class g
  extends d
  implements e.b
{
  private ao sBM;
  private f sCI;
  private boolean sCJ;
  
  public g(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(111906);
    this.sBM = new ao(Looper.getMainLooper());
    parame = parame.getContext();
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(160));
    parame = (f)((n)com.tencent.mm.kernel.g.ad(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt).get(0);
    parame.syB = paramString;
    if (w.sQ(paramString)) {
      parame.sCD = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().xN(paramString);
    }
    this.sCI = parame;
    AppMethodBeat.o(111906);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a FC(int paramInt)
  {
    AppMethodBeat.i(111908);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.sCI.FC(paramInt);
    if (locala != null)
    {
      locala.szu = paramInt;
      locala.pageType = 4;
    }
    AppMethodBeat.o(111908);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111907);
    setCount(parame.FB(0));
    notifyDataSetChanged();
    ah(getCount(), true);
    AppMethodBeat.o(111907);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111910);
    this.sCI.a(paramView, parama, paramBoolean);
    if ((parama.szC) && (!this.sCJ))
    {
      this.sCJ = true;
      k.c(this.query, true, this.sCI.cKX(), -2);
    }
    AppMethodBeat.o(111910);
    return false;
  }
  
  protected final int cKF()
  {
    AppMethodBeat.i(210505);
    int i = this.sCI.cKX();
    AppMethodBeat.o(210505);
    return i;
  }
  
  protected final void cKY()
  {
    AppMethodBeat.i(111909);
    this.sCJ = false;
    this.sCI.a(this.query, this.sBM, new HashSet(), 0L);
    AppMethodBeat.o(111909);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111911);
    super.finish();
    if (!this.sCJ)
    {
      this.sCJ = true;
      k.c(this.query, false, this.sCI.cKX(), -2);
    }
    AppMethodBeat.o(111911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.g
 * JD-Core Version:    0.7.0.1
 */