package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.al;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ac;
import java.util.HashSet;
import java.util.List;

public final class g
  extends d
  implements l
{
  private aq lVY;
  private k tFQ;
  private String tFT;
  private com.tencent.mm.plugin.fts.a.a.a tGb;
  private ac tKj;
  
  public g(e parame, String paramString)
  {
    super(parame);
    AppMethodBeat.i(111878);
    this.lVY = new aq();
    this.tFT = paramString;
    if (x.zT(paramString)) {
      this.tKj = ((c)com.tencent.mm.kernel.g.ab(c.class)).azP().Bx(paramString);
    }
    AppMethodBeat.o(111878);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a Ho(int paramInt)
  {
    AppMethodBeat.i(111879);
    com.tencent.mm.plugin.fts.ui.a.d locald = new com.tencent.mm.plugin.fts.ui.a.d(paramInt);
    locald.kno = ((m)this.tFQ.tGc.get(paramInt));
    locald.tFe = this.tFQ.tFe;
    locald.pSr = -14;
    locald.tKj = this.tKj;
    locald.tGM = paramInt;
    locald.pageType = 6;
    if (locald.position == getCount() - 1) {
      locald.tGL = true;
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
    switch (paramk.bZU)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111881);
      return;
      this.tFQ = paramk;
      setCount(paramk.tGc.size());
      notifyDataSetChanged();
      ao(getCount(), true);
      AppMethodBeat.o(111881);
      return;
      setCount(0);
      notifyDataSetChanged();
      ao(getCount(), true);
    }
  }
  
  protected final void cVS()
  {
    AppMethodBeat.i(111880);
    clearCache();
    if (this.tGb != null) {
      ((n)com.tencent.mm.kernel.g.ad(n.class)).cancelSearchTask(this.tGb);
    }
    j localj = new j();
    localj.query = this.query;
    localj.tFT = this.tFT;
    localj.tFZ = com.tencent.mm.plugin.fts.a.c.e.tGC;
    localj.tFY.add("create_talker_message​");
    localj.tGa = this;
    localj.handler = this.lVY;
    localj.jUf = 3;
    this.tGb = ((n)com.tencent.mm.kernel.g.ad(n.class)).search(3, localj);
    ae.i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", new Object[] { this.query });
    AppMethodBeat.o(111880);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111882);
    super.finish();
    if (this.tGb != null) {
      ((n)com.tencent.mm.kernel.g.ad(n.class)).cancelSearchTask(this.tGb);
    }
    AppMethodBeat.o(111882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.g
 * JD-Core Version:    0.7.0.1
 */