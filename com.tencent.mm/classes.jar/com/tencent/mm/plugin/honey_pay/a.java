package com.tencent.mm.plugin.honey_pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.h;
import com.tencent.mm.g.a.pm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.honey_pay.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private h<b> tCt;
  private com.tencent.mm.sdk.b.c<pm> tCu;
  private p tCv;
  
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
    this.tCt = new h(new com.tencent.mm.cn.c() {});
    this.tCu = new com.tencent.mm.sdk.b.c() {};
    this.tCv = new a.4(this);
    AppMethodBeat.o(64607);
  }
  
  public static a cST()
  {
    AppMethodBeat.i(64606);
    a locala = (a)t.ap(a.class);
    AppMethodBeat.o(64606);
    return locala;
  }
  
  public final b cSU()
  {
    AppMethodBeat.i(64610);
    b localb = (b)this.tCt.get();
    AppMethodBeat.o(64610);
    return localb;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(64608);
    this.tCu.alive();
    ((q)g.ad(q.class)).getSysCmdMsgExtension().a("paymsg", this.tCv);
    AppMethodBeat.o(64608);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64609);
    this.tCu.dead();
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("paymsg", this.tCv);
    AppMethodBeat.o(64609);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a
 * JD-Core Version:    0.7.0.1
 */