package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.u;
import java.util.HashSet;
import java.util.List;

public final class f
  extends d
  implements com.tencent.mm.plugin.fts.a.l
{
  private ak ipC;
  private j mSK;
  private String mSN;
  private com.tencent.mm.plugin.fts.a.a.a mSV;
  private u mWV;
  
  public f(e parame, String paramString)
  {
    super(parame);
    AppMethodBeat.i(61785);
    this.ipC = new ak();
    this.mSN = paramString;
    if (t.nI(paramString)) {
      this.mWV = ((c)g.E(c.class)).YJ().oU(paramString);
    }
    AppMethodBeat.o(61785);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    return false;
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(61788);
    switch (paramj.bpE)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(61788);
      return;
      this.mSK = paramj;
      setCount(paramj.mSW.size());
      notifyDataSetChanged();
      V(getCount(), true);
      AppMethodBeat.o(61788);
      return;
      setCount(0);
      notifyDataSetChanged();
      V(getCount(), true);
    }
  }
  
  protected final void bCy()
  {
    AppMethodBeat.i(61787);
    clearCache();
    if (this.mSV != null) {
      ((n)g.G(n.class)).cancelSearchTask(this.mSV);
    }
    i locali = new i();
    locali.query = this.query;
    locali.mSN = this.mSN;
    locali.mST = com.tencent.mm.plugin.fts.a.c.e.mTw;
    locali.mSS.add("create_talker_message​");
    locali.mSU = this;
    locali.handler = this.ipC;
    locali.hdl = 3;
    this.mSV = ((n)g.G(n.class)).search(3, locali);
    ab.i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", new Object[] { this.query });
    AppMethodBeat.o(61787);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(61789);
    super.finish();
    if (this.mSV != null) {
      ((n)g.G(n.class)).cancelSearchTask(this.mSV);
    }
    AppMethodBeat.o(61789);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a wu(int paramInt)
  {
    AppMethodBeat.i(61786);
    com.tencent.mm.plugin.fts.ui.a.d locald = new com.tencent.mm.plugin.fts.ui.a.d(paramInt);
    locald.hrL = ((com.tencent.mm.plugin.fts.a.a.l)this.mSK.mSW.get(paramInt));
    locald.mRX = this.mSK.mRX;
    locald.lox = -14;
    locald.mWV = this.mWV;
    locald.mTI = paramInt;
    locald.pageType = 6;
    if (locald.position == getCount() - 1) {
      locald.mTH = true;
    }
    AppMethodBeat.o(61786);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.f
 * JD-Core Version:    0.7.0.1
 */