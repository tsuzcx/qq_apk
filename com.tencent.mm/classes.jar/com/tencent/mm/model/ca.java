package com.tencent.mm.model;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Set;

public final class ca
{
  public Set<a> dXV = new HashSet();
  public boolean isRunning = false;
  
  public final boolean a(a parama)
  {
    if (this.isRunning)
    {
      y.e("MicroMsg.UninitForUEH", "add , is running , forbid add");
      return false;
    }
    return this.dXV.add(parama);
  }
  
  public final boolean b(a parama)
  {
    if (this.isRunning)
    {
      y.e("MicroMsg.UninitForUEH", "remove , is running , forbid remove");
      return false;
    }
    return this.dXV.remove(parama);
  }
  
  public static abstract interface a
  {
    public abstract boolean Iu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ca
 * JD-Core Version:    0.7.0.1
 */