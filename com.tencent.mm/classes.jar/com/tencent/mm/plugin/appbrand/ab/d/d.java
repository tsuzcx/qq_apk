package com.tencent.mm.plugin.appbrand.ab.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public abstract interface d
{
  public abstract ByteBuffer bqE();
  
  public abstract boolean bqF();
  
  public abstract boolean bqG();
  
  public abstract a bqH();
  
  public abstract void e(d paramd);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156659);
      lOu = new a("CONTINUOUS", 0);
      lOv = new a("TEXT", 1);
      lOw = new a("BINARY", 2);
      lOx = new a("PING", 3);
      lOy = new a("PONG", 4);
      lOz = new a("CLOSING", 5);
      lOA = new a[] { lOu, lOv, lOw, lOx, lOy, lOz };
      AppMethodBeat.o(156659);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.d.d
 * JD-Core Version:    0.7.0.1
 */