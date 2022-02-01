package com.tencent.mm.plugin.appbrand.aa.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public abstract interface d
{
  public abstract ByteBuffer bBJ();
  
  public abstract boolean bBK();
  
  public abstract boolean bBL();
  
  public abstract a bBM();
  
  public abstract void e(d paramd);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156659);
      mRa = new a("CONTINUOUS", 0);
      mRb = new a("TEXT", 1);
      mRc = new a("BINARY", 2);
      mRd = new a("PING", 3);
      mRe = new a("PONG", 4);
      mRf = new a("CLOSING", 5);
      mRg = new a[] { mRa, mRb, mRc, mRd, mRe, mRf };
      AppMethodBeat.o(156659);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.d.d
 * JD-Core Version:    0.7.0.1
 */