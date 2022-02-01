package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class c
{
  protected HashMap<String, HashMap<String, byte[]>> a;
  protected HashMap<String, Object> b;
  protected String c;
  m d;
  private HashMap<String, Object> e;
  
  c()
  {
    AppMethodBeat.i(223971);
    this.a = new HashMap();
    this.b = new HashMap();
    this.e = new HashMap();
    this.c = "GBK";
    this.d = new m();
    AppMethodBeat.o(223971);
  }
  
  private void a(ArrayList<String> paramArrayList, Object paramObject)
  {
    AppMethodBeat.i(224008);
    for (;;)
    {
      if (paramObject.getClass().isArray())
      {
        if (!paramObject.getClass().getComponentType().toString().equals("byte"))
        {
          paramArrayList = new IllegalArgumentException("only byte[] is supported");
          AppMethodBeat.o(224008);
          throw paramArrayList;
        }
        if (Array.getLength(paramObject) > 0)
        {
          paramArrayList.add("java.util.List");
          paramObject = Array.get(paramObject, 0);
        }
        else
        {
          paramArrayList.add("Array");
          paramArrayList.add("?");
          AppMethodBeat.o(224008);
        }
      }
      else
      {
        if ((paramObject instanceof Array))
        {
          paramArrayList = new IllegalArgumentException("can not support Array, please use List");
          AppMethodBeat.o(224008);
          throw paramArrayList;
        }
        if ((paramObject instanceof List))
        {
          paramArrayList.add("java.util.List");
          paramObject = (List)paramObject;
          if (paramObject.size() > 0)
          {
            paramObject = paramObject.get(0);
          }
          else
          {
            paramArrayList.add("?");
            AppMethodBeat.o(224008);
          }
        }
        else
        {
          if (!(paramObject instanceof Map)) {
            break label255;
          }
          paramArrayList.add("java.util.Map");
          Object localObject = (Map)paramObject;
          if (((Map)localObject).size() <= 0) {
            break;
          }
          localObject = ((Map)localObject).get(((Map)localObject).keySet().iterator().next());
          paramArrayList.add(a(paramObject));
          paramObject = localObject;
        }
      }
    }
    paramArrayList.add("?");
    paramArrayList.add("?");
    AppMethodBeat.o(224008);
    return;
    label255:
    paramArrayList.add(a(paramObject));
    AppMethodBeat.o(224008);
  }
  
  private void b(String paramString, Object paramObject)
  {
    AppMethodBeat.i(223987);
    this.e.put(paramString, paramObject);
    AppMethodBeat.o(223987);
  }
  
  private Object d(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(223980);
    String str2 = o.a(paramString);
    String str1 = paramString;
    if (str2 != null)
    {
      str1 = paramString;
      if (!"".equals(str2)) {
        str1 = str2;
      }
    }
    if (this.b.containsKey(str1)) {
      paramString = this.b.get(str1);
    }
    for (;;)
    {
      AppMethodBeat.o(223980);
      return paramString;
      paramString = a.a(str1, paramBoolean, paramClassLoader);
      this.b.put(str1, paramString);
    }
  }
  
  public <T> T a(String paramString, Object paramObject, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(224122);
    if (!this.a.containsKey(paramString))
    {
      AppMethodBeat.o(224122);
      return paramObject;
    }
    if (this.e.containsKey(paramString))
    {
      paramString = this.e.get(paramString);
      AppMethodBeat.o(224122);
      return paramString;
    }
    Object localObject = (HashMap)this.a.get(paramString);
    String str = "";
    localObject = ((HashMap)localObject).entrySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = (Map.Entry)((Iterator)localObject).next();
      str = (String)((Map.Entry)localObject).getKey();
    }
    for (localObject = (byte[])((Map.Entry)localObject).getValue();; localObject = new byte[0]) {
      try
      {
        paramClassLoader = d(str, paramBoolean, paramClassLoader);
        this.d.a((byte[])localObject);
        this.d.a(this.c);
        paramClassLoader = this.d.a(paramClassLoader, 0, true);
        b(paramString, paramClassLoader);
        AppMethodBeat.o(224122);
        return paramClassLoader;
      }
      catch (Exception paramClassLoader)
      {
        b(paramString, paramObject);
        AppMethodBeat.o(224122);
        return paramObject;
      }
    }
  }
  
  public <T> T a(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    String str = null;
    AppMethodBeat.i(224090);
    if (!this.a.containsKey(paramString))
    {
      AppMethodBeat.o(224090);
      return null;
    }
    if (this.e.containsKey(paramString))
    {
      paramString = this.e.get(paramString);
      AppMethodBeat.o(224090);
      return paramString;
    }
    Object localObject2 = (HashMap)this.a.get(paramString);
    Object localObject1 = new byte[0];
    localObject2 = ((HashMap)localObject2).entrySet().iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      str = (String)((Map.Entry)localObject1).getKey();
      localObject1 = (byte[])((Map.Entry)localObject1).getValue();
    }
    try
    {
      paramClassLoader = d(str, paramBoolean, paramClassLoader);
      this.d.a((byte[])localObject1);
      this.d.a(this.c);
      paramClassLoader = this.d.a((p)paramClassLoader);
      b(paramString, paramClassLoader);
      AppMethodBeat.o(224090);
      return paramClassLoader;
    }
    catch (Exception paramString)
    {
      paramString = new b(paramString);
      AppMethodBeat.o(224090);
      throw paramString;
    }
  }
  
  public String a()
  {
    return this.c;
  }
  
  public <T> String a(T paramT)
  {
    AppMethodBeat.i(224148);
    String str1 = "";
    if ((paramT instanceof p)) {
      str1 = ((p)paramT).className();
    }
    String str2 = str1;
    if ("".equals(str1)) {
      str2 = paramT.getClass().getName();
    }
    AppMethodBeat.o(224148);
    return str2;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public <T> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(224073);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("put key can not is null");
      AppMethodBeat.o(224073);
      throw paramString;
    }
    if (paramT == null)
    {
      paramString = new IllegalArgumentException("put value can not is null");
      AppMethodBeat.o(224073);
      throw paramString;
    }
    if ((paramT instanceof Set))
    {
      paramString = new IllegalArgumentException("can not support Set");
      AppMethodBeat.o(224073);
      throw paramString;
    }
    Object localObject = new n();
    ((n)localObject).a(this.c);
    ((n)localObject).a(paramT, 0);
    localObject = q.a(((n)localObject).a);
    HashMap localHashMap = new HashMap(1);
    ArrayList localArrayList = new ArrayList(1);
    a(localArrayList, paramT);
    localHashMap.put(a.a(localArrayList), localObject);
    this.e.remove(paramString);
    this.a.put(paramString, localHashMap);
    AppMethodBeat.o(224073);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224172);
    this.d.a(paramArrayOfByte);
    this.d.a(this.c);
    paramArrayOfByte = new HashMap(1);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("", new byte[0]);
    paramArrayOfByte.put("", localHashMap);
    this.a = this.d.a(paramArrayOfByte, 0, false);
    AppMethodBeat.o(224172);
  }
  
  public <T> T b(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    String str = null;
    AppMethodBeat.i(224106);
    if (!this.a.containsKey(paramString))
    {
      AppMethodBeat.o(224106);
      return null;
    }
    if (this.e.containsKey(paramString))
    {
      paramString = this.e.get(paramString);
      AppMethodBeat.o(224106);
      return paramString;
    }
    Object localObject = ((HashMap)this.a.get(paramString)).entrySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = (Map.Entry)((Iterator)localObject).next();
      str = (String)((Map.Entry)localObject).getKey();
    }
    for (localObject = (byte[])((Map.Entry)localObject).getValue();; localObject = new byte[0]) {
      try
      {
        paramClassLoader = d(str, paramBoolean, paramClassLoader);
        this.d.a((byte[])localObject);
        this.d.a(this.c);
        paramClassLoader = this.d.a(paramClassLoader, 0, true);
        b(paramString, paramClassLoader);
        AppMethodBeat.o(224106);
        return paramClassLoader;
      }
      catch (Exception paramString)
      {
        paramString = new b(paramString);
        AppMethodBeat.o(224106);
        throw paramString;
      }
    }
  }
  
  public void b()
  {
    AppMethodBeat.i(224029);
    this.e.clear();
    AppMethodBeat.o(224029);
  }
  
  public boolean b(String paramString)
  {
    AppMethodBeat.i(224061);
    boolean bool = this.a.containsKey(paramString);
    AppMethodBeat.o(224061);
    return bool;
  }
  
  public <T> T c(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(224136);
    if (!this.a.containsKey(paramString))
    {
      AppMethodBeat.o(224136);
      return null;
    }
    paramString = (HashMap)this.a.remove(paramString);
    String str = "";
    paramString = paramString.entrySet().iterator();
    if (paramString.hasNext())
    {
      paramString = (Map.Entry)paramString.next();
      str = (String)paramString.getKey();
    }
    for (paramString = (byte[])paramString.getValue();; paramString = new byte[0]) {
      try
      {
        paramClassLoader = a.a(str, paramBoolean, paramClassLoader);
        this.d.a(paramString);
        this.d.a(this.c);
        paramString = this.d.a(paramClassLoader, 0, true);
        AppMethodBeat.o(224136);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString = new b(paramString);
        AppMethodBeat.o(224136);
        throw paramString;
      }
    }
  }
  
  public Set<String> c()
  {
    AppMethodBeat.i(224038);
    Set localSet = Collections.unmodifiableSet(this.a.keySet());
    AppMethodBeat.o(224038);
    return localSet;
  }
  
  public boolean d()
  {
    AppMethodBeat.i(224043);
    boolean bool = this.a.isEmpty();
    AppMethodBeat.o(224043);
    return bool;
  }
  
  public int e()
  {
    AppMethodBeat.i(224052);
    int i = this.a.size();
    AppMethodBeat.o(224052);
    return i;
  }
  
  public byte[] f()
  {
    AppMethodBeat.i(224158);
    Object localObject = new n(0);
    ((n)localObject).a(this.c);
    ((n)localObject).a(this.a, 0);
    localObject = q.a(((n)localObject).a);
    AppMethodBeat.o(224158);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.c
 * JD-Core Version:    0.7.0.1
 */