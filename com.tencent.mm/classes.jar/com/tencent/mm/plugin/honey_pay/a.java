package com.tencent.mm.plugin.honey_pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.cm.h;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.honey_pay.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class a
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private h<b> nGX;
  private c<nq> nGY;
  private o nGZ;
  
  static
  {
    AppMethodBeat.i(41716);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("HoneyPayMsgRecord".hashCode()), new a.1());
    AppMethodBeat.o(41716);
  }
  
  public a()
  {
    AppMethodBeat.i(41712);
    this.nGX = new h(new a.2(this));
    this.nGY = new a.3(this);
    this.nGZ = new a.4(this);
    AppMethodBeat.o(41712);
  }
  
  public static a bHS()
  {
    AppMethodBeat.i(41711);
    a locala = (a)q.S(a.class);
    AppMethodBeat.o(41711);
    return locala;
  }
  
  public final b bHT()
  {
    AppMethodBeat.i(41715);
    b localb = (b)this.nGX.get();
    AppMethodBeat.o(41715);
    return localb;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(41713);
    this.nGY.alive();
    ((p)g.G(p.class)).getSysCmdMsgExtension().a("paymsg", this.nGZ);
    AppMethodBeat.o(41713);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(41714);
    this.nGY.dead();
    ((p)g.G(p.class)).getSysCmdMsgExtension().b("paymsg", this.nGZ);
    AppMethodBeat.o(41714);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a
 * JD-Core Version:    0.7.0.1
 */