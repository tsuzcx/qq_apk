package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ab;
import java.util.HashSet;
import java.util.List;

public final class g
  extends d
  implements l
{
  private ap lRx;
  private k tuZ;
  private String tvc;
  private com.tencent.mm.plugin.fts.a.a.a tvk;
  private ab tzs;
  
  public g(e parame, String paramString)
  {
    super(parame);
    AppMethodBeat.i(111878);
    this.lRx = new ap();
    this.tvc = paramString;
    if (w.zj(paramString)) {
      this.tzs = ((c)com.tencent.mm.kernel.g.ab(c.class)).azz().AN(paramString);
    }
    AppMethodBeat.o(111878);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a GR(int paramInt)
  {
    AppMethodBeat.i(111879);
    com.tencent.mm.plugin.fts.ui.a.d locald = new com.tencent.mm.plugin.fts.ui.a.d(paramInt);
    locald.kjY = ((m)this.tuZ.tvl.get(paramInt));
    locald.tun = this.tuZ.tun;
    locald.pLM = -14;
    locald.tzs = this.tzs;
    locald.tvV = paramInt;
    locald.pageType = 6;
    if (locald.position == getCount() - 1) {
      locald.tvU = true;
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
      this.tuZ = paramk;
      setCount(paramk.tvl.size());
      notifyDataSetChanged();
      al(getCount(), true);
      AppMethodBeat.o(111881);
      return;
      setCount(0);
      notifyDataSetChanged();
      al(getCount(), true);
    }
  }
  
  protected final void cTn()
  {
    AppMethodBeat.i(111880);
    clearCache();
    if (this.tvk != null) {
      ((n)com.tencent.mm.kernel.g.ad(n.class)).cancelSearchTask(this.tvk);
    }
    j localj = new j();
    localj.query = this.query;
    localj.tvc = this.tvc;
    localj.tvi = com.tencent.mm.plugin.fts.a.c.e.tvL;
    localj.tvh.add("create_talker_message​");
    localj.tvj = this;
    localj.handler = this.lRx;
    localj.jQN = 3;
    this.tvk = ((n)com.tencent.mm.kernel.g.ad(n.class)).search(3, localj);
    ad.i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", new Object[] { this.query });
    AppMethodBeat.o(111880);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(111882);
    super.finish();
    if (this.tvk != null) {
      ((n)com.tencent.mm.kernel.g.ad(n.class)).cancelSearchTask(this.tvk);
    }
    AppMethodBeat.o(111882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.g
 * JD-Core Version:    0.7.0.1
 */