package com.tencent.luggage.bridge.impl.a;

import com.tencent.mm.plugin.appbrand.f.a.a;
import com.tencent.mm.plugin.appbrand.f.a.c;
import java.util.Map;

public abstract class a
  implements a.a
{
  public void a(String paramString, a.c paramc)
  {
    a(paramString, null, paramc);
  }
  
  public void a(String paramString, Map<String, String> paramMap, a.c paramc)
  {
    a(paramString, paramc);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a.a)) {
      return false;
    }
    if (key().equalsIgnoreCase(((a.a)paramObject).key())) {
      return true;
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.a.a
 * JD-Core Version:    0.7.0.1
 */