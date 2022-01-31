package com.tencent.mm.compatible.d;

public enum a
{
  private static volatile a.a duJ = new a.1();
  
  private a() {}
  
  public static void a(a.a parama)
  {
    try
    {
      duJ = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static void bq(long paramLong)
  {
    duJ.br(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.compatible.d.a
 * JD-Core Version:    0.7.0.1
 */