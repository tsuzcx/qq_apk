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
  private static volatile c mzf;
  Map<String, List<e>> mMap;
  
  private c()
  {
    AppMethodBeat.i(158785);
    this.mMap = new ConcurrentHashMap();
    AppMethodBeat.o(158785);
  }
  
  public static c aYB()
  {
    AppMethodBeat.i(158784);
    if (mzf == null) {}
    try
    {
      if (mzf == null) {
        mzf = new c();
      }
      c localc = mzf;
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
    List localList = (List)this.mMap.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.mMap.put(paramString, localObject);
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
    List localList = (List)this.mMap.get(paramString);
    if (localList != null) {}
    for (;;)
    {
      try
      {
        bool = localList.remove(parame);
        if (localList.isEmpty()) {
          this.mMap.remove(paramString);
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
  
  public final boolean r(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(158786);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(158786);
      return false;
    }
    paramString = (List)this.mMap.get(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(158786);
      return true;
    }
    try
    {
      ArrayList localArrayList = new ArrayList(paramString);
      paramString = localArrayList.iterator();
      if (paramString.hasNext()) {}
      return true;
    }
    finally
    {
      AppMethodBeat.o(158786);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.d.c
 * JD-Core Version:    0.7.0.1
 */