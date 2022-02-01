package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vfs.u;

public class PluginImageBase
  extends f
  implements a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(177298);
    if (paramg.akL())
    {
      u.ap("image", "image", 19);
      u.ap("image2", "image2", 1424);
      u.ap("oldimage2", "image2", 531);
    }
    AppMethodBeat.o(177298);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(177299);
    if (paramg.akL()) {
      pin(d.dfK());
    }
    AppMethodBeat.o(177299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.image.PluginImageBase
 * JD-Core Version:    0.7.0.1
 */