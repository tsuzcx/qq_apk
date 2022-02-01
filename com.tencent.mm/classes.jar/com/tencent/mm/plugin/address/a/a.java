package com.tencent.mm.plugin.address.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.plugin.address.model.k;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements az
{
  private l juu;
  private com.tencent.mm.plugin.address.b.a.a juv;
  private j juw;
  private k jux;
  
  public a()
  {
    AppMethodBeat.i(20756);
    this.juu = null;
    this.juv = null;
    this.juw = new j();
    this.jux = new k();
    AppMethodBeat.o(20756);
  }
  
  public static a aVq()
  {
    AppMethodBeat.i(20757);
    bc.aCa();
    a locala2 = (a)cc.Ca("plugin.address");
    a locala1 = locala2;
    if (locala2 == null)
    {
      ae.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
      locala1 = new a();
      bc.aCa().a("plugin.address", locala1);
    }
    AppMethodBeat.o(20757);
    return locala1;
  }
  
  public static com.tencent.mm.plugin.address.b.a.a aVr()
  {
    AppMethodBeat.i(20758);
    g.ajP().aiU();
    if (aVq().juv == null) {
      aVq().juv = new com.tencent.mm.plugin.address.b.a.a();
    }
    com.tencent.mm.plugin.address.b.a.a locala = aVq().juv;
    AppMethodBeat.o(20758);
    return locala;
  }
  
  public static l aVs()
  {
    AppMethodBeat.i(20759);
    g.ajP().aiU();
    if (aVq().juu == null) {
      aVq().juu = new l();
    }
    l locall = aVq().juu;
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
    com.tencent.mm.sdk.b.a.IvT.c(this.juw);
    com.tencent.mm.sdk.b.a.IvT.c(this.jux);
    l locall = aVs();
    bc.aCg();
    String str = c.getAccPath();
    locall.path = (str + "addrmgr");
    AppMethodBeat.o(20760);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(20761);
    com.tencent.mm.sdk.b.a.IvT.d(this.juw);
    com.tencent.mm.sdk.b.a.IvT.d(this.jux);
    AppMethodBeat.o(20761);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.a.a
 * JD-Core Version:    0.7.0.1
 */