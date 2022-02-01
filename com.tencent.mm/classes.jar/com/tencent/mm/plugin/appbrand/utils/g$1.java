package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class g$1
  implements Runnable
{
  g$1(String paramString, g.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(135334);
    if (!g.aYC().containsKey(this.val$url)) {
      g.aYC().put(this.val$url, new ArrayList());
    }
    ((List)g.aYC().get(this.val$url)).add(this.uqv);
    AppMethodBeat.o(135334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.g.1
 * JD-Core Version:    0.7.0.1
 */