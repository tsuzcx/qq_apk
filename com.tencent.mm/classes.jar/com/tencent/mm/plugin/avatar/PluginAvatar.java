package com.tencent.mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.an;
import com.tencent.mm.vfs.ab;

public class PluginAvatar
  extends f
  implements b
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(151429);
    ab.a("avatar", "avatar", 536870912L, 7776000000L, 67);
    AppMethodBeat.o(151429);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(151430);
    if (paramg.aIE())
    {
      pin(c.crR());
      h.b(an.class, new com.tencent.mm.am.b());
    }
    AppMethodBeat.o(151430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.PluginAvatar
 * JD-Core Version:    0.7.0.1
 */