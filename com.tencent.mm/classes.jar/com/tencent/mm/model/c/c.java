package com.tencent.mm.model.c;

import android.annotation.SuppressLint;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.storage.d;
import java.util.HashMap;

public class c
  implements ar
{
  @SuppressLint({"UseSparseArrays"})
  private static HashMap<Integer, h.d> dgp;
  private d dYO;
  private com.tencent.mm.storage.b dYP;
  private bx.a dYQ = new c.1(this);
  private com.tencent.mm.sdk.b.c dYR = new c.2(this);
  private j.a dYS = new c.3(this);
  private com.tencent.mm.vending.b.b dYT = null;
  private final com.tencent.mm.plugin.auth.a.a dYU = new c.4(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("NEW_ABTEST_TABLE".hashCode()), new c.5());
    dgp.put(Integer.valueOf("NEW_ABTEST_INFO_TABLE".hashCode()), new c.6());
  }
  
  private static c IW()
  {
    try
    {
      c localc = (c)com.tencent.mm.model.p.B(c.class);
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static d IX()
  {
    g.DN().CX();
    if (IW().dYO == null) {
      IW().dYO = new d(g.DP().dKu);
    }
    return IW().dYO;
  }
  
  public static com.tencent.mm.storage.b IY()
  {
    g.DN().CX();
    if (IW().dYP == null) {
      IW().dYP = new com.tencent.mm.storage.b(g.DP().dKu);
    }
    return IW().dYP;
  }
  
  public final void bh(boolean paramBoolean)
  {
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("newabtest", this.dYQ, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("newabtestinfo", this.dYQ, true);
    com.tencent.mm.sdk.b.a.udP.c(this.dYR);
    IX().c(this.dYS);
    this.dYT = ((com.tencent.mm.plugin.auth.a.b)g.t(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.dYU);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("newabtest", this.dYQ, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("newabtestinfo", this.dYQ, true);
    com.tencent.mm.sdk.b.a.udP.d(this.dYR);
    IX().d(this.dYS);
    if (this.dYT != null)
    {
      this.dYT.dead();
      this.dYT = null;
    }
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.c.c
 * JD-Core Version:    0.7.0.1
 */