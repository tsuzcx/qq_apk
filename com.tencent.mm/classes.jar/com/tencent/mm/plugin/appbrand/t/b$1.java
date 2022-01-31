package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class b$1
  implements Runnable
{
  b$1(String paramString, b.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(87394);
    if (!b.access$000().containsKey(this.val$url)) {
      b.access$000().put(this.val$url, new ArrayList());
    }
    ((List)b.access$000().get(this.val$url)).add(this.iXv);
    AppMethodBeat.o(87394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.b.1
 * JD-Core Version:    0.7.0.1
 */