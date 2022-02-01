package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class p
  implements be
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private c lUC;
  
  static
  {
    AppMethodBeat.i(20556);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(20556);
  }
  
  public static o bnm()
  {
    AppMethodBeat.i(20552);
    h.aHH();
    h.aHE().aGH();
    o localo = ((n)h.ae(n.class)).bnm();
    AppMethodBeat.o(20552);
    return localo;
  }
  
  public static q bnn()
  {
    AppMethodBeat.i(20553);
    q localq = ((com.tencent.mm.plugin.zero.b.b)h.ae(com.tencent.mm.plugin.zero.b.b.class)).bnn();
    AppMethodBeat.o(20553);
    return localq;
  }
  
  public static p bno()
  {
    AppMethodBeat.i(20554);
    bh.beC();
    p localp2 = (p)ch.RZ(p.class.getName());
    p localp1 = localp2;
    if (localp2 == null)
    {
      localp1 = new p();
      bh.beC().a(p.class.getName(), localp1);
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
    EventCenter localEventCenter = EventCenter.instance;
    c localc = new c();
    this.lUC = localc;
    localEventCenter.addListener(localc);
    AppMethodBeat.o(20551);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20555);
    if (this.lUC != null)
    {
      c localc = this.lUC;
      EventCenter.instance.removeListener(localc.lMy);
      com.tencent.mm.av.b.blw().lMr = null;
      ((n)h.ae(n.class)).bbR().remove(localc);
      bno();
      bnm().remove(localc);
      EventCenter.instance.removeListener(this.lUC);
    }
    AppMethodBeat.o(20555);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.p
 * JD-Core Version:    0.7.0.1
 */