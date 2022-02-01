package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.x;
import java.util.HashSet;
import java.util.List;

public final class f
  extends d
  implements l
{
  private ao lso;
  private x sCD;
  private String syB;
  private com.tencent.mm.plugin.fts.a.a.a syJ;
  private k syy;
  
  public f(e parame, String paramString)
  {
    super(parame);
    AppMethodBeat.i(111878);
    this.lso = new ao();
    this.syB = paramString;
    if (w.wo(paramString)) {
      this.sCD = ((c)g.ab(c.class)).awK().xN(paramString);
    }
    AppMethodBeat.o(111878);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a FC(int paramInt)
  {
    AppMethodBeat.i(111879);
    com.tencent.mm.plugin.fts.ui.a.d locald = new com.tencent.mm.plugin.fts.ui.a.d(paramInt);
    locald.jPN = ((m)this.syy.syK.get(paramInt));
    locald.sxM = this.syy.sxM;
    locald.pil = -14;
    locald.sCD = this.sCD;
    locald.szu = paramInt;
    locald.pageType = 6;
    if (locald.position == getCount() - 1) {
      locald.szt = true;
    }
    AppMethodBeat.o(111879);
    return locald;
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    return false;
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(111881);
    switch (paramk.bPH)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111881);
      return;
      this.syy = paramk;
      setCount(paramk.syK.size());
      notifyDataSetChanged();
      ah(getCount(), true);
      AppMethodBeat.o(111881);
      return;
      setCount(0);
      notifyDataSetChanged();
      ah(getCount(), true);
    }
  }
  
  protected final void cKY()
  {
    AppMethodBeat.i(111880);
    clearCache();
    if (this.syJ != null) {
      ((n)g.ad(n.class)).cancelSearchTask(this.syJ);
    }
    j localj = new j();
    localj.query = this.query;
    localj.syB = this.syB;
    localj.syH = com.tencent.mm.plugin.fts.a.c.e.szk;
    localj.syG.add("create_talker_message​");
    localj.syI = this;
    localj.handler = this.lso;
    localj.jwR = 3;
    this.syJ = ((n)g.ad(n.class)).search(3, localj);
    ac.i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", new Object[] { this.query });
    AppMethodBeat.o(111880);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111882);
    super.finish();
    if (this.syJ != null) {
      ((n)g.ad(n.class)).cancelSearchTask(this.syJ);
    }
    AppMethodBeat.o(111882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.f
 * JD-Core Version:    0.7.0.1
 */