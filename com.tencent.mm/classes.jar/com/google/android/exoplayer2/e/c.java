package com.google.android.exoplayer2.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface c
{
  public static final c bjy = new c()
  {
    public final a f(String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(92359);
      paramAnonymousString = d.f(paramAnonymousString, paramAnonymousBoolean);
      AppMethodBeat.o(92359);
      return paramAnonymousString;
    }
    
    public final a tB()
    {
      AppMethodBeat.i(92360);
      a locala = d.tB();
      AppMethodBeat.o(92360);
      return locala;
    }
  };
  
  public abstract a f(String paramString, boolean paramBoolean);
  
  public abstract a tB();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.e.c
 * JD-Core Version:    0.7.0.1
 */