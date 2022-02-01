package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.chatroom.a.c;
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
  private MMHandler ndA;
  private k wWP;
  private String wWS;
  private com.tencent.mm.plugin.fts.a.a.a wXa;
  private ah xbi;
  
  public g(e parame, String paramString)
  {
    super(parame);
    AppMethodBeat.i(111878);
    this.ndA = new MMHandler();
    this.wWS = paramString;
    if (ab.Iw(paramString)) {
      this.xbi = ((c)com.tencent.mm.kernel.g.af(c.class)).aSX().Kd(paramString);
    }
    AppMethodBeat.o(111878);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a No(int paramInt)
  {
    AppMethodBeat.i(111879);
    com.tencent.mm.plugin.fts.ui.a.d locald = new com.tencent.mm.plugin.fts.ui.a.d(paramInt);
    locald.lqW = ((m)this.wWP.wXb.get(paramInt));
    locald.wWd = this.wWP.wWd;
    locald.rjr = -14;
    locald.xbi = this.xbi;
    locald.wXL = paramInt;
    locald.pageType = 6;
    if (locald.position == getCount() - 1) {
      locald.wXK = true;
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
      this.wWP = paramk;
      setCount(paramk.wXb.size());
      notifyDataSetChanged();
      ax(getCount(), true);
      AppMethodBeat.o(111881);
      return;
      setCount(0);
      notifyDataSetChanged();
      ax(getCount(), true);
    }
  }
  
  protected final void dPb()
  {
    AppMethodBeat.i(111880);
    clearCache();
    if (this.wXa != null) {
      ((n)com.tencent.mm.kernel.g.ah(n.class)).cancelSearchTask(this.wXa);
    }
    j localj = new j();
    localj.query = this.query;
    localj.wWS = this.wWS;
    localj.wWY = com.tencent.mm.plugin.fts.a.c.e.wXB;
    localj.wWX.add("create_talker_message​");
    localj.wWZ = this;
    localj.handler = this.ndA;
    localj.kXb = 3;
    this.wXa = ((n)com.tencent.mm.kernel.g.ah(n.class)).search(3, localj);
    Log.i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", new Object[] { this.query });
    AppMethodBeat.o(111880);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111882);
    super.finish();
    if (this.wXa != null) {
      ((n)com.tencent.mm.kernel.g.ah(n.class)).cancelSearchTask(this.wXa);
    }
    AppMethodBeat.o(111882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.g
 * JD-Core Version:    0.7.0.1
 */