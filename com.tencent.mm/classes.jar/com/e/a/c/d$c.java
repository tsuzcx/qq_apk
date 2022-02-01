package com.e.a.c;

import java.util.Map;

final class d$c<K, V>
  implements r<K, V>
{
  private final Map<K, V> cfN;
  
  d$c(Map<K, V> paramMap)
  {
    this.cfN = paramMap;
  }
  
  public final boolean n(K paramK, V paramV)
  {
    paramK = this.cfN.get(paramK);
    return (paramK == paramV) || ((paramK != null) && (paramK.equals(paramV)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.e.a.c.d.c
 * JD-Core Version:    0.7.0.1
 */