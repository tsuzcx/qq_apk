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
  private static List<a> eEG;
  private static Map<String, a> eEH;
  
  static
  {
    AppMethodBeat.i(114085);
    eEG = new LinkedList();
    eEH = new HashMap();
    AppMethodBeat.o(114085);
  }
  
  public static Object a(String paramString, Parcel paramParcel)
  {
    AppMethodBeat.i(114083);
    paramString = (a)eEH.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.d(paramParcel);
      AppMethodBeat.o(114083);
      return paramString;
    }
    AppMethodBeat.o(114083);
    return null;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(114084);
    if ((parama == null) || (eEG.contains(parama)))
    {
      AppMethodBeat.o(114084);
      return;
    }
    eEH.put(parama.getClass().getName(), parama);
    eEG.add(parama);
    AppMethodBeat.o(114084);
  }
  
  public static void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(114082);
    a locala = ag(paramObject);
    if (locala != null) {
      locala.a(paramObject, paramParcel);
    }
    AppMethodBeat.o(114082);
  }
  
  public static a ag(Object paramObject)
  {
    AppMethodBeat.i(114081);
    Iterator localIterator = eEG.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.af(paramObject))
      {
        AppMethodBeat.o(114081);
        return locala;
      }
    }
    AppMethodBeat.o(114081);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.c
 * JD-Core Version:    0.7.0.1
 */