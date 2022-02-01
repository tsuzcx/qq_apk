package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.chatroom.a.c;
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
  private MMHandler xad;
  private f xbn;
  private boolean xbo;
  
  public h(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(111906);
    this.xad = new MMHandler(Looper.getMainLooper());
    parame = parame.getContext();
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(160));
    parame = (f)((n)g.ah(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt).get(0);
    parame.wWS = paramString;
    if (ab.Eq(paramString)) {
      parame.xbi = ((c)g.af(c.class)).aSX().Kd(paramString);
    }
    this.xbn = parame;
    AppMethodBeat.o(111906);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a No(int paramInt)
  {
    AppMethodBeat.i(111908);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.xbn.No(paramInt);
    if (locala != null)
    {
      locala.wXL = paramInt;
      locala.pageType = 4;
    }
    AppMethodBeat.o(111908);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(111907);
    setCount(parame.Nn(0));
    notifyDataSetChanged();
    ax(getCount(), true);
    AppMethodBeat.o(111907);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111910);
    this.xbn.a(paramView, parama, paramBoolean);
    if ((parama.wXT) && (!this.xbo))
    {
      this.xbo = true;
      l.c(this.query, true, this.xbn.dPa(), -2);
    }
    AppMethodBeat.o(111910);
    return false;
  }
  
  protected final int dOI()
  {
    AppMethodBeat.i(258735);
    int i = this.xbn.dPa();
    AppMethodBeat.o(258735);
    return i;
  }
  
  protected final void dPb()
  {
    AppMethodBeat.i(111909);
    this.xbo = false;
    this.xbn.a(this.query, this.xad, new HashSet(), 0L);
    AppMethodBeat.o(111909);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111911);
    super.finish();
    if (!this.xbo)
    {
      this.xbo = true;
      l.c(this.query, false, this.xbn.dPa(), -2);
    }
    AppMethodBeat.o(111911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.h
 * JD-Core Version:    0.7.0.1
 */