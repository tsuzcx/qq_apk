package com.tencent.mm.plugin.appbrand.ae.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public abstract interface d
{
  public abstract ByteBuffer bZH();
  
  public abstract boolean bZI();
  
  public abstract boolean bZJ();
  
  public abstract a bZK();
  
  public abstract void e(d paramd);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156659);
      oji = new a("CONTINUOUS", 0);
      ojj = new a("TEXT", 1);
      ojk = new a("BINARY", 2);
      ojl = new a("PING", 3);
      ojm = new a("PONG", 4);
      ojn = new a("CLOSING", 5);
      ojo = new a[] { oji, ojj, ojk, ojl, ojm, ojn };
      AppMethodBeat.o(156659);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.d.d
 * JD-Core Version:    0.7.0.1
 */