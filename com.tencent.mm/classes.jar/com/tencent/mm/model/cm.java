package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Set;

public final class cm
{
  public Set<a> iGc;
  public boolean isRunning;
  
  public cm()
  {
    AppMethodBeat.i(132286);
    this.isRunning = false;
    this.iGc = new HashSet();
    AppMethodBeat.o(132286);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(132287);
    if (this.isRunning)
    {
      Log.e("MicroMsg.UninitForUEH", "add , is running , forbid add");
      AppMethodBeat.o(132287);
      return false;
    }
    boolean bool = this.iGc.add(parama);
    AppMethodBeat.o(132287);
    return bool;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(132288);
    if (this.isRunning)
    {
      Log.e("MicroMsg.UninitForUEH", "remove , is running , forbid remove");
      AppMethodBeat.o(132288);
      return false;
    }
    boolean bool = this.iGc.remove(parama);
    AppMethodBeat.o(132288);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean aWC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cm
 * JD-Core Version:    0.7.0.1
 */