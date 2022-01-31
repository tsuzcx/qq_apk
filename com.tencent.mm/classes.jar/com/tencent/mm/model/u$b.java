package com.tencent.mm.model;

import android.text.TextUtils;
import java.util.Map;
import java.util.Set;

public final class u$b
{
  private Map<String, Object> dVg = new u.a((byte)0);
  
  public final b S(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.dVg.put(paramString1, paramString2);
    }
    return this;
  }
  
  public final boolean containsKey(String paramString)
  {
    return this.dVg.containsKey(paramString);
  }
  
  public final Set<String> dd()
  {
    return this.dVg.keySet();
  }
  
  public final Object get(String paramString)
  {
    return this.dVg.get(paramString);
  }
  
  public final <T> T get(String paramString, T paramT)
  {
    paramString = get(paramString);
    if (paramString != null) {
      paramT = paramString;
    }
    return paramT;
  }
  
  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.dVg.get(paramString);
      bool = paramBoolean;
      if ((paramString instanceof Boolean)) {
        bool = ((Boolean)paramString).booleanValue();
      }
    }
    return bool;
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    int i = paramInt;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.dVg.get(paramString);
      i = paramInt;
      if ((paramString instanceof Integer)) {
        i = ((Integer)paramString).intValue();
      }
    }
    return i;
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = this.dVg.get(paramString1);
      str = paramString2;
      if ((paramString1 instanceof String)) {
        str = (String)paramString1;
      }
    }
    return str;
  }
  
  public final b h(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.dVg.put(paramString, paramObject);
    }
    return this;
  }
  
  public final boolean ik(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.dVg.get(paramString);
      if ((paramString instanceof Boolean)) {
        return ((Boolean)paramString).booleanValue();
      }
    }
    return false;
  }
  
  public final void recycle()
  {
    this.dVg.clear();
  }
  
  public final b w(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.dVg.put(paramString, Boolean.valueOf(paramBoolean));
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.u.b
 * JD-Core Version:    0.7.0.1
 */