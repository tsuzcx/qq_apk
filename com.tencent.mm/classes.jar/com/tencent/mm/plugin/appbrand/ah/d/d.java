package com.tencent.mm.plugin.appbrand.ah.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public abstract interface d
{
  public abstract ByteBuffer cOn();
  
  public abstract boolean cOo();
  
  public abstract boolean cOp();
  
  public abstract a cOq();
  
  public abstract void e(d paramd);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156659);
      uvf = new a("CONTINUOUS", 0);
      uvg = new a("TEXT", 1);
      uvh = new a("BINARY", 2);
      uvi = new a("PING", 3);
      uvj = new a("PONG", 4);
      uvk = new a("CLOSING", 5);
      uvl = new a[] { uvf, uvg, uvh, uvi, uvj, uvk };
      AppMethodBeat.o(156659);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah.d.d
 * JD-Core Version:    0.7.0.1
 */