package com.tencent.mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ao;
import com.tencent.mm.vfs.af;

public class PluginAvatar
  extends f
  implements b
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(151429);
    af.b("avatar", "avatar", 536870912L, 7776000000L, 67);
    AppMethodBeat.o(151429);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(151430);
    if (paramg.bbA())
    {
      pin(c.cUB());
      h.b(ao.class, new com.tencent.mm.modelavatar.b());
    }
    AppMethodBeat.o(151430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.PluginAvatar
 * JD-Core Version:    0.7.0.1
 */