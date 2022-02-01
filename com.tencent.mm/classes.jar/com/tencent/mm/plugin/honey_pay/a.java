package com.tencent.mm.plugin.honey_pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.h;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.honey_pay.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private h<b> uFc;
  private c<pw> uFd;
  private q uFe;
  
  static
  {
    AppMethodBeat.i(64611);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("HoneyPayMsgRecord".hashCode()), new a.1());
    AppMethodBeat.o(64611);
  }
  
  public a()
  {
    AppMethodBeat.i(64607);
    this.uFc = new h(new a.2(this));
    this.uFd = new c() {};
    this.uFe = new a.4(this);
    AppMethodBeat.o(64607);
  }
  
  public static a dca()
  {
    AppMethodBeat.i(64606);
    a locala = (a)t.ap(a.class);
    AppMethodBeat.o(64606);
    return locala;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final b dcb()
  {
    AppMethodBeat.i(64610);
    b localb = (b)this.uFc.get();
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
    this.uFd.alive();
    ((r)g.ad(r.class)).getSysCmdMsgExtension().a("paymsg", this.uFe);
    AppMethodBeat.o(64608);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(64609);
    this.uFd.dead();
    ((r)g.ad(r.class)).getSysCmdMsgExtension().b("paymsg", this.uFe);
    AppMethodBeat.o(64609);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a
 * JD-Core Version:    0.7.0.1
 */