package com.tencent.matrix.iocanary.a;

public final class a
{
  public final com.tencent.c.a.a cqF;
  
  private a(com.tencent.c.a.a parama)
  {
    this.cqF = parama;
  }
  
  public final boolean GT()
  {
    return this.cqF.get(com.tencent.c.a.a.a.JIS.name(), true);
  }
  
  public final boolean GU()
  {
    return this.cqF.get(com.tencent.c.a.a.a.JIX.name(), true);
  }
  
  public final boolean GV()
  {
    return this.cqF.get(com.tencent.c.a.a.a.JIU.name(), true);
  }
  
  public final boolean GW()
  {
    return this.cqF.get(com.tencent.c.a.a.a.JIZ.name(), true);
  }
  
  public final String toString()
  {
    return String.format("[IOCanary.IOConfig], main_thread:%b, small_buffer:%b, repeat_read:%b, closeable_leak:%b", new Object[] { Boolean.valueOf(GT()), Boolean.valueOf(GV()), Boolean.valueOf(GU()), Boolean.valueOf(GW()) });
  }
  
  public static final class a
  {
    public com.tencent.c.a.a cqF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.iocanary.a.a
 * JD-Core Version:    0.7.0.1
 */