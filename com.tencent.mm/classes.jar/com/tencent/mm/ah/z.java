package com.tencent.mm.ah;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface z
{
  public abstract void a(a parama);
  
  public abstract boolean azv();
  
  public abstract boolean azw();
  
  public abstract boolean azx();
  
  public abstract void b(a parama);
  
  public abstract void c(a parama);
  
  public abstract void v(Bundle paramBundle);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(150135);
      hGK = new a("del", 0);
      hGL = new a("trans", 1);
      hGM = new a("fav", 2);
      hGN = new a[] { hGK, hGL, hGM };
      AppMethodBeat.o(150135);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.z
 * JD-Core Version:    0.7.0.1
 */