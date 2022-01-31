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

public final class v$a
  implements bx.a
{
  private static final a fJt = new a();
  
  public static void adn()
  {
    ((p)g.t(p.class)).getSysCmdMsgExtension().a("UpdateWxaUsageListNotify", fJt, true);
  }
  
  public static void unregister()
  {
    ((p)g.t(p.class)).getSysCmdMsgExtension().b("UpdateWxaUsageListNotify", fJt, true);
  }
  
  public final void a(e.a parama)
  {
    parama = aa.a(parama.dBs.svH);
    if (bk.bl(parama)) {
      return;
    }
    c.DS().O(new v.a.1(this, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.v.a
 * JD-Core Version:    0.7.0.1
 */