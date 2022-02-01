package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class e
  extends c
{
  protected HashMap<String, byte[]> e;
  m f;
  private HashMap<String, Object> g;
  
  public e()
  {
    AppMethodBeat.i(223885);
    this.e = null;
    this.g = new HashMap();
    this.f = new m();
    AppMethodBeat.o(223885);
  }
  
  private <T> T a(String paramString, T paramT1, T paramT2)
  {
    AppMethodBeat.i(223925);
    if (this.e != null)
    {
      if (!this.e.containsKey(paramString))
      {
        AppMethodBeat.o(223925);
        return paramT2;
      }
      if (this.g.containsKey(paramString))
      {
        paramString = this.g.get(paramString);
        AppMethodBeat.o(223925);
        return paramString;
      }
      paramT2 = (byte[])this.e.get(paramString);
      try
      {
        paramT1 = a(paramT2, paramT1);
        if (paramT1 != null) {
          d(paramString, paramT1);
        }
        AppMethodBeat.o(223925);
        return paramT1;
      }
      catch (Exception paramString)
      {
        paramString = new b(paramString);
        AppMethodBeat.o(223925);
        throw paramString;
      }
    }
    if (!this.a.containsKey(paramString))
    {
      AppMethodBeat.o(223925);
      return paramT2;
    }
    if (this.g.containsKey(paramString))
    {
      paramString = this.g.get(paramString);
      AppMethodBeat.o(223925);
      return paramString;
    }
    paramT2 = ((HashMap)this.a.get(paramString)).entrySet().iterator();
    if (paramT2.hasNext())
    {
      paramT2 = (Map.Entry)paramT2.next();
      paramT2.getKey();
    }
    for (paramT2 = (byte[])paramT2.getValue();; paramT2 = new byte[0]) {
      try
      {
        this.f.a(paramT2);
        this.f.a(this.c);
        paramT1 = this.f.a(paramT1, 0, true);
        d(paramString, paramT1);
        AppMethodBeat.o(223925);
        return paramT1;
      }
      catch (Exception paramString)
      {
        paramString = new b(paramString);
        AppMethodBeat.o(223925);
        throw paramString;
      }
    }
  }
  
  private Object a(byte[] paramArrayOfByte, Object paramObject)
  {
    AppMethodBeat.i(223942);
    this.f.a(paramArrayOfByte);
    this.f.a(this.c);
    paramArrayOfByte = this.f.a(paramObject, 0, true);
    AppMethodBeat.o(223942);
    return paramArrayOfByte;
  }
  
  private <T> T b(String paramString, T paramT)
  {
    AppMethodBeat.i(223902);
    if (!this.e.containsKey(paramString))
    {
      AppMethodBeat.o(223902);
      return null;
    }
    if (this.g.containsKey(paramString))
    {
      paramString = this.g.get(paramString);
      AppMethodBeat.o(223902);
      return paramString;
    }
    byte[] arrayOfByte = (byte[])this.e.get(paramString);
    try
    {
      paramT = a(arrayOfByte, paramT);
      if (paramT != null) {
        d(paramString, paramT);
      }
      AppMethodBeat.o(223902);
      return paramT;
    }
    catch (Exception paramString)
    {
      paramString = new b(paramString);
      AppMethodBeat.o(223902);
      throw paramString;
    }
  }
  
  private <T> T b(String paramString, T paramT, Object paramObject)
  {
    AppMethodBeat.i(223935);
    if (!this.e.containsKey(paramString))
    {
      AppMethodBeat.o(223935);
      return paramObject;
    }
    paramString = c(paramString, paramT);
    AppMethodBeat.o(223935);
    return paramString;
  }
  
  private <T> T c(String paramString)
  {
    AppMethodBeat.i(223959);
    paramString = a(paramString, true, null);
    AppMethodBeat.o(223959);
    return paramString;
  }
  
  private <T> T c(String paramString, T paramT)
  {
    AppMethodBeat.i(223914);
    if (this.e != null)
    {
      if (!this.e.containsKey(paramString))
      {
        AppMethodBeat.o(223914);
        return null;
      }
      if (this.g.containsKey(paramString))
      {
        paramString = this.g.get(paramString);
        AppMethodBeat.o(223914);
        return paramString;
      }
      localObject = (byte[])this.e.get(paramString);
      try
      {
        paramT = a((byte[])localObject, paramT);
        if (paramT != null) {
          d(paramString, paramT);
        }
        AppMethodBeat.o(223914);
        return paramT;
      }
      catch (Exception paramString)
      {
        paramString = new b(paramString);
        AppMethodBeat.o(223914);
        throw paramString;
      }
    }
    if (!this.a.containsKey(paramString))
    {
      AppMethodBeat.o(223914);
      return null;
    }
    if (this.g.containsKey(paramString))
    {
      paramString = this.g.get(paramString);
      AppMethodBeat.o(223914);
      return paramString;
    }
    Object localObject = ((HashMap)this.a.get(paramString)).entrySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = (Map.Entry)((Iterator)localObject).next();
      ((Map.Entry)localObject).getKey();
    }
    for (localObject = (byte[])((Map.Entry)localObject).getValue();; localObject = new byte[0]) {
      try
      {
        this.f.a((byte[])localObject);
        this.f.a(this.c);
        paramT = this.f.a(paramT, 0, true);
        d(paramString, paramT);
        AppMethodBeat.o(223914);
        return paramT;
      }
      catch (Exception paramString)
      {
        paramString = new b(paramString);
        AppMethodBeat.o(223914);
        throw paramString;
      }
    }
  }
  
  private <T> T d(String paramString)
  {
    AppMethodBeat.i(223968);
    paramString = b(paramString, true, null);
    AppMethodBeat.o(223968);
    return paramString;
  }
  
  private void d(String paramString, Object paramObject)
  {
    AppMethodBeat.i(223951);
    this.g.put(paramString, paramObject);
    AppMethodBeat.o(223951);
  }
  
  private <T> T e(String paramString)
  {
    AppMethodBeat.i(223984);
    paramString = c(paramString, true, null);
    AppMethodBeat.o(223984);
    return paramString;
  }
  
  private <T> T e(String paramString, Object paramObject)
  {
    AppMethodBeat.i(223977);
    paramString = a(paramString, paramObject, true, null);
    AppMethodBeat.o(223977);
    return paramString;
  }
  
  private <T> T f(String paramString, T paramT)
  {
    AppMethodBeat.i(223995);
    if (!this.e.containsKey(paramString))
    {
      AppMethodBeat.o(223995);
      return null;
    }
    if (paramT != null)
    {
      paramString = a((byte[])this.e.remove(paramString), paramT);
      AppMethodBeat.o(223995);
      return paramString;
    }
    this.e.remove(paramString);
    AppMethodBeat.o(223995);
    return null;
  }
  
  public final <T> T a(String paramString, Object paramObject, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(224085);
    if (this.e != null)
    {
      paramString = new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy, Object defaultValue)");
      AppMethodBeat.o(224085);
      throw paramString;
    }
    paramString = super.a(paramString, paramObject, paramBoolean, paramClassLoader);
    AppMethodBeat.o(224085);
    return paramString;
  }
  
  public final <T> T a(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(224063);
    if (this.e != null)
    {
      paramString = new RuntimeException("data is encoded by new version, please use getJceStruct(String name,T proxy)");
      AppMethodBeat.o(224063);
      throw paramString;
    }
    paramString = super.a(paramString, paramBoolean, paramClassLoader);
    AppMethodBeat.o(224063);
    return paramString;
  }
  
  public <T> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(224053);
    if (this.e != null)
    {
      if (paramString == null)
      {
        paramString = new IllegalArgumentException("put key can not is null");
        AppMethodBeat.o(224053);
        throw paramString;
      }
      if (paramT == null)
      {
        paramString = new IllegalArgumentException("put value can not is null");
        AppMethodBeat.o(224053);
        throw paramString;
      }
      if ((paramT instanceof Set))
      {
        paramString = new IllegalArgumentException("can not support Set");
        AppMethodBeat.o(224053);
        throw paramString;
      }
      n localn = new n();
      localn.a(this.c);
      localn.a(paramT, 0);
      paramT = q.a(localn.a);
      this.e.put(paramString, paramT);
      AppMethodBeat.o(224053);
      return;
    }
    super.a(paramString, paramT);
    AppMethodBeat.o(224053);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224139);
    try
    {
      super.a(paramArrayOfByte);
      AppMethodBeat.o(224139);
      return;
    }
    catch (Exception localException)
    {
      this.f.a(paramArrayOfByte);
      this.f.a(this.c);
      paramArrayOfByte = new HashMap(1);
      paramArrayOfByte.put("", new byte[0]);
      this.e = this.f.a(paramArrayOfByte, 0, false);
      AppMethodBeat.o(224139);
    }
  }
  
  public final <T> T b(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(224074);
    if (this.e != null)
    {
      paramString = new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy)");
      AppMethodBeat.o(224074);
      throw paramString;
    }
    paramString = super.b(paramString, paramBoolean, paramClassLoader);
    AppMethodBeat.o(224074);
    return paramString;
  }
  
  public final void b()
  {
    AppMethodBeat.i(224011);
    this.g.clear();
    AppMethodBeat.o(224011);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224116);
    this.f.a(paramArrayOfByte);
    this.f.a(this.c);
    paramArrayOfByte = new HashMap(1);
    paramArrayOfByte.put("", new byte[0]);
    this.e = this.f.a(paramArrayOfByte, 0, false);
    AppMethodBeat.o(224116);
  }
  
  public final boolean b(String paramString)
  {
    AppMethodBeat.i(224041);
    if (this.e != null)
    {
      bool = this.e.containsKey(paramString);
      AppMethodBeat.o(224041);
      return bool;
    }
    boolean bool = this.a.containsKey(paramString);
    AppMethodBeat.o(224041);
    return bool;
  }
  
  public final <T> T c(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(224096);
    if (this.e != null)
    {
      if (!this.e.containsKey(paramString))
      {
        AppMethodBeat.o(224096);
        return null;
      }
      this.e.remove(paramString);
      AppMethodBeat.o(224096);
      return null;
    }
    paramString = super.c(paramString, paramBoolean, paramClassLoader);
    AppMethodBeat.o(224096);
    return paramString;
  }
  
  public final Set<String> c()
  {
    AppMethodBeat.i(224020);
    if (this.e != null)
    {
      localSet = Collections.unmodifiableSet(this.e.keySet());
      AppMethodBeat.o(224020);
      return localSet;
    }
    Set localSet = Collections.unmodifiableSet(this.a.keySet());
    AppMethodBeat.o(224020);
    return localSet;
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224127);
    super.a(paramArrayOfByte);
    AppMethodBeat.o(224127);
  }
  
  public final boolean d()
  {
    AppMethodBeat.i(224026);
    if (this.e != null)
    {
      bool = this.e.isEmpty();
      AppMethodBeat.o(224026);
      return bool;
    }
    boolean bool = this.a.isEmpty();
    AppMethodBeat.o(224026);
    return bool;
  }
  
  public final int e()
  {
    AppMethodBeat.i(224034);
    if (this.e != null)
    {
      i = this.e.size();
      AppMethodBeat.o(224034);
      return i;
    }
    int i = this.a.size();
    AppMethodBeat.o(224034);
    return i;
  }
  
  public byte[] f()
  {
    AppMethodBeat.i(224104);
    if (this.e != null)
    {
      localObject = new n(0);
      ((n)localObject).a(this.c);
      ((n)localObject).a(this.e, 0);
      localObject = q.a(((n)localObject).a);
      AppMethodBeat.o(224104);
      return localObject;
    }
    Object localObject = super.f();
    AppMethodBeat.o(224104);
    return localObject;
  }
  
  public void g()
  {
    AppMethodBeat.i(224002);
    this.e = new HashMap();
    AppMethodBeat.o(224002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.e
 * JD-Core Version:    0.7.0.1
 */