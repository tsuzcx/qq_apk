package com.tencent.mm.message;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface z
{
  public abstract void O(Bundle paramBundle);
  
  public abstract void a(a parama);
  
  public abstract void b(a parama);
  
  public abstract boolean bws();
  
  public abstract boolean bwt();
  
  public abstract boolean bwu();
  
  public abstract void c(a parama);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(150135);
      nVu = new a("del", 0);
      nVv = new a("trans", 1);
      nVw = new a("fav", 2);
      nVx = new a[] { nVu, nVv, nVw };
      AppMethodBeat.o(150135);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.message.z
 * JD-Core Version:    0.7.0.1
 */