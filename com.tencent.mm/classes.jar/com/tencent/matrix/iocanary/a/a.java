package com.tencent.matrix.iocanary.a;

public final class a
{
  public final com.tencent.c.a.a cBC;
  
  private a(com.tencent.c.a.a parama)
  {
    this.cBC = parama;
  }
  
  public final boolean Io()
  {
    return this.cBC.get(com.tencent.c.a.a.a.LCB.name(), true);
  }
  
  public final boolean Ip()
  {
    return this.cBC.get(com.tencent.c.a.a.a.LCG.name(), true);
  }
  
  public final boolean Iq()
  {
    return this.cBC.get(com.tencent.c.a.a.a.LCD.name(), true);
  }
  
  public final boolean Ir()
  {
    return this.cBC.get(com.tencent.c.a.a.a.LCI.name(), true);
  }
  
  public final String toString()
  {
    return String.format("[IOCanary.IOConfig], main_thread:%b, small_buffer:%b, repeat_read:%b, closeable_leak:%b", new Object[] { Boolean.valueOf(Io()), Boolean.valueOf(Iq()), Boolean.valueOf(Ip()), Boolean.valueOf(Ir()) });
  }
  
  public static final class a
  {
    public com.tencent.c.a.a cBC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.iocanary.a.a
 * JD-Core Version:    0.7.0.1
 */