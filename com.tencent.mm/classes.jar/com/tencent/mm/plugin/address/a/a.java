package com.tencent.mm.plugin.address.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.plugin.address.model.k;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements aw
{
  private l iYs;
  private com.tencent.mm.plugin.address.b.a.a iYt;
  private j iYu;
  private k iYv;
  
  public a()
  {
    AppMethodBeat.i(20756);
    this.iYs = null;
    this.iYt = null;
    this.iYu = new j();
    this.iYv = new k();
    AppMethodBeat.o(20756);
  }
  
  public static a aRF()
  {
    AppMethodBeat.i(20757);
    az.ayG();
    a locala2 = (a)bz.yz("plugin.address");
    a locala1 = locala2;
    if (locala2 == null)
    {
      ac.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
      locala1 = new a();
      az.ayG().a("plugin.address", locala1);
    }
    AppMethodBeat.o(20757);
    return locala1;
  }
  
  public static com.tencent.mm.plugin.address.b.a.a aRG()
  {
    AppMethodBeat.i(20758);
    g.agP().afT();
    if (aRF().iYt == null) {
      aRF().iYt = new com.tencent.mm.plugin.address.b.a.a();
    }
    com.tencent.mm.plugin.address.b.a.a locala = aRF().iYt;
    AppMethodBeat.o(20758);
    return locala;
  }
  
  public static l aRH()
  {
    AppMethodBeat.i(20759);
    g.agP().afT();
    if (aRF().iYs == null) {
      aRF().iYs = new l();
    }
    l locall = aRF().iYs;
    AppMethodBeat.o(20759);
    return locall;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(20760);
    com.tencent.mm.sdk.b.a.GpY.c(this.iYu);
    com.tencent.mm.sdk.b.a.GpY.c(this.iYv);
    l locall = aRH();
    az.ayM();
    String str = c.getAccPath();
    locall.path = (str + "addrmgr");
    AppMethodBeat.o(20760);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(20761);
    com.tencent.mm.sdk.b.a.GpY.d(this.iYu);
    com.tencent.mm.sdk.b.a.GpY.d(this.iYv);
    AppMethodBeat.o(20761);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.a.a
 * JD-Core Version:    0.7.0.1
 */