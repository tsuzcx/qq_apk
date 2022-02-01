package com.google.android.exoplayer2.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface c
{
  public static final c bdq = new c()
  {
    public final a e(String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(92359);
      paramAnonymousString = d.e(paramAnonymousString, paramAnonymousBoolean);
      AppMethodBeat.o(92359);
      return paramAnonymousString;
    }
    
    public final a tc()
    {
      AppMethodBeat.i(92360);
      a locala = d.tc();
      AppMethodBeat.o(92360);
      return locala;
    }
  };
  
  public abstract a e(String paramString, boolean paramBoolean);
  
  public abstract a tc();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.e.c
 * JD-Core Version:    0.7.0.1
 */