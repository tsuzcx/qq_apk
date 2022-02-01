package com.tencent.mm.plugin.messenger.foundation.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.a.a;
import com.tencent.mm.cn.c;

public final class y
{
  private static SparseArray<a> uGS;
  private static c<x> uGT;
  
  static
  {
    AppMethodBeat.i(43074);
    uGS = new SparseArray();
    AppMethodBeat.o(43074);
  }
  
  public static <T extends com.tencent.mm.bw.a> void a(int paramInt, v<T> paramv)
  {
    try
    {
      AppMethodBeat.i(43070);
      a locala2 = (a)uGS.get(paramInt);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        uGS.put(paramInt, locala1);
      }
      locala1.bs(paramv);
      AppMethodBeat.o(43070);
      return;
    }
    finally {}
  }
  
  public static void a(v paramv)
  {
    try
    {
      AppMethodBeat.i(43071);
      a locala = (a)uGS.get(5);
      if (locala != null)
      {
        locala.remove(paramv);
        if (locala.size() == 0) {
          uGS.remove(5);
        }
      }
      AppMethodBeat.o(43071);
      return;
    }
    finally {}
  }
  
  public static <T extends com.tencent.mm.bw.a> void b(int paramInt, T paramT)
  {
    try
    {
      AppMethodBeat.i(43073);
      a locala = (a)uGS.get(paramInt);
      if (locala != null) {
        locala.b(paramT);
      }
      AppMethodBeat.o(43073);
      return;
    }
    finally {}
  }
  
  public static final void b(c<x> paramc)
  {
    uGT = paramc;
  }
  
  public static final c<x> dct()
  {
    return uGT;
  }
  
  public static <T extends com.tencent.mm.bw.a> void j(T paramT)
  {
    try
    {
      AppMethodBeat.i(43072);
      a locala = (a)uGS.get(5);
      if (locala != null) {
        locala.a(paramT);
      }
      AppMethodBeat.o(43072);
      return;
    }
    finally {}
  }
  
  static final class a<T extends com.tencent.mm.bw.a>
    extends com.tencent.mm.cn.a<v<T>>
    implements v<T>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.y
 * JD-Core Version:    0.7.0.1
 */