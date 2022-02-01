package com.tencent.mm.aj;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface z
{
  public abstract void H(Bundle paramBundle);
  
  public abstract void a(a parama);
  
  public abstract void b(a parama);
  
  public abstract boolean bbA();
  
  public abstract boolean bbB();
  
  public abstract boolean bbC();
  
  public abstract void c(a parama);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(150135);
      lqr = new a("del", 0);
      lqs = new a("trans", 1);
      lqt = new a("fav", 2);
      lqu = new a[] { lqr, lqs, lqt };
      AppMethodBeat.o(150135);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.z
 * JD-Core Version:    0.7.0.1
 */