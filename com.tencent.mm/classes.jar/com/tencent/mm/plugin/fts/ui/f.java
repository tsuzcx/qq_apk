package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashSet;
import java.util.List;

public final class f
  extends d
  implements l
{
  private ap kQO;
  private k rpE;
  private String rpH;
  private com.tencent.mm.plugin.fts.a.a.a rpP;
  private com.tencent.mm.storage.w rtK;
  
  public f(e parame, String paramString)
  {
    super(parame);
    AppMethodBeat.i(111878);
    this.kQO = new ap();
    this.rpH = paramString;
    if (com.tencent.mm.model.w.sl(paramString)) {
      this.rtK = ((c)g.ab(c.class)).apV().tH(paramString);
    }
    AppMethodBeat.o(111878);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a DG(int paramInt)
  {
    AppMethodBeat.i(111879);
    com.tencent.mm.plugin.fts.ui.a.d locald = new com.tencent.mm.plugin.fts.ui.a.d(paramInt);
    locald.jpy = ((m)this.rpE.rpQ.get(paramInt));
    locald.roS = this.rpE.roS;
    locald.oEL = -14;
    locald.rtK = this.rtK;
    locald.rqA = paramInt;
    locald.pageType = 6;
    if (locald.position == getCount() - 1) {
      locald.rqz = true;
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
    switch (paramk.bRZ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111881);
      return;
      this.rpE = paramk;
      setCount(paramk.rpQ.size());
      notifyDataSetChanged();
      ae(getCount(), true);
      AppMethodBeat.o(111881);
      return;
      setCount(0);
      notifyDataSetChanged();
      ae(getCount(), true);
    }
  }
  
  protected final void cxM()
  {
    AppMethodBeat.i(111880);
    clearCache();
    if (this.rpP != null) {
      ((n)g.ad(n.class)).cancelSearchTask(this.rpP);
    }
    j localj = new j();
    localj.query = this.query;
    localj.rpH = this.rpH;
    localj.rpN = com.tencent.mm.plugin.fts.a.c.e.rqq;
    localj.rpM.add("create_talker_message​");
    localj.rpO = this;
    localj.handler = this.kQO;
    localj.iWB = 3;
    this.rpP = ((n)g.ad(n.class)).search(3, localj);
    ad.i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", new Object[] { this.query });
    AppMethodBeat.o(111880);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111882);
    super.finish();
    if (this.rpP != null) {
      ((n)g.ad(n.class)).cancelSearchTask(this.rpP);
    }
    AppMethodBeat.o(111882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.f
 * JD-Core Version:    0.7.0.1
 */