package com.tencent.mm.plugin.appbrand.af.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public abstract interface d
{
  public abstract ByteBuffer cmC();
  
  public abstract boolean cmD();
  
  public abstract boolean cmE();
  
  public abstract a cmF();
  
  public abstract void e(d paramd);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156659);
      rlw = new a("CONTINUOUS", 0);
      rlx = new a("TEXT", 1);
      rly = new a("BINARY", 2);
      rlz = new a("PING", 3);
      rlA = new a("PONG", 4);
      rlB = new a("CLOSING", 5);
      rlC = new a[] { rlw, rlx, rly, rlz, rlA, rlB };
      AppMethodBeat.o(156659);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.d.d
 * JD-Core Version:    0.7.0.1
 */