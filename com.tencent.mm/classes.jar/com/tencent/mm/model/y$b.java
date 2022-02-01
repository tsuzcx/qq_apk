package com.tencent.mm.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.Set;

public final class y$b
{
  private Map<String, Object> gMA;
  
  public y$b()
  {
    AppMethodBeat.i(125094);
    this.gMA = new y.a((byte)0);
    AppMethodBeat.o(125094);
  }
  
  public final b F(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(125099);
    if (!TextUtils.isEmpty(paramString)) {
      this.gMA.put(paramString, Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(125099);
    return this;
  }
  
  public final long aa(String paramString)
  {
    AppMethodBeat.i(125103);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.gMA.get(paramString);
      if (!(paramString instanceof Long)) {}
    }
    for (long l = ((Long)paramString).longValue();; l = 0L)
    {
      AppMethodBeat.o(125103);
      return l;
    }
  }
  
  public final b ax(String paramString1, String paramString2)
  {
    AppMethodBeat.i(125100);
    if (!TextUtils.isEmpty(paramString1)) {
      this.gMA.put(paramString1, paramString2);
    }
    AppMethodBeat.o(125100);
    return this;
  }
  
  public final boolean containsKey(String paramString)
  {
    AppMethodBeat.i(125096);
    boolean bool = this.gMA.containsKey(paramString);
    AppMethodBeat.o(125096);
    return bool;
  }
  
  public final Object get(String paramString)
  {
    AppMethodBeat.i(125102);
    paramString = this.gMA.get(paramString);
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
      paramString = this.gMA.get(paramString);
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
      paramString = this.gMA.get(paramString);
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
    Set localSet = this.gMA.keySet();
    AppMethodBeat.o(125095);
    return localSet;
  }
  
  public final String getString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(125106);
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = this.gMA.get(paramString1);
      str = paramString2;
      if ((paramString1 instanceof String)) {
        str = (String)paramString1;
      }
    }
    AppMethodBeat.o(125106);
    return str;
  }
  
  public final b m(String paramString, Object paramObject)
  {
    AppMethodBeat.i(125097);
    if (!TextUtils.isEmpty(paramString)) {
      this.gMA.put(paramString, paramObject);
    }
    AppMethodBeat.o(125097);
    return this;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(125108);
    this.gMA.clear();
    AppMethodBeat.o(125108);
  }
  
  public final boolean tE(String paramString)
  {
    AppMethodBeat.i(125101);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.gMA.get(paramString);
      if (!(paramString instanceof Boolean)) {}
    }
    for (boolean bool = ((Boolean)paramString).booleanValue();; bool = false)
    {
      AppMethodBeat.o(125101);
      return bool;
    }
  }
  
  public final b u(String paramString, long paramLong)
  {
    AppMethodBeat.i(125098);
    if (!TextUtils.isEmpty(paramString)) {
      this.gMA.put(paramString, Long.valueOf(paramLong));
    }
    AppMethodBeat.o(125098);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.y.b
 * JD-Core Version:    0.7.0.1
 */