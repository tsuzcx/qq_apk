package com.tencent.mm.plugin.appbrand.aa.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public abstract interface d
{
  public abstract ByteBuffer bxE();
  
  public abstract boolean bxF();
  
  public abstract boolean bxG();
  
  public abstract a bxH();
  
  public abstract void e(d paramd);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156659);
      mqu = new a("CONTINUOUS", 0);
      mqv = new a("TEXT", 1);
      mqw = new a("BINARY", 2);
      mqx = new a("PING", 3);
      mqy = new a("PONG", 4);
      mqz = new a("CLOSING", 5);
      mqA = new a[] { mqu, mqv, mqw, mqx, mqy, mqz };
      AppMethodBeat.o(156659);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.d.d
 * JD-Core Version:    0.7.0.1
 */