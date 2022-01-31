package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;

public final class d$a
  extends m.b
{
  public d$a(d paramd)
  {
    super(paramd);
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    paramContext = (d)parama1;
    parama = (m.a)parama;
    m.k(parama.contentView, this.kCK.kxT);
    if (bk.bl(paramContext.fYx.talker)) {
      a.b.a(parama.doU, paramContext.fYx.kwg);
    }
    for (;;)
    {
      m.a(paramContext.kCI, parama.doV);
      m.a(paramContext.eXL, parama.dsy);
      m.a(paramContext.kDD, parama.dsz);
      return;
      a.b.a(parama.doU, paramContext.fYx.talker);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.d.a
 * JD-Core Version:    0.7.0.1
 */