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
  private static final List<a> mzi;
  private static final Map<String, a> mzj;
  private static final Object sLock;
  
  static
  {
    AppMethodBeat.i(158796);
    sLock = new byte[0];
    mzi = new LinkedList();
    mzj = new HashMap();
    AppMethodBeat.o(158796);
  }
  
  private static a Fb(String paramString)
  {
    AppMethodBeat.i(235694);
    synchronized (sLock)
    {
      paramString = (a)mzj.get(paramString);
      AppMethodBeat.o(235694);
      return paramString;
    }
  }
  
  public static Object a(String paramString, Parcel paramParcel)
  {
    AppMethodBeat.i(158794);
    paramString = Fb(paramString);
    if (paramString != null)
    {
      paramString = paramString.f(paramParcel);
      AppMethodBeat.o(158794);
      return paramString;
    }
    AppMethodBeat.o(158794);
    return null;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(158795);
    if (parama == null)
    {
      AppMethodBeat.o(158795);
      return;
    }
    synchronized (sLock)
    {
      if (mzi.contains(parama))
      {
        AppMethodBeat.o(158795);
        return;
      }
      mzj.put(parama.getClass().getName(), parama);
      mzi.add(parama);
      AppMethodBeat.o(158795);
      return;
    }
  }
  
  public static void a(Object paramObject, Parcel paramParcel)
  {
    AppMethodBeat.i(158793);
    a locala = cK(paramObject);
    if (locala != null) {
      locala.a(paramObject, paramParcel);
    }
    AppMethodBeat.o(158793);
  }
  
  public static a cK(Object paramObject)
  {
    AppMethodBeat.i(158792);
    synchronized (sLock)
    {
      Iterator localIterator = mzi.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.cJ(paramObject))
        {
          AppMethodBeat.o(158792);
          return locala;
        }
      }
      AppMethodBeat.o(158792);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.extension.c
 * JD-Core Version:    0.7.0.1
 */