package com.tencent.mm.l;

public abstract interface a
{
  public abstract boolean Wo();
  
  public static final class a
  {
    private static a gCD = null;
    
    public static void a(a parama)
    {
      gCD = parama;
    }
    
    public static a anB()
    {
      return gCD;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.l.a
 * JD-Core Version:    0.7.0.1
 */