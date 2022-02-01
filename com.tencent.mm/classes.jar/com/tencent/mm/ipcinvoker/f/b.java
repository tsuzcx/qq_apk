package com.tencent.mm.ipcinvoker.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  private static final Map<String, Set<c>> mza;
  private static final Set<Object> mzs;
  
  static
  {
    AppMethodBeat.i(158826);
    mzs = new HashSet();
    mza = new HashMap();
    AppMethodBeat.o(158826);
  }
  
  public static void Fc(String paramString)
  {
    AppMethodBeat.i(158825);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(158825);
      return;
    }
    Set localSet;
    synchronized (mza)
    {
      localSet = (Set)mza.remove(paramString);
      if (localSet == null)
      {
        AppMethodBeat.o(158825);
        return;
      }
    }
    com.tencent.mm.ipcinvoker.h.c.i("IPC.ObjectRecycler", "recycleAll(%s)", new Object[] { paramString });
    try
    {
      paramString = localSet.iterator();
      while (paramString.hasNext())
      {
        ??? = (c)paramString.next();
        com.tencent.mm.ipcinvoker.h.c.i("IPC.ObjectRecycler", "recycle(%s)", new Object[] { Integer.valueOf(???.hashCode()) });
        ((c)???).recycle();
      }
      localSet.clear();
    }
    finally
    {
      AppMethodBeat.o(158825);
    }
    AppMethodBeat.o(158825);
  }
  
  public static boolean a(String paramString, c paramc)
  {
    AppMethodBeat.i(158823);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(158823);
      return false;
    }
    Object localObject;
    label125:
    for (;;)
    {
      synchronized (mza)
      {
        localObject = (Set)mza.get(paramString);
        if (localObject != null) {
          break label125;
        }
        localObject = new HashSet();
        mza.put(paramString, localObject);
        com.tencent.mm.ipcinvoker.h.c.i("IPC.ObjectRecycler", "addIntoSet(%s)", new Object[] { paramString });
      }
      try
      {
        boolean bool = ((Set)localObject).add(paramc);
        AppMethodBeat.o(158823);
        return bool;
      }
      finally
      {
        AppMethodBeat.o(158823);
      }
      paramString = finally;
      AppMethodBeat.o(158823);
      throw paramString;
    }
  }
  
  public static boolean b(String paramString, c paramc)
  {
    AppMethodBeat.i(158824);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(158824);
      return false;
    }
    Set localSet;
    synchronized (mza)
    {
      localSet = (Set)mza.get(paramString);
      if (localSet == null)
      {
        AppMethodBeat.o(158824);
        return false;
      }
    }
    com.tencent.mm.ipcinvoker.h.c.i("IPC.ObjectRecycler", "removeFromSet(%s)", new Object[] { paramString });
    try
    {
      boolean bool = localSet.remove(paramc);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(158824);
    }
  }
  
  public static void cL(Object paramObject)
  {
    AppMethodBeat.i(158821);
    if (paramObject == null)
    {
      AppMethodBeat.o(158821);
      return;
    }
    synchronized (mzs)
    {
      mzs.add(paramObject);
      AppMethodBeat.o(158821);
      return;
    }
  }
  
  public static void cM(Object paramObject)
  {
    AppMethodBeat.i(158822);
    if (paramObject == null)
    {
      AppMethodBeat.o(158822);
      return;
    }
    synchronized (mzs)
    {
      mzs.remove(paramObject);
      AppMethodBeat.o(158822);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f.b
 * JD-Core Version:    0.7.0.1
 */