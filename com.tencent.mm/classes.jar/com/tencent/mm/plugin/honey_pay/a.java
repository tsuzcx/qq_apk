package com.tencent.mm.plugin.honey_pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.c;
import com.tencent.mm.co.h;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.honey_pay.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private h<b> yjt;
  private IListener<qr> yju;
  private q yjv;
  
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
    this.yjt = new h(new c() {});
    this.yju = new a.3(this);
    this.yjv = new a.4(this);
    AppMethodBeat.o(64607);
  }
  
  public static a dYM()
  {
    AppMethodBeat.i(64606);
    a locala = (a)y.at(a.class);
    AppMethodBeat.o(64606);
    return locala;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final b dYN()
  {
    AppMethodBeat.i(64610);
    b localb = (b)this.yjt.get();
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
    this.yju.alive();
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", this.yjv);
    AppMethodBeat.o(64608);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64609);
    this.yju.dead();
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", this.yjv);
    AppMethodBeat.o(64609);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a
 * JD-Core Version:    0.7.0.1
 */