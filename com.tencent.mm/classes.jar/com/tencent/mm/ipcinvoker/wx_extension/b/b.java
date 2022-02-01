package com.tencent.mm.ipcinvoker.wx_extension.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private final List<b<a>> gab;
  private final List<Object> gac;
  
  private b()
  {
    AppMethodBeat.i(146427);
    this.gab = new LinkedList();
    this.gac = new LinkedList();
    AppMethodBeat.o(146427);
  }
  
  private void adJ()
  {
    try
    {
      AppMethodBeat.i(146432);
      Iterator localIterator = this.gac.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(146432);
    }
    finally {}
  }
  
  private void adK()
  {
    try
    {
      AppMethodBeat.i(146433);
      Iterator localIterator = this.gac.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(146433);
    }
    finally {}
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(146428);
    if (c(parama))
    {
      AppMethodBeat.o(146428);
      return false;
    }
    synchronized (this.gab)
    {
      this.gab.add(new b(parama));
      adJ();
      AppMethodBeat.o(146428);
      return true;
    }
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(146429);
    if (parama == null)
    {
      AppMethodBeat.o(146429);
      return false;
    }
    synchronized (this.gab)
    {
      boolean bool = this.gab.remove(new b(parama));
      adK();
      AppMethodBeat.o(146429);
      return bool;
    }
  }
  
  public final boolean c(a parama)
  {
    AppMethodBeat.i(146430);
    if (parama == null)
    {
      AppMethodBeat.o(146430);
      return false;
    }
    synchronized (this.gab)
    {
      Iterator localIterator = this.gab.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (b)localIterator.next();
        if (localObject != null)
        {
          localObject = (a)((b)localObject).get();
          if ((localObject != null) && (parama.equals(localObject)))
          {
            AppMethodBeat.o(146430);
            return true;
          }
        }
      }
      AppMethodBeat.o(146430);
      return false;
    }
  }
  
  public final int size()
  {
    AppMethodBeat.i(146431);
    synchronized (this.gab)
    {
      int i = this.gab.size();
      AppMethodBeat.o(146431);
      return i;
    }
  }
  
  public static final class a
  {
    private static b gad;
    
    static
    {
      AppMethodBeat.i(146425);
      gad = new b((byte)0);
      AppMethodBeat.o(146425);
    }
  }
  
  static final class b<T>
    extends WeakReference<T>
  {
    public b(T paramT)
    {
      super();
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(146426);
      if (paramObject == this)
      {
        AppMethodBeat.o(146426);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(146426);
        return false;
      }
      paramObject = ((b)paramObject).get();
      Object localObject = get();
      if ((paramObject == localObject) || ((localObject != null) && (localObject.equals(paramObject))))
      {
        AppMethodBeat.o(146426);
        return true;
      }
      AppMethodBeat.o(146426);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.b.b
 * JD-Core Version:    0.7.0.1
 */