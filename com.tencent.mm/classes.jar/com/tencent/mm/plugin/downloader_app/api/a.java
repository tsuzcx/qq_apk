package com.tencent.mm.plugin.downloader_app.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
{
  public static enum a
  {
    static
    {
      AppMethodBeat.i(153082);
      oKo = new a("OK", 0);
      oKp = new a("FAIL", 1);
      oKq = new a("WAIT_FOR_WIFI", 2);
      oKr = new a("CANCEL", 3);
      oKs = new a[] { oKo, oKp, oKq, oKr };
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
    public abstract void beX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.api.a
 * JD-Core Version:    0.7.0.1
 */