package com.tencent.mm.m;

import com.tencent.mm.storage.bu;

public abstract interface a
{
  public abstract String I(String paramString, int paramInt);
  
  public abstract void n(bu parambu);
  
  public abstract String o(bu parambu);
  
  public abstract boolean vd(String paramString);
  
  public static final class a
  {
    private static a fVs = null;
    
    public static a ZG()
    {
      return fVs;
    }
    
    public static void a(a parama)
    {
      fVs = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.m.a
 * JD-Core Version:    0.7.0.1
 */