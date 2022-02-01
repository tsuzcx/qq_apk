package com.tencent.mapsdk.internal;

public final class iq
  extends it
{
  private iq.a b;
  private long q = -1L;
  
  public iq()
  {
    super(null);
  }
  
  private void a(iq.a parama)
  {
    this.b = parama;
  }
  
  protected final void a(float paramFloat) {}
  
  protected final boolean c(long paramLong)
  {
    if (this.j == 0)
    {
      this.j = 1;
      if (this.i >= 0L) {
        break label40;
      }
      this.h = paramLong;
    }
    for (;;)
    {
      if (this.b != null) {
        this.q = paramLong;
      }
      return false;
      label40:
      this.h = (paramLong - this.i);
      this.i = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.iq
 * JD-Core Version:    0.7.0.1
 */