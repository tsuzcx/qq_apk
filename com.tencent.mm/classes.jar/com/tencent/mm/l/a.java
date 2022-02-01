package com.tencent.mm.l;

import com.tencent.mm.storage.bl;

public abstract interface a
{
  public abstract String F(String paramString, int paramInt);
  
  public abstract void n(bl parambl);
  
  public abstract String o(bl parambl);
  
  public abstract boolean pc(String paramString);
  
  public static final class a
  {
    private static a fyx = null;
    
    public static a Wh()
    {
      return fyx;
    }
    
    public static void a(a parama)
    {
      fyx = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.l.a
 * JD-Core Version:    0.7.0.1
 */