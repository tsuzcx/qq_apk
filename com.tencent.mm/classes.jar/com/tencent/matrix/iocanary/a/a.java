package com.tencent.matrix.iocanary.a;

import com.tencent.c.a.a.a;

public final class a
{
  public final com.tencent.c.a.a cty;
  
  private a(com.tencent.c.a.a parama)
  {
    this.cty = parama;
  }
  
  public final boolean Hi()
  {
    return this.cty.get(a.a.Ihk.name(), true);
  }
  
  public final boolean Hj()
  {
    return this.cty.get(a.a.Ihp.name(), true);
  }
  
  public final boolean Hk()
  {
    return this.cty.get(a.a.Ihm.name(), true);
  }
  
  public final boolean Hl()
  {
    return this.cty.get(a.a.Ihr.name(), true);
  }
  
  public final String toString()
  {
    return String.format("[IOCanary.IOConfig], main_thread:%b, small_buffer:%b, repeat_read:%b, closeable_leak:%b", new Object[] { Boolean.valueOf(Hi()), Boolean.valueOf(Hk()), Boolean.valueOf(Hj()), Boolean.valueOf(Hl()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.iocanary.a.a
 * JD-Core Version:    0.7.0.1
 */