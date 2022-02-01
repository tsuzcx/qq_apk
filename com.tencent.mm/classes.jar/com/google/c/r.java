package com.google.c;

import com.google.c.b.a.f;
import com.google.c.d.a;
import com.google.c.d.b;
import com.google.c.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.List;

public abstract class r<T>
{
  public final r<T> YQ()
  {
    new r()
    {
      public final T a(a paramAnonymousa)
      {
        AppMethodBeat.i(208793);
        if (paramAnonymousa.Zh() == b.dIv)
        {
          paramAnonymousa.Zl();
          AppMethodBeat.o(208793);
          return null;
        }
        paramAnonymousa = r.this.a(paramAnonymousa);
        AppMethodBeat.o(208793);
        return paramAnonymousa;
      }
      
      public final void a(c paramAnonymousc, T paramAnonymousT)
      {
        AppMethodBeat.i(107843);
        if (paramAnonymousT == null)
        {
          paramAnonymousc.Zv();
          AppMethodBeat.o(107843);
          return;
        }
        r.this.a(paramAnonymousc, paramAnonymousT);
        AppMethodBeat.o(107843);
      }
    };
  }
  
  public abstract T a(a parama);
  
  public abstract void a(c paramc, T paramT);
  
  public final i bm(T paramT)
  {
    f localf;
    try
    {
      localf = new f();
      a(localf, paramT);
      if (!localf.aln.isEmpty()) {
        throw new IllegalStateException("Expected one JSON element but was " + localf.aln);
      }
    }
    catch (IOException paramT)
    {
      throw new j(paramT);
    }
    paramT = localf.dGk;
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.r
 * JD-Core Version:    0.7.0.1
 */