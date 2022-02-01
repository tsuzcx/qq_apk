package com.google.a.b;

import com.google.a.d.c;
import com.google.a.r;
import com.google.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
  implements s, Cloneable
{
  public static final d bLI;
  public double bLJ;
  public int bLK;
  public boolean bLL;
  public boolean bLM;
  public List<com.google.a.a> bLN;
  public List<com.google.a.a> bLO;
  
  static
  {
    AppMethodBeat.i(108104);
    bLI = new d();
    AppMethodBeat.o(108104);
  }
  
  public d()
  {
    AppMethodBeat.i(108092);
    this.bLJ = -1.0D;
    this.bLK = 136;
    this.bLL = true;
    this.bLN = Collections.emptyList();
    this.bLO = Collections.emptyList();
    AppMethodBeat.o(108092);
  }
  
  private boolean a(com.google.a.a.d paramd)
  {
    AppMethodBeat.i(108101);
    if ((paramd != null) && (paramd.zk() > this.bLJ))
    {
      AppMethodBeat.o(108101);
      return false;
    }
    AppMethodBeat.o(108101);
    return true;
  }
  
  private boolean a(com.google.a.a.e parame)
  {
    AppMethodBeat.i(108102);
    if ((parame != null) && (parame.zk() <= this.bLJ))
    {
      AppMethodBeat.o(108102);
      return false;
    }
    AppMethodBeat.o(108102);
    return true;
  }
  
  public static boolean t(Class<?> paramClass)
  {
    AppMethodBeat.i(108097);
    if ((!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass())))
    {
      AppMethodBeat.o(108097);
      return true;
    }
    AppMethodBeat.o(108097);
    return false;
  }
  
  public static boolean u(Class<?> paramClass)
  {
    AppMethodBeat.i(108098);
    if ((paramClass.isMemberClass()) && (!v(paramClass)))
    {
      AppMethodBeat.o(108098);
      return true;
    }
    AppMethodBeat.o(108098);
    return false;
  }
  
  private static boolean v(Class<?> paramClass)
  {
    AppMethodBeat.i(108099);
    if ((paramClass.getModifiers() & 0x8) != 0)
    {
      AppMethodBeat.o(108099);
      return true;
    }
    AppMethodBeat.o(108099);
    return false;
  }
  
  private d zm()
  {
    AppMethodBeat.i(108093);
    try
    {
      d locald = (d)super.clone();
      AppMethodBeat.o(108093);
      return locald;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      AssertionError localAssertionError = new AssertionError(localCloneNotSupportedException);
      AppMethodBeat.o(108093);
      throw localAssertionError;
    }
  }
  
  public final <T> r<T> a(final com.google.a.e parame, final com.google.a.c.a<T> parama)
  {
    final boolean bool2 = false;
    AppMethodBeat.i(108094);
    boolean bool3 = s(parama.bOw);
    if ((bool3) || (bo(true))) {}
    for (final boolean bool1 = true;; bool1 = false)
    {
      if ((bool3) || (bo(false))) {
        bool2 = true;
      }
      if ((bool1) || (bool2)) {
        break;
      }
      AppMethodBeat.o(108094);
      return null;
    }
    parame = new r()
    {
      private r<T> bLl;
      
      private r<T> zn()
      {
        AppMethodBeat.i(222455);
        r localr = this.bLl;
        if (localr != null)
        {
          AppMethodBeat.o(222455);
          return localr;
        }
        localr = parame.a(d.this, parama);
        this.bLl = localr;
        AppMethodBeat.o(222455);
        return localr;
      }
      
      public final T a(com.google.a.d.a paramAnonymousa)
      {
        AppMethodBeat.i(222449);
        if (bool2)
        {
          paramAnonymousa.zE();
          AppMethodBeat.o(222449);
          return null;
        }
        paramAnonymousa = zn().a(paramAnonymousa);
        AppMethodBeat.o(222449);
        return paramAnonymousa;
      }
      
      public final void a(c paramAnonymousc, T paramAnonymousT)
      {
        AppMethodBeat.i(107890);
        if (bool1)
        {
          paramAnonymousc.zK();
          AppMethodBeat.o(107890);
          return;
        }
        zn().a(paramAnonymousc, paramAnonymousT);
        AppMethodBeat.o(107890);
      }
    };
    AppMethodBeat.o(108094);
    return parame;
  }
  
  public final boolean a(com.google.a.a.d paramd, com.google.a.a.e parame)
  {
    AppMethodBeat.i(108100);
    if ((a(paramd)) && (a(parame)))
    {
      AppMethodBeat.o(108100);
      return true;
    }
    AppMethodBeat.o(108100);
    return false;
  }
  
  public final boolean bo(boolean paramBoolean)
  {
    AppMethodBeat.i(108096);
    if (paramBoolean) {}
    for (Object localObject = this.bLN;; localObject = this.bLO)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((com.google.a.a)((Iterator)localObject).next()).yX());
      AppMethodBeat.o(108096);
      return true;
    }
    AppMethodBeat.o(108096);
    return false;
  }
  
  public final boolean s(Class<?> paramClass)
  {
    AppMethodBeat.i(108095);
    if ((this.bLJ != -1.0D) && (!a((com.google.a.a.d)paramClass.getAnnotation(com.google.a.a.d.class), (com.google.a.a.e)paramClass.getAnnotation(com.google.a.a.e.class))))
    {
      AppMethodBeat.o(108095);
      return true;
    }
    if ((!this.bLL) && (u(paramClass)))
    {
      AppMethodBeat.o(108095);
      return true;
    }
    if (t(paramClass))
    {
      AppMethodBeat.o(108095);
      return true;
    }
    AppMethodBeat.o(108095);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.b.d
 * JD-Core Version:    0.7.0.1
 */