package com.tencent.luggage.bridge.impl.a;

import com.tencent.mm.plugin.appbrand.e.a.a;
import com.tencent.mm.plugin.appbrand.e.a.b;

public abstract class a
  implements a.b
{
  public void a(String paramString, a.a parama)
  {
    if (parama != null) {
      parama.P(new byte[0]);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a.b)) {
      return false;
    }
    if (tX().equalsIgnoreCase(((a.b)paramObject).tX())) {
      return true;
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.a.a
 * JD-Core Version:    0.7.0.1
 */