package com.tencent.matrix.iocanary.a;

public final class a
{
  public final com.tencent.b.a.a cYC;
  
  private a(com.tencent.b.a.a parama)
  {
    this.cYC = parama;
  }
  
  public final boolean WM()
  {
    return this.cYC.eJ(com.tencent.b.a.a.a.ZbD.name());
  }
  
  public final boolean WN()
  {
    return this.cYC.eJ(com.tencent.b.a.a.a.ZbI.name());
  }
  
  public final boolean WO()
  {
    return this.cYC.eJ(com.tencent.b.a.a.a.ZbF.name());
  }
  
  public final boolean WP()
  {
    return this.cYC.eJ(com.tencent.b.a.a.a.ZbK.name());
  }
  
  public final String toString()
  {
    return String.format("[IOCanary.IOConfig], main_thread:%b, small_buffer:%b, repeat_read:%b, closeable_leak:%b", new Object[] { Boolean.valueOf(WM()), Boolean.valueOf(WO()), Boolean.valueOf(WN()), Boolean.valueOf(WP()) });
  }
  
  public static final class a
  {
    public com.tencent.b.a.a cYC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.iocanary.a.a
 * JD-Core Version:    0.7.0.1
 */