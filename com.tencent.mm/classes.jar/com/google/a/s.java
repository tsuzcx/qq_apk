package com.google.a;

import com.google.a.b.a.e;
import com.google.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.List;

public abstract class s<T>
{
  public abstract void a(a parama, T paramT);
  
  public final k ag(T paramT)
  {
    e locale;
    try
    {
      locale = new e();
      a(locale, paramT);
      if (!locale.bEu.isEmpty()) {
        throw new IllegalStateException("Expected one JSON element but was " + locale.bEu);
      }
    }
    catch (IOException paramT)
    {
      throw new l(paramT);
    }
    paramT = locale.bEw;
    return paramT;
  }
  
  public final s<T> xe()
  {
    new s()
    {
      public final void a(a paramAnonymousa, T paramAnonymousT)
      {
        AppMethodBeat.i(107843);
        if (paramAnonymousT == null)
        {
          paramAnonymousa.xv();
          AppMethodBeat.o(107843);
          return;
        }
        s.this.a(paramAnonymousa, paramAnonymousT);
        AppMethodBeat.o(107843);
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.s
 * JD-Core Version:    0.7.0.1
 */