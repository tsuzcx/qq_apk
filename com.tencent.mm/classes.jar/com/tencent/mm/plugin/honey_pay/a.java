package com.tencent.mm.plugin.honey_pay;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.ck.h;
import com.tencent.mm.h.a.mu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.honey_pay.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class a
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private h<b> ljB = new h(new a.2(this));
  private c<mu> ljC = new a.3(this);
  private o ljD = new a.4(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("HoneyPayMsgRecord".hashCode()), new a.1());
  }
  
  public static a baR()
  {
    return (a)com.tencent.mm.model.p.B(a.class);
  }
  
  public final b baS()
  {
    return (b)this.ljB.get();
  }
  
  public final void bh(boolean paramBoolean)
  {
    this.ljC.cqo();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("paymsg", this.ljD);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    this.ljC.dead();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("paymsg", this.ljD);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a
 * JD-Core Version:    0.7.0.1
 */