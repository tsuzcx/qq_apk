package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.c;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.be;
import java.util.HashMap;

public class n
  implements at
{
  public static HashMap<Integer, h.d> baseDBFactories;
  private c fJt;
  
  static
  {
    AppMethodBeat.i(16510);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(16510);
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.n ain()
  {
    AppMethodBeat.i(16506);
    g.RM();
    g.RJ().QQ();
    com.tencent.mm.plugin.messenger.foundation.a.a.n localn = ((j)g.E(j.class)).ain();
    AppMethodBeat.o(16506);
    return localn;
  }
  
  public static o aio()
  {
    AppMethodBeat.i(16507);
    o localo = ((com.tencent.mm.plugin.zero.b.b)g.E(com.tencent.mm.plugin.zero.b.b.class)).aio();
    AppMethodBeat.o(16507);
    return localo;
  }
  
  public static n aip()
  {
    AppMethodBeat.i(16508);
    aw.aat();
    n localn2 = (n)bw.pF(n.class.getName());
    n localn1 = localn2;
    if (localn2 == null)
    {
      localn1 = new n();
      aw.aat().a(n.class.getName(), localn1);
    }
    AppMethodBeat.o(16508);
    return localn1;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(16505);
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.ymk;
    c localc = new c();
    this.fJt = localc;
    locala.c(localc);
    AppMethodBeat.o(16505);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(16509);
    if (this.fJt != null)
    {
      c localc = this.fJt;
      com.tencent.mm.sdk.b.a.ymk.d(localc.fCE);
      com.tencent.mm.aq.b.agX().fCx = null;
      ((j)g.E(j.class)).YF().b(localc);
      aip();
      ain().remove(localc);
      com.tencent.mm.sdk.b.a.ymk.d(this.fJt);
    }
    AppMethodBeat.o(16509);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.n
 * JD-Core Version:    0.7.0.1
 */