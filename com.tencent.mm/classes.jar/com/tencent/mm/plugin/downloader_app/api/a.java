package com.tencent.mm.plugin.downloader_app.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
{
  public static enum a
  {
    static
    {
      AppMethodBeat.i(153082);
      xrM = new a("OK", 0);
      xrN = new a("FAIL", 1);
      xrO = new a("WAIT_FOR_WIFI", 2);
      xrP = new a("CANCEL", 3);
      xrQ = new a[] { xrM, xrN, xrO, xrP };
      AppMethodBeat.o(153082);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(a.a parama, long paramLong);
  }
  
  public static abstract interface c
  {
    public abstract void cqd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.api.a
 * JD-Core Version:    0.7.0.1
 */