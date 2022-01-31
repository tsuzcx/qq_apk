package com.tencent.mm.ipcinvoker.f;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  private static final Map<String, Set<c>> dGN = new HashMap();
  private static final Set<Object> dHk = new HashSet();
  
  public static void Z(Object paramObject)
  {
    dHk.add(paramObject);
  }
  
  public static boolean a(String paramString, c paramc)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramc == null)) {
      return false;
    }
    for (;;)
    {
      synchronized (dGN)
      {
        Object localObject = (Set)dGN.get(paramString);
        if (localObject == null)
        {
          localObject = new HashSet();
          dGN.put(paramString, localObject);
          com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "addIntoSet(%s)", new Object[] { paramString });
          try
          {
            boolean bool = ((Set)localObject).add(paramc);
            return bool;
          }
          finally {}
        }
      }
    }
  }
  
  public static void aa(Object paramObject)
  {
    dHk.remove(paramObject);
  }
  
  public static boolean b(String paramString, c paramc)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramc == null)) {
      return false;
    }
    Set localSet;
    synchronized (dGN)
    {
      localSet = (Set)dGN.get(paramString);
      if (localSet == null) {
        return false;
      }
    }
    com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "removeFromSet(%s)", new Object[] { paramString });
    try
    {
      boolean bool = localSet.remove(paramc);
      return bool;
    }
    finally {}
  }
  
  public static void fI(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    Set localSet;
    for (;;)
    {
      return;
      synchronized (dGN)
      {
        localSet = (Set)dGN.remove(paramString);
        if (localSet != null)
        {
          com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "recycleAll(%s)", new Object[] { paramString });
          try
          {
            paramString = localSet.iterator();
            while (paramString.hasNext())
            {
              ??? = (c)paramString.next();
              com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "recycle(%s)", new Object[] { Integer.valueOf(???.hashCode()) });
              ((c)???).recycle();
              continue;
              paramString = finally;
            }
          }
          finally {}
        }
      }
    }
    localSet.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f.b
 * JD-Core Version:    0.7.0.1
 */