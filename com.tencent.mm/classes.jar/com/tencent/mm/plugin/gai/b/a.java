package com.tencent.mm.plugin.gai.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements be
{
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(25276);
    Log.i("MicroMsg.SubCoreGai", "SubCoreGai onAccountPostReset!");
    AppMethodBeat.o(25276);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(25277);
    Log.i("MicroMsg.SubCoreGai", "SubCoreGai onAccountRelease!");
    AppMethodBeat.o(25277);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gai.b.a
 * JD-Core Version:    0.7.0.1
 */