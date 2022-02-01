package com.tencent.mm.plugin.address.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.plugin.address.model.k;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements bd
{
  private l ksJ;
  private com.tencent.mm.plugin.address.b.a.a ksK;
  private j ksL;
  private k ksM;
  
  public a()
  {
    AppMethodBeat.i(20756);
    this.ksJ = null;
    this.ksK = null;
    this.ksL = new j();
    this.ksM = new k();
    AppMethodBeat.o(20756);
  }
  
  public static a bqb()
  {
    AppMethodBeat.i(20757);
    bg.aVz();
    a locala2 = (a)cg.KG("plugin.address");
    a locala1 = locala2;
    if (locala2 == null)
    {
      Log.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
      locala1 = new a();
      bg.aVz().a("plugin.address", locala1);
    }
    AppMethodBeat.o(20757);
    return locala1;
  }
  
  public static com.tencent.mm.plugin.address.b.a.a bqc()
  {
    AppMethodBeat.i(20758);
    g.aAf().azk();
    if (bqb().ksK == null) {
      bqb().ksK = new com.tencent.mm.plugin.address.b.a.a();
    }
    com.tencent.mm.plugin.address.b.a.a locala = bqb().ksK;
    AppMethodBeat.o(20758);
    return locala;
  }
  
  public static l bqd()
  {
    AppMethodBeat.i(20759);
    g.aAf().azk();
    if (bqb().ksJ == null) {
      bqb().ksJ = new l();
    }
    l locall = bqb().ksJ;
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
    EventCenter.instance.addListener(this.ksL);
    EventCenter.instance.addListener(this.ksM);
    l locall = bqd();
    bg.aVF();
    String str = c.getAccPath();
    locall.path = (str + "addrmgr");
    AppMethodBeat.o(20760);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(20761);
    EventCenter.instance.removeListener(this.ksL);
    EventCenter.instance.removeListener(this.ksM);
    AppMethodBeat.o(20761);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.a.a
 * JD-Core Version:    0.7.0.1
 */