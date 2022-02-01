package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static List<a> jZk;
  private static Map<String, a> jZl;
  
  static
  {
    AppMethodBeat.i(158796);
    jZk = new LinkedList();
    jZl = new HashMap();
    AppMethodBeat.o(158796);
  }
  
  public static Object a(String paramString, Parcel paramParcel)
  {
    AppMethodBeat.i(158794);
    paramString = (a)jZl.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.d(paramParcel);
      AppMethodBeat.o(158794);
      return paramString;
    }
    AppMethodBeat.o(158794);
    return null;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(158795);
    if ((parama == null) || (jZk.contains(parama)))
    {
      AppMethodBeat.o(158795);
      return;
    }
    jZl.put(parama.getClass().getName(), parama);
    jZk.add(parama);
    AppMethodBeat.o(158795);
  }
  
  public static void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(158793);
    a locala = bq(paramObject);
    if (locala != null) {
      locala.a(paramObject, paramParcel);
    }
    AppMethodBeat.o(158793);
  }
  
  public static a bq(Object paramObject)
  {
    AppMethodBeat.i(158792);
    Iterator localIterator = jZk.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.bp(paramObject))
      {
        AppMethodBeat.o(158792);
        return locala;
      }
    }
    AppMethodBeat.o(158792);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.c
 * JD-Core Version:    0.7.0.1
 */