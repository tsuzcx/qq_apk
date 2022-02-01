package com.tencent.mm.plugin.choosemsgfile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public class PluginChooseMsgFile
  extends f
  implements com.tencent.mm.plugin.choosemsgfile.a.a
{
  public void dependency()
  {
    AppMethodBeat.i(123220);
    if (ai.cin()) {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }
    AppMethodBeat.o(123220);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(123219);
    ac.d("MicroMsg.PluginChooseMsgFile", "execute");
    com.tencent.mm.kernel.g.b(com.tencent.mm.choosemsgfile.compat.a.class, new com.tencent.mm.plugin.choosemsgfile.b.a());
    AppMethodBeat.o(123219);
  }
  
  public void installed()
  {
    AppMethodBeat.i(123218);
    ac.d("MicroMsg.PluginChooseMsgFile", "installed");
    alias(com.tencent.mm.plugin.choosemsgfile.a.a.class);
    AppMethodBeat.o(123218);
  }
  
  public String name()
  {
    return "plugin-choosemsgfile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile
 * JD-Core Version:    0.7.0.1
 */