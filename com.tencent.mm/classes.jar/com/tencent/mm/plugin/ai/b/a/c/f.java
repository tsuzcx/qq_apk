package com.tencent.mm.plugin.ai.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public final class f
{
  private static f npx;
  public HashSet<c> npy;
  
  private f()
  {
    AppMethodBeat.i(239456);
    this.npy = new HashSet();
    this.npy.add(new b());
    this.npy.add(new a());
    this.npy.add(new e());
    this.npy.add(new d());
    AppMethodBeat.o(239456);
  }
  
  public static f bBf()
  {
    AppMethodBeat.i(239455);
    if (npx == null) {
      npx = new f();
    }
    f localf = npx;
    AppMethodBeat.o(239455);
    return localf;
  }
  
  public final void OO()
  {
    AppMethodBeat.i(239457);
    Iterator localIterator = this.npy.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).OO();
    }
    AppMethodBeat.o(239457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.c.f
 * JD-Core Version:    0.7.0.1
 */