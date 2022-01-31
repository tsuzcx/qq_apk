package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

final class c
  extends d
{
  long axh = -9223372036854775807L;
  
  public c()
  {
    super(null);
  }
  
  private static Boolean b(m paramm)
  {
    boolean bool = true;
    AppMethodBeat.i(94870);
    if (paramm.readUnsignedByte() == 1) {}
    for (;;)
    {
      AppMethodBeat.o(94870);
      return Boolean.valueOf(bool);
      bool = false;
    }
  }
  
  private static Object b(m paramm, int paramInt)
  {
    AppMethodBeat.i(94877);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 9: 
    default: 
      AppMethodBeat.o(94877);
      return null;
    case 0: 
      paramm = c(paramm);
      AppMethodBeat.o(94877);
      return paramm;
    case 1: 
      paramm = b(paramm);
      AppMethodBeat.o(94877);
      return paramm;
    case 2: 
      paramm = d(paramm);
      AppMethodBeat.o(94877);
      return paramm;
    case 3: 
      paramm = f(paramm);
      AppMethodBeat.o(94877);
      return paramm;
    case 8: 
      paramm = g(paramm);
      AppMethodBeat.o(94877);
      return paramm;
    case 10: 
      paramm = e(paramm);
      AppMethodBeat.o(94877);
      return paramm;
    }
    paramm = h(paramm);
    AppMethodBeat.o(94877);
    return paramm;
  }
  
  private static Double c(m paramm)
  {
    AppMethodBeat.i(94871);
    double d = Double.longBitsToDouble(paramm.readLong());
    AppMethodBeat.o(94871);
    return Double.valueOf(d);
  }
  
  private static String d(m paramm)
  {
    AppMethodBeat.i(94872);
    int i = paramm.readUnsignedShort();
    int j = paramm.position;
    paramm.en(i);
    paramm = new String(paramm.data, j, i);
    AppMethodBeat.o(94872);
    return paramm;
  }
  
  private static ArrayList<Object> e(m paramm)
  {
    AppMethodBeat.i(94873);
    int j = paramm.qT();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(b(paramm, paramm.readUnsignedByte()));
      i += 1;
    }
    AppMethodBeat.o(94873);
    return localArrayList;
  }
  
  private static HashMap<String, Object> f(m paramm)
  {
    AppMethodBeat.i(94874);
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      String str = d(paramm);
      int i = paramm.readUnsignedByte();
      if (i == 9) {
        break;
      }
      localHashMap.put(str, b(paramm, i));
    }
    AppMethodBeat.o(94874);
    return localHashMap;
  }
  
  private static HashMap<String, Object> g(m paramm)
  {
    AppMethodBeat.i(94875);
    int j = paramm.qT();
    HashMap localHashMap = new HashMap(j);
    int i = 0;
    while (i < j)
    {
      localHashMap.put(d(paramm), b(paramm, paramm.readUnsignedByte()));
      i += 1;
    }
    AppMethodBeat.o(94875);
    return localHashMap;
  }
  
  private static Date h(m paramm)
  {
    AppMethodBeat.i(94876);
    Date localDate = new Date(c(paramm).doubleValue());
    paramm.en(2);
    AppMethodBeat.o(94876);
    return localDate;
  }
  
  protected final void a(m paramm, long paramLong)
  {
    AppMethodBeat.i(94869);
    if (paramm.readUnsignedByte() != 2)
    {
      paramm = new o();
      AppMethodBeat.o(94869);
      throw paramm;
    }
    if (!"onMetaData".equals(d(paramm)))
    {
      AppMethodBeat.o(94869);
      return;
    }
    if (paramm.readUnsignedByte() != 8)
    {
      AppMethodBeat.o(94869);
      return;
    }
    paramm = g(paramm);
    if (paramm.containsKey("duration"))
    {
      double d = ((Double)paramm.get("duration")).doubleValue();
      if (d > 0.0D) {
        this.axh = ((d * 1000000.0D));
      }
    }
    AppMethodBeat.o(94869);
  }
  
  protected final boolean a(m paramm)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.c
 * JD-Core Version:    0.7.0.1
 */