package com.tencent.mm.plugin.address.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ci;
import com.tencent.mm.plugin.address.model.RcptAddressEventListener;
import com.tencent.mm.plugin.address.model.RcptGetAddrEventListener;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements be
{
  private j qhB;
  private com.tencent.mm.plugin.address.b.a.a qhC;
  private RcptAddressEventListener qhD;
  private RcptGetAddrEventListener qhE;
  
  public a()
  {
    AppMethodBeat.i(20756);
    this.qhB = null;
    this.qhC = null;
    this.qhD = new RcptAddressEventListener();
    this.qhE = new RcptGetAddrEventListener();
    AppMethodBeat.o(20756);
  }
  
  public static a bZe()
  {
    AppMethodBeat.i(20757);
    bh.bCt();
    a locala2 = (a)ci.Ka("plugin.address");
    a locala1 = locala2;
    if (locala2 == null)
    {
      Log.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
      locala1 = new a();
      bh.bCt().a("plugin.address", locala1);
    }
    AppMethodBeat.o(20757);
    return locala1;
  }
  
  public static com.tencent.mm.plugin.address.b.a.a bZf()
  {
    AppMethodBeat.i(20758);
    h.baC().aZJ();
    if (bZe().qhC == null) {
      bZe().qhC = new com.tencent.mm.plugin.address.b.a.a();
    }
    com.tencent.mm.plugin.address.b.a.a locala = bZe().qhC;
    AppMethodBeat.o(20758);
    return locala;
  }
  
  public static j bZg()
  {
    AppMethodBeat.i(20759);
    h.baC().aZJ();
    if (bZe().qhB == null) {
      bZe().qhB = new j();
    }
    j localj = bZe().qhB;
    AppMethodBeat.o(20759);
    return localj;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(20760);
    this.qhD.alive();
    this.qhE.alive();
    bZg();
    AppMethodBeat.o(20760);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(20761);
    this.qhD.dead();
    this.qhE.dead();
    AppMethodBeat.o(20761);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.a.a
 * JD-Core Version:    0.7.0.1
 */