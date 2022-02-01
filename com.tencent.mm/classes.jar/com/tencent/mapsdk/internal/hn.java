package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.opengles.GL10;

public final class hn
  extends hl
{
  private ArrayList<hl> g;
  
  private hn(hl... paramVarArgs)
  {
    super(0L);
    AppMethodBeat.i(226008);
    this.g = new ArrayList();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.g.add(paramVarArgs[i]);
      l = Math.max(l, paramVarArgs[i].a());
      i += 1;
    }
    this.e = l;
    AppMethodBeat.o(226008);
  }
  
  protected final void a(GL10 paramGL10, long paramLong)
  {
    AppMethodBeat.i(226025);
    if ((this.g == null) || (this.g.isEmpty()))
    {
      AppMethodBeat.o(226025);
      return;
    }
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      hl localhl = (hl)localIterator.next();
      if (!localhl.c()) {
        localhl.a(paramGL10);
      }
    }
    AppMethodBeat.o(226025);
  }
  
  public final void b()
  {
    AppMethodBeat.i(226014);
    super.b();
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((hl)localIterator.next()).b();
    }
    AppMethodBeat.o(226014);
  }
  
  protected final void d()
  {
    AppMethodBeat.i(226020);
    super.d();
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((hl)localIterator.next()).b();
    }
    AppMethodBeat.o(226020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hn
 * JD-Core Version:    0.7.0.1
 */