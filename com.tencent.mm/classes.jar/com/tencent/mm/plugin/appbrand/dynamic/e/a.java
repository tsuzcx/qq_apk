package com.tencent.mm.plugin.appbrand.dynamic.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.c;
import com.tencent.mm.plugin.appbrand.i.r;
import com.tencent.mm.z.b.d;

public final class a
  extends c
  implements d
{
  public a(Object paramObject)
  {
    AppMethodBeat.i(10902);
    addJavascriptInterface(paramObject, "WeixinJSCore");
    AppMethodBeat.o(10902);
  }
  
  public final boolean Qw()
  {
    AppMethodBeat.i(141925);
    if (v(r.class) != null)
    {
      AppMethodBeat.o(141925);
      return true;
    }
    AppMethodBeat.o(141925);
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(10905);
    if (Qw()) {
      ((r)v(r.class)).pause();
    }
    AppMethodBeat.o(10905);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(10906);
    if (Qw()) {
      ((r)v(r.class)).resume();
    }
    AppMethodBeat.o(10906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.e.a
 * JD-Core Version:    0.7.0.1
 */