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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements aw
{
  private l iyp;
  private com.tencent.mm.plugin.address.b.a.a iyq;
  private j iyr;
  private k iys;
  
  public a()
  {
    AppMethodBeat.i(20756);
    this.iyp = null;
    this.iyq = null;
    this.iyr = new j();
    this.iys = new k();
    AppMethodBeat.o(20756);
  }
  
  public static a aKO()
  {
    AppMethodBeat.i(20757);
    az.arP();
    a locala2 = (a)bz.ut("plugin.address");
    a locala1 = locala2;
    if (locala2 == null)
    {
      ad.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
      locala1 = new a();
      az.arP().a("plugin.address", locala1);
    }
    AppMethodBeat.o(20757);
    return locala1;
  }
  
  public static com.tencent.mm.plugin.address.b.a.a aKP()
  {
    AppMethodBeat.i(20758);
    g.afz().aeD();
    if (aKO().iyq == null) {
      aKO().iyq = new com.tencent.mm.plugin.address.b.a.a();
    }
    com.tencent.mm.plugin.address.b.a.a locala = aKO().iyq;
    AppMethodBeat.o(20758);
    return locala;
  }
  
  public static l aKQ()
  {
    AppMethodBeat.i(20759);
    g.afz().aeD();
    if (aKO().iyp == null) {
      aKO().iyp = new l();
    }
    l locall = aKO().iyp;
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
    com.tencent.mm.sdk.b.a.ESL.c(this.iyr);
    com.tencent.mm.sdk.b.a.ESL.c(this.iys);
    l locall = aKQ();
    az.arV();
    String str = c.getAccPath();
    locall.path = (str + "addrmgr");
    AppMethodBeat.o(20760);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(20761);
    com.tencent.mm.sdk.b.a.ESL.d(this.iyr);
    com.tencent.mm.sdk.b.a.ESL.d(this.iys);
    AppMethodBeat.o(20761);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.a.a
 * JD-Core Version:    0.7.0.1
 */