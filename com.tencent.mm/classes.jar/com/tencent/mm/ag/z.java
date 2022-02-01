package com.tencent.mm.ag;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface z
{
  public abstract void B(Bundle paramBundle);
  
  public abstract void a(a parama);
  
  public abstract boolean aSC();
  
  public abstract boolean aSD();
  
  public abstract boolean aSE();
  
  public abstract void b(a parama);
  
  public abstract void c(a parama);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(150135);
      iAT = new a("del", 0);
      iAU = new a("trans", 1);
      iAV = new a("fav", 2);
      iAW = new a[] { iAT, iAU, iAV };
      AppMethodBeat.o(150135);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.z
 * JD-Core Version:    0.7.0.1
 */