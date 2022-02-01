package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;
import java.util.Set;

public final class cg
{
  public Set<a> hIv;
  public boolean isRunning;
  
  public cg()
  {
    AppMethodBeat.i(132286);
    this.isRunning = false;
    this.hIv = new HashSet();
    AppMethodBeat.o(132286);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(132287);
    if (this.isRunning)
    {
      ad.e("MicroMsg.UninitForUEH", "add , is running , forbid add");
      AppMethodBeat.o(132287);
      return false;
    }
    boolean bool = this.hIv.add(parama);
    AppMethodBeat.o(132287);
    return bool;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(132288);
    if (this.isRunning)
    {
      ad.e("MicroMsg.UninitForUEH", "remove , is running , forbid remove");
      AppMethodBeat.o(132288);
      return false;
    }
    boolean bool = this.hIv.remove(parama);
    AppMethodBeat.o(132288);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean aCO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cg
 * JD-Core Version:    0.7.0.1
 */