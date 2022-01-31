package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  private static List<a> dHd = new LinkedList();
  private static Map<String, a> dHe = new HashMap();
  
  public static a Y(Object paramObject)
  {
    Iterator localIterator = dHd.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.X(paramObject)) {
        return locala;
      }
    }
    return null;
  }
  
  public static Object a(String paramString, Parcel paramParcel)
  {
    paramString = (a)dHe.get(paramString);
    if (paramString != null) {
      return paramString.c(paramParcel);
    }
    return null;
  }
  
  public static void a(a parama)
  {
    if ((parama == null) || (dHd.contains(parama))) {
      return;
    }
    dHe.put(parama.getClass().getName(), parama);
    dHd.add(parama);
  }
  
  public static void a(Object paramObject, Parcel paramParcel)
  {
    a locala = Y(paramObject);
    if (locala != null) {
      locala.a(paramObject, paramParcel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.c
 * JD-Core Version:    0.7.0.1
 */