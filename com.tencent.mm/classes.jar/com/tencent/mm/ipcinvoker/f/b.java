package com.tencent.mm.ipcinvoker.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  private static final Set<Object> eEN;
  private static final Map<String, Set<c>> eEq;
  
  static
  {
    AppMethodBeat.i(114115);
    eEN = new HashSet();
    eEq = new HashMap();
    AppMethodBeat.o(114115);
  }
  
  public static boolean a(String paramString, c paramc)
  {
    AppMethodBeat.i(114112);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(114112);
      return false;
    }
    Object localObject;
    label125:
    for (;;)
    {
      synchronized (eEq)
      {
        localObject = (Set)eEq.get(paramString);
        if (localObject != null) {
          break label125;
        }
        localObject = new HashSet();
        eEq.put(paramString, localObject);
        com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "addIntoSet(%s)", new Object[] { paramString });
      }
      try
      {
        boolean bool = ((Set)localObject).add(paramc);
        return bool;
      }
      finally
      {
        AppMethodBeat.o(114112);
      }
      paramString = finally;
      AppMethodBeat.o(114112);
      throw paramString;
    }
  }
  
  public static void ah(Object paramObject)
  {
    AppMethodBeat.i(114110);
    eEN.add(paramObject);
    AppMethodBeat.o(114110);
  }
  
  public static void ai(Object paramObject)
  {
    AppMethodBeat.i(114111);
    eEN.remove(paramObject);
    AppMethodBeat.o(114111);
  }
  
  public static boolean b(String paramString, c paramc)
  {
    AppMethodBeat.i(114113);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(114113);
      return false;
    }
    Set localSet;
    synchronized (eEq)
    {
      localSet = (Set)eEq.get(paramString);
      if (localSet == null)
      {
        AppMethodBeat.o(114113);
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
      AppMethodBeat.o(114113);
    }
  }
  
  public static void md(String paramString)
  {
    AppMethodBeat.i(114114);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(114114);
      return;
    }
    Set localSet;
    synchronized (eEq)
    {
      localSet = (Set)eEq.remove(paramString);
      if (localSet == null)
      {
        AppMethodBeat.o(114114);
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
      AppMethodBeat.o(114114);
    }
    AppMethodBeat.o(114114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f.b
 * JD-Core Version:    0.7.0.1
 */