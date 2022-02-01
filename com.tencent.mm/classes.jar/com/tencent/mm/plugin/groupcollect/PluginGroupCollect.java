package com.tencent.mm.plugin.groupcollect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginGroupCollect
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, c, a
{
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return null;
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(175282);
    ac.i("MicroMsg.groupcollect.PluginGroupCollect", "execute");
    AppMethodBeat.o(175282);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(175280);
    ac.i("MicroMsg.groupcollect.PluginGroupCollect", "onAccountInitialized");
    AppMethodBeat.o(175280);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(175281);
    ac.i("MicroMsg.groupcollect.PluginGroupCollect", "onAccountRelease");
    AppMethodBeat.o(175281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.groupcollect.PluginGroupCollect
 * JD-Core Version:    0.7.0.1
 */