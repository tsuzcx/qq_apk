package com.tencent.mm.plugin.appbrand.h.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.a.e.a;
import org.apache.http.client.methods.HttpPost;

public final class i$a
  extends HttpPost
{
  private e.a jhU;
  
  public i$a(String paramString, e.a parama)
  {
    super(paramString);
    this.jhU = parama;
  }
  
  public final String getMethod()
  {
    AppMethodBeat.i(159010);
    String str = this.jhU.name();
    AppMethodBeat.o(159010);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.c.i.a
 * JD-Core Version:    0.7.0.1
 */