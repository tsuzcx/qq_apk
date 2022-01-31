package com.tencent.mm.plugin.messenger.foundation.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.cm.c;

public final class v
{
  private static SparseArray<v.a> oDG;
  private static c<u> oDH;
  
  static
  {
    AppMethodBeat.i(60015);
    oDG = new SparseArray();
    AppMethodBeat.o(60015);
  }
  
  public static <T extends a> void a(int paramInt, s<T> params)
  {
    try
    {
      AppMethodBeat.i(60011);
      v.a locala2 = (v.a)oDG.get(paramInt);
      v.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new v.a((byte)0);
        oDG.put(paramInt, locala1);
      }
      locala1.at(params);
      AppMethodBeat.o(60011);
      return;
    }
    finally {}
  }
  
  public static void a(s params)
  {
    try
    {
      AppMethodBeat.i(60012);
      v.a locala = (v.a)oDG.get(5);
      if (locala != null)
      {
        locala.remove(params);
        if (locala.size() == 0) {
          oDG.remove(5);
        }
      }
      AppMethodBeat.o(60012);
      return;
    }
    finally {}
  }
  
  public static <T extends a> void b(int paramInt, T paramT)
  {
    try
    {
      AppMethodBeat.i(60014);
      v.a locala = (v.a)oDG.get(paramInt);
      if (locala != null) {
        locala.e(paramT);
      }
      AppMethodBeat.o(60014);
      return;
    }
    finally {}
  }
  
  public static final void b(c<u> paramc)
  {
    oDH = paramc;
  }
  
  public static final c<u> bPS()
  {
    return oDH;
  }
  
  public static <T extends a> void h(T paramT)
  {
    try
    {
      AppMethodBeat.i(60013);
      v.a locala = (v.a)oDG.get(5);
      if (locala != null) {
        locala.f(paramT);
      }
      AppMethodBeat.o(60013);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.v
 * JD-Core Version:    0.7.0.1
 */