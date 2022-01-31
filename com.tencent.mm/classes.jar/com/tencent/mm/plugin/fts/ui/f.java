package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.u;
import java.util.List;

public final class f
  extends d
  implements com.tencent.mm.plugin.fts.a.l
{
  private ah gNQ = new ah();
  private u kBd;
  private j kwU;
  private String kwY;
  private com.tencent.mm.plugin.fts.a.a.a kxg;
  
  public f(e parame, String paramString)
  {
    super(parame);
    this.kwY = paramString;
    if (s.gZ(paramString)) {
      this.kBd = ((c)g.r(c.class)).FF().in(paramString);
    }
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    return false;
  }
  
  protected final void aVV()
  {
    clearCache();
    if (this.kxg != null) {
      ((n)g.t(n.class)).cancelSearchTask(this.kxg);
    }
    i locali = new i();
    locali.bVk = this.bVk;
    locali.kwY = this.kwY;
    locali.kxe = com.tencent.mm.plugin.fts.a.c.e.kxH;
    locali.kxf = this;
    locali.handler = this.gNQ;
    locali.kwX = 3;
    this.kxg = ((n)g.t(n.class)).search(3, locali);
    y.i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", new Object[] { this.bVk });
  }
  
  public final void b(j paramj)
  {
    switch (paramj.aYY)
    {
    default: 
      return;
    case 0: 
      this.kwU = paramj;
      setCount(paramj.kxh.size());
      notifyDataSetChanged();
      N(getCount(), true);
      return;
    }
    setCount(0);
    notifyDataSetChanged();
    N(getCount(), true);
  }
  
  public final void finish()
  {
    super.finish();
    if (this.kxg != null) {
      ((n)g.t(n.class)).cancelSearchTask(this.kxg);
    }
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a ry(int paramInt)
  {
    com.tencent.mm.plugin.fts.ui.a.d locald = new com.tencent.mm.plugin.fts.ui.a.d(paramInt);
    locald.fYx = ((com.tencent.mm.plugin.fts.a.a.l)this.kwU.kxh.get(paramInt));
    locald.kwi = this.kwU.kwi;
    locald.kxU = -14;
    locald.kBd = this.kBd;
    locald.kxV = paramInt;
    locald.pageType = 6;
    if (locald.position == getCount() - 1) {
      locald.kxT = true;
    }
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.f
 * JD-Core Version:    0.7.0.1
 */