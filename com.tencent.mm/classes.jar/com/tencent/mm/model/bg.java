package com.tencent.mm.model;

import com.tencent.mm.network.k;

public final class bg
{
  public static a dWU = null;
  
  public static int HT()
  {
    if (dWU != null) {
      return dWU.HT();
    }
    return 0;
  }
  
  public static k a(k paramk)
  {
    if (dWU == null) {
      return paramk;
    }
    return dWU.HU();
  }
  
  public static abstract interface a
  {
    public abstract int HT();
    
    public abstract k HU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bg
 * JD-Core Version:    0.7.0.1
 */