package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class a$f
{
  public ArrayList<a.g> cBy;
  public String color;
  public String hhf;
  public String hhg;
  public String hhh;
  public String hhi;
  public boolean hhj;
  
  public a$f()
  {
    AppMethodBeat.i(86878);
    this.cBy = new ArrayList();
    AppMethodBeat.o(86878);
  }
  
  public final boolean zW(String paramString)
  {
    AppMethodBeat.i(86879);
    Iterator localIterator = this.cBy.iterator();
    while (localIterator.hasNext()) {
      if (((a.g)localIterator.next()).url.equals(h.cg(paramString)))
      {
        AppMethodBeat.o(86879);
        return true;
      }
    }
    AppMethodBeat.o(86879);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.f
 * JD-Core Version:    0.7.0.1
 */