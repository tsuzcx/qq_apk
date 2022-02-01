package com.tencent.mm.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ad
{
  private static volatile ad lsQ;
  private Map<String, c> lsR;
  
  private ad()
  {
    AppMethodBeat.i(125111);
    this.lsR = new a((byte)0);
    AppMethodBeat.o(125111);
  }
  
  private c Rm(String paramString)
  {
    AppMethodBeat.i(125112);
    c localc = new c();
    this.lsR.put(paramString, localc);
    AppMethodBeat.o(125112);
    return localc;
  }
  
  public static String Rp(String paramString)
  {
    AppMethodBeat.i(125116);
    paramString = "SessionId@" + paramString + "#" + System.nanoTime();
    AppMethodBeat.o(125116);
    return paramString;
  }
  
  public static ad beh()
  {
    AppMethodBeat.i(125110);
    if (lsQ == null) {}
    try
    {
      if (lsQ == null) {
        lsQ = new ad();
      }
      ad localad = lsQ;
      AppMethodBeat.o(125110);
      return localad;
    }
    finally
    {
      AppMethodBeat.o(125110);
    }
  }
  
  public final b I(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(125114);
    c localc2 = (c)this.lsR.get(paramString);
    c localc1 = localc2;
    if (localc2 == null)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(125114);
        return null;
      }
      localc1 = Rm(paramString);
    }
    paramString = localc1.lsT;
    AppMethodBeat.o(125114);
    return paramString;
  }
  
  public final b Rn(String paramString)
  {
    AppMethodBeat.i(125113);
    paramString = (c)this.lsR.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.lsT;
      AppMethodBeat.o(125113);
      return paramString;
    }
    AppMethodBeat.o(125113);
    return null;
  }
  
  public final b Ro(String paramString)
  {
    AppMethodBeat.i(125115);
    paramString = (c)this.lsR.remove(paramString);
    if (paramString != null)
    {
      paramString = paramString.lsT;
      AppMethodBeat.o(125115);
      return paramString;
    }
    AppMethodBeat.o(125115);
    return null;
  }
  
  public String toString()
  {
    AppMethodBeat.i(125117);
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DataCenter \nDataStore size : ").append(this.lsR.size());
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(this.lsR.entrySet());
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
          ((StringBuilder)localObject).append(", CT : ").append(localc.lsU).append("ms");
          ((StringBuilder)localObject).append(", TTL : ").append((l - localc.lsU) / 1000L).append("s");
        }
      }
    }
    localLinkedHashSet.clear();
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(125117);
    return localObject;
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
  
  public static class b
  {
    private Map<String, Object> lsS;
    
    public b()
    {
      AppMethodBeat.i(125094);
      this.lsS = new ad.a((byte)0);
      AppMethodBeat.o(125094);
    }
    
    public final b J(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(125099);
      if (!TextUtils.isEmpty(paramString)) {
        this.lsS.put(paramString, Boolean.valueOf(paramBoolean));
      }
      AppMethodBeat.o(125099);
      return this;
    }
    
    public final long Mh(String paramString)
    {
      AppMethodBeat.i(125103);
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = this.lsS.get(paramString);
        if (!(paramString instanceof Long)) {}
      }
      for (long l = ((Long)paramString).longValue();; l = 0L)
      {
        AppMethodBeat.o(125103);
        return l;
      }
    }
    
    public final boolean Rq(String paramString)
    {
      AppMethodBeat.i(125101);
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = this.lsS.get(paramString);
        if (!(paramString instanceof Boolean)) {}
      }
      for (boolean bool = ((Boolean)paramString).booleanValue();; bool = false)
      {
        AppMethodBeat.o(125101);
        return bool;
      }
    }
    
    public final b aO(String paramString1, String paramString2)
    {
      AppMethodBeat.i(125100);
      if (!TextUtils.isEmpty(paramString1)) {
        this.lsS.put(paramString1, paramString2);
      }
      AppMethodBeat.o(125100);
      return this;
    }
    
    public final boolean containsKey(String paramString)
    {
      AppMethodBeat.i(125096);
      boolean bool = this.lsS.containsKey(paramString);
      AppMethodBeat.o(125096);
      return bool;
    }
    
    public final Object get(String paramString)
    {
      AppMethodBeat.i(125102);
      paramString = this.lsS.get(paramString);
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
        paramString = this.lsS.get(paramString);
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
        paramString = this.lsS.get(paramString);
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
      Set localSet = this.lsS.keySet();
      AppMethodBeat.o(125095);
      return localSet;
    }
    
    public final String getString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(125106);
      String str = paramString2;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = this.lsS.get(paramString1);
        str = paramString2;
        if ((paramString1 instanceof String)) {
          str = (String)paramString1;
        }
      }
      AppMethodBeat.o(125106);
      return str;
    }
    
    public final b k(String paramString, Object paramObject)
    {
      AppMethodBeat.i(125097);
      if (!TextUtils.isEmpty(paramString)) {
        this.lsS.put(paramString, paramObject);
      }
      AppMethodBeat.o(125097);
      return this;
    }
    
    public final void recycle()
    {
      AppMethodBeat.i(125108);
      this.lsS.clear();
      AppMethodBeat.o(125108);
    }
    
    public final b v(String paramString, long paramLong)
    {
      AppMethodBeat.i(125098);
      if (!TextUtils.isEmpty(paramString)) {
        this.lsS.put(paramString, Long.valueOf(paramLong));
      }
      AppMethodBeat.o(125098);
      return this;
    }
  }
  
  static final class c
  {
    ad.b lsT;
    long lsU;
    
    c()
    {
      AppMethodBeat.i(125109);
      this.lsT = new ad.b();
      this.lsU = System.currentTimeMillis();
      AppMethodBeat.o(125109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ad
 * JD-Core Version:    0.7.0.1
 */