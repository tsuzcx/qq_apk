package com.google.a;

import com.google.a.b.a.f;
import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.List;

public abstract class r<T>
{
  public abstract T a(a parama);
  
  public abstract void a(c paramc, T paramT);
  
  public final i ae(T paramT)
  {
    f localf;
    try
    {
      localf = new f();
      a(localf, paramT);
      if (!localf.bMD.isEmpty()) {
        throw new IllegalStateException("Expected one JSON element but was " + localf.bMD);
      }
    }
    catch (IOException paramT)
    {
      throw new j(paramT);
    }
    paramT = localf.bMF;
    return paramT;
  }
  
  public final r<T> zf()
  {
    new r()
    {
      public final T a(a paramAnonymousa)
      {
        AppMethodBeat.i(222000);
        if (paramAnonymousa.zw() == b.bOQ)
        {
          paramAnonymousa.zA();
          AppMethodBeat.o(222000);
          return null;
        }
        paramAnonymousa = r.this.a(paramAnonymousa);
        AppMethodBeat.o(222000);
        return paramAnonymousa;
      }
      
      public final void a(c paramAnonymousc, T paramAnonymousT)
      {
        AppMethodBeat.i(107843);
        if (paramAnonymousT == null)
        {
          paramAnonymousc.zK();
          AppMethodBeat.o(107843);
          return;
        }
        r.this.a(paramAnonymousc, paramAnonymousT);
        AppMethodBeat.o(107843);
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.r
 * JD-Core Version:    0.7.0.1
 */