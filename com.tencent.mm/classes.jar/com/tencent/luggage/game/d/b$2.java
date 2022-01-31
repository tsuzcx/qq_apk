package com.tencent.luggage.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

final class b$2
  extends f.b
{
  b$2(b paramb) {}
  
  public final boolean bO(String paramString)
  {
    AppMethodBeat.i(140368);
    boolean bool = "wagame://WAGameVConsole.html".equals(paramString);
    AppMethodBeat.o(140368);
    return bool;
  }
  
  public final InputStream bP(String paramString)
  {
    AppMethodBeat.i(140370);
    paramString = this.bAs.bAn.asY().openRead(paramString);
    AppMethodBeat.o(140370);
    return paramString;
  }
  
  public final void uG()
  {
    AppMethodBeat.i(140369);
    this.bAs.bAr = true;
    if ((this.bAs.bAq != null) && (!this.bAs.bAq.isEmpty()))
    {
      Iterator localIterator = this.bAs.bAq.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.bAs.bN(str);
      }
    }
    AppMethodBeat.o(140369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.d.b.2
 * JD-Core Version:    0.7.0.1
 */