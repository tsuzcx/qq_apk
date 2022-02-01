package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.opengles.GL10;

public final class hq
  extends hl
{
  private ArrayList<hl> g;
  
  private hq(hl... paramVarArgs)
  {
    super(0L);
    AppMethodBeat.i(225940);
    this.g = new ArrayList();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.g.add(paramVarArgs[i]);
      l += paramVarArgs[i].a();
      i += 1;
    }
    this.e = l;
    AppMethodBeat.o(225940);
  }
  
  public final void a(GL10 paramGL10)
  {
    AppMethodBeat.i(225975);
    a(paramGL10, 0L);
    AppMethodBeat.o(225975);
  }
  
  protected final void a(GL10 paramGL10, long paramLong)
  {
    AppMethodBeat.i(225984);
    if ((this.g == null) || (this.g.isEmpty()))
    {
      AppMethodBeat.o(225984);
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
    AppMethodBeat.o(225984);
  }
  
  public final void b()
  {
    AppMethodBeat.i(225957);
    super.b();
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((hl)localIterator.next()).b();
    }
    AppMethodBeat.o(225957);
  }
  
  public final boolean c()
  {
    AppMethodBeat.i(225968);
    Iterator localIterator = this.g.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((hl)localIterator.next()).c());
    for (boolean bool = false;; bool = true)
    {
      AppMethodBeat.o(225968);
      return bool;
    }
  }
  
  protected final void d()
  {
    AppMethodBeat.i(225948);
    super.d();
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((hl)localIterator.next()).b();
    }
    AppMethodBeat.o(225948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.hq
 * JD-Core Version:    0.7.0.1
 */