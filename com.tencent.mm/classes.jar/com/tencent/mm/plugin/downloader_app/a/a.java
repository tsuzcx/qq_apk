package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
{
  public static enum a
  {
    static
    {
      AppMethodBeat.i(35545);
      kZY = new a("OK", 0);
      kZZ = new a("FAIL", 1);
      laa = new a("WAIT_FOR_WIFI", 2);
      lab = new a("CANCEL", 3);
      lac = new a[] { kZY, kZZ, laa, lab };
      AppMethodBeat.o(35545);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(a.a parama, long paramLong);
  }
  
  public static abstract interface c
  {
    public abstract void aBK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.a
 * JD-Core Version:    0.7.0.1
 */