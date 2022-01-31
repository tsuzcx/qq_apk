package com.tencent.mm.ipcinvoker.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c
{
  private static volatile c eED;
  Map<String, List<e>> eEE;
  
  private c()
  {
    AppMethodBeat.i(114074);
    this.eEE = new ConcurrentHashMap();
    AppMethodBeat.o(114074);
  }
  
  public static c PT()
  {
    AppMethodBeat.i(114073);
    if (eED == null) {}
    try
    {
      if (eED == null) {
        eED = new c();
      }
      c localc = eED;
      AppMethodBeat.o(114073);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(114073);
    }
  }
  
  public final boolean a(String paramString, e parame)
  {
    AppMethodBeat.i(114076);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(114076);
      return false;
    }
    List localList = (List)this.eEE.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.eEE.put(paramString, localObject);
    }
    if (((List)localObject).contains(parame))
    {
      AppMethodBeat.o(114076);
      return false;
    }
    try
    {
      boolean bool = ((List)localObject).add(parame);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(114076);
    }
  }
  
  public final boolean b(String paramString, e parame)
  {
    AppMethodBeat.i(114077);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(114077);
      return false;
    }
    List localList = (List)this.eEE.get(paramString);
    if (localList != null) {}
    for (;;)
    {
      try
      {
        bool = localList.remove(parame);
        if (localList.isEmpty()) {
          this.eEE.remove(paramString);
        }
        AppMethodBeat.o(114077);
        return bool;
      }
      finally
      {
        AppMethodBeat.o(114077);
      }
      boolean bool = false;
    }
  }
  
  public final boolean l(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(114075);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(114075);
      return false;
    }
    paramString = (List)this.eEE.get(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(114075);
      return true;
    }
    try
    {
      ArrayList localArrayList = new ArrayList(paramString);
      paramString = localArrayList.iterator();
      while (paramString.hasNext()) {
        ((e)paramString.next()).ad(paramBundle);
      }
      AppMethodBeat.o(114075);
    }
    finally
    {
      AppMethodBeat.o(114075);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.d.c
 * JD-Core Version:    0.7.0.1
 */