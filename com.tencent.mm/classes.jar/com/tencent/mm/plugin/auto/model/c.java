package com.tencent.mm.plugin.auto.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class c
  implements be
{
  private a uVL;
  
  public c()
  {
    AppMethodBeat.i(21158);
    this.uVL = new a();
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
    this.uVL.uVH.alive();
    AppMethodBeat.o(21159);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(21160);
    Log.i("MicroMsg.auto.SubCoreAuto", "onAccountRelease");
    this.uVL.uVH.dead();
    AppMethodBeat.o(21160);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.model.c
 * JD-Core Version:    0.7.0.1
 */