package com.tencent.mm.plugin.expt.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.sdk.event.IListener;
import java.util.HashSet;
import java.util.Iterator;

public final class a
{
  private static a wro;
  public IListener<fw> iQL;
  HashSet<b> npy;
  
  private a()
  {
    AppMethodBeat.i(256665);
    this.iQL = new IListener() {};
    this.npy = new HashSet();
    this.npy.add(new d());
    this.npy.add(new e());
    this.npy.add(new c());
    AppMethodBeat.o(256665);
  }
  
  public static a dhd()
  {
    AppMethodBeat.i(256662);
    if (wro == null) {
      wro = new a();
    }
    a locala = wro;
    AppMethodBeat.o(256662);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.j.a
 * JD-Core Version:    0.7.0.1
 */