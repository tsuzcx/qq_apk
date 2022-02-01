package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ah;
import java.util.HashSet;
import java.util.List;

public final class g
  extends d
  implements l
{
  private k BIK;
  private String BIN;
  private com.tencent.mm.plugin.fts.a.a.a BIV;
  private ah BNi;
  private MMHandler qdR;
  
  public g(e parame, String paramString)
  {
    super(parame);
    AppMethodBeat.i(111878);
    this.qdR = new MMHandler();
    this.BIN = paramString;
    if (ab.PO(paramString)) {
      this.BNi = ((b)h.ae(b.class)).bbV().Rw(paramString);
    }
    AppMethodBeat.o(111878);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a SC(int paramInt)
  {
    AppMethodBeat.i(111879);
    com.tencent.mm.plugin.fts.ui.a.d locald = new com.tencent.mm.plugin.fts.ui.a.d(paramInt);
    locald.olG = ((m)this.BIK.BIW.get(paramInt));
    locald.BHY = this.BIK.BHY;
    locald.uMD = -14;
    locald.BNi = this.BNi;
    locald.BJH = paramInt;
    locald.pageType = 6;
    if (locald.position == getCount() - 1) {
      locald.BJG = true;
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
    switch (paramk.resultCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111881);
      return;
      this.BIK = paramk;
      setCount(paramk.BIW.size());
      notifyDataSetChanged();
      aB(getCount(), true);
      AppMethodBeat.o(111881);
      return;
      setCount(0);
      notifyDataSetChanged();
      aB(getCount(), true);
    }
  }
  
  protected final void erv()
  {
    AppMethodBeat.i(111880);
    clearCache();
    if (this.BIV != null) {
      ((n)h.ag(n.class)).cancelSearchTask(this.BIV);
    }
    j localj = new j();
    localj.query = getQuery();
    localj.BIN = this.BIN;
    localj.BIT = com.tencent.mm.plugin.fts.a.c.e.BJx;
    localj.BIS.add("create_talker_message​");
    localj.BIU = this;
    localj.handler = this.qdR;
    localj.nRn = 3;
    this.BIV = ((n)h.ag(n.class)).search(3, localj);
    Log.i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", new Object[] { getQuery() });
    AppMethodBeat.o(111880);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111882);
    super.finish();
    if (this.BIV != null) {
      ((n)h.ag(n.class)).cancelSearchTask(this.BIV);
    }
    AppMethodBeat.o(111882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.g
 * JD-Core Version:    0.7.0.1
 */