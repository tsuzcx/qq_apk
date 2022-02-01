package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import java.util.HashSet;
import java.util.List;

public final class g
  extends d
  implements com.tencent.mm.plugin.fts.a.l
{
  private c HtE;
  private m Hts;
  private String Htv;
  private aj Hyy;
  private MMHandler tiG;
  
  public g(e parame, String paramString)
  {
    super(parame);
    AppMethodBeat.i(111878);
    this.tiG = new MMHandler();
    this.Htv = paramString;
    if (au.bwE(paramString)) {
      this.Hyy = ((b)h.ax(b.class)).bzK().Ju(paramString);
    }
    AppMethodBeat.o(111878);
  }
  
  protected final a Wj(int paramInt)
  {
    AppMethodBeat.i(111879);
    com.tencent.mm.plugin.fts.ui.b.d locald = new com.tencent.mm.plugin.fts.ui.b.d(paramInt);
    locald.rpp = ((o)this.Hts.HtF.get(paramInt));
    locald.FWt = this.Hts.FWt;
    locald.xVf = -14;
    locald.Hyy = this.Hyy;
    locald.Huq = paramInt;
    locald.pageType = 6;
    if (locald.position == getCount() - 1) {
      locald.Hup = true;
    }
    AppMethodBeat.o(111879);
    return locald;
  }
  
  protected final boolean a(View paramView, a parama, boolean paramBoolean)
  {
    return false;
  }
  
  public final void b(m paramm)
  {
    AppMethodBeat.i(111881);
    switch (paramm.resultCode)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111881);
      return;
      this.Hts = paramm;
      setCount(paramm.HtF.size());
      notifyDataSetChanged();
      aZ(getCount(), true);
      AppMethodBeat.o(111881);
      return;
      setCount(0);
      notifyDataSetChanged();
      aZ(getCount(), true);
    }
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111882);
    super.finish();
    if (this.HtE != null) {
      ((n)h.az(n.class)).cancelSearchTask(this.HtE);
    }
    AppMethodBeat.o(111882);
  }
  
  protected final void fyd()
  {
    AppMethodBeat.i(111880);
    clearCache();
    if (this.HtE != null) {
      ((n)h.az(n.class)).cancelSearchTask(this.HtE);
    }
    com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
    locall.query = getQuery();
    locall.Htv = this.Htv;
    locall.HtB = com.tencent.mm.plugin.fts.a.c.e.Huh;
    locall.HtA.add("create_talker_message​");
    locall.HtC = this;
    locall.handler = this.tiG;
    locall.qRb = 3;
    this.HtE = ((n)h.az(n.class)).search(3, locall);
    Log.i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", new Object[] { getQuery() });
    AppMethodBeat.o(111880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.g
 * JD-Core Version:    0.7.0.1
 */