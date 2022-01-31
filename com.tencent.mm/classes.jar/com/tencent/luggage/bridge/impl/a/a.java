package com.tencent.luggage.bridge.impl.a;

import com.tencent.mm.plugin.appbrand.d.a.a;

public abstract class a
  implements a.a
{
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a.a)) {
      return false;
    }
    if (pU().equalsIgnoreCase(((a.a)paramObject).pU())) {
      return true;
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.a.a
 * JD-Core Version:    0.7.0.1
 */