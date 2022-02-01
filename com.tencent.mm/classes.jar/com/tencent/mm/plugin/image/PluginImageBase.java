package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vfs.o;

public class PluginImageBase
  extends f
  implements a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(177298);
    if (paramg.akw())
    {
      o.an("image", "image", 19);
      o.an("image2", "image2", 1424);
      o.an("oldimage2", "image2", 531);
    }
    AppMethodBeat.o(177298);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(177299);
    if (paramg.akw()) {
      pin(d.dcS());
    }
    AppMethodBeat.o(177299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.image.PluginImageBase
 * JD-Core Version:    0.7.0.1
 */