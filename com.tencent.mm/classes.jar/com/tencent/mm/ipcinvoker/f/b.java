package com.tencent.mm.ipcinvoker.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  private static final Map<String, Set<c>> fZD;
  private static final Set<Object> fZQ;
  
  static
  {
    AppMethodBeat.i(158826);
    fZQ = new HashSet();
    fZD = new HashMap();
    AppMethodBeat.o(158826);
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
      synchronized (fZD)
      {
        localObject = (Set)fZD.get(paramString);
        if (localObject != null) {
          break label125;
        }
        localObject = new HashSet();
        fZD.put(paramString, localObject);
        com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "addIntoSet(%s)", new Object[] { paramString });
      }
      try
      {
        boolean bool = ((Set)localObject).add(paramc);
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
    synchronized (fZD)
    {
      localSet = (Set)fZD.get(paramString);
      if (localSet == null)
      {
        AppMethodBeat.o(158824);
        return false;
      }
    }
    com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "removeFromSet(%s)", new Object[] { paramString });
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
  
  public static void bj(Object paramObject)
  {
    AppMethodBeat.i(158821);
    fZQ.add(paramObject);
    AppMethodBeat.o(158821);
  }
  
  public static void bk(Object paramObject)
  {
    AppMethodBeat.i(158822);
    fZQ.remove(paramObject);
    AppMethodBeat.o(158822);
  }
  
  public static void qt(String paramString)
  {
    AppMethodBeat.i(158825);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(158825);
      return;
    }
    Set localSet;
    synchronized (fZD)
    {
      localSet = (Set)fZD.remove(paramString);
      if (localSet == null)
      {
        AppMethodBeat.o(158825);
        return;
      }
    }
    com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "recycleAll(%s)", new Object[] { paramString });
    try
    {
      paramString = localSet.iterator();
      while (paramString.hasNext())
      {
        ??? = (c)paramString.next();
        com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "recycle(%s)", new Object[] { Integer.valueOf(???.hashCode()) });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f.b
 * JD-Core Version:    0.7.0.1
 */