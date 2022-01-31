package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;

public final class r$b
  implements bx.a
{
  private static final b fJc = new b();
  
  public static void adn()
  {
    q.acY();
    ((p)g.t(p.class)).getSysCmdMsgExtension().a("wxareddot", fJc, true);
  }
  
  public static void unregister()
  {
    q.acY();
    ((p)g.t(p.class)).getSysCmdMsgExtension().b("wxareddot", fJc, true);
  }
  
  public final void a(e.a parama)
  {
    parama = aa.a(parama.dBs.svH);
    if (bk.bl(parama)) {
      return;
    }
    c.DS().O(new r.b.1(this, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.r.b
 * JD-Core Version:    0.7.0.1
 */