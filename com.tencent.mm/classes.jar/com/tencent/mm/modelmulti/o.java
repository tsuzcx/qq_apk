package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class o
  implements aw
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private c hmw;
  
  static
  {
    AppMethodBeat.i(20556);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(20556);
  }
  
  public static n azu()
  {
    AppMethodBeat.i(20552);
    g.afC();
    g.afz().aeD();
    n localn = ((k)g.ab(k.class)).azu();
    AppMethodBeat.o(20552);
    return localn;
  }
  
  public static p azv()
  {
    AppMethodBeat.i(20553);
    p localp = ((com.tencent.mm.plugin.zero.b.b)g.ab(com.tencent.mm.plugin.zero.b.b.class)).azv();
    AppMethodBeat.o(20553);
    return localp;
  }
  
  public static o azw()
  {
    AppMethodBeat.i(20554);
    az.arP();
    o localo2 = (o)bz.ut(o.class.getName());
    o localo1 = localo2;
    if (localo2 == null)
    {
      localo1 = new o();
      az.arP().a(o.class.getName(), localo1);
    }
    AppMethodBeat.o(20554);
    return localo1;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(20551);
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.ESL;
    c localc = new c();
    this.hmw = localc;
    locala.c(localc);
    AppMethodBeat.o(20551);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20555);
    if (this.hmw != null)
    {
      c localc = this.hmw;
      com.tencent.mm.sdk.b.a.ESL.d(localc.hff);
      com.tencent.mm.at.b.axZ().heY = null;
      ((k)g.ab(k.class)).apR().b(localc);
      azw();
      azu().remove(localc);
      com.tencent.mm.sdk.b.a.ESL.d(this.hmw);
    }
    AppMethodBeat.o(20555);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o
 * JD-Core Version:    0.7.0.1
 */