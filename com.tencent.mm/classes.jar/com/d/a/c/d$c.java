package com.d.a.c;

import java.util.Map;

final class d$c<K, V>
  implements r<K, V>
{
  private final Map<K, V> bXR;
  
  d$c(Map<K, V> paramMap)
  {
    this.bXR = paramMap;
  }
  
  public final boolean l(K paramK, V paramV)
  {
    paramK = this.bXR.get(paramK);
    return (paramK == paramV) || ((paramK != null) && (paramK.equals(paramV)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.d.a.c.d.c
 * JD-Core Version:    0.7.0.1
 */