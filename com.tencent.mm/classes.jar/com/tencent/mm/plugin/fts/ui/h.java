package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.e.f;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.au;
import java.util.HashSet;
import java.util.LinkedList;

public final class h
  extends d
  implements e.b
{
  private MMHandler HwY;
  private f HyG;
  private boolean HyH;
  
  public h(e parame, String paramString, int paramInt)
  {
    super(parame);
    AppMethodBeat.i(111906);
    this.HwY = new MMHandler(Looper.getMainLooper());
    parame = parame.getContext();
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(160));
    parame = (f)((n)com.tencent.mm.kernel.h.az(n.class)).createFTSUIUnitList(localHashSet, parame, this, paramInt).get(0);
    parame.Htv = paramString;
    if (au.bwE(paramString)) {
      parame.Hyy = ((b)com.tencent.mm.kernel.h.ax(b.class)).bzK().Ju(paramString);
    }
    this.HyG = parame;
    AppMethodBeat.o(111906);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a Wj(int paramInt)
  {
    AppMethodBeat.i(111908);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.HyG.Wj(paramInt);
    if (locala != null)
    {
      locala.Huq = paramInt;
      locala.pageType = 4;
    }
    AppMethodBeat.o(111908);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(265645);
    setCount(parame.Wi(0));
    notifyDataSetChanged();
    aZ(getCount(), true);
    AppMethodBeat.o(265645);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(111910);
    this.HyG.a(paramView, parama, paramBoolean);
    if ((parama.Huy) && (!this.HyH))
    {
      this.HyH = true;
      l.c(getQuery(), true, this.HyG.fyc(), -2);
    }
    AppMethodBeat.o(111910);
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111911);
    super.finish();
    if (!this.HyH)
    {
      this.HyH = true;
      l.c(getQuery(), false, this.HyG.fyc(), -2);
    }
    AppMethodBeat.o(111911);
  }
  
  protected final int fxI()
  {
    AppMethodBeat.i(369734);
    int i = this.HyG.fyc();
    AppMethodBeat.o(369734);
    return i;
  }
  
  protected final void fyd()
  {
    AppMethodBeat.i(111909);
    this.HyH = false;
    this.HyG.a(getQuery(), this.HwY, new HashSet());
    AppMethodBeat.o(111909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.h
 * JD-Core Version:    0.7.0.1
 */