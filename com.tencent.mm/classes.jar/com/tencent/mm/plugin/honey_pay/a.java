package com.tencent.mm.plugin.honey_pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.h;
import com.tencent.mm.g.a.px;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.honey_pay.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private h<b> uQP;
  private com.tencent.mm.sdk.b.c<px> uQQ;
  private q uQR;
  
  static
  {
    AppMethodBeat.i(64611);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("HoneyPayMsgRecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(64611);
  }
  
  public a()
  {
    AppMethodBeat.i(64607);
    this.uQP = new h(new com.tencent.mm.cm.c() {});
    this.uQQ = new com.tencent.mm.sdk.b.c() {};
    this.uQR = new a.4(this);
    AppMethodBeat.o(64607);
  }
  
  public static a deS()
  {
    AppMethodBeat.i(64606);
    a locala = (a)u.ap(a.class);
    AppMethodBeat.o(64606);
    return locala;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final b deT()
  {
    AppMethodBeat.i(64610);
    b localb = (b)this.uQP.get();
    AppMethodBeat.o(64610);
    return localb;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(64608);
    this.uQQ.alive();
    ((s)g.ad(s.class)).getSysCmdMsgExtension().a("paymsg", this.uQR);
    AppMethodBeat.o(64608);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64609);
    this.uQQ.dead();
    ((s)g.ad(s.class)).getSysCmdMsgExtension().b("paymsg", this.uQR);
    AppMethodBeat.o(64609);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a
 * JD-Core Version:    0.7.0.1
 */