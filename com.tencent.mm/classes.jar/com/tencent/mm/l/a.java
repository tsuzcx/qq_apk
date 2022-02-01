package com.tencent.mm.l;

import com.tencent.mm.storage.bo;

public abstract interface a
{
  public abstract String F(String paramString, int paramInt);
  
  public abstract void n(bo parambo);
  
  public abstract String o(bo parambo);
  
  public abstract boolean so(String paramString);
  
  public static final class a
  {
    private static a fCe = null;
    
    public static a Xf()
    {
      return fCe;
    }
    
    public static void a(a parama)
    {
      fCe = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.l.a
 * JD-Core Version:    0.7.0.1
 */