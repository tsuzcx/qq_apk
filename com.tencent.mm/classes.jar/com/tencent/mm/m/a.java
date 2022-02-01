package com.tencent.mm.m;

import com.tencent.mm.storage.bv;

public abstract interface a
{
  public abstract String J(String paramString, int paramInt);
  
  public abstract void n(bv parambv);
  
  public abstract String o(bv parambv);
  
  public abstract boolean vz(String paramString);
  
  public static final class a
  {
    private static a fXy = null;
    
    public static a ZP()
    {
      return fXy;
    }
    
    public static void a(a parama)
    {
      fXy = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.m.a
 * JD-Core Version:    0.7.0.1
 */