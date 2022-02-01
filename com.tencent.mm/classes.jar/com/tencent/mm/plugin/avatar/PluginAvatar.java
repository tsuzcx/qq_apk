package com.tencent.mm.plugin.avatar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vfs.o;

public class PluginAvatar
  extends f
  implements b
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(151429);
    o.a("avatar", "avatar", 536870912L, 0);
    AppMethodBeat.o(151429);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(151430);
    if (paramg.akw()) {
      pin(c.bGP());
    }
    AppMethodBeat.o(151430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.avatar.PluginAvatar
 * JD-Core Version:    0.7.0.1
 */