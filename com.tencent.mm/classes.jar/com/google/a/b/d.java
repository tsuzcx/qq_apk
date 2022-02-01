package com.google.a.b;

import com.google.a.a.e;
import com.google.a.b;
import com.google.a.f;
import com.google.a.s;
import com.google.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
  implements t, Cloneable
{
  public static final d bNS;
  public double bNT;
  public int bNU;
  public boolean bNV;
  public boolean bNW;
  public List<b> bNX;
  public List<b> bNY;
  
  static
  {
    AppMethodBeat.i(108104);
    bNS = new d();
    AppMethodBeat.o(108104);
  }
  
  public d()
  {
    AppMethodBeat.i(108092);
    this.bNT = -1.0D;
    this.bNU = 136;
    this.bNV = true;
    this.bNX = Collections.emptyList();
    this.bNY = Collections.emptyList();
    AppMethodBeat.o(108092);
  }
  
  public static boolean E(Class<?> paramClass)
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
  
  public static boolean F(Class<?> paramClass)
  {
    AppMethodBeat.i(108098);
    if ((paramClass.isMemberClass()) && (!G(paramClass)))
    {
      AppMethodBeat.o(108098);
      return true;
    }
    AppMethodBeat.o(108098);
    return false;
  }
  
  private static boolean G(Class<?> paramClass)
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
  
  private boolean a(com.google.a.a.d paramd)
  {
    AppMethodBeat.i(108101);
    if ((paramd != null) && (paramd.yG() > this.bNT))
    {
      AppMethodBeat.o(108101);
      return false;
    }
    AppMethodBeat.o(108101);
    return true;
  }
  
  private boolean a(e parame)
  {
    AppMethodBeat.i(108102);
    if ((parame != null) && (parame.yG() <= this.bNT))
    {
      AppMethodBeat.o(108102);
      return false;
    }
    AppMethodBeat.o(108102);
    return true;
  }
  
  private d yI()
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
  
  public final boolean D(Class<?> paramClass)
  {
    AppMethodBeat.i(108095);
    if ((this.bNT != -1.0D) && (!a((com.google.a.a.d)paramClass.getAnnotation(com.google.a.a.d.class), (e)paramClass.getAnnotation(e.class))))
    {
      AppMethodBeat.o(108095);
      return true;
    }
    if ((!this.bNV) && (F(paramClass)))
    {
      AppMethodBeat.o(108095);
      return true;
    }
    if (E(paramClass))
    {
      AppMethodBeat.o(108095);
      return true;
    }
    AppMethodBeat.o(108095);
    return false;
  }
  
  public final <T> s<T> a(final f paramf, final com.google.a.c.a<T> parama)
  {
    final boolean bool2 = false;
    AppMethodBeat.i(108094);
    boolean bool3 = D(parama.bQy);
    if ((bool3) || (bf(true))) {}
    for (final boolean bool1 = true;; bool1 = false)
    {
      if ((bool3) || (bf(false))) {
        bool2 = true;
      }
      if ((bool1) || (bool2)) {
        break;
      }
      AppMethodBeat.o(108094);
      return null;
    }
    paramf = new s()
    {
      private s<T> bNs;
      
      public final void a(com.google.a.d.a paramAnonymousa, T paramAnonymousT)
      {
        AppMethodBeat.i(107890);
        if (bool1)
        {
          paramAnonymousa.yS();
          AppMethodBeat.o(107890);
          return;
        }
        s locals = this.bNs;
        if (locals != null) {}
        for (;;)
        {
          locals.a(paramAnonymousa, paramAnonymousT);
          AppMethodBeat.o(107890);
          return;
          locals = paramf.a(d.this, parama);
          this.bNs = locals;
        }
      }
    };
    AppMethodBeat.o(108094);
    return paramf;
  }
  
  public final boolean a(com.google.a.a.d paramd, e parame)
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
  
  public final boolean bf(boolean paramBoolean)
  {
    AppMethodBeat.i(108096);
    if (paramBoolean) {}
    for (Object localObject = this.bNX;; localObject = this.bNY)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((b)((Iterator)localObject).next()).yu());
      AppMethodBeat.o(108096);
      return true;
    }
    AppMethodBeat.o(108096);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.b.d
 * JD-Core Version:    0.7.0.1
 */