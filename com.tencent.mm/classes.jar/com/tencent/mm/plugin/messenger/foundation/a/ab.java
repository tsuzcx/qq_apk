package com.tencent.mm.plugin.messenger.foundation.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.cm.c;

public final class ab
{
  private static SparseArray<a> vVZ;
  private static c<aa> vWa;
  
  static
  {
    AppMethodBeat.i(43074);
    vVZ = new SparseArray();
    AppMethodBeat.o(43074);
  }
  
  public static <T extends com.tencent.mm.bw.a> void a(int paramInt, y<T> paramy)
  {
    try
    {
      AppMethodBeat.i(43070);
      a locala2 = (a)vVZ.get(paramInt);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        vVZ.put(paramInt, locala1);
      }
      locala1.bu(paramy);
      AppMethodBeat.o(43070);
      return;
    }
    finally {}
  }
  
  public static void a(y paramy)
  {
    try
    {
      AppMethodBeat.i(43071);
      a locala = (a)vVZ.get(5);
      if (locala != null)
      {
        locala.remove(paramy);
        if (locala.size() == 0) {
          vVZ.remove(5);
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
      a locala = (a)vVZ.get(paramInt);
      if (locala != null) {
        locala.b(paramT);
      }
      AppMethodBeat.o(43073);
      return;
    }
    finally {}
  }
  
  public static final void b(c<aa> paramc)
  {
    vWa = paramc;
  }
  
  public static final c<aa> doK()
  {
    return vWa;
  }
  
  public static <T extends com.tencent.mm.bw.a> void j(T paramT)
  {
    try
    {
      AppMethodBeat.i(43072);
      a locala = (a)vVZ.get(5);
      if (locala != null) {
        locala.a(paramT);
      }
      AppMethodBeat.o(43072);
      return;
    }
    finally {}
  }
  
  static final class a<T extends com.tencent.mm.bw.a>
    extends com.tencent.mm.cm.a<y<T>>
    implements y<T>
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
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.ab
 * JD-Core Version:    0.7.0.1
 */