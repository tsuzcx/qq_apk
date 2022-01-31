package com.tencent.mm.plugin.appbrand.jsapi.v.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class a$1
  implements Runnable
{
  a$1(String paramString, a.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(140024);
    if (!a.access$000().containsKey(this.val$url)) {
      a.access$000().put(this.val$url, new ArrayList());
    }
    ((List)a.access$000().get(this.val$url)).add(this.iix);
    AppMethodBeat.o(140024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.b.a.1
 * JD-Core Version:    0.7.0.1
 */