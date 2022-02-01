package com.tencent.mm.plugin.auto.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class b
  implements aw
{
  private a mpO;
  
  public b()
  {
    AppMethodBeat.i(21158);
    this.mpO = new a();
    AppMethodBeat.o(21158);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(21159);
    ad.i("MicroMsg.auto.SubCoreAuto", "onAccountPostReset");
    a locala = this.mpO;
    com.tencent.mm.sdk.b.a.ESL.c(locala.mpM);
    AppMethodBeat.o(21159);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(21160);
    ad.i("MicroMsg.auto.SubCoreAuto", "onAccountRelease");
    a locala = this.mpO;
    com.tencent.mm.sdk.b.a.ESL.d(locala.mpM);
    AppMethodBeat.o(21160);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.b
 * JD-Core Version:    0.7.0.1
 */