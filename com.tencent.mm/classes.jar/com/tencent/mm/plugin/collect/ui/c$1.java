package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.ag.b;
import com.tencent.mm.ag.o;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements am.b.a
{
  c$1(c paramc, long paramLong) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      y.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (bk.UY() - this.iJC) + " ms");
      b.M(paramString, 3);
      o.Kj().kb(paramString);
    }
    for (;;)
    {
      a.b.a(c.a(this.iMe), c.b(this.iMe));
      return;
      y.w("MicroMsg.CollectPayInfoPreference", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.c.1
 * JD-Core Version:    0.7.0.1
 */