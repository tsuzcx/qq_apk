package com.tencent.mm.plugin.appbrand.dynamic.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.d;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.appbrand.n.u;

public final class a
  extends c
  implements d
{
  public a(Object paramObject)
  {
    AppMethodBeat.i(121382);
    addJavascriptInterface(paramObject, "WeixinJSCore");
    AppMethodBeat.o(121382);
  }
  
  public final boolean aZi()
  {
    AppMethodBeat.i(121385);
    if (Z(u.class) != null)
    {
      AppMethodBeat.o(121385);
      return true;
    }
    AppMethodBeat.o(121385);
    return false;
  }
  
  public final boolean aZj()
  {
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(121383);
    if (aZi()) {
      ((u)Z(u.class)).pause();
    }
    AppMethodBeat.o(121383);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(121384);
    if (aZi()) {
      ((u)Z(u.class)).resume();
    }
    AppMethodBeat.o(121384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.e.a
 * JD-Core Version:    0.7.0.1
 */