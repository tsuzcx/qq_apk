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
  private static volatile c fZG;
  Map<String, List<e>> fZH;
  
  private c()
  {
    AppMethodBeat.i(158785);
    this.fZH = new ConcurrentHashMap();
    AppMethodBeat.o(158785);
  }
  
  public static c adD()
  {
    AppMethodBeat.i(158784);
    if (fZG == null) {}
    try
    {
      if (fZG == null) {
        fZG = new c();
      }
      c localc = fZG;
      AppMethodBeat.o(158784);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(158784);
    }
  }
  
  public final boolean a(String paramString, e parame)
  {
    AppMethodBeat.i(158787);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(158787);
      return false;
    }
    List localList = (List)this.fZH.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.fZH.put(paramString, localObject);
    }
    if (((List)localObject).contains(parame))
    {
      AppMethodBeat.o(158787);
      return false;
    }
    try
    {
      boolean bool = ((List)localObject).add(parame);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(158787);
    }
  }
  
  public final boolean b(String paramString, e parame)
  {
    AppMethodBeat.i(158788);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(158788);
      return false;
    }
    List localList = (List)this.fZH.get(paramString);
    if (localList != null) {}
    for (;;)
    {
      try
      {
        bool = localList.remove(parame);
        if (localList.isEmpty()) {
          this.fZH.remove(paramString);
        }
        AppMethodBeat.o(158788);
        return bool;
      }
      finally
      {
        AppMethodBeat.o(158788);
      }
      boolean bool = false;
    }
  }
  
  public final boolean m(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(158786);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(158786);
      return false;
    }
    paramString = (List)this.fZH.get(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(158786);
      return true;
    }
    try
    {
      ArrayList localArrayList = new ArrayList(paramString);
      paramString = localArrayList.iterator();
      while (paramString.hasNext()) {
        ((e)paramString.next()).bf(paramBundle);
      }
      AppMethodBeat.o(158786);
    }
    finally
    {
      AppMethodBeat.o(158786);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.d.c
 * JD-Core Version:    0.7.0.1
 */