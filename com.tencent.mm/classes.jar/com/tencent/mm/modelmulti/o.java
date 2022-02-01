package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.as.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class o
  implements aw
{
  public static HashMap<Integer, h.b> baseDBFactories;
  private c hMZ;
  
  static
  {
    AppMethodBeat.i(20556);
    baseDBFactories = new HashMap();
    AppMethodBeat.o(20556);
  }
  
  public static n aGl()
  {
    AppMethodBeat.i(20552);
    g.agS();
    g.agP().afT();
    n localn = ((k)g.ab(k.class)).aGl();
    AppMethodBeat.o(20552);
    return localn;
  }
  
  public static p aGm()
  {
    AppMethodBeat.i(20553);
    p localp = ((com.tencent.mm.plugin.zero.b.b)g.ab(com.tencent.mm.plugin.zero.b.b.class)).aGm();
    AppMethodBeat.o(20553);
    return localp;
  }
  
  public static o aGn()
  {
    AppMethodBeat.i(20554);
    az.ayG();
    o localo2 = (o)bz.yz(o.class.getName());
    o localo1 = localo2;
    if (localo2 == null)
    {
      localo1 = new o();
      az.ayG().a(o.class.getName(), localo1);
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
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.GpY;
    c localc = new c();
    this.hMZ = localc;
    locala.c(localc);
    AppMethodBeat.o(20551);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20555);
    if (this.hMZ != null)
    {
      c localc = this.hMZ;
      com.tencent.mm.sdk.b.a.GpY.d(localc.hFI);
      com.tencent.mm.as.b.aER().hFB = null;
      ((k)g.ab(k.class)).awG().b(localc);
      aGn();
      aGl().remove(localc);
      com.tencent.mm.sdk.b.a.GpY.d(this.hMZ);
    }
    AppMethodBeat.o(20555);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o
 * JD-Core Version:    0.7.0.1
 */