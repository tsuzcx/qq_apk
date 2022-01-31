package com.tencent.matrix.iocanary.a;

public final class a
{
  public final com.tencent.mrs.b.a bMc;
  
  private a(com.tencent.mrs.b.a parama)
  {
    this.bMc = parama;
  }
  
  public final String toString()
  {
    return String.format("[IOCanary.IOConfig], main_thread:%b, small_buffer:%b, repeat_read:%b, closeable_leak:%b", new Object[] { Boolean.valueOf(yU()), Boolean.valueOf(yW()), Boolean.valueOf(yV()), Boolean.valueOf(yX()) });
  }
  
  public final boolean yU()
  {
    return this.bMc.get(com.tencent.mrs.b.a.a.Baz.name(), true);
  }
  
  public final boolean yV()
  {
    return this.bMc.get(com.tencent.mrs.b.a.a.BaE.name(), true);
  }
  
  public final boolean yW()
  {
    return this.bMc.get(com.tencent.mrs.b.a.a.BaB.name(), true);
  }
  
  public final boolean yX()
  {
    return this.bMc.get(com.tencent.mrs.b.a.a.BaG.name(), true);
  }
  
  public static final class a
  {
    public com.tencent.mrs.b.a bMc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.iocanary.a.a
 * JD-Core Version:    0.7.0.1
 */