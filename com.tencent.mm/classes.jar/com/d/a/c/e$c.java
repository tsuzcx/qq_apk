package com.d.a.c;

import java.util.Map;

final class e$c<K, V>
  implements s<K, V>
{
  private final Map<K, V> clR;
  
  e$c(Map<K, V> paramMap)
  {
    this.clR = paramMap;
  }
  
  public final boolean o(K paramK, V paramV)
  {
    paramK = this.clR.get(paramK);
    return (paramK == paramV) || ((paramK != null) && (paramK.equals(paramV)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.d.a.c.e.c
 * JD-Core Version:    0.7.0.1
 */