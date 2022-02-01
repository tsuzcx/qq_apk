package com.tencent.matrix.iocanary.a;

public final class a
{
  public final com.tencent.c.a.a cQF;
  
  private a(com.tencent.c.a.a parama)
  {
    this.cQF = parama;
  }
  
  public final boolean St()
  {
    return this.cQF.get(com.tencent.c.a.a.a.RzX.name(), true);
  }
  
  public final boolean Su()
  {
    return this.cQF.get(com.tencent.c.a.a.a.RAc.name(), true);
  }
  
  public final boolean Sv()
  {
    return this.cQF.get(com.tencent.c.a.a.a.RzZ.name(), true);
  }
  
  public final boolean Sw()
  {
    return this.cQF.get(com.tencent.c.a.a.a.RAe.name(), true);
  }
  
  public final String toString()
  {
    return String.format("[IOCanary.IOConfig], main_thread:%b, small_buffer:%b, repeat_read:%b, closeable_leak:%b", new Object[] { Boolean.valueOf(St()), Boolean.valueOf(Sv()), Boolean.valueOf(Su()), Boolean.valueOf(Sw()) });
  }
  
  public static final class a
  {
    public com.tencent.c.a.a cQF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.iocanary.a.a
 * JD-Core Version:    0.7.0.1
 */