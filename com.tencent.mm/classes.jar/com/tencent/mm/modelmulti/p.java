package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.as.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class p
  implements bd
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private c jed;
  
  static
  {
    AppMethodBeat.i(20556);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(20556);
  }
  
  public static o bdR()
  {
    AppMethodBeat.i(20552);
    g.aAi();
    g.aAf().azk();
    o localo = ((l)g.af(l.class)).bdR();
    AppMethodBeat.o(20552);
    return localo;
  }
  
  public static q bdS()
  {
    AppMethodBeat.i(20553);
    q localq = ((com.tencent.mm.plugin.zero.b.b)g.af(com.tencent.mm.plugin.zero.b.b.class)).bdS();
    AppMethodBeat.o(20553);
    return localq;
  }
  
  public static p bdT()
  {
    AppMethodBeat.i(20554);
    bg.aVz();
    p localp2 = (p)cg.KG(p.class.getName());
    p localp1 = localp2;
    if (localp2 == null)
    {
      localp1 = new p();
      bg.aVz().a(p.class.getName(), localp1);
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
    this.jed = localc;
    localEventCenter.addListener(localc);
    AppMethodBeat.o(20551);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20555);
    if (this.jed != null)
    {
      c localc = this.jed;
      EventCenter.instance.removeListener(localc.iWd);
      com.tencent.mm.as.b.bch().iVW = null;
      ((l)g.af(l.class)).aST().remove(localc);
      bdT();
      bdR().remove(localc);
      EventCenter.instance.removeListener(this.jed);
    }
    AppMethodBeat.o(20555);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.p
 * JD-Core Version:    0.7.0.1
 */