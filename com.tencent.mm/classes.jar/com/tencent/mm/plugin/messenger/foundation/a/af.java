package com.tencent.mm.plugin.messenger.foundation.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.cw.c;

public final class af
{
  private static SparseArray<af.a> EVD;
  private static c<ae> EVE;
  
  static
  {
    AppMethodBeat.i(43074);
    EVD = new SparseArray();
    AppMethodBeat.o(43074);
  }
  
  public static <T extends a> void a(int paramInt, ac<T> paramac)
  {
    try
    {
      AppMethodBeat.i(43070);
      af.a locala2 = (af.a)EVD.get(paramInt);
      af.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new af.a((byte)0);
        EVD.put(paramInt, locala1);
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
      af.a locala = (af.a)EVD.get(5);
      if (locala != null)
      {
        locala.remove(paramac);
        if (locala.size() == 0) {
          EVD.remove(5);
        }
      }
      AppMethodBeat.o(43071);
      return;
    }
    finally {}
  }
  
  public static <T extends a> void b(int paramInt, T paramT)
  {
    try
    {
      AppMethodBeat.i(43073);
      af.a locala = (af.a)EVD.get(paramInt);
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
    EVE = paramc;
  }
  
  public static final c<ae> eSf()
  {
    return EVE;
  }
  
  public static <T extends a> void k(T paramT)
  {
    try
    {
      AppMethodBeat.i(43072);
      af.a locala = (af.a)EVD.get(5);
      if (locala != null) {
        locala.a(paramT);
      }
      AppMethodBeat.o(43072);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.af
 * JD-Core Version:    0.7.0.1
 */