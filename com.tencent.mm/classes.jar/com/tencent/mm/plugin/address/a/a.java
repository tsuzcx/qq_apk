package com.tencent.mm.plugin.address.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ca;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.plugin.address.model.k;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements ax
{
  private l jrB;
  private com.tencent.mm.plugin.address.b.a.a jrC;
  private j jrD;
  private k jrE;
  
  public a()
  {
    AppMethodBeat.i(20756);
    this.jrB = null;
    this.jrC = null;
    this.jrD = new j();
    this.jrE = new k();
    AppMethodBeat.o(20756);
  }
  
  public static a aUR()
  {
    AppMethodBeat.i(20757);
    ba.aBK();
    a locala2 = (a)ca.By("plugin.address");
    a locala1 = locala2;
    if (locala2 == null)
    {
      ad.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
      locala1 = new a();
      ba.aBK().a("plugin.address", locala1);
    }
    AppMethodBeat.o(20757);
    return locala1;
  }
  
  public static com.tencent.mm.plugin.address.b.a.a aUS()
  {
    AppMethodBeat.i(20758);
    g.ajA().aiF();
    if (aUR().jrC == null) {
      aUR().jrC = new com.tencent.mm.plugin.address.b.a.a();
    }
    com.tencent.mm.plugin.address.b.a.a locala = aUR().jrC;
    AppMethodBeat.o(20758);
    return locala;
  }
  
  public static l aUT()
  {
    AppMethodBeat.i(20759);
    g.ajA().aiF();
    if (aUR().jrB == null) {
      aUR().jrB = new l();
    }
    l locall = aUR().jrB;
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
    com.tencent.mm.sdk.b.a.IbL.c(this.jrD);
    com.tencent.mm.sdk.b.a.IbL.c(this.jrE);
    l locall = aUT();
    ba.aBQ();
    String str = c.getAccPath();
    locall.path = (str + "addrmgr");
    AppMethodBeat.o(20760);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(20761);
    com.tencent.mm.sdk.b.a.IbL.d(this.jrD);
    com.tencent.mm.sdk.b.a.IbL.d(this.jrE);
    AppMethodBeat.o(20761);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.a.a
 * JD-Core Version:    0.7.0.1
 */