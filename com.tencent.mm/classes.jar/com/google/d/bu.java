package com.google.d;

public final class bu<K, V>
{
  static <K, V> int a(a<K, V> parama, K paramK, V paramV)
  {
    return az.a(parama.dTB, 1, paramK) + az.a(parama.dTD, 2, paramV);
  }
  
  static <T> T a(i parami, at paramat, du.a parama, T paramT)
  {
    switch (1.dJl[parama.ordinal()])
    {
    default: 
      return az.a(parami, parama);
    case 1: 
      parama = ((ce)paramT).toBuilder();
      parami.a(parama, paramat);
      return parama.buildPartial();
    case 2: 
      return Integer.valueOf(parami.aam());
    }
    throw new RuntimeException("Groups are not allowed in maps.");
  }
  
  static <K, V> void a(k paramk, a<K, V> parama, K paramK, V paramV)
  {
    az.a(paramk, parama.dTB, 1, paramK);
    az.a(paramk, parama.dTD, 2, paramV);
  }
  
  static class a<K, V>
  {
    public final V dOI;
    public final du.a dTB;
    public final K dTC;
    public final du.a dTD;
    
    public a(du.a parama1, K paramK, du.a parama2, V paramV)
    {
      this.dTB = parama1;
      this.dTC = paramK;
      this.dTD = parama2;
      this.dOI = paramV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bu
 * JD-Core Version:    0.7.0.1
 */