package com.tencent.mm.plugin.address.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.plugin.address.model.k;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class a
  implements at
{
  private l gKF;
  private com.tencent.mm.plugin.address.b.a.a gKG;
  private j gKH;
  private k gKI;
  
  public a()
  {
    AppMethodBeat.i(16713);
    this.gKF = null;
    this.gKG = null;
    this.gKH = new j();
    this.gKI = new k();
    AppMethodBeat.o(16713);
  }
  
  public static a asl()
  {
    AppMethodBeat.i(16714);
    aw.aat();
    a locala2 = (a)bw.pF("plugin.address");
    a locala1 = locala2;
    if (locala2 == null)
    {
      ab.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
      locala1 = new a();
      aw.aat().a("plugin.address", locala1);
    }
    AppMethodBeat.o(16714);
    return locala1;
  }
  
  public static com.tencent.mm.plugin.address.b.a.a asm()
  {
    AppMethodBeat.i(16715);
    g.RJ().QQ();
    if (asl().gKG == null) {
      asl().gKG = new com.tencent.mm.plugin.address.b.a.a();
    }
    com.tencent.mm.plugin.address.b.a.a locala = asl().gKG;
    AppMethodBeat.o(16715);
    return locala;
  }
  
  public static l asn()
  {
    AppMethodBeat.i(16716);
    g.RJ().QQ();
    if (asl().gKF == null) {
      asl().gKF = new l();
    }
    l locall = asl().gKF;
    AppMethodBeat.o(16716);
    return locall;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(16717);
    com.tencent.mm.sdk.b.a.ymk.c(this.gKH);
    com.tencent.mm.sdk.b.a.ymk.c(this.gKI);
    l locall = asn();
    aw.aaz();
    String str = c.getAccPath();
    locall.path = (str + "addrmgr");
    AppMethodBeat.o(16717);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(16718);
    com.tencent.mm.sdk.b.a.ymk.d(this.gKH);
    com.tencent.mm.sdk.b.a.ymk.d(this.gKI);
    AppMethodBeat.o(16718);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.a.a
 * JD-Core Version:    0.7.0.1
 */