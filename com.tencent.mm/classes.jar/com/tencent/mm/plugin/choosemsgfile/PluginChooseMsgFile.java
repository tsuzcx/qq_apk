package com.tencent.mm.plugin.choosemsgfile;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;

public class PluginChooseMsgFile
  extends f
  implements com.tencent.mm.plugin.choosemsgfile.a.a
{
  public void dependency()
  {
    AppMethodBeat.i(54248);
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    AppMethodBeat.o(54248);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(54247);
    d.d("MicroMsg.PluginChooseMsgFile", "execute");
    com.tencent.mm.kernel.g.b(com.tencent.mm.choosemsgfile.compat.a.class, new com.tencent.mm.plugin.choosemsgfile.b.a());
    AppMethodBeat.o(54247);
  }
  
  public void installed()
  {
    AppMethodBeat.i(54246);
    d.d("MicroMsg.PluginChooseMsgFile", "installed");
    alias(com.tencent.mm.plugin.choosemsgfile.a.a.class);
    AppMethodBeat.o(54246);
  }
  
  public String name()
  {
    return "plugin-choosemsgfile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.PluginChooseMsgFile
 * JD-Core Version:    0.7.0.1
 */