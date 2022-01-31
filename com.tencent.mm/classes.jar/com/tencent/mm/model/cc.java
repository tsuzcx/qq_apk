package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Set;

public final class cc
{
  public Set<a> foa;
  public boolean isRunning;
  
  public cc()
  {
    AppMethodBeat.i(58142);
    this.isRunning = false;
    this.foa = new HashSet();
    AppMethodBeat.o(58142);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(58143);
    if (this.isRunning)
    {
      ab.e("MicroMsg.UninitForUEH", "add , is running , forbid add");
      AppMethodBeat.o(58143);
      return false;
    }
    boolean bool = this.foa.add(parama);
    AppMethodBeat.o(58143);
    return bool;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(58144);
    if (this.isRunning)
    {
      ab.e("MicroMsg.UninitForUEH", "remove , is running , forbid remove");
      AppMethodBeat.o(58144);
      return false;
    }
    boolean bool = this.foa.remove(parama);
    AppMethodBeat.o(58144);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract boolean abs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cc
 * JD-Core Version:    0.7.0.1
 */