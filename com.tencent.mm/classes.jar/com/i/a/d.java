package com.i.a;

import com.i.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  public final List<Object> ede;
  public final String sql;
  
  public d(String paramString, List<Object> paramList)
  {
    AppMethodBeat.i(153391);
    this.sql = paramString;
    paramString = paramList;
    if (paramList == null) {
      paramString = new ArrayList();
    }
    this.ede = paramString;
    AppMethodBeat.o(153391);
  }
  
  static Object[] aV(List<Object> paramList)
  {
    AppMethodBeat.i(153393);
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(cc(paramList.next()));
      }
    }
    paramList = localArrayList.toArray(new Object[0]);
    AppMethodBeat.o(153393);
    return paramList;
  }
  
  static List<String> aW(List<Object> paramList)
  {
    AppMethodBeat.i(153394);
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(ca(paramList.next()));
      }
    }
    AppMethodBeat.o(153394);
    return localArrayList;
  }
  
  private static String ca(Object paramObject)
  {
    AppMethodBeat.i(153395);
    if (paramObject == null)
    {
      AppMethodBeat.o(153395);
      return null;
    }
    if ((paramObject instanceof byte[]))
    {
      ArrayList localArrayList = new ArrayList();
      paramObject = (byte[])paramObject;
      int j = paramObject.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(Integer.valueOf(paramObject[i]));
        i += 1;
      }
      paramObject = localArrayList.toString();
      AppMethodBeat.o(153395);
      return paramObject;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = h((Map)paramObject).toString();
      AppMethodBeat.o(153395);
      return paramObject;
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(153395);
    return paramObject;
  }
  
  private static Object cc(Object paramObject)
  {
    AppMethodBeat.i(153390);
    if (paramObject == null)
    {
      AppMethodBeat.o(153390);
      return null;
    }
    if (a.edh) {
      new StringBuilder("arg ").append(paramObject.getClass().getCanonicalName()).append(" ").append(ca(paramObject));
    }
    Object localObject = paramObject;
    if ((paramObject instanceof List))
    {
      paramObject = (List)paramObject;
      localObject = new byte[paramObject.size()];
      int i = 0;
      while (i < paramObject.size())
      {
        localObject[i] = ((byte)((Integer)paramObject.get(i)).intValue());
        i += 1;
      }
    }
    if (a.edh) {
      new StringBuilder("arg ").append(localObject.getClass().getCanonicalName()).append(" ").append(ca(localObject));
    }
    AppMethodBeat.o(153390);
    return localObject;
  }
  
  private static Map<String, Object> h(Map<Object, Object> paramMap)
  {
    AppMethodBeat.i(153396);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMap = localEntry.getValue();
      if ((paramMap instanceof Map)) {}
      for (paramMap = h((Map)paramMap);; paramMap = ca(paramMap))
      {
        localHashMap.put(ca(localEntry.getKey()), paramMap);
        break;
      }
    }
    AppMethodBeat.o(153396);
    return localHashMap;
  }
  
  public final d alv()
  {
    AppMethodBeat.i(153392);
    if (this.ede.size() == 0)
    {
      AppMethodBeat.o(153392);
      return this;
    }
    Object localObject1 = new StringBuilder();
    ArrayList localArrayList = new ArrayList();
    int n = this.sql.length();
    int k = 0;
    int i = 0;
    int j = 0;
    char c;
    while (k < n)
    {
      c = this.sql.charAt(k);
      if (c != '?') {
        break label265;
      }
      if ((k + 1 < n) && (Character.isDigit(this.sql.charAt(k + 1))))
      {
        AppMethodBeat.o(153392);
        return this;
      }
      j += 1;
      if (i >= this.ede.size())
      {
        AppMethodBeat.o(153392);
        return this;
      }
      Object localObject2 = this.ede;
      int m = i + 1;
      localObject2 = ((List)localObject2).get(i);
      if (((localObject2 instanceof Integer)) || ((localObject2 instanceof Long)))
      {
        ((StringBuilder)localObject1).append(localObject2.toString());
        i = m;
        k += 1;
      }
      else
      {
        localArrayList.add(localObject2);
        i = m;
      }
    }
    label265:
    for (;;)
    {
      ((StringBuilder)localObject1).append(c);
      break;
      if (j != this.ede.size())
      {
        AppMethodBeat.o(153392);
        return this;
      }
      localObject1 = new d(((StringBuilder)localObject1).toString(), localArrayList);
      AppMethodBeat.o(153392);
      return localObject1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(153400);
    if ((paramObject instanceof d))
    {
      paramObject = (d)paramObject;
      if (this.sql != null)
      {
        if (!this.sql.equals(paramObject.sql))
        {
          AppMethodBeat.o(153400);
          return false;
        }
      }
      else if (paramObject.sql != null)
      {
        AppMethodBeat.o(153400);
        return false;
      }
      if (this.ede.size() != paramObject.ede.size())
      {
        AppMethodBeat.o(153400);
        return false;
      }
      int i = 0;
      while (i < this.ede.size())
      {
        if (((this.ede.get(i) instanceof byte[])) && ((paramObject.ede.get(i) instanceof byte[])))
        {
          if (!Arrays.equals((byte[])this.ede.get(i), (byte[])paramObject.ede.get(i)))
          {
            AppMethodBeat.o(153400);
            return false;
          }
        }
        else if (!this.ede.get(i).equals(paramObject.ede.get(i)))
        {
          AppMethodBeat.o(153400);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(153400);
      return true;
    }
    AppMethodBeat.o(153400);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(153399);
    if (this.sql != null)
    {
      int i = this.sql.hashCode();
      AppMethodBeat.o(153399);
      return i;
    }
    AppMethodBeat.o(153399);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153397);
    StringBuilder localStringBuilder = new StringBuilder().append(this.sql);
    if ((this.ede == null) || (this.ede.isEmpty())) {}
    for (String str = "";; str = " " + aW(this.ede))
    {
      str = str;
      AppMethodBeat.o(153397);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.i.a.d
 * JD-Core Version:    0.7.0.1
 */