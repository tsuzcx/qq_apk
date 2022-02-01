package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.Set;

public final class ci
{
  public Set<a> hLo;
  public boolean isRunning;
  
  public ci()
  {
    AppMethodBeat.i(132286);
    this.isRunning = false;
    this.hLo = new HashSet();
    AppMethodBeat.o(132286);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(132287);
    if (this.isRunning)
    {
      ae.e("MicroMsg.UninitForUEH", "add , is running , forbid add");
      AppMethodBeat.o(132287);
      return false;
    }
    boolean bool = this.hLo.add(parama);
    AppMethodBeat.o(132287);
    return bool;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(132288);
    if (this.isRunning)
    {
      ae.e("MicroMsg.UninitForUEH", "remove , is running , forbid remove");
      AppMethodBeat.o(132288);
      return false;
    }
    boolean bool = this.hLo.remove(parama);
    AppMethodBeat.o(132288);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean aDe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ci
 * JD-Core Version:    0.7.0.1
 */