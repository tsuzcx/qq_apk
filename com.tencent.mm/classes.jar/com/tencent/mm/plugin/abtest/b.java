package com.tencent.mm.plugin.abtest;

import com.tencent.mm.ah.e.d;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.a.a;
import com.tencent.mm.model.a.d;
import com.tencent.mm.model.bx;

public final class b
  extends com.tencent.mm.model.p
  implements c
{
  private static b eZV;
  private d eZW = new d();
  private a eZX = new a();
  
  private b()
  {
    super(com.tencent.mm.model.a.g.class);
  }
  
  public static b VS()
  {
    try
    {
      if (eZV == null) {
        eZV = new b();
      }
      b localb = eZV;
      return localb;
    }
    finally {}
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    super.onAccountInitialized(paramc);
    e.d.a(Integer.valueOf(-1879048184), this.eZW);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("abtest", this.eZX);
  }
  
  public final void onAccountRelease()
  {
    super.onAccountRelease();
    e.d.a(Integer.valueOf(-1879048184), this.eZW);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("abtest", this.eZX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.b
 * JD-Core Version:    0.7.0.1
 */