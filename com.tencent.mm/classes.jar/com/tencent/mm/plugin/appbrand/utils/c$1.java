package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class c$1
  implements Runnable
{
  c$1(String paramString, c.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(135334);
    if (!c.access$000().containsKey(this.val$url)) {
      c.access$000().put(this.val$url, new ArrayList());
    }
    ((List)c.access$000().get(this.val$url)).add(this.ogE);
    AppMethodBeat.o(135334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.c.1
 * JD-Core Version:    0.7.0.1
 */