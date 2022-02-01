package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.as.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.br;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class p
  implements az
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private c ijh;
  
  static
  {
    AppMethodBeat.i(20556);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(20556);
  }
  
  public static o aJP()
  {
    AppMethodBeat.i(20552);
    g.ajS();
    g.ajP().aiU();
    o localo = ((l)g.ab(l.class)).aJP();
    AppMethodBeat.o(20552);
    return localo;
  }
  
  public static q aJQ()
  {
    AppMethodBeat.i(20553);
    q localq = ((com.tencent.mm.plugin.zero.b.b)g.ab(com.tencent.mm.plugin.zero.b.b.class)).aJQ();
    AppMethodBeat.o(20553);
    return localq;
  }
  
  public static p aJR()
  {
    AppMethodBeat.i(20554);
    bc.aCa();
    p localp2 = (p)cc.Ca(p.class.getName());
    p localp1 = localp2;
    if (localp2 == null)
    {
      localp1 = new p();
      bc.aCa().a(p.class.getName(), localp1);
    }
    AppMethodBeat.o(20554);
    return localp1;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(20551);
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.IvT;
    c localc = new c();
    this.ijh = localc;
    locala.c(localc);
    AppMethodBeat.o(20551);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20555);
    if (this.ijh != null)
    {
      c localc = this.ijh;
      com.tencent.mm.sdk.b.a.IvT.d(localc.ibf);
      com.tencent.mm.as.b.aIn().iaY = null;
      ((l)g.ab(l.class)).azL().b(localc);
      aJR();
      aJP().remove(localc);
      com.tencent.mm.sdk.b.a.IvT.d(this.ijh);
    }
    AppMethodBeat.o(20555);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.p
 * JD-Core Version:    0.7.0.1
 */