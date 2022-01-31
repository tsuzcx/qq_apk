package com.tencent.magicbrush.a;

public final class c
{
  private static a bkk = new c.1();
  
  public static void a(a parama)
  {
    bkk = parama;
  }
  
  public static void loadLibrary(String paramString)
  {
    bkk.loadLibrary(paramString);
  }
  
  public static void qG()
  {
    bkk.loadLibrary("mmv8");
    bkk.loadLibrary("magicbrush");
    bkk.loadLibrary("gamelog_delegate");
  }
  
  public static abstract interface a
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.a.c
 * JD-Core Version:    0.7.0.1
 */