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
  private static volatile c gxW;
  Map<String, List<e>> gxX;
  
  private c()
  {
    AppMethodBeat.i(158785);
    this.gxX = new ConcurrentHashMap();
    AppMethodBeat.o(158785);
  }
  
  public static c ahF()
  {
    AppMethodBeat.i(158784);
    if (gxW == null) {}
    try
    {
      if (gxW == null) {
        gxW = new c();
      }
      c localc = gxW;
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
    List localList = (List)this.gxX.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.gxX.put(paramString, localObject);
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
    List localList = (List)this.gxX.get(paramString);
    if (localList != null) {}
    for (;;)
    {
      try
      {
        bool = localList.remove(parame);
        if (localList.isEmpty()) {
          this.gxX.remove(paramString);
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
    paramString = (List)this.gxX.get(paramString);
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
        ((e)paramString.next()).be(paramBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.d.c
 * JD-Core Version:    0.7.0.1
 */