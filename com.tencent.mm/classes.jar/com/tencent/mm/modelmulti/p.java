package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class p
  implements ax
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private c igo;
  
  static
  {
    AppMethodBeat.i(20556);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(20556);
  }
  
  public static o aJw()
  {
    AppMethodBeat.i(20552);
    g.ajD();
    g.ajA().aiF();
    o localo = ((l)g.ab(l.class)).aJw();
    AppMethodBeat.o(20552);
    return localo;
  }
  
  public static q aJx()
  {
    AppMethodBeat.i(20553);
    q localq = ((com.tencent.mm.plugin.zero.b.b)g.ab(com.tencent.mm.plugin.zero.b.b.class)).aJx();
    AppMethodBeat.o(20553);
    return localq;
  }
  
  public static p aJy()
  {
    AppMethodBeat.i(20554);
    ba.aBK();
    p localp2 = (p)ca.By(p.class.getName());
    p localp1 = localp2;
    if (localp2 == null)
    {
      localp1 = new p();
      ba.aBK().a(p.class.getName(), localp1);
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
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.IbL;
    c localc = new c();
    this.igo = localc;
    locala.c(localc);
    AppMethodBeat.o(20551);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20555);
    if (this.igo != null)
    {
      c localc = this.igo;
      com.tencent.mm.sdk.b.a.IbL.d(localc.hYn);
      com.tencent.mm.at.b.aHW().hYg = null;
      ((l)g.ab(l.class)).azv().b(localc);
      aJy();
      aJw().remove(localc);
      com.tencent.mm.sdk.b.a.IbL.d(this.igo);
    }
    AppMethodBeat.o(20555);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.p
 * JD-Core Version:    0.7.0.1
 */