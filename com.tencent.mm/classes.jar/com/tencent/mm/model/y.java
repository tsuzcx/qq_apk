package com.tencent.mm.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class y
{
  private static volatile y hmY;
  private Map<String, c> hmZ;
  
  private y()
  {
    AppMethodBeat.i(125111);
    this.hmZ = new a((byte)0);
    AppMethodBeat.o(125111);
  }
  
  public static y ayq()
  {
    AppMethodBeat.i(125110);
    if (hmY == null) {}
    try
    {
      if (hmY == null) {
        hmY = new y();
      }
      y localy = hmY;
      AppMethodBeat.o(125110);
      return localy;
    }
    finally
    {
      AppMethodBeat.o(125110);
    }
  }
  
  private c xG(String paramString)
  {
    AppMethodBeat.i(125112);
    c localc = new c();
    this.hmZ.put(paramString, localc);
    AppMethodBeat.o(125112);
    return localc;
  }
  
  public static String xJ(String paramString)
  {
    AppMethodBeat.i(125116);
    paramString = "SessionId@" + paramString + "#" + System.nanoTime();
    AppMethodBeat.o(125116);
    return paramString;
  }
  
  public final b F(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(125114);
    c localc2 = (c)this.hmZ.get(paramString);
    c localc1 = localc2;
    if (localc2 == null)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(125114);
        return null;
      }
      localc1 = xG(paramString);
    }
    paramString = localc1.hnb;
    AppMethodBeat.o(125114);
    return paramString;
  }
  
  public String toString()
  {
    AppMethodBeat.i(125117);
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DataCenter \nDataStore size : ").append(this.hmZ.size());
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(this.hmZ.entrySet());
    Iterator localIterator = localLinkedHashSet.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry != null)
      {
        c localc = (c)localEntry.getValue();
        if (localc != null)
        {
          ((StringBuilder)localObject).append("\nDataStore id : ").append((String)localEntry.getKey());
          ((StringBuilder)localObject).append(", CT : ").append(localc.hnc).append("ms");
          ((StringBuilder)localObject).append(", TTL : ").append((l - localc.hnc) / 1000L).append("s");
        }
      }
    }
    localLinkedHashSet.clear();
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(125117);
    return localObject;
  }
  
  public final b xH(String paramString)
  {
    AppMethodBeat.i(125113);
    paramString = (c)this.hmZ.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.hnb;
      AppMethodBeat.o(125113);
      return paramString;
    }
    AppMethodBeat.o(125113);
    return null;
  }
  
  public final b xI(String paramString)
  {
    AppMethodBeat.i(125115);
    paramString = (c)this.hmZ.remove(paramString);
    if (paramString != null)
    {
      paramString = paramString.hnb;
      AppMethodBeat.o(125115);
      return paramString;
    }
    AppMethodBeat.o(125115);
    return null;
  }
  
  static final class a<K, V>
    extends ConcurrentHashMap<K, V>
  {
    public final boolean containsValue(Object paramObject)
    {
      AppMethodBeat.i(125093);
      if (paramObject == null)
      {
        AppMethodBeat.o(125093);
        return false;
      }
      boolean bool = super.containsValue(paramObject);
      AppMethodBeat.o(125093);
      return bool;
    }
    
    public final V get(Object paramObject)
    {
      AppMethodBeat.i(125090);
      if (paramObject == null)
      {
        AppMethodBeat.o(125090);
        return null;
      }
      paramObject = super.get(paramObject);
      AppMethodBeat.o(125090);
      return paramObject;
    }
    
    public final V put(K paramK, V paramV)
    {
      AppMethodBeat.i(125091);
      if (paramK == null)
      {
        AppMethodBeat.o(125091);
        return null;
      }
      if (paramV == null)
      {
        paramK = super.remove(paramK);
        AppMethodBeat.o(125091);
        return paramK;
      }
      paramK = super.put(paramK, paramV);
      AppMethodBeat.o(125091);
      return paramK;
    }
    
    public final V remove(Object paramObject)
    {
      AppMethodBeat.i(125092);
      if (paramObject == null)
      {
        AppMethodBeat.o(125092);
        return null;
      }
      paramObject = super.remove(paramObject);
      AppMethodBeat.o(125092);
      return paramObject;
    }
  }
  
  public static final class b
  {
    private Map<String, Object> hna;
    
    public b()
    {
      AppMethodBeat.i(125094);
      this.hna = new y.a((byte)0);
      AppMethodBeat.o(125094);
    }
    
    public final b G(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(125099);
      if (!TextUtils.isEmpty(paramString)) {
        this.hna.put(paramString, Boolean.valueOf(paramBoolean));
      }
      AppMethodBeat.o(125099);
      return this;
    }
    
    public final b aF(String paramString1, String paramString2)
    {
      AppMethodBeat.i(125100);
      if (!TextUtils.isEmpty(paramString1)) {
        this.hna.put(paramString1, paramString2);
      }
      AppMethodBeat.o(125100);
      return this;
    }
    
    public final boolean containsKey(String paramString)
    {
      AppMethodBeat.i(125096);
      boolean bool = this.hna.containsKey(paramString);
      AppMethodBeat.o(125096);
      return bool;
    }
    
    public final Object get(String paramString)
    {
      AppMethodBeat.i(125102);
      paramString = this.hna.get(paramString);
      AppMethodBeat.o(125102);
      return paramString;
    }
    
    public final <T> T get(String paramString, T paramT)
    {
      AppMethodBeat.i(125107);
      paramString = get(paramString);
      if (paramString != null)
      {
        AppMethodBeat.o(125107);
        return paramString;
      }
      AppMethodBeat.o(125107);
      return paramT;
    }
    
    public final boolean getBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(125105);
      boolean bool = paramBoolean;
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = this.hna.get(paramString);
        bool = paramBoolean;
        if ((paramString instanceof Boolean)) {
          bool = ((Boolean)paramString).booleanValue();
        }
      }
      AppMethodBeat.o(125105);
      return bool;
    }
    
    public final int getInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(125104);
      int i = paramInt;
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = this.hna.get(paramString);
        i = paramInt;
        if ((paramString instanceof Integer)) {
          i = ((Integer)paramString).intValue();
        }
      }
      AppMethodBeat.o(125104);
      return i;
    }
    
    public final Set<String> getKeySet()
    {
      AppMethodBeat.i(125095);
      Set localSet = this.hna.keySet();
      AppMethodBeat.o(125095);
      return localSet;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(125106);
      String str = paramString2;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = this.hna.get(paramString1);
        str = paramString2;
        if ((paramString1 instanceof String)) {
          str = (String)paramString1;
        }
      }
      AppMethodBeat.o(125106);
      return str;
    }
    
    public final b l(String paramString, Object paramObject)
    {
      AppMethodBeat.i(125097);
      if (!TextUtils.isEmpty(paramString)) {
        this.hna.put(paramString, paramObject);
      }
      AppMethodBeat.o(125097);
      return this;
    }
    
    public final void recycle()
    {
      AppMethodBeat.i(125108);
      this.hna.clear();
      AppMethodBeat.o(125108);
    }
    
    public final long tx(String paramString)
    {
      AppMethodBeat.i(125103);
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = this.hna.get(paramString);
        if (!(paramString instanceof Long)) {}
      }
      for (long l = ((Long)paramString).longValue();; l = 0L)
      {
        AppMethodBeat.o(125103);
        return l;
      }
    }
    
    public final b v(String paramString, long paramLong)
    {
      AppMethodBeat.i(125098);
      if (!TextUtils.isEmpty(paramString)) {
        this.hna.put(paramString, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(125098);
      return this;
    }
    
    public final boolean xK(String paramString)
    {
      AppMethodBeat.i(125101);
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = this.hna.get(paramString);
        if (!(paramString instanceof Boolean)) {}
      }
      for (boolean bool = ((Boolean)paramString).booleanValue();; bool = false)
      {
        AppMethodBeat.o(125101);
        return bool;
      }
    }
  }
  
  static final class c
  {
    y.b hnb;
    long hnc;
    
    c()
    {
      AppMethodBeat.i(125109);
      this.hnb = new y.b();
      this.hnc = System.currentTimeMillis();
      AppMethodBeat.o(125109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.y
 * JD-Core Version:    0.7.0.1
 */