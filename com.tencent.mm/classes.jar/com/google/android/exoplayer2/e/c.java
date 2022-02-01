package com.google.android.exoplayer2.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface c
{
  public static final c btN = new c()
  {
    public final a d(String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(92359);
      paramAnonymousString = d.d(paramAnonymousString, paramAnonymousBoolean);
      AppMethodBeat.o(92359);
      return paramAnonymousString;
    }
    
    public final a vf()
    {
      AppMethodBeat.i(92360);
      a locala = d.vf();
      AppMethodBeat.o(92360);
      return locala;
    }
  };
  
  public abstract a d(String paramString, boolean paramBoolean);
  
  public abstract a vf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.e.c
 * JD-Core Version:    0.7.0.1
 */