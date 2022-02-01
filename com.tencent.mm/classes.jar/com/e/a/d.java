package com.e.a;

import com.e.a.a.a;
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
  public final List<Object> bYL;
  public final String sql;
  
  public d(String paramString, List<Object> paramList)
  {
    AppMethodBeat.i(153391);
    this.sql = paramString;
    paramString = paramList;
    if (paramList == null) {
      paramString = new ArrayList();
    }
    this.bYL = paramString;
    AppMethodBeat.o(153391);
  }
  
  private static Object[] F(List<Object> paramList)
  {
    AppMethodBeat.i(153393);
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(az(paramList.next()));
      }
    }
    paramList = localArrayList.toArray(new Object[0]);
    AppMethodBeat.o(153393);
    return paramList;
  }
  
  static List<String> G(List<Object> paramList)
  {
    AppMethodBeat.i(153394);
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(toString(paramList.next()));
      }
    }
    AppMethodBeat.o(153394);
    return localArrayList;
  }
  
  private static Object az(Object paramObject)
  {
    AppMethodBeat.i(153390);
    if (paramObject == null)
    {
      AppMethodBeat.o(153390);
      return null;
    }
    if (a.bYN) {
      new StringBuilder("arg ").append(paramObject.getClass().getCanonicalName()).append(" ").append(toString(paramObject));
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
    if (a.bYN) {
      new StringBuilder("arg ").append(localObject.getClass().getCanonicalName()).append(" ").append(toString(localObject));
    }
    AppMethodBeat.o(153390);
    return localObject;
  }
  
  private static Map<String, Object> c(Map<Object, Object> paramMap)
  {
    AppMethodBeat.i(153396);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMap = localEntry.getValue();
      if ((paramMap instanceof Map)) {}
      for (paramMap = c((Map)paramMap);; paramMap = toString(paramMap))
      {
        localHashMap.put(toString(localEntry.getKey()), paramMap);
        break;
      }
    }
    AppMethodBeat.o(153396);
    return localHashMap;
  }
  
  private static String toString(Object paramObject)
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
      paramObject = c((Map)paramObject).toString();
      AppMethodBeat.o(153395);
      return paramObject;
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(153395);
    return paramObject;
  }
  
  public final d Aw()
  {
    AppMethodBeat.i(153392);
    if (this.bYL.size() == 0)
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
        break label232;
      }
      j += 1;
      if (i >= this.bYL.size())
      {
        AppMethodBeat.o(153392);
        return this;
      }
      Object localObject2 = this.bYL;
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
    label232:
    for (;;)
    {
      ((StringBuilder)localObject1).append(c);
      break;
      if (j != this.bYL.size())
      {
        AppMethodBeat.o(153392);
        return this;
      }
      localObject1 = new d(((StringBuilder)localObject1).toString(), localArrayList);
      AppMethodBeat.o(153392);
      return localObject1;
    }
  }
  
  public final Object[] Ax()
  {
    AppMethodBeat.i(153398);
    Object[] arrayOfObject = F(this.bYL);
    AppMethodBeat.o(153398);
    return arrayOfObject;
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
      if (this.bYL.size() != paramObject.bYL.size())
      {
        AppMethodBeat.o(153400);
        return false;
      }
      int i = 0;
      while (i < this.bYL.size())
      {
        if (((this.bYL.get(i) instanceof byte[])) && ((paramObject.bYL.get(i) instanceof byte[])))
        {
          if (!Arrays.equals((byte[])this.bYL.get(i), (byte[])paramObject.bYL.get(i)))
          {
            AppMethodBeat.o(153400);
            return false;
          }
        }
        else if (!this.bYL.get(i).equals(paramObject.bYL.get(i)))
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
    if ((this.bYL == null) || (this.bYL.isEmpty())) {}
    for (String str = "";; str = " " + G(this.bYL))
    {
      str = str;
      AppMethodBeat.o(153397);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.e.a.d
 * JD-Core Version:    0.7.0.1
 */