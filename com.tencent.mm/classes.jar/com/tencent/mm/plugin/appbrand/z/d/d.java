package com.tencent.mm.plugin.appbrand.z.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public abstract interface d
{
  public abstract ByteBuffer bCD();
  
  public abstract boolean bCE();
  
  public abstract boolean bCF();
  
  public abstract a bCG();
  
  public abstract void e(d paramd);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156659);
      mWj = new a("CONTINUOUS", 0);
      mWk = new a("TEXT", 1);
      mWl = new a("BINARY", 2);
      mWm = new a("PING", 3);
      mWn = new a("PONG", 4);
      mWo = new a("CLOSING", 5);
      mWp = new a[] { mWj, mWk, mWl, mWm, mWn, mWo };
      AppMethodBeat.o(156659);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.d.d
 * JD-Core Version:    0.7.0.1
 */