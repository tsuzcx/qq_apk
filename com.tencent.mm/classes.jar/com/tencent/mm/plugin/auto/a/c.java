package com.tencent.mm.plugin.auto.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class c
  implements bd
{
  private a oIH;
  
  public c()
  {
    AppMethodBeat.i(21158);
    this.oIH = new a();
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
    Log.i("MicroMsg.auto.SubCoreAuto", "onAccountPostReset");
    a locala = this.oIH;
    EventCenter.instance.addListener(locala.oID);
    AppMethodBeat.o(21159);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(21160);
    Log.i("MicroMsg.auto.SubCoreAuto", "onAccountRelease");
    a locala = this.oIH;
    EventCenter.instance.removeListener(locala.oID);
    AppMethodBeat.o(21160);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.a.c
 * JD-Core Version:    0.7.0.1
 */