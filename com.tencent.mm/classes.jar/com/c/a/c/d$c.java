package com.c.a.c;

import java.util.Map;

final class d$c<K, V>
  implements r<K, V>
{
  private final Map<K, V> cqo;
  
  d$c(Map<K, V> paramMap)
  {
    this.cqo = paramMap;
  }
  
  public final boolean v(K paramK, V paramV)
  {
    paramK = this.cqo.get(paramK);
    return (paramK == paramV) || ((paramK != null) && (paramK.equals(paramV)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.c.a.c.d.c
 * JD-Core Version:    0.7.0.1
 */