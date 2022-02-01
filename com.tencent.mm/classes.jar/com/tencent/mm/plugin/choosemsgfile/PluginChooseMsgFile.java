package com.tencent.mm.plugin.choosemsgfile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class PluginChooseMsgFile
  extends f
  implements com.tencent.mm.plugin.choosemsgfile.a.a
{
  public void dependency()
  {
    AppMethodBeat.i(123220);
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }
    AppMethodBeat.o(123220);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(123219);
    Log.d("MicroMsg.PluginChooseMsgFile", "execute");
    h.b(com.tencent.mm.choosemsgfile.compat.a.class, new com.tencent.mm.plugin.choosemsgfile.b.a());
    AppMethodBeat.o(123219);
  }
  
  public void installed()
  {
    AppMethodBeat.i(123218);
    Log.d("MicroMsg.PluginChooseMsgFile", "installed");
    alias(com.tencent.mm.plugin.choosemsgfile.a.a.class);
    AppMethodBeat.o(123218);
  }
  
  public String name()
  {
    return "plugin-choosemsgfile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile
 * JD-Core Version:    0.7.0.1
 */