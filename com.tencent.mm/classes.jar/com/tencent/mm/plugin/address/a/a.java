package com.tencent.mm.plugin.address.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.plugin.address.model.k;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements be
{
  private l nks;
  private com.tencent.mm.plugin.address.b.a.a nkt;
  private j nku;
  private k nkv;
  
  public a()
  {
    AppMethodBeat.i(20756);
    this.nks = null;
    this.nkt = null;
    this.nku = new j();
    this.nkv = new k();
    AppMethodBeat.o(20756);
  }
  
  public static a bAn()
  {
    AppMethodBeat.i(20757);
    bh.beC();
    a locala2 = (a)ch.RZ("plugin.address");
    a locala1 = locala2;
    if (locala2 == null)
    {
      Log.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
      locala1 = new a();
      bh.beC().a("plugin.address", locala1);
    }
    AppMethodBeat.o(20757);
    return locala1;
  }
  
  public static com.tencent.mm.plugin.address.b.a.a bAo()
  {
    AppMethodBeat.i(20758);
    h.aHE().aGH();
    if (bAn().nkt == null) {
      bAn().nkt = new com.tencent.mm.plugin.address.b.a.a();
    }
    com.tencent.mm.plugin.address.b.a.a locala = bAn().nkt;
    AppMethodBeat.o(20758);
    return locala;
  }
  
  public static l bAp()
  {
    AppMethodBeat.i(20759);
    h.aHE().aGH();
    if (bAn().nks == null) {
      bAn().nks = new l();
    }
    l locall = bAn().nks;
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
    EventCenter.instance.addListener(this.nku);
    EventCenter.instance.addListener(this.nkv);
    bAp();
    AppMethodBeat.o(20760);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(20761);
    EventCenter.instance.removeListener(this.nku);
    EventCenter.instance.removeListener(this.nkv);
    AppMethodBeat.o(20761);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.a.a
 * JD-Core Version:    0.7.0.1
 */