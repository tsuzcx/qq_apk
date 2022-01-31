package com.tencent.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
{
  public static final a bzy = new a()
  {
    public final void a(c paramAnonymousc)
    {
      AppMethodBeat.i(90857);
      paramAnonymousc.a(b.bzB);
      AppMethodBeat.o(90857);
    }
    
    public final void a(String paramAnonymousString, c paramAnonymousc)
    {
      AppMethodBeat.i(90858);
      paramAnonymousc.a(b.bzB);
      AppMethodBeat.o(90858);
    }
  };
  public static final a bzz = new a.2();
  
  public abstract void a(c paramc);
  
  public abstract void a(String paramString, c paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.d.a.a
 * JD-Core Version:    0.7.0.1
 */