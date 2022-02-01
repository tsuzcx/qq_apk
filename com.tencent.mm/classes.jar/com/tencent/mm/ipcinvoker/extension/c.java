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
  private static List<a> fZJ;
  private static Map<String, a> fZK;
  
  static
  {
    AppMethodBeat.i(158796);
    fZJ = new LinkedList();
    fZK = new HashMap();
    AppMethodBeat.o(158796);
  }
  
  public static Object a(String paramString, Parcel paramParcel)
  {
    AppMethodBeat.i(158794);
    paramString = (a)fZK.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.c(paramParcel);
      AppMethodBeat.o(158794);
      return paramString;
    }
    AppMethodBeat.o(158794);
    return null;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(158795);
    if ((parama == null) || (fZJ.contains(parama)))
    {
      AppMethodBeat.o(158795);
      return;
    }
    fZK.put(parama.getClass().getName(), parama);
    fZJ.add(parama);
    AppMethodBeat.o(158795);
  }
  
  public static void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(158793);
    a locala = bi(paramObject);
    if (locala != null) {
      locala.a(paramObject, paramParcel);
    }
    AppMethodBeat.o(158793);
  }
  
  public static a bi(Object paramObject)
  {
    AppMethodBeat.i(158792);
    Iterator localIterator = fZJ.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.bh(paramObject))
      {
        AppMethodBeat.o(158792);
        return locala;
      }
    }
    AppMethodBeat.o(158792);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.c
 * JD-Core Version:    0.7.0.1
 */