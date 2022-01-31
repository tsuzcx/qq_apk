package com.tencent.mm.plugin.appbrand.jsapi.file;

import java.util.HashMap;
import java.util.Map;

public final class f$a
{
  public final String aox;
  public final Map<String, Object> values = new HashMap();
  
  public f$a(String paramString, Object... paramVarArgs)
  {
    this.aox = String.format(paramString, paramVarArgs);
  }
  
  public final a m(String paramString, Object paramObject)
  {
    this.values.put(paramString, paramObject);
    return this;
  }
  
  public final a t(Map<String, Object> paramMap)
  {
    if (paramMap != null) {
      this.values.putAll(paramMap);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.f.a
 * JD-Core Version:    0.7.0.1
 */