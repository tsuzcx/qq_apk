package com.tencent.matrix.iocanary.a;

public final class a
{
  public final com.tencent.c.a.a cCj;
  
  private a(com.tencent.c.a.a parama)
  {
    this.cCj = parama;
  }
  
  public final boolean Iw()
  {
    return this.cCj.get(com.tencent.c.a.a.a.LZF.name(), true);
  }
  
  public final boolean Ix()
  {
    return this.cCj.get(com.tencent.c.a.a.a.LZK.name(), true);
  }
  
  public final boolean Iy()
  {
    return this.cCj.get(com.tencent.c.a.a.a.LZH.name(), true);
  }
  
  public final boolean Iz()
  {
    return this.cCj.get(com.tencent.c.a.a.a.LZM.name(), true);
  }
  
  public final String toString()
  {
    return String.format("[IOCanary.IOConfig], main_thread:%b, small_buffer:%b, repeat_read:%b, closeable_leak:%b", new Object[] { Boolean.valueOf(Iw()), Boolean.valueOf(Iy()), Boolean.valueOf(Ix()), Boolean.valueOf(Iz()) });
  }
  
  public static final class a
  {
    public com.tencent.c.a.a cCj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.iocanary.a.a
 * JD-Core Version:    0.7.0.1
 */