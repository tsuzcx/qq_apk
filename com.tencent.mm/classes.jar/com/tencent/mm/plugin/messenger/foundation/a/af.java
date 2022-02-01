package com.tencent.mm.plugin.messenger.foundation.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.a.a;
import com.tencent.mm.cp.c;

public final class af
{
  private static SparseArray<a> KRd;
  private static c<ae> KRe;
  
  static
  {
    AppMethodBeat.i(43074);
    KRd = new SparseArray();
    AppMethodBeat.o(43074);
  }
  
  public static <T extends com.tencent.mm.bx.a> void a(int paramInt, ac<T> paramac)
  {
    try
    {
      AppMethodBeat.i(43070);
      a locala2 = (a)KRd.get(paramInt);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        KRd.put(paramInt, locala1);
      }
      locala1.add(paramac);
      AppMethodBeat.o(43070);
      return;
    }
    finally {}
  }
  
  public static void a(ac paramac)
  {
    try
    {
      AppMethodBeat.i(43071);
      a locala = (a)KRd.get(5);
      if (locala != null)
      {
        locala.remove(paramac);
        if (locala.size() == 0) {
          KRd.remove(5);
        }
      }
      AppMethodBeat.o(43071);
      return;
    }
    finally {}
  }
  
  public static <T extends com.tencent.mm.bx.a> void b(int paramInt, T paramT)
  {
    try
    {
      AppMethodBeat.i(43073);
      a locala = (a)KRd.get(paramInt);
      if (locala != null) {
        locala.b(paramT);
      }
      AppMethodBeat.o(43073);
      return;
    }
    finally {}
  }
  
  public static final void b(c<ae> paramc)
  {
    KRe = paramc;
  }
  
  public static final c<ae> gba()
  {
    return KRe;
  }
  
  public static <T extends com.tencent.mm.bx.a> void k(T paramT)
  {
    try
    {
      AppMethodBeat.i(43072);
      a locala = (a)KRd.get(5);
      if (locala != null) {
        locala.a(paramT);
      }
      AppMethodBeat.o(43072);
      return;
    }
    finally {}
  }
  
  static final class a<T extends com.tencent.mm.bx.a>
    extends com.tencent.mm.cp.a<ac<T>>
    implements ac<T>
  {
    public final void a(final T paramT)
    {
      AppMethodBeat.i(43068);
      a(new a.a() {});
      AppMethodBeat.o(43068);
    }
    
    public final void b(final T paramT)
    {
      AppMethodBeat.i(43069);
      a(new a.a() {});
      AppMethodBeat.o(43069);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.af
 * JD-Core Version:    0.7.0.1
 */