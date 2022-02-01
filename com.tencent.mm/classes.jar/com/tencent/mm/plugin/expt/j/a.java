package com.tencent.mm.plugin.expt.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.sdk.event.IListener;
import java.util.HashSet;
import java.util.Iterator;

public final class a
{
  private static a sLs;
  public IListener<fp> gmC;
  HashSet<b> sLt;
  
  private a()
  {
    AppMethodBeat.i(220646);
    this.gmC = new IListener() {};
    this.sLt = new HashSet();
    this.sLt.add(new c());
    this.sLt.add(new d());
    AppMethodBeat.o(220646);
  }
  
  public static a cSe()
  {
    AppMethodBeat.i(220645);
    if (sLs == null) {
      sLs = new a();
    }
    a locala = sLs;
    AppMethodBeat.o(220645);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.j.a
 * JD-Core Version:    0.7.0.1
 */