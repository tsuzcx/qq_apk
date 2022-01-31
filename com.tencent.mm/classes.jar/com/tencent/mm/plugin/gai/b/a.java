package com.tencent.mm.plugin.gai.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class a
  implements at
{
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(21214);
    ab.i("MicroMsg.SubCoreGai", "SubCoreGai onAccountPostReset!");
    AppMethodBeat.o(21214);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(21215);
    ab.i("MicroMsg.SubCoreGai", "SubCoreGai onAccountRelease!");
    AppMethodBeat.o(21215);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gai.b.a
 * JD-Core Version:    0.7.0.1
 */