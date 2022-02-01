package com.bumptech.glide.load.d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
{
  private final List<a<?, ?>> aMi;
  
  public f()
  {
    AppMethodBeat.i(77535);
    this.aMi = new ArrayList();
    AppMethodBeat.o(77535);
  }
  
  public final <Z, R> void b(Class<Z> paramClass, Class<R> paramClass1, e<Z, R> parame)
  {
    try
    {
      AppMethodBeat.i(77536);
      this.aMi.add(new a(paramClass, paramClass1, parame));
      AppMethodBeat.o(77536);
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public final <Z, R> e<Z, R> c(Class<Z> paramClass, Class<R> paramClass1)
  {
    try
    {
      AppMethodBeat.i(77537);
      if (paramClass1.isAssignableFrom(paramClass))
      {
        paramClass = g.pS();
        AppMethodBeat.o(77537);
      }
      for (;;)
      {
        return paramClass;
        Iterator localIterator = this.aMi.iterator();
        a locala;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          locala = (a)localIterator.next();
        } while (!locala.e(paramClass, paramClass1));
        paramClass = locala.aGW;
        AppMethodBeat.o(77537);
      }
      paramClass = new IllegalArgumentException("No transcoder registered to transcode from " + paramClass + " to " + paramClass1);
    }
    finally {}
    AppMethodBeat.o(77537);
    throw paramClass;
  }
  
  public final <Z, R> List<Class<R>> d(Class<Z> paramClass, Class<R> paramClass1)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(77538);
        ArrayList localArrayList = new ArrayList();
        if (paramClass1.isAssignableFrom(paramClass))
        {
          localArrayList.add(paramClass1);
          AppMethodBeat.o(77538);
          return localArrayList;
        }
        Iterator localIterator = this.aMi.iterator();
        if (localIterator.hasNext())
        {
          if (((a)localIterator.next()).e(paramClass, paramClass1)) {
            localArrayList.add(paramClass1);
          }
        }
        else {
          AppMethodBeat.o(77538);
        }
      }
      finally {}
    }
  }
  
  static final class a<Z, R>
  {
    final e<Z, R> aGW;
    private final Class<Z> aMj;
    private final Class<R> aMk;
    
    a(Class<Z> paramClass, Class<R> paramClass1, e<Z, R> parame)
    {
      this.aMj = paramClass;
      this.aMk = paramClass1;
      this.aGW = parame;
    }
    
    public final boolean e(Class<?> paramClass1, Class<?> paramClass2)
    {
      AppMethodBeat.i(77534);
      if ((this.aMj.isAssignableFrom(paramClass1)) && (paramClass2.isAssignableFrom(this.aMk)))
      {
        AppMethodBeat.o(77534);
        return true;
      }
      AppMethodBeat.o(77534);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.f.f
 * JD-Core Version:    0.7.0.1
 */