package com.google.c.b;

import com.google.c.d.c;
import com.google.c.r;
import com.google.c.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
  implements s, Cloneable
{
  public static final d dFq;
  public double dFr;
  public int dFs;
  public boolean dFt;
  public boolean dFu;
  public List<com.google.c.a> dFv;
  public List<com.google.c.a> dFw;
  
  static
  {
    AppMethodBeat.i(108104);
    dFq = new d();
    AppMethodBeat.o(108104);
  }
  
  public d()
  {
    AppMethodBeat.i(108092);
    this.dFr = -1.0D;
    this.dFs = 136;
    this.dFt = true;
    this.dFv = Collections.emptyList();
    this.dFw = Collections.emptyList();
    AppMethodBeat.o(108092);
  }
  
  public static boolean C(Class<?> paramClass)
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
  
  public static boolean D(Class<?> paramClass)
  {
    AppMethodBeat.i(108098);
    if ((paramClass.isMemberClass()) && (!E(paramClass)))
    {
      AppMethodBeat.o(108098);
      return true;
    }
    AppMethodBeat.o(108098);
    return false;
  }
  
  private static boolean E(Class<?> paramClass)
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
  
  private d YX()
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
  
  private boolean a(com.google.c.a.d paramd)
  {
    AppMethodBeat.i(108101);
    if ((paramd != null) && (paramd.YV() > this.dFr))
    {
      AppMethodBeat.o(108101);
      return false;
    }
    AppMethodBeat.o(108101);
    return true;
  }
  
  private boolean a(com.google.c.a.e parame)
  {
    AppMethodBeat.i(108102);
    if ((parame != null) && (parame.YV() <= this.dFr))
    {
      AppMethodBeat.o(108102);
      return false;
    }
    AppMethodBeat.o(108102);
    return true;
  }
  
  public final boolean B(Class<?> paramClass)
  {
    AppMethodBeat.i(108095);
    if ((this.dFr != -1.0D) && (!a((com.google.c.a.d)paramClass.getAnnotation(com.google.c.a.d.class), (com.google.c.a.e)paramClass.getAnnotation(com.google.c.a.e.class))))
    {
      AppMethodBeat.o(108095);
      return true;
    }
    if ((!this.dFt) && (D(paramClass)))
    {
      AppMethodBeat.o(108095);
      return true;
    }
    if (C(paramClass))
    {
      AppMethodBeat.o(108095);
      return true;
    }
    AppMethodBeat.o(108095);
    return false;
  }
  
  public final <T> r<T> a(final com.google.c.e parame, final com.google.c.c.a<T> parama)
  {
    final boolean bool2 = false;
    AppMethodBeat.i(108094);
    boolean bool3 = B(parama.dIb);
    if ((bool3) || (bV(true))) {}
    for (final boolean bool1 = true;; bool1 = false)
    {
      if ((bool3) || (bV(false))) {
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
      private r<T> dET;
      
      private r<T> YY()
      {
        AppMethodBeat.i(208810);
        r localr = this.dET;
        if (localr != null)
        {
          AppMethodBeat.o(208810);
          return localr;
        }
        localr = parame.a(d.this, parama);
        this.dET = localr;
        AppMethodBeat.o(208810);
        return localr;
      }
      
      public final T a(com.google.c.d.a paramAnonymousa)
      {
        AppMethodBeat.i(208811);
        if (bool2)
        {
          paramAnonymousa.Zp();
          AppMethodBeat.o(208811);
          return null;
        }
        paramAnonymousa = YY().a(paramAnonymousa);
        AppMethodBeat.o(208811);
        return paramAnonymousa;
      }
      
      public final void a(c paramAnonymousc, T paramAnonymousT)
      {
        AppMethodBeat.i(107890);
        if (bool1)
        {
          paramAnonymousc.Zv();
          AppMethodBeat.o(107890);
          return;
        }
        YY().a(paramAnonymousc, paramAnonymousT);
        AppMethodBeat.o(107890);
      }
    };
    AppMethodBeat.o(108094);
    return parame;
  }
  
  public final boolean a(com.google.c.a.d paramd, com.google.c.a.e parame)
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
  
  public final boolean bV(boolean paramBoolean)
  {
    AppMethodBeat.i(108096);
    if (paramBoolean) {}
    for (Object localObject = this.dFv;; localObject = this.dFw)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((com.google.c.a)((Iterator)localObject).next()).YI());
      AppMethodBeat.o(108096);
      return true;
    }
    AppMethodBeat.o(108096);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.c.b.d
 * JD-Core Version:    0.7.0.1
 */